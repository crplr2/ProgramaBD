package ProgramBD.Hector;

import ProgramBD.Hector.ListadoProductos.BusquedaNombreProductos;
import ProgramBD.Hector.ListadoProductos.CargarListadoProductos;
import ProgramBD.Hector.ListadoProductos.ListadoProductos;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private TableView<ListadoProductos> tablaListadoProducto;
    @FXML private TableColumn colProductID;
    @FXML private TableColumn colName;
    @FXML private TableColumn colColor;
    @FXML private TableColumn colStandardCost;
    @FXML private TableColumn colQuantity;
    @FXML private TableColumn colUnitPrice;
    @FXML private TableColumn colUnitPriceDiscount;
    @FXML private TableColumn colDescription;

    @FXML private TextField textoBusquedaNombre;
    @FXML private Button button1;


    public void initialize(){
        cargarTablaListadoProducto();
    }


    @FXML
    public void buscarProducto(){
        String texto = textoBusquedaNombre.getText();
        if(texto.trim().isEmpty()){
            cargarTablaListadoProducto();
        }else {
            int resultado = BusquedaNombreProductos.buscarNombre(texto);
            cargarTablaListadoProductoID(resultado);
        }

    }


    @FXML
    public void regresarMenu(){
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



    public void cargarTablaListadoProducto(){
        ObservableList<ListadoProductos> listaProductos = FXCollections.observableArrayList(CargarListadoProductos.todosListadoProductos());
        colProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("Color"));
        colStandardCost.setCellValueFactory(new PropertyValueFactory<>("StandardCost"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        colUnitPriceDiscount.setCellValueFactory(new PropertyValueFactory<>("UnitPriceDiscount"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        tablaListadoProducto.setItems(listaProductos);
    }



    public void cargarTablaListadoProductoID(int productID){
        ObservableList<ListadoProductos> listaProductos = FXCollections.observableArrayList(CargarListadoProductos.porIDListadoProductos(productID));
        colProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("Color"));
        colStandardCost.setCellValueFactory(new PropertyValueFactory<>("StandardCost"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        colUnitPriceDiscount.setCellValueFactory(new PropertyValueFactory<>("UnitPriceDiscount"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        tablaListadoProducto.setItems(listaProductos);
    }



}
