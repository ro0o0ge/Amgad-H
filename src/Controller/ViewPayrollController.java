/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Payroll;
import amgad.h.Management;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class ViewPayrollController implements Initializable {

    @FXML
    private Label amount;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    @FXML
    private TextField IssuedBy;
    @FXML
    private TableView<Payroll> PayrollTable;
    @FXML
    private TableColumn<Payroll, String> NameColumn;
    @FXML
    private TableColumn<Payroll, String> GrossColumn;
    @FXML
    private TableColumn<Payroll, String> DeductionColumn;
    @FXML
    private TableColumn<Payroll, String> RewardsColumn;
    @FXML
    private TableColumn<Payroll, String> NetColumn;

    Management MA;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

//        PayrollTable.setItems(Management.getPayrollList());
//        NameColumn.setCellValueFactory(cellData -> cellData.getValue().getPId().NameProperty());
//        GrossColumn.setCellValueFactory(cellData -> cellData.getValue().());
//        DeductionColumn.setCellValueFactory(cellData -> cellData.getValue().());
//        Rewards1Column.setCellValueFactory(cellData -> cellData.getValue().());
//        Rewards2Column.setCellValueFactory(cellData -> cellData.getValue().());
//        NetColumn.setCellValueFactory(cellData -> cellData.getValue().());
    }
    @FXML
    public void Search() {
        if (fromDate.getValue()!=null && toDate.getValue()!=null) {
            System.out.println("in search");
//            List<Payroll> tempPR = Management.getPayrollList();
//            for (Payroll pr :tempPR){
//                
//            }
//            
//            ObservableList<Payroll> TempList = FXCollections.observableArrayList(Management.getPayrollList());
//            StudentsTable.getItems().clear();
//            for (int i = 0; i < TempList.size(); i++) {
//                if (!TempList.get(i).getPId().getName().contains(SearchQuery.getText())) {
//                    TempList.remove(i);
//                    i--;
//                }
//            }
//            StudentsTable.setItems(TempList);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("لاتترك صندوق البحث فارغ");
            alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

}
