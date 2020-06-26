use AdventureWorks2008;

-- cau 1 
SELECT * From Person.Person;
-- cau 2
SELECT Title, FirstName, MiddleName, LastName và Person.EmailAddress.EmailAddress
FROM Person.Person, Person.EmailAddress
WHERE Person.EmailAddress.BussinessEntityID = Person.Person.BussinessEntityID;
-- cau 3 
SELECT ISNULL(Title,'') + ISNULL(FirstName,'') + ISNULL(LastName,'')
FROM AdventureWorks2008.Person.Person
-- cau 4 
SELECT AddressLine1 FROM AdventureWorks2008.Person.Address
-- cau 5 
SELECT DISTINCT City FROM AdventureWorks2008.Person.Address
-- cau 6 
SELECT TOP 10 * FROM AdventureWorks2008.Person.Address;
-- cau 7
Select avg(Rate) FROM AdventureWorks2008.HumanResources.EmployeePayHistory;
-- cau 8 
SELECT count(BusinessEntityId) From AdventureWorks2008.HumanResources.Employee; 
-- cau 9 
SELECT CustomerID
FROM AdventureWorks2008.Sales.SalesOrderHeader 
GROUP BY (CustomerID)
HAVING COUNT (CustomerID) > 10
-- cau 10 
SELECT ProductID From Production.Product
Group By Production.Product.ProductID
HAVING Production.Product.ProductID NOT IN (
SELECT Sales.SalesOrderDetail.ProductID From Sales.SalesOrderDetail, Production.Product
WHERE Production.Product.ProductID = Sales.SalesOrderDetail.ProductID
 );
-- cau 11
First is Cost of Clustered Index Seek is 56%, of Index Seek(NonClustered) is 39 % 
Second, Conduct in the same time inner join (Cost 1%) and Index Scan (2%)
Last, Left Anti Semi Join (Cost 1%). 
-- cau 12
Time for Select Query use index is faster than Query not use index, 
Time for Update, delete Query use index is faster than Query not use index
-- cau 13 
SELECT ProductID FROM Production.Product
WHERE ProductID NOT IN (
SELECT Sales.SalesOrderDetail.ProductID From Sales.SalesOrderDetail, Production.Product
WHERE Production.Product.ProductID = Sales.SalesOrderDetail.ProductID
 );
 
 

