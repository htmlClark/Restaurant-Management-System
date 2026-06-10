
package RestaurantManagementSystem_.InventoryManagement;

public class invItem {
    private String itemID;
    private String itemName;
    private double itemQuantity;
    private String itemCategory;
    private String itemMeasurement;
    private String itemDeliveryID;
    private String itemExpirationDate;
    private String itemDeliveryDate;
    private String itemDeliveryTime;
    private String itemDeliveryCourier;
    private String itemCurrentStatus;
    
    public invItem(
            String itemID,
            String itemName,
            double  itemQuantity,
            String itemCategory,
            String itemMeasurement,
            String itemDeliveryID,
            String itemExpirationDate,
            String itemDeliveryDate,
            String itemDeliveryTime,
            String itemDeliveryCourier,
            String itemCurrentStatus
            ) {

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
            
            this.itemCurrentStatus = itemCurrentStatus;
    }
    
    public String getItemID() {
        return itemID;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public double getItemQuantity() {
        return itemQuantity;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public String getItemMeasurement() {
        return itemMeasurement;
    }
    
    public String getItemExpirationDate() {
        return itemExpirationDate;
    }
    
    public String getItemDeliveryDate() {
        return itemDeliveryDate;
    }
    public String getItemDeliveryTime() {
        return itemDeliveryTime;
    }
    
    public String getItemDeliveryCourier() {
        return itemDeliveryCourier;
    }
    
    public String getItemCurrentStatus() { 
        return itemCurrentStatus; 
    }

    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public void setItemQuantity(double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    public String getDeliveryID() { return itemDeliveryID; }
    
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setItemMeasurement(String itemMeasurement) {
        this.itemMeasurement = itemMeasurement;
    }

    public void setDeliveryID(String deliveryID) {
        this.itemDeliveryID = deliveryID;
    }

    public void setExpirationDate(String expirationDate) {
        this.itemExpirationDate = expirationDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.itemDeliveryDate = deliveryDate;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.itemDeliveryTime = deliveryTime;
    }

    public void setDeliveryCourier(String deliveryCourier) {
        this.itemDeliveryCourier = deliveryCourier;
    }
    
    public void setItemCurrentStatus(String itemCurrentStatus) { 
        this.itemCurrentStatus = itemCurrentStatus; 
    }

    
}

