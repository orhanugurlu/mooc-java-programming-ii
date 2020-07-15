package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    private static final int[][] data = {
        {2007, 73},
        {2008, 68},
        {2009, 72},
        {2010, 72},
        {2011, 74},
        {2012, 73},
        {2013, 76},
        {2014, 73},
        {2015, 67},
        {2016, 56},
        {2017, 56}        
    };
    
    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        lineChart.setLegendVisible(false);

        XYChart.Series seriesData = new XYChart.Series();
        for (int i = 0; i < data.length; i++) {
            seriesData.getData().add(new XYChart.Data(data[i][0], data[i][1]));
        }
        lineChart.getData().add(seriesData);

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

}
