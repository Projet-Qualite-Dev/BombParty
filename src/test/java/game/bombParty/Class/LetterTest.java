package game.bombParty.Class;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LetterTest {

    @Test
    void constructorTest() {
        Letter letter= new Letter(AllLettersForGame.A);
        Assertions.assertNotNull(letter);
    }

    @Test
    void getUseTest() {
        Letter letter= new Letter(AllLettersForGame.A);
        Assertions.assertEquals(letter.getUse(), false);
    }

    @Test
    void getUseTest() {
        Letter letter= new Letter(AllLettersForGame.A);
        Assertions.assertEquals(letter.getUse(), false);
    }
}
