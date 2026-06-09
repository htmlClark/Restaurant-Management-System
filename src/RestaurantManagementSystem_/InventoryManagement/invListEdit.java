package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class invListEdit extends JPanel implements ActionListener {

    private JLabel lblOld, lblName, lblQty, lblCategory, lblMeasurement;
    private JTextField txtOldID, txtName, txtQuantity;
    private JComboBox cbCategory, cbMeasurement;
    private JButton btnEdit;

    public invListEdit()
    {
        functionMenu();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void functionMenu()
    {
        lblOld = new JLabel("OLD ID:");
        lblOld.setBounds(30, 30, 100, 25);

        txtOldID = new JTextField();
        txtOldID.setBounds(120, 30, 150, 25);

        lblName = new JLabel("NAME:");
        lblName.setBounds(30, 90, 100, 25);

        txtName = new JTextField();
        txtName.setBounds(120, 90, 150, 25);

        lblQty = new JLabel("QUANTITY:");
        lblQty.setBounds(30, 140, 100, 25);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(120, 140, 150, 25);

        lblCategory = new JLabel("CATEGORY:");
        lblCategory.setBounds(300, 90, 100, 25);

        String[] categories = {"MEAT", "VEGETABLE", "SEAFOOD", "SEASONING", "CONDIMENT", "DAIRY"};
        cbCategory = new JComboBox<>(categories);
        cbCategory.setBounds(420, 90, 150, 25);

        lblMeasurement = new JLabel("MEASUREMENT:");
        lblMeasurement.setBounds(300, 140, 120, 25);

        String[] measurements = {"KG", "GRAM", "PACK", "BOTTLE", "BOX", "PIECE"};
        cbMeasurement = new JComboBox<>(measurements);
        cbMeasurement.setBounds(420, 140, 150, 25);

        btnEdit = new JButton("EDIT");
        btnEdit.setBounds(300, 200, 120, 30);
        btnEdit.setBackground(Color.decode("#B71C1C"));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(this);

        add(lblOld);         add(txtOldID);
        add(lblName);        add(txtName);
        add(lblQty);         add(txtQuantity);
        add(lblCategory);    add(cbCategory);
        add(lblMeasurement); add(cbMeasurement);
        add(btnEdit);
    }

    @Override
    public void actionPerformed(ActionEvent e) { }
}