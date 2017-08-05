package application;

import java.util.Random;

/* @author marbi */
public class Thermometer implements Sensor {

    private boolean swtch;

    public Thermometer() {
        this.swtch = false;
    }

    @Override
    public boolean isOn() {
        return this.swtch;
    }

    @Override
    public void on() {
        this.swtch = true;
    }

    @Override
    public void off() {
        this.swtch = false;

    }

    @Override
    public int measure() {
        if (!this.swtch) {
            throw new IllegalStateException();
        } else {
            Random rn = new Random();
            return rn.nextInt(30 - (-30) + 1) + (-30);
        }
    }

}
