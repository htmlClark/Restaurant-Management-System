package RestaurantManagementSystem_.Products;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Appetizer extends JPanel implements ActionListener {
    private JScrollPane scrollPane;
    private JButton btnShanghai, btnTokwa, btnChicharon, btnPlaceOrder, btnVoidOrder, btnBack;
    private JLabel lblAppetizer, lblProduct, lblPrice, lblQuanti, lblTotal, lblProdTotal;
    private JPanel productPanel, rowPanel, addRow;

    private int prodTotal = 0;

    private String[] columnNames = {"Product", "Quantity", "Price"};

    public Appetizer()
    {
        appetizers();
        productSummary();

        setBounds (300,80,980,720);
        setLayout(null);
        setBackground(Color.decode("#FFF8E1"));
    }

    private void productSummary()
    {
        //For Appetizer Label
        ImageIcon appLogo = new ImageIcon (getClass().getResource("/src_pack/images/appetizer_bg.png"));
        Image appSize = appLogo.getImage().getScaledInstance(350, 78, Image.SCALE_DEFAULT);

        lblAppetizer = new JLabel(new ImageIcon(appSize));
        lblAppetizer.setBounds(30,20,350,78);
        add(lblAppetizer);

        //Place Order
        ImageIcon placeLogo = new ImageIcon (getClass().getResource("/src_pack/images/place.png"));
        Image placeSize = placeLogo.getImage().getScaledInstance(150, 33, Image.SCALE_DEFAULT);

        btnPlaceOrder = new JButton(new ImageIcon(placeSize));
        btnPlaceOrder.setBackground(Color.decode("#00BF63"));
        btnPlaceOrder.setBounds(620,600,150,33);
        btnPlaceOrder.addActionListener(this);
        add(btnPlaceOrder);

        //Void Order
        ImageIcon voidLogo = new ImageIcon (getClass().getResource("/src_pack/images/void.png"));
        Image voidSize = voidLogo.getImage().getScaledInstance(150, 33, Image.SCALE_DEFAULT);

        btnVoidOrder = new JButton(new ImageIcon(voidSize));
        btnVoidOrder.setBackground(Color.decode("#B71C1C"));
        btnVoidOrder.setBounds(785,600,150,33);
        btnVoidOrder.addActionListener(this);
        add(btnVoidOrder);

        //Back Button
        ImageIcon backLogo = new ImageIcon (getClass().getResource("/src_pack/images/back.png"));
        Image backSize = backLogo.getImage().getScaledInstance(150, 33, Image.SCALE_DEFAULT);

        btnBack = new JButton(new ImageIcon(backSize));
        btnBack.setBackground(Color.decode("#B71C1C"));
        btnBack.setBounds(400,620,150,33);
        btnBack.addActionListener(this);
        add(btnBack);

        //Product Summary Labels
        lblProduct = new JLabel("PRODUCT");
        lblProduct.setBounds(600,90,100,30);
        lblProduct.setFont(new Font("Arial",Font.BOLD,15));
        add(lblProduct);

        lblQuanti = new JLabel("QUANTITY");
        lblQuanti.setBounds(750,90,100,30);
        lblQuanti.setFont(new Font("Arial",Font.BOLD,15));
        add(lblQuanti);

        lblPrice = new JLabel("PRICE");
        lblPrice.setBounds(900,90,100,30);
        lblPrice.setFont(new Font("Arial",Font.BOLD,15));
        add(lblPrice);

        lblTotal = new JLabel("TOTAL");
        lblTotal.setBounds(600,500,100,30);
        lblTotal.setFont(new Font("Arial",Font.BOLD,15));
        add(lblTotal);

        lblProdTotal = new JLabel("₱"+prodTotal);
        lblProdTotal.setBounds(910,500,100,30);
        lblProdTotal.setFont(new Font("Arial",Font.BOLD,15));
        add(lblProdTotal);

        //Product Summary Panel
        rowPanel = new JPanel(null);
        rowPanel.setBounds(0,120,400,380);
        rowPanel.setBackground(Color.decode("#F2D0BD"));

        scrollPane = new JScrollPane(rowPanel);
        scrollPane.setBounds(580,120,380,380);
        add(scrollPane);

        productPanel = new JPanel();
        productPanel.setBounds(580,50,400,650);
        productPanel.setBackground(Color.decode("#F2D0BD"));
        add(productPanel);
    }

    private boolean addProduct(String prodName, int prodPrice)
    {
       for (Component component : rowPanel.getComponents())
       {
           if (component instanceof JPanel)
           {
               JPanel row = (JPanel) component;

               JLabel rowName = (JLabel) row.getComponent(0);
               JSpinner rowSpinner = (JSpinner) row.getComponent(1);
               JLabel rowPrice = (JLabel) row.getComponent(2);

                if (rowName.getText().equals(prodName))
                {
                    int currentQuanti = (int) rowSpinner.getValue();
                        rowPrice.setText("₱" + ((currentQuanti + 1) * prodPrice));
                        rowSpinner.setValue(currentQuanti + 1);

                    prodTotal += prodPrice;
                    lblProdTotal.setText("₱" + prodTotal);
                    return true;
                }
           }
       }

        int rowHeight = 50;
        int nextRowPosition = rowPanel.getComponentCount() * rowHeight;

        JPanel addRow = new JPanel(null);
        addRow.setBounds(0, nextRowPosition, 400, rowHeight);
        addRow.setBackground(Color.decode("#F2D0BD"));

        JLabel lblProdName = new JLabel(prodName);
        lblProdName.setBounds(20,10,100,30);

        JSpinner spnQuantity = new JSpinner(new SpinnerNumberModel(1,1,99,1));
        spnQuantity.setBounds(180,10,50,30);

        JLabel lblProdPrice = new JLabel("₱"+prodPrice);
        lblProdPrice.setBounds(300,10,100,30);

        int prevQuanti[] = {1};
        spnQuantity.addChangeListener(e ->{
            int currentQuanti = (int) spnQuantity.getValue();
            int updateQuanti = currentQuanti - prevQuanti[0];

            int calculateProdPrice = currentQuanti * prodPrice;
            lblProdPrice.setText("₱" + calculateProdPrice);

            prodTotal += updateQuanti * prodPrice;
            lblProdTotal.setText("₱"+prodTotal);

            prevQuanti[0] = currentQuanti;
        });

        addRow.add(lblProdName);
        addRow.add(spnQuantity);
        addRow.add(lblProdPrice);

        rowPanel.add(addRow);
        rowPanel.setPreferredSize(new Dimension(380,nextRowPosition + rowHeight));
        rowPanel.revalidate();
        rowPanel.repaint();

        prodTotal += prodPrice;
        lblProdTotal.setText("₱"+prodTotal);

        return false;
    }

    private void appetizers()
    {
        //Lumpiang Shanghai
        ImageIcon lmpLogo = new ImageIcon (getClass().getResource("/src_pack/images/28.png"));
        Image lmpSize = lmpLogo.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);

        btnShanghai = new JButton(new ImageIcon(lmpSize));
            btnShanghai.setBounds(30,120,200,220);
            btnShanghai.setBackground(Color.decode("#F2D0BD"));
            btnShanghai.addActionListener(this);
            add(btnShanghai);

        //Tokwa't Baboy
        ImageIcon tkwLogo = new ImageIcon (getClass().getResource("/src_pack/images/29.png"));
        Image tkwSize = tkwLogo.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);

        btnTokwa = new JButton(new ImageIcon(tkwSize));
            btnTokwa.setBounds(260,120,200,220);
            btnTokwa.setBackground(Color.decode("#F2D0BD"));
            btnTokwa.addActionListener(this);
            add(btnTokwa);

        //Chicharon
        ImageIcon chcaLogo = new ImageIcon (getClass().getResource("/src_pack/images/30.png"));
        Image chcaSize = chcaLogo.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);

        btnChicharon = new JButton(new ImageIcon(chcaSize));
            btnChicharon.setBounds(30,370,200,220);
            btnChicharon.setBackground(Color.decode("#F2D0BD"));
            btnChicharon.addActionListener(this);
            add(btnChicharon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (e.getSource() == btnBack)
        {
            frame.getContentPane().remove(this);
            frame.getContentPane().add(new Products());
            frame.revalidate();
            frame.repaint();
        }
        if (e.getSource() == btnShanghai)
        {
            addProduct("LMP SHNG",120);
        }
        if (e.getSource() == btnTokwa)
        {
            addProduct("TKW BBY",150);
        }
        if (e.getSource() == btnChicharon)
        {
            addProduct("CHRN BLK",180);
        }
        if (e.getSource() == btnPlaceOrder)
        {
            if(rowPanel.getComponentCount()>0)
            {

            }
            else
            {
                JOptionPane.showMessageDialog(null,"No products have been added to this order", "ORDER ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
