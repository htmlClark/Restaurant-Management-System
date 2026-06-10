package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class invList extends JPanel implements ActionListener {
    //SYSTEM OBJECTS
    private JTable itemTable;
    private DefaultTableModel model;
    private JPanel panelItemTable, panelStock, panelDelivery, panelAdd;
    private JLabel lblStock1, lblStock2, lblDelivery1, lblDelivery2, lblAddID, lblAddName, lblAddQuantity, lblAddCategory, lblAddMeasurement, lblModify1;
    private JComboBox cbSwitchClass, cbAddCategory, cbAddMeasurement;
    private JButton btnAdd, btnModify, btnRemove;
    private JTextField txtAddID, txtAddName, txtAddQuantity;
    
    
    
    
    //ITEM INFOS
    private ArrayList<invItem> deliveryList = new ArrayList<>();
    
    
    public invList()
    {
        functionMenu();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void functionMenu()
    {
        panelStock = new JPanel();
        panelStock.setBounds(25, 25, 280, 80);
        panelStock.setBackground(Color.decode("#1b4a62"));

        lblStock1 = new JLabel("Warning: Low Stocks!");
        lblStock1.setFont(new Font("Arial", Font.BOLD, 14));
        lblStock1.setForeground(Color.WHITE);

        lblStock2 = new JLabel("[!] Pork");
        lblStock2.setFont(new Font("Arial", Font.BOLD, 14));
        lblStock2.setForeground(Color.WHITE);

        panelStock.add(lblStock1);
        panelStock.add(lblStock2);

        panelDelivery = new JPanel();
        panelDelivery.setBounds(325, 25, 280, 80);
        panelDelivery.setBackground(Color.decode("#1b4a62"));

        lblDelivery1 = new JLabel("Latest Delivery:");
        lblDelivery1.setFont(new Font("Arial", Font.BOLD, 14));
        lblDelivery1.setForeground(Color.WHITE);

        lblDelivery2 = new JLabel("1/18/2026");
        lblDelivery2.setFont(new Font("Arial", Font.BOLD, 14));
        lblDelivery2.setForeground(Color.WHITE);

        panelDelivery.add(lblDelivery1);
        panelDelivery.add(lblDelivery2);

        String[] pages = {"INVENTORY", "RECIPE", "DELIVERY"};
        cbSwitchClass = new JComboBox<>(pages);
        cbSwitchClass.setBounds(690, 25, 250, 50);        

        panelItemTable = new JPanel(new BorderLayout());
        panelItemTable.setBounds(25, 130, 830, 450);
        panelItemTable.setBackground(Color.decode("#89B7B3"));

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAME");
        model.addColumn("QUANTITY");
        model.addColumn("CATEGORY");
        model.addColumn("MEASUREMENT");

        itemTable = new JTable(model);
        itemTable.setDefaultEditor(Object.class, null);
        itemTable.setBackground(Color.WHITE);
        itemTable.setForeground(Color.BLACK);
        itemTable.getTableHeader().setBackground(Color.decode("#1b4a62"));
        itemTable.getTableHeader().setForeground(Color.WHITE);

        panelItemTable.add(new JScrollPane(itemTable), BorderLayout.CENTER);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(200, 610, 150, 30);
        btnFunction(btnAdd);

        btnModify = new JButton("MODIFY");
        btnModify.setBounds(400, 610, 150, 30);
        btnFunction(btnModify);

        btnRemove = new JButton("REMOVE");
        btnRemove.setBounds(600, 610, 150, 30);
        btnFunction(btnRemove);

        btnAdd.addActionListener(this);
        btnModify.addActionListener(this);
        btnRemove.addActionListener(this);

        add(panelStock);
        add(panelDelivery);
        add(cbSwitchClass);
        add(panelItemTable);
        add(btnAdd);
        add(btnModify);
        add(btnRemove);
    }

    private void btnFunction(JButton btn)
    {
        btn.setBackground(Color.decode("#e7191f"));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btn.setBackground(Color.decode("#b71c1c")); }
            public void mouseExited(MouseEvent e)  { btn.setBackground(Color.decode("#e7191f")); }
        });
    }

    @Override
