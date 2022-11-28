package game.bombParty.controller;

import game.bombParty.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    @FXML
    Slider lifeSlider, maxLifeSlider, difficultySlider;
    @FXML
    Label lifeLabel, maxLifeLabel, difficultyLabel;
    @FXML
    Button launchNewPageButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initializeSlider(this.lifeSlider, 1, 4, this.lifeLabel);
        this.initializeSlider(this.maxLifeSlider, 4, 8, this.maxLifeLabel);
        this.initializeSlider(this.difficultySlider, 1, 3, this.difficultyLabel);
        this.launchNewPageButton.setOnMouseClicked(Event -> {
            Thread newPage = new Thread();
            newPage.start();
            try {
                new Main().launchAPage(new Stage(), "/game/bombParty/HomePage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
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
        slider.setOnMouseClicked(Event -> label.setText(String.valueOf((int)slider.getValue())));
    }
}