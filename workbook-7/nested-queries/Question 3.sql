SELECT OrderID FROM northwind.`order details`
WHERE ProductID IN (SELECT ProductID FROM northwind.products
					WHERE ProductName LIKE ("Sasquatch Ale"));