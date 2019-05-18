/*     */ package Controller;
/*     */ 
/*     */ import Entity.Contacts;
/*     */ import Entity.Schedule;
/*     */ import Entity.Student;
/*     */ import Entity.StudentAttendance;
/*     */ import amgad.h.StudentAffair;
/*     */ import amgad.h.root;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.ResourceBundle;
/*     */ import javafx.beans.value.ObservableValue;
/*     */ import javafx.collections.FXCollections;
/*     */ import javafx.collections.ObservableList;
/*     */ import javafx.embed.swing.SwingFXUtils;
/*     */ import javafx.fxml.FXML;
/*     */ import javafx.fxml.FXMLLoader;
/*     */ import javafx.fxml.Initializable;
/*     */ import javafx.geometry.NodeOrientation;
/*     */ import javafx.scene.Scene;
/*     */ import javafx.scene.SnapshotParameters;
/*     */ import javafx.scene.control.Alert;
/*     */ import javafx.scene.control.Button;
/*     */ import javafx.scene.control.Label;
/*     */ import javafx.scene.control.Tab;
/*     */ import javafx.scene.control.TableColumn;
/*     */ import javafx.scene.control.TableView;
/*     */ import javafx.scene.control.cell.CheckBoxTableCell;
/*     */ import javafx.scene.image.Image;
/*     */ import javafx.scene.image.ImageView;
/*     */ import javafx.scene.image.WritableImage;
/*     */ import javafx.scene.layout.AnchorPane;
/*     */ import javafx.scene.transform.Affine;
/*     */ import javafx.stage.Modality;
/*     */ import javafx.stage.Stage;
/*     */ import javax.imageio.ImageIO;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ViewStudController
/*     */   implements Initializable
/*     */ {
/*     */   @FXML
/*     */   private Label name;
/*     */   @FXML
/*     */   private Label className;
/*     */   @FXML
/*     */   private Label serial;
/*     */   @FXML
/*     */   private Label type;
/*     */   @FXML
/*     */   private Label nationality;
/*     */   @FXML
/*     */   private Label religion;
/*     */   @FXML
/*     */   private Label dob;
/*     */   @FXML
/*     */   private Label address;
/*     */   @FXML
/*     */   private Label nationalId;
/*     */   @FXML
/*     */   private Label secretNo;
/*     */   @FXML
/*     */   private Label seatingNo;
/*     */   @FXML
/*     */   private TableView<Contacts> ContactsTable;
/*     */   @FXML
/*     */   private TableColumn<Contacts, String> NameColumn;
/*     */   @FXML
/*     */   private TableColumn<Contacts, String> NumColumn;
/*     */   @FXML
/*     */   private Tab schedule;
/*     */   @FXML
/*     */   AnchorPane scheduleAP;
/*     */   @FXML
/*     */   private Button printScheduleBtn;
/*     */   @FXML
/*     */   private Label Sun1;
/*     */   @FXML
/*     */   private Label Sun2;
/*     */   @FXML
/*     */   private Label Sun3;
/*     */   @FXML
/*     */   private Label Sun4;
/*     */   @FXML
/*     */   private Label Sun5;
/*     */   @FXML
/*     */   private Label Sun6;
/*     */   @FXML
/*     */   private Label Sun7;
/*     */   @FXML
/*     */   private Label Mon1;
/*     */   @FXML
/*     */   private Label Mon2;
/*     */   @FXML
/*     */   private Label Mon3;
/*     */   @FXML
/*     */   private Label Mon4;
/*     */   @FXML
/*     */   private Label Mon5;
/*     */   @FXML
/*     */   private Label Mon6;
/*     */   @FXML
/*     */   private Label Mon7;
/*     */   @FXML
/*     */   private Label Tue1;
/*     */   @FXML
/*     */   private Label Tue2;
/*     */   @FXML
/*     */   private Label Tue3;
/*     */   @FXML
/*     */   private Label Tue4;
/*     */   @FXML
/*     */   private Label Tue5;
/*     */   @FXML
/*     */   private Label Tue6;
/*     */   @FXML
/*     */   private Label Tue7;
/*     */   @FXML
/*     */   private Label Wed1;
/*     */   @FXML
/*     */   private Label Wed2;
/*     */   @FXML
/*     */   private Label Wed3;
/*     */   @FXML
/*     */   private Label Wed4;
/*     */   @FXML
/*     */   private Label Wed5;
/*     */   @FXML
/*     */   private Label Wed6;
/*     */   @FXML
/*     */   private Label Wed7;
/*     */   @FXML
/*     */   private Label Thu1;
/*     */   @FXML
/*     */   private Label Thu2;
/*     */   @FXML
/*     */   private Label Thu3;
/*     */   @FXML
/*     */   private Label Thu4;
/*     */   @FXML
/*     */   private Label Thu5;
/*     */   @FXML
/*     */   private Label Thu6;
/*     */   @FXML
/*     */   private Label Thu7;
/*     */   @FXML
/*     */   private Tab abscense;
/*     */   @FXML
/*     */   private Button saveAbscence;
/*     */   @FXML
/*     */   private Label ParentOccupation;
/*     */   @FXML
/*     */   private Label registryStatus;
/*     */   @FXML
/*     */   ImageView PhotoPath;
/*     */   @FXML
/*     */   private TableView<StudentAttendance> AttTable;
/*     */   @FXML
/*     */   private TableColumn<StudentAttendance, String> AttNoteColumn;
/*     */   @FXML
/*     */   private TableColumn<StudentAttendance, String> AttDateColumn;
/*     */   @FXML
/*     */   private TableColumn<StudentAttendance, Boolean> StatusColumn;
/*     */   private static Student current;
/*     */   StudentAffair TS;
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/*     */     try {
/* 192 */       current = StudentAffair.getEdit();
/* 193 */       this.TS = new StudentAffair();
/* 194 */       this.name.setText(current.getPId().getName());
/*     */       
/* 196 */       if (current.getClassStudentsList() != null) {
/* 197 */         this.className.setText(current.getClassStudentsList().getCId().getClassDesc());
/* 198 */         if (current.getClassStudentsList().getCId().getScheduleList() != null && 
/* 199 */           current.getClassStudentsList().getCId().getScheduleList().size() > 0) {
/* 200 */           this.Sun1.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(0)).getSuId());
/* 201 */           this.Sun2.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(1)).getSuId());
/* 202 */           this.Sun3.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(2)).getSuId());
/* 203 */           this.Sun4.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(3)).getSuId());
/* 204 */           this.Sun5.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(4)).getSuId());
/* 205 */           this.Sun6.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(5)).getSuId());
/* 206 */           this.Sun7.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(6)).getSuId());
/* 207 */           this.Mon1.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(7)).getSuId());
/* 208 */           this.Mon2.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(8)).getSuId());
/* 209 */           this.Mon3.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(9)).getSuId());
/* 210 */           this.Mon4.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(10)).getSuId());
/* 211 */           this.Mon5.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(11)).getSuId());
/* 212 */           this.Mon6.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(12)).getSuId());
/* 213 */           this.Mon7.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(13)).getSuId());
/* 214 */           this.Tue1.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(14)).getSuId());
/* 215 */           this.Tue2.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(15)).getSuId());
/* 216 */           this.Tue3.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(16)).getSuId());
/* 217 */           this.Tue4.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(17)).getSuId());
/* 218 */           this.Tue5.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(18)).getSuId());
/* 219 */           this.Tue6.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(19)).getSuId());
/* 220 */           this.Tue7.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(20)).getSuId());
/* 221 */           this.Wed1.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(21)).getSuId());
/* 222 */           this.Wed2.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(22)).getSuId());
/* 223 */           this.Wed3.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(23)).getSuId());
/* 224 */           this.Wed4.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(24)).getSuId());
/* 225 */           this.Wed5.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(25)).getSuId());
/* 226 */           this.Wed6.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(26)).getSuId());
/* 227 */           this.Wed7.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(27)).getSuId());
/* 228 */           this.Thu1.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(28)).getSuId());
/* 229 */           this.Thu2.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(29)).getSuId());
/* 230 */           this.Thu3.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(30)).getSuId());
/* 231 */           this.Thu4.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(31)).getSuId());
/* 232 */           this.Thu5.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(32)).getSuId());
/* 233 */           this.Thu6.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(33)).getSuId());
/* 234 */           this.Thu7.setText(((Schedule)current.getClassStudentsList().getCId().getScheduleList().get(34)).getSuId());
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 239 */       this.schedule.selectedProperty().addListener((ov, oldTab, newTab) -> 
/* 240 */           this.printScheduleBtn.setVisible(newTab.booleanValue()));
/*     */ 
/*     */       
/* 243 */       this.serial.setText(current.getSerialNo());
/* 244 */       if (current.getPId().getGender().equals("1")) {
/* 245 */         this.type.setText("ذكر");
/*     */       } else {
/* 247 */         this.type.setText("أنثى");
/*     */       } 
/* 249 */       this.nationality.setText(current.getPId().getNationality());
/* 250 */       if (current.getPId().getReligion().equals("1")) {
/* 251 */         this.religion.setText("مسلم");
/*     */       } else {
/* 253 */         this.religion.setText("مسيحي");
/*     */       } 
/* 255 */       this.dob.setText(current.getPId().getDob().toString());
/* 256 */       this.address.setText(current.getPId().getAddress());
/* 257 */       this.nationalId.setText(current.getPId().getNationalId());
/* 258 */       if (current.getPId().getSpouseParentOccupation() != null) {
/* 259 */         this.ParentOccupation.setText(current.getPId().getSpouseParentOccupation());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 264 */       if (current.getSeatingNo() != null) {
/* 265 */         this.seatingNo.setText(current.getSeatingNo());
/*     */       }
/*     */       
/* 268 */       this.registryStatus.setText(current.getRegistryStatus());
/* 269 */       ObservableList<Contacts> tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());
/* 270 */       this.ContactsTable.setItems(tempCon);
/* 271 */       this.NameColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue()).NameProperty());
/* 272 */       this.NumColumn.setCellValueFactory(cellData -> ((Contacts)cellData.getValue()).ConDeatailsProperty());
/*     */       
/* 274 */       this.abscense.selectedProperty().addListener((ov, oldTab, newTab) -> 
/* 275 */           this.saveAbscence.setVisible(newTab.booleanValue()));
/*     */ 
/*     */       
/* 278 */       if (current.getStudentAttendanceList() != null) {
/* 279 */         ObservableList<StudentAttendance> tempAtt = FXCollections.observableArrayList(current.getStudentAttendanceList());
/* 280 */         this.AttTable.setItems(tempAtt);
/* 281 */         this.AttNoteColumn.setCellValueFactory(cellData -> ((StudentAttendance)cellData.getValue()).DescProperty());
/* 282 */         this.AttDateColumn.setCellValueFactory(cellData -> ((StudentAttendance)cellData.getValue()).DateProperty());
/* 283 */         this.StatusColumn.setCellValueFactory(cellData -> ((StudentAttendance)cellData.getValue()).statusProperty());
/* 284 */         this.StatusColumn.setCellFactory(CheckBoxTableCell.forTableColumn(this.StatusColumn));
/*     */       } 
/*     */       
/* 287 */       this.PhotoPath.setImage(new Image((new File(current.getPId().getPersonalPhoto())).toURI().toString()));
/* 288 */     } catch (Exception e) {
/* 289 */       System.err.println("ERROR IN INIT" + e);
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleImageClick() {
/*     */     try {
/* 296 */       FXMLLoader loader = new FXMLLoader();
/* 297 */       loader.setLocation(amgad.h.Main.class.getResource("/View/ViewImage.fxml"));
/* 298 */       root.f = new File(current.getPId().getPersonalPhoto());
/* 299 */       AnchorPane page = (AnchorPane)loader.load();
/* 300 */       Stage dialogStage2 = new Stage();
/* 301 */       dialogStage2.getIcons().add(new Image(amgad.h.Main.class.getResourceAsStream("/resources/6.jpg")));
/* 302 */       dialogStage2.setTitle("عرض الصورة");
/* 303 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/* 304 */       dialogStage2.initOwner(this.TS.getDialogStage());
/* 305 */       Scene scene = new Scene(page);
/* 306 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 307 */       dialogStage2.setScene(scene);
/* 308 */       dialogStage2.showAndWait();
/*     */     }
/* 310 */     catch (IOException e) {
/* 311 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/* 315 */   private static final Logger LOGGER = LogManager.getLogger(ViewTeacherController.class);
/*     */   @FXML
/*     */   public void handlePrintSchedule() {
/*     */     try {
/* 319 */       SnapshotParameters spp = new SnapshotParameters();
/* 320 */       Affine reflectTransform = new Affine();
/* 321 */       reflectTransform.setMxx(-1.0D);
/* 322 */       reflectTransform.setTx(708.0D);
/*     */       
/* 324 */       spp.setTransform(reflectTransform);
/* 325 */       WritableImage image = this.scheduleAP.snapshot(spp, null);
/*     */       
/* 327 */       File file = new File("D:\\جدول حصص - " + current.getPId().getName() + ".png");
/*     */       
/* 329 */       ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
/* 330 */     } catch (Exception e) {
/* 331 */       LOGGER.error(e);
/* 332 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 333 */       alert.setTitle("يوجد خطأ");
/* 334 */       alert.setHeaderText("خطأ");
/* 335 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 336 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 337 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleEdit() {
/* 343 */     int selectedIndex = this.AttTable.getSelectionModel().getSelectedIndex();
/* 344 */     if (selectedIndex >= 0) {
/* 345 */       StudentAffair.setEditStatus((StudentAttendance)this.AttTable.getItems().get(selectedIndex));
/* 346 */       this.TS.ViewEditAbscentStatus();
/* 347 */       ObservableList<StudentAttendance> tempAtt = FXCollections.observableArrayList(current.getStudentAttendanceList());
/* 348 */       this.AttTable.getItems().clear();
/* 349 */       this.AttTable.setItems(tempAtt);
/*     */     } else {
/* 351 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 352 */       alert.setTitle("يوجد خطأ");
/* 353 */       alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
/* 354 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 355 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 356 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\ViewStudController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */