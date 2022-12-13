package game.bombParty.controller;

import game.bombParty.Class.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.text.Normalizer;
import java.util.Timer;

public final class GamePageController extends AnchorPane implements JavaFXControllable {

    @FXML
    private Label syllableLabel, secondLabel, lifeLabel, executeTimeLabel;
    @FXML
    private TextField textField;
    private LetterGrid letterGrid;

    private static Stage primaryStage;
    private static Game game;
    private Timer timer;
    private final int time;
    private static int point;
    private final int diffictulty;

    public GamePageController(Stage primaryStage, int time, int difficulty) throws Exception {
        GamePageController.primaryStage = primaryStage;
        this.time = time;
        this.diffictulty = difficulty;

        point = 0;
        this.loadFXMLFile("Game");
        game = new Game(new Player(new Life()), difficulty);
        this.lifeLabel.textProperty().bind(game.getStringLife());
        this.timer = new Timer();
    }

    @FXML
    public void initialize() {
        this.textField.setOnKeyPressed(event -> {
            String input = Normalizer.normalize(this.textField.getText(), Normalizer.Form.NFKD).toUpperCase();

            if (event.getCode().equals(KeyCode.ENTER) && game.isStarted()) {
                if (game.containsValue(this.syllableLabel.getText(), input)) {
                    point++;

                    this.textField.setStyle("-fx-border-color: #71C562; -fx-border-width: 4px;");
                    this.letterGrid.setUseForAWord(input);
                    if (this.letterGrid.isFull()) game.winLife();

                    this.timer.cancel();
                    this.update();
                }
                else {
                    this.textField.setStyle("-fx-border-color: #CD5C5C; -fx-border-width: 4px;");
                }
                this.textField.setText("");
            }
        });
        this.letterGrid = new LetterGrid();
        this.executeTimeLabel.setText(WordMap.getExecuteTime());
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
            this.getChildren().add(this.letterGrid);
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
}