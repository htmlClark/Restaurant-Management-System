package RestaurantManagementSystem_.InventoryManagement;

import java.util.List;

public class InventoryPopulatedData {

    public static void loadData()
    {
        List<invItem> inventoryList = InventoryManager.getInstance().getInventoryList();

        if (!inventoryList.isEmpty()) return;

        inventoryList.add(new invItem(InventoryManager.generateItemID(), "Pork Belly", 20, "MEAT", "KG", "", "", "", "", "", "Good"));
        inventoryList.add(new invItem(InventoryManager.generateItemID(), "Chicken", 18, "MEAT", "KG", "", "", "", "", "", "Good"));
        inventoryList.add(new invItem(InventoryManager.generateItemID(), "Soy Sauce", 2, "SEASONING", "LITER", "", "", "", "", "", "Good"));
        inventoryList.add(new invItem(InventoryManager.generateItemID(), "Garlic", 3, "VEGETABLE", "KG", "", "", "", "", "", "Good"));
        inventoryList.add(new invItem(InventoryManager.generateItemID(), "Onion", 4, "VEGETABLE", "KG", "", "", "", "", "", "Good"));
        inventoryList.add(new invItem(InventoryManager.generateItemID(), "Vinegar", 6, "CONDIMENTS", "LITER", "", "", "", "", "", "Good"));
        inventoryList.add(new invItem(InventoryManager.generateItemID(), "Cooking Oil", 2, "OTHERS", "PACK", "", "", "", "", "", "Good"));

        for (invItem item : inventoryList)
        {
            item.setItemCurrentStatus(computeStatus(item.getItemQuantity(), item.getItemCategory()));
        }
    }

    private static String computeStatus(double quantity, String category)
    {
        double threshold;

        switch (category.toUpperCase())
        {
            case "MEAT":       threshold = 15; break;
            case "SEASONING":  threshold = 1;  break;
            case "VEGETABLE":  threshold = 2;  break;
            case "CONDIMENTS": threshold = 5;  break;
            case "OTHERS":     threshold = 2;  break;
            default:           threshold = 10; break;
        }

        if (quantity <= threshold) return "Low";
        return "Good";
    }
}