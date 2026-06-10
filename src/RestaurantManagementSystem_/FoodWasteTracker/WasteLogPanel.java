package RestaurantManagementSystem_.FoodWasteTracker;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class WasteLogPanel extends JPanel implements ActionListener {

    // ── Shared log list across all roles ────────────────────────
    private static final List<WasteLog> SHARED_LOGS = new ArrayList<>();

    // ── Role constants ───────────────────────────────────────────
    public enum Role { STAFF, ADMIN, SUPER_ADMIN }

    // ── Static factory methods ───────────────────────────────────
    public static WasteLogPanel forStaff()      { return new WasteLogPanel(SHARED_LOGS, Role.STAFF); }
    public static WasteLogPanel forAdmin()      { return new WasteLogPanel(SHARED_LOGS, Role.ADMIN); }
    public static WasteLogPanel forSuperAdmin() { return new WasteLogPanel(SHARED_LOGS, Role.SUPER_ADMIN); }

    // ── Fields ───────────────────────────────────────────────────
    private List<WasteLog> logs;
    private Role role;
    private boolean editMode = false;

    private DefaultTableModel tableModel;
    private JTable tblWasteLog;
    private JScrollPane scrollPane;

    private JButton btnAddLog, btnEditLogs, btnConfirmEdit;
    private JPanel btnPanel;

    // ── Colors ───────────────────────────────────────────────────
    Color colorCream  = new Color(0xFF, 0xF8, 0xE1);
    Color colorTeal   = new Color(0x36, 0x63, 0x79);
    Color colorRed    = new Color(0xB7, 0x1C, 0x1C);
    Color colorSalmon = new Color(0xF5, 0xCF, 0xBA);
    Color colorSteel  = new Color(0x89, 0xB7, 0xB3);
    Color colorDark   = new Color(0x22, 0x3A, 0x45);
    Color colorWhite  = Color.WHITE;
    Color colorRowAlt = new Color(0xFF, 0xF0, 0xD0);

    // ── Fonts ────────────────────────────────────────────────────
    Font fontBold   = new Font("Arial", Font.BOLD, 14);
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

        if (role == Role.ADMIN || role == Role.SUPER_ADMIN)
        {
            btnEditLogs = new JButton("EDIT LOGS");
            btnEditLogs.setBounds(145, 5, 130, 38);
            btnEditLogs.setBackground(colorRed);
            btnEditLogs.setForeground(colorWhite);
            btnEditLogs.setFont(fontBold);
            btnEditLogs.setFocusPainted(false);
            btnEditLogs.setBorderPainted(false);
            btnEditLogs.addActionListener(this);
            btnPanel.add(btnEditLogs);
        }

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

        // ── allow clicking rows to delete ────────────────────────
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

        if (role == Role.ADMIN || role == Role.SUPER_ADMIN)
        {
            btnEditLogs.setBounds(145, 5, 130, 38);
            btnPanel.add(btnEditLogs);
        }

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
            logs.remove(selectedRow);
            refreshTable();
        }
    }

    private void showAddLogDialog()
    {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        JPanel panelAdd = new JPanel(new GridLayout(6, 2, 5, 10));

        String timeNow = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());

        JLabel lblTime    = new JLabel("TIME:");
        JTextField txtTime = new JTextField(timeNow);

        JLabel lblItem    = new JLabel("FOOD ITEM:");
        JTextField txtItem = new JTextField();

        JLabel lblQty    = new JLabel("QUANTITY:");
        JTextField txtQty = new JTextField();

        JLabel lblReason = new JLabel("REASON:");
        String[] reasons = {"Spoilage/Expired", "Leftovers", "Customer Returns", "Contaminated", "Staff Error", "Other"};
        JComboBox<String> cbReason = new JComboBox<>(reasons);

        JLabel lblStaff   = new JLabel("STAFF:");
        JTextField txtStaff = new JTextField();

        JLabel lblRemarks   = new JLabel("REMARKS:");
        JTextField txtRemarks = new JTextField();

        panelAdd.add(lblTime);    panelAdd.add(txtTime);
        panelAdd.add(lblItem);    panelAdd.add(txtItem);
        panelAdd.add(lblQty);     panelAdd.add(txtQty);
        panelAdd.add(lblReason);  panelAdd.add(cbReason);
        panelAdd.add(lblStaff);   panelAdd.add(txtStaff);
        panelAdd.add(lblRemarks); panelAdd.add(txtRemarks);

        int userConfirm = JOptionPane.showConfirmDialog(
                frame, panelAdd, "ADD WASTE LOG", JOptionPane.OK_CANCEL_OPTION
        );

        if (userConfirm == JOptionPane.OK_OPTION)
        {
            String inputItem = txtItem.getText().trim();
            String inputQty  = txtQty.getText().trim();

            if (inputItem.isEmpty() || inputQty.isEmpty())
            {
                JOptionPane.showMessageDialog(frame, "Food Item and Quantity are required.", "Missing Fields", JOptionPane.WARNING_MESSAGE);
                return;
            }

            logs.add(new WasteLog(
                    txtTime.getText().trim(),
                    inputItem,
                    inputQty,
                    (String) cbReason.getSelectedItem(),
                    txtStaff.getText().trim(),
                    txtRemarks.getText().trim()
            ));

            refreshTable();
            JOptionPane.showMessageDialog(frame, "Waste log added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnAddLog)      { showAddLogDialog(); }
        else if (e.getSource() == btnEditLogs)    { enterEditMode(); }
        else if (e.getSource() == btnConfirmEdit) { exitEditMode(); }
    }
}