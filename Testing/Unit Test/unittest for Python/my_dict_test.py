#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
unittest demo module.
"""

__author__ = 'Ziang Lu'

import unittest

from my_dict import MyDict


class TestDict(unittest.TestCase):
    """
    A test case must inherit from unittest.TestCase
    """

    def setUp(self):
        """
        This method will be called to set up the testing environment for each
        single test.
        e.g., If a single test requires connecting to a database, we can make
        the connection in this setUp() method.
        """
        print('Setting up a single test...')

    def tearDown(self):
        """
        This method will be called to clean up the testing environment for each
        single test.
        e.g., If a single test connects to a database, we can close the
        connection in this tearDown() method.
        """
        print('Tearing down the single test...')

    def test_init(self):
        """
        Any single method starts with "test" will be tested by the framework.
        """
        d = MyDict(a=1, b='test')
        self.assertTrue(isinstance(d, dict))
        self.assertEqual(d.a, 1)
        self.assertEqual(d.b, 'test')

    def test_key(self):
        d = MyDict()
        d['key'] = 'value'
        self.assertEqual(d.key, 'value')

    def test_keyerror(self):
        d = MyDict()
        with self.assertRaises(KeyError):
            d['key']

    def test_attr(self):
        d = MyDict()
        d.key = 'value'
        self.assertTrue('key' in d)
        self.assertEqual(d['key'], 'value')

    def test_attrerror(self):
        d = MyDict()
        with self.assertRaises(AttributeError):
            d.key


if __name__ == '__main__':
    unittest.main()
