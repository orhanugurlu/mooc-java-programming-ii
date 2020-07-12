public class CustomTacoBox implements TacoBox {
    
    private int tacos;

    public CustomTacoBox(int tacos) {
        this.tacos = tacos;
    }

    @Override
    public void eat() {
        if (tacos > 0) {
            tacos--;
        }
    }

    @Override
    public int tacosRemaining() {
        return tacos;
    }
    
}
