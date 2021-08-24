package com.example.friendsbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {
    private static String name;
    private static String age;
    private static String phone;
    private static String email;
    private static String memory;

    private static FileReader file_reader;
    private static BufferedReader buffered_reader;
    private static ArrayList<Friend> friends = new ArrayList<>();

    public static ArrayList create_all_friends(String file) throws IOException {
        friends.clear();
        file_reader = new FileReader(file);
        buffered_reader = new BufferedReader(file_reader);
        String line;
        String friend_string = "";

        while ((line = buffered_reader.readLine()) != null){
            if (!line.equals(";")){
                friend_string += line;
            }
            else{
                parse_friend(friend_string);
                friend_string = "";
            }
            //System.out.println(friend_string);
        }
        return friends;
    }
    private static void parse_friend(String string){
        String[] splitted_string = string.split(",");
        //System.out.println(splitted_string.length);
        String name = splitted_string[0];
        String age = splitted_string[1];
        String phone = splitted_string[2];
        String email = splitted_string[3];
        String memory = splitted_string[4];

        Friend friend = new Friend(name, age, phone, email, memory);
        //System.out.println(friend);

        //ensuring that redundant friend names don't occur twice
        int count = 0;
        for (int i = 0; i < friends.size(); i++){
            if(friend.name.equals(friends.get(i).name)){
                count ++;
            }
        }
        //System.out.println(count);
        if(count == 0){
            friends.add(friend);
        }
        //System.out.println(friends);
    }
}
