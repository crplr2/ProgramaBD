package ProgramBD.Roberto.ProductoHistorico.Producto;

import ProgramBD.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargarProducto {
    private static PreparedStatement ps;

    static{
        String sqlQuery = "SELECT * FROM Production.Product ";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try{
            ps= conn.prepareStatement(sqlQuery);
        }catch (SQLException e){
            System.out.println("Error in prepared statement CargarProducto error"+e);
        }
    }



    public static List<Producto> todosProducto(){
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<>();
        try{
            rs = ps.executeQuery();
            while (rs.next()){
                Producto producto = new Producto();
                producto.setProductID(rs.getString(1));
                producto.setName(rs.getString(2));
                producto.setProductNumber(rs.getString(3));
                producto.setMakeFlag(rs.getString(4));
                producto.setFinishedGoodsFlag(rs.getString(5));
                producto.setColor(rs.getString(6));
                producto.setSafetyStockLevel(rs.getString(7));
                producto.setReorderPoint(rs.getString(8));
                producto.setStandardCost(rs.getString(9));
                producto.setListPrice(rs.getString(10));
                producto.setSize(rs.getString(11));
                producto.setSizeUnitMeasureCode(rs.getString(12));
                producto.setWeightUnitMeasureCode(rs.getString(13));
                producto.setWeight(rs.getString(14));
                producto.setDaysToManufacture(rs.getString(15));
                producto.setProductLine(rs.getString(16));
                producto.setOClass(rs.getString(17));
                producto.setStyle(rs.getString(18));
                producto.setProductSubcategoryID(rs.getString(19));
                producto.setProductModelID(rs.getString(20));
                producto.setSellStartDate(rs.getString(21));
                producto.setSellEndDate(rs.getString(22));
                producto.setDiscontinuedDate(rs.getString(23));
                producto.setRowguid(rs.getString(24));
                producto.setModifiedDate(rs.getString(25));
                productos.add(producto);
            }
        }catch (SQLException e ){
            System.out.println("Error in result set CargarProducto error"+e);
        }
        return productos;
    }


}
