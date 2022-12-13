package game.bombParty.controller;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Cette class permet de gérer la page d'accueil.
 */
public final class HomePageController extends AnchorPane implements JavaFXControllable {

    /**
     * Les curseurs qui sont sur la page d'accueil.
     */
    @FXML
    private Slider timeSlider, difficultySlider;
    /**
     * Les labels qui sont sur la page d'accueil.
     */
    @FXML
    private Label lifeLabel, timeLabel, difficultyLabel, scoreLabel, textScoreLabel;
    /**
     * La page de l'application.
     */
    private final Stage primaryStage;

    /**
     * Le premier constructeur de la class HomePageController.
     *
     * @param primaryStage : La page de l'application.
     */
    public HomePageController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.loadFXMLFile("Home");
    }

    /**
     * Le deuxième constructeur de la class HomePageController.
     *
     * @param primaryStage : La page de l'application.
     * @param score : Le score du joueur sur la dernière partie.
     */
    public HomePageController(Stage primaryStage, String score) {
        this.primaryStage = primaryStage;
        this.loadFXMLFile("Home");
        this.textScoreLabel.setText("Point(s) de la partie :");
        this.scoreLabel.setText(score);
    }

    /**
     * Initialisation des éléments de la page FXMl.
     */
    @FXML
    public void initialize() {
        this.initializeSlider(this.timeSlider, 10, 30, this.timeLabel);
        this.initializeSlider(this.difficultySlider, 1, 3, this.difficultyLabel);
    }

    /**
     * Lancer une partie.
     *
     * @throws Exception : Si ce n'est pas possible de créer la partie.
     */
    @FXML
    public void launchGamePage() throws Exception {
        Scene scene = new Scene(new GamePageController(this.primaryStage, (int) this.timeSlider.getValue(), Integer.parseInt(this.difficultyLabel.getText())));
        this.primaryStage.setScene(scene);
    }

    /**
     * Modifier les paramètres d'un curseur.
     *
     * @param slider : Le curseur à modifier.
     * @param minValue : La valeur minimum que le curseur doit prendre.
     * @param maxValue : La valeur minimum que le curseur doit prendre.
     * @param label : Le label à bind par rapport à la valeur du curseur.
     */
    private void initializeSlider(Slider slider, int minValue, int maxValue, Label label) {
        label.setText(String.valueOf(minValue));
        slider.setMin(minValue);
        slider.setMax(maxValue);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        label.textProperty().bind(Bindings.format("%.0f", slider.valueProperty()));
    }
}