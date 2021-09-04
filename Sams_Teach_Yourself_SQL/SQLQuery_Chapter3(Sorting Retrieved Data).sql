SELECT prod_id, prod_price, prod_name
FROM Products 
ORDER BY prod_price DESC, prod_name; -- or: Order By 2,3;

SELECT cust_name 
FROM Customers
ORDER BY cust_name DESC;  --Challenge 1

SELECT cust_id, order_num
FROM Orders
ORDER BY 1, order_date DESC; --Challenge 2

SELECT quantity, item_price
FROM OrderItems
ORDER BY quantity DESC, item_price DESC; --Challenge 3

/* SELECT vend_name,
FROM Vendors
ORDER vend_name DESC; */ -- Challenge 4 --There should be no comma after vend_name. 
								--ORDER should be ORDER BY