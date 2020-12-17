/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Contacts;
import Entity.EmployeeAttendance;
import Entity.Evaluation;
import Entity.Payroll;
import Entity.Staff;
import Util.LoginSec;
import amgad.h.Main;
import amgad.h.Management;
import amgad.h.root;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class ViewStaffController implements Initializable {
    private static final Logger LOGGER = LogManager.getLogger(ViewStaffController.class);
    @FXML
    private Label name;
    @FXML
    private Label socialStatus;
    @FXML
    private Label type;
    @FXML
    private Label nationality;
    @FXML
    private Label religion;
    @FXML
    private Label dob;
    @FXML
    private Label address;
    @FXML
    private Label nationalId;
    @FXML
    private Label SingInDate;
    @FXML
    private Label Status;
    @FXML
    private Label Qual;
    @FXML
    private Label salary;
    @FXML
    private Label category;
    @FXML
    private Label salaryLabel;
    @FXML
    private Tab payroll;
    @FXML
    private Button calculateSalary;
    @FXML
    private TableView<Contacts> ContactsTable;
    @FXML
    private TableColumn<Contacts, String> NameColumn;
    @FXML
    private TableColumn<Contacts, String> NumColumn;
    @FXML
    private Tab abscense;
    @FXML
    private Button saveAbscence;
    @FXML
    ImageView PhotoPath;

    @FXML
    private TableView<EmployeeAttendance> AttTable;
    @FXML
    private TableColumn<EmployeeAttendance, String> AttNoteColumn;
    @FXML
    private TableColumn<EmployeeAttendance, String> DurationColumn;
    @FXML
    private TableColumn<EmployeeAttendance, String> TypeColumn;
    @FXML
    private TableColumn<EmployeeAttendance, String> DateColumn;
    @FXML
    private TableColumn<EmployeeAttendance, Boolean> StatusColumn;

    @FXML
    private Button savePenalty;
    @FXML
    private Tab penalty;
    @FXML
    private TableView<Payroll> PenaltyTable;
    @FXML
    private TableColumn<Payroll, String> PenaltyAmountColumn;
    @FXML
    private TableColumn<Payroll, String> PenaltyDateColumn;
    @FXML
    private TableColumn<Payroll, String> PenaltyNotesColumn;
    @FXML
    private TableColumn<Payroll, Boolean> PenaltyStatusColumn;

    @FXML
    private Button saveBonus;
    @FXML
    private Tab bonusTab;
    @FXML
    private TableView<Payroll> BonusTable;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumn;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumn;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumn;
    @FXML
    private TableColumn<Payroll, Boolean> BonusStatusColumn;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumn;
    
    @FXML
    private TabPane pane2020;
    @FXML
    private Tab choose;
    @FXML
    private Tab JAN20;
    @FXML
    private Tab FEB20;
    @FXML
    private Tab MAR20;
    @FXML
    private Tab APR20;
    @FXML
    private Tab MAY20;
    @FXML
    private Tab JUN20;
    @FXML
    private Tab JUL20;
    @FXML
    private Tab AUG20;
    @FXML
    private Tab SEP20;
    @FXML
    private Tab OCT20;
    @FXML
    private Tab NOV20;
    @FXML
    private Tab DEC20;


    @FXML
    private Label Gross;
    @FXML
    private Label Deduction;
    @FXML
    private Label Bonus;
    @FXML
    private Label Net;

    @FXML
    private TableView<Payroll> BonusTableJan20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnJan20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnJan20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnJan20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnJan20;
    @FXML
    private TableView<Payroll> DeductionTableJan20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnJan20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnJan20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnJan20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnJan20;
    @FXML
    private Label Gross201;
    @FXML
    private Label Bonus201;
    @FXML
    private Label Deduction201;
    @FXML
    private Label Net201;

    @FXML
    private TableView<Payroll> BonusTableFeb20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnFeb20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnFeb20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnFeb20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnFeb20;
    @FXML
    private TableView<Payroll> DeductionTableFeb20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnFeb20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnFeb20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnFeb20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnFeb20;
    @FXML
    private Label Gross202;
    @FXML
    private Label Bonus202;
    @FXML
    private Label Deduction202;
    @FXML
    private Label Net202;

    @FXML
    private TableView<Payroll> BonusTableMar20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnMar20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnMar20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnMar20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnMar20;
    @FXML
    private TableView<Payroll> DeductionTableMar20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnMar20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnMar20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnMar20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnMar20;
    @FXML
    private Label Gross203;
    @FXML
    private Label Bonus203;
    @FXML
    private Label Deduction203;
    @FXML
    private Label Net203;

    @FXML
    private TableView<Payroll> BonusTableApr20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnApr20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnApr20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnApr20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnApr20;
    @FXML
    private TableView<Payroll> DeductionTableApr20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnApr20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnApr20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnApr20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnApr20;
    @FXML
    private Label Gross204;
    @FXML
    private Label Bonus204;
    @FXML
    private Label Deduction204;
    @FXML
    private Label Net204;

    @FXML
    private TableView<Payroll> BonusTableMay20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnMay20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnMay20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnMay20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnMay20;
    @FXML
    private TableView<Payroll> DeductionTableMay20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnMay20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnMay20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnMay20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnMay20;
    @FXML
    private Label Gross205;
    @FXML
    private Label Bonus205;
    @FXML
    private Label Deduction205;
    @FXML
    private Label Net205;

    @FXML
    private TableView<Payroll> BonusTableJun20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnJun20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnJun20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnJun20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnJun20;
    @FXML
    private TableView<Payroll> DeductionTableJun20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnJun20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnJun20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnJun20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnJun20;
    @FXML
    private Label Gross206;
    @FXML
    private Label Bonus206;
    @FXML
    private Label Deduction206;
    @FXML
    private Label Net206;

    @FXML
    private TableView<Payroll> BonusTableJul20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnJul20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnJul20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnJul20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnJul20;
    @FXML
    private TableView<Payroll> DeductionTableJul20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnJul20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnJul20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnJul20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnJul20;
    @FXML
    private Label Gross207;
    @FXML
    private Label Bonus207;
    @FXML
    private Label Deduction207;
    @FXML
    private Label Net207;

    @FXML
    private TableView<Payroll> BonusTableAug20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnAug20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnAug20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnAug20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnAug20;
    @FXML
    private TableView<Payroll> DeductionTableAug20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnAug20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnAug20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnAug20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnAug20;
    @FXML
    private Label Gross208;
    @FXML
    private Label Bonus208;
    @FXML
    private Label Deduction208;
    @FXML
    private Label Net208;

    @FXML
    private TableView<Payroll> BonusTableSep20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnSep20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnSep20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnSep20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnSep20;
    @FXML
    private TableView<Payroll> DeductionTableSep20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnSep20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnSep20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnSep20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnSep20;
    @FXML
    private Label Gross209;
    @FXML
    private Label Bonus209;
    @FXML
    private Label Deduction209;
    @FXML
    private Label Net209;

    @FXML
    private TableView<Payroll> BonusTableOct20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnOct20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnOct20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnOct20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnOct20;
    @FXML
    private TableView<Payroll> DeductionTableOct20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnOct20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnOct20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnOct20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnOct20;
    @FXML
    private Label Gross2010;
    @FXML
    private Label Bonus2010;
    @FXML
    private Label Deduction2010;
    @FXML
    private Label Net2010;

    @FXML
    private TableView<Payroll> BonusTableNov20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnNov20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnNov20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnNov20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnNov20;
    @FXML
    private TableView<Payroll> DeductionTableNov20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnNov20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnNov20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnNov20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnNov20;
    @FXML
    private Label Gross2011;
    @FXML
    private Label Bonus2011;
    @FXML
    private Label Deduction2011;
    @FXML
    private Label Net2011;

    @FXML
    private TableView<Payroll> BonusTableDec20;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnDec20;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnDec20;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnDec20;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnDec20;
    @FXML
    private TableView<Payroll> DeductionTableDec20;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnDec20;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnDec20;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnDec20;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnDec20;
    @FXML
    private Label Gross2012;
    @FXML
    private Label Bonus2012;
    @FXML
    private Label Deduction2012;
    @FXML
    private Label Net2012;

    @FXML
    private Tab ev;
    @FXML
    private TextField A1;
    @FXML
    private TextField A2;
    @FXML
    private TextField A3;
    @FXML
    private TextField A4;
    @FXML
    private TextField A5;
    @FXML
    private TextField A6;
    @FXML
    private TextField A7;
    @FXML
    private TextField A8;
    @FXML
    private DatePicker ADate;

    @FXML
    private TableView<Evaluation> EvaluationTable;
    @FXML
    private TableColumn<Evaluation, String> A1Column;
    @FXML
    private TableColumn<Evaluation, String> A2Column;
    @FXML
    private TableColumn<Evaluation, String> A3Column;
    @FXML
    private TableColumn<Evaluation, String> A4Column;
    @FXML
    private TableColumn<Evaluation, String> A5Column;
    @FXML
    private TableColumn<Evaluation, String> A6Column;
    @FXML
    private TableColumn<Evaluation, String> A7Column;
    @FXML
    private TableColumn<Evaluation, String> A8Column;
    @FXML
    private TableColumn<Evaluation, String> ADateColumn;

    static private Staff current;
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
        current = Management.getEdit();
        MA = new Management();
        name.setText(current.getPId().getName());
        socialStatus.setText(current.getPId().maritalStatusProperty().getValue());
        type.setText(current.getPId().GenderProperty().getValue());
        if (current.getPId().getReligion().equals("1")) {
            religion.setText("مسلم");
        } else {
            religion.setText("مسيحي");
        }
        dob.setText(current.getPId().getDob().toString());
        address.setText(current.getPId().getAddress());
        nationalId.setText(current.getPId().getNationalId());
        nationality.setText(current.getPId().getNationality());
        SingInDate.setText(current.getPId().getHiringDate().toString());
        Status.setText(current.statusProperty().getValue());
        Qual.setText(current.getPId().getQualification());
        category.setText(current.getStaffCategory());

        ObservableList<Contacts> tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());
        ContactsTable.setItems(tempCon);
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        NumColumn.setCellValueFactory(cellData -> cellData.getValue().ConDeatailsProperty());

        penalty.selectedProperty().addListener((ov, oldTab, newTab) -> {
            savePenalty.setVisible(newTab);
        });

        bonusTab.selectedProperty().addListener((ov, oldTab, newTab) -> {
                saveBonus.setVisible(newTab);
            });
        
        abscense.selectedProperty().addListener((ov, oldTab, newTab) -> {
            saveAbscence.setVisible(newTab);
        });

        payroll.selectedProperty().addListener((ov, oldTab, newTab) -> {
            calculateSalary.setVisible(newTab);
        });

        if (LoginSec.getLoggedUser().getPermission().equals("2")) {
            salary.setVisible(true);
            salaryLabel.setVisible(true);
            if (current.getMonthlySalary() != null) {
                salary.setText(String.valueOf(current.getMonthlySalary()));
            }
            payroll.setDisable(false);
        }

        if (current.getEmployeeAttendanceList() != null) {
            ObservableList<EmployeeAttendance> tempAtt = FXCollections.observableArrayList(current.getEmployeeAttendanceList());
            AttTable.setItems(tempAtt);
            AttNoteColumn.setCellValueFactory(cellData -> cellData.getValue().descProperty());
            DurationColumn.setCellValueFactory(cellData -> cellData.getValue().durationProperty());
            TypeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
            DateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
            StatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
            StatusColumn.setCellFactory(CheckBoxTableCell.forTableColumn(StatusColumn));
            StatusColumn.onEditStartProperty();
        }

        List<Payroll> tempBonus = new ArrayList();
        List<Payroll> tempDeduction = new ArrayList();
        if (current.getPId().getPayrollList() != null) {

            for (Payroll bonus : current.getPId().getPayrollList()) {
                if (bonus.getPrType().equals("1")) {
                    tempBonus.add(bonus);
                } else if (bonus.getPrType().equals("2")) {
                    tempDeduction.add(bonus);
                }
            }
            ObservableList<Payroll> PenaltyObserv = FXCollections.observableArrayList(tempDeduction);
            PenaltyTable.setItems(PenaltyObserv);
            PenaltyAmountColumn.setCellValueFactory(cellData -> cellData.getValue().PenaltyAmountProperty());
            PenaltyDateColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
            PenaltyNotesColumn.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
            PenaltyStatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
            PenaltyStatusColumn.setCellFactory(CheckBoxTableCell.forTableColumn(PenaltyStatusColumn));
            
            ObservableList<Payroll> BonusObserv = FXCollections.observableArrayList(tempBonus);
                BonusTable.setItems(BonusObserv);
                BonusAmountColumn.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                BonusDateColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                BonusNotesColumn.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                BonusStatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                BonusTypeColumn.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                BonusStatusColumn.setCellFactory(CheckBoxTableCell.forTableColumn(BonusStatusColumn));
                
            //2020
            List<Payroll> tempBonus201 = new ArrayList();
            List<Payroll> tempDeduction201 = new ArrayList();
            List<Payroll> tempBonus202 = new ArrayList();
            List<Payroll> tempDeduction202 = new ArrayList();
            List<Payroll> tempBonus203 = new ArrayList();
            List<Payroll> tempDeduction203 = new ArrayList();
            List<Payroll> tempBonus204 = new ArrayList();
            List<Payroll> tempDeduction204 = new ArrayList();
            List<Payroll> tempBonus205 = new ArrayList();
            List<Payroll> tempDeduction205 = new ArrayList();
            List<Payroll> tempBonus206 = new ArrayList();
            List<Payroll> tempDeduction206 = new ArrayList();
            List<Payroll> tempBonus207 = new ArrayList();
            List<Payroll> tempDeduction207 = new ArrayList();
            List<Payroll> tempBonus208 = new ArrayList();
            List<Payroll> tempDeduction208 = new ArrayList();
            List<Payroll> tempBonus209 = new ArrayList();
            List<Payroll> tempDeduction209 = new ArrayList();
            List<Payroll> tempBonus2010 = new ArrayList();
            List<Payroll> tempDeduction2010 = new ArrayList();
            List<Payroll> tempBonus2011 = new ArrayList();
            List<Payroll> tempDeduction2011 = new ArrayList();
            List<Payroll> tempBonus2012 = new ArrayList();
            List<Payroll> tempDeduction2012 = new ArrayList();

            if (tempBonus.size() > 0) {
                for (Payroll tBP : tempBonus) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(tBP.getPrDate());
                    if (calendar.get(Calendar.MONTH) + 1 == 1 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus201.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 2 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus202.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 3 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus203.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 4 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus204.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 5 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus205.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 6 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus206.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 7 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus207.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 8 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus208.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 9 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus209.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 10 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus2010.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 11 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus2011.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.YEAR) == 2020) {
                        tempBonus2012.add(tBP);
                    }
                }
            }
            if (tempDeduction.size() > 0) {
                for (Payroll tBP : tempDeduction) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(tBP.getPrDate());
                     if (calendar.get(Calendar.MONTH) + 1 == 1 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction201.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 2 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction202.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 3 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction203.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 4 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction204.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 5 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction205.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 6 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction206.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 7 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction207.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 8 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction208.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 9 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction209.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 10 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction2010.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 11 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction2011.add(tBP);
                    } else if (calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.YEAR) == 2020) {
                        tempDeduction2012.add(tBP);
                    }
                }
            }
            choose.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(true);
                    }
                });
            JAN20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 1 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net201.setText(String.valueOf(bp.getAmount()));
                                Gross201.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction201.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus201.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus201);
                    BonusTableJan20.setItems(bonusObserv);
                    BonusAmountColumnJan20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnJan20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnJan20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnJan20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction201);
                    DeductionTableJan20.setItems(DeductObserv);
                    DeductionAmountColumnJan20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnJan20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnJan20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnJan20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnJan20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnJan20));
                }
            });
            FEB20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 2 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net202.setText(String.valueOf(bp.getAmount()));
                                Gross202.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction202.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus202.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus202);
                    BonusTableFeb20.setItems(bonusObserv);
                    BonusAmountColumnFeb20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnFeb20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnFeb20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnFeb20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction202);
                    DeductionTableFeb20.setItems(DeductObserv);
                    DeductionAmountColumnFeb20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnFeb20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnFeb20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnFeb20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnFeb20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnFeb20));
                }
            });
            MAR20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 3 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net203.setText(String.valueOf(bp.getAmount()));
                                Gross203.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction203.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus203.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus203);
                    BonusTableMar20.setItems(bonusObserv);
                    BonusAmountColumnMar20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnMar20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnMar20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnMar20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction203);
                    DeductionTableMar20.setItems(DeductObserv);
                    DeductionAmountColumnMar20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnMar20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnMar20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnMar20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnMar20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnMar20));
                }
            });
            APR20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 4 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net204.setText(String.valueOf(bp.getAmount()));
                                Gross204.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction204.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus204.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus204);
                    BonusTableApr20.setItems(bonusObserv);
                    BonusAmountColumnApr20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnApr20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnApr20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnApr20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction204);
                    DeductionTableApr20.setItems(DeductObserv);
                    DeductionAmountColumnApr20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnApr20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnApr20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnApr20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnApr20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnApr20));
                }
            });
            MAY20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 5 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net205.setText(String.valueOf(bp.getAmount()));
                                Gross205.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction205.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus205.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus205);
                    BonusTableMay20.setItems(bonusObserv);
                    BonusAmountColumnMay20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnMay20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnMay20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnMay20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction205);
                    DeductionTableMay20.setItems(DeductObserv);
                    DeductionAmountColumnMay20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnMay20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnMay20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnMay20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnMay20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnMay20));
                }
            });
            JUN20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 6 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net206.setText(String.valueOf(bp.getAmount()));
                                Gross206.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction206.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus206.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus206);
                    BonusTableJun20.setItems(bonusObserv);
                    BonusAmountColumnJun20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnJun20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnJun20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnJun20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction206);
                    DeductionTableJun20.setItems(DeductObserv);
                    DeductionAmountColumnJun20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnJun20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnJun20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnJun20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnJun20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnJun20));
                }
            });
            JUL20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 7 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net207.setText(String.valueOf(bp.getAmount()));
                                Gross207.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction207.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus207.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus207);
                    BonusTableJul20.setItems(bonusObserv);
                    BonusAmountColumnJul20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnJul20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnJul20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnJul20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction207);
                    DeductionTableJul20.setItems(DeductObserv);
                    DeductionAmountColumnJul20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnJul20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnJul20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnJul20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnJul20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnJul20));
                }
            });
            AUG20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
