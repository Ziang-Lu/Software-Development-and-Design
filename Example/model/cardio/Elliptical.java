package model.cardio;

public class Elliptical extends CardioMachine {

    /**
     * Constructor with parameter.
     * @param speed speed of this elliptical
     * @param minutes minutes of this elliptical
     */
    public Elliptical(double speed, int minutes) {
        // We assume that speed is positive.
        // We assume that minutes is positive.
        super(speed, minutes);
    }

}
