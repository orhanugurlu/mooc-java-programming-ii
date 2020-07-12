
import java.util.ArrayList;
import java.util.Collections;



public class Main {

    public static void main(String[] args) {
        // test your code here

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, Suit.DIAMOND));
        cards.add(new Card(2, Suit.CLUB));
        cards.add(new Card(14, Suit.SPADE));
        cards.add(new Card(12, Suit.HEART));
        System.out.println(cards);
        System.out.println("----");
        Collections.sort(cards);
        System.out.println(cards);
    }
}
