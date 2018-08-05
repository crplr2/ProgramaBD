ALTER   TRIGGER [Production].[anyUpdate] on [Production].[Product] 
AFTER UPDATE AS
BEGIN
---------------------------------------------------------------------------------------------------------
--ESTO PARA VALIDAR QUE EN SOLO UN ELEMENTO REALIZE EL UPDATE EN CASO CONTRARIO REGRESA
IF((SELECT COUNT(ProductID) FROM deleted)>1)
BEGIN
	RETURN
END
---------------------------------------------------------------------------------------------------------
--ESTO ES PARA SACAR LOS CAMPOS DE LOS CUALES SE REALIZO EL UPDATE
DECLARE @Columns_Updated NVARCHAR(MAX)
DECLARE @ValorAnterior NVARCHAR(MAX)
DECLARE @ValorNuevo NVARCHAR(MAX)


IF ( ((SELECT Name FROM deleted ) IS NULL AND (SELECT Name FROM inserted ) IS NOT NULL) OR 
	 ((SELECT Name FROM inserted ) IS NULL AND (SELECT Name FROM deleted ) IS NOT NULL)  OR
	 ((SELECT Name  FROM inserted ) <> (SELECT Name FROM deleted )))
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'Name'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.Name),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.Name),'NULL'),CHAR(10))
	FROM INSERTED a
END

	 

IF ( ((SELECT ProductNumber FROM deleted) IS NULL AND (SELECT ProductNumber FROM inserted) IS NOT NULL) OR 
	 ((SELECT ProductNumber FROM inserted) IS NULL AND (SELECT ProductNumber FROM deleted) IS NOT NULL) OR
	 ((SELECT ProductNumber FROM inserted) <> (SELECT ProductNumber FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'ProductNumber'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.ProductNumber),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.ProductNumber),'NULL'),CHAR(10))
	FROM INSERTED a

END



IF ( ((SELECT MakeFlag FROM deleted) IS NULL AND (SELECT MakeFlag FROM inserted) IS NOT NULL) OR 
	 ((SELECT MakeFlag FROM inserted) IS NULL AND (SELECT MakeFlag FROM deleted) IS NOT NULL) OR
	 ((SELECT MakeFlag FROM inserted) <> (SELECT MakeFlag FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'MakeFlag'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.MakeFlag),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.MakeFlag),'NULL'),CHAR(10))
	FROM INSERTED a
END



IF ( ((SELECT FinishedGoodsFlag FROM deleted) IS NULL AND (SELECT FinishedGoodsFlag FROM inserted ) IS NOT NULL) OR 
	 ((SELECT FinishedGoodsFlag FROM inserted) IS NULL AND (SELECT FinishedGoodsFlag FROM deleted ) IS NOT NULL) OR
	 ((SELECT FinishedGoodsFlag FROM inserted) <> (SELECT FinishedGoodsFlag FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'FinishedGoodsFlag'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.FinishedGoodsFlag),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.FinishedGoodsFlag),'NULL'),CHAR(10))
	FROM INSERTED a
END



IF ( ((SELECT Color FROM deleted) IS NULL AND (SELECT Color FROM inserted ) IS NOT NULL) OR 
	 ((SELECT Color FROM inserted) IS NULL AND (SELECT Color FROM deleted ) IS NOT NULL) OR
	 ((SELECT Color FROM inserted) <> (SELECT Color FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'Color'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.Color),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.Color),'NULL'),CHAR(10))
	FROM INSERTED a
END



IF ( ((SELECT SafetyStockLevel FROM deleted) IS NULL AND (SELECT SafetyStockLevel FROM inserted ) IS NOT NULL) OR 
	 ((SELECT SafetyStockLevel FROM inserted) IS NULL AND (SELECT SafetyStockLevel FROM deleted ) IS NOT NULL) OR
	 ((SELECT SafetyStockLevel FROM inserted) <> (SELECT SafetyStockLevel FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'SafetyStockLevel'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.SafetyStockLevel),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.SafetyStockLevel),'NULL'),CHAR(10))
	FROM INSERTED a
END


