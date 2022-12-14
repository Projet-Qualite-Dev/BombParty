package game.bombParty.Class;

import javafx.beans.property.SimpleStringProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void constructorTest() throws Exception {
        Game game = new Game(new Player(new Life()), 3);
        Assertions.assertNotNull(game);
    }

    @Test
    void isStratedTest() throws Exception {
        Game game = new Game(new Player(new Life()), 3);
        Assertions.assertFalse(game.isStarted());
    }

    @Test
    void startTest() throws Exception {
        Game game = new Game(new Player(new Life()), 3);
        game.start();
        Assertions.assertTrue(game.isStarted());
    }

    @Test
    void winLifeTest() throws Exception {
        Life life = new Life();
        Game game = new Game(new Player(life), 3);
        game.winLife();
        Assertions.assertEquals(life.getActualLife(), 4);
    }

    @Test
    void getStringLifeTest() throws Exception {
        Life life = new Life();
        Game game = new Game(new Player(life), 3);
        Assertions.assertEquals(game.getStringLife().toString(), new SimpleStringProperty("3").toString());
    }

    @Test
    void getLifeTest() throws Exception {
        Life life = new Life();
        Game game = new Game(new Player(life), 3);
        Assertions.assertEquals(game.getLife().getActualLife(), 3);
    }

    @Test
    void containsValueTest() throws Exception {
        Life life = new Life();
        Game game = new Game(new Player(life), 3);
        Assertions.assertTrue(game.containsValue("ALU","SALUT"));
    }

    @Test
    void getRandomSyllableTest() throws Exception {
        Life life = new Life();
        Game game = new Game(new Player(life), 3);
        Assertions.assertEquals(game.getRandomSyllable().length(), 3);
    }
}
