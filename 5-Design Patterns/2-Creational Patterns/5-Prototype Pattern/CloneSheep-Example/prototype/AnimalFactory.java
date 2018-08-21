package prototype;

/**
 * AnimalFactory class that clones abstract animals.
 *
 * @author Ziang Lu
 */
public class AnimalFactory {

    /**
     * Clones the given animal prototype and stores it in its own location in
     * memory.
     * @param prototype animal prototype to clone
     * @return cloned animal
     * @throws CloneNotSupportedException if AnimalPrototype is not cloneable
     */
    public AnimalPrototype getClone(AnimalPrototype prototype) throws CloneNotSupportedException {
        return prototype.clone();
    }

}
