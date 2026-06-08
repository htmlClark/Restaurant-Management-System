package RestaurantManagementSystem_.PaymentProcess;
import java.util.ArrayList;
public class Order {
    
    private int orderNumber;
    private ArrayList<OrderItem> items;
    
    public Order(int OrderNumber) {
        this.orderNumber = orderNumber;
        this.items = new ArrayList<OrderItem>();
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
   
