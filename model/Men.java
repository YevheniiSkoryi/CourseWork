/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ImmolateImprove
 */
public class Men {

    private List<Equipment> list;
    private String nameMoto;

    public Men(String nameMoto) {
        this.nameMoto = nameMoto;
        list = new ArrayList();
    }

    public String getNameMoto() {
        return nameMoto;
    }

    public void setNameMoto(String nameMoto) {
        this.nameMoto = nameMoto;
    }

    public void addEquipment(Equipment item) {
        list.add(item);
    }

    public void removeEquipment(int index) {
        list.remove(index);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Equipment spec : list) {
            totalPrice += spec.getPrice();
        }
        return totalPrice;
    }

    public void addEquipment(List<Equipment> list) {
        this.list.addAll(list);
    }

    public List<Equipment> getAllEquipment() {
        return new ArrayList(list);
    }

}
