SELECT prod_id, prod_name
FROM Products
WHERE prod_name LIKE 'Fish%';

SELECT prod_id, prod_name
FROM Products
WHERE prod_name LIKE '%bean bag%';

SELECT prod_name
FROM Products 
WHERE prod_name LIKE 'F%y'; --begin with F and end with y
/*There is one situation in which wildcards may indeed 
be useful in the middle of a search pattern, 
and that is looking for email addresses based on a partial
address, such as WHERE email 'LIKE b%@forta.com'. */

--It may seem that the % wildcard matches anything, but there is one exception: NULL

SELECT prod_id, prod_name
FROM Products
WHERE prod_name LIKE '__ inch teddy bear' OR prod_name LIKE '_ inch teddy bear';

-- or with the same result

SELECT prod_id, prod_name
FROM Products
WHERE prod_name LIKE '% inch teddy bear';

SELECT cust_contact 
FROM Customers
WHERE cust_contact LIKE '[JM]%'
ORDER BY cust_contact;
--find all contacts whose names begin with the letter J or the letter M

SELECT cust_contact
FROM Customers
WHERE cust_contact LIKE '[^JM]%'
ORDER BY cust_contact;
--the opposite of the previous example

--or
SELECT cust_contact
FROM Customers
WHERE NOT cust_contact LIKE '[JM]%'
ORDER BY cust_contact;

SELECT prod_name, prod_desc
FROM Products
WHERE prod_desc LIKE '%toy%'; --challenge 1

SELECT prod_name, prod_desc
FROM Products 
WHERE NOT prod_desc LIKE '%toy%'
ORDER BY prod_name;  --challenge 2

SELECT prod_name, prod_desc
FROM Products
WHERE prod_desc LIKE '%toy%' AND prod_desc LIKE '%carrots%'; --challenge 3

SELECT prod_name, prod_desc
FROM Products
WHERE prod_desc LIKE '%toy%carrots%'; --challenge 4




