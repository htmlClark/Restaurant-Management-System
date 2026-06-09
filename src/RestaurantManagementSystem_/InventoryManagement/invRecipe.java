package RestaurantManagementSystem_.InventoryManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class invRecipe extends JPanel implements ActionListener {

    private JPanel panelRecipe, panelTitle1;
    private JLabel lblRecipe, lblTitle, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
    private JComboBox cbSwitchClass;

    public invRecipe()
    {
        functionMenu();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void functionMenu()
    {
        String[] pages = {"RECIPE", "INVENTORY", "DELIVERY"};
        cbSwitchClass = new JComboBox<>(pages);
        cbSwitchClass.setBounds(650, 25, 250, 50);
        cbSwitchClass.addActionListener(e -> {
            String selected = (String) cbSwitchClass.getSelectedItem();
            // TO FIX: switch panels
        });

        panelTitle1 = new JPanel();
        panelTitle1.setBounds(25, 25, 200, 50);
        panelTitle1.setBackground(Color.decode("#B71C1C"));

        lblRecipe = new JLabel("RECIPE");
        lblRecipe.setFont(new Font("Arial", Font.BOLD, 25));
        lblRecipe.setForeground(Color.WHITE);
        panelTitle1.add(lblRecipe);

        panelRecipe = new JPanel(null);
        panelRecipe.setBounds(25, 100, 600, 500);
        panelRecipe.setBackground(Color.decode("#B71C1C"));

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

        String[] foods = {"Adobo", "Shanghai", "Pansit", "Halo-Halo", "Gulaman"};
        JComboBox<String> cbFoods = new JComboBox<>(foods);
        cbFoods.setBounds(650, 100, 250, 25);

        add(cbSwitchClass);
        add(panelTitle1);
        add(panelRecipe);
        add(cbFoods);
    }

    @Override
    public void actionPerformed(ActionEvent e) { }
}