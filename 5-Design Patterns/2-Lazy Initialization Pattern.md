# Lazy Initialization Pattern

=> Lazy Initialization Pattern is a **creational pattern** of **delaying the initialization of objects until the first time it is needed**.

```java
import java.util.HashMap;
import java.util.Map;

enum FruitType {
    none, apple, banana
}

class Fruit {
    private static Map<FruitType, Fruit> fruits = new HashMap<>();

    private Fruit(FruitType type) {}

    static Fruit getFruitByType(FruitType type) {
        Fruit fruit = fruits.getOrDefault(type, new Fruit(type));
        fruits.put(type, fruit);
        return fruit;
    }

    static void showAll() {
        if (!fruits.isEmpty()) {
            System.out.println("Number of fruit instances made: " + fruits.size());
            for (FruitType type: fruits.keySet()) {
                // Capitalize the first letter of the fruit type
                String typeName = type.toString();
                System.out.println(Character.toUpperCase(typeName.charAt(0)) + typeName.substring(1));
            }
            System.out.println();
        }
    }
}

public class LazyInitialization {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Fruit.getFruitByType(FruitType.apple);
        Fruit.showAll();
        Fruit.getFruitByType(FruitType.banana);
        Fruit.showAll();
        Fruit.getFruitByType(FruitType.apple);
        Fruit.showAll();

        /*
         * Output:
         * Number of fruit instances made: 1
         * Apple
         *
         * Number of fruit instances made: 2
         * Apple
         * Banana
         *
         * Number of fruit instances made: 2
         * Apple
         * Banana
         */
    }

}

```

