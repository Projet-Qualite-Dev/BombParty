package game.bombParty.Class;

public class Difficulty {

    private int valueOfDifficulty;
    private static final int valueOfEasy = 500;
    private static final int valueOfMedium = 150;
    private static final int valueOfHard = 50;

    public Difficulty(int difficulty) {
        this.valueOfDifficulty = difficulty;
    } /* TODO Savoir si on doit faire des throws pour les erreurs comme valueOfDifficulty est pas 1 ou 2 ou 3 */

    public int getValue() {
        if (this.valueOfDifficulty == 1) {
            return valueOfEasy;
        } else if (this.valueOfDifficulty == 2) {
            return valueOfMedium;
        } else if (this.valueOfDifficulty == 3) {
            return valueOfHard;
        }
        return 0;
    }

    public void setDifficulty(int difficulty) {
        this.valueOfDifficulty = difficulty;
    }
}
