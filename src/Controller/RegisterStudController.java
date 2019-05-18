/*     */ package Controller;
/*     */ 
/*     */ import Entity.ClassStudents;
/*     */ import Entity.Classes;
/*     */ import Entity.Contacts;
/*     */ import Entity.Persons;
/*     */ import Entity.Student;
/*     */ import Entity.StudyYears;
/*     */ import amgad.h.StudentAffair;
/*     */ import java.io.File;
/*     */ import java.net.URL;
/*     */ import java.sql.Date;
/*     */ import java.time.LocalDate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
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
/*     */ import javafx.scene.control.TextField;
/*     */ import javafx.scene.control.ToggleGroup;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RegisterStudController
/*     */   implements Initializable
/*     */ {
/*     */   @FXML
/*     */   private Label ageCalc;
/*     */   @FXML
/*     */   private TextField serialNo;
/*     */   @FXML
/*     */   private TextField sName;
/*     */   @FXML
/*     */   private TextField sAddress;
/*     */   @FXML
/*     */   private TextField sNatNo;
/*     */   @FXML
/*     */   private TextField sSecretNo;
/*     */   @FXML
/*     */   private TextField sSeatingNo;
/*     */   @FXML
/*     */   private DatePicker sDOB;
/*     */   @FXML
/*     */   private ToggleGroup sType;
/*     */   @FXML
/*     */   private ToggleGroup sStatus;
/*     */   @FXML
/*     */   private ToggleGroup sReligion;
/*     */   @FXML
/*     */   private ComboBox sNationality;
/*     */   @FXML
/*     */   private ComboBox sClass;
/*     */   @FXML
/*     */   private ComboBox registryStatus;
/*     */   @FXML
/*     */   private RadioButton male;
/*     */   @FXML
/*     */   private RadioButton female;
/*     */   @FXML
/*     */   private RadioButton R1;
/*     */   @FXML
/*     */   private RadioButton R2;
/*     */   @FXML
/*     */   private RadioButton S1;
/*     */   @FXML
/*     */   private RadioButton S2;
/*     */   @FXML
/*     */   private RadioButton S3;
/*     */   @FXML
/*     */   TextField ParentJob;
/*     */   @FXML
/*     */   private Label PhotoPath;
/*     */   @FXML
/*     */   private TableView<Contacts> ContactsTable;
/*     */   @FXML
/*     */   private TableColumn<Contacts, String> NameColumn;
/*     */   @FXML
/*     */   private TableColumn<Contacts, String> NumColumn;
/*     */   private Student stud;
/*     */   private Persons pers;
/*     */   private ClassStudents classStud;
/*     */   private List<Classes> css;
/* 107 */   final File defaultDirectory = new File("C:\\");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   StudentAffair SA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/* 119 */     this.male.setUserData("ذكر");
/* 120 */     this.female.setUserData("انثى");
/* 121 */     this.R1.setUserData("مسلم");
/* 122 */     this.R2.setUserData("مسيحي");
/* 123 */     this.S1.setUserData("مرفوض");
/* 124 */     this.S2.setUserData("منتظر");
/* 125 */     this.S3.setUserData("مقبول");
/*     */     
/* 127 */     this.sNationality.getItems().removeAll(this.sNationality.getItems());
/* 128 */     this.sNationality.getItems().addAll(new Object[] { "EGY", "SAU", "OMN", "BHR", "KWT", "UAE", "JOR", "PSE", "LBR" });
/*     */ 
/*     */     
/* 131 */     this.sClass.getItems().removeAll(this.sClass.getItems());
/* 132 */     this.sClass.getItems().addAll(getClasses());
/*     */     
/* 134 */     this.registryStatus.getItems().removeAll(this.sClass.getItems());
/* 135 */     this.registryStatus.getItems().addAll(new Object[] { "مقيد", "جديد" });
/*     */     
/* 137 */     this.sDOB.valueProperty().addListener((ov, oldValue, newValue) -> {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 142 */           LocalDate currentDate = LocalDate.of(Calendar.getInstance().get(1), 10, 1);
/*     */           
/* 144 */           this.ageCalc.setText(currentDate.until(newValue).toString().replace("P-", ""));
/*     */         });
/*     */ 
/*     */     
/* 148 */     this.ContactsTable.setItems(this.SA.getContactsList());
/* 149 */     this.NameColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue())
/* 150 */         .NameProperty());
/* 151 */     this.NumColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue())
/* 152 */         .ConDeatailsProperty());
/*     */   }
/*     */ 
/*     */   
/*     */   private List<String> getStudyYear() {
/* 157 */     this.SA = new StudentAffair();
/* 158 */     List<String> StudY = new ArrayList<String>();
/* 159 */     for (Iterator<StudyYears> iterator = this.SA.getSY().iterator(); iterator.hasNext();) {
/* 160 */       StudY.add(((StudyYears)iterator.next()).getSyDesc());
/*     */     }
/* 162 */     return StudY;
/*     */   }
/*     */   
/*     */   private List<String> getClasses() {
/* 166 */     this.SA = new StudentAffair();
/* 167 */     List<String> StudY = new ArrayList<String>();
/* 168 */     this.css = this.SA.getClasses();
/* 169 */     for (Iterator<Classes> iterator = this.css.iterator(); iterator.hasNext();) {
/* 170 */       StudY.add(((Classes)iterator.next()).getClassDesc());
/*     */     }
/* 172 */     return StudY;
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleSave() {
/* 177 */     this.stud = new Student();
/* 178 */     this.pers = new Persons();
/* 179 */     if (!this.sName.getText().equals("") || this.sNationality.getSelectionModel().isEmpty() || 
/* 180 */       !this.sNatNo.getText().equals("") || !this.sNatNo.getText().matches("[0-9]+") || 
/* 181 */       !this.sAddress.getText().equals("") || this.sDOB.getValue() != null || 
/* 182 */       !this.serialNo.getText().equals("") || !this.serialNo.getText().matches("[0-9]+")) {
/*     */       try {
/* 184 */         this.pers.setName(this.sName.getText());
/* 185 */         if (this.sType.getSelectedToggle().getUserData().toString().equals("ذكر")) {
/* 186 */           this.pers.setGender("1");
/*     */         } else {
/* 188 */           this.pers.setGender("2");
/*     */         } 
/* 190 */         this.pers.setNationality(this.sNationality.getSelectionModel().getSelectedItem().toString());
/*     */         
/* 192 */         if (this.sReligion.getSelectedToggle().getUserData().toString().equals("مسلم")) {
/* 193 */           this.pers.setReligion("1");
/*     */         } else {
/* 195 */           this.pers.setReligion("2");
/*     */         } 
/* 197 */         this.pers.setNationalId(this.sNatNo.getText());
/* 198 */         this.pers.setAddress(this.sAddress.getText());
/* 199 */         this.pers.setDob(Date.valueOf((LocalDate)this.sDOB.getValue()));
/* 200 */         this.pers.setCreatedDate(Date.valueOf(LocalDate.now()));
/*     */         
/* 202 */         this.pers.setSpouseParentOccupation(this.ParentJob.getText());
/* 203 */         this.pers.setPersonalPhoto(this.PhotoPath.getText());
/* 204 */         this.stud.setPId(this.pers);
/* 205 */         this.stud.setRegistryStatus(this.registryStatus.getSelectionModel().getSelectedItem().toString());
/* 206 */         String t = this.ageCalc.getText();
/*     */         
/* 208 */         t = t.replace("Y", "");
/* 209 */         t = t.replace("M", "");
/* 210 */         t = t.replace("D", "");
/* 211 */         System.out.println(t);
/* 212 */         String[] ar = t.split("-");
/* 213 */         List a = Arrays.asList(ar);
/* 214 */         Collections.reverse(a);
/* 215 */         t = "";
/* 216 */         for (int i = 0; i < a.size(); i++) {
/* 217 */           if (i == a.size() - 1) {
/* 218 */             t = t + a.get(i);
/*     */           } else {
/* 220 */             t = t + a.get(i) + " ";
/*     */           } 
/*     */         } 
/* 223 */         System.out.println(t);
/* 224 */         this.stud.setAgeOnOct(t);
/*     */         
/* 226 */         if (this.sStatus.getSelectedToggle().getUserData().toString().equals("مرفوض")) {
/* 227 */           this.stud.setStatus("1");
/* 228 */         } else if (this.sStatus.getSelectedToggle().getUserData().toString().equals("منتظر")) {
/* 229 */           this.stud.setStatus("2");
/*     */         } else {
/* 231 */           this.stud.setStatus("3");
/*     */         } 
/* 233 */         this.stud.setSerialNo(this.serialNo.getText());
/* 234 */         if (!this.sClass.getSelectionModel().isEmpty()) {
/* 235 */           Classes c = new Classes();
/* 236 */           Classes temp = new Classes();
/* 237 */           for (Iterator<Classes> iterator = this.css.iterator(); iterator.hasNext(); ) {
/* 238 */             temp = (Classes)iterator.next();
/* 239 */             if (temp.getClassDesc().equals(this.sClass.getSelectionModel().getSelectedItem().toString())) {
/* 240 */               c = temp;
/*     */             }
/*     */           } 
/* 243 */           this.classStud = new ClassStudents();
/* 244 */           this.classStud.setSId(this.stud);
/* 245 */           this.classStud.setCId(c);
/*     */         } 
/*     */         
/* 248 */         this.SA.PersistNewStud(this.pers, this.stud, this.classStud);
/* 249 */       } catch (Exception e) {
/* 250 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 251 */         alert.setTitle("يوجد خطأ");
/* 252 */         alert.setHeaderText("خطأ");
/* 253 */         alert.setContentText("برجاء مراجعة مالك البرنامج");
/* 254 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 255 */         alert.showAndWait();
/*     */       } 
/*     */     } else {
/* 258 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 259 */       alert.setTitle("يوجد خطأ");
/* 260 */       alert.setHeaderText("خطأ");
/* 261 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 262 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 263 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handlePhoto() {
/* 269 */     FileChooser fileChooser = new FileChooser();
/* 270 */     fileChooser.setInitialDirectory(this.defaultDirectory);
/* 271 */     List<String> extensions = Arrays.asList(new String[] { "JPG", "JPEG", "PNG" });
/* 272 */     fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Images", extensions));
/* 273 */     File selectedFile = fileChooser.showOpenDialog(this.SA.getDialogStage());
/* 274 */     if (selectedFile != null) {
/* 275 */       this.PhotoPath.setText(selectedFile.getAbsolutePath());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/* 281 */   public void handleClose() { this.SA.getDialogStage().close(); }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   public void handleAddCont() {
/* 286 */     this.SA.setC(new Contacts());
/* 287 */     this.SA.newCon();
/* 288 */     this.SA.getContactsList().add(this.SA.getContacts());
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleDeleteCont() {
/* 293 */     if (this.ContactsTable.getSelectionModel().getSelectedIndex() >= 0) {
/* 294 */       this.ContactsTable.getItems().remove(this.ContactsTable.getSelectionModel().getSelectedIndex());
/*     */     } else {
/* 296 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 297 */       alert.setTitle("يوجد خطأ");
/* 298 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
/* 299 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 300 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 301 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\RegisterStudController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */