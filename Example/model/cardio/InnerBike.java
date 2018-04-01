package model.cardio;

public class InnerBike extends CardioMachine {

    /**
     * Constructor with parameter.
     * @param minutes minutes of this inner bike
     */
    public InnerBike(int minutes) {
        // We assume that minutes is positive.
        super(minutes);
    }

}
