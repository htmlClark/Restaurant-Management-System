package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class invDeliveryEdit extends JPanel implements ActionListener {

    private JLabel lblDeliveryID, lblItemID, lblItemName, lblQty,
            lblCategory, lblMeasurement, lblExpDate, lblCourier;
    private JTextField txtDeliveryID, txtItemID, txtItemName, txtQty,
            txtExpDate, txtCourier;
    private JComboBox cbCategory, cbMeasurement;
    private JButton btnEdit;

    public invDeliveryEdit()
    {
        functionMenu();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void functionMenu()
    {
        lblDeliveryID = new JLabel("OLD DELIVERY ID:");
        lblDeliveryID.setBounds(20, 20, 130, 25);

        txtDeliveryID = new JTextField();
        txtDeliveryID.setBounds(160, 20, 150, 25);

        lblItemID = new JLabel("ITEM ID:");
        lblItemID.setBounds(20, 60, 120, 25);

        txtItemID = new JTextField();
        txtItemID.setBounds(160, 60, 150, 25);

        lblItemName = new JLabel("ITEM NAME:");
        lblItemName.setBounds(20, 100, 120, 25);

        txtItemName = new JTextField();
        txtItemName.setBounds(160, 100, 150, 25);

        lblQty = new JLabel("QUANTITY:");
        lblQty.setBounds(20, 140, 120, 25);

        txtQty = new JTextField();
        txtQty.setBounds(160, 140, 150, 25);

        lblCategory = new JLabel("CATEGORY:");
        lblCategory.setBounds(350, 20, 120, 25);

        cbCategory = new JComboBox<>(new String[]{"MEAT", "VEGETABLE", "SEAFOOD", "SEASONING", "CONDIMENT", "DAIRY"});
        cbCategory.setBounds(460, 20, 150, 25);

        lblMeasurement = new JLabel("MEASUREMENT:");
        lblMeasurement.setBounds(350, 60, 120, 25);

        cbMeasurement = new JComboBox<>(new String[]{"KG", "GRAM", "PACK", "BOTTLE", "BOX", "PIECE"});
        cbMeasurement.setBounds(460, 60, 150, 25);

        lblExpDate = new JLabel("EXPIRATION:");
        lblExpDate.setBounds(350, 100, 120, 25);

        txtExpDate = new JTextField();
        txtExpDate.setBounds(460, 100, 150, 25);

        lblCourier = new JLabel("COURIER:");
        lblCourier.setBounds(350, 140, 120, 25);

        txtCourier = new JTextField();
        txtCourier.setBounds(460, 140, 150, 25);

        btnEdit = new JButton("EDIT");
        btnEdit.setBounds(350, 220, 120, 30);
        btnEdit.setBackground(Color.decode("#B71C1C"));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(this);

        add(lblDeliveryID);  add(txtDeliveryID);
        add(lblItemID);      add(txtItemID);
        add(lblItemName);    add(txtItemName);
        add(lblQty);         add(txtQty);
        add(lblCategory);    add(cbCategory);
        add(lblMeasurement); add(cbMeasurement);
        add(lblExpDate);     add(txtExpDate);
        add(lblCourier);     add(txtCourier);
        add(btnEdit);
    }

    @Override
    public void actionPerformed(ActionEvent e) { }
}