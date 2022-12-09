package game.bombParty.Class;

import game.bombParty.Main;
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

    private Player player;
    private Label labelForSyllab, labelForTime;

    public Game(Player player) throws URISyntaxException, IOException {
        this.player = player;
        this.player.getTime().reset();
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

    @Override
    public void run() {
        Platform.runLater(() -> {
            this.labelForSyllab.setText(Main.getWordList().getRandomSyllab(this.getDifficultyValue()));
        });
        while (!this.isRoundTerminated()) {
            Platform.runLater(() -> {
                this.labelForTime.setText(this.player.getTime().getTime());
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                continue;
            }
            if (!this.isRoundTerminated())
                this.player.getTime().update();
        }
    }

    public boolean isRoundTerminated() {
        return this.player.getTime().isFinished();
    }

    public Player getPlayer() {
        return this.player;
    }
}
