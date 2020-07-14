package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeApplication  extends Application {

    @Override
    public void start(Stage window) throws Exception {
        GameLogic gameLogic = new GameLogic();
        GameView gameView = new GameView(gameLogic);
        Scene scene = new Scene(gameView.getView());
        window.setTitle("Tic Tac Toe");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}