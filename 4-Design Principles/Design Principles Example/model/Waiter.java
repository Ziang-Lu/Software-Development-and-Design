package model;
import java.util.ArrayList;
import java.util.List;

/**
 * Waiter class.
 *
 * @author Ziang Lu
 */
public class Waiter extends FrontOfHouseEmployee {

    /**
     * String prefix of Waiter.
     */
    private static final String PREFIX = "WAITER - ";

    /**
     * List of orders.
     */
    private final List<Order> orders;
    /**
     * Current cash.
     */
    private double cash;

    /**
     * Default constructor.
     */
    public Waiter() {
        orders = new ArrayList<>();
        cash = 0.0;
    }

    /**
     * Accessor of orders.
     * @return orders.
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Accessor of cash.
     * @return
     */
    public double getCash() {
        return cash;
    }

    /**
     * Takes a new order or the given dish and returns it.
     * @param dish given dish
     * @return new order
     */
    public Order takeOrder(Dish dish) {
        System.out.println(getPrefix() + "Taking order...");
        Order o = new Order(dish);
        orders.add(o);
        System.out.println("Order taken: ");
        o.print();
        return o;
    }

    /**
     * Takes the payment of the given order
     * @param order given order
     * @return whether the payment is successful
     */
    public boolean takePayment(Order order) {
        if (!order.isServed()) {
            System.out.println("Sorry, but the order hasn't been served yet.");
            return false;
        }

        System.out.println(getPrefix() + "Taking payment...");
        orders.remove(order);
        cash += Dish.DISH_PRICE;
        System.out.println("Order paid: ");
        order.print();
        System.out.println("Thanks for visiting Busy's Diner!");
        return true;
    }

    @Override
    protected String getPrefix() {
        return PREFIX;
    }

}
