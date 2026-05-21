package RestaurantManagementSystem_.PaymentProcess;

import RestaurantManagementSystem_.PaymentProcess.Order;

public class PaymentMain {
    public static void main(String[] args) {
        Order order = new Order(37);
        order.addItem(new OrderItem("Lumpiang Shanghai", 120, 1));
        order.addItem(new OrderItem("Chicken Adobo", 160, 2));
        order.addItem(new OrderItem("Buko Juice", 70, 1));

        PaymentProcessingPage pp = new PaymentProcessingPage(order);
        pp.setVisible(true);
    }
}