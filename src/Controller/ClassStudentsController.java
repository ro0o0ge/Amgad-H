/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.ClassStudents;
import Entity.Classes;
import Entity.Student;
import amgad.h.StudentAffair;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class ClassStudentsController implements Initializable {

    @FXML
    private ComboBox ComboClass;
    @FXML
    private TextField SearchQuery;
    @FXML
    private TableView<Student> StudentsTable;
    @FXML
    private TableColumn<Student, String> NameColumn;
    @FXML
    private TableColumn<Student, String> StatusColumn;
    @FXML
    private TableColumn<Student, String> ClassColumn;
    @FXML
    private TableColumn<Student, String> AdmissionDateColumn;
    @FXML
    private TableColumn<Student, String> DOBColumn;

    @FXML
    private TableView<ClassStudents> StudentsInClassTable;
    @FXML
    private TableColumn<ClassStudents, String> StudNameColumn;
    @FXML
    private TableColumn<ClassStudents, String> StudSerialColumn;

    StudentAffair SA;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SA = new StudentAffair();
        ComboClass.getItems().clear();
        ComboClass.getItems().addAll(getClasses());
        ComboClass.valueProperty().addListener((ov, oldValue, newValue) -> {
            SA.LoadStudentsInClass(newValue.toString());
            StudentsInClassTable.setItems(SA.getStudentsInClassList());
        });

        if (!StudentsTable.getItems().isEmpty()) {
            StudentsTable.getItems().clear();
        }
        //table el students
        StudentsTable.setItems(StudentAffair.getPersonsList());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().NameProperty());
        DOBColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().DOBProperty());
        AdmissionDateColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().createdDateProperty());
        StatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        ClassColumn.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cellData) -> {
            if (cellData.getValue().getClassStudentsList() != null) {
                return cellData.getValue().getClassStudentsList().getCId().ClassDescProperty();
            } else {
                return null;
            }
        });
        //table el students in class
        StudNameColumn.setCellValueFactory(cellData -> cellData.getValue().getSId().getPId().NameProperty());
        StudSerialColumn.setCellValueFactory(cellData -> cellData.getValue().getSId().serialProperty());
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
    public void Search() {
        if (!SearchQuery.getText().equals("")) {
            ObservableList<Student> TempList = FXCollections.observableArrayList(SA.getStudents(2));
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

    @FXML
    public void handleAdd() {
        int selectedIndex = StudentsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ClassStudents cs = new ClassStudents();
            cs.setCId(SA.getClassesByDesc(ComboClass.getSelectionModel().getSelectedItem().toString()));
            cs.setSId(StudentsTable.getItems().get(selectedIndex));
            SA.PersistNewClassStudent(cs);
            
            StudentsTable.setItems(StudentAffair.getPersonsList());
            SA.LoadStudentsInClass(ComboClass.getSelectionModel().getSelectedItem().toString());
            StudentsInClassTable.setItems(SA.getStudentsInClassList());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لم يتم تحديد العنصر المراد إضافته");
            alert.setContentText("من فضلك قم بتحديد العنصر من الجدول بالأسفل");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleDel() {
        int selectedIndex = StudentsInClassTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            
            SA.RemoveClassStudent(StudentsInClassTable.getItems().get(selectedIndex));
            SA.getStudentsInClassList().remove(StudentsInClassTable.getItems().get(selectedIndex));
            
            StudentsTable.setItems(StudentAffair.getPersonsList());
            SA.LoadStudentsInClass(ComboClass.getSelectionModel().getSelectedItem().toString());
            StudentsInClassTable.setItems(SA.getStudentsInClassList());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
            alert.setContentText("من فضلك قم بتحديد العنصر من الجدول الجانبي");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }
}
