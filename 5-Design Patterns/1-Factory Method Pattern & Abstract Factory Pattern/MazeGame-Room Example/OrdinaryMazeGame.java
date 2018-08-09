/**
 * Concrete factory OrdinaryMazeGame class.
 *
 * @author Ziang Lu
 */
public class OrdinaryMazeGame extends MazeGame {

    /**
     * Concrete factory method to make a concrete product OrdinaryMazeGame
     * instance.
     * @return instantiated Room
     */
    @Override
    public Room makeRoom() {
        return new OrdinaryRoom();
    }

}
