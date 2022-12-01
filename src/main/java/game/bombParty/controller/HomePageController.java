package game.bombParty.controller;

import game.bombParty.Class.Difficulty;
import game.bombParty.Class.Life;
import game.bombParty.Class.Player;
import game.bombParty.Class.Time;
import game.bombParty.JavaFXInitializer;
import game.bombParty.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    @FXML
    Slider lifeSlider, timeSlider, difficultySlider;
    @FXML
    Label lifeLabel, timeLabel, difficultyLabel;
    @FXML
    ImageView gifView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initializeSlider(this.lifeSlider, 1, 4, this.lifeLabel);
        this.initializeSlider(this.timeSlider, 5, 12, this.timeLabel);
        this.initializeSlider(this.difficultySlider, 1, 3, this.difficultyLabel);
    }

    @FXML
    public void launchGamePage() throws IOException, URISyntaxException {
        Main.getGame().setLife(Integer.parseInt(this.lifeLabel.getText()));
        Main.getGame().setTime(Integer.parseInt(this.timeLabel.getText()));
        Main.getGame().setDifficulty(Integer.parseInt(this.difficultyLabel.getText()));

        Main.setGamePage(JavaFXInitializer.initializeStackPane(Main.getGamePage(), true, "/game/bombParty/GamePage.fxml"));
        Main.getMainPane().getChildren().setAll(Main.getGamePage());
    }

    private void initializeSlider(Slider slider, Integer min, Integer max, Label label) {
        label.setText(String.valueOf(min));
        slider.setMin(min);
        slider.setMax(max);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setOnMouseClicked(Event -> label.setText(String.valueOf((int) slider.getValue())));
    }
}