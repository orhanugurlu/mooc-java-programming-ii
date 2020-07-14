package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {
    
    @Override
    public void start(Stage window) {        
        Label firstLabel = new Label("First view!");
        Button firstButton = new Button("To the second view!");
        BorderPane layout1 = new BorderPane();
        layout1.setTop(firstLabel);
        layout1.setCenter(firstButton);
        Scene firstScene = new Scene(layout1);

        Label secondLabel = new Label("Second view!");
        Button secondButton = new Button("To the third view!");
        VBox layout2 = new VBox();
        layout2.getChildren().addAll(secondButton, secondLabel);
        Scene secondScene = new Scene(layout2);

        Label thirdLabel = new Label("Third view!");
        Button thirdButton = new Button("To the first view!");
        GridPane layout3 = new GridPane();
        layout3.add(thirdLabel, 0, 0);
        layout3.add(thirdButton, 1, 1);
        Scene thirdScene = new Scene(layout3);
        
        firstButton.setOnAction((event) -> {
            window.setScene(secondScene);
        });

        secondButton.setOnAction((event) -> {
            window.setScene(thirdScene);
        });

        thirdButton.setOnAction((event) -> {
            window.setScene(firstScene);
        });
        
        window.setScene(firstScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}