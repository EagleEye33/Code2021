'''. In Python, every value
has a datatype, but you don’t need to declare the datatype of variables. 
How does that work? Based on each variable’s original assignment, 
Python figures out what type it is and keeps tracks of that internally'''

'''3. Strings are sequences of Unicode characters, e.g. an HTML document.
4. Bytes and byte arrays, e.g. a JPEG image file.
5. Lists are ordered sequences of values.
6. Tuples are ordered, immutable sequences of values.
7. Sets are unordered bags of values.
8. Dictionaries are unordered bags of key-value pairs.'''

'''. Everything is an object in Python, so there are types like module,
function, class, method, file, and even compiled code. '''

'''You can use virtually any expression in a boolean context.'''

'''Due to some legacy issues left over from Python 2, booleans can be treated as numbers. True is 1; False is 0.
>>> True + True
2  
'''

'''. Python supports both integers and floating point
numbers. There’s no type declaration to distinguish them'''

type(1) #<class 'int'>

isinstance(1, int) #True

type(2.0) #<class 'float'>

1 + 1.0 #2.0



>>> float(2) ①
2.0
>>> int(2.0) ②
2
>>> int(2.5) ③ #truncate not round
2
>>> int(-2.5) ④ #truncate towards zero
-2
>>> 1.12345678901234567890 ⑤ #accurate to 15 decimal places
1.1234567890123457
>>> type(1000000000000000) ⑥
<class 'int'>



>>> 11 / 2 ①
5.5
>>> 11 // 2 ②
5
>>> −11 // 2 ③  #rounds "up" not truncate
−6
>>> 11.0 // 2 ④
5.0
>>> 11 ** 2 ⑤
121
>>> 11 % 2 ⑥
1



>>> import fractions ①
>>> x = fractions.Fraction(1, 3) ② #Numerator then Denominator
>>> x
Fraction(1, 3)
>>> x * 2 ③
Fraction(2, 3)
>>> fractions.Fraction(6, 4) ④ 
Fraction(3, 2)                  #auto reduce
>>> fractions.Fraction(0, 0) ⑤  #division by zero
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
File "fractions.py", line 96, in __new__
raise ZeroDivisionError('Fraction(%s, 0)' % numerator)
ZeroDivisionError: Fraction(0, 0)



>>> import math
>>> math.pi ①
3.1415926535897931
>>> math.sin(math.pi / 2) ②
1.0
>>> math.tan(math.pi / 4) ③  #no infinite precision
0.99999999999999989


>>> def is_it_true(anything): ①  #boolean context for numbers
... if anything:
... print("yes, it's true")
... else:
... print("no, it's false")
...
>>> is_it_true(1) ②
#yes, it's true
>>> is_it_true(-1)
#yes, it's true
>>> is_it_true(0)
#no, it's false
>>> is_it_true(0.1) ③
#yes, it's true
>>> is_it_true(0.0)
#no, it's false
>>> import fractions
>>> is_it_true(fractions.Fraction(1, 2)) ④
#yes, it's true
>>> is_it_true(fractions.Fraction(0, 1))
#no, it's false



















										LISTS:




#A list in Python is like an ArrayList in Java,
#which can hold arbitrary objects and can expand dynamically as new items are added.


>>> a_list = ['a', 'b', 'mpilgrim', 'z', 'example'] ①
>>> a_list
['a', 'b', 'mpilgrim', 'z', 'example']
>>> a_list[0] ②
'a'
>>> a_list[4] ③
'example'
>>> a_list[-1] ④
'example'
>>> a_list[-3] ⑤
'mpilgrim'

#The last item of any non-empty list is always a_list[-1].


>>> a_list
['a', 'b', 'mpilgrim', 'z', 'example']
>>> a_list[1:3] ①
['b', 'mpilgrim']  #slicing a list: up to but not including the second slice
>>> a_list[1:-1] ②
['b', 'mpilgrim', 'z']
>>> a_list[0:3] ③
['a', 'b', 'mpilgrim']
>>> a_list[:3] ④     #zero is implied
['a', 'b', 'mpilgrim']  
>>> a_list[3:] ⑤    #rest of list implied
['z', 'example']
>>> a_list[:] ⑥
['a', 'b', 'mpilgrim', 'z', 'example']   #copy of original list



