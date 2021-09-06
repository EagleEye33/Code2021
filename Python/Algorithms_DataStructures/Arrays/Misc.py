# temp = ['a', 'b', 'c']
# letters = ''.join(temp)
# print(letters)
#
# import sys
#
# try:
#     n = int(sys.argv[1])
# except:
#     n = 100
#
# import sys                              # provides getsizeof function
# data = []
# for k in range(n):                      # NOTE: must fix choice of n
#   a = len(data)                         # number of elements
#   b = sys.getsizeof(data)               # actual size in bytes
#   print('Length: {0:3d}; Size in bytes: {1:4d}'.format(a, b))
#   data.append(None)                     # increase length by one
#
# try:
#     maxN = int(sys.argv[1])
# except:
#     maxN = 10000000
#
# from time import time            # import time function from time module
# def compute_average(n):
#   """Perform n appends to an empty list and return average time elapsed."""
#   data = []
#   start = time()                 # record the start time (in seconds)
#   for k in range(n):
#     data.append(None)
#   end = time()                   # record the end time (in seconds)
#   return (end - start) / n       # compute average per operation
#
# n = 10
# while n <= maxN:
#   print('Average of {0:.3f} for n {1}'.format(compute_average(n)*1000000, n))
#   n *= 10

# def find_repeat(A, n):
#     n = n-1
#     min = (n*(n+1))/2 + 1
#     sum1 = sum(A)
#     return 1 + sum1 - min

# B = [1,2,3,4,5,6,4,7]
# print(find_repeat(B, len(B)))

A = [[10,2],[1,3],[1,4]]
# result = [sum(A[j]) for j in range(len(A))]
# print(result)

def multi_add(A , n, x=0): #n is length
    x = sum(A[n-1])
    if(n == 1):
        return x
    return x + multi_add(A, n-1)


print(multi_add(A, len(A)))

