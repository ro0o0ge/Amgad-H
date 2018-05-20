/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.FinalGrades;
import Entity.GradeDetail;
import Entity.StudyYears;
import Entity.Subjects;
import amgad.h.TeachingStaff;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class GradesController implements Initializable {

    @FXML
    private ComboBox ComboYear;
    @FXML
    private ComboBox ComboSubject;
    @FXML
    private TextField FinalGrade;
    @FXML
    private TextField Grade;
    @FXML
    private TextArea GradeDesc;
    @FXML
    private TableView<GradeDetail> GradeDetailTable;
    @FXML
    private TableColumn<GradeDetail, String> GradeColumn;
    @FXML
    private TableColumn<GradeDetail, String> GradeDescColumn;

    TeachingStaff TS;

    private static FinalGrades FG;

    public static void setFG(FinalGrades FG) {
        GradesController.FG = FG;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TS = new TeachingStaff();
        ComboSubject.getItems().removeAll(ComboSubject.getItems());
        ComboYear.getItems().removeAll(ComboYear.getItems());
        ComboYear.getItems().addAll(getStaudyYears());
        ComboYear.valueProperty().addListener((ov, oldValue, newValue) -> {
            ComboSubject.getItems().clear();
            ComboSubject.getItems().addAll(getSubjects(newValue.toString()));
            FinalGrade.setText("");
        });

        ComboSubject.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (!newValue.equals("")) {
                TS.LoadGradeDetails(newValue.toString(),
                        ComboYear.getSelectionModel().getSelectedItem().toString());
//                GradeDetailTable.setItems(TS.getGradeDetailList());
//                GradeColumn.setCellValueFactory(cellData -> cellData.getValue().GradeProperty());
//                GradeDescColumn.setCellValueFactory(cellData -> cellData.getValue().GradeDescProperty());
                FinalGrade.setText(TS.getFinalGrade(
                        TS.getSubjectsByDescAndYDesc(newValue.toString(),
                                ComboYear.getSelectionModel().getSelectedItem().toString())
                ));
            }
        });
        System.out.println("Call Init");
        GradeDetailTable.setItems(TS.getGradeDetailList());
        GradeColumn.setCellValueFactory(cellData -> cellData.getValue().GradeProperty());
        GradeDescColumn.setCellValueFactory(cellData -> cellData.getValue().GradeDescProperty());
        GradeDetailTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));

    }

    private void showDetails(GradeDetail shera2) {
        if (shera2 != null) {
            Grade.setText(String.valueOf(shera2.getGrade()));
            GradeDesc.setText(shera2.getGradeDetail());
        } else {
            Grade.setText("");
            GradeDesc.setText("");
        }
    }

    public List<String> getStaudyYears() {
        List<String> StudY = new ArrayList<String>();
        for (StudyYears sy : TS.getStudyYears()) {
            StudY.add(sy.getSyDesc());
        }
        return StudY;
    }

    public List<String> getSubjects(String syDesc) {
        List<String> StudY = new ArrayList<String>();
        for (Subjects sy : TS.getSubjectsByStudyYearDesc(syDesc)) {
            StudY.add(sy.getSuDesc());
        }
        return StudY;
    }

    @FXML
    public void handleNew() {
        if (!Grade.getText().equals("") && !GradeDesc.getText().equals("")) {
            GradeDetail tempGD = new GradeDetail();
            tempGD.setGId(FG);
            tempGD.setGrade(Double.valueOf(Grade.getText()));
            tempGD.setGradeDetail(GradeDesc.getText());
//            TS.PersistNewGradeDetail(tempGD);
            TS.getGradeDetailList().add(tempGD);
            GradeDetailTable.setItems(TS.getGradeDetailList());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء التأكد من صحة البيانات");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleEdit() {
        GradeDetail gd = GradeDetailTable.getSelectionModel().getSelectedItem();
        if (gd != null && !Grade.getText().equals("") && !GradeDesc.getText().equals("")) {
            gd.setGrade(Double.valueOf(Grade.getText()));
            gd.setGradeDetail(GradeDesc.getText());
            showDetails(gd);
            GradeDetailTable.setItems(TS.getGradeDetailList());
            System.out.println("eh!!");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleDelete() {
        int selectedIndex = GradeDetailTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            GradeDetailTable.getItems().remove(selectedIndex);

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleSaveAll() {

    }

    @FXML
    public void handleNewFinalGrade() {
        if (!ComboSubject.getSelectionModel().getSelectedItem().equals("")
                && !FinalGrade.getText().equals("") && FinalGrade.getText().matches("[0-9]+")) {
            FinalGrades tempFG = new FinalGrades();
            tempFG.setSuId(TS.getSubjectsByDescAndYDesc(ComboSubject.getSelectionModel().getSelectedItem().toString(),
                    ComboYear.getSelectionModel().getSelectedItem().toString()));
            tempFG.setGrade(Integer.parseInt(FinalGrade.getText()));
            TS.PersistNewFinalGrade(tempFG);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء التأكد من اختيار المادة و كتابة الدرجة ");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleClose() {
        TS.getDialogStage().close();
    }
}
