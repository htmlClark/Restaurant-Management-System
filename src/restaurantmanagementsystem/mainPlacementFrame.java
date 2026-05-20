package restaurantmanagementsystem;
import SidePanels.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mainPlacementFrame extends JFrame implements ActionListener{
    mainPlacementFrame(){
        showStaffPanel();
                
        setSize (1280,800);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);     
        setVisible(true);
    }

    public void showStaffPanel(){
//        SidePanels.SidePanel_Staff staffPanel = new SidePanel_Staff();
//        add(staffPanel);
        
        SidePanels.SidePanel_SuperAdmin adminPanel = new SidePanel_SuperAdmin();
        add(adminPanel);
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
