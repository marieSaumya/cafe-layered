package lk.ijse.freshBite.entity;

public class AddMenuEntity {
    private String itemId;
    private String name;
    private String  menu_type;
    private int qty_on_hand;
    private double unit_Price;
    private String availability;
    private String stockId;
    private String imagePath ;

    public AddMenuEntity() {
    }

    public AddMenuEntity(String itemId, String name, String menu_type, int qty_on_hand, double unit_Price, String availability, String stockId, String imagePath) {
        this.itemId = itemId;
        this.name = name;
        this.menu_type = menu_type;
        this.qty_on_hand = qty_on_hand;
        this.unit_Price = unit_Price;
        this.availability = availability;
        this.stockId = stockId;
        this.imagePath = imagePath;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public int getQty_on_hand() {
        return qty_on_hand;
    }

    public void setQty_on_hand(int qty_on_hand) {
        this.qty_on_hand = qty_on_hand;
    }

    public double getUnit_Price() {
        return unit_Price;
    }

    public void setUnit_Price(double unit_Price) {
        this.unit_Price = unit_Price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
