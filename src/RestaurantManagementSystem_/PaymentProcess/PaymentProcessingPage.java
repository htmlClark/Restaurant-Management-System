package RestaurantManagementSystem_.PaymentProcess;

import MainPlacementFrame.*;
import RestaurantManagementSystem_.Products.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaymentProcessingPage extends JPanel implements ActionListener {

    private JLabel lblPaymentProcessing, lblOrderSummary, lblSubtotal, lblTax, lblTotal,
    lblPaymentMethod, lblAmountTendered, lblPaid, lblChange;
    private JButton btnCash, btnCard, btnGcash,
            btn100, btn200, btn500, btn1000, btnExact,
            btnProcessPayment, btnCancel;

    private JTextField txtAmountTendered;
    Color colorCream   = new Color(0xFF, 0xF8, 0xE1);
    Color colorRed     = new Color(0xB7, 0x1C, 0x1C);
    Color colorSalmon  = new Color(0xF5, 0xCF, 0xBA);
    Color colorTeal    = new Color(0x89, 0xB7, 0xB3);
    Color colorGreen   = new Color(0x2E, 0x7D, 0x32);
    Color colorWhite   = new Color(0xFF, 0xFF, 0xFF);

    Font fontBold   = new Font("Arial", Font.BOLD, 14);
    Font fontHeader = new Font("Arial", Font.BOLD, 22);
    Font fontSmall  = new Font("Arial", Font.PLAIN, 12);
    Font fontNormal = new Font("Arial", Font.PLAIN, 14);
    Font fontTotal  = new Font("Arial", Font.BOLD, 16);

    private String selectedPaymentMethod = null;
    private Order order;
    private ProductSummary summaryPanel;

    public PaymentProcessingPage(Order order, ProductSummary summaryPanel)
    {
        this.order = order;
        this.summaryPanel = summaryPanel;

        orderSummary();
        paymentMethod();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void orderSummary()
    {
        //Order Summary Panel
        JPanel pnlOrderSummary = new JPanel(null);
        pnlOrderSummary.setBounds(0, 125, 580, 595);
        pnlOrderSummary.setBackground(colorCream);
        add(pnlOrderSummary);

        //LABELS
        ImageIcon paymentLogo = new ImageIcon(getClass().getResource("/src_pack/images/payment.png"));
        Image paymentSize = paymentLogo.getImage().getScaledInstance(350, 78, Image.SCALE_DEFAULT);

        lblPaymentProcessing = new JLabel(new ImageIcon(paymentSize));
            lblPaymentProcessing.setBounds(30, 20, 350, 78);
            add(lblPaymentProcessing);

        lblOrderSummary = new JLabel("ORDER SUMMARY");
            lblOrderSummary.setBounds(30, 20, 300, 30);
            lblOrderSummary.setFont(fontHeader);
            pnlOrderSummary.add(lblOrderSummary);

        int yPos = 60;
        for (int i = 0; i < order.getItems().size(); i++)
        {
            OrderItem item = order.getItems().get(i);

            JLabel lblName = new JLabel(item.getItemName() + " x" + item.getQuantity());
            lblName.setBounds(30, yPos, 350, 25);
            lblName.setFont(fontNormal);
            pnlOrderSummary.add(lblName);

            JLabel lblPrice = new JLabel("₱" + String.format("%.0f", item.getTotalPrice()));
            lblPrice.setBounds(460, yPos, 100, 25);
            lblPrice.setFont(fontNormal);
            pnlOrderSummary.add(lblPrice);

            yPos += 30;
        }

        JSeparator separator = new JSeparator();
        separator.setBounds(30, 450, 540, 2);
        pnlOrderSummary.add(separator);

        lblSubtotal = new JLabel("Subtotal: ₱" + String.format("%.2f", order.getSubtotal()));
        lblSubtotal.setBounds(30, 460, 300, 25);
        lblSubtotal.setFont(fontSmall);
        pnlOrderSummary.add(lblSubtotal);

        lblTax = new JLabel("Tax (12%): ₱" + String.format("%.2f", order.getVAT()));
        lblTax.setBounds(30, 485, 300, 25);
        lblTax.setFont(fontSmall);
        pnlOrderSummary.add(lblTax);

        lblTotal = new JLabel("TOTAL: ₱" + String.format("%.2f", order.getTotal()));
        lblTotal.setBounds(30, 515, 300, 30);
        lblTotal.setFont(fontTotal);
        pnlOrderSummary.add(lblTotal);
    }

    private void paymentMethod()
    {
        JPanel pnlPaymentMethod = new JPanel(null);
        pnlPaymentMethod.setBounds(590, 70, 390, 650);
        pnlPaymentMethod.setBackground(colorSalmon);
        add(pnlPaymentMethod);

        // Header
        JPanel pnlMethodHeader = new JPanel(null);
        pnlMethodHeader.setBounds(0, 0, 390, 50);
        pnlMethodHeader.setBackground(colorTeal);
        pnlPaymentMethod.add(pnlMethodHeader);

        lblPaymentMethod = new JLabel("PAYMENT METHOD");
        lblPaymentMethod.setBounds(10, 10, 300, 30);
        lblPaymentMethod.setFont(fontBold);
        lblPaymentMethod.setForeground(colorWhite);
        pnlMethodHeader.add(lblPaymentMethod);

        // Payment type buttons
        btnCash = new JButton("CASH");
        btnCash.setBounds(20, 65, 160, 40);
        btnCash.setFont(fontBold);
        btnCash.setBackground(colorWhite);
        pnlPaymentMethod.add(btnCash);

        btnCard = new JButton("CARD");
        btnCard.setBounds(200, 65, 160, 40);
        btnCard.setFont(fontBold);
        btnCard.setBackground(colorWhite);
        pnlPaymentMethod.add(btnCard);

        btnGcash = new JButton("GCASH");
        btnGcash.setBounds(20, 120, 160, 40);
        btnGcash.setFont(fontBold);
        btnGcash.setBackground(colorWhite);
        pnlPaymentMethod.add(btnGcash);

        // Denomination buttons
        btn100 = new JButton("₱100");
        btn100.setBounds(20, 185, 160, 40);
        btn100.setFont(fontBold);
        btn100.setBackground(colorWhite);
        pnlPaymentMethod.add(btn100);

        btn200 = new JButton("₱200");
        btn200.setBounds(200, 185, 160, 40);
        btn200.setFont(fontBold);
        btn200.setBackground(colorWhite);
        pnlPaymentMethod.add(btn200);

        btn500 = new JButton("₱500");
        btn500.setBounds(20, 240, 160, 40);
        btn500.setFont(fontBold);
        btn500.setBackground(colorWhite);
        pnlPaymentMethod.add(btn500);

        btn1000 = new JButton("₱1000");
        btn1000.setBounds(200, 240, 160, 40);
        btn1000.setFont(fontBold);
        btn1000.setBackground(colorWhite);
        pnlPaymentMethod.add(btn1000);

        btnExact = new JButton("EXACT");
        btnExact.setBounds(20, 295, 340, 40);
        btnExact.setFont(fontBold);
        btnExact.setBackground(colorWhite);
        pnlPaymentMethod.add(btnExact);

        // Amount tendered
        lblAmountTendered = new JLabel("AMOUNT TENDERED");
        lblAmountTendered.setBounds(20, 350, 250, 25);
        lblAmountTendered.setFont(fontBold);
        pnlPaymentMethod.add(lblAmountTendered);

        txtAmountTendered = new JTextField("0.00");
        txtAmountTendered.setBounds(20, 380, 340, 40);
        txtAmountTendered.setFont(new Font("Arial", Font.PLAIN, 18));
        pnlPaymentMethod.add(txtAmountTendered);
        txtAmountTendered.getDocument().addDocumentListener(new javax.swing.event.DocumentListener()
        {
            public void insertUpdate(javax.swing.event.DocumentEvent e)  { computeChange(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e)  { computeChange(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { computeChange(); }
        });

        lblPaid = new JLabel("PAID: ₱" + String.format("%.2f", order.getTotal()));
        lblPaid.setBounds(20, 430, 300, 25);
        lblPaid.setFont(fontSmall);
        lblPaid.setForeground(colorRed);
        pnlPaymentMethod.add(lblPaid);

        lblChange = new JLabel("CHANGE: ₱0.00");
        lblChange.setBounds(20, 455, 300, 30);
        lblChange.setFont(fontTotal);
        pnlPaymentMethod.add(lblChange);

        // Action buttons
        btnProcessPayment = new JButton("PROCESS PAYMENT");
        btnProcessPayment.setBounds(20, 500, 340, 45);
        btnProcessPayment.setFont(fontBold);
        btnProcessPayment.setBackground(colorGreen);
        btnProcessPayment.setForeground(colorWhite);
        btnProcessPayment.setBorderPainted(false);
        pnlPaymentMethod.add(btnProcessPayment);

        btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(20, 560, 340, 40);
        btnCancel.setFont(fontBold);
        btnCancel.setBackground(colorSalmon);
        btnCancel.setBorderPainted(false);
        pnlPaymentMethod.add(btnCancel);

        // Register listeners
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

    private void computeChange()
    {
        try {
            double tendered = Double.parseDouble(txtAmountTendered.getText().trim());
            double change = tendered - order.getTotal();
            if (change >= 0)
                lblChange.setText("CHANGE: ₱" + String.format("%.2f", change));
            else
                lblChange.setText("CHANGE: Insufficient amount");
        } catch (NumberFormatException ex) {
            lblChange.setText("CHANGE: Invalid input");
        }
    }

    private void selectPaymentMethod(JButton selectedBtn, String paymentMethod)
    {
        //tis is for un-selecting buttons
        if (paymentMethod.equals(selectedPaymentMethod))
        {
            selectedBtn.setBackground(colorWhite);
            selectedBtn.setForeground(Color.BLACK);
            selectedPaymentMethod = null;
            return;
        }

        //tis for unselected buttons setup
        btnCard.setBackground(colorWhite);
        btnCard.setForeground(Color.BLACK);

        btnCash.setBackground(colorWhite);
        btnCash.setForeground(Color.BLACK);

        btnGcash.setBackground(colorWhite);
        btnGcash.setForeground(Color.BLACK);

        //tis for selected button
        selectedBtn.setBackground(colorGreen);
        selectedBtn.setForeground(colorWhite);
        selectedPaymentMethod = paymentMethod;
    }

    private boolean validatePaymentMethod()
    {
        if (selectedPaymentMethod == null)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Please select a payment method first.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void validateAmtTendered()
    {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        try {
            double tendered = Double.parseDouble(txtAmountTendered.getText().trim());
            double orderTotal = order.getTotal();
            if (tendered >= orderTotal)
            {
                if (tendered >= (orderTotal*10))
                {
                    int cashNotice = JOptionPane.showConfirmDialog(
                            null,
                            "Oops. Amount Tendered exceed 10 times more than the Total Amount.\nDo you still want to continue?",
                            "CASH AMOUNT NOTICE!",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(cashNotice == JOptionPane.YES_OPTION)
                    {
                        PaymentConfirmationDialog dialog = new PaymentConfirmationDialog(frame, order);
                        dialog.setVisible(true);
                    }
                }
                else
                {
                    PaymentConfirmationDialog dialog = new PaymentConfirmationDialog(frame, order);
                    dialog.setVisible(true);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(
                        null,
                        "Insufficient amount!",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please enter a valid amount!",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelBtn()
    {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        JPanel nextPanel = new Products(summaryPanel);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(nextPanel);
        frame.revalidate();
        frame.repaint();

        if (frame instanceof userFrame)            { ((userFrame) frame).switchPanel(nextPanel); }
        else if (frame instanceof adminFrame)      { ((adminFrame) frame).switchPanel(nextPanel); }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if      (e.getSource() == btn100)   { txtAmountTendered.setText("100.00");  computeChange(); }
        else if (e.getSource() == btn200)   { txtAmountTendered.setText("200.00");  computeChange(); }
        else if (e.getSource() == btn500)   { txtAmountTendered.setText("500.00");  computeChange(); }
        else if (e.getSource() == btn1000)  { txtAmountTendered.setText("1000.00"); computeChange(); }
        else if (e.getSource() == btnExact) { txtAmountTendered.setText(String.format("%.2f", order.getTotal())); computeChange(); }
        else if (e.getSource() == btnCash) { selectPaymentMethod(btnCash, "CASH"); }
        else if (e.getSource() == btnCard) { selectPaymentMethod(btnCard, "CARD"); }
        else if (e.getSource() == btnGcash) { selectPaymentMethod(btnGcash, "GCASH"); }
        else if (e.getSource() == btnProcessPayment)
        {
            if (!validatePaymentMethod()) { return; }
            computeChange();
            validateAmtTendered();
        }
        else if (e.getSource() == btnCancel)
        {
            cancelBtn();
        }
    }
}

