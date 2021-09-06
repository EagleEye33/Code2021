/*Lesson 19. Working with Stored
Procedures
In this lesson, you’ll learn what stored procedures are, why they are used, and
how. You’ll also look at the basic syntax for creating and using them.*/EXECUTE AddNewProduct('JTS01',
'Stuffed Eiffel Tower',
6.49,
'Plush stuffed toy with
the text La Tour Eiffel in red white and blue');
--AddNewProduct does not exist

/*The stored procedure adds a new
row to the Products table and assigns these passed attributes to the appropriate
columns. */

/*It validates the passed data, ensuring that all four parameters have values.
It generates a unique ID to be used as the primary key.
It inserts the new product into the Products table, storing the generated
primary key and passed data in the appropriate columns. */

CREATE PROCEDURE MailingListCount
AS
DECLARE @cnt INTEGER
SELECT @cnt = COUNT(*)
FROM Customers
WHERE NOT cust_email IS NULL;
RETURN @cnt;--all local variables in SQLServer are named starting with a @DECLARE @ReturnValue INT
EXECUTE @ReturnValue=MailingListCount;
SELECT @ReturnValue;/*This code declares a variable to hold whatever the stored procedure returns,
executes the stored procedure, and then uses a SELECT to display the returned
value.*/SELECT * FROM Orders;CREATE PROCEDURE NewOrder @cust_id CHAR(10)
AS
-- Declare variable for order number
DECLARE @order_num INTEGER
-- Get current highest order number
SELECT @order_num=MAX(order_num)
FROM Orders
-- Determine next order number
SELECT @order_num=@order_num+1
-- Insert new order
INSERT INTO Orders(order_num, order_date, cust_id)
VALUES(@order_num, GETDATE(), @cust_id)
-- Return order number
RETURN @order_num/*This stored procedure creates a new order in the Orders table. It takes a single
parameter—the ID of the customer placing the order*/--same code different formCREATE PROCEDURE NewOrder1 @cust_id CHAR(10)
AS
-- Insert new order
INSERT INTO Orders(cust_id)
VALUES(@cust_id)
-- Return order number
SELECT order_num = @@IDENTITY;EXECUTE NewOrder @cust_id = '1000000001';--Global variable @@IDENTITY returns order_num of NULL. --Exection of stored procedure fails due to order_num column not allowing NULL values--unsure why @@IDENTITY does this or how it works. Requires further investigationSELECT * FROM Customers;