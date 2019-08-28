# `pytest` for Python

## Installation

```bash
$ pip3 install pytest
```

## Usage

Check out `test_my_dict_func.py` and `test_my_dict_class.py` for test discovery rules

```bash
$ pytest -v -s tests/
# -v increase verbosity
# -s or --capture=no allows print statements inside test functions to be printed to terminal
# tests/ contains the test files ("test_*.py" and "*_test.py")
```

**Skip some tests (maybe on some condition)**

```bash
$ pytest -v -rxs tests/
# -r shows extra test summry info as specified by ...
#     x: failed
#     s: skipped
```

**Run tests selectively by <u>name</u>**

```bash
$ pytest -k 'key or attr' -v tests/
# -k [EXPRESSION] EXPRESSION is a Python expression within which substrings are used to be checked against the test names
# => Run tests whose name contains "key" or "attr"
```

**Run tests selectively by <u>custom mark</u>**

```bash
$ pytest -m 'linux or mac' -v tests/
# -m [MARKEXPR] MARKEXPR is a Python expression within which substrings are used to be checked against the custom marks of the tests
# => Run tests whose custom mark is "linux" or "mac"
```

*Side Note:*

*Using `pytest.raises` is likely to be better for cases where you are testing exceptions your own code is deliberately raising, whereas using `@pytest.mark.xfail()` with a check function is probably better for something like documenting unfixed bugs or bugs in dependencies.*

**Fixtures**

*(Can be regarded as … functions?)*

=> Fixture functions can be used to do some useful work before/after a single test function / test module / test session.

<u>Scopes:</u> Run once

* per test function
* per module
* per session

(Just like the classic `setup()` and `teardown()` functions!)

***

Note that we can also define `setup_module(module)` and `teardown_module(module)` functions, just like how they work in `unittest`!

***

Check out `fixture_demo.py`

