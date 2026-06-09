package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class invListAdd extends JPanel implements ActionListener {

    private JLabel lblID, lblName, lblQuantity, lblCategory, lblMeasurement;
    private JTextField txtID, txtName, txtQuantity;
    private JComboBox cbCategory, cbMeasurement;
    private JButton btnAdd;

    public invListAdd()
    {
        functionMenu();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void functionMenu()
    {
        lblID = new JLabel("ID:");
        lblID.setBounds(20, 20, 100, 25);

        txtID = new JTextField();
        txtID.setBounds(120, 20, 150, 25);

        lblName = new JLabel("NAME:");
        lblName.setBounds(20, 60, 100, 25);

        txtName = new JTextField();
        txtName.setBounds(120, 60, 150, 25);

        lblQuantity = new JLabel("QUANTITY:");
        lblQuantity.setBounds(20, 100, 100, 25);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(120, 100, 150, 25);

        lblCategory = new JLabel("CATEGORY:");
        lblCategory.setBounds(300, 20, 100, 25);

        String[] categories = {"MEAT", "VEGETABLE", "SEAFOOD", "SEASONING", "CONDIMENT", "DAIRY"};
        cbCategory = new JComboBox<>(categories);
        cbCategory.setBounds(400, 20, 150, 25);

        lblMeasurement = new JLabel("MEASUREMENT:");
        lblMeasurement.setBounds(300, 60, 120, 25);

        String[] measurements = {"KG", "GRAM", "PACK", "BOTTLE", "BOX", "PIECE"};
        cbMeasurement = new JComboBox<>(measurements);
        cbMeasurement.setBounds(420, 60, 130, 25);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(300, 150, 100, 30);
        btnAdd.setBackground(Color.decode("#B71C1C"));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(this);

        add(lblID);          add(txtID);
        add(lblName);        add(txtName);
        add(lblQuantity);    add(txtQuantity);
        add(lblCategory);    add(cbCategory);
        add(lblMeasurement); add(cbMeasurement);
        add(btnAdd);
    }

    @Override
    public void actionPerformed(ActionEvent e) { }
}