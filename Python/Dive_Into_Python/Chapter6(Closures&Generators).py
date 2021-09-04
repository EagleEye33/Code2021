#program that automatically pluralizes English nouns:
import re
def plural(noun):
if re.search('[sxz]$', noun): ①
return re.sub('$', 'es', noun) ②
elif re.search('[^aeioudgkprt]h$', noun):
return re.sub('$', 'es', noun)
elif re.search('[^aeiou]y$', noun):
return re.sub('y$', 'ies', noun)
else:
return noun + 's'
'''first regular expression tests whether noun ends with s, x, or z.'''

#Examining the re.sub() function in detail...
>>> import re
>>> re.search('[abc]', 'Mark') ①   #Yes Mark contains an A or B or C
<_sre.SRE_Match object at 0x001C1FA8>
>>> re.sub('[abc]', 'o', 'Mark') ②
'Mork'
>>> re.sub('[abc]', 'o', 'rock') ③
'rook'
>>> re.sub('[abc]', 'o', 'caps') ④
'oops'
#re.sub replaces all of the matches, not just the first one.

#Back to the plural() function...
def plural(noun):
if re.search('[sxz]$', noun):
return re.sub('$', 'es', noun) ①
elif re.search('[^aeioudgkprt]h$', noun): ②
return re.sub('$', 'es', noun) ③
elif re.search('[^aeiou]y$', noun):
return re.sub('y$', 'ies', noun)
else:
return noun + 's'
'''first else if h