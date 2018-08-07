package ProgramBD.Miguel.Producto.Detalles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DetallesController implements Initializable {
    @FXML private TableView table;
    @FXML private TableColumn colID;
    @FXML private TableColumn colName;
    @FXML private TableColumn colColor;
    @FXML private TableColumn colCantidad;
    @FXML private TableColumn colLocation;

    @FXML private static int id;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarTabla();
    }

    private void cargarTabla(){
        ObservableList<ProductoDetalles> listaProductos = FXCollections.observableArrayList(CargarDetalles.cargarDetalles(id));
        colID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        table.setItems(listaProductos);
    }

    @FXML
    private void btnBack(ActionEvent e){
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/ProgramBD/Miguel//UI.fxml"));
            Scene scene = new Scene(fxml);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }catch (IOException w){
            System.out.println("UI menu not found "+w);
        }
    }

    public static void setID(int mID){
        id=mID;
    }
}
