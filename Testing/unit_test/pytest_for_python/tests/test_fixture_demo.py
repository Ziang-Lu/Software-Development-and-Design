#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
pytest fixture demo.

Assumption: creating a user is a very resource-consuming process
=> Thus, we don't want to do user creation every time we run a test.
"""

__author__ = 'Ziang Lu'

import pytest

from pytest_for_python.src.codes import User, is_member, is_prime_member


# By default, pytest.fixture has "function" scope, meaning that still we'll
# create a user for every test, and every test individually gets its own test
# user.
# => Thus, we need to change the fixture scope to "module".
@pytest.fixture(scope='module')
def user():
    """
    Creates and returns a temporary test user.
    """
    test_user = User(name='Williams', pwd='iamwill')
    # => This will work like "setup()".
    # return test_user

    # If we also want to work like "setup()" and "teardown()", use "yield"
    # instead of "return", and then do the "teardown()" work after that.
    yield test_user
    test_user.clean_up()


# When a test function sees that its argument name matches a fixture name (here,
# "user"), it will call that fixture function at the appropriate scope (here,
# "module"), and takes the resulting fixture object as the argument.
def test_is_member(user):
    assert not is_member(user)


def test_is_prime_member(user):
    assert is_prime_member(user)
