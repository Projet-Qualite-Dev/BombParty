package game.bombParty;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private StackPane homePage;
    private final StackPane stackPaneMain = new StackPane();

    @Override
    public void start(Stage stage) throws IOException {
        this.homePage = FXMLLoader.load(HelloApplication.class.getResource("/game/bombParty/HomePage.fxml"));
        this.homePage.setVisible(true);
        this.stackPaneMain.getChildren().setAll(homePage);
        Scene scene = new Scene(this.stackPaneMain);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}