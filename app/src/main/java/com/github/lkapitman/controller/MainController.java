package com.github.lkapitman.controller;

import com.github.lkapitman.FxApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

public class MainController {
    private final Runtime runtime = Runtime.getRuntime();

    public TextArea wait_device;
    public TextArea logs;
    public CheckBox no_reboot;
    public Button flash_btn;
    public Button update_btn;
    public TextArea path_to_file;
    public Button exit_btn;
    public Button open_btn;

    public void flash(ActionEvent actionEvent) {
        
    }

    @SneakyThrows
    public void update(ActionEvent actionEvent) {
        var update = runtime.exec("heimdall detect");
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(update.getInputStream()));

        String s;
        while ((s = stdInput.readLine()) != null) {
            if (s.toLowerCase(Locale.ROOT).contains("detected")) {
                wait_device.setText("Founded!");
                break;
            }
        }
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void open(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(FxApplication.getStage());
        path_to_file.setText(selectedFile.getAbsolutePath());
    }
}
