package application;

import java.util.ArrayList;
import java.util.List;

/* @author marbi */
public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> averages;

    public AverageSensor() {
        sensors = new ArrayList<Sensor>();
        averages = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }

    @Override
    public boolean isOn() {
        if (!sensors.isEmpty()) {
            for (Sensor sensor : sensors) {
                return sensor.isOn();
            }
        }

        return false;

    }

    @Override
    public void on() {
        for (Sensor sensor : sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (sensors.isEmpty()) {
            throw new IllegalStateException();
        }

        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                throw new IllegalStateException();
            }
        }

        int totalAverage = 0;

        for (Sensor sensor : sensors) {
            totalAverage += sensor.measure();
        }

        int average = totalAverage / sensors.size();
        averages.add(average);

        return average;
    }

    public List<Integer> readings() {
        return averages;
    }
}
