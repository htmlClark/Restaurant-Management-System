
package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


<<<<<<<< HEAD:src/RestaurantManagementSystem_/InventoryManagement/invList.java
public class invList extends JFrame implements ActionListener{

========
public class inventoryManagement extends JPanel implements ActionListener{
>>>>>>>> master-rms:src/RestaurantManagementSystem_/InventoryManagement/inventoryManagement.java
    private JTable itemTable;
    private DefaultTableModel model;
    
    private JPanel panelDashboard, panelHeaderLogo, panelHeaderBar, panelFunctionMenu, panelItemTable, panelStock, panelDelivery, panelOption;
    private JLabel lblLogo, lblStock1, lblStock2, lblDelivery1, lblDelivery2;
    private JTextField txtFieldSearch;
<<<<<<<< HEAD:src/RestaurantManagementSystem_/InventoryManagement/invList.java
    private JComboBox cbSwitchClass;
    
    private JButton btnAdd, btnModify, btnRemove;
    invList()
========
    private JButton btnBack, btnInvMain, btnList, btnRecipe, btnDelivery, btnLogout, btnAdd, btnEdit, btnRemove;
    
    public inventoryManagement()
>>>>>>>> master-rms:src/RestaurantManagementSystem_/InventoryManagement/inventoryManagement.java
    {
    headerLogo();
    headerBar();
    functionMenu();

    setBounds (300,80,980,720);
    setLayout(null);
<<<<<<<< HEAD:src/RestaurantManagementSystem_/InventoryManagement/invList.java
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
    
========
    setBackground(Color.decode("#FFF8E1"));
>>>>>>>> master-rms:src/RestaurantManagementSystem_/InventoryManagement/inventoryManagement.java
    }
    
    
    private void headerLogo() {
        panelHeaderLogo = new JPanel();
        panelHeaderLogo.setBounds(0, 0, 300, 80);
        panelHeaderLogo.setBackground(Color.decode("#B71C1C"));
        panelHeaderLogo.setLayout(null);
        add(panelHeaderLogo);
        
<<<<<<<< HEAD:src/RestaurantManagementSystem_/InventoryManagement/invList.java
        ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
        Image logo = icon.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
========
        ImageIcon icon = new ImageIcon(getClass().getResource("src_pack/images/logo.png"));
        Image logo = icon.getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH);
>>>>>>>> master-rms:src/RestaurantManagementSystem_/InventoryManagement/inventoryManagement.java
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
<<<<<<<< HEAD:src/RestaurantManagementSystem_/InventoryManagement/invList.java
    
