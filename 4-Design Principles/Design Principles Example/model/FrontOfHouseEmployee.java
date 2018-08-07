package model;

/**
 * Abstract front-of-house employee class.
 *
 * @author Ziang Lu
 */
public abstract class FrontOfHouseEmployee {

    /**
     * Greets the customers.
     */
    public void greet(Dish dish) {
        System.out.println("Hello and welcome to Busy's, the home of the " + dish.getName() +".");
    }

    /**
     * Describes the dish.
     */
    public void describeDish(Dish dish) {
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
