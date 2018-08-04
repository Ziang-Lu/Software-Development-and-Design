How should we <u>organize</u> the <u>software phases</u> into the software development process?

# Software Process Models (软件过程模型) / Software Lifecycle Model (软件生命周期模型)

Main functions:

* Determine the **order of the software activities** described in "Software Phases"
* Determine the **transition criteria for the software activities**, i.e., when we can go from one phase to another

## Waterfall Model (瀑布模型)

**[Procedural]**

-> **Follow the set of rigid steps**, i.e., strictly from requirement analysis all the way to system testing

* Pros:

  * Find errors early

* **Cons:**

  * **Not flexible**

    ***Normally, it is difficult to fully specify requirements at the beginning of a project.***

    => **Far from ideal for most real-world projects**

    **(太过于教条主义)**

*Example:*

*A control system for the airplane softwares*

*Reasons:*

*1. The domain and the requirements are well understood.*

*2. It's a system in which we don't expect requirements to change dramatically over time.*

*3. We want to be rigorous in this case.*

<br>

## Evolutionary Prototyping (演化原型)

**[Iterative/Incremental]**

-> **Start with an initial prototype, and evolve it based on the feedback from the customer**

* Phases:

  1. Initial concept

  2. Design and implement a prototype

     *Developers start by developing part of the system that they understand, instead of working on a whole system.*

  3. Refine the prototype until it's acceptable.  *(iterative process)*

     *The partial system is shown to the customer, and customer feedback is used to drive the next iteration: change the current features, or add new features, i.e., the prototype is improved or extended, respectively.*

  4. Complete and release the prototype

     *Finally, the customer agrees that the prototype is good enough.*

* Pros:   *(iterative process)*

  * Suitable for cases when not all requirements are well understood in the first place

  * Immediate feedback

    => The risk of implementing the wrong system is minimized.

* **Cons:**

  * **Difficult to plan in advance**
  * **Can become an excuse to develop working but not a high-quality product**

  **(太过于灵活)**

  **=> 与Waterfall Model是两个极端**

<br>

## Spiral Model (螺旋模型) ***

**[Iterative/Incremental, Risk-oritented]**

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/2-Software%20Process%20Models/spiral_model.png?raw=true">

* Pros:
  * Extensive risk analysis =>
    * Risk reduction
  * Iterative =>
    * Software is produced early. (=> prototypes) (=> Get early feedback from the customers)
    * Functionalities can be added later.
* Cons:
  * Highly dependent on risk analysis, which requires specific expertise, but has to be done right
  * Complex

<br>

## Unified Software Process (USP) (统一软件开发过程) ***

**[Iterative/Incremental]**

-> **Based on UML**

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/2-Software%20Process%20Models/unified_software_process.png?raw=true">

<br>

## Agile Software Process (敏捷软件过程) ***

**[Iterative/Incremental]**

-> **Sacrifice discipline a little bit, in order to be more flexible, and be more able to account for changes**, specifically changes in requirements


