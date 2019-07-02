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
public class Boots extends Equipment {

    private String manufacturerCountry;

    public Boots(String manufacturerCountry, double price, double weight, String name) {
        super(price, weight, name);
        this.manufacturerCountry = manufacturerCountry;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

}
