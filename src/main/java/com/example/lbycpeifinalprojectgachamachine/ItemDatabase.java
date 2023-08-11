package com.example.lbycpeifinalprojectgachamachine;

import java.util.ArrayList;
import java.util.Random;

public class ItemDatabase {
    Random randomGenerator = new Random();

    ArrayList<ChocolateItem> chocolateItems = new ArrayList<>();
    ArrayList<SchoolItem> schoolItems = new ArrayList<>();
    ArrayList<OshiNoKoItem> oshiNoKoItems = new ArrayList<>();
    ArrayList<Item> inventory = new ArrayList<>();

    // adds items to database.
    public void initializeDatabase() {
        chocolateItems.add(new ChocolateItem("Toblerone","A bar of Toblerone",0.14,"/com/example/lbycpeifinalprojectgachamachine/items/Chocolates/Toblerone.png"));
        chocolateItems.add(new ChocolateItem("KitKat","A bar of KitKat",0.35,"/com/example/lbycpeifinalprojectgachamachine/items/Chocolates/KitKat.png"));
        chocolateItems.add(new ChocolateItem("Oreo","A pack of Oreos",0.14,"/com/example/lbycpeifinalprojectgachamachine/items/Chocolates/Oreo.png"));
        chocolateItems.add(new ChocolateItem("1 Hershey's Kisses","A single Hershey's Kiss",0.35, "/com/example/lbycpeifinalprojectgachamachine/items/Chocolates/kisses.png"));
        chocolateItems.add(new ChocolateItem("Box of Ferrero Rocher","A whole box of Ferrero Rocher",0.02, "/com/example/lbycpeifinalprojectgachamachine/items/Chocolates/ferrero.png"));

        schoolItems.add(new SchoolItem("Laptop","A MacBook Pro", 0.14, "/com/example/lbycpeifinalprojectgachamachine/items/School Items/Laptop.png"));
        schoolItems.add(new SchoolItem("Muji pen","Fancy pen", 0.35, "/com/example/lbycpeifinalprojectgachamachine/items/School Items/MujiPen.png"));
        schoolItems.add(new SchoolItem("Correction tape","Useful for making mistakes in tests", 0.35, "/com/example/lbycpeifinalprojectgachamachine/items/School Items/CorrectionTape.png"));
        schoolItems.add(new SchoolItem("Free Skip Class ticket","Show this to your teacher and you're good", 0.02, "/com/example/lbycpeifinalprojectgachamachine/items/School Items/ticket.png"));
        schoolItems.add(new SchoolItem("Scientific calculator","An engineer's best friend", 0.14, "/com/example/lbycpeifinalprojectgachamachine/items/School Items/ScientificCalculator.png"));
    }

    // types in java are invariant,
    // meaning that while ChocolateItem is a subtype of Item,
    // an ArrayList<> of ChocolateItems is not a subtype of
    // an ArrayList<> of Items.
    // to get around this, we can use a wildcard (?), bounded by the
    // requirement that the type must extend Item.
    public Item getItem(ArrayList<? extends Item> array, int index) {
        return array.get(index);
    }

    // gets the nth item of a certain rarity from an ArrayList array.
    public Item getNthItemOfRarity(ArrayList<? extends Item> array, double rarity, int n) {
        int count = 1;

        for (int i = 0; i < array.size(); i++) {
            if (getItem(array, i).getRarity() == rarity && count == n) {
                return getItem(array, i);
            } else if (getItem(array, i).getRarity() == rarity) {
                count++;
            }
        }

        return null;
    }

    // gets one random item from a given ArrayList array.
    public Item getRandomItem(ArrayList<? extends Item> array) {
        initializeDatabase();
        int nextRandom = randomGenerator.nextInt(100);

        // LEGENDARY
        if (nextRandom >= 98) {
            for (int i = 0; i < array.size(); i++) {
                if (getItem(array, i).getRarity() == 0.02) {
                    return getItem(array, i);
                }
            }
        }
        // RARE 1
        else if (nextRandom >= 83) {
            for (int i = 0; i < array.size(); i++) {
                if (getItem(array, i).getRarity() == 0.14) {
                    return getItem(array, i);
                }
            }
        }
        // RARE 2
        else if (nextRandom >= 69) {
            for (int i = 0; i < array.size(); i++) {
                if (getItem(array, i).getRarity() == 0.14) {
                    return getNthItemOfRarity(array, 0.14, 2);
                }
            }
        }
        // COMMON 1
        else if (nextRandom >= 34) {
            for (int i = 0; i < array.size(); i++) {
                if (getItem(array, i).getRarity() == 0.35) {
                    return getItem(array, i);
                }
            }
        }
        // COMMON 2
        else {
            for (int i = 0; i < array.size(); i++) {
                if (getItem(array, i).getRarity() == 0.35) {
                    return getNthItemOfRarity(array, 0.35, 2);
                }
            }
        }
        return getItem(array, 0);
    }

    // given an Item query, finds instances of that object in player inventory.
    public int findInInventory(Item query) {
        int foundCount = 0;
        for (int i = 0; i < inventory.size(); i++) {
            if (query.equals(inventory.get(i))) {
                foundCount++;
            }
        }

        return foundCount;
    }
}