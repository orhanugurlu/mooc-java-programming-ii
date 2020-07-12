
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private Map<String,Integer> priceMap;
    private Map<String,Integer> stockMap;

    public Warehouse() {
        priceMap = new HashMap<>();
        stockMap = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        priceMap.put(product, price);
        int existingStock = stock(product);
        stockMap.put(product, existingStock + stock);
    }
    
    public int price(String product) {
        return priceMap.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return stockMap.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        int currentStock = stock(product);
        if (currentStock >= 1) {
            stockMap.put(product, currentStock - 1);
            return true;
        }
        return false;
    }
    
    public Set<String> products() {
        return priceMap.keySet();
    }
    
}
