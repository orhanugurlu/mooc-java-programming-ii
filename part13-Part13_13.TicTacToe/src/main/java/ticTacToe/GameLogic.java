package ticTacToe;

import java.util.Arrays;

public class GameLogic {

    private static final String EMPTY = " ";
    private static final String PLAY_X = "X";
    private static final String PLAY_O = "O";
    
    private String[][] grid = new String[3][3];
    private PlayerState stateX;
    private PlayerState stateO;
    private GameStatus status;
    private int totalPlayCount;
    
    private void reset() {
        status = GameStatus.Turn_X;
        for (String[] row: grid)
            Arrays.fill(row, EMPTY);
        stateX = new PlayerState();
        stateO = new PlayerState();
        totalPlayCount = 0;
    }
    
    public GameLogic() {
        reset();
    }
    
    public void setField(int row, int col) {
        if (status == GameStatus.Turn_O) {
            grid[row][col] = PLAY_O;
            stateO.setField(row, col);
        } else if (status == GameStatus.Turn_X) {
            grid[row][col] = PLAY_X;
            stateX.setField(row, col);
        }
        totalPlayCount++;
        if (stateX.hasWon() || stateO.hasWon() || totalPlayCount == 9) {
            status = GameStatus.The_End;
        } else if (status == GameStatus.Turn_O) {
            status = GameStatus.Turn_X;
        } else {
            status = GameStatus.Turn_O;
        }
    }

    public String getField(int row, int col) {
        return grid[row][col];
    }
    
    public GameStatus getStatus() {
        return status;
    }
    
}