/*Lesson 18. Using Views
In this lesson, you’ll learn exactly what views are, how they work, and when
they should be used. You’ll also see how views can be used to simplify some of
the SQL operations performed in earlier lessons.*/

SELECT cust_name, cust_contact
FROM Customers, Orders, OrderItems
WHERE Customers.cust_id = Orders.cust_id
AND OrderItems.order_num = Orders.order_num
AND prod_id = 'RGAN01'; --from lesson 12

CREATE VIEW ProductCustomers AS
SELECT cust_name, cust_contact, prod_id
FROM Customers, Orders, OrderItems
WHERE Customers.cust_id = Orders.cust_id
AND OrderItems.order_num = Orders.order_num;

SELECT cust_name, cust_contact
FROM ProductCustomers
WHERE prod_id = 'RGAN01'; --ProductCustomers is a view
--retrieve a list of customers who ordered product RGAN01

SELECT * FROM ProductCustomers;  --every customer who ordered anything

/*Views contain no data themselves, so the data they return is retrieved
from other tables. When data is added or changed in those tables, the views will
return that changed data. */

/*Renaming Views
To remove a view, you use the DROP statement. The syntax is simply DROP
VIEW viewname;.
To overwrite (or update) a view, you must first DROP it and then re-create it.*/

SELECT RTRIM(vend_name) + ' (' + RTRIM(vend_country) + ')'
AS vend_title
FROM Vendors
ORDER BY vend_name;  --lesson 7CREATE VIEW VendorLocations AS SELECT RTRIM (vend_name) + ' (' + RTRIM(vend_country) + ')'	   AS vend_titleFROM Vendors;SELECT * FROM VendorLocations; --retrieve data to create all mailing labelsCREATE VIEW CustomerEMailList ASSELECT cust_id, cust_name, cust_emailFROM CustomersWHERE cust_email IS NOT NULL;  --ignore users who have no email addressSELECT *FROM CustomerEMailList;--Views are exceptionally useful for simplifying the use of calculated fieldsSELECT prod_id,
quantity,
item_price,
quantity*item_price AS expanded_price
FROM OrderItems
WHERE order_num = 20008;  --lesson 7CREATE VIEW OrderItemsExpanded AS SELECT order_num,	prod_id,	quantity,	item_price,	quantity * item_price AS ExpandedPriceFROM OrderItems;SELECT *FROM OrderItemsExpandedWHERE order_num = 20008;CREATE VIEW CustomersWithOrders ASSELECT Customers.*FROM CustomersINNER JOIN Orders ON Customers.cust_id = Orders.cust_id;  --challenge 1SELECT *FROM CustomersWithOrders;--or
/* CREATE VIEW CustomersWithOrders1 AS
SELECT Customers.cust_id,
       Customers.cust_name,
       Customers.cust_address,
       Customers.cust_city,
       Customers.cust_state,
       Customers.cust_zip,
       Customers.cust_country,
       Customers.cust_contact,
       Customers.cust_email
FROM Customers
JOIN Orders ON Customers.cust_id = Orders.cust_id;

SELECT * FROM CustomersWithOrders; */CREATE VIEW OrderItemsExpanded AS
SELECT order_num,
       prod_id,
       quantity,
       item_price,
       quantity*item_price AS expanded_price
FROM OrderItems
ORDER BY order_num;  --challenge 2/*ORDER BY is not allowed in views. Views are used like tables, if you needsorted data use ORDER BY in the SELECT that retrieved data from the view.*/


