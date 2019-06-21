#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
cProfile module demo 2 using cProfile.Profile and pstats.Stats classes to gain
more precise control.
"""

__author__ = 'Ziang Lu'

import io
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
        retval = func(*args, **kwargs)
        pr.disable()

        str_buf = io.StringIO()  # In-memory stream for text I/O
        stats = Stats(pr, stream=str_buf).sort_stats(SortKey.CUMULATIVE)  # Sort the entries by cumulative times
        stats.strip_dirs()
        stats.print_stats()  # Output the formatted profile data to "str_buf" in-memory text I/O stream
        print(str_buf.getvalue())
        # Actually, we don't need to use "str_buf" and simply do stream=stdout,
        # which will output the formatted profile data to standard output.

        # Note that we can also use Stats class as a statistics browser for the
        # dumped profile data (.proj files)
        # => We simply need to pass a filename to the constructor.

        # Also output the formatted profile data to "result_stats.prof" file
        stats.dump_stats('result_stats2.prof')
        return retval

    return inner


@profile
def find_duplicate_movies(filename: str) -> List[str]:
    """
    Finds the duplicate movie titles from the given file.
    :param src_filename: str
    :return: list[str]
    """
    movies = _read_movies(filename)
    seen = set()
    duplicates = []
    for movie in movies:
        if movie.lower() in seen:  # Duplicate movie
            duplicates.append(movie)
        else:  # New movie
            seen.add(movie.lower())
    return duplicates


def _read_movies(filename: str) -> List[str]:
    """
    Helper function to read movie titles from the given file.
    :param filename: str
    :return: list[str]
    """
    with open(filename) as f:
        return f.readlines()


def main():
    find_duplicate_movies('movies')


if __name__ == '__main__':
    main()
