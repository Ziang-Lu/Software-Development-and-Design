#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Source codes.
"""

__author__ = 'Ziang Lu'

from typing import Any


class MyDict(dict):
    """
    An dictionary class that acts the same as "dict", but also allows accessing
    values by keys as attributes.
    """
    __slots__ = []

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def __getattr__(self, key: Any) -> Any:
        try:
            return self[key]
        except KeyError:
            # To let this dict act like a class, transform KeyError to
            # AttributeError
            raise AttributeError(f"'Dict' object has no attribute '{key}'")

    def __setattr__(self, key: Any, val: Any) -> None:
        self[key] = val


class User:
    """ Dummy User class. """
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
        """
        Accessor of name.
        :return: str
        """
        return self._name

    @property
    def pwd(self) -> str:
        """
        Accessor of pwd.
        :return: str
        """
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
    if not user:
        raise TypeError('user should not be None')
    return user.name.startswith('L')


def is_prime_member(user: User) -> bool:
    """
    Checks whether the given user is a prime member.
    A prime member must have a name starting with "W".
    :param user: User
    :return: bool
    """
    if not user:
        raise TypeError('user should not be None')
    return user.name.startswith('W')
