package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;

public class invDelivery extends JPanel implements ActionListener {

    private DefaultTableModel model;
    private JTable deliveryTable;
    private JPanel panelFunctionMenu, panelDeliveryTable, panelDate, panelTime, panelAdd, panelModify;
    private JLabel lblDate, lblTime, lblAddItemID, lblAddName, lblAddQuantity, lblAddCategory, lblAddMeasurement, 
                   lblAddDeliveryID, lblAddExpirationDate, lblAddDeliveryDate, lblAddDeliveryTime, lblAddDeliveryCourier;
    private JComboBox cbAddCategory, cbAddMeasurement;
    private JButton btnAdd, btnModify, btnRemove;
    private JTextField txtAddItemID, txtAddName, txtAddQuantity, txtAddDeliveryID, txtAddExpirationDate, txtAddDeliveryDate, txtAddDeliveryTime, txtAddDeliveryCourier ;
    private ArrayList<invItem> deliveryList = new ArrayList<>();
    
    public invDelivery() {

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));

        functionMenu();
    }

    private void functionMenu() {

        panelFunctionMenu = new JPanel();
        panelFunctionMenu.setBounds(0, 0, 980, 720);
        panelFunctionMenu.setBackground(Color.decode("#FFF8E1"));
        panelFunctionMenu.setLayout(null);

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");

        panelDate = new JPanel();
        panelDate.setBounds(25, 25, 400, 50);
        panelDate.setBackground(Color.decode("#1b4a62"));

        lblDate = new JLabel("Date: " + now.format(dateFormat));
        lblDate.setForeground(Color.WHITE);
        lblDate.setFont(new Font("Arial", Font.BOLD, 35));

        panelDate.add(lblDate);

        panelTime = new JPanel();
        panelTime.setBounds(521, 25, 400, 50);
        panelTime.setBackground(Color.decode("#1b4a62"));

        lblTime = new JLabel("Time: " + now.format(timeFormat));
        lblTime.setForeground(Color.WHITE);
        lblTime.setFont(new Font("Arial", Font.BOLD, 35));

        panelTime.add(lblTime);

        panelDeliveryTable = new JPanel(new BorderLayout());
        panelDeliveryTable.setBounds(25, 100, 900, 400);
        panelDeliveryTable.setBackground(Color.decode("#f5cfba"));

        model = new DefaultTableModel();

        model.addColumn("DELIVERY ID");
        model.addColumn("ITEM ID");
        model.addColumn("ITEM NAME");
        model.addColumn("QUANTITY");
        model.addColumn("CATEGORY");
        model.addColumn("MEASUREMENT");
        model.addColumn("EXPIRATION DATE");
        model.addColumn("DATE");
        model.addColumn("TIME");
        model.addColumn("COURIER");

        deliveryTable = new JTable(model);
        deliveryTable.setDefaultEditor(Object.class, null);
        deliveryTable.getTableHeader().setBackground(Color.decode("#1b4a62"));
        deliveryTable.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(deliveryTable);
        panelDeliveryTable.add(scrollPane, BorderLayout.CENTER);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(215, 550, 150, 30);
        btnModify = new JButton("MODIFY");
        btnModify.setBounds(415, 550, 150, 30);
        btnRemove = new JButton("REMOVE");
        btnRemove.setBounds(615, 550, 150, 30);

        stylebtnFunction(btnAdd);
        stylebtnFunction(btnModify);
        stylebtnFunction(btnRemove);

        btnAdd.addActionListener(this);
        btnModify.addActionListener(this);
        btnRemove.addActionListener(this);

        panelFunctionMenu.add(panelDate);
        panelFunctionMenu.add(panelTime);
        panelFunctionMenu.add(panelDeliveryTable);

        panelFunctionMenu.add(btnAdd);
        panelFunctionMenu.add(btnModify);
        panelFunctionMenu.add(btnRemove);

        add(panelFunctionMenu);
    }

    private void stylebtnFunction(JButton btn) {
        btn.setBackground(Color.decode("#e7191f"));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(Color.decode("#b71c1c"));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(Color.decode("#e7191f"));
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAdd) {
            panelAdd = new JPanel(new GridLayout(10, 2, 5, 5));

            lblAddDeliveryID = new JLabel("Delivery ID:");
            txtAddDeliveryID = new JTextField();

            lblAddItemID = new JLabel("Item ID (e.g DV1001):");
            txtAddItemID = new JTextField();

            lblAddName = new JLabel("Item Name:");
            txtAddName = new JTextField();

            lblAddQuantity = new JLabel("Quantity:");
            txtAddQuantity = new JTextField();

            lblAddCategory = new JLabel("Category:");
            String[] categories = {"MEAT", "SEASONING", "VEGETABLE", "CONDIMENTS", "OTHERS"};
            cbAddCategory = new JComboBox<>(categories);

            lblAddMeasurement = new JLabel("Measurement:");
            String[] measurements = {"KG", "LITER", "PACK"};
            cbAddMeasurement = new JComboBox<>(measurements);

            lblAddExpirationDate = new JLabel("Expiration Date:");
            txtAddExpirationDate = new JTextField();

            lblAddDeliveryDate = new JLabel("Delivery Date:");
            txtAddDeliveryDate = new JTextField();

            lblAddDeliveryTime = new JLabel("Delivery Time:");
            txtAddDeliveryTime = new JTextField();

            lblAddDeliveryCourier = new JLabel("Courier:");
            txtAddDeliveryCourier = new JTextField();
            
            panelAdd.add(lblAddDeliveryID);
            panelAdd.add(txtAddDeliveryID);

            panelAdd.add(lblAddItemID);
            panelAdd.add(txtAddItemID);

            panelAdd.add(lblAddName);
            panelAdd.add(txtAddName);

            panelAdd.add(lblAddQuantity);
            panelAdd.add(txtAddQuantity);

            panelAdd.add(lblAddCategory);
            panelAdd.add(cbAddCategory);

            panelAdd.add(lblAddMeasurement);
            panelAdd.add(cbAddMeasurement);

            panelAdd.add(lblAddExpirationDate);
            panelAdd.add(txtAddExpirationDate);

            panelAdd.add(lblAddDeliveryDate);
            panelAdd.add(txtAddDeliveryDate);

            panelAdd.add(lblAddDeliveryTime);
            panelAdd.add(txtAddDeliveryTime);

            panelAdd.add(lblAddDeliveryCourier);
            panelAdd.add(txtAddDeliveryCourier);
            
            int userConfirm = JOptionPane.showConfirmDialog(this,panelAdd,"Add Delivery",JOptionPane.OK_CANCEL_OPTION);
                    
            if (userConfirm == JOptionPane.OK_OPTION){
                String inputDeliveryID = txtAddDeliveryID.getText().trim();
                String inputItemID = txtAddItemID.getText().trim();
                String inputItemName = txtAddName.getText().trim();
                String inputItemQuantity = txtAddQuantity.getText().trim();
                String inputItemCategory = cbAddCategory.getSelectedItem().toString();
                String inputItemMeasurement = cbAddMeasurement.getSelectedItem().toString();
                String inputItemExpiration = txtAddExpirationDate.getText().trim();
                String inputDeliveryDate = txtAddDeliveryDate.getText().trim();
                String inputDeliveryTime = txtAddDeliveryTime.getText().trim();
                String inputDeliveryCourier = txtAddDeliveryCourier.getText().trim();
                
                if (!inputDeliveryID.isEmpty() && !inputItemID.isEmpty() && !inputItemName.isEmpty() && !inputItemQuantity.isEmpty()){
                
                    try {
                        
                    double inputItemQuantityDouble = Double.parseDouble(inputItemQuantity);
                    int inputItemINTExpiration = Integer.parseInt(inputItemExpiration);
                    int inputDeliveryINTDate = Integer.parseInt(inputDeliveryDate);
                    int inputDeliveryINTTime = Integer.parseInt(inputDeliveryTime);

                    if (inputItemQuantityDouble <= 0) {
                    JOptionPane.showMessageDialog(this,"Quantity must be over 0","Add Delivery | Error",JOptionPane.ERROR_MESSAGE);
                    return;
                    }
                    
                    else {
                        
                    invItem item = new invItem(inputItemID,inputItemName,inputItemQuantityDouble,inputItemCategory,inputItemMeasurement,inputDeliveryID,inputItemExpiration,inputDeliveryDate,inputDeliveryTime,inputDeliveryCourier, "");

                    deliveryList.add(item);
                    
                    model.addRow(new Object[]{
                            inputDeliveryID,
                            inputItemID,
                            inputItemName,
                            inputItemQuantityDouble,
                            inputItemCategory,
                            inputItemMeasurement,
                            inputItemINTExpiration,
                            inputDeliveryINTDate,
                            inputDeliveryINTTime,
                            inputDeliveryCourier
                    });

                    JOptionPane.showMessageDialog(this,"Delivery added successfully","Add Delivery",JOptionPane.INFORMATION_MESSAGE);
                }
                                    }
                    
                    
                    
                    catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Quantity must be a valid number", "Add Delivery | Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                else {
                    JOptionPane.showMessageDialog(this, "Please enter all fields", "Add Delivery | Error", JOptionPane.ERROR_MESSAGE);

                }
            }
            }
//modify
        else if (e.getSource() == btnModify) {

            int selectedRow = deliveryTable.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this,
                        "Please select a delivery to modify",
                        "Modify | Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else {

            String selectedDeliveryID = (String) model.getValueAt(selectedRow, 0);

            invItem itemToModify = null;

            for (invItem item : deliveryList) {
                if (item.getDeliveryID().equalsIgnoreCase(selectedDeliveryID)) {
                    itemToModify = item;
                    break;
                }
            }

            if (itemToModify == null) {
                JOptionPane.showMessageDialog(this,
                        "Delivery not found","Modify | Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else{
                panelModify = new JPanel(new GridLayout(10, 2, 5, 5));

                txtAddDeliveryID = new JTextField(itemToModify.getDeliveryID());
                txtAddItemID = new JTextField(itemToModify.getItemID());
                txtAddName = new JTextField(itemToModify.getItemName());
                txtAddQuantity = new JTextField(String.valueOf(itemToModify.getItemQuantity()));

                String[] categories = {"MEAT", "SEASONING", "VEGETABLE", "CONDIMENTS", "OTHERS"};
                cbAddCategory = new JComboBox<>(categories);
                cbAddCategory.setSelectedItem(itemToModify.getItemCategory());

                String[] measurements = {"KG", "LITER", "PACK"};
                cbAddMeasurement = new JComboBox<>(measurements);
                cbAddMeasurement.setSelectedItem(itemToModify.getItemMeasurement());

                txtAddExpirationDate = new JTextField(itemToModify.getItemExpirationDate());
                txtAddDeliveryDate = new JTextField(itemToModify.getItemDeliveryDate());
                txtAddDeliveryTime = new JTextField(itemToModify.getItemDeliveryTime());
                txtAddDeliveryCourier = new JTextField(itemToModify.getItemDeliveryCourier());

                panelModify.add(new JLabel("Delivery ID:"));
                panelModify.add(txtAddDeliveryID);

                panelModify.add(new JLabel("Item ID:"));
                panelModify.add(txtAddItemID);

                panelModify.add(new JLabel("Item Name:"));
                panelModify.add(txtAddName);

                panelModify.add(new JLabel("Quantity:"));
                panelModify.add(txtAddQuantity);

                panelModify.add(new JLabel("Category:"));
                panelModify.add(cbAddCategory);

                panelModify.add(new JLabel("Measurement:"));
                panelModify.add(cbAddMeasurement);

                panelModify.add(new JLabel("Expiration Date:"));
                panelModify.add(txtAddExpirationDate);

                panelModify.add(new JLabel("Delivery Date:"));
                panelModify.add(txtAddDeliveryDate);

                panelModify.add(new JLabel("Delivery Time:"));
                panelModify.add(txtAddDeliveryTime);

                panelModify.add(new JLabel("Courier:"));
                panelModify.add(txtAddDeliveryCourier);

                int result = JOptionPane.showConfirmDialog(this,panelModify,"Modify Delivery",JOptionPane.OK_CANCEL_OPTION
                );

                if (result != JOptionPane.OK_OPTION) {
                    return;
                }
                
                else {
                    String newDeliveryID = txtAddDeliveryID.getText().trim();
                    String newItemID = txtAddItemID.getText().trim();
                    String newItemName = txtAddName.getText().trim();
                    String newQuantity = txtAddQuantity.getText().trim();

                    String newItemCategory = cbAddCategory.getSelectedItem().toString();
                    String newItemMeasurement = cbAddMeasurement.getSelectedItem().toString();

                    String newItemExpiration = txtAddExpirationDate.getText().trim();
                    String newDeliveryDate = txtAddDeliveryDate.getText().trim();
                    String newDeliveryTime = txtAddDeliveryTime.getText().trim();
                    String newDeliveryCourier = txtAddDeliveryCourier.getText().trim();

                    
                    
                    try {
                        double inputItemQuantityDouble = Double.parseDouble(newQuantity);
                        int inputItemINTExpiration = Integer.parseInt(newItemExpiration);
                        int inputDeliveryINTDate = Integer.parseInt(newDeliveryDate);
                        int inputDeliveryINTTime = Integer.parseInt(newDeliveryTime); // FIXED

                        if (inputItemQuantityDouble <= 0) {
                            JOptionPane.showMessageDialog(this,
                                    "Quantity must be greater than 0",
                                    "Modify Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        itemToModify.setDeliveryID(newDeliveryID);
                        itemToModify.setItemID(newItemID);
                        itemToModify.setItemName(newItemName);
                        itemToModify.setItemQuantity(inputItemQuantityDouble);
                        itemToModify.setItemCategory(newItemCategory);
                        itemToModify.setItemMeasurement(newItemMeasurement);
                        itemToModify.setExpirationDate(newItemExpiration);
                        itemToModify.setDeliveryDate(newDeliveryDate);
                        itemToModify.setDeliveryTime(newDeliveryTime);
                        itemToModify.setDeliveryCourier(newDeliveryCourier);

                        model.setValueAt(newDeliveryID, selectedRow, 0);
                        model.setValueAt(newItemID, selectedRow, 1);
                        model.setValueAt(newItemName, selectedRow, 2);
                        model.setValueAt(inputItemQuantityDouble, selectedRow, 3);
                        model.setValueAt(newItemCategory, selectedRow, 4);
                        model.setValueAt(newItemMeasurement, selectedRow, 5);
                        model.setValueAt(newItemExpiration, selectedRow, 6);
                        model.setValueAt(newDeliveryDate, selectedRow, 7);
                        model.setValueAt(newDeliveryTime, selectedRow, 8);
                        model.setValueAt(newDeliveryCourier, selectedRow, 9);

                        JOptionPane.showMessageDialog(this,
                                "Delivery modified successfully",
                                "Success",
                                JOptionPane.INFORMATION_MESSAGE);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this,
                                "Quantity must be a valid number",
                                "Modify Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
        }
            }
        }
        }
        
        //remove
        else if (e.getSource() == btnRemove) {
            
            int selectedRow = deliveryTable.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this,"Please select a delivery to remove","Remove Delivery| Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete this delivery?","Remove Delivery",JOptionPane.YES_NO_OPTION);

            if (confirm != JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(this,"It seem you cancelled this function","Remove Delivery| Error",JOptionPane.ERROR_MESSAGE);

                return;
            }

            else{
            String selectedDeliveryID = (String) model.getValueAt(selectedRow, 0);

            invItem itemToRemove = null;

            for (invItem item : deliveryList) {
                if (item.getDeliveryID().equalsIgnoreCase(selectedDeliveryID)) {
                    itemToRemove = item;
                    break;
                }  
            }

            if (itemToRemove != null) {
                deliveryList.remove(itemToRemove);
                model.removeRow(selectedRow);

                JOptionPane.showMessageDialog(this,"Delivery removed successfully","Remove Delivery",JOptionPane.INFORMATION_MESSAGE);
                }
            
            else {
                JOptionPane.showMessageDialog(this,"Item not found in list","Remove Delivery | Error",JOptionPane.ERROR_MESSAGE);
                    }
        }
        }
        }
        }
        
    
        
        
        




