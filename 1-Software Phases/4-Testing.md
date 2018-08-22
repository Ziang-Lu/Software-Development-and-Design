# Testing

*Assumption: The <u>behavior of the program</u> with any other inputs is the <u>consistent</u> with the behavior shown with the tested input.*

## Pros and Cons

- Pros:

  - Does not generate false positives

    => When testing generates a failure, it must be a failure.

- **Cons:**

  - **Highly incomplete**

    **Can only consider a tiny fraction of the input domain**

<br>

## Granularity Levels

### Developer's Testing

* Unit testing

* Integration testing (集成测试)

  Test the <u>interaction among the differnet units/modules</u>

* System testing (系统测试)

  Test the <u>system as a whole</u>

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

<br>

#### 2. Pros & Cons

* Pros:

  * Focus on the input domain

    Make sure that we cover the input domain, i.e., the important behaviors of the software

  * No need for the code

    => Early test design before implementation

  * Applicable at all granularity levels

* Cons:

  * Since we don't look into the implementation, we cannot reveal failures due to implementation details.

<br>

#### 3. Systematic Approach

*即根据功能描述 -> 找可独立测试的feature -> 确定相关input -> 写test cases*

*且由于一次性找出所有的可独立测试的features<u>太不现实</u>, 这应该是一个iterative的过程.*

1. Start from **functional specification (功能规格说明)**

2. Identify **independent testable features**

3. identify the **relevant inputs** for each one of the independent testable features

   "Test data selection"

   <img src="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/1-Software%20Phases/test_data_selection.png?raw=true">

   * Exaustive testing (穷举测试)?

     -> Impossible in terms of time => 不现实

   * Random testing (随机测试)?

     -> 大海捞针 => 效果不好

   * <u>Partition testing (分割测试)</u>

     Due to the fact that though failures are <u>generally sparse</u>, they are <u>dense in some subdomains (partitions)</u>

     * Identify partitions

     * Select inputs from each partition

       => Errors tend to occur at the <u>boundary of the partitions</u>.

       => Select inputs at these boundaries

4. Derive **test case specifications (测试用例规格说明)**

   -> Defines how the test input values should be put together when actually testing the system

   * Simply combine the selected input values to actual test cases, and eliminate the meaningless and invalid ones

5. Generate **test cases** from the corresponding test case specifications

<br>

#### 4. Category-Partition Method (类别-分割方法) - A Specific Black-Box Testing Approach

1. Identify **independent testable features**

   *Same as the systematic approach*

2. Identify **categories**

   ***

   A <u>category</u> is the <u>characteristics of one input element</u>.

   ***

   => Identify characteristics that are meaningful and cover the main aspects of the input element

   e.g.,

   ```java
   public void split(String s, int size) {}
   ```

   * Category 1: Characteristics of `String s`
     * Characteristic: Length of the string
     * Characteristic: Contents of the string
   * Category 2: Characteristics of `int size`
     * Characteristic: Value of the integer

3. **Partition categories into choices**

   ***

   A <u>choice</u> is an <u>interesting case in a category</u>.

   ***

   e.g.,

   ```java
   public void split(String s, int size) {}
   ```

   - Category 1: Characteristics of `String s`
     - Characteristic: Length of the string
       - `length = 0`
       - `length = size - 1 `
       - `length = size`
       - `length = size + 1`
       - `length = 2 * size - 1`
       - ...
     - Characteristic: Contents of the string
       - Only whitespaces
       - Only special characters, like non-printable characters
       - ...
   - Category 2: Characteristics of `int size`
     - Characteristic: Value of the integer
       - `size = Integer.MIN_VALUE`
       - `size < 0`
       - `size = 0`
       - `size > 0`
       - `size = Integer.MAX_VALUE`

4. Identify **constraints among choices**

   => To eliminate the meaningless and invalid combinations of inputs

   *即识别出一些不合法的输入choice组合, 并排除掉他们*

5. Produce/Evaluate **test case specifications**

   * Can be <u>automated</u>

     i.e., Identify categories, then choices, and then add constraints   => (Automate, 有脚本或应用程序来处理)   Test frames

   * Produce <u>test frames (测试框架)</u>

     ***

     A test frame is a specification of a test. (Similar to test case specification).

     ***

     | Test Frame #36   |                                                 |
     | ---------------- | ----------------------------------------------- |
     | Input "String s" | length: size - 1<br>content: special characters |
     | Input "int size" | Value: > 0                                      |

6. Generate **test cases** from test case specifications

   * Simply <u>instantiate test frames, producing concrete test cases</u>

     | Test Case #36 | wvv         |
     | ------------- | ----------- |
     | s             | "ABCC!\n\t" |
     | size          | 9           |

     *(满足之前的test frame #36)*

<br>

### White-box Testing (白箱测试)

Look inside the box

=> Based on the **code implementation**, but **not look into the specification of the software**

Limitation:

* Since we don't look into the specification, we cannot reveal the failures of parts of the software that haven't been implemented.

=> Black-box and white-box testings are really **complementary** techniques.