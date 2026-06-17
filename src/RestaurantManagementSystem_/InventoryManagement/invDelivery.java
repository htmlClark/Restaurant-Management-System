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
import java.util.List;
import javax.swing.*;

public class invDelivery extends JPanel implements ActionListener {

    private DefaultTableModel model;
    private JTable deliveryTable;
    private JPanel panelFunctionMenu, panelDeliveryTable, panelDate, panelTime, panelAdd, panelModify;
    private JLabel lblDate, lblTime, lblAddItemID, lblAddName, lblAddQuantity, lblAddCategory, lblAddMeasurement,
                   lblAddDeliveryID, lblAddExpirationDate, lblAddDeliveryDate, lblAddDeliveryTime, lblAddDeliveryCourier;
    private JComboBox cbAddCategory, cbAddMeasurement;
    private JButton btnAdd, btnModify, btnRemove;
    private JTextField txtAddName, txtAddQuantity, txtAddExpirationDate, txtAddDeliveryDate, txtAddDeliveryTime, txtAddDeliveryCourier;
    private List<invItem> deliveryList;

    public invDelivery()
    {
        this.deliveryList = InventoryManager.getInstance().getDeliveryList();
        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
        functionMenu();
        loadTableFromList();
    }

    private void loadTableFromList()
    {
        model.setRowCount(0);
        for (invItem item : deliveryList)
        {
            model.addRow(new Object[]{
                item.getDeliveryID(),
                item.getItemID(),
                item.getItemName(),
                item.getItemQuantity(),
                item.getItemCategory(),
                item.getItemMeasurement(),
                item.getItemExpirationDate(),
                item.getItemDeliveryDate(),
                item.getItemDeliveryTime(),
                item.getItemDeliveryCourier()
            });
        }
    }

