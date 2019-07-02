/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import model.Equipment;

/**
 *
 * @author ImmolateImprove
 */
public class SortAndFind {

    public static List<Equipment> findEquipment(int minPrice, int maxPrice, List<Equipment> arr) {
        List<Equipment> filteredList = new ArrayList();
        for (Equipment item : arr) {
            if (item.getPrice() > minPrice && item.getPrice() < maxPrice) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static List<Equipment> sortWeight(List<Equipment> specif) {
        for (int i = 0; i < specif.size(); i++) {
            for (int j = 0; j < specif.size() - 1 - i; j++) {
                if (specif.get(j).getWeight() >= specif.get(j + 1).getWeight()) {
                    Equipment t = specif.get(j);
                    specif.set(j, specif.get(j + 1));
                    specif.set(j + 1, t);

                }
            }
        }
        return specif;
    }

}
