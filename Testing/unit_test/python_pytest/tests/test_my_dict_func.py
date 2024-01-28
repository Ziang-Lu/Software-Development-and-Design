#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
pytest demo module by defining tests as functions.
The module name must start with "test_" or end with "_test".
"""

__author__ = 'Ziang Lu'

import sys

import pytest

from pytest_for_python.src.codes import MyDict


# Use pytest.mark.skip decorator if you want to simply skip a test
# @pytest.mark.skip(reason='No need to test the constructor for the time being')
@pytest.mark.skipif(sys.version_info < (3, 4), reason='Requires >= Python 3.4')
def test_init():
    """
    Any single function starts with "test_" will be tested by the framework.
    """
    d = MyDict(a=1, b='test')
    assert isinstance(d, dict)
    assert d.a == 1
    assert d.b == 'test'


@pytest.mark.skipif(sys.version_info < (3, 4), reason='Requires >= Python 3.4')
def test_key():
    d = MyDict()
    d['key'] = 'value'
    assert d.key == 'value'


@pytest.mark.skipif(sys.version_info < (3, 4), reason='Requires >= Python 3.4')
def test_key_error():
    d = MyDict()
    with pytest.raises(KeyError):
        d['key']


@pytest.mark.skipif(sys.version_info < (3, 4), reason='Requires >= Python 3.4')
def test_attr():
    d = MyDict()
    d.key = 'value'
    assert 'key' in d
    assert d['key'] == 'value'


@pytest.mark.skipif(sys.version_info < (3, 4), reason='Requires >= Python 3.4')
def test_attrerror():
    d = MyDict()
    with pytest.raises(AttributeError):
        d.key
