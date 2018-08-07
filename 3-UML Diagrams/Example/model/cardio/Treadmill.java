package model.cardio;

/**
 * Treadmill class.
 *
 * @author Ziang Lu
 */
public class Treadmill extends CardioMachine {

    /**
     * Speed of this treadmill.
     */
    private double speed;

    /**
     * Constructor with parameter.
     * @param speed speed of this treadmill
     * @param minutes minutes of this treadmill
     */
    public Treadmill(double speed, int minutes) {
        // We assume that speed is positive.
        // We assume that minutes is positive.
        super(minutes);
        this.speed = speed;
    }

    /**
     * Accessor of speed.
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Mutator of speed.
     * @param speed speed to set
     */
    public void setSpeed(double speed) {
        if (speed <= 0.0) {
            throw new IllegalArgumentException("The speed should be positive.");
        }
        this.speed = speed;
    }

}
