package game.bombParty;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


public interface JavaFXInitializer {

    static StackPane initializeStackPane(StackPane page, boolean isVisible, String file) throws IOException {
        page = FXMLLoader.load(Main.class.getResource(file));
        page.setVisible(isVisible);
        return page;
    }

    static StackPane initializeMainStackPane(StackPane pane, StackPane... panes) {
        pane.getChildren().setAll(panes);
        return pane;
    }

    static void initializeStage(Stage stage, StackPane main, String title) {
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.show();
    }
}
