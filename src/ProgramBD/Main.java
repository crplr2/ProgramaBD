package ProgramBD;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Menu/UI.fxml"));
        primaryStage.setScene(new Scene(root, 550, 400));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        if(!DatabaseConnection.getInstance().openConnection()) {
            Platform.exit();
        }
    }


    @Override
    public void stop() throws Exception {
        super.stop();
        DatabaseConnection.getInstance().closeConnection();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
