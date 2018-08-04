package ProgramBD.Roberto.Reportes.ProductosMasDescuento;

import ProgramBD.DatabaseConnection;
import ProgramBD.Roberto.Reportes.ClientesMasCompras.ClientesMasCompras;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargarMasDescuento {
    private static PreparedStatement ps;

    static{
        String sqlQuery = "EXEC ReportOne";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try{
            ps= conn.prepareStatement(sqlQuery);
        }catch (SQLException e){
            System.out.println("Error in prepared statement CargarMasDescuento error"+e);
        }
    }


    public static List<ProductosMasDescuento> todosProductosMasDescuento(){
        ResultSet rs ;
        List<ProductosMasDescuento> productos = new ArrayList<>();
        try{
            rs = ps.executeQuery();
            while (rs.next()){
                ProductosMasDescuento pm = new ProductosMasDescuento();
                pm.setProductID(rs.getString(1));
                pm.setName(rs.getString(2));
                pm.setStandardCost(rs.getString(3));
                pm.setListPrice(rs.getString(4));
                pm.setSpecialOfferID(rs.getString(5));
                pm.setDescription(rs.getString(6));
                pm.setDiscountPct(rs.getString(7));
                pm.setType(rs.getString(8));
                pm.setMinQty(rs.getString(9));
                pm.setMaxQty(rs.getString(10));
                productos.add(pm);
            }
        }catch (SQLException e ){
            System.out.println("Error in result set todosProductosMasDescuento error"+e);
        }

        return productos;
    }

}
