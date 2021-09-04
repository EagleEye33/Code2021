SUFFIXES = {1000: ['KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'],
			1024: ['KiB', 'MiB', 'GiB', 'TiB', 'PiB', 'EiB', 'ZiB', 'YiB']}

def approximate_size(size, a_kilobyte_is_1024_bytes=True):

	'''Convert a file size to human-readable form.

	Keyword arguments:
	size -- file size in bytes
	a_kilobyte_is_1024_bytes -- if True (default), use multiples of 1024
								if False, use multiples of 1000
	Returns: string

	'''

	if size < 0:
		raise ValueError('number must be non-negative')

	multiple = 1024 if a_kilobyte_is_1024_bytes else 1000
	for suffix in SUFFIXES[multiple]:
		size /= multiple
		if size < multiple:
			return '{0:.1f} {1}'.format(size, suffix)

	raise ValueError('number too large')

if __name__ == '__main__':
	print(approximate_size(1000000000000, False))
	print(approximate_size(1000000000000))  #note the default value


'''You called the Python intepreter on the
command line, and you passed the name of the script you wanted Python to execute. 
The script defines a single function, the approximate_size() function, 
which takes an exact file size in bytes and calculates a “pretty” (but approximate) size.'''

'''The print() function is built-in; you’ll never see
an explicit declaration of it. (built_in functions)'''

'''. Python functions do not specify the datatype of
their return value; they don’t even specify whether or not
they return a value.'''

'''There are no subroutines in Python.'''

'''. In Python, variables are never explicitly typed. Python figures out what
type a variable is and keeps track of it internally (as opposed to statically-typed languages).'''

approximate_size(4000, a_kilobyte_is_1024_bytes=False)
#'4.0 KB'
approximate_size(size=4000, a_kilobyte_is_1024_bytes=False)
#'4.0 KB'
approximate_size(a_kilobyte_is_1024_bytes=False, size=4000)
#'4.0 KB'
approximate_size(a_kilobyte_is_1024_bytes=False, 4000)
#File "<stdin>", line 1
#SyntaxError: non-keyword arg after keyword arg
approximate_size(size=4000, False) 
#File "<stdin>", line 1
#SyntaxError: non-keyword arg after keyword arg
'''As soon as you have a named argument, all arguments to the right
of that need to be named arguments, too.'''

'''Everything between the triple quotes is the function’s
docstring, which documents what the function does. must be the first thing defined in a
function if used'''

'''Changing 'C:\Users\wyatt\PycharmProjects\DiveIntoPython\Intro'
to 'C:/Users/wyatt/PycharmProjects/DiveIntoPython/Intro' fixed error when importing
through sys.path.insert in command line (not sure why. Unicode error?)'''

 '''>>> print(humansize.approximate_size.__doc__)
Convert a file size to human-readable form.
Keyword arguments:
size -- file size in bytes
a_kilobyte_is_1024_bytes -- if True (default), use multiples of 1024
if False, use multiples of 1000
Returns: string'''    
							#called docstring attribute

'''(Everything in Python is an Object) everything is an object in the sense that it can
be assigned to a variable or passed as an argument to a function.'''

'''raise statement is actually creating an instance of the
ValueError class and passing the string 
number must be non-negative' to its initialization method.'''

'''multiple = 1024 if a_kilobyte_is_1024_bytes else 1000

	You never declare the variable multiple, you just assign a value to it. '''




