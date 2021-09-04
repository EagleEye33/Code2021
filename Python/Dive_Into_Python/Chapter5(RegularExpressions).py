'''Regular expressions are a powerful and (mostly) standardized way of searching, 
replacing, and parsing text with complex patterns of characters.'''

>>> s = '100 NORTH MAIN ROAD'
>>> s.replace('ROAD', 'RD.') ①
'100 NORTH MAIN RD.'
>>> s = '100 NORTH BROAD ROAD'
>>> s.replace('ROAD', 'RD.') ②
'100 NORTH BRD. RD.'
>>> s[:-4] + s[-4:].replace('ROAD', 'RD.') ③
'100 NORTH BROAD RD.'
>>> import re ④
>>> re.sub('ROAD$', 'RD.', s) ⑤
'100 NORTH BROAD RD.'

'''^ matches the start of a string. 
$ matches the end of a string.'''


>>> s = '100 BROAD'
>>> re.sub('ROAD$', 'RD.', s)
'100 BRD.'
>>> re.sub('\\bROAD$', 'RD.', s) ①
'100 BROAD'
>>> re.sub(r'\bROAD$', 'RD.', s) ②
'100 BROAD'
>>> s = '100 BROAD ROAD APT. 3'
>>> re.sub(r'\bROAD$', 'RD.', s) ③
'100 BROAD ROAD APT. 3'
>>> re.sub(r'\bROAD\b', 'RD.', s) ④
'100 BROAD RD. APT 3'
''' 'raw string' tells python that nothing in the string should be escaped
	\b, which means “a word boundary must occur right here.”
		the last regular expression reads  “match 'ROAD' when it’s a 
		whole word by itself anywhere in the string,” '''


#Roman Numeral pattern matching(1000's):
>>> import re
>>> pattern = '^M?M?M?$' ①
>>> re.search(pattern, 'M') ②
<SRE_Match object at 0106FB58>
>>> re.search(pattern, 'MM') ③
<SRE_Match object at 0106C290>
>>> re.search(pattern, 'MMM') ④
<SRE_Match object at 0106AA38>
>>> re.search(pattern, 'MMMM') ⑤
>>> re.search(pattern, '') ⑥
<SRE_Match object at 0106F4A8>
#Up to three optional M's are checked
#	? Makes a pattern optional

#Hundreds:
>>> import re
>>> pattern = '^M?M?M?(CM|CD|D?C?C?C?)$' ①
>>> re.search(pattern, 'MCM') ②
<SRE_Match object at 01070390>
>>> re.search(pattern, 'MD') ③
<SRE_Match object at 01073A50>
>>> re.search(pattern, 'MMMCCC') ④
<SRE_Match object at 010748A8>
>>> re.search(pattern, 'MCMC') ⑤  #does not match
>>> re.search(pattern, '') ⑥
<SRE_Match object at 01071D98>
'''three mutually exclusive patterns, separated by vertical bars: CM, CD, and D?C?C?C?
The regular expression parser checks for each of these patterns in order (from left
to right), takes the first one that matches, and ignores the rest'''


#USING THE {n,m} SYNTAX
#{1,4} matches between 1 and 4 occurrences of a pattern

>>> pattern = '^M{0,3}$' ①
>>> re.search(pattern, 'M') ②
<_sre.SRE_Match object at 0x008EEB48>
>>> re.search(pattern, 'MM') ③
<_sre.SRE_Match object at 0x008EE090>
>>> re.search(pattern, 'MMM') ④
<_sre.SRE_Match object at 0x008EEDA8>
>>> re.search(pattern, 'MMMM') ⑤
>>>
'''“Match the start of the string, then anywhere from zero to three M characters, 
then the end of the string.”
If you want to match at least one but no more than three M characters, 
you could say M{1,3}'''

#Tens:
>>> pattern = '^M?M?M?(CM|CD|D?C?C?C?)(XC|XL|L?X?X?X?)$'
>>> re.search(pattern, 'MCMXL') ①  #1940
<_sre.SRE_Match object at 0x008EEB48>
>>> re.search(pattern, 'MCML') ②   #1950
<_sre.SRE_Match object at 0x008EEB48>
>>> re.search(pattern, 'MCMLX') ③  #1960
<_sre.SRE_Match object at 0x008EEB48>
>>> re.search(pattern, 'MCMLXXX') ④  #1980
<_sre.SRE_Match object at 0x008EEB48>
>>> re.search(pattern, 'MCMLXXXX') ⑤  #Not a roman numeral
>>>

#A|B matches either pattern A or pattern B (but not both)

#Ones:
>>> pattern = '^M?M?M?(CM|CD|D?C?C?C?)(XC|XL|L?X?X?X?)(IX|IV|V?I?I?I?)$'

#Pattern using the alternate {n,m} syntax
>>> pattern = '^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$'
>>> re.search(pattern, 'MDLV') ①   #1555
<_sre.SRE_Match object at 0x008EEB48>
>>> re.search(pattern, 'MMDCLXVI') ②  #2666
<_sre.SRE_Match object at 0x008EEB48>
>>> re.search(pattern, 'MMMDCCCLXXXVIII') ③  #3888
<_sre.SRE_Match object at 0x008EEB48>
>>> re.search(pattern, 'I') ④		#whoa.
<_sre.SRE_Match object at 0x008EEB48>

