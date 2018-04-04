package model;

public class Host extends FrontOfHouseEmployee {

    /**
     * String prefix of Host.
     */
    private static final String PREFIX = "HOST - ";

    /**
     * Constructor with parameter.
     * @param dish dish instance
     */
    public Host(Dish dish) {
        super(dish);
    }

    @Override
    protected String getPrefix() {
        return PREFIX;
    }

}
