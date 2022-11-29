package game.bombParty.Class;

public class Letter {
    private char value;
    private boolean use;

    public Letter(char value) {
        this.value = value;
        this.use = false;
    }

    public void use(){
        use = true;
    }


}
