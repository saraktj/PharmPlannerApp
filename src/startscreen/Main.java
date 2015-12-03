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
import javafx.scene.Group;
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
    
    public ScreensController controller = new ScreensController();
    //public static String groupLogin = "groupLogin";
    public static String groupLoginFile = "/startscreen/GroupLoginFXML.fxml";
    //public static String groupCreateAcc = "groupCreateAcc";
    public static String groupCreateAccFile = "GroupCreateNewAccountFXML.fxml";
    //public static String userLogin = "userLogin";
    public static String userLoginFile = "/startscreen/UserLoginFXML.fxml";
    //public static String createAcc = "createAcc";
    public static String createAccFile = "/startscreen/UserCreateNewAccountFXML.fxml";
    //public static String forgotPass = "forgotPass";
    public static String forgotPassFile = "/startscreen/ForgotPasswordFXML.fxml";
    //public static String createAdmin = "createAdmin";
    public static String createAdminFile = "/startscreen/CreateAdminFXML.fxml";
    @Override
    public void start(Stage primaryStage) throws IOException { 
        //ScreensController controller = new ScreensController();
        /*controller.loadScreen(groupLogin, groupLoginFile);
        controller.loadScreen(groupCreateAcc, groupCreateAccFile);
        controller.loadScreen(userLogin,userLoginFile);
        controller.loadScreen(createAcc, createAccFile);
        controller.loadScreen(forgotPass,forgotPassFile);
        controller.loadScreen(createAdmin,createAdminFile);
        controller.setScreen(groupLogin); */
        controller.loadScreen(groupLoginFile);
            Group root = new Group();
            root.getChildren().addAll(controller);
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
