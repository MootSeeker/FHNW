# -*- coding: utf-8 -*-
"""
Created on Fri Nov  6 09:58:29 2026

@author: kevin
"""


def dual(a, b):
    add = a + b
    sub = a - b
    div = a / b
    mul = a * b
    pows = pow(a, b)

    return (add, sub, mul, div, pows)


print(dual(2, 5))