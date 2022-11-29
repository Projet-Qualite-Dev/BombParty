package game.bombParty;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


public interface JavaFXInitializer {

    public StackPane initializeStackPane(StackPane page, boolean isVisible, String file) throws IOException;

    public StackPane initializeMainStackPane(StackPane pane, StackPane... panes);

    public void initializeStage(Stage stage, StackPane main, String title);
}
