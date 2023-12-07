SELECT o.OrderID, o.ShipName, o.ShipAddress, s.CompanyName
FROM northwind.orders AS o JOIN northwind.shippers AS s
	ON o.ShipVia = s.ShipperID
WHERE o.ShipCountry = "Germany";