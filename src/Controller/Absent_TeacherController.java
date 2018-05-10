/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Teacher;
import amgad.h.TeachingStaff;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class Absent_TeacherController implements Initializable {

    @FXML
    private TextField SearchQuery;
    @FXML
    private TextField Duration;
    @FXML
    private DatePicker AbsentDate;
    @FXML
    private TextArea Notes;
    @FXML
    private TableView<Teacher> StudentsTable;
    @FXML
    private TableColumn<Teacher, String> NameColumn;
    @FXML
    private ComboBox ComboAbsentType;
    @FXML
    private ComboBox ComboTimeType;

    TeachingStaff MA;
    Teacher st;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ComboAbsentType.getItems().removeAll(ComboAbsentType.getItems());
        ComboAbsentType.getItems().addAll("تأخير", "استئذان", "عارضة", "مرضي", "سنوية", "غياب");
//        ComboAbsentType.getSelectionModel().select(1);
        //remove menubutton from fxml file

        ComboTimeType.getItems().removeAll(ComboTimeType.getItems());
        ComboTimeType.getItems().addAll("دقائق", "ايام");
//        ComboTimeType.getSelectionModel().select(1);

        if (!StudentsTable.getItems().isEmpty()) {
            StudentsTable.getItems().clear();
        }

        StudentsTable.setItems(TeachingStaff.getPersonsList());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().NameProperty());

        MA = new TeachingStaff();
    }

    @FXML
    public void Search() {
        if (!SearchQuery.getText().equals("")) {
            ObservableList<Teacher> TempList = FXCollections.observableArrayList(MA.getActiveTeachers());
            StudentsTable.getItems().clear();
            for (int i = 0; i < TempList.size(); i++) {
                if (!TempList.get(i).getPId().getName().contains(SearchQuery.getText())) {
                    TempList.remove(i);
                    i--;
                }
            }
            StudentsTable.setItems(TempList);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لاتترك صندوق البحث فارغ");
            alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    public void afterNew() {
        StudentsTable.setItems(TeachingStaff.getPersonsList());
        SearchQuery.setText("");
        Notes.setText("");
        Duration.setText("");
        AbsentDate.setValue(null);
    }

    @FXML
    public void handleNewAbsent() {
        st = StudentsTable.getSelectionModel().getSelectedItem();
        if (st != null && AbsentDate.getValue() != null
                && Duration.getText() != null && ComboAbsentType.getSelectionModel().getSelectedIndex() != -1
                && ComboTimeType.getSelectionModel().getSelectedIndex() != -1) {
            if (MA.PersistNewAbsent(Notes.getText(), st,
                    Date.valueOf(AbsentDate.getValue()),
                    ComboAbsentType.getSelectionModel().getSelectedItem().toString(),
                    ComboTimeType.getSelectionModel().getSelectedItem().toString(),
                    Duration.getText())) {
                afterNew();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("تم");
                alert.setHeaderText("تم الحفظ بنجاح");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("لم يتم الحفظ");
                alert.setContentText("برجاء الرجوع الى مالك البرنامج");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            }
        } else {
            if (st == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("لم يتم تحديد العنصر المراد حفظه");
                alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("برجاء التأكد من ادخال البيانات المطلوبة");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            }
        }

    }

    @FXML
    public void handleClose() {
        MA.getDialogStage().close();
    }

}
