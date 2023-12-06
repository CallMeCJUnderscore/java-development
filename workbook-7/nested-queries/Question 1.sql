SELECT ProductName FROM northwind.products
WHERE UnitPrice IN (SELECT MAX(UnitPrice) FROM northwind.products);