    private void functionMenu()
    {
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

    private void stylebtnFunction(JButton btn)
    {
        btn.setBackground(Color.decode("#e7191f"));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) { btn.setBackground(Color.decode("#b71c1c")); }
            public void mouseExited(java.awt.event.MouseEvent e)  { btn.setBackground(Color.decode("#e7191f")); }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnAdd)
        {
            String autoDeliveryID = InventoryManager.generateDeliveryID();
            String autoItemID     = InventoryManager.generateItemID();

            panelAdd = new JPanel(new GridLayout(10, 2, 5, 5));

            lblAddDeliveryID = new JLabel("Delivery ID (Auto-generated):");
            JLabel lblAutoDeliveryID = new JLabel(autoDeliveryID);
            lblAutoDeliveryID.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 13));

            lblAddItemID = new JLabel("Item ID (Auto-generated):");
            JLabel lblAutoItemID = new JLabel(autoItemID);
            lblAutoItemID.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 13));

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
            panelAdd.add(lblAutoDeliveryID);
            panelAdd.add(lblAddItemID);
            panelAdd.add(lblAutoItemID);
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

            int userConfirm = JOptionPane.showConfirmDialog(this, panelAdd, "Add Delivery", JOptionPane.OK_CANCEL_OPTION);

            if (userConfirm == JOptionPane.OK_OPTION)
            {
                String inputItemName        = txtAddName.getText().trim();
                String inputItemQuantity    = txtAddQuantity.getText().trim();
                String inputItemCategory    = cbAddCategory.getSelectedItem().toString();
                String inputItemMeasurement = cbAddMeasurement.getSelectedItem().toString();
                String inputItemExpiration  = txtAddExpirationDate.getText().trim();
                String inputDeliveryDate    = txtAddDeliveryDate.getText().trim();
                String inputDeliveryTime    = txtAddDeliveryTime.getText().trim();
                String inputDeliveryCourier = txtAddDeliveryCourier.getText().trim();

                if (!inputItemName.isEmpty() && !inputItemQuantity.isEmpty()
                        && !inputItemExpiration.isEmpty()
                        && !inputDeliveryDate.isEmpty() && !inputDeliveryTime.isEmpty()
                        && !inputDeliveryCourier.isEmpty())
                {
                    try
                    {
                        double inputItemQuantityDouble = Double.parseDouble(inputItemQuantity);

                        if (inputItemQuantityDouble <= 0)
                        {
                            JOptionPane.showMessageDialog(this, "Quantity must be over 0", "Add Delivery | Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        else
                        {
                            invItem item = new invItem(autoItemID, inputItemName, inputItemQuantityDouble, inputItemCategory, inputItemMeasurement, autoDeliveryID, inputItemExpiration, inputDeliveryDate, inputDeliveryTime, inputDeliveryCourier, "");

                            deliveryList.add(item);
                            InventoryManager.getInstance().receiveDelivery(item);

                            model.addRow(new Object[]{
                                autoDeliveryID,
                                autoItemID,
                                inputItemName,
                                inputItemQuantityDouble,
                                inputItemCategory,
                                inputItemMeasurement,
                                inputItemExpiration,
                                inputDeliveryDate,
                                inputDeliveryTime,
                                inputDeliveryCourier
                            });

                            JOptionPane.showMessageDialog(this, "Delivery added successfully", "Add Delivery", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(this, "Quantity must be a valid number", "Add Delivery | Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Please enter all fields", "Add Delivery | Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        else if (e.getSource() == btnModify)
        {
            int selectedRow = deliveryTable.getSelectedRow();

            if (selectedRow == -1)
            {
                JOptionPane.showMessageDialog(this, "Please select a delivery to modify", "Modify | Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                String selectedDeliveryID = (String) model.getValueAt(selectedRow, 0);
                invItem itemToModify = null;

                for (invItem item : deliveryList)
                {
                    if (item.getDeliveryID().equalsIgnoreCase(selectedDeliveryID))
                    {
                        itemToModify = item;
                        break;
                    }
                }

                if (itemToModify == null)
                {
                    JOptionPane.showMessageDialog(this, "Delivery not found", "Modify | Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else
                {
                    panelModify = new JPanel(new GridLayout(10, 2, 5, 5));

                    JLabel lblModDeliveryID = new JLabel(itemToModify.getDeliveryID());
                    lblModDeliveryID.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 13));
                    JLabel lblModItemID = new JLabel(itemToModify.getItemID());
                    lblModItemID.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 13));

                    txtAddName          = new JTextField(itemToModify.getItemName());
                    txtAddQuantity      = new JTextField(String.valueOf(itemToModify.getItemQuantity()));

                    String[] categories = {"MEAT", "SEASONING", "VEGETABLE", "CONDIMENTS", "OTHERS"};
                    cbAddCategory = new JComboBox<>(categories);
                    cbAddCategory.setSelectedItem(itemToModify.getItemCategory());

                    String[] measurements = {"KG", "LITER", "PACK"};
                    cbAddMeasurement = new JComboBox<>(measurements);
                    cbAddMeasurement.setSelectedItem(itemToModify.getItemMeasurement());

                    txtAddExpirationDate  = new JTextField(itemToModify.getItemExpirationDate());
                    txtAddDeliveryDate    = new JTextField(itemToModify.getItemDeliveryDate());
                    txtAddDeliveryTime    = new JTextField(itemToModify.getItemDeliveryTime());
                    txtAddDeliveryCourier = new JTextField(itemToModify.getItemDeliveryCourier());

                    panelModify.add(new JLabel("Delivery ID:"));
                    panelModify.add(lblModDeliveryID);
                    panelModify.add(new JLabel("Item ID:"));
                    panelModify.add(lblModItemID);
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

                    int result = JOptionPane.showConfirmDialog(this, panelModify, "Modify Delivery", JOptionPane.OK_CANCEL_OPTION);

                    if (result != JOptionPane.OK_OPTION)
                    {
                        return;
                    }
                    else
                    {
                        String newItemName        = txtAddName.getText().trim();
                        String newQuantity        = txtAddQuantity.getText().trim();
                        String newItemCategory    = cbAddCategory.getSelectedItem().toString();
                        String newItemMeasurement = cbAddMeasurement.getSelectedItem().toString();
                        String newItemExpiration  = txtAddExpirationDate.getText().trim();
                        String newDeliveryDate    = txtAddDeliveryDate.getText().trim();
                        String newDeliveryTime    = txtAddDeliveryTime.getText().trim();
                        String newDeliveryCourier = txtAddDeliveryCourier.getText().trim();

                        // IDs are immutable — keep the originals
                        String keptDeliveryID = itemToModify.getDeliveryID();
                        String keptItemID     = itemToModify.getItemID();

                        try
                        {
                            double inputItemQuantityDouble = Double.parseDouble(newQuantity);

                            if (inputItemQuantityDouble <= 0)
                            {
                                JOptionPane.showMessageDialog(this, "Quantity must be greater than 0", "Modify Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            itemToModify.setItemName(newItemName);
                            itemToModify.setItemQuantity(inputItemQuantityDouble);
                            itemToModify.setItemCategory(newItemCategory);
                            itemToModify.setItemMeasurement(newItemMeasurement);
                            itemToModify.setExpirationDate(newItemExpiration);
                            itemToModify.setDeliveryDate(newDeliveryDate);
                            itemToModify.setDeliveryTime(newDeliveryTime);
                            itemToModify.setDeliveryCourier(newDeliveryCourier);

                            model.setValueAt(keptDeliveryID,         selectedRow, 0);
                            model.setValueAt(keptItemID,             selectedRow, 1);
                            model.setValueAt(newItemName,            selectedRow, 2);
                            model.setValueAt(inputItemQuantityDouble,selectedRow, 3);
                            model.setValueAt(newItemCategory,        selectedRow, 4);
                            model.setValueAt(newItemMeasurement,     selectedRow, 5);
                            model.setValueAt(newItemExpiration,      selectedRow, 6);
                            model.setValueAt(newDeliveryDate,        selectedRow, 7);
                            model.setValueAt(newDeliveryTime,        selectedRow, 8);
                            model.setValueAt(newDeliveryCourier,     selectedRow, 9);

                            JOptionPane.showMessageDialog(this, "Delivery modified successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (NumberFormatException ex)
                        {
                            JOptionPane.showMessageDialog(this, "Quantity must be a valid number", "Modify Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }

        else if (e.getSource() == btnRemove)
        {
            int selectedRow = deliveryTable.getSelectedRow();

            if (selectedRow == -1)
            {
                JOptionPane.showMessageDialog(this, "Please select a delivery to remove", "Remove Delivery | Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this delivery?", "Remove Delivery", JOptionPane.YES_NO_OPTION);

            if (confirm != JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(this, "It seems you cancelled this function", "Remove Delivery | Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                String selectedDeliveryID = (String) model.getValueAt(selectedRow, 0);
                invItem itemToRemove = null;

                for (invItem item : deliveryList)
                {
                    if (item.getDeliveryID().equalsIgnoreCase(selectedDeliveryID))
                    {
                        itemToRemove = item;
                        break;
                    }
                }

                if (itemToRemove != null)
                {
                    deliveryList.remove(itemToRemove);
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Delivery removed successfully", "Remove Delivery", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Item not found in list", "Remove Delivery | Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}