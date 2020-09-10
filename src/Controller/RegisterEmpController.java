 package Controller;
 
 import Entity.Contacts;
 import Entity.Persons;
 import Entity.Staff;
 import Util.LoginSec;
 import amgad.h.Management;
 import java.io.File;
 import java.net.URL;
 import java.sql.Date;
 import java.time.LocalDate;
 import java.util.Arrays;
 import java.util.List;
 import java.util.ResourceBundle;
 import javafx.beans.value.ObservableValue;
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
 
 
 
 
 
 
 
 
 
 
 public class RegisterEmpController
   implements Initializable
 {
   @FXML
   TextField tSerial;
   @FXML
   DatePicker tSignDate;
   @FXML
   TextField tSalary;
   @FXML
   TextField tQual;
   @FXML
   TextField spouseName;
   @FXML
   TextField spouseJob;
   @FXML
   TextField noOfChildren;
   @FXML
   TextArea prevEXP;
   @FXML
   ComboBox tNationality;
   @FXML
   ComboBox tCategory;
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
   RadioButton type1;
   @FXML
   RadioButton type2;
   @FXML
   RadioButton type3;
   @FXML
   HBox salary;
   @FXML
   ToggleGroup gType;
   @FXML
   ToggleGroup gCategory;
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
   private Label PhotoPath;
   @FXML
   TextField InsuranceNo;
   @FXML
   TextField InsuranceAmount;
   Management MA;
   private Persons pers;
   private Staff teac;
/* 128 */   final File defaultDirectory = new File("C:\\");
 
 
 
 
 
 
 
 
 
   
   public void initialize(URL url, ResourceBundle rb) {
/* 140 */     this.MA = new Management();
/* 141 */     this.t1.setUserData("ذكر");
/* 142 */     this.t2.setUserData("انثى");
/* 143 */     this.r1.setUserData("مسلم");
/* 144 */     this.r2.setUserData("مسيحي");
/* 145 */     this.s1.setUserData("يعمل");
/* 146 */     this.s2.setUserData("لا يعمل");
/* 147 */     this.soc1.setUserData("مطلق");
/* 148 */     this.soc2.setUserData("أرمل");
/* 149 */     this.soc3.setUserData("أعزب");
/* 150 */     this.soc4.setUserData("متزوج");
/* 151 */     this.type1.setUserData("إداري");
/* 152 */     this.type2.setUserData("فني");
/* 153 */     this.type3.setUserData("عمال و سائقين");
/* 154 */     this.tNationality.getItems().removeAll(this.tNationality.getItems());
/* 155 */     this.tNationality.getItems().addAll(new Object[] { "EGY", "SAU", "OMN", "BHR", "KWT", "UAE", "JOR", "PSE", "LBR" });
 
     
/* 158 */     this.gCategory.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
/* 159 */           if (newToggle.getUserData().equals("إداري")) {
/* 160 */             this.tCategory.getItems().removeAll(this.tCategory.getItems());
/* 161 */             this.tCategory.getItems().addAll(new Object[] { "رئيس قسم سكرتارية", "سكرتيرة", "ضابطة", "ضابطة أولى", "وكيلة شئون مالية", "وكيلة شئون ادارية", "وكيلة شئون ادارية ومالية", "مشرفة دور", "مشرفة باص", "مشرفة مقصف", "مشرفة باص و مقصف", "مسئولة سينما", "ألعاب", "مجالات", "مسئولة الكمبيوتر", "اخصائية اجتماعية" });
 
 
           
           }
/* 166 */           else if (newToggle.getUserData().equals("فني")) {
/* 167 */             this.tCategory.getItems().removeAll(this.tCategory.getItems());
/* 168 */             this.tCategory.getItems().addAll(new Object[] { "ناظرة", "مساعد قائد", "وكيلة فنية", "مديرة متابعة فنية", "مشرفة اللغة العربية", "مشرفة اللغة الانجليزية", "مشرفة اللغة الفرنسية", "مشرفة الرياضيات", "مشرفة العلوم", "مشرفة الدراسات" });
           }
           else {
             
/* 172 */             this.tCategory.getItems().removeAll(this.tCategory.getItems());
           } 
         });
     
