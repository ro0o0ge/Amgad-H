/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class EditEmpPayrollStatusController implements Initializable {
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
        System.out.println("name "+Management.getEditPayrollStatus().getPId().getName());
        name.setText(Management.getEditPayrollStatus().getPId().getName());
        date.setText(Management.getEditPayrollStatus().getPrDate().toString());
        status.setSelected(Management.getEditPayrollStatus().getPrStatus());
    }

    @FXML
    public void handleDone() {
        Management TS = new Management();
        Management.getEditPayrollStatus().setPrStatus(status.isSelected());
        TS.UpdatePenaltyStatus();
        Management.getDialogStage2().close();

    }  
    
}
