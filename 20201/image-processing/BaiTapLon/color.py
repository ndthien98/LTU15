import numpy as np
import matplotlib.pyplot as plt
from matplotlib.pyplot import figure
import cv2 as cv2
import argparse
import os

def main():
    argparser = argparse.ArgumentParser()

    argparser.add_argument(
        '--input_file',
        default='./data/lenna.png',
        help='Image to resize')

    argparser.add_argument(
        '--color',
        default='RGB',
        help='Color space: RGB, CMYK, HSV')

    args, _ = argparser.parse_known_args()

    input_file = args.input_file
    output_file = './data/' + args.color + '_converted.png'

    if not os.path.isfile(input_file):
        print('Error: File does not exist!')
        return

    # Open image
    img = cv2.imread(input_file)

    print('Input file: ' + input_file)
    # Plot
     
    img_rgb = cv2.cvtColor(img,cv2.COLOR_BGR2RGB)
    img_hsv = cv2.cvtColor(img,cv2.COLOR_BGR2HSV)
    img_gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)



    plt.subplot(221)
    plt.imshow(img)
    plt.title('BGR')

    plt.subplot(222)
    plt.imshow(img_rgb)
    plt.title('RGB')

    plt.subplot(223)
    plt.imshow(img_hsv)
    plt.title('HSV')

    plt.subplot(224)
    plt.imshow(img_gray,cmap='Greys_r')
    plt.title('GRAY')

    plt.show()

main()
