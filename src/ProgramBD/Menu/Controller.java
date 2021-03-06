package ProgramBD.Menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


import java.io.IOException;


public class Controller {


    @FXML
    public void buttonProductHistory(ActionEvent event)throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/ProgramBD/Roberto/ProductoHistorico/UI.fxml"));
        Scene scene = new Scene(fxml);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void buttonReports(ActionEvent event)throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("/ProgramBD/Roberto/Reportes/UI.fxml"));
        Scene scene = new Scene(fxml);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void buttonAnalisis(ActionEvent event)throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("/ProgramBD/Miguel/UI.fxml"));
        Scene scene = new Scene(fxml);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void buttonListadoProductos(ActionEvent event)throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("/ProgramBD/Hector/UI.fxml"));
        Scene scene = new Scene(fxml);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
