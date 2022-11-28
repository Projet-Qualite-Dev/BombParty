package game.bombParty;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private StackPane homePage;
    private final StackPane stackPaneMain = new StackPane();

    @Override
    public void start(Stage stage) throws IOException {
        launchAPage(stage, "/game/bombParty/HomePage.fxml");
    }

    public void launchAPage(Stage stage, String page) throws IOException {
        this.homePage = FXMLLoader.load(Main.class.getResource(page));
        this.homePage.setVisible(true);
        this.stackPaneMain.getChildren().setAll(homePage);
        Scene scene = new Scene(this.stackPaneMain);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Bomb Party");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}