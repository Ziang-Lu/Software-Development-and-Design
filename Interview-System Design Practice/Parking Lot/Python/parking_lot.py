#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Parking lot module.
"""

from collections import deque
from enum import Enum, auto

from vehicle import Bus, Car, MotorCycle, Truck, Vehicle


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
    def vehicle(self, vehicle: Vehicle) -> None:
        """
        Mutator of my_vehicle.
        :param vehicle: Vehicle
        :return: None
        """
        self._my_vehicle = vehicle


class ParkingLot:
    __slots__ = ['_addr', '_available', '_parked']

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

    def place_vehicle(self, vehicle: Vehicle) -> int:
        """
        Places the given vehicle.
        :param vehicle: Vehicle
        :return: int
        """
        # Check whether the vehicle is already parked
        if vehicle.license_plate in self._parked:
            raise Exception('The vehicle is already parked.')

        if isinstance(vehicle, MotorCycle):
            parked_spot_id = \
                self._place_vehicle_to_sized_spot(vehicle, ParkingSpotSize.S)
            if parked_spot_id != -1:
                return parked_spot_id
            parked_spot_id = \
                self._place_vehicle_to_sized_spot(vehicle, ParkingSpotSize.M)
            if parked_spot_id != -1:
                return parked_spot_id
            parked_spot_id = \
                self._place_vehicle_to_sized_spot(vehicle, ParkingSpotSize.L)
            if parked_spot_id != -1:
                return parked_spot_id
            return self._place_vehicle_to_sized_spot(vehicle,
                                                     ParkingSpotSize.XL)
        elif isinstance(vehicle, Car):
            parked_spot_id = \
                self._place_vehicle_to_sized_spot(vehicle, ParkingSpotSize.M)
            if parked_spot_id != -1:
                return parked_spot_id
            parked_spot_id = \
                self._place_vehicle_to_sized_spot(vehicle, ParkingSpotSize.L)
            if parked_spot_id != -1:
                return parked_spot_id
            return self._place_vehicle_to_sized_spot(vehicle,
                                                     ParkingSpotSize.XL)
        elif isinstance(vehicle, Truck):
            parked_spot_id = \
                self._place_vehicle_to_sized_spot(vehicle, ParkingSpotSize.L)
            if parked_spot_id != -1:
                return parked_spot_id
            return self._place_vehicle_to_sized_spot(vehicle,
                                                     ParkingSpotSize.XL)
        else:
            return self._place_vehicle_to_sized_spot(vehicle,
                                                     ParkingSpotSize.XL)

    def _place_vehicle_to_sized_spot(self, vehicle: Vehicle,
                                     size: ParkingSpotSize) -> int:
        """
        Private helper method to place the given vehicle to a parking spot of
        the given size.
        :param vehicle: Vehicle
        :param size: ParkingSpotSize
        :return: int
        """
        size_available = self._available[size]
        if not size_available:
            return -1
        spot = size_available.popleft()
        spot.vehicle = vehicle
        self._parked[vehicle.license_plate] = spot
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
        vehicle = spot.vehicle
        # Free the parking spot
        spot.vehicle = None
        size_available = self._available[spot.size]
        size_available.append(spot)
        self._available[spot.size] = size_available
        return vehicle
        # Time: O(1)
