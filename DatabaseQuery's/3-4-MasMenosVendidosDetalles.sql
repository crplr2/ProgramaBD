

--FUNCION PARA MAS DETALLES--

create function masDetalles(@id int)
returns @tabla table(
ProductID int,ProductName nvarchar(30),Color nvarchar(30),CantidadInventario int, Location nvarchar(30))
as
begin
insert into @tabla (ProductID,ProductName,Color,CantidadInventario,Location)
select pp.ProductID, pp.Name,pp.Color,ppi.Quantity,pl.Name from Production.Product pp inner join Production.ProductInventory ppi
on pp.ProductID=ppi.ProductID inner join Production.Location pl on ppi.LocationID=pl.LocationID
where pp.ProductID=@id
return
end

------------------------------------------------------------------------------------------------------
--FUNCION PARA DAR EL PRODUCTO MAS VENDIDO Y EL MENOS VENDIDO--

 create function ProductoVendidoTabla (@vendido int)
 returns @tabla table 
 (ProductoID int, Cantidad int)
 as 
 begin
 declare @producto int;
  if(@vendido = 1)
  begin
  insert into @tabla (ProductoID,Cantidad)
  select top(15) ProductID, SUM(OrderQty) as 'Cantidad' from Sales.SalesOrderDetail 
 group by ProductID 
 order by 'Cantidad' desc
 end
 else
 begin
	insert into @tabla (ProductoID,Cantidad)
	select top(15) ProductID, SUM(OrderQty) as 'Cantidad' from Sales.SalesOrderDetail 
	group by ProductID 
	order by 'Cantidad' asc
end
return 
end


--MOSTRAR EN PROGRAMA--
select pp.ProductID,pp.Name,pp.ProductNumber from Production.Product pp


	
  
 ----------------------------------------------------------------------------------------------------------------
 ----------------------------------------------------------------------------------------------------------------

 