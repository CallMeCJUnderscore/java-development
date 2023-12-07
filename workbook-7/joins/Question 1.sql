SELECT p.ProductID, p.ProductName, p.UnitPrice, c.CategoryName
FROM northwind.products AS p JOIN northwind.categories AS c
ON p.CategoryID = c.CategoryID
ORDER BY c.CategoryName, p.ProductName;