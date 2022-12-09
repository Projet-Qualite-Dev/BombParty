package game.bombParty.Class;

import game.bombParty.Main;
import game.bombParty.controller.GamePageController;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.TimerTask;

public class TimeTask extends TimerTask {

    private int second;
    private int millisecond;
    private int time;
    private Label secondLabel, syllabLabel;
    private Life life;

    public TimeTask(int time, Label secondLabel, Label syllabLabel, Life life) {
        this.time = time;
        this.second = this.time;
        this.millisecond = 0;
        this.secondLabel = secondLabel;
        this.syllabLabel = syllabLabel;
        this.life = life;
    }

    @Override
    public void run() {
        System.out.println("onf");
        if (this.millisecond == 0) {
            this.second--;
            this.millisecond = 9;
        } else {
            this.millisecond -= 1;
        }
        if (this.second == 0 && this.millisecond == 0) {
            if (this.life.getActualLife() == 0) {
                this.cancel();
                Platform.runLater(GamePageController::quit);
            } else {
                this.second = time;
                Platform.runLater(() -> {
                    this.life.looseLife();
                    this.syllabLabel.setText(GamePageController.getGame().getRandomSyllab());
                });
            }

        }
        Platform.runLater(() -> this.secondLabel.setText(this.second + "." + this.millisecond + "s"));
    }
}
