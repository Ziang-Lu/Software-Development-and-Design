# Python Profiling

-> Look for bottleneck!

## Profiling Run Time

### 1. Small Code Snippets => `timeit` Module

Check out `timeit_sum.py`

```bash
$ python3 -m timeit -s 'import timeit_sum' 'timeit_sum.main()'
```

Check out `timeit_for_loop.py`

```bash
$ python3 -m timeit -s 'import timeit_for_loop' 'timeit_for_loop.main()'
```

**(Diretly run <u>the codes to be timed</u> from command-line interface)**

```bash
$ python3 -m timeit -s 'x = range(10000)' 'total = sum(x)'
```

<br>

### 2. Python Application

#### 1) `cProfile` Module

* Profile <u>function calls</u>
* <u>Deterministic</u>

**Python Programming Interface (as Module)**

* Use `cProfile.run()` function

  Check out `cprofile_demo1.py`

* Use `cProfile.Profile` and `pstats.Stats` classes

  Check out `cprofile_demo2.py`

**Command-Line Interface (as Script)**

(Directly run <u>the script to be profiled</u> from command-line interface)

```bash
$ python3 -m cProfile -s 2 -o result_stats.prof script.py
```

***

**Profile Visualization**

Assume that we got a profile file called `result_stats.prof`, we can visualize it using `SnakeViz`:

```bash
$ pip3 install snakeviz  # Install SnakeViz

$ snakeviz result_stats.prof
# Note that the path to the profile file is not allowed to contain space!!!
```

***

<br>

#### 2) `line_profiler` Module

*Note: Currently Python 3.7 is not well supported by `line_profiler`, so we'll just do Python 2.7 version.*

* Profile the execution <u>line by line</u>
* <u>Deterministic</u>

**Installation**

```bash
$ pip install line_profiler
```

**Usage**

1. As decorator

   Use `@profile` decorator to decorate the function to profile: Check out `line_profiler_demo.py`

2. As context manager

   Use `with profile:` to profile a single code section

```bash
$ kernprof -l -o line_profiler_demo.lprof -v line_profiler_demo.py
```

The above command will also print the profiling statistics to to the terminal. However, if later we want to check out the profiling statistics stored in `line_profiler_demo.lprof`, we can do

```bash
$ python -m line_profiler line_profiler_demo.lprof
```

<br>

#### 3) `statprof` Module

* <u>Statistical</u>

  -> Instead of instrumenting each and every line, just peep at the stack from time to time, and figure out where we are!

  => 虽然结果准确性可能会稍稍下降, 但是会大大缩短profiling的时间

**Installation**

```bash
$ pip3 install statprof
```

**Usage**

```python
import statprof

statprof.start()
try:
    # Code to be profiled
finally:
    statprof.stop()
statptof.display()
```

And then simple from command-line interface:

```bash
$ python3 module.py
```

<br>

#### 4) `yappi` Module

* Profile <u>function calls</u> and <u>thread execution statistics</u>
* <u>Statistical</u>

**Installation**

```bash
$ pip3 install yappi
```

**Usage**

1. Direct usage

   Check out `yappi_demo1.py`

2. As context manager

   Check out `yappi_demo2.py`

<br>

## Profiling for Memory Usage

Check out:

* `pympler`, `guppy` / `heapy` for <u>function-level</u>, <u>deterministic</u> memory usage profiling

* `memory_profiler` for <u>line-level</u>, <u>deterministic</u> memory usage profiling

  Works very similar to `line_profiler`

