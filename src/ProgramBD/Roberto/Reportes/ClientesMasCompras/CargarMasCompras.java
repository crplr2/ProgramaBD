package ProgramBD.Roberto.Reportes.ClientesMasCompras;

import ProgramBD.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargarMasCompras {
    private static PreparedStatement ps;

    static{
        String sqlQuery = "EXEC ReportTwo";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try{
            ps= conn.prepareStatement(sqlQuery);
        }catch (SQLException e){
            System.out.println("Error in prepared statement CargarMasCompras error"+e);
        }
    }


    public static List<ClientesMasCompras> todosClientesMasCompras(){
        ResultSet rs ;
        List<ClientesMasCompras> clientes = new ArrayList<>();
        try{
            rs = ps.executeQuery();
            while (rs.next()){
                ClientesMasCompras cc = new ClientesMasCompras();
                cc.setVendorID(rs.getString(1));
                cc.setAccountNumber(rs.getString(2));
                cc.setName(rs.getString(3));
                cc.setCantidadCompras(rs.getString(4));
                cc.setTotalCompras(rs.getString(5));
                cc.setCreditRating(rs.getString(6));
                cc.setPreferredVendorStatus(rs.getString(7));
                clientes.add(cc);
            }
        }catch (SQLException e ){
            System.out.println("Error in result set todosClientesMasCompras error"+e);
        }

        return clientes;
    }
}
