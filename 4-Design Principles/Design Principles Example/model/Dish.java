package model;
import java.util.List;

/**
 * Dish class
 *
 * @author Ziang Lu
 */
public class Dish {

    /**
     * Dish price.
     */
    public static final double DISH_PRICE = 20.0;

    /**
     * Name of this dish.
     */
    private final String name;
    /**
     * Description of this dish.
     */
    private final String description;
    /**
     * List of ingredients in this dish.
     */
    private final List<String> ingredients;
    /**
     * Recipe of this dish.
     */
    private final String recipe;

    /**
     * Constructor with parameter.
     * @param name name of the dish
     * @param description description of the dish
     * @param ingredients ingredients in the dish
     * @param recipe recipe of the dish
     */
    public Dish(String name, String description, List<String> ingredients, String recipe) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }

    /**
     * Accessor of name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor of description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Accessor of ingredients.
     * @return ingredients
     */
    public List<String> getIngredients() {
        return ingredients;
    }

    /**
     * Accessor of recipe.
     * @return recipe
     */
    public String getRecipe() {
        return recipe;
    }

}
