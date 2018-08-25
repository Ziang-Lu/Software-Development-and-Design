package items;

/**
 * Abstract item class.
 *
 * @author Ziang Lu
 */
public abstract class Item {

    /**
     * Title of this item.
     */
    private final String title;

    /**
     * Constructor with parameter.
     * @param title title of the item
     */
    public Item(String title) {
        this.title = title;
    }

    /**
     * Accessor of title.
     * @return title
     */
    public String getTitle() {
        return title;
    }

}
