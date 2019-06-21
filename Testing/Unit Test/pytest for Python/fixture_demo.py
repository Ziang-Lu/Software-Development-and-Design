#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
pytest fixture demo.
"""

__author__ = 'Ziang Lu'

import pytest


class User:
    """
    Dummy User class.
    """
    __slots__ = ['_name', '_pwd']

    def __init__(self, name: str, pwd: str):
        """
        Constructor with parameter.
        :param name: str
        :param pwd: str
        """
        print('This is a long long process of creating a user...')
        self._name = name
        self._pwd = pwd

    @property
    def name(self) -> str:
        return self._name

    @property
    def pwd(self) -> str:
        return self._pwd

    def clean_up(self) -> None:
        """
        Dummy method to do some clean-up work.
        """
        print('Doing some clean-up work...')


def is_member(user: User) -> bool:
    """
    Checks whether the given user is a member.
    A member must have a name starting with "L".
    :param user: User
    :return: bool
    """
    return user.name.startswith('L')


def is_prime_member(user: User) -> bool:
    """
    Checks whether the given user is a prime member.
    A prime member must have a name starting with "W".
    :param user: User
    :return: bool
    """
    return user.name.startswith('W')


# Assumption: creating a user is a very resource-consuming process
# => Thus, we don't want to do user creation every time we run a test.
#
# However by default, pytest.fixture has "function" scope, meaning that still
# we'll create a user for every test, and every test individually gets its own
# test user.
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
