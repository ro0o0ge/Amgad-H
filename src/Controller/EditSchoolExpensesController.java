/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.SchoolExpenses;
import Entity.SchoolExpenses;
import amgad.h.Management;
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
public class EditSchoolExpensesController implements Initializable {

    @FXML
    private TextField SearchQuery;
    @FXML
    private TextField Amount;
    @FXML
    private TextField ExenseTo;
    @FXML
    private DatePicker EDate;
    @FXML
    private TextField ExenseBy;
    @FXML
    private TableView<SchoolExpenses> SchoolExpensesTable;
    @FXML
    private TableColumn<SchoolExpenses, String> ToColumn;
    @FXML
    private TableColumn<SchoolExpenses, String> ByColumn;
    @FXML
    private TableColumn<SchoolExpenses, String> DateColumn;
    @FXML
    private ComboBox ComboSearch;

    Management MA;

    SchoolExpenses st;

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
        ComboSearch.getItems().addAll("جهة الصرف", "التاريخ");

        MA = new Management();
        ComboSearch.getSelectionModel().select(0);

        SchoolExpensesTable.setItems(Management.getSchoolExpensesList());
        ToColumn.setCellValueFactory(cellData -> cellData.getValue().IssuedToProperty());
        ByColumn.setCellValueFactory(cellData -> cellData.getValue().IssuedByProperty());
        DateColumn.setCellValueFactory(cellData -> cellData.getValue().DDateProperty());

        SchoolExpensesTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));
    }

    private void showDetails(SchoolExpenses shera2) {
        if (shera2 != null) {
            // Fill the labels with info from the person object.

            Amount.setText(shera2.getAmount().toString());
            ExenseTo.setText(shera2.getIssuedTo());
            Calendar cal = Calendar.getInstance();
            cal.setTime(shera2.getSceDate());
            LocalDate date = LocalDate.of(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
            EDate.setValue(date);
            ExenseBy.setText(shera2.getIssuedBy());
        } else {
            Amount.setText("");
            ExenseTo.setText("");
            ExenseBy.setText("");
            EDate.setValue(null);
        }
    }

    @FXML
    public void Search() {
        if (!SearchQuery.getText().equals("")) {
            ObservableList<SchoolExpenses> TempList = FXCollections.observableArrayList(MA.getSchoolExpenses());
            SchoolExpensesTable.getItems().clear();

            if (ComboSearch.getSelectionModel().isSelected(0)) {//title
                for (int i = 0; i < TempList.size(); i++) {
                    if (!TempList.get(i).IssuedToProperty().toString().contains(SearchQuery.getText())) {
                        TempList.remove(i);
                        i--;
                    }
                }
                SchoolExpensesTable.setItems(TempList);
            } else {//date
                for (int i = 0; i < TempList.size(); i++) {
                    if (!TempList.get(i).DDateProperty().toString().contains(SearchQuery.getText())) {
                        TempList.remove(i);
                        i--;
                    }
                }
                SchoolExpensesTable.setItems(TempList);
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
    public void handleNew() {

        if (!Amount.getText().equals("") && !ExenseBy.getText().equals("")
                && EDate.getValue() != null && !ExenseTo.getText().equals("")) {
            st = new SchoolExpenses();
            st.setAmount(Double.valueOf(Amount.getText()));
            st.setIssuedBy(ExenseBy.getText());
            st.setIssuedTo(ExenseTo.getText());
            st.setSceDate(Date.valueOf(EDate.getValue()));
            MA.PersistSchoolExpense(st);
            showDetails(null);
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
        if (!Amount.getText().equals("") && !ExenseBy.getText().equals("")
                && EDate.getValue() != null && !ExenseTo.getText().equals("")) {
            st = SchoolExpensesTable.getSelectionModel().getSelectedItem();
            st.setAmount(Double.valueOf(Amount.getText()));
            st.setIssuedBy(ExenseBy.getText());
            st.setIssuedTo(ExenseTo.getText());
            st.setSceDate(Date.valueOf(EDate.getValue()));
            MA.UpdateSchoolExpense(st);
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
    public void handleClose() {
        Management.getDialogStage().close();
    }
}
