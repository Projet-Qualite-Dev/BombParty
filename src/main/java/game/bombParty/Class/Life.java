/**
 * Cette class permet de gérer les vies du joueur.
 */

package game.bombParty.Class;

import javafx.beans.property.SimpleStringProperty;

public final class Life {
    private int actualLife;
    private final SimpleStringProperty LIFE = new SimpleStringProperty();

    /**
     * Le constructeur de la class Life.
     */
    public Life() {
        this.actualLife = 3;
    }

    /**
     * Avoir la vie actuelle.
     *
     * @return int : Vie actuelle.
     */
    public int getActualLife() {
        return this.actualLife;
    }

    /**
     * Avoir la vie actuelle.
     *
     * @return SimpleStringProperty : Vie actuelle.
     */
    public SimpleStringProperty getStringLife(){
        this.updateStringProperty();
        return this.LIFE;
    }

    /**
     * Permet de faire perdre une vie si elle est positive.
     */
    public void looseLife(){
        if(actualLife > 0) --this.actualLife;
        this.updateStringProperty();
    }

    /**
     * Pemet de faire gagner une vie.
     */
    public void winLife() {
        ++this.actualLife;
        this.updateStringProperty();
    }

    /**
     * Permet de mettre à jour le SimpleStringProperty par rapport à la vie actuelle.
     */
    private void updateStringProperty() {
        this.LIFE.set(String.valueOf(this.actualLife));
    }
}