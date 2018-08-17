/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Student;
import amgad.h.StudentAffair;
import java.net.URL;
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
public class EditStudController implements Initializable {

    @FXML
    private TextField SearchQuery;
    @FXML
    private ComboBox ComboSearch;
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

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ComboSearch.getItems().removeAll(ComboSearch.getItems());
        ComboSearch.getItems().addAll("الاسم", "حالة الطالب", "الفصل");
        ComboSearch.getSelectionModel().select(1);
        if (!StudentsTable.getItems().isEmpty()) {
            StudentsTable.getItems().clear();
        }

        StudentsTable.setItems(StudentAffair.getPersonsList());

        NameColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().NameProperty());
        DOBColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().DOBProperty());
        AdmissionDateColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().createdDateProperty());
        StatusColumn.setCellValueFactory(cellData -> cellData.getValue().AgeOnOctProperty());
        ClassColumn.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cellData) -> {
            if (cellData.getValue().getClassStudentsList() != null) {
                return cellData.getValue().getClassStudentsList().getCId().ClassDescProperty();
            } else {
                return null;
            }
        });
        SA = new StudentAffair();
    }

    StudentAffair SA;

    @FXML
    public void Search() {
        if (!SearchQuery.getText().equals("")) {
            ObservableList<Student> TempList = FXCollections.observableArrayList(SA.getStudents());
            StudentsTable.getItems().clear();
            if (ComboSearch.getSelectionModel().isSelected(0)) {//name
                for (int i = 0; i < TempList.size(); i++) {
                    if (!TempList.get(i).getPId().getName().contains(SearchQuery.getText())) {
                        TempList.remove(i);
                        i--;
                    }
                }
                StudentsTable.setItems(TempList);
            } else if (ComboSearch.getSelectionModel().isSelected(1)) {//status
                System.out.println("size " + TempList.size());
                for (int i = 0; i < TempList.size(); i++) {
                    if (!TempList.get(i).statusProperty().toString().contains(SearchQuery.getText())) {
                        TempList.remove(i);
                        i--;
                    }
                }
                StudentsTable.setItems(TempList);
            } else {//class
                for (int i = 0; i < TempList.size(); i++) {
                    if (SearchQuery.getText().equals("  ")) {
                        if (TempList.get(i).getClassStudentsList() != null) {
                            TempList.remove(i);
                            i--;
                        }
                        break;
                    }
                    if (TempList.get(i).getClassStudentsList() != null) {
                        if (!TempList.get(i).getClassStudentsList().getCId().getClassDesc().contains(SearchQuery.getText())) {
                            TempList.remove(i);
                            i--;
                        }
                    } else if (TempList.get(i).getClassStudentsList() == null) {
                        TempList.remove(i);
                        i--;
                    }
                }
                StudentsTable.setItems(TempList);
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
        int selectedIndex = StudentsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            StudentAffair.setEdit(StudentsTable.getItems().get(selectedIndex));
            SA.editStudDetail();
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
        int selectedIndex = StudentsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            StudentAffair.setEdit(StudentsTable.getItems().get(selectedIndex));
            SA.ViewStudent();
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
    public void handleNotes() {
        int selectedIndex = StudentsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            StudentAffair.setEdit(StudentsTable.getItems().get(selectedIndex));
            SA.StudNotes();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لم يتم تحديد العنصر المراد إضافة ملاحظات له");
            alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleExpenses() {
        int selectedIndex = StudentsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            StudentAffair.setEdit(StudentsTable.getItems().get(selectedIndex));
            SA.editStudExpenses();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لم يتم تحديد العنصر المراد تعديله");
            alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }
}
