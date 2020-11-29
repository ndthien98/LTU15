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
        '--width',
        default='100',
        help='Width scale rate, 0 - 100')

    argparser.add_argument(
        '--height',
        default='100',
        help='Height scale rate, 0 - 100')

    args, _ = argparser.parse_known_args()

    input_file = args.input_file
    output_file = './data/resized.png'

    if not os.path.isfile(input_file):
        print('Error: File does not exist!')
        return

    # Open image
    img = cv2.imread(input_file)

    width_scale = int(args.width)
    height_scale = int(args.height)

    width = int(img.shape[1] * width_scale / 100)
    height = int(img.shape[0] * height_scale / 100)
    dim = (width, height)

    img_resized = cv2.resize(img, dim, interpolation=cv2.INTER_AREA)
    
    cv2.imwrite(output_file, img_resized)
    
    print('Input file: ' + input_file)
    print('Output file: ' + output_file)
    # Plot
     
    plt.subplot(122)
    plt.imshow(cv2.cvtColor(img_resized,cv2.COLOR_BGR2RGB))
    plt.title('Resized')
    plt.subplot(121)
    plt.imshow(cv2.cvtColor(img,cv2.COLOR_BGR2RGB))
    plt.title('Origin')
    plt.show()

main()
