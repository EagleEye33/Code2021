



											OS MODULE:



>>> import os ①
>>> print(os.getcwd()) ②
#C:\Python31
>>> os.chdir('/Users/pilgrim/diveintopython3/examples') ③
>>> print(os.getcwd()) ④
#C:\Users\pilgrim\diveintopython3\examples

>>> import os
>>> print(os.path.join('/Users/pilgrim/diveintopython3/examples/', 'humansize.py')) ①
/Users/pilgrim/diveintopython3/examples/humansize.py
>>> print(os.path.join('/Users/pilgrim/diveintopython3/examples', 'humansize.py')) ②
#/Users/pilgrim/diveintopython3/examples\humansize.py    
>>> print(os.path.expanduser('~')) ③
#c:\Users\pilgrim
>>> print(os.path.join(os.path.expanduser('~'), 'diveintopython3', 'examples', 'humansize.py')) ④
#c:\Users\pilgrim\diveintopython3\examples\humansize.py

>>> pathname = '/Users/pilgrim/diveintopython3/examples/humansize.py'
>>> os.path.split(pathname) ①
('/Users/pilgrim/diveintopython3/examples', 'humansize.py')
>>> (dirname, filename) = os.path.split(pathname) ②
>>> dirname ③
'/Users/pilgrim/diveintopython3/examples'
>>> filename ④
'humansize.py'
>>> (shortname, extension) = os.path.splitext(filename) ⑤
>>> shortname
'humansize'
>>> extension
'.py'

'''Notice the multi-variable assignment used above. 
'split' function returns a tuple of the path and filename
the 'splittext' function splits a filename and returns a tuple
of the filename and file extension'''


#Listing Directories: the glob() module:
>>> os.chdir('/Users/pilgrim/diveintopython3/')
>>> import glob
>>> glob.glob('examples/*.xml') ①
['examples\\feed-broken.xml',
'examples\\feed-ns0.xml',
'examples\\feed.xml']
>>> os.chdir('examples/') ②
>>> glob.glob('*test*.py') ③
['alphameticstest.py',
'pluraltest1.py',
'pluraltest2.py',
'pluraltest3.py',
'pluraltest4.py',
'pluraltest5.py',
'pluraltest6.py',
'romantest1.py',
'romantest10.py',
'romantest2.py',
'romantest3.py',
'romantest4.py',
'romantest5.py',
'romantest6.py',
'romantest7.py',
'romantest8.py',
'romantest9.py']
#note the wildcard matching that 'glob()' utilizies


#Metadata: creation date, last-modified date, file size, and so on.
>>> import os
>>> print(os.getcwd()) ①
#c:\Users\pilgrim\diveintopython3\examples
>>> metadata = os.stat('feed.xml') ②
>>> metadata.st_mtime ③
1247520344.9537716
>>> import time ④
>>> time.localtime(metadata.st_mtime) ⑤
time.struct_time(tm_year=2009, tm_mon=7, tm_mday=13, tm_hour=17,
tm_min=25, tm_sec=44, tm_wday=0, tm_yday=194, tm_isdst=1)


# continued from the previous example
>>> metadata.st_size ①
3070    #3070 bytes
>>> import humansize
>>> humansize.approximate_size(metadata.st_size) ②
'3.0 KiB'


#for constructing an absolute pathname:
>>> import os
>>> print(os.getcwd())
#c:\Users\pilgrim\diveintopython3\examples
>>> print(os.path.realpath('feed.xml'))
#c:\Users\pilgrim\diveintopython3\examples\feed.xml













								LIST COMPREHENSIONS


>>> a_list = [1, 9, 8, 4]
>>> [elem * 2 for elem in a_list] ①
[2, 18, 16, 8]
>>> a_list ②
[1, 9, 8, 4]   #original list not changed
>>> a_list = [elem * 2 for elem in a_list] ③
>>> a_list
[2, 18, 16, 8]


'''It is safe to assign the result of a list comprehension to the variable 
that you’re mapping. Python constructs the
new list in memory, and when the list comprehension is complete, 
it assigns the result to the original variable'''


