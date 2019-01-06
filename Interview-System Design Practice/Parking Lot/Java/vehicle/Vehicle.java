package vehicle;

/**
 * Abstract Vehicle class.
 *
 * @author Ziang Lu
 */
public abstract class Vehicle {

    /**
     * License plate of this vehicle.
     */
    private final String licensePlate;

    /**
     * Constructor with parameter.
     * @param licensePlate license plate of the vehicle
     */
    protected Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Accessor of licensePlate.
     * @return licensePlate
     */
    public String licensePlate() {
        return licensePlate;
    }

}
