package application;

import java.text.DecimalFormat;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SavingsCalculatorView {

    private static final DecimalFormat df = new DecimalFormat("0.0");
    private static final int noOfYears = 30;

    private Parent view;
    private SavingsCalculator calculator;
    private Label savingLabel;
    private Label rateLabel;
    private Slider savingSlider;
    private Slider rateSlider;
    LineChart<Number, Number> lineChart;
    XYChart.Series savingSeries;
    XYChart.Series compoundSeries;

    private void updateSeries(XYChart.Series series, Map<Integer, Double> data) {
        series.getData().clear();
        data.forEach((year, value) -> {
            series.getData().add(new XYChart.Data(year, value));
        });
    }
    
    private void updateView() {
        Double saving = Double.parseDouble(df.format(savingSlider.getValue()));
        Double rate = Double.parseDouble(df.format(rateSlider.getValue()));
        savingLabel.setText(saving.toString());
        rateLabel.setText(rate.toString());
        Map<Integer, Double> savings = calculator.calculateSavings(noOfYears, saving);
        updateSeries(savingSeries, savings);
        Map<Integer, Double> compund = calculator.calculateCompound(noOfYears, saving, rate);
        updateSeries(compoundSeries, compund);
    }
    
    public SavingsCalculatorView(SavingsCalculator calculator) {
        this.calculator = calculator;
        
        BorderPane savingLayout = new BorderPane();
        Label savingDesc = new Label("Monthly savings");
        savingSlider = new Slider(25, 250, 25);
        savingSlider.setShowTickMarks(true);
        savingSlider.setShowTickLabels(true);
        savingSlider.setMajorTickUnit(25);
        savingSlider.setBlockIncrement(25);
        //savingSlider.setSnapToTicks(true);
        savingSlider.valueProperty().addListener(e -> updateView());
        savingLabel = new Label(savingSlider.getValue() + "");
        savingLayout.setLeft(savingDesc);
        savingLayout.setCenter(savingSlider);
        savingLayout.setRight(savingLabel);
        savingLayout.setPadding(new Insets(10, 10, 10, 10));

        BorderPane rateLayout = new BorderPane();
        Label rateDesc = new Label("Yearly interest rate");
        rateSlider = new Slider(0, 10, 0);
        rateSlider.setShowTickMarks(true);
        rateSlider.setShowTickLabels(true);
        rateSlider.setMajorTickUnit(1.0);
        rateSlider.setBlockIncrement(1.0);
        rateSlider.valueProperty().addListener(e -> updateView());
        rateLabel = new Label(rateSlider.getValue() + "");
        rateLayout.setLeft(rateDesc);
        rateLayout.setCenter(rateSlider);
        rateLayout.setRight(rateLabel);
        rateLayout.setPadding(new Insets(10, 10, 10, 10));

        VBox settingsLayout = new VBox();
        settingsLayout.getChildren().addAll(savingLayout, rateLayout);
        
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings");
        lineChart.setLegendVisible(false);
        lineChart.setPadding(new Insets(10, 10, 10, 10));
        savingSeries = new XYChart.Series();
        compoundSeries = new XYChart.Series();
        lineChart.getData().add(savingSeries);
        lineChart.getData().add(compoundSeries);
        
        BorderPane layout = new BorderPane();
        layout.setTop(settingsLayout);
        layout.setCenter(lineChart);
        
        updateView();
        
        view = layout;
    }

    public Parent getView() {
        return view;
    }
   
}
