#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
cProfile module demo 1 using cProfile.run() function.
"""

__author__ = 'Ziang Lu'

import cProfile
import time


def delay1() -> None:
    """
    Delays 1 second.
    :return: None
    """
    time.sleep(1)


def delay2() -> None:
    """
    Delays 2 seconds.
    :return: None
    """
    time.sleep(2)


def delay3() -> None:
    """
    Delays 3 seconds.
    :return: None
    """
    time.sleep(3)


def main():
    delay1()
    delay2()
    delay3()


if __name__ == '__main__':
    # Sort the entries by cumulative time
    # Output the profile data to "result_stats1.prof" file
    cProfile.run('main()', sort=2, filename='result_stats1.prof')
