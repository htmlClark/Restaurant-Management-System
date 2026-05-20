
package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class inventoryManagement extends JPanel implements ActionListener{
    private JTable itemTable;
    private DefaultTableModel model;
    
    private JPanel panelDashboard, panelHeaderLogo, panelHeaderBar, panelFunctionMenu, panelItemTable;
    private JLabel lblLogo;
    private JTextField txtFieldSearch;
    private JButton btnBack, btnInvMain, btnList, btnRecipe, btnDelivery, btnLogout, btnAdd, btnEdit, btnRemove;
    
    public inventoryManagement()
    {
    headerLogo();
    headerBar();
    functionMenu();

    setBounds (300,80,980,720);
    setLayout(null);
    setBackground(Color.decode("#FFF8E1"));
    }
    
    
    private void headerLogo() {
        panelHeaderLogo = new JPanel();
        panelHeaderLogo.setBounds(0, 0, 250, 75);
        panelHeaderLogo.setBackground(Color.decode("#B71C1C"));
        panelHeaderLogo.setLayout(null);
        add(panelHeaderLogo);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("src_pack/images/logo.png"));
        Image logo = icon.getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(logo);
        lblLogo = new JLabel(resizedIcon);
        lblLogo.setBounds(0, 0, 250, 75);

        panelHeaderLogo.add(lblLogo);
    }
    
    private void headerBar(){
        panelHeaderBar = new JPanel();
        panelHeaderBar.setBounds(250, 0, 1030, 75);
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

    private void functionMenu(){
        panelItemTable = new JPanel();
        panelItemTable.setBounds (275, 100, 975, 575);
        panelItemTable.setBackground(Color.decode("#f5cfba"));
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

        
        add(panelItemTable);

        panelFunctionMenu = new JPanel();
        panelFunctionMenu.setBounds(250, 75, 1030, 700);
        panelFunctionMenu.setBackground(Color.decode("#FFF8E1"));
        panelFunctionMenu.setLayout(null);
        add(panelFunctionMenu);
        
        btnAdd = new JButton();
        btnAdd.setText("ADD");
        btnAdd.setBounds(150, 625, 200, 30);
        btnAdd.setBackground(Color.LIGHT_GRAY);
        btnAdd.setLayout(null);
        panelFunctionMenu.add(btnAdd);
        
        btnEdit = new JButton();
        btnEdit.setText("EDIT");
        btnEdit.setBounds(400, 625, 200, 30);
        btnEdit.setBackground(Color.LIGHT_GRAY);
        btnEdit.setLayout(null);
        panelFunctionMenu.add(btnEdit);
        
        btnRemove = new JButton();
        btnRemove.setText("REMOVE");
        btnRemove.setBounds(650, 625, 200, 30);
        btnRemove.setBackground(Color.LIGHT_GRAY);
        btnRemove.setLayout(null);
        panelFunctionMenu.add(btnRemove);
      
        stylebtnFunction(btnAdd);
        stylebtnFunction(btnEdit);
        stylebtnFunction(btnRemove);
    }
    
    private void styleButton(JButton btn) {
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setForeground(Color.WHITE);

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setOpaque(true);
                btn.setBackground(Color.decode("#1b4a62"));
            }

            public void mouseExited(MouseEvent e) {
                btn.setOpaque(false);
            }
        });
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

         
    }
    
}
