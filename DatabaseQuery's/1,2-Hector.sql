--Sistema que muestre un listado de productos (nombre, precio, descuento)
CREATE OR ALTER PROCEDURE ListadoProductos 
AS
BEGIN
SELECT DISTINCT pp.ProductID,pp.Name,pp.Color,pp.StandardCost, pin.Quantity, sod.UnitPrice, sod.UnitPriceDiscount, sso.Description
FROM Production.Product pp
INNER JOIN Production.ProductInventory pin ON pp.ProductID=pin.ProductID 
INNER JOIN Sales.SalesOrderDetail sod ON pp.ProductID=sod.ProductID
INNER JOIN Sales.SpecialOffer sso ON sod.SpecialOfferID=sso.SpecialOfferID
END



--Sistema que muestre un listado de productos (nombre, precio, descuento) donde busca el id
CREATE OR ALTER PROCEDURE ListadoProductosPorID
@ProductID INT
AS
BEGIN
SELECT DISTINCT pp.ProductID,pp.Name,pp.Color,pp.StandardCost, pin.Quantity, sod.UnitPrice, sod.UnitPriceDiscount, sso.Description
FROM Production.Product pp
INNER JOIN Production.ProductInventory pin ON pp.ProductID=pin.ProductID 
INNER JOIN Sales.SalesOrderDetail sod ON pp.ProductID=sod.ProductID
INNER JOIN Sales.SpecialOffer sso ON sod.SpecialOfferID=sso.SpecialOfferID
WHERE pp.ProductID = @ProductID
END




--Búsqueda por nombre (Producto) 
CREATE OR ALTER FUNCTION dbo.busqueda_nombre(@nom varchar(30))  
RETURNS INT
AS   
BEGIN  
DECLARE @temp INT;  
SELECT  @temp = pp.ProductID
FROM Production.Product pp
INNER JOIN Production.ProductInventory pin ON pp.ProductID=pin.ProductID 
INNER JOIN Sales.SalesOrderDetail sod ON pp.ProductID=sod.ProductID
INNER JOIN Sales.SpecialOffer sso ON sod.SpecialOfferID=sso.SpecialOfferID 
WHERE pp.name = @nom
IF (@temp IS NULL)   
	BEGIN
        SET @temp = -1
	END
RETURN @temp
END


--Búsqueda por nombre (Producto) alternativo con like
CREATE OR ALTER FUNCTION dbo.busqueda_nombre(@nom varchar(30))  
RETURNS INT
AS   
BEGIN  
DECLARE @temp INT;  
SELECT  @temp = pp.ProductID
FROM Production.Product pp
INNER JOIN Production.ProductInventory pin ON pp.ProductID=pin.ProductID 
INNER JOIN Sales.SalesOrderDetail sod ON pp.ProductID=sod.ProductID
INNER JOIN Sales.SpecialOffer sso ON sod.SpecialOfferID=sso.SpecialOfferID 
WHERE pp.name LIKE '%'+@nom+'%'
IF (@temp IS NULL)   
	BEGIN
        SET @temp = -1
	END
RETURN @temp
END




drop function dbo.busqueda_nombre
SELECT  dbo.busqueda_nombre ('Sport-100 Helmet, Black')
FROM Production.Product 

EXEC ListadoProductos
EXEC ListadoProductosPorID 708