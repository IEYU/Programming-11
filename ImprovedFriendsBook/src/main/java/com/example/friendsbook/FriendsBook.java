package com.example.friendsbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//TODO Create a .txt file to store all the Friend objects
//TODO Load a text file to bring up all the Friends objects
//TODO Ability to save multiple different text files with different groups of friends on each
//TODO A method to choose which file you wish to load

/*
Button Function Details:
Save to - All Friends:save to the default friend list all_friends.txt
Save as: create a txt file with custom name where the user can store the information of a specific group of friends
Load All friends: bring up all the friend objects
Select box + Load: choose which file the user wish to load and load the friend objects saved in that file

File Details:
all_friends: the default friend list where all the friend objects are saved
test: a friend list created by the user with custom name
test number 2: same as test
*/

public class FriendsBook extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FriendsBook.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 500);
        stage.setTitle("The Friends Book");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}