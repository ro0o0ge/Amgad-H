/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Classes;
import Entity.LectureDatetime;
import Entity.Schedule;
import amgad.h.TeachingStaff;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class ScheduleController implements Initializable {

    @FXML
    private TextField Sun1;
    @FXML
    private TextField Sun2;
    @FXML
    private TextField Sun3;
    @FXML
    private TextField Sun4;
    @FXML
    private TextField Sun5;
    @FXML
    private TextField Sun6;
    @FXML
    private TextField Sun7;
    @FXML
    private TextField Mon1;
    @FXML
    private TextField Mon2;
    @FXML
    private TextField Mon3;
    @FXML
    private TextField Mon4;
    @FXML
    private TextField Mon5;
    @FXML
    private TextField Mon6;
    @FXML
    private TextField Mon7;
    @FXML
    private TextField Tue1;
    @FXML
    private TextField Tue2;
    @FXML
    private TextField Tue3;
    @FXML
    private TextField Tue4;
    @FXML
    private TextField Tue5;
    @FXML
    private TextField Tue6;
    @FXML
    private TextField Tue7;
    @FXML
    private TextField Wed1;
    @FXML
    private TextField Wed2;
    @FXML
    private TextField Wed3;
    @FXML
    private TextField Wed4;
    @FXML
    private TextField Wed5;
    @FXML
    private TextField Wed6;
    @FXML
    private TextField Wed7;
    @FXML
    private TextField Thu1;
    @FXML
    private TextField Thu2;
    @FXML
    private TextField Thu3;
    @FXML
    private TextField Thu4;
    @FXML
    private TextField Thu5;
    @FXML
    private TextField Thu6;
    @FXML
    private TextField Thu7;
    @FXML
    private ComboBox comboClass;

    TeachingStaff MA;
    Schedule sc;
    Classes c;
    List<LectureDatetime> lecList;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MA = new TeachingStaff();
        comboClass.getItems().addAll(getClasses());
        
        comboClass.valueProperty().addListener((ov, oldValue, newValue) -> {
            List<Schedule> s = MA.getSchedulebyClassDesc(newValue.toString());
            Sun1.setText(s.get(0).getSuId());
            Sun2.setText(s.get(1).getSuId());
            Sun3.setText(s.get(2).getSuId());
            Sun4.setText(s.get(3).getSuId());
            Sun5.setText(s.get(4).getSuId());
            Sun6.setText(s.get(5).getSuId());
            Sun7.setText(s.get(6).getSuId());
            Mon1.setText(s.get(7).getSuId());
            Mon2.setText(s.get(8).getSuId());
            Mon3.setText(s.get(9).getSuId());
            Mon4.setText(s.get(10).getSuId());
            Mon5.setText(s.get(11).getSuId());
            Mon6.setText(s.get(12).getSuId());
            Mon7.setText(s.get(13).getSuId());
            Tue1.setText(s.get(14).getSuId());
            Tue2.setText(s.get(15).getSuId());
            Tue3.setText(s.get(16).getSuId());
            Tue4.setText(s.get(17).getSuId());
            Tue5.setText(s.get(18).getSuId());
            Tue6.setText(s.get(19).getSuId());
            Tue7.setText(s.get(20).getSuId());
            Wed1.setText(s.get(21).getSuId());
            Wed2.setText(s.get(22).getSuId());
            Wed3.setText(s.get(23).getSuId());
            Wed4.setText(s.get(24).getSuId());
            Wed5.setText(s.get(25).getSuId());
            Wed6.setText(s.get(26).getSuId());
            Wed7.setText(s.get(27).getSuId());
            Thu1.setText(s.get(28).getSuId());
            Thu2.setText(s.get(29).getSuId());
            Thu3.setText(s.get(30).getSuId());
            Thu4.setText(s.get(31).getSuId());
            Thu5.setText(s.get(32).getSuId());
            Thu6.setText(s.get(33).getSuId());
            Thu7.setText(s.get(34).getSuId());
        });

    }

    private List<String> getClasses() {
        List<String> StudY = new ArrayList<String>();
        for (Classes sy : MA.getClasses()) {
            StudY.add(sy.getClassDesc());
        }
        return StudY;
    }

    @FXML
    public void SerachSC() {
    }

    public void createNew(String s, LectureDatetime ldt) {
        sc.setCId(c);
        sc.setLecId(ldt);
        sc.setSuId(s);
        MA.PersistNewSchedule(sc);
    }

    @FXML
    public void Save() {
        if (!comboClass.getValue().equals("")) {
            sc = new Schedule();
            c = MA.getClassesByDesc(comboClass.getValue().toString());
            lecList = MA.getLectures();

            createNew(Sun1.getText(), lecList.get(0));
            sc = new Schedule();
            createNew(Sun2.getText(), lecList.get(1));
            sc = new Schedule();
            createNew(Sun3.getText(), lecList.get(2));
            sc = new Schedule();
            createNew(Sun4.getText(), lecList.get(3));
            sc = new Schedule();
            createNew(Sun5.getText(), lecList.get(4));
            sc = new Schedule();
            createNew(Sun6.getText(), lecList.get(5));
            sc = new Schedule();
            createNew(Sun7.getText(), lecList.get(6));
            sc = new Schedule();
            createNew(Mon1.getText(), lecList.get(7));
            sc = new Schedule();
            createNew(Mon2.getText(), lecList.get(8));
            sc = new Schedule();
            createNew(Mon3.getText(), lecList.get(9));
            sc = new Schedule();
            createNew(Mon4.getText(), lecList.get(10));
            sc = new Schedule();
            createNew(Mon5.getText(), lecList.get(11));
            sc = new Schedule();
            createNew(Mon6.getText(), lecList.get(12));
            sc = new Schedule();
            createNew(Mon7.getText(), lecList.get(13));
            sc = new Schedule();
            createNew(Tue1.getText(), lecList.get(14));
            sc = new Schedule();
            createNew(Tue2.getText(), lecList.get(15));
            sc = new Schedule();
            createNew(Tue3.getText(), lecList.get(16));
            sc = new Schedule();
            createNew(Tue4.getText(), lecList.get(17));
            sc = new Schedule();
            createNew(Tue5.getText(), lecList.get(18));
            sc = new Schedule();
            createNew(Tue6.getText(), lecList.get(19));
            sc = new Schedule();
            createNew(Tue7.getText(), lecList.get(20));
            sc = new Schedule();
            createNew(Wed1.getText(), lecList.get(21));
            sc = new Schedule();
            createNew(Wed2.getText(), lecList.get(22));
            sc = new Schedule();
            createNew(Wed3.getText(), lecList.get(23));
            sc = new Schedule();
            createNew(Wed4.getText(), lecList.get(24));
            sc = new Schedule();
            createNew(Wed5.getText(), lecList.get(25));
            sc = new Schedule();
            createNew(Wed6.getText(), lecList.get(26));
            sc = new Schedule();
            createNew(Wed7.getText(), lecList.get(27));
            sc = new Schedule();
            createNew(Thu1.getText(), lecList.get(28));
            sc = new Schedule();
            createNew(Thu2.getText(), lecList.get(29));
            sc = new Schedule();
            createNew(Thu3.getText(), lecList.get(30));
            sc = new Schedule();
            createNew(Thu4.getText(), lecList.get(31));
            sc = new Schedule();
            createNew(Thu5.getText(), lecList.get(32));
            sc = new Schedule();
            createNew(Thu6.getText(), lecList.get(33));
            sc = new Schedule();
            createNew(Thu7.getText(), lecList.get(34));

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("خطأ");
            alert.setContentText("برجاء التأكد من البيانات");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    @FXML
    public void Cancel() {
        MA.getDialogStage2().close();
    }
}
