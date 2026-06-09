package RestaurantManagementSystem_.FoodWasteTracker;

import javax.swing.*;
import java.util.*;

public class StaffApp extends JFrame {

    public StaffApp(List<WasteLog> sharedLogs, String username) {
        setTitle("Food Waste Tracker – Staff");
        setSize(1280, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        WasteLogPanel panel = new WasteLogPanel(sharedLogs, WasteLogPanel.Role.STAFF);
        panel.setBounds(0, 0, 1280, 800);
        add(panel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StaffApp app = new StaffApp(new ArrayList<>(), "staff");
            app.setVisible(true);
        });
    }
}
