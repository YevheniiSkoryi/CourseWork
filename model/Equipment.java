/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ImmolateImprove
 */
public class Equipment {

    private double price;
    private double weight;
    private String name;
    

    public Equipment(double price, double weight, String name) {
        
        this.price = price;
        this.weight = weight;
        this.name = name;
    }
    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Equipment{" + "price=" + price + ", weight=" + weight + ", name=" + name + '}';
    }
    


}
