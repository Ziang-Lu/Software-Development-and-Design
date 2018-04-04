
public class MagicMazeGame extends MazeGame {

    @Override
    public Room makeRoom() {
        return new MagicRoom();
    }

}
