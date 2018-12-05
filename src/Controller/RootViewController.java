/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class RootViewController implements Initializable {

    private static final Logger logger = LogManager.getLogger(RootViewController.class);

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private Management man;
    private StudentAffair sa;
    private TeachingStaff ts;
    Scene r;

    public void setMainApp(Management m, StudentAffair s, TeachingStaff t, Scene r) {
        this.man = m;
        this.sa = s;
        this.ts = t;
        this.r = r;
    }

    @FXML
    private void handlePrint() throws Exception {

        try {
            // First, compile jrxml file.
            JasperReport jasperReport = JasperCompileManager.compileReport("./src/Reports/classLists.jrxml");
            // Fields for report
            HashMap<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("class_ID", 32);
//            String dbUrl = "jdbc:mysql://192.168.1.107:3306/amgad_sc";
            String dbUrl = "jdbc:mysql://localhost:3306/amgad_sc";
            // String dbDriver = props.getProperty("jdbc.driver");
            String dbDriver = "com.mysql.jdbc.Driver";
            // String dbUname = props.getProperty("db.username");
//            String dbUname = "amgad_root";
            String dbUname = "root";
            // String dbPwd = props.getProperty("db.password");
//            String dbPwd = "Amgad@123@Root";
            String dbPwd = "123456";

            // Load the JDBC driver
            Class.forName(dbDriver);
            // Get the connection
            logger.debug("in printing");
            Connection conn = DriverManager
                    .getConnection(dbUrl, dbUname, dbPwd);
//        String EXTENSION_RESOURCE_NAME = "jasper-extensions.properties";
//        List<ClassLoaderResource> extensionResources = JRLoader.getClassLoaderResources(
//                EXTENSION_RESOURCE_NAME);
//        for (ClassLoaderResource extensionResource : extensionResources) {
//            URL url = extensionResource.getUrl();
//            JRPropertiesMap properties = JRPropertiesMap.loadProperties(url);
//            
//        }

//        Font font = Font.createFont(Font.TRUETYPE_FONT,new File ("../lib/font/arial.ttf") );
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
            File pdf = File.createTempFile("output", ".pdf", new File("D://"));
            JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
            logger.debug("in printing");
        } catch (Exception e) {
            System.out.println("Controller.RootViewController.handlePrint()");
            logger.error("Can't print pdf " + e.getLocalizedMessage());
        }
    }

    @FXML
    private void handleNewStud() {
        sa.newStud();
    }

    @FXML
    private void handleEditStud() {
        sa.editStud();
    }

    @FXML
    private void handleStudAbsent() {
        sa.AbsentStud();
    }

    @FXML
    private void handleClassStuds() {
        sa.ClassStudents();
    }

    @FXML
    private void handleStudReports() {
        sa.ReportsStud();
    }
    
    @FXML

    private void handleNewTeacher() {
        ts.newTeacher();
    }

    @FXML
    private void handleEditTeacher() {
        ts.editTeacher();
    }

    @FXML
    private void handleTeacherAbsent() {
        ts.AbsentTeacher();
    }

    @FXML
    private void handleScedule() {
        ts.schedule();
    }

    @FXML
    private void handleFinalGrades() {
        ts.FinalGrades();
    }

    @FXML
    private void handleNewEmp() {
        man.newEmp();
    }

    @FXML
    private void handleEditEmp() {
        man.editEmp();
    }

    @FXML
    private void handleEmpAbsent() {
        man.AbsentEmp();
    }

    @FXML
    private void handleBoardDecision() {
        man.BoardDecision();
    }

    @FXML
    private void handleSchoolExpense() {
        man.newSchoolExpense();
    }

    @FXML
    private void handleBonus() {
        man.bonus();
    }

    @FXML
    private void handlePenalty() {
        man.penalty();
    }

    @FXML
    private void handleInsurance() {
        man.insurance();
    }

    @FXML
    private void handleViewPayroll() {
        man.ViewPayroll();
    }
    
    @FXML
    private void handleManReports() {
        man.ReportsMan();
    }

    @FXML
    BorderPane border;

    @FXML
    private void handleReports() {
        ObservableSet<Printer> orinters = Printer.getAllPrinters();

        for (Printer printer : orinters) {
            System.out.println(printer.getName());
        }

        PrinterJob job = PrinterJob.createPrinterJob();
//        job.showPrintDialog(this.r);

        boolean printed = job.printPage(border);
        if (printed) {
            job.endJob();
        }
        PrinterJob pj = PrinterJob.createPrinterJob();
        PageLayout paisagem = pj.getPrinter().createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);

        Rotate rotate = Transform.rotate(180.0, this.r.getWidth()
                / 2, this.r.getHeight() / 2);
        Affine affine = Transform.affine(0.0, 1.0, 1.0, 0.0, 0.0, 0.0);
        
        this.r.getRoot().getTransforms().add(rotate);
        this.r.getRoot().getTransforms().add(affine);
        
        pj.getJobSettings().setPageLayout(paisagem);
        pj.showPrintDialog(this.r.getWindow());
        boolean printed1 = pj.printPage(border);
        if (printed1) {
            pj.endJob();
        }
//        if () {
//            val rotate = Transform.rotate(90.0, documentRoot.width / 2, documentRoot.height / 2)
//            val affine = Transform.affine(0.0, 1.0, 1.0, 0.0, 0.0, 0.0)
//            documentRoot.transforms.add(rotate)
//            documentRoot.transforms.add(affine)
//            pj.printPage(documentRoot)
//            pj.endJob()
//            stage.hide()
//        }
    }

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("مدرسة الأمجاد الخاصة");
        alert.setHeaderText("معلومات");
        alert.setContentText("بواسطة : عبدالله رمضان \n للتواصل: abdo.ramadan29@gmail.com");
        alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        alert.showAndWait();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        try {
            LoginSec ls = new LoginSec();
            ls.HandleLogout();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("برجاء مراجعة مالك البرنامج");
            alert.setContentText(e.getMessage());
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
        System.exit(0);
    }
}
