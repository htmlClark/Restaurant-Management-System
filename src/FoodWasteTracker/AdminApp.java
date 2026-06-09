package FoodWasteTracker;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class AdminApp extends JFrame {
    private final List<WasteLog> logs;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private boolean editMode = false;
    private static final String[][] NAVIGATION = {
        {"DASHBOARD","DASHBOARD.png"},
        {"PRODUCTS","PRODUCTS.png"},
        {"INVENTORY","INVENTORY.png"},
        {"REPORT","REPORT.png"},
        {"WASTE LOGS","WASTE_LOG.png"},
        {"DELIVERY","DELIVERY.png"},
    };
    

public AdminApp(List<WasteLog> sharedLogs, String username) {
    this.logs = sharedLogs;
    setSize(1000, 750);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    add(SharedUI.buildTopBar("ADMIN"), BorderLayout.NORTH);
    add(buildSidebar(), BorderLayout.WEST);

    cardLayout = new CardLayout();
    cardPanel = new JPanel(cardLayout);
    cardPanel.setBackground(SharedUI.C_CREAM);

    cardPanel.add(buildPH("DASHBOARD","DASHBOARD.png"),"DASHBOARD");
    cardPanel.add(buildPH("PRODUCTS","PRODUCTS.png"),"PRODUCTS");
    cardPanel.add(buildPH("INVENTORY","INVENTORY.png"),"INVENTORY");
    cardPanel.add(buildPH("WEEKLY SUMMARY REPORT","REPORT.png"),"REPORT");
    cardPanel.add(buildWLP(),"WASTE LOGS");
    cardPanel.add(buildPH("DELIVERY","DELIVERY.png"),"DELIVERY");
    add(cardPanel, BorderLayout.CENTER);
    cardLayout.show(cardPanel,"DASHBOARD");
    }

private JPanel buildSidebar() {
    JPanel sidebar = new JPanel();
    sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
    sidebar.setBackground(SharedUI.C_TEAL);
    sidebar.setPreferredSize(new Dimension(200, 0));
    sidebar.add(Box.createVerticalStrut(8));
    for (String[] entry : NAVIGATION) {
        sidebar.add(navRow(entry[0], entry[1]));
    }
    sidebar.add(Box.createVerticalGlue());
    sidebar.add(navRowLogout());
    sidebar.add(Box.createVerticalStrut(12));
    return sidebar;
    }

private JPanel navRow(String label, String iconFile) {
    JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 8));
    row.setBackground(SharedUI.C_TEAL);
    row.setMaximumSize(new Dimension(200, 52));
    row.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    ImageIcon icon = SharedUI.loadIcon(iconFile, 26, 26);
    JLabel icoLbl  = new JLabel(icon);
    icoLbl.setForeground(SharedUI.C_GOLD);
    JLabel lbl = new JLabel(label);
    lbl.setFont(SharedUI.fNav(13));
    lbl.setForeground(SharedUI.C_WHITE);
    row.add(icoLbl);
    row.add(lbl);

    String cardKey = label;

    row.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
        cardLayout.show(cardPanel, cardKey);
        }
        });
        return row;
    }

private JPanel navRowLogout() {
    JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 8));
    row.setBackground(SharedUI.C_TEAL);
    row.setMaximumSize(new Dimension(200, 52));
    row.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    ImageIcon icon = SharedUI.loadIcon("LOGOUT.png", 26, 26);
    JLabel icoLbl  = new JLabel(icon);
    icoLbl.setForeground(SharedUI.C_GOLD);
    JLabel lbl = new JLabel("LOGOUT");
    lbl.setFont(SharedUI.fNav(13));
    lbl.setForeground(SharedUI.C_WHITE);

    row.add(icoLbl);
    row.add(lbl);

    row.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) { dispose(); }
    });
    return row;
    }

