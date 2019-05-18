/*     */ package Controller;
/*     */ 
/*     */ import Entity.Staff;
/*     */ import amgad.h.Management;
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
/*     */ 
/*     */ public class EditEmpController
/*     */   implements Initializable
/*     */ {
/*     */   @FXML
/*     */   private TextField SearchQuery;
/*     */   @FXML
/*     */   private ComboBox ComboSearch;
/*     */   @FXML
/*     */   private TableView<Staff> TeachersTable;
/*     */   @FXML
/*     */   private TableColumn<Staff, String> NameColumn;
/*     */   @FXML
/*     */   private TableColumn<Staff, String> SignDateColumn;
/*     */   @FXML
/*     */   private TableColumn<Staff, String> SocialStatusColumn;
/*     */   @FXML
/*     */   private TableColumn<Staff, String> StatusColumn;
/*     */   Management TS;
/*  62 */   private static final Logger LOGGER = LogManager.getLogger(EditStudController.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/*  72 */     this.ComboSearch.getItems().removeAll(this.ComboSearch.getItems());
/*  73 */     this.ComboSearch.getItems().addAll(new Object[] { "الاسم", "الحالة الإجتماعية", "الحالة" });
/*  74 */     this.ComboSearch.getSelectionModel().select(1);
/*  75 */     if (!this.TeachersTable.getItems().isEmpty()) {
/*  76 */       this.TeachersTable.getItems().clear();
/*     */     }
/*  78 */     this.TeachersTable.setItems(Management.getPersonsList());
/*     */     
/*  80 */     this.NameColumn.setCellValueFactory(cellData -> ((Staff)cellData.getValue()).getPId().NameProperty());
/*  81 */     this.SignDateColumn.setCellValueFactory(cellData -> ((Staff)cellData.getValue()).getPId().HiringDateProperty());
/*  82 */     this.SocialStatusColumn.setCellValueFactory(cellData -> ((Staff)cellData.getValue()).getPId().maritalStatusProperty());
/*  83 */     this.StatusColumn.setCellValueFactory(cellData -> ((Staff)cellData.getValue()).statusProperty());
/*     */     
/*  85 */     this.TS = new Management();
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void Search() {
/*  90 */     if (!this.SearchQuery.getText().equals("")) {
/*  91 */       ObservableList<Staff> TempList = FXCollections.observableArrayList(this.TS.getTeachers());
/*  92 */       this.TeachersTable.getItems().clear();
/*  93 */       if (this.ComboSearch.getSelectionModel().isSelected(0)) {
/*  94 */         for (int i = 0; i < TempList.size(); i++) {
/*  95 */           if (!((Staff)TempList.get(i)).getPId().getName().contains(this.SearchQuery.getText())) {
/*  96 */             TempList.remove(i);
/*  97 */             i--;
/*     */           } 
/*     */         } 
/* 100 */         this.TeachersTable.setItems(TempList);
/* 101 */       } else if (this.ComboSearch.getSelectionModel().isSelected(2)) {
/* 102 */         for (int i = 0; i < TempList.size(); i++) {
/* 103 */           if (!((Staff)TempList.get(i)).statusProperty().toString().contains(this.SearchQuery.getText())) {
/* 104 */             TempList.remove(i);
/* 105 */             i--;
/*     */           } 
/*     */         } 
/* 108 */         this.TeachersTable.setItems(TempList);
/*     */       } else {
/* 110 */         for (int i = 0; i < TempList.size(); i++) {
/* 111 */           if (!((Staff)TempList.get(i)).getPId().maritalStatusProperty().toString().contains(this.SearchQuery.getText())) {
/* 112 */             TempList.remove(i);
/* 113 */             i--;
/*     */           } 
/*     */         } 
/* 116 */         this.TeachersTable.setItems(TempList);
/*     */       } 
/*     */     } else {
/* 119 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 120 */       alert.setTitle("يوجد خطأ");
/* 121 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/* 122 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/* 123 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 124 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleEdit() {
/* 130 */     int selectedIndex = this.TeachersTable.getSelectionModel().getSelectedIndex();
/* 131 */     if (selectedIndex >= 0) {
/* 132 */       Management.setEdit((Staff)this.TeachersTable.getItems().get(selectedIndex));
/* 133 */       this.TS.editTeacherDetail();
/*     */     } else {
/* 135 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 136 */       alert.setTitle("يوجد خطأ");
/* 137 */       alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
/* 138 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 139 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 140 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleView() {
/* 146 */     int selectedIndex = this.TeachersTable.getSelectionModel().getSelectedIndex();
/* 147 */     if (selectedIndex >= 0) {
/* 148 */       Management.setEdit((Staff)this.TeachersTable.getItems().get(selectedIndex));
/* 149 */       this.TS.ViewTeacher();
/*     */     } else {
/*     */       
/* 152 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 153 */       alert.setTitle("يوجد خطأ");
/* 154 */       alert.setHeaderText("لم يتم تحديد العنصر المراد عرضه");
/* 155 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 156 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 157 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleAbsentReport() {
/*     */     try {
/* 164 */       Properties prop = new Properties();
/* 165 */       String FileName = "config.properties";
/* 166 */       InputStream input = EditEmpController.class.getClassLoader().getResourceAsStream(FileName);
/* 167 */       prop.load(input);
/* 168 */       LOGGER.info("read successfully from prop file");
/* 169 */       int selectedIndex = this.TeachersTable.getSelectionModel().getSelectedIndex();
/* 170 */       if (selectedIndex >= 0) {
/* 171 */         JasperReport jasperReport = JasperCompileManager.compileReport(EditEmpController.class.getClassLoader().getResourceAsStream("Reports/AbsentEmp.jrxml"));
/* 172 */         HashMap<String, Object> parameters = new HashMap<String, Object>();
/* 173 */         parameters.put("Eid", Integer.valueOf(((Staff)this.TeachersTable.getItems().get(selectedIndex)).getPId().getPId().intValue()));
/* 174 */         String dbUrl = prop.getProperty("dbUrl");
/* 175 */         String dbDriver = prop.getProperty("dbDriver");
/* 176 */         String dbUname = prop.getProperty("dbUname");
/* 177 */         String dbPwd = prop.getProperty("dbPwd");
/* 178 */         Class.forName(dbDriver);
/* 179 */         LOGGER.debug("inside printing Employee Absent");
/*     */         
/* 181 */         Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
/* 182 */         JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
/*     */         
/* 184 */         File pdf = new File("D://تقرير غياب - " + ((Staff)this.TeachersTable.getItems().get(selectedIndex)).getPId().getName() + ".pdf");
/*     */         
/* 186 */         FileOutputStream pdfx = new FileOutputStream(pdf, false);
/* 187 */         JasperExportManager.exportReportToPdfStream(print, pdfx);
/* 188 */         TimeUnit.SECONDS.sleep(5L);
/* 189 */         pdfx.close();
/* 190 */         LOGGER.debug("done printing Employee Absent");
/*     */       } else {
/* 192 */         Alert alert = new Alert(Alert.AlertType.WARNING);
/* 193 */         alert.setTitle("يوجد خطأ");
/* 194 */         alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
/* 195 */         alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 196 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 197 */         alert.showAndWait();
/*     */       } 
/* 199 */     } catch (Exception e) {
/* 200 */       e.printStackTrace();
/* 201 */       LOGGER.error("can't read from prop file " + e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleLateReport() {
/*     */     try {
/* 208 */       Properties prop = new Properties();
/* 209 */       String FileName = "config.properties";
/* 210 */       InputStream input = EditEmpController.class.getClassLoader().getResourceAsStream(FileName);
/* 211 */       prop.load(input);
/* 212 */       LOGGER.info("read successfully from prop file");
/* 213 */       int selectedIndex = this.TeachersTable.getSelectionModel().getSelectedIndex();
/* 214 */       if (selectedIndex >= 0) {
/* 215 */         JasperReport jasperReport = JasperCompileManager.compileReport(EditEmpController.class.getClassLoader().getResourceAsStream("Reports/LateEmp.jrxml"));
/* 216 */         HashMap<String, Object> parameters = new HashMap<String, Object>();
/* 217 */         parameters.put("Eid", Integer.valueOf(((Staff)this.TeachersTable.getItems().get(selectedIndex)).getPId().getPId().intValue()));
/* 218 */         String dbUrl = prop.getProperty("dbUrl");
/* 219 */         String dbDriver = prop.getProperty("dbDriver");
/* 220 */         String dbUname = prop.getProperty("dbUname");
/* 221 */         String dbPwd = prop.getProperty("dbPwd");
/* 222 */         Class.forName(dbDriver);
/* 223 */         LOGGER.debug("inside printing Employee Late");
/*     */         
/* 225 */         Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
/* 226 */         JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
/*     */         
/* 228 */         File pdf = new File("D://تقرير تأخير - " + ((Staff)this.TeachersTable.getItems().get(selectedIndex)).getPId().getName() + ".pdf");
/*     */         
/* 230 */         FileOutputStream pdfx = new FileOutputStream(pdf, false);
/* 231 */         JasperExportManager.exportReportToPdfStream(print, pdfx);
/* 232 */         TimeUnit.SECONDS.sleep(5L);
/* 233 */         pdfx.close();
/* 234 */         LOGGER.debug("done printing Employee Late");
/*     */       } else {
/* 236 */         Alert alert = new Alert(Alert.AlertType.WARNING);
/* 237 */         alert.setTitle("يوجد خطأ");
/* 238 */         alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
/* 239 */         alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 240 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 241 */         alert.showAndWait();
/*     */       } 
/* 243 */     } catch (Exception e) {
/* 244 */       e.printStackTrace();
/* 245 */       LOGGER.error("can't read from prop file " + e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleEvaluationReport() {
/*     */     try {
/* 252 */       Properties prop = new Properties();
/* 253 */       String FileName = "config.properties";
/* 254 */       InputStream input = EditEmpController.class.getClassLoader().getResourceAsStream(FileName);
/* 255 */       prop.load(input);
/* 256 */       LOGGER.info("read successfully from prop file");
/* 257 */       int selectedIndex = this.TeachersTable.getSelectionModel().getSelectedIndex();
/* 258 */       if (selectedIndex >= 0) {
/* 259 */         JasperReport jasperReport = JasperCompileManager.compileReport(EditEmpController.class.getClassLoader().getResourceAsStream("Reports/empEval.jrxml"));
/* 260 */         HashMap<String, Object> parameters = new HashMap<String, Object>();
/* 261 */         parameters.put("Eid", Integer.valueOf(((Staff)this.TeachersTable.getItems().get(selectedIndex)).getPId().getPId().intValue()));
/* 262 */         String dbUrl = prop.getProperty("dbUrl");
/* 263 */         String dbDriver = prop.getProperty("dbDriver");
/* 264 */         String dbUname = prop.getProperty("dbUname");
/* 265 */         String dbPwd = prop.getProperty("dbPwd");
/* 266 */         Class.forName(dbDriver);
/* 267 */         LOGGER.debug("inside printing Emp Evaluation");
/*     */         
/* 269 */         Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
/* 270 */         JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
/*     */         
/* 272 */         File pdf = new File("D://تقرير تقييم - " + ((Staff)this.TeachersTable.getItems().get(selectedIndex)).getPId().getName() + ".pdf");
/*     */         
/* 274 */         FileOutputStream pdfx = new FileOutputStream(pdf, false);
/* 275 */         JasperExportManager.exportReportToPdfStream(print, pdfx);
/* 276 */         TimeUnit.SECONDS.sleep(5L);
/* 277 */         pdfx.close();
/* 278 */         LOGGER.debug("done printing Emp Evaluation");
/*     */       } else {
/* 280 */         Alert alert = new Alert(Alert.AlertType.WARNING);
/* 281 */         alert.setTitle("يوجد خطأ");
/* 282 */         alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
/* 283 */         alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 284 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 285 */         alert.showAndWait();
/*     */       } 
/* 287 */     } catch (Exception e) {
/* 288 */       e.printStackTrace();
/* 289 */       LOGGER.error("can't read from prop file " + e.getMessage());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EditEmpController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */