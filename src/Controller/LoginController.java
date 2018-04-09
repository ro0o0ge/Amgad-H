/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Util.LoginSec;
import amgad.h.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
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

    private Main main;

    public void setMainApp(Main mainapp) {
        this.main = mainapp;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void login() {
        try {
            LoginSec ls = new LoginSec();
            if (userName.getText().equals("") || Pass.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("");
                alert.setContentText("برجاء كتابة اسم المستخدم او كلمة المرور");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            } else if (!ls.HandleLogin(userName.getText(), Pass.getText()).equals("1")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("غير مسموح لك بتسجيل الدخول");
                alert.setContentText("برجاء التأكد من اسم المستخدم وكلمة المرور او الرجوع للأدمن");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            } else {
                main.rootView();
                System.out.println("manager or admin");
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("برجاء مراجعة مالك البرنمج");
            alert.setContentText(e.getMessage());
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }
}
