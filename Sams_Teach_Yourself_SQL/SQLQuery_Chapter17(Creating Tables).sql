/*Lesson 17. Creating and Manipulating Tables
In this lesson, you’ll learn the basics of 
table creation, alteration, and deletion.*/

SELECT * FROM Products;

UPDATE Products
SET prod_name = NULL
WHERE prod_id = 'BNBG01';  --name can't be NULL

CREATE TABLE Products
(
	prod_id		CHAR(10)		NOT NULL,
	vend_id		CHAR(10)		NOT NULL,
	prod_name	CHAR(254)		NOT NULL,
	prod_price	DECIMAL(8,2)	NOT NULL,
	prod_desc	VARCHAR(1000)	NULL
);

CREATE TABLE Orders
(
order_num INTEGER NOT NULL,
order_date DATETIME NOT NULL,
cust_id CHAR(10) NOT NULL
);

CREATE TABLE Vendors
(
vend_id CHAR(10) NOT NULL,
vend_name CHAR(50) NOT NULL,
vend_address CHAR(50) ,
vend_city CHAR(50) ,
vend_state CHAR(5) ,
vend_zip CHAR(10) ,
vend_country CHAR(50)
);  --NULL is the default setting, so if NOT NULL is not specified, 	--NULL is assumed./*Don’t confuse NULL values with empty strings. 
A NULL value is the lack of a
value; it is not an empty string. 
If you were to specify '' (two single quotes with nothing in between them), 
that would be allowed in a NOT NULL column.
An empty string is a valid value; it is not no value. NULL values are specified with the keyword NULL, not with an empty string.*/CREATE TABLE OrderItems
(
order_num INTEGER NOT NULL,
order_item INTEGER NOT NULL,
prod_id CHAR(10) NOT NULL,
quantity INTEGER NOT NULL DEFAULT 1,
item_price DECIMAL(8,2) NOT NULL
);--SQLServer GETDATE()ALTER TABLE VendorsADD vend_phone CHAR(20);SELECT * FROM Vendors;ALTER TABLE VendorsDROP COLUMN vend_phone;/*Complex table structure changes usually require a manual move process
involving these steps:
1. Create a new table with the new column layout.
2. Use the INSERT SELECT statement (see Lesson 15, “Inserting Data,” for
details of this statement) to copy the data from the old table to the new table. Use conversion functions and calculated fields, if needed.
3. Verify that the new table contains the desired data.
4. Rename the old table (or delete it, if you are really brave).
5. Rename the new table with the name previously used by the old table.
6. Re-create any triggers, stored procedures, indexes, and foreign keys as
needed. */DROP TABLE CustCopy;--renaming on SQL Server: use sp_renameALTER TABLE VendorsADD vend_web CHAR(100);  --challenge 1SELECT * FROM Vendors;UPDATE VendorsSET vend_web = 'jq.com';  --challenge 2