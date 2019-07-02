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
public class Jacket extends Equipment{

    private int pockedCount;

    public Jacket(int pockedCount, double price, double weight, String name) {
        super(price, weight, name);
        this.pockedCount = pockedCount;
    }

    public int getPockedCount() {
        return pockedCount;
    }

    public void setPockedCount(int pockedCount) {
        this.pockedCount = pockedCount;
    }

    

    

}
