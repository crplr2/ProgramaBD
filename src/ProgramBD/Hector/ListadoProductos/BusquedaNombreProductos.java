package ProgramBD.Hector.ListadoProductos;

import ProgramBD.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BusquedaNombreProductos {
    private static PreparedStatement ps;

    static{
        String sqlQuery1 = "SELECT  dbo.busqueda_nombre (?)";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try{
            ps= conn.prepareStatement(sqlQuery1);
        }catch (SQLException e){
            System.out.println("Error in prepared statement BusquedaNombreProductos error"+e);
        }
    }

    public static int buscarNombre(String Nombre){
        ResultSet rs ;
        int resultado = -1;
        try{
            ps.setString(1,Nombre);
            rs = ps.executeQuery();
            if(rs.next()){
                resultado = rs.getInt(1);
            }
        }catch (SQLException e ){
            System.out.println("Error in result set buscarNombre error"+e);
        }
        return resultado;
    }

}
