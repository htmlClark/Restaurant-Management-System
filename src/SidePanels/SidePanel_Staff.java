package SidePanels;
import MainPlacementFrame.userFrame;
import RestaurantManagementSystem_.InventoryManagement.*;
import RestaurantManagementSystem_.Products.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SidePanel_Staff extends JPanel implements ActionListener{
    private JButton btnDashboard, btnProducts, btnInventory, btnWasteLogs, btnDelivery, btnLogout;
    private JLabel lblLogo;
    private JPanel contentPanel;
    
    
    public SidePanel_Staff()
    {
        panelButtons();
        
        //this is for the restaurant logo
        ImageIcon restaurantLogo = new ImageIcon (getClass().getResource("/src_pack/images/logo.png"));
        Image titleSize = restaurantLogo.getImage().getScaledInstance(300, 80, Image.SCALE_DEFAULT);
        lblLogo = new JLabel (new ImageIcon(titleSize));
            lblLogo.setBounds(0, 0, 300, 80);
            add(lblLogo);
        
        setLayout(null);
        setBackground(Color.decode("#366379"));
        setBounds(0,0,300,1280);
    }
    
    public void panelButtons() {
        //Dashboard
        ImageIcon dashboard = new ImageIcon (getClass().getResource("/src_pack/images/dashboard.png"));
        Image dashboardSize = dashboard.getImage().getScaledInstance(300, 80, Image.SCALE_DEFAULT);
        btnDashboard = new JButton(new ImageIcon(dashboardSize));
            btnDashboard.setBounds(0, 80, 300, 80);
            btnDashboard.setBorderPainted(false);
            btnDashboard.addActionListener(this);
            btnDashboard.setBackground(Color.decode("#366379"));
            add(btnDashboard);
        
        //RestaurantManagementSystem_.Products
        ImageIcon prodLogo = new ImageIcon (getClass().getResource("/src_pack/images/product.png"));
        Image prodSize = prodLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        
        btnProducts = new JButton("   PRODUCTS",new ImageIcon(prodSize));
            btnProducts.setBounds(0, 160, 300, 80);
            btnProducts.setForeground(Color.WHITE);
            btnProducts.setBackground(Color.decode("#366379"));
            btnProducts.setFont(new Font("Arial", Font.BOLD, 20));
            btnProducts.setHorizontalAlignment(SwingConstants.LEFT);
            btnProducts.setBorderPainted(false);
            btnProducts.addActionListener(this);
            add(btnProducts);
            
        //Inventory
        ImageIcon invLogo = new ImageIcon (getClass().getResource("/src_pack/images/inventory.png"));
        Image invSize = invLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        
        btnInventory = new JButton("   INVENTORY",new ImageIcon(invSize));
            btnInventory.setBounds(0, 240, 300, 80);
            btnInventory.setForeground(Color.WHITE);
            btnInventory.setBackground(Color.decode("#366379"));
            btnInventory.setFont(new Font("Arial", Font.BOLD, 20));
            btnInventory.setHorizontalAlignment(SwingConstants.LEFT);
            btnInventory.setBorderPainted(false);
            btnInventory.addActionListener(this);
            add(btnInventory);
            
        //WasteLogs
        ImageIcon wasteLogo = new ImageIcon (getClass().getResource("/src_pack/images/wastelog.png"));
        Image wasteSize = wasteLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        
        btnWasteLogs = new JButton("   WASTE LOGS",new ImageIcon(wasteSize));
            btnWasteLogs.setBounds(0, 320, 300, 80);
            btnWasteLogs.setForeground(Color.WHITE);
            btnWasteLogs.setBackground(Color.decode("#366379"));
            btnWasteLogs.setFont(new Font("Arial", Font.BOLD, 20));
            btnWasteLogs.setHorizontalAlignment(SwingConstants.LEFT);
            btnWasteLogs.setBorderPainted(false);
            btnWasteLogs.addActionListener(this);
            add(btnWasteLogs);
            
        //Delivery
        ImageIcon deliLogo = new ImageIcon (getClass().getResource("/src_pack/images/delivery.png"));
        Image deliSize = deliLogo.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        
        btnDelivery = new JButton("  DELIVERY",new ImageIcon(deliSize));
            btnDelivery.setBounds(0, 400, 300, 80);
            btnDelivery.setForeground(Color.WHITE);
            btnDelivery.setBackground(Color.decode("#366379"));
            btnDelivery.setFont(new Font("Arial", Font.BOLD, 20));
            btnDelivery.setHorizontalAlignment(SwingConstants.LEFT);
            btnDelivery.setBorderPainted(false);
            btnDelivery.addActionListener(this);
            add(btnDelivery);    
            
        //Logout 
        ImageIcon logoutLogo = new ImageIcon (getClass().getResource("/src_pack/images/logout.png"));
        Image logoutSize = logoutLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        
        btnLogout = new JButton("   LOGOUT",new ImageIcon(logoutSize));
            btnLogout.setBounds(0, 680, 300, 80);
            btnLogout.setForeground(Color.WHITE);
            btnLogout.setBackground(Color.decode("#366379"));
            btnLogout.setFont(new Font("Arial", Font.BOLD, 20));
            btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
            btnLogout.setBorderPainted(false);
            btnLogout.addActionListener(this);
            add(btnLogout); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userFrame frame = (userFrame) getParent().getParent().getParent().getParent();
        if (e.getSource() == btnDashboard) {

        }
        else if (e.getSource() == btnProducts) {
            frame.switchPanel(new Products());
        }
        else if (e.getSource() == btnInventory) {
            frame.switchPanel(new inventoryManagement());
        }
        else if (e.getSource() == btnWasteLogs) {

        }
        else if (e.getSource() == btnDelivery) {

        }
        else if (e.getSource() == btnLogout) {
            int confirmLogout = JOptionPane.showConfirmDialog(null,"Are you sure you want to logout?","LOGOUT",JOptionPane.YES_NO_OPTION);
                if (confirmLogout == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
        }
    }
}
