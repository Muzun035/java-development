-- Question 1 
SELECT COUNT(*)
FROM suppliers;


-- Question 2
SELECT SUM(salary)
from employees;




-- Question 3
SELECT MIN(unitPrice)
from products;




-- Question 4
SELECT AVG(unitPrice)
from products;




-- Question 5
SELECT MAX(unitPrice)
from products;

-- Question 6
SELECT distinct (SupplierID)
FROM products;


-- Question 7
SELECT categoryID, avg(unitPrice)
FROM products
GROUP BY categoryID;


-- Question 8
SELECT supplierId, unitsInStock
FROM products
WHERE unitsInStock <= 5;


-- Question 9
SELECT productID,  productName, UnitPrice * UnitsInStock AS InvantoryValue
FROM products
ORDER BY InvantoryValue DESC, ProductName ASC;





