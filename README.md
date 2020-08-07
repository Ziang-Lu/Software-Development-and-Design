# Software Development and Design

This repo takes aspects regarding software development and design notes from:

* **Software Development Process** by *Georgia Tech* on Udacity
* **Software Construction** by *University of British Columbia* on edX

Plus, this repo also notes some development aspects, like testing and dev & ops.

## Software Phases

1. <a href="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/1-Software%20Phases/1-Requirement%20Engineering.md">Requirement Engineering (需求工程)</a>
2. <a href="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/1-Software%20Phases/2-Design.md">Design</a>
3. <a href="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/1-Software%20Phases/3-Implementation.md">Implementation</a>
4. <a href="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/1-Software%20Phases/4-Verification%20and%20Validation.md">Validation and Verification</a>
5. <a href="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/1-Software%20Phases/5-Maintenance.md">Maintenance</a>

<br>

## Software Process Models

* Waterfall Model (瀑布模型)
* Evolutionary Prototyping (进化原型)
* Spiral Model (螺旋模型)
* Rational Unified Process (RUP) / Unified Software Process (USP) (统一软件开发) ***
* Agile Software Process (敏捷软件过程) ***

***: Popularly used

<br>

## UML Diagrams

1. Class Diagram (类图)
2. Associations (关联)
3. Sequence Diagram (序列图)

<br>

## Design Principles

- Single Responsibility Principle (SRP) (单一功能原则)
- Interface Segregation Principle (ISP) (接口分离原则)
- Liskov Substitution Principle (LSP) (里氏代换原则)
- Open-Closed Principle (开闭原则)
- Dependency Inversion (依赖反转原则)

<br>

## Logging

Check out `Logging/logging_demo.py` and `Logging/glog_demo.py`

<br>

## Testing

|        | Unit Testing            | Code Coverage (by Test Cases)                                | Profiling                                                    |
| ------ | ----------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Python | `unittest`<br/>`pytest` | <a href="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/Testing/code_coverage/Python%20Code%20Coverage.md">Overview</a><br/>`coverage`<br/>`pytest-cov` | <a href="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/Testing/profiling/Python%20Profiling.md">Overview</a><br/>`time`<br/>`timeit`<br/>`cProfile` (+ `snakeviz`)<br/>`line_profiler`<br/>`statprof`<br/>`yappi` |

<br>

## License

This repo is distributed under the <a href="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/LICENSE">MIT license</a>.
