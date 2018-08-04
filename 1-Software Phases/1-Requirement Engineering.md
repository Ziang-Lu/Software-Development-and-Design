# Requirement Engineering (RE) (需求工程)

## Definition

RE is a set of activities concerned with **identifying and communicating the purpose of a software-intensive system, and the context in which it will be used**.   *Designers and analysts need to know <u>where</u> and <u>how</u> the system will be used.

## Activities

****

**Requirements**

Focus on the <u>interaction between real-world and the software</u>

Should be:

- Simple (not compound)

  <u>Each requirement should express one specific piece of the functionality</u> that the system need to provide.

- Testable

  There should not be ambiguous descriptions.

Classification:

- Functional requirements (功能性需求)   =>   *Functionality*

  -> Has well-defined satisfaction criteria (满意标准)

- Non-functional requirements (非功能性需求)   =>   *Quality*

  *e.g., Security / Accuracy / Performance / Adaptability / Reusability / ……*

  -> Do not always has well-defined criteria

  => If not, need to refine them to be <u>verifiable</u>

****

### 1. Elicitation

**Collect requirements** from stakeholders and other sources (anyone who might be affected by this software)

- Techniques:

  - Background reading (背景阅读)

    Collect information by <u>reading documents</u>

    => Get some background before interviewing actual people

    *Problem: Written documentations may be out of sync and long-winded.*

  - Hard data sampling

    *与background reading类似, 只不过取了sample来阅读*

  - Interviews

    Can <u>collect a rich set of information</u>, because they allow for uncovering opinios as well as hard facts

    Can <u>probe in-depth</u> through follow-up questions

    *Problem: Require special skills + experience*

  - Surveys

    *Problems: (与interview的优点对应)*

    *Tend to severely constrain the information that the user can provide*   (缺乏rich)

    *Might miss opportunities to collect unforeseen relevant information*   (缺乏in-depth)

### 2. Requirement Analysis (需求分析)

Study and form a **deep understanding** of the collective requirements

- Analysis:

  - Requirement verification (需求验证)

    Check whether the requirements are <u>correct, complete, pertinent, consistent</u> ......

    *By correct, we mean whether the requirements accurately reflect the customer needs.*

  - Requirement validation (需求确认)

    Check whether requirements <u>really define the system that the stakeholders want</u>

    *本质上与requirement verification中的correctness类似*

  - Risk analysis (风险分析)

    Analyze the main risks

    => If some requirements are deemed to be too risky, this may result in changes in the requirements.

- Prioritization

  - Mandatory ~
  - Nice-to-have ~
  - Superfluous ~

### 3. Requirement Specification (需求规格说明)

The collective **requirements** are suitably **represented, organized** and saved so that they can be shared.

### 4. Validation

**Make sure** the collective **requirements** are **complete, consistent and not redundant**

### 5. Requirement Management (需求管理)

**Account for changes** in the requirements during the lifecycle of the project

### Superficially this looks like a linear process. However in reality, this is more of an iterative process.

<br>

=> **Software Requirement Specification (SRS) (软件需求规格说明)**

- Introduction

  - Context + Purpose/Objective of the software

- User requirements

  General + non-technical, 给user看的

- System requirements

  Detailed + technical, 给developer看的

  - Functional + Non-functional