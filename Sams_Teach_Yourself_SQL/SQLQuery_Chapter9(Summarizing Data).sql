--Aggregate functions are used to summarize data. SQLsupports five aggregate
--functions, all of which can be used in multiple ways to return just the results you
--need.

SELECT AVG(prod_price) AS avg_price
FROM Products;

SELECT AVG(prod_price) AS avg_price
FROM Products
WHERE vend_id = 'DLL01';

SELECT COUNT(*) AS num_cust
FROM Customers;

SELECT COUNT(cust_email) AS num_cust
FROM Customers;

SELECT MAX(prod_price) AS max_price
FROM Products;

SELECT MAX(prod_id) AS last_prod_id
FROM Products;

SELECT MIN(prod_price) AS min_price
FROM Products;

SELECT MIN(prod_id) AS first_prod_id
FROM Products;

SELECT SUM(quantity) AS items_ordered
FROM OrderItems
WHERE order_num = 20005;

SELECT SUM(item_price*quantity) AS total_price
FROM OrderItems
WHERE order_num = 20005;

SELECT AVG(DISTINCT prod_price) AS avg_price
FROM Products
WHERE vend_id = 'DLL01';

SELECT COUNT(*) AS num_items,
		MIN(prod_price) AS price_min,
		MAX(prod_price) AS price_max,
		AVG(prod_price) AS price_avg
FROM Products;

SELECT SUM(quantity) AS items_ordered
FROM OrderItems; --challenge 1

SELECT SUM(quantity) AS items_ordered
FROM OrderItems
WHERE prod_id = 'BR01';  --challenge 2

SELECT MAX(prod_price) AS max_price
FROM Products
WHERE prod_price <= 10;  --challenge 3