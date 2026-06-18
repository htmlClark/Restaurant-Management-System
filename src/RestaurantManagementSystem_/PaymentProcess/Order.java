package RestaurantManagementSystem_.PaymentProcess;
<<<<<<< HEAD

=======
>>>>>>> master-rms
import java.util.ArrayList;

public class Order {

    private int orderNumber;
    private ArrayList<OrderItem> items;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public double getSubtotal() {
        return getTotal() / 1.12;
    }

    public double getVAT() {
        return getTotal() - getSubtotal();
    }
}


