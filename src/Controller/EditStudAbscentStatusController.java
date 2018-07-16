/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.EmployeeAttendance;
import Entity.StudentAttendance;
import amgad.h.StudentAffair;
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
public class EditStudAbscentStatusController implements Initializable {

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
        name.setText(StudentAffair.getEditStatus().getSId().getPId().getName());
        date.setText(StudentAffair.getEditStatus().getAbsentDay().toString());
        status.setSelected(StudentAffair.getEditStatus().getStatus());
    }    
    
    @FXML
    public void handleDone() {
        StudentAffair TS = new StudentAffair();
        StudentAttendance ea = StudentAffair.getEditStatus();
        ea.setStatus(status.isSelected());
        TS.UpdateAbscenceStatus(ea);
        StudentAffair.getDialogStage2().close();
    }
    
}
