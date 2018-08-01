package items;

public abstract class Item {

    /**
     * Title of this item.
     */
    private final String title;

    /**
     * Constructor with parameters.
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
