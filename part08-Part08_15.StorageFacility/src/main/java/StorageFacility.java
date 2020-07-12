
import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    
    private HashMap<String, ArrayList<String>> map;

    public StorageFacility() {
        map = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        map.putIfAbsent(unit, new ArrayList<>());
        map.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        return map.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item) {
        if (map.containsKey(storageUnit)) {
            ArrayList<String> items = map.get(storageUnit);
            items.remove(item);
            if (items.size() == 0) {
                map.remove(storageUnit);
            }
        }
    }    
    
    public ArrayList<String> storageUnits() {
        return new ArrayList<>(map.keySet());
    }    
}
