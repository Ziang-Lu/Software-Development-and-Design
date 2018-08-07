package model.weights;

/**
 * Abstract weight class.
 *
 * @author Ziang Lu
 */
public abstract class Weight {

    /**
     * Pounds of this weight.
     */
    protected int pounds;

    /**
     * Constructor with parameter.
     * @param pounds pounds of the weight
     */
    protected Weight(int pounds) {
        this.pounds = pounds;
    }

    /**
     * Returns the total weight of this weight.
     * @return total weight
     */
    public abstract int getWeight();

    /**
     * Mutator of pounds.
     * @param pounds weight to set
     */
    public void setWeight(int pounds) {
        if (pounds <= 0) {
            throw new IllegalArgumentException("The weight to set should be positive.");
        }
        this.pounds = pounds;
    }

}