>>> a_list = ['a']
>>> a_list = a_list + [2.0, 3] ①
>>> a_list ②
['a', 2.0, 3]
>>> a_list.append(True) ③
>>> a_list
['a', 2.0, 3, True]
>>> a_list.extend(['four', 'Ω']) ④
>>> a_list
['a', 2.0, 3, True, 'four', 'Ω']
>>> a_list.insert(0, 'Ω') ⑤  #bump item in position 0 up and added 'Ω' to beginning
>>> a_list
['Ω', 'a', 2.0, 3, True, 'four', 'Ω']

'''A list can contain items of any datatype, 
and the items in a single list don’t all need to be the same type.'''



>>> a_list = ['a', 'b', 'c']
>>> a_list.extend(['d', 'e', 'f']) ①
>>> a_list
['a', 'b', 'c', 'd', 'e', 'f']
>>> len(a_list) ②
6
>>> a_list[-1]
'f'
>>> a_list.append(['g', 'h', 'i']) ③
>>> a_list
['a', 'b', 'c', 'd', 'e', 'f', ['g', 'h', 'i']]
>>> len(a_list) ④
7
>>> a_list[-1]
['g', 'h', 'i']
#note the difference between extend and append


>>> a_list = ['a', 'b', 'new', 'mpilgrim', 'new']
>>> a_list.count('new') ①  #count occurrences 
2
>>> 'new' in a_list ②
True
>>> 'c' in a_list
False
>>> a_list.index('mpilgrim') ③   #you CAN specify a second and third argument to start and 
3									#stop searching
>>> a_list.index('new') ④   #note that we count the first occurrence
2
>>> a_list.index('c') ⑤   #raises exception
Traceback (innermost last):
File "<interactive input>", line 1, in ?
ValueError: list.index(x): x not in list


#removing items from a list:
>>> a_list = ['a', 'b', 'new', 'mpilgrim', 'new']
>>> a_list[1]
'b'
>>> del a_list[1] ①
>>> a_list
['a', 'new', 'mpilgrim', 'new']
>>> a_list[1] ②
'new'



>>> a_list.remove('new') ①   #or use the remove() method to find a value
>>> a_list
['a', 'mpilgrim', 'new']
>>> a_list.remove('new') ②
>>> a_list
['a', 'mpilgrim']
>>> a_list.remove('new')
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
ValueError: list.remove(x): x not in list


'''Tuples are faster than lists and makes code safer. Some tuples can be used 
as dictionary keys
Tuples can be converted into lists, and vice-versa. The built-in tuple() function takes a
list and returns a tuple with the same elements, and the list() function takes a tuple
and returns a list. In effect, tuple() freezes a list, and list() thaws a tuple.'''


'''the pop() method: . When called without arguments, 
the pop() list method removes the last item in the list and returns the value it'''
>>> a_list = ['a', 'b', 'new', 'mpilgrim']
>>> a_list.pop() ①
'mpilgrim'
>>> a_list
['a', 'b', 'new']
>>> a_list.pop(1) ②
'b'
>>> a_list
['a', 'new']
>>> a_list.pop()
'new'
>>> a_list.pop()
'a'
>>> a_list.pop() ③
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
IndexError: pop from empty list


#In a boolean context: Any list with at least one item is true.



















										TUPLES:




#Tuples are immutable
>>> a_tuple = ("a", "b", "mpilgrim", "z", "example") ①   #parentheses instead of brackets
>>> a_tuple
('a', 'b', 'mpilgrim', 'z', 'example')
>>> a_tuple[0] ②
'a'
>>> a_tuple[-1] ③
'example'
>>> a_tuple[1:3] ④
('b', 'mpilgrim')


'''. Lists have methods
like append(), 
extend(), insert(), remove(), and pop(). Tuples have none of these methods.'''



'''Tuples are faster than lists and makes code safer. Some tuples can be used 
as dictionary keys
Tuples can be converted into lists, and vice-versa. The built-in tuple() function takes a
list and returns a tuple with the same elements, and the list() function takes a tuple
and returns a list. In effect, tuple() freezes a list, and list() thaws a tuple.'''


