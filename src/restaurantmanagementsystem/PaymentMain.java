/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aamar
 */


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