
public class MagicSquareFactory {

    private int[] getNextCell(MagicSquare square, int x, int y) {
        int newY = (y - 1 + square.getHeight()) % square.getHeight();
        int newX = (x + 1) % square.getWidth();
        if (square.readValue(newX, newY) == 0) {
            return new int[] {newX, newY};
        } else {
            y = (y + 1) % square.getWidth();
            return new int[] {x, y};
        }
    }
    
    public MagicSquare createMagicSquare(int size) {
        if (size % 2 == 0) {
            throw new IllegalArgumentException("Only odd sized magic squares are supported");
        }

        MagicSquare square = new MagicSquare(size);

        int currentNumber = 1;
        int lastNumber = size * size;

        int y = 0;
        int x = (size - 1) / 2;
        square.placeValue(x, y, currentNumber);
        currentNumber++;
        while (currentNumber <= lastNumber) {
            int[] newCoord = getNextCell(square, x, y);
            x = newCoord[0];
            y = newCoord[1];
            square.placeValue(x, y, currentNumber);
            currentNumber++;
        }
        
        return square;
    }

}
