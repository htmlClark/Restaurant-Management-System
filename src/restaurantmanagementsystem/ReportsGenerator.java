/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
public class ReportsGenerator extends JFrame {

    JLabel totalSalesLabel, avgSalesLabel, bestSellerLabel;
    JLabel totalUsedLabel, avgUsageLabel, mostUsedLabel;
    JLabel totalWasteLabel, avgWasteLabel, mostWasteLabel;

    public ReportsGenerator() {

    
        Color whitemain = Color.decode("#FFF8E1");
        Color darkblue = Color.decode("#366379");
        Color red = Color.decode("#B71C1C");
        Color snude = Color.decode("#F5CFBA");
        Color steal = Color.decode("#89B7B3");

        setTitle("Weekly Reports Dashboard");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(whitemain);

    
        JLabel header = new JLabel("", JLabel.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 28));
        header.setForeground(darkblue);
        header.setBounds(0, 10, 1280, 50);
        add(header);

   
         JPanel salesPanel = new JPanel();
        salesPanel.setLayout(null); 
        salesPanel.setBackground(steal);
        salesPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        salesPanel.setBounds(390, 80, 550, 670);

        // title for sales
        JLabel salesTitle = new JLabel("SALES REPORT");
        salesTitle.setFont(getOpenSans(18f).deriveFont(Font.BOLD));
        salesTitle.setBounds(180, 10, 200, 30);
        salesPanel.add(salesTitle);

        //header 1
        JLabel metricHeader = new JLabel("METRIC");
        metricHeader.setFont(getOpenSans(14f).deriveFont(Font.BOLD));
        metricHeader.setBounds(40, 60, 200, 25);
        //header 2
        JLabel salesHeader = new JLabel("SALES");
        salesHeader.setFont(getOpenSans(14f).deriveFont(Font.BOLD));
        salesHeader.setBounds(300, 60, 200, 25);

        salesPanel.add(metricHeader);
        salesPanel.add(salesHeader);

        //data
        totalSalesLabel = new JLabel("Total Sales");
        totalSalesLabel.setFont(getOpenSans(14f));
        totalSalesLabel.setBounds(40, 100, 200, 25);

        JLabel totalValue = new JLabel("0.00");
        totalValue.setFont(getOpenSans(14f));
        totalValue.setBounds(300, 100, 200, 25);

        avgSalesLabel = new JLabel("Avg Daily");
        avgSalesLabel.setFont(getOpenSans(14f));
        avgSalesLabel.setBounds(40, 140, 200, 25);

        JLabel avgValue = new JLabel("0.00");
        avgValue.setFont(getOpenSans(14f));
        avgValue.setBounds(300, 140, 200, 25);

        bestSellerLabel = new JLabel("Transactions");
        bestSellerLabel.setFont(getOpenSans(14f));
        bestSellerLabel.setBounds(40, 180, 200, 25);

        JLabel transValue = new JLabel("0");
        transValue.setFont(getOpenSans(14f));
        transValue.setBounds(300, 180, 200, 25);

        salesPanel.add(totalSalesLabel);
        salesPanel.add(totalValue);
        salesPanel.add(avgSalesLabel);
        salesPanel.add(avgValue);
        salesPanel.add(bestSellerLabel);
        salesPanel.add(transValue);

        //best seller part
        JLabel bestTitle = new JLabel("BEST SELLERS");
        bestTitle.setFont(getOpenSans(18f).deriveFont(Font.BOLD));
        bestTitle.setBounds(170, 240, 250, 30);
        salesPanel.add(bestTitle);

        // header
        JLabel dishHeader = new JLabel("DISH");
        dishHeader.setBounds(40, 280, 150, 25);

        JLabel unitHeader = new JLabel("UNIT SOLD");
        unitHeader.setBounds(200, 280, 100, 25);

        JLabel revenueHeader = new JLabel("REVENUE");
        revenueHeader.setBounds(350, 280, 150, 25);

