package MainPlacementFrame;
import HeaderPanels.Header_Staff;
import RestaurantManagementSystem_.Products.*;
import SidePanels.*;

import javax.swing.*;
import java.awt.event.*;

public class userFrame extends JFrame implements ActionListener{
    public userFrame()
    {
        setSize (1280,800);
        setTitle("PINOY PLATTERS  |  RMS");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(new SidePanel_Staff());
        add(new Header_Staff("USER"));
        add (new Products());

        setVisible(true);
    }

    public void switchPanel(JPanel thisPanel)
    {
        getContentPane().removeAll();
        add(new SidePanel_Staff());
        add(new Header_Staff("USER"));
        add(thisPanel);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
}