>>> type((False)) ④     
#<class 'bool'>
>>> type((False,))     #To create a tuple of one item, you need a comma after the value.
#<class 'tuple'>


#Assign multiple values at once:
>>> v = ('a', 2, True)
>>> (x, y, z) = v ①
>>> x
'a'
>>> y
2
>>> z
True


>>> (MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY) = range(7) ①
>>> MONDAY ②
0
>>> TUESDAY
1
>>> SUNDAY
6






							









										SETS:




'''Sets: Once you have 
two sets, you can do standard set operations 
like union, intersection, and set difference'''


>>> a_set = {1} ①
>>> a_set
{1}
>>> type(a_set) ②
#<class 'set'>
>>> a_set = {1, 2} ③
>>> a_set
{1, 2}


#create a set out of a list:
>>> a_list = ['a', 'b', 'mpilgrim', True, False, 42]
>>> a_set = set(a_list) ①
>>> a_set ②
{'a', False, 'b', True, 'mpilgrim', 42}
>>> a_list ③
['a', 'b', 'mpilgrim', True, False, 42]


>>> a_set = set() ①
>>> a_set ②
set()     # {} would represent an empty dictionary
>>> type(a_set) ③
#<class 'set'>
>>> len(a_set) ④
0
>>> not_sure = {} ⑤
>>> type(not_sure)   # due to python 2 this is an empty dictionary
#<class 'dict'>


#Modifying a Set:
>>> a_set = {1, 2}
>>> a_set.add(4) ①
>>> a_set
{1, 2, 4}
>>> len(a_set) ②
3
>>> a_set.add(1) ③
>>> a_set
{1, 2, 4}
>>> len(a_set) ④
3
#Sets are bags of UNIQUE values


#Using the update() method:
>>> a_set = {1, 2, 3}
>>> a_set
{1, 2, 3}
>>> a_set.update({2, 4, 6}) ①
>>> a_set ②
{1, 2, 3, 4, 6}
>>> a_set.update({3, 6, 9}, {1, 2, 3, 5, 8, 13}) ③
>>> a_set
{1, 2, 3, 4, 5, 6, 8, 9, 13}
>>> a_set.update([10, 20, 30]) ④    #can even use lists with update()
>>> a_set
{1, 2, 3, 4, 5, 6, 8, 9, 10, 13, 20, 30}


#Removing items from a set:
>>> a_set = {1, 3, 6, 10, 15, 21, 28, 36, 45}
>>> a_set
{1, 3, 36, 6, 10, 45, 15, 21, 28}
>>> a_set.discard(10) ①
>>> a_set
{1, 3, 36, 6, 45, 15, 21, 28}
>>> a_set.discard(10) ②
>>> a_set
{1, 3, 36, 6, 45, 15, 21, 28}
>>> a_set.remove(21) ③
>>> a_set
{1, 3, 36, 6, 45, 15, 28}
>>> a_set.remove(21) ④
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
KeyError: 21
'''Difference between discard() and remove():
 if the value doesn’t exist in the set, the remove() method raises a KeyError exception.'''


#Using the pop() method with Sets:
>>> a_set = {1, 3, 6, 10, 15, 21, 28, 36, 45}
>>> a_set.pop() ①  #pops random values
1
>>> a_set.pop()    #pops random values
3
>>> a_set.pop()    #pops random values
36
>>> a_set
{6, 10, 45, 15, 21, 28}
>>> a_set.clear() ②    #clears the set
>>> a_set
set()           #empty set
>>> a_set.pop() ③
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
KeyError: 'pop from an empty set'


#Common set operations:
>>> a_set = {2, 4, 5, 9, 12, 21, 30, 51, 76, 127, 195}
>>> 30 in a_set ①  #Use the 'in' operator to test for a value in the Set
True
>>> 31 in a_set
False
>>> b_set = {1, 2, 3, 5, 6, 8, 9, 12, 15, 17, 18, 21}
>>> a_set.union(b_set) ②
{1, 2, 195, 4, 5, 6, 8, 12, 76, 15, 17, 18, 3, 21, 30, 51, 9, 127}
>>> a_set.intersection(b_set) ③
{9, 2, 12, 5, 21}
>>> a_set.difference(b_set) ④   #in Set 'a' but not 'b'
{195, 4, 76, 51, 30, 127}
>>> a_set.symmetric_difference(b_set) ⑤
{1, 3, 4, 6, 8, 76, 15, 17, 18, 195, 127, 30, 51}

