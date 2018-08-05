package ProgramBD.Miguel.Producto;

import ProgramBD.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CargarDetalles {
    private static PreparedStatement ps;
    private static ResultSet rs= null;
    private static Connection conn= DatabaseConnection.getInstance().getConnection();

    public static String cargarDetalles(int id){
        String sql="select Name from Production.ProductSubcategory where ProductSubcategoryID=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                String description=rs.getString(1);
                return description;
            }
        }catch (SQLException e){
            System.out.println("ERROR in sql statement cargarDetalles error: "+e);
        }
        return null;
    }
}
