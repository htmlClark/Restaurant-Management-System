package RestaurantManagementSystem_.Products;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainCourse extends JPanel implements ActionListener{
    private ProductSummary summaryPanel;
    private JButton btnTuron, btnHaloHalo, btnBack;
    private JLabel lblBeverage, lbl;

    public MainCourse(ProductSummary summaryPanel)
    {
        this.summaryPanel = summaryPanel;
        mainCourse();
        elements();

        setBounds (300,80,980,720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));

        add(summaryPanel);
    }

    private void elements()
    {
        //For Main Course Label
        ImageIcon appLogo = new ImageIcon (getClass().getResource("/src_pack/images/main_bg.png"));
        Image appSize = appLogo.getImage().getScaledInstance(350, 78, Image.SCALE_DEFAULT);

        lblBeverage = new JLabel(new ImageIcon(appSize));
        lblBeverage.setBounds(30,20,350,78);
        add(lblBeverage);

        //Meat & Poultry

        //Vegetables

        //Back Button
        ImageIcon backLogo = new ImageIcon (getClass().getResource("/src_pack/images/back.png"));
        Image backSize = backLogo.getImage().getScaledInstance(150, 33, Image.SCALE_DEFAULT);

        btnBack = new JButton(new ImageIcon(backSize));
        btnBack.setBackground(Color.decode("#B71C1C"));
        btnBack.setBounds(400,620,150,33);
        btnBack.addActionListener(this);
        add(btnBack);
    }

    private void mainCourse()
    {
        //Chicken Adobo
        ImageIcon trnLogo = new ImageIcon (getClass().getResource("/src_pack/images/37.png"));
        Image trnSize = trnLogo.getImage().getScaledInstance(180, 200, Image.SCALE_DEFAULT);

        btnTuron = new JButton(new ImageIcon(trnSize));
        btnTuron.setBounds(30,120,200,220);
        btnTuron.setBackground(Color.decode("#F2D0BD"));
        btnTuron.addActionListener(this);
        add(btnTuron);

        //Bicol Express
        ImageIcon haloLogo = new ImageIcon (getClass().getResource("/src_pack/images/38.png"));
        Image haloSize = haloLogo.getImage().getScaledInstance(180, 200, Image.SCALE_DEFAULT);

        btnHaloHalo = new JButton(new ImageIcon(haloSize));
        btnHaloHalo.setBounds(260,120,200,220);
        btnHaloHalo.setBackground(Color.decode("#F2D0BD"));
        btnHaloHalo.addActionListener(this);
        add(btnHaloHalo);

        //Pork Sisig
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
        if (e.getSource() == btnTuron)
        {
            summaryPanel.addProduct("TURON", 180);
        }
        if (e.getSource() == btnHaloHalo)
        {
            summaryPanel.addProduct("HALO-HALO", 120);
        }
    }
}
