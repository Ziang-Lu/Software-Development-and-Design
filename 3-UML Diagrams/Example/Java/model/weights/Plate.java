package model.weights;

/**
 * Plate class.
 *
 * @author Ziang Lu
 */
public class Plate extends Weight {

    /**
     * Constructor with parameter.
     * @param pounds weight of the plate
     */
    public Plate(int pounds) {
        // We assume that pounds is positive.
        super(pounds);
    }

    @Override
    public int getWeight() {
        return pounds;
    }

}
