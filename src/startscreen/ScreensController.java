/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startscreen;

import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Angie from Java Youtube channel; edited by Sara
 */
public class ScreensController extends StackPane {
//    private HashMap<String, Node> screens = new HashMap<>();
//    
//    public ScreensController() {
//        super();
//    }
//    
//    public void addScreen(String name, Node screen) {
//        screens.put(name, screen);
//    }
//    
//    public Node getScreen(String name) {
//        return screens.get(name);
//    }
//    
//    public boolean loadScreen(String name, String resource) {
//        try{
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
//            Parent loadScreen = (Parent) loader.load();
//            ControlledScreen controller = ((ControlledScreen) loader.getController());
//            controller.setScreenParent(this);
//            addScreen(name, loadScreen);
//            return true;
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
    public void loadScreen(String resource) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(resource));
        setScreen(root);
    }
//    public boolean setScreen(final String name) {
//        if (screens.get(name) != null) {
//            if (!getChildren().isEmpty()) {
//                getChildren().remove(0);
//                getChildren().add(0,screens.get(name));
//                
//            } else {
//                getChildren().add(screens.get(name));
//            }
//            return true; 
//        }
//        return false;
//    }
    public void setScreen(Node file) {
        getChildren().add(file);
        
    }
//    
//    public boolean unloadScreen(String name) {
//        return screens.remove(name) != null;
//    } 
//    
    
}
