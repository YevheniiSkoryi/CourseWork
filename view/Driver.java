/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import logic.SortAndFind;
import static logic.SortAndFind.findEquipment;
import model.Boots;
import model.Equipment;
import model.Helmet;
import model.Jacket;
import model.Men;
import model.Pants;

/**
 *
 * @author Evghenii Skoriy
 */


public class Driver  {

    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String[] args) {
        Men jacky = new Men("Jacky");
        initMen(jacky);
        System.out.println("All Equipment");
        printEquipmentList(jacky.getAllEquipment());
        System.out.println(jacky.calculateTotalPrice());
        List<Equipment> list = SortAndFind.findEquipment(150, 1000, jacky.getAllEquipment());
        printEquipmentList(list);
       
        
    }

    public static void initMen(Men men) {
        men.addEquipment(createEquipmentList());

    }

    public static void printEquipmentList(List<Equipment> list) {
        for (Equipment item : list) {
            System.out.println(item);
        }
    }

    public static List<Equipment> createEquipmentList() {
        Equipment goodHelmet = new Helmet("blue", 999, 63, "Good helmet");
        Equipment lightHelmet = new Helmet("white-white", 0, 1, "Light helmet");
        Equipment goodJacket = new Jacket(0, 1000, 63, "Good jacket");
        Equipment lightJacket = new Jacket(999, 0, 1, "Light Jacket");
        Equipment goodPants = new Pants("leggings", 321, 63, "Good pants");
        Equipment lightPants = new Pants("sport", 0, 1, "Light Pants");
        Equipment goodBoot = new Boots("Mongol", 123, 63, "Good boot");
        Equipment lightBoot = new Boots("Spain", 0, 1, "Light Boot");

        Equipment fHelmet = new Helmet("orange", 25.25, 20, "Flowers Helmet");
        Equipment fearHelmet = new Helmet("red", 850, 20, "FEAR helmet");
        Equipment fJacket = new Jacket(2, 52.52, 20, "Flowers Jacket");
        Equipment fearJacket = new Jacket(4, 850, 20, "FEAR jacket");
        Equipment fPants = new Pants("Home", 25.52, 20, "Flowers Pants");
        Equipment fearPants = new Pants("fear home", 52.25, 20, "FEAR Pants");
        Equipment fBoot = new Boots("Home", 2.5, 20, "Flowers Boots");
        Equipment fearBoots = new Boots("fear home", 5.2, 20, "FEAR Boots");

        Equipment varHelmet = new Helmet("black", 100, 40, "Var helmet");
        Equipment cHelmet = new Helmet("white", 105, 36, "Cold helmet");
        Equipment varJacket = new Jacket(4, 500, 40, "Var Jacket");
        Equipment cJacket = new Jacket(2, 400, 36, "Cold Jacket");
        Equipment varPants = new Pants("jeans", 200, 40, "Var jeans");
        Equipment cPants = new Pants("Sport", 400, 36, "Cold Sport");
        Equipment varBoot = new Boots("Japan", 1500, 40, "Var boots");
        Equipment cBoot = new Boots("Ukraine", 1000, 36, "Cold boots");
        List<Equipment> list = new ArrayList();
        list.add(goodHelmet);
        list.add(lightHelmet);
        list.add(goodJacket);
        list.add(lightJacket);
        list.add(goodPants);
        list.add(lightPants);
        list.add(goodBoot);
        list.add(lightBoot); 

        list.add(fHelmet);
        list.add(fearHelmet);
        list.add(fJacket);
        list.add(fearJacket);
        list.add(fPants);
        list.add(fearPants);
        list.add(fBoot);
        list.add(fearBoots);

        list.add(cHelmet);
        list.add(varHelmet);
        list.add(cJacket);
        list.add(varJacket);
        list.add(varPants);
        list.add(cPants);
        list.add(varBoot);
        list.add(cBoot);
        Random r = new Random();
        return list.subList(0, 10);
    }
}
