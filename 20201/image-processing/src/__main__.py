import cv2 as cv
import numpy as np
from matplotlib import pyplot as plt

img = cv.imread('data/hieu.jpg')

plt.subplot(221), plt.imshow(img), plt.title('ORIGINAL')
plt.show()

