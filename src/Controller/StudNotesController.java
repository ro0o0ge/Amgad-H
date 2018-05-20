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
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private Label StudName;
    @FXML
    private TextArea NoteBody;

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
        DateColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
        StudName.setText(current.getPId().getName());

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
