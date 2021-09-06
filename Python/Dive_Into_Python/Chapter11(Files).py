#Files are the primary storage paradigm of every major operating system

										READING FROM TEXT FILES

#Before you can read from a file, you need to open it:
a_file = open('examples/chinese.txt', encoding='utf-8')

#Python has a built-in open() function

#in Python, forward slashes always Just Work, even on Windows(which uses backslashes).

#The directory path does not begin with a slash or a drive letter, so it is called a relative path.

#It doesn’t need to be on your local disk.

#characters are an abstraction

'''A string is a sequence of Unicode characters. But a file on disk is
not a sequence of Unicode characters; a file on disk is a sequence of bytes.'''

# This example was created on Windows. Other platforms may
# behave differently, for reasons outlined below.


>>> file = open('examples/chinese.txt')
>>> a_string = file.read()
Traceback (most recent call last):
	File "<stdin>", line 1, in <module>
	File "C:\Python31\lib\encodings\cp1252.py", line 23, in decode
		return codecs.charmap_decode(input,self.errors,decoding_table)[0]
UnicodeDecodeError: 'charmap' codec can't decode byte 0x8f in position 28: character maps to <undefined>
>>>
#no character encoding was specified so python uses the default encoding which
#didn't support the characters that are in the above file

'''If you need to get the default character encoding, import the locale module and call
locale.getpreferredencoding()'''

'''The default encoding is platform-dependent, so this code might work on your
computer (if your default encoding is UTF-8), 
but then it will fail when you distribute it to someone else (whose
default encoding is different, like CP-1252).'''


										STREAM OBJECTS


#The open() function returns a stream object
>>> a_file = open('examples/chinese.txt', encoding='utf-8')
>>> a_file.name ①    #name attribute 
'examples/chinese.txt'
>>> a_file.encoding ②   #encoding attribute
'utf-8'
>>> a_file.mode ③    #mode attribute tell which mode the file was opened. Python defaults to 'r'
'r'


								 READING DATA FROM A TEXT FILE

>>> a_file = open('examples/chinese.txt', encoding='utf-8')
>>> a_file.read() ①    #Reading is just a matter of calling the stream object's read() method
'Dive Into Python æ¯ä¸ºæç» éªçç¨åº åç¼åçä¸ æ¬ Python ä¹¦ã\n'
>>> a_file.read() ②    #does not raise exception
''


#re-read a file:
# continued from the previous example
>>> a_file.read() ①
''
>>> a_file.seek(0) ②
0
>>> a_file.read(16) ③
'Dive Into Python'
>>> a_file.read(1) ④
' '
>>> a_file.read(1)
'æ¯'
>>> a_file.tell() ⑤  #counting by bytes and chinese characters require multiple bytes
20


#No character at the 18th byte - starts at 17th and goes for three bytes:
>>> a_file.seek(18) ①
18
>>> a_file.read(1) ②
Traceback (most recent call last):
File "<pyshell#12>", line 1, in <module>
a_file.read(1)
File "C:\Python31\lib\codecs.py", line 300, in decode
(result, consumed) = self._buffer_decode(data, self.errors, final)
UnicodeDecodeError: 'utf8' codec can't decode byte 0x98 in position 0: unexpected code byte




										CLOSING FILES


#. It’s important to close files as soon as you’re finished with them.

# continued from the previous example
>>> a_file.close() #Wow.

>>> a_file.closed ⑤ #close attribute to confirm file is closed
True


#closing files automatically:
with open('examples/chinese.txt', encoding='utf-8') as a_file:
	a_file.seek(17)
	a_character = a_file.read(1)
	print(a_character)
#when the 'with' block ends the file closes
#that file will get closed. Guaranteed.

'''There’s nothing file-specific about the with statement; it’s just a generic framework 
for creating runtime contexts and telling objects that 
they’re entering and exiting a runtime context'''



			
								READING DATA ONE LINE AT A TIME

#Python handles line endings automatically by default.

line_number = 0
with open('examples/favorite-people.txt', encoding='utf-8') as a_file: ①  #safe;y open file and let python close it
	for a_line in a_file: ②   #the stream object is also an iterator
		line_number += 1
		print('{:>4} {}'.format(line_number, a_line.rstrip())) ③
		#{:>4} means to print this argument right-justified within 4 spaces 
		#the rstrip() removes trailing whitespace and carriage returns


you@localhost:~/diveintopython3$ python3 examples/oneline.py
	1 Dora
	2 Ethan
	3 Wesley
	4 John
	5 Anne
	6 Mike
	7 Chris
	8 Sarah
	9 Alex
	10 Lizzie





									WRITING TO TEXT FILES


