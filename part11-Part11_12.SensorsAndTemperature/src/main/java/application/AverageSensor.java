package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;

    public AverageSensor() {
        sensors = new ArrayList<>();
        readings = new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }    
    
    @Override
    public boolean isOn() {
        Boolean result = true;
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void setOn() {
        sensors.forEach(s -> s.setOn());
    }

    @Override
    public void setOff() {
        sensors.forEach(s -> s.setOff());
    }

    public List<Integer> readings() {
        return readings;
    }
    
    @Override
    public int read() {
        if (!isOn() || sensors.size() == 0) {
            throw new IllegalStateException();
        } else {
            int reading = (int)sensors.stream().mapToInt(s -> s.read()).average().getAsDouble(); 
            readings.add(reading);
            return reading;
        }
    }
    
}
