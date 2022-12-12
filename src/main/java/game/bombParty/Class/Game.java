package game.bombParty.Class;

import javafx.beans.property.SimpleStringProperty;

public final class Game {

    private Player player;
    private WordMap wordList;
    private Difficulty difficulty;
    private int Time;
    private boolean isStarted;

    public Game(Player player, int difficulty) throws Exception {
        this.player = player;
        this.wordList = new WordMap();
        this.difficulty = new Difficulty(difficulty);
        this.isStarted = false;
    }

    private int getDifficulty() {
        return this.difficulty.getValue();
    }

    public String getRandomSyllable() {
        return this.wordList.getRandomSyllable(this.getDifficulty());
    }

    public boolean containsValue(String key, String value) {
        return this.wordList.containsValueByKey(key, value);
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public void start() {
        this.isStarted = true;
    }

    public void stop() {
        this.isStarted = false;
    }

    public void looseLife() {
        this.player.looseLife();
    }

    public void winLife() {
        this.player.winLife();
    }

    public SimpleStringProperty getStringLife() {
        return this.player.getStringLife();
    }

    public int getActualLife() {
        return this.player.getActualLife();
    }

    public Life getLife() {
        return this.player.getLife();
    }
}