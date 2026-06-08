package MainPlacementFrame;
import RestaurantManagementSystem_.Products.*;
import SidePanels.*;

import javax.swing.*;
import java.awt.event.*;

public class adminFrame extends JFrame implements ActionListener{
    public adminFrame()
    {
        setSize (1280,800);
        setTitle("PINOY PLATTERS  |  RMS");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(new SidePanel_Admin());
        add (new Products());

        setVisible(true);
    }

    public void switchPanel(JPanel thisPanel)
    {
        getContentPane().removeAll();
        add(new SidePanel_Admin());
        add(thisPanel);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
