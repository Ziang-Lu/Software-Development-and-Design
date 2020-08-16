#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
yappi module demo.
"""

__author__ = 'Ziang Lu'

from typing import Callable

from yappi import YFuncStats, profile


def aggregate(func: Callable, stats: YFuncStats) -> None:
    """
    Post-processing for profiled statistics.
    :param func: callable
    :param stats: YFuncStats
    :return: None
    """
    filename = f'{func.__name__}.prof'
    try:
        stats.add(filename)
    except IOError:
        pass
    stats.save(filename)


@profile(return_callback=aggregate)
def add(x, y):
    """
    Simple add function.
    :param x:
    :param y:
    :return:
    """
    return x + y
