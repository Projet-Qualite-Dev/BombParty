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
        Assertions.assertFalse(letter.getUse());
    }

    @Test
    void useTest() {
        Letter letter= new Letter(AllLettersForGame.A);
        letter.use();
        Assertions.assertTrue(letter.getUse());
    }

    @Test
    void unUseTest() {
        Letter letter= new Letter(AllLettersForGame.A);
        letter.unUse();
        Assertions.assertFalse(letter.getUse());
    }

    @Test
    void getColorTest() {
        Letter letter= new Letter(AllLettersForGame.A);
        letter.unUse();
        Assertions.assertEquals(letter.getColor(), "white");
        letter.use();
        Assertions.assertEquals(letter.getColor(), "green");
    }
}
