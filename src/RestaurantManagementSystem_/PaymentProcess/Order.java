package RestaurantManagementSystem_.PaymentProcess;
import java.util.ArrayList;

public class Order {

    private int orderNumber;
    private ArrayList<OrderItem> items;

    Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.items = new ArrayList<OrderItem>();
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

        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getTotalPrice();
        }

        return total;
    }

    public double getSubtotal() {
        return getTotal() / 1.12;
    }

    public double getTax() {
        return getTotal() - getSubtotal();
    }
}