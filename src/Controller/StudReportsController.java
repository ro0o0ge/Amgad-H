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
import java.time.LocalDate;
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

public class StudReportsController
        implements Initializable {

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
    private ComboBox sClass4;
    @FXML
    private DatePicker fromDate;
    StudentAffair SA;

    String dbUrl;
    String dbDriver;
    String dbUname;
    String dbPwd;

    /*  68 */    private static final Logger logger = LogManager.getLogger(StudReportsController.class);

    /*  70 */    Properties prop = new Properties();

    public void initialize(URL url, ResourceBundle rb) {
        try {
            /*  83 */ String FileName = "config.properties";

            /*  85 */ InputStream input = StudReportsController.class.getClassLoader().getResourceAsStream(FileName);
            /*  86 */ this.prop.load(input);
            /*  87 */ logger.info("read successfully from prop file");
            /*  88 */        } catch (Exception e) {
            /*  89 */ e.printStackTrace();
            /*  90 */ logger.error("can't read from prop file " + e.getMessage());
        }

        dbUrl = this.prop.getProperty("dbUrl");
        dbDriver = this.prop.getProperty("dbDriver");
        dbUname = this.prop.getProperty("dbUname");
        dbPwd = this.prop.getProperty("dbPwd");

        /*  93 */ this.sClass.getItems().removeAll(this.sClass.getItems());
        /*  94 */ this.sClass.getItems().addAll(getStudyYears());

        /*  96 */ this.ExpenseType.getItems().removeAll(this.ExpenseType.getItems());
        /*  97 */ this.ExpenseType.getItems().addAll(new Object[]{"رسوم تعليم", "رسوم تعليم قسط أول", "رسوم تعليم قسط ثاني", "رسوم إضافية", "رسوم امتحان", "رسوم نشاط", "كتب وزارية", "كتب اجنبية", "زي", "زي تيشيرت صيفي", "زي تيشيرت شتوي", "زي بنطلون او جيبة", "زي جاكيت", "زي اضافي", "زي اضافي تيشيرت صيفي", "زي اضافي تيشيرت شتوي", "زي اضافي بنطلون او جيبة", "زي اضافي جاكيت", "اعفاء", "باص ترم اول", "باص ترم اول ذهاب", "باص ترم اول عودة ", "باص ترم ثاني", "باص ترم ثاني ذهاب", "باص ترم ثاني عودة "});

        /* 103 */ this.sClass1.getItems().removeAll(this.sClass1.getItems());
        /* 104 */ this.sClass1.getItems().addAll(getStudyYears());

        /* 106 */ this.sClass2.getItems().removeAll(this.sClass2.getItems());
        /* 107 */ this.sClass2.getItems().addAll(getClasses());

        /* 109 */ this.sClass3.getItems().removeAll(this.sClass3.getItems());
        /* 110 */ this.sClass3.getItems().addAll(getClasses());

        this.sClass4.getItems().removeAll(this.sClass4.getItems());
        this.sClass4.getItems().addAll(getStudyYears());
    }

    private List<String> getStudyYears() {
        /* 115 */ this.SA = new StudentAffair();
        /* 116 */ List<String> StudY = new ArrayList<String>();
        /* 117 */ List<StudyYears> css = this.SA.getSY();
        /* 118 */ for (Iterator<StudyYears> iterator = css.iterator(); iterator.hasNext();) {
            /* 119 */ StudY.add(((StudyYears) iterator.next()).getSyDesc());
        }
        /* 121 */ return StudY;
    }

    private List<String> getClasses() {
        /* 125 */ this.SA = new StudentAffair();
        /* 126 */ List<String> StudY = new ArrayList<String>();
        /* 127 */ for (Iterator<Classes> iterator = this.SA.getClasses().iterator(); iterator.hasNext();) {
            /* 128 */ StudY.add(((Classes) iterator.next()).getClassDesc());
        }
        /* 130 */ return StudY;
    }

    @FXML
    private void generateStudentsRecord() {
        /* 135 */ if (!this.sClass.getSelectionModel().isEmpty()) {

            try {
                /* 138 */ JasperReport jasperReport = JasperCompileManager.compileReport(StudReportsController.class.getClassLoader().getResourceAsStream("Reports/student_record.jrxml"));

                /* 140 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
                System.out.println("Print Class_id " + this.SA.getStudyYearbyDesc(this.sClass.getSelectionModel().getSelectedItem().toString()));
                /* 141 */ parameters.put("class_ID", this.SA.getStudyYearbyDesc(this.sClass.getSelectionModel().getSelectedItem().toString()));
                /* 142 */ String dbUrl = this.prop.getProperty("dbUrl");
                /* 143 */ String dbDriver = this.prop.getProperty("dbDriver");
                /* 144 */ String dbUname = this.prop.getProperty("dbUname");
                /* 145 */ String dbPwd = this.prop.getProperty("dbPwd");
                /* 146 */ Class.forName(dbDriver);
                /* 147 */ logger.debug("inside printing student record");

                /* 149 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 150 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
                /* 160 */ File pdf = new File("D://سجل الطلاب- " + this.sClass.getSelectionModel().getSelectedItem().toString() + ".pdf");

                /* 162 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 163 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 164 */ TimeUnit.SECONDS.sleep(5L);
                /* 165 */ pdfx.close();
                /* 166 */ logger.debug("done printing student record");
                /* 167 */            } catch (Exception e) {
                /* 168 */ logger.error("Can't print student record pdf " + e.getLocalizedMessage());
                /* 169 */ e.printStackTrace();
            }
        } else {
            /* 172 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 173 */ alert.setTitle("خطأ");
            /* 174 */ alert.setHeaderText("خطأ");
            /* 175 */ alert.setContentText("برجاء اختيار الصف ");
            /* 176 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 177 */ alert.showAndWait();
        }
    }

    @FXML
    private void generateStudentsExpenses() {
        /* 183 */ if (!this.sClass1.getSelectionModel().isEmpty() && !this.ExpenseType.getSelectionModel().isEmpty()) {
            try {
                /* 185 */ JasperReport jasperReport = JasperCompileManager.compileReport(StudReportsController.class.getClassLoader().getResourceAsStream("Reports/studentExpense.jrxml"));
                /* 186 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
                /* 187 */ parameters.put("syId", this.SA
                        /* 188 */.getStudyYearbyDesc(this.sClass1.getSelectionModel().getSelectedItem().toString()));
                /* 189 */ parameters.put("Eid", this.SA
                        /* 190 */.getExpensebyDesc(this.ExpenseType.getSelectionModel().getSelectedItem().toString()));
                /* 191 */  dbUrl = this.prop.getProperty("dbUrl");
                /* 192 */  dbDriver = this.prop.getProperty("dbDriver");
                /* 193 */  dbUname = this.prop.getProperty("dbUname");
                /* 194 */  dbPwd = this.prop.getProperty("dbPwd");
                /* 195 */ Class.forName(dbDriver);
                /* 196 */ logger.debug("inside printing student expense");

                /* 198 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 199 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                /* 201 */ File pdf = new File("D:// " + this.ExpenseType.getSelectionModel().getSelectedItem().toString() + " - ل " + this.sClass1.getSelectionModel().getSelectedItem().toString().replaceAll("/", "-") + ".pdf");

                /* 203 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 204 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 205 */ TimeUnit.SECONDS.sleep(5L);
                /* 206 */ pdfx.close();
                /* 207 */ logger.debug("done printing student expense");
                /* 208 */            } catch (Exception e) {
                /* 209 */ logger.error("Can't print student expense pdf " + e.getLocalizedMessage());
                /* 210 */ e.printStackTrace();
            }
        } else {
            /* 213 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 214 */ alert.setTitle("خطأ");
            /* 215 */ alert.setHeaderText("خطأ");
            /* 216 */ alert.setContentText("برجاء اختيار الصف و نوع المصروف ");
            /* 217 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 218 */ alert.showAndWait();
        }
    }

    @FXML
    private void generateClassList() {
        /* 224 */ if (!this.sClass2.getSelectionModel().isEmpty()) {
            try {
                /* 226 */ JasperReport jasperReport = JasperCompileManager.compileReport(StudReportsController.class.getClassLoader().getResourceAsStream("Reports/classLists.jrxml"));
                /* 227 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
                /* 228 */ parameters.put("class_ID", this.SA.getClassesDesc(this.sClass2.getSelectionModel().getSelectedItem().toString()));
                /* 229 */ String dbUrl = this.prop.getProperty("dbUrl");
                /* 230 */ String dbDriver = this.prop.getProperty("dbDriver");
                /* 231 */ String dbUname = this.prop.getProperty("dbUname");
                /* 232 */ String dbPwd = this.prop.getProperty("dbPwd");
                /* 233 */ Class.forName(dbDriver);
                /* 234 */ logger.debug("inside printing Class List");

                /* 236 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 237 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                /* 239 */ File pdf = new File("D://قائمة فصل -" + this.sClass2.getSelectionModel().getSelectedItem().toString().replaceAll("/", "-") + ".pdf");

                /* 241 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 242 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 243 */ TimeUnit.SECONDS.sleep(5L);
                /* 244 */ pdfx.close();
                /* 245 */ logger.debug("done printing Class List");
                /* 246 */            } catch (Exception e) {
                /* 247 */ logger.error("Can't print Class List pdf " + e.getLocalizedMessage());
                /* 248 */ e.printStackTrace();
            }
        } else {
            /* 251 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 252 */ alert.setTitle("خطأ");
            /* 253 */ alert.setHeaderText("خطأ");
            /* 254 */ alert.setContentText("برجاء اختيار الصف ");
            /* 255 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 256 */ alert.showAndWait();
        }
    }

    @FXML
    private void generateClassAbsence() {
        /* 262 */ if (!this.sClass3.getSelectionModel().isEmpty() && this.fromDate.getValue() != null) {
            try {
                /* 264 */ System.out.println(Date.valueOf((LocalDate) this.fromDate.getValue()));
                /* 265 */ JasperReport jasperReport = JasperCompileManager.compileReport(StudReportsController.class.getClassLoader().getResourceAsStream("Reports/AbsentClass.jrxml"));
                /* 266 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
                /* 267 */ parameters.put("class_ID", this.SA.getClassesDesc(this.sClass3.getSelectionModel().getSelectedItem().toString()));
                /* 268 */ parameters.put("DateExact", Date.valueOf((LocalDate) this.fromDate.getValue()).toString());

                /* 270 */ String dbUrl = this.prop.getProperty("dbUrl");
                /* 271 */ String dbDriver = this.prop.getProperty("dbDriver");
                /* 272 */ String dbUname = this.prop.getProperty("dbUname");
                /* 273 */ String dbPwd = this.prop.getProperty("dbPwd");
                /* 274 */ Class.forName(dbDriver);
                /* 275 */ logger.debug("inside printing Class Absence");

                /* 277 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 278 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                /* 280 */ File pdf = new File("D://غياب فصل -" + this.sClass3.getSelectionModel().getSelectedItem().toString().replaceAll("/", "-") + ".pdf");

                /* 282 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 283 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 284 */ TimeUnit.SECONDS.sleep(5L);
                /* 285 */ pdfx.close();
                /* 286 */ logger.debug("done printing Class Absence");
                /* 287 */            } catch (Exception e) {
                /* 288 */ logger.error("Can't print Class Absence pdf " + e.getLocalizedMessage());
                /* 289 */ e.printStackTrace();
            }
        } else {
            /* 292 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 293 */ alert.setTitle("خطأ");
            /* 294 */ alert.setHeaderText("خطأ");
            /* 295 */ alert.setContentText("برجاء اختيار الصف و التاريخ");
            /* 296 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 297 */ alert.showAndWait();
        }
    }

    @FXML
    private void generate2ndInstalment() {
        /* 135 */ if (!this.sClass4.getSelectionModel().isEmpty()) {

            try {
                /* 138 */ JasperReport jasperReport = JasperCompileManager.compileReport(StudReportsController.class.getClassLoader().getResourceAsStream("Reports/student2ndInstalment.jrxml"));

                /* 140 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
                System.out.println("Print syId " + this.SA.getStudyYearbyDesc(this.sClass4.getSelectionModel().getSelectedItem().toString()));
                /* 141 */ parameters.put("syId", this.SA.getStudyYearbyDesc(this.sClass4.getSelectionModel().getSelectedItem().toString()));
                /* 142 */
 /* 146 */ Class.forName(dbDriver);
                /* 147 */ logger.debug("inside printing 2nd instalment");

                /* 149 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 150 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
                /* 160 */ File pdf = new File("D://القسط الثاني - " + this.sClass4.getSelectionModel().getSelectedItem().toString() + ".pdf");

                /* 162 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 163 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 164 */ TimeUnit.SECONDS.sleep(5L);
                /* 165 */ pdfx.close();
                /* 166 */ logger.debug("done printing 2nd instalment");
                /* 167 */            } catch (Exception e) {
                /* 168 */ logger.error("Can't print 2nd instalment pdf " + e.getLocalizedMessage());
                /* 169 */ e.printStackTrace();
            }
        } else {
            /* 172 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 173 */ alert.setTitle("خطأ");
            /* 174 */ alert.setHeaderText("خطأ");
            /* 175 */ alert.setContentText("برجاء اختيار الصف ");
            /* 176 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 177 */ alert.showAndWait();
        }
    }
}


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\StudReportsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */
