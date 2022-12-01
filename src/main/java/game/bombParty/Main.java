package game.bombParty;

import game.bombParty.Class.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main extends Application implements JavaFXInitializer{

    private static StackPane homePage;
    private static StackPane gamePage;
    private static StackPane mainPane = new StackPane();
    private static Game game;

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        homePage = JavaFXInitializer.initializeStackPane(homePage, true, "/game/bombParty/HomePage.fxml");
        JavaFXInitializer.initializeMainStackPane(mainPane, homePage);
        JavaFXInitializer.initializeStage(stage, mainPane, "Bomb Party");

        game = new Game(new Player(new Life(), new Time(), new Difficulty()));
    }
    public static void main(String[] args) {
        launch();
    }

    public static StackPane getHomePage() {
        return homePage;
    }

    public static StackPane getGamePage() {
        return gamePage;
    }

    public static void setGamePage(StackPane gamePage) {
        Main.gamePage = gamePage;
    }

    public static StackPane getMainPane() {
        return mainPane;
    }

    public static Game getGame() {
        return game;
    }
    /* TODO Remettre en forme */
}