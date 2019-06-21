#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
MyDict implementation that allows getting and setting key-value pairs as
attributes.
"""

__author__ = 'Ziang Lu'

from typing import Any


class MyDict(dict):
    """
    An dictionary class that acts the same as "dict", but also allows accessing
    values by keys as attributes.
    """
    __slots__ = []

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def __getattr__(self, key: Any) -> Any:
        try:
            return self[key]
        except KeyError:
            # To let this dict act like a class, transform KeyError to
            # ArributeError
            raise AttributeError(f"'Dict' object has no attribute '{key}'")

    def __setattr__(self, key: Any, val: Any) -> None:
        self[key] = val
