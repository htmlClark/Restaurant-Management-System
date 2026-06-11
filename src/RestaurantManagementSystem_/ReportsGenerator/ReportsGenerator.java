package RestaurantManagementSystem_.ReportsGenerator;
 
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
 
public class ReportsGenerator extends JPanel {
 
    private Connection conn;
    private JPanel salesPanel;
    private JPanel inventoryPanel;
    private JPanel wastePanel;
 
    
    public ReportsGenerator() {
        this(null);
    }
 
    
    public ReportsGenerator(Connection databaseConnection) {
        this.conn = databaseConnection;
 
        Color whitemain = Color.decode("#FFF8E1");
        Color darkblue  = Color.decode("#366379");
        Color red       = Color.decode("#B71C1C");
        Color snude     = Color.decode("#F5CFBA");
        Color steal     = Color.decode("#89B7B3");
 
        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(whitemain);
 
        
        salesPanel = new JPanel();
        salesPanel.setLayout(null);
        salesPanel.setBackground(steal);
        salesPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        salesPanel.setBounds(10, 10, 560, 700);
        add(salesPanel);
 
        JLabel salesTitle = new JLabel("WEEKLY SALES REPORT");
        salesTitle.setFont(new Font("Arial", Font.BOLD, 22));
        salesTitle.setForeground(Color.BLACK);
        salesTitle.setHorizontalAlignment(JLabel.CENTER);
        salesTitle.setBounds(0, 5, 560, 40);
        salesPanel.add(salesTitle);
 
        
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(null);
        inventoryPanel.setBackground(steal);
        inventoryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        inventoryPanel.setBounds(590, 10, 375, 350);
        add(inventoryPanel);
 
        JLabel invTitle = new JLabel("INVENTORY", JLabel.CENTER);
        invTitle.setFont(new Font("Arial", Font.BOLD, 22));
        invTitle.setForeground(Color.BLACK);
        invTitle.setBounds(0, 10, 375, 30);
        inventoryPanel.add(invTitle);
 
        
        wastePanel = new JPanel();
        wastePanel.setLayout(null);
        wastePanel.setBackground(steal);
        wastePanel.setBounds(590, 370, 375, 340);
        add(wastePanel);
 
        JLabel wasteTitle = new JLabel("WASTE DISTRIBUTION");
        wasteTitle.setFont(new Font("Arial", Font.BOLD, 22));
        wasteTitle.setForeground(Color.BLACK);
        wasteTitle.setHorizontalAlignment(JLabel.CENTER);
        wasteTitle.setBounds(0, 10, 375, 30);
        wastePanel.add(wasteTitle);
 
        if (conn != null) {
            loadSalesData(darkblue);
            loadBestSellers(darkblue);
            loadInventoryData(darkblue);
            loadWasteData(red, darkblue, snude);
        } else {
            insertDefaultPlaceholders(darkblue, red, snude);
        }
    }
 
    
    
    
 
    
    private void loadSalesData(Color darkblue) {
        double totalSales = 0, maxDaily = 0, minDaily = 0, avgSales = 0;
 
        
        String query =
            "SELECT o.order_date, SUM(oi.price * oi.quantity) AS daily_total " +
            "FROM order_items oi " +
            "JOIN orders o ON oi.order_id = o.order_id " +
            "GROUP BY o.order_date " +
            "ORDER BY o.order_date";
 
        int daysCount = 0;
        boolean first = true;
 
        try (Statement stmt = conn.createStatement();
             ResultSet rs   = stmt.executeQuery(query)) {
 
            while (rs.next()) {
                double dailyTotal = rs.getDouble("daily_total");
                totalSales += dailyTotal;
 
                if (first) {
                    maxDaily = dailyTotal;
                    minDaily = dailyTotal;
                    first = false;
                } else {
                    if (dailyTotal > maxDaily) maxDaily = dailyTotal;
                    if (dailyTotal < minDaily) minDaily = dailyTotal;
                }
                daysCount++;
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        avgSales = daysCount > 0 ? totalSales / daysCount : 0;
 
        
        salesPanel.add(createSalesCard("METRIC",               "VALUE",                                    60,  darkblue,    Color.WHITE));
        salesPanel.add(createSalesCard("Total Weekly Sales",   String.format("₱%,.2f", totalSales),       115,  Color.WHITE, Color.BLACK));
        salesPanel.add(createSalesCard("Average Daily Sales",  String.format("₱%,.2f", avgSales),         170,  Color.WHITE, Color.BLACK));
        salesPanel.add(createSalesCard("Highest Daily Sales",  String.format("₱%,.2f", maxDaily),         225,  Color.WHITE, Color.BLACK));
        salesPanel.add(createSalesCard("Lowest Daily Sales",   String.format("₱%,.2f", minDaily),         280,  Color.WHITE, Color.BLACK));
    }
 
    
    private void loadBestSellers(Color darkblue) {
        JLabel bestSellerTitle = new JLabel("BEST SELLERS");
        bestSellerTitle.setFont(new Font("Arial", Font.BOLD, 22));
        bestSellerTitle.setForeground(Color.BLACK);
        bestSellerTitle.setHorizontalAlignment(JLabel.CENTER);
        bestSellerTitle.setBounds(0, 340, 560, 40);
        salesPanel.add(bestSellerTitle);
 
        
        salesPanel.add(createBestSellerRow("DISH", "UNITS SOLD", "REVENUE", 390, darkblue, Color.WHITE));
 
        String query =
            "SELECT d.dish_name, " +
            "       SUM(oi.quantity)              AS units_sold, " +
            "       SUM(oi.price * oi.quantity)   AS total_revenue " +
            "FROM order_items oi " +
            "JOIN dish_list d ON oi.dish_id = d.dish_id " +
            "GROUP BY oi.dish_id, d.dish_name " +
            "ORDER BY units_sold DESC " +
            "LIMIT 5";   
 
        int yOffset  = 445;
        int maxY     = 690; 
 
        try (Statement stmt = conn.createStatement();
             ResultSet rs   = stmt.executeQuery(query)) {
 
            while (rs.next() && yOffset + 50 <= maxY) {
                String dishName = rs.getString("dish_name");
                int    sold     = rs.getInt("units_sold");
                double revenue  = rs.getDouble("total_revenue");
 
                salesPanel.add(createBestSellerRow(
                        dishName,
                        String.valueOf(sold),
                        String.format("₱%,.2f", revenue),
                        yOffset,
                        Color.WHITE,
                        Color.BLACK));
                yOffset += 50;
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    
    private void loadInventoryData(Color darkblue) {
        
        inventoryPanel.add(createInventoryRow("CATEGORY", "QTY (units)", 55, darkblue, Color.WHITE));
 
        String query =
            "SELECT dish_category, SUM(quantity) AS total_qty " +
            "FROM inventory " +
            "GROUP BY dish_category " +
            "ORDER BY dish_category";
 
        int yOffset = 100;
 
        try (Statement stmt = conn.createStatement();
             ResultSet rs   = stmt.executeQuery(query)) {
 
            while (rs.next()) {
                String category = rs.getString("dish_category");
                double qty      = rs.getDouble("total_qty");
 
                inventoryPanel.add(createInventoryRow(
                        category,
                        String.format("%.2f", qty),
                        yOffset,
                        Color.WHITE,
                        Color.BLACK));
                yOffset += 45;
 
                
                if (yOffset + 45 > 340) break;
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    
    private void loadWasteData(Color red, Color darkblue, Color snude) {
        String query =
            "SELECT i.dish_category, SUM(w.quantity) AS total_waste " +
            "FROM wastelogs w " +
            "JOIN inventory i ON w.inv_id = i.inv_id " +
            "GROUP BY i.dish_category " +
            "ORDER BY total_waste DESC";
 
        ArrayList<String> itemsList   = new ArrayList<>();
        ArrayList<Double> valuesList  = new ArrayList<>();
 
        try (Statement stmt = conn.createStatement();
             ResultSet rs   = stmt.executeQuery(query)) {
 
            while (rs.next()) {
                double waste = rs.getDouble("total_waste");
                if (waste > 0) {                          
                    itemsList.add(rs.getString("dish_category"));
                    valuesList.add(waste);
                }
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        if (itemsList.isEmpty()) {
            itemsList.add("No Waste Recorded");
            valuesList.add(100.0);
        }
 
        String[] wasteItems  = itemsList.toArray(new String[0]);
        double[] wasteValues = valuesList.stream().mapToDouble(Double::doubleValue).toArray();
        Color[]  wasteColors = { red, darkblue, snude, Color.ORANGE, Color.PINK, Color.CYAN, Color.GRAY };
 
        PieChartPanel pieChart = new PieChartPanel(wasteValues, wasteColors, wasteItems);
        pieChart.setBounds(0, 45, 375, 285);
        wastePanel.add(pieChart);
    }
 
    
    
    
 
    
    private void insertDefaultPlaceholders(Color darkblue, Color red, Color snude) {
        
        salesPanel.add(createSalesCard("METRIC",              "VALUE",  60,  darkblue,    Color.WHITE));
        salesPanel.add(createSalesCard("Total Weekly Sales",  "₱0.00",  115, Color.WHITE, Color.BLACK));
        salesPanel.add(createSalesCard("Average Daily Sales", "₱0.00",  170, Color.WHITE, Color.BLACK));
        salesPanel.add(createSalesCard("Highest Daily Sales", "₱0.00",  225, Color.WHITE, Color.BLACK));
        salesPanel.add(createSalesCard("Lowest Daily Sales",  "₱0.00",  280, Color.WHITE, Color.BLACK));
 
        JLabel bestSellerTitle = new JLabel("BEST SELLERS");
        bestSellerTitle.setFont(new Font("Arial", Font.BOLD, 22));
        bestSellerTitle.setForeground(Color.BLACK);
        bestSellerTitle.setHorizontalAlignment(JLabel.CENTER);
        bestSellerTitle.setBounds(0, 340, 560, 40);
        salesPanel.add(bestSellerTitle);
 
        salesPanel.add(createBestSellerRow("DISH", "UNITS SOLD", "REVENUE", 390, darkblue, Color.WHITE));
        salesPanel.add(createBestSellerRow("N/A",  "—",          "₱0.00",   445, Color.WHITE, Color.BLACK));
 
        
        inventoryPanel.add(createInventoryRow("CATEGORY", "QTY (units)", 55,  darkblue,    Color.WHITE));
        inventoryPanel.add(createInventoryRow("No Data",  "—",           100, Color.WHITE,  Color.BLACK));
 
        
        String[] wasteItems  = { "No Connection" };
        double[] wasteValues = { 100 };
        Color[]  wasteColors = { Color.GRAY };
        PieChartPanel pieChart = new PieChartPanel(wasteValues, wasteColors, wasteItems);
        pieChart.setBounds(0, 45, 375, 285);
        wastePanel.add(pieChart);
    }
 
    
    
    
 
    
    JPanel createSalesCard(String metric, String value, int y, Color cardColor, Color textColor) {
        JPanel container = new JPanel(null);
        container.setOpaque(false);
        container.setBounds(10, y, 540, 45);   
 
        JPanel leftCard = new JPanel(null);
        leftCard.setBackground(cardColor);
        leftCard.setBounds(0, 0, 260, 45);
 
        JLabel metricLabel = new JLabel(metric);
        metricLabel.setFont(new Font("Arial", Font.BOLD, 14));
        metricLabel.setForeground(textColor);
        metricLabel.setHorizontalAlignment(JLabel.CENTER);
        metricLabel.setBounds(0, 0, 260, 45);
        leftCard.add(metricLabel);
 
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
 
    JPanel createBestSellerRow(String dish, String units, String revenue,
                               int y, Color cardColor, Color textColor) {
        JPanel container = new JPanel(null);
        container.setOpaque(false);
        container.setBounds(10, y, 540, 50);
 
        int cardH = 45;
 
        JPanel leftCard = new JPanel(null);
        leftCard.setBackground(cardColor);
        leftCard.setBounds(0, 0, 170, cardH);
 
        JLabel dishLabel = new JLabel(dish);
        dishLabel.setFont(new Font("Arial", Font.BOLD, 13));
        dishLabel.setForeground(textColor);
        dishLabel.setHorizontalAlignment(JLabel.CENTER);
        dishLabel.setBounds(5, 0, 160, cardH);
        leftCard.add(dishLabel);
 
        JPanel centerCard = new JPanel(null);
        centerCard.setBackground(cardColor);
        centerCard.setBounds(180, 0, 170, cardH);
 
        JLabel unitLabel = new JLabel(units);
        unitLabel.setFont(new Font("Arial", Font.BOLD, 13));
        unitLabel.setForeground(textColor);
        unitLabel.setHorizontalAlignment(JLabel.CENTER);
        unitLabel.setBounds(5, 0, 160, cardH);
        centerCard.add(unitLabel);
 
        JPanel rightCard = new JPanel(null);
        rightCard.setBackground(cardColor);
        rightCard.setBounds(360, 0, 170, cardH);
 
        JLabel revenueLabel = new JLabel(revenue);
        revenueLabel.setFont(new Font("Arial", Font.BOLD, 13));
        revenueLabel.setForeground(textColor);
        revenueLabel.setHorizontalAlignment(JLabel.CENTER);
        revenueLabel.setBounds(5, 0, 160, cardH);
        rightCard.add(revenueLabel);
 
        container.add(leftCard);
        container.add(centerCard);
        container.add(rightCard);
        return container;
    }
 
    JPanel createInventoryRow(String item, String qty,
                              int y, Color cardColor, Color textColor) {
        JPanel container = new JPanel(null);
        container.setOpaque(false);
        container.setBounds(10, y, 350, 40);
 
        JPanel itemCard = new JPanel(null);
        itemCard.setBackground(cardColor);
        itemCard.setBounds(0, 0, 200, 35);
 
        JLabel itemLabel = new JLabel(item);
        itemLabel.setFont(new Font("Arial", Font.BOLD, 12));
        itemLabel.setForeground(textColor);
        itemLabel.setHorizontalAlignment(JLabel.CENTER);
        itemLabel.setBounds(5, 0, 190, 35);
        itemCard.add(itemLabel);
 
        JPanel qtyCard = new JPanel(null);
        qtyCard.setBackground(cardColor);
        qtyCard.setBounds(210, 0, 135, 35);
 
        JLabel qtyLabel = new JLabel(qty);
        qtyLabel.setFont(new Font("Arial", Font.BOLD, 12));
        qtyLabel.setForeground(textColor);
        qtyLabel.setHorizontalAlignment(JLabel.CENTER);
        qtyLabel.setBounds(5, 0, 125, 35);
        qtyCard.add(qtyLabel);
 
        container.add(itemCard);
        container.add(qtyCard);
        return container;
    }
 
    
    
    
 
    
    class PieChartPanel extends JPanel {
        private final double[] values;
        private final Color[]  colors;
        private final String[] labels;
 
        private static final int PIE_SIZE   = 160;
        private static final int LEGEND_H   = 16;
        private static final int LEGEND_GAP = 4;
 
        public PieChartPanel(double[] values, Color[] colors, String[] labels) {
            this.values = values;
            this.colors = colors;
            this.labels = labels;
            setOpaque(false);
 
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int cx = getWidth()  / 2;
                    int cy = PIE_SIZE    / 2 + 10;          
 
                    double dx = e.getX() - cx;
                    double dy = e.getY() - cy;
                    double dist = Math.sqrt(dx * dx + dy * dy);
 
                    if (dist > PIE_SIZE / 2.0) {
                        setToolTipText(null);
                        return;
                    }
 
                    
                    
                    double angle = Math.toDegrees(Math.atan2(-dy, dx)); 
                    if (angle < 0) angle += 360;
 
                    double total = 0;
                    for (double v : values) total += v;
 
                    double cursor = 0;
                    for (int i = 0; i < values.length; i++) {
                        double sweep = (values[i] / total) * 360.0;
                        if (angle >= cursor && angle < cursor + sweep) {
                            double pct = (values[i] / total) * 100.0;
                            setToolTipText(String.format(
                                    "%s: %.1f%%  (%.2f units)", labels[i], pct, values[i]));
                            return;
                        }
                        cursor += sweep;
                    }
                    setToolTipText(null);
                }
            });
        }
 
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
            int w   = getWidth();
            int px  = (w - PIE_SIZE) / 2;
            int py  = 10;                   
 
            double total = 0;
            for (double val : values) total += val;
 
            
            
            double startAngle = 0;
            for (int i = 0; i < values.length; i++) {
                double arcAngle = (values[i] / total) * 360.0;
                g2.setColor(colors[i % colors.length]);
                g2.fillArc(px, py, PIE_SIZE, PIE_SIZE, (int) startAngle, (int) arcAngle);
 
                
                g2.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawArc(px, py, PIE_SIZE, PIE_SIZE, (int) startAngle, (int) arcAngle);
 
                startAngle += arcAngle;
            }
 
            
            int legendY = py + PIE_SIZE + 8;
            g2.setFont(new Font("Arial", Font.PLAIN, 11));
            FontMetrics fm = g2.getFontMetrics();
 
            for (int i = 0; i < labels.length; i++) {
                
                double pct        = (values[i] / total) * 100.0;
                String legendText = labels[i] + String.format(" (%.1f%%)", pct);
                int    textW      = fm.stringWidth(legendText);
                int    blockW     = LEGEND_H + 4 + textW;
                int    lx         = (w - blockW) / 2;
 
                g2.setColor(colors[i % colors.length]);
                g2.fillRect(lx, legendY + 2, LEGEND_H, LEGEND_H);
                g2.setColor(Color.BLACK);
                g2.drawRect(lx, legendY + 2, LEGEND_H, LEGEND_H);
                g2.drawString(legendText, lx + LEGEND_H + 4, legendY + LEGEND_H);
 
                legendY += LEGEND_H + LEGEND_GAP + 2;
            }
        }
    }
}
 
