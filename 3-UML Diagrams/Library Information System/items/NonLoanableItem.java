package items;

/**
 * Abstract non-loanable item class.
 *
 * @author Ziang Lu
 */
public abstract class NonLoanableItem extends Item {

    /**
     * Constructor with parameter.
     * @param title title of the item
     */
    public NonLoanableItem(String title) {
        super(title);
    }

}
