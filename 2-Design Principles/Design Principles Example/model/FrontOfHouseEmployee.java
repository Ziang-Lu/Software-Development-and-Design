package model;

public abstract class FrontOfHouseEmployee {

    /**
     * Current order number.
     */
    protected static int currOrderNum = 100;

    /**
     * Dish instance.
     */
    protected Dish dish;

    /**
     * Constructor with parameter.
     * @param dish dish instance
     */
    public FrontOfHouseEmployee(Dish dish) {
        this.dish = dish;
    }

    /**
     * Greets the customers.
     */
    public void greet() {
        System.out.println("Hello and welcome to Busy's, the home of the " + dish.getName() +".");
    }

    /**
     * Describes the dish.
     */
    public void describeDish() {
        System.out.println(dish.getDescription());
    }

    /**
     * Delivers the given order
     * @param order given order
     * @return whether the delivery is successful
     */
    public boolean deliverFood(Order order) {
        if (!order.isPrepared()) {
            System.out.println("Sorry, but the order is not ready yet.");
            return false;
        }

        order.setServed();
        System.out.println(getPrefix() + "Delivered food");
        order.print();
        return true;
    }

    /**
     * Returns the prefix of this front-of-house employee.
     * @return prefix of this front-of-house employee
     */
    protected abstract String getPrefix();

}
