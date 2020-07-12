public class Item {

    private String product;
    private int quantity;
    private int price;

    public Item(String product, int quantity, int price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public int price() {
        return price * quantity;
    }
    
    public void increaseQuantity() {
        quantity++;
    }
    
    public String toString() {
        return product + ": " + quantity;
    }
}
