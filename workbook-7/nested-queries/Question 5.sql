SELECT CompanyName FROM northwind.customers
WHERE CustomerID IN (SELECT CustomerID FROM northwind.orders
					WHERE OrderID = 10266);