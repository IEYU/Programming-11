package com.example.friendsbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import jdk.jfr.Frequency;
import java.io.File;

import java.io.IOException;
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
    public Button btn_hide;
    public Button btn_save;
    public Button btn_load;
    public Button btn_custom_save;
    public ChoiceBox select_custom;
    public TextField txt_custom_save;
    public Button btn_load_selected;

    //create a new friend object
    public void add_friend(MouseEvent mouseEvent) {
        String friend_name = txt_name.getText();
        String friend_age;
        String friend_phone;
        String friend_email;
        String friend_memory;

        if (txt_age.getText().trim().isEmpty()) {
            friend_age = "N/A";
        } else {
            friend_age = txt_age.getText();
        }
        if (txt_phone.getText().trim().isEmpty()) {
            friend_phone = "N/A";
        } else {
            friend_phone = txt_phone.getText();
        }
        if (txt_email.getText().trim().isEmpty()) {
            friend_email = "N/A";
        } else {
            friend_email = txt_email.getText();
        }
        if (txt_memory.getText().trim().isEmpty()) {
            friend_memory = "N/A";
        } else {
            friend_memory = txt_memory.getText();
        }

        if (!friend_name.isEmpty()) {
            Friend new_friend = new Friend(friend_name, friend_age, friend_phone, friend_email, friend_memory);
            list_friends.getItems().add(new_friend);
        }

        txt_name.clear();
        txt_age.clear();
        txt_phone.clear();
        txt_email.clear();
        txt_memory.clear();
    }

    //delete the selected friend object
    public void delete_friend(MouseEvent mouseEvent) {
        int index = list_friends.getSelectionModel().getSelectedIndex();
        list_friends.getItems().remove(index);
    }

    //show the information of the selected friend object
    public void show_friend(MouseEvent mouseEvent) {
        Friend selected_friend;
        selected_friend = list_friends.getSelectionModel().getSelectedItem();

        show_name.setText(selected_friend.getName());
        show_age.setText(selected_friend.getAge());
        show_phone.setText(selected_friend.getPhone());
        show_email.setText(selected_friend.getEmail());
        show_memory.setText(selected_friend.getMemory());
    }

    //hide the information of the selected friend object
    public void hide_friend(MouseEvent mouseEvent) {
        show_name.clear();
        show_age.clear();
        show_phone.clear();
        show_email.clear();
        show_memory.clear();
    }

    //save to the default friend list
    public void save_list(MouseEvent mouseEvent) throws IOException {
        ObservableList<Friend> friends_list = list_friends.getItems();
        if (!list_friends.getItems().isEmpty()) {
            for (Friend friend : friends_list) {
                friend.write_to_file("all_friends.txt");
            }
        }
        list_friends.getItems().clear();
    }

    //load the default friend list where all friend objects are saved
    public void load_list(MouseEvent mouseEvent) throws IOException {
        list_friends.getItems().clear();
        ArrayList<Friend> friends = CreateFriend.create_all_friends("src/all_friends.txt");
        for (Friend friend : friends) {
            list_friends.getItems().add(friend);
        }
    }

    //create a custom friend list and save the friends' information to that list
    public void save_custom_list(MouseEvent mouseEvent) throws IOException {
        if (!txt_custom_save.getText().isEmpty()) {
            String file_name = txt_custom_save.getText();
            File file = new File("src/" + file_name + ".txt");
            if (file.createNewFile()) {
                System.out.println(file_name + ".txt" + " created");
            } else {
                System.out.println("file already existed");
            }

            ObservableList<Friend> friends_list = list_friends.getItems();
            if (!list_friends.getItems().isEmpty()) {
                for (Friend friend : friends_list) {
                    friend.write_to_file(file_name + ".txt");
                    friend.write_to_file("all_friends.txt");
                }
            }

            txt_custom_save.clear();
            list_friends.getItems().clear();
        }
    }

    //choose which file the user wish to load
    public void select_custom_list(MouseEvent mouseEvent) {
        list_friends.getItems().clear();

        File[] file_list = new File("src/").listFiles();
        ArrayList<String> files = new ArrayList<>();
        for (int i = 0; i < file_list.length; i++) {
            if (file_list[i].isFile()) {
                String file = file_list[i].getName();
                if (file.substring(file.length()-3).equals("txt") && !files.contains(file)){
                    //System.out.println("File " + file);
                    files.add(file);
                }
            }
        }
        //System.out.println(files.toString());
        ObservableList<String> txt_files = FXCollections.observableArrayList(files);
        select_custom.setItems(txt_files);
    }

    //load the selected file
    public void load_selected_list(MouseEvent mouseEvent) throws IOException {
        String selected_file = (String) select_custom.getValue();
        System.out.println(selected_file);
        ArrayList<Friend> selected_friends = CreateFriend.create_all_friends("src/" + selected_file);
        System.out.println(selected_friends);
        if (! selected_friends.isEmpty()){
            for (Friend friend : selected_friends) {
                list_friends.getItems().add(friend);
            }
        }
    }
}
