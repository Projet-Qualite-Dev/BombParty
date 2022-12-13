package game.bombParty;

import game.bombParty.controller.HomePageController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Cette class permet de lancer l'application
 */
public class Main extends Application {

    /**
     * Lancer l'application.
     *
     * @param stage : La page de l'application.
     */
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new HomePageController(stage));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("BombParty");
        stage.show();
    }

    /**
     * Le lancement du programme.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}