/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startscreen;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sara
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException { 
            AnchorPane root;
            root = FXMLLoader.load(getClass().getResource("GroupLoginFXML.fxml"));
            Scene scene =  new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Planner App");
            primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
    
}
