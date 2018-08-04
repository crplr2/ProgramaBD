package ProgramBD.Roberto.Reportes.ProductosStockMasBajo;

import ProgramBD.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargarStockMasBajo {
    private static PreparedStatement ps;

    static{
        String sqlQuery = "EXEC ReportThree";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try{
            ps= conn.prepareStatement(sqlQuery);
        }catch (SQLException e){
            System.out.println("Error in prepared statement CargarStockMasBajo error"+e);
        }
    }


    public static List<ProductosStockMasBajo> todosStockMasBajo(){
        ResultSet rs ;
        List<ProductosStockMasBajo> productos = new ArrayList<>();
        try{
            rs = ps.executeQuery();
            while (rs.next()){
                ProductosStockMasBajo pb = new ProductosStockMasBajo();
                pb.setProductID(rs.getString(1));
                pb.setProductNumber(rs.getString(2));
                pb.setName(rs.getString(3));
                pb.setSafetyStockLevel(rs.getString(4));
                pb.setReorderPoint(rs.getString(5));
                pb.setDaysToManufacture(rs.getString(6));
                pb.setStandardCost(rs.getString(7));
                pb.setListPrice(rs.getString(8));
                productos.add(pb);
            }
        }catch (SQLException e ){
            System.out.println("Error in result set todosStockMasBajo error"+e);
        }

        return productos;
    }
}
