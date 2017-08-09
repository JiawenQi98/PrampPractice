# Problems:

Given an array of integers *arr*, you’re asked to calculate for each index *i* the product of all integers except the integer at that index (i.e. except *arr[i]*). Implement a function *arrayOfArrayProducts* that takes an array of integers and returns an array of the products.

Solve *without using division* and analyze your solution’s time and space complexities.

# Examples:

input:  arr = [8, 10, 2]

output: [20, 16, 80] # by calculating: [10x2, 8x2, 8x10]

input:  arr = [2, 7, 3, 4]

output: [84, 24, 56, 42] # by calculating: [7x3x4, 2x3x4, 2x7x4, 2x7x3]

