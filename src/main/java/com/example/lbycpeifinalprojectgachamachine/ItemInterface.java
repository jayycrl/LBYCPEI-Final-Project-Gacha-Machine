package com.example.lbycpeifinalprojectgachamachine;

public interface ItemInterface {
    double getRarity();
    String getItemName();
    String getDescription();
    String getImage();
    void setRarity(double rarity);
    void setItemName(String itemName);
    void setDescription(String description);

    void setImage(String image);
}
