/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.scene.control.cell.CheckBoxTableCell;
import Entity.Contacts;
import Entity.EmployeeAttendance;
import Entity.Schedule;
import Entity.Teacher;
import Util.LoginSec;
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

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class ViewTeacherController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label socialStatus;
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
    private Label SingInDate;
    @FXML
    private Label Status;
    @FXML
    private Label Qual;
    @FXML
    private Label salary;
    @FXML
    private Label salaryLabel;
    @FXML
    private Tab payroll;
    @FXML
    private TableView<Contacts> ContactsTable;
    @FXML
    private TableColumn<Contacts, String> NameColumn;
    @FXML
    private TableColumn<Contacts, String> NumColumn;
    @FXML
    private Tab abscense;
    @FXML
    private Button saveAbscence;

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
    private Label SSun1;
    @FXML
    private Label SSun2;
    @FXML
    private Label SSun3;
    @FXML
    private Label SSun4;
    @FXML
    private Label SSun5;
    @FXML
    private Label SSun6;
    @FXML
    private Label SSun7;
    @FXML
    private Label SMon1;
    @FXML
    private Label SMon2;
    @FXML
    private Label SMon3;
    @FXML
    private Label SMon4;
    @FXML
    private Label SMon5;
    @FXML
    private Label SMon6;
    @FXML
    private Label SMon7;
    @FXML
    private Label STue1;
    @FXML
    private Label STue2;
    @FXML
    private Label STue3;
    @FXML
    private Label STue4;
    @FXML
    private Label STue5;
    @FXML
    private Label STue6;
    @FXML
    private Label STue7;
    @FXML
    private Label SWed1;
    @FXML
    private Label SWed2;
    @FXML
    private Label SWed3;
    @FXML
    private Label SWed4;
    @FXML
    private Label SWed5;
    @FXML
    private Label SWed6;
    @FXML
    private Label SWed7;
    @FXML
    private Label SThu1;
    @FXML
    private Label SThu2;
    @FXML
    private Label SThu3;
    @FXML
    private Label SThu4;
    @FXML
    private Label SThu5;
    @FXML
    private Label SThu6;
    @FXML
    private Label SThu7;

    @FXML
    private TableView<EmployeeAttendance> AttTable;
    @FXML
    private TableColumn<EmployeeAttendance, String> AttNoteColumn;
    @FXML
    private TableColumn<EmployeeAttendance, String> DurationColumn;
    @FXML
    private TableColumn<EmployeeAttendance, String> TypeColumn;
    @FXML
    private TableColumn<EmployeeAttendance, String> DateColumn;
    @FXML
    private TableColumn<EmployeeAttendance, Boolean> StatusColumn;

    static private Teacher current;
    TeachingStaff TS;

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
        current = TeachingStaff.getEdit();
        name.setText(current.getPId().getName());
        socialStatus.setText(current.getPId().maritalStatusProperty().getValue());
        type.setText(current.getPId().GenderProperty().getValue());
        if (current.getPId().getReligion().equals("1")) {
            religion.setText("مسلم");
        } else {
            religion.setText("مسيحي");
        }
        dob.setText(current.getPId().getDob().toString());
        address.setText(current.getPId().getAddress());
        nationalId.setText(current.getPId().getNationalId());
        nationality.setText(current.getPId().getNationality());
        SingInDate.setText(current.getPId().getHiringDate().toString());
        Status.setText(current.statusProperty().getValue());
        Qual.setText(current.getPId().getQualification());

        ObservableList<Contacts> tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());
        ContactsTable.setItems(tempCon);
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        NumColumn.setCellValueFactory(cellData -> cellData.getValue().ConDeatailsProperty());

        if (LoginSec.getLoggedUser().getPermission().equals("2")) {
            salary.setVisible(true);
            salaryLabel.setVisible(true);
            if (current.getMonthlySalary() != null) {
                salary.setText(current.getMonthlySalary().toString());
            }
            payroll.setDisable(false);
        }

        abscense.selectedProperty().addListener((ov, oldTab, newTab) -> {
            saveAbscence.setVisible(newTab);
        });

        if (current.getEmployeeAttendanceList() != null) {
            ObservableList<EmployeeAttendance> tempAtt = FXCollections.observableArrayList(current.getEmployeeAttendanceList());
            AttTable.setItems(tempAtt);
            AttNoteColumn.setCellValueFactory(cellData -> cellData.getValue().descProperty());
            DurationColumn.setCellValueFactory(cellData -> cellData.getValue().durationProperty());
            TypeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
            DateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
            StatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
            StatusColumn.setCellFactory(CheckBoxTableCell.forTableColumn(StatusColumn));
        }

        if (current.getScheduleList() != null) {
            for (Schedule scheduleList : current.getScheduleList()) {
                int temp = scheduleList.getLecId().getLecId();
                switch (temp) {
                    case 1:
                        SSun1.setText(scheduleList.getSuId());
                        Sun1.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 2:
                        SSun2.setText(scheduleList.getSuId());
                        Sun2.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 3:
                        SSun3.setText(scheduleList.getSuId());
                        Sun3.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 4:
                        SSun4.setText(scheduleList.getSuId());
                        Sun4.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 5:
                        SSun5.setText(scheduleList.getSuId());
                        Sun5.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 6:
                        SSun6.setText(scheduleList.getSuId());
                        Sun6.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 7:
                        SSun7.setText(scheduleList.getSuId());
                        Sun7.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 8:
                        SMon1.setText(scheduleList.getSuId());
                        Mon1.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 9:
                        SMon2.setText(scheduleList.getSuId());
                        Mon2.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 10:
                        SMon3.setText(scheduleList.getSuId());
                        Mon3.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 11:
                        SMon4.setText(scheduleList.getSuId());
                        Mon4.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 12:
                        SMon5.setText(scheduleList.getSuId());
                        Mon5.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 13:
                        SMon6.setText(scheduleList.getSuId());
                        Mon6.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 14:
                        SMon7.setText(scheduleList.getSuId());
                        Mon7.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 15:
                        STue1.setText(scheduleList.getSuId());
                        Tue1.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 16:
                        STue2.setText(scheduleList.getSuId());
                        Tue2.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 17:
                        STue3.setText(scheduleList.getSuId());
                        Tue3.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 18:
                        STue4.setText(scheduleList.getSuId());
                        Tue4.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 19:
                        STue5.setText(scheduleList.getSuId());
                        Tue5.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 20:
                        STue6.setText(scheduleList.getSuId());
                        Tue6.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 21:
                        STue7.setText(scheduleList.getSuId());
                        Tue7.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 22:
                        SWed1.setText(scheduleList.getSuId());
                        Wed1.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 23:
                        SWed2.setText(scheduleList.getSuId());
                        Wed2.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 24:
                        SWed3.setText(scheduleList.getSuId());
                        Wed3.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 25:
                        SWed4.setText(scheduleList.getSuId());
                        Wed4.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 26:
                        SWed5.setText(scheduleList.getSuId());
                        Wed5.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 27:
                        SWed6.setText(scheduleList.getSuId());
                        Wed6.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 28:
                        SWed7.setText(scheduleList.getSuId());
                        Wed7.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 29:
                        SThu1.setText(scheduleList.getSuId());
                        Thu1.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 30:
                        SThu2.setText(scheduleList.getSuId());
                        Thu2.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 31:
                        SThu3.setText(scheduleList.getSuId());
                        Thu3.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 32:
                        SThu4.setText(scheduleList.getSuId());
                        Thu4.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 33:
                        SThu5.setText(scheduleList.getSuId());
                        Thu5.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 34:
                        SThu6.setText(scheduleList.getSuId());
                        Thu6.setText(scheduleList.getCId().getClassDesc());
                        break;
                    case 35:
                        SThu7.setText(scheduleList.getSuId());
                        Thu7.setText(scheduleList.getCId().getClassDesc());
                }
            }
        }
    }
    
    @FXML
    public void handleEdit() {
        int selectedIndex = AttTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            TeachingStaff.setEditStatus(AttTable.getItems().get(selectedIndex));
            TS.ViewEditAbscentStatus();
            ObservableList<EmployeeAttendance> tempAtt = FXCollections.observableArrayList(current.getEmployeeAttendanceList());
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
