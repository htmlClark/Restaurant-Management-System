package MainPlacementFrame;
import RestaurantManagementSystem_.Products.*;
import SidePanels.*;

import javax.swing.*;
import java.awt.event.*;

public class userFrame extends JFrame implements ActionListener{
    public userFrame()
    {
        setSize (1280,800);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(new SidePanel_Staff());
        add (new Products());

        setVisible(true);
    }

    public void switchPanel(JPanel thisPanel)
    {
        getContentPane().removeAll();
        add(new SidePanel_Staff());
        add(thisPanel);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
}
