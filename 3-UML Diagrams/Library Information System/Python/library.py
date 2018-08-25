#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Library module.
"""

__author__ = 'Ziang Lu'

from typing import Iterable

from items import AVMaterial, Book, Item, LoanableItem, Magazine, ReferenceBook
from patron import Patron


class Library(object):
    """
    Library class.
    """
    __slots__ = ['_items_by_title', '_patrons', '_pending_requests']
    _patron_card_num = 0

    def __init__(self):
        """
        Default constructor.
        """
        self._items_by_title = {}
        self._patrons = {}
        self._pending_requests = []

    def _add_item(self, new_item: Item) -> None:
        """
        Private helper method to add the given item.
        :param new_item: item to add
        :return: None
        """
        title = new_item.title
        items = self._items_by_title.get(title, [])
        items.append(new_item)
        self._items_by_title[title] = items

    def add_book(self, title: str, value: float, best_seller: bool) -> None:
        """
        Adds a new book
        :param title: str
        :param value: float
        :param best_seller: bool
        :return: None
        """
        new_book = Book(title, value, best_seller)
        self._add_item(new_book)

    def add_av_material(self, title: str, value: float) -> None:
        """
        Adds a new A/V material.
        :param title: str
        :param value: float
        :return: None
        """
        new_av_material = AVMaterial(title, value)
        self._add_item(new_av_material)

    def add_reference_book(self, title: str) -> None:
        """
        Adds a new reference book.
        :param title: str
        :return: None
        """
        new_reference_book = ReferenceBook(title)
        self._add_item(new_reference_book)

    def add_magazine(self, title: str) -> None:
        """
        Adds a new magazine.
        :param title: str
        :return: None
        """
        new_magazine = Magazine(title)
        self._add_item(new_magazine)

    def register_patron(self, name: str, bday: int, phone_num: int,
                        addr: str) -> Patron:
        """
        Registers a new patron.
        :param name: str
        :param bday: datetime object
        :param phone_num: int
        :param addr: str
        :return: Patron
        """
        new_patron = Patron(self._patron_card_num, name, bday)
        new_patron.phone_num = phone_num
        new_patron.addr = addr
        self._patrons[self._patron_card_num] = new_patron
        self._patron_card_num += 1
        return new_patron

    def item_requested(self, title: str) -> LoanableItem:
        """
        Lets the given patron requests an item with the given title.
        :param title: str
        :return: LoanableItem
        """
        if title not in self._items_by_title:
            return None
        titled_items = self._items_by_title[title]
        for titled_item in titled_items:
            if isinstance(titled_item, LoanableItem):
                if not titled_item.is_checked_out:
                    titled_item.check_out()
                    return titled_item
        self._pending_requests.append(title)
        return None

    def item_renewed(self, item: LoanableItem) -> bool:
        """
        Lets the given item to be renewed.
        :param item: LoanableItem
        :return: bool
        """
        # An item can only be renewed once.
        if item.is_renewed:
            return False
        # If there is a pending request for this item, it cannot be renewed.
        title = item.title
        for pending_request in self._pending_requests:
            if pending_request == title:
                return False
        item.renew()
        return True

    def item_returned(self, item: LoanableItem) -> None:
        """
        Lets the given item to be returned.
        :param item: LoanableItem
        :return: None
        """
        item.check_in()
        # Remove the corresponding pending request if there is one
        self._pending_requests.remove(item.title)

    def get_patron_items(self, card_num: int) -> Iterable[Item]:
        """
        Gets the checked out items by the given patron.
        :param card_num: int
        :return: iterable[Item]
        """
        if card_num not in self._patrons:
            return []
        return self._patrons[card_num].items

    def calc_overdue_fine(self, card_num: int) -> float:
        """
        Calculates the overdue fine of the given patron.
        :param card_num: int
        :return: float
        """
        if card_num not in self._patrons:
            return 0.0
        return self._patrons[card_num].calc_overdue_fine()
