package com.example.dicegame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public Button btn_start;

    public void start_game(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(dice_game.class.getResource("Game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 400);
        Stage stage2 = new Stage();
        stage2.setTitle("Dice Game");
        stage2.setScene(scene);
        stage2.initModality(Modality.NONE);
        stage2.show();
    }
}