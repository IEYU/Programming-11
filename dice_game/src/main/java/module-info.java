module com.example.dice_game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dice_game to javafx.fxml;
    exports com.example.dice_game;
}