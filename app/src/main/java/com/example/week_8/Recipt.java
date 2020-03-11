package com.example.week_8;

public class Recipt {

    private String name;
    private double cost;
    private double size;

    public Recipt(String name, double cost, double size){
        this.name = name;
        this.cost = cost;
        this.size = size;
    }

    public String getName(){
        return this.name;
    }

    public double getCost(){
        return this.cost;
    }

    public double getSize(){
        return this.size;
    }
}