IF ( ((SELECT ReorderPoint FROM deleted) IS NULL AND (SELECT ReorderPoint FROM inserted ) IS NOT NULL) OR 
	 ((SELECT ReorderPoint FROM inserted) IS NULL AND (SELECT ReorderPoint FROM deleted ) IS NOT NULL) OR
	 ((SELECT ReorderPoint FROM inserted) <> (SELECT ReorderPoint FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'ReorderPoint'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.ReorderPoint),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.ReorderPoint),'NULL'),CHAR(10))
	FROM INSERTED a
END


IF ( ((SELECT StandardCost FROM deleted) IS NULL AND (SELECT StandardCost FROM inserted ) IS NOT NULL) OR 
	 ((SELECT StandardCost FROM inserted) IS NULL AND (SELECT StandardCost FROM deleted ) IS NOT NULL) OR
	 ((SELECT StandardCost FROM inserted) <> (SELECT StandardCost FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'StandardCost'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.StandardCost),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.StandardCost),'NULL'),CHAR(10))
	FROM INSERTED a
END


IF ( ((SELECT ListPrice FROM deleted) IS NULL AND (SELECT ListPrice FROM inserted ) IS NOT NULL) OR 
	 ((SELECT ListPrice FROM inserted) IS NULL AND (SELECT ListPrice FROM deleted ) IS NOT NULL) OR
	 ((SELECT ListPrice FROM inserted) <> (SELECT ListPrice FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'ListPrice'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.ListPrice),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.ListPrice),'NULL'),CHAR(10))
	FROM INSERTED a
END



IF ( ((SELECT Size FROM deleted) IS NULL AND (SELECT Size FROM inserted ) IS NOT NULL) OR 
	 ((SELECT Size FROM inserted) IS NULL AND (SELECT Size FROM deleted ) IS NOT NULL) OR
	 ((SELECT Size FROM inserted) <> (SELECT Size FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'Size'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.Size),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.Size),'NULL'),CHAR(10))
	FROM INSERTED a
END


IF ( ((SELECT SizeUnitMeasureCode FROM deleted) IS NULL AND (SELECT SizeUnitMeasureCode FROM inserted ) IS NOT NULL) OR 
	 ((SELECT SizeUnitMeasureCode FROM inserted) IS NULL AND (SELECT SizeUnitMeasureCode FROM deleted ) IS NOT NULL) OR
	 ((SELECT SizeUnitMeasureCode FROM inserted) <> (SELECT SizeUnitMeasureCode FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'SizeUnitMeasureCode'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.SizeUnitMeasureCode),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.SizeUnitMeasureCode),'NULL'),CHAR(10))
	FROM INSERTED a
END


IF ( ((SELECT WeightUnitMeasureCode FROM deleted) IS NULL AND (SELECT WeightUnitMeasureCode FROM inserted ) IS NOT NULL) OR 
	 ((SELECT WeightUnitMeasureCode FROM inserted) IS NULL AND (SELECT WeightUnitMeasureCode FROM deleted ) IS NOT NULL) OR
	 ((SELECT WeightUnitMeasureCode FROM inserted) <> (SELECT WeightUnitMeasureCode FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'WeightUnitMeasureCode'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.WeightUnitMeasureCode),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.WeightUnitMeasureCode),'NULL'),CHAR(10))
	FROM INSERTED a
END


IF ( ((SELECT Weight FROM deleted) IS NULL AND (SELECT Weight FROM inserted ) IS NOT NULL) OR 
	 ((SELECT Weight FROM inserted) IS NULL AND (SELECT Weight FROM deleted ) IS NOT NULL) OR
	 ((SELECT Weight FROM inserted) <> (SELECT Weight FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'Weight'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.Weight),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.Weight),'NULL'),CHAR(10))
	FROM INSERTED a
END


IF ( ((SELECT DaysToManufacture FROM deleted) IS NULL AND (SELECT DaysToManufacture FROM inserted ) IS NOT NULL) OR 
	 ((SELECT DaysToManufacture FROM inserted) IS NULL AND (SELECT DaysToManufacture FROM deleted ) IS NOT NULL) OR
	 ((SELECT DaysToManufacture FROM inserted) <> (SELECT DaysToManufacture FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'DaysToManufacture'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.DaysToManufacture),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.DaysToManufacture),'NULL'),CHAR(10))
	FROM INSERTED a
END


