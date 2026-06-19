package RestaurantManagementSystem_.ManageUsers;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManageUsersSuperAdminPanel extends JPanel implements ActionListener {

    private JButton btnAddUser, btnEditUsers, btnTerminateUser, btnReactivateUser, btnConfirmEdit;
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
    Color colorActive   = new Color(0x1B, 0x5E, 0x20);
    Color colorInactive = new Color(0xB7, 0x1C, 0x1C);

    Font fontHeader = new Font("Arial", Font.BOLD, 22);
    Font fontNormal = new Font("Arial", Font.PLAIN, 13);
    Font fontBold   = new Font("Arial", Font.BOLD, 14);
    Font fontBtn    = new Font("Arial", Font.PLAIN, 15);

    boolean editMode = false;

    private UserManager userManager = UserManager.getInstance();

    String[][] userData;

    String[] colHeaders = {"TIME LOGGED IN", "EMPLOYEE NUMBER", "NAME", "ROLE", "HIRE DATE", "STATUS"};
    int[]    colWidths  = {130, 140, 150, 120, 160, 150};

    public ManageUsersSuperAdminPanel()
    {
        userData = userManager.getUsersAsArray();
        buildTableCard();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(colorCream);
    }

    private void buildTableCard()
    {
        pnlTableCard = new JPanel(null);
        pnlTableCard.setBounds(20, 20, 940, 680);
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
        pnlButtons.setBounds(0, 620, 940, 60);
        pnlButtons.setBackground(colorMutedTeal);
        pnlTableCard.add(pnlButtons);

        refreshButtons();
    }

    private void buildTableRows()
    {
        if (pnlRowsContainer != null) pnlTableCard.remove(pnlRowsContainer);

        pnlRowsContainer = new JPanel(null);
        pnlRowsContainer.setBounds(20, 56, 900, 560);
        pnlRowsContainer.setBackground(colorMutedTeal);
        pnlTableCard.add(pnlRowsContainer);

        int checkboxColW = editMode ? 42 : 0;
        int totalW = 900 - checkboxColW;

        JPanel pnlHeader = new JPanel(null);
        pnlHeader.setBounds(0, 0, 900, 50);
        pnlHeader.setBackground(colorTableHeader);
        pnlRowsContainer.add(pnlHeader);

        if (editMode)
        {
            JLabel blank = new JLabel("");
            blank.setBounds(0, 0, checkboxColW, 50);
            pnlHeader.add(blank);
        }

        int xCol = checkboxColW;
        for (int c = 0; c < colHeaders.length; c++)
        {
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

        for (int r = 0; r < userData.length; r++)
        {
            Color rowBg = (r % 2 == 0) ? colorRowOdd : colorRowEven;
            int yRow = 53 + r * (ROW_H + 3);

            JPanel pnlRow = new JPanel(null);
            pnlRow.setBounds(0, yRow, 900, ROW_H);
            pnlRow.setBackground(rowBg);
            pnlRowsContainer.add(pnlRow);

            if (editMode)
            {
                JCheckBox chk = new JCheckBox();
                chk.setBounds(8, (ROW_H - 20) / 2, 26, 20);
                chk.setBackground(rowBg);
                chk.addItemListener(ev -> updateActionButtonVisibility());
                pnlRow.add(chk);
                rowCheckboxes[r] = chk;
            }

            xCol = checkboxColW;
            for (int c = 0; c < colHeaders.length; c++)
            {
                int w = (totalW * colWidths[c]) / 850;
                JLabel lblCell = new JLabel(userData[r][c], SwingConstants.CENTER);
                lblCell.setBounds(xCol, 0, w, ROW_H);
                if (c == 5)
                {
                    boolean isInactive = userData[r][5].equalsIgnoreCase("Inactive");
                    lblCell.setFont(new Font("Arial", Font.BOLD, 12));
                    lblCell.setForeground(isInactive ? colorInactive : colorActive);
                }
                else
                {
                    lblCell.setFont(fontNormal);
                    lblCell.setForeground(new Color(0x22, 0x22, 0x22));
                }
                pnlRow.add(lblCell);
                xCol += w;
            }

            JPanel pnlSep = new JPanel();
            pnlSep.setBounds(0, yRow + ROW_H, 900, 3);
            pnlSep.setBackground(colorMutedTeal);
            pnlRowsContainer.add(pnlSep);
        }

        pnlTableCard.revalidate();
        pnlTableCard.repaint();
    }

    private void refreshTable()
    {
        userData = userManager.getUsersAsArray();
        buildTableRows();
    }

    private void refreshButtons()
    {
        pnlButtons.removeAll();

        if (!editMode)
        {
            btnAddUser = makeRedButton("ADD USER");
            btnAddUser.setBounds(620, 0, 150, 42);
            btnAddUser.addActionListener(this);
            pnlButtons.add(btnAddUser);

            btnEditUsers = makeRedButton("EDIT USERS");
            btnEditUsers.setBounds(780, 0, 150, 42);
            btnEditUsers.addActionListener(this);
            pnlButtons.add(btnEditUsers);
        }
        else
        {
            btnTerminateUser = makeRedButton("TERMINATE USER");
            btnTerminateUser.setBounds(460, 0, 150, 42);
            btnTerminateUser.addActionListener(this);
            pnlButtons.add(btnTerminateUser);
            
            btnReactivateUser = makeRedButton("REACTIVATE USER");
            btnReactivateUser.setBackground(colorActive);
            btnReactivateUser.setBounds(620, 0, 150, 42);
            btnReactivateUser.addActionListener(this);
            pnlButtons.add(btnReactivateUser);

            btnConfirmEdit = makeRedButton("CONFIRM EDIT");
            btnConfirmEdit.setBounds(780, 00, 150, 42);
            btnConfirmEdit.addActionListener(this);
            pnlButtons.add(btnConfirmEdit);
            
            updateActionButtonVisibility();
        }

        pnlButtons.revalidate();
        pnlButtons.repaint();
    }
    
    private void updateActionButtonVisibility()
    {
        if (!editMode) return;

        boolean hasActiveSelected   = false;
        boolean hasInactiveSelected = false;

        if (rowCheckboxes != null)
        {
            for (int i = 0; i < rowCheckboxes.length; i++)
            {
            if (rowCheckboxes[i] != null && rowCheckboxes[i].isSelected())
                {
                    if (UserManager.STATUS_ACTIVE.equalsIgnoreCase(userData[i][5]))
                    hasActiveSelected = true;
                    else
                        hasInactiveSelected = true;
                }
            }
        }

    if (btnTerminateUser  != null) btnTerminateUser.setVisible(hasActiveSelected);
    if (btnReactivateUser != null) btnReactivateUser.setVisible(hasInactiveSelected);
}
    
    private JButton makeRedButton(String text)
    {
        JButton btn = new JButton(text);
        btn.setFont(fontBtn);
        btn.setBackground(colorRed);
        btn.setForeground(colorWhite);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private List<String> getSelectedEmpNos()
    {
        java.util.List<String> selected = new ArrayList<>();
        if (rowCheckboxes != null)
        {
            for (int i = 0; i < rowCheckboxes.length; i++)
            {
                if (rowCheckboxes[i] != null && rowCheckboxes[i].isSelected())
                    selected.add(userData[i][1]);
            }
        }
        return selected;
    }

    private void removeOverlay()
    {
        if (pnlOverlay != null)
        {
            pnlTableCard.remove(pnlOverlay);
            pnlOverlay = null;
            pnlTableCard.revalidate();
            pnlTableCard.repaint();
        }
    }

    private void showAddUserOverlay()
    {
        removeOverlay();

        pnlOverlay = new JPanel(null) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0, 80));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        pnlOverlay.setBounds(0, 0, 940, 680);
        pnlOverlay.setOpaque(false);

        int cardW = 480, cardH = 484;
        int cardX = (940 - cardW) / 2;
        int cardY = (680 - cardH) / 2;

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

        int yForm = 74;

        JLabel lblEmpNo = new JLabel("Employee No.:");
        lblEmpNo.setBounds(30, yForm, 120, 28);
        lblEmpNo.setFont(fLabel);
        pnlCard.add(lblEmpNo);
        JTextField txtEmpNo = new JTextField();
        txtEmpNo.setBounds(160, yForm, 300, 28);
        txtEmpNo.setFont(fField);
        pnlCard.add(txtEmpNo);
        yForm += 44;

        JLabel lblName = new JLabel("Full Name:");
        lblName.setBounds(30, yForm, 120, 28);
        lblName.setFont(fLabel);
        pnlCard.add(lblName);
        JTextField txtName = new JTextField();
        txtName.setBounds(160, yForm, 300, 28);
        txtName.setFont(fField);
        pnlCard.add(txtName);
        yForm += 44;

        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(30, yForm, 120, 28);
        lblRole.setFont(fLabel);
        pnlCard.add(lblRole);
        JComboBox<String> cmbRole = new JComboBox<>(new String[]{"-Select Role-","Staff", "Admin", "Super Admin"});
        cmbRole.setBounds(160, yForm, 300, 28);
        cmbRole.setFont(fField);
        pnlCard.add(cmbRole);
        yForm += 44;
        
        JLabel lblHireDate = new JLabel("Hire Date:");
        lblHireDate.setBounds(30, yForm, 120, 28);
        lblHireDate.setFont(fLabel);
        pnlCard.add(lblHireDate);
        JTextField txtHireDate = new JTextField(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
        txtHireDate.setBounds(160, yForm, 300, 28);
        txtHireDate.setFont(fField);
        pnlCard.add(txtHireDate);
        yForm += 44;
        
        JLabel lblPwd = new JLabel("Password:");
        lblPwd.setBounds(30, yForm, 120, 28);
        lblPwd.setFont(fLabel);
        pnlCard.add(lblPwd);
        JPasswordField txtPwd = new JPasswordField();
        txtPwd.setBounds(160, yForm, 300, 28);
        txtPwd.setFont(fField);
        pnlCard.add(txtPwd);
        yForm += 44;

        JLabel lblConfirm = new JLabel("Confirm Pass:");
        lblConfirm.setBounds(30, yForm, 120, 28);
        lblConfirm.setFont(fLabel);
        pnlCard.add(lblConfirm);
        JPasswordField txtConfirm = new JPasswordField();
        txtConfirm.setBounds(160, yForm, 300, 28);
        txtConfirm.setFont(fField);
        pnlCard.add(txtConfirm);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(30, cardH - 58, 130, 38);
        btnCancel.setFont(fontBold);
        btnCancel.setForeground(colorRed);
        btnCancel.setBackground(colorOverlayBg);
        btnCancel.setBorder(BorderFactory.createLineBorder(colorRed, 2));
        btnCancel.setFocusPainted(false);
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.addActionListener(ev -> removeOverlay());
        pnlCard.add(btnCancel);

        JButton btnSave = makeRedButton("SAVE USER");
        btnSave.setBounds(320, cardH - 58, 140, 38);
        btnSave.addActionListener(ev ->
        {
            String empNo    = txtEmpNo.getText().trim();
            String name     = txtName.getText().trim();
            String role     = (String) cmbRole.getSelectedItem();
            String hireDate = txtHireDate.getText().trim();
            String password = new String(txtPwd.getPassword()).trim();
            String confirm  = new String(txtConfirm.getPassword()).trim();

            if (!userManager.validateAddUser(null, empNo, name, password, confirm, role, hireDate)) return;

            userManager.addUser(empNo, name, password, role, hireDate);
            removeOverlay();
            refreshTable();
            JOptionPane.showMessageDialog(this, "User added successfully!", "Add User", JOptionPane.INFORMATION_MESSAGE);
        });
        pnlCard.add(btnSave);

        pnlTableCard.add(pnlOverlay);
        pnlTableCard.setComponentZOrder(pnlOverlay, 0);
        pnlTableCard.revalidate();
        pnlTableCard.repaint();
    }

    private void showTerminateOverlay()
    {
        removeOverlay();

        List<String> selectedEmpNos = getSelectedEmpNos();

        if (selectedEmpNos.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please select a user to terminate.", "No User Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        for (String empNo : selectedEmpNos)
        {
        if (!userManager.validateTerminateUser(null, empNo)) return;
        }

        boolean isMultiple   = selectedEmpNos.size() > 1;
        String  displayText  = isMultiple
                ? "ARE YOU SURE YOU WANT TO <b>TERMINATE</b> THESE USERS?"
                : "ARE YOU SURE YOU WANT TO <b>TERMINATE</b><br>USER " + selectedEmpNos.get(0) + "?";

        pnlOverlay = new JPanel(null) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0, 80));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        pnlOverlay.setBounds(0, 0, 940, 680);
        pnlOverlay.setOpaque(false);

        int cardW = 560, cardH = 280;
        int cardX = (940 - cardW) / 2;
        int cardY = (680 - cardH) / 2;

        JPanel pnlCard = new JPanel(null);
        pnlCard.setBounds(cardX, cardY, cardW, cardH);
        pnlCard.setBackground(colorOverlayBg);
        pnlCard.setBorder(BorderFactory.createLineBorder(new Color(0xCC, 0xCC, 0xCC), 1));
        pnlOverlay.add(pnlCard);

        JPanel pnlTitle = new JPanel(null);
        pnlTitle.setBounds(0, 0, cardW, 56);
        pnlTitle.setBackground(colorRed);
        pnlCard.add(pnlTitle);

        JLabel lblTitle = new JLabel("TERMINATE USER?", SwingConstants.CENTER);
        lblTitle.setBounds(0, 10, cardW, 36);
        lblTitle.setFont(fontHeader);
        lblTitle.setForeground(colorWhite);
        pnlTitle.add(lblTitle);

        JLabel lblBody = new JLabel("<html><div style='text-align:center'>" + displayText + "</div></html>", SwingConstants.CENTER);
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
        btnConfirm.addActionListener(ev ->
        {
            for (String empNo : selectedEmpNos) userManager.terminateUser(empNo);
            removeOverlay();
            editMode = false;
            refreshTable();
            refreshButtons();
            JOptionPane.showMessageDialog(this, "User(s) terminated successfully.", "Terminated", JOptionPane.INFORMATION_MESSAGE);
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
    
    private void showReactivateOverlay()
    {
        removeOverlay();
        
        List<String> selectedEmpNos = getSelectedEmpNos();
        
        if (selectedEmpNos.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please select a user to reactivate.", "No User Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        for (String empNo : selectedEmpNos)
        {
        if (!userManager.validateReactivateUser(null, empNo)) return;
        }
        
        boolean isMultiple = selectedEmpNos.size() > 1;
        String displayText = isMultiple
                ? "ARE YOU SURE YOU WANT TO <b>REACTIVATE</b> THESE USERS?"
                : "ARE YOU SURE YOU WANT TO <b>REACTIVATE</b><br>USER " + selectedEmpNos.get(0) + "?";
        
        pnlOverlay = new JPanel(null) {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(0, 0, 0, 80));
            g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        
        pnlOverlay.setBounds(0, 0, 940, 680);
        pnlOverlay.setOpaque(false);

        int cardW = 560, cardH = 280;
        int cardX = (940 - cardW) / 2;
        int cardY = (680 - cardH) / 2;
        
        JPanel pnlCard = new JPanel(null);
        pnlCard.setBounds(cardX, cardY, cardW, cardH);
        pnlCard.setBackground(colorOverlayBg);
        pnlCard.setBorder(BorderFactory.createLineBorder(new Color(0xCC, 0xCC, 0xCC), 1));
        pnlOverlay.add(pnlCard);
        
        JPanel pnlTitle = new JPanel(null);
        pnlTitle.setBounds(0, 0, cardW, 56);
        pnlTitle.setBackground(colorActive);
        pnlCard.add(pnlTitle);
        
        JLabel lblTitle = new JLabel("REACTIVATE USER?", SwingConstants.CENTER);
        lblTitle.setBounds(0, 10, cardW, 36);
        lblTitle.setFont(fontHeader);
        lblTitle.setForeground(colorWhite);
        pnlTitle.add(lblTitle);
        
        JLabel lblBody = new JLabel("<html><div style='text-align:center'>" + displayText + "</div></html>", SwingConstants.CENTER);
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
        btnConfirm.setForeground(colorActive);
        btnConfirm.setFocusPainted(false);
        btnConfirm.setBorderPainted(false);
        btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConfirm.addActionListener(ev ->
        {
            for (String empNo : selectedEmpNos) userManager.reactivateUser(empNo);
            removeOverlay();
            editMode = false;
            refreshTable();
            refreshButtons();
            JOptionPane.showMessageDialog(this, "User(s) reactivated successfully.", "Reactivated", JOptionPane.INFORMATION_MESSAGE);
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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if      (e.getSource() == btnAddUser)      { showAddUserOverlay(); }
        else if (e.getSource() == btnEditUsers)    { editMode = true;  buildTableRows(); refreshButtons(); }
        else if (e.getSource() == btnConfirmEdit)  { editMode = false; buildTableRows(); refreshButtons(); JOptionPane.showMessageDialog(this, "Changes saved successfully!", "Confirm Edit", JOptionPane.INFORMATION_MESSAGE); }
        else if (e.getSource() == btnTerminateUser)  { showTerminateOverlay(); }
        else if (e.getSource() == btnReactivateUser) { showReactivateOverlay(); }
    }
}