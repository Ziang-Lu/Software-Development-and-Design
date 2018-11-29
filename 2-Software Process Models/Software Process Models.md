How should we <u>organize</u> the <u>software phases</u> into the software development process?

# Software Process Models (软件过程模型) / Software Lifecycle Model (软件生命周期模型)

*软件过程模型是软件开发全部过程、活动和任务的<u>结构框架</u>. 它能直观表达软件开发的全过程, 明确规定要完成的主要活动、任务和<u>开发策略</u>.*

Main functions:

* Determine the **order of the software activities** described in "Software Phases"
* Determine the **transition criteria (转换准则) for the software activities**, i.e., when we can go from one phase to another

<br>

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

  3. Refine the prototype until it's acceptable.  *(Iterative process)*

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

  3. According to <u>additional use cases</u>, refine the architecture   *(Iterative process)*

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

## Agile Software Process (敏捷软件过程) / Test-Driven Development (TDD) (测试驱动开发) ***

**[Iterative/Incremental]**

-> **Sacrifice discipline a little bit, in order to be more flexible, and be more able to account for changes**, specifically changes in requirements

### 1. Overview

#### Principles

- **Expectation that requirements will change**

- Customer involvement

  -> To get customer <u>feedback for requirement change</u> and <u>drive the corresponding code modification</u>

- Focus on the code

- **Simplicity: Simple design, simple code**

  -> *Live for today without worrying too much about the future*

- Focus on <u>people</u>

  -> Value people over process

  => Promote <u>communication</u>

#### General Workflow

(在收集完requirements之后)

1. **Test cases according to the requirements**

   Since we haven't implemented the system, these <u>tests must fail</u>.

2. **Code implementation to make the test cases pass**

   Since the <u>test cases represent requirements</u>, we have <u>just enough code implementation</u> to satisfy the requirements.

   *Since this is just a raw and naive implementation, the structure of the code deteriorate over time because we keep adding pieces.*

3. **Refactor to improve the code quality**

   *Then go back to Phase 1 to collect more requirements and turn them into new test cases.*

**根据需求写test case => 写代码 => 重构 => 根据新需求写新test case => 写代码 => 重构 => ……**

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/2-Software%20Process%20Models/customer_value_vs_time.png?raw=true">

<br>

### 2. (Specific) Agile Method - Extreme Programming (XP) (极限编程)

#### Definition

XP is a **lightweight methodology** for small to medium sized teams developing software in the face of **vague or rapidly changing requirements**.

=> <u>XP is all about changing and adapting.</u>

#### Practices

* **Incremental planning (增量式计划)**

  1. Select user stories for this release
  2. Break the stories into specific development tasks
  3. Plan this release
  4. Develop / Integrate / Test the code for this release   *(Iterative process)*
  5. Release the software
  6. Evaluate the software system (from developers and customers feedback)
  7. (Iteration)

  *(基本上与上面的general workflow差不多.)*

* **Test-first development (测试优先开发)**

  <u>Any program feature without an automatic test simply shouldn't exist.</u>

  <u>=> If you need a feature, you need to first write a test for it.</u>

  *(基本上与上面的general workflow中所描述的差不多, 只是可能会更严格: 即如果要开发某个feature, 一定要先为其写unit test, 再去实现.)*

* **Small releases (小型发布)**  *(-> 对应principle里的Customer involvement)*

  Instead of having a big release at the end of a long development cycle, we try to <u>release very often</u>.

  * <u>Reduce risks</u>   *(If we are going down the wrong path, we'll know right away.)*

  * <u>Deliver real business value on a very short cycle</u>, which in turn <u>increases our customer confidence</u>

  * <u>Produce a sense of accomplishment</u> for the developers

* **Simple design**   *(-> 对应principle里的Simplicity)*

  <u>Just enough to meet the requirements</u>, to get our system to work

* **Refactoring**

* **Pair programming (结对编程)**   *(-> 对应principle里的focus on people (communication))*

  <u>All production code</u> is written with <u>two developers looking at one machine</u>.

  -> The <u>two developers play different roles at different times</u>: the two developers <u>alternate in the role of programming and strategizing</u>.

  * Strategizing: Looking at the code that is being written, thinking whether it would work, whether the code can be made simpler, more efficient, more maintainable

* **Continuous integration (连续集成)**

  When we <u>modify or add new code to the codebase</u>, we <u>integrate and test every few hours, or at most a day</u>.

  <img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/2-Software%20Process%20Models/continuous_integration.png?raw=true" width="500px">

