# Testing

*Assumption: The behavior of the program with any other inputs is the consistent with the behavior shown with the tested input.*

## Pros and Cons

- Pros:

  - Doe not generate false positives

    -> When testing generates a failure, it must be a failure.

- **Cons:**

  - **Highly incomplete**

    **Can only consider a tiny fraction of the input domain**

<br>

## Granularity Levels

### Developer's Testing

* Unit Testing

* Integration Testing (集成测试)

  Test the <u>interaction among the differnet units/modules</u>

* System Testing (系统测试)

  Test the <u>sytem as a whole</u>

  * Functional testing (功能测试)

    Aims to verify the functionality provided by the system

  * Non-functional testing (非功能测试)

    Aims to verify the non-functional properties of the system, e.g., performance test (性能测试), load test (负载测试), robustness test (稳健性测试)

<br>

### Alpha Testing

-> Distribute the software to a set of users that are <u>internal to the organization</u>

*内部人员测试 (内测)*

<br>

### Beta Testing

-> Distribute the software to a <u>selected set of users outside of the organization</u>

<br>

## Techniques

### Black-box Testing (黑箱测试)

Consider the software as a closed box (black-box).

=> Based on the **specification of the software**, but **not look into the software and the code implementation**

* Pros:

  * Focus on the input domain

    Make sure that we cover the input domain, i.e., the important behaviors of the software

  * No need for the code

    => Early test design before implementation

  * Applicable at all granularity levels

* Cons:

Limitation:

* Since we don't look into the implementation, we cannot reveal failures due to implementation details.

<br>

### White-box Testing (白箱测试)

Look inside the box

=> Based on the **code implementation**, but **not look into the specification of the software**

Limitation:

* Since we don't look into the specification, we cannot reveal the failures of parts of the software that haven't been implemented.

=> Black-box and white-box testings are really **complementary** techniques.