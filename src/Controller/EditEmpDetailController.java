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
import java.time.Month;
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
 import javafx.scene.control.TextArea;
 import javafx.scene.control.TextField;
 import javafx.scene.control.Toggle;
 import javafx.scene.control.ToggleGroup;
 import javafx.scene.layout.HBox;
 import javafx.stage.FileChooser;
 
 
 
 
 
 
 
 
 
 public class EditEmpDetailController
   implements Initializable
 {
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
/* 132 */   final File defaultDirectory = new File("C:\\");
   
   private static Staff current;
/* 135 */   static ObservableList<Contacts> tempCon = FXCollections.observableArrayList();
 
 
 
 
 
 
 
 
 
   
   public void initialize(URL url, ResourceBundle rb) {
/* 147 */     this.t1.setUserData("ذكر");
/* 148 */     this.t2.setUserData("انثى");
/* 149 */     this.r1.setUserData("مسلم");
/* 150 */     this.r2.setUserData("مسيحي");
/* 151 */     this.s1.setUserData("يعمل");
/* 152 */     this.s2.setUserData("لا يعمل");
/* 153 */     this.soc1.setUserData("مطلق");
/* 154 */     this.soc2.setUserData("أرمل");
/* 155 */     this.soc3.setUserData("أعزب");
/* 156 */     this.soc4.setUserData("متزوج");
/* 157 */     this.type1.setUserData("إداري");
/* 158 */     this.type2.setUserData("فني");
/* 159 */     this.type3.setUserData("عمال و سائقين");
     
/* 161 */     this.MA = new Management();
/* 162 */     current = Management.getEdit();
     
/* 164 */     if (current.getPId().getGender().equals("1")) {
/* 165 */       this.gType.selectToggle(this.t1);
     } else {
/* 167 */       this.gType.selectToggle(this.t2);
     } 
     
/* 170 */     if (current.getStatus().equals("1")) {
/* 171 */       this.gStatus.selectToggle(this.s1);
     } else {
/* 173 */       this.gStatus.selectToggle(this.s2);
     } 
     
/* 176 */     if (current.getPId().getMaritalStatus().equals("1")) {
/* 177 */       this.gSocial.selectToggle(this.soc1);
/* 178 */     } else if (current.getPId().getMaritalStatus().equals("2")) {
/* 179 */       this.gSocial.selectToggle(this.soc2);
/* 180 */     } else if (current.getPId().getMaritalStatus().equals("3")) {
/* 181 */       this.gSocial.selectToggle(this.soc3);
     } else {
/* 183 */       this.gSocial.selectToggle(this.soc4);
     } 
     
/* 186 */     if (current.getPId().getReligion().equals("1")) {
/* 187 */       this.gReligion.selectToggle(this.r1);
     } else {
/* 189 */       this.gReligion.selectToggle(this.r2);
     } 
     
/* 192 */     this.tNationality.getItems().removeAll(this.tNationality.getItems());
/* 193 */     this.tNationality.getItems().addAll(new Object[] { "EGY", "SAU", "OMN", "BHR", "KWT", "UAE", "JOR", "PSE", "LBR" });
     
/* 195 */     this.tNationality.getSelectionModel().select(current.getPId().getNationality());
     
/* 197 */     if (current.getPId().getSpouseName() != null) {
/* 198 */       this.spouseName.setText(current.getPId().getSpouseName());
     }
/* 200 */     if (current.getPId().getSpouseParentOccupation() != null) {
/* 201 */       this.spouseJob.setText(current.getPId().getSpouseParentOccupation());
     }
/* 203 */     if (current.getPId().getInsuranceNo() != null) {
/* 204 */       this.InsuranceNo.setText(current.getPId().getInsuranceNo());
     }
/* 206 */     if (current.getPId().getInsuranceAmount() != null) {
/* 207 */       this.InsuranceAmount.setText(current.getPId().getInsuranceAmount().toString());
     }

                if (current.getPId().getGradYear() != null){
//                    Calendar c = Calendar.getInstance();
//                    c.set(Integer.parseInt(current.getPId().getGradYear()), 7, 1);
                    this.tGradDate.setValue(LocalDate.of(Integer.parseInt(current.getPId().getGradYear()), Month.JUNE, 1));
                }
     
/* 210 */     if (current.getStaffType().equals("1")) {
/* 211 */       this.gCategory.selectToggle(this.type1);
/* 212 */       this.tCategory.getItems().removeAll(this.tCategory.getItems());
/* 213 */       this.tCategory.getItems().addAll(new Object[] { "رئيس قسم سكرتارية", "سكرتيرة", "ضابطة", "ضابطة أولى", "وكيلة شئون مالية", "وكيلة شئون ادارية", "وكيلة شئون ادارية ومالية", "مشرفة دور", "مشرفة باص", "مشرفة مقصف", "مشرفة باص و مقصف", "مسئولة سينما", "ألعاب", "مجالات", "مسئولة الكمبيوتر", "اخصائية اجتماعية" });
 
 
     
     }
/* 218 */     else if (current.getStaffType().equals("2")) {
/* 219 */       this.gCategory.selectToggle(this.type2);
/* 220 */       this.tCategory.getItems().removeAll(this.tCategory.getItems());
/* 221 */       this.tCategory.getItems().addAll(new Object[] { "ناظرة", "مساعد قائد", "وكيلة فنية", "مديرة متابعة فنية", "مشرفة اللغة العربية", "مشرفة اللغة الانجليزية", "مشرفة اللغة الفرنسية", "مشرفة الرياضيات", "مشرفة العلوم", "مشرفة الدراسات" });
     }
     else {
       
/* 225 */       this.gCategory.selectToggle(this.type3);
     } 
     
/* 228 */     if (current.getStaffCategory() != null) {
/* 229 */       this.tCategory.getSelectionModel().select(current.getStaffCategory());
     }
     
/* 232 */     if (current.getPId().getPersonalPhoto() != null) {
/* 233 */       this.PhotoPath.setText(current.getPId().getPersonalPhoto());
     }
     
/* 236 */     if (current.getPId().getPrevExp() != null) {
/* 237 */       this.prevEXP.setText(current.getPId().getPrevExp());
     }
/* 239 */     if (current.getPId().getNoOfChildren() != null) {
/* 240 */       this.noOfChildren.setText(current.getPId().getNoOfChildren().toString());
     }
/* 242 */     if (current.getSerialNo() != null) {
/* 243 */       this.tSerial.setText(current.getSerialNo());
     }
/* 245 */     if (tempCon.size() > 0) {
/* 246 */       tempCon.clear();
     }
/* 248 */     tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());
     
/* 250 */     this.ContactsTable.setItems(tempCon);
/* 251 */     this.NameColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue())
/* 252 */         .NameProperty());
/* 253 */     this.NumColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue())
/* 254 */         .ConDeatailsProperty());
     
