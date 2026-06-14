package RestaurantManagementSystem_.InventoryManagement;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    private static InventoryManager instance;
    private List<invItem> inventoryList = new ArrayList<>();
    private List<invItem> deliveryList  = new ArrayList<>();

    private static int itemCounter     = 1001;
    private static int deliveryCounter = 1001;

    private InventoryManager() {}

    public static String generateItemID() {
        return String.format("IT%04d", itemCounter++);
    }

    public static void rollbackItemID() {
        if (itemCounter > 1001) itemCounter--;
    }

    public static String generateDeliveryID() {
        return String.format("DV%04d", deliveryCounter++);
    }

    public static InventoryManager getInstance() {
        if (instance == null) instance = new InventoryManager();
        return instance;
    }

    public List<invItem> getInventoryList() { return inventoryList; }
    public List<invItem> getDeliveryList()  { return deliveryList;  }

    public void receiveDelivery(invItem delivered) {
        for (invItem item : inventoryList) {
            if (item.getItemID().equalsIgnoreCase(delivered.getItemID())) {
                item.setItemQuantity(item.getItemQuantity() + delivered.getItemQuantity());
                item.setItemCurrentStatus(computeStatus(item.getItemQuantity(), item.getItemCategory()));
                return;
            }
        }
        inventoryList.add(delivered);
    }

    public boolean deductStock(String itemName, double amount) {
        for (invItem item : inventoryList) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                if (item.getItemQuantity() < amount) return false;
                item.setItemQuantity(item.getItemQuantity() - amount);
                item.setItemCurrentStatus(computeStatus(item.getItemQuantity(), item.getItemCategory()));
                return true;
            }
        }
        return false;
    }

    public List<String> getLowStockItems() {
        List<String> lowItems = new ArrayList<>();
        for (invItem item : inventoryList) {
            if ("Low".equals(item.getItemCurrentStatus())) {
                lowItems.add(item.getItemName() + " (" + item.getItemQuantity() + " " + item.getItemMeasurement() + ")");
            }
        }
        return lowItems;
    }

    private String computeStatus(double quantity, String category) {
        double threshold;
        switch (category.toUpperCase()) {
            case "MEAT":       threshold = 15; break;
            case "SEASONING":  threshold = 1;  break;
            case "VEGETABLE":  threshold = 2;  break;
            case "CONDIMENTS": threshold = 5;  break;
            default:           threshold = 2;  break;
        }
        return quantity <= threshold ? "Low" : "Good";
    }
}