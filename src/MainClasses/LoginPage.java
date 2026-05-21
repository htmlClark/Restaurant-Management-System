package MainClasses;

import MainPlacementFrame.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginPage extends JFrame implements ActionListener
{
    private JPanel logInPanel, recPanel;
    private JLabel lblTableCloth, lblDish1, lblDish2, lblDish3, lblTitle1, lblTitle2, lblSubtitle,
    lblRestaurantName, lblLogin, lblLoginSub, lblUsername, lblPass;
    private JTextField txtUsername;
    private JPasswordField pwdPass;
    private JButton btnLogin;

    public LoginPage()
    {
        loginBg();
        loginPanel();

        setSize (1280,800);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#FFF8E1"));
    }

    private void loginBg()
    {
        lblTitle1 = new JLabel ("Panlasang Pinoy");
            lblTitle1.setBounds(25, 45, 800, 60);
            lblTitle1.setFont(new Font("Arial", Font.BOLD, 50));
            add(lblTitle1);

        lblTitle2 = new JLabel ("Para sa Pinoy");
            lblTitle2.setBounds(25, 105, 800, 60);
            lblTitle2.setFont(new Font("Arial", Font.BOLD, 50));
            add(lblTitle2);

        lblSubtitle = new JLabel(
                "<html> The taste of home for every <i>Pinoy!</i> Sharing dishes that " +
                "<br> " +
                "unite families, celebrate culture, and keep <b> Filipino" +
                "<br>" +
                "heritage </b> alive. </html>"
        );
            lblSubtitle.setBounds(25, 180, 800, 60);
            lblSubtitle.setFont(new Font("Arial", Font.PLAIN, 16));
            add(lblSubtitle);

        recPanel = new JPanel();
            recPanel.setBounds(0, 0,720,800);
            recPanel.setBackground(new Color(255, 248, 225,100));
            add(recPanel);

        ImageIcon dish1 = new ImageIcon (getClass().getResource("/src_pack/images/dish1.png"));
        Image dish1Size = dish1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        lblDish1 = new JLabel (new ImageIcon(dish1Size));
        lblDish1.setBounds(370, 520, 350, 350);
        add(lblDish1);

        ImageIcon dish2 = new ImageIcon (getClass().getResource("/src_pack/images/dish2.png"));
        Image dish2Size = dish2.getImage().getScaledInstance(390, 390, Image.SCALE_DEFAULT);
        lblDish2 = new JLabel (new ImageIcon(dish2Size));
            lblDish2.setBounds(20, 420, 390, 390);
            add(lblDish2);

        ImageIcon dish3 = new ImageIcon (getClass().getResource("/src_pack/images/dish3.png"));
        Image dish3Size = dish3.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        lblDish3 = new JLabel (new ImageIcon(dish3Size));
            lblDish3.setBounds(300, 280, 350, 350);
            add(lblDish3);

        ImageIcon tableCloth = new ImageIcon (getClass().getResource("/src_pack/images/tableCloth.png"));
        Image tblClothSize = tableCloth.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        lblTableCloth = new JLabel (new ImageIcon(tblClothSize));
        lblTableCloth.setBounds(0, 200, 700, 800);
        add(lblTableCloth);
    }

    private void loginPanel()
    {
        ImageIcon restaurantTitle = new ImageIcon (getClass().getResource("/src_pack/images/name.png"));
        Image titleSize = restaurantTitle.getImage().getScaledInstance(550, 150, Image.SCALE_SMOOTH);

        lblRestaurantName = new JLabel (new ImageIcon(titleSize));
            lblRestaurantName.setBounds(720, 0, 550, 150);
            add(lblRestaurantName);

        lblLogin = new JLabel ("WELCOME BACK");
            lblLogin.setFont(new Font("Arial", Font.BOLD, 40));
            lblLogin.setForeground(Color.WHITE);
            lblLogin.setBounds(830, 160, 800, 50);
            add(lblLogin);

        lblLoginSub = new JLabel ("Login to your account to view more");
            lblLoginSub.setFont(new Font("Arial", Font.PLAIN, 17));
            lblLoginSub.setForeground(Color.WHITE);
            lblLoginSub.setBounds(870, 210, 500, 30);
            add(lblLoginSub);

        lblUsername = new JLabel ("USERNAME");
            lblUsername.setFont(new Font("Arial", Font.PLAIN, 22));
            lblUsername.setForeground(Color.WHITE);
            lblUsername.setBounds(800, 310, 500, 30);
            add(lblUsername);

        txtUsername = new JTextField();
            txtUsername.setBackground(Color.decode("#FFF8E1"));
            txtUsername.setFont(new Font("Arial", Font.PLAIN, 22));
            txtUsername.setBounds(800, 350, 400, 50);
            txtUsername.setBorder(new LineBorder (Color.BLACK,3,true));
            add(txtUsername);

        lblPass = new JLabel ("PASSWORD");
            lblPass.setFont(new Font("Arial", Font.PLAIN, 22));
            lblPass.setForeground(Color.WHITE);
            lblPass.setBounds(800, 450, 500, 30);
            add(lblPass);

        pwdPass = new JPasswordField();
            pwdPass.setBackground(Color.decode("#FFF8E1"));
            pwdPass.setFont(new Font("Arial", Font.PLAIN, 22));
            pwdPass.setBounds(800, 490, 400, 50);
            pwdPass.setBorder(new LineBorder (Color.BLACK,3,true));
            add(pwdPass);

        ImageIcon loginLogo = new ImageIcon (getClass().getResource("/src_pack/images/login.png"));
        Image loginSize = loginLogo.getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT);

        btnLogin = new JButton(new ImageIcon(loginSize));
            btnLogin.setBackground(Color.decode("#FFDE59"));
            btnLogin.setBounds(900, 620,200, 50);
            btnLogin.addActionListener(this);
            add(btnLogin);

        logInPanel = new JPanel();
            logInPanel.setBounds(720, 0,720,800);
            logInPanel.setBackground(Color.decode("#B71C1C"));
            add(logInPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usernameInput = txtUsername.getText();
        String passwordInput = new String(pwdPass.getPassword());

        if (e.getSource() == btnLogin) {
            if ((usernameInput.equals("user123")) && (passwordInput.equals("user123"))) {
                dispose();
                userFrame UserFrame = new userFrame();
                UserFrame.setVisible(true);
            }
            else if ((usernameInput.equals("admin123")) && (passwordInput.equals("admin123"))) {
                dispose();
                adminFrame AdminFrame = new adminFrame();
                AdminFrame.setVisible(true);
            }
            else if ((usernameInput.equals("superadmin123")) && (passwordInput.equals("superadmin123"))) {
                dispose();
                superAdminFrame SuperAdminFrame = new superAdminFrame();
                SuperAdminFrame.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid username or password. Please try again.","LOGIN FAILED",JOptionPane.ERROR_MESSAGE);
                txtUsername.setText("");
                pwdPass.setText("");
            }
        }
}}
