'''you need to know what character encoding they
used so you can decode the bytes into characters.'''

'''ASCII encoding,
which stores English characters as numbers ranging from 0
to 127. (65 is capital “A”, 97 is lowercase “a”,'''

'''the multi-byte Unicode encodings define a “Byte Order Mark,” 
which is a special nonprintable character that you can include at the 
beginning of your document to indicate what order your bytes are in.'''

''' A document encoded in UTF-8 uses the exact same stream of bytes on any computer.'''

>>> s = 'æ·±å¥ Python' ①  #strings can be single or double quotes
>>> len(s) ②
9
>>> s[0] ③
'æ·±'
>>> s + ' 3' ④
'æ·±å¥ Python 3'


#A string is like a tuple of characters.

>>> username = 'mark'
>>> password = 'PapayaWhip' ①
>>> "{0}'s password is {1}".format(username, password) ②
"mark's password is PapayaWhip"
	
'''that’s a method call on a string literal. Strings are objects, and objects have
methods. 
{0} and {1} are replacement fields, which are
replaced by the arguments passed to the format() method.'''

>>> import humansize
>>> si_suffixes = humansize.SUFFIXES[1000] ①
>>> si_suffixes
['KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB']
>>> '1000{0[0]} = 1{0[1]}'.format(si_suffixes) ②
'1000KB = 1MB'

'''{0[0]} refers to the first item of the list which is the first argument
passed to the format() method: 'KB'. Meanwhile, 
{0[1]} refers to the second item of the same list: 'MB'.'''


'''format specifers can access
items and properties of data structures using (almost) Python
syntax. This is called compound field names'''


>>> import humansize
>>> import sys
>>> '1MB = 1000{0.modules[humansize].SUFFIXES[1000][0]}'.format(sys)
'1MB = 1000KB'


'''the replacement field {0.modules} refers to the dictionary of imported modules.
. In real
Python code, the keys of the sys.modules dictionary are strings; 
to refer to them, you need to put quotes
around the module name (e.g. 'humansize'). 
But within a replacement field, you skip the quotes around the
dictionary key name (e.g. humansize).'''


if size < multiple:
return '{0:.1f} {1}'.format(size, suffix)
#after the zero is the format specifier
#.1 means "rounds to the nearest tenth" and 'f' meand "fixed-point number"

>>> '{0:.1f} {1}'.format(698.24, 'GB')
'698.2 GB'


>>> s = '''Finished files are the re- ①
... sult of years of scientif-
... ic study combined with the
... experience of years.'''
>>> s.splitlines() ②
['Finished files are the re-',
'sult of years of scientif-',
'ic study combined with the',
'experience of years.']
>>> print(s.lower()) ③
finished files are the result of years of scientific study combined with the
experience of years.
>>> s.lower().count('f') ④
6
#lower() converts the string to lowercase. Notice the splitlines() method.

>>> query = 'user=pilgrim&database=master&password=PapayaWhip'
>>> a_list = query.split('&') ①
>>> a_list
['user=pilgrim', 'database=master', 'password=PapayaWhip']
>>> a_list_of_lists = [v.split('=', 1) for v in a_list] ②
>>> a_list_of_lists
[['user', 'pilgrim'], ['database', 'master'], ['password', 'PapayaWhip']]
>>> a_dict = dict(a_list_of_lists) ③
>>> a_dict
{'password': 'PapayaWhip', 'user': 'pilgrim', 'database': 'master'}


'''The split() string method takes one argument, a delimiter, 
and split a string into a list of strings based on the delimiter.'''


 #slicing a string:
 >>> a_string = 'My alphabet starts where your alphabet ends.'
>>> a_string[3:11] ①
'alphabet'
>>> a_string[3:-3] ②
'alphabet starts where your alphabet en'
>>> a_string[0:2] ③
'My'
>>> a_string[:18] ④
'My alphabet starts'
>>> a_string[18:] ⑤
' where your alphabet ends.'


''' STRINGS VS BYTES: An immutable sequence of Unicode characters is called a string.
An immutable sequence of numbers-between-0-and-255 is called a bytes object.'''


>>> by = b'abcd\x65' ①
>>> by
b'abcde'
>>> type(by) ②
#<class 'bytes'>
>>> len(by) ③
5
>>> by += b'\xff' ④
>>> by
b'abcde\xff'
>>> len(by) ⑤
6
>>> by[0] ⑥
97
>>> by[0] = 102 ⑦
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
TypeError: 'bytes' object does not support item assignment

'''To define a bytes object, use the b'' “byte literal” syntax. 
\x00 to \xff is hexadecimal
the items of a bytes object are integers.'''


'''To convert an bytes object into a mutable bytearray object, 
use the built-in bytearray() function.'''
>>> by = b'abcd\x65'
>>> barr = bytearray(by) ①
>>> barr
bytearray(b'abcde')
>>> len(barr) ②
5
>>> barr[0] = 102 ③
>>> barr
bytearray(b'fbcde')


#The one thing you can never do is mix bytes and strings.:
>>> by = b'd'
>>> s = 'abcde'
>>> by + s ①
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
#TypeError: can't concat bytes to str
>>> s.count(by) ②
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
#TypeError: Can't convert 'bytes' object to str implicitly
>>> s.count(by.decode('ascii')) ③
1
'''on line 174: “count the occurrences of the string that you would get after
decoding this sequence of bytes in this particular character encoding.”'''


''': bytes objects have a decode() method that takes a character
encoding and returns a string, and strings have an encode() method 
that takes a character encoding and returns a bytes object.'''

>>> a_string = 'æ·±å¥ Python' ①
>>> len(a_string)
9
>>> by = a_string.encode('utf-8') ②  #encode in UTF-8
>>> by
b'\xe6\xb7\xb1\xe5\x85\xa5 Python'
>>> len(by)
13
>>> by = a_string.encode('gb18030') ③ #encode in GB18030
>>> by
b'\xc9\xee\xc8\xeb Python'
>>> len(by)
11
>>> by = a_string.encode('big5') ④ #encode in Big5
>>> by
b'\xb2`\xa4J Python'
>>> len(by)
11
>>> roundtrip = by.decode('big5') ⑤ #decode using the Big5 encoding algorithm
>>> roundtrip
'æ·±å¥ Python'
>>> a_string == roundtrip
True

'''Python 3 assumes that your source code — i.e. each .py file — is encoded in UTF-8
If you would like to use a different encoding within your Python code, 
you can put an encoding declaration on the first line of each file.'''

#This declaration defines a .py file to be windows-1252:
# -*- coding: windows-1252 -*-