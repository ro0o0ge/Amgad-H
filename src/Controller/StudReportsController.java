/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Classes;
import Entity.StudyYears;
import amgad.h.StudentAffair;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class StudReportsController implements Initializable {

    @FXML
    private ComboBox sClass;

    @FXML
    private ComboBox ExpenseType;
    @FXML
    private ComboBox sClass1;

    @FXML
    private ComboBox sClass2;

    @FXML
    private ComboBox sClass3;
    @FXML
    private DatePicker fromDate;

    StudentAffair SA;
    private static final Logger logger = LogManager.getLogger(StudReportsController.class);

    Properties prop = new Properties();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
            String FileName = "config.properties";
//            InputStream input = new FileInputStream("../config.properties");
            InputStream input = StudReportsController.class.getClassLoader().getResourceAsStream(FileName);
            prop.load(input);
            logger.info("read successfully from prop file");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("can't read from prop file " + e.getMessage());
        }

        sClass.getItems().removeAll(sClass.getItems());
        sClass.getItems().addAll(getStudyYears());

        ExpenseType.getItems().removeAll(ExpenseType.getItems());
        ExpenseType.getItems().addAll("رسوم تعليم", "رسوم تعليم قسط أول", "رسوم تعليم قسط ثاني",
                "رسوم ضافية", "رسوم امتحان", "رسوم نشاط", "كتب وزارية", "كتب اجنبية",
                "زي", "زي تيشيرت صيفي", "زي تيشيرت شتوي", "زي بنطلون او جيبة", "زي جاكيت",
                "زي اضافي", "زي اضافي تيشيرت صيفي", "زي اضافي تيشيرت شتوي", "زي اضافي بنطلون او جيبة", "زي اضافي جاكيت",
                "اعفاء", "باص ترم اول", "باص ترم اول ذهاب", "باص ترم اول عودة ", "باص ترم ثاني", "باص ترم ثاني ذهاب", "باص ترم ثاني عودة "
        );
        sClass1.getItems().removeAll(sClass1.getItems());
        sClass1.getItems().addAll(getClasses());

        sClass2.getItems().removeAll(sClass2.getItems());
        sClass2.getItems().addAll(getClasses());

        sClass3.getItems().removeAll(sClass3.getItems());
        sClass3.getItems().addAll(getClasses());

    }

    private List<String> getStudyYears() {
        SA = new StudentAffair();
        List<String> StudY = new ArrayList<String>();
        List<StudyYears> css = SA.getSY();
        for (Iterator<StudyYears> iterator = css.iterator(); iterator.hasNext();) {
            StudY.add(iterator.next().getSyDesc());
        }
        return StudY;
    }

    private List<String> getClasses() {
        SA = new StudentAffair();
        List<String> StudY = new ArrayList<String>();
        for (Iterator<Classes> iterator = SA.getClasses().iterator(); iterator.hasNext();) {
            StudY.add(iterator.next().getClassDesc());
        }
        return StudY;
    }

    @FXML
    private void generateStudentsRecord() {
        if (!sClass.getSelectionModel().isEmpty()) {
            try {
//                StudReportsController.class.getClassLoader().getResourceAsStream("Reports/student_record.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(StudReportsController.class.getClassLoader().getResourceAsStream("Reports/student_record.jrxml"));
//        ("./src/Reports/student_record.jrxml");
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("class_ID", SA.getStudyYearbyDesc(sClass.getSelectionModel().getSelectedItem().toString()));
                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                logger.debug("inside printing student record");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

//                Exporter exporter = new JRDocxExporter();
//                exporter.setExporterInput(new SimpleExporterInput(print));
//                File Docx = new File("D://سجل الطلاب- "
//                        + sClass.getSelectionModel().getSelectedItem().toString()
//                        + ".docx");
//                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(Docx));
//                exporter.exportReport();
                File pdf = new File("D://سجل الطلاب- "
                        + sClass.getSelectionModel().getSelectedItem().toString()
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                logger.debug("done printing student record");
            } catch (Exception e) {
                logger.error("Can't print student record pdf " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء اختيار الصف ");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    private void generateStudentsExpenses() {
        if (!sClass1.getSelectionModel().isEmpty() && !ExpenseType.getSelectionModel().isEmpty()) {
            try {
                JasperReport jasperReport = JasperCompileManager.compileReport(StudReportsController.class.getClassLoader().getResourceAsStream("Reports/studentExpense.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("syId",
                        SA.getClassesDesc(sClass1.getSelectionModel().getSelectedItem().toString()));
                parameters.put("Eid",
                        SA.getExpensebyDesc(ExpenseType.getSelectionModel().getSelectedItem().toString()));
                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                logger.debug("inside printing student expense");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
                File pdf = new File("D:// " + ExpenseType.getSelectionModel().getSelectedItem().toString()
                        + " - ل " + sClass1.getSelectionModel().getSelectedItem().toString().replaceAll("/", "-")
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                logger.debug("done printing student expense");
            } catch (Exception e) {
                logger.error("Can't print student expense pdf " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء اختيار الصف و نوع المصروف ");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    private void generateClassList() {
        if (!sClass2.getSelectionModel().isEmpty()) {
            try {
                JasperReport jasperReport = JasperCompileManager.compileReport(StudReportsController.class.getClassLoader().getResourceAsStream("Reports/classLists.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("class_ID", SA.getClassesDesc(sClass2.getSelectionModel().getSelectedItem().toString()));
                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                logger.debug("inside printing Class List");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
                File pdf = new File("D://قائمة فصل -"
                        + sClass2.getSelectionModel().getSelectedItem().toString().replaceAll("/", "-")
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                logger.debug("done printing Class List");
            } catch (Exception e) {
                logger.error("Can't print Class List pdf " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء اختيار الصف ");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    private void generateClassAbsence() {
        if (!sClass3.getSelectionModel().isEmpty() && fromDate.getValue() != null) {
            try {
                System.out.println(Date.valueOf(fromDate.getValue()));
                JasperReport jasperReport = JasperCompileManager.compileReport(StudReportsController.class.getClassLoader().getResourceAsStream("Reports/AbsentClass.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("class_ID", SA.getClassesDesc(sClass3.getSelectionModel().getSelectedItem().toString()));
                parameters.put("DateExact", Date.valueOf(fromDate.getValue()).toString());

                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                logger.debug("inside printing Class Absence");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
                File pdf = new File("D://غياب فصل -"
                        + sClass3.getSelectionModel().getSelectedItem().toString().replaceAll("/", "-")
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                logger.debug("done printing Class Absence");
            } catch (Exception e) {
                logger.error("Can't print Class Absence pdf " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء اختيار الصف و التاريخ");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

}
