									
									FINDING ALL OCCURRENCES OF A PATTERN


>>> import re
>>> re.findall('[0-9]+', '16 2-by-4s in rows of 8') ①
['16', '2', '4', '8']
>>> re.findall('[A-Z]+', 'SEND + MORE == MONEY') ②
['SEND', 'MORE', 'MONEY']
'''findall() takes a regular expression pattern and a string and finds all occurrences
of the pattern. Returns a list of substrings()'''


 >>> re.findall(' s.*? s', "The sixth sick sheikh's sixth sheep's sick.")
[' sixth s', " sheikh's s", " sheep's s"]
'''(.*?) identifies the shortest possible series of any character
re.findall() does not return overlapping matches'''


								FINDING THE UNIQUE ITEM IN A SEQEUNCE


>>> a_list = ['The', 'sixth', 'sick', "sheik's", 'sixth', "sheep's", 'sick']
>>> set(a_list) ①   #returns a set of unique strings
{'sixth', 'The', "sheep's", 'sick', "sheik's"}
>>> a_string = 'EAST IS EAST'
>>> set(a_string) ②   #string is sequence of characters
{'A', ' ', 'E', 'I', 'S', 'T'}
>>> words = ['SEND', 'MORE', 'MONEY']
>>> ''.join(words) ③    #concatenates all strings into one
'SENDMOREMONEY'
>>> set(''.join(words)) ④    #returns all unique characters
{'E', 'D', 'M', 'O', 'N', 'S', 'R', 'Y'}

unique_characters = set(''.join(words))



										MAKING ASSERTIONS



>>> assert 1 + 1 == 2 ①  #does nothing
>>> assert 1 + 1 == 3 ②     #raises AssertionError
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
AssertionError
>>> assert 2 + 2 == 5, "Only for very large values of 2" ③
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
AssertionError: Only for very large values of 2				



#this line of code:

assert len(unique_characters) <= 10, 'Too many letters'

#…is equivalent to this:

if len(unique_characters) > 10:
	raise AssertionError('Too many letters')



										GENERATOR EXPRESSIONS


>>> unique_characters = {'E', 'D', 'M', 'O', 'N', 'S', 'R', 'Y'}
>>> gen = (ord(c) for c in unique_characters) ①   #Like an anonymous function that yields values
>>> gen ②   #returns an iterator
<generator object <genexpr> at 0x00BADC10>
>>> next(gen) ③
69
>>> next(gen)
68
>>> tuple(ord(c) for c in unique_characters) ④
(69, 68, 77, 79, 78, 83, 82, 89)
'''you can iterate through all the possible values and return a tuple, list, or set'''


#Same thing but with a generator function :
def ord_map(a_string):
	for c in a_string:
		yield ord(c)
gen = ord_map(unique_characters)


			
										PERMUTATIONS

>>> import itertools ①    #itertools module
>>> perms = itertools.permutations([1, 2, 3], 2) ②    #Permutations of 3 taken 2 at a time. Returns an iterator
>>> next(perms) ③
(1, 2)
>>> next(perms)
(1, 3)
>>> next(perms)
(2, 1) ④
>>> next(perms)
(2, 3)
>>> next(perms)
(3, 1)
>>> next(perms)
(3, 2)
>>> next(perms) ⑤
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
StopIteration

#permutations() can take lists and strings:
>>> import itertools
>>> perms = itertools.permutations('ABC', 3) ①
>>> next(perms)
('A', 'B', 'C') ②
>>> next(perms)
('A', 'C', 'B')
>>> next(perms)
('B', 'A', 'C')
>>> next(perms)
('B', 'C', 'A')
>>> next(perms)
('C', 'A', 'B')
>>> next(perms)
('C', 'B', 'A')
>>> next(perms)
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
StopIteration
>>> list(itertools.permutations('ABC', 3)) ③  #see all permutations immediately
[('A', 'B', 'C'), ('A', 'C', 'B'),
('B', 'A', 'C'), ('B', 'C', 'A'),
('C', 'A', 'B'), ('C', 'B', 'A')]





										OTHER STUFF IN itertools

>>> import itertools
>>> list(itertools.product('ABC', '123')) ①  #returns iterator of cartesian product
[('A', '1'), ('A', '2'), ('A', '3'),
('B', '1'), ('B', '2'), ('B', '3'),
('C', '1'), ('C', '2'), ('C', '3')]
>>> list(itertools.combinations('ABC', 2)) ②  #no duplicate items in different order(3 choose 2)
[('A', 'B'), ('A', 'C'), ('B', 'C')]

