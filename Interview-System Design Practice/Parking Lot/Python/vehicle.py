#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Vehicle module.
"""

__author__ = 'Ziang Lu'

from abc import ABC


class Vehicle(ABC):
    __slots__ = ['_license_plate']

    def __init__(self, license_plate: str):
        """
        Constructor with parameter.
        :param license_plate: str
        """
        self._license_plate = license_plate

    @property
    def license_plate(self) -> str:
        """
        Accessor of license_plate.
        :return: str
        """
        return self._license_plate


class MotorCycle(Vehicle):
    __slots__ = []

    def __init__(self, license_plate: str):
        super().__init__(license_plate)


class Car(Vehicle):
    __slots__ = []

    def __init__(self, license_plate: str):
        super().__init__(license_plate)


class Truck(Vehicle):
    __slots__ = []

    def __init__(self, license_plate: str):
        super().__init__(license_plate)


class Bus(Vehicle):
    __slots__ = []

    def __init__(self, license_plate: str):
        super().__init__(license_plate)
