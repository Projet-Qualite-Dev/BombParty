package game.bombParty.Class;

public class Letter {
    private Alphabet value;
    private boolean use;

    public Letter(Alphabet value) {
        this.value = value;
        this.use = false;
    }

    public boolean getUse() {
        return this.use;
    }

    public String getValue() {
        return value.getValue();
    }

    void use(){
        this.use = true;
    }

    public String getColor() {
        if (this.use) return "green";
        else return "white";
    }
}