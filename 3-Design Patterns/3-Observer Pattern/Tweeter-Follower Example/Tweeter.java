/**
 * Concrete Tweeter class working as "subject".
 *
 * @author Ziang Lu
 */
public class Tweeter extends Subject {

    /**
     * Constructor with parameter.
     * @param name name of the tweeter
     */
    public Tweeter(String name) {
        super(name);
    }

    /**
     * Writes a new Tweeter.
     */
    public void writeTweeter() {
        System.out.println(name + " -> I wrote a new Tweeter!");
        notifyAllObservers();
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : myObservers) {
            observer.update();
        }
    }

}
