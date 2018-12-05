/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.scene.control.cell.CheckBoxTableCell;
import Entity.Contacts;
import Entity.EmployeeAttendance;
import Entity.Evaluation;
import Entity.Payroll;
import Entity.Schedule;
import Entity.Teacher;
import Util.LoginSec;
import amgad.h.Main;
import amgad.h.TeachingStaff;
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
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class ViewTeacherController implements Initializable {

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
    private Tab schedule;
    @FXML
    AnchorPane scheduleAP;
    @FXML
    private Button printScheduleBtn;
    @FXML
    private Label Sun1;
    @FXML
    private Label Sun2;
    @FXML
    private Label Sun3;
    @FXML
    private Label Sun4;
    @FXML
    private Label Sun5;
    @FXML
    private Label Sun6;
    @FXML
    private Label Sun7;
    @FXML
    private Label Mon1;
    @FXML
    private Label Mon2;
    @FXML
    private Label Mon3;
    @FXML
    private Label Mon4;
    @FXML
    private Label Mon5;
    @FXML
    private Label Mon6;
    @FXML
    private Label Mon7;
    @FXML
    private Label Tue1;
    @FXML
    private Label Tue2;
    @FXML
    private Label Tue3;
    @FXML
    private Label Tue4;
    @FXML
    private Label Tue5;
    @FXML
    private Label Tue6;
    @FXML
    private Label Tue7;
    @FXML
    private Label Wed1;
    @FXML
    private Label Wed2;
    @FXML
    private Label Wed3;
    @FXML
    private Label Wed4;
    @FXML
    private Label Wed5;
    @FXML
    private Label Wed6;
    @FXML
    private Label Wed7;
    @FXML
    private Label Thu1;
    @FXML
    private Label Thu2;
    @FXML
    private Label Thu3;
    @FXML
    private Label Thu4;
    @FXML
    private Label Thu5;
    @FXML
    private Label Thu6;
    @FXML
    private Label Thu7;

    @FXML
    private Label SSun1;
    @FXML
    private Label SSun2;
    @FXML
    private Label SSun3;
    @FXML
    private Label SSun4;
    @FXML
    private Label SSun5;
    @FXML
    private Label SSun6;
    @FXML
    private Label SSun7;
    @FXML
    private Label SMon1;
    @FXML
    private Label SMon2;
    @FXML
    private Label SMon3;
    @FXML
    private Label SMon4;
    @FXML
    private Label SMon5;
    @FXML
    private Label SMon6;
    @FXML
    private Label SMon7;
    @FXML
    private Label STue1;
    @FXML
    private Label STue2;
    @FXML
    private Label STue3;
    @FXML
    private Label STue4;
    @FXML
    private Label STue5;
    @FXML
    private Label STue6;
    @FXML
    private Label STue7;
    @FXML
    private Label SWed1;
    @FXML
    private Label SWed2;
    @FXML
    private Label SWed3;
    @FXML
    private Label SWed4;
    @FXML
    private Label SWed5;
    @FXML
    private Label SWed6;
    @FXML
    private Label SWed7;
    @FXML
    private Label SThu1;
    @FXML
    private Label SThu2;
    @FXML
    private Label SThu3;
    @FXML
    private Label SThu4;
    @FXML
    private Label SThu5;
    @FXML
    private Label SThu6;
    @FXML
    private Label SThu7;

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
    private Tab Y18;
    @FXML
    private Tab Y19;
    @FXML
    private Tab Y20;

    @FXML
    private Tab JUL18;
    @FXML
    private Tab AUG18;
    @FXML
    private Tab SEP18;
    @FXML
    private Tab OCT18;
    @FXML
    private Tab NOV18;
    @FXML
    private Tab DEC18;

    @FXML
    private Tab JAN19;
    @FXML
    private Tab FEB19;
    @FXML
    private Tab MAR19;
    @FXML
    private Tab APR19;
    @FXML
    private Tab MAY19;
    @FXML
    private Tab JUN19;
    @FXML
    private Tab JUL19;
    @FXML
    private Tab AUG19;
    @FXML
    private Tab SEP19;
    @FXML
    private Tab OCT19;
    @FXML
    private Tab NOV19;
    @FXML
    private Tab DEC19;

    @FXML
    private TableView<Payroll> BonusTableJul18;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnJul18;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnJul18;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnJul18;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnJul18;

    @FXML
    private TableView<Payroll> DeductionTableJul18;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnJul18;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnJul18;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnJul18;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnJul18;
    @FXML
    private Label Gross187;
    @FXML
    private Label Deduction187;
    @FXML
    private Label Bonus187;
    @FXML
    private Label Net187;

    @FXML
    private TableView<Payroll> BonusTableAug18;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnAug18;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnAug18;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnAug18;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnAug18;
    @FXML
    private TableView<Payroll> DeductionTableAug18;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnAug18;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnAug18;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnAug18;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnAug18;
    @FXML
    private Label Gross;
    @FXML
    private Label Deduction;
    @FXML
    private Label Bonus;
    @FXML
    private Label Net;

    @FXML
    private TableView<Payroll> BonusTableSep18;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnSep18;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnSep18;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnSep18;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnSep18;
    @FXML
    private TableView<Payroll> DeductionTableSep18;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnSep18;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnSep18;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnSep18;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnSep18;
    @FXML
    private Label Gross189;
    @FXML
    private Label Bonus189;
    @FXML
    private Label Deduction189;
    @FXML
    private Label Net189;

    @FXML
    private TableView<Payroll> BonusTableOct18;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnOct18;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnOct18;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnOct18;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnOct18;
    @FXML
    private TableView<Payroll> DeductionTableOct18;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnOct18;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnOct18;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnOct18;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnOct18;
    @FXML
    private Label Gross1810;
    @FXML
    private Label Bonus1810;
    @FXML
    private Label Deduction1810;
    @FXML
    private Label Net1810;

    @FXML
    private TableView<Payroll> BonusTableNov18;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnNov18;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnNov18;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnNov18;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnNov18;
    @FXML
    private TableView<Payroll> DeductionTableNov18;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnNov18;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnNov18;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnNov18;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnNov18;
    @FXML
    private Label Gross1811;
    @FXML
    private Label Bonus1811;
    @FXML
    private Label Deduction1811;
    @FXML
    private Label Net1811;

    @FXML
    private TableView<Payroll> BonusTableDec18;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnDec18;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnDec18;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnDec18;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnDec18;
    @FXML
    private TableView<Payroll> DeductionTableDec18;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnDec18;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnDec18;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnDec18;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnDec18;
    @FXML
    private Label Gross1812;
    @FXML
    private Label Bonus1812;
    @FXML
    private Label Deduction1812;
    @FXML
    private Label Net1812;

    @FXML
    private TableView<Payroll> BonusTableJan19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnJan19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnJan19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnJan19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnJan19;
    @FXML
    private TableView<Payroll> DeductionTableJan19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnJan19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnJan19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnJan19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnJan19;
    @FXML
    private Label Gross191;
    @FXML
    private Label Bonus191;
    @FXML
    private Label Deduction191;
    @FXML
    private Label Net191;

    @FXML
    private TableView<Payroll> BonusTableFeb19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnFeb19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnFeb19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnFeb19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnFeb19;
    @FXML
    private TableView<Payroll> DeductionTableFeb19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnFeb19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnFeb19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnFeb19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnFeb19;
    @FXML
    private Label Gross192;
    @FXML
    private Label Bonus192;
    @FXML
    private Label Deduction192;
    @FXML
    private Label Net192;

    @FXML
    private TableView<Payroll> BonusTableMar19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnMar19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnMar19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnMar19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnMar19;
    @FXML
    private TableView<Payroll> DeductionTableMar19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnMar19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnMar19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnMar19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnMar19;
    @FXML
    private Label Gross193;
    @FXML
    private Label Bonus193;
    @FXML
    private Label Deduction193;
    @FXML
    private Label Net193;

    @FXML
    private TableView<Payroll> BonusTableApr19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnApr19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnApr19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnApr19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnApr19;
    @FXML
    private TableView<Payroll> DeductionTableApr19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnApr19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnApr19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnApr19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnApr19;
    @FXML
    private Label Gross194;
    @FXML
    private Label Bonus194;
    @FXML
    private Label Deduction194;
    @FXML
    private Label Net194;

    @FXML
    private TableView<Payroll> BonusTableMay19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnMay19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnMay19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnMay19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnMay19;
    @FXML
    private TableView<Payroll> DeductionTableMay19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnMay19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnMay19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnMay19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnMay19;
    @FXML
    private Label Gross195;
    @FXML
    private Label Bonus195;
    @FXML
    private Label Deduction195;
    @FXML
    private Label Net195;

    @FXML
    private TableView<Payroll> BonusTableJun19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnJun19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnJun19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnJun19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnJun19;
    @FXML
    private TableView<Payroll> DeductionTableJun19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnJun19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnJun19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnJun19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnJun19;
    @FXML
    private Label Gross196;
    @FXML
    private Label Bonus196;
    @FXML
    private Label Deduction196;
    @FXML
    private Label Net196;

    @FXML
    private TableView<Payroll> BonusTableJul19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnJul19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnJul19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnJul19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnJul19;
    @FXML
    private TableView<Payroll> DeductionTableJul19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnJul19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnJul19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnJul19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnJul19;
    @FXML
    private Label Gross197;
    @FXML
    private Label Bonus197;
    @FXML
    private Label Deduction197;
    @FXML
    private Label Net197;

    @FXML
    private TableView<Payroll> BonusTableAug19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnAug19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnAug19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnAug19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnAug19;
    @FXML
    private TableView<Payroll> DeductionTableAug19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnAug19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnAug19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnAug19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnAug19;
    @FXML
    private Label Gross198;
    @FXML
    private Label Bonus198;
    @FXML
    private Label Deduction198;
    @FXML
    private Label Net198;

    @FXML
    private TableView<Payroll> BonusTableSep19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnSep19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnSep19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnSep19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnSep19;
    @FXML
    private TableView<Payroll> DeductionTableSep19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnSep19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnSep19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnSep19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnSep19;
    @FXML
    private Label Gross199;
    @FXML
    private Label Bonus199;
    @FXML
    private Label Deduction199;
    @FXML
    private Label Net199;

    @FXML
    private TableView<Payroll> BonusTableOct19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnOct19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnOct19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnOct19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnOct19;
    @FXML
    private TableView<Payroll> DeductionTableOct19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnOct19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnOct19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnOct19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnOct19;
    @FXML
    private Label Gross1910;
    @FXML
    private Label Bonus1910;
    @FXML
    private Label Deduction1910;
    @FXML
    private Label Net1910;

    @FXML
    private TableView<Payroll> BonusTableNov19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnNov19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnNov19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnNov19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnNov19;
    @FXML
    private TableView<Payroll> DeductionTableNov19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnNov19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnNov19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnNov19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnNov19;
    @FXML
    private Label Gross1911;
    @FXML
    private Label Bonus1911;
    @FXML
    private Label Deduction1911;
    @FXML
    private Label Net1911;

    @FXML
    private TableView<Payroll> BonusTableDec19;
    @FXML
    private TableColumn<Payroll, String> BonusTypeColumnDec19;
    @FXML
    private TableColumn<Payroll, String> BonusAmountColumnDec19;
    @FXML
    private TableColumn<Payroll, String> BonusNotesColumnDec19;
    @FXML
    private TableColumn<Payroll, String> BonusDateColumnDec19;
    @FXML
    private TableView<Payroll> DeductionTableDec19;
    @FXML
    private TableColumn<Payroll, String> DeductionAmountColumnDec19;
    @FXML
    private TableColumn<Payroll, String> DeductionDateColumnDec19;
    @FXML
    private TableColumn<Payroll, String> DeductionNotesColumnDec19;
    @FXML
    private TableColumn<Payroll, Boolean> DeductionStatusColumnDec19;
    @FXML
    private Label Gross1912;
    @FXML
    private Label Bonus1912;
    @FXML
    private Label Deduction1912;
    @FXML
    private Label Net1912;

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

    static private Teacher current;
    TeachingStaff TS;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            TS = new TeachingStaff();
            current = TeachingStaff.getEdit();
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

            ObservableList<Contacts> tempCon = FXCollections.observableArrayList(current.getPId().getContactsList());
            ContactsTable.setItems(tempCon);
            NameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
            NumColumn.setCellValueFactory(cellData -> cellData.getValue().ConDeatailsProperty());

            if (LoginSec.getLoggedUser().getPermission().equals("2")) {
                salary.setVisible(true);
                salaryLabel.setVisible(true);
                if (current.getMonthlySalary() != null) {
                    salary.setText(current.getMonthlySalary().toString());
                }
                payroll.setDisable(false);
            }

            abscense.selectedProperty().addListener((ov, oldTab, newTab) -> {
                saveAbscence.setVisible(newTab);
            });

            penalty.selectedProperty().addListener((ov, oldTab, newTab) -> {
                savePenalty.setVisible(newTab);
            });

            payroll.selectedProperty().addListener((ov, oldTab, newTab) -> {
                calculateSalary.setVisible(newTab);
            });

            if (current.getEmployeeAttendanceList() != null) {
                ObservableList<EmployeeAttendance> tempAtt = FXCollections.observableArrayList(current.getEmployeeAttendanceList());
                AttTable.setItems(tempAtt);
                AttNoteColumn.setCellValueFactory(cellData -> cellData.getValue().descProperty());
                DurationColumn.setCellValueFactory(cellData -> cellData.getValue().durationProperty());
                TypeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
                DateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
                StatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                StatusColumn.setCellFactory(CheckBoxTableCell.forTableColumn(StatusColumn));
            }

            schedule.selectedProperty().addListener((ov, oldTab, newTab) -> {
                printScheduleBtn.setVisible(newTab);
            });

            if (current.getScheduleList() != null) {
                for (Schedule scheduleList : current.getScheduleList()) {
                    int temp = scheduleList.getLecId().getLecId();
                    switch (temp) {
                        case 1:
                            SSun1.setText(scheduleList.getSuId());
                            Sun1.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 2:
                            SSun2.setText(scheduleList.getSuId());
                            Sun2.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 3:
                            SSun3.setText(scheduleList.getSuId());
                            Sun3.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 4:
                            SSun4.setText(scheduleList.getSuId());
                            Sun4.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 5:
                            SSun5.setText(scheduleList.getSuId());
                            Sun5.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 6:
                            SSun6.setText(scheduleList.getSuId());
                            Sun6.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 7:
                            SSun7.setText(scheduleList.getSuId());
                            Sun7.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 8:
                            SMon1.setText(scheduleList.getSuId());
                            Mon1.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 9:
                            SMon2.setText(scheduleList.getSuId());
                            Mon2.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 10:
                            SMon3.setText(scheduleList.getSuId());
                            Mon3.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 11:
                            SMon4.setText(scheduleList.getSuId());
                            Mon4.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 12:
                            SMon5.setText(scheduleList.getSuId());
                            Mon5.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 13:
                            SMon6.setText(scheduleList.getSuId());
                            Mon6.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 14:
                            SMon7.setText(scheduleList.getSuId());
                            Mon7.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 15:
                            STue1.setText(scheduleList.getSuId());
                            Tue1.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 16:
                            STue2.setText(scheduleList.getSuId());
                            Tue2.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 17:
                            STue3.setText(scheduleList.getSuId());
                            Tue3.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 18:
                            STue4.setText(scheduleList.getSuId());
                            Tue4.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 19:
                            STue5.setText(scheduleList.getSuId());
                            Tue5.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 20:
                            STue6.setText(scheduleList.getSuId());
                            Tue6.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 21:
                            STue7.setText(scheduleList.getSuId());
                            Tue7.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 22:
                            SWed1.setText(scheduleList.getSuId());
                            Wed1.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 23:
                            SWed2.setText(scheduleList.getSuId());
                            Wed2.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 24:
                            SWed3.setText(scheduleList.getSuId());
                            Wed3.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 25:
                            SWed4.setText(scheduleList.getSuId());
                            Wed4.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 26:
                            SWed5.setText(scheduleList.getSuId());
                            Wed5.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 27:
                            SWed6.setText(scheduleList.getSuId());
                            Wed6.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 28:
                            SWed7.setText(scheduleList.getSuId());
                            Wed7.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 29:
                            SThu1.setText(scheduleList.getSuId());
                            Thu1.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 30:
                            SThu2.setText(scheduleList.getSuId());
                            Thu2.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 31:
                            SThu3.setText(scheduleList.getSuId());
                            Thu3.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 32:
                            SThu4.setText(scheduleList.getSuId());
                            Thu4.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 33:
                            SThu5.setText(scheduleList.getSuId());
                            Thu5.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 34:
                            SThu6.setText(scheduleList.getSuId());
                            Thu6.setText(scheduleList.getCId().getClassDesc());
                            break;
                        case 35:
                            SThu7.setText(scheduleList.getSuId());
                            Thu7.setText(scheduleList.getCId().getClassDesc());
                    }
                }
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

                //2018
                List<Payroll> tempBonus187 = new ArrayList();
                List<Payroll> tempDeduction187 = new ArrayList();
                List<Payroll> tempBonus188 = new ArrayList();
                List<Payroll> tempDeduction188 = new ArrayList();
                List<Payroll> tempBonus189 = new ArrayList();
                List<Payroll> tempDeduction189 = new ArrayList();
                List<Payroll> tempBonus1810 = new ArrayList();
                List<Payroll> tempDeduction1810 = new ArrayList();
                List<Payroll> tempBonus1811 = new ArrayList();
                List<Payroll> tempDeduction1811 = new ArrayList();
                List<Payroll> tempBonus1812 = new ArrayList();
                List<Payroll> tempDeduction1812 = new ArrayList();
                //2019
                List<Payroll> tempBonus191 = new ArrayList();
                List<Payroll> tempDeduction191 = new ArrayList();
                List<Payroll> tempBonus192 = new ArrayList();
                List<Payroll> tempDeduction192 = new ArrayList();
                List<Payroll> tempBonus193 = new ArrayList();
                List<Payroll> tempDeduction193 = new ArrayList();
                List<Payroll> tempBonus194 = new ArrayList();
                List<Payroll> tempDeduction194 = new ArrayList();
                List<Payroll> tempBonus195 = new ArrayList();
                List<Payroll> tempDeduction195 = new ArrayList();
                List<Payroll> tempBonus196 = new ArrayList();
                List<Payroll> tempDeduction196 = new ArrayList();
                List<Payroll> tempBonus197 = new ArrayList();
                List<Payroll> tempDeduction197 = new ArrayList();
                List<Payroll> tempBonus198 = new ArrayList();
                List<Payroll> tempDeduction198 = new ArrayList();
                List<Payroll> tempBonus199 = new ArrayList();
                List<Payroll> tempDeduction199 = new ArrayList();
                List<Payroll> tempBonus1910 = new ArrayList();
                List<Payroll> tempDeduction1910 = new ArrayList();
                List<Payroll> tempBonus1911 = new ArrayList();
                List<Payroll> tempDeduction1911 = new ArrayList();
                List<Payroll> tempBonus1912 = new ArrayList();
                List<Payroll> tempDeduction1912 = new ArrayList();

                if (tempBonus.size() > 0) {
                    for (Payroll tBP : tempBonus) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(tBP.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 7 && calendar.get(Calendar.YEAR) == 2018) {
                            tempBonus187.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 8 && calendar.get(Calendar.YEAR) == 2018) {
                            tempBonus188.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 9 && calendar.get(Calendar.YEAR) == 2018) {
                            tempBonus189.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 10 && calendar.get(Calendar.YEAR) == 2018) {
                            tempBonus1810.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 11 && calendar.get(Calendar.YEAR) == 2018) {
                            tempBonus1811.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.YEAR) == 2018) {
                            tempBonus1812.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 1 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus191.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 2 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus192.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 3 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus193.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 4 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus194.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 5 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus195.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 6 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus196.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 7 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus197.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 8 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus198.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 9 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus199.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 10 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus1910.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 11 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus1911.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.YEAR) == 2019) {
                            tempBonus1912.add(tBP);
                        }
                    }
                }
                if (tempDeduction.size() > 0) {
                    for (Payroll tBP : tempDeduction) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(tBP.getPrDate());
                        if (calendar.get(Calendar.MONTH) + 1 == 7 && calendar.get(Calendar.YEAR) == 2018) {
                            tempDeduction187.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 8 && calendar.get(Calendar.YEAR) == 2018) {
                            tempDeduction188.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 9 && calendar.get(Calendar.YEAR) == 2018) {
                            tempDeduction189.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 10 && calendar.get(Calendar.YEAR) == 2018) {
                            tempDeduction1810.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 11 && calendar.get(Calendar.YEAR) == 2018) {
                            tempDeduction1811.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.YEAR) == 2018) {
                            tempDeduction1812.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 1 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction191.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 2 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction192.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 3 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction193.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 4 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction194.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 5 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction195.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 6 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction196.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 7 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction197.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 8 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction198.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 9 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction199.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 10 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction1910.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 11 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction1911.add(tBP);
                        } else if (calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.YEAR) == 2019) {
                            tempDeduction1912.add(tBP);
                        }
                    }
                }
                JUL18.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        System.out.println("size " + current.getPId().getPayrollList().size());
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());

                            if (calendar.get(Calendar.MONTH) + 1 == 7 && calendar.get(Calendar.YEAR) == 2018) {
                                if (bp.getPrType().equals("9")) {
                                    System.out.println("Disable jul18");
                                    calculateSalary.setDisable(true);
                                    Net187.setText(String.valueOf(bp.getAmount()));
                                    Gross187.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction187.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus187.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }

                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus187);
                        BonusTableJul18.setItems(bonusObserv);
                        BonusAmountColumnJul18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnJul18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnJul18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnJul18.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction187);
                        DeductionTableJul18.setItems(DeductObserv);
                        DeductionAmountColumnJul18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnJul18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnJul18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnJul18.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnJul18.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnJul18));
                    }
                });

                AUG18.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 8 && calendar.get(Calendar.YEAR) == 2018) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net.setText(String.valueOf(bp.getAmount()));
                                    Gross.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus188);
                        BonusTableAug18.setItems(bonusObserv);
                        BonusAmountColumnAug18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnAug18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnAug18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnAug18.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction188);
                        DeductionTableAug18.setItems(DeductObserv);
                        DeductionAmountColumnAug18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnAug18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnAug18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnAug18.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnAug18.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnAug18));
                    }
                });
                SEP18.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 9 && calendar.get(Calendar.YEAR) == 2018) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net189.setText(String.valueOf(bp.getAmount()));
                                    Gross189.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction189.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus189.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus189);
                        BonusTableSep18.setItems(bonusObserv);
                        BonusAmountColumnSep18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnSep18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnSep18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnSep18.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction189);
                        DeductionTableSep18.setItems(DeductObserv);
                        DeductionAmountColumnSep18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnSep18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnSep18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnSep18.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnSep18.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnSep18));
                    }
                });
                OCT18.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 10 && calendar.get(Calendar.YEAR) == 2018) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net1810.setText(String.valueOf(bp.getAmount()));
                                    Gross1810.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction1810.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus1810.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus1810);
                        BonusTableOct18.setItems(bonusObserv);
                        BonusAmountColumnOct18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnOct18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnOct18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnOct18.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction1810);
                        DeductionTableOct18.setItems(DeductObserv);
                        DeductionAmountColumnOct18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnOct18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnOct18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnOct18.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnOct18.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnOct18));
                    }
                });
                NOV18.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 11 && calendar.get(Calendar.YEAR) == 2018) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net1811.setText(String.valueOf(bp.getAmount()));
                                    Gross1811.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction1811.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus1811.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus1811);
                        BonusTableNov18.setItems(bonusObserv);
                        BonusAmountColumnNov18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnNov18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnNov18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnNov18.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction1811);
                        DeductionTableNov18.setItems(DeductObserv);
                        DeductionAmountColumnNov18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnNov18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnNov18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnNov18.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnNov18.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnNov18));
                    }
                });
                DEC18.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.YEAR) == 2018) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net1812.setText(String.valueOf(bp.getAmount()));
                                    Gross1812.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction1812.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus1812.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus1812);
                        BonusTableDec18.setItems(bonusObserv);
                        BonusAmountColumnDec18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnDec18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnDec18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnDec18.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction1812);
                        DeductionTableDec18.setItems(DeductObserv);
                        DeductionAmountColumnDec18.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnDec18.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnDec18.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnDec18.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnDec18.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnDec18));
                    }
                });
                JAN19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 1 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net191.setText(String.valueOf(bp.getAmount()));
                                    Gross191.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction191.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus191.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus191);
                        BonusTableJan19.setItems(bonusObserv);
                        BonusAmountColumnJan19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnJan19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnJan19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnJan19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction191);
                        DeductionTableJan19.setItems(DeductObserv);
                        DeductionAmountColumnJan19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnJan19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnJan19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnJan19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnJan19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnJan19));
                    }
                });
                FEB19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 2 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net192.setText(String.valueOf(bp.getAmount()));
                                    Gross192.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction192.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus192.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus192);
                        BonusTableFeb19.setItems(bonusObserv);
                        BonusAmountColumnFeb19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnFeb19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnFeb19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnFeb19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction192);
                        DeductionTableFeb19.setItems(DeductObserv);
                        DeductionAmountColumnFeb19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnFeb19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnFeb19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnFeb19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnFeb19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnFeb19));
                    }
                });
                MAR19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 3 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net193.setText(String.valueOf(bp.getAmount()));
                                    Gross193.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction193.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus193.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus193);
                        BonusTableMar19.setItems(bonusObserv);
                        BonusAmountColumnMar19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnMar19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnMar19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnMar19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction193);
                        DeductionTableMar19.setItems(DeductObserv);
                        DeductionAmountColumnMar19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnMar19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnMar19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnMar19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnMar19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnMar19));
                    }
                });
                APR19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 4 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net194.setText(String.valueOf(bp.getAmount()));
                                    Gross194.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction194.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus194.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus194);
                        BonusTableApr19.setItems(bonusObserv);
                        BonusAmountColumnApr19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnApr19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnApr19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnApr19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction194);
                        DeductionTableApr19.setItems(DeductObserv);
                        DeductionAmountColumnApr19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnApr19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnApr19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnApr19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnApr19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnApr19));
                    }
                });
                MAY19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 5 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net195.setText(String.valueOf(bp.getAmount()));
                                    Gross195.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction195.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus195.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus195);
                        BonusTableMay19.setItems(bonusObserv);
                        BonusAmountColumnMay19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnMay19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnMay19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnMay19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction195);
                        DeductionTableMay19.setItems(DeductObserv);
                        DeductionAmountColumnMay19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnMay19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnMay19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnMay19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnMay19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnMay19));
                    }
                });
                JUN19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 6 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net196.setText(String.valueOf(bp.getAmount()));
                                    Gross196.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction196.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus196.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus196);
                        BonusTableJun19.setItems(bonusObserv);
                        BonusAmountColumnJun19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnJun19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnJun19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnJun19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction196);
                        DeductionTableJun19.setItems(DeductObserv);
                        DeductionAmountColumnJun19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnJun19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnJun19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnJun19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnJun19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnJun19));
                    }
                });
                JUL19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 7 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net197.setText(String.valueOf(bp.getAmount()));
                                    Gross197.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction197.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus197.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus197);
                        BonusTableJul19.setItems(bonusObserv);
                        BonusAmountColumnJul19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnJul19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnJul19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnJul19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction197);
                        DeductionTableJul19.setItems(DeductObserv);
                        DeductionAmountColumnJul19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnJul19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnJul19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnJul19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnJul19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnJul19));
                    }
                });
                AUG19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 8 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net198.setText(String.valueOf(bp.getAmount()));
                                    Gross198.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction198.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus198.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus198);
                        BonusTableAug19.setItems(bonusObserv);
                        BonusAmountColumnAug19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnAug19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnAug19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnAug19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction198);
                        DeductionTableAug19.setItems(DeductObserv);
                        DeductionAmountColumnAug19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnAug19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnAug19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnAug19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnAug19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnAug19));
                    }
                });
                SEP19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 9 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net199.setText(String.valueOf(bp.getAmount()));
                                    Gross199.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction199.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus199.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus199);
                        BonusTableSep19.setItems(bonusObserv);
                        BonusAmountColumnSep19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnSep19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnSep19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnSep19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction199);
                        DeductionTableSep19.setItems(DeductObserv);
                        DeductionAmountColumnSep19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnSep19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnSep19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnSep19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnSep19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnSep19));
                    }
                });
                OCT19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 10 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net1910.setText(String.valueOf(bp.getAmount()));
                                    Gross1910.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction1910.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus1910.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus1910);
                        BonusTableOct19.setItems(bonusObserv);
                        BonusAmountColumnOct19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnOct19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnOct19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnOct19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction1910);
                        DeductionTableOct19.setItems(DeductObserv);
                        DeductionAmountColumnOct19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnOct19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnOct19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnOct19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnOct19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnOct19));
                    }
                });
                NOV19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 11 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net1911.setText(String.valueOf(bp.getAmount()));
                                    Gross1911.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction1911.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus1911.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus1911);
                        BonusTableNov19.setItems(bonusObserv);
                        BonusAmountColumnNov19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnNov19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnNov19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnNov19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction1911);
                        DeductionTableNov19.setItems(DeductObserv);
                        DeductionAmountColumnNov19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnNov19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnNov19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnNov19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnNov19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnNov19));
                    }
                });
                DEC19.selectedProperty().addListener((ov, oldTab, newTab) -> {
                    if (newTab) {
                        calculateSalary.setDisable(false);
                        for (Payroll bp : current.getPId().getPayrollList()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(bp.getPrDate());
                            if (calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.YEAR) == 2019) {
                                if (bp.getPrType().equals("9")) {
                                    calculateSalary.setDisable(true);
                                    Net1912.setText(String.valueOf(bp.getAmount()));
                                    Gross1912.setText(String.valueOf(current.getMonthlySalary()));
                                } else if (bp.getPrType().equals("8")) {
                                    Deduction1912.setText(String.valueOf(bp.getAmount()));
                                } else if (bp.getPrType().equals("7")) {
                                    Bonus1912.setText(String.valueOf(bp.getAmount()));
                                }
                            }
                        }
                        ObservableList<Payroll> bonusObserv = FXCollections.observableArrayList(tempBonus1912);
                        BonusTableDec19.setItems(bonusObserv);
                        BonusAmountColumnDec19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        BonusDateColumnDec19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        BonusNotesColumnDec19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        BonusTypeColumnDec19.setCellValueFactory(cellData -> cellData.getValue().TypeBonusProperty());
                        ObservableList<Payroll> DeductObserv = FXCollections.observableArrayList(tempDeduction1912);
                        DeductionTableDec19.setItems(DeductObserv);
                        DeductionAmountColumnDec19.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
                        DeductionDateColumnDec19.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
                        DeductionNotesColumnDec19.setCellValueFactory(cellData -> cellData.getValue().NoteProperty());
                        DeductionStatusColumnDec19.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
                        DeductionStatusColumnDec19.setCellFactory(CheckBoxTableCell.forTableColumn(DeductionStatusColumnDec19));
                    }
                });
            }

            ev.selectedProperty().addListener((ov, oldTab, newTab) -> {
                if (newTab) {
                    TeachingStaff.setEdit(current);
                    TS.setEvaluationList(TS.getEvaluations());
                    EvaluationTable.setItems(TeachingStaff.getEvaluationList());
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

            EvaluationTable.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> showDetails(newValue));
            PhotoPath.setImage(new Image(new File(current.getPId().getPersonalPhoto()).toURI().toString()));
        } catch (Exception e) {
            System.err.println("ERROR IN INIT" + e.getCause());
        }
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
            dialogStage2.initOwner(TS.getDialogStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage2.setScene(scene);
            dialogStage2.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final Logger LOGGER = LogManager.getLogger(ViewTeacherController.class);
    @FXML
    public void handlePrintSchedule(){
        try {
            SnapshotParameters spp = new SnapshotParameters();
            final Affine reflectTransform = new Affine();
            reflectTransform.setMxx(-1);
            reflectTransform.setTx(708);
            
            spp.setTransform(reflectTransform);
            WritableImage image = scheduleAP.snapshot(spp, null);
            File file = new File("D:\\جدول حصص - "
                    + current.getPId().getName()
                    + ".png");
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (Exception e) {
            LOGGER.error(e);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء التأكد من صحة البيانات");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
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
            eval.setPid(TS.getEdit().getPId());
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
            TS.PersistEval(eval);
            showDetails(null);
            EvaluationTable.getItems().clear();
            EvaluationTable.setItems(TS.getEvaluationList());
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
            TS.EditEval(eval);
            showDetails(null);
            EvaluationTable.getItems().clear();
            EvaluationTable.setItems(TS.getEvaluationList());
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
        if (JUL18.isSelected()) {
            calculateNetSalary(7);
        } else if (AUG18.isSelected()) {
            calculateNetSalary(8);
        } else if (SEP18.isSelected()) {
            calculateNetSalary(9);
        } else if (OCT18.isSelected()) {
            calculateNetSalary(10);
        } else if (NOV18.isSelected()) {
            calculateNetSalary(11);
        } else if (DEC18.isSelected()) {
            calculateNetSalary(12);
        } else if (JAN19.isSelected()) {
            calculateNetSalary(1);
        } else if (FEB19.isSelected()) {
            calculateNetSalary(2);
        } else if (MAR19.isSelected()) {
            calculateNetSalary(3);
        } else if (APR19.isSelected()) {
            calculateNetSalary(4);
        } else if (MAY19.isSelected()) {
            calculateNetSalary(5);
        } else if (JUN19.isSelected()) {
            calculateNetSalary(6);
        } else if (JUL19.isSelected()) {
            calculateNetSalary(7);
        } else if (AUG19.isSelected()) {
            calculateNetSalary(8);
        } else if (SEP19.isSelected()) {
            calculateNetSalary(9);
        } else if (OCT19.isSelected()) {
            calculateNetSalary(10);
        } else if (NOV19.isSelected()) {
            calculateNetSalary(11);
        } else if (DEC19.isSelected()) {
            calculateNetSalary(12);
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
                            if (!tPR.getPrStatus()) {
                                netsalDouble += tPR.getAmount();
                                bonus += tPR.getAmount();
                                tPR.setPrStatus(true);
                                TS.UpdatePayroll(tPR);
                            }
                            break;
                    }
                }
            }
            day = netsalDouble / 30;
            for (Payroll tPR : current.getPId().getPayrollList()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(tPR.getPrDate());
                if (calendar.get(Calendar.MONTH) + 1 == m && calendar.get(Calendar.YEAR)
                        == Calendar.getInstance().get(Calendar.YEAR)) {
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
                            case "1": //
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
                            case "6": //
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
        netsalDouble = Double.valueOf(f.format(netsalDouble));
        deduction = Double.valueOf(f.format(deduction));
        bonus = Double.valueOf(f.format(bonus));
        System.out.println("Deduction " + deduction);

        updateSalaryTable(m);
        current.getPId().getPayrollList().add(TS.PersistNewNetSalary("تم استلام المرتب", current.getPId(), netsalDouble, "الادارة"));
        current.getPId().getPayrollList().add(TS.PersistNewDeductionsSalary("تم الخصم", current.getPId(), deduction));
        current.getPId().getPayrollList().add(TS.PersistNewBonusSalary("تم اضافة المكافأت", current.getPId(), bonus));
    }

    void updateSalaryTable(int mm) {
        if (Calendar.getInstance().get(Calendar.YEAR) == 2018) {
            switch (mm) {
                case 7:
                    Gross187.setText(current.getMonthlySalary().toString());
                    Deduction187.setText(String.valueOf(deduction));
                    Bonus187.setText(String.valueOf(bonus));
                    Net187.setText(String.valueOf(netsalDouble));
                    break;
                case 8:
                    Gross.setText(current.getMonthlySalary().toString());
                    Deduction.setText(String.valueOf(deduction));
                    Bonus.setText(String.valueOf(bonus));
                    Net.setText(String.valueOf(netsalDouble));
                    break;
                case 9:
                    Gross189.setText(current.getMonthlySalary().toString());
                    Deduction189.setText(String.valueOf(deduction));
                    Bonus189.setText(String.valueOf(bonus));
                    Net189.setText(String.valueOf(netsalDouble));
                    break;
                case 10:
                    Gross1810.setText(current.getMonthlySalary().toString());
                    Deduction1810.setText(String.valueOf(deduction));
                    Bonus1810.setText(String.valueOf(bonus));
                    Net1810.setText(String.valueOf(netsalDouble));
                    break;
                case 11:
                    Gross1811.setText(current.getMonthlySalary().toString());
                    Deduction1811.setText(String.valueOf(deduction));
                    Bonus1811.setText(String.valueOf(bonus));
                    Net1811.setText(String.valueOf(netsalDouble));
                    break;
                case 12:
                    Gross1812.setText(current.getMonthlySalary().toString());
                    Deduction1812.setText(String.valueOf(deduction));
                    Bonus1812.setText(String.valueOf(bonus));
                    Net1812.setText(String.valueOf(netsalDouble));
                    break;

            }
        } else if (Calendar.getInstance().get(Calendar.YEAR) == 2019) {
            switch (mm) {
                case 1:
                    Gross191.setText(current.getMonthlySalary().toString());
                    Deduction191.setText(String.valueOf(deduction));
                    Bonus191.setText(String.valueOf(bonus));
                    Net191.setText(String.valueOf(netsalDouble));
                    break;
                case 2:
                    Gross192.setText(current.getMonthlySalary().toString());
                    Deduction192.setText(String.valueOf(deduction));
                    Bonus192.setText(String.valueOf(bonus));
                    Net192.setText(String.valueOf(netsalDouble));
                    break;
                case 3:
                    Gross193.setText(current.getMonthlySalary().toString());
                    Deduction193.setText(String.valueOf(deduction));
                    Bonus193.setText(String.valueOf(bonus));
                    Net193.setText(String.valueOf(netsalDouble));
                    break;
                case 4:
                    Gross194.setText(current.getMonthlySalary().toString());
                    Deduction194.setText(String.valueOf(deduction));
                    Bonus194.setText(String.valueOf(bonus));
                    Net194.setText(String.valueOf(netsalDouble));
                    break;
                case 5:
                    Gross195.setText(current.getMonthlySalary().toString());
                    Deduction195.setText(String.valueOf(deduction));
                    Bonus195.setText(String.valueOf(bonus));
                    Net195.setText(String.valueOf(netsalDouble));
                    break;
                case 6:
                    Gross196.setText(current.getMonthlySalary().toString());
                    Deduction196.setText(String.valueOf(deduction));
                    Bonus196.setText(String.valueOf(bonus));
                    Net196.setText(String.valueOf(netsalDouble));
                    break;
                case 7:
                    Gross197.setText(current.getMonthlySalary().toString());
                    Deduction197.setText(String.valueOf(deduction));
                    Bonus197.setText(String.valueOf(bonus));
                    Net197.setText(String.valueOf(netsalDouble));
                    break;
                case 8:
                    Gross198.setText(current.getMonthlySalary().toString());
                    Deduction198.setText(String.valueOf(deduction));
                    Bonus198.setText(String.valueOf(bonus));
                    Net198.setText(String.valueOf(netsalDouble));
                    break;
                case 9:
                    Gross199.setText(current.getMonthlySalary().toString());
                    Deduction199.setText(String.valueOf(deduction));
                    Bonus199.setText(String.valueOf(bonus));
                    Net199.setText(String.valueOf(netsalDouble));
                    break;
                case 10:
                    Gross1910.setText(current.getMonthlySalary().toString());
                    Deduction1910.setText(String.valueOf(deduction));
                    Bonus1910.setText(String.valueOf(bonus));
                    Net1910.setText(String.valueOf(netsalDouble));
                    break;
                case 11:
                    Gross1911.setText(current.getMonthlySalary().toString());
                    Deduction1911.setText(String.valueOf(deduction));
                    Bonus1911.setText(String.valueOf(bonus));
                    Net1911.setText(String.valueOf(netsalDouble));
                    break;
                case 12:
                    Gross1912.setText(current.getMonthlySalary().toString());
                    Deduction1912.setText(String.valueOf(deduction));
                    Bonus1912.setText(String.valueOf(bonus));
                    Net1912.setText(String.valueOf(netsalDouble));
                    break;
            }
        }

    }

    @FXML
    public void handleEdit() {
        int selectedIndex = AttTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            TeachingStaff.setEditStatus(AttTable.getItems().get(selectedIndex));
            TS.ViewEditAbscentStatus();
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
            TeachingStaff.setEditPayrollStatus(PenaltyTable.getItems().get(selectedIndex));

            TS.ViewEditPenaltyStatus();

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
}
