# Design Patterns

-> Tried and true solutions to commonly encountered problems in OOD

### Classifications (by Purpose)

#### 1. Fundamental Patterns (基础模式)

#### 2. Creational Patterns (创建型模式)

-> **Support object creation**

*e.g., Factory Method Pattern (工厂方法模式) + Abstract Factory Pattern (抽象工厂模式), Lazy Initialization Pattern (惰性初始化模式), Singleton Pattern (单例模式)*

#### 3. Structural Patterns (结构型模式)

-> **Help compose objects and put objects together**

*e.g., Composition Pattern (复合模式)*

#### 4. Behavioral Patterns (行为型模式) 

-> **Help realize interactions among objects**

*e.g., Iterator Pattern (迭代器模式), Observer Pattern (观察者模式), Strategy Pattern (策略模式)*

#### 5. Concurrency Patterns (并发型模式)

-> **Supports concurrency**

<br>

## Factory Method Pattern (工厂方法模式) + Abstract Factory Pattern (抽象工厂模式)

**Applicability:**

- <u>The class can't anticipate the type of objects it must create</u>, i.e., the type of the object is unknown at compile time.

  *即当前class并不知道自己将创建的object的实际具体type是什么.*

- <u>The class wants its subclasses to specify the type of objects it creates.</u>

  *即当前class刻意想让其subclass来指定将创建什么实际具体type的object.*

- The class needs control over the creation of its objects.

  *e.g., when there is a limit on the number of objects that can be created*

<br>

=> Factory Method Pattern is a **creational pattern** that uses factory methods to deal with the problem of **creating objects without having to specify the exact class of the object that will be created**

This is done by calling a factory method — either specified in an interface and implemented by child classes, or implemented in a base class and optionally overriden by derived classes — rather than calling a constructor.

* The Factory Method Pattern describes how to solve such problems:
  * Define a separate operation (factory method) for creating an object
  * Create an object by calling a factory method
* This enables writing of subclasses to change the way an object is created (to redefine which class to instantiate).

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/1-Factory%20Method%20Pattern/factory_method_pattern.jpg?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/1-Factory%20Method%20Pattern/MazeGame-Room%20Example.png?raw=true">

<br>

## Lazy Initialization Pattern (惰性初始化模式)

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

<br>

## Singleton Pattern (单例模式)

=> SIngle Pattern is a **creational pattern** that combines factory method pattern and lazy initialization pattern.

<br>

## Composite Pattern (复合模式)

Problem: Many things in the world are **self-referential**, as in **they can contain themselves** in their inherent structure.

e.g., branches may contain branches and leaves, folders may contain folders and files...

-> Composite Pattern is a **structural pattern** that is an OO solution for a **hierarchical structure**.

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/4-Composite%20Pattern/composite_pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/4-Composite%20Pattern/Composite%20Pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/4-Composite%20Pattern/Topic-Lecture-Video%20Example.png?raw=true">

<br>

## Iterator Pattern (迭代器模式)

**Behavioral pattern**

Use Java **Iterable and Iterator** to iterate collections that are not built-in

<br>

## Observer Pattern (观察者模式)

-> Observer Pattern is a **behaviral pattern** that is an OO solution for **interaction between one object and one or more objects**

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/4-Observer%20Pattern/observer_pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/6-Observer%20Pattern/Observer%20Pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/6-Observer%20Pattern/Java_Observable_Observer.png?raw=true">

<br>

## Strategy Pattern (策略模式)

<br>

## Choosing a Pattern

1. Understand the design context
2. (Examine the pattern catalogue)
3. Identify and study related patterns
4. Apply suitable pattern