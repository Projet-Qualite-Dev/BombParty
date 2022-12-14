package game.bombParty.Class;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllLettersForGameTest {

    @Test
    void constructorAndGetterTest() {
        Assertions.assertEquals(AllLettersForGame.A.getValue(), "A");
    }

    @Test
    void getValuesTest() {
        Assertions.assertEquals(AllLettersForGame.values().length, 21);
    }
}