private JPanel buildWLP() {
    JPanel outer = new JPanel(new BorderLayout(0, 8));
    outer.setBackground(new Color(0xC5, 0xD5, 0xD3));
    outer.setBorder(BorderFactory.createEmptyBorder(20, 24, 20, 24));
    
    JLabel hdr = new JLabel("WASTED ITEMS");
    hdr.setFont(SharedUI.fTitle(24));
    hdr.setForeground(SharedUI.C_DARK);
    outer.add(hdr, BorderLayout.NORTH);

    String[] cols = {"TIME", "ITEM", "QTY", "REASON", "STAFF", "REMARKS"};
    DefaultTableModel model = new DefaultTableModel(cols, 0) {
        public boolean isCellEditable(int r, int c) { return false; }
        };
    JTable table = SharedUI.styledTable(model);
    JScrollPane sp = new JScrollPane(table);
    sp.getViewport().setBackground(SharedUI.C_CREAM);
    sp.setBorder(BorderFactory.createLineBorder(SharedUI.C_TEAL, 1));
    outer.add(sp, BorderLayout.CENTER);

    JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 4));
    btnPanel.setOpaque(false);
    JButton addBtn  = SharedUI.redButton("ADD LOG");
    JButton editBtn = SharedUI.redButton("EDIT LOGS");
    btnPanel.add(addBtn);
    btnPanel.add(editBtn);
    outer.add(btnPanel, BorderLayout.SOUTH);

    outer.addComponentListener(new ComponentAdapter() {
        public void componentShown(ComponentEvent e) {
            editMode = false;
            resetColumns(model);
            refreshTable(model, false);
            btnPanel.removeAll();
            btnPanel.add(addBtn);
            btnPanel.add(editBtn);
            btnPanel.revalidate(); btnPanel.repaint();
            }
        });

        addBtn.addActionListener(e -> showAddLogDialog(model));
            editBtn.addActionListener(e -> {
            if (!editMode) {
            editMode = true;
                addDeleteColumn(model, table);
                refreshTable(model, true);
                btnPanel.removeAll();
                JButton confirmBtn = SharedUI.redButton("CONFIRM EDIT");
            confirmBtn.addActionListener(ev -> {
            editMode = false;
                resetColumns(model);
                refreshTable(model, false);
                btnPanel.removeAll();
                btnPanel.add(addBtn);
                btnPanel.add(editBtn);
                btnPanel.revalidate(); btnPanel.repaint();
            });
                btnPanel.add(confirmBtn);
                btnPanel.revalidate(); btnPanel.repaint();
            }
        });
        return outer;
        }

private void addDeleteColumn(DefaultTableModel model, JTable table) {
    model.setColumnCount(0);
    for (String c : new String[]{"","TIME", "ITEM", "QTY", "REASON", "STAFF", "REMARKS"})
        model.addColumn(c);
    TableColumn delCol = table.getColumnModel().getColumn(0);
    delCol.setMaxWidth(44);
    delCol.setPreferredWidth(44);
    ImageIcon trashIcon = SharedUI.loadIcon("WASTE_LOG.png", 20, 20);
    delCol.setCellRenderer((tbl, val, sel, foc, row, col) -> {
        JLabel lbl = new JLabel(trashIcon);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setOpaque(true);
        lbl.setBackground(row % 2 == 0 ? SharedUI.C_WHITE : SharedUI.C_ROW_ALT);
        return lbl;
        });

    JButton deleteBtn = new JButton(trashIcon != null ? trashIcon : null);
    deleteBtn.setBorderPainted(false);
    deleteBtn.setFocusPainted(false);
    deleteBtn.setContentAreaFilled(false);
        DefaultCellEditor editor = new DefaultCellEditor(new JCheckBox()) {
        public Component getTableCellEditorComponent(
        JTable t, Object value, boolean isSelected, int row, int column) {
        SwingUtilities.invokeLater(() -> {
            stopCellEditing();
            showDeleteDialog(row, model);
        });
        return deleteBtn;
        }
        public Object getCellEditorValue() { return ""; }
        public boolean isCellEditable(EventObject e) { return true; }
        };
        editor.setClickCountToStart(1);
        delCol.setCellEditor(editor);
    }

private void resetColumns(DefaultTableModel model) {
        model.setColumnCount(0);
        for (String c : new String[]{"TIME", "ITEM", "QTY", "REASON", "STAFF", "REMARKS"})
            model.addColumn(c);
    }

private void refreshTable(DefaultTableModel model, boolean withDelete) {
        model.setRowCount(0);
        for (WasteLog l : logs) {
            if (withDelete)
                model.addRow(new Object[]{"🗑", l.time, l.item, l.qty, l.reason, l.staff, l.remarks});
            else
                model.addRow(new Object[]{l.time, l.item, l.qty, l.reason, l.staff, l.remarks});
        }
    }

private void showDeleteDialog(int row, DefaultTableModel model) {
        JDialog dlg = new JDialog(this,"Delete Log",true);
        dlg.setSize(400, 220);
        dlg.setLocationRelativeTo(this);
        dlg.setLayout(new BorderLayout());

        JLabel hLbl = new JLabel("DELETE LOG?", SwingConstants.CENTER);
        hLbl.setFont(SharedUI.fTitle(20));
        hLbl.setForeground(SharedUI.C_WHITE);
        hLbl.setBackground(SharedUI.C_RED);
        hLbl.setOpaque(true);
        hLbl.setPreferredSize(new Dimension(0, 52));
        dlg.add(hLbl, BorderLayout.NORTH);

        JLabel msg = new JLabel("<html><center>Are you sure you want to <b>DELETE</b> this log?</center></html>",SwingConstants.CENTER);
        msg.setFont(SharedUI.fBody(14));
        msg.setBackground(SharedUI.C_CREAM);
        msg.setOpaque(true);
        dlg.add(msg, BorderLayout.CENTER);

        JPanel btnRow = new JPanel(new GridLayout(1, 2, 1, 0));
        JButton confirm = new JButton("CONFIRM");
        confirm.setFont(SharedUI.fTitle(14));
        confirm.setBackground(SharedUI.C_CREAM);
        confirm.setForeground(SharedUI.C_DARK);
        confirm.setFocusPainted(false);
        JButton cancel = new JButton("CANCEL");
        cancel.setFont(SharedUI.fTitle(14));
        cancel.setBackground(SharedUI.C_CREAM);
        cancel.setForeground(SharedUI.C_RED);
        cancel.setFocusPainted(false);
        btnRow.add(confirm); btnRow.add(cancel);
        dlg.add(btnRow, BorderLayout.SOUTH);

        confirm.addActionListener(e -> {
            if (row >= 0 && row < logs.size()) logs.remove(row);
            refreshTable(model, true);
            dlg.dispose();
        });
        cancel.addActionListener(e -> dlg.dispose());
        dlg.setVisible(true);
    }

