package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        
        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestWordLabel = new Label("The longest word is:");
        
        HBox labels = new HBox();
        labels.setSpacing(10);
        labels.getChildren().add(lettersLabel);
        labels.getChildren().add(wordsLabel);
        labels.getChildren().add(longestWordLabel);
        
        BorderPane layout = new BorderPane();
        layout.setCenter(textArea);
        layout.setBottom(labels);
        
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();
            lettersLabel.setText("Letters: " + characters);
            wordsLabel.setText("Words: " + words);
            longestWordLabel.setText("The longest word is: " + longest);
        });        
        
        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
}
