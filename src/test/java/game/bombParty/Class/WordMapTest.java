package game.bombParty.Class;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordMapTest {

    @Test
    void constructorTest() throws Exception {
        WordMap wordMap = new WordMap(false);
        Assertions.assertNotNull(wordMap);
    }

    @Test
    void getExecuteTimeTest() throws Exception {
        WordMap wordMap = new WordMap(false);
        Assertions.assertTrue(WordMap.getExecuteTime().startsWith("Temps d'execution de la lecture du dictionnaire (en seconde) : "));
    }

    @Test
    void getRandomSyllableTest() throws Exception {
        WordMap wordMap = new WordMap(false);
        Assertions.assertEquals(wordMap.getRandomSyllable(1).length(), 3);
    }

    @Test
    void containsValueByKeyTest() throws Exception {
        WordMap wordMap = new WordMap(false);
        Assertions.assertTrue(wordMap.containsValueByKey("NJO", "BONJOUR"));
    }
}
