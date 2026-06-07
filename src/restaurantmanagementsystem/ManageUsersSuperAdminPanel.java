import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManageUsersSuperAdminPanel extends JPanel implements ActionListener {

    private JButton btnAddUser, btnEditUsers, btnDeleteUser, btnConfirmEdit;
    private JTextField txtSearch;
    private JPanel pnlTableCard, pnlButtons, pnlRowsContainer;
    private JPanel pnlOverlay;
    private JCheckBox[] rowCheckboxes;

    Color colorCream       = new Color(0xFF, 0xF8, 0xE1);
    Color colorRed         = new Color(0xB7, 0x1C, 0x1C);
    Color colorGold        = new Color(0xFF, 0xB3, 0x00);
    Color colorSalmon      = new Color(0xF5, 0xCF, 0xBA);
    Color colorMutedTeal   = new Color(0x89, 0xB7, 0xB3);
    Color colorTableHeader = new Color(0x2C, 0x5F, 0x7A);
    Color colorRowOdd      = new Color(0xFF, 0xF8, 0xE1);
    Color colorRowEven     = new Color(0xC9, 0xD4, 0xD8);
    Color colorWhite       = Color.WHITE;
    Color colorOverlayBg   = new Color(0xF5, 0xF0, 0xE8);

    Font fontLogo   = new Font("Impact", Font.BOLD, 28);
    Font fontHeader = new Font("Impact", Font.BOLD, 22);
    Font fontNormal = new Font("Arial", Font.PLAIN, 13);
    Font fontBold   = new Font("Arial", Font.BOLD, 14);
    Font fontBtn    = new Font("Impact", Font.PLAIN, 15);
    Font fontSearch = new Font("Arial", Font.PLAIN, 14);

    boolean editMode = false;

    String[][] userData = {
        {"08:00 AM", "05:00 PM", "EMP-001", "Juan dela Cruz",   "Active"},
        {"09:00 AM", "06:00 PM", "EMP-002", "Maria Santos",     "Active"},
        {"07:30 AM", "04:30 PM", "EMP-003", "Pedro Reyes",      "Inactive"},
        {"08:30 AM", "05:30 PM", "EMP-004", "Ana Gonzales",     "Active"},
        {"10:00 AM", "07:00 PM", "EMP-005", "Carlo Villanueva", "Active"},
    };

    String[] colHeaders = {"TIME LOGGED IN", "TIME LOGGED OUT", "EMPLOYEE NUMBER", "NAME", "STATUS"};
    int[]    colWidths  = {150, 150, 160, 260, 130};

    public ManageUsersSuperAdminPanel() {
        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));

        buildTopBar();
        buildTableCard();
    }

    private void buildTopBar() {
        JPanel pnlLogo = new JPanel(null);
        pnlLogo.setBounds(0, 0, 280, 70);
        pnlLogo.setBackground(colorRed);
        add(pnlLogo);

        JLabel lblLogo = new JLabel("PINOY PLATTERS");
        lblLogo.setBounds(14, 15, 260, 40);
        lblLogo.setFont(fontLogo);
        lblLogo.setForeground(colorWhite);
        pnlLogo.add(lblLogo);

        JPanel pnlTopBar = new JPanel(null);
        pnlTopBar.setBounds(280, 0, 700, 70);
        pnlTopBar.setBackground(colorSalmon);
        add(pnlTopBar);

        txtSearch = new JTextField("SEARCH");
        txtSearch.setBounds(30, 16, 380, 38);
        txtSearch.setFont(fontSearch);
        txtSearch.setForeground(Color.GRAY);
        txtSearch.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0xCC, 0xCC, 0xCC), 1),
            BorderFactory.createEmptyBorder(4, 10, 4, 10)
        ));
        txtSearch.setBackground(colorWhite);
        txtSearch.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (txtSearch.getText().equals("SEARCH")) { txtSearch.setText(""); txtSearch.setForeground(Color.BLACK); }
            }
            public void focusLost(FocusEvent e) {
                if (txtSearch.getText().isEmpty()) { txtSearch.setText("SEARCH"); txtSearch.setForeground(Color.GRAY); }
            }
        });
        pnlTopBar.add(txtSearch);

        JLabel lblRole = new JLabel("SUPER ADMIN");
        lblRole.setBounds(450, 20, 180, 30);
        lblRole.setFont(fontBold);
        lblRole.setForeground(new Color(0x33, 0x33, 0x33));
        lblRole.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlTopBar.add(lblRole);

    }

    private void buildTableCard() {
        pnlTableCard = new JPanel(null);
        pnlTableCard.setBounds(10, 80, 960, 630);
        pnlTableCard.setBackground(colorMutedTeal);
        pnlTableCard.setBorder(BorderFactory.createLineBorder(new Color(0x70, 0x99, 0x9E), 1));
        add(pnlTableCard);

        JLabel lblTitle = new JLabel("MANAGE USERS");
        lblTitle.setBounds(20, 14, 400, 34);
        lblTitle.setFont(fontHeader);
        lblTitle.setForeground(new Color(0x22, 0x22, 0x22));
        pnlTableCard.add(lblTitle);

        buildTableRows();

        pnlButtons = new JPanel(null);
        pnlButtons.setBounds(0, 568, 960, 62);
        pnlButtons.setBackground(colorMutedTeal);
        pnlTableCard.add(pnlButtons);

        refreshButtons();
    }

    private void buildTableRows() {
        if (pnlRowsContainer != null) pnlTableCard.remove(pnlRowsContainer);

        pnlRowsContainer = new JPanel(null);
        pnlRowsContainer.setBounds(20, 56, 920, 508);
        pnlRowsContainer.setBackground(colorMutedTeal);
        pnlTableCard.add(pnlRowsContainer);

        int checkboxColW = editMode ? 42 : 0;
        int totalW = 920 - checkboxColW;

        JPanel pnlHeader = new JPanel(null);
        pnlHeader.setBounds(0, 0, 920, 50);
        pnlHeader.setBackground(colorTableHeader);
        pnlRowsContainer.add(pnlHeader);

        if (editMode) {
            JLabel blank = new JLabel("");
            blank.setBounds(0, 0, checkboxColW, 50);
            pnlHeader.add(blank);
        }

        int xCol = checkboxColW;
        for (int c = 0; c < colHeaders.length; c++) {
            int w = (totalW * colWidths[c]) / 850;
            JLabel lblH = new JLabel(colHeaders[c], SwingConstants.CENTER);
            lblH.setBounds(xCol, 0, w, 50);
            lblH.setFont(new Font("Arial", Font.BOLD, 12));
            lblH.setForeground(colorWhite);
            pnlHeader.add(lblH);
            xCol += w;
        }

        int ROW_H = 58;
        rowCheckboxes = new JCheckBox[userData.length];

        for (int r = 0; r < userData.length; r++) {
            Color rowBg = (r % 2 == 0) ? colorRowOdd : colorRowEven;
            int yRow = 53 + r * (ROW_H + 3);

            JPanel pnlRow = new JPanel(null);
            pnlRow.setBounds(0, yRow, 920, ROW_H);
            pnlRow.setBackground(rowBg);
            pnlRowsContainer.add(pnlRow);

            if (editMode) {
                JCheckBox chk = new JCheckBox();
                chk.setBounds(8, (ROW_H - 20) / 2, 26, 20);
                chk.setBackground(rowBg);
                pnlRow.add(chk);
                rowCheckboxes[r] = chk;
            }

            xCol = checkboxColW;
            for (int c = 0; c < userData[r].length; c++) {
                int w = (totalW * colWidths[c]) / 850;
                JLabel lblCell = new JLabel(userData[r][c], SwingConstants.CENTER);
                lblCell.setBounds(xCol, 0, w, ROW_H);
                if (c == 4) {
                    lblCell.setFont(new Font("Arial", Font.BOLD, 12));
                    lblCell.setForeground("Active".equals(userData[r][c]) ? new Color(0x1B, 0x5E, 0x20) : colorRed);
                } else {
                    lblCell.setFont(fontNormal);
                    lblCell.setForeground(new Color(0x22, 0x22, 0x22));
                }
                pnlRow.add(lblCell);
                xCol += w;
            }

            JPanel pnlSep = new JPanel();
            pnlSep.setBounds(0, yRow + ROW_H, 920, 3);
            pnlSep.setBackground(colorMutedTeal);
            pnlRowsContainer.add(pnlSep);
        }

        pnlTableCard.revalidate();
        pnlTableCard.repaint();
    }

    private void refreshButtons() {
        pnlButtons.removeAll();

        if (!editMode) {
            btnAddUser = makeRedButton("ADD USER");
            btnAddUser.setBounds(630, 10, 150, 42);
            btnAddUser.addActionListener(this);
            pnlButtons.add(btnAddUser);

            btnEditUsers = makeRedButton("EDIT USERS");
            btnEditUsers.setBounds(794, 10, 150, 42);
            btnEditUsers.addActionListener(this);
            pnlButtons.add(btnEditUsers);
        } else {
            btnDeleteUser = makeRedButton("🗑 DELETE USER");
            btnDeleteUser.setBounds(630, 10, 150, 42);
            btnDeleteUser.addActionListener(this);
            pnlButtons.add(btnDeleteUser);

            btnConfirmEdit = makeRedButton("✔ CONFIRM EDIT");
            btnConfirmEdit.setBounds(794, 10, 150, 42);
            btnConfirmEdit.addActionListener(this);
            pnlButtons.add(btnConfirmEdit);
        }

        pnlButtons.revalidate();
        pnlButtons.repaint();
    }

    private JButton makeRedButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(fontBtn);
        btn.setBackground(colorRed);
        btn.setForeground(colorWhite);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddUser) {
            showAddUserOverlay();
        } else if (e.getSource() == btnEditUsers) {
            editMode = true;
            buildTableRows();
            refreshButtons();
        } else if (e.getSource() == btnConfirmEdit) {
            editMode = false;
            buildTableRows();
            refreshButtons();
            JOptionPane.showMessageDialog(this, "Changes saved successfully!", "Confirm Edit", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnDeleteUser) {
            showDeleteOverlay();
        }
    }

    private void removeOverlay() {
        if (pnlOverlay != null) {
            pnlTableCard.remove(pnlOverlay);
            pnlOverlay = null;
            pnlTableCard.revalidate();
            pnlTableCard.repaint();
        }
    }

    private void showAddUserOverlay() {
        removeOverlay();

        pnlOverlay = new JPanel(null) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0, 80));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        pnlOverlay.setBounds(0, 0, 960, 630);
        pnlOverlay.setOpaque(false);

        int cardW = 460, cardH = 390;
        int cardX = (960 - cardW) / 2;
        int cardY = (630 - cardH) / 2;

        JPanel pnlCard = new JPanel(null);
        pnlCard.setBounds(cardX, cardY, cardW, cardH);
        pnlCard.setBackground(colorOverlayBg);
        pnlCard.setBorder(BorderFactory.createLineBorder(new Color(0xCC, 0xCC, 0xCC), 1));
        pnlOverlay.add(pnlCard);

        JPanel pnlTitle = new JPanel(null);
        pnlTitle.setBounds(0, 0, cardW, 56);
        pnlTitle.setBackground(colorRed);
        pnlCard.add(pnlTitle);

        JLabel lblTitle = new JLabel("ADD USER", SwingConstants.CENTER);
        lblTitle.setBounds(0, 10, cardW, 36);
        lblTitle.setFont(fontHeader);
        lblTitle.setForeground(colorWhite);
        pnlTitle.add(lblTitle);

        Font fLabel = new Font("Arial", Font.BOLD, 13);
        Font fField = new Font("Arial", Font.PLAIN, 13);

        String[] labels = {"Employee No.:", "Full Name:", "Role:", "Username:", "Password:"};
        JTextField txtEmpNo   = new JTextField(); txtEmpNo.setFont(fField);
        JTextField txtName    = new JTextField(); txtName.setFont(fField);
        JComboBox<String> cmbRole = new JComboBox<>(new String[]{"Admin", "Super Admin"}); cmbRole.setFont(fField);
        JTextField txtUser    = new JTextField(); txtUser.setFont(fField);
        JPasswordField txtPwd = new JPasswordField(); txtPwd.setFont(fField);
        JComponent[] inputs   = {txtEmpNo, txtName, cmbRole, txtUser, txtPwd};

        int yForm = 70;
        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = new JLabel(labels[i]);
            lbl.setBounds(30, yForm, 120, 28);
            lbl.setFont(fLabel);
            pnlCard.add(lbl);
            inputs[i].setBounds(160, yForm, 280, 28);
            pnlCard.add(inputs[i]);
            yForm += 44;
        }

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(30, cardH - 54, 130, 38);
        btnCancel.setFont(fontBold);
        btnCancel.setForeground(colorRed);
        btnCancel.setBackground(colorOverlayBg);
        btnCancel.setBorder(BorderFactory.createLineBorder(colorRed, 2));
        btnCancel.setFocusPainted(false);
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.addActionListener(ev -> removeOverlay());
        pnlCard.add(btnCancel);

        JButton btnSave = makeRedButton("SAVE USER");
        btnSave.setBounds(300, cardH - 54, 140, 38);
        btnSave.addActionListener(ev -> {
            removeOverlay();
            JOptionPane.showMessageDialog(this, "User added successfully!", "Add User", JOptionPane.INFORMATION_MESSAGE);
        });
        pnlCard.add(btnSave);

        pnlTableCard.add(pnlOverlay);
        pnlTableCard.setComponentZOrder(pnlOverlay, 0);
        pnlTableCard.revalidate();
        pnlTableCard.repaint();
    }

    private void showDeleteOverlay() {
        removeOverlay();

        String empNum = "[EMPLOYEE NUMBER]";
        if (rowCheckboxes != null) {
            for (int i = 0; i < rowCheckboxes.length; i++) {
                if (rowCheckboxes[i] != null && rowCheckboxes[i].isSelected()) {
                    empNum = userData[i][2];
                    break;
                }
            }
        }
        final String finalEmpNum = empNum;

        pnlOverlay = new JPanel(null) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0, 80));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        pnlOverlay.setBounds(0, 0, 960, 630);
        pnlOverlay.setOpaque(false);

        int cardW = 540, cardH = 280;
        int cardX = (960 - cardW) / 2;
        int cardY = (630 - cardH) / 2;

        JPanel pnlCard = new JPanel(null);
        pnlCard.setBounds(cardX, cardY, cardW, cardH);
        pnlCard.setBackground(colorOverlayBg);
        pnlCard.setBorder(BorderFactory.createLineBorder(new Color(0xCC, 0xCC, 0xCC), 1));
        pnlOverlay.add(pnlCard);

        JPanel pnlTitle = new JPanel(null);
        pnlTitle.setBounds(0, 0, cardW, 56);
        pnlTitle.setBackground(colorRed);
        pnlCard.add(pnlTitle);

        JLabel lblTitle = new JLabel("DELETE USER?", SwingConstants.CENTER);
        lblTitle.setBounds(0, 10, cardW, 36);
        lblTitle.setFont(fontHeader);
        lblTitle.setForeground(colorWhite);
        pnlTitle.add(lblTitle);

        JLabel lblBody = new JLabel(
            "<html><div style='text-align:center'>ARE YOU SURE YOU WANT TO <b>DELETE</b><br>USER " + finalEmpNum + "?</div></html>",
            SwingConstants.CENTER);
        lblBody.setBounds(20, 66, cardW - 40, 80);
        lblBody.setFont(new Font("Arial", Font.PLAIN, 15));
        pnlCard.add(lblBody);

        JSeparator sep = new JSeparator();
        sep.setBounds(0, 188, cardW, 2);
        sep.setForeground(Color.LIGHT_GRAY);
        pnlCard.add(sep);

        JButton btnConfirm = new JButton("CONFIRM");
        btnConfirm.setBounds(0, 190, cardW / 2, 90);
        btnConfirm.setFont(fontBold);
        btnConfirm.setBackground(colorOverlayBg);
        btnConfirm.setForeground(Color.BLACK);
        btnConfirm.setFocusPainted(false);
        btnConfirm.setBorderPainted(false);
        btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConfirm.addActionListener(ev -> {
            removeOverlay();
            JOptionPane.showMessageDialog(this, "User deleted.", "Deleted", JOptionPane.INFORMATION_MESSAGE);
        });
        pnlCard.add(btnConfirm);

        JSeparator vertDiv = new JSeparator(SwingConstants.VERTICAL);
        vertDiv.setBounds(cardW / 2, 190, 2, 90);
        vertDiv.setForeground(Color.LIGHT_GRAY);
        pnlCard.add(vertDiv);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(cardW / 2 + 2, 190, cardW / 2 - 2, 90);
        btnCancel.setFont(fontBold);
        btnCancel.setBackground(colorOverlayBg);
        btnCancel.setForeground(colorRed);
        btnCancel.setFocusPainted(false);
        btnCancel.setBorderPainted(false);
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.addActionListener(ev -> removeOverlay());
        pnlCard.add(btnCancel);

        pnlTableCard.add(pnlOverlay);
        pnlTableCard.setComponentZOrder(pnlOverlay, 0);
        pnlTableCard.revalidate();
        pnlTableCard.repaint();
    }
}