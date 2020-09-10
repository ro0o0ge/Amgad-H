package Controller;

import Entity.StudyYears;
import Entity.Subjects;
import amgad.h.Management;
import java.awt.Desktop;
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
import javafx.beans.value.ObservableValue;
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

public class ManagementReportsController
        implements Initializable {

    @FXML
    private ComboBox ExpenseType;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    @FXML
    private DatePicker fromDate2;
    @FXML
    private DatePicker toDate2;
    @FXML
    private DatePicker fromDate3;
    @FXML
    private DatePicker toDate3;
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
    private ComboBox sClass4;
    @FXML
    private ComboBox sClass5;
    @FXML
    private ComboBox sSubjects3;

    @FXML
    private ComboBox sData;
    @FXML
    private ComboBox cmonth;
    @FXML
    private ComboBox cyear;
    /*  74 */    Management SA = new Management();
    /*  75 */    private static final Logger logger = LogManager.getLogger(ManagementReportsController.class);

    /*  77 */    Properties prop = new Properties();

    public void initialize(URL url, ResourceBundle rb) {
        try {
            /*  89 */ String FileName = "config.properties";

            /*  91 */ InputStream input = ManagementReportsController.class.getClassLoader().getResourceAsStream(FileName);
            /*  92 */ prop.load(input);
            /*  93 */ logger.info("read successfully from prop file");
            /*  94 */        } catch (Exception e) {
            /*  95 */ e.printStackTrace();
            /*  96 */ logger.error("can't read from prop file " + e.getMessage());
        }

        /*  99 */ ExpenseType.getItems().removeAll(ExpenseType.getItems());
        /* 100 */ ExpenseType.getItems().addAll(new Object[]{"فواتير مياه", "فواتير كهرباء", "فواتير تليفون", "سباكة", "نجارة", "كهرباء", "حدادة", "الوميتال", "ادوات نظافة", "مصاريف متنوعة", "تفويل باص 7215", "تفويل باص 7214", "تفويل باص 7234", "تفويل باص 9538", "صيانة باص 7215", "صيانة باص 7214", "صيانة باص 7234", "صيانة باص 9538"});

        /* 112 */ sClass.getItems().removeAll(sClass.getItems());
        /* 113 */ sClass.getItems().addAll(getStudyYears());

        /* 115 */ sClass1.getItems().removeAll(sClass1.getItems());
        /* 116 */ sClass1.getItems().addAll(getStudyYears());
        /* 117 */ sClass1.valueProperty().addListener((ov, oldValue, newValue) -> {
            /* 118 */ sSubjects.getItems().removeAll(sSubjects.getItems());
            /* 119 */ sSubjects.getItems().addAll(getStudyYearsSubjects(newValue.toString()));
        });

        /* 122 */ sClass2.getItems().removeAll(sClass2.getItems());
        /* 123 */ sClass2.getItems().addAll(getStudyYears());

        /* 125 */ sClass3.getItems().removeAll(sClass3.getItems());
        /* 126 */ sClass3.getItems().addAll(getStudyYears());
        /* 127 */ sClass3.valueProperty().addListener((ov, oldValue, newValue) -> {
            /* 128 */ sSubjects3.getItems().removeAll(sSubjects3.getItems());
            /* 129 */ sSubjects3.getItems().addAll(getStudyYearsSubjects(newValue.toString()));
        });

        sClass4.getItems().removeAll(sClass4.getItems());
        sClass4.getItems().addAll(getStudyYears());
        
        sClass5.getItems().removeAll(sClass5.getItems());
        sClass5.getItems().addAll(getStudyYears());
        
        sData.getItems().removeAll(sData.getItems());
        sData.getItems().addAll(new Object[]{"المدرسات", "الاداريات"});

        /* 132 */ cmonth.getItems().removeAll(cmonth.getItems());
        /* 133 */ cmonth.getItems().addAll(new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});

        /* 135 */ cyear.getItems().removeAll(cyear.getItems());
        /* 136 */ cyear.getItems().addAll(new Object[]{"2018", "2019", "2020"});
    }

    private List<String> getStudyYears() {
        /* 140 */ SA = new Management();
        /* 141 */ List<String> StudY = new ArrayList<String>();
        /* 142 */ List<StudyYears> css = SA.getSY();
        /* 143 */ for (Iterator<StudyYears> iterator = css.iterator(); iterator.hasNext();) {
            /* 144 */ StudY.add(((StudyYears) iterator.next()).getSyDesc());
        }
        /* 146 */ return StudY;
    }

    private List<String> getStudyYearsSubjects(String syDesc) {
        /* 150 */ SA = new Management();
        /* 151 */ List<String> StudY = new ArrayList<String>();
        /* 152 */ List<Subjects> css = SA.getSYSubjects(syDesc);
        /* 153 */ for (Iterator<Subjects> iterator = css.iterator(); iterator.hasNext();) {
            /* 154 */ StudY.add(((Subjects) iterator.next()).getSuDesc());
        }
        /* 156 */ return StudY;
    }

    @FXML
    private void generateSchoolExpenses() {
        /* 161 */ if (!ExpenseType.getSelectionModel().isEmpty() && fromDate
                /* 162 */.getValue() != null && toDate.getValue() != null) {

            try {
//                /* 165 */ System.out.println(Date.valueOf((LocalDate) fromDate.getValue()));
//                /* 166 */ System.out.println(toDate.toString());

                /* 168 */ JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().getResourceAsStream("Reports/schoolExpense.jrxml"));
                /* 169 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
                /* 170 */ parameters.put("from", Date.valueOf((LocalDate) fromDate.getValue()).toString());
                /* 171 */ parameters.put("to", Date.valueOf((LocalDate) toDate.getValue()).toString());

                /* 173 */ parameters.put("Eid", SA.getExpensebyDesc(ExpenseType.getSelectionModel().getSelectedItem().toString()));
                /* 174 */ String dbUrl = prop.getProperty("dbUrl");
                /* 175 */ String dbDriver = prop.getProperty("dbDriver");
                /* 176 */ String dbUname = prop.getProperty("dbUname");
                /* 177 */ String dbPwd = prop.getProperty("dbPwd");
                /* 178 */ Class.forName(dbDriver);
                /* 179 */ logger.debug("inside printing School expense");

                /* 181 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 182 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                /* 184 */ File pdf = new File("D://مصاريف " + ExpenseType.getSelectionModel().getSelectedItem().toString() + ".pdf");

                /* 186 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 187 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 188 */ TimeUnit.SECONDS.sleep(5L);
                /* 189 */ pdfx.close();
                if (Desktop.isDesktopSupported()) 
                    Desktop.getDesktop().open(pdf);
                /* 190 */ logger.debug("done printing School expense");
            } catch (Exception e) {
                /* 192 */ logger.error("Can't print School expense pdf " + e.getMessage());

                /* 194 */ Alert alert = new Alert(Alert.AlertType.ERROR);
                /* 195 */ alert.setTitle("خطأ");
                /* 196 */ alert.setHeaderText("خطأ");
                /* 197 */ alert.setContentText(e.getMessage());
                /* 198 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                /* 199 */ alert.showAndWait();
            }
        } else {
            /* 202 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 203 */ alert.setTitle("خطأ");
            /* 204 */ alert.setHeaderText("خطأ");
            /* 205 */ alert.setContentText("برجاء اختيار التاريخ و نوع المصروف ");
            /* 206 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 207 */ alert.showAndWait();
        }
    }

    @FXML
    private void generateControl1st() {
        /* 213 */ if (!sClass.getSelectionModel().isEmpty()) {

            try {
                /* 216 */ JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().getResourceAsStream("Reports/control_first.jrxml"));
                /* 217 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
                /* 218 */ parameters.put("class_ID", SA.getStudyYearbyDesc(sClass.getSelectionModel().getSelectedItem().toString()));
                /* 219 */ String dbUrl = prop.getProperty("dbUrl");
                /* 220 */ String dbDriver = prop.getProperty("dbDriver");
                /* 221 */ String dbUname = prop.getProperty("dbUname");
                /* 222 */ String dbPwd = prop.getProperty("dbPwd");
                /* 223 */ Class.forName(dbDriver);
                /* 224 */ logger.debug("inside printing Control First semester");

                /* 226 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 227 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                /* 230 */ File pdf = new File("D://نتائج الفصل الدراسي الاول  - " + sClass.getSelectionModel().getSelectedItem().toString() + ".pdf");

                /* 232 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 233 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 234 */ TimeUnit.SECONDS.sleep(5L);
                /* 235 */ pdfx.close();
                if (Desktop.isDesktopSupported()) 
                    Desktop.getDesktop().open(pdf);
                /* 236 */ logger.debug("done printing Control First semester");
                /* 237 */            } catch (Exception e) {
                /* 238 */ logger.error("Can't print Control First semester pdf " + e.getLocalizedMessage());
                /* 239 */ e.printStackTrace();
            }
        } else {
            /* 242 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 243 */ alert.setTitle("خطأ");
            /* 244 */ alert.setHeaderText("خطأ");
            /* 245 */ alert.setContentText("برجاء اختيار الصف ");
            /* 246 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 247 */ alert.showAndWait();
        }
    }

    @FXML
    private void generateControl1st_new() {
        /* 253 */ String sy = SA.getStudyYearbyDesc(sClass.getSelectionModel().getSelectedItem().toString()) + "";
        /* 254 */ if (sy.equals("1") || sy.equals("2") || sy.equals("3")) {
            /* 255 */ logger.debug("inside printing generateControl1st_new for years 1 , 2 or 3");

            /* 257 */ printReport("control_first_1_2_3", sy);
        } /* 259 */ else if (sy.equals("4") || sy.equals("5") || sy.equals("6")) {
            /* 260 */ logger.debug("inside printing generateControl1st_new for years 4 , 5 or 6");

            /* 262 */ printReport("control_first_4_5_6", sy);
        }
    }

    private void printReport(String filename, String sy_ID) {
        try {
            /* 271 */ JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().getResourceAsStream("Reports/" + filename + ".jrxml"));
            /* 272 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
            /* 273 */ parameters.put("class_ID", SA.getStudyYearbyDesc(sClass.getSelectionModel().getSelectedItem().toString()));
            /* 274 */ String dbUrl = prop.getProperty("dbUrl");
            /* 275 */ String dbDriver = prop.getProperty("dbDriver");
            /* 276 */ String dbUname = prop.getProperty("dbUname");
            /* 277 */ String dbPwd = prop.getProperty("dbPwd");
            /* 278 */ Class.forName(dbDriver);
            /* 279 */ logger.debug("inside printing Control First semester");

            /* 281 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
            /* 282 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

            /* 285 */ File pdf = new File("D://نتائج الفصل الدراسي الاول  - " + sClass.getSelectionModel().getSelectedItem().toString() + ".pdf");

            /* 287 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
            /* 288 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
            /* 289 */ TimeUnit.SECONDS.sleep(5L);
            /* 290 */ pdfx.close();
            if (Desktop.isDesktopSupported()) 
                    Desktop.getDesktop().open(pdf);
            /* 291 */ logger.debug("done printing Control First semester");
            /* 292 */        } catch (Exception e) {
            /* 293 */ logger.error("Can't print Control First semester pdf " + e.getLocalizedMessage());
            /* 294 */ e.printStackTrace();
        }
    }

    private void printReport2nd(String filename, String sy_ID) {
        try {
            /* 271 */ JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().getResourceAsStream("Reports/" + filename + ".jrxml"));
            /* 272 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
            /* 273 */ parameters.put("class_ID", SA.getStudyYearbyDesc(sClass2.getSelectionModel().getSelectedItem().toString()));
            /* 274 */ String dbUrl = prop.getProperty("dbUrl");
            /* 275 */ String dbDriver = prop.getProperty("dbDriver");
            /* 276 */ String dbUname = prop.getProperty("dbUname");
            /* 277 */ String dbPwd = prop.getProperty("dbPwd");
            /* 278 */ Class.forName(dbDriver);
            /* 279 */ logger.debug("inside printing Control Second semester");

            /* 281 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
            /* 282 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

            /* 285 */ File pdf = new File("D://نتائج الفصل الدراسي الثاني  - " + sClass2.getSelectionModel().getSelectedItem().toString() + ".pdf");

            /* 287 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
            /* 288 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
            /* 289 */ TimeUnit.SECONDS.sleep(5L);
            /* 290 */ pdfx.close();
            if (Desktop.isDesktopSupported()) 
                    Desktop.getDesktop().open(pdf);
            /* 291 */ logger.debug("done printing Control Second semester");
            /* 292 */        } catch (Exception e) {
            /* 293 */ logger.error("Can't print Control Second semester pdf " + e.getLocalizedMessage());
            /* 294 */ e.printStackTrace();
        }
    }

    @FXML
    private void generateControl1stbySubjects() {
        /* 300 */ if (!sClass1.getSelectionModel().isEmpty() && !sSubjects.getSelectionModel().isEmpty()) {
            try {
                /* 302 */ JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader()
                        /* 303 */.getResourceAsStream("Reports/control_subject.jrxml"));
                /* 304 */ HashMap<String, Object> parameters = new HashMap<String, Object>();

                /* 306 */ Subjects subject = SA.getSubjectsByDescAndYDesc(sSubjects.getSelectionModel().getSelectedItem().toString(), sClass1
                        /* 307 */.getSelectionModel().getSelectedItem().toString());
                /* 308 */ parameters.put("class_ID", subject.getSyId().getSyId());
                /* 309 */ parameters.put("subject_id", subject.getSuId());
                /* 310 */ int fg = 100;
                /* 311 */ if (subject.getSuDesc().equals("رسم") || subject
                        /* 312 */.getSuDesc().equals("ألعاب") || subject.getSuDesc().equals("كمبيوتر") || subject
                        /* 313 */.getSuDesc().equals("نشاط اختياري 1") || subject.getSuDesc().equals("نشاط اختياري 2")) {
                    /* 314 */ fg = 10;
                }
                /* 316 */ parameters.put("final_grade", Integer.valueOf(fg));

                /* 318 */ String dbUrl = prop.getProperty("dbUrl");
                /* 319 */ String dbDriver = prop.getProperty("dbDriver");
                /* 320 */ String dbUname = prop.getProperty("dbUname");
                /* 321 */ String dbPwd = prop.getProperty("dbPwd");
                /* 322 */ Class.forName(dbDriver);
                /* 323 */ logger.debug("inside printing Control First semester");

                /* 325 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 326 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                /* 330 */ File pdf = new File("D://نتائج الفصل الدراسي الاول  - " + sClass1.getSelectionModel().getSelectedItem().toString() + " - مادة " + sSubjects.getSelectionModel().getSelectedItem().toString() + ".pdf");

                /* 332 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 333 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 334 */ TimeUnit.SECONDS.sleep(5L);
                /* 335 */ pdfx.close();
                if (Desktop.isDesktopSupported()) 
                    Desktop.getDesktop().open(pdf);
                /* 336 */ logger.debug("done printing Control First semester");
                /* 337 */            } catch (Exception e) {
                /* 338 */ logger.error("Can't print Control First semester pdf " + e.getLocalizedMessage());
                /* 339 */ e.printStackTrace();
            }
        } else {
            /* 342 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 343 */ alert.setTitle("خطأ");
            /* 344 */ alert.setHeaderText("خطأ");
            /* 345 */ alert.setContentText("برجاء اختيار الصف و المادة ");
            /* 346 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 347 */ alert.showAndWait();
        }
    }

    @FXML
    private void generateControl2nd() {
        /* 353 */ if (!sClass2.getSelectionModel().isEmpty()) {
            String sy = SA.getStudyYearbyDesc(sClass2.getSelectionModel().getSelectedItem().toString()) + "";
            /* 254 */ if (sy.equals("1") || sy.equals("2") || sy.equals("3")) {
                /* 255 */ logger.debug("inside printing generateControl2nd_new for years 1 , 2 or 3");

                /* 257 */ printReport2nd("control_second_1_2_3", sy);
            } /* 259 */ else if (sy.equals("4") || sy.equals("5") || sy.equals("6")) {
                /* 260 */ logger.debug("inside printing generateControl2nd_new for years 4 , 5 or 6");

                /* 262 */ printReport2nd("control_second_4_5_6", sy);
            }
//       try {
///* 355 */         JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().getResourceAsStream("Reports/control_second.jrxml"));
///* 356 */         HashMap<String, Object> parameters = new HashMap<String, Object>();
///* 357 */         parameters.put("class_ID", SA.getStudyYearbyDesc(sClass2.getSelectionModel().getSelectedItem().toString()));
///* 358 */         String dbUrl = prop.getProperty("dbUrl");
///* 359 */         String dbDriver = prop.getProperty("dbDriver");
///* 360 */         String dbUname = prop.getProperty("dbUname");
///* 361 */         String dbPwd = prop.getProperty("dbPwd");
///* 362 */         Class.forName(dbDriver);
///* 363 */         logger.debug("inside printing Control Second semester");
//         
///* 365 */         Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
///* 366 */         JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
// 
//         
///* 369 */         File pdf = new File("D://نتائج الفصل الدراسي الثاني  - " + sClass2.getSelectionModel().getSelectedItem().toString() + ".pdf");
//         
///* 371 */         FileOutputStream pdfx = new FileOutputStream(pdf, false);
///* 372 */         JasperExportManager.exportReportToPdfStream(print, pdfx);
///* 373 */         TimeUnit.SECONDS.sleep(5L);
///* 374 */         pdfx.close();
///* 375 */         logger.debug("done printing Control Second semester");
///* 376 */       } catch (Exception e) {
///* 377 */         logger.error("Can't print Control Second semester pdf " + e.getLocalizedMessage());
///* 378 */         e.printStackTrace();
//       } 
        } else {
            /* 381 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 382 */ alert.setTitle("خطأ");
            /* 383 */ alert.setHeaderText("خطأ");
            /* 384 */ alert.setContentText("برجاء اختيار الصف ");
            /* 385 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 386 */ alert.showAndWait();
        }
    }

    @FXML
    private void generateControl2ndbySubjects() {
        /* 392 */ if (!sClass3.getSelectionModel().isEmpty() && !sSubjects3.getSelectionModel().isEmpty()) {
            try {
                /* 394 */ JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader()
                        /* 395 */.getResourceAsStream("Reports/control_subject_second.jrxml"));
                /* 396 */ HashMap<String, Object> parameters = new HashMap<String, Object>();

                /* 398 */ Subjects subject = SA.getSubjectsByDescAndYDesc(sSubjects3.getSelectionModel().getSelectedItem().toString(), sClass3
                        /* 399 */.getSelectionModel().getSelectedItem().toString());
                /* 400 */ parameters.put("class_ID", subject.getSyId().getSyId());
                /* 401 */ parameters.put("subject_id", subject.getSuId());
                /* 402 */ int fg = 100;
                /* 403 */ if (subject.getSuDesc().equals("رسم") || subject.getSuDesc().equals("ألعاب") || subject
                        /* 404 */.getSuDesc().equals("كمبيوتر") || subject.getSuDesc().equals("نشاط اختياري 1") || subject
                        /* 405 */.getSuDesc().equals("نشاط اختياري 2")) {
                    /* 406 */ fg = 20;
                    /* 407 */                } else if (subject.getSuDesc().equals("رياضيات")) {
                    /* 408 */ fg = 80;
                    /* 409 */                } else if (subject.getSyId().getSyId().intValue() > 3 && (subject.getSuDesc().equals("علوم") || subject
                        /* 410 */.getSuDesc().equals("دين") || subject.getSuDesc().equals("دراسات اجتماعية") || subject
                        /* 411 */.getSuDesc().equals("لغة انجليزية") || subject.getSuDesc().equals("لغة فرنساوي"))) {
                    /* 412 */ fg = 40;
                    /* 413 */                } else if (subject.getSyId().getSyId().intValue() <= 3 && (subject.getSuDesc().equals("علوم") || subject
                        /* 414 */.getSuDesc().equals("دين") || subject.getSuDesc().equals("دراسات اجتماعية") || subject
                        /* 415 */.getSuDesc().equals("لغة انجليزية") || subject.getSuDesc().equals("لغة فرنساوي"))) {
                    /* 416 */ fg = 30;
                }
                /* 418 */ parameters.put("final_grade", Integer.valueOf(fg));

                /* 420 */ String dbUrl = prop.getProperty("dbUrl");
                /* 421 */ String dbDriver = prop.getProperty("dbDriver");
                /* 422 */ String dbUname = prop.getProperty("dbUname");
                /* 423 */ String dbPwd = prop.getProperty("dbPwd");
                /* 424 */ Class.forName(dbDriver);
                /* 425 */ logger.debug("inside printing Control Second semester");

                /* 427 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 428 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                /* 432 */ File pdf = new File("D://نتائج الفصل الدراسي الثاني  - " + sClass3.getSelectionModel().getSelectedItem().toString() + " - مادة " + sSubjects3.getSelectionModel().getSelectedItem().toString() + ".pdf");

                /* 434 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 435 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 436 */ TimeUnit.SECONDS.sleep(5L);
                /* 437 */ pdfx.close();
                if (Desktop.isDesktopSupported()) 
                    Desktop.getDesktop().open(pdf);
                /* 438 */ logger.debug("done printing Control Second semester");
                /* 439 */            } catch (Exception e) {
                /* 440 */ logger.error("Can't print Control Second semester pdf " + e.getLocalizedMessage());
                /* 441 */ e.printStackTrace();
            }
        } else {
            /* 444 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 445 */ alert.setTitle("خطأ");
            /* 446 */ alert.setHeaderText("خطأ");
            /* 447 */ alert.setContentText("برجاء اختيار الصف و المادة ");
            /* 448 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 449 */ alert.showAndWait();
        }
    }

    @FXML
    private void generateSalary() {
        /* 455 */ if (!cmonth.getSelectionModel().isEmpty() && !cyear.getSelectionModel().isEmpty()) {

            try {
                /* 459 */ JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().getResourceAsStream("Reports/payroll_1.jrxml"));
                /* 460 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
                /* 461 */ parameters.put("currMonth", Integer.valueOf(Integer.parseInt(cmonth.getSelectionModel().getSelectedItem().toString())));
                /* 462 */ parameters.put("year", Integer.valueOf(Integer.parseInt(cyear.getSelectionModel().getSelectedItem().toString())));
                /* 463 */ String dbUrl = prop.getProperty("dbUrl");
                /* 464 */ String dbDriver = prop.getProperty("dbDriver");
                /* 465 */ String dbUname = prop.getProperty("dbUname");
                /* 466 */ String dbPwd = prop.getProperty("dbPwd");
                /* 467 */ Class.forName(dbDriver);
                /* 468 */ logger.debug("inside printing salary");

                /* 470 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 471 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                /* 474 */ File pdf = new File("D://مرتبات شهر " + cmonth.getSelectionModel().getSelectedItem().toString() + " لسنة " + cyear.getSelectionModel().getSelectedItem().toString() + ".pdf");

                /* 476 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 477 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 478 */ TimeUnit.SECONDS.sleep(5L);
                /* 479 */ pdfx.close();
                if (Desktop.isDesktopSupported()) 
                    Desktop.getDesktop().open(pdf);
                /* 480 */ logger.debug("done printing salary");
                /* 481 */            } catch (Exception e) {
                /* 482 */ logger.error("Can't print salary pdf " + e.getMessage());
                /* 483 */ Alert alert = new Alert(Alert.AlertType.ERROR);
                /* 484 */ alert.setTitle("خطأ");
                /* 485 */ alert.setHeaderText("خطأ");
                /* 486 */ alert.setContentText(e.getMessage());
                /* 487 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                /* 488 */ alert.showAndWait();
            }
        } else {
            /* 491 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 492 */ alert.setTitle("خطأ");
            /* 493 */ alert.setHeaderText("خطأ");
            /* 494 */ alert.setContentText("برجاء اختيار الشهر والسنة ");
            /* 495 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 496 */ alert.showAndWait();
        }
    }

    @FXML
    private void generateEmpData() {
        if (!sData.getSelectionModel().isEmpty() && !sData.getSelectionModel().isEmpty()) {
            try {
                JasperReport jasperReport;
                if (sData.getSelectionModel().getSelectedItem().toString().equals("المدرسات")) {
                    jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().
                            getResourceAsStream("Reports/teachers_data.jrxml"));
                } else {
                    jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().
                            getResourceAsStream("Reports/staff_data.jrxml"));
                }

                HashMap<String, Object> parameters = new HashMap<String, Object>();

                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                logger.debug("inside printing emp data");

                Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                File pdf = new File("D://بيانات " + sData.getSelectionModel().getSelectedItem().toString() + ".pdf");

                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5L);
                pdfx.close();
                if (Desktop.isDesktopSupported()) 
                    Desktop.getDesktop().open(pdf);
                logger.debug("done printing emp data");
            } catch (Exception e) {
                logger.error("Can't print Control Second semester pdf " + e.getLocalizedMessage());
                logger.error(e.toString());
                e.printStackTrace();
            }
        } else {
            /* 444 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 445 */ alert.setTitle("خطأ");
            /* 446 */ alert.setHeaderText("خطأ");
            /* 447 */ alert.setContentText("برجاء اختيار نوع التقرير ");
            /* 448 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 449 */ alert.showAndWait();
        }
    }

    @FXML
    private void generateInvCostumes() {
        if (!sClass4.getSelectionModel().isEmpty() && fromDate2
                /* 162 */.getValue() != null && toDate2.getValue() != null) {
            try {
//                /* 165 */ System.out.println(Date.valueOf((LocalDate) fromDate.getValue()));
//                /* 166 */ System.out.println(toDate.toString());

                /* 168 */ JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().
                        getResourceAsStream("Reports/ InventoryReport-Customs.jrxml"));
                /* 169 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
                /* 170 */ parameters.put("from", Date.valueOf((LocalDate) fromDate2.getValue()).toString());
                /* 171 */ parameters.put("to", Date.valueOf((LocalDate) toDate2.getValue()).toString());

                parameters.put("class_ID", SA.getStudyYearbyDesc(sClass4.getSelectionModel().getSelectedItem().toString()));
                /* 174 */ String dbUrl = prop.getProperty("dbUrl");
                /* 175 */ String dbDriver = prop.getProperty("dbDriver");
                /* 176 */ String dbUname = prop.getProperty("dbUname");
                /* 177 */ String dbPwd = prop.getProperty("dbPwd");
                /* 178 */ Class.forName(dbDriver);
                /* 179 */ logger.debug("inside printing Inventory - Customs");

                /* 181 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 182 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                /* 184 */ File pdf = new File("D://جرد الزي " + sClass4.getSelectionModel().getSelectedItem().toString() + ".pdf");

                /* 186 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 187 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 188 */ TimeUnit.SECONDS.sleep(5L);
                /* 189 */ pdfx.close();
                if (Desktop.isDesktopSupported()) 
                    Desktop.getDesktop().open(pdf);
                /* 190 */ logger.debug("done printing Inventory - Customs");
            } catch (Exception e) {
                /* 192 */ logger.error("Can't print Inventory - Customs pdf " + e.getMessage());

                /* 194 */ Alert alert = new Alert(Alert.AlertType.ERROR);
                /* 195 */ alert.setTitle("خطأ");
                /* 196 */ alert.setHeaderText("خطأ");
                /* 197 */ alert.setContentText(e.getMessage());
                /* 198 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                /* 199 */ alert.showAndWait();
            }
        } else {
            /* 444 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 445 */ alert.setTitle("خطأ");
            /* 446 */ alert.setHeaderText("خطأ");
            /* 447 */ alert.setContentText("برجاء اختيار الصف و التاريخ ");
            /* 448 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 449 */ alert.showAndWait();
        }
    }

    @FXML
    private void generateInvConstants() {
        if (!sClass5.getSelectionModel().isEmpty() && fromDate3
                /* 162 */.getValue() != null && toDate3.getValue() != null) {
            try {
//                /* 165 */ System.out.println(Date.valueOf((LocalDate) fromDate.getValue()));
//                /* 166 */ System.out.println(toDate.toString());

                /* 168 */ JasperReport jasperReport = JasperCompileManager.compileReport(ManagementReportsController.class.getClassLoader().
                        getResourceAsStream("Reports/ InventoryReport-Constants.jrxml"));
                /* 169 */ HashMap<String, Object> parameters = new HashMap<String, Object>();
                /* 170 */ parameters.put("from", Date.valueOf((LocalDate) fromDate3.getValue()).toString());
                /* 171 */ parameters.put("to", Date.valueOf((LocalDate) toDate3.getValue()).toString());

                parameters.put("class_ID", SA.getStudyYearbyDesc(sClass5.getSelectionModel().getSelectedItem().toString()));
                /* 174 */ String dbUrl = prop.getProperty("dbUrl");
                /* 175 */ String dbDriver = prop.getProperty("dbDriver");
                /* 176 */ String dbUname = prop.getProperty("dbUname");
                /* 177 */ String dbPwd = prop.getProperty("dbPwd");
                /* 178 */ Class.forName(dbDriver);
                /* 179 */ logger.debug("inside printing Inventory - Constants");

                /* 181 */ Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
                /* 182 */ JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

                /* 184 */ File pdf = new File("D://جرد الثوابت " + sClass5.getSelectionModel().getSelectedItem().toString() + ".pdf");

                /* 186 */ FileOutputStream pdfx = new FileOutputStream(pdf, false);
                /* 187 */ JasperExportManager.exportReportToPdfStream(print, pdfx);
                /* 188 */ TimeUnit.SECONDS.sleep(5L);
                /* 189 */ pdfx.close();
                if (Desktop.isDesktopSupported()) 
                    Desktop.getDesktop().open(pdf);
                /* 190 */ logger.debug("done printing Inventory - Constants");
            } catch (Exception e) {
                /* 192 */ logger.error("Can't print Inventory - Constants pdf " + e.getMessage());

                /* 194 */ Alert alert = new Alert(Alert.AlertType.ERROR);
                /* 195 */ alert.setTitle("خطأ");
                /* 196 */ alert.setHeaderText("خطأ");
                /* 197 */ alert.setContentText(e.getMessage());
                /* 198 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                /* 199 */ alert.showAndWait();
            }
        } else {
            /* 444 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 445 */ alert.setTitle("خطأ");
            /* 446 */ alert.setHeaderText("خطأ");
            /* 447 */ alert.setContentText("برجاء اختيار الصف و التاريخ ");
            /* 448 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 449 */ alert.showAndWait();
        }
    }

}

/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\ManagementReportsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */
