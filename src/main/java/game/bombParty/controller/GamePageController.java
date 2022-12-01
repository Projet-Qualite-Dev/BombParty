package game.bombParty.controller;

import game.bombParty.Chrono;
import game.bombParty.Class.Time;
import game.bombParty.Class.WordMap;
import game.bombParty.Main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class GamePageController implements Initializable {

    @FXML
    public Label syllabLabel, secondLabel;
    @FXML
    public TextField textField;
    private Timeline timeline;
    private Thread gameStart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> Main.getGame().updtateTime()));
        this.timeline.setCycleCount(Animation.INDEFINITE);
    }

    public void returnMenu() {
        Main.getMainPane().getChildren().setAll(Main.getHomePage());
        Main.getHomePage().setVisible(true);
    }

    @FXML
    public void startGame() {
        System.out.println(Main.getGame().getState());
        if (Main.getGame().getState() != Thread.State.RUNNABLE) {
            Main.getGame().setLabels(this.syllabLabel, this.secondLabel);
            Main.getGame().setTextField(this.textField);
            Main.getGame().start();
            System.out.println(Main.getGame().getState());
        }
    }
}
