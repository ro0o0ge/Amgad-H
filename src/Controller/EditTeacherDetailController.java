/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Contacts;
import Entity.Subjects;
import Entity.Teacher;
import Entity.TeacherSubjects;
import Util.LoginSec;
import amgad.h.TeachingStaff;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class EditTeacherDetailController implements Initializable {

    @FXML
    DatePicker tSignDate;
    @FXML
    TextField tSalary;
    @FXML
    TextField tQual;
    @FXML
    ComboBox tNationality;
    @FXML
    TextField tNatNo;
    @FXML
    TextField tName;
    @FXML
    DatePicker tGradDate;
    @FXML
    DatePicker tDOB;
    @FXML
    TextField tAddress;
    @FXML
    RadioButton t2;
    @FXML
    RadioButton t1;
    @FXML
    RadioButton soc1;
    @FXML
    RadioButton soc2;
    @FXML
    RadioButton soc3;
    @FXML
    RadioButton soc4;
    @FXML
    RadioButton s1;
    @FXML
    RadioButton s2;
    @FXML
    RadioButton r2;
    @FXML
    RadioButton r1;
    @FXML
    HBox salary;
    @FXML
    ToggleGroup gType;
    @FXML
    ToggleGroup gStatus;
    @FXML
    ToggleGroup gSocial;
    @FXML
    ToggleGroup gReligion;
    @FXML
    private TableView<Contacts> ContactsTable;
    @FXML
    private TableColumn<Contacts, String> NameColumn;
    @FXML
    private TableColumn<Contacts, String> NumColumn;
    @FXML
    private TableView<Subjects> SubjectsTable;
    @FXML
    private TableColumn<Subjects, String> SubjectNameColumn;

    TeachingStaff TA;

    static private Teacher current;
    static ObservableList<Contacts> tempCon = FXCollections.observableArrayList();
    static ObservableList<Subjects> tempSub = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        t1.setUserData("ذكر");
        t2.setUserData("انثى");
        r1.setUserData("مسلم");
        r2.setUserData("مسيحي");
        s1.setUserData("يعمل");
        s2.setUserData("لا يعمل");
        soc1.setUserData("مطلق");
        soc2.setUserData("أرمل");
        soc3.setUserData("أعزب");
        soc4.setUserData("متزوج");

        TA = new TeachingStaff();
        current = TeachingStaff.getEdit();

        if (current.getPId().getGender().equals("1")) {
            gType.selectToggle(t1);
        } else {
            gType.selectToggle(t2);
        }

        if (current.getStatus().equals("1")) {
            gStatus.selectToggle(s1);
        } else {
            gStatus.selectToggle(s2);
        }

        if (current.getPId().getMaritalStatus().equals("1")) {
            gSocial.selectToggle(soc1);
        } else if (current.getPId().getMaritalStatus().equals("2")) {
            gSocial.selectToggle(soc2);
        } else if (current.getPId().getMaritalStatus().equals("3")) {
            gSocial.selectToggle(soc3);
        } else {
            gSocial.selectToggle(soc4);
        }

        if (current.getPId().getGender().equals("1")) {
            gReligion.selectToggle(r1);
        } else {
            gReligion.selectToggle(r2);
        }

        tNationality.getItems().removeAll(tNationality.getItems());
        tNationality.getItems().addAll("EGY", "SAU", "OMN", "BHR", "KWT",
                "UAE", "JOR", "PSE", "LBR");
        tNationality.getSelectionModel().select(current.getPId().getNationality());

        if (tempCon.size() > 0) {
            tempCon.clear();
        }
        tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());
        List<Subjects> TeSubList = new ArrayList<Subjects>();
        for (TeacherSubjects sub : current.getTeacherSubjectsList()) {
            TeSubList.add(sub.getSuId());
        }
        tempSub = FXCollections.observableArrayList(TeSubList);

        ContactsTable.setItems(tempCon);
        NameColumn.setCellValueFactory(cellData -> cellData.getValue()
                .NameProperty());
        NumColumn.setCellValueFactory(cellData -> cellData.getValue()
                .ConDeatailsProperty());

        SubjectsTable.setItems(tempSub);
        SubjectNameColumn.setCellValueFactory(cellData -> cellData.getValue()
                .SubDescProperty());

        Calendar cal = Calendar.getInstance();
        cal.setTime(current.getPId().getHiringDate());
        LocalDate date = LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
        tSignDate.setValue(date);

        cal = Calendar.getInstance();
        cal.setTime(current.getPId().getDob());
        date = LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
        tDOB.setValue(date);
        tName.setText(current.getPId().getName());
        tNatNo.setText(current.getPId().getNationalId());
        tAddress.setText(current.getPId().getAddress());

        if (current.getPId().getQualification() != null) {
            tQual.setText(current.getPId().getQualification());
        }

        if (LoginSec.getLoggedUser().getPermission().equals("2")) {
            salary.setVisible(true);
            if (current.getMonthlySalary() != null) {
                tSalary.setText(current.getMonthlySalary().toString());
            }
            System.out.println("Salary " + current.getMonthlySalary());
        }

    }

    @FXML
    public void handleSave() {
        if (!tName.getText().equals("") || tNationality.getSelectionModel().isEmpty()
                || !tNatNo.getText().equals("") || !tNatNo.getText().matches("[0-9]+")
                || !tAddress.getText().equals("") || tDOB.getValue() != null
                || tSignDate.getValue() != null) {
            try {
                current.getPId().setName(tName.getText());
                if (gType.getSelectedToggle().getUserData().toString().equals("ذكر")) {
                    current.getPId().setGender("1");
                } else {
                    current.getPId().setGender("2");
                }
                current.getPId().setNationality(tNationality.getSelectionModel().getSelectedItem().toString());
                if (gReligion.getSelectedToggle().getUserData().toString().equals("مسلم")) {
                    current.getPId().setReligion("1");
                } else {
                    current.getPId().setReligion("2");
                }

                if (gSocial.getSelectedToggle().getUserData().toString().equals("مطلق")) {
                    current.getPId().setMaritalStatus("1");
                } else if (gSocial.getSelectedToggle().getUserData().toString().equals("أرمل")) {
                    current.getPId().setMaritalStatus("2");
                } else if (gSocial.getSelectedToggle().getUserData().toString().equals("أعزب")) {
                    current.getPId().setMaritalStatus("3");
                } else {
                    current.getPId().setMaritalStatus("4");
                }
                current.getPId().setNationalId(tNatNo.getText());
                current.getPId().setAddress(tAddress.getText());
                current.getPId().setDob(Date.valueOf(tDOB.getValue()));
                current.getPId().setCreatedDate(Date.valueOf(LocalDate.now()));
                current.getPId().setHiringDate(Date.valueOf(tSignDate.getValue()));

                if (tGradDate.getValue() != null) {
                    LocalDate localDate = tGradDate.getValue();
                    current.getPId().setGradYear(String.valueOf(localDate.getYear()));
                }

                if (!tQual.getText().equals("")) {
                    current.getPId().setQualification(tQual.getText());
                }

                if (gStatus.getSelectedToggle().getUserData().toString().equals("يعمل")) {
                    current.setStatus("1");
                } else {
                    current.setStatus("2");
                }

                if (!tSalary.getText().isEmpty()) {
                    current.setMonthlySalary(Double.valueOf(tSalary.getText()));
                }
                TA.UpdateTeacher(current, tempCon, tempSub);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("خطأ");
                alert.setContentText("برجاء مراجعة مالك البرنامج");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                System.out.println("error " + e.getLocalizedMessage());
                alert.showAndWait();
                throw e;
            }
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
    public void handleClose() {
        TeachingStaff.getDialogStage2().close();
    }

    @FXML
    public void handleAddCont() {
        TeachingStaff.setC(new Contacts());
        TA.newCon();
        tempCon.add(TeachingStaff.getContacts());
    }

    @FXML
    public void handleDeleteCont() {
        if (ContactsTable.getSelectionModel().getSelectedIndex() >= 0) {
            ContactsTable.getItems().remove(ContactsTable.getSelectionModel().getSelectedIndex());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
            alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleAddSub() {
        TeachingStaff.setS(new TeacherSubjects());
        TA.newSub();
        TA.getTss().add(TeachingStaff.getS());
        tempSub.add(TeachingStaff.getS().getSuId());
    }

    @FXML
    public void handleDeleteSub() {
        if (SubjectsTable.getSelectionModel().getSelectedIndex() >= 0) {
            SubjectsTable.getItems().remove(SubjectsTable.getSelectionModel().getSelectedIndex());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
            alert.setContentText("من فضلك قم بتحديد العنصر من جدول المواد");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }
}
