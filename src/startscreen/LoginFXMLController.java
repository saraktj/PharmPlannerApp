/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startscreen;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javafx.scene.control.Button;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sara
 */
public class LoginFXMLController implements Initializable, ControlledScreen {
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
    @FXML
    private TextField groupSecurityQuestion;
    @FXML 
    private TextField groupSecurityAnswer;
    @FXML
    private Button fileBtn;
    @FXML
    private TextField logoLoc;
    @FXML
    private ImageView imageLogo;
    private File destFile;
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
                /*destFile = new File("C:\\Users\\Sara\\Documents\\Summer\\PharmacyApp\\src\\startscreen\\logo.jpg");
                if (destFile != null) {
                    File file = new File("C:\\Users\\Sara\\Pictures\\abacus.jpg");
                    Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    InputStream in = new FileInputStream(destFile);
                    Image logo = new Image(in);
                    if (logo != null) {
                    imageLogo.setImage(logo);
                    }*/
                }
            } else {
                wrong = true;
            }
         } else {
            wrong = true; 
         }
         if (wrong) {
            Alert loginError = new Alert(AlertType.ERROR);
            loginError.setTitle("Login Error");
            loginError.setHeaderText(null);
            loginError.setContentText("Username and/or password entered is not correct. Please try again.");
            loginError.showAndWait();
         } else {
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
        stage = (Stage) createGroupAccount.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GroupCreateNewAccountFXML.fxml"));
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
    /*@FXML
    public void qPopUp(ActionEvent e) {
        Tooltip alert1 = new Tooltip("Set security question in case username/password is forgotten.");
        Tooltip alert2 = new Tooltip("WARNING! Make sure to remember this answer. If forgotten, there is no way to retrieve your password.");
        groupSecurityQuestion.setTooltip(alert1);
        groupSecurityAnswer.setTooltip(alert2);
        System.out.println(alert1.isActivated());
    } */
    public void fileFind(ActionEvent e) throws IOException {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog((Stage) fileBtn.getScene().getWindow());
        if (file != null) {
            logoLoc.setText(file.getPath());
            String fileName = file.getName();
            String filePath = new String("C:\\Users\\Sara\\Documents\\Summer\\PharmacyApp\\src\\startscreen" + fileName);
            destFile = new File(filePath);
            Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
    public void createBtnClick(ActionEvent e) {
        
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
