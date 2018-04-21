/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import amgad.h.StudentAffair;
import amgad.h.TeachingStaff;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class TeacContactController implements Initializable {

     @FXML
    private TextField conName;
    @FXML
    private TextField conNum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleConfirm() {
        if (!conName.getText().equals("") || 
                !conNum.getText().equals("") ) {
            TeachingStaff.getContacts().setConName(conName.getText());
            TeachingStaff.getContacts().setConDeatails(conNum.getText());
            TeachingStaff.getDialogStage2().close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء التأكد من ملأ الاسم و لرقم");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }
}
