package game.bombParty.controller;

import game.bombParty.Class.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.text.Normalizer;
import java.util.Timer;

/**
 * Cette class permet de gérer la page de jeu.
 */
public final class GamePageController extends AnchorPane implements JavaFXControllable {

    /**
     * Les labels qui sont sur la page de jeu.
     */
    @FXML
    private Label syllableLabel, secondLabel, lifeLabel, executeTimeLabel;
    /**
     * Le textField qui est sur la page de jeu.
     */
    @FXML
    private TextField textField;
    /**
     * La letterGrid qui est sur la page de jeu.
     */
    private LetterGrid letterGrid;

    /**
     * La page de l'application.
     */
    private static Stage primaryStage;
    /**
     * La partie en cours.
     */
    private static Game game;
    /**
     * Le temps associé à la partie.
     */
    private Timer timer;
    /**
     * Le temps en secondes pour le décompte.
     */
    private final int time;
    /**
     * Le nombre de points du joueur pour la partie.
     */
    private static int point;

    /**
     * Le constructeur de la class GamePageController.
     *
     * @param primaryStage : La page de l'application.
     * @param time : Le temps en seconde pour le décompte.
     * @param difficulty : La difficulté pour la partie en cours.
     * @throws Exception : Si ce n'est pas possible de créer la partie.
     */
    public GamePageController(Stage primaryStage, int time, int difficulty) throws Exception {
        GamePageController.primaryStage = primaryStage;
        this.time = time;

        point = 0;
        this.loadFXMLFile("Game");
        game = new Game(new Player(new Life()), difficulty);
        this.lifeLabel.textProperty().bind(game.getStringLife());
        this.timer = new Timer();
    }

    /**
     * Initialisation des éléments de la page FXMl.
     * On ajoute un eventListener à chaque fois qu'on appuie sur une touche dans le textField. Si c'est entrer, on gère si c'est un bon mot ou pas avec l'augmentation des points, le reset du temps et le changement de syllabe.
     */
    @FXML
    public void initialize() {
        this.textField.setOnKeyPressed(event -> {
            String input = Normalizer.normalize(this.textField.getText(), Normalizer.Form.NFKD).toUpperCase(); // Le contenu du textField en enlevant les accents.

            if (event.getCode().equals(KeyCode.ENTER) && game.isStarted()) { // Si on appuie sur entrer quand la partie est lancer.
                if (game.containsValue(this.syllableLabel.getText(), input)) { // Si c'est un bon mot.
                    point++;

                    this.textField.setStyle("-fx-border-color: #71C562; -fx-border-width: 4px;");
                    this.letterGrid.setUseForAWord(input);
                    if (this.letterGrid.isFull()) game.winLife(); // S'il a déjà rempli toutes les lettres, il y a une réinitialisation de la letterGrid.

                    this.timer.cancel();
                    this.update();
                }
                else { // Si ce n'est pas un bon mot.
                    this.textField.setStyle("-fx-border-color: #CD5C5C; -fx-border-width: 4px;");
                }
                this.textField.setText("");
            }
        });
        this.letterGrid = new LetterGrid();
        this.executeTimeLabel.setText(WordMap.getExecuteTime());
    }

    /**
     * Retour à la page d'accueil.
     */
    @FXML
    public void returnMenu() {
        this.timer.cancel();
        quit();
    }

    /**
     * Permet de quitter la page de jeu.
     */
    public static void quit() {
        primaryStage.setScene(new Scene(new HomePageController(primaryStage, String.valueOf(point))));
    }

    /**
     * Permet de lancer une partie.
     */
    @FXML
    public void startGame() {
        if (!game.isStarted()) {
            this.textField.requestFocus();
            game.start();
            this.update();
            this.getChildren().add(this.letterGrid);
        }
    }

    /**
     * Permet de faire une actualisation en changeant la syllabe et le timer.
     */
    private void update() {
        this.syllableLabel.setText(game.getRandomSyllable());
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new TimeTask(this.time, this.secondLabel, this.syllableLabel, game.getLife()), 0, 100);
    }

    /**
     * Savoir si la partie est déjà lancée.
     *
     * @return : Si la partie est déjà lancée.
     */
    public static Game getGame() {
        return game;
    }
}