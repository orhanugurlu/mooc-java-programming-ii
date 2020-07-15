package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage window) {

        Canvas paintingCanvas = new Canvas(640, 640);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        BorderPane drawingLayout = new BorderPane();
        drawingLayout.setCenter(paintingCanvas);

        painter.setFill(Color.BLACK);
        painter.fillRect(160, 80, 80, 80);
        painter.fillRect(320, 80, 80, 80);
        painter.fillRect(80, 400, 80, 80);
        painter.fillRect(400, 400, 80, 80);
        painter.fillRect(160, 480, 240, 80);

        Scene view = new Scene(drawingLayout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }
}