package RestaurantManagementSystem_.FoodWasteTracker;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class SharedUI {
    public static final Color C_CREAM = new Color(0xFF, 0xF8, 0xE1);
    public static final Color C_TEAL = new Color(0x36, 0x63, 0x79);
    public static final Color C_RED = new Color(0xB7, 0x1C, 0x1C);
    public static final Color C_GOLD = new Color(0xFF, 0xB3, 0x00);
    public static final Color C_PINK = new Color(0xF5, 0xCF, 0xBA);
    public static final Color C_STEEL = new Color(0x89, 0xB7, 0xB3);
    public static final Color C_DARK = new Color(0x22, 0x3A, 0x45);
    public static final Color C_WHITE = Color.WHITE;
    public static final Color C_ROW_ALT = new Color(0xFF, 0xF0, 0xD0);
    public static Font fTitle(int size) { return new Font("Serif", Font.BOLD, size); }
    public static Font fNav  (int size) { return new Font("SansSerif", Font.BOLD, size); }
    public static Font fBody (int size) { return new Font("SansSerif", Font.PLAIN, size); }

    ImageIcon wasteLogo = new ImageIcon(getClass().getResource("/src_pack/images/wastelog.png"));
    Image wasteSize = wasteLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);

public static JTextField styledField() {
    JTextField f = new JTextField();
    f.setFont(fBody(14));
    f.setBackground(C_WHITE);
    f.setForeground(C_DARK);
    f.setCaretColor(C_DARK);
    f.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createLineBorder(C_STEEL, 1, true),
    BorderFactory.createEmptyBorder(4, 8, 4, 8)));
    return f;
    }

public static void styleCombo(JComboBox<?> cb) {
    cb.setFont(fBody(14));
    cb.setBackground(C_WHITE);
    cb.setForeground(C_DARK);
    }

public static JButton redButton(String text) {
    JButton b = new JButton(text);
    b.setFont(fTitle(14));
    b.setBackground(C_RED);
    b.setForeground(C_WHITE);
    b.setFocusPainted(false);
    b.setBorderPainted(false);
    b.setOpaque(true);
    b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    return b;
    }

public static JTable styledTable(DefaultTableModel model) {
    JTable table = new JTable(model) {
        @Override
        public Component prepareRenderer(TableCellRenderer r, int row, int col) {
            Component c = super.prepareRenderer(r, row, col);
            c.setBackground(isRowSelected(row) ? C_STEEL
                : row % 2 == 0 ? C_WHITE : C_ROW_ALT);
            c.setForeground(isRowSelected(row) ? C_WHITE : C_DARK);
            return c;
            }
        };
        table.setFont(fBody(13));
        table.setRowHeight(36);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 2));
        table.setSelectionBackground(C_STEEL);
        table.setSelectionForeground(C_WHITE);
        JTableHeader hdr = table.getTableHeader();
        hdr.setBackground(C_TEAL);
        hdr.setForeground(C_WHITE);
        hdr.setFont(fNav(13));
        ((DefaultTableCellRenderer) hdr.getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
        return table;
    }
}
