#!usr/bin/env python
# -*- coding: utf-8 -*-

"""
line_profiler module demo.
"""

import random

import numpy as np


class Grid2D:
    """
    2D grid class where each node is at some x- and y-coordinate.
    """

    def __init__(self, xmin=0, xmax=1, dx=0.5, ymin=0, ymax=1, dy=0.5):
        """
        Constructor with parameter.
        :param xmin: int
        :param xmax: int
        :param dx: float
        :param ymin: int
        :param ymax: int
        :param dy: float
        """
        self._xcoor = np.arange(xmin, xmax + dx, step=dx)
        self._ycoor = np.arange(ymin, ymax + dy, step=dy)

    @profile
    def grid_loop(self, func):
        """
        Evaluates the given function at each node of this 2D grid.
        :param func: callable
        :return: ndarray
        """
        x_size = np.size(self._xcoor)
        y_size = np.size(self._ycoor)
        result = np.zeros((x_size, y_size))
        for i, x in enumerate(self._xcoor):
            for j, y in enumerate(self._ycoor):
                result[i, j] = func(x, y)
        return result


def simple_func(x, y):
    """
    Self-defined simple function.
    :param x: float
    :param y: float
    :return: float
    """
    return np.sin(x * y) + y


def main():
    grid = Grid2D(dx=0.001, dy=0.001)
    print('Computing values...')
    result = grid.grid_loop(func=simple_func)
    x_size, y_size = result.shape
    rand_i = random.randint(0, x_size - 1)
    rand_j = random.randint(0, y_size - 1)
    print 'Random sampled value at ({i}, {j}):'.format(i=rand_i, j=rand_j)
    print result[rand_i, rand_j]


if __name__ == '__main__':
    main()
