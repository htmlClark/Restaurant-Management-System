package RestaurantManagementSystem_.PaymentProcess;
import MainPlacementFrame.adminFrame;
import MainPlacementFrame.userFrame;
import RestaurantManagementSystem_.Products.Products;
import RestaurantManagementSystem_.ReportsGenerator.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PaymentConfirmationDialog extends JDialog implements ActionListener {

    private JLabel lblPaymentProcessed;
    private JLabel lblDateTime;
    private JLabel lblOrderNo;
    private JButton btnPrintReceipt;
    private JButton btnConfirm;
    private JFrame parentFrame;
    private Order order;

    Color colorCream = new Color(0xFF, 0xF8, 0xE1);
    Color colorRed = new Color(0xB7, 0x1C, 0x1C);
    Color colorGold = new Color(0xFF, 0xB3, 0x00);
    Color colorGreen   = new Color(0x2E, 0x7D, 0x32);
    Color colorWhite = new Color(0xFF, 0xFF, 0xFF);
    Color colorBlack = new Color(0x00, 0x00, 0x00);

    Font fontHeader = new Font("Impact", Font.BOLD, 35);
    Font fontNormal = new Font("Arial", Font.PLAIN, 14);

    java.time.LocalDateTime now = java.time.LocalDateTime.now();
    private String dateTime = now.getMonthValue() + "/" + now.getDayOfMonth() + "/" + now.getYear()
            + "   " + String.format("%02d", now.getHour()) + ":" + String.format("%02d", now.getMinute());


    public PaymentConfirmationDialog(JFrame parent, Order order) {
        super(parent, true);
        this.parentFrame = parent;
        this.order = order;
        setSize(500, 380);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(parent);
        setTitle("Payment Confirmed");

        getContentPane().setBackground(colorCream);

        JPanel pnlHeader = new JPanel();
        pnlHeader.setLayout(null);
        pnlHeader.setBounds(30, 20, 440, 60);
        pnlHeader.setBackground(colorRed);
        add(pnlHeader);

        lblPaymentProcessed = new JLabel("PAYMENT PROCESSED");
        lblPaymentProcessed.setBounds(70, 10, 340, 40);
        lblPaymentProcessed.setFont(fontHeader);
        lblPaymentProcessed.setForeground(colorCream);
        pnlHeader.add(lblPaymentProcessed);

        lblDateTime = new JLabel(dateTime);
        lblDateTime.setBounds(190, 95, 200, 25);
        lblDateTime.setFont(fontNormal);
        add(lblDateTime);

        lblOrderNo = new JLabel("ORDER NO. " + order.getOrderNumber());
        lblOrderNo.setBounds(160, 130, 250, 40);
        lblOrderNo.setFont(new Font("Arial", Font.BOLD, 26));
        add(lblOrderNo);

        JSeparator separator = new JSeparator();
        separator.setBounds(30, 270, 440, 2);
        add(separator);

        btnPrintReceipt = new JButton("PRINT RECEIPT");
        btnPrintReceipt.setBounds(130, 190, 240, 45);
        btnPrintReceipt.setFont(new Font("Arial", Font.BOLD, 20));
        btnPrintReceipt.setBackground(colorGold);
        btnPrintReceipt.setForeground(colorWhite);
        btnPrintReceipt.setBorderPainted(false);
        add(btnPrintReceipt);

        btnConfirm = new JButton("CONFIRM");
        btnConfirm.setBounds(30, 285, 440, 55);
        btnConfirm.setFont(new Font("Impact", Font.BOLD, 35));
        btnConfirm.setBackground(colorGreen);
        btnConfirm.setForeground(colorWhite);
        btnConfirm.setBorderPainted(true);
        add(btnConfirm);

        btnPrintReceipt.addActionListener(this);
        btnConfirm.addActionListener(this);
    }

    private void confirmBtn()
    {
        //tis is for logging the order into in-memory sales history,
        //used by ReportsGenerator for weekly sales / best sellers
        RecordSales.getInstance().recordOrder(order);

        JPanel nextPanel = new Products();
        parentFrame.getContentPane().removeAll();
        parentFrame.getContentPane().add(nextPanel);
        parentFrame.revalidate();
        parentFrame.repaint();

        if (parentFrame instanceof userFrame)            { ((userFrame) parentFrame).switchPanel(nextPanel); }
        else if (parentFrame instanceof adminFrame)      { ((adminFrame) parentFrame).switchPanel(nextPanel); }
    }

    private void printReceipt()
    {
        // Build receipt text
        StringBuilder sb = new StringBuilder();
        sb.append("=============================\n");
        sb.append("        PINOY PLATTERS       \n");
        sb.append("=============================\n\n");

        sb.append(String.format("%-20s %8s%n", "ITEM", "AMOUNT"));
        sb.append("-----------------------------\n");

        for (OrderItem item : order.getItems())
        {
            String line = item.getItemName() + " x" + item.getQuantity();
            String price = String.format("₱%.2f", item.getTotalPrice());
            sb.append(String.format("%-20s %8s%n", line, price));
        }

        sb.append("-----------------------------\n");
        sb.append(String.format("%-20s %8s%n", "Subtotal:",
                String.format("₱%.2f", order.getSubtotal())));
        sb.append(String.format("%-20s %8s%n", "Tax (12%):",
                String.format("₱%.2f", order.getTax())));
        sb.append(String.format("%-20s %8s%n", "TOTAL:",
                String.format("₱%.2f", order.getTotal())));
        sb.append("=============================\n\n");
        sb.append("      -- Customer Copy --     \n\n");
        sb.append("       " + dateTime + "      \n");
        sb.append("=============================\n");

        // Show in a scrollable dialog
        JTextArea txtReceipt = new JTextArea(sb.toString());
        txtReceipt.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtReceipt.setEditable(false);
        txtReceipt.setBackground(colorCream);

        JScrollPane scrollPane = new JScrollPane(txtReceipt);
        scrollPane.setPreferredSize(new java.awt.Dimension(320, 380));

        JOptionPane.showMessageDialog(
                this,
                scrollPane,
                "Receipt — Order No. " + order.getOrderNumber(),
                JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirm)
        {
            dispose();
            confirmBtn();
        }
        else if (e.getSource() == btnPrintReceipt)
        {
            printReceipt();
        }
    }
}