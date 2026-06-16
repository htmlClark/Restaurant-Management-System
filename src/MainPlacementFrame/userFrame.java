package MainPlacementFrame;
import HeaderPanels.Header_Staff;
import RestaurantManagementSystem_.Products.*;
import SidePanels.*;

import javax.swing.*;
import java.awt.event.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class userFrame extends JFrame implements ActionListener{
    private SidePanel_Staff sidePanel;

    public userFrame()
    {
        setSize(1280, 800);
        setTitle("PINOY PLATTERS  |  RMS");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        sidePanel = new SidePanel_Staff();  // create ONCE
        add(sidePanel);
        add(new Header_Staff("USER"));
        add(new Products());

        setVisible(true);
    }

    public void switchPanel(JPanel thisPanel)
    {
        getContentPane().removeAll();
        add(sidePanel);                     // reuse the SAME instance
        add(new Header_Staff("USER"));
        add(thisPanel);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}