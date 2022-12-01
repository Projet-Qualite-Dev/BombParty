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
    private static WordMap wordList;

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        homePage = JavaFXInitializer.initializeStackPane(homePage, true, "/game/bombParty/HomePage.fxml");
        JavaFXInitializer.initializeMainStackPane(mainPane, homePage);
        JavaFXInitializer.initializeStage(stage, mainPane, "Bomb Party");

        game = new Game(new Player(new Life(), new Time(), new Difficulty()));
        wordList = new WordMap();
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

    public static void setGame(Game game) {
        Main.game = game;
    }

    public static WordMap getWordList() {
        return wordList;
    }

    public boolean isValueExistWithMapKey(String key, String value) {
        return this.wordList.containsValueByKey(key, value);
    }
    /* TODO Remettre en forme */
    /* TODO Problèmes : le temps ne change pas, les threads j'arrive pas */
}