>>> names = list(open('examples/favorite-people.txt', encoding='utf-8')) ① #returns a list of the lines in a text file
>>> names
['Dora\n', 'Ethan\n', 'Wesley\n', 'John\n', 'Anne\n',
'Mike\n', 'Chris\n', 'Sarah\n', 'Alex\n', 'Lizzie\n']
>>> names = [name.rstrip() for name in names] ②  #rstrip() strips trailing whitespace
>>> names
['Dora', 'Ethan', 'Wesley', 'John', 'Anne',
'Mike', 'Chris', 'Sarah', 'Alex', 'Lizzie']
>>> names = sorted(names) ③     #sort alphabetically
>>> names
['Alex', 'Anne', 'Chris', 'Dora', 'Ethan',
'John', 'Lizzie', 'Mike', 'Sarah', 'Wesley']
>>> names = sorted(names, key=len) ④   #or sort by key parameter
>>> names
['Alex', 'Anne', 'Dora', 'John', 'Mike',
'Chris', 'Ethan', 'Sarah', 'Lizzie', 'Wesley']


>>> import itertools
>>> groups = itertools.groupby(names, len) ①    #returns an iterator that generates pairs
>>> groups
<itertools.groupby object at 0x00BB20C0>
>>> list(groups)
[(4, <itertools._grouper object at 0x00BA8BF0>),
(5, <itertools._grouper object at 0x00BB4050>),
(6, <itertools._grouper object at 0x00BB4030>)]
>>> groups = itertools.groupby(names, len) ②    #to loop through again it must be called again
>>> for name_length, name_iter in groups: ③   #given a list of names already sorted by length
... print('Names with {0:d} letters:'.format(name_length))
... for name in name_iter:
... print(name)
...
Names with 4 letters:
Alex
Anne
Dora
John
Mike
Names with 5 letters:
Chris
Ethan
Sarah
Names with 6 letters:
Lizzie
Wesley



										TRANSLATE()


>>> translation_table = {ord('A'): ord('O')} ①   #translate table is dictionary
>>> translation_table ②      #ord() returns the ASCII value
{65: 79}
>>> 'MARK'.translate(translation_table) ③    #replaces all occurrences of the key
'MORK'


										EVAL()


>>> eval('1 + 1 == 2')
True
>>> eval('1 + 1 == 3')
False
>>> eval('9567 + 1085 == 10652')
True

#can handle any python expression:
>>> eval('"A" + "B"')
'AB'
>>> eval('"MARK".translate({65: 79})')
'MORK'
>>> eval('"AAAAA".count("A")')
5
>>> eval('["*"] * 5')
['*', '*', '*', '*', '*']

#can also reference global variables, functions and modules defined outside eval()
>>> x = 5
>>> eval("x * 5") ①
25
>>> eval("pow(x, 2)") ②
25
>>> import math
>>> eval("math.sqrt(x)") ③
2.2360679774997898				


#subprocess module allows you to run arbitrary shell commands and return them as a python string:
>>> import subprocess
>>> eval("subprocess.getoutput('ls ~')") ①
'Desktop Library Pictures \
Documents Movies Public \
Music Sites'
>>> eval("subprocess.getoutput('rm /some/random/file')") ②

#see pages 200-201 for "safe" use of eval()

import re
import itertools

def solve(puzzle):
	words = re.findall('[A-Z]+', puzzle.upper())
	unique_characters = set(''.join(words))
	assert len(unique_characters) <= 10, 'Too many letters'
	first_letters = {word[0] for word in words}
	n = len(first_letters)
	sorted_characters = ''.join(first_letters) + \
		''.join(unique_characters - first_letters)
	characters = tuple(ord(c) for c in sorted_characters)
	digits = tuple(ord(c) for c in '0123456789')
	zero = digits[0]
	for guess in itertools.permutations(digits, len(characters)):
		if zero not in guess[:n]:
			equation = puzzle.translate(dict(zip(characters, guess)))
			if eval(equation):
				return equation

if __name__ == '__main__':
	import sys
	for puzzle in sys.argv[1:]:
		print(puzzle)
		solution = solve(puzzle)
		if solution:
			print(solution)
