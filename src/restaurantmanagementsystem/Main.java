/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author aamar
 */

 import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ignored) {}

        // change na lang ng admin or superadmin if ano ipapaprun hehe
        String role = "SUPER ADMIN";

        SwingUtilities.invokeLater(() -> {
            if (role.equals("SUPER ADMIN")) {
                new ManageUsersSuperAdminPanel();
            } else {
                new ManageUsersAdminPanel();
            }
        });
    }
}
    
    