        dishHeader.setFont(getOpenSans(14f).deriveFont(Font.BOLD));
        unitHeader.setFont(getOpenSans(14f).deriveFont(Font.BOLD));
        revenueHeader.setFont(getOpenSans(14f).deriveFont(Font.BOLD));

        salesPanel.add(dishHeader);
        salesPanel.add(unitHeader);
        salesPanel.add(revenueHeader);

        // ROW 1
        salesPanel.add(createRowLabel("Chicken Adobo", 40, 320));
        salesPanel.add(createRowLabel("0", 200, 320));
        salesPanel.add(createRowLabel("0.00", 350, 320));

        // ROW 2
        salesPanel.add(createRowLabel("Pork Sisig", 40, 350));
        salesPanel.add(createRowLabel("0", 200, 350));
        salesPanel.add(createRowLabel("0.00", 350, 350));

        // ROW 3
        salesPanel.add(createRowLabel("Turon", 40, 380));
        salesPanel.add(createRowLabel("0", 200, 380));
        salesPanel.add(createRowLabel("0.00", 350, 380));

        add(salesPanel);

        JPanel inventoryPanel = new JPanel();
inventoryPanel.setLayout(null); // 🔥 IMPORTANT
inventoryPanel.setBackground(steal);
inventoryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
inventoryPanel.setBounds(950, 80, 300, 400);

// ================= TITLE =================
JLabel invTitle = new JLabel("INVENTORY", JLabel.CENTER);
invTitle.setFont(getOpenSans(16f).deriveFont(Font.BOLD));
invTitle.setBounds(50, 10, 200, 30);
inventoryPanel.add(invTitle);

// ================= HEADERS =================
JLabel categoryHeader = new JLabel("CATEGORY");
categoryHeader.setFont(getOpenSans(13f).deriveFont(Font.BOLD));
categoryHeader.setBounds(20, 50, 150, 25);

JLabel totalHeader = new JLabel("TOTAL");
totalHeader.setFont(getOpenSans(13f).deriveFont(Font.BOLD));
totalHeader.setBounds(180, 50, 100, 25);

inventoryPanel.add(categoryHeader);
inventoryPanel.add(totalHeader);

// ================= DATA (REAL INGREDIENT GROUPS) =================

// ROW 1
inventoryPanel.add(createInvRow("Pork", 20, 90));
inventoryPanel.add(createInvRowValue("0 kg", 180, 90));

// ROW 2
inventoryPanel.add(createInvRow("Pork", 20, 90));
inventoryPanel.add(createInvRowValue("0 kg", 180, 90));

// ROW 3
inventoryPanel.add(createInvRow("Vegetables", 20, 150));
inventoryPanel.add(createInvRowValue("0 kg", 180, 150));

// ROW 4
inventoryPanel.add(createInvRow("Seafood", 20, 180));
inventoryPanel.add(createInvRowValue("0 kg", 180, 180));

// ROW 5
inventoryPanel.add(createInvRow("Rice", 20, 210));
inventoryPanel.add(createInvRowValue("0 kg", 180, 210));

// ROW 6
inventoryPanel.add(createInvRow("Condiments", 20, 240));
inventoryPanel.add(createInvRowValue("0 kg", 180, 240));

// ROW 7
inventoryPanel.add(createInvRow("Sugar", 20, 270));
inventoryPanel.add(createInvRowValue("0 kg", 180, 270));

// ROW 8
inventoryPanel.add(createInvRow("Cooking Oil", 20, 300));
inventoryPanel.add(createInvRowValue("0 kg", 180, 300));

add(inventoryPanel);
      


        JPanel wastePanel = new JPanel();
        wastePanel.setLayout(new GridLayout(4, 1, 5, 5));
        wastePanel.setBackground(steal);
        wastePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        wastePanel.setBounds(950, 490, 300, 260);

