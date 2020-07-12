
import java.util.ArrayList;

public class ChangeHistory {

    private ArrayList<Double> history;

    public ChangeHistory() {
        history = new ArrayList<>();
    }
    
    public void add(double status) {
        history.add(status);
    }
    
    public void clear() {
        history.clear();
    }
    
    public double maxValue() {
        if (history.size() == 0) {
            return 0.0;
        }
        double max = history.get(0);
        for (Double value : history) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public double minValue() {
        if (history.size() == 0) {
            return 0.0;
        }
        double min = history.get(0);
        for (Double value : history) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
    
    public double average() {
        if (history.size() == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (Double value : history) {
            sum += value;
        }
        return sum / history.size();
    }
    
    @Override
    public String toString() {
        return history.toString();
    }
    
}

