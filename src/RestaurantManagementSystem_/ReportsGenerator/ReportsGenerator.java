package RestaurantManagementSystem_.ReportsGenerator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ReportsGenerator extends JPanel {

    public ReportsGenerator()
    {
        //color conversion
        Color whitemain = Color.decode("#FFF8E1");
        Color darkblue  = Color.decode("#366379");
        Color red       = Color.decode("#B71C1C");
        Color snude     = Color.decode("#F5CFBA");
        Color steal     = Color.decode("#89B7B3");

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(whitemain);

        //panel sa sales
        JPanel salesPanel = new JPanel();
        salesPanel.setLayout(null);
        salesPanel.setBackground(steal);
        salesPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        salesPanel.setBounds(10, 10, 560, 700);

        //TITLE sa big panel
        JLabel salesTitle = new JLabel("WEEKLY SALES REPORT");
        salesTitle.setFont(new Font("Arial", Font.BOLD, 22));
        salesTitle.setForeground(Color.BLACK);
        salesTitle.setHorizontalAlignment(JLabel.CENTER);
        salesTitle.setBounds(0, 5, 560, 40);
        salesPanel.add(salesTitle);

        //data ng sales panels placeholder only
        add(salesPanel);
        salesPanel.add(createSalesCard("METRIC", "VALUE", 60, darkblue, Color.WHITE));
        salesPanel.add(createSalesCard("Total Weekly Sales", "₱0.00", 115, Color.WHITE, Color.BLACK));
        salesPanel.add(createSalesCard("Average Daily Sales", "₱0.00", 165, Color.WHITE, Color.BLACK));
        salesPanel.add(createSalesCard("Highest Daily Sales", "₱0.00", 215, Color.WHITE, Color.BLACK));
        salesPanel.add(createSalesCard("Lowest Daily Sales", "₱0.00", 265, Color.WHITE, Color.BLACK));

        //part paren ng sales panel pero ito sa best seller na
        JLabel bestSellerTitle = new JLabel("BEST SELLERS");
        bestSellerTitle.setFont(new Font("Arial", Font.BOLD, 22));
        bestSellerTitle.setForeground(Color.BLACK);
        bestSellerTitle.setHorizontalAlignment(JLabel.CENTER);
        bestSellerTitle.setBounds(0, 360, 560, 40);
        salesPanel.add(bestSellerTitle);

        //placeholder data for the best seller
        salesPanel.add(createBestSellerRow("DISH", "UNIT SOLD", "REVENUE", 410, darkblue, Color.WHITE));
        salesPanel.add(createBestSellerRow("Chicken Adobo", "150", "₱50,000", 465, Color.WHITE, Color.BLACK));
        salesPanel.add(createBestSellerRow("Pork Sisig", "100", "₱80,000", 520, Color.WHITE, Color.BLACK));
        salesPanel.add(createBestSellerRow("Dinakdakan", "120", "₱70,000", 575, Color.WHITE, Color.BLACK));

        //inventory panel na po to
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(null);
        inventoryPanel.setBackground(steal);
        inventoryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        inventoryPanel.setBounds(590, 10, 375, 350);

        //title lang
        JLabel invTitle = new JLabel("INVENTORY", JLabel.CENTER);
        invTitle.setFont(new Font("Arial", Font.BOLD, 22));
        invTitle.setForeground(Color.BLACK);
        invTitle.setHorizontalAlignment(JLabel.CENTER);
        invTitle.setBounds(50, 10, 275, 30);
        inventoryPanel.add(invTitle);

        add(inventoryPanel);

        //placeholder data sa inventory panel
        inventoryPanel.add(createInventoryRow("CATEGORY", "TOTAL", 60, darkblue, Color.WHITE));
        inventoryPanel.add(createInventoryRow("Pork", "50 kg", 105, Color.WHITE, Color.BLACK));
        inventoryPanel.add(createInventoryRow("Beef", "30 kg", 150, Color.WHITE, Color.BLACK));
        inventoryPanel.add(createInventoryRow("Vegetables", "25 kg", 195, Color.WHITE, Color.BLACK));
        inventoryPanel.add(createInventoryRow("Seafood", "15 kg", 240, Color.WHITE, Color.BLACK));
        inventoryPanel.add(createInventoryRow("Rice", "100 kg", 285, Color.WHITE, Color.BLACK));

        //waste panel na
        JPanel wastePanel = new JPanel();
        wastePanel.setLayout(null);
        wastePanel.setBackground(steal);
        wastePanel.setBounds(590, 370, 375, 340);

        //title
        JLabel wasteTitle = new JLabel("WASTE DISTRIBUTION");
        wasteTitle.setFont(new Font("Arial", Font.BOLD, 22));
        wasteTitle.setForeground(Color.BLACK);
        wasteTitle.setHorizontalAlignment(JLabel.CENTER);
        wasteTitle.setBounds(0, 10, 375, 30);
        wastePanel.add(wasteTitle);

        // placeholder po
        String[] wasteItems  = {"Pork", "Beef", "Vegetables", "Seafood", "Rice"};
        double[] wasteValues = {45, 25, 15, 10, 5};
        Color[] wasteColors  = {red, darkblue, snude, Color.WHITE, Color.GRAY};

        // piecharts
        PieChartPanel pieChart = new PieChartPanel(wasteValues, wasteColors, wasteItems);
        pieChart.setBounds(0, 40, 375, 280);
        wastePanel.add(pieChart);
        add(wastePanel);
    }

    private JPanel createSalesCard(String metric, String value, int y, Color cardColor, Color textColor)
    {
        JPanel container = new JPanel();
        container.setLayout(null);
        container.setOpaque(false);
        container.setBounds(20, y, 550, 45);

        // LEFT CARD
        JPanel leftCard = new JPanel(null);
        leftCard.setBackground(cardColor);
        leftCard.setBounds(0, 0, 260, 45);

        JLabel metricLabel = new JLabel(metric);
        metricLabel.setFont(new Font("Arial", Font.BOLD, 14));
        metricLabel.setForeground(textColor);
        metricLabel.setHorizontalAlignment(JLabel.CENTER);
        metricLabel.setBounds(0, 0, 260, 45);
        leftCard.add(metricLabel);

        // RIGHT CARD
        JPanel rightCard = new JPanel(null);
        rightCard.setBackground(cardColor);
        rightCard.setBounds(270, 0, 260, 45);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 14));
        valueLabel.setForeground(textColor);
        valueLabel.setHorizontalAlignment(JLabel.CENTER);
        valueLabel.setBounds(0, 0, 260, 45);
        rightCard.add(valueLabel);

        container.add(leftCard);
        container.add(rightCard);

        return container;
    }

    private JPanel createBestSellerRow(String dish, String units, String revenue, int y, Color cardColor, Color textColor)
    {
        JPanel container = new JPanel();
        container.setLayout(null);
        container.setOpaque(false);
        container.setBounds(20, y, 550, 60);

        // LEFT CARD (DISH)
        JPanel leftCard = new JPanel();
        leftCard.setLayout(null);
        leftCard.setBackground(cardColor);
        leftCard.setBounds(0, 0, 165, 45);

        JLabel dishLabel = new JLabel(dish);
        dishLabel.setFont(new Font("Arial", Font.BOLD, 14));
        dishLabel.setForeground(textColor);
        dishLabel.setHorizontalAlignment(JLabel.CENTER);
        dishLabel.setBounds(5, 12, 155, 20);
        leftCard.add(dishLabel);

        // CENTER CARD (UNIT SOLD)
        JPanel centerCard = new JPanel();
        centerCard.setLayout(null);
        centerCard.setBackground(cardColor);
        centerCard.setBounds(180, 0, 165, 45);

        JLabel unitLabel = new JLabel(units);
        unitLabel.setFont(new Font("Arial", Font.BOLD, 14));
        unitLabel.setForeground(textColor);
        unitLabel.setHorizontalAlignment(JLabel.CENTER);
        unitLabel.setBounds(5, 12, 155, 20);
        centerCard.add(unitLabel);

        // RIGHT CARD (REVENUE)
        JPanel rightCard = new JPanel();
        rightCard.setLayout(null);
        rightCard.setBackground(cardColor);
        rightCard.setBounds(360, 0, 165, 45);

        JLabel revenueLabel = new JLabel(revenue);
        revenueLabel.setFont(new Font("Arial", Font.BOLD, 14));
        revenueLabel.setForeground(textColor);
        revenueLabel.setHorizontalAlignment(JLabel.CENTER);
        revenueLabel.setBounds(5, 12, 155, 20);
        rightCard.add(revenueLabel);

        container.add(leftCard);
        container.add(centerCard);
        container.add(rightCard);

        return container;
    }

    private JPanel createInventoryRow(String item, String qty, int y, Color cardColor, Color textColor)
    {
        JPanel container = new JPanel();
        container.setLayout(null);
        container.setOpaque(false);
        container.setBounds(10, y, 355, 45);

        // --- LEFT CARD (CATEGORY / ITEM NAME) ---
        JPanel itemCard = new JPanel();
        itemCard.setLayout(null);
        itemCard.setBackground(cardColor);
        itemCard.setBounds(0, 0, 200, 35);

        JLabel itemLabel = new JLabel(item);
        itemLabel.setFont(new Font("Arial", Font.BOLD, 12));
        itemLabel.setForeground(textColor);
        itemLabel.setHorizontalAlignment(JLabel.CENTER);
        itemLabel.setBounds(5, 7, 190, 20);
        itemCard.add(itemLabel);

        // --- RIGHT CARD (TOTAL / VALUE) ---
        JPanel qtyCard = new JPanel();
        qtyCard.setLayout(null);
        qtyCard.setBackground(cardColor);
        qtyCard.setBounds(210, 0, 140, 35);

        JLabel qtyLabel = new JLabel(qty);
        qtyLabel.setFont(new Font("Arial", Font.BOLD, 12));
        qtyLabel.setForeground(textColor);
        qtyLabel.setHorizontalAlignment(JLabel.CENTER);
        qtyLabel.setBounds(5, 7, 130, 20);
        qtyCard.add(qtyLabel);

        container.add(itemCard);
        container.add(qtyCard);

        return container;
    }

    class PieChartPanel extends JPanel {
        private double[] values;
        private Color[] colors;
        private String[] labels; // Added labels for the hover effect

        public PieChartPanel(double[] values, Color[] colors, String[] labels)
        {
            this.values = values;
            this.colors = colors;
            this.labels = labels;
            setOpaque(false);

            //hover code
            addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                @Override
                public void mouseMoved(java.awt.event.MouseEvent e) {
                    int size = 180;
                    int centerX = getWidth() / 2;
                    int centerY = getHeight() / 2;
                    int mouseX = e.getX();
                    int mouseY = e.getY();

                    double distance = Math.sqrt(Math.pow(mouseX - centerX, 2) + Math.pow(mouseY - centerY, 2));

                    if (distance <= size / 2)
                    {
                        double angle = Math.toDegrees(Math.atan2(centerY - mouseY, mouseX - centerX));
                        if (angle < 0) angle += 360;

                        double total = 0;
                        for (double v : values) total += v;

                        double currentAngle = 0;
                        for (int i = 0; i < values.length; i++)
                        {
                            double sliceAngle = (values[i] / total) * 360;
                            if (angle >= currentAngle && angle <= (currentAngle + sliceAngle))
                            {
                                double percent = (values[i] / total) * 100;
                                setToolTipText(String.format("%s: %.1f%% (Value: %.0f kg)", labels[i], percent, values[i]));
                                return;
                            }
                            currentAngle += sliceAngle;
                        }
                    }
                    else
                    {
                        setToolTipText(null); // Hide tooltip if mouse is outside circle
                    }
                }
            });
        }

        //code for the pie chart creation
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int size = 180;
            int x = (getWidth() - size) / 2;
            int y = (getHeight() - size) / 2;

            double total = 0;
            for (double val : values) total += val;

            double startAngle = 0;
            for (int i = 0; i < values.length; i++)
            {
                double arcAngle = (values[i] / total) * 360.0;
                g2.setColor(colors[i % colors.length]);
                g2.fillArc(x, y, size, size, (int) startAngle, (int) arcAngle);
                startAngle += arcAngle;
            }
        }
    }
}