/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.StudyYears;
import Entity.Subjects;
import amgad.h.Management;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class ManagementReportsController implements Initializable {

    @FXML
    private ComboBox ExpenseType;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;

    @FXML
    private ComboBox sClass;

    @FXML
    private ComboBox sClass1;
    @FXML
    private ComboBox sSubjects;

    @FXML
    private ComboBox sClass2;

    @FXML
    private ComboBox sClass3;
    @FXML
    private ComboBox sSubjects3;

    @FXML
    private ComboBox cmonth;
    @FXML
    private ComboBox cyear;

    Management SA = new Management();
    private static final Logger logger = LogManager.getLogger(ManagementReportsController.class);

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
            InputStream input = ManagementReportsController.class.getClassLoader().getResourceAsStream(FileName);
            prop.load(input);
            logger.info("read successfully from prop file");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("can't read from prop file " + e.getMessage());
        }

        ExpenseType.getItems().removeAll(ExpenseType.getItems());
        ExpenseType.getItems().addAll("فواتير مياه", "فواتير كهرباء",
                "فواتير تليفون", "سباكة", "نجارة", "كهرباء", "حدادة", "الوميتال", "ادوات نظافة",
                "مصاريف متنوعة",
                "تفويل باص 7215",
                "تفويل باص 7214",
                "تفويل باص 7234",
                "تفويل باص 9538",
                "صيانة باص 7215",
                "صيانة باص 7214",
                "صيانة باص 7234",
                "صيانة باص 9538");

        sClass.getItems().removeAll(sClass.getItems());
        sClass.getItems().addAll(getStudyYears());

        sClass1.getItems().removeAll(sClass1.getItems());
        sClass1.getItems().addAll(getStudyYears());
        sClass1.valueProperty().addListener((ov, oldValue, newValue) -> {
            sSubjects.getItems().removeAll(sSubjects.getItems());
            sSubjects.getItems().addAll(getStudyYearsSubjects(newValue.toString()));
        });

        sClass2.getItems().removeAll(sClass2.getItems());
        sClass2.getItems().addAll(getStudyYears());

        sClass3.getItems().removeAll(sClass3.getItems());
        sClass3.getItems().addAll(getStudyYears());
        sClass3.valueProperty().addListener((ov, oldValue, newValue) -> {
            sSubjects3.getItems().removeAll(sSubjects3.getItems());
            sSubjects3.getItems().addAll(getStudyYearsSubjects(newValue.toString()));
        });
        
        cmonth.getItems().removeAll(cmonth.getItems());
        cmonth.getItems().addAll("1", "2", "3","4", "5", "6","7", "8", "9","10", "11", "12");
        
        cyear.getItems().removeAll(cyear.getItems());
        cyear.getItems().addAll("2018", "2019", "2020");
    }

    private List<String> getStudyYears() {
        SA = new Management();
        List<String> StudY = new ArrayList<String>();
        List<StudyYears> css = SA.getSY();
        for (Iterator<StudyYears> iterator = css.iterator(); iterator.hasNext();) {
            StudY.add(iterator.next().getSyDesc());
        }
        return StudY;
    }

    private List<String> getStudyYearsSubjects(String syDesc) {
        SA = new Management();
        List<String> StudY = new ArrayList<String>();
        List<Subjects> css = SA.getSYSubjects(syDesc);
        for (Iterator<Subjects> iterator = css.iterator(); iterator.hasNext();) {
            StudY.add(iterator.next().getSuDesc());
        }
        return StudY;
    }

    @FXML
    private void generateSchoolExpenses() {
        if (!ExpenseType.getSelectionModel().isEmpty()
                && fromDate.getValue() != null && toDate.getValue() != null) {
            try {

                System.out.println(Date.valueOf(fromDate.getValue()));
                System.out.println(toDate.toString());
                JasperReport jasperReport
                        = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().getResourceAsStream("Reports/schoolExpense.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("from", Date.valueOf(fromDate.getValue()).toString());
                parameters.put("to", Date.valueOf(toDate.getValue()).toString());
//                System.out.println("Expense " + ExpenseType.getSelectionModel().getSelectedItem().toString());
                parameters.put("Eid", SA.getExpensebyDesc(ExpenseType.getSelectionModel().getSelectedItem().toString()));
                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                logger.debug("inside printing School expense");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
                File pdf = new File("D://مصاريف "
                        + ExpenseType.getSelectionModel().getSelectedItem().toString()
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                logger.debug("done printing School expense");
            } catch (Exception e) {
                logger.error("Can't print School expense pdf " + e.getMessage());
//                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("خطأ");
                alert.setHeaderText("خطأ");
                alert.setContentText(e.getMessage());
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء اختيار التاريخ و نوع المصروف ");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    private void generateControl1st() {
        if (!sClass.getSelectionModel().isEmpty()) {
            try {
                JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().getResourceAsStream("Reports/control_first.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("class_ID", SA.getStudyYearbyDesc(sClass.getSelectionModel().getSelectedItem().toString()));
                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                logger.debug("inside printing Control First semester");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                File pdf = new File("D://نتائج الفصل الدراسي الاول  - "
                        + sClass.getSelectionModel().getSelectedItem().toString()
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                logger.debug("done printing Control First semester");
            } catch (Exception e) {
                logger.error("Can't print Control First semester pdf " + e.getLocalizedMessage());
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
    private void generateControl1stbySubjects() {
        if (!sClass1.getSelectionModel().isEmpty() && !sSubjects.getSelectionModel().isEmpty()) {
            try {
                JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().
                        getResourceAsStream("Reports/control_subject.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();
//                int class_ID = SA.getStudyYearbyDesc(sClass1.getSelectionModel().getSelectedItem().toString());
                Subjects subject = SA.getSubjectsByDescAndYDesc(sSubjects.getSelectionModel().getSelectedItem().toString(),
                        sClass1.getSelectionModel().getSelectedItem().toString());
                parameters.put("class_ID", subject.getSyId().getSyId());
                parameters.put("subject_id", subject.getSuId());
                int fg = 100;
                if (subject.getSuDesc().equals("رسم")
                        || subject.getSuDesc().equals("ألعاب") || subject.getSuDesc().equals("كمبيوتر")
                        || subject.getSuDesc().equals("نشاط اختياري 1") || subject.getSuDesc().equals("نشاط اختياري 2")) {
                    fg = 10;
                }
                parameters.put("final_grade", fg);

                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                logger.debug("inside printing Control First semester");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                File pdf = new File("D://نتائج الفصل الدراسي الاول  - "
                        + sClass1.getSelectionModel().getSelectedItem().toString()
                        + " - مادة " + sSubjects.getSelectionModel().getSelectedItem().toString()
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                logger.debug("done printing Control First semester");
            } catch (Exception e) {
                logger.error("Can't print Control First semester pdf " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء اختيار الصف و المادة ");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    private void generateControl2nd() {
        if (!sClass2.getSelectionModel().isEmpty()) {
            try {
                JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().getResourceAsStream("Reports/control_second.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("class_ID", SA.getStudyYearbyDesc(sClass2.getSelectionModel().getSelectedItem().toString()));
                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                logger.debug("inside printing Control Second semester");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                File pdf = new File("D://نتائج الفصل الدراسي الثاني  - "
                        + sClass2.getSelectionModel().getSelectedItem().toString()
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                logger.debug("done printing Control Second semester");
            } catch (Exception e) {
                logger.error("Can't print Control Second semester pdf " + e.getLocalizedMessage());
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
    private void generateControl2ndbySubjects() {
        if (!sClass3.getSelectionModel().isEmpty() && !sSubjects3.getSelectionModel().isEmpty()) {
            try {
                JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().
                        getResourceAsStream("Reports/control_subject_second.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();

                Subjects subject = SA.getSubjectsByDescAndYDesc(sSubjects3.getSelectionModel().getSelectedItem().toString(),
                        sClass3.getSelectionModel().getSelectedItem().toString());
                parameters.put("class_ID", subject.getSyId().getSyId());
                parameters.put("subject_id", subject.getSuId());
                int fg = 100;
                if (subject.getSuDesc().equals("رسم") || subject.getSuDesc().equals("ألعاب")
                        || subject.getSuDesc().equals("كمبيوتر") || subject.getSuDesc().equals("نشاط اختياري 1")
                        || subject.getSuDesc().equals("نشاط اختياري 2")) {
                    fg = 20;
                } else if (subject.getSuDesc().equals("رياضيات")) {
                    fg = 80;
                } else if (subject.getSyId().getSyId() > 3 && (subject.getSuDesc().equals("علوم")
                        || subject.getSuDesc().equals("دين") || subject.getSuDesc().equals("دراسات اجتماعية")
                        || subject.getSuDesc().equals("لغة انجليزية") || subject.getSuDesc().equals("لغة فرنساوي"))) {
                    fg = 40;
                } else if (subject.getSyId().getSyId() <= 3 && (subject.getSuDesc().equals("علوم")
                        || subject.getSuDesc().equals("دين") || subject.getSuDesc().equals("دراسات اجتماعية")
                        || subject.getSuDesc().equals("لغة انجليزية") || subject.getSuDesc().equals("لغة فرنساوي"))) {
                    fg = 30;
                }
                parameters.put("final_grade", fg);

                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                logger.debug("inside printing Control Second semester");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                File pdf = new File("D://نتائج الفصل الدراسي الثاني  - "
                        + sClass3.getSelectionModel().getSelectedItem().toString()
                        + " - مادة " + sSubjects3.getSelectionModel().getSelectedItem().toString()
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                logger.debug("done printing Control Second semester");
            } catch (Exception e) {
                logger.error("Can't print Control Second semester pdf " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء اختيار الصف و المادة ");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    private void generateSalary() {
        if (!cmonth.getSelectionModel().isEmpty()&&!cyear.getSelectionModel().isEmpty()) {
            try {

                JasperReport jasperReport
                        = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().getResourceAsStream("Reports/payroll_1.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("currMonth", Integer.parseInt(cmonth.getSelectionModel().getSelectedItem().toString()));
                parameters.put("year", Integer.parseInt(cyear.getSelectionModel().getSelectedItem().toString()));
                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                logger.debug("inside printing salary");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
                File pdf = new File("D://مرتبات شهر "
                        + cmonth.getSelectionModel().getSelectedItem().toString()+" لسنة "
                        + cyear.getSelectionModel().getSelectedItem().toString()
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                logger.debug("done printing salary");
            } catch (Exception e) {
                logger.error("Can't print salary pdf " + e.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("خطأ");
                alert.setHeaderText("خطأ");
                alert.setContentText(e.getMessage());
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء اختيار الشهر والسنة ");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

}