IF ( ((SELECT ProductSubcategoryID FROM deleted) IS NULL AND (SELECT ProductSubcategoryID FROM inserted ) IS NOT NULL) OR 
	 ((SELECT ProductSubcategoryID FROM inserted) IS NULL AND (SELECT ProductSubcategoryID FROM deleted ) IS NOT NULL) OR
	 ((SELECT ProductSubcategoryID FROM inserted) <> (SELECT ProductSubcategoryID FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'ProductSubcategoryID'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.ProductSubcategoryID),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.ProductSubcategoryID),'NULL'),CHAR(10))
	FROM INSERTED a
END


IF ( ((SELECT ProductModelID FROM deleted) IS NULL AND (SELECT ProductModelID FROM inserted ) IS NOT NULL) OR 
	 ((SELECT ProductModelID FROM inserted) IS NULL AND (SELECT ProductModelID FROM deleted ) IS NOT NULL) OR
	 ((SELECT ProductModelID FROM inserted) <> (SELECT ProductModelID FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'ProductModelID'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.ProductModelID),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.ProductModelID),'NULL'),CHAR(10))
	FROM INSERTED a
END



IF ( ((SELECT SellEndDate FROM deleted) IS NULL AND (SELECT SellEndDate FROM inserted ) IS NOT NULL) OR 
	 ((SELECT SellEndDate FROM inserted) IS NULL AND (SELECT SellEndDate FROM deleted ) IS NOT NULL) OR
	 ((SELECT SellEndDate FROM inserted) <> (SELECT SellEndDate FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'SellEndDate'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.SellEndDate),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.SellEndDate),'NULL'),CHAR(10))
	FROM INSERTED a
END



IF ( ((SELECT DiscontinuedDate FROM deleted) IS NULL AND (SELECT DiscontinuedDate FROM inserted ) IS NOT NULL) OR 
	 ((SELECT DiscontinuedDate FROM inserted) IS NULL AND (SELECT DiscontinuedDate FROM deleted ) IS NOT NULL) OR
	 ((SELECT DiscontinuedDate FROM inserted) <> (SELECT DiscontinuedDate FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'DiscontinuedDate'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.DiscontinuedDate),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.DiscontinuedDate),'NULL'),CHAR(10))
	FROM INSERTED a
END


IF ( ((SELECT ModifiedDate FROM deleted) IS NULL AND (SELECT ModifiedDate FROM inserted ) IS NOT NULL) OR 
	 ((SELECT ModifiedDate FROM inserted) IS NULL AND (SELECT ModifiedDate FROM deleted ) IS NOT NULL) OR
	 ((SELECT ModifiedDate FROM inserted) <> (SELECT ModifiedDate FROM deleted)) )
BEGIN
	SELECT @Columns_Updated= CONCAT(@Columns_Updated,'ModifiedDate'+CHAR(10))
	SELECT @ValorAnterior = CONCAT(@ValorAnterior, ISNULL(CONVERT(nvarchar(MAX),a.ModifiedDate),'NULL'),CHAR(10))
	FROM DELETED a
	SELECT @ValorNuevo = CONCAT(@ValorNuevo, ISNULL(CONVERT(nvarchar(MAX),a.ModifiedDate),'NULL'),CHAR(10))
	FROM INSERTED a
END
-----------------------------------------------------------------------------------------------------------
--ESTO ES PARA SACAR EL ProductID DE LA TABLA
DECLARE @ID INT
SELECT @ID = ProductID
FROM INSERTED
-----------------------------------------------------------------------------------------------------------
--ESTO ES PARA INSERTAR VALORES EN LA TABLA
IF(@Columns_Updated IS NOT NULL)
	BEGIN 
	INSERT INTO CambiosProductoHistorico(IDProducto,CampoModificado,ValorAnterior,ValorNuevo,FechaModificacion) 
	VALUES(@ID,@Columns_Updated,@ValorAnterior,@ValorNuevo,GETDATE())
	END
END









CREATE OR ALTER TRIGGER anyDelete on Production.Product 
AFTER DELETE AS
BEGIN
---------------------------------------------------------------------------------------------------------
--ESTO PARA VALIDAR QUE EN SOLO UN ELEMENTO REALIZE EL DELETE EN CASO CONTRARIO REGRESA
IF((SELECT COUNT(ProductID) FROM deleted)>1)
BEGIN
	RETURN
