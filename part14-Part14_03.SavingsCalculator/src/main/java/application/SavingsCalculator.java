package application;

import java.util.HashMap;
import java.util.Map;

public class SavingsCalculator {

    public Map<Integer, Double> calculateSavings(int years, double monthlySaving) {
        Map<Integer, Double> savings = new HashMap<>();
        double currentSaving = 0.0;
        for (int i = 0; i <= years; i++) {
            savings.put(i, currentSaving);
            currentSaving += monthlySaving * 12;
        }
        return savings;
    }

    public Map<Integer, Double> calculateCompound(int years, double monthlySaving, double rate) {
        Map<Integer, Double> savings = new HashMap<>();
        double currentSaving = 0.0;
        for (int i = 0; i <= years; i++) {
            savings.put(i, currentSaving);
            currentSaving = (currentSaving + monthlySaving * 12) * (1.0 + rate / 100.0);
        }
        return savings;
    }
    
}
