#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
yappi module demo.
"""

__author__ = 'Ziang Lu'

import yappi


def func() -> None:
    """
    Simple function.
    :return: None
    """
    for _ in range(10000000):
        pass


def main():
    yappi.start()
    func()

    # Output the profile data to binary files
    with open('yappi_demo1_func.prof', 'w') as fout:
        yappi.get_func_stats().print_all(out=fout)
    with open('yappi_demo1_thread.prof', 'w') as fout:
        yappi.get_thread_stats().print_all(out=fout)


if __name__ == '__main__':
    main()
