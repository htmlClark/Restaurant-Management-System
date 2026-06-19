package RestaurantManagementSystem_.InventoryManagement;

import RestaurantManagementSystem_.FoodWasteTracker.WasteLog;
import RestaurantManagementSystem_.FoodWasteTracker.WasteLogPanel;
import RestaurantManagementSystem_.FoodWasteTracker.WasteLogSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class invRecipe {
    
        private static boolean usedIngredient(String itemName,double amount, List<String> missing){

        boolean deducted = InventoryManager.getInstance().deductStock(itemName, amount);

        if (!deducted) {
            missing.add(itemName);
            return false;
        }

        WasteLogPanel.getSharedLogs().add(new WasteLog(
                new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()),
                itemName,
                String.valueOf(amount),
                "Customer Order",WasteLogSession.getInstance().getEmployeeNo(),
                ""));

        return true;
    }

    public static List<String> chickenAdobo(int dishQty){
        List<String> missing = new ArrayList<>();
        usedIngredient("Chicken", 0.30 * dishQty, missing);
        usedIngredient("Garlic", 0.02 * dishQty, missing);
        usedIngredient("Onion", 0.05 * dishQty, missing);
        usedIngredient("Soy Sauce", 0.05 * dishQty, missing);
        usedIngredient("Vinegar", 0.05 * dishQty, missing);
        usedIngredient("Black Pepper", 0.005 * dishQty, missing);
        return missing;
    }

    public static List<String> chicharonBulaklak(int dishQty) {
        List<String> missing = new ArrayList<>();
        usedIngredient("Pork Intestine", 0.30 * dishQty, missing);
        usedIngredient("Cooking Oil", 0.10 * dishQty, missing);
        usedIngredient("Salt", 0.01 * dishQty, missing);
        return missing;
    }

    public static List<String> tortangTalong(int dishQty) {
        List<String> missing = new ArrayList<>();
        usedIngredient("Eggplant", 0.20 * dishQty, missing);
        usedIngredient("Egg", 2 * dishQty, missing);
        usedIngredient("Salt", 0.005 * dishQty, missing);
        usedIngredient("Cooking Oil", 0.02 * dishQty, missing);
        return missing;
    }

    public static List<String> turon(int dishQty) {
        List<String> missing = new ArrayList<>();
        usedIngredient("Banana", 0.15 * dishQty, missing);
        usedIngredient("Spring Roll Wrapper", 1 * dishQty, missing);
        usedIngredient("Sugar", 0.02 * dishQty, missing);
        usedIngredient("Cooking Oil", 0.05 * dishQty, missing);
        return missing;
    }

    public static List<String> icedTea(int dishQty) {
        List<String> missing = new ArrayList<>();
        usedIngredient("Tea Powder", 0.01 * dishQty, missing);
        usedIngredient("Sugar", 0.03 * dishQty, missing);
        usedIngredient("Water", 0.50 * dishQty, missing);
        return missing;
    }

    public static List<String> bukoJuice(int dishQty) {
        List<String> missing = new ArrayList<>();
        usedIngredient("Coconut", 1 * dishQty, missing);
        usedIngredient("Water", 0.20 * dishQty, missing);
        usedIngredient("Sugar", 0.01 * dishQty, missing);
        return missing;
    }
    
    
}