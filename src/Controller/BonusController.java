/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Persons;
import amgad.h.Management;
import java.net.URL;
import java.sql.Date;
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
public class BonusController implements Initializable {

    @FXML
    private TextField SearchQuery;
    @FXML
    private TextField Amount;
    @FXML
    private TextArea Notes;
    @FXML
    private DatePicker EDate;
    @FXML
    private CheckBox Recieved;
    @FXML
    private TableView<Persons> PayrollTable;
    @FXML
    private TableColumn<Persons, String> NameColumn;
//    @FXML
//    private TableColumn<Payroll, String> AmountColumn;
//    @FXML
//    private TableColumn<Payroll, String> DateColumn;
//    @FXML
//    private TableColumn<Payroll, String> TypeBonusColumn;
    @FXML
    private ComboBox ComboType;

    Management MA;

    Persons st;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MA = new Management();

        if (!PayrollTable.getItems().isEmpty()) {
            PayrollTable.getItems().clear();
        }

        PayrollTable.setItems(Management.getEmpList());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
//        AmountColumn.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
//        DateColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
//        TypeBonusColumn.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());

        ComboType.getItems().removeAll(ComboType.getItems());
        ComboType.getItems().addAll("مكافأة استثنائية", "مكافأة امتحانات");

    }

    @FXML
    public void Search() {
        if (!SearchQuery.getText().equals("")) {
            ObservableList<Persons> TempList = FXCollections.observableArrayList(MA.getActiveEmp());
            PayrollTable.getItems().clear();
            for (int i = 0; i < TempList.size(); i++) {
                if (!TempList.get(i).getName().contains(SearchQuery.getText())) {
                    TempList.remove(i);
                    i--;
                }
            }
            PayrollTable.setItems(TempList);
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
        PayrollTable.setItems(Management.getEmpList());
        Amount.setText("");
        EDate.setValue(null);
        Notes.setText("");
        Recieved.setSelected(false);
        ComboType.getSelectionModel().select(0);
    }

    @FXML
    public void handleNewAbsent() {
        st = PayrollTable.getSelectionModel().getSelectedItem();
        if (st != null && EDate.getValue() != null
                && Amount.getText() != null && ComboType.getSelectionModel().getSelectedIndex() != -1) {
            if (MA.PersistNewBonus(Notes.getText(), st,
                    Date.valueOf(EDate.getValue()),
                    ComboType.getSelectionModel().getSelectedItem().toString(),
                    Amount.getText(),
                    Recieved.isSelected())) {
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
        Management.getDialogStage().close();
    }

//     private void showDetails(Payroll shera2) {
//        if (shera2 != null) {
//            Recieved.setSelected(shera2.getPrStatus());
//            Notes.setText(shera2.getPRNotes());
//            Amount.setText(String.valueOf(shera2.getAmount()));
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(shera2.getPrDate());
//            LocalDate date = LocalDate.of(cal.get(Calendar.YEAR),
//                    cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
//            EDate.setValue(date);
//            ComboType.getSelectionModel().select(shera2.getPrTypeBonus());
//        } else {
//            Amount.setText("");
//            EDate.setValue(null);
//            Notes.setText("");
//            Recieved.setSelected(false);
//            ComboType.getSelectionModel().select(0);
//        }
//    }
//    
//
//    @FXML
//    public void handleNew() {
//        if (!Amount.getText().equals("") && ComboType.getSelectionModel().getSelectedIndex() != -1
//                && EDate.getValue() != null) {
//            st = new Payroll();
//            st.setAmount(Double.valueOf(Amount.getText()));
//            st.setPRNotes(Notes.getText());
//            st.setPrStatus(Recieved.isSelected());
//            st.setPrDate(Date.valueOf(EDate.getValue()));
//            st.setPrTypeBonus(ComboType.getSelectionModel().getSelectedItem().toString());
//            st.setPrType("1");
////            st.setPId(current);
////            SA.PersistStudentExpense(st);
////            PayrollTable.setItems(StudentAffair.getPayrollList());
//        } else {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("يوجد خطأ");
//            alert.setHeaderText("خطأ");
//            alert.setContentText("برجاء التأكد من صحة البيانات");
//            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
//            alert.showAndWait();
//        }
//    }
//
//    @FXML
//    public void handleEdit() {
//        if (!Amount.getText().equals("") && ComboType.getSelectionModel().getSelectedIndex() != -1
//                && EDate.getValue() != null) {
//            st = PayrollTable.getSelectionModel().getSelectedItem();
//            st.setAmount(Double.valueOf(Amount.getText()));
//            st.setPRNotes(Notes.getText());
//            st.setPrStatus(Recieved.isSelected());
//            st.setPrDate(Date.valueOf(EDate.getValue()));
//            st.setPrTypeBonus(ComboType.getSelectionModel().getSelectedItem().toString());
//            st.setPrType("1");
////            SA.UpdateStudentExpense(st);
//            PayrollTable.setItems(Management.getEmpList());
//        } else {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("يوجد خطأ");
//            alert.setHeaderText("خطأ");
//            alert.setContentText("برجاء التأكد من صحة البيانات");
//            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
//            alert.showAndWait();
//        }
//    }
}
