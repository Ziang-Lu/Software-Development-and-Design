package model.gym;

/**
 * DeluxeGym class.
 *
 * @author Ziang Lu
 */
public class DeluxeGym extends Gym {

    /**
     * Whether this deluxe gym has sauna.
     */
    private final boolean hasSauna = true;

    /**
     * Constructor with parameter.
     * @param location location name of the deluxe gym
     */
    public DeluxeGym(String location) {
        super(location, true);
    }

    /**
     * Accessor of hasSauna.
     * @return hasSauna
     */
    public boolean hasSauna() {
        return hasSauna;
    }

}
