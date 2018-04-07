/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Util.LoginSec;
import amgad.h.AmgadH;
import amgad.h.root;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField userName;
    @FXML
    private PasswordField Pass;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void login() {
        LoginSec ls = new LoginSec();
        if (ls.HandleLogin(userName.getText(), Pass.getText()).equals("1")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("غير مسموح لك بتسجيل الدخول");
            alert.setContentText("برجاء التأكد من اسم المستخدم وكلمة المرور او الرجوع للأدمن");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }else{
            //go to root view with flag to indicate admin or manager
            
        }
        
    }
}
