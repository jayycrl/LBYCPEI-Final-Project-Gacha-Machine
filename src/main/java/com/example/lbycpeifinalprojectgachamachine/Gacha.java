package com.example.lbycpeifinalprojectgachamachine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Gacha extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Gacha.class.getResource("Gacha-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1280,720);
        stage.setTitle("Gacha Machine");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}