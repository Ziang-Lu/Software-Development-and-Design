#!usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = 'Ziang Lu'

import argparse

from num_of_paths import num_of_paths


def test_num_of_paths(start_x: int, start_y: int) -> None:
    """
    Tests num_of_paths() function.
    :param start_x: int
    :param start_y: int
    :return: None
    """
    n_path = num_of_paths(start_x, start_y)
    print(n_path)
    if n_path == 8:  # This condition will not be met.
        print('Condition not met')


if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        description='Tests num_of_paths() function'
    )

    parser.add_argument('x', help='x-coordinate of the start', type=int)
    parser.add_argument('y', help='y-coordinate of the start', type=int)

    args = parser.parse_args()

    start_x = args.x
    start_y = args.y

    test_num_of_paths(start_x, start_y)