#Either mode will create the file automatically if it doesn’t already exist
>>> with open('test.log', mode='w', encoding='utf-8') as a_file: ① #if test .log is an existing file:
#I hope you didn’t care about the previous contents of that file (if any), because that data is gone now.
... a_file.write('test succeeded') ②  #add data to newly opened file
>>> with open('test.log', encoding='utf-8') as a_file:
... print(a_file.read())
test succeeded
>>> with open('test.log', mode='a', encoding='utf-8') as a_file: ③  #mode = 'a' appends to the file instead of overwriting it
... a_file.write('and again')
>>> with open('test.log', encoding='utf-8') as a_file:
... print(a_file.read())
test succeededand again 


'''Reading a “string” from a text file only works because you told Python what encoding
to use to read a stream of bytes and convert it to a string. Writing text to a file presents the same problem in
reverse.'''




										BINARY FILES

>>> an_image = open('examples/beauregard.jpg', mode='rb') ①   #only difference for binary mode is the added 'b' character
>>> an_image.mode ②
'rb'
>>> an_image.name ③
'examples/beauregard.jpg'
>>> an_image.encoding ④    #binary stream object has no encoding attribute
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
AttributeError: '_io.BufferedReader' object has no attribute 'encoding'


# continued from the previous example
>>> an_image.tell()
0
>>> data = image.read(3) ①
>>> data     #read() now takes the number of bytes to read, not the characters
b'\xff\xd8\xff'
>>> type(data) ②
<class 'bytes'>
>>> an_image.tell() ③    #which means there'll never be a mismatch between read() and tell()
3
>>> an_image.seek(0)
0
>>> data = an_image.read()
>>> len(data)
3150



							 STREAMS OBJECTS FROM NON-FILE SOURCES


#your API should take an arbitrary stream object.

'''In the simplest case, a stream object is anything with a read() method 
which takes an optional size parameter and returns a string. '''

>>> a_string = 'PapayaWhip is the new black.'
>>> import io ①    #StringIO class will treat a string in memory as a file
>>> a_file = io.StringIO(a_string) ②   #create a stream object out of a string
>>> a_file.read() ③   #reads the entire file
'PapayaWhip is the new black.'
>>> a_file.read() ④
''
>>> a_file.seek(0) ⑤
0
>>> a_file.read(10) ⑥   #read the string in chunks
'PapayaWhip'
>>> a_file.tell()
10
>>> a_file.seek(18)
18
>>> a_file.read()
'new black'

'''io.StringIO lets you treat a string as a text file. There’s also a io.BytesIO class, which
lets you treat a byte array as a binary file.'''

									HANDLING COMPRESSED FILES

#The Python standard library contains modules that support reading and writing compressed files
#The gzip module lets you create a stream object for reading or writing a gzip-compressed file.

>>> import gzip
>>> with gzip.open('out.log.gz', mode='wb') as z_file: ①  #always open gzipped files in binary mode
... z_file.write('A nine mile walk is no joke, especially in the rain.'.encode('utf-8'))
...
>>> exit()
you@localhost:~$ ls -l out.log.gz ②
-rw-r--r-- 1 mark mark 79 2009-07-19 14:29 out.log.gz
you@localhost:~$ gunzip out.log.gz ③   #decompress file and store contents in new file under the same name without .gz extension
you@localhost:~$ cat out.log ④   #display the contents of the file
A nine mile walk is no joke, especially in the rain.


								STANDARD INPUT, OUTPUT, AND ERROR

>>> for i in range(3):
... print('PapayaWhip') ①
PapayaWhip
PapayaWhip
PapayaWhip
>>> import sys
>>> for i in range(3):
... sys.stdout.write('is the') ②   #stdout is a stream object. print() does the same but with carriage returns 
is theis theis the
>>> for i in range(3):
... sys.stderr.write('new black') ③
new blacknew blacknew black

#sys.stdout and sys.stderr are stream objects, but they are write-only:
>>> import sys
>>> sys.stdout.read()
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
IOError: not readable

#they’re not constants; they’re variables.
import sys
class RedirectStdoutTo:
	def __init__(self, out_new):   
		self.out_new = out_new   #saves the stream
#		object in an instance variable so other methods can use it later.
	def __enter__(self):
		self.out_old = sys.stdout
		sys.stdout = self.out_new

	def __exit__(self, *args):
		sys.stdout = self.out_old

print('A')
with open('out.log', mode='w', encoding='utf-8') as a_file, RedirectStdoutTo(a_file):
	print('B')
print('C')

'''Take a look inside the RedirectStdoutTo class. This class is a custom context
manager. Any class can be a context manager by defining two special methods: __enter__() and __exit__()'''


print('A') ①
with open('out.log', mode='w', encoding='utf-8') as a_file, RedirectStdoutTo(a_file): ②
'''This with statement takes a comma-separated list of contexts. The comma-separated list acts like a series of nested
with blocks. The first context listed is the “outer” block; the last one listed is the “inner” block. The first context
opens a file; the second context redirects sys.stdout to the stream object that was created in the first context.
'''
	print('B') ③ #write file to out.log
print('C')  #the with block is over