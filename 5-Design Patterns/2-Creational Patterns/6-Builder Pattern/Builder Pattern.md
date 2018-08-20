# Builder Pattern

### Applicability

Creating and assembling the parts of a complex object directly within the class is inflexible. It commits

* How can a class (the same contruction process) create different representations of a complex object?
* How can a class that includes creating a complex object be simplified?

<br>

### Definition & Explanation

The Builder Pattern is a **creational pattern** that **separates the construction of a complex object from its representation**.

* Encapsulate creating and assembling the parts of a complex object in a separate `Builder` object
* When needed, delegate object creation to a `Builder` object instead of creating the objects directly.

<br>

### Benefits

<br>

### Drawbacks