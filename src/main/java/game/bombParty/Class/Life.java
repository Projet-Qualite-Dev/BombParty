package game.bombParty.Class;

public class Life {
    private int maxLife;
    private int actualLife;

    public Life(int maxLife, int actualLife) {
        this.maxLife = maxLife;
        this.actualLife = actualLife;
    }

    public int getActualLife() {
        return this.actualLife;
    }

    public void looseLife(){
        --this.actualLife;
    }

    public void winLife(){
        ++this.actualLife;
    }
}