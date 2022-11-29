package game.bombParty;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class Main extends Application implements JavaFXInitializer{

    private StackPane homePage;
    private final StackPane stackPaneMain = new StackPane();

    @Override
    public void start(Stage stage) throws IOException {
        launchAPage(stage, "/game/bombParty/HomePage.fxml");
    }

    public void launchAPage(Stage stage, String page) throws IOException {
        this.homePage = this.initializeStackPane(this.homePage, page);
        this.initializeMainStackPane(this.stackPaneMain, this.homePage);
        this.initializeStage(stage, this.stackPaneMain, "Bomb Party");

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public StackPane initializeStackPane(StackPane page, String file) throws IOException {
        page = FXMLLoader.load(Main.class.getResource(file));
        page.setVisible(true);
        return page;
    }

    @Override
    public void initializeMainStackPane(StackPane mainPane, StackPane... panes) {
        mainPane.getChildren().setAll(panes);
    }

    @Override
    public void initializeStage(Stage stage, StackPane main, String title) {
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.show();
    }
}