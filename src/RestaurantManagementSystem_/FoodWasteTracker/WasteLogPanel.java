package RestaurantManagementSystem_.FoodWasteTracker;

import MainPlacementFrame.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class WasteLogPanel extends JPanel {
private static final List<WasteLog> SHARED_LOGS = new ArrayList<>();

public static WasteLogPanel forStaff(){ 
    return new WasteLogPanel(SHARED_LOGS, Role.STAFF); 
}
public static WasteLogPanel forAdmin(){ 
    return new WasteLogPanel(SHARED_LOGS, Role.ADMIN); 
}
public static WasteLogPanel forSuperAdmin(){ 
    return new WasteLogPanel(SHARED_LOGS, Role.SUPER_ADMIN); 
}
    public enum Role{STAFF, ADMIN, SUPER_ADMIN}
    private final List<WasteLog> logs;
    private final Role role;
    private boolean editMode = false;
    private DefaultTableModel tableModel;
    private JTable table;
    private JPanel btnPanel;
    private JButton addBtn;
    private JButton editBtn;
    private static final int W = 980;
    private static final int H = 720;

public WasteLogPanel(List<WasteLog> logs, Role role) {
    this.logs = logs;
    this.role = role;

    setBounds(300, 80, W, H);
    setLayout(null);
    setBackground(new Color(0xC5, 0xD5, 0xD3));

    buildUI();
    }

private void buildUI() {

    JLabel title = new JLabel("FOOD WASTE LOGS");
    title.setFont(SharedUI.fTitle(28));
    title.setForeground(SharedUI.C_DARK);
    title.setBounds(30, 20, 400, 40);
    add(title);
        String[] cols = {"TIME", "ITEM", "QTY", "REASON", "STAFF", "REMARKS"};
        tableModel = new DefaultTableModel(cols, 0) {
     
            @Override
            public boolean isCellEditable(int r, int c) {
                if (!editMode) return false;
                return c != 0;
            }
            @Override
            public void setValueAt(Object value, int row, int col) {
                super.setValueAt(value, row, col);
                if (!editMode || row < 0 || row >= logs.size()) return;
                WasteLog log = logs.get(row);
                String v = value == null ? "" : value.toString().trim();
                switch (col) {
                    case 1->log.time= v;
                    case 2->log.item = v;
                    case 3->log.qty = v;
                    case 4->log.reason = v;
                    case 5->log.staff = v;
                    case 6->log.remarks = v;
                }
            }
        };
    table = SharedUI.styledTable(tableModel);
    table.getTableHeader().setReorderingAllowed(false);

    JScrollPane sp = new JScrollPane(table);
    sp.getViewport().setBackground(SharedUI.C_CREAM);
    sp.setBorder(BorderFactory.createLineBorder(SharedUI.C_TEAL, 1));
    sp.setBounds(30, 75, 900, 520);
    add(sp);

    btnPanel = new JPanel(null);
    btnPanel.setOpaque(false);
    btnPanel.setBounds(30, 605, 580, 50);
    add(btnPanel);

    addBtn  = SharedUI.redButton("ADD LOG");
    addBtn.setBounds(0, 5, 130, 38);
    btnPanel.add(addBtn);
    addBtn.addActionListener(e -> showAddLogDialog());
        if (role == Role.ADMIN || role == Role.SUPER_ADMIN) {
            editBtn = SharedUI.redButton("EDIT LOGS");
            editBtn.setBounds(145, 5, 130, 38);
            btnPanel.add(editBtn);
            editBtn.addActionListener(e -> enterEditMode());
        }

    refreshTable(false);
    addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                exitEditMode();   
                refreshTable(false);
            }
        });
    }

private void refreshTable(boolean withDeleteCol) {
    tableModel.setRowCount(0);
    for (WasteLog l : logs) {
        if (withDeleteCol)
        tableModel.addRow(new Object[]{"🗑", l.time, l.item, l.qty, l.reason, l.staff, l.remarks});
        else
        tableModel.addRow(new Object[]{l.time, l.item, l.qty, l.reason, l.staff, l.remarks});
        }
    }

private void resetColumns() {
    tableModel.setColumnCount(0);
    for (String c : new String[]{"TIME", "ITEM", "QTY", "REASON", "STAFF", "REMARKS"})
        tableModel.addColumn(c);
    }

private void addDeleteColumn() {
    tableModel.setColumnCount(0);
    for (String c : new String[]{"", "TIME", "ITEM", "QTY", "REASON", "STAFF", "REMARKS"})
        tableModel.addColumn(c);

    TableColumn delCol = table.getColumnModel().getColumn(0);
    delCol.setMaxWidth(50);
    delCol.setMinWidth(50);
    delCol.setPreferredWidth(50);
    delCol.setResizable(false);

    ImageIcon trashIcon = SharedUI.loadIcon(getClass(), "wastelog.png", 20, 20);
    delCol.setCellRenderer((tbl, val, sel, foc, row, col) -> {
        JButton btn = new JButton(trashIcon != null ? trashIcon : new ImageIcon());
        btn.setToolTipText("Delete this log");
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.setOpaque(true);
        btn.setBackground(row % 2 == 0 ? SharedUI.C_WHITE : SharedUI.C_ROW_ALT);
        return btn;
    });

    delCol.setCellEditor(null);
    }

private MouseAdapter deleteMouseListener = null;

