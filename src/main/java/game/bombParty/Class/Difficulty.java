package game.bombParty.Class;

/**
 * Cette class permet de mesurer la difficulté par rapport aux nombres de mots pour une même syllabe.
 */
public final class Difficulty {

    private static final int MAX_DIFFICULTY = 3;
    private final int VALUE_OF_EASY = 500;
    private final int VALUE_OF_MEDIUM = 150;
    private final int VALUE_OF_HARD = 50;
    private final int VALUE_OF_DIFFICULTY;


    /**
     * Le constructeur de la class Difficulty.
     * @param difficulty : La difficulté comprise entre 1 et 3.
     * @throws Exception : Si la difficulté n'est pas comprise entre 0 et la difficulté maximum.
     */
    public Difficulty(int difficulty) throws Exception {
        if (difficulty < 0 || difficulty > MAX_DIFFICULTY) {
            throw new Exception("La difficulté doit être comprise entre 0 et " + MAX_DIFFICULTY);
        }
        this.VALUE_OF_DIFFICULTY = difficulty;
    }

    /**
     * Permet d'avoir le nombre de mots associés à une syllabe par rapport à la difficulté.
     *
     * @return int : Nombre de mots dans la liste de mots associés à une syllabe.
     */
    public int getValue() {
        if (this.VALUE_OF_DIFFICULTY == 1) {
            return VALUE_OF_EASY;
        } else if (this.VALUE_OF_DIFFICULTY == 2) {
            return VALUE_OF_MEDIUM;
        } else if (this.VALUE_OF_DIFFICULTY == 3) {
            return VALUE_OF_HARD;
        }
        return 0;
    }
}