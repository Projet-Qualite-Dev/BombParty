package game.bombParty.controller;

import game.bombParty.Class.Game;
import game.bombParty.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class GamePageController implements Initializable {

    @FXML
    public Label syllabLabel, secondLabel;
    @FXML
    public TextField textField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.textField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER) && !Main.getGame().isRoundTerminated()) {
                if (Main.getWordList().containsValueByKey(this.syllabLabel.getText(), this.textField.getText().toUpperCase())) {
                    try {
                        Main.getGame().interrupt();
                        Main.setGame(new Game(Main.getGame().getPlayer()));
                        this.startGame();
                    } catch (URISyntaxException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                this.textField.setText("");
            }
        });
    }

    public void returnMenu() throws URISyntaxException, IOException {
        Main.getMainPane().getChildren().setAll(Main.getHomePage());
        Main.getHomePage().setVisible(true);
        Main.setGame(new Game(Main.getGame().getPlayer()));
    }

    @FXML
    public void startGame() {
        if (Main.getGame().getState() != Thread.State.RUNNABLE) {
            Main.getGame().setLabels(this.syllabLabel, this.secondLabel);
            Main.getGame().start();
        }
    }
}
