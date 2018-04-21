/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Classes;
import Entity.StudyYears;
import Entity.Subjects;
import amgad.h.StudentAffair;
import amgad.h.TeachingStaff;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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
public class TeacSubjectsController implements Initializable {

    @FXML
    ComboBox SUCombo;
    @FXML
    ComboBox STYCombo;

    TeachingStaff ts;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        STYCombo.getItems().removeAll(STYCombo.getItems());
        STYCombo.getItems().addAll(getStaudyYears());

        SUCombo.getItems().removeAll(STYCombo.getItems());
//        SUCombo.getItems().add("برجاء اختيار السنة الدراسية");
    }

    private List<String> getStaudyYears() {
        ts = new TeachingStaff();
        List<String> StudY = new ArrayList<String>();
        for (StudyYears sy : ts.getStudyYears()) {
            StudY.add(sy.getSyDesc());
        }
        return StudY;
    }

    @FXML
    private void handleSTYSelection() {
        SUCombo.getItems().clear();
        ts = new TeachingStaff();
        List<String> StudY = new ArrayList<String>();
        for (Subjects sy : ts.getStudyYearSubjects(ts.getStudyYearsByDesc(STYCombo.getValue().toString()))) {
            StudY.add(sy.getSuDesc());
        }
        SUCombo.getItems().addAll(StudY);
    }

    @FXML
    private void handleConfirm() {
        if (!SUCombo.getValue().equals("")) {
            ts = new TeachingStaff();
            TeachingStaff.getS().setSuId(ts.getSubjectsByDesc
        (SUCombo.getValue().toString(),STYCombo.getValue().toString()));
            TeachingStaff.getDialogStage2().close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء التأكد من اختيار المادة");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }
}
