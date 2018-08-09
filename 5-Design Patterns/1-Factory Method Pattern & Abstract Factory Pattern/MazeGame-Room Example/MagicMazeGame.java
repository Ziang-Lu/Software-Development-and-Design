/**
 * Concrete factory MagicMazeGame class.
 *
 * @author Ziang Lu
 */
public class MagicMazeGame extends MazeGame {

    /**
     * Concrete factory method to make a concrete product MagicRoom instance.
     * @return instantiated Room
     */
    @Override
    public Room makeRoom() {
        return new MagicRoom();
    }

}
