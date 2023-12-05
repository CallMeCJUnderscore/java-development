 -- Question 1: products

-- Question 2
SELECT ProductID, ProductName, UnitPrice from products;

-- Question 3
SELECT ProductID, ProductName, UnitPrice from products
	ORDER BY UnitPrice ASC;

-- Question 4
SELECT * FROM products
	WHERE UnitPrice < 7.5;

-- Question 5
SELECT * FROM products
	WHERE UnitsInStock >= 100
	ORDER BY UnitPrice DESC;

-- Question 6
SELECT * FROM products
	WHERE UnitsInStock >= 100
	ORDER BY UnitPrice DESC, ProductName ASC;

-- Question 7
SELECT * FROM products
	WHERE UnitsInStock = 0 AND UnitsOnOrder >= 1
    ORDER BY ProductName;

-- Question 8: categories table

-- Question 9: Seafood = 8
SELECT * FROM categories;

-- Question 10: CategoryID column
SELECT * FROM products
	WHERE CategoryID = 8;
    
-- Question 11
SELECT FirstName, LastName FROM employees;

-- Question 12
SELECT * FROM employees
	WHERE Title LIKE "%manager%";
    
-- Question 13
SELECT DISTINCT Title FROM employees;

-- Question 14
SELECT * FROM employees
	WHERE Salary BETWEEN 2000 AND 2500;

-- Question 15
SELECT * FROM suppliers;

-- Question 16: SupplierID column
SELECT * FROM products
	WHERE SupplierID = 4;
