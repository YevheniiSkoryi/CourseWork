/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import logic.SortAndFind;
import model.Boots;
import model.Equipment;
import model.Helmet;
import model.Jacket;
import model.Men;
import model.Pants;
import static view.Driver.createEquipmentList;

/**
 *
 * @author Evghenii Skoriy
 */
public class GUI extends JFrame {
    
    private List<Men> list = new ArrayList();
    private List<Equipment> list2 = new ArrayList();
    private JButton buttonAdd = new JButton("Add");
    private JButton buttonRemove = new JButton("Remove");
    private JButton buttonSort = new JButton("Sort");
    private JButton buttonExit = new JButton("Exit");
    private JPanel panelButton = new JPanel();
    private JPanel panelLeft = new JPanel();
    private JPanel panelCentr = new JPanel();
    private JPanel panelTop = new JPanel();
    private JList listMen = new JList();
    private JList listEquipment = new JList();
    private JList listFindEquipment = new JList();
    
    JTextField textMaxPrice = new JTextField();
    JTextField textMinPrice = new JTextField();
    private JButton find = new JButton("Find");
    
    public GUI() {
        list.addAll(Arrays.asList(new Men[]{new Men("Alex"), new Men("Stas"), new Men("Jack")}));
        for (Men men : list) {
            men.addEquipment(createEquipmentList());
        }
        
        DefaultListModel model = new DefaultListModel();
        for (Men men : list) {
            model.addElement(men.getNameMoto());
        }
        listMen.setModel(model);
        listMen.setPreferredSize(new Dimension(100, 100));
        initWindow();
    }
    
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);    
    }
    
    public void initWindow() {
        setTitle("Equipment");
        setPreferredSize(new Dimension(850, 600));
        setLayout(new BorderLayout());
        createButtonPanel();
        add(panelButton, BorderLayout.SOUTH);
        createLeftPanel();
        add(panelLeft, BorderLayout.WEST);
        createCentrPanel();
        add(panelCentr, BorderLayout.CENTER);
        createTopPanel();
        add(panelTop, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(null);
    }
    
    public void createLeftPanel() {
        listMen.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (listMen.getSelectedValue() != null) {
                    DefaultListModel model = new DefaultListModel();
                    for (Men men : list) {
                        if (listMen.getSelectedValue().toString().equals(men.getNameMoto())) {
                            for (int i = 0; i < men.getAllEquipment().size(); i++) {
                                model.addElement(men.getAllEquipment().get(i).getName() + "; Price= " + men.getAllEquipment().get(i).getPrice());
                            }
                            listEquipment.setModel(model);
                            listEquipment.setPreferredSize(new Dimension(100, 100));
                        }
                    }
                }
            }
        });
        JScrollPane pane = new JScrollPane(listMen);
        panelLeft.setLayout(new GridLayout(1, 1));
        panelLeft.add(pane);
        
    }
    
    public void createTopPanel() {
        panelTop.setLayout(new GridLayout(1, 3));
        panelTop.add(textMinPrice);
        panelTop.add(textMaxPrice);
        panelTop.add(find);
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String priceMin = textMinPrice.getText();
                final String priceMax = textMaxPrice.getText();
                DefaultListModel model = new DefaultListModel();
                for (Men men : list) {
                    if (listMen.getSelectedValue().toString().equals(men.getNameMoto())) {
                        List<Equipment> list2 = SortAndFind.findEquipment(Integer.parseInt(priceMin), Integer.parseInt(priceMax), men.getAllEquipment());
                        for (Equipment item : list2) {
                            model.addElement(item);
                        }
                    }
                   
                    listFindEquipment.setPreferredSize(new Dimension(100, 100));
                }
                
                listFindEquipment.setModel(model);
                
            }
        });
    }
    
    
    public void createCentrPanel() {
        JScrollPane pane = new JScrollPane(listEquipment);
        JScrollPane bane = new JScrollPane(listFindEquipment);
        panelCentr.setLayout(new GridLayout(1, 2));
        panelCentr.add(pane);
        panelCentr.add(bane);
    }
    
    public void createButtonPanel() {
        panelButton.setLayout(new GridLayout(1, 2));
        panelButton.add(buttonAdd);
        panelButton.add(buttonRemove);
        panelButton.add(buttonSort);
        panelButton.add(buttonExit);
        buttonSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) listEquipment.getModel();
                List<Equipment> list1 = new ArrayList();
                for (Men men : list) {
                    if (listMen.getSelectedValue().toString().equals(men.getNameMoto())) {
                        list1 = SortAndFind.sortWeight(men.getAllEquipment());
                        break;
                    }
                }
                model.clear();
                for (Equipment item : list1) {
                    model.addElement(item.getName() + " Price= " + item.getPrice()+" Width= "+item.getWeight());
                }
                listEquipment.setModel(model);
            }
        });
        
        buttonAdd.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                for (Men men : list) {
                    if (listMen.getSelectedValue().toString().equals(men.getNameMoto())) {
                        DefaultListModel model = (DefaultListModel) listEquipment.getModel();
                        Dialog d = new AddWindow(men, model);
                        break;
                    }
                }
                
            }
        });
        buttonRemove.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listEquipment.getSelectedIndex() >= 0) {
                    list.get(listMen.getSelectedIndex()).removeEquipment(listEquipment.getSelectedIndex());
                    DefaultListModel model = (DefaultListModel) listEquipment.getModel();
                    model.removeElementAt(listEquipment.getSelectedIndex());
                } else {
                    JOptionPane.showMessageDialog(null, "Choose item to remove");
                }
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }
    
    public static List<Equipment> createEquipmentList() {
        Random r = new Random();
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
        int first = r.nextInt(list.size() / 2);
        int second = r.nextInt(list.size() / 2) + list.size() / 2 - 1;
        return list.subList(first, second);
    }
}
