package RestaurantManagementSystem_.PaymentProcess;
import java.util.ArrayList;
public class Order {

    private static int orderCounter = 1;

    private int orderNumber;
    private ArrayList<OrderItem> items;

    public Order() {
        this.orderNumber = orderCounter++;
        this.items = new ArrayList<OrderItem>();
    }

    /** Legacy constructor — kept for compatibility; counter still auto-increments. */
    public Order(int ignoredOrderNumber) {
        this();
    }
    
    public void addItem (OrderItem item) {
        items.add(item);
    }
    
    public ArrayList<OrderItem> getItems() {
        return items;
    }
 
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public double getSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < items.size(); i++) {
            subtotal = subtotal + items.get(i).getTotalPrice();
        }
        
        return subtotal;
    }
    
    public double getTax() {
        return getSubtotal() * 0.12; 
    }
    
    public double getTotal() {
        return getSubtotal() + getTax();
    }
}