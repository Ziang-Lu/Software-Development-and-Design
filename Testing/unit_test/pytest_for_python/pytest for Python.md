# `pytest` for Python

## Installation

```bash
$ pip3 install pytest
```

## Usage

Check out `tests/test_my_dict_func.py` and `tests/test_my_dict_class.py` for test discovery rules

```bash
$ pytest -v -s tests/
# -v increase verbosity
# -s or --capture=no allows print statements inside test functions to be printed to terminal
# tests/ contains the test files ("test_*.py" and "*_test.py")
```

<br>

**Skip some tests (maybe on some condition)**

```bash
$ pytest -v -rxs tests/
# -r shows extra test summary info as specified by ...
#     x: failed
#     s: skipped
```

<br>

**Run tests selectively by <u>name</u>**

```bash
$ pytest -k 'key or attr' -v tests/
# -k [EXPRESSION] EXPRESSION is a Python expression within which substrings are used to be checked against the test names
# => Run tests whose name contains "key" or "attr"
```

<br>

**Run tests selectively by <u>custom mark</u>**

First register the custom marks in `pytest.ini`:

```ini
[pytest]
marks =
    linux
    mac
    windows
```

And then

```bash
$ pytest -m 'linux or mac' -v tests/
# -m [MARKEXPR] MARKEXPR is a Python expression within which substrings are used to be checked against the custom marks of the tests
# => Run tests whose custom mark is "linux" or "mac"
```

*Side Note:*

*Using `pytest.raises` is likely to be better for cases where you are testing exceptions that your own code is deliberately raising, whereas using `@pytest.mark.xfail()` with a check function is probably better for something like documenting unfixed bugs or bugs in dependencies.*

<br>

**Fixtures**

(Just like the classic `setup()` and `teardown()` functions in `unittest`!)

Note that we can also define `setup_module(module)` and `teardown_module(module)` functions, just like how they work in `unittest`!

Check out `tests/test_setup_teardown_demo.py`

***

=> Fixture functions can be used to do some useful work before/after a single test function / test module / test session.

<u>Scopes:</u> Run once

* per test function
* per module
* per session

Check out `tests/test_fixture_demo.py`

