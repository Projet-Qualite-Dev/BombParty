package game.bombParty.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public final class HomePageController extends AnchorPane implements JavaFXControllable {
    @FXML
    private Slider timeSlider, difficultySlider;
    @FXML
    private Label lifeLabel, timeLabel, difficultyLabel, scoreLabel;
    private Stage primaryStage;

    public HomePageController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.loadFXMLFile("Home");
    }

    public HomePageController(Stage primaryStage, String scrore) {
        this.primaryStage = primaryStage;
        this.loadFXMLFile("Home");
        this.scoreLabel.setText(scrore);
    }

    @FXML
    public void initialize() {
        this.initializeSlider(this.timeSlider, 5, 12, this.timeLabel);
        this.initializeSlider(this.difficultySlider, 1, 3, this.difficultyLabel);
    }

    @FXML
    public void launchGamePage() throws Exception {
        Scene scene = new Scene(new GamePageController(this.primaryStage, (int) this.timeSlider.getValue(), Integer.parseInt(this.difficultyLabel.getText())));
        this.primaryStage.setScene(scene);
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