package model.cardio;

public class Elliptical extends CardioMachine {

    /**
     * Constructor with parameter.
     * @param minutes minutes of this elliptical
     */
    public Elliptical(int minutes) {
        // We assume that minutes is positive.
        super(minutes);
    }

}