    private void dashboardMenu() {
    
        panelDashboard = new JPanel();
        panelDashboard.setBounds(0, 80, 300, 800);
        panelDashboard.setBackground(Color.decode("#366379"));
        panelDashboard.setLayout(null);
        add(panelDashboard);
  
    }
    
    
========

>>>>>>>> master-rms:src/RestaurantManagementSystem_/InventoryManagement/inventoryManagement.java
    private void functionMenu(){
        panelFunctionMenu = new JPanel();
        panelFunctionMenu.setBounds(300, 80, 1030, 700);
        panelFunctionMenu.setBackground(Color.decode("#FFF8E1"));
        panelFunctionMenu.setLayout(null);
        add(panelFunctionMenu);
        
        panelStock = new JPanel();
        panelStock.setBounds(25, 25, 300, 100);
        panelStock.setBackground(Color.decode("#1b4a62"));
        
        lblStock1 = new JLabel("Warning: Low Stocks!");
        lblStock1.setBounds(25, 25, 200, 30);
        lblStock1.setFont(new Font("Arial", Font.BOLD, 25));
        lblStock1.setForeground(Color.WHITE);
        
        lblStock2 = new JLabel("[!] Pork");
        lblStock2.setBounds(25, 50, 200, 30);
        lblStock2.setFont(new Font("Arial", Font.BOLD, 25));
        lblStock2.setForeground(Color.WHITE);
        
        panelDelivery = new JPanel();
        panelDelivery.setBounds(350, 25, 315, 100);
        panelDelivery.setBackground(Color.decode("#1b4a62"));
        
        lblDelivery1 = new JLabel("Latest Delivery: ");
        lblDelivery1.setBounds(25, 25, 200, 30);
        lblDelivery1.setFont(new Font("Arial", Font.BOLD, 25));
        lblDelivery1.setForeground(Color.WHITE);
        
        lblDelivery2 = new JLabel("1/18/2026");
        lblDelivery2.setBounds(25, 75, 200, 30);
        lblDelivery2.setFont(new Font("Arial", Font.BOLD, 25));
        lblDelivery2.setForeground(Color.WHITE);
        
        String[] pages = {"INVENTORY", "RECIPE", "DELIVERY"};
        cbSwitchClass = new JComboBox<>(pages);
        cbSwitchClass.setBounds(690, 25, 250, 50);
        cbSwitchClass.addActionListener(e -> {
            String selected = (String) cbSwitchClass.getSelectedItem();

            dispose();

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
  
        
        panelItemTable = new JPanel();
        panelItemTable.setBounds (25, 150, 800, 475);
        panelItemTable.setBackground(Color.decode("#89B7B3"));
        panelItemTable.setLayout(new BorderLayout());
        
        model = new DefaultTableModel();
        
        model.addColumn("ID");
        model.addColumn("NAME");
        model.addColumn("QUANTITY");
        model.addColumn("CATEGORY");
        model.addColumn("MEASUREMENT");

        itemTable = new JTable (model);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        panelItemTable.add(scrollPane, BorderLayout.CENTER);
        
        itemTable.setDefaultEditor(Object.class, null);
        itemTable.setBackground(Color.WHITE);
        itemTable.setForeground(Color.BLACK);
        itemTable.getTableHeader().setBackground(Color.decode("#1b4a62"));
        itemTable.getTableHeader().setForeground(Color.WHITE);
        //categories = vegetable, meat, seafood, seasoning, condiments, dairy
        
        //meat models goes here 
        model.addRow(new Object[]{"IT001", "GROUND PORK", "10", "MEAT", "KG"});
        model.addRow(new Object[]{"IT002", "PORK BELLY", "6", "MEAT", "KG"});
        model.addRow(new Object[]{"IT003", "CHICKEN PIECES", "12", "MEAT", "KG"});
        model.addRow(new Object[]{"IT004", "PORK INTESTINES", "5", "MEAT", "KG"});
        model.addRow(new Object[]{"IT005", "FRIED TOFU CUBES", "8", "MEAT", "KG"});
        
        //vegetable models goes here
        model.addRow(new Object[]{"IT006", "CARROTS", "15", "VEGETABLES", "KG"});
        model.addRow(new Object[]{"IT007", "ONIONS", "20", "VEGETABLES", "KG"});
        model.addRow(new Object[]{"IT008", "GARLIC", "25", "VEGETABLES", "KG"});
        model.addRow(new Object[]{"IT009", "EGGPLANT", "10", "VEGETABLES", "KG"});
        model.addRow(new Object[]{"IT010", "AMPALAYA", "8", "VEGETABLES", "KG"});
        model.addRow(new Object[]{"IT011", "OKRA", "12", "VEGETABLES", "KG"});
        model.addRow(new Object[]{"IT012", "SQUASH", "10", "VEGETABLES", "KG"});
        model.addRow(new Object[]{"IT013", "STRING BEANS", "14", "VEGETABLES", "KG"});
        model.addRow(new Object[]{"IT014", "TOMATOES", "18", "VEGETABLES", "KG"});
        model.addRow(new Object[]{"IT015", "CHILI PEPPERS", "5", "VEGETABLES", "KG"});
        model.addRow(new Object[]{"IT016", "GINGER", "7", "VEGETABLES", "KG"});
        model.addRow(new Object[]{"IT017", "TARO LEAVES", "6", "VEGETABLES", "KG"});
        
        //seasoning models goes here
        model.addRow(new Object[]{"IT018", "SALT", "50", "SEASONINGS", "PACK"});
        model.addRow(new Object[]{"IT019", "PEPPER", "40", "SEASONINGS", "PACK"});
        model.addRow(new Object[]{"IT020", "BAY LEAVES", "8", "SEASONINGS", "PACK"});
        model.addRow(new Object[]{"IT021", "PEPPERCORN", "6", "SEASONINGS", "PACK"});
        model.addRow(new Object[]{"IT022", "SUGAR", "35", "SEASONINGS", "KG"});
        model.addRow(new Object[]{"IT023", "BROWN SUGAR", "20", "SEASONINGS", "KG"});
        model.addRow(new Object[]{"IT024", "GINGER POWDER", "10", "SEASONINGS", "KG"});
        
        //condiments models goes here
        model.addRow(new Object[]{"IT025", "SOY SAUCE", "30", "CONDIMENTS", "BOTTLE"});
        model.addRow(new Object[]{"IT026", "VINEGAR", "25", "CONDIMENTS", "BOTTLE"});
        model.addRow(new Object[]{"IT027", "FISH SAUCE", "12", "CONDIMENTS", "BOTTLE"});
        model.addRow(new Object[]{"IT028", "BAGOONG (SHRIMP PASTE)", "10", "CONDIMENTS", "JAR"});
        model.addRow(new Object[]{"IT029", "MAYONNAISE", "8", "CONDIMENTS", "JAR"});
        model.addRow(new Object[]{"IT030", "CALAMANSI JUICE", "15", "CONDIMENTS", "KG"});
        
        //other models goes here
        model.addRow(new Object[]{"IT031", "LUMPIA WRAPPERS", "50", "OTHERS", "PACK"});
        model.addRow(new Object[]{"IT032", "COOKING OIL", "20", "OTHERS", "BOTTLE"});
        model.addRow(new Object[]{"IT033", "TAPIOCA PEARLS (SAGO)", "10", "OTHERS", "PACK"});
        model.addRow(new Object[]{"IT034", "GULAMAN", "12", "OTHERS", "PACK"});
        model.addRow(new Object[]{"IT035", "ICE", "30", "OTHERS", "KG"});
        model.addRow(new Object[]{"IT036", "TEA BAGS", "25", "OTHERS", "BOX"});
        model.addRow(new Object[]{"IT037", "LEMON / CALAMANSI", "15", "OTHERS", "KG"});
        model.addRow(new Object[]{"IT038", "BROWN SUGAR SYRUP (ARNIBAL)", "10", "OTHERS", "BOTTLE"});
        model.addRow(new Object[]{"IT039", "SHAVED ICE", "20", "OTHERS", "KG"});

        //for adding new row
        // model.addRow(new Object[]{"", "", "", "", ""});
        panelFunctionMenu.add(cbSwitchClass);
        panelFunctionMenu.add(panelStock);
        panelFunctionMenu.add(panelDelivery);
        panelFunctionMenu.add(panelItemTable);
        
        panelStock.add(lblStock1);
        panelStock.add(lblStock2);

        panelDelivery.add(lblDelivery1);
        panelDelivery.add(lblDelivery2);

<<<<<<<< HEAD:src/RestaurantManagementSystem_/InventoryManagement/invList.java
========
        
        add(panelItemTable);

        panelFunctionMenu = new JPanel();
        panelFunctionMenu.setBounds(250, 75, 1030, 700);
        panelFunctionMenu.setBackground(Color.decode("#FFF8E1"));
        panelFunctionMenu.setLayout(null);
        add(panelFunctionMenu);
>>>>>>>> master-rms:src/RestaurantManagementSystem_/InventoryManagement/inventoryManagement.java
        
        btnAdd = new JButton();
        btnAdd.setText("ADD");
        btnAdd.setBounds(845, 150, 100, 30);
        btnAdd.setBackground(Color.LIGHT_GRAY);
        btnAdd.setLayout(null);
        panelFunctionMenu.add(btnAdd);
        
        btnModify = new JButton();
        btnModify.setText("MODIFY");
        btnModify.setBounds(845, 200, 100, 30);
        btnModify.setBackground(Color.LIGHT_GRAY);
        btnModify.setLayout(null);
        panelFunctionMenu.add(btnModify);
        
        btnRemove = new JButton();
        btnRemove.setText("REMOVE");
        btnRemove.setBounds(845, 250, 100, 30);
        btnRemove.setBackground(Color.LIGHT_GRAY);
        btnRemove.setLayout(null);
        panelFunctionMenu.add(btnRemove);
     
        btnFunction(btnAdd);
        btnFunction(btnModify);
        btnFunction(btnRemove);
        
        btnAdd.addActionListener(this);
        btnModify.addActionListener(this);
        btnRemove.addActionListener(this);
    }
  
    private void btnFunction(JButton btn) {
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
<<<<<<<< HEAD:src/RestaurantManagementSystem_/InventoryManagement/invList.java
        
       dispose();
       
       if (e.getSource() == btnAdd){
       
       new invListAdd();
       }
       
       else if (e.getSource() == btnModify){
       new invListEdit();
       }
       
       else if (e.getSource() == btnRemove){
       new invListRemove();
       }
========
>>>>>>>> master-rms:src/RestaurantManagementSystem_/InventoryManagement/inventoryManagement.java

         
    }
    
}
