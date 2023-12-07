SELECT p.ProductID, p.ProductName, p.UnitPrice, s.CompanyName
FROM northwind.products AS p JOIN northwind.suppliers AS s
ON p.SupplierID = s.SupplierID
WHERE p.UnitPrice > 75
ORDER BY p.ProductName;