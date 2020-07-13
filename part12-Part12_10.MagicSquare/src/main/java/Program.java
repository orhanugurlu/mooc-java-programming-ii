
public class Program {

    public static void main(String[] args) {
        MagicSquareFactory msFactory = new MagicSquareFactory();
        MagicSquare square = msFactory.createMagicSquare(3);
        System.out.println(square);
        System.out.println(square.isMagicSquare());
        square = msFactory.createMagicSquare(5);
        System.out.println(square);
        System.out.println(square.isMagicSquare());
    }
}
