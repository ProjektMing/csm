package com.example.demo.model.beans;

public class User {
    private final int Id;
    private static int id;
    private String Name;
    private String Email;
    private String Password;
    public User(String name, String email, String password) {
        Id = id++;
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isPasswordValid(String password) {
        return Password.equals(password);
    }
}
