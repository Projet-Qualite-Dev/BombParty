package game.bombParty.controller;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Cette interface permet de charger le fichier FXML.
 */
public interface JavaFXControllable {

    /**
     * Charger un fichier FXML.
     *
     * @param pageName : Le nom du fichier.
     * @throws RuntimeException : Si le fichier n'existe pas.
     */
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