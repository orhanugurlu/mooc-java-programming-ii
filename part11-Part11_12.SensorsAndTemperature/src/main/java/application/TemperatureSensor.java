package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {

    private boolean on;

    public TemperatureSensor() {
        on = false;
    }
    
    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void setOn() {
        on = true;
    }

    @Override
    public void setOff() {
        on = false;
    }

    @Override
    public int read() {
        if (on) {
            return (new Random().nextInt(61) - 30);
        } else {
            throw new IllegalStateException();
        }
    }
    
}
