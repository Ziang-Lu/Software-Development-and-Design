#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Gym-chain module.
"""

from typing import List

from model.gym import DeluxeGym, Gym
from model.members import Member, MembershipLevel


class GymChain:
    """
    GymChain class.
    """
    __slots__ = ['_gyms', '_members']

    def __init__(self):
        """
        Default constructor.
        """
        self._gyms = []
        self._members = []

    @property
    def gyms(self) -> List[Gym]:
        return self._gyms

    def find_gym(self, location: str) -> Gym:
        """
        Finds the gym according to the given location.
        :param location: str
        :return: Gym
        """
        for gym in self._gyms:
            if gym.location.lower() == location.lower():
                return gym
        # Not found
        return None

    @property
    def members(self) -> List[Member]:
        return self._members

    def find_member(self, name: str) -> Member:
        """
        Finds the member according to the given member.
        :param name: str
        :return: Member
        """
        for member in self._members:
            if member.lower() == name.lower():
                return member
        # Not found
        return None

    def can_member_enter_gym(self, member_name, gym_location):
        member = self.find_member(member_name)
        gym = self.find_gym(gym_location)
        if not member or not gym:
            return False

        if member.membership_level == MembershipLevel.DELUXE:
            return True
        return type(gym).__name__ != DeluxeGym.__name__

    def add_gym(self, gym: Gym) -> None:
        """
        Adds the given gym to this gym chain.
        :param gym: Gym
        :return: None
        """
        if not gym:
            print('The gym should not be null.')
            return
        self._gyms.append(gym)

    def sign_up_member(self, member: Member) -> None:
        """
        Signs up the given member to this gym chain.
        :param member: Member
        :return: None
        """
        if not member:
            print('The member should not be null.')
            return
        self._members.append(member)