#symmetric difference: XOR 


# continued from the previous example
>>> b_set.symmetric_difference(a_set) ①
{3, 1, 195, 4, 6, 8, 76, 15, 17, 18, 51, 30, 127}
>>> b_set.symmetric_difference(a_set) == a_set.symmetric_difference(b_set) ②
True    #They are EQUAL
>>> b_set.union(a_set) == a_set.union(b_set) ③
True
>>> b_set.intersection(a_set) == a_set.intersection(b_set) ④
True
>>> b_set.difference(a_set) == a_set.difference(b_set) ⑤
False    #not symmetric. Order of operands matter


#Subsets:
>>> a_set = {1, 2, 3}
>>> b_set = {1, 2, 3, 4}
>>> a_set.issubset(b_set) ①
True
>>> b_set.issuperset(a_set) ②
True
>>> a_set.add(5) ③
>>> a_set.issubset(b_set)
False
>>> b_set.issuperset(a_set)
False



#In a boolean context, an empty set is false.





















								DICTIONARIES:



'''When you add a key to a dictionary, you must also add a
value for that key. (You can always change the value later.) 
Python dictionaries are optimized for retrieving the
value when you know the key, but not the other way around.'''

>>> a_dict = {'server': 'db.diveintopython3.org', 'database': 'mysql'} ①
>>> a_dict
{'server': 'db.diveintopython3.org', 'database': 'mysql'}
>>> a_dict['server'] ②
'db.diveintopython3.org'
>>> a_dict['database'] ③
'mysql'
>>> a_dict['db.diveintopython3.org'] ④
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
KeyError: 'db.diveintopython3.org'


#Modifying a Dictionary
>>> a_dict
{'server': 'db.diveintopython3.org', 'database': 'mysql'}
>>> a_dict['database'] = 'blog' ①  #You can not have duplicate keys in a dictionary. 
>>> a_dict
{'server': 'db.diveintopython3.org', 'database': 'blog'}
>>> a_dict['user'] = 'mark' ②
>>> a_dict ③
{'server': 'db.diveintopython3.org', 'user': 'mark', 'database': 'blog'}
>>> a_dict['user'] = 'dora' ④
>>> a_dict
{'server': 'db.diveintopython3.org', 'user': 'dora', 'database': 'blog'}
>>> a_dict['User'] = 'mark' ⑤
>>> a_dict
{'User': 'mark', 'server': 'db.diveintopython3.org', 'user': 'dora', 'database': 'blog'}


'''. MIXED-VALUE DICTIONARIES:
Dictionary values can be any datatype
And within a single dictionary, the values don’t all need to be the same type'''

SUFFIXES = {1000: ['KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'],
1024: ['KiB', 'MiB', 'GiB', 'TiB', 'PiB', 'EiB', 'ZiB', 'YiB']}

>>> SUFFIXES = {1000: ['KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'],
... 1024: ['KiB', 'MiB', 'GiB', 'TiB', 'PiB', 'EiB', 'ZiB', 'YiB']}
>>> len(SUFFIXES) ①
2
>>> 1000 in SUFFIXES ②
True
>>> SUFFIXES[1000] ③
['KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB']
>>> SUFFIXES[1024] ④
['KiB', 'MiB', 'GiB', 'TiB', 'PiB', 'EiB', 'ZiB', 'YiB']
>>> SUFFIXES[1000][3] ⑤   #Is a list so you can address individual items
'TB'
'''The SUFFIXES dictionary contains Lists as datatypes.
1000 and 1024 is a key is SUFFIXES; both are a list value of eight items'''


#In a boolean context, an empty dictionary is false
















										

									NONE:



'''A special constant in python. it is a null value and the only null value.
unique datatype of NoneType'''


>>> type(None)
#<class 'NoneType'>
>>> None == False
False
>>> None == 0
False
>>> None == ''
False
>>> None == None
True
>>> x = None
>>> x == None
True
>>> y = None
>>> x == y
True

#In a boolean context, None is false and not None is true

