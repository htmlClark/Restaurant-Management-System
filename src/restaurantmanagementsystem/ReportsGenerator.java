/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
        salesPanel.setLayout(new GridLayout(4, 1, 5, 5));
        salesPanel.setBackground(steal);
        salesPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        salesPanel.setBounds(390, 80, 550, 670);

        JLabel salesTitle = new JLabel("Sales Summary");
        salesTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));

        totalSalesLabel = createLabel("Total: ₱0.00");
        avgSalesLabel = createLabel("Avg Daily: ₱0.00");
        bestSellerLabel = createLabel("Best Seller: -");

        salesPanel.add(salesTitle);
        salesPanel.add(totalSalesLabel);
        salesPanel.add(avgSalesLabel);
        salesPanel.add(bestSellerLabel);

        add(salesPanel);


        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridLayout(4, 1, 5, 5));
        inventoryPanel.setBackground(steal);
        inventoryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        inventoryPanel.setBounds(950, 80, 300, 400);

        JLabel inventoryTitle = new JLabel("Inventory Usage");
        inventoryTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));

        totalUsedLabel = createLabel("Used: 0");
        avgUsageLabel = createLabel("Avg Daily: 0");
        mostUsedLabel = createLabel("Most Used: -");

        inventoryPanel.add(inventoryTitle);
        inventoryPanel.add(totalUsedLabel);
        inventoryPanel.add(avgUsageLabel);
        inventoryPanel.add(mostUsedLabel);

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
        LOGO.setBounds(0, 0, 390, 80);

        JLabel logolabel = new JLabel("PINOY PLATTERS");
        logolabel.setFont(getCubaoFont(40f));
        logolabel.setForeground(Color.WHITE);
        logolabel.setBounds(10, 22, 700, 50);

        LOGO.add(logolabel);
        add(LOGO);

     
        JPanel SEARCH = new JPanel();
        SEARCH.setLayout(null);
        SEARCH.setBackground(snude);
        SEARCH.setBounds(390, 0, 880, 80);
        
        JTextField searchfield = new JTextField("SEARCH");
        searchfield.setBounds(20,20, 500, 50);
        searchfield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        SEARCH.add(searchfield);
        

        add(SEARCH);

        loadSampleData();
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


    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        return label;
    }


    public void updateSales(double total, String bestItem) {
        totalSalesLabel.setText("Total: ₱" + total);
        avgSalesLabel.setText("Avg Daily: ₱" + String.format("%.2f", total / 7));
        bestSellerLabel.setText("Best Seller: " + bestItem);
    }

    public void updateInventory(int totalUsed, String mostUsed) {
        totalUsedLabel.setText("Used: " + totalUsed);
        avgUsageLabel.setText("Avg Daily: " + String.format("%.2f", totalUsed / 7.0));
        mostUsedLabel.setText("Most Used: " + mostUsed);
    }

    public void updateWaste(double totalWaste, String mostWaste) {
        totalWasteLabel.setText("Total Waste: " + totalWaste);
        avgWasteLabel.setText("Avg Daily: " + String.format("%.2f", totalWaste / 7));
        mostWasteLabel.setText("Most Wasted: " + mostWaste);
    }

    private void loadSampleData() {
        updateSales(14000, "Chicken Adobo");
        updateInventory(350, "Rice");
        updateWaste(21.5, "Vegetables");
    }

    public static void main(String[] args) {
        new ReportsGenerator();
    }
}