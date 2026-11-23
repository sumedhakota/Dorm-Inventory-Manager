
import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items; 

    public Inventory() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayItems() {
        for (int i =0; i<items.size(); i++) {
            System.out.println(items.get(i).getName() + " - " + items.get(i).getCategory() + " - " + items.get(i).getLocation());
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
    
}
