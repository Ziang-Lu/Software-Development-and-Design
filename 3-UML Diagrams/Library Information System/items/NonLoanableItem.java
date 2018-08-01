package items;

public abstract class NonLoanableItem extends Item {

    /**
     * Constructor with parameter.
     * @param title title of the item
     */
    public NonLoanableItem(String title) {
        super(title);
    }

}
