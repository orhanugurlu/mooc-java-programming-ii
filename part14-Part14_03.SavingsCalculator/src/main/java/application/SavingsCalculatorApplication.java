package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SavingsCalculatorApplication  extends Application {

    @Override
    public void start(Stage window) throws Exception {
        SavingsCalculator calculator = new SavingsCalculator();
        SavingsCalculatorView view = new SavingsCalculatorView(calculator);
        Scene scene = new Scene(view.getView(), 640, 480);
        window.setTitle("Savings Calculator");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
}