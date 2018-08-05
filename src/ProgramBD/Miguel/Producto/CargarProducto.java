package ProgramBD.Miguel.Producto;

import ProgramBD.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargarProducto {

    private static PreparedStatement ps;
    private static ResultSet rs= null;
    private static Connection conn= DatabaseConnection.getInstance().getConnection();
    static{
        String sqlQuery = "SELECT * FROM Production.Product order by ProductID desc ";
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
    public static List<Producto>  ProductosMNVendidos(int opcion){
        List<ProductoVendidos> productosVendidos = new ArrayList<ProductoVendidos>();
        List<Producto> productos;
        String sql="select * from ProductoVendidoTabla(?);";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1,opcion);
            rs=ps.executeQuery();
            while(rs.next()){
                ProductoVendidos pv= new ProductoVendidos();
                pv.setId(rs.getInt(1));
                pv.setCantidad(rs.getInt(2));
                productosVendidos.add(pv);
            }
        }catch (SQLException e){
            System.out.println("ERROR in sql statement ProductosMNVendidos error: "+e);
        }
        productos=buscarProductos(productosVendidos);
        return productos;
    }
    public static List<Producto> buscarProductos(List<ProductoVendidos> productoVendidos){
        int cont=0;
        List<Producto> productos = new ArrayList<>();
        while(cont<productoVendidos.size()) {
            String sql = "select * from Production.Product where ProductID=?";
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1,productoVendidos.get(cont).getId());
                rs=ps.executeQuery();
                while(rs.next()){
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
                    producto.setCantidad(productoVendidos.get(cont).getCantidad());
                    productos.add(producto);
                }
            } catch (SQLException e) {
                System.out.println("ERROR in sql statement buscarProductos error: " + e);
            }
            cont++;
        }
        return productos;
    }
    public static class ProductoVendidos{
        private int id;
        private int cantidad;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getCantidad() {
            return cantidad;
        }
        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }

}