private void showAddLogDialog(DefaultTableModel model) {
    JDialog dlg = new JDialog(this,"Add Waste Log",true);
    dlg.setSize(480, 400);
    dlg.setLocationRelativeTo(this);
    dlg.setLayout(new BorderLayout());
    JLabel hLbl = new JLabel("  ADD WASTE LOG");
    hLbl.setFont(SharedUI.fTitle(20));
    hLbl.setForeground(SharedUI.C_WHITE);
    hLbl.setBackground(SharedUI.C_TEAL);
    hLbl.setOpaque(true);
    hLbl.setPreferredSize(new Dimension(0, 52));
    dlg.add(hLbl, BorderLayout.NORTH);

    JPanel form = new JPanel(new GridBagLayout());
    form.setBackground(SharedUI.C_CREAM);
    form.setBorder(BorderFactory.createEmptyBorder(16, 28, 16, 28));
    GridBagConstraints gc = new GridBagConstraints();
    gc.insets = new Insets(6, 4, 6, 4);
    gc.fill = GridBagConstraints.HORIZONTAL;

    String timeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
    JTextField fTime = SharedUI.styledField(); fTime.setText(timeStr);
    JTextField fItem = SharedUI.styledField();
    JTextField fQty = SharedUI.styledField();
    String[] reasons = {"Spoilage/Expired","Leftovers","Customer Returns","Contaminated","Staff Error","Other"};
    JComboBox<String> fReason = new JComboBox<>(reasons); SharedUI.styleCombo(fReason);
    JTextField fStaff = SharedUI.styledField();
    JTextField fRemarks = SharedUI.styledField();

    String[]labels = {"Time","Food Item","Quantity","Reason","Staff","Remarks"};
    JComponent[] flds = {fTime, fItem, fQty, fReason, fStaff, fRemarks};

        for (int i = 0; i < labels.length; i++) {
            gc.gridx = 0; gc.gridy = i; gc.weightx = 0;
            JLabel l = new JLabel(labels[i]); l.setFont(SharedUI.fNav(13));
            form.add(l, gc);
            gc.gridx = 1; gc.weightx = 1;
            flds[i].setPreferredSize(new Dimension(240, 32));
            form.add(flds[i], gc);
        }
        dlg.add(form, BorderLayout.CENTER);

        JPanel bRow = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 8));
        bRow.setBackground(SharedUI.C_CREAM);
        JButton cancel = new JButton("CANCEL");
        cancel.setFont(SharedUI.fNav(13));
        cancel.setBackground(SharedUI.C_STEEL);
        cancel.setForeground(SharedUI.C_WHITE);
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        cancel.setOpaque(true);
        JButton save = SharedUI.redButton("SAVE LOG");
        bRow.add(cancel); bRow.add(save);
        dlg.add(bRow, BorderLayout.SOUTH);

        save.addActionListener(e -> {
        String item = fItem.getText().trim();
        String qty  = fQty.getText().trim();
            if (item.isEmpty() || qty.isEmpty()) {
        JOptionPane.showMessageDialog(dlg,"Food Item and Quantity are required.", "Missing Fields",JOptionPane.WARNING_MESSAGE);
                return;
            }
            logs.add(new WasteLog(
            fTime.getText().trim(), item, qty,
            (String) fReason.getSelectedItem(),
            fStaff.getText().trim(),
            fRemarks.getText().trim()
            ));
            refreshTable(model, editMode);
            dlg.dispose();
        });
        cancel.addActionListener(e -> dlg.dispose());
        dlg.setVisible(true);
    }

private JPanel buildPH(String name, String iconFile) {
    JPanel p = new JPanel(new GridBagLayout());
    p.setBackground(SharedUI.C_CREAM);
    GridBagConstraints g = new GridBagConstraints();
    g.gridy = 0;
    ImageIcon icon = SharedUI.loadIcon(iconFile, 64, 64);
    if (icon != null) { p.add(new JLabel(icon), g); g.gridy++; }
        JLabel l = new JLabel(name);
        l.setFont(SharedUI.fTitle(28));
        l.setForeground(SharedUI.C_TEAL);
        p.add(l, g); g.gridy++;
        JLabel s = new JLabel("(Page coming soon)");
        s.setFont(SharedUI.fBody(14));
        s.setForeground(SharedUI.C_STEEL);
        p.add(s, g);
        return p;
    }
}
