package game.bombParty.Class;

import javafx.beans.property.SimpleStringProperty;

/**
 * Cette class permet de gérer la partie en cours.
 */
public final class Game {

    /**
     * Le joueur.
     */
    private final Player player;
    /**
     * Map qui contient pour clefs les syllabes et pour valeurs les mots associés.
     */
    private final WordMap wordList;
    /**
     * La difficulté de la partie.
     */
    private final Difficulty difficulty;
    /**
     * Si la partie est lancée.
     */
    private boolean isStarted;

    /**
     * Le constructeur de la class Game.
     *
     * @param player : Le joueur qui joue la partie.
     * @param difficulty : La difficulté de la partie allant de 1 à 3.
     * @throws Exception : Si la difficulté n'est pas comprise entre 1 et 3.
     */
    public Game(Player player, int difficulty) throws Exception {
        this.player = player;
        this.wordList = new WordMap(false);
        this.difficulty = new Difficulty(difficulty);
        this.isStarted = false;
    }

    /**
     * Avoir la difficulté de la partie.
     *
     * @return : La difficulté de la partie.
     */
    private int getDifficulty() {
        return this.difficulty.getValue();
    }

    /**
     * Si la partie a commencé ou non.
     *
     * @return : Si la partie a commencé.
     */
    public boolean isStarted() {
        return this.isStarted;
    }

    /**
     * Commencer la partie.
     */
    public void start() {
        this.isStarted = true;
    }

    /**
     * Gagner une vie pour le joueur.
     */
    public void winLife() {
        this.player.winLife();
    }

    /**
     * Avoir la vie du joueur sous forme de SimpleStringProperty.
     *
     * @return : La vie du joueur.
     */
    public SimpleStringProperty getStringLife() {
        return this.player.getStringLife();
    }

    /**
     * Avoir la vie du joueur.
     *
     * @return : La vie du joueur.
     */
    public Life getLife() {
        return this.player.getLife();
    }

    /**
     * Si un mot contient une syllabe à l'aide de la Map.
     *
     * @param key : La syllabe.
     * @param value : Le mot.
     * @return : Si un mot contient une syllabe de 3 lettres.
     */
    public boolean containsValue(String key, String value) {
        return this.wordList.containsValueByKey(key, value);
    }

    /**
     * Avoir une syllabe au hasard dans la Map.
     *
     * @return : Une syllabe au hasard.
     */
    public String getRandomSyllable() {
        return this.wordList.getRandomSyllable(this.getDifficulty());
    }
}