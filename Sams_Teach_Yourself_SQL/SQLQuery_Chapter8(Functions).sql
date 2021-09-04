SELECT GETDATE();

SELECT vend_name, UPPER(vend_name) AS vend_name_upcase
FROM Vendors;

SELECT cust_name, cust_contact
FROM Customers
WHERE SOUNDEX(cust_contact) = SOUNDEX('Michael Green');

SELECT order_num
FROM Orders
WHERE DATEPART(yy, order_date) = 2020;

SELECT order_num, order_date
FROM Orders
WHERE order_date BETWEEN '01/13/2020'
AND '12/31/2020';

SELECT EXP(10); SELECT ABS(-100); SELECT PI(); SELECT SQRT(2); SELECT SIN(1.57);

SELECT cust_id, cust_name, 
UPPER(SUBSTRING(cust_contact, 1, 2) + SUBSTRING(cust_city, 1, 3)) 
AS user_login
FROM Customers;  --challenge 1
 -- or
SELECT cust_id, cust_name,
        UPPER(LEFT(cust_contact, 2)) + UPPER(LEFT(cust_city, 3)) AS user_login
FROM customers;

SELECT order_num, order_date
FROM Orders
WHERE DATEPART(month, order_date) = 01 AND DATEPART(year, order_date) = 2020
ORDER BY order_date; --challenge 2
-- or
SELECT order_num, order_date
FROM Orders
WHERE DATEPART(yy, order_date) = 2020 AND DATEPART(mm, order_date) = 1
ORDER BY order_date;

