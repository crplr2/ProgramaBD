CREATE OR ALTER PROCEDURE ReportOne
AS
BEGIN
SELECT TOP 20 pp.ProductID, pp.Name, pp.StandardCost,pp.ListPrice, sso.SpecialOfferID, sso.Description, sso.DiscountPct, sso.Type,sso.MinQty,sso.MaxQty
FROM Production.Product pp INNER JOIN
Sales.SpecialOfferProduct ssp ON ssp.ProductID = pp.ProductID INNER JOIN 
Sales.SpecialOffer sso ON sso.SpecialOfferID = ssp.SpecialOfferID 
WHERE sso.Type<>'No Discount'
ORDER BY sso.DiscountPct DESC
END


CREATE OR ALTER PROCEDURE ReportTwo
AS
BEGIN
SELECT TOP 20 pp.VendorID,pv.AccountNumber,pv.Name, COUNT(pp.PurchaseOrderID) AS CantidadCompras ,SUM(pp.TotalDue) AS TotalCompras,pv.CreditRating, pv.PreferredVendorStatus
FROM Purchasing.PurchaseOrderHeader pp INNER JOIN
Purchasing.Vendor pv ON pv.BusinessEntityID = pp.VendorID
GROUP BY pp.VendorID, pv.AccountNumber,pv.Name,pv.CreditRating,pv.PreferredVendorStatus, pp.TotalDue
ORDER BY TotalCompras DESC
END


CREATE OR ALTER PROCEDURE ReportThree
AS
BEGIN
SELECT TOP 30 ProductID,ProductNumber,Name, SafetyStockLevel, ReorderPoint,DaysToManufacture,StandardCost,ListPrice FROM Production.Product ORDER BY SafetyStockLevel 
END

EXEC ReportOne
EXEC ReportTwo
EXEC ReportThree


select * from Production.Product
select * from Sales.SpecialOfferProduct
select * from Sales.SpecialOffer
select * from Purchasing.PurchaseOrderHeader
select * from Purchasing.Vendor

select * from Production.TransactionHistory

BEGIN TRAN
ROLLBACK TRAN
SELECT name FROM sys.columns WHERE object_id = OBJECT_ID('AdventureWorks2014.Production.Product') 





