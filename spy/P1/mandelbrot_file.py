# -*- coding: utf-8 -*-
# """
# Buchcode inkl. Kürzübungen: Kap. 7.

# last edited: 5-Aug-2022

# @author: Stefan Wicki
# """
"""
Zeichnet die Mandelbrotmenge.

::

   Projekt     : Zeichnet die Mandelbrotmenge
   Autor       : Stefan Wicki
   Dateiname   : Mandelbrot.py
   Beginndatum : 03.08.15
   Enddatum    : 12.08.15
   Version     : 1.0

Beschreibung
------------
Eine Mandelbrotmenge ist als Fraktalmenge bekannt. Punkte (Koordinaten in
der komplexen Ebene) werden solange iteriert bis sie entweder
konvergieren oder divergieren. Wie schnell ein Punkt divergiert (d.h. der
Betrag der komplexen Zahl eine gewisse Grenze überschreitet), bestimmt die
Farbe des selben. Punkte nahe des Zentrums (0, 0j) konvergieren eher
als solche, die weit weg sind.

Algortihmus
-----------
Der Algorithmus lautet folgendermassen (z ist eine komplexe Zahl):

    .. math ::
        z(n+1) = z(n) +z(n)^2
"""

import matplotlib.pyplot as plt
import numpy as np


# -----------------------------------------------------------------------------
# Initialisierungen:
# -----------------------------------------------------------------------------
# Definition des Gebietes in der komplexen Ebene

REAL_MIN = -2                   # Realteil negativster Punkt
REAL_MAX = 0.7                  # Realteil positivster Punkt
IMAG_MIN = -1j                  # Imaginärteil negativster Punkt
IMAG_MAX = 1j                   # Imaginärteil positivster Punkt
N_REAL = 100                    # Auflösung Punkte in x-Richtung (Realteil)
N_IMAG = 100                    # Auflösung Punkte in y-Richtung (Imaginärteil)
RE = np.linspace(REAL_MIN, REAL_MAX, N_REAL)    # realer Vektor
IM = np.linspace(IMAG_MIN, IMAG_MAX, N_IMAG)    # imaginärer Vektor

# Definition der Grenzen und Iterationen
GRENZE = 1e6                    # Grenze für divergieren
ITERA = 30                      # Anzahl Iterationen

# -----------------------------------------------------------------------------
# Mandelbrotmenge berechnen:
# -----------------------------------------------------------------------------
x = RE                              # x wird als reale Achse festgelegt
y = np.imag(IM)                     # y wird als imaginäre Achse festgelegt
ma = np.zeros([N_REAL, N_IMAG])     # Matrize ma wird mit 0 initialisiert

for k in range(N_REAL):          # k: Laufvariable für x-Achse
    for m in range(N_IMAG):      # m: Laufvariable für y-Achse
        z = 0                       # z: wird auf 0 initialisiert
        for n in range(ITERA):   # Schleife für jeden Punkt (x, y)
            z = np.square(z)        # z = z**2
            z = z+RE[k]+IM[m]       # z = z + z
            if abs(z) > GRENZE:     # Abbruchkriterium: |z| > GRENZE
                break               # Schleife vorzeitig verlassen
            ma[k, m] = n            # Anzahl Iterationen wird gespeichert

# -----------------------------------------------------------------------------
# Ausgabe
# -----------------------------------------------------------------------------
# Ausgabe vom Plot in der Ebene (contour plot)
fig1, ax2 = plt.subplots(constrained_layout=True)       # erstellen
ax2.contourf(x, y, np.flip(ma), 10, cmap=plt.cm.hot)    # zeichnen
ax2.axis('off')                                         # Achsen aus
ax2.set_aspect('equal')                                 # x/y gleich
plt.show()                                              # Figur zeichnen

# Ausgabe in 3D
plt.figure()                                      # neue Figur
ax = plt.axes(projection='3d')                          # erstellen
X, Y = np.meshgrid(x, y)                                # Gitter
ax.plot_surface(X, Y, ma, cmap='viridis')               # zeichnen
plt.title("Mandelbrot 3D")                              # Titel setzen
ax.axis('off')                                          # Achsen ausschalten
plt.show()                                              # Figur zeichnen
