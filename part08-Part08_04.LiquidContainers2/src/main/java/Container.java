public class Container {
    
    private static final int MAX_AMOUNT = 100;
    private int amount;

    public Container() {
        amount = 0;
    }
    

    public int contains() {
        return amount;
    }

    public void add(int amountToAdd) {
        if (amountToAdd > 0) {
            if ((amount + amountToAdd) > MAX_AMOUNT) {
                amount = MAX_AMOUNT;
            } else {
                amount += amountToAdd;
            }
        }
    }

    public void remove(int amountToRemove) {
        if (amountToRemove > 0) {
            if ((amount - amountToRemove) < 0) {
                amount = 0;
            } else {
                amount -= amountToRemove;
            }
        }
    }

    @Override
    public String toString() {
        return amount + "/" + MAX_AMOUNT;
    }
    
}
