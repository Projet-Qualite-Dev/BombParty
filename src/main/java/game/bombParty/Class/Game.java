package game.bombParty.Class;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URISyntaxException;

public class Game extends Thread {

    private WordMap wordList;
    private Player player;
    private Timeline timeline;
    private Label labelForSyllab, labelForTime;
    private TextField textField;

    public Game(Player player) throws URISyntaxException, IOException {
        this.player = player;
        this.wordList = new WordMap();
    }

    public void setTime(int time) {
        this.player.getTime().setTime(time);
    }

    public void setLife(int life) {
        this.player.getLife().setLife(life);
    }

    public int getDifficultyValue() {
        return this.player.getDifficulty().getValue();
    }

    public void setDifficulty(int difficulty) {
        this.player.getDifficulty().setDifficulty(difficulty);
    }

    public void setLabels(Label labelForSyllab, Label labelForTime) {
        this.labelForSyllab = labelForSyllab;
        this.labelForTime = labelForTime;
    }

    public void updtateTime() {
        this.player.getTime().update();
    }

    @Override
    public void run() {
        Platform.runLater(() -> {
            this.labelForSyllab.setText(this.wordList.getRandomSyllab(this.getDifficultyValue()));
        });
        this.timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> this.update()));
        this.timeline.setCycleCount(Animation.INDEFINITE);
        while (this.isRoundTerminated()) {
            this.timeline.play();
            Platform.runLater(() -> {
                this.labelForTime.setText(this.player.getTime().getTime());
            });
        }
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public boolean isRoundTerminated() {
        return this.player.getTime().isFinished();
    }

    public void update() {
        this.player.getTime().update();
    }
}
