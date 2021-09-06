import copy
class Vector:

  def __init__ (self, d):
      if(isinstance(d, int)):
        self._coords = [0]*d
      else:
        self._coords = d

  def __len__ (self):
   return len(self._coords)

  def __getitem__ (self, j):
   return self._coords[j]

  def __setitem__ (self, j, val):
   self._coords[j] = val

  def __add__ (self, other):
      if len(self) != len(other): # relies on len method
        raise ValueError( 'dimensions must agree' )
      result = Vector(len(self)) # start with vector of zeros
      for j in range(len(self)):
        result[j] = self[j] + other[j]
      return result

  def __radd__(self, other):
      if len(self) != len(other): # relies on len method
        raise ValueError( 'dimensions must agree' )
      result = Vector(len(self)) # start with vector of zeros
      for j in range(len(self)):
        result[j] = self[j] + other[j]
      return result


  def __sub__(self, other):
      if len(self) != len(other):
          raise ValueError("Dimensions must agree ")
      result = Vector(len(self))
      for j in range(len(self)):
        result[j] = self[j] - other[j]
      return result

  def __neg__(self):
      for j in range(len(self)):
          self[j] *= -1
      return self

  def __mul__(self, other):
      if isinstance(other, (int, float)):
        for j in range(len(self)):
            self[j] *= other
      else:
         for j in range(len(self)):
            self[j] *= other[j]
      return self

  def __rmul__(self, other):
      if isinstance(other, (int, float)):
        for j in range(len(self)):
            self[j] *= other
      else:
        for j in range(len(self)):
            self[j] *= other[j]
      return self

  def __eq__ (self, other):
      return self._coords == other._coords

  def __ne__ (self, other):
      return not self == other # rely on existing eq definition

  def __str__ (self):
      return '<' + str(self._coords)[1:-1] + '>'# adapt list representation

if __name__ == '__main__':
  # the following demonstrates usage of a few methods
  v = Vector(5)              # construct five-dimensional <0, 0, 0, 0, 0>
  v[1] = 23                  # <0, 23, 0, 0, 0> (based on use of __setitem__)
  v[-1] = 45                 # <0, 23, 0, 0, 45> (also via __setitem__)
  l = Vector(5)
  l[1] = 5
  l[4] = 10
  print(v[4])                # print 45 (via __getitem__)
  u = v + v                  # <0, 46, 0, 0, 90> (via __add__)
  print(u)                   # print <0, 46, 0, 0, 90>
  p = u - l
  print(p)
  print(-u)
  total = 0
  k = [0, 0, 0, 5, 10] + v
  print(k)
  k *= 5
  print(k)
  k = 2 * k
  print(k)
  v *= v
  print(v)
  w = Vector([4, 7, 5])
  print(w)
  for entry in v:            # implicit iteration via __len__ and __getitem__
    total += entry

  print(len(range(0, 16, 3)))
# class Progression:
#
#
#   def __init__(self, start=0):
#       self._current = start
#
#   def _advance(self):
#       self._current += 1
#
#   def __next__(self):
#       if self._current is None:
#           raise StopIteration()
#       else:
#           answer = self._current  # record current value to return
#           self._advance()  # advance to prepare for next time
#           return answer  # return the answer
#
#   def __iter__(self):
#       return self
#
#   def print_progression(self, n):
#       print(' '.join(str(next(self)) for j in range(n)))
#
# Progression().print_progression(10)

# a = [1, 2, 3]
# b = [4 ,5 ,6]
# c = [a, b]
# d = copy.copy(c)
# d[0][0] += 5
# print(d)
# print(c)
