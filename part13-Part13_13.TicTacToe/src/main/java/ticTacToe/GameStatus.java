package ticTacToe;

public enum GameStatus {
    Turn_X  { public String toString() { return "Turn: X"; }; },  
    Turn_O  { public String toString() { return "Turn: O"; }; },
    The_End { public String toString() { return "The end!"; }; }
}
