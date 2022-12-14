package game.bombParty.Class;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DifficultyTest {

    @Test
    void constructorTest() throws Exception {
        Difficulty difficulty = new Difficulty(3);
        Assertions.assertNotNull(difficulty);
    }

    @Test
    void constructorTest2() throws Exception {
        Assertions.assertThrows(Exception.class, () -> new Difficulty(8));
    }

    @Test
    void getValueTest() throws Exception {
        Difficulty difficulty = new Difficulty(3);
        Assertions.assertEquals(difficulty.getValue(), 50);
    }
}
