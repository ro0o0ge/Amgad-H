/*     */ package Controller;
/*     */ 
/*     */ import Entity.ClassStudents;
/*     */ import Entity.Classes;
/*     */ import Entity.Contacts;
/*     */ import Entity.Student;
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
/*     */ import javafx.collections.FXCollections;
/*     */ import javafx.collections.ObservableList;
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
/*     */ public class EditStudDetailController
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
/*     */   private TableView<Contacts> ContactsTable;
/*     */   @FXML
/*     */   private TableColumn<Contacts, String> NameColumn;
/*     */   @FXML
/*     */   private TableColumn<Contacts, String> NumColumn;
/*     */   @FXML
/*     */   private Label PhotoPath;
/*     */   private ClassStudents classStud;
/*     */   private List<Classes> css;
/*     */   StudentAffair SA;
/* 105 */   final File defaultDirectory = new File("C:\\");
/*     */   
/*     */   private static Student current;
/* 108 */   static ObservableList<Contacts> tempCon = FXCollections.observableArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 126 */     current = StudentAffair.getEdit();
/* 127 */     if (tempCon.size() > 0) {
/* 128 */       tempCon.clear();
/*     */     }
/* 130 */     tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());
/*     */     
/* 132 */     this.sNationality.getItems().removeAll(this.sNationality.getItems());
/* 133 */     this.sNationality.getItems().addAll(new Object[] { "EGY", "SAU", "OMN", "BHR", "KWT", "UAE", "JOR", "PSE", "LBR" });
/*     */     
/* 135 */     this.sNationality.getSelectionModel().select(current.getPId().getNationality());
/*     */ 
/*     */     
/* 138 */     this.registryStatus.getItems().removeAll(this.registryStatus.getItems());
/*     */     
/* 140 */     this.registryStatus.getItems().addAll(new Object[] { "مقيد", "جديد" });
/* 141 */     this.registryStatus.getSelectionModel().select(current.getRegistryStatus());
/*     */     
/* 143 */     this.ParentJob.setText(current.getPId().getSpouseParentOccupation());
/* 144 */     this.sClass.getItems().removeAll(this.sClass.getItems());
/* 145 */     this.sClass.getItems().addAll(getClasses());
/* 146 */     if (current.getClassStudentsList() != null) {
/* 147 */       this.sClass.getSelectionModel().select(current.getClassStudentsList().getCId().getClassDesc());
/*     */     }
/*     */     
/* 150 */     this.sDOB.valueProperty().addListener((ov, oldValue, newValue) -> {
/*     */           LocalDate currentDate;
/* 152 */           if (newValue.getDayOfMonth() == 31) {
/* 153 */             currentDate = LocalDate.of(Calendar.getInstance().get(1), 9, 30);
/*     */           } else {
/* 155 */             currentDate = LocalDate.of(Calendar.getInstance().get(1), 10, 1);
/*     */           } 
/* 157 */           this.ageCalc.setText(currentDate.until(newValue).toString().replace("P-", ""));
/*     */         });
/*     */     
/* 160 */     Calendar cal = Calendar.getInstance();
/* 161 */     cal.setTime(current.getPId().getDob());
/* 162 */     LocalDate date = LocalDate.of(cal.get(1), cal
/* 163 */         .get(2) + 1, cal.get(5));
/* 164 */     this.sDOB.setValue(date);
/* 165 */     if (!this.ContactsTable.getItems().isEmpty()) {
/* 166 */       this.ContactsTable.getItems().clear();
/*     */     }
/* 168 */     this.ContactsTable.setItems(tempCon);
/*     */     
/* 170 */     this.NameColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue())
/* 171 */         .NameProperty());
/* 172 */     this.NumColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue())
/* 173 */         .ConDeatailsProperty());
/*     */     
/* 175 */     this.serialNo.setText(current.getSerialNo());
/* 176 */     this.sName.setText(current.getPId().getName());
/* 177 */     this.sNatNo.setText(current.getPId().getNationalId());
/* 178 */     this.sAddress.setText(current.getPId().getAddress());
/*     */     
/* 180 */     if (current.getPId().getGender().equals("1")) {
/* 181 */       this.sType.selectToggle(this.male);
/*     */     } else {
/* 183 */       this.sType.selectToggle(this.female);
/*     */     } 
/*     */     
/* 186 */     if (current.getStatus().equals("2")) {
/* 187 */       this.sStatus.selectToggle(this.S2);
/* 188 */     } else if (current.getStatus().equals("1")) {
/* 189 */       this.sStatus.selectToggle(this.S1);
/*     */     } else {
/* 191 */       this.sStatus.selectToggle(this.S3);
/*     */     } 
/* 193 */     if (current.getPId().getReligion().equals("1")) {
/* 194 */       this.sReligion.selectToggle(this.R1);
/*     */     } else {
/* 196 */       this.sReligion.selectToggle(this.R2);
/*     */     } 
/*     */ 
/*     */     
/* 200 */     this.sSeatingNo.setText(current.getSeatingNo());
/* 201 */     this.PhotoPath.setText(current.getPId().getPersonalPhoto());
/*     */   }
/*     */   
/*     */   private List<String> getClasses() {
/* 205 */     this.SA = new StudentAffair();
/* 206 */     List<String> StudY = new ArrayList<String>();
/* 207 */     this.css = this.SA.getClasses();
/* 208 */     for (Iterator<Classes> iterator = this.css.iterator(); iterator.hasNext();) {
/* 209 */       StudY.add(((Classes)iterator.next()).getClassDesc());
/*     */     }
/* 211 */     return StudY;
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handlePhoto() {
/* 216 */     FileChooser fileChooser = new FileChooser();
/* 217 */     fileChooser.setInitialDirectory(this.defaultDirectory);
/* 218 */     List<String> extensions = Arrays.asList(new String[] { "JPG", "JPEG", "PNG" });
/* 219 */     fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Images", extensions));
/* 220 */     File selectedFile = fileChooser.showOpenDialog(this.SA.getDialogStage());
/* 221 */     if (selectedFile != null) {
/* 222 */       this.PhotoPath.setText(selectedFile.getAbsolutePath());
/*     */     }
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleSave() {
/* 228 */     if (!this.sName.getText().equals("") || this.sNationality.getSelectionModel().isEmpty() || 
/* 229 */       !this.sNatNo.getText().equals("") || !this.sNatNo.getText().matches("[0-9]+") || 
/* 230 */       !this.sAddress.getText().equals("") || this.sDOB.getValue() != null || 
/* 231 */       !this.serialNo.getText().equals("") || !this.serialNo.getText().matches("[0-9]+")) {
/*     */       
/*     */       try {
/* 234 */         current.getPId().setName(this.sName.getText());
/* 235 */         if (this.sType.getSelectedToggle().getUserData().toString().equals("ذكر")) {
/* 236 */           current.getPId().setGender("1");
/*     */         } else {
/* 238 */           current.getPId().setGender("2");
/*     */         } 
/* 240 */         current.getPId().setNationality(this.sNationality.getSelectionModel().getSelectedItem().toString());
/*     */         
/* 242 */         current.setRegistryStatus(this.registryStatus.getSelectionModel().getSelectedItem().toString());
/*     */         
/* 244 */         if (this.sReligion.getSelectedToggle().getUserData().toString().equals("مسلم")) {
/* 245 */           current.getPId().setReligion("1");
/*     */         } else {
/* 247 */           current.getPId().setReligion("2");
/*     */         } 
/* 249 */         current.getPId().setNationalId(this.sNatNo.getText());
/* 250 */         current.getPId().setAddress(this.sAddress.getText());
/* 251 */         current.getPId().setDob(Date.valueOf((LocalDate)this.sDOB.getValue()));
/* 252 */         current.getPId().setModifiedDate(Date.valueOf(LocalDate.now()));
/* 253 */         current.getPId().setSpouseParentOccupation(this.ParentJob.getText());
/* 254 */         current.getPId().setPersonalPhoto(this.PhotoPath.getText());
/* 255 */         if (this.sStatus.getSelectedToggle().getUserData().toString().equals("مرفوض")) {
/* 256 */           current.setStatus("1");
/* 257 */         } else if (this.sStatus.getSelectedToggle().getUserData().toString().equals("منتظر")) {
/* 258 */           current.setStatus("2");
/*     */         } else {
/* 260 */           current.setStatus("3");
/*     */         } 
/* 262 */         current.setSerialNo(this.serialNo.getText());
/*     */         
/* 264 */         String t = this.ageCalc.getText();
/*     */         
/* 266 */         t = t.replace("Y", "");
/* 267 */         t = t.replace("M", "");
/* 268 */         t = t.replace("D", "");
/* 269 */         System.out.println(t);
/* 270 */         String[] ar = t.split("-");
/* 271 */         List a = Arrays.asList(ar);
/* 272 */         Collections.reverse(a);
/* 273 */         t = "";
/* 274 */         for (int i = 0; i < a.size(); i++) {
/* 275 */           if (i == a.size() - 1) {
/* 276 */             t = t + a.get(i);
/*     */           } else {
/* 278 */             t = t + a.get(i) + " ";
/*     */           } 
/*     */         } 
/* 281 */         System.out.println(t);
/* 282 */         current.setAgeOnOct(t);
/* 283 */         if (!this.sClass.getSelectionModel().isEmpty()) {
/* 284 */           Classes c = new Classes();
/* 285 */           for (Classes r : this.css) {
/* 286 */             if (r.getClassDesc().equals(this.sClass.getSelectionModel().getSelectedItem().toString())) {
/* 287 */               c = r;
/*     */             }
/*     */           } 
/* 290 */           this.classStud = new ClassStudents();
/* 291 */           this.classStud.setCId(c);
/* 292 */           this.classStud.setSId(current);
/* 293 */           current.setClassStudentsList(this.classStud);
/*     */         } 
/* 295 */         this.SA.UpdateStud(current, this.classStud, tempCon);
/* 296 */       } catch (Exception e) {
/* 297 */         System.err.println("Erorr in " + Class.class.getName() + " " + e.getLocalizedMessage());
/* 298 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 299 */         alert.setTitle("يوجد خطأ");
/* 300 */         alert.setHeaderText("خطأ");
/* 301 */         alert.setContentText("برجاء مراجعة مالك البرنامج");
/* 302 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 303 */         alert.showAndWait();
/*     */       } 
/*     */     } else {
/* 306 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 307 */       alert.setTitle("يوجد خطأ");
/* 308 */       alert.setHeaderText("خطأ");
/* 309 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 310 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 311 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/* 317 */   public void handleClose() { StudentAffair.getDialogStage2().close(); }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   public void handleAddCont() {
/* 322 */     StudentAffair.setC(new Contacts());
/* 323 */     this.SA.newCon();
/* 324 */     tempCon.add(StudentAffair.getContacts());
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleDeleteCont() {
/* 329 */     if (this.ContactsTable.getSelectionModel().getSelectedIndex() >= 0) {
/* 330 */       this.ContactsTable.getItems().remove(this.ContactsTable.getSelectionModel().getSelectedIndex());
/*     */     } else {
/* 332 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 333 */       alert.setTitle("يوجد خطأ");
/* 334 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
/* 335 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 336 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 337 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EditStudDetailController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */