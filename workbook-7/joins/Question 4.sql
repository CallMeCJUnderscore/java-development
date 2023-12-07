SELECT p.ProductName, c.CategoryName
FROM northwind.products AS p JOIN northwind.categories AS c
	ON p.CategoryID = c.CategoryID
WHERE p.UnitPrice IN (SELECT MAX(UnitPrice) FROM northwind.products);