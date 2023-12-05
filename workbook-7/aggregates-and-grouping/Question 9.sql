SELECT ProductID, ProductName, UnitPrice * UnitsInStock AS Value FROM northwind.products
ORDER BY Value DESC, ProductName ASC;