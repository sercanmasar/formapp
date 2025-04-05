package com.formapp;

import com.formapp.util.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HomeApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        SceneManager.setStage(primaryStage);
        SceneManager.switchScene("/com/formapp/user-form.fxml", "User Registration");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
