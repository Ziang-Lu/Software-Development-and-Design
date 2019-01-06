package parking_lot;

import vehicle.Vehicle;

/**
 * ParkingSpot class.
 *
 * @author Ziang Lu
 */
class ParkingSpot {

    /**
     * Next ID to assign.
     */
    private static int nextId = 0;

    /**
     * ID of this parking spot.
     */
    private final int id;
    /**
     * Size of this parking spot.
     */
    private final ParkingSpotSize size;
    /**
     * Vehicle parked in this parking spot.
     */
    private Vehicle myVehicle;

    /**
     * Constructor with parameter.
     * @param size size of the parking spot
     */
    ParkingSpot(ParkingSpotSize size) {
        id = nextId;
        ++nextId;
        this.size = size;
        myVehicle = null;
    }

    /**
     * Accessor of id.
     * @return id
     */
    int id() {
        return id;
    }

    /**
     * Accessor of size.
     * @return size
     */
    ParkingSpotSize size() {
        return size;
    }

    /**
     * Accessor of myVehicle.
     * @return myVehicle
     */
    Vehicle getVehicle() {
        return myVehicle;
    }

    /**
     * Mutator of myVehicle
     * @param vehicle vehicle to set
     */
    void setVehicle(Vehicle vehicle) {
        myVehicle = vehicle;
    }

}
