package com.example.week_8;

import android.view.View;

import java.util.ArrayList;
import java.util.Scanner;

public class BottleDispenser{

    private static BottleDispenser single_instance = null;

    public float money = 0;
    public int choice;

    ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object

    private BottleDispenser() {

        money = 0;

        // Initialize the array
        bottle_array.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 1.8, 0.5));
        bottle_array.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 2.2, 1.5));
        bottle_array.add(new Bottle("Coca-Cola Zero", "Pepsi", 0.3, 2.0, 0.5));
        bottle_array.add(new Bottle("Coca-Cola Zero", "Pepsi", 0.3, 2.5, 1.5));
        bottle_array.add(new Bottle("Fanta Zero", "Pepsi", 0.3, 1.95, 0.5));
    }

    public static BottleDispenser getInstance()
    {
        if (single_instance == null)
            single_instance = new BottleDispenser();

        return single_instance;
    }

    public String addMoney(int progressChangedValue) {
        money += progressChangedValue;
        String addPrint = ("Klink! Added more money! Balance: "+ money);
        return addPrint;
    }

    public String buyBottle(int choice) {
        String buyB;
        if(money >= bottle_array.get(choice-1).getCost()) {
            money -= bottle_array.get(choice-1).getCost();
            buyB = ("KACHUNK! "+ bottle_array.get(choice-1).getName() +" came out of the dispenser!");
            bottle_array.remove(choice-1);
        } else {
            buyB = ("Add money first!");
        }
        return buyB;
    }

    public String returnMoney() {
        String returnM = String.format("Klink klink. Money came out! You got %.02f€ back", money);
        return returnM;
    }

    public void printBottles() {
        for(int i = 0;i<bottle_array.size();i++) {
            System.out.println(i+1 +". Name: "+bottle_array.get(i).getName());
            System.out.println("	Size: "+bottle_array.get(i).getSize()+"	Price: "+bottle_array.get(i).getCost());
        }

    }

}