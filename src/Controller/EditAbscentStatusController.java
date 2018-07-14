/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.EmployeeAttendance;
import amgad.h.TeachingStaff;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class EditAbscentStatusController implements Initializable {

    @FXML
    Label name;
    @FXML
    Label date; 
    @FXML
    CheckBox status;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        name.setText(TeachingStaff.getEditStatus().getTId().getPId().getName());
        date.setText(TeachingStaff.getEditStatus().getEaDate().toString());
        status.setSelected(TeachingStaff.getEditStatus().getStatus());
    }    
    
    @FXML
    public void handleDone() {
        TeachingStaff TS = new TeachingStaff();
        EmployeeAttendance ea = TeachingStaff.getEditStatus();
        ea.setStatus(status.isSelected());
        TS.UpdateAbscenceStatus(ea);
        TeachingStaff.getDialogStage2().close();
        
    }
}
