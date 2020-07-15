package application;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {
    
    private List<String> readLines(String fileName){
        List<String> lines = new ArrayList<>();
        try {
            Files.lines(Paths.get(fileName)).forEach(line -> {
                if (line.trim().length() > 0) {
                    lines.add(line);
                }
            });
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lines;
    }
    private Map<String, Map<Integer, Double>> loadData(String fileName) {
        Map<String, Map<Integer, Double>> data = new HashMap<>();
        List<String> lines = readLines(fileName);
        String[] years = lines.get(0).split("\t");
        for (int i = 1; i < lines.size(); i++) {
            String[] partyLineTokes = lines.get(i).split("\t");
            Map<Integer, Double> partyData = new HashMap<>();
            for (int j = 1; j < partyLineTokes.length; j++) {
                if (!partyLineTokes[j].equals("-")) {
                    partyData.put(Integer.valueOf(years[j]),
                                  Double.valueOf(partyLineTokes[j]));                    
                }
            }
            data.put(partyLineTokes[0], partyData);
        }
        return data;
    }
    
    private void addDataSeries(LineChart<Number, Number> lineChart,
                               Map<String, Map<Integer, Double>> values) {
        values.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            lineChart.getData().add(data);
        });    
    }
    
    @Override
    public void start(Stage stage) {
        Map<String, Map<Integer, Double>> data = loadData("partiesdata.tsv");

        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        addDataSeries(lineChart, data);

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}
