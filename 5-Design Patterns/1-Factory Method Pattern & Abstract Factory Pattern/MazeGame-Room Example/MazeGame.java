import java.util.ArrayList;
import java.util.List;

/**
 * Abstract factory MazeGame class.
 *
 * @author Ziang Lu
 */
public abstract class MazeGame {

    /**
     * List of rooms.
     */
    private List<Room> rooms;

    /**
     * Default constructor.
     */
    public MazeGame() {
        rooms = new ArrayList<>();
        Room room1 = makeRoom();
        rooms.add(room1);
        Room room2 = makeRoom();
        rooms.add(room2);
        room1.connect(room2);
    }

    /**
     * Abstract factory method to make an abstract product Room instance.
     * However, the ability to determine which concrete type of Room product to
     * instantiate is deferred to concrete factories (subclasses).
     * @return instantiated Room
     */
    public abstract Room makeRoom();

}
