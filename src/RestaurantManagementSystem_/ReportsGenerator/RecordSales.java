package RestaurantManagementSystem_.ReportsGenerator;

import RestaurantManagementSystem_.PaymentProcess.Order;
import RestaurantManagementSystem_.PaymentProcess.OrderItem;

import java.time.LocalDate;
import java.util.*;

public class RecordSales {

    private static RecordSales instance;
    private final List<Order> confirmedOrders = new ArrayList<>();
    private final List<LocalDate> confirmedDates = new ArrayList<>();

    private RecordSales() {}

    public static RecordSales getInstance() {
        if (instance == null) instance = new RecordSales();
        return instance;
    }
    
    public void recordOrder(Order order) {
        confirmedOrders.add(order);
        confirmedDates.add(LocalDate.now());
    }

    public List<Order> getConfirmedOrders() {
        return confirmedOrders;
    }

    /** Total revenue across all confirmed orders. */
    public double getTotalSales() {
        double total = 0;
        for (Order order : confirmedOrders) {
            total += order.getTotal();
        }
        return total;
    }

    /** Maps order date -> total revenue for that date. */
    public Map<LocalDate, Double> getDailyTotals() {
        Map<LocalDate, Double> dailyTotals = new LinkedHashMap<>();
        for (int i = 0; i < confirmedOrders.size(); i++) {
            LocalDate date = confirmedDates.get(i);
            double total = confirmedOrders.get(i).getTotal();
            dailyTotals.merge(date, total, Double::sum);
        }
        return dailyTotals;
    }

    public double getAverageDailySales() {
        Map<LocalDate, Double> dailyTotals = getDailyTotals();
        if (dailyTotals.isEmpty()) return 0;
        double total = 0;
        for (double v : dailyTotals.values()) total += v;
        return total / dailyTotals.size();
    }

    public double getHighestDailySales() {
        double max = 0;
        boolean first = true;
        for (double v : getDailyTotals().values()) {
            if (first || v > max) { max = v; first = false; }
        }
        return max;
    }

    public double getLowestDailySales() {
        double min = 0;
        boolean first = true;
        for (double v : getDailyTotals().values()) {
            if (first || v < min) { min = v; first = false; }
        }
        return min;
    }

    /**
     * Aggregates units sold and revenue per dish name across all
     * confirmed orders, used for the BEST SELLERS table.
     */
    public List<BestSeller> getBestSellers(int limit) {
        Map<String, BestSeller> totals = new LinkedHashMap<>();

        for (Order order : confirmedOrders) {
            for (OrderItem item : order.getItems()) {
                String name = item.getItemName();
                BestSeller bs = totals.get(name);
                if (bs == null) {
                    bs = new BestSeller(name, 0, 0);
                    totals.put(name, bs);
                }
                bs.unitsSold += item.getQuantity();
                bs.totalRevenue += item.getTotalPrice();
            }
        }

        List<BestSeller> sorted = new ArrayList<>(totals.values());
        sorted.sort((a, b) -> Integer.compare(b.unitsSold, a.unitsSold));

        if (sorted.size() > limit) {
            return sorted.subList(0, limit);
        }
        return sorted;
    }

    /** Simple holder for a best-seller row. */
    public static class BestSeller {
        public final String dishName;
        public int unitsSold;
        public double totalRevenue;

        public BestSeller(String dishName, int unitsSold, double totalRevenue) {
            this.dishName = dishName;
            this.unitsSold = unitsSold;
            this.totalRevenue = totalRevenue;
        }
    }
}