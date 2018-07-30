package ProgramBD.Roberto.ProductoHistorico;



import ProgramBD.Roberto.ProductoHistorico.Producto.CargarProducto;
import ProgramBD.Roberto.ProductoHistorico.Producto.EliminarProducto;
import ProgramBD.Roberto.ProductoHistorico.Producto.Producto;
import ProgramBD.Roberto.ProductoHistorico.ProductoHistorico.CargarHistorico;
import ProgramBD.Roberto.ProductoHistorico.ProductoHistorico.ProductoHistorico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

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


    @FXML private TableView<ProductoHistorico> tablaHistorico;
    @FXML private TableColumn colIDProducto;
    @FXML private TableColumn colCampoModificado;
    @FXML private TableColumn colValorAnterior;
    @FXML private TableColumn colValorNuevo;
    @FXML private TableColumn colFechaModificacion;




    public void initialize() {
        cargarTablaProductos();
        cargarTablaHistorico();
    }


    public void cargarTablaProductos(){
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
        tablaProductos.setItems(listaProductos);
    }


    public void cargarTablaHistorico(){
        ObservableList<ProductoHistorico> listaProductos = FXCollections.observableArrayList(CargarHistorico.historicoProducto());
        colIDProducto.setCellValueFactory(new PropertyValueFactory<>("IDProducto"));
        colCampoModificado.setCellValueFactory(new PropertyValueFactory<>("campoModificado"));
        colValorAnterior.setCellValueFactory(new PropertyValueFactory<>("valorAnterior"));
        colValorNuevo.setCellValueFactory(new PropertyValueFactory<>("valorNuevo"));
        colFechaModificacion.setCellValueFactory(new PropertyValueFactory<>("fechaModificacion"));
        tablaHistorico.setItems(listaProductos);
    }


    @FXML
    public void actionBotonModificar(ActionEvent event)throws IOException {
        Producto producto = tablaProductos.getSelectionModel().getSelectedItem();
        if(producto!=null){
            ProgramBD.Roberto.ProductoHistorico.ProductoModificar.Controller.setProducto(producto);
            Parent fxml = FXMLLoader.load(getClass().getResource("/ProgramBD/Roberto/ProductoHistorico/ProductoModificar/UI.fxml"));
            Scene scene = new Scene(fxml);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void actionBotonEliminar(){
        Producto producto = tablaProductos.getSelectionModel().getSelectedItem();
        if(EliminarProducto.eliminarP(producto)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Producto eliminado");
            alert.show();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error al eliminar el producto");
            alert.show();
        }
        cargarTablaProductos();
        cargarTablaHistorico();
    }


}
