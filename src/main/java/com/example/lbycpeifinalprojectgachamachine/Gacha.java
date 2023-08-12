package com.example.lbycpeifinalprojectgachamachine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Gacha extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ItemDatabase database = new ItemDatabase();
        GachaController controller = new GachaController();

        FXMLLoader fxmlLoader = new FXMLLoader(Gacha.class.getResource("Gacha-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1280,720);
        stage.setTitle("Gacha Machine");
        stage.setScene(scene);

        database.initializeDatabase();

        controller.currentItem = database.getItem(database.chocolateItems, 0);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}