/* 256 */     Calendar cal = Calendar.getInstance();
/* 257 */     cal.setTime(current.getPId().getHiringDate());
/* 258 */     LocalDate date = LocalDate.of(cal.get(1), cal
/* 259 */         .get(2) + 1, cal.get(5));
/* 260 */     this.tSignDate.setValue(date);
     
/* 262 */     cal = Calendar.getInstance();
/* 263 */     cal.setTime(current.getPId().getDob());
/* 264 */     date = LocalDate.of(cal.get(1), cal
/* 265 */         .get(2) + 1, cal.get(5));
/* 266 */     this.tDOB.setValue(date);
/* 267 */     this.tName.setText(current.getPId().getName());
/* 268 */     this.tNatNo.setText(current.getPId().getNationalId());
/* 269 */     this.tAddress.setText(current.getPId().getAddress());
     
/* 271 */     this.tQual.setText(current.getPId().getQualification());
     
/* 273 */     if (LoginSec.getLoggedUser().getPermission().equals("2")) {
/* 274 */       this.salary.setVisible(true);
/* 275 */       this.tSalary.setText(String.valueOf(current.getMonthlySalary()));
     } 
/* 277 */     this.gCategory.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
/* 278 */           if (newToggle.getUserData().equals("إداري")) {
/* 279 */             this.tCategory.getItems().removeAll(this.tCategory.getItems());
/* 280 */             this.tCategory.getItems().addAll(new Object[] { "رئيس قسم سكرتارية", "سكرتيرة", "ضابطة", "ضابطة أولى", "وكيلة شئون مالية", "وكيلة شئون ادارية", "وكيلة شئون ادارية ومالية", "مشرفة دور", "مشرفة باص", "مشرفة مقصف", "مشرفة باص و مقصف", "مسئولة سينما", "ألعاب", "مجالات", "مسئولة الكمبيوتر", "اخصائية اجتماعية" });
 
 
           
           }
