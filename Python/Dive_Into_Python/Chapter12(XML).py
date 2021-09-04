'''XML isn’t about code; it’s about data. One common use of XML is “syndication feeds” 
that list the latest articles on a blog, forum, or other frequently-updated website'''

#Atom syndication feed:


								A 5-MINUTE CRASH COURSE IN XML


#XML is a generalized way of describing hierarchical structured data

'''An XML document contains one or more
elements, which are delimited by start and end tags.'''

<foo> ①
</foo> ②

'''The first element in every XML document is called the root element. 
An XML document can only have one root element.'''

<foo lang='en'> ①   #attribute lang and its value is en
	<bar id=xml-'papayawhip'>lang="fr"></bar> ②  #two attributes
</foo>

#If an element has more than one attribute, the ordering of the attributes is not significant

#Elements can have text content:
<foo lang='en'>
	<bar lang='fr'>PapayaWhip</bar>
</foo>

#namespace and prefix:
<atom:feed xmlns:atom='http://www.w3.org/2005/Atom'> ①
	<atom:title>dive into mark</atom:title> ②
</atom:feed>

#1. The feed element is in the http://www.w3.org/2005/Atom namespace.
#2. The title element is also in the http://www.w3.org/2005/Atom namespace.

#character encoding information:
<?xml version='1.0' encoding='utf-8'?>



								THE STRUCTURE OF AN ATOM FEED


<feed xmlns='http://www.w3.org/2005/Atom' ①  #http://www.w3.org ... is the atom namespace
	xml:lang='en'>   #feed is in english

feed xmlns='http://www.w3.org/2005/Atom' xml:lang='en'>
	<title>dive into mark</title> ①
	<subtitle>currently between addictions</subtitle> ②
	<id>tag:diveintomark.org,2001-07-29:/</id> ③   #globally unique identifier
	<updated>2009-03-27T21:56:07Z</updated> ④		#last updated
	<link rel='alternate' type='text/html' href='http://diveintomark.org/'/> ⑤  
	#link attirbutes tell you what kind the link is, the type is HTML and the target is given in the href attribute


<entry>
	<author> ①
		<name>Mark</name>
		<uri>http://diveintomark.org/</uri>
	</author>
	<title>Dive into history, 2009 edition</title> ②
	<link rel='alternate' type='text/html' ③
		href='http://diveintomark.org/archives/2009/03/27/dive-into-history-2009-edition'/>
	<id>tag:diveintomark.org,2009-03-27:/archives/20090327172042</id> ④ #unique identifier
	<updated>2009-03-27T21:56:07Z</updated> ⑤   #need updated and published date
	<published>2009-03-27T17:20:42Z</published>
	<category scheme='http://diveintomark.org' term='diveintopython'/> ⑥
	<category scheme='http://diveintomark.org' term='docbook'/>
	<category scheme='http://diveintomark.org' term='html'/>
	<summary type='html'>Putting an entire chapter on one page sounds ⑦  #gives a summary and says this is a snippet of HTML
		bloated, but consider this &amp;mdash; my longest chapter so far
		would be 75 printed pages, and it loads in under 5 seconds&amp;hellip;
		On dialup.</summary>
</entry>



										PARSING XML

>>> import xml.etree.ElementTree as etree ①   #part of the python standard library
>>> tree = etree.parse('examples/feed.xml') ②  #parse() takes a filename or file-like object
>>> root = tree.getroot() ③ #call getroot() method to reference root element
>>> root ④  #root element is the feed element in the http://www.w3.org/2005/Atom namespace.
<Element {http://www.w3.org/2005/Atom}feed at cd1eb0>


# continued from the previous example
>>> root.tag ①
'{http://www.w3.org/2005/Atom}feed'
>>> len(root) ②  #length of root is number of child elements
8
>>> for child in root: ③   #loop through child elements
... print(child) ④
...
<Element {http://www.w3.org/2005/Atom}title at e2b5d0>
<Element {http://www.w3.org/2005/Atom}subtitle at e2b4e0>
<Element {http://www.w3.org/2005/Atom}id at e2b6c0>
<Element {http://www.w3.org/2005/Atom}updated at e2b6f0>
<Element {http://www.w3.org/2005/Atom}link at e2b4b0>
<Element {http://www.w3.org/2005/Atom}entry at e2b720>
<Element {http://www.w3.org/2005/Atom}entry at e2b510>
<Element {http://www.w3.org/2005/Atom}entry at e2b750>


# continuing from the previous example
>>> root.attrib ①
{'{http://www.w3.org/XML/1998/namespace}lang': 'en'}
>>> root[4] ②   #the fifth child is the link element
<Element {http://www.w3.org/2005/Atom}link at e181b0>
>>> root[4].attrib ③   #the link element has three attributes
{'href': 'http://diveintomark.org/',
'type': 'text/html',
'rel': 'alternate'}
>>> root[3] ④
<Element {http://www.w3.org/2005/Atom}updated at e2b4e0>
>>> root[3].attrib ⑤  #has no attributes
{}


						SEARCHING FOR NODES WITHIN AN XML DOCUMENT

>>> import xml.etree.ElementTree as etree
>>> tree = etree.parse('examples/feed.xml')
>>> root = tree.getroot()
>>> root.findall('{http://www.w3.org/2005/Atom}entry') ①  #finds child elements that match a specific query
[<Element {http://www.w3.org/2005/Atom}entry at e2b4e0>,
<Element {http://www.w3.org/2005/Atom}entry at e2b510>,
<Element {http://www.w3.org/2005/Atom}entry at e2b540>]
>>> root.tag
'{http://www.w3.org/2005/Atom}feed'
>>> root.findall('{http://www.w3.org/2005/Atom}feed') ②
[]
>>> root.findall('{http://www.w3.org/2005/Atom}author') ③
[]


>>> import lxml.etree ①
>>> tree = lxml.etree.parse('examples/feed.xml')
>>> tree.findall('//{http://www.w3.org/2005/Atom}*[@href]') ②
'''This query finds all elements in the Atom namespace, anywhere in the document, that have an href attribute.
The // at the beginning of the query means “elements anywhere (not just as children of the root element).”
{http://www.w3.org/2005/Atom} means “only elements in the Atom namespace.” * means “elements with any
local name.” And [@href] means “has an href attribute.”'''
[<Element {http://www.w3.org/2005/Atom}link at eeb8a0>,
<Element {http://www.w3.org/2005/Atom}link at eeb990>,
<Element {http://www.w3.org/2005/Atom}link at eeb960>,
<Element {http://www.w3.org/2005/Atom}link at eeb9c0>]
>>> tree.findall("//{http://www.w3.org/2005/Atom}*[@href='http://diveintomark.org/']") ③
[<Element {http://www.w3.org/2005/Atom}link at eeb930>]
>>> NS = '{http://www.w3.org/2005/Atom}'
>>> tree.findall('//{NS}author[{NS}uri]'.format(NS=NS)) ④
[<Element {http://www.w3.org/2005/Atom}author at eeba80>,
<Element {http://www.w3.org/2005/Atom}author at eebba0>]


									GENERATING XML


>>> import xml.etree.ElementTree as etree
>>> new_feed = etree.Element('{http://www.w3.org/2005/Atom}feed', ①  #use element class to create a new element
... attrib={'{http://www.w3.org/XML/1998/namespace}lang': 'en'}) ②
>>> print(etree.tostring(new_feed)) ③
<ns0:feed xmlns:ns0='http://www.w3.org/2005/Atom' xml:lang='en'/>