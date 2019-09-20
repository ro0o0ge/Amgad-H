/*     */ package Controller;
/*     */ 
/*     */ import Entity.Student;
/*     */ import amgad.h.StudentAffair;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.util.HashMap;
/*     */ import java.util.Properties;
/*     */ import java.util.ResourceBundle;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javafx.beans.value.ObservableValue;
/*     */ import javafx.collections.FXCollections;
/*     */ import javafx.collections.ObservableList;
/*     */ import javafx.fxml.FXML;
/*     */ import javafx.fxml.Initializable;
/*     */ import javafx.geometry.NodeOrientation;
/*     */ import javafx.scene.control.Alert;
/*     */ import javafx.scene.control.ComboBox;
/*     */ import javafx.scene.control.TableColumn;
/*     */ import javafx.scene.control.TableView;
/*     */ import javafx.scene.control.TextField;
/*     */ import net.sf.jasperreports.engine.JasperCompileManager;
/*     */ import net.sf.jasperreports.engine.JasperExportManager;
/*     */ import net.sf.jasperreports.engine.JasperFillManager;
/*     */ import net.sf.jasperreports.engine.JasperPrint;
/*     */ import net.sf.jasperreports.engine.JasperReport;
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
/*     */ public class EditStudController
/*     */   implements Initializable
/*     */ {
/*     */   @FXML
/*     */   private TextField SearchQuery;
/*     */   @FXML
/*     */   private ComboBox ComboSearch;
/*     */   @FXML
/*     */   private TableView<Student> StudentsTable;
/*     */   @FXML
/*     */   private TableColumn<Student, String> NameColumn;
/*     */   @FXML
/*     */   private TableColumn<Student, String> StatusColumn;
/*     */   @FXML
/*     */   private TableColumn<Student, String> ClassColumn;
/*     */   @FXML
/*     */   private TableColumn<Student, String> AdmissionDateColumn;
/*     */   @FXML
/*     */   private TableColumn<Student, String> DOBColumn;
/*  62 */   private static final Logger LOGGER = LogManager.getLogger(EditStudController.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   StudentAffair SA;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/*  73 */     this.ComboSearch.getItems().removeAll(this.ComboSearch.getItems());
/*  74 */     this.ComboSearch.getItems().addAll(new Object[] { "الاسم", "حالة الطالب", "الفصل" });
/*  75 */     this.ComboSearch.getSelectionModel().select(1);
/*  76 */     if (!this.StudentsTable.getItems().isEmpty()) {
/*  77 */       this.StudentsTable.getItems().clear();
/*     */     }
/*     */     
/*  80 */     this.StudentsTable.setItems(StudentAffair.getPersonsList());
/*     */     
/*  82 */     this.NameColumn.setCellValueFactory(cellData -> ((Student)cellData.getValue()).getPId().NameProperty());
/*  83 */     this.DOBColumn.setCellValueFactory(cellData -> ((Student)cellData.getValue()).getPId().DOBProperty());
/*  84 */     this.AdmissionDateColumn.setCellValueFactory(cellData -> ((Student)cellData.getValue()).getPId().createdDateProperty());
/*  85 */     this.StatusColumn.setCellValueFactory(cellData -> ((Student)cellData.getValue()).AgeOnOctProperty());
/*  86 */     this.ClassColumn.setCellValueFactory(cellData -> {
/*  87 */           if (((Student)cellData.getValue()).getClassStudentsList() != null) {
/*  88 */             return ((Student)cellData.getValue()).getClassStudentsList().getCId().ClassDescProperty();
/*     */           }
/*  90 */           return null;
/*     */         });
/*     */     
/*  93 */     this.SA = new StudentAffair();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FXML
/*     */   public void Search() {
/* 100 */     if (!this.SearchQuery.getText().equals("")) {
/* 101 */       ObservableList<Student> TempList = FXCollections.observableArrayList(this.SA.getStudents(1));
/* 102 */       this.StudentsTable.getItems().clear();
/* 103 */       if (this.ComboSearch.getSelectionModel().isSelected(0)) {
                  TempList = FXCollections.observableArrayList(this.SA.searchStudentbyName(this.SearchQuery.getText()));
///* 104 */         for (int i = 0; i < TempList.size(); i++) {
///* 105 */           if (!((Student)TempList.get(i)).getPId().getName().contains(this.SearchQuery.getText())) {
///* 106 */             TempList.remove(i);
///* 107 */             i--;
///*     */           } 
///*     */         } 
/* 110 */         this.StudentsTable.setItems(TempList);
/* 111 */       } else if (this.ComboSearch.getSelectionModel().isSelected(1)) {
                   
/* 112 */         System.out.println("size " + TempList.size());
/* 113 */         for (int i = 0; i < TempList.size(); i++) {
/* 114 */           if (!((Student)TempList.get(i)).statusProperty().toString().contains(this.SearchQuery.getText())) {
/* 115 */             TempList.remove(i);
/* 116 */             i--;
/*     */           } 
/*     */         } 
/* 119 */         this.StudentsTable.setItems(TempList);
/*     */       } else {
/* 121 */         for (int i = 0; i < TempList.size(); i++) {
/* 122 */           if (this.SearchQuery.getText().equals("  ")) {
/* 123 */             if (((Student)TempList.get(i)).getClassStudentsList() != null) {
/* 124 */               TempList.remove(i);
/* 125 */               i--;
/*     */             } 
/*     */             break;
/*     */           } 
/* 129 */           if (((Student)TempList.get(i)).getClassStudentsList() != null) {
/* 130 */             if (!((Student)TempList.get(i)).getClassStudentsList().getCId().getClassDesc().contains(this.SearchQuery.getText())) {
/* 131 */               TempList.remove(i);
/* 132 */               i--;
/*     */             } 
/* 134 */           } else if (((Student)TempList.get(i)).getClassStudentsList() == null) {
/* 135 */             TempList.remove(i);
/* 136 */             i--;
/*     */           } 
/*     */         } 
/* 139 */         this.StudentsTable.setItems(TempList);
/*     */       } 
/*     */     } else {
/* 142 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 143 */       alert.setTitle("يوجد خطأ");
/* 144 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/* 145 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/* 146 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 147 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleEdit() {
/* 153 */     int selectedIndex = this.StudentsTable.getSelectionModel().getSelectedIndex();
/* 154 */     if (selectedIndex >= 0) {
/* 155 */       StudentAffair.setEdit((Student)this.StudentsTable.getItems().get(selectedIndex));
/* 156 */       this.SA.editStudDetail();
/*     */     } else {
/* 158 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 159 */       alert.setTitle("يوجد خطأ");
/* 160 */       alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
/* 161 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 162 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 163 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleView() {
/* 169 */     int selectedIndex = this.StudentsTable.getSelectionModel().getSelectedIndex();
/* 170 */     if (selectedIndex >= 0) {
/* 171 */       StudentAffair.setEdit((Student)this.StudentsTable.getItems().get(selectedIndex));
/* 172 */       this.SA.ViewStudent();
/*     */     } else {
/* 174 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 175 */       alert.setTitle("يوجد خطأ");
/* 176 */       alert.setHeaderText("لم يتم تحديد العنصر المراد عرضه");
/* 177 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 178 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 179 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleNotes() {
/* 185 */     int selectedIndex = this.StudentsTable.getSelectionModel().getSelectedIndex();
/* 186 */     if (selectedIndex >= 0) {
/* 187 */       StudentAffair.setEdit((Student)this.StudentsTable.getItems().get(selectedIndex));
/* 188 */       this.SA.StudNotes();
/*     */     } else {
/* 190 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 191 */       alert.setTitle("يوجد خطأ");
/* 192 */       alert.setHeaderText("لم يتم تحديد العنصر المراد إضافة ملاحظات له");
/* 193 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 194 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 195 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleExpenses() {
/* 201 */     int selectedIndex = this.StudentsTable.getSelectionModel().getSelectedIndex();
/* 202 */     if (selectedIndex >= 0) {
/* 203 */       StudentAffair.setEdit((Student)this.StudentsTable.getItems().get(selectedIndex));
/* 204 */       this.SA.editStudExpenses();
/*     */     } else {
/* 206 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 207 */       alert.setTitle("يوجد خطأ");
/* 208 */       alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
/* 209 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 210 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 211 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleControl() {
/*     */     try {
/* 218 */       int selectedIndex = this.StudentsTable.getSelectionModel().getSelectedIndex();
/* 219 */       if (selectedIndex >= 0) {
/* 220 */         if (((Student)this.StudentsTable.getItems().get(selectedIndex)).getClassStudentsList() != null) {
/* 221 */           StudentAffair.setEdit((Student)this.StudentsTable.getItems().get(selectedIndex));
/* 222 */           if (((Student)this.StudentsTable.getItems().get(selectedIndex)).getClassStudentsList()
/* 223 */             .getCId().getSyId().getSyId().equals(Integer.valueOf(1)) || ((Student)this.StudentsTable
/* 224 */             .getItems().get(selectedIndex)).getClassStudentsList()
/* 225 */             .getCId().getSyId().getSyId().equals(Integer.valueOf(2)) || ((Student)this.StudentsTable
/* 226 */             .getItems().get(selectedIndex)).getClassStudentsList()
/* 227 */             .getCId().getSyId().getSyId().equals(Integer.valueOf(3))) {
/* 228 */             this.SA.ViewControl1_3();
/* 229 */           } else if (((Student)this.StudentsTable.getItems().get(selectedIndex)).getClassStudentsList()
/* 230 */             .getCId().getSyId().getSyId().equals(Integer.valueOf(4)) || ((Student)this.StudentsTable
/* 231 */             .getItems().get(selectedIndex)).getClassStudentsList()
/* 232 */             .getCId().getSyId().getSyId().equals(Integer.valueOf(5)) || ((Student)this.StudentsTable
/* 233 */             .getItems().get(selectedIndex)).getClassStudentsList()
/* 234 */             .getCId().getSyId().getSyId().equals(Integer.valueOf(6))) {
/* 235 */             this.SA.ViewControl4_6();
/*     */           } else {
/* 237 */             Alert alert = new Alert(Alert.AlertType.WARNING);
/* 238 */             alert.setTitle("يوجد خطأ");
/* 239 */             alert.setHeaderText("خطأ");
/* 240 */             alert.setContentText("الطالب غير مقيد في الصفوف الابتدائية");
/* 241 */             alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 242 */             alert.showAndWait();
/*     */           } 
/*     */         } else {
/* 245 */           Alert alert = new Alert(Alert.AlertType.WARNING);
/* 246 */           alert.setTitle("يوجد خطأ");
/* 247 */           alert.setHeaderText("خطأ");
/* 248 */           alert.setContentText("برجاء تسجيل الفصل اولا");
/* 249 */           alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 250 */           alert.showAndWait();
/*     */         } 
/*     */       } else {
/* 253 */         Alert alert = new Alert(Alert.AlertType.WARNING);
/* 254 */         alert.setTitle("يوجد خطأ");
/* 255 */         alert.setHeaderText("لم يتم تحديد العنصر المراد عرضه");
/* 256 */         alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 257 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 258 */         alert.showAndWait();
/*     */       } 
/* 260 */     } catch (Exception e) {
/* 261 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleExpensesReport() {
/*     */     try {
/* 268 */       Properties prop = new Properties();
/* 269 */       String FileName = "config.properties";
/* 270 */       InputStream input = StudReportsController.class.getClassLoader().getResourceAsStream(FileName);
/* 271 */       prop.load(input);
/* 272 */       LOGGER.info("read successfully from prop file");
/* 273 */       int selectedIndex = this.StudentsTable.getSelectionModel().getSelectedIndex();
/* 274 */       if (selectedIndex >= 0) {
/* 275 */         JasperReport jasperReport = JasperCompileManager.compileReport(StudReportsController.class.getClassLoader().getResourceAsStream("Reports/AllstudentExpenses.jrxml"));
/* 276 */         HashMap<String, Object> parameters = new HashMap<String, Object>();
/* 277 */         parameters.put("Eid", Integer.valueOf(((Student)this.StudentsTable.getItems().get(selectedIndex)).getSId().intValue()));
/* 278 */         parameters.put("class_desc", ((Student)this.StudentsTable.getItems().get(selectedIndex)).getClassStudentsList().getCId().getClassDesc());
/* 279 */         String dbUrl = prop.getProperty("dbUrl");
/* 280 */         String dbDriver = prop.getProperty("dbDriver");
/* 281 */         String dbUname = prop.getProperty("dbUname");
/* 282 */         String dbPwd = prop.getProperty("dbPwd");
/* 283 */         Class.forName(dbDriver);
/* 284 */         LOGGER.debug("inside printing Student Expnses");
/*     */         
/* 286 */         Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
/* 287 */         JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
/*     */         
/* 289 */         File pdf = new File("D://تقرير مصاريف - " + ((Student)this.StudentsTable.getItems().get(selectedIndex)).getPId().getName() + ".pdf");
/*     */         
/* 291 */         FileOutputStream pdfx = new FileOutputStream(pdf, false);
/* 292 */         JasperExportManager.exportReportToPdfStream(print, pdfx);
/* 293 */         TimeUnit.SECONDS.sleep(5L);
/* 294 */         pdfx.close();
/* 295 */         LOGGER.debug("done printing Student Expenses");
/*     */       } else {
/* 297 */         Alert alert = new Alert(Alert.AlertType.WARNING);
/* 298 */         alert.setTitle("يوجد خطأ");
/* 299 */         alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
/* 300 */         alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 301 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 302 */         alert.showAndWait();
/*     */       } 
/* 304 */     } catch (Exception e) {
/* 305 */       e.printStackTrace();
/* 306 */       LOGGER.error("can't read from prop file " + e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleAbsentReport() {
/*     */     try {
/* 313 */       Properties prop = new Properties();
/* 314 */       String FileName = "config.properties";
/* 315 */       InputStream input = StudReportsController.class.getClassLoader().getResourceAsStream(FileName);
/* 316 */       prop.load(input);
/* 317 */       LOGGER.info("read successfully from prop file");
/* 318 */       int selectedIndex = this.StudentsTable.getSelectionModel().getSelectedIndex();
/* 319 */       if (selectedIndex >= 0) {
/* 320 */         JasperReport jasperReport = JasperCompileManager.compileReport(StudReportsController.class.getClassLoader().getResourceAsStream("Reports/AbsentStudent.jrxml"));
/* 321 */         HashMap<String, Object> parameters = new HashMap<String, Object>();
/* 322 */         parameters.put("Eid", Integer.valueOf(((Student)this.StudentsTable.getItems().get(selectedIndex)).getSId().intValue()));
/* 323 */         parameters.put("class_desc", ((Student)this.StudentsTable.getItems().get(selectedIndex)).getClassStudentsList().getCId().getClassDesc());
/* 324 */         String dbUrl = prop.getProperty("dbUrl");
/* 325 */         String dbDriver = prop.getProperty("dbDriver");
/* 326 */         String dbUname = prop.getProperty("dbUname");
/* 327 */         String dbPwd = prop.getProperty("dbPwd");
/* 328 */         Class.forName(dbDriver);
/* 329 */         LOGGER.debug("inside printing Student Expnses");
/*     */         
/* 331 */         Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
/* 332 */         JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
/*     */         
/* 334 */         File pdf = new File("D://تقرير غياب - " + ((Student)this.StudentsTable.getItems().get(selectedIndex)).getPId().getName() + ".pdf");
/*     */         
/* 336 */         FileOutputStream pdfx = new FileOutputStream(pdf, false);
/* 337 */         JasperExportManager.exportReportToPdfStream(print, pdfx);
/* 338 */         TimeUnit.SECONDS.sleep(5L);
/* 339 */         pdfx.close();
/* 340 */         LOGGER.debug("done printing Student Absent");
/*     */       } else {
/* 342 */         Alert alert = new Alert(Alert.AlertType.WARNING);
/* 343 */         alert.setTitle("يوجد خطأ");
/* 344 */         alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
/* 345 */         alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 346 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 347 */         alert.showAndWait();
/*     */       } 
/* 349 */     } catch (Exception e) {
/* 350 */       e.printStackTrace();
/* 351 */       LOGGER.error("can't read from prop file " + e.getMessage());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EditStudController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */