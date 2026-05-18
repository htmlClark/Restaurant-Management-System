
package restaurantmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class ReportsGenerator extends JFrame {


    public ReportsGenerator() {
        //color conversion
        Color whitemain = Color.decode("#FFF8E1");
        Color darkblue = Color.decode("#366379");
        Color red = Color.decode("#B71C1C");
        Color snude = Color.decode("#F5CFBA");
        Color steal = Color.decode("#89B7B3");

       //title nya 
        setTitle("Weekly Reports Dashboard");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(whitemain);

    
//panel sa sales
JPanel salesPanel = new JPanel();
salesPanel.setLayout(null);
salesPanel.setBackground(steal);
salesPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
salesPanel.setBounds(390, 80, 560, 700);

//TITLE sa big panel
JLabel salesTitle = new JLabel("WEEKLY SALES REPORT");
salesTitle.setFont(getOpenSans(22f).deriveFont(Font.BOLD));
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
bestSellerTitle.setFont(getOpenSans(22f).deriveFont(Font.BOLD));
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
inventoryPanel.setBounds(970, 80, 300, 350);

//title lang
JLabel invTitle = new JLabel("INVENTORY", JLabel.CENTER);
invTitle.setFont(getOpenSans(22f).deriveFont(Font.BOLD));
invTitle.setForeground(Color.BLACK);
invTitle.setHorizontalAlignment(JLabel.CENTER);
invTitle.setBounds(50, 10, 200, 30);
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
wastePanel.setBounds(970, 440, 300, 340); // Positioned under Inventory

//title
JLabel wasteTitle = new JLabel("WASTE DISTRIBUTION");
wasteTitle.setFont(getOpenSans(22f).deriveFont(Font.BOLD));
wasteTitle.setForeground(Color.BLACK); // Matches your theme
wasteTitle.setHorizontalAlignment(JLabel.CENTER);
wasteTitle.setBounds(0, 10, 300, 30);
wastePanel.add(wasteTitle);

// placeholder po
String[] wasteItems = {"Pork", "Beef", "Vegetables", "Seafood", "Rice"};
double[] wasteValues = {45, 25, 15, 10, 5}; 
Color[] wasteColors = {red, darkblue, snude, Color.WHITE, Color.GRAY};

// piecharts
PieChartPanel pieChart = new PieChartPanel(wasteValues, wasteColors, wasteItems);
pieChart.setBounds(0, 40, 300, 280); 
wastePanel.add(pieChart);
add(wastePanel);


//left side na panel
JPanel dashPanel = new JPanel(null);
dashPanel.setBackground(darkblue);
dashPanel.setBounds(0, 80, 390, 700);

//ginawa ko button hahahahahahahaha baka kasi pwede syang like back to main menu siguro
JButton dashBtn = createNavButton("DASHBOARD", "/images/DASHBOARD.png", 10, false, darkblue);
dashBtn.setFont(getCubaoFont(35f));
dashBtn.setBounds(0, 10, 390, 60);  
dashPanel.add(dashBtn);


//ginaya ko sa canva para may linya emerrut
JPanel line = new JPanel();
line.setBackground(Color.WHITE);
line.setBounds(20, 75, 350, 1);
dashPanel.add(line);

//buttons 
dashPanel.add(createNavButton("PRODUCTS", "/images/PRODUCTS.png", 100, false, darkblue));
dashPanel.add(createNavButton("INVENTORY", "/images/INVENTORY.png", 170, false, darkblue));
dashPanel.add(createNavButton("WEEKLY SUMMARY", "/images/REPORT.png", 240, false, darkblue)); 
dashPanel.add(createNavButton("WASTE LOGS", "/images/WASTE LOG.png", 310, false, darkblue));
dashPanel.add(createNavButton("DELIVERY", "/images/DELIVERY.png", 380, false, darkblue));
dashPanel.add(createNavButton("LOGOUT", "/images/logout.png", 600, false, darkblue));


//logo na
JPanel LOGO = new JPanel();
LOGO.setLayout(null);
LOGO.setBackground(red);
LOGO.setBounds(0, 0, 390, 80);

JLabel fullLogo = new JLabel();
ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/NAME.png"));
Image scaledLogo = logoIcon.getImage().getScaledInstance(360, 80, Image.SCALE_SMOOTH);

fullLogo.setIcon(new ImageIcon(scaledLogo));
fullLogo.setBounds(15, 10, 360, 80); 
fullLogo.setHorizontalAlignment(JLabel.CENTER);

LOGO.add(fullLogo);
add(LOGO);
add(dashPanel);
        
// sa search

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



    

   
    
private JPanel createSalesCard(String metric, String value, int y, Color cardColor, Color textColor) {
    JPanel container = new JPanel();
    container.setLayout(null);
    container.setOpaque(false);
    // CHANGE: Height from 60 to 45 to match the cards exactly
    container.setBounds(20, y, 550, 45); 

    // LEFT CARD
    JPanel leftCard = new JPanel(null);
    leftCard.setBackground(cardColor);
    leftCard.setBounds(0, 0, 260, 45);

    JLabel metricLabel = new JLabel(metric);
    metricLabel.setFont(getOpenSans(14f).deriveFont(Font.BOLD));
    metricLabel.setForeground(textColor);
    metricLabel.setHorizontalAlignment(JLabel.CENTER);
    // CHANGE: Center the text vertically by using the full 45 height
    metricLabel.setBounds(0, 0, 260, 45); 
    leftCard.add(metricLabel);

    // RIGHT CARD
    JPanel rightCard = new JPanel(null);
    rightCard.setBackground(cardColor);
    rightCard.setBounds(270, 0, 260, 45);

    JLabel valueLabel = new JLabel(value);
    valueLabel.setFont(getOpenSans(14f).deriveFont(Font.BOLD));
    valueLabel.setForeground(textColor);
    valueLabel.setHorizontalAlignment(JLabel.CENTER);
    // CHANGE: Center the text vertically by using the full 45 height
    valueLabel.setBounds(0, 0, 260, 45); 
    rightCard.add(valueLabel);

    container.add(leftCard);
    container.add(rightCard);

    return container;
}
    
private JPanel createBestSellerRow(String dish, String units, String revenue, int y, Color cardColor, Color textColor) {
    JPanel container = new JPanel();
    container.setLayout(null);
    container.setOpaque(false);
    container.setBounds(20, y, 550, 60); 

    // Width for 3 columns: (550 / 3) approx 170. 
    // Let's use 165 width with 15px gaps.

    // LEFT CARD (DISH)
    JPanel leftCard = new JPanel();
    leftCard.setLayout(null);
    leftCard.setBackground(cardColor);
    leftCard.setBounds(0, 0, 165, 45);

    JLabel dishLabel = new JLabel(dish);
    dishLabel.setFont(getOpenSans(14f).deriveFont(Font.BOLD));
    dishLabel.setForeground(textColor);
    dishLabel.setHorizontalAlignment(JLabel.CENTER);
    dishLabel.setBounds(5, 12, 155, 20);
    leftCard.add(dishLabel);

    // CENTER CARD (UNIT SOLD)
    JPanel centerCard = new JPanel();
    centerCard.setLayout(null);
    centerCard.setBackground(cardColor);
    centerCard.setBounds(180, 0, 165, 45); // 165 width + 15 gap

    JLabel unitLabel = new JLabel(units);
    unitLabel.setFont(getOpenSans(14f).deriveFont(Font.BOLD));
    unitLabel.setForeground(textColor);
    unitLabel.setHorizontalAlignment(JLabel.CENTER);
    unitLabel.setBounds(5, 12, 155, 20);
    centerCard.add(unitLabel);

    // RIGHT CARD (REVENUE)
    JPanel rightCard = new JPanel();
    rightCard.setLayout(null);
    rightCard.setBackground(cardColor);
    rightCard.setBounds(360, 0, 165, 45); // 180 + 165 + 15 gap

    JLabel revenueLabel = new JLabel(revenue);
    revenueLabel.setFont(getOpenSans(14f).deriveFont(Font.BOLD));
    revenueLabel.setForeground(textColor);
    revenueLabel.setHorizontalAlignment(JLabel.CENTER);
    revenueLabel.setBounds(5, 12, 155, 20);
    rightCard.add(revenueLabel);

    container.add(leftCard);
    container.add(centerCard);
    container.add(rightCard);

    return container;
}

private JPanel createInventoryRow(String item, String qty, int y, Color cardColor, Color textColor) {
    JPanel container = new JPanel();
    container.setLayout(null);
    container.setOpaque(false);
    // 280 width to fit comfortably inside your 300px wide panel
    container.setBounds(10, y, 280, 45); 

    // --- LEFT CARD (CATEGORY / ITEM NAME) ---
    JPanel itemCard = new JPanel();
    itemCard.setLayout(null);
    itemCard.setBackground(cardColor);
    itemCard.setBounds(0, 0, 150, 35); // 150px wide

    JLabel itemLabel = new JLabel(item);
    itemLabel.setFont(getOpenSans(12f).deriveFont(Font.BOLD));
    itemLabel.setForeground(textColor);
    itemLabel.setHorizontalAlignment(JLabel.CENTER);
    itemLabel.setBounds(5, 7, 140, 20);
    itemCard.add(itemLabel);

    // --- RIGHT CARD (TOTAL / VALUE) ---
    JPanel qtyCard = new JPanel();
    qtyCard.setLayout(null);
    qtyCard.setBackground(cardColor);
    qtyCard.setBounds(155, 0, 115, 35); // 115px wide (5px gap from left card)

    JLabel qtyLabel = new JLabel(qty);
    qtyLabel.setFont(getOpenSans(12f).deriveFont(Font.BOLD));
    qtyLabel.setForeground(textColor);
    qtyLabel.setHorizontalAlignment(JLabel.CENTER);
    qtyLabel.setBounds(5, 7, 105, 20);
    qtyCard.add(qtyLabel);

    container.add(itemCard);
    container.add(qtyCard);

    return container;
}
class PieChartPanel extends JPanel {
    private double[] values;
    private Color[] colors;
    private String[] labels; // Added labels for the hover effect

    public PieChartPanel(double[] values, Color[] colors, String[] labels) {
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
                
                if (distance <= size / 2) {
            
                    double angle = Math.toDegrees(Math.atan2(centerY - mouseY, mouseX - centerX));
                    if (angle < 0) angle += 360; 
                    
           
                    double total = 0;
                    for (double v : values) total += v;

                    double currentAngle = 0;
                    for (int i = 0; i < values.length; i++) {
                        double sliceAngle = (values[i] / total) * 360;
                        if (angle >= currentAngle && angle <= (currentAngle + sliceAngle)) {
    double percent = (values[i] / total) * 100;
    
   
    setToolTipText(String.format("%s: %.1f%% (Value: %.0f kg)", labels[i], percent, values[i]));
    return;
}
                        currentAngle += sliceAngle;
                    }
                } else {
                    setToolTipText(null); // Hide tooltip if mouse is outside circle
                }
            }
        });
    }
