import numpy as np

# a)
help(np.linspace)
help(np.logspace)

# b)
a = np.arange(20)

# c)
b = np.linspace(0, 2*np.pi, 20)

# d)
A = np.array([a, b])

# e)
A[0][-1] = 0
A[1][-1] = 0