/* 176 */     this.ContactsTable.setItems(this.MA.getContactsList());
/* 177 */     this.NameColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue())
/* 178 */         .NameProperty());
/* 179 */     this.NumColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue())
/* 180 */         .ConDeatailsProperty());
     
/* 182 */     if (LoginSec.getLoggedUser().getPermission().equals("2")) {
/* 183 */       this.salary.setVisible(true);
     }
   }
   
   @FXML
   public void handlePhoto() {
/* 189 */     FileChooser fileChooser = new FileChooser();
/* 190 */     fileChooser.setInitialDirectory(this.defaultDirectory);
/* 191 */     List<String> extensions = Arrays.asList(new String[] { "JPG", "JPEG", "PNG" });
/* 192 */     fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Images", extensions));
/* 193 */     File selectedFile = fileChooser.showOpenDialog(this.MA.getDialogStage());
/* 194 */     if (selectedFile != null) {
/* 195 */       this.PhotoPath.setText(selectedFile.getAbsolutePath());
     }
   }
   
   @FXML
   public void handleSave() {
/* 201 */     this.pers = new Persons();
/* 202 */     this.teac = new Staff();
/* 203 */     if (!this.tName.getText().equals("") || this.tNationality.getSelectionModel().isEmpty() || 
/* 204 */       !this.tNatNo.getText().equals("") || !this.tNatNo.getText().matches("[0-9]+") || 
/* 205 */       !this.tAddress.getText().equals("") || this.tDOB.getValue() != null) {
       try {
/* 207 */         this.pers.setName(this.tName.getText());
/* 208 */         if (this.gType.getSelectedToggle().getUserData().toString().equals("ذكر")) {
/* 209 */           this.pers.setGender("1");
         } else {
/* 211 */           this.pers.setGender("2");
         } 
/* 213 */         this.pers.setNationality(this.tNationality.getSelectionModel().getSelectedItem().toString());
/* 214 */         if (this.gReligion.getSelectedToggle().getUserData().toString().equals("مسلم")) {
/* 215 */           this.pers.setReligion("1");
         } else {
/* 217 */           this.pers.setReligion("2");
         } 
         
/* 220 */         if (this.gSocial.getSelectedToggle().getUserData().toString().equals("مطلق")) {
/* 221 */           this.pers.setMaritalStatus("1");
/* 222 */         } else if (this.gSocial.getSelectedToggle().getUserData().toString().equals("أرمل")) {
/* 223 */           this.pers.setMaritalStatus("2");
/* 224 */         } else if (this.gSocial.getSelectedToggle().getUserData().toString().equals("أعزب")) {
/* 225 */           this.pers.setMaritalStatus("3");
         } else {
/* 227 */           this.pers.setMaritalStatus("4");
         } 
/* 229 */         this.pers.setNationalId(this.tNatNo.getText());
/* 230 */         this.pers.setAddress(this.tAddress.getText());
/* 231 */         this.pers.setDob(Date.valueOf((LocalDate)this.tDOB.getValue()));
/* 232 */         this.pers.setCreatedDate(Date.valueOf(LocalDate.now()));
/* 233 */         this.pers.setHiringDate(Date.valueOf((LocalDate)this.tSignDate.getValue()));
         
/* 235 */         if (this.tGradDate.getValue() != null) {
/* 236 */           LocalDate localDate = (LocalDate)this.tGradDate.getValue();
/* 237 */           this.pers.setGradYear(String.valueOf(localDate.getYear()));
         } 
/* 239 */         if (!this.tQual.getText().equals("")) {
/* 240 */           this.pers.setQualification(this.tQual.getText());
         }
/* 242 */         if (!this.spouseName.getText().equals("")) {
/* 243 */           this.pers.setSpouseName(this.spouseName.getText());
         }
/* 245 */         if (!this.spouseJob.getText().equals("")) {
/* 246 */           this.pers.setSpouseParentOccupation(this.spouseJob.getText());
         }
/* 248 */         if (!this.noOfChildren.getText().equals("")) {
/* 249 */           this.pers.setNoOfChildren(Integer.valueOf(this.noOfChildren.getText()));
         }
/* 251 */         if (!this.prevEXP.getText().equals("")) {
/* 252 */           this.pers.setPrevExp(this.prevEXP.getText());
         }
/* 254 */         if (!this.PhotoPath.getText().equals("")) {
/* 255 */           this.pers.setPersonalPhoto(this.PhotoPath.getText());
         }
/* 257 */         if (!this.InsuranceAmount.getText().equals("")) {
/* 258 */           this.pers.setInsuranceAmount(Double.valueOf(Double.parseDouble(this.InsuranceAmount.getText())));
         }
/* 260 */         if (!this.InsuranceNo.getText().equals("")) {
/* 261 */           this.pers.setInsuranceNo(this.InsuranceNo.getText());
         }
         
/* 264 */         this.teac.setPId(this.pers);
/* 265 */         if (this.gCategory.getSelectedToggle().getUserData().toString().equals("إداري")) {
/* 266 */           this.teac.setStaffType("1");
/* 267 */         } else if (this.gSocial.getSelectedToggle().getUserData().toString().equals("فني")) {
/* 268 */           this.teac.setStaffType("2");
         } else {
/* 270 */           this.teac.setStaffType("3");
         } 
         
/* 273 */         if (!"3".equals(this.teac.getStaffType())) {
/* 274 */           this.teac.setStaffCategory(this.tCategory.getSelectionModel().getSelectedItem().toString());
         } else {
/* 276 */           this.teac.setStaffCategory("");
         } 
/* 278 */         if (this.gStatus.getSelectedToggle().getUserData().toString().equals("يعمل")) {
/* 279 */           this.teac.setStatus("1");
         } else {
/* 281 */           this.teac.setStatus("2");
         } 
         
/* 284 */         if (!this.tSalary.getText().isEmpty()) {
/* 285 */           this.teac.setMonthlySalary(Double.valueOf(this.tSalary.getText()));
         }
/* 287 */         this.teac.setSerialNo(this.tSerial.getText());
         
/* 289 */         this.MA.PersistNewTeac(this.pers, this.teac);
       }
/* 291 */       catch (Exception e) {
/* 292 */         System.out.println("Error " + e.getSuppressed());
/* 293 */         e.printStackTrace();
/* 294 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 295 */         alert.setTitle("يوجد خطأ");
/* 296 */         alert.setHeaderText("خطأ");
/* 297 */         alert.setContentText("برجاء مراجعة مالك البرنامج");
/* 298 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 299 */         alert.showAndWait();
       } 
     } else {
/* 302 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 303 */       alert.setTitle("يوجد خطأ");
/* 304 */       alert.setHeaderText("خطأ");
/* 305 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 306 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 307 */       alert.showAndWait();
     } 
   }
 
   
   @FXML
/* 313 */   public void handleClose() { Management.getDialogStage().close(); }
 
   
   @FXML
   public void handleAddCont() {
/* 318 */     Management.setC(new Contacts());
/* 319 */     this.MA.newCon();
/* 320 */     this.MA.getContactsList().add(Management.getContacts());
   }
   
   @FXML
   public void handleDeleteCont() {
/* 325 */     if (this.ContactsTable.getSelectionModel().getSelectedIndex() >= 0) {
/* 326 */       this.ContactsTable.getItems().remove(this.ContactsTable.getSelectionModel().getSelectedIndex());
     } else {
/* 328 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 329 */       alert.setTitle("يوجد خطأ");
/* 330 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
/* 331 */       alert.setContentText("من فضلك قم بتحديد العنصر من جدول جهات الاتصال");
/* 332 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 333 */       alert.showAndWait();
     } 
   }
   
   @FXML
   public void handleAddSub() {}
   
   @FXML
   public void handleDeleteSub() {}
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\RegisterEmpController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */