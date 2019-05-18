/*     */ package Controller;
/*     */ 
/*     */ import Entity.Contacts;
/*     */ import Entity.Persons;
/*     */ import Entity.Subjects;
/*     */ import Entity.Teacher;
/*     */ import Entity.TeacherSubjects;
/*     */ import Util.LoginSec;
/*     */ import amgad.h.TeachingStaff;
/*     */ import java.io.File;
/*     */ import java.net.URL;
/*     */ import java.sql.Date;
/*     */ import java.time.LocalDate;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.ResourceBundle;
/*     */ import javafx.beans.value.ObservableValue;
/*     */ import javafx.fxml.FXML;
/*     */ import javafx.fxml.Initializable;
/*     */ import javafx.geometry.NodeOrientation;
/*     */ import javafx.scene.control.Alert;
/*     */ import javafx.scene.control.ComboBox;
/*     */ import javafx.scene.control.DatePicker;
/*     */ import javafx.scene.control.Label;
/*     */ import javafx.scene.control.RadioButton;
/*     */ import javafx.scene.control.TableColumn;
/*     */ import javafx.scene.control.TableView;
/*     */ import javafx.scene.control.TextArea;
/*     */ import javafx.scene.control.TextField;
/*     */ import javafx.scene.control.ToggleGroup;
/*     */ import javafx.scene.layout.HBox;
/*     */ import javafx.stage.FileChooser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RegisterTeacherController
/*     */   implements Initializable
/*     */ {
/*     */   @FXML
/*     */   TextField tSerial;
/*     */   @FXML
/*     */   DatePicker tSignDate;
/*     */   @FXML
/*     */   TextField tSalary;
/*     */   @FXML
/*     */   TextField tQual;
/*     */   @FXML
/*     */   TextField spouseName;
/*     */   @FXML
/*     */   TextField spouseJob;
/*     */   @FXML
/*     */   TextField noOfChildren;
/*     */   @FXML
/*     */   TextArea prevEXP;
/*     */   @FXML
/*     */   ComboBox tNationality;
/*     */   @FXML
/*     */   TextField tNatNo;
/*     */   @FXML
/*     */   TextField tName;
/*     */   @FXML
/*     */   DatePicker tGradDate;
/*     */   @FXML
/*     */   DatePicker tDOB;
/*     */   @FXML
/*     */   TextField tAddress;
/*     */   @FXML
/*     */   RadioButton t2;
/*     */   @FXML
/*     */   RadioButton t1;
/*     */   @FXML
/*     */   RadioButton soc1;
/*     */   @FXML
/*     */   RadioButton soc2;
/*     */   @FXML
/*     */   RadioButton soc3;
/*     */   @FXML
/*     */   RadioButton soc4;
/*     */   @FXML
/*     */   RadioButton s1;
/*     */   @FXML
/*     */   RadioButton s2;
/*     */   @FXML
/*     */   RadioButton r2;
/*     */   @FXML
/*     */   RadioButton r1;
/*     */   @FXML
/*     */   HBox salary;
/*     */   @FXML
/*     */   ToggleGroup gType;
/*     */   @FXML
/*     */   ToggleGroup gStatus;
/*     */   @FXML
/*     */   ToggleGroup gSocial;
/*     */   @FXML
/*     */   ToggleGroup gReligion;
/*     */   @FXML
/*     */   private TableView<Contacts> ContactsTable;
/*     */   @FXML
/*     */   private TableColumn<Contacts, String> NameColumn;
/*     */   @FXML
/*     */   private TableColumn<Contacts, String> NumColumn;
/*     */   @FXML
/*     */   private TableView<Subjects> SubjectsTable;
/*     */   @FXML
/*     */   private TableColumn<Subjects, String> SubjectNameColumn;
/*     */   @FXML
/*     */   private TableColumn<Subjects, String> SyNameColumn;
/*     */   @FXML
/*     */   private Label PhotoPath;
/*     */   @FXML
/*     */   TextField InsuranceNo;
/*     */   @FXML
/*     */   TextField InsuranceAmount;
/*     */   TeachingStaff TA;
/*     */   private Persons pers;
/*     */   private Teacher teac;
/* 125 */   final File defaultDirectory = new File("C:\\");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/* 135 */     this.TA = new TeachingStaff();
/* 136 */     this.tNationality.getItems().removeAll(this.tNationality.getItems());
/* 137 */     this.tNationality.getItems().addAll(new Object[] { "EGY", "SAU", "OMN", "BHR", "KWT", "UAE", "JOR", "PSE", "LBR" });
/*     */ 
/*     */     
/* 140 */     this.t1.setUserData("ذكر");
/* 141 */     this.t2.setUserData("انثى");
/* 142 */     this.r1.setUserData("مسلم");
/* 143 */     this.r2.setUserData("مسيحي");
/* 144 */     this.s1.setUserData("يعمل");
/* 145 */     this.s2.setUserData("لا يعمل");
/* 146 */     this.soc1.setUserData("مطلق");
/* 147 */     this.soc2.setUserData("أرمل");
/* 148 */     this.soc3.setUserData("أعزب");
/* 149 */     this.soc4.setUserData("متزوج");
/*     */     
/* 151 */     this.ContactsTable.setItems(this.TA.getContactsList());
/* 152 */     this.NameColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue())
/* 153 */         .NameProperty());
/* 154 */     this.NumColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue())
/* 155 */         .ConDeatailsProperty());
/*     */     
/* 157 */     this.SubjectsTable.setItems(this.TA.getSubjectsList());
/* 158 */     this.SubjectNameColumn.setCellValueFactory(cellData -> ((Subjects)cellData.getValue())
/* 159 */         .SubDescProperty());
/* 160 */     this.SyNameColumn.setCellValueFactory(cellData -> ((Subjects)cellData.getValue())
/* 161 */         .SyDescProperty());
/*     */     
/* 163 */     if (LoginSec.getLoggedUser().getPermission().equals("2")) {
/* 164 */       this.salary.setVisible(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   public void handlePhoto() {
/* 171 */     FileChooser fileChooser = new FileChooser();
/* 172 */     fileChooser.setInitialDirectory(this.defaultDirectory);
/* 173 */     List<String> extensions = Arrays.asList(new String[] { "JPG", "JPEG", "PNG" });
/* 174 */     fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Images", extensions));
/* 175 */     File selectedFile = fileChooser.showOpenDialog(this.TA.getDialogStage());
/* 176 */     if (selectedFile != null) {
/* 177 */       this.PhotoPath.setText(selectedFile.getAbsolutePath());
/*     */     }
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleSave() {
/* 183 */     this.pers = new Persons();
/* 184 */     this.teac = new Teacher();
/* 185 */     if (!this.tName.getText().equals("") || this.tNationality.getSelectionModel().isEmpty() || 
/* 186 */       !this.tNatNo.getText().equals("") || !this.tNatNo.getText().matches("[0-9]+") || 
/* 187 */       !this.tAddress.getText().equals("") || this.tDOB.getValue() != null) {
/*     */       try {
/* 189 */         this.pers.setName(this.tName.getText());
/* 190 */         if (this.gType.getSelectedToggle().getUserData().toString().equals("ذكر")) {
/* 191 */           this.pers.setGender("1");
/*     */         } else {
/* 193 */           this.pers.setGender("2");
/*     */         } 
/* 195 */         this.pers.setNationality(this.tNationality.getSelectionModel().getSelectedItem().toString());
/* 196 */         if (this.gReligion.getSelectedToggle().getUserData().toString().equals("مسلم")) {
/* 197 */           this.pers.setReligion("1");
/*     */         } else {
/* 199 */           this.pers.setReligion("2");
/*     */         } 
/*     */         
/* 202 */         if (this.gSocial.getSelectedToggle().getUserData().toString().equals("مطلق")) {
/* 203 */           this.pers.setMaritalStatus("1");
/* 204 */         } else if (this.gSocial.getSelectedToggle().getUserData().toString().equals("أرمل")) {
/* 205 */           this.pers.setMaritalStatus("2");
/* 206 */         } else if (this.gSocial.getSelectedToggle().getUserData().toString().equals("أعزب")) {
/* 207 */           this.pers.setMaritalStatus("3");
/*     */         } else {
/* 209 */           this.pers.setMaritalStatus("4");
/*     */         } 
/* 211 */         this.pers.setNationalId(this.tNatNo.getText());
/* 212 */         this.pers.setAddress(this.tAddress.getText());
/* 213 */         this.pers.setDob(Date.valueOf((LocalDate)this.tDOB.getValue()));
/* 214 */         this.pers.setCreatedDate(Date.valueOf(LocalDate.now()));
/* 215 */         this.pers.setHiringDate(Date.valueOf((LocalDate)this.tSignDate.getValue()));
/*     */         
/* 217 */         if (this.tGradDate.getValue() != null) {
/* 218 */           LocalDate localDate = (LocalDate)this.tGradDate.getValue();
/* 219 */           this.pers.setGradYear(String.valueOf(localDate.getYear()));
/*     */         } 
/* 221 */         this.pers.setSpouseName(this.spouseName.getText());
/* 222 */         this.pers.setSpouseParentOccupation(this.spouseJob.getText());
/* 223 */         this.pers.setNoOfChildren(Integer.valueOf(this.noOfChildren.getText()));
/* 224 */         this.pers.setPrevExp(this.prevEXP.getText());
/* 225 */         this.pers.setPersonalPhoto(this.PhotoPath.getText());
/*     */         
/* 227 */         if (!this.tQual.getText().equals("")) {
/* 228 */           this.pers.setQualification(this.tQual.getText());
/*     */         }
/* 230 */         if (!this.InsuranceAmount.getText().equals("")) {
/* 231 */           this.pers.setInsuranceAmount(Double.valueOf(Double.parseDouble(this.InsuranceAmount.getText())));
/*     */         }
/* 233 */         if (!this.InsuranceNo.getText().equals("")) {
/* 234 */           this.pers.setInsuranceNo(this.InsuranceNo.getText());
/*     */         }
/*     */         
/* 237 */         this.teac.setPId(this.pers);
/*     */         
/* 239 */         if (this.gStatus.getSelectedToggle().getUserData().toString().equals("يعمل")) {
/* 240 */           this.teac.setStatus("1");
/*     */         } else {
/* 242 */           this.teac.setStatus("2");
/*     */         } 
/*     */         
/* 245 */         if (!this.tSalary.getText().isEmpty()) {
/* 246 */           this.teac.setMonthlySalary(Double.valueOf(this.tSalary.getText()));
/*     */         }
/*     */         
/* 249 */         this.teac.setSerialNo(this.tSerial.getText());
/*     */         
/* 251 */         this.TA.PersistNewTeac(this.pers, this.teac);
/*     */       }
/* 253 */       catch (Exception e) {
/* 254 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 255 */         alert.setTitle("يوجد خطأ");
/* 256 */         alert.setHeaderText("خطأ");
/* 257 */         alert.setContentText("برجاء مراجعة مالك البرنامج");
/* 258 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 259 */         alert.showAndWait();
/*     */       } 
/*     */     } else {
/* 262 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 263 */       alert.setTitle("يوجد خطأ");
/* 264 */       alert.setHeaderText("خطأ");
/* 265 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 266 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 267 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/* 273 */   public void handleClose() { this.TA.getDialogStage().close(); }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   public void handleAddCont() {
/* 278 */     this.TA.setC(new Contacts());
/* 279 */     this.TA.newCon();
/* 280 */     this.TA.getContactsList().add(this.TA.getContacts());
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleDeleteCont() {
/* 285 */     if (this.ContactsTable.getSelectionModel().getSelectedIndex() >= 0) {
/* 286 */       this.ContactsTable.getItems().remove(this.ContactsTable.getSelectionModel().getSelectedIndex());
/*     */     } else {
/* 288 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 289 */       alert.setTitle("يوجد خطأ");
/* 290 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
/* 291 */       alert.setContentText("من فضلك قم بتحديد العنصر من جدول جهات الاتصال");
/* 292 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 293 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleAddSub() {
/* 299 */     this.TA.setS(new TeacherSubjects());
/* 300 */     this.TA.newSub();
/* 301 */     this.TA.getTss().add(this.TA.getS());
/* 302 */     this.TA.getSubjectsList().add(this.TA.getS().getSuId());
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleDeleteSub() {
/* 307 */     if (this.SubjectsTable.getSelectionModel().getSelectedIndex() >= 0) {
/* 308 */       this.SubjectsTable.getItems().remove(this.SubjectsTable.getSelectionModel().getSelectedIndex());
/*     */     } else {
/* 310 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 311 */       alert.setTitle("يوجد خطأ");
/* 312 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
/* 313 */       alert.setContentText("من فضلك قم بتحديد العنصر من جدول المواد");
/* 314 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 315 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\RegisterTeacherController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */