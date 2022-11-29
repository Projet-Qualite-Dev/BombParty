package game.bombParty.Class;

import java.util.Set;

public class Player {
    private Life life;
    private Set<Letter> letters;

    public Player(Life life) {
        this.life = life;
        for (Alphabet v: Alphabet.values()) {
            this.letters.add(new Letter(v));
        }
    }


}
