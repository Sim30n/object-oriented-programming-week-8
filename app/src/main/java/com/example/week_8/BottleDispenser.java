package com.example.week_8;

import java.util.ArrayList;

public class BottleDispenser{

    private static BottleDispenser single_instance = null;

    public float money = 0;
    public int choice;

    ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    ArrayList<Recipt> recipt_array = new ArrayList<Recipt>();

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

    public String buyBottle(String value, double size) {
        String buyB;
        buyB = ("Out of stock!");
        for (int i = 0; i < bottle_array.size(); i++) {
            if(money >= bottle_array.get(i).getCost() && size == bottle_array.get(i).getSize() && value == bottle_array.get(i).getName() ) {
                money -= bottle_array.get(i).getCost();
                buyB = ("KACHUNK! "+ bottle_array.get(i).getName() +" came out of the dispenser!");
                recipt_array.add(new Recipt(bottle_array.get(i).getName(),bottle_array.get(i).getCost(),bottle_array.get(i).getSize()));
                bottle_array.remove(i);
                break;
            } else if (money < bottle_array.get(choice).getCost()){
                buyB = ("Add money first!");
            } else if (size != bottle_array.get(choice).getSize() && value == bottle_array.get(choice).getName()){
                buyB = ("We don't have that size!");
            }
        }
        return buyB;
    }

    public String returnMoney() {
        String returnM = String.format("Klink klink. Money came out! You got %.02f€ back", money);
        return returnM;
    }

    public String printRecipt(){
        String recipt ="This is recipt!\n"+recipt_array.get(recipt_array.size()-1).getName() +" "+ recipt_array.get(recipt_array.size()-1).getSize()+"l "+recipt_array.get(recipt_array.size()-1).getCost()+"€ ";
        return recipt;

    }

}