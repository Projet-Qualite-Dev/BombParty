package game.bombParty.Class;

public class Letter {
    private Alphabet value;
    private boolean use;

    public Letter(Alphabet value) {
        this.value = value;
        this.use = false;
    }

    public void use(){
        this.use = true;
    }
}