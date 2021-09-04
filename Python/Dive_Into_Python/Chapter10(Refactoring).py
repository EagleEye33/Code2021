#A bug is a test case you haven’t written yet.

def from_roman(s):
	'''convert Roman numeral to integer'''
	if not s: ①   #check for empty string and raise exception if so
		raise InvalidRomanNumeralError('Input can not be blank')
	if not re.search(romanNumeralPattern, s):
		raise InvalidRomanNumeralError('Invalid Roman numeral: {}'.format(s)) ②


	result = 0
	index = 0
	for numeral, integer in romanNumeralMap:
		while s[index:index+len(numeral)] == numeral:
			result += integer
			index += len(numeral)
	return result


'''since
you can easily re-run all the test cases along with your new one, 
you are much less likely to break old code when
fixing new code. Today’s unit test is tomorrow’s regression test.'''


'''Refactoring is the process of taking working code and making it work better. 
Usually, “better” means “faster”, although it can also mean “using less memory”, 
or “using less disk space”, or simply “more elegantly”.'''

'''You can change over half the code in the module,
but the unit tests will stay the same'''

build_lookup_tables()
'''a function call but it gets called when the module is imported, then cached'''

to_roman_table = [ None ]
from_roman_table = {}
.
.
.
def build_lookup_tables():
	def to_roman(n): ①   #redefine function - only defined in local scope 
		result = ''
		for numeral, integer in roman_numeral_map:
			if n >= integer:
				result = numeral
				n -= integer
				break
		if n > 0:
			result += to_roman_table[n]
		return result
	for integer in range(1, 5000):
		roman_numeral = to_roman(integer) ②   
		to_roman_table.append(roman_numeral) ③   #this table is only a list 
		from_roman_table[roman_numeral] = integer   #a dictionary 



def to_roman(n):
	'''convert integer to Roman numeral'''
	if not (0 < n < 5000):
		raise OutOfRangeError('number out of range (must be 1..4999)')
	if int(n) != n:
		raise NotIntegerError('non-integers can not be converted')
	return to_roman_table[n] ①  #notice the lookup table is in order i.e the 10th item in the list is the roman numeral representation of 10

def from_roman(s):
	'''convert Roman numeral to integer'''
	if not isinstance(s, str):
		raise InvalidRomanNumeralError('Input must be a string')
	if not s:
		raise InvalidRomanNumeralError('Input can not be blank')
	if s not in from_roman_table:
		raise InvalidRomanNumeralError('Invalid Roman numeral: {0}'.format(s))
	return from_roman_table[s] ②    #accesses the proper key value pairs in the dictionary


#Unit tests can give you the confidence to do large-scale refactoring.

