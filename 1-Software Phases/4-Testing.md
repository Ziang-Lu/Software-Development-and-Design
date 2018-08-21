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

    Aims to verify the non-functional properties of the system

    * Configuration testing (配置测试)
    * Compatibility testing (兼容性测试)
    * Performance testing (性能测试),
    * Concurrency testing (并发测试)
    * Load testing (负载测试)
    * Robustness testing (稳健性测试)
    * Security testing (安全测试)
    * Reliability testing (可信赖度测试)
    * Recovery testing (故障恢复测试)
    * ...

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

#### 1. Definition & Explanation

Consider the software as a closed box (black-box)

=> Based on the **specification of the software**, but **not look into the software and the code implementation**

#### 2. Pros & Cons

* Pros:

  * Focus on the input domain

    Make sure that we cover the input domain, i.e., the important behaviors of the software

  * No need for the code

    => Early test design before implementation

  * Applicable at all granularity levels

* Cons:

  * Since we don't look into the implementation, we cannot reveal failures due to implementation details.

#### 3. Systematic Approach

*即根据功能描述 -> 找可独立测试的feature -> 确定测试的相关input -> 写test cases*

*且由于一次性找出所有的可独立测试的features太不现实, 这应该是一个iterative的过程.*

1. Start from <u>functional specification (功能规格说明)</u>

2. Identify <u>independent testable features</u>

3. identify the <u>relevant inputs</u> for each one of the independent testable features

   "Test data selection"

4. Derive <u>test case specifications (测试用例规格说明)</u>

   -> Descriptions of test cases

5. Generate <u>test cases</u> from the corresponding test case specifications

<br>

### White-box Testing (白箱测试)

Look inside the box

=> Based on the **code implementation**, but **not look into the specification of the software**

Limitation:

* Since we don't look into the specification, we cannot reveal the failures of parts of the software that haven't been implemented.

=> Black-box and white-box testings are really **complementary** techniques.