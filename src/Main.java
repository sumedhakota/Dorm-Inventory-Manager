
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();

        inventory.loadInventory();

        System.out.println("Hello! Welcome to the Dorm Inventory Manager!");

        String choice = "";
        

        while(!choice.equals("5")) {

            System.out.println("Choose an option from below:");
            System.out.println("1. Add an Item");
            System.out.println("2. View Items");
            System.out.println("3. Remove an Item");
            System.out.println("4. Search for an Item");
            System.out.println("5. Exit");

            choice = input.nextLine();

            if(choice.equals("1")) {
                System.out.println("Enter the name of the item:");
                String itemName = input.nextLine();

                System.out.println("Enter the category of the item:");
                String itemCat = input.nextLine();

                System.out.println("Enter the location of the item:");
                String itemLoc = input.nextLine();

                System.out.println("Enter the quantity of the item:");
                String num = input.nextLine();
                int itemQuan=0;

                try{
                    itemQuan = Integer.parseInt(num);
                    
                    if(itemQuan <= 0) {
                        throw new NumberFormatException("Invalid number. Enter a whole, positive number. Please try again.");
                    } else {
                        Item item = new Item(itemName, itemCat, itemLoc, itemQuan);
                        inventory.addItem(item);

                        System.out.println("Item added!");
                    }

                } catch(NumberFormatException e) {
                    System.out.println("Invalid number. Enter a whole, positive number. Please try again.");
                }

            } else if (choice.equals("2")) {
                inventory.displayItems();
                

            } else if (choice.equals("3")) {
                
                System.out.println("Which item would you like to remove? Enter the name:");
                String name = input.nextLine();

                Item item = inventory.searchItem(name);

                if(item!=null) {
                    inventory.removeItem(item);
                    System.out.println("Item removed!");

                } else {
                    System.out.println("Item not found :( ");
                }
                
            } else if (choice.equals("4")) {
                System.out.println("Which item would you like to search for? Enter the name:");
                String name = input.nextLine();

                Item item = inventory.searchItem(name);

                if(item!=null) {
                    System.out.println("Name: " + item.getName() + " - Category: "  + item.getCategory() + " - Location: "  + item.getLocation() + " - Quantity: " + item.getQuantity());

                } else {
                    System.out.println("Item not found :( ");
                }
                
            } else if (choice.equals("5")) {
                inventory.saveInventory();
                System.out.println("Goodbye!");
                
            } else {
                System.out.println("Invalid option. Try again!");
            }



        }

        input.close();

        
        
    }
    
}
