#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Gym-related module.
"""

__author__ = 'Ziang Lu'

from typing import List

from model.cardio import CardioMachine
from model.members import Member
from model.weights import Weight


class FitnessClass:
    """
    FitnessClass class.
    """
    __slots__ = ['_name', '_class_date', '_registered']

    _MAX_CAPACITY = 150

    def __init__(self, name: str, class_date: str):
        """
        Constructor with parameter.
        :param name: str
        :param class_date: str
        """
        self._name = name
        self._class_date = class_date
        self._registered = []

    @property
    def name(self) -> str:
        """
        Accessor of name.
        :return: name
        """
        return self._name

    @property
    def class_date(self) -> str:
        """
        Accessor of class_date.
        :return: str
        """
        return self._class_date

    @property
    def registered_members(self) -> List[Member]:
        """
        Accessor of registered.
        :return: list[Member]
        """
        return self._registered

    def register_member(self, member: Member) -> None:
        """
        Register the given member to the fitness class.
        :param member: Member
        :return: None
        """
        if member in self._registered:
            print('Sorry, but you seem to have registered the class.')
            return
        if len(self._registered) > self._MAX_CAPACITY:
            print('Sorry, but the class is full.')
            return
        self._registered.append(member)

    def remove_member(self, member: Member) -> None:
        """
        Removes the given member from the fitness class.
        :param member: Member
        :return: None
        """
        if member not in self._registered:
            print('Sorry, but you seem to have not registered the class.')
            return
        self._registered.remove(member)


class Gym:
    """
    Gym class.
    """
    __slots__ = ['_location', '_weights', '_machines', '_classes', '_has_pool']

    def __init__(self, location: str, has_pool: bool):
        """
        Constructor with parameter.
        :param location: str
        :param has_pool: bool
        """
        self._location = location
        self._weights = []
        self._machines = []
        self._classes = []
        self._has_pool = has_pool

    @property
    def location(self) -> str:
        """
        Accessor of location.
        :return: str
        """
        return self._location

    @property
    def weights(self) -> List[Weight]:
        """
        Accessor of weights.
        :return: list[Weight]
        """
        return self._weights

    @property
    def machines(self) -> List[CardioMachine]:
        """
        Accessor of machines.
        :return: list[CardioMachine]
        """
        return self._machines

    @property
    def classes(self) -> List[FitnessClass]:
        """
        Accessor of classes.
        :return: list[FitnessClass]
        """
        return self._classes

    @property
    def has_pool(self) -> bool:
        """
        Accessor of has_pool.
        :return: bool
        """
        return self._has_pool

    def add_weight(self, weight: Weight) -> None:
        """
        Adds the given weight to this gym.
        :param weight: Weight
        :return: None
        """
        if not weight:
            print('The weight should not be None.')
            return
        self._weights.append(weight)

    def add_machine(self, machine: CardioMachine) -> None:
        """
        Adds the given cardio machine to this gym.
        :param machine: CardioMachine
        :return: None
        """
        if not machine:
            print('The cardio machine should not be None.')
            return
        self._machines.append(machine)

    def add_fitness_class(self, cls) -> None:
        """
        Adds the given fitness class to this gym.
        :param cls: FitnessClass
        :return: None
        """
        if not cls:
            print('The fitness class should not be None.')
            return
        self._classes.append(cls)

    def guide_member_through_workout(self, member: Member) -> None:
        """
        Guides the given member through workout.
        :param member: Member
        :return: None
        """
        if not member:
            print('The member should not be None.')
            return

        name = member.name
        for weight in self._weights:
            print(f'{name} is lifting {weight.get_weight()} pounds')
        for machine in self._machines:
            print(
                f'{name} is exercising on {type(machine).__name__} for '
                f'{machine.minutes} minutes at level {machine.level}'
            )
        for cls in self._classes:
            cls.register_member(member)
            print(f'{name} is registered for {cls.name} on {cls.class_date}')


class DeluxeGym(Gym):
    """
    DeluxeGym class.
    """
    __slots__ = ['_has_sauna']

    def __init__(self, location: str):
        """
        Constructor with parameter.
        :param location: str
        """
        super().__init__(location, has_pool=True)
        self._has_sauna = True

    @property
    def has_sauna(self) -> bool:
        """
        Accessor of has_sauna.
        :return: bool
        """
        return self._has_sauna
