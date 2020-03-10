package com.example.week_8;

public class Bottle {

    private String name;

    private String manufacturer;

    private double total_energy;

    private double cost;
    private double size;

    public Bottle(String name, String manufacturer, double total_energy, double cost, double size){
        this.name = name;
        this.manufacturer = manufacturer;
        this.total_energy = total_energy;
        this.cost = cost;
        this.size = size;
    }

    public String getName(){
        return this.name;
    }

    public String getManufacturer(){
        return this.manufacturer;
    }

    public double getEnergy(){
        return this.total_energy;
    }

    public double getCost(){
        return this.cost;
    }

    public double getSize(){
        return this.size;
    }

}