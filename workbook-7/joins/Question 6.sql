SELECT o.OrderID, o.OrderDate, o.ShipName, o.ShipAddress
FROM northwind.orders AS o JOIN northwind.`order details` AS d
	ON o.OrderID = d.OrderID
JOIN northwind.products AS p
	ON d.ProductID = p.ProductID
WHERE p.ProductName = "Sasquatch Ale";