//                    Year2020.getSelectionModel().select(AUG20);
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 8 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net208.setText(String.valueOf(bp.getAmount()));
                                Gross208.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction208.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus208.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus208);
                    BonusTableAug20.setItems(bonusObserv);
                    BonusAmountColumnAug20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnAug20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnAug20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnAug20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction208);
                    DeductionTableAug20.setItems(DeductObserv);
                    DeductionAmountColumnAug20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnAug20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnAug20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnAug20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnAug20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnAug20));
                }
            });
            SEP20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 9 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net209.setText(String.valueOf(bp.getAmount()));
                                Gross209.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction209.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus209.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus209);
                    BonusTableSep20.setItems(bonusObserv);
                    BonusAmountColumnSep20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnSep20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnSep20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnSep20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction209);
                    DeductionTableSep20.setItems(DeductObserv);
                    DeductionAmountColumnSep20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnSep20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnSep20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnSep20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnSep20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnSep20));
                }
            });
            OCT20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 10 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net2010.setText(String.valueOf(bp.getAmount()));
                                Gross2010.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction2010.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus2010.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus2010);
                    BonusTableOct20.setItems(bonusObserv);
                    BonusAmountColumnOct20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnOct20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnOct20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnOct20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction2010);
                    DeductionTableOct20.setItems(DeductObserv);
                    DeductionAmountColumnOct20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnOct20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnOct20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnOct20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnOct20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnOct20));
                }
            });
            NOV20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 11 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net2011.setText(String.valueOf(bp.getAmount()));
                                Gross2011.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction2011.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus2011.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus2011);
                    BonusTableNov20.setItems(bonusObserv);
                    BonusAmountColumnNov20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnNov20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnNov20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnNov20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction2011);
                    DeductionTableNov20.setItems(DeductObserv);
                    DeductionAmountColumnNov20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnNov20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnNov20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnNov20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnNov20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnNov20));
                }
            });
            DEC20.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    calculateSalary.setDisable(false);
                    for (Payroll bp : current.getPId().getPayrollList()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bp.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.YEAR) == 2020) {
                            if (bp.getPrType().equals("9")) {
                                calculateSalary.setDisable(true);
                                Net2012.setText(String.valueOf(bp.getAmount()));
                                Gross2012.setText(String.valueOf(current.getMonthlySalary()));
                            } else if (bp.getPrType().equals("8")) {
                                Deduction2012.setText(String.valueOf(bp.getAmount()));
                            } else if (bp.getPrType().equals("7")) {
                                Bonus2012.setText(String.valueOf(bp.getAmount()));
                            }
                        }
                    }
                    ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus2012);
                    BonusTableDec20.setItems(bonusObserv);
                    BonusAmountColumnDec20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    BonusDateColumnDec20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    BonusNotesColumnDec20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    BonusTypeColumnDec20.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                    ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction2012);
                    DeductionTableDec20.setItems(DeductObserv);
                    DeductionAmountColumnDec20.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                    DeductionDateColumnDec20.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                    DeductionNotesColumnDec20.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                    DeductionStatusColumnDec20.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                    DeductionStatusColumnDec20.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnDec20));
                }
            });
        }

        ev.selectedProperty().addListener((ov, oldTab, newTab) -> {
            if (newTab) {
                Management.setEdit(current);
                MA.setEvaluationList(MA.getEvaluations());
                EvaluationTable.setItems(Management.getEvaluationList());
                A1Column.setCellValueFactory(cellData -> cellData.getValue().AbsenceProperty());
                A2Column.setCellValueFactory(cellData -> cellData.getValue().LateProperty());
                A3Column.setCellValueFactory(cellData -> cellData.getValue().PenaltyProperty());
                A4Column.setCellValueFactory(cellData -> cellData.getValue().CollaborationProperty());
                A5Column.setCellValueFactory(cellData -> cellData.getValue().StudentTreatmentProperty());
                A6Column.setCellValueFactory(cellData -> cellData.getValue().PersonalityProperty());
                A7Column.setCellValueFactory(cellData -> cellData.getValue().TechLvlProperty());
                A8Column.setCellValueFactory(cellData -> cellData.getValue().InfoExplainationProperty());
                ADateColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
            }
        });
        PhotoPath.setImage(new Image(new File(current.getPId().getPersonalPhoto()).toURI().toString()));
        EvaluationTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));

    }

    private void showDetails(Evaluation shera2) {
        if (shera2 != null) {
            // Fill the labels with info from the person object.
            A1.setText(shera2.getAbsence());
            A2.setText(shera2.getLateness());
            A3.setText(shera2.getPenaleties());
            A4.setText(shera2.getCllaboration());
            A5.setText(shera2.getStudentTreatment());
            A6.setText(shera2.getPersonality());
            A7.setText(shera2.getTechLvl());
            A8.setText(shera2.getInfoExplaination());
            Calendar cal = Calendar.getInstance();
            cal.setTime(shera2.getEvaDate());
            LocalDate date = LocalDate.of(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
            ADate.setValue(date);
        } else {
            A1.setText("");
            A2.setText("");
            A3.setText("");
            A4.setText("");
            A5.setText("");
            A6.setText("");
            A7.setText("");
            A8.setText("");
            ADate.setValue(null);
        }
    }

    @FXML
    public void handleImageClick() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/ViewImage.fxml"));
            root.f = new File(current.getPId().getPersonalPhoto());
            AnchorPane page = loader.load();
            Stage dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("عرض الصورة");
            dialogStage2.initModality(Modality.WINDOW_MODAL);
            dialogStage2.initOwner(MA.getDialogStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage2.setScene(scene);
            dialogStage2.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String NetSal = "";
    double netsalDouble = 0.0;
    double deduction = 0.0;
    double bonus = 0.0;
    double day = 0.0;

    @FXML
    public void handleNewEva() {
        if (ADate.getValue() != null) {
            Evaluation eval = new Evaluation();
            eval.setPid(MA.getEdit().getPId());
            eval.setEvaDate(Date.valueOf(ADate.getValue()));
            if (!A1.getText().equals("")) {
                eval.setAbsence(A1.getText());
            }
            if (!A2.getText().equals("")) {
                eval.setLateness(A2.getText());
            }
            if (!A3.getText().equals("")) {
                eval.setPenaleties(A3.getText());
            }
            if (!A4.getText().equals("")) {
                eval.setCllaboration(A4.getText());
            }
            if (!A5.getText().equals("")) {
                eval.setStudentTreatment(A5.getText());
            }
            if (!A6.getText().equals("")) {
                eval.setPersonality(A6.getText());
            }
            if (!A7.getText().equals("")) {
                eval.setTechLvl(A7.getText());
            }
            if (!A8.getText().equals("")) {
                eval.setInfoExplaination(A8.getText());
            }
            MA.PersistEval(eval);
            showDetails(null);
            EvaluationTable.getItems().clear();
            EvaluationTable.setItems(MA.getEvaluationList());
//            MA.getBoardDecisionList().add(st);
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
    public void handleEditEva() {
        int selectedIndex = EvaluationTable.getSelectionModel().getSelectedIndex();
        if (ADate.getValue() != null && selectedIndex >= 0) {
            Evaluation eval = EvaluationTable.getSelectionModel().getSelectedItem();
            eval.setAbsence(A1.getText());
            eval.setLateness(A2.getText());
            eval.setPenaleties(A3.getText());
            eval.setCllaboration(A4.getText());
            eval.setStudentTreatment(A5.getText());
            eval.setPersonality(A6.getText());
            eval.setTechLvl(A7.getText());
            eval.setInfoExplaination(A8.getText());
            MA.EditEval(eval);
            showDetails(null);
            EvaluationTable.getItems().clear();
            EvaluationTable.setItems(MA.getEvaluationList());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء تحديد عنصر من الجدول لتعديله");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }

    }

    @FXML
    public void handleCalculateSalary() {
        netsalDouble = current.getMonthlySalary();
//        day = netsalDouble / 30;

        if (current.getPId().getInsuranceAmount() != null) {
            netsalDouble -= current.getPId().getInsuranceAmount();
        }
        System.out.println(pane2020.getSelectionModel().getSelectedItem().getId());
        String SelectionY2020 = pane2020.getSelectionModel().getSelectedItem().getId();
        switch (SelectionY2020){
            case "JAN20":
                calculateNetSalary(1);
                break;
            case "FEB20":
                calculateNetSalary(2);
                break;
            case "MAR20":
                calculateNetSalary(3);
                break;
            case "APR20":
                calculateNetSalary(4);
                break;
            case "MAY20":
                calculateNetSalary(5);
                break;
            case "JUN20":
                calculateNetSalary(6);
                break;
            case "JUL20":
                calculateNetSalary(7);
                break;
            case "AUG20":
                calculateNetSalary(8);
                break;
            case "SEP20":
                calculateNetSalary(9);
                break;
            case "OCT20":
                calculateNetSalary(10);
                break;
            case "NOV20":
                calculateNetSalary(11);
                break;
            case "DEC20":
                calculateNetSalary(12);
                break;
            default:
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("لم يتم تحديد الشهر");
                alert.setContentText("من فضلك قم بتحديد الشهر المراد حسابه");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
                break;
        }
        calculateSalary.setDisable(true);
    }

    void calculateNetSalary(int m) {
        if (current.getPId().getPayrollList().size() > 0) {
            for (Payroll tPR : current.getPId().getPayrollList()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(tPR.getPrDate());
                if (calendar.get(Calendar.MONTH) + 1 == m && calendar.get(Calendar.YEAR) 
                        == Calendar.getInstance().get(Calendar.YEAR)) {
                    switch (tPR.getPrType()) {
                        case "1":
                            if (tPR.getPrStatus()) {
                                netsalDouble += tPR.getAmount();
                                bonus += tPR.getAmount();
//                                tPR.setPrStatus(true);
                                MA.UpdatePayroll(tPR);
                            }
                            break;
                    }
                }
            }
            day = netsalDouble / 30;
            for (Payroll tPR : current.getPId().getPayrollList()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(tPR.getPrDate());
                if (calendar.get(Calendar.MONTH) + 1 == m && calendar.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
                    switch (tPR.getPrType()) {
                        case "2":
                            if (tPR.getPrStatus()) {
                                netsalDouble -= (tPR.getAmount() * day);
                                deduction += (tPR.getAmount() * day);
                            }
                            break;
                    }
                }
            }
        }

        if (day == 0.0) {
            day = netsalDouble / 30;
        }
        
        if (current.getEmployeeAttendanceList().size() > 0) {
            for (EmployeeAttendance tEA : current.getEmployeeAttendanceList()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(tEA.getEaDate());
                if (calendar.get(Calendar.MONTH) + 1 == m && calendar.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
                    if (tEA.getStatus()) {
                        switch (tEA.getAbscenceType()) {
                            case "1": // minutes
                                if (tEA.getTimeAmount() > 15 && tEA.getTimeAmount() <= 60) {
                                    netsalDouble -= (day * .25);
                                    deduction += (day * .25);
                                } else if (tEA.getTimeAmount() > 60 && tEA.getTimeAmount() <= 120) {
                                    netsalDouble -= (day * .5);
                                    deduction += (day * .5);
                                } else if (tEA.getTimeAmount() > 120) {
                                    netsalDouble -= day;
                                    deduction += (day);
                                }
                                break;
                            case "6": //days
                                netsalDouble -= (3 * day * tEA.getTimeAmount());
                                deduction += (3 * day * tEA.getTimeAmount());
                                break;
                        }
                    }
                }
            }
        }
//        Deduction.setText(String.valueOf(deduction));
//        Bonus.setText(String.valueOf(bonus));
//        NetSal += netsalDouble;
//        Net.setText(NetSal);
        DecimalFormat f = new DecimalFormat("##.00");
        netsalDouble=Double.valueOf(f.format(netsalDouble));
        deduction=Double.valueOf(f.format(deduction));
        bonus=Double.valueOf(f.format(bonus));
        System.out.println("Deduction " + deduction);
        try{
        current.getPId().getPayrollList().add(MA.PersistNewNetSalary("تم استلام المرتب", current.getPId(), netsalDouble, "الادارة"));
        LOGGER.info("تم استلام المرتب "+current.getPId().getName());
        current.getPId().getPayrollList().add(MA.PersistNewDeductionsSalary("تم الخصم", current.getPId(), deduction));
        LOGGER.info("تم الخصم "+current.getPId().getName());
        current.getPId().getPayrollList().add(MA.PersistNewBonusSalary("تم اضافة المكافأت", current.getPId(), bonus));
        LOGGER.info("تم اضافة المكافأت "+current.getPId().getName());
        updateSalaryTable(m);
        }catch (Exception e){
            LOGGER.error(e);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء التأكد من صحة البيانات");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    void updateSalaryTable(int mm) {
         if (Calendar.getInstance().get(Calendar.YEAR) == 2020) {
            switch (mm) {
                case 1:
                    Gross201.setText(current.getMonthlySalary().toString());
                    Deduction201.setText(String.valueOf(deduction));
                    Bonus201.setText(String.valueOf(bonus));
                    Net201.setText(String.valueOf(netsalDouble));
                    break;
                case 2:
                    Gross202.setText(current.getMonthlySalary().toString());
                    Deduction202.setText(String.valueOf(deduction));
                    Bonus202.setText(String.valueOf(bonus));
                    Net202.setText(String.valueOf(netsalDouble));
                    break;
                case 3:
                    Gross203.setText(current.getMonthlySalary().toString());
                    Deduction203.setText(String.valueOf(deduction));
                    Bonus203.setText(String.valueOf(bonus));
                    Net203.setText(String.valueOf(netsalDouble));
                    break;
                case 4:
                    Gross204.setText(current.getMonthlySalary().toString());
                    Deduction204.setText(String.valueOf(deduction));
                    Bonus204.setText(String.valueOf(bonus));
                    Net204.setText(String.valueOf(netsalDouble));
                    break;
                case 5:
                    Gross205.setText(current.getMonthlySalary().toString());
                    Deduction205.setText(String.valueOf(deduction));
                    Bonus205.setText(String.valueOf(bonus));
                    Net205.setText(String.valueOf(netsalDouble));
                    break;
                case 6:
                    Gross206.setText(current.getMonthlySalary().toString());
                    Deduction206.setText(String.valueOf(deduction));
                    Bonus206.setText(String.valueOf(bonus));
                    Net206.setText(String.valueOf(netsalDouble));
                    break;
                case 7:
                    Gross207.setText(current.getMonthlySalary().toString());
                    Deduction207.setText(String.valueOf(deduction));
                    Bonus207.setText(String.valueOf(bonus));
                    Net207.setText(String.valueOf(netsalDouble));
                    break;
                case 8:
                    Gross208.setText(current.getMonthlySalary().toString());
                    Deduction208.setText(String.valueOf(deduction));
                    Bonus208.setText(String.valueOf(bonus));
                    Net208.setText(String.valueOf(netsalDouble));
                    break;
                case 9:
                    Gross209.setText(current.getMonthlySalary().toString());
                    Deduction209.setText(String.valueOf(deduction));
                    Bonus209.setText(String.valueOf(bonus));
                    Net209.setText(String.valueOf(netsalDouble));
                    break;
                case 10:
                    Gross2010.setText(current.getMonthlySalary().toString());
                    Deduction2010.setText(String.valueOf(deduction));
                    Bonus2010.setText(String.valueOf(bonus));
                    Net2010.setText(String.valueOf(netsalDouble));
                    break;
                case 11:
                    Gross2011.setText(current.getMonthlySalary().toString());
                    Deduction2011.setText(String.valueOf(deduction));
                    Bonus2011.setText(String.valueOf(bonus));
                    Net2011.setText(String.valueOf(netsalDouble));
                    break;
                case 12:
                    Gross2012.setText(current.getMonthlySalary().toString());
                    Deduction2012.setText(String.valueOf(deduction));
                    Bonus2012.setText(String.valueOf(bonus));
                    Net2012.setText(String.valueOf(netsalDouble));
                    break;
            }
        }

    }

    @FXML
    public void handleEdit() {
        int selectedIndex = AttTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Management.setEditStatus(AttTable.getItems().get(selectedIndex));
            MA.ViewEditAbscentStatus();
            ObservableList<EmployeeAttendance> tempAtt = FXCollections.observableArrayList(current.getEmployeeAttendanceList());
            AttTable.getItems().clear();
            AttTable.setItems(tempAtt);
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
    public void handlePenaltyEdit() {
        int selectedIndex = PenaltyTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            Management.setEditPayrollStatus(PenaltyTable.getItems().get(selectedIndex));
            MA.ViewEditPenaltyStatus();

            List<Payroll> tempDeduction = new ArrayList();
            for (Payroll p : current.getPId().getPayrollList()) {
                if (p.getPrType().equals("2")) {
                    tempDeduction.add(p);
                }
            }
            ObservableList<Payroll> tempPenalty = FXCollections.observableArrayList(tempDeduction);
            
            PenaltyTable.getItems().clear();
            PenaltyTable.setItems(tempPenalty);
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
    public void handleBonusEdit() {
        int selectedIndex = BonusTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            Management.setEditPayrollStatus(BonusTable.getItems().get(selectedIndex));
            MA.ViewEditPenaltyStatus();

            List<Payroll> tempDeduction = new ArrayList();
            for (Payroll p : current.getPId().getPayrollList()) {
                if (p.getPrType().equals("1")) {
                    tempDeduction.add(p);
                }
            }
            ObservableList<Payroll> tempPenalty = FXCollections.observableArrayList(tempDeduction);
            BonusTable.getItems().clear();
            BonusTable.setItems(tempPenalty);
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
