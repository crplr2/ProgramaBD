package ProgramBD.Roberto.ProductoHistorico.ProductoHistorico;

import ProgramBD.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargarHistorico {
    private static PreparedStatement ps;

    static{
        String sqlQuery = "SELECT * FROM CambiosProductoHistorico ";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try{
            ps= conn.prepareStatement(sqlQuery);
        }catch (SQLException e){
            System.out.println("Error in prepared statement CargarHistorico error"+e);
        }
    }

    public static List<ProductoHistorico> historicoProducto(){
        ResultSet rs = null;
        List<ProductoHistorico> productos = new ArrayList<>();
        try{
            rs = ps.executeQuery();
            while (rs.next()){
                ProductoHistorico ph = new ProductoHistorico();
                ph.setIDProducto(rs.getString(1));
                ph.setCampoModificado(rs.getString(2));
                ph.setValorAnterior(rs.getString(3));
                ph.setValorNuevo(rs.getString(4));
                ph.setFechaModificacion(rs.getString(5));
                productos.add(ph);
            }
        }catch (SQLException e ){
            System.out.println("Error in result set CargarProducto error"+e);
        }

        return productos;
    }
}
