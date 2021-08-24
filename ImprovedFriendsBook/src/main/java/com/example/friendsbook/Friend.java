package com.example.friendsbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    String name;
    String age;
    String phone;
    String email;
    String memory;

    Friend(String name, String age, String phone, String email, String memory){
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.memory = memory;
    }

    public void write_to_file(String file) throws IOException {
        FileWriter file_writer = new FileWriter("src/" + file, true);
        BufferedWriter buffered_writer = new BufferedWriter(file_writer);
        buffered_writer.write("\r" + name + ",\r");
        buffered_writer.write(age + ",\r");
        buffered_writer.write(phone + ",\r");
        buffered_writer.write(email + ",\r");
        buffered_writer.write(memory + ",\r");
        buffered_writer.write(";\r");
        buffered_writer.close();
    }

    public String toString(){
        return name;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
}
