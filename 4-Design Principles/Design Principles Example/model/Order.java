package model;
import java.util.List;

public class Order {

    /**
     * Current order number.
     */
    protected static int currOrderNum = 100;

    /**
     * Order number.
     */
    private final int num;
    /**
     * Dish in this order.
     */
    private final Dish dish;
    /**
     * Whether this order is prepared.
     */
    private boolean prepared;
    /**
     * Whether this order has been served.
     */
    private boolean served;

    /**
     * Constructor with parameter.
     * @param orderNum order number
     * @param dish dish in the order
     */
    public Order(Dish dish) {
        ++currOrderNum;
        num = currOrderNum;
        this.dish = dish;
        prepared = false;
        served = false;
    }

    /**
     * Returns the ingredients of the dish in this order.
     * @return ingredients of the dish in this order
     */
    public List<String> getDishIngredients() {
        return dish.getIngredients();
    }

    /**
     * Returns the recipe of the dish in this order.
     * @return recipe of the dish in this order
     */
    public String getDishRecipe() {
        return dish.getRecipe();
    }

    /**
     * Accessor of prepared.
     * @return prepared
     */
    public boolean isPrepared() {
        return prepared;
    }

    /**
     * Accessor of served.
     * @return served
     */
    public boolean isServed() {
        return served;
    }

    /**
     * Sets this order to prepared.
     */
    public void setPrepared() {
        prepared = true;
    }

    /**
     * Sets this order to served.
     */
    public void setServed() {
        served = true;
    }

    /**
     * Prints this order.
     */
    public void print() {
        System.out.print("Order #" + num + " -> ");
        if (prepared) {
            System.out.print("prepared");
        } else {
            System.out.print("not prepared");
        }
        System.out.print(", ");
        if (served) {
            System.out.println("served");
        } else {
            System.out.println("not served");
        }
    }

}
