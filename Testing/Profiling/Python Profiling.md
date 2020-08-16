# Python Profiling

-> Look for bottleneck!

## Profiling Run Time

### 1. Small Code Snippets => `timeit` Module

`timeit_for_loop.py`:

```python
def main():
    total = 0
    for i in range(10000):
        total += i
```

```bash
$ python3 -m timeit -s 'import timeit_for_loop' 'timeit_for_loop.main()'
```

`timeit_sum.py`:

```python
def main():
    x = range(10000)
    total = sum(x)
```

```bash
$ python3 -m timeit -s 'import timeit_sum' 'timeit_sum.main()'
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

<br>

**Usage**

* **Python programming interface (as module)**

  * Use `cProfile.run()` function

    Check out `cprofile_demo1.py`, dumping to `result_stats1.prof`

  * Use `cProfile.Profile` and `pstats.Stats` classes

    Check out `cprofile_demo2.py`, dumping to `result_stats2.prof`

* **Command-line interface (as script)**

  (Directly run <u>the script to be profiled</u> from command-line interface)

  ```bash
  $ python3 -m cProfile -s 2 -o result_stats.prof script.py
  # Dumping to "result_stats.prof"
  ```

**Viewing Profile Data**

```python
from pstats import SortKey, Stats

stats = Stats('result_stats.prof').sort_stats(SortKey.CUMULATIVE)
stats.strip_dirs()
stats.print_stats()
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

* Profile the execution <u>line by line</u>
* <u>Deterministic</u>

**Installation**

```bash
$ pip3 install line_profiler
```

**Usage**

* <u>As decorator</u>: Use `@profile` decorator to decorate the function to profile

  Check out `line_profiler_demo.py`, dumping to `line_profiler_demo.lprof`

* <u>As context manager</u>: Use `with profile:` to profile a single code section

```bash
$ kernprof -l -o line_profiler_demo.lprof -v line_profiler_demo.py
# -v: Immediately view the formatted results at the terminal
```

Dumps to `line_profiler_demo.lprof`

**Viewing Profile Data**

```bash
$ python3 -m line_profiler line_profiler_demo.lprof
```

<br>

#### 3) `statprof` Module

* <u>Statistical</u>

  -> Instead of instrumenting each and every line, just peep at the stack from time to time, and figure out where we are

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
statptof.display()  # View the results at the terminal
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

* Direct usage

  Check out `yappi_demo1.py`, dumping to `yappi_demo1_func.prof` and `yappi_demo1_thread.prof`

* As context manager

  Check out `yappi_demo2.py`, dumping to `<func.__name__>.prof`

**Viewing Profile Data**

Same as using `pstats` to view `.prof` files

<br>

## Profiling for Memory Usage

Check out:

* `pympler`, `guppy` / `heapy` for <u>function-level</u>, <u>deterministic</u> memory usage profiling

* `memory_profiler` for <u>line-level</u>, <u>deterministic</u> memory usage profiling

  Works very similar to `line_profiler`

