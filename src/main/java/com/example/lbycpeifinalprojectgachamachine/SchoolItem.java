package com.example.lbycpeifinalprojectgachamachine;

public class SchoolItem extends Item {
    public double rarity;
    public String itemName;
    public String description;
    public String image;

    public SchoolItem(String itemName, String description, double rarity, String image) {
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

    @Override
    public void setRarity(double rarity) {
        this.rarity = rarity;
    }

    @Override
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }
}