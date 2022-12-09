package game.bombParty.Class;

import javafx.beans.property.SimpleStringProperty;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private Life life;
    private Set<Letter> letters;

    public Player(Life life) {
        this.life = life;
        this.letters = new HashSet<>();
        for (Alphabet v: Alphabet.values()) {
            this.letters.add(new Letter(v));
        }
    }

    public int getActualLife() {
        return this.life.getActualLife();
    }

    public void winLife() {
        this.life.winLife();
    }

    public void looseLife() {
        this.life.looseLife();
    }

    public SimpleStringProperty getStringLife() {
        return this.life.getStringLife();
    }

    public Life getLife() {
        return this.life;
    }
}
