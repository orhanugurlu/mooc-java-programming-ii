public class List<T> {
    
    private T[] items;
    private int firstFreeIndex;
    
    public List() {
        items = (T[])new Object[10];
        firstFreeIndex = 0;
    }
    
    private void grow() {
        int newSize = items.length + items.length / 2;
        T[] newItems = (T[])new Object[newSize];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }
    
    public void add(T item) {
        if (items.length == firstFreeIndex) {
            grow();
        }
        items[firstFreeIndex] = item;
        firstFreeIndex++;
    }
    
    public boolean contains(T item) {
        return indexOfValue(item) != -1;
    }
    
    public int indexOfValue(T item) {
        for (int i = 0; i < firstFreeIndex; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    
    private void shiftLeft(int startIndex) {
        for (int i = startIndex; i < firstFreeIndex; i++) {
            items[i] = items[i+1];
        }
    }
    
    public void remove(T item) {
        int indexToRemove = indexOfValue(item);
        if (indexToRemove != -1) {
            shiftLeft(indexToRemove);
            firstFreeIndex--;
        }
    }
    
    public T value(int index) {
        if (index < 0 || index >= firstFreeIndex) {
            throw new IndexOutOfBoundsException("Index " + index 
                    + " is outside of [0, " + firstFreeIndex + "]");
        }
        return items[index];
    }
    
    public int size() {
        return firstFreeIndex;
    }
    
}
