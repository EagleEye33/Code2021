SELECT prod_name, prod_price
FROM Products
WHERE prod_price = 3.49;

SELECT prod_name, prod_price
FROM Products
WHERE prod_price < 10;

SELECT vend_id, prod_name
FROM Products
WHERE vend_id != 'DLL01';

SELECT prod_name, prod_price
FROM Products
WHERE prod_price BETWEEN 5 AND 10;

SELECT cust_name
FROM Customers
WHERE cust_email IS NULL;

SELECT prod_id, prod_name
FROM Products
WHERE prod_price = 9.49; --Challenge 1

SELECT prod_id, prod_name 
FROM Products
WHERE prod_price >= 9;

SELECT DISTINCT order_num
FROM OrderItems
WHERE order_num >= 100

SELECT prod_name, prod_price
FROM Products
WHERE prod_price BETWEEN 3 AND 6
ORDER BY prod_price;