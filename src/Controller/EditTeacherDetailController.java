 package Controller;


  import Entity.Contacts;
 import Entity.Subjects;
 import Entity.Teacher;
 import Entity.TeacherSubjects;
 import Util.LoginSec;
 import amgad.h.TeachingStaff;
 import java.io.File;
 import java.net.URL;
 import java.sql.Date;
 import java.time.LocalDate;
import java.time.Month;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.Calendar;
 import java.util.List;
 import java.util.ResourceBundle;
 import javafx.beans.value.ObservableValue;
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
 import javafx.scene.layout.HBox;
 import javafx.stage.FileChooser;


 
 
 
 
 
 
 
 
 
 
  public class EditTeacherDetailController
         implements Initializable  {

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
     TextField InsuranceNo;
        @FXML
     TextField InsuranceAmount;
        @FXML
     private TextField tSerial;
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
        @FXML
     private TableColumn<Subjects, String> SyNameColumn;
        @FXML
     private Label PhotoPath;
    /* 117 */    final File defaultDirectory = new File("C:\\");
    
     TeachingStaff TA;
    
     private static Teacher current;
    /* 122 */    static ObservableList<Contacts> tempCon = FXCollections.observableArrayList();
    /* 123 */    static ObservableList<Subjects> tempSub = FXCollections.observableArrayList();

    
 
 
 
 
 
 
 
 
  public void initialize(URL url, ResourceBundle rb) {
        /* 134 */ this.t1.setUserData("ذكر");
        /* 135 */ this.t2.setUserData("انثى");
        /* 136 */ this.r1.setUserData("مسلم");
        /* 137 */ this.r2.setUserData("مسيحي");
        /* 138 */ this.s1.setUserData("يعمل");
        /* 139 */ this.s2.setUserData("لا يعمل");
        /* 140 */ this.soc1.setUserData("مطلق");
        /* 141 */ this.soc2.setUserData("أرمل");
        /* 142 */ this.soc3.setUserData("أعزب");
        /* 143 */ this.soc4.setUserData("متزوج");
        
 /* 145 */ this.TA = new TeachingStaff();
        /* 146 */ current = TeachingStaff.getEdit();
        
 /* 148 */ if (current.getPId().getGender().equals("1")) {
            /* 149 */ this.gType.selectToggle(this.t1);
                    } else {
            /* 151 */ this.gType.selectToggle(this.t2);
                    }
        
 /* 154 */ if (current.getStatus().equals("1")) {
            /* 155 */ this.gStatus.selectToggle(this.s1);
                    } else {
            /* 157 */ this.gStatus.selectToggle(this.s2);
                    }
        
 /* 160 */ if (current.getPId().getMaritalStatus().equals("1")) {
            /* 161 */ this.gSocial.selectToggle(this.soc1);
            /* 162 */        } else if (current.getPId().getMaritalStatus().equals("2")) {
            /* 163 */ this.gSocial.selectToggle(this.soc2);
            /* 164 */        } else if (current.getPId().getMaritalStatus().equals("3")) {
            /* 165 */ this.gSocial.selectToggle(this.soc3);
                    } else {
            /* 167 */ this.gSocial.selectToggle(this.soc4);
                    }
        
 /* 170 */ if (current.getPId().getGender().equals("1")) {
            /* 171 */ this.gType.selectToggle(this.t1);
                    } else {
            /* 173 */ this.gType.selectToggle(this.t2);
                    }
        
 /* 176 */ if (current.getPId().getReligion().equals("1")) {
            /* 177 */ this.gReligion.selectToggle(this.r1);
                    } else {
            /* 179 */ this.gReligion.selectToggle(this.r2);
                    }
        
 /* 182 */ current.getPId().setPersonalPhoto(this.PhotoPath.getText());
        /* 183 */ this.tNationality.getItems().removeAll(this.tNationality.getItems());
        /* 184 */ this.tNationality.getItems().addAll(new Object[]{"EGY", "SAU", "OMN", "BHR", "KWT", "UAE", "JOR", "PSE", "LBR"});
        
 /* 186 */ this.tNationality.getSelectionModel().select(current.getPId().getNationality());
        
 /* 188 */ if (tempCon.size() > 0) {
            /* 189 */ tempCon.clear();
                    }
        /* 191 */ tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());
        /* 192 */ List<Subjects> TeSubList = new ArrayList<Subjects>();
        /* 193 */ for (TeacherSubjects sub : current.getTeacherSubjectsList()) {
            /* 194 */ TeSubList.add(sub.getSuId());
                    }
        /* 196 */ tempSub = FXCollections.observableArrayList(TeSubList);
        
 /* 198 */ this.ContactsTable.setItems(tempCon);
        /* 199 */ this.NameColumn.setCellValueFactory(cellData -> ((Contacts) cellData.getValue())
                /* 200 */.NameProperty());
        /* 201 */ this.NumColumn.setCellValueFactory(cellData -> ((Contacts) cellData.getValue())
                /* 202 */.ConDeatailsProperty());
        
 /* 204 */ this.SubjectsTable.setItems(tempSub);
        /* 205 */ this.SubjectNameColumn.setCellValueFactory(cellData -> ((Subjects) cellData.getValue())
                /* 206 */.SubDescProperty());
        /* 207 */ this.SyNameColumn.setCellValueFactory(cellData -> ((Subjects) cellData.getValue())
                /* 208 */.SyDescProperty());
        
 /* 210 */ Calendar cal = Calendar.getInstance();
        /* 211 */ cal.setTime(current.getPId().getHiringDate());
        /* 212 */ LocalDate date = LocalDate.of(cal.get(1), cal
                /* 213 */.get(2) + 1, cal.get(5));
        /* 214 */ this.tSignDate.setValue(date);
        
 /* 216 */ cal = Calendar.getInstance();
        /* 217 */ cal.setTime(current.getPId().getDob());
        /* 218 */ date = LocalDate.of(cal.get(1), cal
                /* 219 */.get(2) + 1, cal.get(5));
        /* 220 */ this.tDOB.setValue(date);
        /* 221 */ this.tName.setText(current.getPId().getName());
        /* 222 */ this.tNatNo.setText(current.getPId().getNationalId());
        /* 223 */ this.tAddress.setText(current.getPId().getAddress());

        if (current.getPId().getGradYear() != null) {
//                    Calendar c = Calendar.getInstance();
//                    c.set(Integer.parseInt(current.getPId().getGradYear()), 7, 1);
            this.tGradDate.setValue(LocalDate.of(Integer.parseInt(current.getPId().getGradYear()), Month.JUNE, 1));
        }
        
 /* 225 */ if (current.getPId().getInsuranceNo() != null) {
            /* 226 */ this.InsuranceNo.setText(current.getPId().getInsuranceNo());
                    }
        /* 228 */ if (current.getPId().getInsuranceAmount() != null) {
            /* 229 */ this.InsuranceAmount.setText(current.getPId().getInsuranceAmount().toString());
                    }
        
 /* 232 */ if (current.getPId().getQualification() != null) {
            /* 233 */ this.tQual.setText(current.getPId().getQualification());
                    }
        
 /* 236 */ if (LoginSec.getLoggedUser().getPermission().equals("2")) {
            /* 237 */ this.salary.setVisible(true);
            /* 238 */ if (current.getMonthlySalary() != null) {
                /* 239 */ this.tSalary.setText(current.getMonthlySalary().toString());
                            }
            /* 241 */ System.out.println("Salary " + current.getMonthlySalary());
                    }
            }

    
 
  @FXML
     public void handlePhoto() {
        /* 248 */ FileChooser fileChooser = new FileChooser();
        /* 249 */ fileChooser.setInitialDirectory(this.defaultDirectory);
        /* 250 */ List<String> extensions = Arrays.asList(new String[]{"JPG", "JPEG", "PNG"});
        /* 251 */ fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Images", extensions));
        /* 252 */ File selectedFile = fileChooser.showOpenDialog(this.TA.getDialogStage());
        /* 253 */ if (selectedFile != null) {
            /* 254 */ this.PhotoPath.setText(selectedFile.getAbsolutePath());
                    }
            }

    
  @FXML
     public void handleSave() {
        /* 260 */ if (!this.tName.getText().equals("") || this.tNationality.getSelectionModel().isEmpty()
                || /* 261 */ !this.tNatNo.getText().equals("") || !this.tNatNo.getText().matches("[0-9]+")
                || /* 262 */ !this.tAddress.getText().equals("") || this.tDOB.getValue() != null || this.tSignDate
                /* 263 */.getValue() != null) {
             try {
                /* 265 */ current.getPId().setName(this.tName.getText());
                /* 266 */ if (this.gType.getSelectedToggle().getUserData().toString().equals("ذكر")) {
                    /* 267 */ current.getPId().setGender("1");
                                    } else {
                    /* 269 */ current.getPId().setGender("2");
                                    }
                /* 271 */ current.getPId().setNationality(this.tNationality.getSelectionModel().getSelectedItem().toString());
                /* 272 */ if (this.gReligion.getSelectedToggle().getUserData().toString().equals("مسلم")) {
                    /* 273 */ current.getPId().setReligion("1");
                                    } else {
                    /* 275 */ current.getPId().setReligion("2");
                                    }
                
 /* 278 */ if (this.gSocial.getSelectedToggle().getUserData().toString().equals("مطلق")) {
                    /* 279 */ current.getPId().setMaritalStatus("1");
                    /* 280 */                } else if (this.gSocial.getSelectedToggle().getUserData().toString().equals("أرمل")) {
                    /* 281 */ current.getPId().setMaritalStatus("2");
                    /* 282 */                } else if (this.gSocial.getSelectedToggle().getUserData().toString().equals("أعزب")) {
                    /* 283 */ current.getPId().setMaritalStatus("3");
                                    } else {
                    /* 285 */ current.getPId().setMaritalStatus("4");
                                    }
                /* 287 */ current.getPId().setNationalId(this.tNatNo.getText());
                /* 288 */ current.getPId().setAddress(this.tAddress.getText());
                /* 289 */ current.getPId().setDob(Date.valueOf((LocalDate) this.tDOB.getValue()));
                /* 290 */ current.getPId().setCreatedDate(Date.valueOf(LocalDate.now()));
                /* 291 */ current.getPId().setHiringDate(Date.valueOf((LocalDate) this.tSignDate.getValue()));
                
 /* 293 */ if (!this.InsuranceAmount.getText().equals("")) {
                    /* 294 */ current.getPId().setInsuranceAmount(Double.valueOf(Double.parseDouble(this.InsuranceAmount.getText())));
                                    }
                /* 296 */ if (!this.InsuranceNo.getText().equals("")) {
                    /* 297 */ current.getPId().setInsuranceNo(this.InsuranceNo.getText());
                                    }
                /* 299 */ if (current.getSerialNo() != null) {
                    /* 300 */ this.tSerial.setText(current.getSerialNo());
                                    }
                /* 302 */ if (this.tGradDate.getValue() != null) {
                    /* 303 */ LocalDate localDate = (LocalDate) this.tGradDate.getValue();
                    /* 304 */ current.getPId().setGradYear(String.valueOf(localDate.getYear()));
                                    }
                
 /* 307 */ if (!this.tQual.getText().equals("")) {
                    /* 308 */ current.getPId().setQualification(this.tQual.getText());
                                    }
                
 /* 311 */ if (this.gStatus.getSelectedToggle().getUserData().toString().equals("يعمل")) {
                    /* 312 */ current.setStatus("1");
                                    } else {
                    /* 314 */ current.setStatus("2");
                                    }
                
 /* 317 */ if (!this.tSalary.getText().isEmpty()) {
                    /* 318 */ current.setMonthlySalary(Double.valueOf(this.tSalary.getText()));
                                    }
                /* 320 */ this.TA.UpdateTeacher(current, tempCon, tempSub);
                /* 321 */            } catch (Exception e) {
                /* 322 */ Alert alert = new Alert(Alert.AlertType.ERROR);
                /* 323 */ alert.setTitle("يوجد خطأ");
                /* 324 */ alert.setHeaderText("خطأ");
                /* 325 */ alert.setContentText("برجاء مراجعة مالك البرنامج");
                /* 326 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                /* 327 */ System.out.println("error " + e.getLocalizedMessage());
                /* 328 */ alert.showAndWait();
                /* 329 */ throw e;
                            }
                    } else {
            /* 332 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 333 */ alert.setTitle("يوجد خطأ");
            /* 334 */ alert.setHeaderText("خطأ");
            /* 335 */ alert.setContentText("برجاء التأكد من صحة البيانات");
            /* 336 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 337 */ alert.showAndWait();
                    }
            }

    
 
  @FXML
    /* 343 */ public void handleClose() {
        TeachingStaff.getDialogStage2().close();
    }

    
 
  @FXML
     public void handleAddCont() {
        /* 348 */ TeachingStaff.setC(new Contacts());
        /* 349 */ this.TA.newCon();
        /* 350 */ tempCon.add(TeachingStaff.getContacts());
            }

    
  @FXML
     public void handleDeleteCont() {
        /* 355 */ if (this.ContactsTable.getSelectionModel().getSelectedIndex() >= 0) {
            /* 356 */ this.ContactsTable.getItems().remove(this.ContactsTable.getSelectionModel().getSelectedIndex());
                    } else {
            /* 358 */ Alert alert = new Alert(Alert.AlertType.WARNING);
            /* 359 */ alert.setTitle("يوجد خطأ");
            /* 360 */ alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
            /* 361 */ alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            /* 362 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 363 */ alert.showAndWait();
                    }
            }

    
  @FXML
     public void handleAddSub() {
        /* 369 */ TeachingStaff.setS(new TeacherSubjects());
        /* 370 */ this.TA.newSub();
        /* 371 */ this.TA.getTss().add(TeachingStaff.getS());
        /* 372 */ tempSub.add(TeachingStaff.getS().getSuId());
            }

    
  @FXML
     public void handleDeleteSub() {
        /* 377 */ if (this.SubjectsTable.getSelectionModel().getSelectedIndex() >= 0) {
            /* 378 */ this.SubjectsTable.getItems().remove(this.SubjectsTable.getSelectionModel().getSelectedIndex());
                    } else {
            /* 380 */ Alert alert = new Alert(Alert.AlertType.WARNING);
            /* 381 */ alert.setTitle("يوجد خطأ");
            /* 382 */ alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
            /* 383 */ alert.setContentText("من فضلك قم بتحديد العنصر من جدول المواد");
            /* 384 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 385 */ alert.showAndWait();
                    }
            }
     }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EditTeacherDetailController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */
