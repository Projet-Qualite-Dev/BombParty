package game.bombParty.Class;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.*;

/**
 * Cette class permet de générer une GridPane contenant toutes les lettres de BombParty.
 */
public final class LetterGrid extends GridPane {

    /**
     * La liste de toutes les lettres.
     */
    private List<Letter> letterList = new ArrayList<>();

    /**
     * Le constructeur de la class LetterGrid.
     */
    public LetterGrid() {
        for (AllLettersForGame currentLetter: AllLettersForGame.values()) {
            this.letterList.add(new Letter(currentLetter));
        }
        this.setLayoutX(75);
        this.setLayoutY(180);
        this.setGridChildren();
    }

    /**
     * Initialiser tous les labels contenants chacun une lettre différente.
     */
    public void setGridChildren() {
        int cpt = 0;
        this.getChildren().clear();
        for (int row = 0; row < this.letterList.size() / 3; ++row) {
            for (int column = 0; column < this.letterList.size() / 7; ++column) {
                this.letterList.get(cpt).unuse();
                Label label = new Label(this.letterList.get(cpt).getValue());
                label.setMinWidth(30);
                label.setMinHeight(30);
                label.setAlignment(Pos.CENTER);
                label.setFont(new Font("Arial", 25));
                this.add(label, column, row);
                ++cpt;
            }
        }
    }

    /**
     * Changer l'utilisation des lettres selon le mot entré.
     *
     * @param word : Mot choisi par l'utilisateur.
     */
    public void setUseForAWord(String word) {
        for (char currentLetter: word.toCharArray()) {
            for (Letter currentCheckLetter: this.letterList) {
                if (currentCheckLetter.getValue().equals(String.valueOf(currentLetter))) currentCheckLetter.use();
            }
        }
        this.updateLetters();
    }


    /**
     * Permet de changer la couleur du fond des labels selon l'utilisation de chaque lettre.
     */
    public void updateLetters() {
        for (int currentLetter = 0; currentLetter < this.getChildren().size(); ++currentLetter) {
            this.getChildren().get(currentLetter).setStyle("-fx-background-color: " + this.letterList.get(currentLetter).getColor() + ";");
        }
    }

    /**
     * Si toutes les lettres ont déjà été choisies.
     *
     * @return : Si toutes les lettres ont été choisies.
     */
    public boolean isFull() {
        for (Letter currentLetter: this.letterList) {
            if (!currentLetter.getUse()) return false;
        }
        this.setGridChildren();
        return true;
    }
}