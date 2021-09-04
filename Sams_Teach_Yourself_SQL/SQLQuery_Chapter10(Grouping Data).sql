/*In this lesson, you’ll learn how to group data so that you can summarize
subsets of table contents. This involves two new SELECT statement clauses: the
GROUP BY clause and the HAVING clause. */SELECT COUNT(*) AS num_prodsFROM ProductsWHERE vend_id = 'DLL01';/*But what if you wanted to return the number of products offered by each vendor?
Or products offered by vendors who offer a single product, or only those who
offer more than 10 products? */SELECT vend_id, COUNT(*) AS num_prodsFROM ProductsGROUP BY vend_id;--The GROUP BY clause must come after any WHERE clause and before any ORDER
--BY clauseSELECT cust_id, COUNT(*) AS ordersFROM OrdersGROUP BY cust_idHAVING COUNT(*) >= 2;SELECT vend_id, COUNT(*) AS num_prodsFROM ProductsWHERE prod_price >= 4GROUP BY vend_idHAVING COUNT(*) >= 2;-- COMPARESELECT vend_id, COUNT(*) AS num_prodsFROM ProductsGROUP BY vend_idHAVING COUNT(*) >= 2;SELECT order_num, COUNT(*) AS itemsFROM OrderItemsGROUP BY order_num HAVING COUNT(*) >= 3;--compareSELECT order_num, COUNT(*) AS itemsFROM OrderItemsGROUP BY order_num HAVING COUNT(*) >= 3ORDER BY items, order_num;SELECT order_num, COUNT(*) AS order_linesFROM OrderItemsGROUP BY order_numORDER BY order_lines;  --challenge 1SELECT vend_id, MIN(prod_price) AS cheapest_itemFROM ProductsGROUP BY vend_idORDER BY cheapest_item;  --challenge 2SELECT order_num, SUM(quantity) AS highest_order_numFROM OrderItemsWHERE quantity >= 100GROUP BY order_num;  --challenge 3SELECT order_num
FROM OrderItems
GROUP BY order_num
HAVING SUM(quantity) >= 100
ORDER BY order_num;SELECT * FROM OrderItemsSELECT order_num, SUM(item_price*quantity) AS total_priceFROM OrderItemsGROUP BY order_numHAVING SUM(quantity*item_price) >= 1000ORDER BY order_num;  --challenge 4 /* SELECT order_num, COUNT(*) AS items     --challenge 5
FROM OrderItems
GROUP BY items
HAVING COUNT(*) >= 3
ORDER BY items, order_num; Group by must be an actual column, not the one being used to perform the aggregate calculations */