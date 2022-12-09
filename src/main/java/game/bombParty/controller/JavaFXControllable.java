package game.bombParty.controller;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public interface JavaFXControllable {

    default void loadFXMLFile(String pageName) throws RuntimeException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/game/bombParty/" + pageName + "Page.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
