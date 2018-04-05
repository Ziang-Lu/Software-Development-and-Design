/**
 * Concrete Follower class working as "observer".
 *
 * @author Ziang Lu
 */
public class Follower extends Observer {

    /**
     * Constructor with parameter.
     * @param name
     */
    public Follower(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.println(name + ": I got an update!");
    }

}
