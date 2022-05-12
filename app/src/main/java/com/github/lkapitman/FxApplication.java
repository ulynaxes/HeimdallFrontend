package com.github.lkapitman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.Getter;

import java.net.URL;

public class FxApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        var loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main.fxml"));
        Parent root = loader.load();

        stage.setScene(new Scene(root));

        stage.setResizable(false);
        stage.getIcons().add(new Image("/icon.png"));
        stage.setTitle("Heimdall Frontend");
        stage.show();
    }
}
