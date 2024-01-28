#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
pytest setup_module() and teardown_module() demo.

Assumption: creating a user is a very resource-consuming process
=> Thus, we don't want to do user creation every time we run a test.
"""

__author__ = 'Ziang Lu'

import pytest

from pytest_for_python.src.codes import User, is_member, is_prime_member

user = None


def setup_module(module):
    global user
    user = User(name='Williams', pwd='iamwill')


def test_user_is_member():
    assert not is_member(user)


def test_user_is_prime_member():
    assert is_prime_member(user)


def teardown_module(module):
    user.clean_up()
