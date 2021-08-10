package com.example.friendsbook;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {
    public Button btn_open;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void open_friendsbook(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FriendsBook.class.getResource("Book.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        Stage stage_book = new Stage();
        stage_book.setTitle("The Friends Book");
        stage_book.setScene(scene);
        stage_book.show();
    }
}