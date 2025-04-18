package com.example;

import com.example.Configuration.Session;
import com.example.Database.libraryDatabase;

public class Main {
    public static void main(String[] args) {

        libraryDatabase database = new libraryDatabase();

        Session session = new Session(database, true);
        session.start();
    }
}
