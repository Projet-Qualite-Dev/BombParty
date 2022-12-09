package game.bombParty.controller;

import game.bombParty.Class.Game;
import game.bombParty.Class.Life;
import game.bombParty.Class.Player;
import game.bombParty.Class.TimeTask;
import game.bombParty.Main;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Timer;

public class GamePageController extends StackPane implements JavaFXControllable {

    @FXML
    public Label syllabLabel, secondLabel, lifeLabel;
    @FXML
    public TextField textField;
    private Timer timer;
    private static Game game;
    private static int point = 0;
    private final int time;
    private static Stage primaryStage;

    public GamePageController(Stage primaryStage, int time, int difficulty) throws URISyntaxException, IOException {
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
                if (game.containsValue(this.syllabLabel.getText(), this.textField.getText().toUpperCase())) {
                    this.point++;
                } else {
                    if (game.getActualLife() == 0) {
                        this.returnMenu();
                    } else {
                        game.looseLife();
                    }
                }
                this.timer.cancel();
                this.update();
                this.textField.setText("");
            }
        });
    }

    @FXML
    public void returnMenu() {
        this.timer.cancel();
        quit();
    }

    public static void quit() {
        primaryStage.setScene(new Scene(new HomePageController(primaryStage, String.valueOf(point))));
    }

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
        this.syllabLabel.setText(game.getRandomSyllab());
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new TimeTask(this.time, this.secondLabel, this.syllabLabel, game.getLife()), 0, 100);
    }
    /* TODO Rajouter le temps d'execution faire un attribut dans game ou wordMap*/
}
