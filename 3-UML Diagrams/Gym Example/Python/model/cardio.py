#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Cardio machines module.
"""

__author__ = 'Ziang Lu'

from abc import ABC


class CardioMachine(ABC):
    """
    Abstract CardioMachine class.
    """
    __slots__ = ['_minutes', '_level']
    _DEFAULT_LEVEL = 1

    def __init__(self, minutes: int):
        """
        Constructor with parameter.
        :param minutes: int
        """
        self._minutes = minutes
        self._level = self._DEFAULT_LEVEL

    @property
    def minutes(self) -> int:
        """
        Accessor of minutes.
        :return: int
        """
        return self._minutes

    @property
    def level(self) -> int:
        """
        Accessor of level.
        :return: int
        """
        return self._level

    def level_up(self) -> None:
        """
        Levels up this cardio machine.
        :return: None
        """
        self._level += 1

    def level_down(self) -> None:
        """
        Levels down this cardio machine, if possible.
        :return: None
        """
        if self._level > 1:
            self._level -= 1


class Treadmill(CardioMachine):
    """
    Treadmill class.
    """
    __slots__ = ['_speed']

    def __init__(self, speed: float, minutes: int):
        """
        Constructor with parameter.
        :param speed: float
        :param minutes: int
        """
        # We assume that both speed and minutes are positive.
        super().__init__(minutes)
        self._speed = speed

    @property
    def speed(self) -> float:
        """
        Accessor of speed.
        :return: float
        """
        return self._speed

    @speed.setter
    def speed(self, speed: float) -> None:
        """
        Mutator of speed.
        :param speed: float
        :return: None
        """
        if speed <= 0.0:
            raise ValueError('The speed should be positive.')

        self._speed = speed


class Elliptical(CardioMachine):
    """
    Elliptical class.
    """
    __slots__ = []

    def __init__(self, minutes):
        """
        Constructor with parameter.
        :param minutes: int
        """
        # We assume that minutes is positive.
        super().__init__(minutes)


class InnerBike(CardioMachine):
    """
    InnerBike class.
    """
    __slots__ = []

    def __init__(self, minutes: int):
        """
        Constructor with parameter.
        :param minutes: int
        """
        # We assume that minutes is positive.
        super().__init__(minutes)
