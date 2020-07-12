
import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    
    private ArrayList<Card> cards = new ArrayList<>();
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public void print() {
        cards.forEach(p -> System.out.println(p));
    }
    
    public void sort() {
        Collections.sort(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public int getValue() {
       return this.getCards().stream().mapToInt(c -> c.getValue()).sum(); 
    }
    
    @Override
    public int compareTo(Hand other) {
        return this.getValue() - other.getValue();
    }
    
    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }
}
