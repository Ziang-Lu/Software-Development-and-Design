package model.weights;

/**
 * Dumbbell class.
 *
 * @author Ziang Lu
 */
public class Dumbbell extends Weight {

    /**
     * Constructor with parameter.
     * @param pounds weight of the dumbbell
     */
    public Dumbbell(int pounds) {
        // We assume that pounds is positive.
        super(pounds);
    }

    @Override
    public int getWeight() {
        return pounds * 2;
    }

}
