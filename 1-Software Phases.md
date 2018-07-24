# Software Phases (软件阶段)

软件开发过程包含多个阶段.

## 1. Requirement Engineering (需求工程)

-> **Establish the needs** of stakeholders that are to be solved by software

1. **Elicitation (引出)**

   Collect requirements from stakeholders and other sources

2. **Requirements Analysis (需求分析)**

   Study and form a deep understanding of the collective requirements

3. **Requirement Specification (需求规格说明)**

   The collective requirements are suitably represented, organized and saved so that they can be shared.

4. **Validation**

   Make sure the collective requirements are complete, consistent and not redundant

5. **Management**

   Account for changes in the requirements during the lifecycle of the project

Superficially this looks like a linear process. However in reality, this is more of an **iterative** process.

<br>

## 2. Design

-> Software requirements are analyzed in order to **produce an internal structure and organization of the system**.

=> Go from a high-level view of the system, to a low-level view of the system

Design activities (设计活动) and their corresponding design products (设计产品):

1. **Architecture Design**

   => System structure

2. **Abstract Specification (抽象规格说明)**

   => Software specification (软件规格说明)

3. **Interface Design (接口设计)**

   => Interface specification (接口规格说明)

4. **Component Design (部件设计)**

   => Component specification (部件规格说明)

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

* Validation: Did we build the right system?

* Verification: Did we build the system right?

  GIven the description of the system that we derived from the previous requirement engineering and design phases, did we build a system that actually implements the specifications that we defined?

  * Unit testing (单元测试)

    ...

  * Integration testing (集成测试)

    Test the interaction between the differnet units

  * System testing (系统测试)

    Test the sytem as a whole

<br>

## 5. Maintenance

-> **Sustain the software product** as it evolves throughout its lifecycle

* Corrective Maintenence (故障检修)
  * In response to bug reports
* Perfective Maintenance (完善性维护)
  * In response to feature requests
* Adaptive Maintenance (适应性维护)
  * In response to environment changes