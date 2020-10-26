from mpl_toolkits import mplot3d

import numpy as np
import matplotlib.pyplot as plt

def segment(xa, ya, xb, yb):
    return ((xa, ya), (xb, yb))


def read_from(filename):
    segments = []
    with open(filename, "r") as f:
        while True:
            numbers = list(map(float, f.readline().split()))
            if numbers == []:
                break
            segments.append(segment(*numbers))

    return segments


fig = plt.figure()
ax = plt.axes(projection="3d")

def plot_segments(index, segments):
    for s in segments:
        a, b = s
        xa, ya = a
        xb, yb = b
        ax.plot3D([index, index], [xa, xb], [ya, yb], c="g")

for i in range(0, 20):
    index = i + 1
    plot_segments(index, read_from("data3d/output%s" % index))

plt.show()
