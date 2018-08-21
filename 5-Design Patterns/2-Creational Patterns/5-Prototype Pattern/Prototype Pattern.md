# Prototype Pattern

### Applicability

* How can objects be created so that <u>which objects to create can be specified at runtime</u>?

  *即如何才能在runtime时再决定创建哪种具体类型的object*

* How can dynamically loaded classes be instantiated?

  i.e., <u>when there are numerous potential classes that you want to only use if needed at runtime</u>

* <u>Avoid the inherent cost of creating a new object in the standard way (using the `new` operator)</u>, when it is prohibitively expensive for a given application

  *即正常用new创建object的成本过高以至于application中无法承担*

<br>

### Definition & Explanation

-> Similar to Factory Method Pattern

Prototype Pattern is a **creational pattern** that **creates objects whose type is determined by a protytypical instance, which is cloned to produce new objects**.

*即由现有的某个prototype通过clone的方式创建新的object*

* The Prototype Pattern describes how to solve such problems:
  * Define a `Prototype` object that is able to return copies of itself
  * Create new objects by copying a `Prototype` object

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/2-Creational%20Patterns/5-Prototype%20Pattern/prototype_pattern.png?raw=true">



### Benefits

* Avoid subclasses of an object creator in the client application

  *类似于Factory Method Pattern + Abstract Factory Pattern*


***

* **Relationship with Factory Method Pattern + Abstract Factory Pattern**

  * There are cases when either prototype or abstract factory would be appropriate.

  * <u>At other times, they complement each other:</u>

    <u>Abstract factory might store a set of prototypes from which to clone and return product objects.</u>

* **Relationship with Singleton Pattern**

  * Similar to Singleton Pattern
  * However, Singleton Pattern keeps only one singleton instance, and return it every time an instance is requested. Instead, <u>Prototype Pattern also keeps only one prototype, but clones and returns a new instance every time an instance is requested.</u>

***

<br>

### Drawback

Requires to create prototypes before create other objects