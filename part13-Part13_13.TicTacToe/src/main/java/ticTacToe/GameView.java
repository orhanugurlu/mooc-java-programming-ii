package ticTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameView {

    private GameLogic gameLogic;
    private Button[][] buttons;
    private Label infoLabel;
    private Parent view;
    
    private void handleButtonClick(Button b) {
        GameStatus status = gameLogic.getStatus();
        if (status != GameStatus.The_End && b.getText().equals(" ")) {
            String userData = (String)b.getUserData();
            int row = userData.charAt(0) - '0';
            int col = userData.charAt(1) - '0';
            gameLogic.setField(row, col);
            b.setText(gameLogic.getField(row, col));
            infoLabel.setText(gameLogic.getStatus().toString());
        }
    }    
    
    public GameView(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        buttons = new Button[3][3];
        infoLabel = new Label();
        
        BorderPane layout = new BorderPane();
        infoLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 40));
        infoLabel.setPadding(new Insets(10, 10, 10, 10));
        layout.setTop(infoLabel);
        
        GridPane gridLayout = new GridPane();
        gridLayout.setAlignment(Pos.CENTER);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button b = new Button(" ");
                b.setUserData(i + "" + j);
                b.setFont(Font.font("Monospaced", FontWeight.BOLD, 40));
                b.setOnAction((event) -> {
                    Button src = (Button)event.getSource();
                    handleButtonClick(src);
                });
                buttons[i][j] = b;
                gridLayout.add(b, i, j);
            }
        }
        infoLabel.setText(gameLogic.getStatus().toString());
        layout.setCenter(gridLayout);
        view = layout;
    }
    
    public Parent getView() {
        return view;
    }
}
