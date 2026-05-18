package SidePanels;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SidePanel_Admin extends JPanel implements ActionListener{
    private JButton btnDashboard, btnProducts, btnInventory, btnWasteLogs, btnDelivery, btnReport, btnLogout;
    private JLabel lblLogo;
    
    
    public SidePanel_Admin()
    {
        panelButtons();
        
        //this is for the restaurant logo
        ImageIcon restuarantLogo = new ImageIcon (getClass().getResource("/images/logo.png"));
        Image titleSize = restuarantLogo.getImage().getScaledInstance(300, 80, Image.SCALE_DEFAULT);
        lblLogo = new JLabel (new ImageIcon(titleSize));
            lblLogo.setBounds(0, 0, 300, 80);
            add(lblLogo);
        
        setLayout(null);
        setBackground(Color.decode("#366379"));
        setBounds(0,0,300,1280);
    }
    
    public void panelButtons() {
        //Dashboard
        ImageIcon dashboard = new ImageIcon (getClass().getResource("/images/dashboard.png"));
        Image dashboardSize = dashboard.getImage().getScaledInstance(300, 80, Image.SCALE_DEFAULT);
        btnDashboard = new JButton(new ImageIcon(dashboardSize));
            btnDashboard.setBounds(0, 80, 300, 80);
            btnDashboard.setBorderPainted(false);
            btnDashboard.addActionListener(this);
            btnDashboard.setBackground(Color.decode("#366379"));
            add(btnDashboard);
        
        //Products   
        ImageIcon prodLogo = new ImageIcon (getClass().getResource("/images/product.png"));
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
        ImageIcon invLogo = new ImageIcon (getClass().getResource("/images/inventory.png"));
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
            
        //Summary Report
        ImageIcon reportLogo = new ImageIcon (getClass().getResource("/images/report.png"));
        Image reportSize = reportLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        
        btnReport = new JButton("   SUMMARY REPORT",new ImageIcon(reportSize));
            btnReport.setBounds(0, 320, 300, 80);
            btnReport.setForeground(Color.WHITE);
            btnReport.setBackground(Color.decode("#366379"));
            btnReport.setFont(new Font("Arial", Font.BOLD, 20));
            btnReport.setHorizontalAlignment(SwingConstants.LEFT);
            btnReport.setBorderPainted(false);
            btnReport.addActionListener(this);
            add(btnReport);
            
        //WasteLogs
        ImageIcon wasteLogo = new ImageIcon (getClass().getResource("/images/wastelog.png"));
        Image wasteSize = wasteLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        
        btnWasteLogs = new JButton("   WASTE LOGS",new ImageIcon(wasteSize));
            btnWasteLogs.setBounds(0, 400, 300, 80);
            btnWasteLogs.setForeground(Color.WHITE);
            btnWasteLogs.setBackground(Color.decode("#366379"));
            btnWasteLogs.setFont(new Font("Arial", Font.BOLD, 20));
            btnWasteLogs.setHorizontalAlignment(SwingConstants.LEFT);
            btnWasteLogs.setBorderPainted(false);
            btnWasteLogs.addActionListener(this);
            add(btnWasteLogs);
            
        //Delivery
        ImageIcon deliLogo = new ImageIcon (getClass().getResource("/images/delivery.png"));
        Image deliSize = deliLogo.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        
        btnDelivery = new JButton("  DELIVERY",new ImageIcon(deliSize));
            btnDelivery.setBounds(0, 480, 300, 80);
            btnDelivery.setForeground(Color.WHITE);
            btnDelivery.setBackground(Color.decode("#366379"));
            btnDelivery.setFont(new Font("Arial", Font.BOLD, 20));
            btnDelivery.setHorizontalAlignment(SwingConstants.LEFT);
            btnDelivery.setBorderPainted(false);
            btnDelivery.addActionListener(this);
            add(btnDelivery);    
            
        //Logout 
        ImageIcon logoutLogo = new ImageIcon (getClass().getResource("/images/logout.png"));
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
        
    }
}
