
package restaurantmanagementsystem;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class inventoryManagement extends JFrame implements ActionListener{

    private JPanel panelDashboard, panelHeaderLogo, panelHeaderBar, panelFunctionMenu;
    private JLabel lblLogo;
    private JTextField txtFieldSearch;
    private JButton btnBack, btnInvMain, btnList, btnRecipe, btnDelivery, btnLogout, btnAdd, btnEdit, btnRemove;
    inventoryManagement()
    {
        
    dashboardMenu();
    headerLogo();
    headerBar();
    functionMenu();
            
    setTitle ("Inventory Management");
    setSize (1280,800);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
    
    }
    
    
    private void headerLogo() {
        panelHeaderLogo = new JPanel();
        panelHeaderLogo.setBounds(0, 0, 250, 75);
        panelHeaderLogo.setBackground(Color.decode("#B71C1C"));
        panelHeaderLogo.setLayout(null);
        add(panelHeaderLogo);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
        Image logo = icon.getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(logo);
        lblLogo = new JLabel(resizedIcon);
        lblLogo.setBounds(0, 0, 250, 75);

        panelHeaderLogo.add(lblLogo);
    }
    
    private void headerBar(){
        panelHeaderBar = new JPanel();
        panelHeaderBar.setBounds(250, 0, 1030, 75);
        panelHeaderBar.setBackground(Color.decode("#f5cfba"));
        panelHeaderBar.setLayout(null);
        add(panelHeaderBar);
        
        txtFieldSearch = new JTextField();
        txtFieldSearch.setBounds(25, 20, 500, 35);
        txtFieldSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        txtFieldSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        txtFieldSearch.setBackground(Color.decode("#FFF8E1"));
        txtFieldSearch.setBorder(null);
        txtFieldSearch.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        panelHeaderBar.add(txtFieldSearch); 
    }
    
    private void dashboardMenu() {
    
        panelDashboard = new JPanel();
        panelDashboard.setBounds(0, 75, 250, 700);
        panelDashboard.setBackground(Color.decode("#366379"));
        panelDashboard.setLayout(null);
        add(panelDashboard);
        
        btnBack = new JButton();
        btnBack.setText("DASHBOARD");
        btnBack.setBounds(0, 0, 250, 50);
        btnBack.setBackground(Color.LIGHT_GRAY);
        btnBack.setLayout(null);
        btnBack.addActionListener(this);
        panelDashboard.add(btnBack);
        
        btnInvMain = new JButton();
        btnInvMain.setText("-");
        btnInvMain.setBounds(0, 100, 250, 50);
        btnInvMain.setBackground(Color.LIGHT_GRAY);
        btnInvMain.setLayout(null);
        btnInvMain.addActionListener(this);
        panelDashboard.add(btnInvMain);
        
        btnList = new JButton();
        btnList.setText("LIST");
        btnList.setBounds(0, 175, 250, 50);
        btnList.setBackground(Color.LIGHT_GRAY);
        btnList.setLayout(null);
        btnList.addActionListener(this);
        panelDashboard.add(btnList);
        
        btnRecipe = new JButton();
        btnRecipe.setText("RECIPE");
        btnRecipe.setBounds(0, 250, 250, 50);
        btnRecipe.setBackground(Color.LIGHT_GRAY);
        btnRecipe.setLayout(null);
        btnRecipe.addActionListener(this);
        panelDashboard.add(btnRecipe);
        
        btnDelivery = new JButton();
        btnDelivery.setText("DELIVERY");
        btnDelivery.setBounds(0, 325, 250, 50);
        btnDelivery.setBackground(Color.LIGHT_GRAY);
        btnDelivery.setLayout(null);
        btnDelivery.addActionListener(this);

        panelDashboard.add(btnDelivery);
        
        btnLogout = new JButton();
        btnLogout.setText("LOGOUT");
        btnLogout.setBounds(0, 625, 250, 30);
        btnLogout.setBackground(Color.LIGHT_GRAY);
        btnLogout.setLayout(null);
        btnLogout.addActionListener(this);

        styleButton(btnInvMain);
        styleButton(btnList);
        styleButton(btnRecipe);
        styleButton(btnDelivery);
        styleButton(btnLogout);
        
        btnBack.setFont(new Font("Open Sans", Font.BOLD, 25));
        btnInvMain.setFont(new Font("Open Sans", Font.BOLD, 25));
        btnList.setFont(new Font("Open Sans", Font.BOLD, 25));
        btnRecipe.setFont(new Font("Open Sans", Font.BOLD, 25));
        btnDelivery.setFont(new Font("Open Sans", Font.BOLD, 25));
        btnLogout.setFont(new Font("Open Sans", Font.BOLD, 25));
        
        panelDashboard.add(btnLogout);
    }
    
    
    private void functionMenu(){
        panelFunctionMenu = new JPanel();
        panelFunctionMenu.setBounds(250, 75, 1030, 700);
        panelFunctionMenu.setBackground(Color.decode("#FFF8E1"));
        panelFunctionMenu.setLayout(null);
        add(panelFunctionMenu);
        
        btnAdd = new JButton();
        btnAdd.setText("ADD");
        btnAdd.setBounds(150, 625, 200, 30);
        btnAdd.setBackground(Color.LIGHT_GRAY);
        btnAdd.setLayout(null);
        panelFunctionMenu.add(btnAdd);
        
        btnEdit = new JButton();
        btnEdit.setText("EDIT");
        btnEdit.setBounds(400, 625, 200, 30);
        btnEdit.setBackground(Color.LIGHT_GRAY);
        btnEdit.setLayout(null);
        panelFunctionMenu.add(btnEdit);
        
        btnRemove = new JButton();
        btnRemove.setText("REMOVE");
        btnRemove.setBounds(650, 625, 200, 30);
        btnRemove.setBackground(Color.LIGHT_GRAY);
        btnRemove.setLayout(null);
        panelFunctionMenu.add(btnRemove);
      
        stylebtnFunction(btnAdd);
        stylebtnFunction(btnEdit);
        stylebtnFunction(btnRemove);
    }
    
    private void styleButton(JButton btn) {
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setForeground(Color.WHITE);

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setOpaque(true);
                btn.setBackground(Color.decode("#1b4a62"));
            }

            public void mouseExited(MouseEvent e) {
                btn.setOpaque(false);
            }
        });
    }
    
    private void stylebtnFunction(JButton btn) {
        btn.setBackground(Color.decode("#e7191f"));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);

    btn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent e) {
            btn.setBackground(Color.decode("#b71c1c"));
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            btn.setBackground(Color.decode("#e7191f"));
        }
    });
}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnList) {
            dispose();
            new inventoryManagement();
        }

        else if (e.getSource() == btnRecipe){
            dispose();
            new invManagementRecipe();
        }

        else if (e.getSource() == btnDelivery){
            dispose();
            new inventoryManagementDelivery();
        }

        else if (e.getSource() == btnLogout){
            dispose();
            new inventoryManagement();
        }
         
    }
    
}
