										DEFINING CLASSES:

The pass statement in Python is like a empty set of curly braces ({}) in Java or C.

Python classes can have something similar to a constructor: the __init__() method.


class Fib:
	'''iterator that yields numbers in the Fibonacci sequence''' ①
	def __init__(self, max): ②

'''The __init__() method is called immediately after an instance of the class is created'''


'''The first argument of every class method, including the __init__() method, is always a reference to the current
instance of the class. By convention, this argument is named self'''

'''Although you need to specify self explicitly when defining the method, you
do not specify it when calling the method; Python will add it for you automatically.'''






									INSTANTIATING CLASSES:


'''To instantiate a class, simply call the class as if it were a
function, passing the arguments that the __init__() method requires. 
The return value will be the newly created object.'''

>>> import fibonacci2
>>> fib = fibonacci2.Fib(100) ①  #create an instance of the Fib class
>>> fib ②
<fibonacci2.Fib object at 0x00DB8810>
>>> fib.__class__ ③      #built in attribuite to retreive metadata
<class 'fibonacci2.Fib'>
>>> fib.__doc__ ④     #access the instance's docstring
'iterator that yields numbers in the Fibonacci sequence'





									INSTANCE VARIABLES:


class Fib:
	def __init__(self, max):
		self.max = max ①
.
.
.
def __next__(self):
	fib = self.a
	if fib > self.max: ②   #self.max is referenced in the __next__() method


>>> import fibonacci2
>>> fib1 = fibonacci2.Fib(100)
>>> fib2 = fibonacci2.Fib(200)
>>> fib1.max
100
>>> fib2.max
200
'''if you create two Fib instances with
different maximum values, they will each remember their own values.'''



									A FIBONACCI ITERATOR


#building an iterator from scratch:
class Fib: ①  #always start with a class
	def __init__(self, max): ②   #An instance of this class calls this __init__ method with max
		self.max = max
	def __iter__(self): ③
		self.a = 0
		self.b = 1
		return self
	def __next__(self): ④
		fib = self.a
		if fib > self.max:
			raise StopIteration ⑤    #the iteration is exhausted
		self.a, self.b = self.b, self.a + self.b
		return fib ⑥    #spits out the next value; yield is only for generators


>>> from fibonacci2 import Fib
>>> for n in Fib(1000):
... print(n, end=' ')
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987
'''the for loop returns an instance of the Fib class and secretly returns an iterator 
object using this instance'''



									PLURAL RULES ITERATOR

class LazyRules:
	rules_filename = 'plural6-rules.txt'  #class variable - shared across all instances of the LazyRules class

	def __init__(self):
		self.pattern_file = open(self.rules_filename, encoding='utf-8') ① #open pattern file
		self.cache = [] #initialize the cache


>>> import plural6
>>> r1 = plural6.LazyRules()
>>> r2 = plural6.LazyRules()
>>> r1.rules_filename ①   #each instance inherits the rules_filename attribute
'plural6-rules.txt'
>>> r2.rules_filename
'plural6-rules.txt'
>>> r2.rules_filename = 'r2-override.txt' ② #doesn't affect other instances
>>> r2.rules_filename
'r2-override.txt'
>>> r1.rules_filename
'plural6-rules.txt'
>>> r2.__class__.rules_filename ③  #class attribute not changed
'plural6-rules.txt'
>>> r2.__class__.rules_filename = 'papayawhip.txt' ④ #now other instances are affected
>>> r1.rules_filename
'papayawhip.txt'
>>> r2.rules_filename ⑤ #except if that instance overridden that attribute
'r2-overridetxt'


def __iter__(self): ①
	self.cache_index = 0
	return self ② 
'''every __iter__() method must return an iterator. returning 'self' signals
that this class defines a __next__() method which will take care of returning
values throughout the iteration'''

def __next__(self): ① #gets called when say, a for loop call next(rules)
	.
	.
	.
	pattern, search, replace = line.split(None, 3)
	funcs = build_match_and_apply_functions( ②
		pattern, search, replace)
	self.cache.append(funcs) ③ #before returning 'funcs' save them in self.cache
	return funcs


def __next__(self):
	.
	.
	.
	line = self.pattern_file.readline() ①  #readline() vs readlines(): reads exactly one line
	#from an open file. File objects are iterators too(iterates all the way down)
	if not line: ②
		self.pattern_file.close()
		raise StopIteration ③
	.
	.
	.


def __next__(self):
	self.cache_index += 1
	if len(self.cache) >= self.cache_index:
		return self.cache[self.cache_index - 1] ①
	if self.pattern_file.closed:
		raise StopIteration ②
	.
	.
	.

#Check pages 177-179 for detailed analysis of this Iterator