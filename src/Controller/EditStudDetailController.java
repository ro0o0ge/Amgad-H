/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.ClassStudents;
import Entity.Classes;
import Entity.Contacts;
import Entity.Persons;
import Entity.Student;
import amgad.h.StudentAffair;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class EditStudDetailController implements Initializable {

    @FXML
    private Label ageCalc;
    @FXML
    private TextField serialNo;
    @FXML
    private TextField sName;
    @FXML
    private TextField sAddress;
    @FXML
    private TextField sNatNo;
    @FXML
    private TextField sSecretNo;
    @FXML
    private TextField sSeatingNo;
    @FXML
    private DatePicker sDOB;
    @FXML
    private ToggleGroup sType;
    @FXML
    private ToggleGroup sStatus;
    @FXML
    private ToggleGroup sReligion;
    @FXML
    private ComboBox sNationality;
    @FXML
    private ComboBox sClass;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton R1;
    @FXML
    private RadioButton R2;
    @FXML
    private RadioButton S1;
    @FXML
    private RadioButton S2;
    @FXML
    private RadioButton S3;

    @FXML
    private TableView<Contacts> ContactsTable;
    @FXML
    private TableColumn<Contacts, String> NameColumn;
    @FXML
    private TableColumn<Contacts, String> NumColumn;

    private Student stud;
    private Persons pers;
    private ClassStudents classStud;
    private List<Classes> css;

    StudentAffair SA;

    private Student current = StudentAffair.getEdit();
    ObservableList<Contacts> tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        male.setUserData("ذكر");
        female.setUserData("انثى");
        R1.setUserData("مسلم");
        R2.setUserData("مسيحي");
        S1.setUserData("مرفوض");
        S2.setUserData("منتظر");
        S3.setUserData("مقبول");

        sNationality.getItems().removeAll(sNationality.getItems());
        sNationality.getItems().addAll("EGY", "SAU", "OMN", "BHR", "KWT",
                "UAE", "JOR", "PSE", "LBR");
        sNationality.getSelectionModel().select(current.getPId().getNationality());

        sClass.getItems().removeAll(sClass.getItems());
        sClass.getItems().addAll(getClasses());
        if (current.getClassStudentsList() != null) {
            sClass.getSelectionModel().select(current.getClassStudentsList().getCId().getClassDesc());
        }

        sDOB.valueProperty().addListener((ov, oldValue, newValue) -> {
            LocalDate currentDate = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), 10, 1);
            ageCalc.setText(currentDate.until(newValue).toString().replace("P-", ""));
        });

//        sDOB.setValue(current.getPId().getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        sDOB.setValue(LocalDate.from(current.getPId().getDob().toInstant()));

        
        ContactsTable.setItems(tempCon);

        NameColumn.setCellValueFactory(cellData -> cellData.getValue()
                .NameProperty());
        NumColumn.setCellValueFactory(cellData -> cellData.getValue()
                .ConDeatailsProperty());
    }

    private List<String> getClasses() {
        SA = new StudentAffair();
        List<String> StudY = new ArrayList<String>();
        css = SA.getClasses();
        for (Iterator<Classes> iterator = css.iterator(); iterator.hasNext();) {
            StudY.add(iterator.next().getClassDesc());
        }
        return StudY;
    }

    @FXML
    public void handleSave() {
        stud = new Student();
        pers = new Persons();
        if (!sName.getText().equals("") || sNationality.getSelectionModel().isEmpty()
                || !sNatNo.getText().equals("") || !sNatNo.getText().matches("[0-9]+")
                || !sAddress.getText().equals("") || sDOB.getValue() != null
                || !serialNo.getText().equals("") || !serialNo.getText().matches("[0-9]+")) {
            try {
                pers.setName(sName.getText());
                if (sType.getSelectedToggle().getUserData().toString().equals("ذكر")) {
                    pers.setGender("1");
                } else {
                    pers.setGender("2");
                }
                pers.setNationality(sNationality.getSelectionModel().getSelectedItem().toString());
                if (sReligion.getSelectedToggle().getUserData().toString().equals("مسلم")) {
                    pers.setReligion("1");
                } else {
                    pers.setReligion("2");
                }
                pers.setNationalId(sNatNo.getText());
                pers.setAddress(sAddress.getText());
                pers.setDob(Date.valueOf(sDOB.getValue()));
                pers.setCreatedDate(Date.valueOf(LocalDate.now()));

                stud.setPId(pers);

                if (sStatus.getSelectedToggle().getUserData().toString().equals("مرفوض")) {
                    stud.setStatus("1");
                } else if (sStatus.getSelectedToggle().getUserData().toString().equals("منتظر")) {
                    stud.setStatus("2");
                } else {
                    stud.setStatus("3");
                }
                stud.setSerialNo(serialNo.getText());
                if (!sClass.getSelectionModel().isEmpty()) {
                    Classes c = new Classes();
                    for (Iterator<Classes> iterator = css.iterator(); iterator.hasNext();) {
                        if (iterator.next().getClassDesc().equals(sClass.getSelectionModel().getSelectedItem().toString())) {
                            c = iterator.next();
                        }
                    }
                    classStud = new ClassStudents();
                    classStud.setSId(stud);
                    classStud.setCId(c);
                }

                SA.PersistNewStud(pers, stud, classStud);
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
        SA.getDialogStage2().close();
    }

    @FXML
    public void handleAddCont() {
        SA.newCon();
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

}
