#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
cProfile module demo 2 using cProfile.Profile and pstats.Stats classes to gain
more precise control.
"""

__author__ = 'Ziang Lu'

import sys
from cProfile import Profile
from pstats import SortKey, Stats
from typing import Callable, List


def profile(func: Callable) -> Callable:
    """
    A decorator that uses cProfile.Profile class to profile a function.
    :param func: function
    :return: function
    """

    def inner(*args, **kwargs):
        pr = Profile()
        pr.enable()
        result = func(*args, **kwargs)
        pr.disable()

        stats = Stats(pr).sort_stats(SortKey.CUMULATIVE)  # Sort the entries by cumulative times
        stats.strip_dirs()
        # Output the formatted profile data to "result_stats.prof" file
        stats.dump_stats('result_stats2.prof')

        # Note that we can also use Stats class as a statistics browser for the
        # dumped profile data (.proj files)
        # => We simply need to pass a filename to the constructor.
        return result

    return inner


@profile
def find_duplicate_movies(filename: str) -> List[str]:
    """
    Finds the duplicate movie titles from the given file.
    :param filename: str
    :return: list[str]
    """
    with open(filename) as f:
        movies = f.readlines()

    seen = set()
    duplicates = []
    for movie in movies:
        movie = movie.strip().lower()
        if movie in seen:
            duplicates.append(movie)
        seen.add(movie)
    return duplicates


if __name__ == '__main__':
    find_duplicate_movies('movies')
