package ProgramBD.Roberto.ProductoHistorico.ProductoModificar;

import ProgramBD.DatabaseConnection;
import ProgramBD.Roberto.ProductoHistorico.Producto.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificarProducto {
    private static PreparedStatement ps;

    static{
        String sqlQuery =   "UPDATE Production.Product SET " +
                            "Name = ?,"+
                            "ProductNumber = ?,"+
                            "MakeFlag = ?,"+
                            "FinishedGoodsFlag = ?,"+
                            "Color = ?,"+
                            "SafetyStockLevel = ?,"+
                            "ReorderPoint = ?,"+
                            "StandardCost = ?,"+
                            "ListPrice = ?,"+
                            "Size = ?,"+
                            "SizeUnitMeasureCode = ?,"+
                            "WeightUnitMeasureCode = ?,"+
                            "Weight = ?,"+
                            "DaysToManufacture = ?,"+
                            "ProductSubcategoryID = ?,"+
                            "ProductModelID = ?,"+
                            "SellStartDate = ?,"+
                            "SellEndDate = ?,"+
                            "DiscontinuedDate = ?,"+
                            "ModifiedDate = ? "+
                            "WHERE ProductID = ?";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try{
            ps= conn.prepareStatement(sqlQuery);
        }catch (SQLException e){
            System.out.println("Error in prepared statement CargarProducto error"+e);
        }
    }


    public static boolean modificarP(Producto producto){
        try{
            ps.setString(1,producto.getName());
            ps.setString(2,producto.getProductNumber());
            ps.setInt(3,Integer.valueOf(producto.getMakeFlag()));
            ps.setInt(4,Integer.valueOf(producto.getFinishedGoodsFlag()));
            ps.setString(5,producto.getColor());
            ps.setInt(6,Integer.valueOf(producto.getSafetyStockLevel()));
            ps.setInt(7,Integer.valueOf(producto.getReorderPoint()));
            ps.setDouble(8,Double.valueOf(producto.getStandardCost()));
            ps.setDouble(9,Double.valueOf(producto.getListPrice()));
            ps.setString(10,producto.getSize());
            ps.setString(11,producto.getSizeUnitMeasureCode());
            ps.setString(12,producto.getWeightUnitMeasureCode());
            ps.setString(13,producto.getWeight());
            ps.setString(14,producto.getDaysToManufacture());
            ps.setString(15,producto.getProductSubcategoryID());
            ps.setString(16,producto.getProductModelID());
            ps.setString(17,producto.getSellStartDate());
            ps.setString(18,producto.getSellEndDate());
            ps.setString(19,producto.getDiscontinuedDate());
            ps.setString(20,producto.getModifiedDate());
            ps.setInt(21,Integer.valueOf(producto.getProductID()));
            ps.executeUpdate();
            return  true;
        }catch (SQLException e ){
            System.out.println("Error in update query ModificarProducto error"+e);
            return  false;
        }
    }

}
