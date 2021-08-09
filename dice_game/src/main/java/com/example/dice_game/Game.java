package com.example.dice_game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    public TextField txt_score;
    public Button btn_higher;
    public Button btn_lower;
    public TextField txt_dice_1;
    public TextField txt_dice_2;
    public Button btn_roll_2;
    public Button btn_roll_1;
    public Button btn_rule;
    int score = 0;
    public boolean higher = false;
    public boolean lower = false;
    int round = 1;
    ArrayList<Integer> dice_number = new ArrayList<>();

    public void roll_dice_first(MouseEvent mouseEvent) {
        txt_dice_1.clear();
        txt_dice_2.clear();
        Integer d[] = {1,2,3,4,5,6};
        Random i = new Random();
        Integer dice = d[i.nextInt(6)];
        txt_dice_1.setText(String.valueOf(dice));
        dice_number.add(Integer.parseInt(txt_dice_1.getText()));
        btn_roll_1.setDisable(true);
        btn_roll_2.setDisable(true);
        btn_lower.setDisable(false);
        btn_higher.setDisable(false);
    }

    public void dice_higher(MouseEvent mouseEvent) {
        higher = true;
        lower = false;
        btn_higher.setDisable(true);
        btn_lower.setDisable(true);
        btn_roll_2.setDisable(false);
    }

    public void dice_lower(MouseEvent mouseEvent) {
        lower = true;
        higher = false;
        btn_higher.setDisable(true);
        btn_lower.setDisable(true);
        btn_roll_2.setDisable(false);
    }

    public void roll_dice_second(MouseEvent mouseEvent) {
        Integer d[] = {1,2,3,4,5,6};
        Random i = new Random();
        Integer dice = d[i.nextInt(6)];
        txt_dice_2.setText(String.valueOf(dice));
        dice_number.add(Integer.parseInt(txt_dice_2.getText()));
        btn_roll_2.setDisable(true);
        btn_lower.setDisable(true);
        btn_higher.setDisable(true);
        System.out.println(dice_number);

        if (dice_number.get(1) > dice_number.get(0) && higher == true){
            score ++;
        }
        else if (dice_number.get(1) < dice_number.get(0) && lower == true){
            score ++;
        }
        else{
            if (score > 0){
                score --;
            }
        }
        dice_number.clear();
        txt_score.setText(String.valueOf(score));
        btn_roll_1.setDisable(false);
    }

    public void open_rule(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(dice_game.class.getResource("Rule.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 400);
        Stage stage2 = new Stage();
        stage2.setTitle("Rules");
        stage2.setScene(scene);
        stage2.initModality(Modality.NONE);
        stage2.show();
    }
}
