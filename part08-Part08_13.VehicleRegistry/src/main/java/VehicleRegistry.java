
import java.util.HashMap;
import java.util.HashSet;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> map = new HashMap<>();
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (map.containsKey(licensePlate)) {
            return false;
        } else {
            map.put(licensePlate, owner);
            return true;
        }
    }
    
    public String get(LicensePlate licensePlate) {
        return map.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (map.containsKey(licensePlate)) {
            map.remove(licensePlate);
            return true;
        } else {
            return false;
        }
    }
    
    public void printLicensePlates() {
        for (LicensePlate licensePlate : map.keySet()) {
            System.out.println(licensePlate);
        }
    }
    
    public void printOwners() {
        HashSet<String> set = new HashSet();
        set.addAll(map.values());
        for (String owner : set) {
            System.out.println(owner);
        }
    }
    
}
