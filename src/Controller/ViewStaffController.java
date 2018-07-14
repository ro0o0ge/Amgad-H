/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Contacts;
import Entity.EmployeeAttendance;
import Entity.Staff;
import Util.LoginSec;
import amgad.h.Management;
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
public class ViewStaffController implements Initializable {

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

    static private Staff current;
    Management MA;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        current = Management.getEdit();
        MA = new Management();
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

        abscense.selectedProperty().addListener((ov, oldTab, newTab) -> {
            saveAbscence.setVisible(newTab);
        });

        if (LoginSec.getLoggedUser().getPermission().equals("2")) {
            salary.setVisible(true);
            salaryLabel.setVisible(true);
//            if (current.getMonthlySalary() != null) {
            salary.setText(String.valueOf(current.getMonthlySalary()));
//            }
            payroll.setDisable(false);
        }

        if (current.getEmployeeAttendanceList() != null) {
            ObservableList<EmployeeAttendance> tempAtt = FXCollections.observableArrayList(current.getEmployeeAttendanceList());
            AttTable.setItems(tempAtt);
            AttNoteColumn.setCellValueFactory(cellData -> cellData.getValue().descProperty());
            DurationColumn.setCellValueFactory(cellData -> cellData.getValue().durationProperty());
            TypeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
            DateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
            StatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
            StatusColumn.setCellFactory(CheckBoxTableCell.forTableColumn(StatusColumn));
            StatusColumn.onEditStartProperty();
        }

    }

    @FXML
    public void handleEdit() {
        int selectedIndex = AttTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Management.setEditStatus(AttTable.getItems().get(selectedIndex));
            MA.ViewEditAbscentStatus();
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
