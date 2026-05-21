//package restaurantmanagementsystem;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//
//public class invDeliveryAdd extends JFrame implements ActionListener {
//
//    private JPanel panelHeaderLogo, panelDashboard, panelFunctionMenu;
//    private JLabel lblLogo, lblDeliveryID, lblItemID, lblQuantity, lblMeasurement,
//                   lblExpirationDate, lblDate, lblTime, lblCourier, lblCategory;
//
//    private JTextField txtDeliveryID, txtItemID, txtQuantity, txtExpirationDate, txtDate, txtTime, txtCourier;
//    private JComboBox cbMeasurement, cbCategory;
//    private JButton btnAdd;
//
//    invDeliveryAdd() {
//
//        headerLogo();
//        dashboardMenu();
//        functionMenu();
//
//        setTitle("Add Delivery");
//        setSize(750, 500);
//        setLayout(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setResizable(false);
//        setVisible(true);
//    }
//
//    private void headerLogo() {
//        panelHeaderLogo = new JPanel();
//        panelHeaderLogo.setBounds(0, 0, 250, 75);
//        panelHeaderLogo.setBackground(Color.decode("#B71C1C"));
//        panelHeaderLogo.setLayout(null);
//        add(panelHeaderLogo);
//
//        ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
//        Image logo = icon.getImage().getScaledInstance(250, 75, Image.SCALE_SMOOTH);
//        lblLogo = new JLabel(new ImageIcon(logo));
//        lblLogo.setBounds(0, 0, 250, 75);
//
//        panelHeaderLogo.add(lblLogo);
//    }
//
//    private void dashboardMenu() {
//        panelDashboard = new JPanel();
//        panelDashboard.setBounds(250, 0, 500, 75);
//        panelDashboard.setBackground(Color.decode("#B71C1C"));
//        panelDashboard.setLayout(null);
//        add(panelDashboard);
//    }
//
//    private void functionMenu() {
//
//        panelFunctionMenu = new JPanel();
//        panelFunctionMenu.setBounds(0, 75, 750, 450);
//        panelFunctionMenu.setBackground(Color.decode("#FFF8E1"));
//        panelFunctionMenu.setLayout(null);
//        add(panelFunctionMenu);
//
//        lblDeliveryID = new JLabel("DELIVERY ID:");
//        lblDeliveryID.setBounds(20, 20, 120, 25);
//
//        txtDeliveryID = new JTextField();
//        txtDeliveryID.setBounds(150, 20, 150, 25);
//
//        lblItemID = new JLabel("ITEM ID:");
//        lblItemID.setBounds(20, 60, 120, 25);
//
//        txtItemID = new JTextField();
//        txtItemID.setBounds(150, 60, 150, 25);
//
//        lblQuantity = new JLabel("QUANTITY:");
//        lblQuantity.setBounds(20, 100, 120, 25);
//
//        txtQuantity = new JTextField();
//        txtQuantity.setBounds(150, 100, 150, 25);
//
//        lblCategory = new JLabel("CATEGORY:");
//        lblCategory.setBounds(20, 140, 120, 25);
//
//        String[] categories = {
//            "MEAT", "VEGETABLE", "SEAFOOD",
//            "SEASONING", "CONDIMENT", "DAIRY"
//        };
//
//        cbCategory = new JComboBox<>(categories);
//        cbCategory.setBounds(150, 140, 150, 25);
//
//        lblMeasurement = new JLabel("MEASUREMENT:");
//        lblMeasurement.setBounds(350, 20, 120, 25);
//
//        String[] measurements = {"KG", "GRAM", "PACK", "BOTTLE", "BOX", "PIECE"};
//        cbMeasurement = new JComboBox<>(measurements);
//        cbMeasurement.setBounds(470, 20, 150, 25);
//
//        lblExpirationDate = new JLabel("EXPIRATION DATE:");
//        lblExpirationDate.setBounds(350, 60, 150, 25);
//
//        txtExpirationDate = new JTextField();
//        txtExpirationDate.setBounds(470, 60, 150, 25);
//
//        lblDate = new JLabel("DATE:");
//        lblDate.setBounds(350, 100, 120, 25);
//
//        txtDate = new JTextField();
//        txtDate.setBounds(470, 100, 150, 25);
//
//        lblTime = new JLabel("TIME:");
//        lblTime.setBounds(350, 140, 120, 25);
//
//        txtTime = new JTextField();
//        txtTime.setBounds(470, 140, 150, 25);
//
//        lblCourier = new JLabel("COURIER:");
//        lblCourier.setBounds(20, 180, 120, 25);
//
//        txtCourier = new JTextField();
//        txtCourier.setBounds(150, 180, 150, 25);
//
//        btnAdd = new JButton("ADD");
//        btnAdd.setBounds(250, 220, 200, 35);
//        btnAdd.setBackground(Color.decode("#B71C1C"));
//        btnAdd.setForeground(Color.WHITE);
//        btnAdd.setFocusPainted(false);
//
//        panelFunctionMenu.add(lblDeliveryID);
//        panelFunctionMenu.add(txtDeliveryID);
//        panelFunctionMenu.add(lblItemID);
//        panelFunctionMenu.add(txtItemID);
//        panelFunctionMenu.add(lblQuantity);
//        panelFunctionMenu.add(txtQuantity);
//        panelFunctionMenu.add(lblCategory);
//        panelFunctionMenu.add(cbCategory);
//        panelFunctionMenu.add(lblMeasurement);
//        panelFunctionMenu.add(cbMeasurement);
//        panelFunctionMenu.add(lblExpirationDate);
//        panelFunctionMenu.add(txtExpirationDate);
//        panelFunctionMenu.add(lblDate);
//        panelFunctionMenu.add(txtDate);
//        panelFunctionMenu.add(lblTime);
//        panelFunctionMenu.add(txtTime);
//        panelFunctionMenu.add(lblCourier);
//        panelFunctionMenu.add(txtCourier);
//        panelFunctionMenu.add(btnAdd);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//    }
//}