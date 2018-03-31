package model.gym;

public class DeluxeGym extends Gym {

    /**
     * Whether this deluxe gym has sauna.
     */
    private final boolean hasSauna;

    /**
     * Constructor with parameter.
     * @param location location name of the delexu gym
     */
    public DeluxeGym(String location) {
        super(location, true);
        hasSauna = true;
    }

    /**
     * Accessor of hasSauna.
     * @return hasSauna
     */
    public boolean hasSauna() {
        return hasSauna;
    }

}
