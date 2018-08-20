# Prototype Pattern

### Applicability

* How can objects be created so that which objects to create can be specified at runtime?

  *即如何才能在runtime时再决定创建哪种具体类型的object*

  *类似于Factory Method Pattern + Abstract Factory Pattern*

* How can dynamically loaded classes be instantiated?

* Avoid the inherent cost of creating a new object in the standard way when it is prohibitively expensive for a given application

  *即正常用new创建object的成本过高以至于application中不允许使用*

<br>

### Definition & Explanation

-> Similar to Factory Method Pattern

Prototype Pattern is a **creational pattern** that **creates objects whose type is determined by a protytypical instance, which is cloned to produce new objects**.

*即由现有的某个prototype通过clone的方式创建新的object*

* The Prototype Pattern describes how to solve such problems:
  * Define a `Prototype` object that is able to return copies of itself
  * Create new objects by copying a `Prototype` object

<br>

### Benefits

* Avoid subclasses of an object creator in the client application

  *类似于Factory Method Pattern + Abstract Factory Pattern*