private void attachDeleteMouseListener() {
    if (deleteMouseListener != null) return; 
    deleteMouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (!editMode) return;
            int viewCol = table.columnAtPoint(e.getPoint());
            if (viewCol != 0) return;
            int viewRow = table.rowAtPoint(e.getPoint());
            if (viewRow < 0) return;
            int modelRow = table.convertRowIndexToModel(viewRow);
            showDeleteDialog(modelRow);
        }
    };
    table.addMouseListener(deleteMouseListener);
    }

 private void enterEditMode() {
    if (editMode) return;
    editMode = true;
    addDeleteColumn();
    attachDeleteMouseListener();
    refreshTable(true);
    btnPanel.removeAll();
    JButton confirmBtn = SharedUI.redButton("CONFIRM EDIT");
    confirmBtn.setBounds(0, 5, 160, 38);
    btnPanel.add(confirmBtn);
    confirmBtn.addActionListener(ev -> exitEditMode());
    btnPanel.revalidate();
    btnPanel.repaint();
    }

private void exitEditMode() {
    editMode = false;
    resetColumns();
    refreshTable(false);
    btnPanel.removeAll();
    addBtn.setBounds(0, 5, 130, 38);
    btnPanel.add(addBtn);

    if (role == Role.ADMIN || role == Role.SUPER_ADMIN) {
        editBtn.setBounds(145, 5, 130, 38);
        btnPanel.add(editBtn);
    }
    btnPanel.revalidate();
    btnPanel.repaint();
    }

private void showDeleteDialog(int modelRow) {
    JFrame owner = (JFrame) SwingUtilities.getWindowAncestor(this);
    JDialog dlg  = new JDialog(owner, "Delete Log", true);
    dlg.setSize(400, 220);
    dlg.setLocationRelativeTo(owner);
    dlg.setLayout(new BorderLayout());
    JLabel hLbl = new JLabel("DELETE LOG?", SwingConstants.CENTER);
    hLbl.setFont(SharedUI.fTitle(20));
    hLbl.setForeground(SharedUI.C_WHITE);
    hLbl.setBackground(SharedUI.C_RED);
    hLbl.setOpaque(true);
    hLbl.setPreferredSize(new Dimension(0, 52));
    dlg.add(hLbl, BorderLayout.NORTH);
        JLabel msg = new JLabel(
                "<html><center>Are you sure you want to <b>DELETE</b> this log?</center></html>",
                SwingConstants.CENTER);
        msg.setFont(SharedUI.fBody(14));
        msg.setBackground(SharedUI.C_CREAM);
        msg.setOpaque(true);
        dlg.add(msg, BorderLayout.CENTER);
        JPanel btnRow  = new JPanel(new GridLayout(1, 2, 1, 0));
        JButton confirm = new JButton("CONFIRM");
        confirm.setFont(SharedUI.fTitle(14));
        confirm.setBackground(SharedUI.C_CREAM);
        confirm.setForeground(SharedUI.C_DARK);
        confirm.setFocusPainted(false);
        JButton cancel  = new JButton("CANCEL");
        cancel.setFont(SharedUI.fTitle(14));
        cancel.setBackground(SharedUI.C_CREAM);
        cancel.setForeground(SharedUI.C_RED);
        cancel.setFocusPainted(false);
        btnRow.add(confirm);
        btnRow.add(cancel);
        dlg.add(btnRow, BorderLayout.SOUTH);

        confirm.addActionListener(e -> {
            if (modelRow >= 0 && modelRow < logs.size()) {
                logs.remove(modelRow);
                refreshTable(true);   
            }
            dlg.dispose();
        });
        cancel.addActionListener(e -> dlg.dispose());
        dlg.setVisible(true);
    }

private void showAddLogDialog() {
    JFrame owner = (JFrame) SwingUtilities.getWindowAncestor(this);
    JDialog dlg  = new JDialog(owner, "Add Waste Log", true);
    dlg.setSize(480, 400);
    dlg.setLocationRelativeTo(owner);
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
    gc.fill   = GridBagConstraints.HORIZONTAL;
        String timeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        JTextField fTime = SharedUI.styledField(); fTime.setText(timeStr);
        JTextField  fItem = SharedUI.styledField();
        JTextField fQty = SharedUI.styledField();
        String[]reasons = {"Spoilage/Expired","Leftovers","Customer Returns","Contaminated","Staff Error","Other"};
        JComboBox<String> fReason = new JComboBox<>(reasons); SharedUI.styleCombo(fReason);
        JTextField fStaff   = SharedUI.styledField();
        JTextField fRemarks = SharedUI.styledField();
        String[]labels = {"Time","Food Item","Quantity","Reason","Staff","Remarks"};
        JComponent[]flds = {fTime, fItem, fQty, fReason, fStaff, fRemarks};

        for (int i = 0; i < labels.length; i++) {
            gc.gridx = 0; gc.gridy = i; gc.weightx = 0;
            JLabel l = new JLabel(labels[i]); l.setFont(SharedUI.fNav(13));
            form.add(l, gc);
            gc.gridx = 1; gc.weightx = 1;
            flds[i].setPreferredSize(new Dimension(240, 32));
            form.add(flds[i], gc);
        }
        dlg.add(form, BorderLayout.CENTER);
        JPanel  bRow   = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 8));
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
                JOptionPane.showMessageDialog(dlg,
                        "Food Item and Quantity are required.",
                        "Missing Fields", JOptionPane.WARNING_MESSAGE);
                return;
            }
            logs.add(new WasteLog(
                    fTime.getText().trim(), item, qty,
                    (String) fReason.getSelectedItem(),
                    fStaff.getText().trim(),
                    fRemarks.getText().trim()));
            refreshTable(editMode);
            dlg.dispose();
        });
        cancel.addActionListener(e -> dlg.dispose());
        dlg.setVisible(true);
    }
}