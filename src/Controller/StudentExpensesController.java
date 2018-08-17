/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Student;
import Entity.StudentExpenses;
import amgad.h.StudentAffair;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
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
public class StudentExpensesController implements Initializable {

    @FXML
    private TextField SearchQuery;
    @FXML
    private TextField Amount;
    @FXML
    private TextField RecievedBy;
    @FXML
    private TextArea Notes;
    @FXML
    private DatePicker EDate;
    @FXML
    private CheckBox Recieved;
    @FXML
    private TableView<StudentExpenses> StudentExpensesTable;
    @FXML
    private TableColumn<StudentExpenses, String> RecievedColumn;
    @FXML
    private TableColumn<StudentExpenses, String> AmountColumn;
    @FXML
    private TableColumn<StudentExpenses, String> DateColumn;
    @FXML
    private TableColumn<StudentExpenses, String> TypeColumn;
    @FXML
    private ComboBox ComboType;

    StudentAffair SA;
    StudentExpenses st;

    static private Student current;

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
        current = StudentAffair.getEdit();
        ComboType.getItems().removeAll(ComboType.getItems());
        ComboType.getItems().addAll("رسوم تعليم", "رسوم تعليم قسط أول", "رسوم تعليم قسط ثاني",
                "رسوم ضافية","رسوم امتحان", "رسوم نشاط", "كتب وزارية", "كتب اجنبية",
                "زي", "زي تيشيرت صيفي", "زي تيشيرت شتوي", "زي بنطلون او جيبة", "زي جاكيت",
                "زي اضافي", "زي اضافي تيشيرت صيفي", "زي اضافي تيشيرت شتوي", "زي اضافي بنطلون او جيبة", "زي اضافي جاكيت",
                "اعفاء","باص ترم اول","باص ترم اول ذهاب", "باص ترم اول عودة ","باص ترم ثاني","باص ترم ثاني ذهاب", "باص ترم ثاني عودة "
                );

        StudentExpensesTable.setItems(StudentAffair.getStudentExpensesList());
        RecievedColumn.setCellValueFactory(cellData -> cellData.getValue().RecievedProperty());
        AmountColumn.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
        DateColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
        TypeColumn.setCellValueFactory(cellData -> cellData.getValue().TypeProperty());
        StudentExpensesTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));

    }

    private void showDetails(StudentExpenses shera2) {
        if (shera2 != null) {
            // Fill the labels with info from the person object.

            Amount.setText(String.valueOf(shera2.getAmount()));
            RecievedBy.setText(shera2.getSteRecieved());
            Notes.setText(shera2.getSteNote());
            Calendar cal = Calendar.getInstance();
            cal.setTime(shera2.getSteDate());
            LocalDate date = LocalDate.of(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
            EDate.setValue(date);
            Recieved.setSelected(shera2.getSteStatus());
            ComboType.getSelectionModel().select(shera2.getSteType());
        } else {
            Amount.setText("");
            RecievedBy.setText("");
            Notes.setText("");
            EDate.setValue(null);
            ComboType.getSelectionModel().clearSelection();
            Recieved.setSelected(false);
        }
    }

    @FXML
    public void Search() {
        if (!SearchQuery.getText().equals("")) {
            ObservableList<StudentExpenses> TempList = FXCollections.observableArrayList(SA.getStudentExpensesList());
            StudentExpensesTable.getItems().clear();

            for (int i = 0; i < TempList.size(); i++) {
                if (!TempList.get(i).DateProperty().toString().contains(SearchQuery.getText())) {
                    TempList.remove(i);
                    i--;
                }
            }
            StudentExpensesTable.setItems(TempList);

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
    public void handleNew() {
        if (!Amount.getText().equals("") && ComboType.getSelectionModel().getSelectedIndex() != -1
                && EDate.getValue() != null) {
            st = new StudentExpenses();
            st.setAmount(Double.valueOf(Amount.getText()));
            st.setSteNote(Notes.getText());
            st.setSteRecieved(RecievedBy.getText());
            st.setSteDate(Date.valueOf(EDate.getValue()));
            st.setSteType(ComboType.getSelectionModel().getSelectedItem().toString());
            st.setSteStatus(Recieved.isSelected());
            st.setSId(current);
            SA.PersistStudentExpense(st);
            showDetails(null);
            StudentExpensesTable.getItems().clear();
            StudentExpensesTable.setItems(SA.getStudentExpensesList());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء التأكد من صحة البيانات");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleEdit() {
        if (!Amount.getText().equals("") && ComboType.getSelectionModel().getSelectedIndex() != -1
                && EDate.getValue() != null) {
            st = StudentExpensesTable.getSelectionModel().getSelectedItem();
            st.setAmount(Double.valueOf(Amount.getText()));
            st.setSteNote(Notes.getText());
            st.setSteRecieved(RecievedBy.getText());
            st.setSteDate(Date.valueOf(EDate.getValue()));
            st.setSteType(ComboType.getSelectionModel().getSelectedItem().toString());
            st.setSteStatus(Recieved.isSelected());
            SA.UpdateStudentExpense(st);
            StudentExpensesTable.setItems(StudentAffair.getStudentExpensesList());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء التأكد من صحة البيانات");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

}
