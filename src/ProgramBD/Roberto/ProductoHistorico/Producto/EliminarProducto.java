package ProgramBD.Roberto.ProductoHistorico.Producto;

import ProgramBD.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EliminarProducto {

    private static PreparedStatement ps;

    static{
        String sqlQuery = "DELETE FROM Production.Product " +
                        " WHERE ProductID = ?";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try{
            ps= conn.prepareStatement(sqlQuery);
        }catch (SQLException e){
            System.out.println("Error in prepared statement EliminarProducto error"+e);
        }
    }



    public static boolean eliminarP(Producto producto){
        try{
            ps.setInt(1,Integer.valueOf(producto.getProductID()));
            ps.executeUpdate();
            return true;
        }catch (SQLException e ){
            System.out.println("Error in query  EliminarProducto error"+e);
            return false;
        }
    }
}