'''VERBOSE REGULAR EXPRESSIONS:
we need inline documentation
Different from compact regular expressions in the following ways:
Whitespace is ignored and comments are ignored (comment within a multi-line string)

Making a compact regular expression verbose:'''
>>> pattern = '''
^ # beginning of string
M{0,3} # thousands - 0 to 3 Ms
(CM|CD|D?C{0,3}) # hundreds - 900 (CM), 400 (CD), 0-300 (0 to 3 Cs),
# or 500-800 (D, followed by 0 to 3 Cs)
(XC|XL|L?X{0,3}) # tens - 90 (XC), 40 (XL), 0-30 (0 to 3 Xs),
# or 50-80 (L, followed by 0 to 3 Xs)
(IX|IV|V?I{0,3}) # ones - 9 (IX), 4 (IV), 0-3 (0 to 3 Is),
# or 5-8 (V, followed by 0 to 3 Is)
$ # end of string
'''
>>> re.search(pattern, 'M', re.VERBOSE) ①  #note the important use of re.VERBOSE
<_sre.SRE_Match object at 0x008EEB48>
>>> re.search(pattern, 'MCMLXXXIX', re.VERBOSE) ②
<_sre.SRE_Match object at 0x008EEB48>
>>> re.search(pattern, 'MMMDCCCLXXXVIII', re.VERBOSE) ③
<_sre.SRE_Match object at 0x008EEB48>
>>> re.search(pattern, 'M') ④
'''Python assumes every regular expression is compact
unless you explicitly state that it is verbose.'''


#Phone Parsing:
#\d matches any numeric digit (0-9) 
#\D matches anything but digits
>>> phonePattern = re.compile(r'^(\d{3})-(\d{3})-(\d{4})$') ①
>>> phonePattern.search('800-555-1212').groups() ②   #call on the 3 groups (returns a tuple)
('800', '555', '1212')
>>> phonePattern.search('800-555-1212-1234') ③
>>> phonePattern.search('800-555-1212-1234').groups() ④
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
AttributeError: 'NoneType' object has no attribute 'groups'
'''“match exactly three numeric digits, 
and then remember them as a group that I can ask for later”.'''

>>> phonePattern = re.compile(r'^(\d{3})-(\d{3})-(\d{4})-(\d+)$') ①
>>> phonePattern.search('800-555-1212-1234').groups() ②
('800', '555', '1212', '1234')
>>> phonePattern.search('800 555 1212 1234') ③  #problem 1
>>>
>>> phonePattern.search('800-555-1212') ④   #problem 2
>>>
'''the last group is a remembered group of one or more digits'''

>>> phonePattern = re.compile(r'^(\d{3})\D+(\d{3})\D+(\d{4})\D+(\d+)$') ①
>>> phonePattern.search('800 555 1212 1234').groups() ②
('800', '555', '1212', '1234')
>>> phonePattern.search('800-555-1212-1234').groups() ③
('800', '555', '1212', '1234')
>>> phonePattern.search('80055512121234') ④ #assumes there is a separator
>>>
>>> phonePattern.search('800-555-1212') ⑤  #still problem 2
>>>
'''now the pattern also searches in between each group 1 or more non-numeric character''' 

>>> phonePattern = re.compile(r'^(\d{3})\D*(\d{3})\D*(\d{4})\D*(\d*)$') ①
>>> phonePattern.search('80055512121234').groups() ②
('800', '555', '1212', '1234')
>>> phonePattern.search('800.555.1212 x1234').groups() ③
('800', '555', '1212', '1234')
>>> phonePattern.search('800-555-1212').groups() ④
('800', '555', '1212', '')
>>> phonePattern.search('(800)5551212 x1234') ⑤  #problem: extra character before area code
>>>
'''now the pattern searches in between each group 0 or more non-numeric
characters and the fourth group becomes optional'''

>>> phonePattern = re.compile(r'^\D*(\d{3})\D*(\d{3})\D*(\d{4})\D*(\d*)$') ①
>>> phonePattern.search('(800)5551212 ext. 1234').groups() ②
('800', '555', '1212', '1234')
>>> phonePattern.search('800-555-1212').groups() ③
('800', '555', '1212', '')
>>> phonePattern.search('work 1-(800) 555.1212 #1234') ④ #problem: the 1 before the area code
>>>
'''only difference is matching zero or more non-numeric characters before
the first remembered group.'''

>>> phonePattern = re.compile(r'(\d{3})\D*(\d{3})\D*(\d{4})\D*(\d*)$') ①
>>> phonePattern.search('work 1-(800) 555.1212 #1234').groups() ②
('800', '555', '1212', '1234')
>>> phonePattern.search('800-555-1212') ③
('800', '555', '1212', '')
>>> phonePattern.search('80055512121234') ④
('800', '555', '1212', '1234')
'''Note the lack of ^ in this regular expression. 
You are not matching the beginning of the string anymore.
The regular expression
engine will do the hard work of figuring out 
where the input string starts to match, and go from there'''

#As a verbose regular expression:
>>> phonePattern = re.compile(r'''
# don't match beginning of string, number can start anywhere
(\d{3}) # area code is 3 digits (e.g. '800')
\D* # optional separator is any number of non-digits
(\d{3}) # trunk is 3 digits (e.g. '555')
\D* # optional separator
(\d{4}) # rest of number is 4 digits (e.g. '1212')
\D* # optional separator
(\d*) # extension is optional and can be any number of digits
$ # end of string
''', re.VERBOSE)
>>> phonePattern.search('work 1-(800) 555.1212 #1234').groups() ①
('800', '555', '1212', '1234')
>>> phonePattern.search('800-555-1212') ②
('800', '555', '1212', '')