---- Question 1: Add a new supplier
-- Question 1: Add a new supplier
INSERT INTO Suppliers (SupplierID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone)
VALUES (30, 'New Supplier', 'John Doe', 'CEO', '123 Elm St', 'Sample City', 'Region A', '12345', 'Country X', '123-456-7890');
;

-- Question 2: Add a new product provided by that supplier
INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
VALUES (78,'New Product',30,1,10.00);

-- Question 3: List all products and their suppliers
SELECT Products.ProductName, Suppliers.CompanyName
FROM Products
LEFT JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID;
-- Question 4: Raise the price of your new product by 15%
UPDATE Products
SET UnitPrice = UnitPrice * 1.15
WHERE ProductID = '78';

--- Question 5: List the products and prices of all products from that supplier
SELECT ProductName,UnitPrice
FROM Products
WHERE SupplierID = 30;
-- Question 6: Delete the new product
DELETE FROM Products
WHERE ProductID = 30;
-- Question 7: Delete the new supplier
DELETE FROM Suppliers
WHERE CompanyName = 'New Supplier Co';
-- Question 8: List all products
SELECT * FROM Products;
-- Question 9: List all suppliers
SELECT * FROM Suppliers;