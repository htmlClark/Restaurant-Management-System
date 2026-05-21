package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class invListAdd extends JFrame implements ActionListener{

    invListAdd(){

    headerLogo();
    dashboardMenu();
    functionMenu();

    setTitle ("Add Item");
    setSize (750,500);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);

    }

    private JPanel panelHeaderLogo, panelDashboard, panelFunctionMenu;
    private JLabel lblLogo, lblID, lblName, lblQuantity, lblCategory, lblMeasurement;
    private JTextField txtID, txtName, txtQuantity;
    private JComboBox cbCategory, cbMeasurement;
    private JButton btnAdd;

    private void headerLogo() {
        panelHeaderLogo = new JPanel();
        panelHeaderLogo.setBounds(0, 0, 250, 75);
        panelHeaderLogo.setBackground(Color.decode("#B71C1C"));
        panelHeaderLogo.setLayout(null);
        add(panelHeaderLogo);

        ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
        Image logo = icon.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(logo);
        lblLogo = new JLabel(resizedIcon);
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

    private void functionMenu(){
        panelFunctionMenu = new JPanel();
        panelFunctionMenu.setBounds(0, 75, 750, 450);
        panelFunctionMenu.setBackground(Color.decode("#FFF8E1"));
        panelFunctionMenu.setLayout(null);
        add(panelFunctionMenu);

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
        btnAdd.setBounds(300, 100, 100, 30);
        btnAdd.setBackground(Color.decode("#B71C1C"));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFocusPainted(false);

        panelFunctionMenu.add(lblID);
        panelFunctionMenu.add(txtID);
        panelFunctionMenu.add(lblName);
        panelFunctionMenu.add(txtName);
        panelFunctionMenu.add(lblQuantity);
        panelFunctionMenu.add(txtQuantity);
        panelFunctionMenu.add(lblCategory);
        panelFunctionMenu.add(cbCategory);
        panelFunctionMenu.add(lblMeasurement);
        panelFunctionMenu.add(cbMeasurement);
        panelFunctionMenu.add(btnAdd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
