/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.ActualGrades;
import Entity.GradeDetail;
import Entity.Student;
import amgad.h.StudentAffair;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class StudentGradesOneController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label className;
    @FXML
    private Label overall;

    @FXML
    private TextField serialNo;
    @FXML
    private TextField seatingNo;
    @FXML
    private TextField obsrNo1;
    @FXML
    private TextField obsrNo2;

    @FXML
    private TextField Arabic_F_1;
    @FXML
    private TextField Arabic_F_2;
    @FXML
    private TextField Arabic_F_3;
    @FXML
    private TextField Arabic_S_1;
    @FXML
    private TextField Arabic_S_2;
    @FXML
    private TextField Arabic_S_3;
    @FXML
    private TextField Arabic_T_1;
    @FXML
    private TextField Arabic_T_2;
    @FXML
    private TextField Arabic_T_3;

    @FXML
    private TextField Math_F_1;
    @FXML
    private TextField Math_F_2;
    @FXML
    private TextField Math_F_3;
    @FXML
    private TextField Math_S_1;
    @FXML
    private TextField Math_S_2;
    @FXML
    private TextField Math_S_3;
    @FXML
    private TextField Math_T_1;
    @FXML
    private TextField Math_T_2;
    @FXML
    private TextField Math_T_3;

    @FXML
    private TextField English_F_1;
    @FXML
    private TextField English_F_2;
    @FXML
    private TextField English_F_3;
    @FXML
    private TextField English_S_1;
    @FXML
    private TextField English_S_2;
    @FXML
    private TextField English_S_3;
    @FXML
    private TextField English_T_1;
    @FXML
    private TextField English_T_2;
    @FXML
    private TextField English_T_3;

    @FXML
    private TextField Religion_F_1;
    @FXML
    private TextField Religion_F_2;
    @FXML
    private TextField Religion_F_3;
    @FXML
    private TextField Religion_S_1;
    @FXML
    private TextField Religion_S_2;
    @FXML
    private TextField Religion_S_3;
    @FXML
    private TextField Religion_T_1;
    @FXML
    private TextField Religion_T_2;
    @FXML
    private TextField Religion_T_3;

    @FXML
    private TextField French_F_1;
    @FXML
    private TextField French_F_2;
    @FXML
    private TextField French_F_3;
    @FXML
    private TextField French_S_1;
    @FXML
    private TextField French_S_2;
    @FXML
    private TextField French_S_3;
    @FXML
    private TextField French_T_1;
    @FXML
    private TextField French_T_2;
    @FXML
    private TextField French_T_3;

    @FXML
    private TextField Required_F_1;
    @FXML
    private TextField Required_F_2;
    @FXML
    private TextField Required_F_3;
    @FXML
    private TextField Required_S_1;
    @FXML
    private TextField Required_S_2;
    @FXML
    private TextField Required_S_3;
    @FXML
    private TextField Required_T_1;
    @FXML
    private TextField Required_T_2;

    @FXML
    private TextField Optional_F_1;
    @FXML
    private TextField Optional_F_2;
    @FXML
    private TextField Optional_F_3;
    @FXML
    private TextField Optional_S_1;
    @FXML
    private TextField Optional_S_2;
    @FXML
    private TextField Optional_S_3;
    @FXML
    private TextField Optional_T_1;
    @FXML
    private TextField Optional_T_2;

    static private Student current;

    StudentAffair SA;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        current = StudentAffair.getEdit();
        SA = new StudentAffair();
        name.setText(current.getPId().getName());
        if (current.getClassStudentsList() != null) {
            className.setText(current.getClassStudentsList().getCId().getClassDesc());
        }

        serialNo.setText(current.getSerialNo());
        seatingNo.setText(current.getSeatingNo());
        obsrNo1.setText(current.getObserve1());
        obsrNo2.setText(current.getObserve2());

        if (current.getActualGradesList() != null) {
            for (ActualGrades a : current.getActualGradesList()) {
                System.out.println("grade detail id " + a.getGdId().getGdId());
                if (current.getClassStudentsList().getCId().getSyId().getSyId() == 1) {
                    switch (a.getGdId().getGdId()) {
                        case 56:
                            Arabic_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 57:
                            Arabic_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 58:
                            Arabic_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 59:
                            Arabic_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 38:
                            Math_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 39:
                            Math_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 40:
                            Math_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 41:
                            Math_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 52:
                            English_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 53:
                            English_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 54:
                            English_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 55:
                            English_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 60:
                            Religion_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 61:
                            Religion_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 62:
                            Religion_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 63:
                            Religion_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 64:
                            French_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 65:
                            French_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 66:
                            French_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 67:
                            French_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 68:
                            Required_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 69:
                            Required_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 70:
                            Required_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 71:
                            Required_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 74:
                            Optional_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 75:
                            Optional_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 76:
                            Optional_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 77:
                            Optional_S_2.setText(String.valueOf(a.getGrade()));
                            break;
                    }
                } else if (current.getClassStudentsList().getCId().getSyId().getSyId() == 2) {
                    switch (a.getGdId().getGdId()) {
                        case 82:
                            Arabic_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 83:
                            Arabic_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 84:
                            Arabic_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 85:
                            Arabic_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 92:
                            Math_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 93:
                            Math_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 94:
                            Math_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 95:
                            Math_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 78:
                            English_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 79:
                            English_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 80:
                            English_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 81:
                            English_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 100:
                            Religion_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 101:
                            Religion_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 102:
                            Religion_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 103:
                            Religion_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 104:
                            French_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 105:
                            French_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 106:
                            French_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 107:
                            French_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 108:
                            Required_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 109:
                            Required_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 110:
                            Required_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 111:
                            Required_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 114:
                            Optional_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 115:
                            Optional_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 116:
                            Optional_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 117:
                            Optional_S_2.setText(String.valueOf(a.getGrade()));
                            break;
                    }
                } else if (current.getClassStudentsList().getCId().getSyId().getSyId() == 3) {
                    switch (a.getGdId().getGdId()) {
                        case 122:
                            Arabic_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 123:
                            Arabic_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 124:
                            Arabic_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 125:
                            Arabic_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 132:
                            Math_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 133:
                            Math_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 134:
                            Math_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 135:
                            Math_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 118:
                            English_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 119:
                            English_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 120:
                            English_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 121:
                            English_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 140:
                            Religion_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 141:
                            Religion_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 142:
                            Religion_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 143:
                            Religion_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 144:
                            French_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 145:
                            French_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 146:
                            French_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 147:
                            French_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 148:
                            Required_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 149:
                            Required_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 150:
                            Required_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 151:
                            Required_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 154:
                            Optional_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 155:
                            Optional_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 156:
                            Optional_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 157:
                            Optional_S_2.setText(String.valueOf(a.getGrade()));
                            break;
                    }
                }
            }
        }
        try {

            if (!Arabic_F_1.getText().isEmpty() && !Arabic_F_2.getText().isEmpty()) {
                double x = Double.valueOf(Arabic_F_1.getText()) + Double.valueOf(Arabic_F_2.getText());
                Arabic_F_3.setText(String.valueOf(x));
            }
            if (!Arabic_S_1.getText().isEmpty() && !Arabic_S_2.getText().isEmpty()) {
                double x = Double.valueOf(Arabic_S_1.getText()) + Double.valueOf(Arabic_S_2.getText());
                Arabic_S_3.setText(String.valueOf(x));
            }
            if (!Arabic_F_3.getText().isEmpty() && !Arabic_S_3.getText().isEmpty()) {
                double x = Double.valueOf(Arabic_F_3.getText()) + Double.valueOf(Arabic_S_3.getText());
                Arabic_T_1.setText(String.valueOf(x));
                x /= 2;
                Arabic_T_2.setText(String.valueOf(x));
                x /= 1;
                Arabic_T_3.setText(gpa(x, 1));
            }

            if (!Math_F_1.getText().isEmpty() && !Math_F_2.getText().isEmpty()) {
                double x = Double.valueOf(Math_F_1.getText()) + Double.valueOf(Math_F_2.getText());
                Math_F_3.setText(String.valueOf(x));
            }
            if (!Math_S_1.getText().isEmpty() && !Math_S_2.getText().isEmpty()) {
                double x = Double.valueOf(Math_S_1.getText()) + Double.valueOf(Math_S_2.getText());
                Math_S_3.setText(String.valueOf(x));
            }
            if (!Math_F_3.getText().isEmpty() && !Math_S_3.getText().isEmpty()) {
                double x = Double.valueOf(Math_F_3.getText()) + Double.valueOf(Math_S_3.getText());
                Math_T_1.setText(String.valueOf(x));
                x /= 2;
                x *= .8;
                Math_T_2.setText(String.valueOf(x));
//                x /= .8;
                Math_T_3.setText(gpa(x, 2));
            }

            if (!English_F_1.getText().isEmpty() && !English_F_2.getText().isEmpty()) {
                double x = Double.valueOf(English_F_1.getText()) + Double.valueOf(English_F_2.getText());
                English_F_3.setText(String.valueOf(x));
            }
            if (!English_S_1.getText().isEmpty() && !English_S_2.getText().isEmpty()) {
                double x = Double.valueOf(English_S_1.getText()) + Double.valueOf(English_S_2.getText());
                English_S_3.setText(String.valueOf(x));
            }
            if (!English_F_3.getText().isEmpty() && !English_S_3.getText().isEmpty()) {
                double x = Double.valueOf(English_F_3.getText()) + Double.valueOf(English_S_3.getText());
                English_T_1.setText(String.valueOf(x));
                x /= 2;
                x *= .3;
                English_T_2.setText(String.valueOf(x));
//                x /= .4;
                English_T_3.setText(gpa(x, 3));
            }

            if (!Required_F_1.getText().isEmpty() && !Required_F_2.getText().isEmpty()) {
                double x = Double.valueOf(Required_F_1.getText()) + Double.valueOf(Required_F_2.getText());
                Required_F_3.setText(String.valueOf(x));
            }
            if (!Required_S_1.getText().isEmpty() && !Required_S_2.getText().isEmpty()) {
                double x = Double.valueOf(Required_S_1.getText()) + Double.valueOf(Required_S_2.getText());
                Required_S_3.setText(String.valueOf(x));
            }

            if (!Required_F_3.getText().isEmpty() && !Required_S_3.getText().isEmpty()) {
                double x = Double.valueOf(Required_F_3.getText()) + Double.valueOf(Required_S_3.getText());
//                x *= 6;
                Required_T_1.setText(String.valueOf(x));
//                x /= 3.6;
                Required_T_2.setText(gpa(x, 4));
            }

            if (!Optional_F_1.getText().isEmpty() && !Optional_F_2.getText().isEmpty()) {
                double x = Double.valueOf(Optional_F_1.getText()) + Double.valueOf(Optional_F_2.getText());
                Optional_F_3.setText(String.valueOf(x));
            }
            if (!Optional_S_1.getText().isEmpty() && !Optional_S_2.getText().isEmpty()) {
                double x = Double.valueOf(Optional_S_1.getText()) + Double.valueOf(Optional_S_2.getText());
                Optional_S_3.setText(String.valueOf(x));
            }
            if (!Optional_F_3.getText().isEmpty() && !Optional_S_3.getText().isEmpty()) {
                double x = Double.valueOf(Optional_F_3.getText()) + Double.valueOf(Optional_S_3.getText());
//                x = 5;
                Optional_T_1.setText(String.valueOf(x));
//                x /= .4;
                Optional_T_2.setText(gpa(x, 4));
            }

            if (!Religion_F_1.getText().isEmpty() && !Religion_F_2.getText().isEmpty()) {
                double x = Double.valueOf(Religion_F_1.getText()) + Double.valueOf(Religion_F_2.getText());
                Religion_F_3.setText(String.valueOf(x));
            }
            if (!Religion_S_1.getText().isEmpty() && !Religion_S_2.getText().isEmpty()) {
                double x = Double.valueOf(Religion_S_1.getText()) + Double.valueOf(Religion_S_2.getText());
                Religion_S_3.setText(String.valueOf(x));
            }
            if (!Religion_F_3.getText().isEmpty() && !Religion_S_3.getText().isEmpty()) {
                double x = Double.valueOf(Religion_F_3.getText()) + Double.valueOf(Religion_S_3.getText());
                Religion_T_1.setText(String.valueOf(x));
                x /= 2;
                x *= .3;
                Religion_T_2.setText(String.valueOf(x));
//                x /= .4;
                Religion_T_3.setText(gpa(x, 3));
            }

            if (!French_F_1.getText().isEmpty() && !French_F_2.getText().isEmpty()) {
                double x = Double.valueOf(French_F_1.getText()) + Double.valueOf(French_F_2.getText());
                French_F_3.setText(String.valueOf(x));
            }
            if (!French_S_1.getText().isEmpty() && !French_S_2.getText().isEmpty()) {
                double x = Double.valueOf(French_S_1.getText()) + Double.valueOf(French_S_2.getText());
                French_S_3.setText(String.valueOf(x));
            }
            if (!French_F_3.getText().isEmpty() && !French_S_3.getText().isEmpty()) {
                double x = Double.valueOf(French_F_3.getText()) + Double.valueOf(French_S_3.getText());
                French_T_1.setText(String.valueOf(x));
                x /= 2;
                x *= .3;
                French_T_2.setText(String.valueOf(x));
//                x /= .4;
                French_T_3.setText(gpa(x, 3));
            }

            if (!French_T_2.getText().isEmpty() && !Religion_T_2.getText().isEmpty() && !English_T_2.getText().isEmpty()
                    && !Math_T_2.getText().isEmpty() && !Arabic_T_2.getText().isEmpty() && !Optional_T_1.getText().isEmpty()
                    && !Required_T_1.getText().isEmpty()) {
                double x = Double.valueOf(French_T_2.getText()) + Double.valueOf(Religion_T_2.getText())
                        + Double.valueOf(English_T_2.getText()) + Double.valueOf(Math_T_2.getText())
                        + Double.valueOf(Arabic_T_2.getText()) + Double.valueOf(Optional_T_1.getText())
                        + Double.valueOf(Required_T_1.getText());
                overall.setText(gpa(x, 5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String gpa(double y, int x) {
        switch (x) {
            case 1:
                if (y >= 85) {
                    return "م";
                } else if (y < 85 && y >= 75) {
                    return "ج ج";
                } else if (y < 75 && y >= 65) {
                    return "ج";
                } else if (y < 65 && y >= 50) {
                    return "مق";
                } else {
                    return "ض";
                }
            case 2:
                if (y >= 68) {
                    return "م";
                } else if (y < 68 && y >= 60) {
                    return "ج ج";
                } else if (y < 60 && y >= 52) {
                    return "ج";
                } else if (y < 52 && y >= 40) {
                    return "مق";
                } else {
                    return "ض";
                }
            case 3:
                if (y >= 25.5) {
                    return "م";
                } else if (y < 25.5 && y >= 22.5) {
                    return "ج ج";
                } else if (y < 22.5 && y >= 19.5) {
                    return "ج";
                } else if (y < 19.5 && y >= 15) {
                    return "مق";
                } else {
                    return "ض";
                }
            case 4:
                if (y >= 17) {
                    return "م";
                } else if (y < 17 && y >= 15) {
                    return "ج ج";
                } else if (y < 15 && y >= 13) {
                    return "ج";
                } else if (y < 13 && y >= 10) {
                    return "مق";
                } else {
                    return "ض";
                }
            case 5:
                if (y >= 297.5) {
                    return "م";
                } else if (y < 297.5 && y >= 262.5) {
                    return "ج ج";
                } else if (y < 262.5 && y >= 227.5) {
                    return "ج";
                } else if (y < 227.5 && y >= 175) {
                    return "مق";
                } else {
                    return "ض";
                }
        }
        return "لم";
    }

    @FXML
    public void handleSave() {
        current.setSerialNo(serialNo.getText());
        current.setSeatingNo(seatingNo.getText());
        current.setObserve1(obsrNo1.getText());
        current.setObserve2(obsrNo2.getText());
        SA.UpdateStud(current);

        //1st year
        if (current.getClassStudentsList().getCId().getSyId().getSyId() == 1) {
            //arabic subject
            if (!Arabic_F_1.getText().isEmpty() && Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(56));
                ag.setGrade(Double.valueOf(Arabic_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_F_2.getText().isEmpty() && Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(57));
                ag.setGrade(Double.valueOf(Arabic_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_1.getText().isEmpty() && Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(58));
                ag.setGrade(Double.valueOf(Arabic_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_2.getText().isEmpty() && Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(59));
                ag.setGrade(Double.valueOf(Arabic_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //math subject
            if (!Math_F_1.getText().isEmpty() && Math_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(38));
                ag.setGrade(Double.valueOf(Math_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_F_2.getText().isEmpty() && Math_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(39));
                ag.setGrade(Double.valueOf(Math_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_1.getText().isEmpty() && Math_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(40));
                ag.setGrade(Double.valueOf(Math_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_2.getText().isEmpty() && Math_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(41));
                ag.setGrade(Double.valueOf(Math_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //english subject
            if (!English_F_1.getText().isEmpty() && English_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(52));
                ag.setGrade(Double.valueOf(English_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_F_2.getText().isEmpty() && English_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(53));
                ag.setGrade(Double.valueOf(English_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_1.getText().isEmpty() && English_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(54));
                ag.setGrade(Double.valueOf(English_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_2.getText().isEmpty() && English_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(55));
                ag.setGrade(Double.valueOf(English_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //religion subject
            if (!Religion_F_1.getText().isEmpty() && Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(60));
                ag.setGrade(Double.valueOf(Religion_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_F_2.getText().isEmpty() && Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(61));
                ag.setGrade(Double.valueOf(Religion_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_1.getText().isEmpty() && Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(62));
                ag.setGrade(Double.valueOf(Religion_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_2.getText().isEmpty() && Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(63));
                ag.setGrade(Double.valueOf(Religion_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //french subject
            if (!French_F_1.getText().isEmpty() && French_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(64));
                ag.setGrade(Double.valueOf(French_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_F_2.getText().isEmpty() && French_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(65));
                ag.setGrade(Double.valueOf(French_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_1.getText().isEmpty() && French_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(66));
                ag.setGrade(Double.valueOf(French_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_2.getText().isEmpty() && French_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(67));
                ag.setGrade(Double.valueOf(French_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //required Activity
            if (!Required_F_1.getText().isEmpty() && Required_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_F_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(68));
                ag.setGrade(Double.valueOf(Required_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_F_2.getText().isEmpty() && Required_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_F_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(69));
                ag.setGrade(Double.valueOf(Required_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_S_1.getText().isEmpty() && Required_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_S_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(70));
                ag.setGrade(Double.valueOf(Required_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_S_2.getText().isEmpty() && Required_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_S_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(71));
                ag.setGrade(Double.valueOf(Required_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //optional activity
            if (!Optional_F_1.getText().isEmpty() && Optional_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_F_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(74));
                ag.setGrade(Double.valueOf(Optional_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Optional_F_2.getText().isEmpty() && Optional_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_F_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(75));
                ag.setGrade(Double.valueOf(Optional_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Optional_S_1.getText().isEmpty() && Optional_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_S_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(76));
                ag.setGrade(Double.valueOf(Optional_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Optional_S_2.getText().isEmpty() && Optional_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_S_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(77));
                ag.setGrade(Double.valueOf(Optional_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
        }
        //2nd year
        if (current.getClassStudentsList().getCId().getSyId().getSyId() == 2) {
            //arabic subject
            if (!Arabic_F_1.getText().isEmpty() && Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(82));
                ag.setGrade(Double.valueOf(Arabic_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_F_2.getText().isEmpty() && Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(83));
                ag.setGrade(Double.valueOf(Arabic_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_1.getText().isEmpty() && Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(84));
                ag.setGrade(Double.valueOf(Arabic_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_2.getText().isEmpty() && Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(85));
                ag.setGrade(Double.valueOf(Arabic_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //math subject
            if (!Math_F_1.getText().isEmpty() && Math_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(92));
                ag.setGrade(Double.valueOf(Math_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
//        else if (!Math_F_1.getText().isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("يوجد خطأ");
//            alert.setContentText("برجاء ادخال رقم اقل من او يساوي اربعين");
//            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
//            alert.showAndWait();
//        }
            if (!Math_F_2.getText().isEmpty() && Math_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(93));
                ag.setGrade(Double.valueOf(Math_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_1.getText().isEmpty() && Math_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(94));
                ag.setGrade(Double.valueOf(Math_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_2.getText().isEmpty() && Math_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(95));
                ag.setGrade(Double.valueOf(Math_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //english subject
            if (!English_F_1.getText().isEmpty() && English_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(78));
                ag.setGrade(Double.valueOf(English_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_F_2.getText().isEmpty() && English_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(79));
                ag.setGrade(Double.valueOf(English_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_1.getText().isEmpty() && English_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(80));
                ag.setGrade(Double.valueOf(English_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_2.getText().isEmpty() && English_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(81));
                ag.setGrade(Double.valueOf(English_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //religion subject
            if (!Religion_F_1.getText().isEmpty() && Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(100));
                ag.setGrade(Double.valueOf(Religion_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_F_2.getText().isEmpty() && Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(101));
                ag.setGrade(Double.valueOf(Religion_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_1.getText().isEmpty() && Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(102));
                ag.setGrade(Double.valueOf(Religion_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_2.getText().isEmpty() && Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(103));
                ag.setGrade(Double.valueOf(Religion_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //french subject
            if (!French_F_1.getText().isEmpty() && French_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(104));
                ag.setGrade(Double.valueOf(French_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_F_2.getText().isEmpty() && French_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(105));
                ag.setGrade(Double.valueOf(French_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_1.getText().isEmpty() && French_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(106));
                ag.setGrade(Double.valueOf(French_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_2.getText().isEmpty() && French_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(107));
                ag.setGrade(Double.valueOf(French_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //required Activity
            if (!Required_F_1.getText().isEmpty() && Required_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_F_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(108));
                ag.setGrade(Double.valueOf(Required_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_F_2.getText().isEmpty() && Required_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_F_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(109));
                ag.setGrade(Double.valueOf(Required_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_S_1.getText().isEmpty() && Required_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_S_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(110));
                ag.setGrade(Double.valueOf(Required_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_S_2.getText().isEmpty() && Required_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_S_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(111));
                ag.setGrade(Double.valueOf(Required_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //optional activity
            if (!Optional_F_1.getText().isEmpty() && Optional_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_F_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(114));
                ag.setGrade(Double.valueOf(Optional_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Optional_F_2.getText().isEmpty() && Optional_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_F_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(115));
                ag.setGrade(Double.valueOf(Optional_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Optional_S_1.getText().isEmpty() && Optional_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_S_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(116));
                ag.setGrade(Double.valueOf(Optional_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Optional_S_2.getText().isEmpty() && Optional_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_S_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(117));
                ag.setGrade(Double.valueOf(Optional_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
        }
        //3rd year
        if (current.getClassStudentsList().getCId().getSyId().getSyId() == 3) {
            //arabic subject
            if (!Arabic_F_1.getText().isEmpty() && Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(122));
                ag.setGrade(Double.valueOf(Arabic_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_F_2.getText().isEmpty() && Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(123));
                ag.setGrade(Double.valueOf(Arabic_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_1.getText().isEmpty() && Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(124));
                ag.setGrade(Double.valueOf(Arabic_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_2.getText().isEmpty() && Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(125));
                ag.setGrade(Double.valueOf(Arabic_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //math subject
            if (!Math_F_1.getText().isEmpty() && Math_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(132));
                ag.setGrade(Double.valueOf(Math_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
//        else if (!Math_F_1.getText().isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("يوجد خطأ");
//            alert.setContentText("برجاء ادخال رقم اقل من او يساوي اربعين");
//            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
//            alert.showAndWait();
//        }
            if (!Math_F_2.getText().isEmpty() && Math_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(133));
                ag.setGrade(Double.valueOf(Math_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_1.getText().isEmpty() && Math_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(134));
                ag.setGrade(Double.valueOf(Math_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_2.getText().isEmpty() && Math_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(135));
                ag.setGrade(Double.valueOf(Math_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //english subject
            if (!English_F_1.getText().isEmpty() && English_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(118));
                ag.setGrade(Double.valueOf(English_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_F_2.getText().isEmpty() && English_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(119));
                ag.setGrade(Double.valueOf(English_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_1.getText().isEmpty() && English_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(120));
                ag.setGrade(Double.valueOf(English_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_2.getText().isEmpty() && English_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(121));
                ag.setGrade(Double.valueOf(English_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //religion subject
            if (!Religion_F_1.getText().isEmpty() && Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(140));
                ag.setGrade(Double.valueOf(Religion_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_F_2.getText().isEmpty() && Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(141));
                ag.setGrade(Double.valueOf(Religion_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_1.getText().isEmpty() && Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(142));
                ag.setGrade(Double.valueOf(Religion_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_2.getText().isEmpty() && Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(143));
                ag.setGrade(Double.valueOf(Religion_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //french subject
            if (!French_F_1.getText().isEmpty() && French_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(144));
                ag.setGrade(Double.valueOf(French_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_F_2.getText().isEmpty() && French_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(145));
                ag.setGrade(Double.valueOf(French_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_1.getText().isEmpty() && French_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_1.getText()) <= 75) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(146));
                ag.setGrade(Double.valueOf(French_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_2.getText().isEmpty() && French_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_2.getText()) <= 25) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(147));
                ag.setGrade(Double.valueOf(French_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //required Activity
            if (!Required_F_1.getText().isEmpty() && Required_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_F_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(148));
                ag.setGrade(Double.valueOf(Required_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_F_2.getText().isEmpty() && Required_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_F_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(149));
                ag.setGrade(Double.valueOf(Required_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_S_1.getText().isEmpty() && Required_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_S_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(150));
                ag.setGrade(Double.valueOf(Required_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_S_2.getText().isEmpty() && Required_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_S_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(151));
                ag.setGrade(Double.valueOf(Required_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //optional activity
            if (!Optional_F_1.getText().isEmpty() && Optional_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_F_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(154));
                ag.setGrade(Double.valueOf(Optional_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Optional_F_2.getText().isEmpty() && Optional_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_F_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(155));
                ag.setGrade(Double.valueOf(Optional_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Optional_S_1.getText().isEmpty() && Optional_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_S_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(156));
                ag.setGrade(Double.valueOf(Optional_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Optional_S_2.getText().isEmpty() && Optional_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Optional_S_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(157));
                ag.setGrade(Double.valueOf(Optional_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
        }
        StudentAffair.getDialogStage2().close();
    }

}
