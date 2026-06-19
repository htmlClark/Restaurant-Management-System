package MainClasses;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class homePage extends JFrame implements ActionListener
{
    private JLabel lblHeading, lblStatus;
    private JButton btnStart, btnInv;
    
    homePage()
    {
    header();

    setSize (1280,800);
    setTitle("Restaurant Management System");
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    getContentPane().setBackground(Color.decode("#B71C1C"));
    }
    
    private void header()
    {
        ImageIcon restaurantTitle = new ImageIcon (getClass().getResource("/src_pack/images/name.png"));
        Image titleSize = restaurantTitle.getImage().getScaledInstance(1100, 300, Image.SCALE_SMOOTH);
        lblHeading = new JLabel (new ImageIcon(titleSize));
            lblHeading.setBounds(100, 150, 1050, 300);
            add(lblHeading);

        lblStatus = new JLabel ("");
            lblStatus.setBounds(350,550, 300, 30);
            add(lblStatus);
            
        btnStart = new JButton ("GET STARTED");
            btnStart.setBounds(480,550,300,40);
            btnStart.setBackground(Color.decode("#FFF8E1"));
            btnStart.setBorderPainted(false);
            btnStart.addActionListener(this);
            add(btnStart);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) 
        {
            dispose();
            LoginPage login = new LoginPage();
            login.setVisible(true);
        }
}}
