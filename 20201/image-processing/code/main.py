import cv2
print(cv2.__version__)
img = cv2.imread('linkinpark.jpg')

# cv2.imshow('Display Image', img)
# cv2.waitKey(0)

(h, w, d) = img.shape
print("width={}, height={}, depth={}".format(w, h, d))
