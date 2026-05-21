
package restaurantmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class invListRemove extends JFrame implements ActionListener{

    invListRemove(){
    headerLogo();
    dashboardMenu();
    functionMenu();

    setTitle ("Remove Item");
    setSize (750,500);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);

    }

    private JPanel panelHeaderLogo, panelDashboard, panelFunctionMenu;
    private JLabel lblLogo, lblID, lblName;
    private JTextField txtID, txtName;
    private JButton btnConfirm;

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

        lblID = new JLabel("ID:");
        lblID.setBounds(50, 80, 100, 25);


        txtID = new JTextField();
        txtID.setBounds(150, 80, 200, 25);


        lblName = new JLabel("NAME:");
        lblName.setBounds(50, 130, 100, 25);

        txtName = new JTextField();
        txtName.setBounds(150, 130, 200, 25);

        btnConfirm = new JButton("CONFIRM REMOVE");
        btnConfirm.setBounds(150, 200, 200, 35);
        btnConfirm.setBackground(Color.decode("#B71C1C"));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFocusPainted(false);

        panelFunctionMenu.add(txtName);
        panelFunctionMenu.add(btnConfirm);
        panelFunctionMenu.add(lblName);
        panelFunctionMenu.add(txtID);
        panelFunctionMenu.add(lblID);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
