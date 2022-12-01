package game.bombParty.Class;

import Generate.GenerateMap;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Map;

public class WordMap {
    private Map<String, Set<String>> wordList;
    private Random random;

    public WordMap() throws URISyntaxException, IOException {
        this.wordList = new GenerateMap("dictionary.txt").generateLettersAndWordList();
        this.random = new Random();
    }

    public String getRandomSyllab(int difficulty) {
        int numberOfSyllab = this.random.nextInt(0, this.wordList.size());
        int index = 1;
        for (String key: this.wordList.keySet()) {
            if (index == numberOfSyllab) {
                int hashCode = Character.valueOf(key.toCharArray()[2]).hashCode(); /* Résout un bug quand le dernier caratère de la syllabe est un espace vide */
                if (this.wordList.get(key).size() < difficulty && hashCode != 13) {
                    return key;
                } else {
                    getRandomSyllab(difficulty);
                }
            }
            ++index;
        }
        return getRandomSyllab(difficulty);
    }

    public boolean containsValueByKey(String key, String value) {
        for (String currentValue: this.wordList.get(key)) {
            if (Objects.equals(currentValue, value)) {
                return true;
            }
        }
        return false;
    }

    public Object getKeyByIndex(int index) {
        return null;
    }

    public Object findValueByKey(Object key) {
        return null;
    }

    public Map<String, Set<String>> getWordList() {
        return wordList;
    }
}