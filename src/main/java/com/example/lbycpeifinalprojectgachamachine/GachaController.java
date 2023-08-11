package com.example.lbycpeifinalprojectgachamachine;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Objects;

import javafx.animation.PauseTransition;
import javafx.util.BuilderFactory;
import javafx.util.Duration;

public class GachaController {
    ItemDatabase database = new ItemDatabase();

    ArrayList<? extends Item> currentItemPool = database.chocolateItems;
    String currentItemPoolName = "chocolateItems";

    @FXML
    GridPane itemGrid;
    @FXML
    ImageView randomItemImage;
    @FXML
    ImageView itemSlot1;
    @FXML
    ImageView itemSlot2;
    @FXML
    ImageView itemSlot3;
    @FXML
    ImageView itemSlot4;
    @FXML
    ImageView itemSlot5;
    @FXML
    Label itemDescription;
    @FXML
    Button item1SlotButton;
    @FXML
    Button item2SlotButton;
    @FXML
    Button item3SlotButton;
    @FXML
    Button item4SlotButton;
    @FXML
    Button item5SlotButton;

    @FXML
    public void displayRandomItem() {
        Item randomItem = database.getRandomItem(currentItemPool);
        Image image = new Image(getClass().getResource(randomItem.getImage()).toString());
        randomItemImage.setImage(image);

        database.inventory.add(randomItem);
    }

    @FXML
    public void setCurrentItemPool(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        switch (clickedButton.getId()) {
            case "chocolateItemPoolButton" -> {
                currentItemPool = database.chocolateItems;
                currentItemPoolName = "chocolateItems";
                loadItemImages(database.chocolateItems);
            }
            case "schoolItemPoolButton" -> {
                currentItemPool = database.schoolItems;
                currentItemPoolName = "schoolItems";
                loadItemImages(database.schoolItems);
            }
            case "oshiNoKoItemPoolButton" -> {
                currentItemPool = database.oshiNoKoItems;
                currentItemPoolName = "oshiNoKoItems";
                // loadItemImages(database.oshiNoKoItems);
            }
        }
    }

    @FXML
    public void loadItemImages(ArrayList<? extends Item> arrayList) {
        database.initializeDatabase();
        ImageView[] itemSlots = {itemSlot1, itemSlot2, itemSlot3, itemSlot4, itemSlot5};
        Button[] itemSlotButtons = {item1SlotButton, item2SlotButton, item3SlotButton, item4SlotButton, item5SlotButton};
        for (int i = 0; i < itemSlots.length; i++) {
            System.out.println(arrayList.get(i).getImage());
            itemSlots[i].setImage(new Image(arrayList.get(i).getImage()));
            itemSlotButtons[i].setText(arrayList.get(i).getItemName());
        }
    }

    @FXML
    public void loadItemDescription(ActionEvent event) {
        database.initializeDatabase();
        Button clickedButton = (Button) event.getSource();

        switch (clickedButton.getId()) {
            case "item1SlotButton" -> itemDescription.setText(currentItemPool.get(0).getDescription());
            case "item2SlotButton" -> itemDescription.setText(currentItemPool.get(1).getDescription());
            case "item3SlotButton" -> itemDescription.setText(currentItemPool.get(2).getDescription());
            case "item4SlotButton" -> itemDescription.setText(currentItemPool.get(3).getDescription());
            case "item5SlotButton" -> itemDescription.setText(currentItemPool.get(4).getDescription());
        }
    }
}