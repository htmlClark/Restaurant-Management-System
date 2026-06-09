package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class invListRemove extends JPanel implements ActionListener {

    private JLabel lblID, lblName;
    private JTextField txtID, txtName;
    private JButton btnConfirm;

    public invListRemove()
    {
        functionMenu();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void functionMenu()
    {
        lblID = new JLabel("ID:");
        lblID.setBounds(50, 80, 100, 25);

        txtID = new JTextField();
        txtID.setBounds(150, 80, 200, 25);

        lblName = new JLabel("NAME:");
        lblName.setBounds(50, 130, 100, 25);

        txtName = new JTextField();
        txtName.setBounds(150, 130, 200, 25);

        btnConfirm = new JButton("CONFIRM REMOVE");
        btnConfirm.setBounds(150, 200, 200, 35);
        btnConfirm.setBackground(Color.decode("#B71C1C"));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFocusPainted(false);
        btnConfirm.addActionListener(this);

        add(txtName);
        add(btnConfirm);
        add(lblName);
        add(txtID);
        add(lblID);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}