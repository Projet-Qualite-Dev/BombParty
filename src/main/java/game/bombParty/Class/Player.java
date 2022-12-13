package game.bombParty.Class;

import javafx.beans.property.SimpleStringProperty;

/**
 * Cette class permet de gérer le joueur.
 */
public final class Player {

    /**
     * La vie du joueur.
     */
    private final Life life;


    /**
     * Le constructeur
     * @param life : La vie du joueur.
     */
    public Player(Life life) {
        this.life = life;
    }

    /**
     * Avoir la vie du joueur.
     *
     * @return La vie du joueur.
     */
    public Life getLife() {
        return this.life;
    }

    /**
     * Avoir la vie du joueur.
     *
     * @return La vie du joueur.
     */
    public int getActualLife() {
        return this.life.getActualLife();
    }

    /**
     * Avoir la vie du joueur.
     *
     * @return La vie du joueur.
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