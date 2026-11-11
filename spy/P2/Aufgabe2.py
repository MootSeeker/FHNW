# -*- coding: utf-8 -*-
"""
Aufgabe 2 - SPY

    Projekt:    Aufgabe 2
    Autor:      Kevin Perillo
    Dateiname:  Aufgabe2.py
    Datum:      10.10.2026
    Version:    1.0.0
    
Beschreibung
------------
Aufgabe nach Skript gelöst. 

Copyright (c) 2026 Kevin Perillo 

"""

#Benötigte Libraries includieren
import numpy as np

# a) Unterschied zwischen linspace und logspace:
# linspace erzeugt Werte mit gleichen linearen Abständen.
# Beispiel: np.linspace(0, 2, 3) ergibt [0, 1, 2].
help(np.linspace)

# logspace erzeugt Werte mit gleichen logarithmischen Abständen.
# Start und Ende sind Exponenten; die Basis ist standardmässig 10.
# Beispiel: np.logspace(0, 2, 3) ergibt [1, 10, 100].
help(np.logspace)

# b) Vektor a: 20 Elemente von 0 bis 19, ohne linspace.
a = np.arange(20)

# c) Vektor b: 20 Elemente von 0 bis 2*pi
b = np.linspace(0, 2 * np.pi, 20)

# d) Matrix A: 2 Zeilen und 20 Spalten.
# Erste Zeile: Werte aus a; zweite Zeile: Werte aus b.
A = np.array([a, b])

# e) Beide Elemente der letzten Spalte auf 0 setzen.
A[0][-1] = 0
A[1][-1] = 0
