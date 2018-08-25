#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Member-related module.
"""

__author__ = 'Ziang Lu'

import datetime
from typing import List


class MembershipLevels(object):
    """
    Membership level enumeration.
    """
    __slots__ = []

    BASIC = 1
    CLASSES = 2
    DELUXE = 3


class Visit(object):
    """
    Visit class.
    """
    __slots__ = ['_year', '_month', '_day']

    def __init__(self, year, month, day):
        """
        Constructor with parameter.
        :param year: int
        :param month: int
        :param day: int
        """
        self._year = year
        self._month = month
        self._day = day

    def __repr__(self):
        return f'{self._month}/{self._day}/{self._year}'


class Member(object):
    """
    Member class.
    """

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        self._name = name
        self._my_level = MembershipLevels.BASIC
        self._visit_records = []

    @property
    def name(self) -> str:
        """
        Accessor of name.
        :return: str
        """
        return self._name

    @property
    def membership_level(self) -> int:
        """
        Accessor of my_level.
        :return: int
        """
        return self._my_level

    @property
    def visit_history(self) -> List[Visit]:
        """
        Accessor of visit_records.
        :return: list[Visit]
        """
        return self._visit_records

    def update(self) -> None:
        """
        Updates this member, if possible.
        :return: None
        """
        if self._my_level == MembershipLevels.BASIC:
            self._my_level = MembershipLevels.CLASSES
        elif self._my_level == MembershipLevels.CLASSES:
            self._my_level = MembershipLevels.DELUXE

    def check_in(self) -> None:
        """
        Checks in for this member today.
        :return: None
        """
        today = datetime.today()
        self._visit_records.append(Visit(today.year, today.month, today.day))
