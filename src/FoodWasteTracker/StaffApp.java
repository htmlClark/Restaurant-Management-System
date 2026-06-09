package FoodWasteTracker;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.*;
import javax.swing.table.*;

public class StaffApp extends JFrame {
    private final List<WasteLog> logs;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private static final String[][] NAVIGATION = {
        {"DASHBOARD","DASHBOARD.png"},
        {"PRODUCTS","PRODUCTS.png"},
        {"INVENTORY","INVENTORY.png"},
        {"WASTE LOGS","WASTE_LOG.png"},
        {"DELIVERY","DELIVERY.png"},
    };

public StaffApp(List<WasteLog> sharedLogs, String username) {
    this.logs = sharedLogs;
    setSize(1000, 750);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    add(SharedUI.buildTopBar("STAFF"), BorderLayout.NORTH);
    add(buildSidebar(), BorderLayout.WEST);
    
    cardLayout = new CardLayout();
    cardPanel = new JPanel(cardLayout);
    cardPanel.setBackground(SharedUI.C_CREAM);

    cardPanel.add(buildPH("DASHBOARD","DASHBOARD.png"),"DASHBOARD");
    cardPanel.add(buildPH("PRODUCTS","PRODUCTS.png"),"PRODUCTS");
    cardPanel.add(buildPH("INVENTORY","INVENTORY.png"),"INVENTORY");
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

    row.addMouseListener(new MouseAdapter() {       
        public void mouseClicked(MouseEvent e) {
        cardLayout.show(cardPanel, label);
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
    JLabel icoLbl = new JLabel(icon);
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
    JButton addBtn = SharedUI.redButton("ADD LOG");
    btnPanel.add(addBtn);
    outer.add(btnPanel, BorderLayout.SOUTH);

    outer.addComponentListener(new ComponentAdapter() {
        public void componentShown(ComponentEvent e) { refreshTable(model); }
        });

        addBtn.addActionListener(e -> showAddLogDialog(model));
        return outer;
    }

private void refreshTable(DefaultTableModel model) {
    model.setRowCount(0);
    for (WasteLog l : logs)
        model.addRow(new Object[]{l.time, l.item, l.qty, l.reason, l.staff, l.remarks});
    }

private void showAddLogDialog(DefaultTableModel model) {
    JDialog dlg = new JDialog(this, "Add Waste Log", true);
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
    gc.fill   = GridBagConstraints.HORIZONTAL;

        String timeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        JTextField fTime = SharedUI.styledField(); fTime.setText(timeStr);
        JTextField fItem = SharedUI.styledField();
        JTextField fQty = SharedUI.styledField();
        String[] reasons = {"Spoilage/Expired","Leftovers","Customer Returns","Contaminated","Staff Error","Other"};
        JComboBox<String> fReason = new JComboBox<>(reasons); SharedUI.styleCombo(fReason);
        JTextField fStaff   = SharedUI.styledField();
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
        refreshTable(model);
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

