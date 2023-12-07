SELECT p.ProductID, p.ProductName, p.UnitPrice, c.CategoryName, s.CompanyName
FROM northwind.products AS p JOIN northwind.suppliers AS s
	ON p.SupplierID = s.SupplierID
JOIN northwind.categories AS c
	ON p.CategoryID = c.CategoryID
ORDER BY p.ProductName;