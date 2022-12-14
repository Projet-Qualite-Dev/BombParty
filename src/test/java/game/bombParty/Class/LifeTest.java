package game.bombParty.Class;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LifeTest {

    @Test
    void constructorTest() {
        Life life = new Life();
        Assertions.assertNotNull(life);
    }

    @Test
    void getActualLifeTest() {
        Life life = new Life();
        Assertions.assertEquals(life.getActualLife(),3);
    }

    @Test
    void getStringLifeTest() {
        Life life = new Life();
        Assertions.assertEquals(life.getStringLife().toString(), new SimpleStringProperty("3").toString() );
    }

    @Test
    void winLifeTest() {
        Life life = new Life();
        life.winLife();
        Assertions.assertEquals(life.getActualLife(),4);
    }

    @Test
    void looseLifeTest() {
        Life life = new Life();
        life.looseLife();
        Assertions.assertEquals(life.getActualLife(), 2);
    }
}
