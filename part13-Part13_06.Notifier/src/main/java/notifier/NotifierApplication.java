package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage window) {
        TextField textField = new TextField();
        Button button = new Button("Update");
        Label label = new Label();

        button.setOnAction((event) -> {
            label.setText(textField.getText());
        });
        
        VBox layout = new VBox();
        layout.getChildren().addAll(textField, button, label);
        
        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }
}
