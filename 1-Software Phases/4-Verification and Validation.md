# Verification & Validation

****

* Error & Fault & Failure

  * Error (过失)

    Cause of a fault/bug, which is typically a <u>human error (人为过失)</u>

  * Fault / Bug (错误)

    <u>Incorrect</u> piece of <u>code</u>

  * Failure (故障)

    Observable <u>incorrect behavior of the program</u>

  (Human) Error   =>   (Code) Fault/Bug   =>   (Program) Failure

****

-> Check that **the software system meets its specification and fulfills its intended purpose**

## Verification   *(Did we build the system right?)*

-> GIven the description of the system that we derived from the previous requirement engineering, design and implementation phases, did we build a system that actually implements the specifications that we defined?

### Approaches

#### 1. Dynamic Verification (动态验证) / Testing ***

*<u>Dynamic</u> here means the tester <u>has to run the code</u>.*

Check out `Testing.md`

<br>

#### 2. Inspection / Review / Walkthrough

-> <u>A group of developers</u> sit together, <u>look at the code and try to identify defects</u>.

- Pros:
  - Systematic => Results are thorough
- **Cons:**
  - **Informal => Results are subjective depending on the specific inspectors**

<br>

#### 3. Static Verification (静态验证)

*In constract to dynamic verification, <u>static</u> here means the tester doe <u>NOT have to run the code</u>.*

-> A <u>complete consideration of the entire input domain</u>, and thus all the possible executions of the program

- Pros:

  - Complete

- **Cons:**

  - **Can generate false positives**

    -> *This is because static verification usually also redundantly consider some of the impossible behaviors of the program.*

<br>

#### 4. Formal Proofs (形式证明) (of Correctness)

-> Given the software specifications, <u>use sophiscated mathematical analysis on the specifications and the code, to **prove** that the program actually implemented the specifications</u>

* Pros:

  * Provide strong guarantees

    It can guarantee that the program is correct.

* **Cons:**

  * **Need a formal specification (a complete mathematical description) of the expected behavior of the program, which is rarely available**
  * **Complex + Expensive**

<br>

## Validation   *(Did we build the right system?)*

* Acceptance testing (验收测试)

  Make sure the system does what the customer wants it to do