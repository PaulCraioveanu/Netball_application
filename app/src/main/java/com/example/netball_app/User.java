package com.example.netball_app;

public class User {
        String name, username, password;
        int age;

        public User(String name, int age, String username, String password){
            this.name = "";
            this.age = -1;
            this.username = username;
            this.password = password;

        }
        public User(String username, String password){
            this.username = username;
            this.password = password;
            this.age = -1;
            this.name = "";
        }

}
