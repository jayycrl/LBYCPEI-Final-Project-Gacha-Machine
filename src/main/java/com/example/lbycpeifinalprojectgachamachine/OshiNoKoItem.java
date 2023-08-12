package com.example.lbycpeifinalprojectgachamachine;

public class OshiNoKoItem extends Item {
    public double rarity;
    public String itemName;
    public String description;
    public String image;

    public OshiNoKoItem(String itemName, String description, double rarity, String image) {
        this.rarity = rarity;
        this.itemName = itemName;
        this.description = description;
        this.image = image;
    }

    @Override
    public double getRarity() {
        return this.rarity;
    }

    @Override
    public String getItemName() {
        return this.itemName;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getImage() {
        return this.image;
    }

}