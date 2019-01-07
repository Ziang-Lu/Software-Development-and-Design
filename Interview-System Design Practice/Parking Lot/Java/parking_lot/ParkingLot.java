package parking_lot;

import vehicle.Car;
import vehicle.MotorCycle;
import vehicle.Truck;
import vehicle.Vehicle;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Sizes of the parking spots.
 */
enum ParkingSpotSize {
    S, M, L, XL
}

/**
 * ParkingLot class.
 *
 * @author Ziang Lu
 */
public class ParkingLot {

    private static final int DEFAULT_NUM_OF_SPOTS_PER_SIZE = 20;

    /**
     * Address of the parking lot.
     */
    private final String addr;
    /**
     * Mapping between parking spot sizes and the corresponding available
     * parking spots.
     */
    private final ConcurrentMap<ParkingSpotSize, BlockingQueue<ParkingSpot>> available;
    /**
     * Mapping between the license plates of the parked vehicles and the
     * corresponding parking spot.
     */
    private final ConcurrentMap<String, ParkingSpot> parked;

    /**
     * Constructor with parameter.
     * @param addr address of the parking lot
     */
    public ParkingLot(String addr) {
        this.addr = addr;
        available = new ConcurrentHashMap<>();
        for (ParkingSpotSize size : ParkingSpotSize.values()) {
            available.put(size, new ArrayBlockingQueue<>(DEFAULT_NUM_OF_SPOTS_PER_SIZE));
        }
        parked = new ConcurrentHashMap<>();
    }

    /**
     * Adds a parking spot of the given size to this parking lot.
     * @param size given parking spot size
     */
    public void addParkingSpot(ParkingSpotSize size) {
        BlockingQueue<ParkingSpot> sizeAvailable = available.get(size);
        sizeAvailable.offer(new ParkingSpot(size));
        available.put(size, sizeAvailable);
    }

    /**
     * Places the given vehicle.
     * @param vehicle vehicle to place
     * @return parking spot ID on success, -1 on failure
     */
    public int placeVehicle(Vehicle vehicle) {
        // Check whether the vehicle is already parked
        if (parked.containsKey(vehicle.licensePlate())) {
            throw new RuntimeException("The vehicle is already parked.");
        }

        int parkedSpotId = 0;
        if (vehicle instanceof MotorCycle) {
            if ((parkedSpotId = placeVehicleToSizedSpot(vehicle, ParkingSpotSize.S)) != -1) {
                return parkedSpotId;
            } else if ((parkedSpotId = placeVehicleToSizedSpot(vehicle, ParkingSpotSize.M)) != -1) {
                return parkedSpotId;
            } else if ((parkedSpotId = placeVehicleToSizedSpot(vehicle, ParkingSpotSize.L)) != -1) {
                return parkedSpotId;
            }
            return placeVehicleToSizedSpot(vehicle, ParkingSpotSize.XL);
        } else if (vehicle instanceof Car) {
            if ((parkedSpotId = placeVehicleToSizedSpot(vehicle, ParkingSpotSize.M)) != -1) {
                return parkedSpotId;
            } else if ((parkedSpotId = placeVehicleToSizedSpot(vehicle, ParkingSpotSize.L)) != -1) {
                return parkedSpotId;
            }
            return placeVehicleToSizedSpot(vehicle, ParkingSpotSize.XL);
        } else if (vehicle instanceof Truck) {
            if ((parkedSpotId = placeVehicleToSizedSpot(vehicle, ParkingSpotSize.L)) != -1) {
                return parkedSpotId;
            }
            return placeVehicleToSizedSpot(vehicle, ParkingSpotSize.XL);
        } else {
            return placeVehicleToSizedSpot(vehicle, ParkingSpotSize.XL);
        }
        // Time: O(1)
    }

    /**
     * Private helper method to place the given vehicle to a parking spot of the
     * given size.
     * @param vehicle vehicle to place
     * @param size given parking spot size
     * @return parking spot ID on success, -1 on failure
     */
    private int placeVehicleToSizedSpot(Vehicle vehicle, ParkingSpotSize size) {
        BlockingQueue<ParkingSpot> sizeAvailable = available.get(size);
        if (sizeAvailable.isEmpty()) {
            return -1;
        }

        ParkingSpot spot = sizeAvailable.poll();
        // Occupy the parking spot
        spot.setVehicle(vehicle);
        parked.put(vehicle.licensePlate(), spot);
        return spot.id();
        // Time: O(1)
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
        Vehicle vehicle = spot.getVehicle();
        // Free the parking spot
        spot.setVehicle(null);
        BlockingQueue<ParkingSpot> sizeAvailable = available.get(spot.size());
        sizeAvailable.offer(spot);
        available.put(spot.size(), sizeAvailable);
        return vehicle;
        // Time: O(1)
    }

}
