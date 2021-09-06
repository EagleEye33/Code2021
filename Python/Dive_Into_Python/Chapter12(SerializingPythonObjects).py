'''The concept of serialization is simple. You have a data structure in memory that you 
want to save, reuse, or send to someone else. '''

'''The data is only meant to be used by the same program that
created it, never sent over a network, 
and never read by anything other than the program that created it.'''


								SAVING DATA TO A PICKLE FILE



>>> shell ①
1
>>> entry = {} ②    #build dictionary with several different data types
>>> entry['title'] = 'Dive into history, 2009 edition'
>>> entry['article_link'] = 'http://diveintomark.org/archives/2009/03/27/dive-into-history-2009-edition'
>>> entry['comments_link'] = None
>>> entry['internal_id'] = b'\xDE\xD5\xB4\xF8'
>>> entry['tags'] = ('diveintopython', 'docbook', 'html')
>>> entry['published'] = True
>>> import time
>>> entry['published_date'] = time.strptime('Fri Mar 27 22:20:42 2009') ③
>>> entry['published_date']
time.struct_time(tm_year=2009, tm_mon=3, tm_mday=27, tm_hour=22, tm_min=20, tm_sec=42, tm_wday=4, tm_y)
'''time_struct can represent a point in time and 'striptime() takes a formatted
string and converts it to a time_struct'''


#save dictionary to file:
>>> shell ①
1
>>> import pickle
>>> with open('entry.pickle', 'wb') as f: ②   #open for writing as binary mode
... pickle.dump(entry, f) ③  
...
'''The dump() function in the pickle module takes a serializable Python data structure,
 serializes it into a binary,
Python-specific format using the latest version of the pickle protocol,
 and saves it to an open file.'''



 								LOADING DATA FROM A PICKLE FILE

>>> shell ①
2
>>> entry ②   #in a different environment
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
NameError: name 'entry' is not defined
>>> import pickle
>>> with open('entry.pickle', 'rb') as f: ③  #open entry.pickle file from python shell #1
... entry = pickle.load(f) ④
...
>>> entry ⑤   #entry variable is a dictionary with familiar values
{'comments_link': None,
'internal_id': b'\xDE\xD5\xB4\xF8',
'title': 'Dive into history, 2009 edition',
'tags': ('diveintopython', 'docbook', 'html'),
'article_link':
'http://diveintomark.org/archives/2009/03/27/dive-into-history-2009-edition',
'published_date': time.struct_time(tm_year=2009, tm_mon=3, tm_mday=27, tm_hour=22, tm_min=20, tm_sec=42, tm_wday=4, tm_yday=86, tm_isdst=-1),
'published': True}
'''The pickle.load() function takes a stream object, reads the serialized data 
from the stream, creates a new
Python object, recreates the serialized data in the new Python object, 
and returns the new Python object.'''

>>> shell ①
1 
>>> with open('entry.pickle', 'rb') as f: ②   #open entry.pickle file
... entry2 = pickle.load(f) ③   #load serialized data into new variable entry2  
...
>>> entry2 == entry ④   #entry was built from the ground up. entry 2 is a perfect replica
True
>>> entry2 is entry ④   #still a copy though
False
>>> entry2['tags'] ⑥   #tags key is a tuple
('diveintopython', 'docbook', 'html')
>>> entry2['internal_id']   #bytes object
b'\xDE\xD5\xB4\xF8'



									PICKLING WITHOUT A FILE


#You can also serialize to a bytes object in memory.
>>> shell
1
>>> b = pickle.dumps(entry) ①   #dump vs dumps. simply returns the serialized data
>>> type(b) ②   #returns bytes object
<class 'bytes'>
>>> entry3 = pickle.loads(b) ③  #deserialization
>>> entry3 == entry ④  #perfect replica of original dictionary
True


'''“JSON” stands for “JavaScript Object Notation,” but don’t let
the name fool you — JSON is explicitly designed to be 
usable across multiple programming languages. '''



								SAVING DATA TO A JSON FILE


>>> shell
1
>>> basic_entry = {} ①   #create new data structure
>>> basic_entry['id'] = 256
>>> basic_entry['title'] = 'Dive into history, 2009 edition'
>>> basic_entry['tags'] = ('diveintopython', 'docbook', 'html')
>>> basic_entry['published'] = True
>>> basic_entry['comments_link'] = None
>>> import json
>>> with open('basic.json', mode='w', encoding='utf-8') as f: ②   #you can never go wrong with UTF-8
... json.dump(basic_entry, f) ③  #serializes the data structure and writes it to the stream object

>>> shell
1
>>> with open('basic-pretty.json', mode='w', encoding='utf-8') as f:
... json.dump(basic_entry, f, indent=2) ①  #indent paramater makes JSON file more readable


#And this is the result:
you@localhost:~/diveintopython3/examples$ cat basic-pretty.json
{
"published": true,
"tags": [
"diveintopython",
"docbook",
"html"
],
"comments_link": null,
"id": 256,
"title": "Dive into history, 2009 edition"
}


'''JSON is a text-based format. Always open JSON files in text
mode with a UTF-8 character encoding.'''

'''JSON has no support for bytes objects. However, if storing bytes is important to you,
you can define your own “mini-serialization format.” '''

def to_json(python_object): ①   #python object as paramater
	if isinstance(python_object, bytes): ②  #check python object is bytes object
		return {'__class__': 'bytes',
				'__value__': list(python_object)} ③  #convert bytes object to dictionary. list() function converts bytes object to a sequence of integers
	raise TypeError ④   #in case custom serializer did not recognize type

>>> shell
1
>>> import customserializer ①   #where to_json() function was defined
>>> with open('entry.json', 'w', encoding='utf-8') as f: ②   
... json.dump(entry, f, default=customserializer.to_json) ③   #pass function in default paramater
...
Traceback (most recent call last):
File "<stdin>", line 9, in <module>
json.dump(entry, f, default=customserializer.to_json)
File "C:\Python31\lib\json\__init__.py", line 178, in dump
for chunk in iterable:
File "C:\Python31\lib\json\encoder.py", line 408, in _iterencode
for chunk in _iterencode_dict(o, _current_indent_level):
File "C:\Python31\lib\json\encoder.py", line 382, in _iterencode_dict
for chunk in chunks:
File "C:\Python31\lib\json\encoder.py", line 416, in _iterencode
o = _default(o)
File "/Users/pilgrim/diveintopython3/examples/customserializer.py", line 12, in to_json
raise TypeError(repr(python_object) + ' is not JSON serializable') ④
TypeError: time.struct_time(tm_year=2009, tm_mon=3, tm_mday=27, tm_hour=22, tm_min=20, tm_sec=42, tm_w