/* 285 */           else if (newToggle.getUserData().equals("فني")) {
/* 286 */             this.tCategory.getItems().removeAll(this.tCategory.getItems());
/* 287 */             this.tCategory.getItems().addAll(new Object[] { "ناظرة", "مساعد قائد", "وكيلة فنية", "مديرة متابعة فنية", "مشرفة اللغة العربية", "مشرفة اللغة الانجليزية", "مشرفة اللغة الفرنسية", "مشرفة الرياضيات", "مشرفة العلوم", "مشرفة الدراسات" });
           }
           else {
             
/* 291 */             this.tCategory.getItems().removeAll(this.tCategory.getItems());
           } 
         });
   }
   
   @FXML
   public void handlePhoto() {
/* 298 */     FileChooser fileChooser = new FileChooser();
/* 299 */     fileChooser.setInitialDirectory(this.defaultDirectory);
/* 300 */     List<String> extensions = Arrays.asList(new String[] { "JPG", "JPEG", "PNG" });
/* 301 */     fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Images", extensions));
/* 302 */     File selectedFile = fileChooser.showOpenDialog(this.MA.getDialogStage());
/* 303 */     if (selectedFile != null) {
/* 304 */       this.PhotoPath.setText(selectedFile.getAbsolutePath());
     }
   }
   
   @FXML
   public void handleSave() {
/* 310 */     if (!this.tName.getText().equals("") || this.tNationality.getSelectionModel().isEmpty() || 
/* 311 */       !this.tNatNo.getText().equals("") || !this.tNatNo.getText().matches("[0-9]+") || 
/* 312 */       !this.tAddress.getText().equals("") || this.tDOB.getValue() != null || this.tSignDate
/* 313 */       .getValue() != null) {
       try {
/* 315 */         current.getPId().setName(this.tName.getText());
/* 316 */         if (this.gType.getSelectedToggle().getUserData().toString().equals("ذكر")) {
/* 317 */           current.getPId().setGender("1");
         } else {
/* 319 */           current.getPId().setGender("2");
         } 
/* 321 */         current.getPId().setNationality(this.tNationality.getSelectionModel().getSelectedItem().toString());
/* 322 */         if (this.gReligion.getSelectedToggle().getUserData().toString().equals("مسلم")) {
/* 323 */           current.getPId().setReligion("1");
         } else {
/* 325 */           current.getPId().setReligion("2");
         } 
         
/* 328 */         if (this.gSocial.getSelectedToggle().getUserData().toString().equals("مطلق")) {
/* 329 */           current.getPId().setMaritalStatus("1");
/* 330 */         } else if (this.gSocial.getSelectedToggle().getUserData().toString().equals("أرمل")) {
/* 331 */           current.getPId().setMaritalStatus("2");
/* 332 */         } else if (this.gSocial.getSelectedToggle().getUserData().toString().equals("أعزب")) {
/* 333 */           current.getPId().setMaritalStatus("3");
         } else {
/* 335 */           current.getPId().setMaritalStatus("4");
         } 
/* 337 */         current.getPId().setNationalId(this.tNatNo.getText());
/* 338 */         current.getPId().setAddress(this.tAddress.getText());
/* 339 */         current.getPId().setDob(Date.valueOf((LocalDate)this.tDOB.getValue()));
/* 340 */         current.getPId().setCreatedDate(Date.valueOf(LocalDate.now()));
/* 341 */         current.getPId().setHiringDate(Date.valueOf((LocalDate)this.tSignDate.getValue()));
         
/* 343 */         if (this.tGradDate.getValue() != null) {
/* 344 */           LocalDate localDate = (LocalDate)this.tGradDate.getValue();
/* 345 */           current.getPId().setGradYear(String.valueOf(localDate.getYear()));
         } 
         
/* 348 */         if (this.tQual.getText() != null) {
/* 349 */           current.getPId().setQualification(this.tQual.getText());
         }
         
/* 352 */         if (!this.spouseName.getText().equals("")) {
/* 353 */           current.getPId().setSpouseName(this.spouseName.getText());
         }
/* 355 */         if (!this.spouseJob.getText().equals("")) {
/* 356 */           current.getPId().setSpouseParentOccupation(this.spouseJob.getText());
         }
/* 358 */         if (!this.noOfChildren.getText().equals("")) {
/* 359 */           current.getPId().setNoOfChildren(Integer.valueOf(this.noOfChildren.getText()));
         }
/* 361 */         if (!this.prevEXP.getText().equals("")) {
/* 362 */           current.getPId().setPrevExp(this.prevEXP.getText());
         }
/* 364 */         if (!this.PhotoPath.getText().equals("")) {
/* 365 */           current.getPId().setPersonalPhoto(this.PhotoPath.getText());
         }
/* 367 */         if (!this.InsuranceAmount.getText().equals("")) {
/* 368 */           current.getPId().setInsuranceAmount(Double.valueOf(Double.parseDouble(this.InsuranceAmount.getText())));
         }
/* 370 */         if (!this.InsuranceNo.getText().equals("")) {
/* 371 */           current.getPId().setInsuranceNo(this.InsuranceNo.getText());
         }
/* 373 */         if (this.gCategory.getSelectedToggle().getUserData().toString().equals("إداري")) {
/* 374 */           current.setStaffType("1");
/* 375 */         } else if (this.gCategory.getSelectedToggle().getUserData().toString().equals("فني")) {
/* 376 */           current.setStaffType("2");
         } else {
/* 378 */           current.setStaffType("3");
         } 
         
/* 381 */         if (!"3".equals(current.getStaffType())) {
/* 382 */           current.setStaffCategory(this.tCategory.getSelectionModel().getSelectedItem().toString());
         } else {
/* 384 */           current.setStaffCategory("");
         } 
         
/* 387 */         if (this.gStatus.getSelectedToggle().getUserData().toString().equals("يعمل")) {
/* 388 */           current.setStatus("1");
         } else {
/* 390 */           current.setStatus("2");
         } 
         
/* 393 */         current.setSerialNo(this.tSerial.getText());
         
/* 395 */         if (!this.tSalary.getText().isEmpty()) {
/* 396 */           current.setMonthlySalary(Double.valueOf(this.tSalary.getText()));
         }
/* 398 */         this.MA.UpdateTeacher(current, tempCon);
/* 399 */       } catch (Exception e) {
/* 400 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 401 */         alert.setTitle("يوجد خطأ");
/* 402 */         alert.setHeaderText("خطأ");
/* 403 */         alert.setContentText("برجاء مراجعة مالك البرنامج");
/* 404 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 405 */         System.out.println("error " + e.getLocalizedMessage());
/* 406 */         alert.showAndWait();
/* 407 */         throw e;
       } 
     } else {
/* 410 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 411 */       alert.setTitle("يوجد خطأ");
/* 412 */       alert.setHeaderText("خطأ");
/* 413 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 414 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 415 */       alert.showAndWait();
     } 
   }
 
   
   @FXML
/* 421 */   public void handleClose() { Management.getDialogStage2().close(); }
 
   
   @FXML
   public void handleAddCont() {
/* 426 */     Management.setC(new Contacts());
/* 427 */     this.MA.newCon();
/* 428 */     tempCon.add(Management.getContacts());
   }
   
   @FXML
   public void handleDeleteCont() {
/* 433 */     if (this.ContactsTable.getSelectionModel().getSelectedIndex() >= 0) {
/* 434 */       this.ContactsTable.getItems().remove(this.ContactsTable.getSelectionModel().getSelectedIndex());
     } else {
/* 436 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 437 */       alert.setTitle("يوجد خطأ");
/* 438 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
/* 439 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 440 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 441 */       alert.showAndWait();
     } 
   }
   
   @FXML
   public void handleAddSub() {}
   
   @FXML
   public void handleDeleteSub() {}
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EditEmpDetailController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */