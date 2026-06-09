package RestaurantManagementSystem_.Products;

import HeaderPanels.*;
import MainPlacementFrame.*;
import RestaurantManagementSystem_.PaymentProcess.*;
import SidePanels.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ProductSummary extends JPanel implements ActionListener {
    private JScrollPane scrollPane;
    private JButton btnPlaceOrder, btnDeleteItem;
    private JLabel lblProduct, lblQuanti, lblPrice, lblTotal, lblProdTotal;
    private JPanel productPanel, rowPanel;

    private int prodTotal = 0;

    public ProductSummary()
    {
        product();

        setLayout(null);
        setBackground(Color.decode("#F2D0BD"));
        setBounds(580, 80, 400, 640);
    }

    private void product()
    {
        //Place Order
        ImageIcon placeLogo = new ImageIcon (getClass().getResource("/src_pack/images/place.png"));
        Image placeSize = placeLogo.getImage().getScaledInstance(150, 33, Image.SCALE_DEFAULT);

        btnPlaceOrder = new JButton(new ImageIcon(placeSize));
        btnPlaceOrder.setBackground(Color.decode("#00BF63"));
        btnPlaceOrder.setBounds(100,500,150,33);
        btnPlaceOrder.addActionListener(this);
        add(btnPlaceOrder);

        //Delete Item Order
        ImageIcon deleteLogo = new ImageIcon (getClass().getResource("/src_pack/images/delete.png"));
        Image deleteSize = deleteLogo.getImage().getScaledInstance(150, 33, Image.SCALE_DEFAULT);

        btnDeleteItem = new JButton(new ImageIcon(deleteSize));
        btnDeleteItem.setBackground(Color.decode("#B71C1C"));
        btnDeleteItem.setBounds(100,550,150,33);
        btnDeleteItem.addActionListener(this);
        btnDeleteItem.setVisible(false);
        add(btnDeleteItem);

        //Product Summary Labels
        lblProduct = new JLabel("PRODUCT");
        lblProduct.setBounds(30,10,100,30);
        lblProduct.setFont(new Font("Arial",Font.BOLD,15));
        add(lblProduct);

        lblQuanti = new JLabel("QUANTITY");
        lblQuanti.setBounds(170,10,100,30);
        lblQuanti.setFont(new Font("Arial",Font.BOLD,15));
        add(lblQuanti);

        lblPrice = new JLabel("PRICE");
        lblPrice.setBounds(310,10,100,30);
        lblPrice.setFont(new Font("Arial",Font.BOLD,15));
        add(lblPrice);

        lblTotal = new JLabel("TOTAL");
        lblTotal.setBounds(30,430,100,30);
        lblTotal.setFont(new Font("Arial",Font.BOLD,15));
        add(lblTotal);

        lblProdTotal = new JLabel("₱"+prodTotal);
        lblProdTotal.setBounds(310,430,100,30);
        lblProdTotal.setFont(new Font("Arial",Font.BOLD,15));
        add(lblProdTotal);

        //Product Summary Panel
        rowPanel = new JPanel(null);
        rowPanel.setBounds(0,120,330,380);
        rowPanel.setBackground(Color.decode("#F2D0BD"));

        scrollPane = new JScrollPane(rowPanel);
        scrollPane.setBounds(0,40,400,380);
        add(scrollPane);

        productPanel = new JPanel();
        productPanel.setBounds(580,80,450,600);
        productPanel.setBackground(Color.decode("#F2D0BD"));
        add(productPanel);
    }

    public boolean addProduct(String prodName, int prodPrice)
    {
        for (Component component : rowPanel.getComponents())
        {
            if (component instanceof JPanel)
            {
                JPanel row = (JPanel) component;

                JCheckBox rowCheck = (JCheckBox) row.getComponent(0);
                JLabel rowName = (JLabel) row.getComponent(1);
                JSpinner rowSpinner = (JSpinner) row.getComponent(2);
                JLabel rowPrice = (JLabel) row.getComponent(3);

                if (rowName.getText().equals(prodName))
                {
                    int currentQuanti = (int) rowSpinner.getValue();
                    rowPrice.setText("₱" + ((currentQuanti + 1) * prodPrice));
                    rowSpinner.setValue(currentQuanti + 1);
                    return true;
                }
            }
        }

        int rowHeight = 50;
        int nextRowPosition = rowPanel.getComponentCount() * rowHeight;

        JPanel addRow = new JPanel(null);
        addRow.setBounds(0, nextRowPosition, 380, rowHeight);
        addRow.setBackground(Color.decode("#F2D0BD"));

        JCheckBox chDeleteItem = new JCheckBox();
        chDeleteItem.setBounds(10,15,20,20);
        chDeleteItem.setBackground(Color.decode("#FFB300"));
        chDeleteItem.addActionListener(e->{
            updateDeleteItem();});

        JLabel lblProdName = new JLabel(prodName);
            lblProdName.setBounds(40,10,100,30);

        JSpinner spnQuantity = new JSpinner(new SpinnerNumberModel(1,1,99,1));
            spnQuantity.setBounds(200,10,50,30);

        JLabel lblProdPrice = new JLabel("₱"+prodPrice);
            lblProdPrice.setBounds(320,10,50,30);

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

        addRow.add(chDeleteItem);
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

    private void updateDeleteItem()
    {
        for (Component component : rowPanel.getComponents())
        {
            JPanel row = (JPanel) component;
            JCheckBox rowCheck = (JCheckBox) row.getComponent(0);

            if (rowCheck.isSelected())
            {
                btnDeleteItem.setVisible(true);
                return;
            }
        }
        btnDeleteItem.setVisible(false);
    }

    private void deleteItemSelected()
    {
        for (Component component : rowPanel.getComponents())
        {
            JPanel row = (JPanel) component;
            JCheckBox rowCheck = (JCheckBox) row.getComponent(0);

            if(rowCheck.isSelected())
            {
                JLabel rowPrice = (JLabel) row.getComponent(3);
                String getRowPrice = rowPrice.getText();
                prodTotal -= Integer.parseInt(getRowPrice.replace("₱",""));
                rowPanel.remove(row);
                btnDeleteItem.setVisible(false);
            }
        }
        //NOTE! i added this for positioning of remaining rows
        for (int i = 0; i < rowPanel.getComponentCount(); i++)
        {
            rowPanel.getComponent(i).setBounds(0, i * 50, 400, 50);
        }
        lblProdTotal.setText("₱" + prodTotal);
        rowPanel.revalidate();
        rowPanel.repaint();
    }

    private Order processOrder()
    {
        Order order = new Order(1);

        for (Component component : rowPanel.getComponents())
        {
            JPanel row = (JPanel) component;
            JLabel rowName    = (JLabel)   row.getComponent(1);
            JSpinner rowSpinner = (JSpinner) row.getComponent(2);
            JLabel rowPrice   = (JLabel)   row.getComponent(3);

            String name    = rowName.getText();
            int quantity   = (int) rowSpinner.getValue();
            double price   = Double.parseDouble(rowPrice.getText().replace("₱", "")) / quantity;

            order.addItem(new OrderItem(name, price, quantity));
        }
        return order;
    }

    private void placeOrder()
    {
        if(rowPanel.getComponentCount()>0)
        {
            Order order = processOrder();

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

            frame.getContentPane().removeAll();
            frame.getContentPane().add(new PaymentProcessingPage(order, this));

            if(frame instanceof userFrame)
            {
                frame.getContentPane().add(new SidePanel_Staff());
                frame.getContentPane().add(new Header_Staff("USER"));
            }
            else if (frame instanceof adminFrame)
            {
                frame.getContentPane().add(new SidePanel_Admin());
                frame.getContentPane().add(new Header_Admin("ADMIN"));
            }
            else if (frame instanceof superAdminFrame)
            {
                frame.getContentPane().add(new SidePanel_SuperAdmin());
            }

            frame.revalidate();
            frame.repaint();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No products have been added to this order", "ORDER ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPlaceOrder)
        {
            placeOrder();
        }
        if (e.getSource() == btnDeleteItem)
        {
            deleteItemSelected();
        }
    }
}
