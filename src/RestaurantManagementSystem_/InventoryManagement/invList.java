package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class invList extends JPanel implements ActionListener {
    private JTable itemTable;
    private DefaultTableModel model;
    private JPanel panelItemTable, panelStock;
    private JLabel lblStock1, lblStock2;

    private List<invItem> inventoryList;

    public invList()
    {
        InventoryPopulatedData.loadInventoryData();
        this.inventoryList = InventoryManager.getInstance().getInventoryList();
        functionMenu();
        loadTableFromList();
        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void loadTableFromList()
    {
        model.setRowCount(0);
        for (invItem item : inventoryList)
        {
            model.addRow(new Object[]{
                item.getItemID(),
                item.getItemName(),
                item.getItemQuantity(),
                item.getItemCategory(),
                item.getItemMeasurement(),
                item.getItemCurrentStatus()
            });
        }
    }
    
        public void refreshTable()
    {
        loadTableFromList();
        updateStockStatus();
    }

    private void functionMenu()
    {
        panelStock = new JPanel();
        panelStock.setBounds(25, 25, 450, 100);
        panelStock.setBackground(Color.decode("#1b4a62"));
        panelStock.setLayout(null);

        lblStock1 = new JLabel("");
        lblStock1.setFont(new Font("Arial", Font.BOLD, 25));
        lblStock1.setForeground(Color.WHITE);
        lblStock1.setBounds(10, 10, 280, 30);

        lblStock2 = new JLabel("");
        lblStock2.setFont(new Font("Arial", Font.BOLD, 25));
        lblStock2.setForeground(Color.WHITE);
        lblStock2.setBounds(10, 50, 280, 30);
        
        panelStock.add(lblStock1);
        panelStock.add(lblStock2);

        panelItemTable = new JPanel(new BorderLayout());
        panelItemTable.setBounds(25, 130, 910, 450);
        panelItemTable.setBackground(Color.decode("#89B7B3"));

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAME");
        model.addColumn("QUANTITY");
        model.addColumn("CATEGORY");
        model.addColumn("MEASUREMENT");
        model.addColumn("STATUS");

        itemTable = new JTable(model);
        itemTable.setDefaultEditor(Object.class, null);
        itemTable.setBackground(Color.WHITE);
        itemTable.setForeground(Color.BLACK);
        itemTable.getTableHeader().setBackground(Color.decode("#1b4a62"));
        itemTable.getTableHeader().setForeground(Color.WHITE);

        refreshTable();
        updateStockStatus();
        
        panelItemTable.add(new JScrollPane(itemTable), BorderLayout.CENTER);

        add(panelStock);
        add(panelItemTable);
    }

    private void updateStockStatus()
    {
        
        if (inventoryList.isEmpty())
        {
            lblStock1.setText("[!] No recorded items");
            lblStock2.setText("");
            return;
        }

        lblStock1.setText("[!] Stock Status:");

        boolean hasLowStock = false;
        invItem lowest = inventoryList.get(0);

        for (invItem item : inventoryList)
        {
            
            
            if (InventoryManager.computeStatus(item.getItemQuantity(), item.getItemCategory()).equals("Low"))
            {
                hasLowStock = true;
                if (item.getItemQuantity() < lowest.getItemQuantity())
                {
                    lowest = item;
                }
            }
        }

        if (!hasLowStock)
        {
            lblStock2.setText("All stocks are sufficient");
        }
        else
        {
            lblStock2.setText(lowest.getItemName() + " (" + lowest.getItemQuantity() + ")");
        }
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

    }
}