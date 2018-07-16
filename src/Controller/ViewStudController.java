/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Contacts;
import Entity.EmployeeAttendance;
import Entity.Student;
import Entity.StudentAttendance;
import amgad.h.StudentAffair;
import amgad.h.TeachingStaff;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class ViewStudController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label className;
    @FXML
    private Label serial;
    @FXML
    private Label type;
    @FXML
    private Label nationality;
    @FXML
    private Label religion;
    @FXML
    private Label dob;
    @FXML
    private Label address;
    @FXML
    private Label nationalId;
    @FXML
    private Label secretNo;
    @FXML
    private Label seatingNo;
    @FXML
    private TableView<Contacts> ContactsTable;
    @FXML
    private TableColumn<Contacts, String> NameColumn;
    @FXML
    private TableColumn<Contacts, String> NumColumn;

    @FXML
    private Label Sun1;
    @FXML
    private Label Sun2;
    @FXML
    private Label Sun3;
    @FXML
    private Label Sun4;
    @FXML
    private Label Sun5;
    @FXML
    private Label Sun6;
    @FXML
    private Label Sun7;
    @FXML
    private Label Mon1;
    @FXML
    private Label Mon2;
    @FXML
    private Label Mon3;
    @FXML
    private Label Mon4;
    @FXML
    private Label Mon5;
    @FXML
    private Label Mon6;
    @FXML
    private Label Mon7;
    @FXML
    private Label Tue1;
    @FXML
    private Label Tue2;
    @FXML
    private Label Tue3;
    @FXML
    private Label Tue4;
    @FXML
    private Label Tue5;
    @FXML
    private Label Tue6;
    @FXML
    private Label Tue7;
    @FXML
    private Label Wed1;
    @FXML
    private Label Wed2;
    @FXML
    private Label Wed3;
    @FXML
    private Label Wed4;
    @FXML
    private Label Wed5;
    @FXML
    private Label Wed6;
    @FXML
    private Label Wed7;
    @FXML
    private Label Thu1;
    @FXML
    private Label Thu2;
    @FXML
    private Label Thu3;
    @FXML
    private Label Thu4;
    @FXML
    private Label Thu5;
    @FXML
    private Label Thu6;
    @FXML
    private Label Thu7;
    @FXML
    private Tab abscense;
    @FXML
    private Button saveAbscence;

    @FXML
    private TableView<StudentAttendance> AttTable;
    @FXML
    private TableColumn<StudentAttendance, String> AttNoteColumn;
    @FXML
    private TableColumn<StudentAttendance, String> AttDateColumn;
    @FXML
    private TableColumn<StudentAttendance, Boolean> StatusColumn;

    static private Student current;
    
    StudentAffair TS;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            current = StudentAffair.getEdit();
            TS = new StudentAffair();
            name.setText(current.getPId().getName());
            if (current.getClassStudentsList() != null) {
                className.setText(current.getClassStudentsList().getCId().getClassDesc());
                if (current.getClassStudentsList().getCId().getScheduleList() != null) {
                    if (current.getClassStudentsList().getCId().getScheduleList().size() > 0) {
                        Sun1.setText(current.getClassStudentsList().getCId().getScheduleList().get(0).getSuId());
                        Sun2.setText(current.getClassStudentsList().getCId().getScheduleList().get(1).getSuId());
                        Sun3.setText(current.getClassStudentsList().getCId().getScheduleList().get(2).getSuId());
                        Sun4.setText(current.getClassStudentsList().getCId().getScheduleList().get(3).getSuId());
                        Sun5.setText(current.getClassStudentsList().getCId().getScheduleList().get(4).getSuId());
                        Sun6.setText(current.getClassStudentsList().getCId().getScheduleList().get(5).getSuId());
                        Sun7.setText(current.getClassStudentsList().getCId().getScheduleList().get(6).getSuId());
                        Mon1.setText(current.getClassStudentsList().getCId().getScheduleList().get(7).getSuId());
                        Mon2.setText(current.getClassStudentsList().getCId().getScheduleList().get(8).getSuId());
                        Mon3.setText(current.getClassStudentsList().getCId().getScheduleList().get(9).getSuId());
                        Mon4.setText(current.getClassStudentsList().getCId().getScheduleList().get(10).getSuId());
                        Mon5.setText(current.getClassStudentsList().getCId().getScheduleList().get(11).getSuId());
                        Mon6.setText(current.getClassStudentsList().getCId().getScheduleList().get(12).getSuId());
                        Mon7.setText(current.getClassStudentsList().getCId().getScheduleList().get(13).getSuId());
                        Tue1.setText(current.getClassStudentsList().getCId().getScheduleList().get(14).getSuId());
                        Tue2.setText(current.getClassStudentsList().getCId().getScheduleList().get(15).getSuId());
                        Tue3.setText(current.getClassStudentsList().getCId().getScheduleList().get(16).getSuId());
                        Tue4.setText(current.getClassStudentsList().getCId().getScheduleList().get(17).getSuId());
                        Tue5.setText(current.getClassStudentsList().getCId().getScheduleList().get(18).getSuId());
                        Tue6.setText(current.getClassStudentsList().getCId().getScheduleList().get(19).getSuId());
                        Tue7.setText(current.getClassStudentsList().getCId().getScheduleList().get(20).getSuId());
                        Wed1.setText(current.getClassStudentsList().getCId().getScheduleList().get(21).getSuId());
                        Wed2.setText(current.getClassStudentsList().getCId().getScheduleList().get(22).getSuId());
                        Wed3.setText(current.getClassStudentsList().getCId().getScheduleList().get(23).getSuId());
                        Wed4.setText(current.getClassStudentsList().getCId().getScheduleList().get(24).getSuId());
                        Wed5.setText(current.getClassStudentsList().getCId().getScheduleList().get(25).getSuId());
                        Wed6.setText(current.getClassStudentsList().getCId().getScheduleList().get(26).getSuId());
                        Wed7.setText(current.getClassStudentsList().getCId().getScheduleList().get(27).getSuId());
                        Thu1.setText(current.getClassStudentsList().getCId().getScheduleList().get(28).getSuId());
                        Thu2.setText(current.getClassStudentsList().getCId().getScheduleList().get(29).getSuId());
                        Thu3.setText(current.getClassStudentsList().getCId().getScheduleList().get(30).getSuId());
                        Thu4.setText(current.getClassStudentsList().getCId().getScheduleList().get(31).getSuId());
                        Thu5.setText(current.getClassStudentsList().getCId().getScheduleList().get(32).getSuId());
                        Thu6.setText(current.getClassStudentsList().getCId().getScheduleList().get(33).getSuId());
                        Thu7.setText(current.getClassStudentsList().getCId().getScheduleList().get(34).getSuId());
                    }
                }
            }
            serial.setText(current.getSerialNo());
            if (current.getPId().getGender().equals("1")) {
                type.setText("ذكر");
            } else {
                type.setText("أنثى");
            }
            nationality.setText(current.getPId().getNationality());
            if (current.getPId().getReligion().equals("1")) {
                religion.setText("مسلم");
            } else {
                religion.setText("مسيحي");
            }
            dob.setText(current.getPId().getDob().toString());
            address.setText(current.getPId().getAddress());
            nationalId.setText(current.getPId().getNationalId());
            secretNo.setText(current.getSecretNo());
            seatingNo.setText(current.getSeatingNo());

            ObservableList<Contacts> tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());
            ContactsTable.setItems(tempCon);
            NameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
            NumColumn.setCellValueFactory(cellData -> cellData.getValue().ConDeatailsProperty());

            abscense.selectedProperty().addListener((ov, oldTab, newTab) -> {
                saveAbscence.setVisible(newTab);
            });

            if (current.getStudentAttendanceList() != null) {
                ObservableList<StudentAttendance> tempAtt = FXCollections.observableArrayList(current.getStudentAttendanceList());
                AttTable.setItems(tempAtt);
                AttNoteColumn.setCellValueFactory(cellData -> cellData.getValue().DescProperty());
                AttDateColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                StatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                StatusColumn.setCellFactory(CheckBoxTableCell.forTableColumn(StatusColumn));
            }
        } catch (Exception e) {
            System.err.println("ERROR IN INIT" + e);
        }
    }

    @FXML
    public void handleEdit() {
        int selectedIndex = AttTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            StudentAffair.setEditStatus(AttTable.getItems().get(selectedIndex));
            TS.ViewEditAbscentStatus();
            ObservableList<StudentAttendance> tempAtt = FXCollections.observableArrayList(current.getStudentAttendanceList());
            AttTable.getItems().clear();
            AttTable.setItems(tempAtt);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
            alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }
}
