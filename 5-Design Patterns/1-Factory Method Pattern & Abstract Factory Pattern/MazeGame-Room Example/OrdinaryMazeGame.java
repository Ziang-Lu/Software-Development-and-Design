
public class OrdinaryMazeGame extends MazeGame {

    @Override
    public Room makeRoom() {
        return new OrdinaryRoom();
    }

}
