
import java.util.ArrayList;

public class Box implements Packable {

    private double capacity;
    private ArrayList<Packable> packables;

    public Box(double capacity) {
        packables = new ArrayList<>();
        this.capacity = capacity;
    }
    
    public double weight() {
        double sum = 0.0;
        for (Packable packable : packables) {
            sum += packable.weight();
        }
        return sum;
    }
    
    public void add(Packable packable) {
        if ((packable.weight() + weight()) <= capacity) {
            packables.add(packable);
        }
    }

    @Override
    public String toString() {
        return "Box: " + packables.size() + " items, total weight " + weight()+ " kg";
    }
    
}
