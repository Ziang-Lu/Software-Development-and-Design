# Builder Pattern

### Applicability

Problem: Creating and assembling the parts of a <u>complex</u> object directly within the class is inflexible.

It commits

* How can a class (the same contruction process) create different representations of a complex object?
* How can a class that includes creating a complex object be simplified?

<br>

### Definition & Explanation

The Builder Pattern is a **creational pattern** that **constructs complex objects made up from a bunch of its component objects, and meanwhile keeps the creation of these part objects to be independent from the main object**.

* Encapsulate creating and assembling <u>the parts of a complex object in a separate `Builder` object</u>
* When needed, <u>delegate object creation to a `Builder` object instead of creating the objects directly</u>.

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/2-Creational%20Patterns/6-Builder%20Pattern/phone_example.png?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/5-Design%20Patterns/2-Creational%20Patterns/6-Builder%20Pattern/robot_example.png?raw=true">

<br>

### Benefits

<br>

### Drawback

