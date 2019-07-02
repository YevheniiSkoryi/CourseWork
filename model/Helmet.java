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
public class Helmet extends Equipment {

    private String glassStyle;

    public Helmet(String glassStyle, double price, double weight, String name) {
        super(price, weight, name);
        this.glassStyle = glassStyle;
    }

   

    public String getGlassStyle() {
        return glassStyle;
    }

    public void setGlassStyle(String glassStyle) {
        this.glassStyle = glassStyle;
    }

}
