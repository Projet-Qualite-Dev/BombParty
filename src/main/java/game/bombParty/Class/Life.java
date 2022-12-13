package game.bombParty.Class;

import javafx.beans.property.SimpleStringProperty;

/**
 * Cette class permet de gérer les vies du joueur.
 */
public final class Life {

    /**
     * Valeur de la vie actuelle.
     */
    private int actualLife;
    /**
     * Valeur de la vie actuelle sous forme de StringProperty pour la bind à un Label.
     */
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
     * @return Vie actuelle.
     */
    public int getActualLife() {
        return this.actualLife;
    }

    /**
     * Avoir la vie actuelle.
     *
     * @return Vie actuelle.
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
     * Permet de faire gagner une vie.
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