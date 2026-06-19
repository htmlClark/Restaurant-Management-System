package RestaurantManagementSystem_.ManageUsers;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import RestaurantManagementSystem_.FoodWasteTracker.WasteLogSession;

public class UserManager
{
    private static UserManager instance;
    private List<String[]> userList = new ArrayList<>();
    
    public static final String STATUS_ACTIVE = "Active";
    public static final String STATUS_INACTIVE = "Inactive";
    
    private UserManager()
    {
        userList.add(new String[]{"--", "SA-001", "Angelie Iranzo", "Super Admin", "2026-06-18", STATUS_ACTIVE, "superadmin123"});
        userList.add(new String[]{"--", "AD-001", "Alexa Reyes", "Admin", "2026-06-18", STATUS_ACTIVE, "admin123"});
        userList.add(new String[]{"--", "EMP-001", "Marcuss Trinidad", "Staff", "2026-06-18", STATUS_ACTIVE, "user123"});
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
            if (user[1].equalsIgnoreCase(empNo) && user[6].equals(password))
            {
                if(!STATUS_ACTIVE.equalsIgnoreCase(user[5])) return null;
                return user;   
            }
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
                WasteLogSession.getInstance().setEmployeeNo(empNo);
                return;
            }
        }
    }

    public boolean addUser(String empNo, String name, String password, String role, String hireDate)
    {
        userList.add(new String[]{"--", empNo, name, role, hireDate, STATUS_ACTIVE, password});
        return true;
    }

    public boolean terminateUser(String empNo)
    {
        for (String[] user : userList)
        {
            if (user[1].equalsIgnoreCase(empNo))
            {
                if(!STATUS_ACTIVE.equalsIgnoreCase(user[5])) return false; // user already inactive
                user[5] = STATUS_INACTIVE;
                return true;
            }    
        }
        return false;
    }
    
    public boolean reactivateUser(String empNo)
    {
        for (String[] user : userList)
        {
            if (user[1].equals(empNo))
            {
                if (STATUS_ACTIVE.equalsIgnoreCase(user[5])) return false; // user already active
                user[5] = STATUS_ACTIVE;
                return true;
            }
        }
        return false;
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
    
    public boolean isUserActive(String empNo)
    {
        for (String[] user : userList)
            if (user[1].equalsIgnoreCase(empNo)) return STATUS_ACTIVE.equalsIgnoreCase(user[5]);
        return false;
    }

    public String getUserStatus(String empNo)
    {
        for (String[] user : userList)
            if (user[1].equalsIgnoreCase(empNo)) return user[5];
        return null;
    }
    
    public boolean validateAddUser(JFrame frame, String empNo, String name, String password, String confirmPassword, String role, String hireDate)
    {
        if (empNo.isEmpty() || name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty())
        {
            JOptionPane.showMessageDialog(frame, "All fields are required.", "Missing Fields", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!hireDate.matches("\\d{2}/\\d{2}/\\d{4}"))
        {
            JOptionPane.showMessageDialog(frame, "Hire Date must follow the format: MM/DD/YYYY", "Invalid Hire Date", JOptionPane.WARNING_MESSAGE);
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
            if (!isUserActive(empNo))
            {
                JOptionPane.showMessageDialog(frame, "This Employee Number belongs to a terminated employee. \nUse the REACTIVATE function instead of adding a new user", "Terminated Employee", JOptionPane.WARNING_MESSAGE);
            }
            else 
            {
                JOptionPane.showMessageDialog(frame, "Employee Number already exists.", "Duplicate Employee", JOptionPane.WARNING_MESSAGE);
            }
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

    public boolean validateTerminateUser(JFrame frame, String empNo)
    {
        if (empNo == null)
        {
            JOptionPane.showMessageDialog(frame, "Please select a user to terminate.", "No User Selected", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!userExists(empNo))
        {
            JOptionPane.showMessageDialog(frame, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!isUserActive(empNo))
        {
            JOptionPane.showMessageDialog(frame, "Employee " + empNo + " is already marked as Inactive.", "Already Terminated", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }
    
    public boolean validateReactivateUser(JFrame frame, String empNo)
    {
        if (empNo == null)
        {
            JOptionPane.showMessageDialog(frame, "Please select a user to reactivate.", "No User Selected", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!userExists(empNo))
        {
            JOptionPane.showMessageDialog(frame, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (isUserActive(empNo))
        {
            JOptionPane.showMessageDialog(frame, "Employee " + empNo + " is already Active.", "Already Active", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }
}