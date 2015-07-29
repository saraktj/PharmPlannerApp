/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startscreen;

import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sara
 */
public class LoginFXMLController implements Initializable {
    @FXML
    private Button submitBtn;
    @FXML
    private Button groupSubmitBtn;
    @FXML
    private Hyperlink createAccount;
    @FXML
    private Hyperlink adminHover;
    @FXML
    private Hyperlink createGroupAccount;
    @FXML
    private TextField groupUsernameField ;
    @FXML
    private PasswordField groupPasswordField;
    private String groupUsername;
    private String groupPassword;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void buttonClick(ActionEvent event) throws IOException {
      Stage stage = new Stage();
      Parent root = null;
      boolean wrong = false;
      if (event.getSource() == groupSubmitBtn) {
          if (groupUsernameField.getText() != null && !groupUsernameField.getText().isEmpty() &&
                  groupPasswordField.getText() != null && !groupPasswordField.getText().isEmpty()) {
            groupUsername = groupUsernameField.getText();
            groupPassword = groupPasswordField.getText();
            if (groupLogin(groupUsername,groupPassword)) {
                stage = (Stage) groupSubmitBtn.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
            } else {
                wrong = true;
            }
         } else {
            wrong = true; 
         }
         if (wrong) {
            root = FXMLLoader.load(getClass().getResource("PopUp.fxml"));
         }
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
     }
 
    }
    
    @FXML
    public void hyperLinkClick(ActionEvent e) throws IOException {
      Stage stage;
      Parent root;
      if (e.getSource() == createAccount){
        stage = (Stage) createAccount.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("CreateNewAccountFXML.fxml"));
        Scene scene = new Scene(root); 
        stage.setScene(scene);
        stage.show();
      } else if (e.getSource() == createGroupAccount) {
        stage = (Stage) createAccount.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GroupCreateAccountFXML.fxml"));
        Scene scene = new Scene(root); 
        stage.setScene(scene);
        stage.show();
      }
    }
    private boolean groupLogin(String username, String password) {
               return true;
    }
    public String[] getGroupInfo() {
        String[] output= {groupUsername, groupPassword};
        return output;
    }
}
