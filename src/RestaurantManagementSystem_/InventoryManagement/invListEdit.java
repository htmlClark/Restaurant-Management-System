
package restaurantmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class invListEdit extends JFrame implements ActionListener{

    invListEdit(){
    headerLogo();
    dashboardMenu();
    functionMenu();
    setTitle ("Edit Item");
    setSize (750,500);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);

    }

    private JPanel panelHeaderLogo, panelDashboard, panelFunctionMenu;
    private JLabel lblLogo, lblOld, lblID, lblName, lblQty, lblCategory, lblMeasurement;
    private JTextField txtOldID;
    private JTextField txtNewID, txtName, txtQuantity;
    private JComboBox cbCategory, cbMeasurement;
    private JButton btnEdit;

    private void headerLogo() {
        panelHeaderLogo = new JPanel();
        panelHeaderLogo.setBounds(0, 0, 250, 75);
        panelHeaderLogo.setBackground(Color.decode("#B71C1C"));
        panelHeaderLogo.setLayout(null);
        add(panelHeaderLogo);

        ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
        Image logo = icon.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(logo);
        lblLogo = new JLabel(resizedIcon);
        lblLogo.setBounds(0, 0, 250, 75);

        panelHeaderLogo.add(lblLogo);
    }

    private void dashboardMenu() {

        panelDashboard = new JPanel();
        panelDashboard.setBounds(250, 0, 500, 75);
        panelDashboard.setBackground(Color.decode("#B71C1C"));
        panelDashboard.setLayout(null);
        add(panelDashboard);

    }

    private void functionMenu(){
        panelFunctionMenu = new JPanel();
        panelFunctionMenu.setBounds(0, 75, 750, 450);
        panelFunctionMenu.setBackground(Color.decode("#FFF8E1"));
        panelFunctionMenu.setLayout(null);
        add(panelFunctionMenu);

        lblOld = new JLabel("OLD ID:");
        lblOld.setBounds(30, 30, 100, 25);

        txtOldID = new JTextField();
        txtOldID.setBounds(120, 30, 150, 25);

        lblName = new JLabel("NAME:");
        lblName.setBounds(30, 90, 100, 25);

        txtName = new JTextField();
        txtName.setBounds(120, 90, 150, 25);

        lblQty = new JLabel("QUANTITY:");
        lblQty.setBounds(30, 140, 100, 25);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(120, 140, 150, 25);

        lblCategory = new JLabel("CATEGORY:");
        lblCategory.setBounds(300, 90, 100, 25);

        String[] categories = {"MEAT", "VEGETABLE", "SEAFOOD", "SEASONING", "CONDIMENT", "DAIRY"};
        cbCategory = new JComboBox<>(categories);
        cbCategory.setBounds(420, 90, 150, 25);

        lblMeasurement = new JLabel("MEASUREMENT:");
        lblMeasurement.setBounds(300, 140, 120, 25);

        String[] measurements = {"KG", "GRAM", "PACK", "BOTTLE", "BOX", "PIECE"};
        cbMeasurement = new JComboBox<>(measurements);
        cbMeasurement.setBounds(420, 140, 150, 25);

        btnEdit = new JButton("EDIT");
        btnEdit.setBounds(300, 200, 120, 30);
        btnEdit.setBackground(Color.decode("#B71C1C"));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFocusPainted(false);

        panelFunctionMenu.add(lblOld);
        panelFunctionMenu.add(txtOldID);

        panelFunctionMenu.add(lblName);
        panelFunctionMenu.add(txtName);

        panelFunctionMenu.add(lblQty);
        panelFunctionMenu.add(txtQuantity);

        panelFunctionMenu.add(lblCategory);
        panelFunctionMenu.add(cbCategory);

        panelFunctionMenu.add(lblMeasurement);
        panelFunctionMenu.add(cbMeasurement);

        panelFunctionMenu.add(btnEdit);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

