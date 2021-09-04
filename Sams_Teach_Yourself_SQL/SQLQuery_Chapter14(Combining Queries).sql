/*Lesson 14. Combining Queries
In this lesson, you’ll learn how to use the UNION operator to combine multiple
SELECT statements into one result set. */SELECT cust_name, cust_contact, cust_emailFROM CustomersWHERE cust_state IN ('IL', 'IN', 'MI');SELECT cust_name, cust_contact, cust_emailFROM CustomersWHERE cust_name = 'Fun4All';SELECT cust_name, cust_contact, cust_emailFROM CustomersWHERE cust_state IN ('IL', 'IN', 'MI')UNION SELECT cust_name, cust_contact, cust_emailFROM CustomersWHERE cust_name = 'Fun4All';SELECT cust_name, cust_contact, cust_email
FROM Customers
WHERE cust_state IN ('IL','IN','MI')
UNION ALL
SELECT cust_name, cust_contact, cust_email
FROM Customers
WHERE cust_name = 'Fun4All';

/*. UNION ALL is the form of UNION
that accomplishes what cannot be done with WHERE clauses*/

SELECT cust_name, cust_contact, cust_email
FROM Customers
WHERE cust_state IN ('IL','IN','MI')
UNION
SELECT cust_name, cust_contact, cust_email
FROM Customers
WHERE cust_name = 'Fun4All'
ORDER BY cust_name, cust_contact;

SELECT prod_id, quantity
FROM OrderItems
WHERE quantity = 100
UNION
SELECT prod_id, quantity
FROM OrderItems
WHERE prod_id LIKE 'BNBG%'
ORDER BY prod_id;  --challenge 1

SELECT prod_id, quantity
FROM OrderItems
WHERE quantity = 100
OR prod_id LIKE 'BNBG%'
ORDER BY prod_id;  --challenge 2

--remember LIKE is for wildcard searching. DON'T use equals sign

SELECT prod_name
FROM Products
UNION
SELECT cust_name
FROM Customers
ORDER BY prod_name;  --challenge 3

/*SELECT cust_name, cust_contact, cust_email
FROM Customers
WHERE cust_state  = 'MI'
ORDER BY cust_name;
UNION
SELECT cust_name, cust_contact, cust_email
FROM Customers
WHERE cust_state = 'IL'     --challenge 4
ORDER BY cust_name; */
--there should be no ; after the first SELECT statement. Also, there should only
-- be one ORDER BY Clause after the last SELECT statement.



