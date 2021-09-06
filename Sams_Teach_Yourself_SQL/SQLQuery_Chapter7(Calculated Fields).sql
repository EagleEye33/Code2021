SELECT Concat(RTRIM(vend_name), ' (', RTRIM(vend_country), ')') 
FROM Vendors
ORDER BY vend_name;

 -- or with the same result 

SELECT RTRIM(vend_name) + ' (' + RTRIM(vend_country) + ')'
FROM Vendors
ORDER BY vend_name;

--LTRIM(), RTRIM(), TRIM()

SELECT Concat(RTRIM(vend_name), ' (', RTRIM(vend_country), ')')
AS vend_title
FROM Vendors
ORDER BY vend_name;

SELECT prod_id, quantity, item_price, quantity*item_price AS expanded_price
FROM OrderItems
WHERE order_num = 20008;

SELECT 3 * 2 AS BigCalculation
SELECT Trim('      abc   ' ) AS HeyTrimbo;

SELECT vend_id, 
		vend_name AS vname, 
		vend_city AS vcity, 
		vend_address AS vaddress
FROM Vendors
ORDER BY vname;   --challenge 1

SELECT prod_id, prod_price,
		0.9 * prod_price AS sale_price
FROM Products;    --challenge 2









