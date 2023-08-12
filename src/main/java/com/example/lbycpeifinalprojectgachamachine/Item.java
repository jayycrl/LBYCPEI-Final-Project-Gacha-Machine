package com.example.lbycpeifinalprojectgachamachine;

public abstract class Item implements ItemInterface {
    public double rarity;
    public String itemName;
    public String description;
    public String image;

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
