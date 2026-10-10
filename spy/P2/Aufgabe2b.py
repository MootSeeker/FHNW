# -*- coding: utf-8 -*-
"""
Aufgabe 2 - SPY

    Projekt:    Aufgabe 2 b
    Autor:      Kevin Perillo
    Dateiname:  Aufgabe2b.py
    Datum:      10.10.2026
    Version:    1.0.0
    
Beschreibung
------------
Aufgabe nach Skript gelöst. 

Copyright (c) 2026 Kevin Perillo 

"""

# Benötigte libraries importieren
import numpy as np
import matplotlib.pyplot as plt

# a) sin(x), sin(2x) und sin(3x) in einem gemeinsamen plot
x = np.linspace(0, 2 * np.pi, 500)

# Plot zusammenbauen
plt.figure(figsize=(8, 5))
plt.plot(x, np.sin(x), label="sin(x)")
plt.plot(x, np.sin(x * 2), label="sin(2x)")
plt.plot(x, np.sin(x * 3), label="sin(3x)")
plt.title("Verschiedene Sinusfunktionen")
plt.xlabel("x [rad]")
plt.ylabel("Funktionswert")
plt.legend()
plt.grid(True)
plt.tight_layout()

# b) Funktionen aus a) untereinander darstellen.
plt.figure(figsize=(8, 8))

plt.subplot(3, 1, 1)
plt.plot(x, np.sin(x), label="sin(x)")
plt.xlabel("x [rad]")
plt.ylabel("sin(x)")
plt.legend()
plt.grid(True)

plt.subplot(3, 1, 2)
plt.plot(x, np.sin(x * 2), label="sin(2x)")
plt.xlabel("x [rad]")
plt.ylabel("sin(2x)")
plt.legend()
plt.grid(True)

plt.subplot(3, 1, 3)
plt.plot(x, np.sin(x * 3), label="sin(3x)")
plt.xlabel("x [rad]")
plt.ylabel("sin(3x)")
plt.legend()
plt.grid(True)

plt.suptitle("Sinusfunktionen untereinander")
plt.tight_layout()


# c) e^x und ln(x) gemeinsam in einer neuen Figur.
# Werte empirisch ermittelt --> ln(0) = undef. --> x > 0 
x_log = np.linspace(0.1, 3, 200)

plt.figure(figsize=(8, 5))
plt.plot(x_log, np.exp(x_log), label="exp(x)")
plt.plot(x_log, np.log(x_log), label="ln(x)")
plt.title("Exponentialfunktion und natuerlicher Logarithmus")
plt.xlabel("x")
plt.ylabel("Funktionswert")
plt.legend()
plt.grid(True)
plt.tight_layout()

# Alle drei Figuren nach ihrer Erstellung anzeigen.
plt.show()

