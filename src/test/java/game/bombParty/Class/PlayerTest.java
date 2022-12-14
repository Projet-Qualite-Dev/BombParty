package game.bombParty.Class;

import javafx.beans.property.SimpleStringProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void constructorTest() {
        Player player = new Player(new Life());
        Assertions.assertNotNull(player);
    }

    @Test
    void getLifeTest() {
        Life life = new Life();
        Player player = new Player(life);
        Assertions.assertEquals(player.getLife() , life);
    }

    @Test
    void getStringLifeTest() {
        Life life = new Life();
        Player player = new Player(life);
        Assertions.assertEquals(player.getStringLife().toString() , new SimpleStringProperty("3").toString());
    }

    @Test
    void winLifeTest() {
        Life life = new Life();
        Player player = new Player(life);
        player.winLife();
        Assertions.assertEquals(player.getLife().getActualLife() , 4);
    }

}
