import java.util.ArrayList;
import java.util.List;

import model.Chef;
import model.Dish;
import model.Host;
import model.Order;
import model.Waiter;

public class Diner {

    /**
     * Host of this diner.
     */
    private static Host host;
    /**
     * Waiter of this diner.
     */
    private static Waiter waiter;
    /**
     * Chef of this diner.
     */
    private static Chef chef;

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Dish dish = generateTurkeyClubSandwich();
        host = new Host(dish);
        waiter = new Waiter(dish);
        chef = new Chef();

        for (int i = 0; i < 2; ++i) {
            System.out.println("Table " + (i + 1) + ":");
            tableRoutine();
            System.out.println();
        }
        chef.doDishes();
    }

    /**
     * Private helper method to generate a turkey club sandwich dish.
     * @return generated dish
     */
    private static Dish generateTurkeyClubSandwich() {
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("avocado");
        ingredients.add("sriracha");
        ingredients.add("cheddar cheese");
        ingredients.add("bread");
        ingredients.add("lettuce");
        ingredients.add("tomato");
        ingredients.add("turkey");
        ingredients.add("bacon");
        return new Dish("turkey club sandwich",
                "Our trendy sandwich has avocado, sriracha sauce, cheese, veggies, turkey and bacon.", ingredients,
                "\t1. Pour sriracha\n\t2. Spread avocado\n\t3. Stack meat\n\t4. Place veggies");
    }

    /**
     * Private helper method to follow the routines of a table.
     */
    private static void tableRoutine() {
        waiter.greet();
        waiter.describeDish();
        Order order = waiter.takeOrder();
        orderRoutine(order);
    }

    /**
     * Helper method to follow the routines of a order.
     * @param order given order
     */
    private static void orderRoutine(Order order) {
        chef.makeDish(order);
        waiter.deliverFood(order);
        waiter.takePayment(order);
    }

}
