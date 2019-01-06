#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Items module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod
from datetime import date, timedelta


class Item(ABC):
    """
    Abstract item class.
    """
    __slots__ = ['_title']

    def __init__(self, title: str):
        """
        Constructor with parameter.
        :param title: title
        """
        self._title = title

    @property
    def title(self) -> str:
        """
        Accessor of title.
        :return: str
        """
        return self._title


class LoanableItem(Item):
    """
    Abstract loanable item class.
    """
    __slots__ = ['_value', '_checked_out', '_due_date', '_renewed']
    _DAYS_PER_WEEK = 7

    def __init__(self, title: str, value: float):
        """
        Constructor with parameter.
        :param title: str
        :param value: float
        """
        super().__init__(title)
        self._value = value
        self._checked_out = False
        self._due_date = None
        self._renewed = False

    @property
    def value(self) -> float:
        """
        Accessor of value.
        :return: value
        """
        return self._value

    @property
    def is_checked_out(self) -> bool:
        """
        Accessor of checked_out.
        :return: bool
        """
        return self._checked_out

    @property
    def due_date(self):
        """
        Accessor of due_date.
        :return: datetime object
        """
        return self._due_date

    @property
    def is_renewed(self) -> bool:
        """
        Accessor of renewed.
        :return: bool
        """
        return self._renewed

    def check_out(self) -> None:
        """
        Checks out this item.
        :return: None
        """
        self._checked_out = True
        self._set_due_date()
        self._renewed = False

    def _set_due_date(self) -> None:
        """
        Private helper function to set the due date when checking out.
        :return: None
        """
        today = date.today()
        loan_length = self._get_loan_length()
        self._due_date = today + timedelta(days=loan_length)

    @abstractmethod
    def _get_loan_length(self) -> int:
        """
        Helper function to get the loan length of this item.
        :return: int
        """
        pass

    def renew(self) -> None:
        """
        Renews this item.
        :return: None
        """
        self._checked_out = True
        self._set_due_date()
        self._renewed = True

    def check_in(self) -> None:
        """
        Checks in this item.
        :return: None
        """
        self._checked_out = False
        self._due_date = None
        self._renewed = False


class Book(LoanableItem):
    """
    Book class.
    """
    __slots__ = ['_best_seller']
    _NORMAL_LOAN_LENGTH = 3 * super()._DAYS_PER_WEEK
    _BEST_SELLER_LOAN_LENGTH = 2 * super()._DAYS_PER_WEEK

    def __init__(self, title: str, value: float, best_seller: bool):
        """
        Constructor with parameter.
        :param title: str
        :param value: float
        :param best_seller: bool
        """
        super().__init__(title, value)
        self._best_seller = best_seller

    def set_as_not_best_seller(self) -> None:
        """
        Sets this book to be not a best-seller.
        :return: None
        """
        self._best_seller = False

    def _get_loan_length(self):
        if self._best_seller:
            return self._BEST_SELLER_LOAN_LENGTH
        return self._NORMAL_LOAN_LENGTH


class AVMaterial(LoanableItem):
    """
    Audio/Video material class.
    """
    __slots__ = []
    _LOAN_LENGTH = 2 * super()._DAYS_PER_WEEK

    def __init__(self, title: str, value: float):
        """
        Constructor with parameter.
        :param title: str
        :param value: float
        """
        super().__init__(title, value)

    def _get_loan_length(self):
        return self._LOAN_LENGTH


class NonLoanableItem(Item):
    """
    Abstract non-loanable item class.
    """
    __slots__ = []

    def __init__(self, title: str):
        """
        Constructor with parameter.
        :param title: str
        """
        super().__init__(title)


class ReferenceBook(NonLoanableItem):
    """
    Reference book class.
    """
    __slots__ = []

    def __init__(self, title: str):
        """
        Constructor with parameter.
        :param title: str
        """
        super().__init__(title)


class Magazine(NonLoanableItem):
    """
    Magazine class.
    """
    __slots__ = []

    def __init__(self, title: str):
        """
        Constructor with parameter.
        :param title: str
        """
        super().__init__(title)
