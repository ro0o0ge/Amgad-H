 package Controller;
 
 import Util.LoginSec;
 import amgad.h.Management;
 import amgad.h.StudentAffair;
 import amgad.h.TeachingStaff;
 import java.io.File;
 import java.io.FileOutputStream;
 import java.net.URL;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.util.HashMap;
 import java.util.ResourceBundle;
 import javafx.collections.ObservableSet;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.geometry.NodeOrientation;
 import javafx.print.PageLayout;
 import javafx.print.PageOrientation;
 import javafx.print.Paper;
 import javafx.print.Printer;
 import javafx.print.PrinterJob;
 import javafx.scene.Scene;
 import javafx.scene.control.Alert;
 import javafx.scene.layout.BorderPane;
 import javafx.scene.transform.Affine;
 import javafx.scene.transform.Rotate;
 import javafx.scene.transform.Transform;
 import net.sf.jasperreports.engine.JasperCompileManager;
 import net.sf.jasperreports.engine.JasperExportManager;
 import net.sf.jasperreports.engine.JasperFillManager;
 import net.sf.jasperreports.engine.JasperPrint;
 import net.sf.jasperreports.engine.JasperReport;
 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
 
 
 
 
 
 
 
 
 
 
 
 public class RootViewController
   implements Initializable
 {
/*  50 */   private static final Logger logger = LogManager.getLogger(RootViewController.class);
 
   
   private Management man;
   
   private StudentAffair sa;
   
   private TeachingStaff ts;
   
   Scene r;
   
   @FXML
   BorderPane border;
 
   
   public void initialize(URL url, ResourceBundle rb) {}
 
   
   public void setMainApp(Management m, StudentAffair s, TeachingStaff t, Scene r) {
/*  69 */     this.man = m;
/*  70 */     this.sa = s;
/*  71 */     this.ts = t;
/*  72 */     this.r = r;
   }
 
 
   
   @FXML
   private void handlePrint() {
     try {
/*  80 */       JasperReport jasperReport = JasperCompileManager.compileReport("./src/Reports/classLists.jrxml");
       
/*  82 */       HashMap<String, Object> parameters = new HashMap<String, Object>();
/*  83 */       parameters.put("class_ID", Integer.valueOf(32));
       
/*  85 */       String dbUrl = "jdbc:mysql://localhost:3306/amgad_sc";
       
/*  87 */       String dbDriver = "com.mysql.jdbc.Driver";
 
       
/*  90 */       String dbUname = "root";
 
       
/*  93 */       String dbPwd = "123456";
 
       
/*  96 */       Class.forName(dbDriver);
       
/*  98 */       logger.debug("in printing");
       
/* 100 */       Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
 
 
 
 
 
 
 
 
 
       
/* 111 */       JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
/* 112 */       File pdf = File.createTempFile("output", ".pdf", new File("D://"));
/* 113 */       JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
/* 114 */       logger.debug("in printing");
/* 115 */     } catch (Exception e) {
/* 116 */       System.out.println("Controller.RootViewController.handlePrint()");
/* 117 */       logger.error("Can't print pdf " + e.getLocalizedMessage());
     } 
   }
 
   
   @FXML
/* 123 */   private void handleNewStud() { this.sa.newStud(); }
 
 
   
   @FXML
/* 128 */   private void handleEditStud() { this.sa.editStud(); }
 
 
   
   @FXML
/* 133 */   private void handleStudAbsent() { this.sa.AbsentStud(); }
 
 
   
   @FXML
/* 138 */   private void handleClassStuds() { this.sa.ClassStudents(); }
 
 
   
   @FXML
/* 143 */   private void handleStudReports() { this.sa.ReportsStud(); }
 
 
 
   
   @FXML
/* 149 */   private void handleNewTeacher() { this.ts.newTeacher(); }
 
 
   
   @FXML
/* 154 */   private void handleEditTeacher() { this.ts.editTeacher(); }
 
 
   
   @FXML
/* 159 */   private void handleTeacherAbsent() { this.ts.AbsentTeacher(); }
 
 
   
   @FXML
/* 164 */   private void handleScedule() { this.ts.schedule(); }
 
 
   
   @FXML
/* 169 */   private void handleFinalGrades() { this.ts.FinalGrades(); }
 
 
   
   @FXML
/* 174 */   private void handleNewEmp() { this.man.newEmp(); }
 
 
   
   @FXML
/* 179 */   private void handleEditEmp() { this.man.editEmp(); }
 
 
   
   @FXML
/* 184 */   private void handleEmpAbsent() { this.man.AbsentEmp(); }
 
 
   
   @FXML
/* 189 */   private void handleBoardDecision() { this.man.BoardDecision(); }
 
 
   
   @FXML
/* 194 */   private void handleSchoolExpense() { this.man.newSchoolExpense(); }
 
 
   
   @FXML
/* 199 */   private void handleBonus() { this.man.bonus(); }
 
 
   
   @FXML
/* 204 */   private void handlePenalty() { this.man.penalty(); }
 
 
   
   @FXML
/* 209 */   private void handleInsurance() { this.man.insurance(); }
 
 
   
   @FXML
/* 214 */   private void handleViewPayroll() { this.man.ViewPayroll(); }
 
 
   
   @FXML
/* 219 */   private void handleManReports() { this.man.ReportsMan(); }
 
 
 
 
   
   @FXML
   private void handleReports() {
/* 227 */     ObservableSet<Printer> orinters = Printer.getAllPrinters();
     
/* 229 */     for (Printer printer : orinters) {
/* 230 */       System.out.println(printer.getName());
     }
     
/* 233 */     PrinterJob job = PrinterJob.createPrinterJob();
 
     
/* 236 */     boolean printed = job.printPage(this.border);
/* 237 */     if (printed) {
/* 238 */       job.endJob();
     }
/* 240 */     PrinterJob pj = PrinterJob.createPrinterJob();
/* 241 */     PageLayout paisagem = pj.getPrinter().createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
     
/* 243 */     Rotate rotate = Transform.rotate(180.0D, this.r.getWidth() / 2.0D, this.r
/* 244 */         .getHeight() / 2.0D);
/* 245 */     Affine affine = Transform.affine(0.0D, 1.0D, 1.0D, 0.0D, 0.0D, 0.0D);
     
/* 247 */     this.r.getRoot().getTransforms().add(rotate);
/* 248 */     this.r.getRoot().getTransforms().add(affine);
     
/* 250 */     pj.getJobSettings().setPageLayout(paisagem);
/* 251 */     pj.showPrintDialog(this.r.getWindow());
/* 252 */     boolean printed1 = pj.printPage(this.border);
/* 253 */     if (printed1) {
/* 254 */       pj.endJob();
     }
   }
 
 
 
 
 
 
 
 
 
 
 
 
   
   @FXML
   private void handleAbout() {
/* 272 */     Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 273 */     alert.setTitle("مدرسة الأمجاد الخاصة");
/* 274 */     alert.setHeaderText("معلومات");
/* 275 */     alert.setContentText("بواسطة : عبدالله رمضان \n للتواصل: abdo.ramadan29@gmail.com");
/* 276 */     alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 277 */     alert.showAndWait();
   }
 
 
 
   
   @FXML
   private void handleExit() {
     try {
/* 286 */       LoginSec ls = new LoginSec();
/* 287 */       ls.HandleLogout();
/* 288 */     } catch (Exception e) {
/* 289 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 290 */       alert.setTitle("يوجد خطأ");
/* 291 */       alert.setHeaderText("برجاء مراجعة مالك البرنامج");
/* 292 */       alert.setContentText(e.getMessage());
/* 293 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 294 */       alert.showAndWait();
     } 
/* 296 */     System.exit(0);
   }
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\RootViewController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */