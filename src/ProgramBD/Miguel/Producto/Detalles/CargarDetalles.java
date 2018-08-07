package ProgramBD.Miguel.Producto.Detalles;
import ProgramBD.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargarDetalles {
    private static PreparedStatement ps;
    private static ResultSet rs= null;
    private static Connection conn= DatabaseConnection.getInstance().getConnection();

    public static List<ProductoDetalles> cargarDetalles(int id){
        String sql="select * from masDetalles(?)";
        List<ProductoDetalles> lista = new ArrayList<ProductoDetalles>();
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                ProductoDetalles producto= new ProductoDetalles();
                producto.setProductID(rs.getInt(1));
                producto.setProductName(rs.getString(2));
                producto.setColor(rs.getString(3));
                producto.setCantidad(rs.getInt(4));
                producto.setLocation(rs.getString(5));
                lista.add(producto);
            }
        }catch (SQLException e){
            System.out.println("ERROR in sql statement cargarDetalles error: "+e);
        }
        return lista;
    }
}