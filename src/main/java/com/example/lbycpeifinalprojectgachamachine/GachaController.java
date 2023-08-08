package com.example.lbycpeifinalprojectgachamachine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;

public class GachaController {
    ItemDatabase database = new ItemDatabase();
    @FXML
    public void loadItemPoolsScene(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        AnchorPane itemPoolsBackground = new AnchorPane();

        // Create the new scene
        Parent root = FXMLLoader.load(getClass().getResource("Prize.fxml"));
        Scene newScene = new Scene(root);
        currentStage.setTitle("Gacha Machine");

        // Set the scene of the current stage to the new scene
        currentStage.setScene(newScene);
    }

    @FXML
    public void loadMainMenuScene(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Create the new scene
        Parent root = FXMLLoader.load(getClass().getResource("Gacha-view.fxml"));
        Scene newScene = new Scene(root);
        currentStage.setTitle("Gacha Machine");

        // Set the scene of the current stage to the new scene
        currentStage.setScene(newScene);
    }

    @FXML
    public void displayRandomItem() {
        database.initializeDatabase();

        System.out.println(database.getRandomItem(database.chocolateItems).getItemName());
    }
}