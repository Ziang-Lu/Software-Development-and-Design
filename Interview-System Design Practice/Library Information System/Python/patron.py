#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Patron module.
"""

__author__ = 'Ziang Lu'

from datetime import date
from typing import Iterable

from items import Item, LoanableItem
from library import Library


class Patron:

    def __init__(self, card_num: int, name: str, bday):
        """
        Constructor with parameter.
        :param card_num: int
        :param name: str
        :param bday: datetime object
        """
        self._card_num = card_num
        self._name = name
        self._bday = bday
        self._phone_num = 0
        self._addr = None
        self._my_items_by_title = {}

    @property
    def card_num(self) -> int:
        """
        Accessor of card_num.
        :return: int
        """
        return self._card_num

    @property
    def name(self) -> str:
        """
        Accessor of name.
        :return: str
        """
        return self._name

    @property
    def age(self) -> int:
        """
        Returns the age of this patron.
        :return: int
        """
        today = date.today()
        return today.year - self._bday.year

    @property
    def phone_num(self) -> int:
        """
        Accessor of phone_num.
        :return: int
        """
        return self._phone_num

    @property
    def addr(self) -> str:
        """
        Accessor of addr.
        :return: str
        """
        return self._addr

    @property
    def items(self) -> Iterable[Item]:
        """
        Returns the checked out items by this patron as a list.
        :return: iterable[Item]
        """
        return self._my_items_by_title.values()

    @phone_num.setter
    def phone_num(self, phone_num: int) -> None:
        """
        Mutator of phone_num.
        :param phone_num: int
        :return: None
        """
        self._phone_num = phone_num

    @addr.setter
    def addr(self, addr: str) -> None:
        """
        Mutator of addr.
        :param addr: str
        :return: None
        """
        self._addr = addr

    def request_item(self, lib: Library, title: str) -> None:
        """
        Requests to the given library for the item with the given title.
        :param lib: Library
        :param title: str
        :return: None
        """
        # Children (age 12 or under) can only check out 5 items at a time
        if self.age <= 12 and len(self._my_items_by_title.values()) >= 5:
            return

        loanable = lib.item_requested(title)
        if not loanable:
            return
        self._my_items_by_title[title] = loanable

    def renew_item(self, lib: Library, title: str) -> None:
        """
        Renews the given item to the given library.
        :param lib: Library
        :param title: str
        :return: None
        """
        if title not in self._my_items_by_title:
            return
        item = self._my_items_by_title[title]
        if not lib.item_renewed(item):
            self._return_item(lib, item)

    def _return_item(self, lib: Library, item: LoanableItem) -> None:
        """
        Private helper function to return the given item to the given library.
        :param lib: Library
        :param item: Item
        :return: None
        """
        lib.item_returned(item)
        self._my_items_by_title.pop(item.title)

    def return_item(self, lib: Library, title: str) -> None:
        """
        Returns the item with the given title to the given library.
        :param lib: Library
        :param title: str
        :return: None
        """
        if title not in self._my_items_by_title:
            return
        item = self._my_items_by_title[title]
        self._return_item(lib, item)

    def calc_overdue_fine(self) -> float:
        """
        Calculates this patron's overdue fine.
        :return: float
        """
        today = date.today()
        overdue_fine = 0.0
        for item in self._my_items_by_title.values():
            due_date = item.due_date
            if due_date < today:
                diff = today - due_date
                delayed_days = diff.days
                # The overdue fine for an item cannot be higher than the value
                # of the item.
                overdue_fine += min(delayed_days * 0.1, item.value)
        return overdue_fine
