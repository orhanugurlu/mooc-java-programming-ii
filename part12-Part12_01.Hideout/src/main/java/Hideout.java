public class Hideout<T> {

    private T item = null;
    
    public void putIntoHideout(T toHide) {
        this.item = toHide;
    }
    
    public T takeFromHideout() {
        T result = this.item;
        this.item = null;
        return result;
    }
    
    public boolean isInHideout() {
        return (item != null);
    }  
    
}
