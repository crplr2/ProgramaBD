

 --TOP 5 PRODUCTOS MAS VENDIDOS--
 select top(5) ProductID, SUM(OrderQty) as 'Cantidad' from Sales.SalesOrderDetail 
 group by ProductID 
 order by 'Cantidad' desc

 
 --T0P 5 PRODUCTOS MENOS VENDIDOS--
  select top(5) ProductID, SUM(OrderQty) as 'Cantidad' from Sales.SalesOrderDetail 
 group by ProductID 
 order by 'Cantidad' asc


 --LLAMAR A LA FUNCION--
select * from ProductoVendidoTabla(1)


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

 