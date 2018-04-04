package model;

public class Host extends FrontOfHouseEmployee {

    /**
     * String prefix of Host.
     */
    private static final String PREFIX = "HOST - ";

    @Override
    protected String getPrefix() {
        return PREFIX;
    }

}
