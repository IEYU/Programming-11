package com.example.friendsbook;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class Book {
    public ListView<Friend> list_friends = new ListView<>();

    public Tab tab_home;
    public Tab tab_friendslist;

    public TextField txt_name;
    public TextField txt_age;
    public TextField txt_phone;
    public TextField txt_email;
    public TextArea txt_memory;

    public Button btn_add;
    public Button btn_delete;
    public Button btn_show;

    public TextField show_name;
    public TextField show_age;
    public TextField show_phone;
    public TextField show_email;
    public TextArea show_memory;
    public Button btn_edit;
    public Button btn_hide;

    public void add_friend(MouseEvent mouseEvent) {
        String friend_name = txt_name.getText();
        String friend_age;
        String friend_phone;
        String friend_email;
        String friend_memory;

        if (txt_age.getText().trim().isEmpty()){
            friend_age = "N/A";
        } else{
            friend_age = txt_age.getText();
        }
        if (txt_phone.getText().trim().isEmpty()){
            friend_phone = "N/A";
        } else{
            friend_phone = txt_phone.getText();
        }
        if (txt_email.getText().trim().isEmpty()){
            friend_email = "N/A";
        } else{
            friend_email = txt_email.getText();
        }
        if (txt_memory.getText().trim().isEmpty()){
            friend_memory = "N/A";
        } else{
            friend_memory = txt_memory.getText();
        }

        if (!friend_name.isEmpty()){
            Friend new_friend = new Friend(friend_name, friend_age, friend_phone, friend_email, friend_memory);
            list_friends.getItems().add(new_friend);
        }

        txt_name.clear();
        txt_age.clear();
        txt_phone.clear();
        txt_email.clear();
        txt_memory.clear();
    }

    public void delete_friend(MouseEvent mouseEvent) {
        int index = list_friends.getSelectionModel().getSelectedIndex();
        list_friends.getItems().remove(index);
    }

    public void show_friend(MouseEvent mouseEvent) {
        Friend selected_friend;
        selected_friend = list_friends.getSelectionModel().getSelectedItem();
        
        show_name.setText(selected_friend.getName());
        show_age.setText(selected_friend.getAge());
        show_phone.setText(selected_friend.getPhone());
        show_email.setText(selected_friend.getEmail());
        show_memory.setText(selected_friend.getMemory());
    }

    public void edit_friend(MouseEvent mouseEvent) {

    }

    public void hide_friend(MouseEvent mouseEvent) {
        show_name.clear();
        show_age.clear();
        show_phone.clear();
        show_email.clear();
        show_memory.clear();
    }
}
