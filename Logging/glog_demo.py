#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
glog module demo.
"""

import glog as logging


def foo(s: str) -> float:
    """
    Sample function to interpret the given string as a floating-point number,
    and return its result when divided by 10.
    :param s: str
    :return: float
    """
    n = int(s)
    logging.info(f'n = {n}')
    return 10 / n


def main():
    print(foo('0'))


if __name__ == '__main__':
    main()


# Output:
# I0706 18:06:29.690877 231 glog_demo.py:19] n = 0
# Traceback(most recent call last):
#   File "glog_demo.py", line 28, in <module >
#   main()
#   File "glog_demo.py", line 24, in main
#   print(foo('0'))
#   File "glog_demo.py", line 20, in foo
#   return 10 / n
# ZeroDivisionError: division by zero
