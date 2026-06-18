package RestaurantManagementSystem_.InventoryManagement;

public class invRecipe {
    
    public static void chickenAdobo(int dishQty){
        InventoryManager manager = InventoryManager.getInstance();
        manager.deductStock("Pork Intestine", 0.30 * dishQty);
        manager.deductStock("Garlic", 0.02 * dishQty);
        manager.deductStock("Onion", 0.05 * dishQty);
        manager.deductStock("Soy Sauce", 0.05 * dishQty);
        manager.deductStock("Vinegar", 0.05 * dishQty);
        manager.deductStock("Black Pepper", 0.005 * dishQty);
    }

    public static void chicharonBulaklak(int dishQty) {
        InventoryManager manager = InventoryManager.getInstance();

        manager.deductStock("Pork Intestine", 0.30 * dishQty);
        manager.deductStock("Cooking Oil", 0.10 * dishQty);
        manager.deductStock("Salt", 0.01 * dishQty);
    }

    public static void tortangTalong(int dishQty) {
        InventoryManager manager = InventoryManager.getInstance();

        manager.deductStock("Eggplant", 0.20 * dishQty);
        manager.deductStock("Egg", 2 * dishQty);
        manager.deductStock("Salt", 0.005 * dishQty);
        manager.deductStock("Cooking Oil", 0.02 * dishQty);
    }

    public static void turon(int dishQty) {
        InventoryManager manager = InventoryManager.getInstance();

        manager.deductStock("Banana", 0.15 * dishQty);
        manager.deductStock("Spring Roll Wrapper", 1 * dishQty);
        manager.deductStock("Sugar", 0.02 * dishQty);
        manager.deductStock("Cooking Oil", 0.05 * dishQty);
    }

    public static void icedTea(int dishQty) {
        InventoryManager manager = InventoryManager.getInstance();

        manager.deductStock("Tea Powder", 0.01 * dishQty);
        manager.deductStock("Sugar", 0.03 * dishQty);
        manager.deductStock("Water", 0.50 * dishQty);
    }

    public static void bukoJuice(int dishQty) {
        InventoryManager manager = InventoryManager.getInstance();

        manager.deductStock("Young Coconut", 1 * dishQty);
        manager.deductStock("Water", 0.20 * dishQty);
        manager.deductStock("Sugar", 0.01 * dishQty);
    }
    
    
}
