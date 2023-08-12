package com.example.lbycpeifinalprojectgachamachine;

import java.util.ArrayList;
import java.util.Random;

public class ItemDatabase {
    Random randomGenerator = new Random();
    int credits = 1000;

    ArrayList<ChocolateItem> chocolateItems = new ArrayList<>();
    ArrayList<SchoolItem> schoolItems = new ArrayList<>();
    ArrayList<OshiNoKoItem> oshiNoKoItems = new ArrayList<>();
    ArrayList<Item> inventory = new ArrayList<>();

    // adds items to database.
    public void initializeDatabase() {
        chocolateItems.add(new ChocolateItem("1 Hershey's Kisses", "A small, bite-sized Hershey's chocolate. First manufactured in 1907. It is uncertain where the name 'Kisses' came from; one story says that the machines that make the chocolates makes a sound like a kiss. (Hersheyland)", 0.35, "/com/example/lbycpeifinalprojectgachamachine/items/Chocolate Items/kisses.png"));
        chocolateItems.add(new ChocolateItem("KitKat", "A chocolate-covered wafer bar created in the United Kingdom, and is now produced by Nestle. The standard bars consist of two or four pieces of three wafer layers, separated and covered by an outer layer of chocolate. The name goes back to the 18th century, originally being used to refer to mutton pies that were served at meetings of the political Kit-Cat Club. (Wikipedia)", 0.35, "/com/example/lbycpeifinalprojectgachamachine/items/Chocolate Items/KitKat.png"));
        chocolateItems.add(new ChocolateItem("Toblerone", "A Swiss chocolate known for its distinct, triangular shape. Introduced in 1908. The recipe consists of milk chocolate, white nougat, almonds, and honey. Its shape was used in the Toblerone line, a series of anti-tank emplacements in Switzerland's border areas from World War II. (Wikipedia)", 0.14, "/com/example/lbycpeifinalprojectgachamachine/items/Chocolate Items/Toblerone.png"));
        chocolateItems.add(new ChocolateItem("Oreo", "A pack of sandwich cookies consisting of two cocoa biscuits with a fondant filling. It was introduced by Nabisco on March 6, 1912. These cookies are an imitation of the Hydrox brand of cookies, but Oreo exceeded Hydrox's popularity to the extent that people think Hydrox is an imitation of Oreo. (Wikipedia)", 0.14, "/com/example/lbycpeifinalprojectgachamachine/items/Chocolate Items/Oreo.png"));
        chocolateItems.add(new ChocolateItem("Box of Ferrero Rocher", "A chocolate and hazelnut confectionery introduced in 1982 by the Italian company Ferrero. The chocolate consists of a whole roasted hazelnut inside of a thin wafer shell filled with hazelnut chocolate, covered in milk chocolated and chopped hazelnuts. (Wikipedia)", 0.02, "/com/example/lbycpeifinalprojectgachamachine/items/Chocolate Items/ferrero.png"));

        schoolItems.add(new SchoolItem("Muji pen", "Look at this fancy pen lol", 0.35, "/com/example/lbycpeifinalprojectgachamachine/items/School Items/MujiPen.png"));
        schoolItems.add(new SchoolItem("Correction tape", "Useful for when you make mistakes in tests", 0.35, "/com/example/lbycpeifinalprojectgachamachine/items/School Items/CorrectionTape.png"));
        schoolItems.add(new SchoolItem("Laptop", "A MacBook Pro. Thin and light, a rigid aluminum build with next to no flex, and speedy performance to drive a high-resolution 2880x1800 P3-compatible display.", 0.14, "/com/example/lbycpeifinalprojectgachamachine/items/School Items/Laptop.png"));
        schoolItems.add(new SchoolItem("Scientific calculator", "An engineer's best friend", 0.14, "/com/example/lbycpeifinalprojectgachamachine/items/School Items/ScientificCalculator.png"));
        schoolItems.add(new SchoolItem("Free Skip Class ticket", "Show this to your teacher and you're good (probably)", 0.02, "/com/example/lbycpeifinalprojectgachamachine/items/School Items/ticket.png"));

        oshiNoKoItems.add(new OshiNoKoItem("Aquamarine Hoshino", "Aquamarine Hoshino, commonly referred to as Aqua, is the male protagonist and one of the titular characters of the series. In his previous life, he was known as Gorou Amamiya, a doctor specializing in obstetrics and gynaecology. He was murdered by a stalker of one of his patients, Ai Hoshino, causing him to be reincarnated as her child. Details: Male, 172 cm, 18 years old [Movie arc] (Oshi No Ko Fandom Wiki)", 0.35, "/com/example/lbycpeifinalprojectgachamachine/items/Oshi No Ko Pins/aquamarine-hoshino.png"));
        oshiNoKoItems.add(new OshiNoKoItem("Ruby Hoshino", "Ruby Hoshino, commonly referred to as Ruby, is the female protagonist and one of the titular characters of the series. In her previous life, she was known as Sarina Tendouji, a patient suffering from anaplastic astrocytoma. She was neglected by her parents in her previous life, and after being reincarnated as the child of her favorite idol, Ai Hoshino, she greatly enjoyed her new life. This happy life was ended when Ai was murdered by a deranged fan. Details: Female, 158 cm, 18 years old [Movie arc] (Oshi No Ko Fandom Wiki)", 0.35, "/com/example/lbycpeifinalprojectgachamachine/items/Oshi No Ko Pins/ruby-hoshino.png"));
        oshiNoKoItems.add(new OshiNoKoItem("Kana Arima", "Kana Arima is a major supporting character in the series. She is a child actress and a childhood acquantiance of Aqua and Ruby. She was the former center of the idol group B-Komachi. Details: Female, 150 cm, 19 years old [Movie arc] (Oshi No Ko Fandom Wiki)", 0.14, "/com/example/lbycpeifinalprojectgachamachine/items/Oshi No Ko Pins/kana-arima.png"));
        oshiNoKoItems.add(new OshiNoKoItem("Mem-Cho", "Mem-Cho is a major supporting character in the series. Despite being a popular YouTuber and former TikToker, her real name is unknown. She missed her chance to become an idol due to having to support her family, but became a popular streamer. Details: Female, 155 cm, 27 years old [Movie arc] (Oshi No Ko Fandom Wiki)", 0.14, "/com/example/lbycpeifinalprojectgachamachine/items/Oshi No Ko Pins/Mem-Cho.png"));
        oshiNoKoItems.add(new OshiNoKoItem("Ai Hoshino", "Ai Hoshino is the poster child of the series and was the lead idol of B-Komachi. She came from an abusive past. Details: Female, 151 cm, 20 years old [chapter 9] (Oshi No Ko Fandom Wiki)", 0.02, "/com/example/lbycpeifinalprojectgachamachine/items/Oshi No Ko Pins/ai-hoshino.png"));
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
    public int countItemInInventory(Item query) {
        if (query == null) {
            return 0;
        }

        int foundCount = 0;
        for (int i = 0; i < inventory.size(); i++) {
            if (query.equals(inventory.get(i))) {
                foundCount++;
            }
        }

        return foundCount;
    }
}