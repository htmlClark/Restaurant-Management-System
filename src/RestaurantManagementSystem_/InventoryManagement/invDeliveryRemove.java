package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class invDeliveryRemove extends JPanel implements ActionListener {

    private JLabel lblDeliveryID, lblItemName;
    private JTextField txtDeliveryID, txtItemName;
    private JButton btnDelete;

    public invDeliveryRemove()
    {
        functionMenu();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void functionMenu()
    {
        lblDeliveryID = new JLabel("DELIVERY ID:");
        lblDeliveryID.setBounds(50, 50, 120, 25);

        txtDeliveryID = new JTextField();
        txtDeliveryID.setBounds(180, 50, 200, 25);

        lblItemName = new JLabel("ITEM NAME:");
        lblItemName.setBounds(50, 100, 120, 25);

        txtItemName = new JTextField();
        txtItemName.setBounds(180, 100, 200, 25);

        btnDelete = new JButton("CONFIRM DELETE");
        btnDelete.setBounds(300, 180, 200, 40);
        btnDelete.setBackground(Color.decode("#B71C1C"));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFocusPainted(false);
        btnDelete.addActionListener(this);

        add(lblDeliveryID);
        add(txtDeliveryID);
        add(lblItemName);
        add(txtItemName);
        add(btnDelete);
    }

    @Override
    public void actionPerformed(ActionEvent e) { }
}