//code for the pie chart creation
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = 180;
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        double total = 0;
        for (double val : values) total += val;

        double startAngle = 0;
        for (int i = 0; i < values.length; i++) {
            double arcAngle = (values[i] / total) * 360.0;
            g2.setColor(colors[i % colors.length]);
            g2.fillArc(x, y, size, size, (int) startAngle, (int) arcAngle);
            startAngle += arcAngle;
        }
    }

}
//buttons
private JButton createNavButton(String text, String iconPath, int y, boolean isActive, Color darkblue) {
    JButton btn = new JButton(text);
    
    btn.setBounds(0, y, 390, 60);
    
    btn.setFocusPainted(false);
    btn.setBorderPainted(false);
    btn.setContentAreaFilled(isActive); // Highlight only the active one
    btn.setBackground(Color.decode("#264653")); // Darker shade for active button
    btn.setOpaque(isActive);
    
    btn.setForeground(Color.WHITE);
    btn.setFont(getOpenSans(20f).deriveFont(Font.BOLD));
    
    btn.setHorizontalAlignment(SwingConstants.LEFT);
    btn.setIconTextGap(30); // Gap between icon and text
    btn.setMargin(new java.awt.Insets(0, 30, 0, 0)); // Padding from the left edge

    try {
        ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));
        Image scaled = icon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(scaled));
    } catch (Exception e) {
        System.out.println("Could not find icon: " + iconPath);
    }
btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, 
                "You clicked on: " + text + "\nThis feature is coming soon!", 
                "Navigation Placeholder", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    });
  
    btn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent e) {
            btn.setContentAreaFilled(true);
            btn.setBackground(Color.decode("#457B9D")); // Light blue hover
        }
        public void mouseExited(java.awt.event.MouseEvent e) {
            btn.setContentAreaFilled(isActive);
            btn.setBackground(Color.decode("#264653"));
        }
    });

    return btn;
}
    public static void main(String[] args) {
        new ReportsGenerator();
    }
}