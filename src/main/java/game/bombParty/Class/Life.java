package game.bombParty.Class;

public class Life {
    private int actualLife;

    public Life() {

    }

    public int getActualLife() {
        return this.actualLife;
    }

    public void looseLife(){
        if(actualLife > 0) --this.actualLife;
    }

    public void winLife(){++this.actualLife;}

    public void setLife(int life) {
        this.actualLife = life;
    }
}