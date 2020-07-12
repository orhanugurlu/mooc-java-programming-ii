public class OneItemBox extends Box {

    private Item itemInTheBox;
    
    public OneItemBox() {
        itemInTheBox = null;
    }

    @Override
    public void add(Item item) {
        if (itemInTheBox == null) {
            itemInTheBox = item;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return (itemInTheBox != null && item != null && itemInTheBox.equals(item));
    }
    
}
