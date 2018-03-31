package model.cardio;

public abstract class CardioMachine {

    /**
     * Default level.
     */
    private static final int DEFAULT_LEVEL = 1;

    /**
     * Speed of this cardio machine.
     */
    protected double speed;
    /**
     * Minutes of this cardio machine.
     */
    protected int minutes;
    /**
     * Level of this cardio machine.
     */
    protected int level;

    /**
     * Constructor with parameter.
     * @param minutes minutes of the cardio
     */
    protected CardioMachine(double speed, int minutes) {
        this.speed = speed;
        this.minutes = minutes;
        level = DEFAULT_LEVEL;
    }

    /**
     * Accessor of speed.
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Accessor of minutes.
     * @return minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Accessor of level
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Mutator of speed.
     * @param speed speed to set
     */
    public void setSpeed(double speed) {
        if (speed <= 0.0) {
            throw new IllegalArgumentException("The speed to set should be positive.");
        }
        this.speed = speed;
    }

    /**
     * Mutator of minutes.
     * @param minutes minutes to set
     */
    public void setMinutes(int minutes) {
        if (minutes <= 0) {
            throw new IllegalArgumentException("The minutes to set should be positive.");
        }
        this.minutes = minutes;
    }

    /**
     * Levels up this cardio machine.
     */
    public void levelUp() {
        ++level;
    }

    /**
     * Levels down this cardio machine.
     */
    public void levelDown() {
        if (level > 1) {
            --level;
        }
    }

}
