package ProgramBD.Miguel;

import ProgramBD.Miguel.Producto.CargarDetalles;
import ProgramBD.Miguel.Producto.CargarProducto;
import ProgramBD.Miguel.Producto.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn colProductID;
    @FXML private TableColumn colName;
    @FXML private TableColumn colProductNumber;
    @FXML private TableColumn colMakeFlag;
    @FXML private TableColumn colFinishedGoodsFlag;
    @FXML private TableColumn colColor;
    @FXML private TableColumn colSafetyStockLevel;
    @FXML private TableColumn colReorderPoint;
    @FXML private TableColumn colStandardCost;
    @FXML private TableColumn colListPrice;
    @FXML private TableColumn colSize;
    @FXML private TableColumn colSizeUnitMeasureCode;
    @FXML private TableColumn colWeightUnitMeasureCode;
    @FXML private TableColumn colWeight;
    @FXML private TableColumn colDaysToManufacture;
    @FXML private TableColumn colProductLine;
    @FXML private TableColumn colClass;
    @FXML private TableColumn colStyle;
    @FXML private TableColumn colProductSubcategoryID;
    @FXML private TableColumn colProductModelID;
    @FXML private TableColumn colSellStartDate;
    @FXML private TableColumn colSellEndDate;
    @FXML private TableColumn colDiscontinuedDate;
    @FXML private TableColumn colrowguid;
    @FXML private TableColumn colModifiedDate;
    @FXML private TableColumn colCantidad;

    @FXML private Button button1;
    @FXML private Button btnDetalles;

    private static int tag =0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tag=0;
        cargarTablaProductos();
        colCantidad.setVisible(false);
        btnDetalles.setDisable(true);
        final ObservableList<Producto> table = tablaProductos.getSelectionModel().getSelectedItems();
        table.addListener(tableSelector);
    }

    private final ListChangeListener<Producto> tableSelector= new ListChangeListener<Producto>() {
        @Override
        public void onChanged(Change<? extends Producto> c) {
            btnDetalles.setDisable(false);
        }
    };

    private Producto getSelected(){
        if(tablaProductos!=null){
            List<Producto> lista = tablaProductos.getSelectionModel().getSelectedItems();
            if(lista.size()==1){
                final Producto productoSelected = lista.get(0);
                return productoSelected;
            }
        }
        return null;
    }




    private void cargarTablaProductos(){
        ObservableList<Producto> listaProductos = FXCollections.observableArrayList(CargarProducto.todosProducto());
        colProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colProductNumber.setCellValueFactory(new PropertyValueFactory<>("ProductNumber"));
        colMakeFlag.setCellValueFactory(new PropertyValueFactory<>("MakeFlag"));
        colFinishedGoodsFlag.setCellValueFactory(new PropertyValueFactory<>("FinishedGoodsFlag"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("Color"));
        colSafetyStockLevel.setCellValueFactory(new PropertyValueFactory<>("SafetyStockLevel"));
        colReorderPoint.setCellValueFactory(new PropertyValueFactory<>("ReorderPoint"));
        colStandardCost.setCellValueFactory(new PropertyValueFactory<>("StandardCost"));
        colListPrice.setCellValueFactory(new PropertyValueFactory<>("ListPrice"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("Size"));
        colSizeUnitMeasureCode.setCellValueFactory(new PropertyValueFactory<>("SizeUnitMeasureCode"));
        colWeightUnitMeasureCode.setCellValueFactory(new PropertyValueFactory<>("WeightUnitMeasureCode"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("Weight"));
        colDaysToManufacture.setCellValueFactory(new PropertyValueFactory<>("DaysToManufacture"));
        colProductLine.setCellValueFactory(new PropertyValueFactory<>("ProductLine"));
        colClass.setCellValueFactory(new PropertyValueFactory<>("OClass"));
        colStyle.setCellValueFactory(new PropertyValueFactory<>("Style"));
        colProductSubcategoryID.setCellValueFactory(new PropertyValueFactory<>("ProductSubcategoryID"));
        colProductModelID.setCellValueFactory(new PropertyValueFactory<>("ProductModelID"));
        colSellStartDate.setCellValueFactory(new PropertyValueFactory<>("SellStartDate"));
        colSellEndDate.setCellValueFactory(new PropertyValueFactory<>("SellEndDate"));
        colDiscontinuedDate.setCellValueFactory(new PropertyValueFactory<>("DiscontinuedDate"));
        colrowguid.setCellValueFactory(new PropertyValueFactory<>("rowguid"));
        colModifiedDate.setCellValueFactory(new PropertyValueFactory<>("ModifiedDate"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        tablaProductos.setItems(listaProductos);
    }


    @FXML
    private void btnMasVendidos(){
        tag=1;
        ObservableList<Producto> listaProductos = FXCollections.observableArrayList(CargarProducto.ProductosMNVendidos(1));
        tablaProductos.setItems(listaProductos);
    }

    @FXML
    private void btnMenosVendidos(){
        tag=1;
        ObservableList<Producto> listaProductos = FXCollections.observableArrayList(CargarProducto.ProductosMNVendidos(0));
        tablaProductos.setItems(listaProductos);
    }

    @FXML
    public void regresarMenu( ){
        button1.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override public void handle(javafx.event.ActionEvent e) {
                try{
                    Parent fxml = FXMLLoader.load(getClass().getResource("/ProgramBD/Menu/UI.fxml"));
                    Scene scene = new Scene(fxml);
                    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }catch (IOException w){
                    System.out.println("UI menu not found "+w);
                }

            }
        });
        button1.fire();
    }

    @FXML
    public void btnDetalles() {
        Producto producto =getSelected();
        if(producto.getProductSubcategoryID()!=null) {
            String des = CargarDetalles.cargarDetalles(Integer.parseInt(producto.getProductSubcategoryID()));
            alert(des);
        }
        else{
            alert2();
        }
    }

    private void alert(String des){
        if(tag==1) {
            Producto producto = getSelected();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Detalles del Producto");
            alert.setHeaderText(null);
            alert.setContentText("NOMBRE DEL PRODUCTO:\n" + producto.getName() + "\n CATEGORIA DEL PRODUCTO: \n" + des +
                    "\n CANTIDAD VENDIDA: \n" + producto.getCantidad());

            alert.showAndWait();
        }
        else{
            Producto producto = getSelected();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Detalles del Producto");
            alert.setHeaderText(null);
            alert.setContentText("NOMBRE DEL PRODUCTO:\n" + producto.getName() + "\n CATEGORIA DEL PRODUCTO: \n" + des );

            alert.showAndWait();
        }
    }

    private void alert2(){
        if(tag==1) {
            Producto producto = getSelected();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Detalles del Producto");
            alert.setHeaderText(null);
            alert.setContentText("NOMBRE DEL PRODUCTO:\n" + producto.getName() + "\n CATEGORIA DEL PRODUCTO: \n" + "No contiene categoria" +
                    "\n CANTIDAD VENDIDA: \n" + producto.getCantidad());

            alert.showAndWait();
        }
        else{
            Producto producto = getSelected();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Detalles del Producto");
            alert.setHeaderText(null);
            alert.setContentText("NOMBRE DEL PRODUCTO:\n" + producto.getName() + "\n CATEGORIA DEL PRODUCTO: \n" + "No contiene categoria");
        }
    }
}



