import cv2
print('OpenCV version: ',cv2.__version__)

img = cv2.imread('linkinpark.jpg')
(h, w, d) = img.shape
print("width={}, height={}, depth={}".format(w, h, d))
print(img[700][700])

# cv2.imshow('Display Image', img)
# cv2.waitKey(0)
