import java.util.ArrayList;
import java.util.List;

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
     * Factory method to make a Room.
     * @return created Room
     */
    public abstract Room makeRoom();

}
