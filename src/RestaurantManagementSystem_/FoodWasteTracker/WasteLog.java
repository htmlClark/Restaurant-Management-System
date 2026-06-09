package RestaurantManagementSystem_.FoodWasteTracker;

public class WasteLog {
    public String time, item, qty, reason, staff, remarks;
    public WasteLog(String time, String item, String qty,
           String reason, String staff, String remarks) {
        this.time = time;
        this.item = item;
        this.qty = qty;
        this.reason = reason;
        this.staff = staff;
        this.remarks = remarks;
    }
}

