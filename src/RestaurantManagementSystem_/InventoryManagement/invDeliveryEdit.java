//package restaurantmanagementsystem;
//
//import java.awt.*;
//import javax.swing.*;
//
//public class invDeliveryEdit extends JFrame {
//
//    private JPanel panelHeaderLogo, panelDashboard, panelFunctionMenu;
//
//    private JLabel lblLogo, lblDeliveryID, lblItemID, lblItemName, lblQty, lblCategory, lblMeasurement, lblExpDate, lblCourier;
//
//    private JTextField txtDeliveryID, txtItemID, txtItemName, txtQty, txtExpDate, txtCourier;
//
//    private JComboBox cbCategory, cbMeasurement;
//
//    private JButton btnEdit;
//
//    invDeliveryEdit() {
//
//        headerLogo();
//        dashboardMenu();
//        functionMenu();
//
//        setTitle("Edit Delivery");
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
//        Image logo = icon.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
//        ImageIcon resizedIcon = new ImageIcon(logo);
//
//        lblLogo = new JLabel(resizedIcon);
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
//
//        lblDeliveryID = new JLabel("OLD DELIVERY ID:");
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
//        lblItemName = new JLabel("ITEM NAME:");
//        lblItemName.setBounds(20, 100, 120, 25);
//
//        txtItemName = new JTextField();
//        txtItemName.setBounds(150, 100, 150, 25);
//
//        lblQty = new JLabel("QUANTITY:");
//        lblQty.setBounds(20, 140, 120, 25);
//
//        txtQty = new JTextField();
//        txtQty.setBounds(150, 140, 150, 25);
//
//        lblCategory = new JLabel("CATEGORY:");
//        lblCategory.setBounds(350, 20, 120, 25);
//
//        cbCategory = new JComboBox<>(new String[]{"MEAT", "VEGETABLE", "SEAFOOD", "SEASONING", "CONDIMENT", "DAIRY"});
//        cbCategory.setBounds(450, 20, 150, 25);
//
//        lblMeasurement = new JLabel("MEASUREMENT:");
//        lblMeasurement.setBounds(350, 60, 120, 25);
//
//        cbMeasurement = new JComboBox<>(new String[]{"KG", "GRAM", "PACK", "BOTTLE", "BOX", "PIECE"});
//        cbMeasurement.setBounds(470, 60, 130, 25);
//
//        lblExpDate = new JLabel("EXPIRATION:");
//        lblExpDate.setBounds(350, 100, 120, 25);
//
//        txtExpDate = new JTextField();
//        txtExpDate.setBounds(450, 100, 150, 25);
//
//        lblCourier = new JLabel("COURIER:");
//        lblCourier.setBounds(350, 140, 120, 25);
//
//        txtCourier = new JTextField();
//        txtCourier.setBounds(450, 140, 150, 25);
//
//        btnEdit = new JButton("EDIT");
//        btnEdit.setBounds(300, 200, 120, 30);
//        btnEdit.setBackground(Color.decode("#B71C1C"));
//        btnEdit.setForeground(Color.WHITE);
//        btnEdit.setFocusPainted(false);
//
//        panelFunctionMenu.add(lblDeliveryID);
//        panelFunctionMenu.add(txtDeliveryID);
//        panelFunctionMenu.add(lblItemID);
//        panelFunctionMenu.add(txtItemID);
//        panelFunctionMenu.add(lblItemName);
//        panelFunctionMenu.add(txtItemName);
//        panelFunctionMenu.add(lblQty);
//        panelFunctionMenu.add(txtQty);
//        panelFunctionMenu.add(lblCategory);
//        panelFunctionMenu.add(cbCategory);
//        panelFunctionMenu.add(lblMeasurement);
//        panelFunctionMenu.add(cbMeasurement);
//        panelFunctionMenu.add(lblExpDate);
//        panelFunctionMenu.add(txtExpDate);
//        panelFunctionMenu.add(lblCourier);
//        panelFunctionMenu.add(txtCourier);
//        panelFunctionMenu.add(btnEdit);
//        add(panelFunctionMenu);
//    }
//}