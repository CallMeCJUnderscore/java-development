SELECT SupplierID, SUM(UnitsInStock) + SUM(UnitsOnOrder) FROM northwind.products
GROUP BY SupplierID;