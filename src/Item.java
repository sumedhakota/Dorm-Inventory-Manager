public class Item {

    private String name;
    private String category;
    private String location;

    private int quantity;

    public Item(String name, String category, String location, int quantity) {

        this.name = name;
        this.category = category;
        this.location = location;
        this.quantity = quantity;

    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public int getQuantity() {
        return quantity;
    }





}