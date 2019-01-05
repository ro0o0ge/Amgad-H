/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Staff;
import amgad.h.Management;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
public class EditEmpController implements Initializable {

    @FXML
    private TextField SearchQuery;
    @FXML
    private ComboBox ComboSearch;
    @FXML
    private TableView<Staff> TeachersTable;
    @FXML
    private TableColumn<Staff, String> NameColumn;
    @FXML
    private TableColumn<Staff, String> SignDateColumn;
    @FXML
    private TableColumn<Staff, String> SocialStatusColumn;
    @FXML
    private TableColumn<Staff, String> StatusColumn;

    Management TS;
    
    private static final Logger LOGGER = LogManager.getLogger(EditStudController.class);

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ComboSearch.getItems().removeAll(ComboSearch.getItems());
        ComboSearch.getItems().addAll("الاسم", "الحالة الإجتماعية", "الحالة");
        ComboSearch.getSelectionModel().select(1);
        if (!TeachersTable.getItems().isEmpty()) {
            TeachersTable.getItems().clear();
        }
        TeachersTable.setItems(Management.getPersonsList());

        NameColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().NameProperty());
        SignDateColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().HiringDateProperty());
        SocialStatusColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().maritalStatusProperty());
        StatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        TS = new Management();
    }

    @FXML
    public void Search() {
        if (!SearchQuery.getText().equals("")) {
            ObservableList<Staff> TempList = FXCollections.observableArrayList(TS.getTeachers());
            TeachersTable.getItems().clear();
            if (ComboSearch.getSelectionModel().isSelected(0)) {//name
                for (int i = 0; i < TempList.size(); i++) {
                    if (!TempList.get(i).getPId().getName().contains(SearchQuery.getText())) {
                        TempList.remove(i);
                        i--;
                    }
                }
                TeachersTable.setItems(TempList);
            } else if (ComboSearch.getSelectionModel().isSelected(2)) {//status
                for (int i = 0; i < TempList.size(); i++) {
                    if (!TempList.get(i).statusProperty().toString().contains(SearchQuery.getText())) {
                        TempList.remove(i);
                        i--;
                    }
                }
                TeachersTable.setItems(TempList);
            } else {//social status
                for (int i = 0; i < TempList.size(); i++) {
                    if (!TempList.get(i).getPId().maritalStatusProperty().toString().contains(SearchQuery.getText())) {
                        TempList.remove(i);
                        i--;
                    }
                }
                TeachersTable.setItems(TempList);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لاتترك صندوق البحث فارغ");
            alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleEdit() {
        int selectedIndex = TeachersTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Management.setEdit(TeachersTable.getItems().get(selectedIndex));
            TS.editTeacherDetail();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
            alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleView() {
        int selectedIndex = TeachersTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Management.setEdit(TeachersTable.getItems().get(selectedIndex));
            TS.ViewTeacher();

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لم يتم تحديد العنصر المراد عرضه");
            alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleAbsentReport() {
        try {
            Properties prop = new Properties();
            String FileName = "config.properties";
            InputStream input = EditEmpController.class.getClassLoader().getResourceAsStream(FileName);
            prop.load(input);
            LOGGER.info("read successfully from prop file");
            int selectedIndex = TeachersTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                JasperReport jasperReport = JasperCompileManager.compileReport(EditEmpController.class.getClassLoader().getResourceAsStream("Reports/AbsentEmp.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("Eid", TeachersTable.getItems().get(selectedIndex).getPId().getPId().intValue());
                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                LOGGER.debug("inside printing Employee Absent");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
                File pdf = new File("D://تقرير غياب - "
                        + TeachersTable.getItems().get(selectedIndex).getPId().getName()
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                LOGGER.debug("done printing Employee Absent");
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
                alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("can't read from prop file " + e.getMessage());
        }
    }

    @FXML
    public void handleLateReport() {
        try {
            Properties prop = new Properties();
            String FileName = "config.properties";
            InputStream input = EditEmpController.class.getClassLoader().getResourceAsStream(FileName);
            prop.load(input);
            LOGGER.info("read successfully from prop file");
            int selectedIndex = TeachersTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                JasperReport jasperReport = JasperCompileManager.compileReport(EditEmpController.class.getClassLoader().getResourceAsStream("Reports/LateEmp.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("Eid", TeachersTable.getItems().get(selectedIndex).getPId().getPId().intValue());
                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                LOGGER.debug("inside printing Employee Late");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
                File pdf = new File("D://تقرير تأخير - "
                        + TeachersTable.getItems().get(selectedIndex).getPId().getName()
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                LOGGER.debug("done printing Employee Late");
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
                alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("can't read from prop file " + e.getMessage());
        }
    }

    @FXML
    public void handleEvaluationReport() {
        try {
            Properties prop = new Properties();
            String FileName = "config.properties";
            InputStream input = EditEmpController.class.getClassLoader().getResourceAsStream(FileName);
            prop.load(input);
            LOGGER.info("read successfully from prop file");
            int selectedIndex = TeachersTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                JasperReport jasperReport = JasperCompileManager.compileReport(EditEmpController.class.getClassLoader().getResourceAsStream("Reports/empEval.jrxml"));
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("Eid", TeachersTable.getItems().get(selectedIndex).getPId().getPId().intValue());
                String dbUrl = prop.getProperty("dbUrl");
                String dbDriver = prop.getProperty("dbDriver");
                String dbUname = prop.getProperty("dbUname");
                String dbPwd = prop.getProperty("dbPwd");
                Class.forName(dbDriver);
                LOGGER.debug("inside printing Emp Evaluation");
                Connection conn = DriverManager
                        .getConnection(dbUrl, dbUname, dbPwd);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
                File pdf = new File("D://تقرير تقييم - "
                        + TeachersTable.getItems().get(selectedIndex).getPId().getName()
                        + ".pdf");
                FileOutputStream pdfx = new FileOutputStream(pdf, false);
                JasperExportManager.exportReportToPdfStream(print, pdfx);
                TimeUnit.SECONDS.sleep(5);
                pdfx.close();
                LOGGER.debug("done printing Emp Evaluation");
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
                alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("can't read from prop file " + e.getMessage());
        }
    }

}