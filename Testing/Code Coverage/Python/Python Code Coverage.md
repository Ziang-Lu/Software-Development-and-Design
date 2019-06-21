# Python Code Coverage (by Test Cases)

## `coverage`

### Installation

```bash
> pip3 install coverage
```

### Usage

***

Check out https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/1-Software%20Phases/4-Testing.md for <u>various coverage criteria</u>:

* Statement Coverage
* Branch Coverage

***

* **Statement Coverage**

  ```bash
  > coverage3 run script.py
  ```

* **Branch Coverage**

  ```bash
  > coverage3 run --branch script.py
  ```

**Specify / Omit the source files:**

Use `--source`, `--include`, `--omit` command-line options

**Output the report to the terminal:**

```bash
> coverage3 report -m --fail-under=0.8
# -m will show the line numbers of the codes that are not covered
# --fail-under=MIN specifies that if the total coverage is < MIN, exit with a status of 2
```

**Generate a `htmlcov/` folder, which contains reports in html format:**

```bash
> coverage3 html --fail-under=0.8 --title="Coverage Result"
```

**Exclude reporting on some code:**

*<u>Excluded code is executed as usual,  and its execution is recorded in the coverage data as usual. However, when producing reports, `coverage.py` excludes it from the list of missing code.</u>*

```python
debug = False

a = my_func1()
if debug:  # pragma: no cover
    msg = 'bla bla'
    log_message(msg, a)
b = my_func2()
# Note that "# pragma: no cover" will exclude the entire clause, function or class definition
```

<br>

## `pytest-cov`

Prerequisite: <a href="https://github.com/Ziang-Lu/Software-Development-and-Design/blob/master/Testing/Unit%20Test/pytest%20for%20Python/pytest%20for%20Python.md">Unit testing by `pytest`</a>

### Installation

```bash
> pip3 install pytest-cov
```

### Usage

* **Statement Coverage**

  ```bash
  > pytest --cov=myproj tests/
  ```

  Folder to test coverage against: `myproj/`

  Folder containing the tests (`test_*.py` and `*_test.py`): `tests/`

* **Branch Coverage**

  ```bash
  > pytest --cov-branch --cov=myproj tests/
  ```

**Output the report to the terminal:**

```bash
> pytest --cov-report term-missing:skip-covered --cov=myproj tests/
# --cov-report term-missing will show the line numbers of the codes that are not covered
# :skip-covered will skip the files with complete coverage
```

**Generate a `htmlcov/` folder, which contains reports in html format:**

```bash
> pytest --cov-report html:htmlcov --cov=myproj tests/
```

