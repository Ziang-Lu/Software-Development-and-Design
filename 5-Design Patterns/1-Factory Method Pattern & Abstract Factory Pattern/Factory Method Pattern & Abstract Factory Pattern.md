# Factory Method Pattern & Abstract Factory Pattern

**Applicability:**

- <u>The class can't anticipate the type of objects it must create</u>, i.e., the type of the object is unknown at compile time.

  *即当前class并不知道自己将创建的object的实际具体type是什么.*

- <u>The class wants its subclasses to specify the type of objects it creates.</u>

  *即当前class刻意想让其subclass来指定将创建什么实际具体type的object.*

- The class needs control over the creation of its objects.

  *e.g., when there is a limit on the number of objects that can be created*

<br>

=> Factory Method Pattern is a **creational pattern** that uses factory methods to deal with the problem of **creating objects without having to specify the exact class of the object that will be created**

This is done by calling a factory method — <u>either specified in an interface and implemented by child classes, or implemented in a base class and optionally overriden by derived classes</u> — rather than calling a constructor.

*(=> Abstract Factory Pattern)*

- The Factory Method Pattern describes how to solve such problems:
  - Define a separate operation (factory method) for creating an object
  - Create an object by calling a factory method
- This enables writing of subclasses to change the way an object is created (to redefine which class to instantiate).

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/1-Factory%20Method%20Pattern%20&%20Abstract%20Factory%20Pattern/factory_method_pattern.jpg?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/1-Factory%20Method%20Pattern%20&%20Abstract%20Factory%20Pattern/MazeGame-Room%20Example.png?raw=true">

