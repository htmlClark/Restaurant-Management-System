package restaurantmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class invDeliveryRemove extends JFrame implements ActionListener {

    private JPanel panelHeaderLogo, panelDashboard, panelFunctionMenu;
    private JLabel lblLogo, lblDeliveryID, lblItemName;
    private JTextField txtDeliveryID, txtItemName;
    private JButton btnDelete;

    invDeliveryRemove() {

        headerLogo();
        dashboardMenu();
        functionMenu();

        setTitle("Remove Delivery");
        setSize(750, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void headerLogo() {
        panelHeaderLogo = new JPanel();
        panelHeaderLogo.setBounds(0, 0, 250, 75);
        panelHeaderLogo.setBackground(Color.decode("#B71C1C"));
        panelHeaderLogo.setLayout(null);
        add(panelHeaderLogo);

        ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
        Image logo = icon.getImage().getScaledInstance(250, 75, Image.SCALE_SMOOTH);
        lblLogo = new JLabel(new ImageIcon(logo));
        lblLogo.setBounds(0, 0, 250, 75);

        panelHeaderLogo.add(lblLogo);
    }

    private void dashboardMenu() {
        panelDashboard = new JPanel();
        panelDashboard.setBounds(250, 0, 500, 75);
        panelDashboard.setBackground(Color.decode("#B71C1C"));
        panelDashboard.setLayout(null);
        add(panelDashboard);
    }

    private void functionMenu() {

        panelFunctionMenu = new JPanel();
        panelFunctionMenu.setBounds(0, 75, 750, 450);
        panelFunctionMenu.setBackground(Color.decode("#FFF8E1"));
        panelFunctionMenu.setLayout(null);
        add(panelFunctionMenu);

        lblDeliveryID = new JLabel("DELIVERY ID:");
        lblDeliveryID.setBounds(50, 50, 120, 25);

        txtDeliveryID = new JTextField();
        txtDeliveryID.setBounds(180, 50, 200, 25);

        lblItemName = new JLabel("ITEM NAME:");
        lblItemName.setBounds(50, 100, 120, 25);

        txtItemName = new JTextField();
        txtItemName.setBounds(180, 100, 200, 25);

        btnDelete = new JButton("CONFIRM DELETE");
        btnDelete.setBounds(250, 180, 200, 40);
        btnDelete.setBackground(Color.decode("#B71C1C"));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFocusPainted(false);

        panelFunctionMenu.add(lblDeliveryID);
        panelFunctionMenu.add(txtDeliveryID);
        panelFunctionMenu.add(lblItemName);
        panelFunctionMenu.add(txtItemName);
        panelFunctionMenu.add(btnDelete);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}