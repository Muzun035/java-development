-- Question 1 
SELECT UnitPrice
FROM products
WHERE UnitPrice = (SELECT MAX(UnitPrice)
		FROM products);



-- Question 2
SELECT Orders.OrderID, Orders.ShipName, Orders.ShipAddress
From orders
Where Orders.ShipVia = ( SELECT ShipperID
						FROM shippers
                        WHERE CompanyName = 'Federal Shipping'
                        );



-- Question 3 
SELECT OrderId
FROM `Order Details`
WHERE ProductID = (SELECT ProductID
				FROM products
                WHERE ProductName = 'Sasquatch Ale'
                );



-- Question 4 
SELECT firstname, lastname
FROM employees
WHERE EmployeeID = ( SELECT EmployeeID
					FROM orders
                    WHERE OrderID = 10266
                    );
                    
-- Question 5
SELECT CompanyName
FROM Customers
WHERE CustomerID = (
  SELECT CustomerID
  FROM Orders
  WHERE OrderID = 10266
);