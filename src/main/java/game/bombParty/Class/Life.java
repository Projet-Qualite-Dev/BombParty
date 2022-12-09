package game.bombParty.Class;

import javafx.beans.property.SimpleStringProperty;

public class Life {
    private int actualLife;
    private SimpleStringProperty life = new SimpleStringProperty();

    public Life() {
        this.actualLife = 3;
    }

    public int getActualLife() {
        return this.actualLife;
    }

    public SimpleStringProperty getStringLife(){
        this.updateStringProperty();
        return this.life;
    }

    public void looseLife(){
        if(actualLife > 0) --this.actualLife;
        this.updateStringProperty();
    }

    private void updateStringProperty() {
        this.life.set(String.valueOf(this.actualLife));
    }

    public void winLife() {
        ++this.actualLife;
        this.updateStringProperty();
    }
}