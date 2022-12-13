/**
 * Cette class permet de gérer le joueur.
 */

package game.bombParty.Class;

import javafx.beans.property.SimpleStringProperty;

import java.util.HashSet;
import java.util.Set;

public final class Player {
    private final Life life;
    private final Set<Letter> letters;


    /**
     * Le constructeur
     * @param life : La vie du joueur.
     */
    public Player(Life life) {
        this.life = life;
        this.letters = new HashSet<>();
        for (AllLettersForGame v: AllLettersForGame.values()) {
            this.letters.add(new Letter(v));
        }
    }

    /**
     * Avoir la vie du joueur.
     *
     * @return Life : La vie du joueur.
     */
    public Life getLife() {
        return this.life;
    }

    /**
     * Avoir la vie du joueur.
     *
     * @return int : La vie du joueur.
     */
    public int getActualLife() {
        return this.life.getActualLife();
    }

    /**
     * Avoir la vie du joueur.
     *
     * @return SimpleStringProperty : La vie du joueur.
     */
    public SimpleStringProperty getStringLife() {
        return this.life.getStringLife();
    }

    /**
     * Permet de gagner une vie.
     */
    public void winLife() {
        this.life.winLife();
    }

    /**
     * Permet de perdre une vie.
     */
    public void looseLife() {
        this.life.looseLife();
    }
}