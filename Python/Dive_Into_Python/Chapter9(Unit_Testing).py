'''test-driven development, or TDD. The set of two conversion functions — to_roman(), 
and later from_roman() — can be written and tested as a unit, 
separate from any larger program that imports them.
Python has a framework for unit testing, the appropriately-named unittest module.'''


#A test case answers a single question about the code it is testing.


#Each test case is an island.


#Test case for to_roman function:
'''1. The to_roman() function should return 
the Roman numeral representation for all integers 1 to 3999.'''


import roman1
import unittest
class KnownValues(unittest.TestCase): ①   #first subclass the TestCase class of unittest module
	known_values = ( (1, 'I'),
						(2, 'II'),
						(3, 'III'),
						(4, 'IV'),
						(5, 'V'),
						(6, 'VI'),
						(7, 'VII'),
						(8, 'VIII'),
						(9, 'IX'),
						(10, 'X'),
						(50, 'L'),
						(100, 'C'),
						(500, 'D'),
						(1000, 'M'),
						(31, 'XXXI'),
						(148, 'CXLVIII'),
						(294, 'CCXCIV'),
						(312, 'CCCXII'),
						(421, 'CDXXI'),
						(528, 'DXXVIII'),
						(621, 'DCXXI'),
						(782, 'DCCLXXXII'),
						(870, 'DCCCLXX'),
						(941, 'CMXLI'),
						(1043, 'MXLIII'),
						(1110, 'MCX'),
						(1226, 'MCCXXVI'),
						(1301, 'MCCCI'),
						(1485, 'MCDLXXXV'),
						(1509, 'MDIX'),
						(1607, 'MDCVII'),
						(1754, 'MDCCLIV'),
						(1832, 'MDCCCXXXII'),
						(1993, 'MCMXCIII'),
						(2074, 'MMLXXIV'),
						(2152, 'MMCLII'),
						(2212, 'MMCCXII'),
						(2343, 'MMCCCXLIII'),
						(2499, 'MMCDXCIX'),
						(2574, 'MMDLXXIV'),
						(2646, 'MMDCXLVI'),
						(2723, 'MMDCCXXIII'),
						(2892, 'MMDCCCXCII'),
						(2975, 'MMCMLXXV'),
						(3051, 'MMMLI'),
						(3185, 'MMMCLXXXV'),
						(3250, 'MMMCCL'),
						(3313, 'MMMCCCXIII'),
						(3408, 'MMMCDVIII'),
						(3501, 'MMMDI'),
						(3610, 'MMMDCX'),
						(3743, 'MMMDCCXLIII'),
						(3844, 'MMMDCCCXLIV'),
						(3888, 'MMMDCCCLXXXVIII'),
						(3940, 'MMMCMXL'),
						(3999, 'MMMCMXCIX')) ②    #testing of input
def test_to_roman_known_values(self): ③   #no parameters and returns no value. Either raises and exception(fails) or exits normally(pass)
	'''to_roman should give known result with known input'''
	for integer, numeral in self.known_values:
		result = roman1.to_roman(integer) ④
		self.assertEqual(numeral, result) ⑤


'''First step is to define the API of the to_roman() function, but don't code yet'''

# roman1.py


def to_roman(n):
	'''convert integer to Roman numeral'''
	pass ①

roman_numeral_map = (('M', 1000),
					('CM', 900),
					('D', 500),
					('CD', 400),
					('C', 100),
					('XC', 90),
					('L', 50),
					('XL', 40),
					('X', 10),
					('IX', 9),
					('V', 5),
					('IV', 4),
					('I', 1)) ①   #tuple of tuples in descending order
def to_roman(n):
	'''convert integer to Roman numeral'''
	result = ''
	for numeral, integer in roman_numeral_map:
		while n >= integer: ②   #hinges off of descending tuple
			result += numeral
			n -= integer
	return result



#The to_roman() function should raise an OutOfRangeError when given an 
#integer greater than 3999.


def to_roman(n):
	'''convert integer to Roman numeral'''
	if not (0 < n < 4000): ①
		raise OutOfRangeError('number out of range (must be 1..3999)') ②

	result = ''
	for numeral, integer in roman_numeral_map:
		while n >= integer:
			result += numeral
			n -= integer
	return result


#Unit test for these new cases:
class ToRomanBadInput(unittest.TestCase):
	def test_too_large(self):
		'''to_roman should fail with large input'''
		self.assertRaises(roman3.OutOfRangeError, roman3.to_roman, 4000) ①

	def test_zero(self):
		'''to_roman should fail with 0 input'''
		self.assertRaises(roman3.OutOfRangeError, roman3.to_roman, 0) ②
	def test_negative(self):
		'''to_roman should fail with negative input'''
		self.assertRaises(roman3.OutOfRangeError, roman3.to_roman, -1) ③



#dealing with non-integers:
class NotIntegerError(ValueError): pass #define a NotIntegerError exception

#write test case:
class ToRomanBadInput(unittest.TestCase):
	.
	.
	.
	def test_non_integer(self):
		'''to_roman should fail with non-integer input'''
		self.assertRaises(roman4.NotIntegerError, roman4.to_roman, 0.5)

#write new code to pass test:
def to_roman(n):
	'''convert integer to Roman numeral'''
	if not (0 < n < 4000):
		raise OutOfRangeError('number out of range (must be 1..3999)')
	if not isinstance(n, int): ①   #built in type isintance() tests for a particular type
		raise NotIntegerError('non-integers can not be converted') ②

	result = ''
	for numeral, integer in roman_numeral_map:
		while n >= integer:
			result += numeral
			n -= integer
	return result


