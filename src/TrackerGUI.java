import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackerGUI {
    public static void main(String[] args) {
        Color cream = Color.decode("#FFF8E1");
        Color teal = Color.decode("#89B7B3");
        Font openSans = new Font("Open Sans", Font.PLAIN, 16);
        Font openSansBold = new Font("Open Sans", Font.BOLD, 16);

        JFrame frame = new JFrame("Food Waste Tracker");
        frame.setSize(1280, 800);
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(20, 20));
        frame.getContentPane().setBackground(cream);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 15, 15));
        inputPanel.setBackground(cream);
        inputPanel.setBorder(new EmptyBorder(30, 50, 10, 50));
        
        JTextField itemField = new JTextField();
        JTextField qtyField = new JTextField();
        String[] reasons = {"Spoilage/Expired", "Leftovers", "Returns", "Staff Error", "Contaminated"};
        JComboBox<String> reasonCombo = new JComboBox<>(reasons);
        
        JButton logButton = new JButton("Log Waste Entry");
        
       
        logButton.setBackground(teal);
        logButton.setForeground(Color.WHITE); 
        logButton.setFocusPainted(false);
        logButton.setFont(openSansBold);

        JLabel itemLabel = new JLabel("Food Item:");
        itemLabel.setFont(openSans);
        JLabel qtyLabel = new JLabel("Quantity:");
        qtyLabel.setFont(openSans);
        JLabel reasonLabel = new JLabel("Reason:");
        reasonLabel.setFont(openSans);

        itemField.setFont(openSans);
        qtyField.setFont(openSans);
        reasonCombo.setFont(openSans);

        inputPanel.add(itemLabel);
        inputPanel.add(itemField);
        inputPanel.add(qtyLabel);
        inputPanel.add(qtyField);
        inputPanel.add(reasonLabel);
        inputPanel.add(reasonCombo);
        inputPanel.add(new JLabel(""));
        inputPanel.add(logButton);

        JTextArea logDisplay = new JTextArea();
        logDisplay.setEditable(false);
        logDisplay.setFont(new Font("Monospaced", Font.PLAIN, 14));
        logDisplay.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(logDisplay);
        scrollPane.setBorder(BorderFactory.createLineBorder(teal, 2));
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(cream);
        centerPanel.setBorder(new EmptyBorder(10, 50, 50, 50));
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = itemField.getText();
                String qty = qtyField.getText();
                String reason = (String) reasonCombo.getSelectedItem();

                if (!item.isEmpty() && !qty.isEmpty()) {
                    String entry = String.format(" > Item: %-20s | Qty: %-10s | Reason: %s\n", item, qty, reason);
                    logDisplay.append(entry);
                    
                    itemField.setText("");
                    qtyField.setText("");
                    itemField.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                }
            }
        });

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}