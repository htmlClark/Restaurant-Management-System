package RestaurantManagementSystem_.FoodWasteTracker;
public class WasteLogSession {

    private static WasteLogSession instance;
    private String employeeNo = "UNKNOWN";

    private WasteLogSession() {}

    public static WasteLogSession getInstance() {
        if (instance == null) instance = new WasteLogSession();
        return instance;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = (employeeNo == null || employeeNo.isBlank()) ? "UNKNOWN" : employeeNo.trim();
    }
    
    public String getEmployeeNo() {
        return employeeNo;
    }

    public void clearSession() {
        employeeNo = "UNKNOWN";
    }
}