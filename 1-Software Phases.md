# Software Phases (软件阶段)

## 1. Requirement Engineering (RE) (需求工程)

### Definition:

RE is a set of activities concerned with **identifying and communicating the purpose of a software-intensive system, and the context in which it will be used**.   *Designers and analysts need to know <u>where</u> and <u>how</u> the system will be used.*

### Activities:

***

* **Requirements**

  Focus on the <u>interaction between real-world and the software</u>

  Should be:

  * Simple (not compound)

    <u>Each requirement should express one specific piece of the functionality</u> that the system need to provide.

  * Testable

    There should not be ambiguous descriptions.

  Classification:

  * Functional requirements (功能性需求)   =>   *Functionality*

    -> Has well-defined satisfaction criteria (满意标准)

  * Non-functional requirements (非功能性需求)   =>   *Quality*

    *e.g., Security / Accuracy / Performance / Adaptability / Reusability / ……*

    -> Do not always has well-defined criteria

    => If not, need to refine them to be <u>verifiable</u>

***

1. **Elicitation (引出)**

   <u>Collect requirements</u> from stakeholders and other sources (anyone who might be affected by this software)

   * Techniques:

     * Background reading (背景阅读)

       Collect information by <u>reading documents</u>

       => Get some background before interviewing actual people

       *Problem: Written documentations may be out of sync and long-winded.*

     * Hard data sampling

       与background reading类似, 只不过取了sample来阅读

     * Interviews

       Can <u>collect a rich set of information</u>, because they allow for uncovering opinios as well as hard facts

       Can <u>probe in-depth</u> through follow-up questions

       *Problem: Require special skills + experience*

     * Surveys

       *Problems: (与interview的优点对应)*

       *Tend to severely constrain the information that the user can provide*   (缺乏rich)

       *Might miss opportunities to collect unforeseen relevant information*   (缺乏in-depth)

2. **Requirements Analysis (需求分析)**

   Study and form a <u>deep understanding</u> of the collective requirements

   * Analysis:

     * Requirement verification (需求验证)

       Check whether the requirements are <u>correct, complete, pertinent, consistent</u> ......

       *By correct, we mean whether the requirements accurately reflect the customer needs.*

     * Requirement validation (需求确认)

       Check whether requirements <u>really define the system that the stakeholders want</u>

       *本质上与requirement verification中的correctness类似*

     * Risk analysis (风险分析)

       Analyze the main risks

       => If some requirements are deemed to be too risky, this may result in changes in the requirements.

   * Prioritization

     * Mandatory ~
     * Nice-to-have ~
     * Superfluous ~

3. **Requirement Specification (需求规格说明)**

   The collective <u>requirements</u> are suitably <u>represented, organized</u> and saved so that they can be shared.

4. **Validation**

   <u>Make sure</u> the collective <u>requirements</u> are <u>complete, consistent and not redundant</u>

5. **Requirement Management (需求管理)**

   <u>Account for changes</u> in the requirements during the lifecycle of the project

Superficially this looks like a linear process. However in reality, this is more of an **iterative** process.

<br>

=> **Software Requirement Specification (SRS) (软件需求说明)**

* Introduction
  * Context + Purpose/Objective of the software
* User requirements
* System requirements
  * Functional + Non-functional

<br>

## 2. Design

-> Software requirements are analyzed in order to **produce an internal structure and organization of the system**.

=> Go from a high-level view of the system, to a low-level view of the system

Design activities (设计活动) and their corresponding design products (设计产品):

1. **Architecture Design**

   => System structure

2. **Abstract Specification (抽象说明)**

   => Software specification (软件说明)

3. **Interface Design (接口设计)**

   => Interface specification (接口说明)

4. **Component Design (部件设计)**

   => Component specification (部件说明)

5. **Data Structure**

   => Data structure specification

6. **Algorithm Design**

   => Algorithm specification

<br>

## 3. Implementation

-> Realize the software system and **create an actual software system**

Four principles:

* Reduction of Complexity (减少复杂性)

* Anticipation of Diversity

  => Software construction might change in various ways over time.

* Structuring for Validation / Design for Testability (可测性设计)

* Use of (External) Standards

<br>

## 4. Validation and Verification

-> Check that **the software system meets its specification and fulfills its intended purpose**

* Verification: Did we build the system right?

  GIven the description of the system that we derived from the previous requirement engineering and design phases, did we build a system that actually implements the specifications that we defined?

  * Unit testing (单元测试)

    ...

  * Integration testing (集成测试)

    Test the interaction between the differnet units

  * System testing (系统测试)

    Test the sytem as a whole

* Validation: Did we build the right system?

<br>

## 5. Maintenance

-> **Sustain the software product** as it evolves throughout its lifecycle

* Corrective Maintenence (故障检修)
  * In response to bug reports
* Perfective Maintenance (完善性维护)
  * In response to feature requests
* Adaptive Maintenance (适应性维护)
  * In response to environment changes