package game.bombParty.Class;

public class Life {
    private int maxLife;
    private int actualLife;

    public Life(int maxLife) {
        this.maxLife = maxLife;
        this.actualLife = this.maxLife;
    }


    public int getActualLife() {
        return actualLife;
    }

    public void looseLife(){
        --actualLife;
    }

    public void winLife(){
        ++actualLife;
    }
}
