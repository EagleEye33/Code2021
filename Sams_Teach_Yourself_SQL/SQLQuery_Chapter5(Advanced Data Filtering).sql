SELECT prod_id, prod_price, prod_name
FROM Products
WHERE vend_id = 'DLL01' AND prod_price <=4
ORDER BY prod_name;

SELECT prod_id, prod_price, prod_name
FROM Products
WHERE vend_id = 'DLL01' OR vend_id = 'BRS01';

SELECT vend_id, prod_name, prod_price
FROM Products
WHERE (vend_id = 'DLL01' OR vend_id = 'BRS01') 
		AND prod_price >= 10;

SELECT prod_name, prod_price
FROM Products
WHERE vend_id IN ('DLL01', 'BRS01')
ORDER BY prod_name;

SELECT vend_id, prod_name
FROM Products
WHERE NOT vend_id = 'DLL01'
ORDER BY prod_name;

SELECT vend_id, prod_name, prod_price
FROM Products
WHERE NOT vend_id IN ('DLL01', 'BRS01')
ORDER BY prod_name;

SELECT vend_name
FROM Vendors
WHERE vend_country = 'USA' AND vend_state = 'CA'; --Challenge 1

SELECT order_num, prod_id, quantity
FROM OrderItems
WHERE prod_id IN ('BR01', 'BR02', 'BR03') AND quantity >= 100; --Challenge 2

SELECT prod_name, prod_price
FROM Products
WHERE prod_price BETWEEN 3 AND 6 
ORDER BY prod_price; -- Challenge 3

/* SELECT vend_name
FROM Vendors
ORDER BY vend_name
WHERE vend_country = 'USA' AND vend_state = 'CA'; */ 
--Challenge 4: ORDER BY  Clause must come after the WHERE Clause



