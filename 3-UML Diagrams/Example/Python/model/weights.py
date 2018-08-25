#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Weights module.
"""

__author__ = 'Ziang Lu'


from abc import ABC, abstractmethod
from typing import List


class Weight(ABC):
    """
    Abstract Weight class.
    """
    __slots__ = ['_pounds']

    def __init__(self, pounds: int):
        """
        Constructor with parameter.
        :param pounds: int
        """
        self._pounds = pounds

    @abstractmethod
    def get_weight(self) -> int:
        """
        Returns the total weight of this weight.
        :return: int
        """
        pass

    def set_weight(self, pounds: int) -> None:
        """
        Mutator of pounds.
        :param pounds: int
        :return: None
        """
        if pounds <= 0:
            raise ValueError('The weight to set should be positive.')

        self._pounds = pounds


class WeightMachine(Weight):
    """
    WeightMachine class.
    """
    __slots__ = ['_muscle_group']

    def __init__(self, pounds: int, muscle_group: str):
        # We assume that pounds is positive.
        super().__init__(pounds)
        self._muscle_group = muscle_group

    def get_weight(self):
        return self._pounds

    @property
    def muscle_group(self):
        return self._muscle_group


class Plate(Weight):
    """
    Plate class.
    """
    __slots__ = []

    def __init__(self, pounds: int):
        """
        Constructor with parameter.
        :param pounds: int
        """
        super().__init__(pounds)

    def get_weight(self) -> int:
        return self._pounds


class Barbell(Weight):
    """
    Barbell class.
    """
    __slots__ = []
    _BAR_POUNDS = 45
    _PLATE_POUNDS_45 = 45
    _PLATE_POUNDS_25 = 25
    _PLATE_POUNDS_10 = 10
    _PLATE_POUNDS_5 = 5
    _PLATE_POUNDS_1 = 1

    @staticmethod
    def _add_plate_pair(plates: List[Plate], plate_pounds: int,
                        remaining_pounds: int) -> int:
        """
        Adds a pair of plates weighing the given pounds to the given plates,
        and returns the remaining pounds after the addition.
        :param plates: list[Plate]
        :param plate_pounds: int
        :param remaining_pounds: int
        :return:
        """
        plates.append(Plate(plate_pounds))
        plates.append(Plate(plate_pounds))
        return remaining_pounds - 2 * plate_pounds

    def __init__(self, pounds: int):
        """
        Constructor with parameter.
        :param pounds: int
        """
        # We assume that pounds is greater than or equal to 45.
        super().__init__(pounds)

    def get_weight(self):
        return self._pounds + self._BAR_POUNDS

    def get_plate(self) -> List[Plate]:
        """
        Returns a list of plates of this barbell.
        :return: list[Plate]
        """
        remaining_pounds = self._pounds
        plates = []
        while remaining_pounds > 0:
            if remaining_pounds >= 2 * self._PLATE_POUNDS_45:
                remaining_pounds = self._add_plate_pair(
                    plates, self._PLATE_POUNDS_45, remaining_pounds
                )
            elif remaining_pounds >= 2 * self._PLATE_POUNDS_25:
                remaining_pounds = self._add_plate_pair(
                    plates, self._PLATE_POUNDS_25, remaining_pounds
                )
            elif remaining_pounds >= 2 * self._PLATE_POUNDS_10:
                remaining_pounds = self._add_plate_pair(
                    plates, self._PLATE_POUNDS_10, remaining_pounds
                )
            elif remaining_pounds >= 2 * self._PLATE_POUNDS_5:
                remaining_pounds = self._add_plate_pair(
                    plates, self._PLATE_POUNDS_5, remaining_pounds
                )
            else:
                while remaining_pounds > 0:
                    plates.append(Plate(self._PLATE_POUNDS_1))
                    remaining_pounds -= 1
        return plates


class Dumbbell(Weight):
    """
    Dumbbell class.
    """
    __slots__ = []

    def __init__(self, pounds: int):
        """
        Constructor with parameter.
        :param pounds: int
        """
        # We assume that pounds is positive.
        super().__init__(pounds)

    def get_weight(self):
        return self._pounds * 2
