#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Parking lot module.
"""

from collections import deque
from enum import Enum, auto

from vehicle import Bus, Car, Truck, Vehicle


class ParkingSpotSize(Enum):
    """
    Sizes of the parking spots.
    """
    S = auto()
    M = auto()
    L = auto()
    XL = auto()


class ParkingSpot:
    __slots__ = ['_id', '_size', '_my_vehicle']

    _next_id = 0

    def __init__(self, size: ParkingSpotSize):
        """
        Constructor with parameter.
        :param size: ParkingSpotSize
        """
        self._id = ParkingSpot._next_id
        ParkingSpot._next_id += 1
        self._size = size
        self._my_vehicle = None

    @property
    def id(self) -> int:
        """
        Accessor of id.
        :return: int
        """
        return self._id

    @property
    def size(self) -> ParkingSpotSize:
        """
        Accessor of size.
        :return: ParkingSpotSize
        """
        return self._size

    @property
    def vehicle(self) -> Vehicle:
        """
        Accessor of my_vehicle.
        :return: Vehicle
        """
        return self._my_vehicle

    @vehicle.setter
    def vehicle(self, v: Vehicle) -> None:
        """
        Mutator of my_vehicle.
        :param v: Vehicle
        :return: None
        """
        self._my_vehicle = v


class ParkingLot:
    __slots__ = ['_addr', '_available', '_parked']

    _ALL_SIZES = [
        ParkingSpotSize.S, ParkingSpotSize.M, ParkingSpotSize.L,
        ParkingSpotSize.XL
    ]

    def __init__(self, addr: str):
        """
        Constructor with parameter.
        :param addr: str
        """
        self._addr = addr
        self._available = {size: deque() for size in ParkingSpotSize}
        self._parked = {}

    def add_parking_spot(self, size: ParkingSpotSize) -> None:
        """
        Adds a new parking spot of the given size.
        :param size: ParkingSpotSize
        :return: None
        """
        size_available = self._parked[size]
        size_available.offer(ParkingSpot(size))
        self._parked[size] = size_available

    def place_vehicle(self, v: Vehicle) -> int:
        """
        Places the given vehicle.
        :param v: Vehicle
        :return: int
        """
        # Check whether the vehicle is already parked
        if v.license_plate in self._parked:
            raise Exception('The vehicle is already parked.')

        vehicle_size = ParkingSpotSize.S
        if isinstance(v, Car):
            vehicle_size = ParkingSpotSize.M
        elif isinstance(v, Truck):
            vehicle_size = ParkingSpotSize.L
        elif isinstance(v, Bus):
            vehicle_size = ParkingSpotSize.XL
        return self._place_vehicle_from_sized_spot(v, from_size=vehicle_size)

    def _place_vehicle_from_sized_spot(self, v: Vehicle,
                                       from_size: ParkingSpotSize) -> int:
        """
        Private helper method to place the given vehicle to a parking spot,
        starting from searching the given size.
        :param v: Vehicle
        :param from_size: int
        :return: int
        """
        from_idx = self._ALL_SIZES.index(from_size)
        parked_spot_id = -1
        for idx in range(from_idx, len(self._ALL_SIZES)):
            size = self._ALL_SIZES[idx]
            parked_spot_id = self._place_vehicle_to_sized_spot(v, size=size)
            if parked_spot_id != -1:
                break
        return parked_spot_id

    def _place_vehicle_to_sized_spot(self, v: Vehicle,
                                     size: ParkingSpotSize) -> int:
        """
        Helper method to place the given vehicle to a parking spot of the given
        size.
        :param v: Vehicle
        :param size: ParkingSpotSize
        :return: int
        """
        size_available = self._available[size]
        if not size_available:
            return -1
        spot = size_available.popleft()
        spot.vehicle = v
        self._parked[v.license_plate] = spot
        return spot.id
        # Time: O(1)

    def retrieve_vehicle(self, license_plate: str) -> Vehicle:
        """
        Retrieves the vehicle with the given license plate.
        :param license_plate: str
        :return: Vehicle
        """
        # Check whether the vehicle is already parked
        if license_plate not in self._parked:
            raise Exception('The vehicle is not parked.')

        spot = self._parked.pop(license_plate)
        v = spot.vehicle
        # Free the parking spot
        spot.vehicle = None
        size_available = self._available[spot.size]
        size_available.append(spot)
        self._available[spot.size] = size_available
        return v
        # Time: O(1)
