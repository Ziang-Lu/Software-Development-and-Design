package model.cardio;

public abstract class CardioMachine {

    /**
     * Default level.
     */
    private static final int DEFAULT_LEVEL = 1;

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
    protected CardioMachine(int minutes) {
        this.minutes = minutes;
        level = DEFAULT_LEVEL;
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
     * Levels down this cardio machine, if possible.
     */
    public void levelDown() {
        if (level > 1) {
            --level;
        }
    }

}
