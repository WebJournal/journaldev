import argparse

parser = argparse.ArgumentParser()
parser.add_argument('number', help="Enter number to triple it.")
args = parser.parse_args()
print(args.number*3)