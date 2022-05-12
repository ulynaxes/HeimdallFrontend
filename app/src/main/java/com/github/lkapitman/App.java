package com.github.lkapitman;

import javafx.application.Application;

import javax.swing.*;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        try {
            Class.forName("javafx.application.Application");
            Application.launch(FxApplication.class, args);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "JavaFX not found !", "JavaFX Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
