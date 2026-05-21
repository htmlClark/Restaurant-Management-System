
package restaurantmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class invRecipe extends JFrame implements ActionListener{
    private JPanel panelDashboard, panelHeaderLogo, panelHeaderBar, panelFunctionMenu, panelRecipe, panelTitle1;
    private JLabel lblLogo, lblRecipe, lblTitle, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
    private JTextField txtFieldSearch;
    private JComboBox cbSwitchClass, cbBox;
    private JScrollPane spAppetizer;

    invRecipe()
    {

    dashboardMenu();
    headerLogo();
    headerBar();
    functionMenu();

    setTitle ("Recipe");
    setSize (1280,800);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(true);
    setVisible(true);

    }

    private void headerLogo() {
        panelHeaderLogo = new JPanel();
        panelHeaderLogo.setBounds(0, 0, 300, 80);
        panelHeaderLogo.setBackground(Color.decode("#B71C1C"));
        panelHeaderLogo.setLayout(null);
        add(panelHeaderLogo);

        ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
        Image logo = icon.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(logo);
        lblLogo = new JLabel(resizedIcon);
        lblLogo.setBounds(0, 0, 300, 80);

        panelHeaderLogo.add(lblLogo);
    }

    private void headerBar(){
        panelHeaderBar = new JPanel();
        panelHeaderBar.setBounds(300, 0, 1030, 80);
        panelHeaderBar.setBackground(Color.decode("#f5cfba"));
        panelHeaderBar.setLayout(null);
        add(panelHeaderBar);

        txtFieldSearch = new JTextField();
        txtFieldSearch.setBounds(25, 20, 500, 35);
        txtFieldSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        txtFieldSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        txtFieldSearch.setBackground(Color.decode("#FFF8E1"));
        txtFieldSearch.setBorder(null);
        txtFieldSearch.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        panelHeaderBar.add(txtFieldSearch);
    }

    private void dashboardMenu() {

        panelDashboard = new JPanel();
        panelDashboard.setBounds(0, 80, 300, 700);
        panelDashboard.setBackground(Color.decode("#366379"));
        panelDashboard.setLayout(null);
        add(panelDashboard);

    }

    private void functionMenu(){
        panelFunctionMenu = new JPanel();
        panelFunctionMenu.setBounds(250, 80, 1030, 700);
        panelFunctionMenu.setBackground(Color.decode("#FFF8E1"));
        panelFunctionMenu.setLayout(null);
        add(panelFunctionMenu);

        String[] pages = {"RECIPE", "INVENTORY", "DELIVERY"};
        cbSwitchClass = new JComboBox<>(pages);
        cbSwitchClass.setBounds(745, 25, 250, 50);
        cbSwitchClass.addActionListener(e -> {
            String selected = (String) cbSwitchClass.getSelectedItem();

            dispose();

            if (selected.equals("INVENTORY")) {
                //TO FIX:
//                new invList();
//                dispose();
            }
            else if (selected.equals("RECIPE")) {
                new invRecipe();
                dispose();

            }
            else if (selected.equals("DELIVERY")) {
                //TO FIX:
//                new invDelivery();
//                dispose();
            }
        });

        panelTitle1 = new JPanel();
        panelTitle1.setBounds(75, 25, 300, 50);
        panelTitle1.setBackground(Color.decode("#B71C1C"));
            lblRecipe = new JLabel("RECIPE");
            lblRecipe.setBounds(75, 25, 200, 50);
            lblRecipe.setFont(new Font("Open Sans", Font.BOLD, 30));
            lblRecipe.setForeground(Color.WHITE);
        panelTitle1.add(lblRecipe);

        panelRecipe = new JPanel();
        panelRecipe.setBounds(75, 100, 600, 500);
        panelRecipe.setBackground(Color.decode("#B71C1C"));
        panelRecipe.setLayout(null);

        lblTitle = new JLabel("ADOBO");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(25, 25, 250, 30);

        lbl1 = new JLabel("PORK - 1/4 KG");
        lbl1.setFont(new Font("Arial", Font.ITALIC, 15));
        lbl1.setForeground(Color.WHITE);
        lbl1.setBounds(25, 55, 200, 30);

        lbl2 = new JLabel("SOY SAUCE - 1/4 CUP");
        lbl2.setFont(new Font("Arial", Font.ITALIC, 15));
        lbl2.setForeground(Color.WHITE);
        lbl2.setBounds(25, 85, 200, 30);

        lbl3 = new JLabel("VINEGAR - 1/4 CUP");
        lbl3.setFont(new Font("Arial", Font.ITALIC, 15));
        lbl3.setForeground(Color.WHITE);
        lbl3.setBounds(25, 115, 200, 30);

        lbl4 = new JLabel("GARLIC - 4 CLOVES");
        lbl4.setFont(new Font("Arial", Font.ITALIC, 15));
        lbl4.setForeground(Color.WHITE);
        lbl4.setBounds(25, 145, 200, 30);

        lbl5 = new JLabel("BAY LEAVES - 2 PIECES");
        lbl5.setFont(new Font("Arial", Font.ITALIC, 15));
        lbl5.setForeground(Color.WHITE);
        lbl5.setBounds(25, 175, 200, 30);

        lbl6 = new JLabel("PEPPER - 1 TBSP");
        lbl6.setFont(new Font("Arial", Font.ITALIC, 15));
        lbl6.setForeground(Color.WHITE);
        lbl6.setBounds(25, 205, 200, 30);

        lbl7 = new JLabel("WATER - 1 CUP");
        lbl7.setFont(new Font("Arial", Font.ITALIC, 15));
        lbl7.setForeground(Color.WHITE);
        lbl7.setBounds(25, 235, 200, 30);

        panelRecipe.add(lblTitle);
        panelRecipe.add(lbl1);
        panelRecipe.add(lbl2);
        panelRecipe.add(lbl3);
        panelRecipe.add(lbl4);
        panelRecipe.add(lbl5);
        panelRecipe.add(lbl6);
        panelRecipe.add(lbl7);

                String[] foods = {
                    "Adobo",
                    "Shanghai",
                    "Pansit",
                    "Halo-Halo",
                    "Gulaman"
                    };

        JComboBox<String> cbFoods = new JComboBox<>(foods);
        cbFoods.setBounds(745, 100, 250, 25);

        panelFunctionMenu.add(cbFoods);
        panelFunctionMenu.add(panelTitle1);
        panelFunctionMenu.add(panelRecipe);
        panelFunctionMenu.add(cbSwitchClass);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
