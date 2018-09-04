# UML Diagrams

## [Structural] Class Diagram (类图)

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/3-UML%20Diagrams/class_hierarchy.png?raw=true">

<br>

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/3-UML%20Diagrams/class_hierarchy_example.png?raw=true">

<br>

## [Structural] Associations (关联)

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/3-UML%20Diagrams/associations.png?raw=true">

***

**Types of associations:**

* **Aggregation (聚集):**

  Aggregation is a <u>specialized form of association</u> where <u>there is an ownership relationship between parent and child objects and child objects cannot belong to another parent object, but all objects have their own lifecycle</u>.

  *e.g., Department [Parent] & Instructor [Child]: There is an ownership relationship between departments and instructors and instructors in one department cannot belong to another department, but all the objects have their own lifecycle, so if we delete the department, the instructors will not be deleted.*

  *"I have an object which I've borrowed from someone else."*

  ```java
  import java.util.List;
  
  class Instructor {}
  
  public class Department() {
      private List<Instructor> instructors;
  }
  ```

* Composition (成分):

  Composition is also a <u>specialized form of association and is a strong type of aggregation</u> where <u>their is an ownership relationship between parent and child objects and child objects cannot belong to another parent object, but child objects do not have their own lifecycle, and if the parent object is deleted, all of its child objects will be automatically deleted</u>.

  *e.g.,  House [Parent] & Room [Child]: There is an ownership relationship between houses and rooms and rooms in one house cannot belong to another house, but rooms do not have their own lifecycle, so if we delete the house, all of its rooms will be automatically deleted.*

  *"I own an object and I am responsible for its lifetime."*

  ```java
  import java.util.ArrayList;
  import java.util.List;
  
  public class House {
      private static class Room {}
  
      private List<Room> myRooms = new ArrayList<>();
  }
  ```

* Dependency (依赖):

  Dependency is a <u>weaker form of relationship</u> and it indicates that <u>a class uses another class by parameter or by return type</u>.

  ```java
  class Program {}
  
  public class Programmer {
      public Program code() {}
  }
  ```

***

<br>

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/3-UML%20Diagrams/associations_example.png?raw=true">

<br>

## [Behavior] Sequence Diagram (序列图)

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/3-UML%20Diagrams/sequence_diagram.png?raw=true">

<br>

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/3-UML%20Diagrams/sequence_diagram_simple.png?raw=true">

<br>

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/3-UML%20Diagrams/sequence_diagram_loop.png?raw=true">

