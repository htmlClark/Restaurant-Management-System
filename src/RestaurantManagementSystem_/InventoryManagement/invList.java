package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class invList extends JPanel implements ActionListener {

    private JTable itemTable;
    private DefaultTableModel model;
    private JPanel panelItemTable, panelStock, panelDelivery;
    private JLabel lblStock1, lblStock2, lblDelivery1, lblDelivery2;
    private JComboBox cbSwitchClass;
    private JButton btnAdd, btnModify, btnRemove;

    public invList()
    {
        functionMenu();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void functionMenu()
    {
        panelStock = new JPanel();
        panelStock.setBounds(25, 25, 280, 80);
        panelStock.setBackground(Color.decode("#1b4a62"));

        lblStock1 = new JLabel("Warning: Low Stocks!");
        lblStock1.setFont(new Font("Arial", Font.BOLD, 14));
        lblStock1.setForeground(Color.WHITE);

        lblStock2 = new JLabel("[!] Pork");
        lblStock2.setFont(new Font("Arial", Font.BOLD, 14));
        lblStock2.setForeground(Color.WHITE);

        panelStock.add(lblStock1);
        panelStock.add(lblStock2);

        panelDelivery = new JPanel();
        panelDelivery.setBounds(325, 25, 280, 80);
        panelDelivery.setBackground(Color.decode("#1b4a62"));

        lblDelivery1 = new JLabel("Latest Delivery:");
        lblDelivery1.setFont(new Font("Arial", Font.BOLD, 14));
        lblDelivery1.setForeground(Color.WHITE);

        lblDelivery2 = new JLabel("1/18/2026");
        lblDelivery2.setFont(new Font("Arial", Font.BOLD, 14));
        lblDelivery2.setForeground(Color.WHITE);

        panelDelivery.add(lblDelivery1);
        panelDelivery.add(lblDelivery2);

        String[] pages = {"INVENTORY", "RECIPE", "DELIVERY"};
        cbSwitchClass = new JComboBox<>(pages);
        cbSwitchClass.setBounds(650, 25, 250, 50);
        cbSwitchClass.addActionListener(e -> {
            String selected = (String) cbSwitchClass.getSelectedItem();
            // TO FIX: switch panels
        });

        panelItemTable = new JPanel(new BorderLayout());
        panelItemTable.setBounds(25, 130, 830, 450);
        panelItemTable.setBackground(Color.decode("#89B7B3"));

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAME");
        model.addColumn("QUANTITY");
        model.addColumn("CATEGORY");
        model.addColumn("MEASUREMENT");

        itemTable = new JTable(model);
        itemTable.setDefaultEditor(Object.class, null);
        itemTable.setBackground(Color.WHITE);
        itemTable.setForeground(Color.BLACK);
        itemTable.getTableHeader().setBackground(Color.decode("#1b4a62"));
        itemTable.getTableHeader().setForeground(Color.WHITE);

        panelItemTable.add(new JScrollPane(itemTable), BorderLayout.CENTER);

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

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(200, 610, 150, 30);
        btnFunction(btnAdd);

        btnModify = new JButton("MODIFY");
        btnModify.setBounds(400, 610, 150, 30);
        btnFunction(btnModify);

        btnRemove = new JButton("REMOVE");
        btnRemove.setBounds(600, 610, 150, 30);
        btnFunction(btnRemove);

        btnAdd.addActionListener(this);
        btnModify.addActionListener(this);
        btnRemove.addActionListener(this);

        add(panelStock);
        add(panelDelivery);
        add(cbSwitchClass);
        add(panelItemTable);
        add(btnAdd);
        add(btnModify);
        add(btnRemove);
    }

    private void btnFunction(JButton btn)
    {
        btn.setBackground(Color.decode("#e7191f"));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btn.setBackground(Color.decode("#b71c1c")); }
            public void mouseExited(MouseEvent e)  { btn.setBackground(Color.decode("#e7191f")); }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnAdd) { }
        else if (e.getSource() == btnModify) { }
        else if (e.getSource() == btnRemove) { }
    }
}