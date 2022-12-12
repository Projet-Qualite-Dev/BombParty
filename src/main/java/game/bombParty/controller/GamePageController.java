package game.bombParty.controller;

import game.bombParty.Class.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Timer;

public final class GamePageController extends AnchorPane implements JavaFXControllable {

    @FXML
    private Label syllableLabel, secondLabel, lifeLabel, executeTimeLabel;
    @FXML
    private TextField textField;
    @FXML
    GridPane letterGrid;
    private Timer timer;
    private static Game game;
    private static int point = 0;
    private final int time;
    private static Stage primaryStage;

    public GamePageController(Stage primaryStage, int time, int difficulty) throws Exception {
        game = new Game(new Player(new Life()), difficulty);
        this.loadFXMLFile("Game");
        this.timer = new Timer();
        this.time = time;
        GamePageController.primaryStage = primaryStage;
        this.lifeLabel.textProperty().bind(game.getStringLife());
    }

    @FXML
    public void initialize() {
        this.textField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if (game.containsValue(this.syllableLabel.getText(), this.textField.getText().toUpperCase())) {
                    point++;
                    this.textField.setStyle("-fx-border-color: #71C562; -fx-border-width: 4px;");
                } else {
                    if (game.getActualLife() == 0) this.returnMenu();
                    else game.looseLife();
                    this.textField.setStyle("-fx-border-color: #CD5C5C; -fx-border-width: 4px;");
                }
                this.timer.cancel();
                this.update();
                this.textField.setText("");
            }
        });
        this.executeTimeLabel.setText(WordMap.getExecuteTime());
    }

    @FXML
    public void returnMenu() {
        this.timer.cancel();
        quit();
    }

    public static void quit() {
        primaryStage.setScene(new Scene(new HomePageController(primaryStage, String.valueOf(point))));
    } /* TODO Voir pour changer ça */

    @FXML
    public void startGame() {
        this.textField.requestFocus();
        if (!game.isStarted()) {
            game.start();
            this.update();
        }
    }

    public static Game getGame() {
        return game;
    }

    private void update() {
        this.syllableLabel.setText(game.getRandomSyllable());
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new TimeTask(this.time, this.secondLabel, this.syllableLabel, game.getLife()), 0, 100);
    }
    /* TODO Rajouter le temps d'execution faire un attribut dans game ou wordMap*/
}