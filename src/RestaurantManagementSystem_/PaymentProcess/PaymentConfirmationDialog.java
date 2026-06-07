package RestaurantManagementSystem_.PaymentProcess;
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

    Color colorCream = new Color(0xFF, 0xF8, 0xE1);
    Color colorRed = new Color(0xB7, 0x1C, 0x1C);
    Color colorGold = new Color(0xFF, 0xB3, 0x00);
    Color colorWhite = new Color(0xFF, 0xFF, 0xFF);
    Color colorBlack = new Color(0x00, 0x00, 0x00);

    Font fontHeader = new Font("Impact", Font.BOLD, 26);
    Font fontNormal = new Font("Arial", Font.PLAIN, 14);

    PaymentConfirmationDialog(JFrame parent, Order order) {
        super(parent, true);
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
        lblPaymentProcessed.setBounds(50, 10, 340, 40);
        lblPaymentProcessed.setFont(fontHeader);
        lblPaymentProcessed.setForeground(colorCream);
        pnlHeader.add(lblPaymentProcessed);

        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        String dateTime = now.getMonthValue() + "/" + now.getDayOfMonth() + "/" + now.getYear()
                + "   " + String.format("%02d", now.getHour()) + ":" + String.format("%02d", now.getMinute());

        lblDateTime = new JLabel(dateTime);
        lblDateTime.setBounds(150, 95, 200, 25);
        lblDateTime.setFont(fontNormal);
        add(lblDateTime);

        lblOrderNo = new JLabel("ORDER NO. " + order.getOrderNumber());
        lblOrderNo.setBounds(130, 130, 250, 40);
        lblOrderNo.setFont(new Font("Arial", Font.BOLD, 26));
        add(lblOrderNo);

        JSeparator separator = new JSeparator();
        separator.setBounds(30, 270, 440, 2);
        add(separator);

        btnPrintReceipt = new JButton("PRINT RECEIPT");
        btnPrintReceipt.setBounds(130, 190, 240, 45);
        btnPrintReceipt.setFont(new Font("Impact", Font.BOLD, 14));
        btnPrintReceipt.setBackground(colorGold);
        btnPrintReceipt.setForeground(colorWhite);
        btnPrintReceipt.setBorderPainted(false);
        add(btnPrintReceipt);

        btnConfirm = new JButton("CONFIRM");
        btnConfirm.setBounds(30, 285, 440, 55);
        btnConfirm.setFont(new Font("Impact", Font.BOLD, 20));
        btnConfirm.setBackground(colorCream);
        btnConfirm.setForeground(colorBlack);
        btnConfirm.setBorderPainted(true);
        add(btnConfirm);

        btnPrintReceipt.addActionListener(this);
        btnConfirm.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirm) {
            dispose();
        } else if (e.getSource() == btnPrintReceipt) {
            JOptionPane.showMessageDialog(this, "Printing receipt...", "Print", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}