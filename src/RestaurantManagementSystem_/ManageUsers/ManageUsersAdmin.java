package RestaurantManagementSystem_.ManageUsers;

import java.awt.*;
import javax.swing.*;

public class ManageUsersAdmin extends JPanel {

    Color colorCream       = new Color(0xFF, 0xF8, 0xE1);
    Color colorRed         = new Color(0xB7, 0x1C, 0x1C);
    Color colorGold        = new Color(0xFF, 0xB3, 0x00);
    Color colorSalmon      = new Color(0xF5, 0xCF, 0xBA);
    Color colorMutedTeal   = new Color(0x89, 0xB7, 0xB3);
    Color colorTableHeader = new Color(0x2C, 0x5F, 0x7A);
    Color colorRowOdd      = new Color(0xFF, 0xF8, 0xE1);
    Color colorRowEven     = new Color(0xC9, 0xD4, 0xD8);
    Color colorWhite       = Color.WHITE;
    Color colorActive   = new Color(0x1B, 0x5E, 0x20);
    Color colorInactive = new Color(0xB7, 0x1C, 0x1C);

    Font fontHeader = new Font("Arial", Font.BOLD, 22);
    Font fontNormal = new Font("Arial", Font.PLAIN, 13);
    Font fontBold   = new Font("Arial", Font.BOLD, 14);

    private UserManager userManager = UserManager.getInstance();
    String[][] userData;

    String[] colHeaders = {"TIME LOGGED IN", "EMPLOYEE NUMBER", "NAME", "ROLE", "HIRE DATE", "STATUS"};
    int[]    colWidths  = {130, 140, 150, 120, 160, 150};

    public ManageUsersAdmin()
    {
        userData = userManager.getUsersAsArray();
        buildTableCard();

        setBounds(300, 80, 980, 720);
        setLayout(null);
        setBackground(colorCream);
    }

    private void buildTableCard()
    {
        JPanel pnlTableCard = new JPanel(null);
        pnlTableCard.setBounds(20, 20, 940, 680);
        pnlTableCard.setBackground(colorMutedTeal);
        pnlTableCard.setBorder(BorderFactory.createLineBorder(new Color(0x70, 0x99, 0x9E), 1));
        add(pnlTableCard);

        JLabel lblTitle = new JLabel("MANAGE USERS");
        lblTitle.setBounds(20, 14, 400, 34);
        lblTitle.setFont(fontHeader);
        lblTitle.setForeground(new Color(0x22, 0x22, 0x22));
        pnlTableCard.add(lblTitle);

        buildTableRows(pnlTableCard);
    }

    private void buildTableRows(JPanel pnlTableCard)
    {
        JPanel pnlRows = new JPanel(null);
        pnlRows.setBounds(20, 56, 900, 580);
        pnlRows.setBackground(colorMutedTeal);
        pnlTableCard.add(pnlRows);

        JPanel pnlHeader = new JPanel(null);
        pnlHeader.setBounds(0, 0, 900, 50);
        pnlHeader.setBackground(colorTableHeader);
        pnlRows.add(pnlHeader);

        int xCol = 0;
        for (int c = 0; c < colHeaders.length; c++)
        {
            int w = (900 * colWidths[c]) / 850;
            JLabel lblH = new JLabel(colHeaders[c], SwingConstants.CENTER);
            lblH.setBounds(xCol, 0, w, 50);
            lblH.setFont(new Font("Arial", Font.BOLD, 12));
            lblH.setForeground(colorWhite);
            pnlHeader.add(lblH);
            xCol += w;
        }

        int ROW_H = 58;
        for (int r = 0; r < userData.length; r++)
        {
            Color rowBg = (r % 2 == 0) ? colorRowOdd : colorRowEven;
            int yRow = 53 + r * (ROW_H + 3);

            JPanel pnlRow = new JPanel(null);
            pnlRow.setBounds(0, yRow, 900, ROW_H);
            pnlRow.setBackground(rowBg);
            pnlRows.add(pnlRow);

            xCol = 0;
            for (int c = 0; c < colHeaders.length; c++)
            {
                int w = (900 * colWidths[c]) / 850;
                JLabel lblCell = new JLabel(userData[r][c], SwingConstants.CENTER);
                lblCell.setBounds(xCol, 0, w, ROW_H);
                if (c == 5)
                {
                    boolean isInactive = userData[r][5].equalsIgnoreCase("Inactive");
                    lblCell.setFont(new Font("Arial", Font.BOLD, 12));
                    lblCell.setForeground(isInactive ? colorInactive : colorActive);
                }
                else
                {
                    lblCell.setFont(fontNormal);
                    lblCell.setForeground(new Color(0x22, 0x22, 0x22));
                }
                pnlRow.add(lblCell);
                xCol += w;
            }

            JPanel pnlSep = new JPanel();
            pnlSep.setBounds(0, yRow + ROW_H, 900, 3);
            pnlSep.setBackground(colorMutedTeal);
            pnlRows.add(pnlSep);
        }
    }
}