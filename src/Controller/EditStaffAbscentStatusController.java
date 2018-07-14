/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.EmployeeAttendance;
import amgad.h.Management;
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
public class EditStaffAbscentStatusController implements Initializable {

    @FXML
    Label name;
    @FXML
    Label date;
    @FXML
    CheckBox status;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        name.setText(Management.getEditStatus().getStId().getPId().getName());
        date.setText(Management.getEditStatus().getEaDate().toString());
        status.setSelected(Management.getEditStatus().getStatus());
    }

    @FXML
    public void handleDone() {
        Management TS = new Management();
        EmployeeAttendance ea = Management.getEditStatus();
        ea.setStatus(status.isSelected());
        TS.UpdateAbscenceStatus(ea);
        Management.getDialogStage2().close();
    }
}
