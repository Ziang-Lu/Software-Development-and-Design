#!usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = 'Ziang Lu'


def num_of_paths(from_x: int, from_y: int) -> int:
    """
    Calculates the number of paths from the given point to the origin (0, 0).
    :param from_x: int
    :param from_y: int
    :return: int
    """
    # Assumption: from_x >= 0 and from_y >= 0
    if from_x == 0 or from_y == 0:
        return 1
    return num_of_paths(from_x - 1, from_y) + num_of_paths(from_x, from_y - 1)
