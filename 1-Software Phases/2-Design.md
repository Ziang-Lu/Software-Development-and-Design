# Design

-> Software requirements are analyzed in order to **produce an internal structure and organization of the system**.

=> Go from a high-level view of the system, to a low-level view of the system

****

**Software Architecture (SWA)**

- **Definition**:

  A set of <u>principle design decisions</u> (architectural design decisions) about the system

  <u>Blueprint of a software system</u>, encompassing:

  - Structure
  - Behavior
  - Interactions within the system
  - Non-functional properties

- Classification:

  - Prescriptive SWA

    Capture the design decisions that are made prior to the software construction

    *根据design => 得到SWA*

  - Descriptive SWA

    Describe how the system has actually been built

    *根据实际存在的架构 => 抽象出SWA*

  These two often diverge as time goes by, resulting in <u>architecture drift (架构偏移)</u>, which introduces <u>orthogonal</u> design decisions, and <u>architecture erosion (架构侵蚀)</u>, which introduce <u>violated</u> design decisions.

- **Architectural Elements (架构元素)**:

  - Software <u>components</u> (软件部件)

    A software component is an architectural entity that

    - <u>encapsulates a subset of the system's functionality and/or data</u>
    - <u>restricts access to that subset via an explicitly defined interface</u>

    *Blocks in UML class diagrams*

  - Software <u>connectors</u> (软件连接件)

    A software connector is an architectural entity that <u>affects and regulates interactions among components</u>.

    *Connecting lines in UML class diagrams*

  => Together, they form an **architectural configuration** (架构形态), which is <u>a set of specific associations between the components and connectors</u> of the SWA.

<br>

Example architectures:

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/1-Software%20Phases/Napster_architecture.png?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/1-Software%20Phases/Skype_architecture.png?raw=true">

<img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/1-Software%20Phases/Skype_architecture_abnormal.png?raw=true">

****

<br>

Design activities (设计活动) and their corresponding design products (设计产品):

| Design Activities                        | Design Product                         |
| ---------------------------------------- | -------------------------------------- |
| 1. Architecture Design                   | System Structure                       |
| 2. Abstract Specification (抽象规格说明) | Software Specification (软件规格说明)  |
| 3. Interface Design (接口设计)           | Interface Specification (接口规格说明) |
| 4. Component Design (部件设计)           | Component Specification (部件规格说明) |
| 5. Data Structure                        | Data Structure Specification           |
| 6. Algorithm Design                      | Algorithm Specification                |

