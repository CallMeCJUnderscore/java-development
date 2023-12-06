SELECT FirstName, LastName FROM northwind.employees
WHERE EmployeeID IN (SELECT EmployeeID FROM northwind.orders
					WHERE OrderID = 10266);