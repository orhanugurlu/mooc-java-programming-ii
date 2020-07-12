
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> itemMap;

    public ShoppingCart() {
        itemMap = new HashMap<>();
    }
    
    public void add(String product, int price) {
        if (itemMap.containsKey(product)) {
            Item item = itemMap.get(product);
            item.increaseQuantity();;
        } else {
            itemMap.put(product, new Item(product, 1, price));
        }
    }
    
    public int price() {
        int sum = 0;
        for (Item item : itemMap.values()) {
            sum += item.price();
        }
        return sum;
    }
    
    public void print() {
        for (Item item : itemMap.values()) {
            System.out.println(item);
        }
    }    
}
