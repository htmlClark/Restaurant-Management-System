//package RestaurantManagementSystem_.ReportsGenerator;
//
//import RestaurantManagementSystem_.FoodWasteTracker.WasteLog;
//import RestaurantManagementSystem_.FoodWasteTracker.WasteLogPanel;
//import RestaurantManagementSystem_.InventoryManagement.InventoryManager;
//import RestaurantManagementSystem_.InventoryManagement.invItem;
//
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionAdapter;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import javax.swing.*;
//import javax.swing.border.*;
//
//public class ReportsGenerator extends JPanel {
//
//    private JPanel salesPanel;
//    private JPanel inventoryPanel;
//    private JPanel wastePanel;
//
//    public ReportsGenerator() {
//
//        Color whitemain = Color.decode("#FFF8E1");
//        Color darkblue  = Color.decode("#366379");
//        Color red       = Color.decode("#B71C1C");
//        Color snude     = Color.decode("#F5CFBA");
//        Color steal     = Color.decode("#89B7B3");
//
//        setBounds(300, 80, 980, 720);
//        setLayout(null);
//        setBackground(whitemain);
//
//        //Sales n Best Sellers Panel
//        salesPanel = new JPanel();
//        salesPanel.setLayout(null);
//        salesPanel.setBackground(steal);
//        salesPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//        salesPanel.setBounds(10, 10, 560, 700);
//        add(salesPanel);
//
//        JLabel salesTitle = new JLabel("WEEKLY SALES REPORT");
//        salesTitle.setFont(new Font("Arial", Font.BOLD, 22));
//        salesTitle.setForeground(Color.BLACK);
//        salesTitle.setHorizontalAlignment(JLabel.CENTER);
//        salesTitle.setBounds(0, 5, 560, 40);
//        salesPanel.add(salesTitle);
//
//        //Inventory Panel
//        inventoryPanel = new JPanel();
//        inventoryPanel.setLayout(null);
//        inventoryPanel.setBackground(steal);
//        inventoryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//        inventoryPanel.setBounds(590, 10, 375, 350);
//        add(inventoryPanel);
//
//        JLabel invTitle = new JLabel("INVENTORY", JLabel.CENTER);
//        invTitle.setFont(new Font("Arial", Font.BOLD, 22));
//        invTitle.setForeground(Color.BLACK);
//        invTitle.setBounds(0, 10, 375, 30);
//        inventoryPanel.add(invTitle);
//
//        //Waste Distribution Panel
//        wastePanel = new JPanel();
//        wastePanel.setLayout(null);
//        wastePanel.setBackground(steal);
//        wastePanel.setBounds(590, 370, 375, 340);
//        add(wastePanel);
//
//        JLabel wasteTitle = new JLabel("WASTE DISTRIBUTION");
//        wasteTitle.setFont(new Font("Arial", Font.BOLD, 22));
//        wasteTitle.setForeground(Color.BLACK);
//        wasteTitle.setHorizontalAlignment(JLabel.CENTER);
//        wasteTitle.setBounds(0, 10, 375, 30);
//        wastePanel.add(wasteTitle);
//
//        loadSalesData(darkblue);
//        loadBestSellers(darkblue);
//        loadInventoryData(darkblue);
//        loadWasteData(red, darkblue, snude);
//    }
//
//    //tis is for the weekly sales metrics, pulled from confirmed orders in SalesRecord
//    private void loadSalesData(Color darkblue) {
//        RecordSales sales = RecordSales.getInstance();
//
//        double totalSales = sales.getTotalSales();
//        double avgSales   = sales.getAverageDailySales();
//        double maxDaily   = sales.getHighestDailySales();
//        double minDaily   = sales.getLowestDailySales();
//
//        salesPanel.add(createSalesCard("METRIC",               "VALUE",                                    60,  darkblue,    Color.WHITE));
//        salesPanel.add(createSalesCard("Total Weekly Sales",   String.format("₱%,.2f", totalSales),       115,  Color.WHITE, Color.BLACK));
//        salesPanel.add(createSalesCard("Average Daily Sales",  String.format("₱%,.2f", avgSales),         170,  Color.WHITE, Color.BLACK));
//        salesPanel.add(createSalesCard("Highest Daily Sales",  String.format("₱%,.2f", maxDaily),         225,  Color.WHITE, Color.BLACK));
//        salesPanel.add(createSalesCard("Lowest Daily Sales",   String.format("₱%,.2f", minDaily),         280,  Color.WHITE, Color.BLACK));
//    }
//
//    //tis is for the top 5 best sellers, aggregated from confirmed orders in SalesRecord
//    private void loadBestSellers(Color darkblue) {
//        JLabel bestSellerTitle = new JLabel("BEST SELLERS");
//        bestSellerTitle.setFont(new Font("Arial", Font.BOLD, 22));
//        bestSellerTitle.setForeground(Color.BLACK);
//        bestSellerTitle.setHorizontalAlignment(JLabel.CENTER);
//        bestSellerTitle.setBounds(0, 340, 560, 40);
//        salesPanel.add(bestSellerTitle);
//
//        salesPanel.add(createBestSellerRow("DISH", "UNITS SOLD", "REVENUE", 390, darkblue, Color.WHITE));
//
//        List<RecordSales.BestSeller> bestSellers = RecordSales.getInstance().getBestSellers(5);
//
//        int yOffset = 445;
//        int maxY    = 690;
//
//        if (bestSellers.isEmpty()) {
//            salesPanel.add(createBestSellerRow("No Sales Recorded", "—", "₱0.00", yOffset, Color.WHITE, Color.BLACK));
//        } else {
//            for (RecordSales.BestSeller item : bestSellers) {
//                if (yOffset + 50 > maxY) break;
//
//                salesPanel.add(createBestSellerRow(
//                        item.dishName,
//                        String.valueOf(item.unitsSold),
//                        String.format("₱%,.2f", item.totalRevenue),
//                        yOffset,
//                        Color.WHITE,
//                        Color.BLACK));
//                yOffset += 50;
//            }
//        }
//    }
//
//    //tis is for the inventory status table, pulled directly from InventoryManager
//    private void loadInventoryData(Color darkblue) {
//
//        inventoryPanel.add(createInventoryRow("ITEM", "STATUS", 55, darkblue, Color.WHITE));
//
//        List<invItem> inventoryList = InventoryManager.getInstance().getInventoryList();
//
//        int yOffset = 100;
//
//        if (inventoryList.isEmpty()) {
//            inventoryPanel.add(createInventoryRow("No recorded items", "—", yOffset, Color.WHITE, Color.BLACK));
//        } else {
//            for (invItem item : inventoryList) {
//
//                inventoryPanel.add(createInventoryRow(
//                        item.getItemName(),
//                        item.getItemCurrentStatus(),
//                        yOffset,
//                        Color.WHITE,
//                        Color.BLACK));
//                yOffset += 45;
//
//                //tis is for rows don't overflow the panel
//                if (yOffset + 45 > 340) break;
//            }
//        }
//    }
//
//    private void loadWasteData(Color red, Color darkblue, Color snude) {
//
//        List<WasteLog> wasteLogs = WasteLogPanel.getSharedLogs();
//        Map<String, Double> wasteByItem = new LinkedHashMap<>();
//
//        for (WasteLog log : wasteLogs) {
//            double qty;
//            try {
//                qty = Double.parseDouble(log.qty);
//            } catch (NumberFormatException ex) {
//                continue; 
//            }
//
//            if (qty > 0) {
//                wasteByItem.merge(log.item, qty, Double::sum);
//            }
//        }
//
//        ArrayList<String> itemsList  = new ArrayList<>(wasteByItem.keySet());
//        ArrayList<Double> valuesList = new ArrayList<>(wasteByItem.values());
//
//        if (itemsList.isEmpty()) {
//            itemsList.add("No Waste Recorded");
//            valuesList.add(100.0);
//        }
//
//        String[] wasteItems  = itemsList.toArray(new String[0]);
//        double[] wasteValues = valuesList.stream().mapToDouble(Double::doubleValue).toArray();
//        Color[]  wasteColors = { red, darkblue, snude, Color.ORANGE, Color.PINK, Color.CYAN, Color.GRAY };
//
//        PieChartPanel pieChart = new PieChartPanel(wasteValues, wasteColors, wasteItems);
//        pieChart.setBounds(0, 45, 375, 285);
//        wastePanel.add(pieChart);
//    }
//
//    //tis is for sales rowsss
//    JPanel createSalesCard(String metric, String value, int y, Color cardColor, Color textColor) {
//        JPanel container = new JPanel(null);
//        container.setOpaque(false);
//        container.setBounds(10, y, 540, 45);
//
//        JPanel leftCard = new JPanel(null);
//        leftCard.setBackground(cardColor);
//        leftCard.setBounds(0, 0, 260, 45);
//
//        JLabel metricLabel = new JLabel(metric);
//        metricLabel.setFont(new Font("Arial", Font.BOLD, 14));
//        metricLabel.setForeground(textColor);
//        metricLabel.setHorizontalAlignment(JLabel.CENTER);
//        metricLabel.setBounds(0, 0, 260, 45);
//        leftCard.add(metricLabel);
//
//        JPanel rightCard = new JPanel(null);
//        rightCard.setBackground(cardColor);
//        rightCard.setBounds(270, 0, 260, 45);
//
//        JLabel valueLabel = new JLabel(value);
//        valueLabel.setFont(new Font("Arial", Font.BOLD, 14));
//        valueLabel.setForeground(textColor);
//        valueLabel.setHorizontalAlignment(JLabel.CENTER);
//        valueLabel.setBounds(0, 0, 260, 45);
//        rightCard.add(valueLabel);
//
//        container.add(leftCard);
//        container.add(rightCard);
//        return container;
//    }
//
//    //tis is for best seller rows
//    JPanel createBestSellerRow(String dish, String units, String revenue,
//                               int y, Color cardColor, Color textColor) {
//        JPanel container = new JPanel(null);
//        container.setOpaque(false);
//        container.setBounds(10, y, 540, 50);
//
//        int cardH = 45;
//
//        JPanel leftCard = new JPanel(null);
//        leftCard.setBackground(cardColor);
//        leftCard.setBounds(0, 0, 170, cardH);
//
//        JLabel dishLabel = new JLabel(dish);
//        dishLabel.setFont(new Font("Arial", Font.BOLD, 13));
//        dishLabel.setForeground(textColor);
//        dishLabel.setHorizontalAlignment(JLabel.CENTER);
//        dishLabel.setBounds(5, 0, 160, cardH);
//        leftCard.add(dishLabel);
//
//        JPanel centerCard = new JPanel(null);
//        centerCard.setBackground(cardColor);
//        centerCard.setBounds(180, 0, 170, cardH);
//
//        JLabel unitLabel = new JLabel(units);
//        unitLabel.setFont(new Font("Arial", Font.BOLD, 13));
//        unitLabel.setForeground(textColor);
//        unitLabel.setHorizontalAlignment(JLabel.CENTER);
//        unitLabel.setBounds(5, 0, 160, cardH);
//        centerCard.add(unitLabel);
//
//        JPanel rightCard = new JPanel(null);
//        rightCard.setBackground(cardColor);
//        rightCard.setBounds(360, 0, 170, cardH);
//
//        JLabel revenueLabel = new JLabel(revenue);
//        revenueLabel.setFont(new Font("Arial", Font.BOLD, 13));
//        revenueLabel.setForeground(textColor);
//        revenueLabel.setHorizontalAlignment(JLabel.CENTER);
//        revenueLabel.setBounds(5, 0, 160, cardH);
//        rightCard.add(revenueLabel);
//
//        container.add(leftCard);
//        container.add(centerCard);
//        container.add(rightCard);
//        return container;
//    }
//
//    //tis is for inventory rows
//    JPanel createInventoryRow(String item, String status,
//                              int y, Color cardColor, Color textColor) {
//        JPanel container = new JPanel(null);
//        container.setOpaque(false);
//        container.setBounds(10, y, 350, 40);
//
//        JPanel itemCard = new JPanel(null);
//        itemCard.setBackground(cardColor);
//        itemCard.setBounds(0, 0, 200, 35);
//
//        JLabel itemLabel = new JLabel(item);
//        itemLabel.setFont(new Font("Arial", Font.BOLD, 12));
//        itemLabel.setForeground(textColor);
//        itemLabel.setHorizontalAlignment(JLabel.CENTER);
//        itemLabel.setBounds(5, 0, 190, 35);
//        itemCard.add(itemLabel);
//
//        JPanel statusCard = new JPanel(null);
//        statusCard.setBackground(cardColor);
//        statusCard.setBounds(210, 0, 135, 35);
//        
//        Color statusColor = "Low".equalsIgnoreCase(status)
//                ? Color.decode("#B71C1C")
//                : textColor;
//
//        JLabel statusLabel = new JLabel(status);
//        statusLabel.setFont(new Font("Arial", Font.BOLD, 12));
//        statusLabel.setForeground(statusColor);
//        statusLabel.setHorizontalAlignment(JLabel.CENTER);
//        statusLabel.setBounds(5, 0, 125, 35);
//        statusCard.add(statusLabel);
//
//        container.add(itemCard);
//        container.add(statusCard);
//        return container;
//    }
//    class PieChartPanel extends JPanel {
//        private final double[] values;
//        private final Color[]  colors;
//        private final String[] labels;
//
//        private static final int PIE_SIZE   = 160;
//        private static final int LEGEND_H   = 16;
//        private static final int LEGEND_GAP = 4;
//
//        public PieChartPanel(double[] values, Color[] colors, String[] labels) {
//            this.values = values;
//            this.colors = colors;
//            this.labels = labels;
//            setOpaque(false);
//
//            addMouseMotionListener(new MouseMotionAdapter() {
//                @Override
//                public void mouseMoved(MouseEvent e) {
//                    int cx = getWidth()  / 2;
//                    int cy = PIE_SIZE    / 2 + 10;
//
//                    double dx = e.getX() - cx;
//                    double dy = e.getY() - cy;
//                    double dist = Math.sqrt(dx * dx + dy * dy);
//
//                    if (dist > PIE_SIZE / 2.0) {
//                        setToolTipText(null);
//                        return;
//                    }
//
//                    double angle = Math.toDegrees(Math.atan2(-dy, dx));
//                    if (angle < 0) angle += 360;
//
//                    double total = 0;
//                    for (double v : values) total += v;
//
//                    double cursor = 0;
//                    for (int i = 0; i < values.length; i++) {
//                        double sweep = (values[i] / total) * 360.0;
//                        if (angle >= cursor && angle < cursor + sweep) {
//                            double pct = (values[i] / total) * 100.0;
//                            setToolTipText(String.format(
//                                    "%s: %.1f%%  (%.2f units)", labels[i], pct, values[i]));
//                            return;
//                        }
//                        cursor += sweep;
//                    }
//                    setToolTipText(null);
//                }
//            });
//        }
//
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            Graphics2D g2 = (Graphics2D) g;
//            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//            int w   = getWidth();
//            int px  = (w - PIE_SIZE) / 2;
//            int py  = 10;
//
//            double total = 0;
//            for (double val : values) total += val;
//
//            double startAngle = 0;
//            for (int i = 0; i < values.length; i++) {
//                double arcAngle = (values[i] / total) * 360.0;
//                g2.setColor(colors[i % colors.length]);
//                g2.fillArc(px, py, PIE_SIZE, PIE_SIZE, (int) startAngle, (int) arcAngle);
//
//                g2.setColor(Color.WHITE);
//                g2.setStroke(new BasicStroke(1.5f));
//                g2.drawArc(px, py, PIE_SIZE, PIE_SIZE, (int) startAngle, (int) arcAngle);
//
//                startAngle += arcAngle;
//            }
//
//            int legendY = py + PIE_SIZE + 8;
//            g2.setFont(new Font("Arial", Font.PLAIN, 11));
//            FontMetrics fm = g2.getFontMetrics();
//
//            for (int i = 0; i < labels.length; i++) {
//                double pct        = (values[i] / total) * 100.0;
//                String legendText = labels[i] + String.format(" (%.1f%%)", pct);
//                int    textW      = fm.stringWidth(legendText);
//                int    blockW     = LEGEND_H + 4 + textW;
//                int    lx         = (w - blockW) / 2;
//
//                g2.setColor(colors[i % colors.length]);
//                g2.fillRect(lx, legendY + 2, LEGEND_H, LEGEND_H);
//                g2.setColor(Color.BLACK);
//                g2.drawRect(lx, legendY + 2, LEGEND_H, LEGEND_H);
//                g2.drawString(legendText, lx + LEGEND_H + 4, legendY + LEGEND_H);
//
//                legendY += LEGEND_H + LEGEND_GAP + 2;
//            }
//        }
//    }
//}