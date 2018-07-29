/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Student;
import Entity.StudentNotes;
import amgad.h.StudentAffair;
import java.net.URL;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class StudNotesController implements Initializable {

    @FXML
    private TableView<StudentNotes> NotesTable;
    @FXML
    private TableColumn<StudentNotes, String> TitleColumn;
    @FXML
    private TableColumn<StudentNotes, String> DateColumn;
    @FXML
    private TableColumn<StudentNotes, String> ContentColumn;
    @FXML
    private Label StudName;
    @FXML
    private TextArea NoteBody;
    @FXML
    ComboBox NoteType;

    StudentAffair SA;

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
        NotesTable.setItems(SA.getStudentNotesList());
        TitleColumn.setCellValueFactory(cellData -> cellData.getValue().TitleProperty());
        ContentColumn.setCellValueFactory(cellData -> cellData.getValue().TypeProperty());
        DateColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
        StudName.setText(current.getPId().getName());

        NoteType.getItems().removeAll(NoteType.getItems());
        NoteType.getItems().addAll("السلوك", "الهوايات", "الحالة الصحية", "المستوى التعليمي",
                "الإلتزام (التأخير)", "الإلتزام (الغياب)", "ملاحظات");

        NotesTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));
    }

    private void showDetails(StudentNotes shera2) {
        if (shera2 != null) {
            NoteBody.setText(shera2.getNDesc());
        } else {
            NoteBody.setText("");
        }
    }

    @FXML
    public void handleNew() {
        if (!NoteBody.getText().equals("")) {
            StudentNotes Temp = new StudentNotes();
            Temp.setNDesc(NoteBody.getText());
            Temp.setNDate(Date.valueOf(LocalDate.now()));
            Temp.setSId(current);
            Temp.setNType(NoteType.getSelectionModel().getSelectedItem().toString());
            SA.PersistNewStudentNote(Temp);
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
    public void handleDelete() {
        int selectedIndex = NotesTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            SA.RemoveStudentNote(NotesTable.getItems().get(selectedIndex));
            SA.getStudentNotesList().remove(NotesTable.getItems().get(selectedIndex));
//            NotesTable.getItems().remove(selectedIndex);
            NotesTable.setItems(SA.getStudentNotesList());
//            SA.LoadStudentsInClass(ComboClass.getSelectionModel().getSelectedItem().toString());
//            StudentsInClassTable.setItems(SA.getStudentsInClassList());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

}
