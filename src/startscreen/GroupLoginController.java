package startscreen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sara
 */
public class GroupLoginController implements Initializable {
    public ScreensController controller;
    @FXML
    private TextField groupUsernameField;
    @FXML
    private PasswordField groupPasswordField;
    @FXML
    private Button groupSubmitBtn;
    @FXML
    private Hyperlink createGroupAccount;
    @FXML
    private Hyperlink forgotGroup;
    private String groupUsername;
    private String groupPassword;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

//    @Override
//    public void setScreenParent(ScreensController screenParent) {
//        controller = screenParent;
//    }
    @FXML
    public void buttonClick(ActionEvent event) throws IOException {
      boolean wrong = false;
      if (event.getSource() == groupSubmitBtn) {
          if (groupUsernameField.getText() != null && !groupUsernameField.getText().isEmpty() &&
                  groupPasswordField.getText() != null && !groupPasswordField.getText().isEmpty()) {
            groupUsername = groupUsernameField.getText();
            groupPassword = groupPasswordField.getText();
            if (groupLogin(groupUsername,groupPassword)) {
                Stage stage = (Stage) groupSubmitBtn.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource(Main.userLoginFile));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                wrong = true;
            }
         } else {
            wrong = true; 
         }
         if (wrong) {
            Alert loginError = new Alert(Alert.AlertType.ERROR);
            loginError.setTitle("Login Error");
            loginError.setHeaderText(null);
            loginError.setContentText("Username and/or password entered is not correct. Please try again.");
            loginError.showAndWait();
         }
     }
    }
    
    @FXML
    public void hyperLinkClick(ActionEvent e) throws IOException {
      if (e.getSource() == createGroupAccount) {
            Stage stage = (Stage) createGroupAccount.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(Main.groupCreateAccFile));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            //controller.loadScreen(Main.groupCreateAccFile);
            //Parent root 
      }
    }
    private boolean groupLogin(String username, String password) throws FileNotFoundException {
        String temp = Paths.get("").toAbsolutePath().toString() + "\\" + username;
        if (Files.exists(Paths.get(temp))) {
            File file = new File(temp + "\\GroupPassword.txt");
            Scanner scan = new Scanner(file);
            if (scan.nextLine().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public String[] getGroupInfo() {
        String[] output= {groupUsername, groupPassword};
        return output;
    }
    public void forgotBtnClick(ActionEvent e) throws IOException {
        if (e.getSource() == forgotGroup) {
            Stage stage = (Stage) forgotGroup.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(Main.forgotPassFile));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}