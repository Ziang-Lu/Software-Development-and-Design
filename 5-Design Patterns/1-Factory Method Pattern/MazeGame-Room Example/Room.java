import java.util.ArrayList;
import java.util.List;

public abstract class Room {

    /**
     * List of connected rooms.
     */
    private List<Room> connectedRooms;

    /**
     * Default constructor.
     */
    public Room() {
        connectedRooms = new ArrayList<>();
    }

    /**
     * Adds the given room to the connected rooms.
     * @param room room to connect
     */
    public void connect(Room room) {
        connectedRooms.add(room);
    }

}
