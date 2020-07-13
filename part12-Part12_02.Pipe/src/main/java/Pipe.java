
import java.util.ArrayList;

public class Pipe<T> {
    ArrayList<T> items;

    public Pipe() {
        items = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        items.add(value);
    }
    
    public T takeFromPipe() {
        if (isInPipe()) {
            return items.remove(0);
        } else {
            return null;
        }
    }
    
    public boolean isInPipe() {
        return items.size() > 0;
    }
    
}
