package com.example.Model;

public abstract class User {
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getuserId() {
        return userId;
    }

    public String getname() {
        return name;
    }

    // public abstract String returnRole();
}
