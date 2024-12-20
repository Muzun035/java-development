-- Question 1: products


-- Question 2: 
SELECT productid, productname, unitprice
FROM products; 



-- Question 3:
SELECT productid, productname, unitprice
from products
 ORDER BY unitprice;




-- Question 4:
SELECT unitprice
FROM products
where unitprice <= 7.50;




-- Question 5:
SELECT *
FROM products
WHERE UnitsInStock <= 100
ORDER BY UnitPrice DESC



-- Question 6:
SELECT *
FROM products
WHERE UnitsInStock <= 100
ORDER BY UnitPrice DESC , productName




-- Question 7:
SELECT *
FROM products
where UnitsInStock = 0 and unitsonorder > 0
order by ProductName;


-- Question 8:
--categories

-- Question 9:
SELECT * 
FROM categories
-- categoryID 8


-- Question 10:
SELECT *
FROM products
WHERE categortid = 8



-- Question 11:
SELECT FirstName, LastName
FROM Employees;


-- Question 12:
SELECT FirstName, LastName, Title
FROM Employees
WHERE Title LIKE "%manager%";




-- Question 13:
SELECT DISTINCT Title 
FROM Employees;




-- Question 14:
SELECT FirstName, LastName, Salary
FROM Employees
WHERE Salary BETWEEN 2000 and 2500;


-- Question 15:
SELECT * 
FROM Suppliers;


-- Question 16:
SELECT *
FROM Products
WHERE SupplierID =4;



