package RestaurantManagementSystem_.ManageUsers;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager
{
    private static UserManager instance;
    private List<String[]> userList = new ArrayList<>();

    private UserManager()
    {
        userList.add(new String[]{"--", "SA-001", "Angelie Iranzo",   "Super Admin", "superadmin123"});
        userList.add(new String[]{"--", "AD-001", "Alexa Reyes",   "Admin", "admin123"});
        userList.add(new String[]{"--", "EMP-001", "Marcuss Trinidad",   "Staff", "user123"});
    }

    public static UserManager getInstance()
    {
        if (instance == null) instance = new UserManager();
        return instance;
    }

    public List<String[]> getAllUsers()     { return userList; }
    public String[][]     getUsersAsArray() { return userList.toArray(new String[0][]); }

    public String[] login(String empNo, String password)
    {
        for (String[] user : userList)
        {
            if (user[1].equalsIgnoreCase(empNo) && user[4].equals(password))
                return user;
        }
        return null;
    }

    public void recordLogin(String empNo)
    {
        for (String[] user : userList)
        {
            if (user[1].equalsIgnoreCase(empNo))
            {
                user[0] = new java.text.SimpleDateFormat("hh:mm a").format(new java.util.Date());
                user[1] = "--";
                return;
            }
        }
    }

    public boolean addUser(String empNo, String name, String password, String role)
    {
        userList.add(new String[]{"--", empNo, name, role,password});
        return true;
    }

    public boolean deleteUser(String empNo)
    {
        return userList.removeIf(user -> user[2].equals(empNo));
    }

    public boolean updateUser(String empNo, String name, String role)
    {
        for (String[] user : userList)
        {
            if (user[1].equals(empNo))
            {
                user[2] = name;
                user[3] = role;
                return true;
            }
        }
        return false;
    }

    public boolean userExists(String empNo)
    {
        for (String[] user : userList)
            if (user[1].equalsIgnoreCase(empNo)) return true;
        return false;
    }

    public boolean validateAddUser(JFrame frame, String empNo, String name, String password, String confirmPassword, String role)
    {
        if (empNo.isEmpty() || name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty())
        {
            JOptionPane.showMessageDialog(frame, "All fields are required.", "Missing Fields", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!empNo.matches("EMP-\\d{3}") && role.equals("Staff"))
        {
            JOptionPane.showMessageDialog(frame, "Employee Number for Staff must follow the format: EMP-001", "Invalid Employee Number", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if (!empNo.matches("AD-\\d{3}") && role.equals("Admin"))
        {
            JOptionPane.showMessageDialog(frame, "Employee Number for Admin must follow the format: AD-001", "Invalid Employee Number", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if (!empNo.matches("SA-\\d{3}") && role.equals("Super Admin"))
        {
            JOptionPane.showMessageDialog(frame, "Employee Number for Super Admin must follow the format: SA-001", "Invalid Employee Number", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (userExists(empNo))
        {
            JOptionPane.showMessageDialog(frame, "Employee Number already exists.", "Duplicate Employee", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!name.matches("[a-zA-Z\\s]+"))
        {
            JOptionPane.showMessageDialog(frame, "Name should only contain letters.", "Invalid Name", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (password.length() < 6)
        {
            JOptionPane.showMessageDialog(frame, "Password must be at least 6 characters.", "Invalid Password", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!password.equals(confirmPassword))
        {
            JOptionPane.showMessageDialog(frame, "Passwords do not match.", "Password Mismatch", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (role.equals("-Select Role-"))
        {
            JOptionPane.showMessageDialog(frame, "Please select a role.", "Missing Role", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    public boolean validateEditUser(JFrame frame, String name, String role)
    {
        if (name.isEmpty())
        {
            JOptionPane.showMessageDialog(frame, "Name is required.", "Missing Fields", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!name.matches("[a-zA-Z\\s]+"))
        {
            JOptionPane.showMessageDialog(frame, "Name should only contain letters.", "Invalid Name", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (role.equals("-Select Role-"))
        {
            JOptionPane.showMessageDialog(frame, "Please select a role.", "Missing Role", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    public boolean validateDeleteUser(JFrame frame, String empNo)
    {
        if (empNo == null)
        {
            JOptionPane.showMessageDialog(frame, "Please select a user to delete.", "No User Selected", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!userExists(empNo))
        {
            JOptionPane.showMessageDialog(frame, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}