package com.example.lbycpeifinalprojectgachamachine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.*;

import java.io.IOException;
import java.util.EventObject;

public class GachaController {
    @FXML
    public void loadItemPoolsScene(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Create the new scene
        Parent root = FXMLLoader.load(getClass().getResource("ItemPools.fxml"));
        Scene itemPools = new Scene(root, 1280, 720);
        currentStage.setTitle("Gacha Machine");

        // Set the scene of the current stage to the new scene
        currentStage.setScene(itemPools);
    }
}