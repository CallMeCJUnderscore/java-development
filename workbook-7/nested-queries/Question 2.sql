SELECT OrderID, ShipName, ShipAddress FROM northwind.orders
WHERE ShipVia IN (SELECT ShipperID FROM northwind.shippers
					WHERE CompanyName LIKE ("Federal Shipping"));