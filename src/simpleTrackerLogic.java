import java.util.Scanner;

public class simpleTrackerLogic{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- New Waste Entry ---");
            System.out.print("Enter Item Name (or type 'quit' to stop): ");
            String item = scanner.nextLine();

            if (item.equalsIgnoreCase("quit")) {
                break; 
            }

            System.out.print("Enter Quantity: ");
            String qty = scanner.nextLine();

            System.out.println("Select Reason: 1.Spoilage, 2.Leftovers, 3.Returns, 4.Error, 5.Contaminated");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            String reason = switch (choice) {
                case "1" -> "Spoilage/Expired";
                case "2" -> "Leftovers";
                case "3" -> "Returns";
                case "4" -> "Staff Error";
                case "5" -> "Contaminated";
                default -> "Unknown";
            };

            System.out.println(">> LOGGED: " + qty + " of " + item + " due to " + reason);
        }

        System.out.println("\nProgram closed. Log saved!");
        scanner.close();
    }
}