public void actionPerformed(ActionEvent e)
{
    if (e.getSource() == btnAdd) {

        panelAdd = new JPanel(new GridLayout(5, 2, 5, 5));

        lblAddID = new JLabel("ID:");
        txtAddID = new JTextField();

        lblAddName = new JLabel("Name:");
        txtAddName = new JTextField();

        lblAddQuantity = new JLabel("Quantity:");
        txtAddQuantity = new JTextField();

        lblAddCategory = new JLabel("Category:");
        String[] categories = {"MEAT", "SEASONING", "VEGETABLE", "CONDIMENTS", "OTHERS"};
        cbAddCategory = new JComboBox<>(categories);

        lblAddMeasurement = new JLabel("Measurement:");
        String[] measurements = {"KG", "LITER", "PACK"};
        cbAddMeasurement = new JComboBox<>(measurements);

        panelAdd.add(lblAddID);
        panelAdd.add(txtAddID);

        panelAdd.add(lblAddName);
        panelAdd.add(txtAddName);

        panelAdd.add(lblAddQuantity);
        panelAdd.add(txtAddQuantity);

        panelAdd.add(lblAddCategory);
        panelAdd.add(cbAddCategory);

        panelAdd.add(lblAddMeasurement);
        panelAdd.add(cbAddMeasurement);

        int userConfirm = JOptionPane.showConfirmDialog(this, panelAdd, "Add Item", JOptionPane.OK_CANCEL_OPTION);

        if (userConfirm == JOptionPane.OK_OPTION) {

            String inputItemID = txtAddID.getText().trim();
            String inputItemName = txtAddName.getText().trim();
            String inputItemQuantity = txtAddQuantity.getText().trim();
            String inputItemCategory = cbAddCategory.getSelectedItem().toString();
            String inputItemMeasurement = cbAddMeasurement.getSelectedItem().toString();

            if (!inputItemID.isEmpty() && !inputItemName.isEmpty() && !inputItemQuantity.isEmpty()) {
                
                int inputItemINTQuantity;
                try {
                    inputItemINTQuantity = Integer.parseInt(inputItemQuantity);
                }
                
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Quantity must be a number", "Add Item | Error", JOptionPane.ERROR_MESSAGE); 
                    return; 
                }
                
                if (inputItemINTQuantity > 0) {

                        for (invItem item : deliveryList) {
                        if (item.getItemID().equalsIgnoreCase(inputItemID) || item.getItemName().equalsIgnoreCase(inputItemName)) {
                            JOptionPane.showMessageDialog(this,"Item already exists","Add Item | Error",JOptionPane.ERROR_MESSAGE);
                        return;
                        }
                        }

                    invItem item = new invItem(inputItemID,inputItemName,inputItemINTQuantity,inputItemCategory,inputItemMeasurement,"", "", "", "", "");

                    deliveryList.add(item);
                    
                    model.addRow(new Object[]{
                            inputItemID,
                            inputItemName,
                            inputItemINTQuantity,
                            inputItemCategory,
                            inputItemMeasurement
                    });

                    JOptionPane.showMessageDialog(this,"Item added sucessfully","Add Item",JOptionPane.INFORMATION_MESSAGE);
                }
                
                else {
                JOptionPane.showMessageDialog(this,"Item quantity must be greater than ","Add Item | Error",JOptionPane.ERROR_MESSAGE);
            }
            } 
            
            else {
                 JOptionPane.showMessageDialog(this, "Please enter all fields", "Add Item | Error", JOptionPane.ERROR_MESSAGE);

            }
            
        }
        
        else {
            JOptionPane.showMessageDialog(this,"It seems like you cancelled this function. Try again","Add Item | Error",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    //modify

   else if (e.getSource() == btnModify) {

    int userSelectedItem = itemTable.getSelectedRow();

    if (userSelectedItem == -1) {
        JOptionPane.showMessageDialog(this,"Please select an Item to Modify","Modify Item",JOptionPane.ERROR_MESSAGE);
        
        return;
    }

    else {

        String selectedItemID = (String) model.getValueAt(userSelectedItem, 0);

            invItem item = null;

            for (invItem indexItem : deliveryList) {
                if (indexItem.getItemID().equalsIgnoreCase(selectedItemID)) {
                    item = indexItem;
                    break;
                }
            }
             if (item == null) {
                JOptionPane.showMessageDialog(this,"Item not found in inventory","Modify Item",JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            String selectedItemName = item.getItemName();
            int selectedItemQuantity = item.getItemQuantity();

            String newItemName = JOptionPane.showInputDialog(this, "Edit Name:", selectedItemName);
            String newItemQuantity = JOptionPane.showInputDialog(this, "Edit Quantity:", selectedItemQuantity);

            if (newItemName == null || newItemQuantity == null) {
                return;
            }

            int inputItemINTQuantity;

            try {
                inputItemINTQuantity = Integer.parseInt(newItemQuantity);
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,"Quantity must be a valid number!","Modify Item | Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (inputItemINTQuantity <= 0) {
                JOptionPane.showMessageDialog(this,"Invalid input","Modify Item | Error",JOptionPane.ERROR_MESSAGE);
                return;

            }

            else {
                item.setItemName(newItemName.trim());
                item.setItemQuantity(inputItemINTQuantity);

                model.setValueAt(newItemName, userSelectedItem, 1);
                model.setValueAt(inputItemINTQuantity, userSelectedItem, 2);

                JOptionPane.showMessageDialog(this,"Item modified successfully","Modify Item",JOptionPane.INFORMATION_MESSAGE);
            }
        }
}

    else if (e.getSource() == btnRemove) {

        int userSelectedItem = itemTable.getSelectedRow();

        if (userSelectedItem == -1) {
            JOptionPane.showMessageDialog(this,"Please select an Item to Remove","Remove | Error",JOptionPane.ERROR_MESSAGE);
        }

        else {
            int userConfirmation = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete this item?","Remove Item",JOptionPane.YES_NO_OPTION);

            if (userConfirmation == JOptionPane.YES_OPTION) {
                
                String selectedID = (String) model.getValueAt(userSelectedItem,0);
                
                invItem itemToRemove = null;
                
                for (invItem itemIndex : deliveryList) {
                if (itemIndex.getItemID().equalsIgnoreCase(selectedID)){
                    itemToRemove = itemIndex;
                    break;
                }
            }
                if (itemToRemove != null) {
                deliveryList.remove(itemToRemove);
                model.removeRow(userSelectedItem);

                JOptionPane.showMessageDialog(this,"Item removed successfully","Remove Item",JOptionPane.INFORMATION_MESSAGE);
            }
            }

            else {
                JOptionPane.showMessageDialog(this,
                        "It seems like you cancelled to remove item","Remove Item",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
}
