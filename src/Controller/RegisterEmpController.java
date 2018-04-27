/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Classes;
import Entity.Contacts;
import Entity.Persons;
import Entity.Staff;
import Entity.StaffClasses;
import Util.LoginSec;
import amgad.h.Management;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import java.sql.Date;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class RegisterEmpController implements Initializable {
    
    
    
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
    private TableView<Classes> ClassesTable;
    @FXML
    private TableColumn<Classes, String> ClassNameColumn;

    
    Management MA;
    private Persons pers;
    private Staff teac;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         MA = new Management();
        tNationality.getItems().removeAll(tNationality.getItems());
        tNationality.getItems().addAll("EGY", "SAU", "OMN", "BHR", "KWT",
                "UAE", "JOR", "PSE", "LBR");

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

        ContactsTable.setItems(MA.getContactsList());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue()
                .NameProperty());
        NumColumn.setCellValueFactory(cellData -> cellData.getValue()
                .ConDeatailsProperty());

        ClassesTable.setItems(MA.getSubjectsList());
        ClassNameColumn.setCellValueFactory(cellData -> cellData.getValue()
                .ClassDescProperty());

        System.out.println("Permission "+LoginSec.getLoggedUser().getPermission()+
                " name "+ LoginSec.getLoggedUser().getUName());
        if (LoginSec.getLoggedUser().getPermission().equals("2")) {
            salary.setVisible(true);
        }
    }  
    
    
    
    @FXML
    public void handleSave() {
        pers = new Persons();
        teac = new Staff();
        if (!tName.getText().equals("") || tNationality.getSelectionModel().isEmpty()
                || !tNatNo.getText().equals("") || !tNatNo.getText().matches("[0-9]+")
                || !tAddress.getText().equals("") || tDOB.getValue() != null
                || tSignDate.getValue() != null) {
            try {
                pers.setName(tName.getText());
                if (gType.getSelectedToggle().getUserData().toString().equals("ذكر")) {
                    pers.setGender("1");
                } else {
                    pers.setGender("2");
                }
                pers.setNationality(tNationality.getSelectionModel().getSelectedItem().toString());
                if (gReligion.getSelectedToggle().getUserData().toString().equals("مسلم")) {
                    pers.setReligion("1");
                } else {
                    pers.setReligion("2");
                }

                if (gSocial.getSelectedToggle().getUserData().toString().equals("مطلق")) {
                    pers.setMaritalStatus("1");
                } else if (gSocial.getSelectedToggle().getUserData().toString().equals("أرمل")) {
                    pers.setMaritalStatus("2");
                } else if (gSocial.getSelectedToggle().getUserData().toString().equals("أعزب")) {
                    pers.setMaritalStatus("3");
                } else {
                    pers.setMaritalStatus("4");
                }
                pers.setNationalId(tNatNo.getText());
                pers.setAddress(tAddress.getText());
                pers.setDob(Date.valueOf(tDOB.getValue()));
                pers.setCreatedDate(Date.valueOf(LocalDate.now()));
                pers.setHiringDate(Date.valueOf(tSignDate.getValue()));

                if (tGradDate.getValue() != null) {
                    LocalDate localDate = tGradDate.getValue();
                    pers.setGradYear(String.valueOf(localDate.getYear()));
                }

                if (!tQual.getText().equals("")) {
                    pers.setQualification(tQual.getText());
                }

                teac.setPId(pers);

                if (gStatus.getSelectedToggle().getUserData().toString().equals("يعمل")) {
                    teac.setStatus("1");
                } else {
                    teac.setStatus("2");
                }

                if (!tSalary.getText().isEmpty()) {
                    teac.setMonthlySalary(Double.valueOf(tSalary.getText()));
                }

                MA.PersistNewTeac(pers, teac);

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("خطأ");
                alert.setContentText("برجاء مراجعة مالك البرنامج");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
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
        Management.getDialogStage().close();
    }

    @FXML
    public void handleAddCont() {
        Management.setC(new Contacts());
        MA.newCon();
        MA.getContactsList().add(Management.getContacts());
    }

    @FXML
    public void handleDeleteCont() {
        if (ContactsTable.getSelectionModel().getSelectedIndex() >= 0) {
            ContactsTable.getItems().remove(ContactsTable.getSelectionModel().getSelectedIndex());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
            alert.setContentText("من فضلك قم بتحديد العنصر من جدول جهات الاتصال");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleAddSub() {
        Management.setSC(new StaffClasses());
        MA.newSub();
        MA.getTss().add(Management.getSC());
        MA.getSubjectsList().add(Management.getSC().getCId());
    }

    @FXML
    public void handleDeleteSub() {
        if (ClassesTable.getSelectionModel().getSelectedIndex() >= 0) {
            ClassesTable.getItems().remove(ClassesTable.getSelectionModel().getSelectedIndex());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
            alert.setContentText("من فضلك قم بتحديد العنصر من جدول الفصول");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }
}
