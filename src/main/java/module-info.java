module com.example.bombparty {
    requires javafx.controls;
    requires javafx.fxml;


    opens game.bombParty to javafx.fxml;
    exports game.bombParty;
    exports game.bombParty.controller;
    opens game.bombParty.controller to javafx.fxml;
}