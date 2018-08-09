How should we <u>organize</u> the <u>software phases</u> into the software development process?

# Software Process Models (软件过程模型) / Software Lifecycle Model (软件生命周期模型)

Main functions:

* Determine the **order of the software activities** described in "Software Phases"
* Determine the **transition criteria (转换准则) for the software activities**, i.e., when we can go from one phase to another

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

### Distinguishing Aspects

Use cases define the function of the system, whereas architecture defines the form of the system in order to provide that function.

* **Use-case driven (用例驱动)**

  Use cases <u>capture the interaction between users and the system</u>, and answered the question "What is the system supposed to do <u>for each user</u>?"

  *(针对不同use case)*

* **Architecture-centric (以架构为中心)**

  * **Based on UML**

  1. Create a rough outline (general structure) of the system <u>independently of the functionality</u>

     *Model aspects such as the platform that the system will run on, the overall architecture style, ...*

  2. According to the <u>key use cases</u>, identify and define the main subsystems

  3. According to <u>additional use cases</u>, refine the architecture   *(iterative process)*

  Use-case driven development can also be reflected here.

* **Iterative/Incremental**

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/2-Software%20Process%20Models/usp_lifecycle.png?raw=true">

Each **cycle terminates** with a **production release**.

<br>

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/2-Software%20Process%20Models/unified_software_process.png?raw=true">

<br>

### Phases

#### 1. Inception phase (初始阶段)

Idea of the product   =>   <u>vision of the end product</u>

**Deliverables:**

* Vision document (远景文档)
  * Describes the general vision of the core project's requirements, key features, and main constraints
* Initial project glossary (项目术语表)
  - Describes the main terms used in the project and their meanings
* Initial use-case model (用例模型)
  * Includes an initial set of use cases, and then will be later refined
* Initial business case (业务案例)
  * Includes business context (业务环境) and success criteria (成功标准)
* Initial project plan
* Risk asessment document
  * Describes the main risks and the corresponding counter measures (对策)

#### 2. Elaboration phase (细化阶段)

**Activities:**

* Analyze the problem domain
* Refine the software architecture
* Refine the plan of activities and estimates of the resources
* Eliminate the highest risk elements, i.e., address the most critical use cases

**Deliverables:**

* Almost <u>complete</u> use-case model

  *Compare to the "initial" use-case model in Inception phase*

* Supplementary requirements (补充需求)

  -> All requirements that are not associated with the use-case model, including in particular the non-functional requirements

* Complete software architecture

* Lower-level design for the system

  * Design model
  * Test cases
  * Executable protypes

* <u>Revised</u> project plan

  *Compare to the "initial" project plan in Inception phase*

* <u>Updated</u> risk assessment document

  *Compare to the "initial" risk assessment document in Inception phase*

#### 3. Construction phase (开发阶段)

IP (ideas) development   =>   <u>Product development</u>

**Activities:**

* Develop all the features
* Test the features thoroughly

**Deliverables:**

* All the use cases have been realized, with <u>traceability information (追溯信息)</u>.
* Complete set of artifacts:
  * Design documents
  * Code implementation
  * Test cases
* Complete system tests results
* <u>Complete</u> software product integrated on the appropriate platforms   =>   *Beta release*

#### 4. Transition phase (移交阶段)

**Activities:**

* Check out `Software Phases/5-Maintenance`
* Start the next cycle

**Deliverables:**

* Complete project that is ready for deployment
* The product is actuall in use in the market.
* Plans for the next cycle

<br>

Note that the labels represents **iterations** within each phase:

1. Select some use cases to implement

2. According to the use cases and the architecture, create a design

3. Implement the design => Components

4. Verify the components against the use cases

5. <u>Release a product</u>

   *Represent the end of the iteration.*

<br>

## Agile Software Process (敏捷软件过程) ***

**[Iterative/Incremental]**

-> **Sacrifice discipline a little bit, in order to be more flexible, and be more able to account for changes**, specifically changes in requirements

### Test-Driven Development (TDD) (测试驱动开发)

(在收集完requirements之后)

#### 1. Test cases according to the requirements

Since we haven't implement of the system, these <u>tests must fail</u>.

#### 2. Code implementation to make the test cases pass

Since the <u>test cases represent requirements</u>, we have <u>just enough code implementation to satisfy the requirements</u>.

*Since this is just a raw and naive implementation, the structure of the code deteriorate over time because we keep adding pieces.*

#### 3. Refactoring to improve the code quality

*Then go back to Phase 1 to collect more requirements and turn them into new test cases.*

<br>

根据需求写test case => 写代码 => 重构 => 根据新需求写新test case => 写代码 => 重构 => ......

<br>

