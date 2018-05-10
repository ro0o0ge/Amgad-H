/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.BoardDecisions;
import amgad.h.Management;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class BoardDecisionController implements Initializable {

    @FXML
    private TextField SearchQuery;
    @FXML
    private TextField Title;
    @FXML
    private TextArea Notes;
    @FXML
    private TableView<BoardDecisions> DecisionsTable;
    @FXML
    private TableColumn<BoardDecisions, String> TitleColumn;
    @FXML
    private TableColumn<BoardDecisions, String> DateColumn;
    @FXML
    private ComboBox ComboSearch;

    Management MA;

    BoardDecisions st;

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
        ComboSearch.getItems().removeAll(ComboSearch.getItems());
        ComboSearch.getItems().addAll("العنوان", "التاريخ");
        ComboSearch.getSelectionModel().select(0);

        DecisionsTable.setItems(Management.getBoardDecisionList());
        TitleColumn.setCellValueFactory(cellData -> cellData.getValue().TitleProperty());
        DateColumn.setCellValueFactory(cellData -> cellData.getValue().DDateProperty());

        DecisionsTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));
    }

    private void showDetails(BoardDecisions shera2) {
        if (shera2 != null) {
            // Fill the labels with info from the person object.
            Title.setText(shera2.getTitle());
            Notes.setText(shera2.getBody());
        } else {
            // Person is null, remove all the text.
            Title.setText("");
            Notes.setText("");
        }
    }

    @FXML
    public void Search() {
        if (!SearchQuery.getText().equals("")) {
            ObservableList<BoardDecisions> TempList = FXCollections.observableArrayList(MA.getBoardDecision());
            DecisionsTable.getItems().clear();

            if (ComboSearch.getSelectionModel().isSelected(0)) {//title
                for (int i = 0; i < TempList.size(); i++) {
                    if (!TempList.get(i).TitleProperty().toString().contains(SearchQuery.getText())) {
                        TempList.remove(i);
                        i--;
                    }
                }
                DecisionsTable.setItems(TempList);
            } else {//date
                System.out.println("size " + TempList.size());
                for (int i = 0; i < TempList.size(); i++) {
                    if (!TempList.get(i).DDateProperty().toString().contains(SearchQuery.getText())) {
                        TempList.remove(i);
                        i--;
                    }
                }
                DecisionsTable.setItems(TempList);
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

        if (!Title.getText().equals("") && !Notes.getText().equals("")) {
            st = new BoardDecisions();
            st.setTitle(Title.getText());
            st.setBody(Notes.getText());
            st.setDDate(Date.valueOf(LocalDate.now()));
            System.out.println("Time " + st.getDDate());
            MA.PersistDecision(st);
            showDetails(null);
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
    public void handleEdit() {
        if (!Title.getText().equals("") && !Notes.getText().equals("")) {
            st = DecisionsTable.getSelectionModel().getSelectedItem();
            st.setTitle(Title.getText());
            st.setBody(Notes.getText());
            st.setDDate(Date.valueOf(LocalDate.now()));
            MA.UpdateDecision(st);
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
