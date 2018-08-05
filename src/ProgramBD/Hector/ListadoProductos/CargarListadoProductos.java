package ProgramBD.Hector.ListadoProductos;

import ProgramBD.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargarListadoProductos {
    private static PreparedStatement ps;
    private static PreparedStatement ps2;

    static{
        String sqlQuery1 = "EXEC ListadoProductos";
        String sqlQuery2 = "EXEC ListadoProductosPorID ?";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try{
            ps= conn.prepareStatement(sqlQuery1);
            ps2 = conn.prepareStatement(sqlQuery2);
        }catch (SQLException e){
            System.out.println("Error in prepared statement CargarListadoProductos error"+e);
        }
    }

    public static List<ListadoProductos> todosListadoProductos(){
        ResultSet rs ;
        List<ListadoProductos> productos = new ArrayList<>();
        try{
            rs = ps.executeQuery();
            while (rs.next()){
                ListadoProductos lp = new ListadoProductos();
                lp.setProductID(rs.getString(1));
                lp.setName(rs.getString(2));
                lp.setColor(rs.getString(3));
                lp.setStandardCost(rs.getString(4));
                lp.setQuantity(rs.getString(5));
                lp.setUnitPrice(rs.getString(6));
                lp.setUnitPriceDiscount(rs.getString(7));
                lp.setDescription(rs.getString(8));
                productos.add(lp);
            }
        }catch (SQLException e ){
            System.out.println("Error in result set todosListadoProductos error"+e);
        }
        return productos;
    }



    public static List<ListadoProductos> porIDListadoProductos(int productID){
        ResultSet rs;
        List<ListadoProductos> productos = new ArrayList<>();
        if(productID==-1){
            return productos;
        }
        try{
            ps2.setInt(1,productID);
            rs = ps2.executeQuery();
            while (rs.next()){
                ListadoProductos lp = new ListadoProductos();
                lp.setProductID(rs.getString(1));
                lp.setName(rs.getString(2));
                lp.setColor(rs.getString(3));
                lp.setStandardCost(rs.getString(4));
                lp.setQuantity(rs.getString(5));
                lp.setUnitPrice(rs.getString(6));
                lp.setUnitPriceDiscount(rs.getString(7));
                lp.setDescription(rs.getString(8));
                productos.add(lp);
            }
        }catch (SQLException e ){
            System.out.println("Error in result set porIDListadoProductos error"+e);
        }
        return productos;
    }

}
