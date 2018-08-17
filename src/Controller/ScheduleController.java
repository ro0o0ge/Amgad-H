/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Classes;
import Entity.LectureDatetime;
import Entity.Schedule;
import Entity.Teacher;
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

    @FXML
    private ComboBox TSun1;
    @FXML
    private ComboBox TSun2;
    @FXML
    private ComboBox TSun3;
    @FXML
    private ComboBox TSun4;
    @FXML
    private ComboBox TSun5;
    @FXML
    private ComboBox TSun6;
    @FXML
    private ComboBox TSun7;
    @FXML
    private ComboBox TMon1;
    @FXML
    private ComboBox TMon2;
    @FXML
    private ComboBox TMon3;
    @FXML
    private ComboBox TMon4;
    @FXML
    private ComboBox TMon5;
    @FXML
    private ComboBox TMon6;
    @FXML
    private ComboBox TMon7;
    @FXML
    private ComboBox TTue1;
    @FXML
    private ComboBox TTue2;
    @FXML
    private ComboBox TTue3;
    @FXML
    private ComboBox TTue4;
    @FXML
    private ComboBox TTue5;
    @FXML
    private ComboBox TTue6;
    @FXML
    private ComboBox TTue7;
    @FXML
    private ComboBox TWed1;
    @FXML
    private ComboBox TWed2;
    @FXML
    private ComboBox TWed3;
    @FXML
    private ComboBox TWed4;
    @FXML
    private ComboBox TWed5;
    @FXML
    private ComboBox TWed6;
    @FXML
    private ComboBox TWed7;
    @FXML
    private ComboBox TThu1;
    @FXML
    private ComboBox TThu2;
    @FXML
    private ComboBox TThu3;
    @FXML
    private ComboBox TThu4;
    @FXML
    private ComboBox TThu5;
    @FXML
    private ComboBox TThu6;
    @FXML
    private ComboBox TThu7;

    TeachingStaff MA;
    Schedule sc;
    Classes c;
    List<LectureDatetime> lecList;

    int tempcheck = 0;

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
            MA = new TeachingStaff();
            comboClass.getItems().addAll(getClasses());

            comboClass.valueProperty().addListener((ov, oldValue, newValue) -> {
                List<Schedule> s = MA.getSchedulebyClassDesc(newValue.toString());
                List<String> Ts = MA.getClassTeachers(newValue.toString());
                if (Ts.size() > 0 && s.isEmpty()) {
                    tempcheck = 1;
                    TSun1.getItems().setAll(Ts);
                    TSun2.getItems().setAll(Ts);
                    TSun3.getItems().setAll(Ts);
                    TSun4.getItems().setAll(Ts);
                    TSun5.getItems().setAll(Ts);
                    TMon1.getItems().setAll(Ts);
                    TMon2.getItems().setAll(Ts);
                    TMon3.getItems().setAll(Ts);
                    TMon4.getItems().setAll(Ts);
                    TMon5.getItems().setAll(Ts);
                    TTue1.getItems().setAll(Ts);
                    TTue2.getItems().setAll(Ts);
                    TTue3.getItems().setAll(Ts);
                    TTue4.getItems().setAll(Ts);
                    TTue5.getItems().setAll(Ts);
                    TWed1.getItems().setAll(Ts);
                    TWed2.getItems().setAll(Ts);
                    TWed3.getItems().setAll(Ts);
                    TWed4.getItems().setAll(Ts);
                    TWed5.getItems().setAll(Ts);
                    TThu1.getItems().setAll(Ts);
                    TThu2.getItems().setAll(Ts);
                    TThu3.getItems().setAll(Ts);
                    TThu4.getItems().setAll(Ts);
                    TThu5.getItems().setAll(Ts);
                } else if (tempcheck == 1) {
                    TSun1.getItems().clear();
                    TSun2.getItems().clear();
                    TSun3.getItems().clear();
                    TSun4.getItems().clear();
                    TSun5.getItems().clear();
                    TMon1.getItems().clear();
                    TMon2.getItems().clear();
                    TMon3.getItems().clear();
                    TMon4.getItems().clear();
                    TMon5.getItems().clear();
                    TTue1.getItems().clear();
                    TTue2.getItems().clear();
                    TTue3.getItems().clear();
                    TTue4.getItems().clear();
                    TTue5.getItems().clear();
                    TWed1.getItems().clear();
                    TWed2.getItems().clear();
                    TWed3.getItems().clear();
                    TWed4.getItems().clear();
                    TWed5.getItems().clear();
                    TThu1.getItems().clear();
                    TThu2.getItems().clear();
                    TThu3.getItems().clear();
                    TThu4.getItems().clear();
                    TThu5.getItems().clear();
                }

                if (s.size() < 1) {
                    Sun1.setText("");
                    Sun2.setText("");
                    Sun3.setText("");
                    Sun4.setText("");
                    Sun5.setText("");
                    Mon1.setText("");
                    Mon2.setText("");
                    Mon3.setText("");
                    Mon4.setText("");
                    Mon5.setText("");
                    Tue1.setText("");
                    Tue2.setText("");
                    Tue3.setText("");
                    Tue4.setText("");
                    Tue5.setText("");
                    Wed1.setText("");
                    Wed2.setText("");
                    Wed3.setText("");
                    Wed4.setText("");
                    Wed5.setText("");
                    Thu1.setText("");
                    Thu2.setText("");
                    Thu3.setText("");
                    Thu4.setText("");
                    Thu5.setText("");
                } else {
                    Sun1.setText(s.get(0).getSuId());
                    Sun2.setText(s.get(1).getSuId());
                    Sun3.setText(s.get(2).getSuId());
                    Sun4.setText(s.get(3).getSuId());
                    Sun5.setText(s.get(4).getSuId());
                    Mon1.setText(s.get(7).getSuId());
                    Mon2.setText(s.get(8).getSuId());
                    Mon3.setText(s.get(9).getSuId());
                    Mon4.setText(s.get(10).getSuId());
                    Mon5.setText(s.get(11).getSuId());
                    Tue1.setText(s.get(14).getSuId());
                    Tue2.setText(s.get(15).getSuId());
                    Tue3.setText(s.get(16).getSuId());
                    Tue4.setText(s.get(17).getSuId());
                    Tue5.setText(s.get(18).getSuId());
                    Wed1.setText(s.get(21).getSuId());
                    Wed2.setText(s.get(22).getSuId());
                    Wed3.setText(s.get(23).getSuId());
                    Wed4.setText(s.get(24).getSuId());
                    Wed5.setText(s.get(25).getSuId());
                    Thu1.setText(s.get(28).getSuId());
                    Thu2.setText(s.get(29).getSuId());
                    Thu3.setText(s.get(30).getSuId());
                    Thu4.setText(s.get(31).getSuId());
                    Thu5.setText(s.get(32).getSuId());

                    TSun1.setValue(MA.getTeacherNameByID(s.get(0).getTId().getTId()));
                    TSun2.setValue(MA.getTeacherNameByID(s.get(1).getTId().getTId()));
                    TSun3.setValue(MA.getTeacherNameByID(s.get(2).getTId().getTId()));
                    TSun4.setValue(MA.getTeacherNameByID(s.get(3).getTId().getTId()));
                    TSun5.setValue(MA.getTeacherNameByID(s.get(4).getTId().getTId()));
                    TMon1.setValue(MA.getTeacherNameByID(s.get(7).getTId().getTId()));
                    TMon2.setValue(MA.getTeacherNameByID(s.get(8).getTId().getTId()));
                    TMon3.setValue(MA.getTeacherNameByID(s.get(9).getTId().getTId()));
                    TMon4.setValue(MA.getTeacherNameByID(s.get(10).getTId().getTId()));
                    TMon5.setValue(MA.getTeacherNameByID(s.get(11).getTId().getTId()));
                    TTue1.setValue(MA.getTeacherNameByID(s.get(14).getTId().getTId()));
                    TTue2.setValue(MA.getTeacherNameByID(s.get(15).getTId().getTId()));
                    TTue3.setValue(MA.getTeacherNameByID(s.get(16).getTId().getTId()));
                    TTue4.setValue(MA.getTeacherNameByID(s.get(17).getTId().getTId()));
                    TTue5.setValue(MA.getTeacherNameByID(s.get(18).getTId().getTId()));
                    TWed1.setValue(MA.getTeacherNameByID(s.get(21).getTId().getTId()));
                    TWed2.setValue(MA.getTeacherNameByID(s.get(22).getTId().getTId()));
                    TWed3.setValue(MA.getTeacherNameByID(s.get(23).getTId().getTId()));
                    TWed4.setValue(MA.getTeacherNameByID(s.get(24).getTId().getTId()));
                    TWed5.setValue(MA.getTeacherNameByID(s.get(25).getTId().getTId()));
                    TThu1.setValue(MA.getTeacherNameByID(s.get(28).getTId().getTId()));
                    TThu2.setValue(MA.getTeacherNameByID(s.get(29).getTId().getTId()));
                    TThu3.setValue(MA.getTeacherNameByID(s.get(30).getTId().getTId()));
                    TThu4.setValue(MA.getTeacherNameByID(s.get(31).getTId().getTId()));
                    TThu5.setValue(MA.getTeacherNameByID(s.get(32).getTId().getTId()));
                }
            });
        } catch (Exception e) {
            System.err.println("Table not full : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }

    private List<String> getClasses() {
        List<String> StudY = new ArrayList<String>();
        for (Classes sy : MA.getClasses()) {
            StudY.add(sy.getClassDesc());
        }
        return StudY;
    }

    public void createNew(String s, LectureDatetime ldt, Teacher tId) {
        sc.setCId(c);
        sc.setLecId(ldt);
        sc.setSuId(s);
        sc.setTId(tId);
        MA.PersistNewSchedule(sc);
    }

    @FXML
    public void Save() {
        // n check 3ala kol 7aga :(  note : msh hn check
        try {
            if (!comboClass.getValue().equals("")) {
                sc = new Schedule();
                c = MA.getClassesByDesc(comboClass.getValue().toString());
                lecList = MA.getLectures();

                createNew(Sun1.getText(), lecList.get(0),
                        MA.getTeacherByName(TSun1.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Sun2.getText(), lecList.get(1),
                        MA.getTeacherByName(TSun2.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Sun3.getText(), lecList.get(2),
                        MA.getTeacherByName(TSun3.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Sun4.getText(), lecList.get(3),
                        MA.getTeacherByName(TSun4.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Sun5.getText(), lecList.get(4),
                        MA.getTeacherByName(TSun5.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
//            sc = new Schedule();
//            createNew(Sun6.getText(), lecList.get(5),
//                    MA.getTeacherByName(TSun6.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
//            sc = new Schedule();
//            createNew(Sun7.getText(), lecList.get(6),
//                    MA.getTeacherByName(TSun7.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Mon1.getText(), lecList.get(7),
                        MA.getTeacherByName(TMon1.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Mon2.getText(), lecList.get(8),
                        MA.getTeacherByName(TMon2.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Mon3.getText(), lecList.get(9),
                        MA.getTeacherByName(TMon3.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Mon4.getText(), lecList.get(10),
                        MA.getTeacherByName(TMon4.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Mon5.getText(), lecList.get(11),
                        MA.getTeacherByName(TMon5.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
//            sc = new Schedule();
//            createNew(Mon6.getText(), lecList.get(12),
//                    MA.getTeacherByName(TMon6.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
//            sc = new Schedule();
//            createNew(Mon7.getText(), lecList.get(13),
//                    MA.getTeacherByName(TMon7.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Tue1.getText(), lecList.get(14),
                        MA.getTeacherByName(TTue1.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Tue2.getText(), lecList.get(15),
                        MA.getTeacherByName(TTue2.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Tue3.getText(), lecList.get(16),
                        MA.getTeacherByName(TTue3.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Tue4.getText(), lecList.get(17),
                        MA.getTeacherByName(TTue4.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Tue5.getText(), lecList.get(18),
                        MA.getTeacherByName(TTue5.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
//            sc = new Schedule();
//            createNew(Tue6.getText(), lecList.get(19),
//                    MA.getTeacherByName(TTue6.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
//            sc = new Schedule();
//            createNew(Tue7.getText(), lecList.get(20),
//                    MA.getTeacherByName(TTue7.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Wed1.getText(), lecList.get(21),
                        MA.getTeacherByName(TWed1.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Wed2.getText(), lecList.get(22),
                        MA.getTeacherByName(TWed2.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Wed3.getText(), lecList.get(23),
                        MA.getTeacherByName(TWed3.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Wed4.getText(), lecList.get(24),
                        MA.getTeacherByName(TWed4.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Wed5.getText(), lecList.get(25),
                        MA.getTeacherByName(TWed5.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
//            sc = new Schedule();
//            createNew(Wed6.getText(), lecList.get(26),
//                    MA.getTeacherByName(TWed6.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
//            sc = new Schedule();
//            createNew(Wed7.getText(), lecList.get(27),
//                    MA.getTeacherByName(TWed7.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Thu1.getText(), lecList.get(28),
                        MA.getTeacherByName(TThu1.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Thu2.getText(), lecList.get(29),
                        MA.getTeacherByName(TThu2.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Thu3.getText(), lecList.get(30),
                        MA.getTeacherByName(TThu3.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Thu4.getText(), lecList.get(31),
                        MA.getTeacherByName(TThu4.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
                sc = new Schedule();
                createNew(Thu5.getText(), lecList.get(32),
                        MA.getTeacherByName(TThu5.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
//            sc = new Schedule();
//            createNew(Thu6.getText(), lecList.get(33),
//                    MA.getTeacherByName(TThu6.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));
//            sc = new Schedule();
//            createNew(Thu7.getText(), lecList.get(34),
//                    MA.getTeacherByName(TThu7.getSelectionModel().getSelectedItem().toString(), c.getClassDesc()));

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("يوجد خطأ");
                alert.setHeaderText("خطأ");
                alert.setContentText("برجاء التأكد من البيانات");
                alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                alert.showAndWait();
            }
        } catch (Exception e) {
            System.err.println("Table not full : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }

    @FXML
    public void Cancel() {
        MA.getDialogStage2().close();
    }
}
