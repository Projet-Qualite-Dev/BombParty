package game.bombParty;

import javafx.application.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testStart() {
        Main main = new Main();
        Assertions.assertNotNull(main);
        Assertions.assertTrue(main instanceof Application);
    }
}
