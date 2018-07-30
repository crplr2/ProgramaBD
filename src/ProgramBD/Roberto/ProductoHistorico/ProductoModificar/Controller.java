package ProgramBD.Roberto.ProductoHistorico.ProductoModificar;

import ProgramBD.Roberto.ProductoHistorico.Producto.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML private TextField ProductID;
    @FXML private TextField Name;
    @FXML private TextField ProductNumber;
    @FXML private TextField MakeFlag;
    @FXML private TextField FinishedGoodsFlag;
    @FXML private TextField Color;
    @FXML private TextField SafetyStockLevel;
    @FXML private TextField ReorderPoint;
    @FXML private TextField StandardCost;
    @FXML private TextField ListPrice;
    @FXML private TextField Size;
    @FXML private TextField SizeUnitMeasureCode;
    @FXML private TextField WeightUnitMeasureCode;
    @FXML private TextField Weight;
    @FXML private TextField DaysToManufacture;
    @FXML private TextField ProductLine;
    @FXML private TextField Class;
    @FXML private TextField Style;
    @FXML private TextField ProductSubcategoryID;
    @FXML private TextField ProductModelID;
    @FXML private TextField SellStartDate;
    @FXML private TextField SellEndDate;
    @FXML private TextField DiscontinuedDate;
    @FXML private TextField rowguid;
    @FXML private TextField ModifiedDate;

    @FXML private TextField test;

    private static Producto producto;


    public void initialize() {
        cargarProducto();
    }


    public void cargarProducto(){
        ProductID.setText(producto.getProductID());
        Name.setText(producto.getName());
        ProductNumber.setText(producto.getProductNumber());
        MakeFlag.setText(producto.getMakeFlag());
        FinishedGoodsFlag.setText(producto.getFinishedGoodsFlag());
        Color.setText(producto.getColor());
        SafetyStockLevel.setText(producto.getSafetyStockLevel());
        ReorderPoint.setText(producto.getReorderPoint());
        StandardCost.setText(producto.getStandardCost());
        ListPrice.setText(producto.getListPrice());
        Size.setText(producto.getSize());
        SizeUnitMeasureCode.setText(producto.getSizeUnitMeasureCode());
        WeightUnitMeasureCode.setText(producto.getWeightUnitMeasureCode());
        Weight.setText(producto.getWeight());
        DaysToManufacture.setText(producto.getDaysToManufacture());
        ProductLine.setText(producto.getProductLine());
        Class.setText(producto.getOClass());
        Style.setText(producto.getStyle());
        ProductSubcategoryID.setText(producto.getProductSubcategoryID());
        ProductModelID.setText(producto.getProductModelID());
        SellStartDate.setText(producto.getSellStartDate());
        SellEndDate.setText(producto.getSellEndDate());
        DiscontinuedDate.setText(producto.getDiscontinuedDate());
        rowguid.setText(producto.getRowguid());
        ModifiedDate.setText(producto.getModifiedDate());
    }


    @FXML
    public void actionBotonModificar(ActionEvent event){
        producto.setName(Name.getText());
        producto.setProductNumber(ProductNumber.getText());
        producto.setMakeFlag(MakeFlag.getText());
        producto.setFinishedGoodsFlag(FinishedGoodsFlag.getText());
        producto.setColor(Color.getText());
        producto.setSafetyStockLevel(SafetyStockLevel.getText());
        producto.setReorderPoint(ReorderPoint.getText());
        producto.setStandardCost(StandardCost.getText());
        producto.setListPrice(ListPrice.getText());
        producto.setSize(Size.getText());
        producto.setSizeUnitMeasureCode(SizeUnitMeasureCode.getText());
        producto.setWeight(Weight.getText());
        producto.setDaysToManufacture(DaysToManufacture.getText());
        producto.setProductSubcategoryID(ProductSubcategoryID.getText());
        producto.setProductSubcategoryID(ProductSubcategoryID.getText());
        producto.setProductModelID(ProductModelID.getText());
        producto.setSellStartDate(SellStartDate.getText());
        producto.setSellEndDate(SellEndDate.getText());
        producto.setDiscontinuedDate(DiscontinuedDate.getText());
        producto.setModifiedDate(ModifiedDate.getText());
        if(ModificarProducto.modificarP(producto)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Producto modificado");
            alert.show();
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error al modificar el producto");
            alert.show();
        }
    }

    @FXML
    public void actionBotonRegresar(ActionEvent event)throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/ProgramBD/Roberto/ProductoHistorico/UI.fxml"));
        Scene scene = new Scene(fxml);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public static void setProducto(Producto productoNuevo){
        producto = productoNuevo;
    }
}
