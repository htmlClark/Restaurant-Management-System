package RestaurantManagementSystem_.InventoryManagement;

import RestaurantManagementSystem_.FoodWasteTracker.WasteLog;
import RestaurantManagementSystem_.FoodWasteTracker.WasteLogPanel;
import RestaurantManagementSystem_.FoodWasteTracker.WasteLogSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class invRecipe {
    
        private static void usedIngredient(String itemName,double amount){

        WasteLogPanel.getSharedLogs().add(new WasteLog(
                new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()),
                itemName,
                String.valueOf(amount),
                "Customer Order",WasteLogSession.getInstance().getEmployeeNo(),
                ""));
    }
    
    public static void chickenAdobo(int dishQty){
        usedIngredient("Chicken", 0.30 * dishQty);
        usedIngredient("Garlic", 0.02 * dishQty);
        usedIngredient("Onion", 0.05 * dishQty);
        usedIngredient("Soy Sauce", 0.05 * dishQty);
        usedIngredient("Vinegar", 0.05 * dishQty);
        usedIngredient("Black Pepper", 0.005 * dishQty);
    }

    public static void chicharonBulaklak(int dishQty) {

        usedIngredient("Pork Intestine", 0.30 * dishQty);
        usedIngredient("Cooking Oil", 0.10 * dishQty);
        usedIngredient("Salt", 0.01 * dishQty);
    }

    public static void tortangTalong(int dishQty) {

        usedIngredient("Eggplant", 0.20 * dishQty);
        usedIngredient("Egg", 2 * dishQty);
        usedIngredient("Salt", 0.005 * dishQty);
        usedIngredient("Cooking Oil", 0.02 * dishQty);
    }

    public static void turon(int dishQty) {

        usedIngredient("Banana", 0.15 * dishQty);
        usedIngredient("Spring Roll Wrapper", 1 * dishQty);
        usedIngredient("Sugar", 0.02 * dishQty);
        usedIngredient("Cooking Oil", 0.05 * dishQty);
    }

    public static void icedTea(int dishQty) {

        usedIngredient("Tea Powder", 0.01 * dishQty);
        usedIngredient("Sugar", 0.03 * dishQty);
        usedIngredient("Water", 0.50 * dishQty);
    }

    public static void bukoJuice(int dishQty) {

        usedIngredient("Young Coconut", 1 * dishQty);
        usedIngredient("Water", 0.20 * dishQty);
        usedIngredient("Sugar", 0.01 * dishQty);
    }
    
    
}
