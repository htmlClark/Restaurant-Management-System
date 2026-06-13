package MainPlacementFrame;
import HeaderPanels.*;
import RestaurantManagementSystem_.Products.*;
import SidePanels.*;

import javax.swing.*;
import java.awt.event.*;

public class adminFrame extends JFrame implements ActionListener{
    private SidePanel_Admin sidePanel;

    public adminFrame()
    {
        setSize(1280, 800);
        setTitle("PINOY PLATTERS  |  RMS");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        sidePanel = new SidePanel_Admin();
        add(sidePanel);
        add(new Header_Admin("ADMIN"));
        add(new Products());

        setVisible(true);
    }

    public void switchPanel(JPanel thisPanel)
    {
        getContentPane().removeAll();
        add(sidePanel);
        add(new Header_Admin("ADMIN"));
        add(thisPanel);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}