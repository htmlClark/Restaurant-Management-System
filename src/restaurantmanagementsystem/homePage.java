package restaurantmanagementsystem;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class homePage extends JFrame implements ActionListener
{
    private JLabel lblTitle, lblSubtitle1, lblSubtitle2, lblStatus;
    private JButton btnLogin, btnInv;
    
    homePage()
    {
    header();
     
    setSize (1280,800);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
    }
    
    private void header()
    {
        lblTitle = new JLabel ("RESTAURANT TITLE");
            lblTitle.setBounds(250,200,800,50);
            lblTitle.setFont(new Font("Serif", Font.BOLD, 50));
            add(lblTitle);
        
        lblSubtitle1 = new JLabel ("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
            lblSubtitle1.setBounds(260,300,1000,50);
            lblSubtitle1.setFont(new Font("Arial", Font.PLAIN, 20));
            add(lblSubtitle1);
            
        lblSubtitle2 = new JLabel ("Vestibulum euismod, nunc at tincidunt posuere, ligula");
            lblSubtitle2.setBounds(265,320,1000,50);
            lblSubtitle2.setFont(new Font("Arial", Font.PLAIN, 20));
            add(lblSubtitle2);  
            
        lblStatus = new JLabel ("");
            lblStatus.setBounds(350,550, 300, 30);
            add(lblStatus);
            
        btnLogin = new JButton ("LOGIN");
            btnLogin.setBounds(350,500,300,30);
            btnLogin.addActionListener(this);
            add(btnLogin);
            
        btnInv = new JButton ("Inventory Management");
            btnInv.setBounds(350, 550, 300, 30);
            btnInv.addActionListener(this);
            add(btnInv) ;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
           if (e.getSource() == btnLogin) 
        {
            lblStatus.setText("LOG IN SUCCESSFULLY");
        } 
           else if (e.getSource() == btnInv){
               dispose();
               inventoryManagement inv = new inventoryManagement ();
               inv.setVisible(true);
           }
    }
    
}
