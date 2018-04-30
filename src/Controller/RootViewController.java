/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Util.LoginSec;
import amgad.h.Management;
import amgad.h.StudentAffair;
import amgad.h.TeachingStaff;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class RootViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
  
    private Management man;
    private StudentAffair sa;
    private TeachingStaff ts;

    public void setMainApp(Management m,StudentAffair s,TeachingStaff t) {
        this.man = m;
        this.sa = s;
        this.ts = t;
    }
    
    @FXML
    private void handleNewStud() {
        sa.newStud();
    }
    
    @FXML
    private void handleEditStud() {
        sa.editStud();
    }
    
    @FXML
    private void handleStudAbsent() {
        sa.AbsentStud();
    }
    
    
    @FXML
    private void handleNewTeacher() {
        ts.newTeacher();
    }
    
    @FXML
    private void handleEditTeacher() {
        ts.editTeacher();
    }
    
    @FXML
    private void handleNewEmp() {
        man.newEmp();
    }
    
    @FXML
    private void handleEditEmp() {
        man.editEmp();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("مدرسة الأمجاد الخاصة");
        alert.setHeaderText("معلومات");
        alert.setContentText("بواسطة : عبدالله رمضان \n للتواصل: abdo.ramadan29@gmail.com");
        alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        alert.showAndWait();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        try {
            LoginSec ls = new LoginSec();
            ls.HandleLogout();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("برجاء مراجعة مالك البرنمج");
            alert.setContentText(e.getMessage());
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
        System.exit(0);
    }
}