        JLabel wasteTitle = new JLabel("Waste Statistics");
        wasteTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));

        totalWasteLabel = createLabel("Total Waste: 0");
        avgWasteLabel = createLabel("Avg Daily: 0");
        mostWasteLabel = createLabel("Most Wasted: -");

        wastePanel.add(wasteTitle);
        wastePanel.add(totalWasteLabel);
        wastePanel.add(avgWasteLabel);
        wastePanel.add(mostWasteLabel);

        add(wastePanel);

        JPanel dashPanel = new JPanel();
        dashPanel.setLayout(null);
        dashPanel.setBackground(darkblue);
        dashPanel.setBounds(0, 80, 390, 700);

        add(dashPanel);
        
        

      JPanel LOGO = new JPanel();
      LOGO.setLayout(null);
LOGO.setBackground(red);
LOGO.setBounds(0, 0, 390, 140);


JLabel leftText = new JLabel("PIN");
leftText.setFont(getCubaoFont(50f));
leftText.setForeground(Color.WHITE);
leftText.setBounds(15, 3, 120, 90);


JLabel logoImage = new JLabel();

ImageIcon iconlogo = new ImageIcon(getClass().getResource("/images/ologo.png"));
Image scaledlogo = iconlogo.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);

logoImage.setIcon(new ImageIcon(scaledlogo));
logoImage.setBounds(73, 0, 120, 90);


JLabel rightText = new JLabel("Y PLATTERS");
rightText.setFont(getCubaoFont(50f));
rightText.setForeground(Color.WHITE);
rightText.setBounds(115, 3, 350, 90);

// ADD ALL
LOGO.add(leftText);
LOGO.add(logoImage);
LOGO.add(rightText);

add(LOGO);

     System.out.println(getClass().getResource("/images/search.png"));
    JPanel SEARCH = new JPanel();
    SEARCH.setLayout(null);
    SEARCH.setBackground(snude);
    SEARCH.setBounds(390, 0, 880, 80);

    JTextField searchfield = new JTextField();
    searchfield.setBounds(60, 20, 500, 40);
    searchfield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    searchfield.setBorder(BorderFactory.createEmptyBorder(5, 35, 5, 5));

    JLabel searchIcon = new JLabel();

    ImageIcon iconsearch = new ImageIcon(getClass().getResource("/images/search.png"));
    Image scaledsearch = iconsearch.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);

    searchIcon.setIcon(new ImageIcon(scaledsearch));
    searchIcon.setBounds(75, 32, 18, 18);
   

    SEARCH.add(searchIcon);
    SEARCH.add(searchfield);

        

        add(SEARCH);
     
      
        setVisible(true);
    }

    private Font getCubaoFont(float size) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/fonts/Cubao_Free_Narrow.otf"));
            return font.deriveFont(Font.BOLD, size);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("Segoe UI", Font.BOLD, (int) size);
        }
    }
    private Font getOpenSans(float size) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/fonts/OpenSans-Regular.ttf"));
            return font.deriveFont(Font.BOLD, size);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("Segoe UI", Font.BOLD, (int) size);
        }
    }
private JLabel createRowLabel(String text, int x, int y) {
    JLabel label = new JLabel(text);
    label.setFont(getOpenSans(14f));
    label.setBounds(x, y, 200, 25);
    return label;
    

}
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        return label;
    }

private JLabel createInvRow(String text, int x, int y) {
    JLabel label = new JLabel(text);
    label.setFont(getOpenSans(13f));
    label.setBounds(x, y, 150, 25);
    return label;
}

private JLabel createInvRowValue(String text, int x, int y) {
    JLabel label = new JLabel(text);
    label.setFont(getOpenSans(13f));
    label.setBounds(x, y, 100, 25);
    return label;
}


    

    public void updateWaste(double totalWaste, String mostWaste) {
        totalWasteLabel.setText("Total Waste: " + totalWaste);
        avgWasteLabel.setText("Avg Daily: " + String.format("%.2f", totalWaste / 7));
        mostWasteLabel.setText("Most Wasted: " + mostWaste);
    }



    public static void main(String[] args) {
        new ReportsGenerator();
    }
}