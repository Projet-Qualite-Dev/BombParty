/**
 * Cette class permet de gérer le décompte lors du jeu.
 */

package game.bombParty.Class;

import game.bombParty.controller.GamePageController;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.TimerTask;

public final class TimeTask extends TimerTask {

    private int second;
    private int millisecond;
    private final int TIME;
    private final Label SECOND_LABEL;
    private final Label SYLLABLE;
    private final Life LIFE;

    /**
     * Le constructeur de la class TimeTask.
     *
     * @param time : Défini le temps de départ pour le décompte.
     * @param secondLabel : Défini le label contenant le décompte en secondes.
     * @param syllableLabel : Défini le label contenant la syllabe actuelle.
     * @param life : Défini la vie du joueur.
     */
    public TimeTask(int time, Label secondLabel, Label syllableLabel, Life life) {
        this.TIME = time;
        this.second = this.TIME;
        this.millisecond = 0;
        this.SECOND_LABEL = secondLabel;
        this.SYLLABLE = syllableLabel;
        this.LIFE = life;
    }

    /**
     * Permet de faire le décompte avec les secondes et les dixièmes de secondes.
     */
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
            if (this.LIFE.getActualLife() == 0) {
                this.cancel();
                Platform.runLater(GamePageController::quit);
            } else {
                this.second = TIME;
                Platform.runLater(() -> {
                    this.LIFE.looseLife();
                    this.SYLLABLE.setText(GamePageController.getGame().getRandomSyllable());
                });
            }

        }
        Platform.runLater(() -> this.SECOND_LABEL.setText(this.second + "." + this.millisecond + "s"));
    }
}