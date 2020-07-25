package parking_lot;

import vehicle.Bus;
import vehicle.Car;
import vehicle.MotorCycle;
import vehicle.Truck;
import vehicle.Vehicle;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * ParkingLot class.
 *
 * @author Ziang Lu
 */
public class ParkingLot {

    /**
     * All parking spot sizes in ascending order.
     */
    private static final ParkingSpotSize[] ALL_SIZES_IN_ORDER =
            {ParkingSpotSize.S, ParkingSpotSize.M, ParkingSpotSize.M, ParkingSpotSize.XL};

    /**
     * Mapping between parking spot sizes and the corresponding available
     * parking spots.
     */
    private final Map<ParkingSpotSize, Queue<ParkingSpot>> available;
    /**
     * Mapping between the license plates of the parked vehicles and the
     * corresponding parking spot.
     */
    private final Map<String, ParkingSpot> parked;

    /**
     * Default constructor.
     */
    public ParkingLot() {
        available = new HashMap<>();
        for (ParkingSpotSize size : ParkingSpotSize.values()) {
            available.put(size, new ArrayDeque<>());
        }
        parked = new HashMap<>();
    }

    /**
     * Adds a parking spot of the given size to this parking lot.
     * @param size given parking spot size
     */
    public void addParkingSpot(ParkingSpotSize size) {
        available.get(size).offer(new ParkingSpot(size));
    }

    /**
     * Places the given vehicle.
     * @param v vehicle to place
     * @return parking spot ID on success, -1 on failure
     */
    public int placeVehicle(Vehicle v) {
        // Check whether the vehicle is already parked
        if (parked.containsKey(v.licensePlate())) {
            throw new RuntimeException("The vehicle is already parked.");
        }

        ParkingSpotSize vehicleSize = ParkingSpotSize.S;
        if (v instanceof Car) {
            vehicleSize = ParkingSpotSize.M;
        } else if (v instanceof Truck) {
            vehicleSize = ParkingSpotSize.L;
        } else if (v instanceof Bus) {
            vehicleSize = ParkingSpotSize.XL;
        }
        return placeVehicleFromSizedSpot(v, vehicleSize);
    }

    /**
     * Private helper method to place the given vehicle to a parking spot,
     * starting from searching the given size.
     * @param v vehicle to place
     * @param fromSize given parking spot size from which to start searching
     * @return parking spot ID on success, -1 on failure
     */
    private int placeVehicleFromSizedSpot(Vehicle v, ParkingSpotSize fromSize) {
        int fromIdx = Arrays.binarySearch(ALL_SIZES_IN_ORDER, fromSize);
        int parkedSpotId = -1;
        for (int idx = fromIdx; idx < ALL_SIZES_IN_ORDER.length; ++idx) {
            ParkingSpotSize spotSize = ALL_SIZES_IN_ORDER[idx];
            // Try to place the given vehicle to a parking spot of this size
            int parkedSpotId = placeVehicleToSizedSpot(v, spotSize);
            if (parkedSpotId != -1) {
                break;
            }
        }
        return parkedSpotId;
        // Time: O(1)
    }

    /**
     * Helper method to place the given vehicle to a parking spot of the given
     * size.
     * @param v vehicle to place
     * @param size given parking spot size
     * @return parking spot ID on success, -1 on failure
     */
    private int placeVehicleToSizedSpot(Vehicle v, ParkingSpotSize size) {
        Queue<ParkingSpot> sizeAvailable = available.get(size);
        if (sizeAvailable.isEmpty()) {
            return -1;
        }

        ParkingSpot spot = sizeAvailable.poll();
        // Occupy the parking spot
        spot.setVehicle(v);
        parked.put(v.licensePlate(), spot);
        return spot.id();
    }

    /**
     * Retrieves the vehicle with the given license plate.
     * @param licensePlate license plate to retrieve
     * @return retrieved vehicle
     */
    public Vehicle retrieveVehicle(String licensePlate) {
        // Check whether the vehicle is already parked
        if (!parked.containsKey(licensePlate)) {
            throw new RuntimeException("The vehicle is not parked.");
        }

        ParkingSpot spot = parked.remove(licensePlate);
        Vehicle v = spot.getVehicle();
        // Free the parking spot
        spot.setVehicle(null);
        available.get(spot.size()).offer(spot);
        return v;
    }

}
