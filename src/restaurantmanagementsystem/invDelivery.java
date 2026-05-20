
package restaurantmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class invDelivery extends JFrame implements ActionListener{
    
    private DefaultTableModel model;
    private JTable deliveryTable;
    private JPanel panelDashboard, panelHeaderLogo, panelHeaderBar, panelFunctionMenu, panelDeliveryTable, panelDate, panelTime;
    private JLabel lblLogo, lblDate, lblTime;
    private JComboBox cbSwitchClass;
    private JTextField txtFieldSearch;
    private JButton btnAdd, btnModify, btnRemove;
    
    invDelivery()
    {
        
    dashboardMenu();
    headerLogo();
    headerBar();
    functionMenu();
            
    setTitle ("Delivery");
    setSize (1280,800);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(true);
    setVisible(true);
    
    }
    
    
    private void headerLogo() {
        panelHeaderLogo = new JPanel();
        panelHeaderLogo.setBounds(0, 0, 300, 80);
        panelHeaderLogo.setBackground(Color.decode("#B71C1C"));
        panelHeaderLogo.setLayout(null);
        add(panelHeaderLogo);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
        Image logo = icon.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(logo);
        lblLogo = new JLabel(resizedIcon);
        lblLogo.setBounds(0, 0, 300, 80);

        panelHeaderLogo.add(lblLogo);
    }
    
    private void headerBar(){
        panelHeaderBar = new JPanel();
        panelHeaderBar.setBounds(300, 0, 1030, 80);
        panelHeaderBar.setBackground(Color.decode("#f5cfba"));
        panelHeaderBar.setLayout(null);
        add(panelHeaderBar);
        
        txtFieldSearch = new JTextField();
        txtFieldSearch.setBounds(25, 20, 500, 35);
        txtFieldSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        txtFieldSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        txtFieldSearch.setBackground(Color.decode("#FFF8E1"));
        txtFieldSearch.setBorder(null);
        txtFieldSearch.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        panelHeaderBar.add(txtFieldSearch); 
    }
    
    private void dashboardMenu() {
    
        panelDashboard = new JPanel();
        panelDashboard.setBounds(0, 80, 300, 700);
        panelDashboard.setBackground(Color.decode("#366379"));
        panelDashboard.setLayout(null);
        add(panelDashboard);
        
    }
    
    
    
    private void functionMenu(){
        
        panelFunctionMenu = new JPanel();
        panelFunctionMenu.setBounds(250, 75, 1030, 700);
        panelFunctionMenu.setBackground(Color.decode("#FFF8E1"));
        panelFunctionMenu.setLayout(null);
        
        //for date time ito
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");

        String date = now.format(dateFormat);
        String time = now.format(timeFormat);
        
        panelDate = new JPanel();
        panelDate.setBounds(75, 25, 300, 50);
        panelDate.setBackground(Color.decode("#1b4a62"));
        
            lblDate = new JLabel("Date: " + date);
            lblDate.setBounds(30, 30, 200, 30);
            lblDate.setForeground(Color.WHITE);
            lblDate.setFont(new Font("Arial", Font.BOLD, 25));
        
        panelTime = new JPanel();
        panelTime.setBounds(400, 25, 315, 50);
        panelTime.setBackground(Color.decode("#1b4a62"));
        
            lblTime = new JLabel("Time: " + time);
            lblTime.setBounds(30, 30, 200, 30);
            lblTime.setForeground(Color.WHITE);
            lblTime.setFont(new Font("Arial", Font.BOLD, 25));
        
        panelDate.add(lblDate);
        panelTime.add(lblTime);    
            
        String[] pages = {"DELIVERY", "INVENTORY", "RECIPE"};
        cbSwitchClass = new JComboBox<>(pages);
        cbSwitchClass.setBounds(745, 25, 250, 50);
        cbSwitchClass.addActionListener(e -> {
            String selected = (String) cbSwitchClass.getSelectedItem();

            if (selected.equals("INVENTORY")) {
                new invList();
                dispose();
            }
            else if (selected.equals("RECIPE")) {
                new invRecipe();
                dispose();
            }
            else if (selected.equals("DELIVERY")) {
                new invDelivery();
                dispose();
            }
        });
        
        panelDeliveryTable = new JPanel();
        panelDeliveryTable.setBounds (130, 100, 805, 350);
        panelDeliveryTable.setBackground(Color.decode("#f5cfba"));
        panelDeliveryTable.setLayout(new BorderLayout());
        
        model = new DefaultTableModel();
        
        model.addColumn("DELIVERY ID");
        model.addColumn("ITEM ID");
        model.addColumn("ITEM NAME");
        model.addColumn("QUANTITY");
        model.addColumn("CATEGORY");
        model.addColumn("MEASUREMENT");
        model.addColumn("EXPIRATION DATE");
        model.addColumn("DATE");
        model.addColumn("TIME");
        model.addColumn("COURIER");

        /*deliveryID
        deliveryItemName
        deliveryItemQuantity
        deliveryItemCategory
        deliveryItemMeasurement
        deliveryDate
        deliveryTime
        deliveryCourier
        deliveryItemExpirationDate*/
        
        deliveryTable = new JTable (model);
        JScrollPane scrollPane = new JScrollPane(deliveryTable);
        panelDeliveryTable.add(scrollPane, BorderLayout.CENTER);
        deliveryTable.setDefaultEditor(Object.class, null);
        deliveryTable.setBackground(Color.WHITE);
        deliveryTable.setForeground(Color.BLACK);
        deliveryTable.getTableHeader().setBackground(Color.decode("#1b4a62"));
        deliveryTable.getTableHeader().setForeground(Color.WHITE);
        
        
        model.addRow(new Object[]{"DV001", "IT001", "GROUND PORK", "20", "MEAT", "KG", "01/25/2026", "01/17/2026", "04:45 AM", "XANE'S MEATSHOP"});
        model.addRow(new Object[]{"DV002", "IT002", "PORK BELLY", "15", "MEAT", "KG", "01/25/2026", "01/17/2026", "04:45 AM", "XANE'S MEATSHOP"});
        model.addRow(new Object[]{"DV003", "IT023", "SALT", "5", "SEASONING", "KG", "04/10/2027", "01/18/2026", "15:37 PM", "RHOXSEASONING"});
        
               
        btnAdd = new JButton();
        btnAdd.setText("ADD");
        btnAdd.setBounds(250, 600, 150, 30);
        btnAdd.setBackground(Color.LIGHT_GRAY);
        btnAdd.setLayout(null);
        panelFunctionMenu.add(btnAdd);
        
        btnModify = new JButton();
        btnModify.setText("MODIFY");
        btnModify.setBounds(450, 600, 150, 30);
        btnModify.setBackground(Color.LIGHT_GRAY);
        btnModify.setLayout(null);
        panelFunctionMenu.add(btnModify);
        
        btnRemove = new JButton();
        btnRemove.setText("REMOVE");
        btnRemove.setBounds(650, 600, 150, 30);
        btnRemove.setBackground(Color.LIGHT_GRAY);
        btnRemove.setLayout(null);
        panelFunctionMenu.add(btnRemove);
      
        btnAdd.addActionListener(this);
        btnModify.addActionListener(this);
        btnRemove.addActionListener(this);
        
        stylebtnFunction(btnAdd);
        stylebtnFunction(btnModify);
        stylebtnFunction(btnRemove);

        panelFunctionMenu.add(cbSwitchClass);
        panelFunctionMenu.add(panelDate);
        panelFunctionMenu.add(panelTime);
        panelFunctionMenu.add(panelDeliveryTable);
        add(panelFunctionMenu);

    }
    
    private void stylebtnFunction(JButton btn) {
        btn.setBackground(Color.decode("#e7191f"));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent e) {
            btn.setBackground(Color.decode("#b71c1c"));
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            btn.setBackground(Color.decode("#e7191f"));
        }
    });
}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
       
       if (e.getSource() == btnAdd){
            new invDeliveryAdd();
       }
       
       else if (e.getSource() == btnModify){
            new invDeliveryEdit();
       }
       
       else if (e.getSource() == btnRemove){
       new invDeliveryRemove();
       }
        
    }
}
