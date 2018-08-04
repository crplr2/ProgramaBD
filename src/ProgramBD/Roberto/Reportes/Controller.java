package ProgramBD.Roberto.Reportes;


import ProgramBD.Roberto.Reportes.ClientesMasCompras.CargarMasCompras;
import ProgramBD.Roberto.Reportes.ClientesMasCompras.ClientesMasCompras;
import ProgramBD.Roberto.Reportes.ProductosMasDescuento.CargarMasDescuento;
import ProgramBD.Roberto.Reportes.ProductosMasDescuento.ProductosMasDescuento;
import ProgramBD.Roberto.Reportes.ProductosStockMasBajo.CargarStockMasBajo;
import ProgramBD.Roberto.Reportes.ProductosStockMasBajo.ProductosStockMasBajo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML private TableView<ProductosMasDescuento> tablaProductosMasDescuento;
    @FXML private TableColumn colProductID;
    @FXML private TableColumn colName;
    @FXML private TableColumn colStandardCost;
    @FXML private TableColumn colListPrice;
    @FXML private TableColumn colSpecialOfferID;
    @FXML private TableColumn colDescription;
    @FXML private TableColumn colDiscountPct;
    @FXML private TableColumn colType;
    @FXML private TableColumn colMinQty;
    @FXML private TableColumn colMaxQty;


    @FXML private TableView<ClientesMasCompras> tablaClientesMasCompras;
    @FXML private TableColumn colVendorID;
    @FXML private TableColumn colAccountNumber;
    @FXML private TableColumn colName2;
    @FXML private TableColumn colCantidadCompras;
    @FXML private TableColumn colTotalCompras;
    @FXML private TableColumn colCreditRating;
    @FXML private TableColumn colPreferredVendorStatus;


    @FXML private TableView<ProductosStockMasBajo> tablaStockMasBajo;
    @FXML private TableColumn colProductID2;
    @FXML private TableColumn colProductNumber;
    @FXML private TableColumn colName3;
    @FXML private TableColumn colSafetyStockLevel;
    @FXML private TableColumn colReorderPoint;
    @FXML private TableColumn colDaysToManufacture;
    @FXML private TableColumn colStandardCost2;
    @FXML private TableColumn colListPrice2;


    @FXML private Button button1;



    public void initialize() {
        cargarTablaMasCompras();
        cargarTablaMasDescuento();
        cargarTablaStockBajo();
    }

    public void cargarTablaMasCompras(){
        ObservableList<ClientesMasCompras> listaProductos = FXCollections.observableArrayList(CargarMasCompras.todosClientesMasCompras());
        colVendorID.setCellValueFactory(new PropertyValueFactory<>("VendorID"));
        colAccountNumber.setCellValueFactory(new PropertyValueFactory<>("AccountNumber"));
        colName2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colCantidadCompras.setCellValueFactory(new PropertyValueFactory<>("CantidadCompras"));
        colTotalCompras.setCellValueFactory(new PropertyValueFactory<>("TotalCompras"));
        colCreditRating.setCellValueFactory(new PropertyValueFactory<>("CreditRating"));
        colPreferredVendorStatus.setCellValueFactory(new PropertyValueFactory<>("PreferredVendorStatus"));
        tablaClientesMasCompras.setItems(listaProductos);
    }

    public void cargarTablaMasDescuento(){
        ObservableList<ProductosMasDescuento> listaProductos = FXCollections.observableArrayList(CargarMasDescuento.todosProductosMasDescuento());
        colProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colStandardCost.setCellValueFactory(new PropertyValueFactory<>("StandardCost"));
        colListPrice.setCellValueFactory(new PropertyValueFactory<>("ListPrice"));
        colSpecialOfferID.setCellValueFactory(new PropertyValueFactory<>("SpecialOfferID"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colDiscountPct.setCellValueFactory(new PropertyValueFactory<>("DiscountPct"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colMinQty.setCellValueFactory(new PropertyValueFactory<>("MinQty"));
        colMaxQty.setCellValueFactory(new PropertyValueFactory<>("MaxQty"));
        tablaProductosMasDescuento.setItems(listaProductos);

    }

    public void cargarTablaStockBajo(){
        ObservableList<ProductosStockMasBajo> listaProductos = FXCollections.observableArrayList(CargarStockMasBajo.todosStockMasBajo());
        colProductID2.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        colProductNumber.setCellValueFactory(new PropertyValueFactory<>("ProductNumber"));
        colName3.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colSafetyStockLevel.setCellValueFactory(new PropertyValueFactory<>("SafetyStockLevel"));
        colReorderPoint.setCellValueFactory(new PropertyValueFactory<>("ReorderPoint"));
        colDaysToManufacture.setCellValueFactory(new PropertyValueFactory<>("DaysToManufacture"));
        colStandardCost2.setCellValueFactory(new PropertyValueFactory<>("StandardCost"));
        colListPrice2.setCellValueFactory(new PropertyValueFactory<>("ListPrice"));
        tablaStockMasBajo.setItems(listaProductos);
    }


    @FXML
    public void regresarMenu( ){
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
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
}