>>> import os, glob
>>> glob.glob('*.xml') ①   #from current working directory
['feed-broken.xml', 'feed-ns0.xml', 'feed.xml']
>>> [os.path.realpath(f) for f in glob.glob('*.xml')] ②
['c:\\Users\\pilgrim\\diveintopython3\\examples\\feed-broken.xml',
'c:\\Users\\pilgrim\\diveintopython3\\examples\\feed-ns0.xml',
'c:\\Users\\pilgrim\\diveintopython3\\examples\\feed.xml']


#To filter a list, you can include an if clause at the end of the list comprehension.
>>> import os, glob
>>> [f for f in glob.glob('*.py') if os.stat(f).st_size > 6000] ①
['pluraltest6.py',
'romantest10.py',
'romantest6.py',
'romantest7.py',
'romantest8.py',
'romantest9.py']


>>> import os, glob
>>> [(os.stat(f).st_size, os.path.realpath(f)) for f in glob.glob('*.xml')] ①
[(3074, 'c:\\Users\\pilgrim\\diveintopython3\\examples\\feed-broken.xml'),
(3386, 'c:\\Users\\pilgrim\\diveintopython3\\examples\\feed-ns0.xml'),
(3070, 'c:\\Users\\pilgrim\\diveintopython3\\examples\\feed.xml')]
>>> import humansize
>>> [(humansize.approximate_size(os.stat(f).st_size), f) for f in glob.glob('*.xml')] ②
[('3.0 KiB', 'feed-broken.xml'),
('3.3 KiB', 'feed-ns0.xml'),
('3.0 KiB', 'feed.xml')]
#cool!


#DICTIONARY COMPREHENSIONS:
>>> import os, glob
>>> metadata = [(f, os.stat(f)) for f in glob.glob('*test*.py')] ①
>>> metadata[0] ②
('alphameticstest.py', nt.stat_result(st_mode=33206, st_ino=0, st_dev=0,
st_nlink=0, st_uid=0, st_gid=0, st_size=2509, st_atime=1247520344,
st_mtime=1247520344, st_ctime=1247520344))
>>> metadata_dict = {f:os.stat(f) for f in glob.glob('*test*.py')} ③
>>> type(metadata_dict) ④
#<class 'dict'>
>>> list(metadata_dict.keys()) ⑤
['romantest8.py', 'pluraltest1.py', 'pluraltest2.py', 'pluraltest5.py',
'pluraltest6.py', 'romantest7.py', 'romantest10.py', 'romantest4.py',
'romantest9.py', 'pluraltest3.py', 'romantest1.py', 'romantest2.py',
'romantest3.py', 'romantest5.py', 'romantest6.py', 'alphameticstest.py',
'pluraltest4.py']
>>> metadata_dict['alphameticstest.py'].st_size ⑥
2509


#'if' clause in dictionary comprehension to filter the input sequence
>>> import os, glob, humansize
>>> metadata_dict = {f:os.stat(f) for f in glob.glob('*')} ①
>>> humansize_dict = {os.path.splitext(f)[0]:humansize.approximate_size(meta.st_size) \
... for f, meta in metadata_dict.items() if meta.st_size > 6000} ②
>>> list(humansize_dict.keys()) ③
['romantest9', 'romantest8', 'romantest7', 'romantest6', 'romantest10', 'pluraltest6']
>>> humansize_dict['romantest9'] ④
'6.5 KiB'
#Unfamiliarity regarding the '.items()' method. Further research needed.


#swapping the keys and values of a dictionary.
>>> a_dict = {'a': 1, 'b': 2, 'c': 3}
>>> {value:key for key, value in a_dict.items()}
{1: 'a', 2: 'b', 3: 'c'}


#SET COMPREHENSIONS
>>> a_set = set(range(10))
>>> a_set
{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
>>> {x ** 2 for x in a_set} ①
{0, 1, 4, 81, 64, 9, 16, 49, 25, 36}
>>> {x for x in a_set if x % 2 == 0} ②
{0, 8, 2, 4, 6}
>>> {2**x for x in range(10)} ③
{32, 1, 2, 4, 8, 64, 128, 256, 16, 512}
#Set comprehensions do not need to take a set as input; they can take any sequence.








