SELECT CategoryID, AVG(UnitPrice) FROM northwind.products
GROUP BY CategoryID;