package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class invDeliveryAdd extends JPanel implements ActionListener {

    private JLabel lblDeliveryID, lblItemID, lblQuantity, lblMeasurement,
            lblExpirationDate, lblDate, lblTime, lblCourier, lblCategory;
    private JTextField txtDeliveryID, txtItemID, txtQuantity, txtExpirationDate,
            txtDate, txtTime, txtCourier;
    private JComboBox cbMeasurement, cbCategory;
    private JButton btnAdd;

    public invDeliveryAdd()
    {
        functionMenu();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void functionMenu()
    {
        lblDeliveryID = new JLabel("DELIVERY ID:");
        lblDeliveryID.setBounds(20, 20, 120, 25);

        txtDeliveryID = new JTextField();
        txtDeliveryID.setBounds(150, 20, 150, 25);

        lblItemID = new JLabel("ITEM ID:");
        lblItemID.setBounds(20, 60, 120, 25);

        txtItemID = new JTextField();
        txtItemID.setBounds(150, 60, 150, 25);

        lblQuantity = new JLabel("QUANTITY:");
        lblQuantity.setBounds(20, 100, 120, 25);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(150, 100, 150, 25);

        lblCategory = new JLabel("CATEGORY:");
        lblCategory.setBounds(20, 140, 120, 25);

        String[] categories = {"MEAT", "VEGETABLE", "SEAFOOD", "SEASONING", "CONDIMENT", "DAIRY"};
        cbCategory = new JComboBox<>(categories);
        cbCategory.setBounds(150, 140, 150, 25);

        lblMeasurement = new JLabel("MEASUREMENT:");
        lblMeasurement.setBounds(350, 20, 120, 25);

        String[] measurements = {"KG", "GRAM", "PACK", "BOTTLE", "BOX", "PIECE"};
        cbMeasurement = new JComboBox<>(measurements);
        cbMeasurement.setBounds(470, 20, 150, 25);

        lblExpirationDate = new JLabel("EXPIRATION DATE:");
        lblExpirationDate.setBounds(350, 60, 150, 25);

        txtExpirationDate = new JTextField();
        txtExpirationDate.setBounds(470, 60, 150, 25);

        lblDate = new JLabel("DATE:");
        lblDate.setBounds(350, 100, 120, 25);

        txtDate = new JTextField();
        txtDate.setBounds(470, 100, 150, 25);

        lblTime = new JLabel("TIME:");
        lblTime.setBounds(350, 140, 120, 25);

        txtTime = new JTextField();
        txtTime.setBounds(470, 140, 150, 25);

        lblCourier = new JLabel("COURIER:");
        lblCourier.setBounds(20, 180, 120, 25);

        txtCourier = new JTextField();
        txtCourier.setBounds(150, 180, 150, 25);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(350, 250, 200, 35);
        btnAdd.setBackground(Color.decode("#B71C1C"));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(this);

        add(lblDeliveryID);   add(txtDeliveryID);
        add(lblItemID);       add(txtItemID);
        add(lblQuantity);     add(txtQuantity);
        add(lblCategory);     add(cbCategory);
        add(lblMeasurement);  add(cbMeasurement);
        add(lblExpirationDate); add(txtExpirationDate);
        add(lblDate);         add(txtDate);
        add(lblTime);         add(txtTime);
        add(lblCourier);      add(txtCourier);
        add(btnAdd);
    }

    @Override
    public void actionPerformed(ActionEvent e) { }
}