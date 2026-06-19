package SidePanels;
import MainClasses.*;
import MainPlacementFrame.*;
import RestaurantManagementSystem_.InventoryManagement.*;
import RestaurantManagementSystem_.Products.*;
import RestaurantManagementSystem_.FoodWasteTracker.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SidePanel_Staff extends JPanel implements ActionListener{
    private JButton btnDashboard, btnProducts, btnInventory, btnWasteLogs, btnDelivery, btnLogout;
    private JLabel lblLogo;
    private JPanel contentPanel;

    private static final Color DEFAULT_COLOR = Color.decode("#366379");
    private static final Color ACTIVE_COLOR  = Color.decode("#1E3D4F");

    private JButton activeButton = null;

    public SidePanel_Staff()
    {
        panelButtons();

        ImageIcon restaurantLogo = new ImageIcon(getClass().getResource("/src_pack/images/logo.png"));
        Image titleSize = restaurantLogo.getImage().getScaledInstance(300, 80, Image.SCALE_DEFAULT);
        lblLogo = new JLabel(new ImageIcon(titleSize));
            lblLogo.setBounds(0, 0, 300, 80);
            add(lblLogo);

        setLayout(null);
        setBackground(DEFAULT_COLOR);
        setBounds(0, 0, 300, 1280);

        setActiveButton(btnProducts);
    }

    private void setActiveButton(JButton btn) {
        if (activeButton != null) {
            activeButton.setBackground(DEFAULT_COLOR);
        }
        activeButton = btn;
        if (activeButton != null) {
            activeButton.setBackground(ACTIVE_COLOR);
        }
    }

    public void panelButtons() {
        ImageIcon prodLogo = new ImageIcon(getClass().getResource("/src_pack/images/product.png"));
        Image prodSize = prodLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        btnProducts = new JButton("   PRODUCTS", new ImageIcon(prodSize));
            btnProducts.setBounds(0, 80, 300, 80);
            btnProducts.setForeground(Color.WHITE);
            btnProducts.setBackground(DEFAULT_COLOR);
            btnProducts.setFont(new Font("Arial", Font.BOLD, 20));
            btnProducts.setHorizontalAlignment(SwingConstants.LEFT);
            btnProducts.setBorderPainted(false);
            btnProducts.setFocusPainted(false);
            btnProducts.addActionListener(this);
            add(btnProducts);

        ImageIcon invLogo = new ImageIcon(getClass().getResource("/src_pack/images/inventory.png"));
        Image invSize = invLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        btnInventory = new JButton("   INVENTORY", new ImageIcon(invSize));
            btnInventory.setBounds(0, 160, 300, 80);
            btnInventory.setForeground(Color.WHITE);
            btnInventory.setBackground(DEFAULT_COLOR);
            btnInventory.setFont(new Font("Arial", Font.BOLD, 20));
            btnInventory.setHorizontalAlignment(SwingConstants.LEFT);
            btnInventory.setBorderPainted(false);
            btnInventory.setFocusPainted(false);
            btnInventory.addActionListener(this);
            add(btnInventory);

        ImageIcon wasteLogo = new ImageIcon(getClass().getResource("/src_pack/images/wastelog.png"));
        Image wasteSize = wasteLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        btnWasteLogs = new JButton("   WASTE LOGS", new ImageIcon(wasteSize));
            btnWasteLogs.setBounds(0, 240, 300, 80);
            btnWasteLogs.setForeground(Color.WHITE);
            btnWasteLogs.setBackground(DEFAULT_COLOR);
            btnWasteLogs.setFont(new Font("Arial", Font.BOLD, 20));
            btnWasteLogs.setHorizontalAlignment(SwingConstants.LEFT);
            btnWasteLogs.setBorderPainted(false);
            btnWasteLogs.setFocusPainted(false);
            btnWasteLogs.addActionListener(this);
            add(btnWasteLogs);

        ImageIcon logoutLogo = new ImageIcon(getClass().getResource("/src_pack/images/logout.png"));
        Image logoutSize = logoutLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        btnLogout = new JButton("   LOGOUT", new ImageIcon(logoutSize));
            btnLogout.setBounds(0, 680, 300, 80);
            btnLogout.setForeground(Color.WHITE);
            btnLogout.setBackground(DEFAULT_COLOR);
            btnLogout.setFont(new Font("Arial", Font.BOLD, 20));
            btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
            btnLogout.setBorderPainted(false);
            btnLogout.setFocusPainted(false);
            btnLogout.addActionListener(this);
            add(btnLogout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userFrame frame = (userFrame) SwingUtilities.getWindowAncestor(this);
        if (e.getSource() == btnProducts) {
            setActiveButton(btnProducts);
            frame.switchPanel(new Products());
        }
        else if (e.getSource() == btnInventory) {
            setActiveButton(btnInventory);
            frame.switchPanel(new invList());
        }
        else if (e.getSource() == btnWasteLogs) {
            setActiveButton(btnWasteLogs);
            frame.switchPanel(WasteLogPanel.forStaff());
        }
        else if (e.getSource() == btnDelivery) {
            setActiveButton(btnDelivery);
            frame.switchPanel(new invDelivery());
        }
        else if (e.getSource() == btnLogout) {
            int confirmLogout = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "LOGOUT", JOptionPane.YES_NO_OPTION);
            if (confirmLogout == JOptionPane.YES_OPTION) {
                frame.dispose();
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
            }
        }
    }
}