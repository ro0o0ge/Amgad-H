/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Classes;
import amgad.h.Management;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class EmpClassesController implements Initializable {

    @FXML
    ComboBox STYCombo;

    Management ts;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        STYCombo.getItems().removeAll(STYCombo.getItems());
        STYCombo.getItems().addAll(getStaudyYears());
    }

    private List<String> getStaudyYears() {
        ts = new Management();
        List<String> StudY = new ArrayList<String>();
        for (Classes sy : ts.getStudyYears()) {
            StudY.add(sy.getClassDesc());
        }
        return StudY;
    }

    @FXML
    private void handleConfirm() {
        if (!STYCombo.getValue().equals("")) {
            ts = new Management();
            Management.getDialogStage2().close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء التأكد من اختيار الفصل");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

}
