package RestaurantManagementSystem_.FoodWasteTracker;
import RestaurantManagementSystem_.InventoryManagement.InventoryManager;
import RestaurantManagementSystem_.InventoryManagement.invItem;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class WasteLogPanel extends JPanel implements ActionListener {
    private static final List<WasteLog> SHARED_LOGS = new ArrayList<>();
    public static List<WasteLog> getSharedLogs() { return SHARED_LOGS; }

    public enum Role { STAFF, ADMIN, SUPER_ADMIN }
    public static WasteLogPanel forStaff() { return new WasteLogPanel(SHARED_LOGS, Role.STAFF); }
    public static WasteLogPanel forAdmin() { return new WasteLogPanel(SHARED_LOGS, Role.ADMIN); }
    public static WasteLogPanel forSuperAdmin() { return new WasteLogPanel(SHARED_LOGS, Role.SUPER_ADMIN); }

    private List<WasteLog> logs;
    private Role role;
    private boolean editMode = false;

    private DefaultTableModel tableModel;
    private JTable tblWasteLog;
    private JScrollPane scrollPane;

    private JButton btnAddLog, btnEditLogs, btnConfirmEdit;
    private JPanel btnPanel;

    Color colorCream = new Color(0xFF, 0xF8, 0xE1);
    Color colorTeal = new Color(0x36, 0x63, 0x79);
    Color colorRed = new Color(0xB7, 0x1C, 0x1C);
    Color colorSalmon = new Color(0xF5, 0xCF, 0xBA);
    Color colorSteel = new Color(0x89, 0xB7, 0xB3);
    Color colorDark = new Color(0x22, 0x3A, 0x45);
    Color colorWhite = Color.WHITE;
    Color colorRowAlt = new Color(0xFF, 0xF0, 0xD0);

    Font fontBold = new Font("Arial", Font.BOLD, 14);
    Font fontNormal = new Font("Arial", Font.PLAIN, 13);
    Font fontHeader = new Font("Arial", Font.BOLD, 22);

    public WasteLogPanel(List<WasteLog> logs, Role role)
    {
        this.logs = logs;
        this.role = role;

        wasteLogTable();
        buttons();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(colorCream);
    }

    private void wasteLogTable()
    {
        JLabel lblTitle = new JLabel("FOOD WASTE LOGS");
        lblTitle.setBounds(30, 20, 400, 40);
        lblTitle.setFont(fontHeader);
        lblTitle.setForeground(colorDark);
        add(lblTitle);

        String[] columns = {"TIME", "ITEM", "QTY", "REASON", "STAFF", "REMARKS"};
        tableModel = new DefaultTableModel(columns, 0)
        {
            @Override
            public boolean isCellEditable(int r, int c) { return false; }
        };

        tblWasteLog = new JTable(tableModel);
        tblWasteLog.setFont(fontNormal);
        tblWasteLog.setRowHeight(36);
        tblWasteLog.setShowGrid(false);
        tblWasteLog.setBackground(colorWhite);
        tblWasteLog.setForeground(colorDark);
        tblWasteLog.setSelectionBackground(colorSteel);
        tblWasteLog.setSelectionForeground(colorWhite);
        tblWasteLog.getTableHeader().setBackground(colorTeal);
        tblWasteLog.getTableHeader().setForeground(colorWhite);
        tblWasteLog.getTableHeader().setFont(fontBold);
        tblWasteLog.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(tblWasteLog);
        scrollPane.setBounds(30, 75, 920, 520);
        scrollPane.getViewport().setBackground(colorCream);
        scrollPane.setBorder(BorderFactory.createLineBorder(colorTeal, 1));
        add(scrollPane);
    }

    private void buttons()
    {
        btnPanel = new JPanel(null);
        btnPanel.setBounds(30, 610, 600, 50);
        btnPanel.setBackground(colorCream);
        add(btnPanel);

        btnAddLog = new JButton("ADD LOG");
        btnAddLog.setBounds(0, 5, 130, 38);
        btnAddLog.setBackground(colorRed);
        btnAddLog.setForeground(colorWhite);
        btnAddLog.setFont(fontBold);
        btnAddLog.setFocusPainted(false);
        btnAddLog.setBorderPainted(false);
        btnAddLog.addActionListener(this);
        btnPanel.add(btnAddLog);

        btnEditLogs = new JButton("EDIT LOGS");
        btnEditLogs.setBounds(145, 5, 130, 38);
        btnEditLogs.setBackground(colorRed);
        btnEditLogs.setForeground(colorWhite);
        btnEditLogs.setFont(fontBold);
        btnEditLogs.setFocusPainted(false);
        btnEditLogs.setBorderPainted(false);
        btnEditLogs.addActionListener(this);
        btnEditLogs.setVisible(role == Role.SUPER_ADMIN && !logs.isEmpty());
        btnPanel.add(btnEditLogs);

        refreshTable();
    }

    private void refreshTable()
    {
        tableModel.setRowCount(0);
        for (WasteLog log : logs)
        {
            tableModel.addRow(new Object[]{
                    log.time, log.item, log.qty,
                    log.reason, log.staff, log.remarks
            });
        }
        if (btnEditLogs != null)
            btnEditLogs.setVisible(role == Role.SUPER_ADMIN && !logs.isEmpty());
    }

    private void enterEditMode()
    {
        editMode = true;
        btnPanel.removeAll();
        btnConfirmEdit = new JButton("CONFIRM EDIT");
        btnConfirmEdit.setBounds(0, 5, 160, 38);
        btnConfirmEdit.setBackground(colorRed);
        btnConfirmEdit.setForeground(colorWhite);
        btnConfirmEdit.setFont(fontBold);
        btnConfirmEdit.setFocusPainted(false);
        btnConfirmEdit.setBorderPainted(false);
        btnConfirmEdit.addActionListener(this);
        btnPanel.add(btnConfirmEdit);
        btnPanel.revalidate();
        btnPanel.repaint();
        tblWasteLog.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (!editMode) return;
                int selectedRow = tblWasteLog.getSelectedRow();
                if (selectedRow == -1) return;
                showDeleteDialog(selectedRow);
            }
        });
    }

    private void exitEditMode()
    {
        editMode = false;
        btnPanel.removeAll();
        btnAddLog.setBounds(0, 5, 130, 38);
        btnPanel.add(btnAddLog);
        btnEditLogs.setBounds(145, 5, 130, 38);
        btnPanel.add(btnEditLogs);
        btnPanel.revalidate();
        btnPanel.repaint();
        refreshTable();
    }

    private void showDeleteDialog(int selectedRow)
    {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        int confirm = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure you want to DELETE this log?",
                "DELETE LOG",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION)
        {
            WasteLog removed = logs.get(selectedRow);
            double qty = 0;
            try { qty = Double.parseDouble(removed.qty); } catch (NumberFormatException ignored) {}
            if (qty > 0) InventoryManager.getInstance().addStock(removed.item, qty);
            logs.remove(selectedRow);
            refreshTable();
        }
    }

    private void showAddLogDialog()
    {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        JPanel panelAdd = new JPanel(new GridLayout(6, 2, 5, 10));

        String timeNow = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        String currentEmp = WasteLogSession.getInstance().getEmployeeNo();

        JLabel lblTime = new JLabel("TIME:");
        JTextField txtTime = new JTextField(timeNow);
        txtTime.setEditable(false);

        JLabel lblItem = new JLabel("* FOOD ITEM:");
        RestaurantManagementSystem_.InventoryManagement.InventoryPopulatedData.loadInventoryData();
        List<invItem> invList = InventoryManager.getInstance().getInventoryList();
        String[] itemNames = new String[invList.size() + 1];
        itemNames[0] = "-Select Item-";
        for (int i = 0; i < invList.size(); i++) itemNames[i + 1] = invList.get(i).getItemName();
        JComboBox<String> cbItem = new JComboBox<>(itemNames);

        JLabel lblQty = new JLabel("* QUANTITY:");
        JTextField txtQty = new JTextField();

        JLabel lblReason = new JLabel("* REASON:");
        String[] reasons = {"-Select Reason-", "Spoilage/Expired", "Leftovers", "Customer Returns", "Contaminated", "Staff Error", "Other"};
        JComboBox<String> cbReason = new JComboBox<>(reasons);

        JLabel lblStaff = new JLabel("STAFF:");
        JTextField txtStaff = new JTextField(currentEmp);
        txtStaff.setEditable(false);
        txtStaff.setBackground(new Color(0xEE, 0xEE, 0xEE));

        JLabel lblRemarks = new JLabel("REMARKS:");
        JTextField txtRemarks = new JTextField();

        panelAdd.add(lblTime); panelAdd.add(txtTime);
        panelAdd.add(lblItem); panelAdd.add(cbItem);
        panelAdd.add(lblQty); panelAdd.add(txtQty);
        panelAdd.add(lblReason); panelAdd.add(cbReason);
        panelAdd.add(lblStaff); panelAdd.add(txtStaff);
        panelAdd.add(lblRemarks); panelAdd.add(txtRemarks);

        int userConfirm = JOptionPane.showConfirmDialog(
                frame, panelAdd, "ADD WASTE LOG", JOptionPane.OK_CANCEL_OPTION
        );

        if (userConfirm == JOptionPane.OK_OPTION)
        {
            String inputItem = (String) cbItem.getSelectedItem();
            String inputQty = txtQty.getText().trim();
            String inputReason = (String) cbReason.getSelectedItem();

            if (inputItem.equals("-Select Item-"))
            {
                JOptionPane.showMessageDialog(frame, "Please select a food item.", "MISSING FIELD", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (inputReason.equals("-Select Reason-"))
            {
                JOptionPane.showMessageDialog(frame, "Please select a reason.", "MISSING FIELD", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (inputQty.isEmpty())
            {
                JOptionPane.showMessageDialog(frame, "Please enter a quantity.", "MISSING FIELD", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double parsedInputQty;
            try
            {
                parsedInputQty = Double.parseDouble(inputQty);
                if (parsedInputQty <= 0)
                {
                    JOptionPane.showMessageDialog(frame, "Quantity must be greater than zero.", "INVALID QUANTITY", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric quantity.", "INVALID QUANTITY", JOptionPane.WARNING_MESSAGE);
                return;
            }

            boolean deducted = InventoryManager.getInstance().deductStock(inputItem, parsedInputQty);
            if (!deducted)
            {
                JOptionPane.showMessageDialog(frame, "Insufficient stock for the entered quantity.", "STOCK ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            logs.add(new WasteLog(
                    txtTime.getText().trim(),
                    inputItem,
                    inputQty,
                    inputReason,
                    currentEmp,
                    txtRemarks.getText().trim()
            ));

            refreshTable();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnAddLog) { showAddLogDialog(); }
        else if (e.getSource() == btnEditLogs) { enterEditMode(); }
        else if (e.getSource() == btnConfirmEdit) { exitEditMode(); }
    }
}