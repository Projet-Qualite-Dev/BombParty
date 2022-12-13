package game.bombParty.Class;

import game.bombParty.controller.GamePageController;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.TimerTask;

/**
 * Cette class permet de gérer le décompte lors du jeu.
 */
public final class TimeTask extends TimerTask {

    /**
     * Les secondes restantes avant la fin.
     */
    private int second;
    /**
     * Les dixièmes de secondes avant la fin.
     */
    private int tenthOfASecond;
    /**
     * Les secondes de départ pour le décompte.
     */
    private final int TIME;
    /**
     * Le Label qui permet d'afficher le temps restant.
     */
    private final Label SECOND_LABEL;
    /**
     * Le Label qui permet d'afficher la syllabe en cours.
     */
    private final Label SYLLABLE;
    /**
     * La vie du joueur.
     */
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
        this.tenthOfASecond = 0;
        this.SECOND_LABEL = secondLabel;
        this.SYLLABLE = syllableLabel;
        this.LIFE = life;
    }

    /**
     * Permet de faire le décompte avec les secondes et les dixièmes de secondes.
     */
    @Override
    public void run() {
        if (this.tenthOfASecond == 0) {
            this.second--;
            this.tenthOfASecond = 9;
        } else {
            this.tenthOfASecond -= 1;
        }
        if (this.second == 0 && this.tenthOfASecond == 0) {
            if (this.LIFE.getActualLife() == 0) { // Si le joueur n'a plus de vies
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
        Platform.runLater(() -> this.SECOND_LABEL.setText(this.second + "." + this.tenthOfASecond + "s"));
    }
}