package RestaurantManagementSystem_.InventoryManagement;

import java.util.List;

public class InventoryPopulatedData {

    private static boolean isLoaded = false;
    
    public static void loadInventoryData()
    {
        if (isLoaded) return;
        isLoaded = true;
        
        List<invItem> inventoryList = InventoryManager.getInstance().getInventoryList();
            
            //ingredients for chicharon bulaklak, chicken adobo, tortang talong, turon, iced tea and buko juice
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Pork Intestine", 20, "MEAT", "KG", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Chicken", 20, "MEAT", "KG", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Eggplant", 15, "VEGETABLE", "KG", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Garlic", 10, "VEGETABLE", "KG", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Onion", 10, "VEGETABLE", "KG", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Coconut", 30, "VEGETABLE", "PCS", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Soy Sauce", 10, "SEASONING", "LITER", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Vinegar", 10, "SEASONING", "LITER", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Salt", 5, "SEASONING", "KG", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Black Pepper", 2, "SEASONING", "KG", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Cooking Oil", 15, "CONDIMENTS", "LITER", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Sugar", 10, "CONDIMENTS", "KG", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Egg", 50, "OTHERS", "PCS", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Spring Roll Wrapper", 100, "OTHERS", "PCS", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Banana", 30, "OTHERS", "KG", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Tea Powder", 2, "OTHERS", "KG", "", "", "", "", "", ""));
            inventoryList.add(new invItem(InventoryManager.generateItemID(), "Water", 50, "OTHERS", "LITER", "", "", "", "", "", ""));

        for (invItem item : inventoryList)
        {
            item.setItemCurrentStatus(InventoryManager.computeStatus(item.getItemQuantity(),item.getItemCategory()));         
        }
    }

    
}