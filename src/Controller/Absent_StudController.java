/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Student;
import Entity.StudentAttendance;
import amgad.h.StudentAffair;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class Absent_StudController implements Initializable {

    @FXML
    private TextField SearchQuery;
    @FXML
    private DatePicker AbsentDate;
    @FXML
    private TextArea Notes;
    @FXML
    private TableView<Student> StudentsTable;
    @FXML
    private TableColumn<Student, String> NameColumn;
    @FXML
    private TableColumn<Student, String> ClassColumn;

    StudentAffair SA;
    Student su;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (!StudentsTable.getItems().isEmpty()) {
            StudentsTable.getItems().clear();
        }

        StudentsTable.setItems(StudentAffair.getPersonsList());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().NameProperty());
        ClassColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue().getClassStudentsList() != null) {
                return cellData.getValue().getClassStudentsList().getCId().ClassDescProperty();
            } else {
                return null;
            }
        });
        SA = new StudentAffair();
        
        System.out.println("Stud Absent Init");
    }

    @FXML
    public void Search() {
        if (!SearchQuery.getText().equals("")) {
            ObservableList<Student> TempList = FXCollections.observableArrayList(SA.getActiveStudents());
            StudentsTable.getItems().clear();
            for (int i = 0; i < TempList.size(); i++) {
                if (!TempList.get(i).getPId().getName().contains(SearchQuery.getText())) {
                    TempList.remove(i);
                    i--;
                }
            }
            StudentsTable.setItems(TempList);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لاتترك صندوق البحث فارغ");
            alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    public void afterNew() {
        StudentsTable.setItems(StudentAffair.getPersonsList());
        SearchQuery.setText("");
        Notes.setText("");
        AbsentDate.setValue(null);
    }

    @FXML
    public void handleNewAbsent() {
        su = StudentsTable.getSelectionModel().getSelectedItem();
        if (su != null && AbsentDate.getValue() != null) {
            if (SA.PersistNewAbsent(Notes.getText(), su, Date.valueOf(AbsentDate.getValue()))) {
                
                afterNew();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("تم");
                alert.setHeaderText("تم الحفظ بنجاح");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("لم يتم الحفظ");
                alert.setContentText("برجاء الرجوع الى صاحب البرنامج");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            }
        } else {
            if (su == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("لم يتم تحديد العنصر المراد حفظه");
                alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("برجاء ادخال تاريخ الغياب");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            }
        }

    }

    @FXML
    public void handleClose() {
        SA.getDialogStage().close();
    }

}
