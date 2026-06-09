package MainPlacementFrame;
import HeaderPanels.*;
import RestaurantManagementSystem_.Products.*;
import SidePanels.*;

import javax.swing.*;
import java.awt.event.*;

public class superAdminFrame extends JFrame implements ActionListener{
    public superAdminFrame()
    {
        setSize (1280,800);
        setTitle("PINOY PLATTERS  |  RMS");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(new SidePanel_SuperAdmin());
        add(new Header_SuperAdmin("SUPER ADMIN"));
        add (new Products());

        setVisible(true);
    }

    public void switchPanel(JPanel thisPanel)
    {
        getContentPane().removeAll();
        add(new SidePanel_SuperAdmin());
        add(new Header_SuperAdmin("SUPER ADMIN"));
        add(thisPanel);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
