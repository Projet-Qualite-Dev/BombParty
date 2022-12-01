package game.bombParty.Class;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private Life life;
    private Time time;
    private Difficulty difficulty;
    private Set<Letter> letters;

    public Player(Life life, Time time, Difficulty difficulty) {
        this.life = life;
        this.time = time;
        this.difficulty = difficulty;
        this.letters = new HashSet<>();
        for (Alphabet v: Alphabet.values()) {
            this.letters.add(new Letter(v));
        }
    }

    public Life getLife() {
        return this.life;
    }

    public Time getTime() {
        return this.time;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }
}
