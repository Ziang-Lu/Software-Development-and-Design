package model.cardio;

public class InnerBike extends CardioMachine {

    /**
     * Constructor with parameter.
     * @param speed speed of this inner bike
     * @param minutes minutes of this inner bike
     */
    public InnerBike(double speed, int minutes) {
        // We assume that speed is positive.
        // We assume that minutes is positive.
        super(speed, minutes);
    }

}
