package RestaurantManagementSystem_.Products;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainCourse extends JPanel implements ActionListener{
    private ProductSummary summaryPanel;
    private JButton btnAdobo, btnBicolExp, btnSisig, btnLaing, btnPinakbet, btnTorta, btnBack;
    private JLabel lblMainCourse, lblMeat, lblVeggie;

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

        lblMainCourse = new JLabel(new ImageIcon(appSize));
            lblMainCourse.setBounds(30,20,350,78);
            add(lblMainCourse);

        //Meat & Poultry
        lblMeat = new JLabel("MEAT & POULTRY");
            lblMeat.setFont(new Font("Arial",Font.BOLD,20));
            lblMeat.setBounds(30,110,200,30);
            add(lblMeat);

        //Vegetables
        lblVeggie = new JLabel("VEGETABLES");
            lblVeggie.setFont(new Font("Arial",Font.BOLD,20));
            lblVeggie.setBounds(30,360,200,30);
            add(lblVeggie);

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
        ImageIcon adbLogo = new ImageIcon (getClass().getResource("/src_pack/images/31.png"));
        Image adbSize = adbLogo.getImage().getScaledInstance(160, 190, Image.SCALE_DEFAULT);

        btnAdobo = new JButton(new ImageIcon(adbSize));
            btnAdobo.setBounds(30,150,160, 190);
            btnAdobo.setBackground(Color.decode("#F2D0BD"));
            btnAdobo.addActionListener(this);
            add(btnAdobo);

        //Bicol Express
        ImageIcon bclLogo = new ImageIcon (getClass().getResource("/src_pack/images/32.png"));
        Image bclSize = bclLogo.getImage().getScaledInstance(160, 190, Image.SCALE_DEFAULT);

        btnBicolExp = new JButton(new ImageIcon(bclSize));
            btnBicolExp.setBounds(200,150,160, 190);
            btnBicolExp.setBackground(Color.DARK_GRAY);
            btnBicolExp.addActionListener(this);
            add(btnBicolExp);

        //Pork Sisig
        ImageIcon ssgLogo = new ImageIcon (getClass().getResource("/src_pack/images/33.png"));
        Image ssgSize = ssgLogo.getImage().getScaledInstance(160, 190, Image.SCALE_DEFAULT);

        btnSisig = new JButton(new ImageIcon(ssgSize));
            btnSisig.setBounds(370,150,160, 190);
            btnSisig.setBackground(Color.DARK_GRAY);
            btnSisig.addActionListener(this);
            add(btnSisig);

        //Laing
        ImageIcon lngLogo = new ImageIcon (getClass().getResource("/src_pack/images/34.png"));
        Image lngSize = lngLogo.getImage().getScaledInstance(160, 190, Image.SCALE_DEFAULT);

        btnLaing = new JButton(new ImageIcon(lngSize));
            btnLaing.setBounds(30,400,160, 190);
            btnLaing.setBackground(Color.DARK_GRAY);
            btnLaing.addActionListener(this);
            add(btnLaing);

        //Pinakbet
        ImageIcon pnkLogo = new ImageIcon (getClass().getResource("/src_pack/images/35.png"));
        Image pnkSize = pnkLogo.getImage().getScaledInstance(160, 190, Image.SCALE_DEFAULT);

        btnPinakbet = new JButton(new ImageIcon(pnkSize));
            btnPinakbet.setBounds(200,400,160, 190);
            btnPinakbet.setBackground(Color.DARK_GRAY);
            btnPinakbet.addActionListener(this);
            add(btnPinakbet);

        //Tortang Talong
        ImageIcon trtaLogo = new ImageIcon (getClass().getResource("/src_pack/images/36.png"));
        Image trtaSize = trtaLogo.getImage().getScaledInstance(160, 190, Image.SCALE_DEFAULT);

        btnTorta = new JButton(new ImageIcon(trtaSize));
            btnTorta.setBounds(370,400,160, 190);
            btnTorta.setBackground(Color.decode("#F2D0BD"));
            btnTorta.addActionListener(this);
            add(btnTorta);
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
        if (e.getSource() == btnAdobo)
        {
            summaryPanel.addProduct("CHKN ADB", 160);
        }
        if (e.getSource() == btnBicolExp)
        {
            summaryPanel.addProduct("BCL EXP", 180);
        }
        if (e.getSource() == btnSisig)
        {
            summaryPanel.addProduct("PRK SSG", 190);
        }
        if (e.getSource() == btnLaing)
        {
            summaryPanel.addProduct("LNG", 140);
        }
        if (e.getSource() == btnPinakbet)
        {
            summaryPanel.addProduct("PNKBT", 150);
        }
        if (e.getSource() == btnTorta)
        {
            summaryPanel.addProduct("TRTA TLNG", 120);
        }
    }
}
