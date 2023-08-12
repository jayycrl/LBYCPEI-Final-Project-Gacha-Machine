package com.example.lbycpeifinalprojectgachamachine;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class GachaController {
    ItemDatabase database = new ItemDatabase();

    ArrayList<? extends Item> currentItemPool = database.chocolateItems;
    String currentItemPoolName = "chocolateItems";
    Item currentItem;

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
    Button sellButton;
    @FXML
    Label itemCountLabel;
    @FXML
    Button rollButton;
    @FXML
    Label creditsLabel;
    @FXML
    Label rarityLabel;
    @FXML
    Label descriptionRarityLabel;

    @FXML
    public void displayRandomItem() {
        if (database.credits != 0) {
            Item randomItem = database.getRandomItem(currentItemPool);
            Image image = new Image(getClass().getResource(randomItem.getImage()).toString());
            randomItemImage.setImage(image);

            database.credits -= 100;

            creditsLabel.setText(database.credits + " CREDITS");

            if (randomItem.getRarity() == 0.02) {
                rarityLabel.setText("LEGENDARY");
                rarityLabel.setTextFill(Color.rgb(250, 188, 60));
            } else if (randomItem.getRarity() == 0.14) {
                rarityLabel.setText("RARE");
                rarityLabel.setTextFill(Color.rgb(197, 159, 201));
            } else if (randomItem.getRarity() == 0.35) {
                rarityLabel.setText("COMMON");
                rarityLabel.setTextFill(Color.rgb(175, 175, 175));
            }

            database.inventory.add(randomItem);
        } else {
            rollButton.setDisable(true);
        }
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
                loadItemImages(database.oshiNoKoItems);
            }
        }
    }

    @FXML
    public void loadItemImages(ArrayList<? extends Item> arrayList) {
        database.initializeDatabase();
        ImageView[] itemSlots = {itemSlot1, itemSlot2, itemSlot3, itemSlot4, itemSlot5};
        Button[] itemSlotButtons = {item1SlotButton, item2SlotButton, item3SlotButton, item4SlotButton, item5SlotButton};
        for (int i = 0; i < itemSlots.length; i++) {
            itemSlots[i].setImage(new Image(arrayList.get(i).getImage()));
            itemSlotButtons[i].setText(arrayList.get(i).getItemName());
        }
    }

    @FXML
    public void loadItemDescription(ActionEvent event) {
        database.initializeDatabase();
        Button clickedButton = (Button) event.getSource();

        switch (clickedButton.getId()) {
            case "item1SlotButton" -> {
                itemDescription.setText(currentItemPool.get(0).getDescription());
                currentItem = currentItemPool.get(0);
            }
            case "item2SlotButton" -> {
                itemDescription.setText(currentItemPool.get(1).getDescription());
                currentItem = currentItemPool.get(1);
            }
            case "item3SlotButton" -> {
                itemDescription.setText(currentItemPool.get(2).getDescription());
                currentItem = currentItemPool.get(2);
            }
            case "item4SlotButton" -> {
                itemDescription.setText(currentItemPool.get(3).getDescription());
                currentItem = currentItemPool.get(3);
            }
            case "item5SlotButton" -> {
                itemDescription.setText(currentItemPool.get(4).getDescription());
                currentItem = currentItemPool.get(4);
            }
        }

        if (currentItem.getRarity() == 0.02) {
            descriptionRarityLabel.setText("LEGENDARY ITEM");
            descriptionRarityLabel.setTextFill(Color.rgb(250, 188, 60));
        } else if (currentItem.getRarity() == 0.14) {
            descriptionRarityLabel.setText("RARE ITEM");
            descriptionRarityLabel.setTextFill(Color.rgb(197, 159, 201));
        } else if (currentItem.getRarity() == 0.35) {
            descriptionRarityLabel.setText("COMMON ITEM");
            descriptionRarityLabel.setTextFill(Color.rgb(175, 175, 175));
        }

        updateItemLabel(currentItem);
    }

    @FXML
    public void updateItemLabel(Item item) {
        int numberOfItems = database.countItemInInventory(item);

        if (numberOfItems == 0) {
            sellButton.setDisable(true);
        } else {
            sellButton.setDisable(false);
        }

        itemCountLabel.setText("You have " + numberOfItems + " of this item.");

        if (currentItem.getRarity() == 0.02) {
            sellButton.setText("SELL 1 FOR 1000 CREDITS");
        } else if (currentItem.getRarity() == 0.14) {
            sellButton.setText("SELL 1 FOR 500 CREDITS");
        } else if (currentItem.getRarity() == 0.35) {
            sellButton.setText("SELL 1 FOR 100 CREDITS");
        }
    }

    @FXML
    public void sellItem() {
        if (currentItem.getRarity() == 0.02) {
            database.credits += 1000;
        } else if (currentItem.getRarity() == 0.14) {
            database.credits += 500;
        } else if (currentItem.getRarity() == 0.35) {
            database.credits += 100;
        }

        updateItemLabel(currentItem);
        creditsLabel.setText(database.credits + " CREDITS");

        if (database.credits > 0) {
            rollButton.setDisable(false);
        }

        database.inventory.remove(currentItem);
    }
}