package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
            stage.setTitle("Sorts");
            stage.setScene(new Scene(root,640,480));
            stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}