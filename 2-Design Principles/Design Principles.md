# Design Principles

## Single Responsibility Principle (单一功能原则)

* **Each class** should be centered around **one cohesive concept**.

* When adding new functionality, consider into which class it would best fit.

* If, over time, a class seems like it has more than one responsibility, it can be split into two separate classes.

  A sympton of having two responsibilities is having multiple clusters of methods, with each cluster referring to their own data within the class. Each cluster may represent its own responsibility, and may be best separated into its own class.

## Liskov Substitution Principle (LSP) (里氏代换原则)

* For a subclass to be substitutable for its superclass, the **subclass cannot break the expectations** that a user **of the superclass** would have.

* The **preconditions of a subclass's behavior (methods) cannot be strengthened**, meaning that a sub-method cannot accept a narrower range of inputs than the original method.

* The **postconditions of a sub-method cannot be weakened**, meaning that the sub-method cannot have a broader range of effect than the original method.

  Thus, it cannot reduce the service it provides, and cannot produce effects not produced in the superclass.

## Open-Closed Principle (开闭原则)

## Dependency Inversion (依赖反转原则)

## Interface Segregation (接口分离原则)

