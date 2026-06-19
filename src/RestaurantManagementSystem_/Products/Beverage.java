package RestaurantManagementSystem_.Products;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Beverage extends JPanel implements ActionListener {
    private ProductSummary summaryPanel;
    private JButton btnSago, btnBuko, btnIcedTea, btnWater, btnBack;
    private JLabel lblBeverage;

    public Beverage(ProductSummary summaryPanel)
    {
        this.summaryPanel = summaryPanel;
        beverages();
        elements();

        setBounds (300,80,980,720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));

        add(summaryPanel);
    }

    private void elements()
    {
        //For Beverage Label
        ImageIcon appLogo = new ImageIcon (getClass().getResource("/src_pack/images/beverage_bg.png"));
        Image appSize = appLogo.getImage().getScaledInstance(350, 78, Image.SCALE_DEFAULT);

        lblBeverage = new JLabel(new ImageIcon(appSize));
            lblBeverage.setBounds(30,20,350,78);
            add(lblBeverage);

        //Back Button
        ImageIcon backLogo = new ImageIcon (getClass().getResource("/src_pack/images/back.png"));
        Image backSize = backLogo.getImage().getScaledInstance(150, 33, Image.SCALE_DEFAULT);

        btnBack = new JButton(new ImageIcon(backSize));
        btnBack.setBackground(Color.decode("#B71C1C"));
        btnBack.setBounds(400,620,150,33);
        btnBack.addActionListener(this);
        add(btnBack);
    }

    private void beverages()
    {
        //Sago't Gulaman
        ImageIcon sagoLogo = new ImageIcon (getClass().getResource("/src_pack/images/39.png"));
        Image sagoSize = sagoLogo.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);

        btnSago = new JButton(new ImageIcon(sagoSize));
            btnSago.setBounds(30,120,200,220);
            btnSago.setBackground(Color.DARK_GRAY);
            btnSago.addActionListener(this);
            add(btnSago);

        //Buko Juice
        ImageIcon bukoLogo = new ImageIcon (getClass().getResource("/src_pack/images/40.png"));
        Image bukoSize = bukoLogo.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);

        btnBuko = new JButton(new ImageIcon(bukoSize));
            btnBuko.setBounds(260,120,200,220);
            btnBuko.setBackground(Color.decode("#F2D0BD"));
            btnBuko.addActionListener(this);
            add(btnBuko);

        //Iced Tea
        ImageIcon teaLogo = new ImageIcon (getClass().getResource("/src_pack/images/41.png"));
        Image teaSize = teaLogo.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);

        btnIcedTea = new JButton(new ImageIcon(teaSize));
            btnIcedTea.setBounds(30,370,200,220);
            btnIcedTea.setBackground(Color.decode("#F2D0BD"));
            btnIcedTea.addActionListener(this);
            add(btnIcedTea);

        //Bottled Wotoh
        ImageIcon waterLogo = new ImageIcon (getClass().getResource("/src_pack/images/42.png"));
        Image waterSize = waterLogo.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);

        btnWater = new JButton(new ImageIcon(waterSize));
            btnWater.setBounds(260,370,200,220);
            btnWater.setBackground(Color.DARK_GRAY);
            btnWater.addActionListener(this);
            add(btnWater);
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
        if (e.getSource() == btnSago)
        {
            summaryPanel.addProduct("SG GLMN", 60);
        }
        if (e.getSource() == btnBuko)
        {
            summaryPanel.addProduct("BK JC", 70);
        }
        if (e.getSource() == btnIcedTea)
        {
            summaryPanel.addProduct("ICD TEA", 50);
        }
        if (e.getSource() == btnWater)
        {
            summaryPanel.addProduct("BTLD WTR", 25);
        }
    }
}
