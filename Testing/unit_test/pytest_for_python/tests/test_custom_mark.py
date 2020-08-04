#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
pytest demo module by grouping tests into custom marks.
Note that the custom marks are registered in "pytest.ini"
"""

__author__ = 'Ziang Lu'

import pytest


# Some dummy tests

@pytest.mark.linux
def test_linux_1():
    assert True


@pytest.mark.linux
def test_linux_2():
    assert True


@pytest.mark.mac
def test_mac_1():
    assert True


@pytest.mark.mac
def test_mac_2():
    assert True


@pytest.mark.windows
def test_windows_1():
    assert True


@pytest.mark.windows
def test_windows_2():
    assert True
