# Design Patterns

-> Tried and true solutions to commonly encountered problems in OOD

### Classifications (by Purpose)

#### 1. Fundamental Patterns (基础模式)

#### 2. Creational Patterns (创建型模式)

-> Support object creation

*e.g., Factory Method Pattern (工厂方法模式)*

#### 3. Structural Patterns (结构型模式)

-> Help compose objects and put objects together

*e.g., Composition Pattern (复合模式)*

#### 4. Behavioral Patterns (行为型模式) 

-> Realize interactions among objects

*e.g., Iterator Pattern (迭代器模式), Observer Pattern (观察者模式).*

#### 5. Concurrency Patterns (并发型模式)

-> Supports concurrency

<br>

## Factory Method Pattern (工厂方法模式)

A **creational pattern** that uses factory methods to deal with the problem of **creating objects without having to specify the exact class of the object that will be created**.

This is done by calling a factory method — either specified in an interface and implemented by child classes, or implemented in a base class and optionally overriden by derived classes — rather than calling a constructor.

* The Factory Method design pattern describes how to solve such problems:
  * Define a separate operation (factory method) for creating an object
  * Create an object by calling a factory method
* This enables writing of subclasses to change the way an object is created (to redefine which class to instantiate).

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/1-Factory%20Method%20Pattern/factory_method_pattern.jpg?raw=true">

**Applicability:**

* The class can't anticipate the type of objects it must create.

<br>

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/1-Factory%20Method%20Pattern/MazeGame-Room%20Example.png?raw=true">

<br>

## Composite Pattern (复合模式)

Problem: Many things in the world are **self-referential**, as in **they can contain themselves** in their inherent structure.

e.g., branches may contain branches and leaves, folders may contain folders and files...

-> Composite pattern is a **structural pattern** that is an OO solution for a **hierarchical structure**.

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/2-Composite%20Pattern/composite_pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/2-Composite%20Pattern/Composite%20Pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/2-Composite%20Pattern/Topic-Lecture-Video%20Example.png?raw=true">

<br>

## Iterator Pattern (迭代器模式)

**Behavioral pattern**

Use Java **Iterable and Iterator** to iterate collections that are not built-in

<br>

## Observer Pattern (观察者模式)

-> A **behaviral pattern** that is an OO solution for **interaction between one object and one or more objects**

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/4-Observer%20Pattern/observer_pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/4-Observer%20Pattern/Observer%20Pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/4-Observer%20Pattern/Java_Observable_Observer.png?raw=true">

