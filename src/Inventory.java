
import java.util.ArrayList;
import java.io.*;

public class Inventory {

    private ArrayList<Item> items; 

    public Inventory() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayItems() {
        if(items.size()==0) {
            System.out.println("No Items Found");
        } else {
            for (int i =0; i<items.size(); i++) {
                System.out.println("Name: " + items.get(i).getName() + " - Category: " + items.get(i).getCategory() + " - Location: " + items.get(i).getLocation() + " - Quantity: " + items.get(i).getQuantity());
            }

        }
        
    }

    public void removeItem(Item item) {
        items.remove(item);
   
    }

    public Item searchItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        
        return null;
    }

    public void saveInventory() {
        try{

            PrintWriter pw = new PrintWriter("inventory.txt");

            for(Item item : items) {
                pw.println(item.getName() + "," + item.getCategory() + "," + item.getLocation() + "," + item.getQuantity());

            }

            pw.close();
            System.out.println("Inventory saved!");

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

    public void loadInventory() {
        try{
            BufferedReader br = new BufferedReader(new FileReader("inventory.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if(parts.length==4) {
                    int quantity = Integer.parseInt(parts[3]);
                    Item item = new Item(parts[0], parts[1], parts[2], quantity);
                    items.add(item);
                }
            }

            br.close();
            
        } catch (IOException e) {
            System.out.println("No saved inventory found.");
        }
    }
    
}
