/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class EditTeacPayrollStatusController implements Initializable {

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
        name.setText(TeachingStaff.getEditPayrollStatus().getPId().getName());
        date.setText(TeachingStaff.getEditPayrollStatus().getPrDate().toString());
        status.setSelected(TeachingStaff.getEditPayrollStatus().getPrStatus());
    }

    @FXML
    public void handleDone() {
        TeachingStaff TS = new TeachingStaff();
        TeachingStaff.getEditPayrollStatus().setPrStatus(status.isSelected());
        TS.UpdatePenaltyStatus();
        TeachingStaff.getDialogStage2().close();

    }
}
