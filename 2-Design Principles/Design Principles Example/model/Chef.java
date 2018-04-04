package model;

public class Chef {

    /**
     * String prefix of Chef.
     */
    private static final String PREFIX = "Chef - ";

    /**
     * Current order.
     */
    private Order currOrder;

    /**
     * Makes the dish in the given order
     * @param order given order
     */
    public void makeDish(Order order) {
        assert(!order.isPrepared());
        currOrder = order;
        prepareIngredients();
        followRecipe();
        cookFood();
        plate(order);
    }

    /**
     * Prepares the ingredients of the dish in the current order.
     */
    private void prepareIngredients() {
        System.out.println(PREFIX + currOrder.getDishIngredients());
    }

    /**
     * Follows the recipe of the dish in the current order.
     */
    private void followRecipe() {
        System.out.println(PREFIX + currOrder.getDishRecipe());
    }

    /**
     * Cooks the dish in the current order.
     */
    private void cookFood() {
        System.out.println(PREFIX + "Grilling sandwich...");
    }

    /**
     * Plates the dish in the current order.
     * @param order
     */
    private void plate(Order order) {
        order.setPrepared();
        System.out.println(PREFIX + "Plated order: ");
        order.print();
    }

    /**
     * Do the dishes.
     */
    public void doDishes() {
        System.out.println(PREFIX + "Cleaning, scrubbling...");
        System.out.println("Dishes done.");
    }

}
