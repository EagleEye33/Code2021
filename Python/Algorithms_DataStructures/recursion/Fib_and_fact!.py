def factorial(n):
  if n == 0:
    return 1
  else:
    return n * factorial(n-1)


def bad_fibonacci(n):
  """Return the nth Fibonacci number."""
  if n <= 1:
    return n
  else:
    return bad_fibonacci(n-2) + bad_fibonacci(n-1)

def good_fibonacci(n):
  """Return pair of Fibonacci numbers, F(n) and F(n-1)."""
  if n <= 1:
    return (n,0)
  else:
    (a, b) = good_fibonacci(n-1)
    return (a+b, a)

# print(bad_fibonacci(4))


# def findMaxRec(A, n):
#     # if n = 0 means whole array
#     # has been traversed
#     if (n == 1):
#         return A[0]
#     return max(A[n - 1], findMaxRec(A, n - 1))
#
#
#
# # Driver Code
# if __name__ == "__main__":
#     A = [1, 4, 45, 6, -50, 10, 2]
#     n = len(A)
#     print(findMaxRec(A, n))
# def pro(m, n):
#     if(n == 1):
#         return m
#     return pro(m, n-1) + m
#
# print(pro(0, 0))


# def subs(l):
#     if l == []:
#         return [[]]
#
#     x = subs(l[1:])
#
#     return x + [[l[0]] + y for y in x]
#
# print (subs([23, 4, 13]))