END
---------------------------------------------------------------------------------------------------------
--ESTO ES PARA OBTENER LOS CAMPOS DE LOS CUALES SE REALIZO EL DELETE
DECLARE @Columns_Updated NVARCHAR(MAX)
SET   @Columns_Updated =  
'ProductID
Name
ProductNumber
MakeFlag
FinishedGoodsFlag
Color
SafetyStockLevel
ReorderPoint
StandardCost
ListPrice
Size
SizeUnitMeasureCode
WeightUnitMeasureCode
Weight
DaysToManufacture
ProductLine
Class
Style
ProductSubcategoryID
ProductModelID
SellStartDate
SellEndDate
DiscontinuedDate
rowguid
ModifiedDate'
-----------------------------------------------------------------------------------------------------------
--ESTO ES PARA TENER EL ProductID DE LA TABLA
DECLARE @ID INT
SELECT @ID = ProductID
FROM DELETED
-----------------------------------------------------------------------------------------------------------
--ESTO ES PARA EL VALOR ANTERIOR
DECLARE @ValorAnterior NVARCHAR(MAX)
SELECT  @ValorAnterior = 
		   ISNULL(CONVERT(nvarchar(MAX),a.ProductID),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.Name),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.ProductNumber),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.MakeFlag),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.FinishedGoodsFlag),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.Color),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.SafetyStockLevel),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.ReorderPoint),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.StandardCost),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.ListPrice),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.Size),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.SizeUnitMeasureCode),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.WeightUnitMeasureCode),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.Weight),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.DaysToManufacture),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.ProductLine),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.Class),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.Style),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.ProductSubcategoryID),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.ProductModelID),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.SellStartDate),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.SellEndDate),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.DiscontinuedDate),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.rowguid),'NULL')
+CHAR(10)+ ISNULL(CONVERT(nvarchar(MAX),a.ModifiedDate),'NULL')
FROM DELETED a
-----------------------------------------------------------------------------------------------------------
--ESTO ES PARA EL VALOR NUEVO
DECLARE @ValorNuevo NVARCHAR(MAX)
SET @ValorNuevo = 'PRODUCTO ELIMINADO'
-----------------------------------------------------------------------------------------------------------
--ESTO ES PARA INSERTAR VALORES EN LA TABLA
INSERT INTO CambiosProductoHistorico(IDProducto,CampoModificado,ValorAnterior,ValorNuevo,FechaModificacion) 
VALUES(@ID,@Columns_Updated,@ValorAnterior,@ValorNuevo,GETDATE())
END
-----------------------------------------------------------------------------------------------------------------



create table CambiosProductoHistorico(
IDProducto int, 
CampoModificado nvarchar(MAX),
ValorAnterior nvarchar(MAX),
ValorNuevo nvarchar(MAX),
FechaModificacion DATE)




-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
------------------------------------------------TEST-----------------------------------------------------------


update  Production.Product set Name = 'Adjustable Race', Color = 'Blue', SafetyStockLevel = 1002 where ProductID = 1;
select * from CambiosProductoHistorico
select * from Production.Product WHERE ProductID = 843
DELETE   from CambiosProductoHistorico
drop table CambiosProductoHistorico

BEGIN TRAN
DELETE FROM Production.Product WHERE ProductID = 799;
ROLLBACK TRAN



BEGIN TRAN
update  Production.Product set 
Name = 'test', 
ProductNumber = 1,
MakeFlag = 1,
FinishedGoodsFlag = 1,
Color = 'test', 
SafetyStockLevel = 800,
ReorderPoint = 1,
StandardCost = 1,
ListPrice = 1,
Size = 't',
SizeUnitMeasureCode = 't',
WeightUnitMeasureCode = 't',
Weight = 1,
DaysToManufacture = 1,
ProductSubcategoryID = 1,
ProductModelID = 1,
SellEndDate = '2018-01-01',
DiscontinuedDate = '2018-01-01',
ModifiedDate = '2018-01-01'
where ProductID = 843
ROLLBACK TRAN



BEGIN TRAN
update  Production.Product set 
Color = NULL
WHERE ProductID = 843



SELECT name FROM sys.columns WHERE object_id = OBJECT_ID('AdventureWorks2014.Production.Product') 

















