public abstract class Prototype implements Cloneable {

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

}
