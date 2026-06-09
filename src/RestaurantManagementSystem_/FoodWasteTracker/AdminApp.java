package RestaurantManagementSystem_.FoodWasteTracker;

import javax.swing.*;
import java.util.*;

public class AdminApp extends JFrame {

    public AdminApp(List<WasteLog> sharedLogs, String username) {
        setTitle("Food Waste Tracker – Admin");
        setSize(1280, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        WasteLogPanel panel = new WasteLogPanel(sharedLogs, WasteLogPanel.Role.ADMIN);
        panel.setBounds(0, 0, 1280, 800);
        add(panel);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminApp app = new AdminApp(new ArrayList<>(), "admin");
            app.setVisible(true);
        });
    }
}
