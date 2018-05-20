/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.ClassStudents;
import Entity.Classes;
import Entity.Contacts;
import Entity.Student;
import amgad.h.StudentAffair;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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

    private ClassStudents classStud;
    private List<Classes> css;

    StudentAffair SA;

    static private Student current;
    static ObservableList<Contacts> tempCon = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
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
        current = StudentAffair.getEdit();
        if (tempCon.size() > 0) {
            tempCon.clear();
        }
        tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());

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

        Calendar cal = Calendar.getInstance();
        cal.setTime(current.getPId().getDob());
        LocalDate date = LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
        sDOB.setValue(date);
        if (!ContactsTable.getItems().isEmpty()) {
            ContactsTable.getItems().clear();
        }
        ContactsTable.setItems(tempCon);

        NameColumn.setCellValueFactory(cellData -> cellData.getValue()
                .NameProperty());
        NumColumn.setCellValueFactory(cellData -> cellData.getValue()
                .ConDeatailsProperty());

        serialNo.setText(current.getSerialNo());
        sName.setText(current.getPId().getName());
        sNatNo.setText(current.getPId().getNationalId());
        sAddress.setText(current.getPId().getAddress());

        if (current.getPId().getGender().equals("1")) {
            sType.selectToggle(male);
        } else {
            sType.selectToggle(female);
        }
        
        if (current.getStatus().equals("2")) {
            sStatus.selectToggle(S2);
        } else if (current.getStatus().equals("1")) {
            sStatus.selectToggle(S1);
        } else {
            sStatus.selectToggle(S3);
        }
        if (current.getPId().getReligion().equals("1")) {
            sReligion.selectToggle(R1);
        } else {
            sReligion.selectToggle(R2);
        }

        sSecretNo.setText(current.getSecretNo());
        sSeatingNo.setText(current.getSeatingNo());
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
        if (!sName.getText().equals("") || sNationality.getSelectionModel().isEmpty()
                || !sNatNo.getText().equals("") || !sNatNo.getText().matches("[0-9]+")
                || !sAddress.getText().equals("") || sDOB.getValue() != null
                || !serialNo.getText().equals("") || !serialNo.getText().matches("[0-9]+")) {
            try {

                current.getPId().setName(sName.getText());
                if (sType.getSelectedToggle().getUserData().toString().equals("ذكر")) {
                    current.getPId().setGender("1");
                } else {
                    current.getPId().setGender("2");
                }
                current.getPId().setNationality(sNationality.getSelectionModel().getSelectedItem().toString());

                if (sReligion.getSelectedToggle().getUserData().toString().equals("مسلم")) {
                    current.getPId().setReligion("1");
                } else {
                    current.getPId().setReligion("2");
                }
                current.getPId().setNationalId(sNatNo.getText());
                current.getPId().setAddress(sAddress.getText());
                current.getPId().setDob(Date.valueOf(sDOB.getValue()));
                current.getPId().setModifiedDate(Date.valueOf(LocalDate.now()));

                if (sStatus.getSelectedToggle().getUserData().toString().equals("مرفوض")) {
                    current.setStatus("1");
                } else if (sStatus.getSelectedToggle().getUserData().toString().equals("منتظر")) {
                    current.setStatus("2");
                } else {
                    current.setStatus("3");
                }
                current.setSerialNo(serialNo.getText());

                if (!sClass.getSelectionModel().isEmpty()) {
                    Classes c = new Classes();
                    for (Classes r : css) {
                        if (r.getClassDesc().equals(sClass.getSelectionModel().getSelectedItem().toString())) {
                            c = r;
                        }
                    }
                    classStud = new ClassStudents();
                    classStud.setCId(c);
                    classStud.setSId(current);
                    current.setClassStudentsList(classStud);
                }
                SA.UpdateStud(current, classStud,tempCon);
            } catch (Exception e) {
                System.err.println("Erorr in " + Class.class.getName() + " " + e.getLocalizedMessage());
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
        StudentAffair.getDialogStage2().close();
    }

    @FXML
    public void handleAddCont() {
        StudentAffair.setC(new Contacts());
        SA.newCon();
        tempCon.add(StudentAffair.getContacts());
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
