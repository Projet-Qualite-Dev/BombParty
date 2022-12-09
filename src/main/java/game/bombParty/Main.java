package game.bombParty;

import game.bombParty.Class.*;
import game.bombParty.controller.GamePageController;
import game.bombParty.controller.HomePageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        Scene scene = new Scene(new HomePageController(stage));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("BombParty");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

    /* TODO Remettre en forme */
}