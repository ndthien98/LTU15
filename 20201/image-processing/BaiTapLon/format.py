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
        help='Image to convert format')

    argparser.add_argument(
        '--format',
        default='jpg',
        help='Format type: jpg, png, ...')

    args, extra_args = argparser.parse_known_args()

    input_file = args.input_file

    print('Input file: ' + input_file)

    if not os.path.isfile(input_file):
        print('Error: File does not exist!')
        return

    # Open image
    img = cv2.imread(input_file)
    # Save as format 
    cv2.imwrite('./data/format.' + args.format, img)

main()
