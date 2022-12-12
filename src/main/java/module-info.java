module main {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens game.bombParty to javafx.fxml;
    exports game.bombParty;
    exports game.bombParty.controller;
    opens game.bombParty.controller to javafx.fxml;
}