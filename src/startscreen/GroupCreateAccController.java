package startscreen;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sara
 */
public class GroupCreateAccController implements Initializable {
    public ScreensController controller;
    @FXML
    private TextField companyIDField;
    @FXML
    private TextField groupUsernameField;
    @FXML
    private PasswordField groupPasswordField;
    @FXML
    private Button groupNext;
    @FXML
    private TextField groupSecurityQuestion;
    @FXML
    private TextField groupSecurityAnswer;
    @FXML
    private TextField logoLoc;
    @FXML
    private Button fileBtn;
    private String groupUsername;
    private String groupPassword;
    private File destFile;
    private String errorStr;
    private String groupDir;
    
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
    public void buttonClick(ActionEvent event) throws IOException{
      //controller.loadScreen(Main.createAdminFile);
        if (checkInfo()) {
            Alert emptyInfo = new Alert(Alert.AlertType.ERROR);
            emptyInfo.setTitle("Error");
            emptyInfo.setHeaderText("Please make sure to correctly fill out the following: \n");
            emptyInfo.setContentText(errorStr);
            emptyInfo.showAndWait();
        } else {
            groupDir = Paths.get("").toAbsolutePath().toString() + "\\" + groupUsernameField.getText();
            if (!Files.exists(Paths.get(groupDir))) {
                saveData();
                Stage stage = (Stage) groupNext.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource(Main.createAdminFile));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                Alert emptyInfo = new Alert(Alert.AlertType.ERROR);
                emptyInfo.setTitle("Error: Company exists");
                emptyInfo.setHeaderText(null);
                emptyInfo.setContentText("Company by that name already exists in the system. Please enter a new company name.");
                emptyInfo.showAndWait();
            }
            //Files.delete(file.toPath());
        }
      
    }
    public void fileFind(ActionEvent e) throws IOException {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog((Stage) fileBtn.getScene().getWindow());
        if (file != null) {
            logoLoc.setText(file.getPath());
            String fileName = file.getName();
            String filePath = Paths.get("").toAbsolutePath().toString() + fileName;
            destFile = new File(filePath);
            Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
    private boolean checkInfo() {
        String temp = new String();
        boolean value = false;
        if (companyIDField.getText() == null || companyIDField.getText().isEmpty()) {
            temp += "Company Name \n";
            value = true;
        }
        if (groupUsernameField.getText() == null || groupUsernameField.getText().isEmpty()) {
            temp += "Username \n";
            value = true;
        }
        if (groupPasswordField.getText() == null || groupPasswordField.getText().isEmpty()) {
            temp += "Password \n";
            value = true;
        }
        if (groupSecurityQuestion.getText() == null || groupSecurityQuestion.getText().isEmpty()) {
            temp += "Security Question \n";
            value = true;
        }
        if (groupSecurityAnswer.getText() == null || groupSecurityAnswer.getText().isEmpty()) {
            temp += "Security Answer \n";
            value = true;
        }
        if (value) {
            errorStr = temp;
            return true;
        }
        return false;
    }
    private void saveData() throws IOException {
        Files.createDirectory(Paths.get(groupDir));
        File companyName = new File(groupDir + "\\CompanyName.txt");
        PrintWriter companyWriter = new PrintWriter(companyName);
        companyWriter.print(companyIDField.getText());
        companyWriter.close();
        File password = new File(groupDir + "\\GroupPassword.txt");
        PrintWriter passwordWriter = new PrintWriter(password);
        passwordWriter.print(groupPasswordField.getText());
        passwordWriter.close();
        File securityQ = new File(groupDir + "\\GroupSecurityQuestion.txt");
        PrintWriter securityQWriter = new PrintWriter(securityQ);
        securityQWriter.print(groupSecurityQuestion.getText());
        securityQWriter.close();
        File securityA = new File(groupDir + "\\GroupSecurityAnswer.txt");
        PrintWriter securityAWriter = new PrintWriter(securityA);
        securityAWriter.print(groupSecurityAnswer.getText());
        securityAWriter.close();
        
    }
}