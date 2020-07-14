package ticTacToe;

public class PlayerState {

    private int[] colCounts;
    private int[] rowCounts;
    private int firstDiagonalCount;
    private int secondDiagonalCount;
    private Boolean won;

    public PlayerState() {
       reset();
    }

    private int increment(int current) {
        current++;
        if (current == 3) {
            won = true;
        }
        return current;
    }
    
    public void reset() {
        colCounts = new int[]{0, 0, 0};
        rowCounts = new int[]{0, 0, 0};
        firstDiagonalCount = 0;
        secondDiagonalCount = 0;
        won = false;
    }
    
    private Boolean isOnFirstDiagonal(int row, int col) {
        return row == col;
    }

    private Boolean isOnSecondDiagonal(int row, int col) {
        return row == (2 - col);
    }
    
    public void setField(int row, int col) {
        rowCounts[row] = increment(rowCounts[row]);
        colCounts[col] = increment(colCounts[col]);
        if (isOnFirstDiagonal(row, col)) {
            firstDiagonalCount = increment(firstDiagonalCount);
        }
        if (isOnSecondDiagonal(row, col)) {
            secondDiagonalCount = increment(secondDiagonalCount);
        }
    }
 
    public Boolean hasWon() {
        return won;
    }
    
}
