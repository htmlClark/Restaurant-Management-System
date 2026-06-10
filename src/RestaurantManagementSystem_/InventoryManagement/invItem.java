
package RestaurantManagementSystem_.InventoryManagement;

public class invItem {
    private String itemID;
    private String itemName;
    private int itemQuantity;
    private String itemCategory;
    private String itemMeasurement;
    private String itemDeliveryID;
    private String itemExpirationDate;
    private String itemDeliveryDate;
    private String itemDeliveryTime;
    private String itemDeliveryCourier;
    
    public invItem(
            String itemID,
            String itemName,
            int itemQuantity,
            String itemCategory,
            String itemMeasurement,
            String itemDeliveryID,
            String itemExpirationDate,
            String itemDeliveryDate,
            String itemDeliveryTime,
            String itemDeliveryCourier) {

            this.itemID = itemID;
            this.itemName = itemName;
            this.itemQuantity = itemQuantity;
            this.itemCategory = itemCategory;
            this.itemMeasurement = itemMeasurement;

            this.itemDeliveryID = itemDeliveryID;
            this.itemExpirationDate = itemExpirationDate;
            this.itemDeliveryDate = itemDeliveryDate;
            this.itemDeliveryTime = itemDeliveryTime;
            this.itemDeliveryCourier = itemDeliveryCourier;
    }
    
    public String getItemID() {
        return itemID;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public int getItemQuantity() {
        return itemQuantity;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public String getItemMeasurement() {
        return itemMeasurement;
    }
    
    public void setItemName(String itemName) {
    this.itemName = itemName;
}
    
    public void setItemQuantity(int itemQuantity) {
    this.itemQuantity = itemQuantity;
    }
    public String getDeliveryID() { return itemDeliveryID; }
    
}

