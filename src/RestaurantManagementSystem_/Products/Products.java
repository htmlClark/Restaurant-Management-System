package RestaurantManagementSystem_.Products;

import MainPlacementFrame.userFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Products extends JPanel implements ActionListener {
    private JButton btnAppetizer, btnMainCourse, btnDessert, btnBeverage;
    private JLabel lblSplash, lblFood;
    private JPanel contentPanel = null;

    public Products()
    {
        setBounds (300,80,980,720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));

        menuCourse();
        productBg();
    }

    private void menuCourse()
    {
        //Appetizer
        ImageIcon apptLogo = new ImageIcon (getClass().getResource("/src_pack/images/appetizer.png"));
        Image apptSize = apptLogo.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);

        btnAppetizer = new JButton(new ImageIcon(apptSize));
            btnAppetizer.setBackground(Color.decode("#B71C1C"));
            btnAppetizer.setBounds(40, 50,450, 100);
            btnAppetizer.addActionListener(this);
            add(btnAppetizer);

        //Main Course
        ImageIcon mainLogo = new ImageIcon (getClass().getResource("/src_pack/images/mainCourse.png"));
        Image mainSize = mainLogo.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);

        btnMainCourse = new JButton(new ImageIcon(mainSize));
            btnMainCourse.setBackground(Color.decode("#B71C1C"));
            btnMainCourse.setBounds(40, 190,450, 100);
            btnMainCourse.addActionListener(this);
            add(btnMainCourse);

        //Dessert
        ImageIcon dessLogo = new ImageIcon (getClass().getResource("/src_pack/images/dessert.png"));
        Image dessSize = dessLogo.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);

        btnDessert = new JButton(new ImageIcon(dessSize));
            btnDessert.setBackground(Color.decode("#B71C1C"));
            btnDessert.setBounds(40, 330,450, 100);
            btnDessert.addActionListener(this);
            add(btnDessert);

        //Beverage
        ImageIcon bevLogo = new ImageIcon (getClass().getResource("/src_pack/images/beverage.png"));
        Image bevSize = bevLogo.getImage().getScaledInstance(450, 100, Image.SCALE_DEFAULT);

        btnBeverage = new JButton(new ImageIcon(bevSize));
            btnBeverage.setBackground(Color.decode("#B71C1C"));
            btnBeverage.setBounds(40, 470,450, 100);
            btnBeverage.addActionListener(this);
            add(btnBeverage);
    }

    private void productBg()
    {
        ImageIcon foodImg = new ImageIcon (getClass().getResource("/src_pack/images/food_design.png"));
        Image foodSize = foodImg.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);

        lblFood = new JLabel (new ImageIcon(foodSize));
        lblFood.setBounds(550, 250, 500, 500);
        add(lblFood);


        ImageIcon splashImg = new ImageIcon (getClass().getResource("/src_pack/images/bg_design.png"));
        Image splashSize = splashImg.getImage().getScaledInstance(750, 750, Image.SCALE_SMOOTH);

        lblSplash = new JLabel (new ImageIcon(splashSize));
            lblSplash.setBounds(450, 0, 750, 750);
            add(lblSplash);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        userFrame frame = (userFrame) getParent().getParent().getParent().getParent();
        if (e.getSource() == btnAppetizer) {
            frame.switchPanel(new Appetizer());
        }
        else if (e.getSource() == btnMainCourse) {
            frame.switchPanel(new MainCourse());
        }
        else if (e.getSource() == btnDessert) {
            frame.switchPanel(new Dessert());
        }
        else if (e.getSource() == btnBeverage) {
            frame.switchPanel(new Beverage());
        }
    }
}
