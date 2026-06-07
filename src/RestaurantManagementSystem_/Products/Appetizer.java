package RestaurantManagementSystem_.Products;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Appetizer extends JPanel implements ActionListener {
    private ProductSummary summaryPanel;
    private JButton btnShanghai, btnTokwa, btnChicharon, btnBack;
    private JLabel lblAppetizer;

    public Appetizer(ProductSummary summaryPanel)
    {
        this.summaryPanel = summaryPanel;
        appetizer();
        elements();

        setBounds (300,80,980,720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));

        add(summaryPanel);
    }

    private void elements()
    {
        //For Appetizer Label
        ImageIcon appLogo = new ImageIcon (getClass().getResource("/src_pack/images/beverage_bg.png"));
        Image appSize = appLogo.getImage().getScaledInstance(350, 78, Image.SCALE_DEFAULT);

        lblAppetizer = new JLabel(new ImageIcon(appSize));
        lblAppetizer.setBounds(30,20,350,78);
        add(lblAppetizer);

        //Back Button
        ImageIcon backLogo = new ImageIcon (getClass().getResource("/src_pack/images/back.png"));
        Image backSize = backLogo.getImage().getScaledInstance(150, 33, Image.SCALE_DEFAULT);

        btnBack = new JButton(new ImageIcon(backSize));
        btnBack.setBackground(Color.decode("#B71C1C"));
        btnBack.setBounds(400,620,150,33);
        btnBack.addActionListener(this);
        add(btnBack);
    }

    private void appetizer()
    {
        //Lumpiang Shanghai
        ImageIcon lmpLogo = new ImageIcon (getClass().getResource("/src_pack/images/28.png"));
        Image lmpSize = lmpLogo.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);

        btnShanghai = new JButton(new ImageIcon(lmpSize));
        btnShanghai.setBounds(30,120,200,220);
        btnShanghai.setBackground(Color.decode("#F2D0BD"));
        btnShanghai.addActionListener(this);
        add(btnShanghai);

        //Tokwa't Baboy
        ImageIcon tkwLogo = new ImageIcon (getClass().getResource("/src_pack/images/29.png"));
        Image tkwSize = tkwLogo.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);

        btnTokwa = new JButton(new ImageIcon(tkwSize));
        btnTokwa.setBounds(260,120,200,220);
        btnTokwa.setBackground(Color.decode("#F2D0BD"));
        btnTokwa.addActionListener(this);
        add(btnTokwa);

        //Chicharon Bulaklak
        ImageIcon chchaLogo = new ImageIcon (getClass().getResource("/src_pack/images/30.png"));
        Image chchaSize = chchaLogo.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);

        btnChicharon = new JButton(new ImageIcon(chchaSize));
        btnChicharon.setBounds(30,370,200,220);
        btnChicharon.setBackground(Color.decode("#F2D0BD"));
        btnChicharon.addActionListener(this);
        add(btnChicharon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        JPanel nextPanel = null;
        if (e.getSource() == btnBack)
        {
            frame.getContentPane().remove(this);
            frame.getContentPane().add(new Products(summaryPanel));
            frame.revalidate();
            frame.repaint();
        }
        if (e.getSource() == btnShanghai)
        {
            summaryPanel.addProduct("LMP SHNG", 120);
        }
        if (e.getSource() == btnTokwa)
        {
            summaryPanel.addProduct("TKW BBY", 150);
        }
        if (e.getSource() == btnChicharon)
        {
            summaryPanel.addProduct("CHRN BLK", 180);
        }
    }
}
