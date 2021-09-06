--Working with Subqueries
SELECT * FROM Orders

SELECT order_num
FROM OrderItems
WHERE prod_id = 'RGAN01';

SELECT cust_id
FROM Orders
WHERE order_num IN (20007,20008);

SELECT cust_id
FROM Orders
WHERE order_num IN (SELECT order_num
					FROM OrderItems
					WHERE prod_id = 'RGAN01');
--Subqueries are always processed starting with the innermost SELECT statement
--and working outward

SELECT cust_name, cust_contact
FROM Customers
WHERE cust_id IN (SELECT cust_id
				  FROM Orders
				  WHERE order_num IN (SELECT order_num
									  FROM OrderItems
									  WHERE prod_id = 'RGAN01'));

SELECT cust_name,
	   cust_state,
	   (SELECT COUNT(*)
	    FROM Orders
		WHERE Orders.cust_id = Customers.cust_id) AS orders
FROM Customers
ORDER BY cust_name;

/*n this lesson, you learned what subqueries are and how to use them. The most
common uses for subqueries are in WHERE clause IN operators and for populating
calculated columns. */

SELECT cust_id, cust_name
FROM Customers
WHERE cust_id IN (SELECT cust_id
				  FROM Orders
				  WHERE order_num IN (SELECT order_num
							        FROM OrderItems
									WHERE item_price >= 10));

SELECT cust_id
FROM Orders
WHERE order_num IN (SELECT order_num
				    FROM OrderItems
					WHERE item_price >= 10); --challenge 1

SELECT cust_id, order_date
FROM Orders
WHERE order_num IN (SELECT order_num
					FROM OrderItems
					WHERE prod_id = 'BR01')
ORDER BY order_date;  --challenge 2

SELECT cust_email
FROM Customers
WHERE cust_id IN (SELECT cust_id
				  FROM Orders
				  WHERE order_num IN (SELECT order_num
									  FROM OrderItems
									  WHERE prod_id = 'BR01'));  --challenge 3

SELECT cust_id, 
		(SELECT SUM(quantity*item_price)
		FROM OrderItems
		WHERE OrderItems.order_num = Orders.order_num) AS total_ordered
FROM Orders
ORDER BY total_ordered DESC;  --challenge 4

SELECT prod_name,
		(SELECT SUM(quantity)
		FROM OrderItems
		WHERE OrderItems.prod_id = Products.prod_id) AS quant_sold  --challenge 5
FROM Products;

SELECT * FROM OrderItems;
SELECT * FROM Products;



