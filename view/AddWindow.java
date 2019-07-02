/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Equipment;
import model.Helmet;
import model.Men;

/**
 *
 * @author ImmolateImprove
 */
public class AddWindow extends JDialog {

    private JPanel labelPanel = new JPanel();
    private JPanel editTextPanel = new JPanel();

    private JLabel labelNameEquipment = new JLabel("Name");
    private JLabel labelPriceEquipment = new JLabel("Price");
    private JLabel labelWidthEquipment = new JLabel("Width");
    private JLabel labelSpecialEquipment = new JLabel("Special");

    JTextField textName = new JTextField();
    JTextField textPrice = new JTextField();
    JTextField textWidth = new JTextField();
    JTextField textSpecial = new JTextField();

    JButton add = new JButton("Add");
    JButton cancel = new JButton("Cancel");

    Men men;
    DefaultListModel listEquipmentModel;

    public AddWindow(Men men1, DefaultListModel listEquipmentModel1) {
        this.men = men1;
        this.listEquipmentModel = listEquipmentModel1;
        setTitle("Add");
        setPreferredSize(new Dimension(450, 250));
        setResizable(false);

        setLayout(new GridLayout(1, 1));
        editTextPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        editTextPanel.setLayout(new GridLayout(5, 2, 5, 5));
        editTextPanel.add(labelNameEquipment);
        editTextPanel.add(textName);
        editTextPanel.add(labelPriceEquipment);
        editTextPanel.add(textPrice);
        editTextPanel.add(labelWidthEquipment);
        editTextPanel.add(textWidth);
        editTextPanel.add(labelSpecialEquipment);
        editTextPanel.add(textSpecial);
        editTextPanel.add(add);
        editTextPanel.add(cancel);
        add(editTextPanel);
        pack();
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                String price = textPrice.getText();
                String width = textWidth.getText();
                String special = textSpecial.getText();
                Equipment p = new Helmet(special, Integer.parseInt(price), Integer.parseInt(width), name);
                men.addEquipment(p);
                listEquipmentModel.addElement(p.getName() +"; Price= "+ p.getPrice()+"; Width= "+p.getWeight());
                dispose();
            }
        });
        setVisible(true);
        setLocationRelativeTo(null);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

}
