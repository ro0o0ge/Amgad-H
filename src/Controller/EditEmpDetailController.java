/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Classes;
import Entity.Contacts;
import Entity.Staff;
import Util.LoginSec;
import amgad.h.Management;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class EditEmpDetailController implements Initializable {

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
    @FXML
    private TextField tSerial;
    @FXML
    private TextField spouseName;
    @FXML
    private TextField spouseJob;
    @FXML
    private TextField noOfChildren;
    @FXML
    private TextArea prevEXP;
    @FXML
    private ComboBox tCategory;
    @FXML
    private RadioButton type1;
    @FXML
    private RadioButton type2;
    @FXML
    private RadioButton type3;
    @FXML
    private ToggleGroup gCategory;
    @FXML
    private Label PhotoPath;
    @FXML
    TextField InsuranceNo;
    @FXML
    TextField InsuranceAmount;

    Management MA;
    final File defaultDirectory = new File("C:\\");

    static private Staff current;
    static ObservableList<Contacts> tempCon = FXCollections.observableArrayList();

//    static ObservableList<Classes> tempSub = FXCollections.observableArrayList();
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
        type1.setUserData("إداري");
        type2.setUserData("فني");
        type3.setUserData("عمال و سائقين");

        MA = new Management();
        current = Management.getEdit();

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

        if (current.getPId().getReligion().equals("1")) {
            gReligion.selectToggle(r1);
        } else {
            gReligion.selectToggle(r2);
        }

        tNationality.getItems().removeAll(tNationality.getItems());
        tNationality.getItems().addAll("EGY", "SAU", "OMN", "BHR", "KWT",
                "UAE", "JOR", "PSE", "LBR");
        tNationality.getSelectionModel().select(current.getPId().getNationality());

        if (current.getPId().getSpouseName() != null) {
            spouseName.setText(current.getPId().getSpouseName());
        }
        if (current.getPId().getSpouseParentOccupation() != null) {
            spouseJob.setText(current.getPId().getSpouseParentOccupation());
        }
        if (current.getPId().getInsuranceNo() != null) {
            InsuranceNo.setText(current.getPId().getInsuranceNo());
        }
        if (current.getPId().getInsuranceAmount() != null) {
            InsuranceAmount.setText(current.getPId().getInsuranceAmount().toString());
        }

        if (current.getStaffType().equals("1")) {
            gCategory.selectToggle(type1);
            tCategory.getItems().removeAll(tCategory.getItems());
            tCategory.getItems().addAll(
                    "رئيس قسم سكرتارية", "سكرتيرة", "ضابطة", "ضابطة أولى", "وكيلة شئون مالية",
                    "وكيلة شئون ادارية", "وكيلة شئون ادارية ومالية", "مشرفة دور", "مشرفة باص",
                    "مشرفة مقصف", "مشرفة باص و مقصف", "مسئولة سينما", "ألعاب",
                    "مجالات", "مسئولة الكمبيوتر", "اخصائية اجتماعية");
        } else if (current.getStaffType().equals("2")) {
            gCategory.selectToggle(type2);
            tCategory.getItems().removeAll(tCategory.getItems());
            tCategory.getItems().addAll("ناظرة", "مساعد قائد", "وكيلة فنية", "مديرة متابعة فنية",
                    "مشرفة اللغة العربية", "مشرفة اللغة الانجليزية", "مشرفة اللغة الفرنسية",
                    "مشرفة الرياضيات", "مشرفة العلوم", "مشرفة الدراسات");
        } else {
            gCategory.selectToggle(type3);
        }

        if (current.getStaffCategory() != null) {
            tCategory.getSelectionModel().select(current.getStaffCategory());
        }

        if (current.getPId().getPersonalPhoto() != null) {
            PhotoPath.setText(current.getPId().getPersonalPhoto());
        }

        if (current.getPId().getPrevExp() != null) {
            prevEXP.setText(current.getPId().getPrevExp());
        }
        if (current.getPId().getNoOfChildren() != null) {
            noOfChildren.setText(current.getPId().getNoOfChildren().toString());
        }
        if (current.getSerialNo() != null) {
            tSerial.setText(current.getSerialNo());
        }
        if (tempCon.size() > 0) {
            tempCon.clear();
        }
        tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());

        ContactsTable.setItems(tempCon);
        NameColumn.setCellValueFactory(cellData -> cellData.getValue()
                .NameProperty());
        NumColumn.setCellValueFactory(cellData -> cellData.getValue()
                .ConDeatailsProperty());

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

        tQual.setText(current.getPId().getQualification());

        if (LoginSec.getLoggedUser().getPermission().equals("2")) {
            salary.setVisible(true);
            tSalary.setText(String.valueOf(current.getMonthlySalary()));
        }
        gCategory.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle.getUserData().equals("إداري")) {
                tCategory.getItems().removeAll(tCategory.getItems());
                tCategory.getItems().addAll(
                        "رئيس قسم سكرتارية", "سكرتيرة", "ضابطة", "ضابطة أولى", "وكيلة شئون مالية",
                        "وكيلة شئون ادارية", "وكيلة شئون ادارية ومالية", "مشرفة دور", "مشرفة باص",
                        "مشرفة مقصف", "مشرفة باص و مقصف", "مسئولة سينما", "ألعاب",
                        "مجالات", "مسئولة الكمبيوتر", "اخصائية اجتماعية");
            } else if (newToggle.getUserData().equals("فني")) {
                tCategory.getItems().removeAll(tCategory.getItems());
                tCategory.getItems().addAll("ناظرة", "مساعد قائد", "وكيلة فنية", "مديرة متابعة فنية",
                        "مشرفة اللغة العربية", "مشرفة اللغة الانجليزية", "مشرفة اللغة الفرنسية",
                        "مشرفة الرياضيات", "مشرفة العلوم", "مشرفة الدراسات");
            } else {
                tCategory.getItems().removeAll(tCategory.getItems());
            }
        });
    }

    @FXML
    public void handlePhoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(defaultDirectory);
        List<String> extensions = Arrays.asList("JPG", "JPEG", "PNG");
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Images", extensions));
        File selectedFile = fileChooser.showOpenDialog(MA.getDialogStage());
        if (selectedFile != null) {
            PhotoPath.setText(selectedFile.getAbsolutePath());
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

                if (tQual.getText() != null) {
                    current.getPId().setQualification(tQual.getText());
                }

                if (!spouseName.getText().equals("")) {
                    current.getPId().setSpouseName(spouseName.getText());
                }
                if (!spouseJob.getText().equals("")) {
                    current.getPId().setSpouseParentOccupation(spouseJob.getText());
                }
                if (!noOfChildren.getText().equals("")) {
                    current.getPId().setNoOfChildren(Integer.valueOf(noOfChildren.getText()));
                }
                if (!prevEXP.getText().equals("")) {
                    current.getPId().setPrevExp(prevEXP.getText());
                }
                if (!PhotoPath.getText().equals("")) {
                    current.getPId().setPersonalPhoto(PhotoPath.getText());
                }
                if (!InsuranceAmount.getText().equals("")) {
                    current.getPId().setInsuranceAmount(Double.parseDouble(InsuranceAmount.getText()));
                }
                if (!InsuranceNo.getText().equals("")) {
                    current.getPId().setInsuranceNo(InsuranceNo.getText());
                }
                if (gCategory.getSelectedToggle().getUserData().toString().equals("إداري")) {
                    current.setStaffType("1");
                } else if (gCategory.getSelectedToggle().getUserData().toString().equals("فني")) {
                    current.setStaffType("2");
                } else {
                    current.setStaffType("3");
                }

                if (!"3".equals(current.getStaffType())) {
                    current.setStaffCategory(tCategory.getSelectionModel().getSelectedItem().toString());
                } else {
                    current.setStaffCategory("");
                }

                if (gStatus.getSelectedToggle().getUserData().toString().equals("يعمل")) {
                    current.setStatus("1");
                } else {
                    current.setStatus("2");
                }

                current.setSerialNo(tSerial.getText());

                if (!tSalary.getText().isEmpty()) {
                    current.setMonthlySalary(Double.valueOf(tSalary.getText()));
                }
                MA.UpdateTeacher(current, tempCon);
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
        Management.getDialogStage2().close();
    }

    @FXML
    public void handleAddCont() {
        Management.setC(new Contacts());
        MA.newCon();
        tempCon.add(Management.getContacts());
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
    }

    @FXML
    public void handleDeleteSub() {
    }
}
