package restaurantmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserManagement extends JFrame {

    //colors
    Color backgroundColor = Color.decode("#F5F0DD");
    Color topbarColor = Color.decode("#EBCFB2");
    Color redColor = Color.decode("#B71C1C");
    Color panelColor = Color.decode("#A8B5B2");

    //components
    JTable usersTable;
    DefaultTableModel tableModel;

    JButton addUserButton;
    JButton editUserButton;
    JButton deleteUserButton;

    JTextField searchField;

    //constructor
    public UserManagement() {

        try {

            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        initializeFrame();

        initializeComponents();

        setVisible(true);
    }

    //frame
    private void initializeFrame() {

        setTitle("Manage Users");

        setSize(1280, 800);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        getContentPane().setBackground(backgroundColor);
    }

    
    private void initializeComponents() {

        //top panel
        JPanel topPanel = new JPanel();

        topPanel.setLayout(null);

        topPanel.setBackground(topbarColor);

        topPanel.setBounds(280, 0, 1000, 80);

        add(topPanel);

        //search field
        searchField = new JTextField();

        searchField.setFont(
                new Font("Arial", Font.ITALIC, 18)
        );

        searchField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                Color.GRAY,
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                10,
                                15,
                                10,
                                15
                        )
                )
        );

        searchField.setBounds(30, 20, 420, 42);

        topPanel.add(searchField);

        //admin label
        JLabel adminLabel =
                new JLabel("SUPER ADMIN");

        adminLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        adminLabel.setBounds(760, 20, 220, 40);

        topPanel.add(adminLabel);

        //main content label
        RoundedPanel contentPanel =
                new RoundedPanel(35);

        contentPanel.setLayout(null);

        contentPanel.setBackground(panelColor);

        contentPanel.setBounds(300, 100, 940, 640);

        add(contentPanel);

        //title
        JLabel titleLabel =
                new JLabel("MANAGE USERS");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 34)
        );

        titleLabel.setBounds(30, 20, 400, 40);

        contentPanel.add(titleLabel);

        //table, table model, and table columns
        String[] columns = {

                "TIME LOGGED IN",
                "TIME LOGGED OUT",
                "EMPLOYEE NUMBER",
                "NAME",
                "STATUS"
        };

        tableModel =
                new DefaultTableModel(columns, 0) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {

                        return false;
                    }
                };

        usersTable =
                new JTable(tableModel);

        usersTable.setRowHeight(55);

        usersTable.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        //grid spacing, color, and background between cells
        usersTable.setShowGrid(true);

        usersTable.setIntercellSpacing(
                new Dimension(12, 12)
        );

        usersTable.setGridColor(panelColor);

        usersTable.setBackground(panelColor);

        usersTable.setSelectionBackground(
                new Color(53, 92, 115)
        );

        usersTable.setSelectionForeground(Color.WHITE);

        usersTable.setFocusable(false);

        usersTable.setBorder(
                BorderFactory.createEmptyBorder()
        );

        usersTable.getTableHeader()
                .setReorderingAllowed(false);

        usersTable.getTableHeader()
                .setResizingAllowed(false);

        //cell renderer
        DefaultTableCellRenderer cellRenderer =
                new DefaultTableCellRenderer() {

                    @Override
                    public Component getTableCellRendererComponent(
                            JTable table,
                            Object value,
                            boolean isSelected,
                            boolean hasFocus,
                            int row,
                            int column
                    ) {

                        JLabel label =
                                (JLabel) super
                                        .getTableCellRendererComponent(
                                                table,
                                                value,
                                                isSelected,
                                                hasFocus,
                                                row,
                                                column
                                        );

                        label.setHorizontalAlignment(
                                JLabel.CENTER
                        );

                        label.setFont(
                                new Font(
                                        "Arial",
                                        Font.BOLD,
                                        14
                                )
                        );

                        label.setOpaque(true);

                        //normal cell color
                        if (isSelected) {

                            label.setBackground(
                                    new Color(53, 92, 115)
                            );

                            label.setForeground(Color.WHITE);

                        } else {

                            label.setBackground(Color.WHITE);

                            label.setForeground(Color.BLACK);
                        }

                        label.setBorder(
                                BorderFactory.createMatteBorder(
                                        5,
                                        5,
                                        5,
                                        5,
                                        panelColor
                                )
                        );

                        return label;
                    }
                };

        //apply cell renderer
        for (int i = 0;
             i < usersTable.getColumnCount();
             i++) {

            usersTable.getColumnModel()
                    .getColumn(i)
                    .setCellRenderer(cellRenderer);
        }

        //header
        usersTable.getTableHeader().setPreferredSize(
                new Dimension(100, 60)
        );

        usersTable.getTableHeader().setDefaultRenderer(
                new DefaultTableCellRenderer() {

                    @Override
                    public Component getTableCellRendererComponent(
                            JTable table,
                            Object value,
                            boolean isSelected,
                            boolean hasFocus,
                            int row,
                            int column
                    ) {

                        JLabel label =
                                (JLabel) super
                                        .getTableCellRendererComponent(
                                                table,
                                                value,
                                                isSelected,
                                                hasFocus,
                                                row,
                                                column
                                        );

                        label.setHorizontalAlignment(
                                JLabel.CENTER
                        );

                        label.setBackground(
                                Color.decode("#23425C")
                        );

                        label.setForeground(Color.WHITE);

                        label.setFont(
                                new Font(
                                        "Arial",
                                        Font.BOLD,
                                        15
                                )
                        );

                        label.setOpaque(true);

                        label.setBorder(
                                BorderFactory.createMatteBorder(
                                        5,
                                        5,
                                        5,
                                        5,
                                        panelColor
                                )
                        );

                        return label;
                    }
                }
        );


        //scroll pane
        JScrollPane scrollPane =
                new JScrollPane(usersTable);

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder()
        );

        scrollPane.getViewport().setBackground(
                panelColor
        );

        scrollPane.setBounds(
                30,
                90,
                870,
                380
        );

        contentPanel.add(scrollPane);

        //sample data for illustration
        tableModel.addRow(new Object[]{

                "08:00 AM",
                "05:00 PM",
                "2025001",
                "Juan Dela Cruz",
                "ACTIVE"
        });

        tableModel.addRow(new Object[]{

                "09:00 AM",
                "06:00 PM",
                "2025002",
                "Maria Santos",
                "ACTIVE"
        });

        tableModel.addRow(new Object[]{

                "10:00 AM",
                "07:00 PM",
                "2025003",
                "Pedro Reyes",
                "INACTIVE"
        });

        //add user button
        addUserButton =
                new JButton("ADD USER");

        styleButton(addUserButton);

        addUserButton.setBounds(
                700,
                500,
                190,
                42
        );

        addUserButton.addActionListener(
                e -> addUser()
        );

        contentPanel.add(addUserButton);

        //edit user button
        editUserButton =
                new JButton("EDIT USER");

        styleButton(editUserButton);

        editUserButton.setBounds(
                700,
                555,
                190,
                42
        );

        editUserButton.addActionListener(
                e -> editUser()
        );

        contentPanel.add(editUserButton);

        //delete user button
        deleteUserButton =
                new JButton("DELETE USER");

        styleButton(deleteUserButton);

        deleteUserButton.setBounds(
                490,
                555,
                190,
                42
        );

        deleteUserButton.addActionListener(
                e -> deleteUser()
        );

        contentPanel.add(deleteUserButton);
    }

    //button style
    private void styleButton(JButton button) {

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setForeground(Color.WHITE);

        button.setBackground(redColor);

        button.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        button.setOpaque(true);
    }

    // add user
    private void addUser() {

        JTextField timeInField =
                new JTextField();

        JTextField timeOutField =
                new JTextField();

        JTextField employeeField =
                new JTextField();

        JTextField nameField =
                new JTextField();

        String[] status = {
                "ACTIVE",
                "INACTIVE"
        };

        JComboBox<String> statusBox =
                new JComboBox<>(status);

        Object[] fields = {

                "Time Logged In:", timeInField,

                "Time Logged Out:", timeOutField,

                "Employee Number:", employeeField,

                "Name:", nameField,

                "Status:", statusBox
        };

        int option =
                JOptionPane.showConfirmDialog(
                        this,
                        fields,
                        "Add User",
                        JOptionPane.OK_CANCEL_OPTION
                );

        if (option == JOptionPane.OK_OPTION) {

            tableModel.addRow(new Object[]{

                    timeInField.getText(),

                    timeOutField.getText(),

                    employeeField.getText(),

                    nameField.getText(),

                    statusBox.getSelectedItem()
            });
        }
    }

    //edit user
    private void editUser() {

        int selectedRow =
                usersTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a user first."
            );

            return;
        }

        JTextField timeInField =
                new JTextField(
                        tableModel.getValueAt(
                                selectedRow,
                                0
                        ).toString()
                );

        JTextField timeOutField =
                new JTextField(
                        tableModel.getValueAt(
                                selectedRow,
                                1
                        ).toString()
                );

        JTextField employeeField =
                new JTextField(
                        tableModel.getValueAt(
                                selectedRow,
                                2
                        ).toString()
                );

        JTextField nameField =
                new JTextField(
                        tableModel.getValueAt(
                                selectedRow,
                                3
                        ).toString()
                );

        String[] status = {
                "ACTIVE",
                "INACTIVE"
        };

        JComboBox<String> statusBox =
                new JComboBox<>(status);

        statusBox.setSelectedItem(
                tableModel.getValueAt(
                        selectedRow,
                        4
                ).toString()
        );

        Object[] fields = {

                "Time Logged In:", timeInField,

                "Time Logged Out:", timeOutField,

                "Employee Number:", employeeField,

                "Name:", nameField,

                "Status:", statusBox
        };

        int option =
                JOptionPane.showConfirmDialog(
                        this,
                        fields,
                        "Edit User",
                        JOptionPane.OK_CANCEL_OPTION
                );

        if (option == JOptionPane.OK_OPTION) {

            tableModel.setValueAt(
                    timeInField.getText(),
                    selectedRow,
                    0
            );

            tableModel.setValueAt(
                    timeOutField.getText(),
                    selectedRow,
                    1
            );

            tableModel.setValueAt(
                    employeeField.getText(),
                    selectedRow,
                    2
            );

            tableModel.setValueAt(
                    nameField.getText(),
                    selectedRow,
                    3
            );

            tableModel.setValueAt(
                    statusBox.getSelectedItem(),
                    selectedRow,
                    4
            );
        }
    }

    //delete user
    private void deleteUser() {

        int selectedRow =
                usersTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a user first."
            );

            return;
        }

        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "ARE YOU SURE YOU WANT TO DELETE\nTHIS USER?",
                        "DELETE USER",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

        if (confirm == JOptionPane.YES_OPTION) {

            tableModel.removeRow(selectedRow);
        }
    }
}

//rounded panel
class RoundedPanel extends JPanel {

    private int radius;

    public RoundedPanel(int radius) {

        this.radius = radius;

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 =
                (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(getBackground());

        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                radius,
                radius
        );

        g2.dispose();

        super.paintComponent(g);
    }
}