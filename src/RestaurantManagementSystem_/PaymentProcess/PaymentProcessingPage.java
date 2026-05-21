package RestaurantManagementSystem_.PaymentProcess;

import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PaymentProcessingPage extends JFrame implements ActionListener {

    private JLabel lblLogo, lblUser;
    private JLabel lblPaymentProcessing;
    private JLabel lblOrderSummary;
    private JLabel lblSubtotal, lblTax, lblTotal;
    private JLabel lblPaymentMethod;
    private JLabel lblAmountTendered;
    private JLabel lblPaid, lblChange;

    private JButton btnCash, btnCard, btnGcash;
    private JButton btn100, btn200, btn500, btn1000, btnExact;
    private JButton btnProcessPayment, btnCancel;

    private JTextField txtAmountTendered;
    private JTextField txtSearch;

    Color colorCream = new Color(0xFF, 0xF8, 0xE1);
    Color colorTeal = new Color(0x36, 0x63, 0x79);
    Color colorRed = new Color(0xB7, 0x1C, 0x1C);
    Color colorGold = new Color(0xFF, 0xB3, 0x00);
    Color colorSalmon = new Color(0xF5, 0xCF, 0xBA);
    Color colorMutedTeal = new Color(0x89, 0xB7, 0xB3);
    Color colorGreen = new Color(0x2E, 0x7D, 0x32);
    Color colorWhite = new Color(0xFF, 0xFF, 0xFF);
    Color colorBlack = new Color(0x00, 0x00, 0x00);

    Font fontBold = new Font("Impact", Font.BOLD, 14);
    Font fontHeader = new Font("Impact", Font.BOLD, 22);
    Font fontLogo = new Font("Impact", Font.BOLD, 28);
    Font fontSmall = new Font("Arial", Font.PLAIN, 12);
    Font fontNormal = new Font("Arial", Font.PLAIN, 14);
    Font fontTotal = new Font("Arial", Font.BOLD, 16);

    Order order;

    PaymentProcessingPage(Order order) {
        this.order = order;

        setSize(1280, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pinoy Platters - Payment Processing");
        setResizable(false);

        getContentPane().setBackground(colorCream);

        JPanel pnlTopBar = new JPanel();
        pnlTopBar.setLayout(null);
        pnlTopBar.setBounds(0, 0, 1280, 70);
        pnlTopBar.setBackground(colorCream);
        add(pnlTopBar);

        txtSearch = new JTextField("SEARCH");
        txtSearch.setBounds(20, 15, 300, 35);
        txtSearch.setFont(fontNormal);
        txtSearch.setForeground(Color.GRAY);
        pnlTopBar.add(txtSearch);

        ImageIcon userIcon = new ImageIcon("icons/USER.png");
        Image userImg = userIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        lblUser = new JLabel("USER", new ImageIcon(userImg), JLabel.LEFT);
        lblUser.setBounds(1100, 20, 120, 30);
        lblUser.setFont(fontBold);
        pnlTopBar.add(lblUser);

        JPanel pnlPaymentHeader = new JPanel();
        pnlPaymentHeader.setLayout(null);
        pnlPaymentHeader.setBounds(0, 70, 600, 55);
        pnlPaymentHeader.setBackground(colorRed);
        add(pnlPaymentHeader);

        lblPaymentProcessing = new JLabel("PAYMENT PROCESSING");
        lblPaymentProcessing.setBounds(10, 10, 580, 35);
        lblPaymentProcessing.setFont(fontHeader);
        lblPaymentProcessing.setForeground(colorCream);
        pnlPaymentHeader.add(lblPaymentProcessing);

        JPanel pnlOrderSummary = new JPanel();
        pnlOrderSummary.setLayout(null);
        pnlOrderSummary.setBounds(0, 125, 600, 610);
        pnlOrderSummary.setBackground(colorCream);
        add(pnlOrderSummary);

        lblOrderSummary = new JLabel("ORDER SUMMARY");
        lblOrderSummary.setBounds(20, 20, 300, 30);
        lblOrderSummary.setFont(fontBold);
        pnlOrderSummary.add(lblOrderSummary);

        int yPos = 60;
        for (int i = 0; i < order.getItems().size(); i++) {
            OrderItem item = order.getItems().get(i);

            JLabel lblName = new JLabel(item.getItemName() + " x" + item.getQuantity());
            lblName.setBounds(20, yPos, 350, 25);
            lblName.setFont(fontNormal);
            pnlOrderSummary.add(lblName);

            JLabel lblPrice = new JLabel("P" + String.format("%.0f", item.getTotalPrice()));
            lblPrice.setBounds(480, yPos, 100, 25);
            lblPrice.setFont(fontNormal);
            pnlOrderSummary.add(lblPrice);

            yPos = yPos + 30;
        }

        JSeparator separator = new JSeparator();
        separator.setBounds(20, 450, 560, 2);
        pnlOrderSummary.add(separator);

        lblSubtotal = new JLabel("Subtotal: P" + String.format("%.2f", order.getSubtotal()));
        lblSubtotal.setBounds(20, 460, 300, 25);
        lblSubtotal.setFont(fontSmall);
        pnlOrderSummary.add(lblSubtotal);

        lblTax = new JLabel("Tax (12%): P" + String.format("%.2f", order.getTax()));
        lblTax.setBounds(20, 485, 300, 25);
        lblTax.setFont(fontSmall);
        pnlOrderSummary.add(lblTax);

        lblTotal = new JLabel("TOTAL: P" + String.format("%.2f", order.getTotal()));
        lblTotal.setBounds(20, 515, 300, 30);
        lblTotal.setFont(fontTotal);
        pnlOrderSummary.add(lblTotal);

        JPanel pnlPaymentMethod = new JPanel();
        pnlPaymentMethod.setLayout(null);
        pnlPaymentMethod.setBounds(620, 70, 660, 665);
        pnlPaymentMethod.setBackground(colorSalmon);
        add(pnlPaymentMethod);

        JPanel pnlMethodHeader = new JPanel();
        pnlMethodHeader.setLayout(null);
        pnlMethodHeader.setBounds(0, 0, 660, 50);
        pnlMethodHeader.setBackground(colorMutedTeal);
        pnlPaymentMethod.add(pnlMethodHeader);

        lblPaymentMethod = new JLabel("PAYMENT METHOD");
        lblPaymentMethod.setBounds(10, 10, 300, 30);
        lblPaymentMethod.setFont(fontBold);
        lblPaymentMethod.setForeground(colorWhite);
        pnlMethodHeader.add(lblPaymentMethod);

        btnCash = new JButton("CASH");
        btnCash.setBounds(20, 65, 180, 40);
        btnCash.setFont(fontBold);
        btnCash.setBackground(colorWhite);
        btnCash.setBorderPainted(true);
        pnlPaymentMethod.add(btnCash);

        btnCard = new JButton("CARD");
        btnCard.setBounds(220, 65, 180, 40);
        btnCard.setFont(fontBold);
        btnCard.setBackground(colorWhite);
        btnCard.setBorderPainted(true);
        pnlPaymentMethod.add(btnCard);

        btnGcash = new JButton("GCASH");
        btnGcash.setBounds(20, 120, 180, 40);
        btnGcash.setFont(fontBold);
        btnGcash.setBackground(colorWhite);
        btnGcash.setBorderPainted(true);
        pnlPaymentMethod.add(btnGcash);

        btn100 = new JButton("P100");
        btn100.setBounds(20, 185, 185, 40);
        btn100.setFont(fontBold);
        btn100.setBackground(colorWhite);
        pnlPaymentMethod.add(btn100);

        btn200 = new JButton("P200");
        btn200.setBounds(220, 185, 185, 40);
        btn200.setFont(fontBold);
        btn200.setBackground(colorWhite);
        pnlPaymentMethod.add(btn200);

        btn500 = new JButton("P500");
        btn500.setBounds(420, 185, 185, 40);
        btn500.setFont(fontBold);
        btn500.setBackground(colorWhite);
        pnlPaymentMethod.add(btn500);

        btn1000 = new JButton("P1000");
        btn1000.setBounds(20, 240, 185, 40);
        btn1000.setFont(fontBold);
        btn1000.setBackground(colorWhite);
        pnlPaymentMethod.add(btn1000);

        btnExact = new JButton("EXACT");
        btnExact.setBounds(220, 240, 185, 40);
        btnExact.setFont(fontBold);
        btnExact.setBackground(colorWhite);
        pnlPaymentMethod.add(btnExact);

        lblAmountTendered = new JLabel("AMOUNT TENDERED");
        lblAmountTendered.setBounds(20, 300, 250, 25);
        lblAmountTendered.setFont(fontBold);
        pnlPaymentMethod.add(lblAmountTendered);

        txtAmountTendered = new JTextField("0.00");
        txtAmountTendered.setBounds(20, 330, 620, 45);
        txtAmountTendered.setFont(new Font("Arial", Font.PLAIN, 20));
        pnlPaymentMethod.add(txtAmountTendered);

        lblPaid = new JLabel("PAID: P" + String.format("%.2f", order.getTotal()));
        lblPaid.setBounds(20, 390, 300, 25);
        lblPaid.setFont(fontSmall);
        lblPaid.setForeground(colorRed);
        pnlPaymentMethod.add(lblPaid);

        lblChange = new JLabel("CHANGE: P0.00");
        lblChange.setBounds(20, 415, 300, 30);
        lblChange.setFont(fontTotal);
        pnlPaymentMethod.add(lblChange);

        btnProcessPayment = new JButton("PROCESS PAYMENT");
        btnProcessPayment.setBounds(20, 465, 620, 50);
        btnProcessPayment.setFont(fontBold);
        btnProcessPayment.setBackground(colorGreen);
        btnProcessPayment.setForeground(colorWhite);
        btnProcessPayment.setBorderPainted(false);
        pnlPaymentMethod.add(btnProcessPayment);

        btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(20, 530, 620, 40);
        btnCancel.setFont(fontBold);
        btnCancel.setBackground(colorSalmon);
        btnCancel.setBorderPainted(false);
        pnlPaymentMethod.add(btnCancel);

        btnCash.addActionListener(this);
        btnCard.addActionListener(this);
        btnGcash.addActionListener(this);
        btn100.addActionListener(this);
        btn200.addActionListener(this);
        btn500.addActionListener(this);
        btn1000.addActionListener(this);
        btnExact.addActionListener(this);
        btnProcessPayment.addActionListener(this);
        btnCancel.addActionListener(this);
    }

    private void computeChange() {
        try {
            double tendered = Double.parseDouble(txtAmountTendered.getText().trim());
            double change = tendered - order.getTotal();
            if (change >= 0) {
                lblChange.setText("CHANGE: P" + String.format("%.2f", change));
            } else {
                lblChange.setText("CHANGE: Insufficient amount");
            }
        } catch (NumberFormatException ex) {
            lblChange.setText("CHANGE: Invalid input");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn100) {
            txtAmountTendered.setText("100.00");
            computeChange();
        } else if (e.getSource() == btn200) {
            txtAmountTendered.setText("200.00");
            computeChange();
        } else if (e.getSource() == btn500) {
            txtAmountTendered.setText("500.00");
            computeChange();
        } else if (e.getSource() == btn1000) {
            txtAmountTendered.setText("1000.00");
            computeChange();
        } else if (e.getSource() == btnExact) {
            txtAmountTendered.setText(String.format("%.2f", order.getTotal()));
            computeChange();
        } else if (e.getSource() == btnCash) {
            JOptionPane.showMessageDialog(this, "Cash selected!", "Payment Method", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnCard) {
            JOptionPane.showMessageDialog(this, "Card selected!", "Payment Method", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnGcash) {
            JOptionPane.showMessageDialog(this, "GCash selected!", "Payment Method", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnProcessPayment) {
            computeChange();
            try {
                double tendered = Double.parseDouble(txtAmountTendered.getText().trim());
                if (tendered >= order.getTotal()) {
                    PaymentConfirmationDialog dialog = new PaymentConfirmationDialog(this, order);
                    dialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient amount!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnCancel) {
            dispose();
        }
    }
}