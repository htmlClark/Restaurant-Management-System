package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class invDelivery extends JPanel implements ActionListener {

    private DefaultTableModel model;
    private JTable deliveryTable;
    private JPanel panelDeliveryTable, panelDate, panelTime;
    private JLabel lblDate, lblTime;
    private JComboBox cbSwitchClass;
    private JButton btnAdd, btnModify, btnRemove;

    public invDelivery()
    {
        functionMenu();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void functionMenu()
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");

        String date = now.format(dateFormat);
        String time = now.format(timeFormat);

        panelDate = new JPanel();
        panelDate.setBounds(25, 25, 250, 50);
        panelDate.setBackground(Color.decode("#1b4a62"));

        lblDate = new JLabel("Date: " + date);
        lblDate.setForeground(Color.WHITE);
        lblDate.setFont(new Font("Arial", Font.BOLD, 18));
        panelDate.add(lblDate);

        panelTime = new JPanel();
        panelTime.setBounds(295, 25, 250, 50);
        panelTime.setBackground(Color.decode("#1b4a62"));

        lblTime = new JLabel("Time: " + time);
        lblTime.setForeground(Color.WHITE);
        lblTime.setFont(new Font("Arial", Font.BOLD, 18));
        panelTime.add(lblTime);

        String[] pages = {"DELIVERY", "INVENTORY", "RECIPE"};
        cbSwitchClass = new JComboBox<>(pages);
        cbSwitchClass.setBounds(650, 25, 250, 50);
        cbSwitchClass.addActionListener(e -> {
            String selected = (String) cbSwitchClass.getSelectedItem();
            // TO FIX: switch panels
        });

        panelDeliveryTable = new JPanel(new BorderLayout());
        panelDeliveryTable.setBounds(25, 100, 830, 400);
        panelDeliveryTable.setBackground(Color.decode("#f5cfba"));

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

        model.addRow(new Object[]{"DV001", "IT001", "GROUND PORK", "20", "MEAT", "KG", "01/25/2026", "01/17/2026", "04:45 AM", "XANE'S MEATSHOP"});
        model.addRow(new Object[]{"DV002", "IT002", "PORK BELLY", "15", "MEAT", "KG", "01/25/2026", "01/17/2026", "04:45 AM", "XANE'S MEATSHOP"});
        model.addRow(new Object[]{"DV003", "IT023", "SALT", "5", "SEASONING", "KG", "04/10/2027", "01/18/2026", "15:37 PM", "RHOXSEASONING"});

        deliveryTable = new JTable(model);
        deliveryTable.setDefaultEditor(Object.class, null);
        deliveryTable.setBackground(Color.WHITE);
        deliveryTable.setForeground(Color.BLACK);
        deliveryTable.getTableHeader().setBackground(Color.decode("#1b4a62"));
        deliveryTable.getTableHeader().setForeground(Color.WHITE);

        panelDeliveryTable.add(new JScrollPane(deliveryTable), BorderLayout.CENTER);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(200, 530, 150, 30);
        stylebtnFunction(btnAdd);

        btnModify = new JButton("MODIFY");
        btnModify.setBounds(400, 530, 150, 30);
        stylebtnFunction(btnModify);

        btnRemove = new JButton("REMOVE");
        btnRemove.setBounds(600, 530, 150, 30);
        stylebtnFunction(btnRemove);

        btnAdd.addActionListener(this);
        btnModify.addActionListener(this);
        btnRemove.addActionListener(this);

        add(panelDate);
        add(panelTime);
        add(cbSwitchClass);
        add(panelDeliveryTable);
        add(btnAdd);
        add(btnModify);
        add(btnRemove);
    }

    private void stylebtnFunction(JButton btn)
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