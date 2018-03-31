package model.cardio;

public class Treadmill extends CardioMachine {

    /**
     * Constructor with parameter.
     * @param speed speed of this treadmill
     * @param minutes minutes of this treadmill
     */
    public Treadmill(double speed, int minutes) {
        // We assume that speed is positive.
        // We assume that minutes is positive.
        super(speed, minutes);
    }

}
