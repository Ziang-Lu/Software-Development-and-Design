package prototype;

/**
 * Concrete Circle class.
 *
 * @author Ziang Lu
 */
public class Circle extends Shape {

    /**
     * Default constructor.
     */
    public Circle() {
        super("Circle");
    }

    @Override
    public void draw() {
        System.out.println("In Circle.draw() method");
    }

}
