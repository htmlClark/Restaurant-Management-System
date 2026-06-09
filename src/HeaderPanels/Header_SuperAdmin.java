package HeaderPanels;
import javax.swing.*;
import java.awt.*;

public class Header_SuperAdmin extends JPanel{
    private JLabel lblRole, lblIcon;

    public Header_SuperAdmin(String role)
    {
        header(role);

        setBounds(300, 0, 980, 80);
        setLayout(null);
        setBackground(Color.decode("#F2D0BD"));
    }

    private void header(String role)
    {
        //tis for user
        ImageIcon userIcon = new ImageIcon(getClass().getResource("/src_pack/images/super.png"));
        Image userSize = userIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

        lblIcon = new JLabel(new ImageIcon(userSize));
        lblIcon.setBounds(890, 20, 40, 40);

        lblRole = new JLabel(role);
        lblRole.setBounds(800, 27, 80, 25);
        lblRole.setFont(new Font("Arial", Font.BOLD, 18));
        lblRole.setForeground(Color.BLACK);
        lblRole.setHorizontalAlignment(SwingConstants.RIGHT);

        add(lblRole);
        add(lblIcon);
    }
}
