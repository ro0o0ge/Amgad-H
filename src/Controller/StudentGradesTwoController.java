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
public class StudentGradesTwoController implements Initializable {

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
    private TextField Social_F_1;
    @FXML
    private TextField Social_F_2;
    @FXML
    private TextField Social_F_3;
    @FXML
    private TextField Social_S_1;
    @FXML
    private TextField Social_S_2;
    @FXML
    private TextField Social_S_3;
    @FXML
    private TextField Social_T_1;
    @FXML
    private TextField Social_T_2;
    @FXML
    private TextField Social_T_3;

    @FXML
    private TextField Science_F_1;
    @FXML
    private TextField Science_F_2;
    @FXML
    private TextField Science_F_3;
    @FXML
    private TextField Science_F_4;
    @FXML
    private TextField Science_S_1;
    @FXML
    private TextField Science_S_2;
    @FXML
    private TextField Science_S_3;
    @FXML
    private TextField Science_S_4;
    @FXML
    private TextField Science_T_1;
    @FXML
    private TextField Science_T_2;
    @FXML
    private TextField Science_T_3;

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
    private TextField Required_TH_1;
    @FXML
    private TextField Required_TH_2;
    @FXML
    private TextField Required_TH_3;
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
                if (current.getClassStudentsList().getCId().getSyId().getSyId() == 4) {
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

                        case 42:
                            Social_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 43:
                            Social_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 44:
                            Social_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 45:
                            Social_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 46:
                            Science_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 48:
                            Science_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 47:
                            Science_F_4.setText(String.valueOf(a.getGrade()));
                            break;
                        case 49:
                            Science_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 51:
                            Science_S_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 50:
                            Science_S_4.setText(String.valueOf(a.getGrade()));
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
                        case 72:
                            Required_TH_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 73:
                            Required_TH_2.setText(String.valueOf(a.getGrade()));
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
                } else if (current.getClassStudentsList().getCId().getSyId().getSyId() == 5) {
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

                        case 96:
                            Social_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 97:
                            Social_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 98:
                            Social_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 99:
                            Social_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 86:
                            Science_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 88:
                            Science_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 87:
                            Science_F_4.setText(String.valueOf(a.getGrade()));
                            break;
                        case 89:
                            Science_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 91:
                            Science_S_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 90:
                            Science_S_4.setText(String.valueOf(a.getGrade()));
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
                        case 112:
                            Required_TH_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 113:
                            Required_TH_2.setText(String.valueOf(a.getGrade()));
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
                } else if (current.getClassStudentsList().getCId().getSyId().getSyId() == 6) {
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

                        case 136:
                            Social_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 137:
                            Social_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 138:
                            Social_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 139:
                            Social_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 126:
                            Science_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 128:
                            Science_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 127:
                            Science_F_4.setText(String.valueOf(a.getGrade()));
                            break;
                        case 129:
                            Science_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 131:
                            Science_S_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 130:
                            Science_S_4.setText(String.valueOf(a.getGrade()));
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
                        case 152:
                            Required_TH_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 153:
                            Required_TH_2.setText(String.valueOf(a.getGrade()));
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
                Arabic_T_3.setText(gpa(x));
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
                x /= 2.5;
                Math_T_2.setText(String.valueOf(x));
                x /= .8;
                Math_T_3.setText(gpa(x));
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
                x /= 5;
                English_T_2.setText(String.valueOf(x));
                x /= .4;
                English_T_3.setText(gpa(x));
            }

            if (!Social_F_1.getText().isEmpty() && !Social_F_2.getText().isEmpty()) {
                double x = Double.valueOf(Social_F_1.getText()) + Double.valueOf(Social_F_2.getText());
                Social_F_3.setText(String.valueOf(x));
            }
            if (!Social_S_1.getText().isEmpty() && !Social_S_2.getText().isEmpty()) {
                double x = Double.valueOf(Social_S_1.getText()) + Double.valueOf(Social_S_2.getText());
                Social_S_3.setText(String.valueOf(x));
            }
            if (!Social_F_3.getText().isEmpty() && !Social_S_3.getText().isEmpty()) {
                double x = Double.valueOf(Social_F_3.getText()) + Double.valueOf(Social_S_3.getText());
                Social_T_1.setText(String.valueOf(x));
                x /= 5;
                Social_T_2.setText(String.valueOf(x));
                x /= .4;
                Social_T_3.setText(gpa(x));
            }

            if (!Science_F_1.getText().isEmpty() && !Science_F_2.getText().isEmpty() && !Science_F_4.getText().isEmpty()) {
                double x = Double.valueOf(Science_F_1.getText()) + Double.valueOf(Science_F_2.getText()) + Double.valueOf(Science_F_4.getText());
                Science_F_3.setText(String.valueOf(x));
            }
            if (!Science_S_1.getText().isEmpty() && !Science_S_2.getText().isEmpty() && !Science_S_4.getText().isEmpty()) {
                double x = Double.valueOf(Science_S_1.getText()) + Double.valueOf(Science_S_2.getText()) + Double.valueOf(Science_S_4.getText());
                Science_S_3.setText(String.valueOf(x));
            }
            if (!Science_F_3.getText().isEmpty() && !Science_S_3.getText().isEmpty()) {
                double x = Double.valueOf(Science_F_3.getText()) + Double.valueOf(Science_S_3.getText());
                Science_T_1.setText(String.valueOf(x));
                x /= 5;
                Science_T_2.setText(String.valueOf(x));
                x /= .4;
                Science_T_3.setText(gpa(x));
            }

            if (!Required_F_1.getText().isEmpty() && !Required_F_2.getText().isEmpty()) {
                double x = Double.valueOf(Required_F_1.getText()) + Double.valueOf(Required_F_2.getText());
                Required_F_3.setText(String.valueOf(x));
            }
            if (!Required_S_1.getText().isEmpty() && !Required_S_2.getText().isEmpty()) {
                double x = Double.valueOf(Required_S_1.getText()) + Double.valueOf(Required_S_2.getText());
                Required_S_3.setText(String.valueOf(x));
            }
            if (!Required_TH_1.getText().isEmpty() && !Required_TH_2.getText().isEmpty()) {
                double x = Double.valueOf(Required_TH_1.getText()) + Double.valueOf(Required_TH_2.getText());
                Required_TH_3.setText(String.valueOf(x));
            }
            if (!Required_F_3.getText().isEmpty() && !Required_S_3.getText().isEmpty() && !Required_TH_3.getText().isEmpty()) {
                double x = Double.valueOf(Required_F_3.getText()) + Double.valueOf(Required_S_3.getText()) + Double.valueOf(Required_TH_3.getText());
                x *= 6;
                Required_T_1.setText(String.valueOf(x));
                x /= 3.6;
                Required_T_2.setText(gpa(x));
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
                x /= .4;
                Optional_T_2.setText(gpa(x));
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
                x /= 5;
                Religion_T_2.setText(String.valueOf(x));
                x /= .4;
                Religion_T_3.setText(gpa(x));
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
                x /= 5;
                French_T_2.setText(String.valueOf(x));
                x /= .4;
                French_T_3.setText(gpa(x));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    String gpa(double y) {
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
    }

    @FXML
    public void handleSave() {
        current.setSerialNo(serialNo.getText());
        current.setSeatingNo(seatingNo.getText());
        current.setObserve1(obsrNo1.getText());
        current.setObserve2(obsrNo2.getText());
        SA.UpdateStud(current);

        //4th year
        if (current.getClassStudentsList().getCId().getSyId().getSyId() == 4) {
            //arabic subject
            if (!Arabic_F_1.getText().isEmpty() && Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(56));
                ag.setGrade(Double.valueOf(Arabic_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_F_2.getText().isEmpty() && Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(57));
                ag.setGrade(Double.valueOf(Arabic_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_1.getText().isEmpty() && Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(58));
                ag.setGrade(Double.valueOf(Arabic_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_2.getText().isEmpty() && Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(59));
                ag.setGrade(Double.valueOf(Arabic_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //math subject
            if (!Math_F_1.getText().isEmpty() && Math_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(38));
                ag.setGrade(Double.valueOf(Math_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_F_2.getText().isEmpty() && Math_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(39));
                ag.setGrade(Double.valueOf(Math_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_1.getText().isEmpty() && Math_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(40));
                ag.setGrade(Double.valueOf(Math_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_2.getText().isEmpty() && Math_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(41));
                ag.setGrade(Double.valueOf(Math_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //english subject
            if (!English_F_1.getText().isEmpty() && English_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(52));
                ag.setGrade(Double.valueOf(English_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_F_2.getText().isEmpty() && English_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(53));
                ag.setGrade(Double.valueOf(English_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_1.getText().isEmpty() && English_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(54));
                ag.setGrade(Double.valueOf(English_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_2.getText().isEmpty() && English_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(55));
                ag.setGrade(Double.valueOf(English_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //social subject
            if (!Social_F_1.getText().isEmpty() && Social_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(42));
                ag.setGrade(Double.valueOf(Social_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Social_F_2.getText().isEmpty() && Social_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(43));
                ag.setGrade(Double.valueOf(Social_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Social_S_1.getText().isEmpty() && Social_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(44));
                ag.setGrade(Double.valueOf(Social_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Social_S_2.getText().isEmpty() && Social_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(45));
                ag.setGrade(Double.valueOf(Social_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //science subject
            if (!Science_F_1.getText().isEmpty() && Science_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(46));
                ag.setGrade(Double.valueOf(Science_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_F_2.getText().isEmpty() && Science_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(48));
                ag.setGrade(Double.valueOf(Science_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_F_4.getText().isEmpty() && Science_F_4.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_F_4.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(47));
                ag.setGrade(Double.valueOf(Science_F_4.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_S_1.getText().isEmpty() && Science_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(49));
                ag.setGrade(Double.valueOf(Science_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_S_2.getText().isEmpty() && Science_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(51));
                ag.setGrade(Double.valueOf(Science_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_S_4.getText().isEmpty() && Science_S_4.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_S_4.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(50));
                ag.setGrade(Double.valueOf(Science_S_4.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //religion subject
            if (!Religion_F_1.getText().isEmpty() && Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(60));
                ag.setGrade(Double.valueOf(Religion_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_F_2.getText().isEmpty() && Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(61));
                ag.setGrade(Double.valueOf(Religion_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_1.getText().isEmpty() && Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(62));
                ag.setGrade(Double.valueOf(Religion_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_2.getText().isEmpty() && Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(63));
                ag.setGrade(Double.valueOf(Religion_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //french subject
            if (!French_F_1.getText().isEmpty() && French_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(64));
                ag.setGrade(Double.valueOf(French_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_F_2.getText().isEmpty() && French_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(65));
                ag.setGrade(Double.valueOf(French_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_1.getText().isEmpty() && French_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(66));
                ag.setGrade(Double.valueOf(French_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_2.getText().isEmpty() && French_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_2.getText()) <= 30) {
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
            if (!Required_TH_1.getText().isEmpty() && Required_TH_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_TH_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(72));
                ag.setGrade(Double.valueOf(Required_TH_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_TH_2.getText().isEmpty() && Required_TH_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_TH_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(73));
                ag.setGrade(Double.valueOf(Required_TH_2.getText()));
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
        //5th year
        if (current.getClassStudentsList().getCId().getSyId().getSyId() == 5) {
            //arabic subject
            if (!Arabic_F_1.getText().isEmpty() && Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(82));
                ag.setGrade(Double.valueOf(Arabic_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_F_2.getText().isEmpty() && Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(83));
                ag.setGrade(Double.valueOf(Arabic_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_1.getText().isEmpty() && Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(84));
                ag.setGrade(Double.valueOf(Arabic_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_2.getText().isEmpty() && Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(85));
                ag.setGrade(Double.valueOf(Arabic_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //math subject
            if (!Math_F_1.getText().isEmpty() && Math_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_F_1.getText()) <= 70) {
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
                    && Double.valueOf(Math_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(93));
                ag.setGrade(Double.valueOf(Math_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_1.getText().isEmpty() && Math_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(94));
                ag.setGrade(Double.valueOf(Math_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_2.getText().isEmpty() && Math_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(95));
                ag.setGrade(Double.valueOf(Math_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //english subject
            if (!English_F_1.getText().isEmpty() && English_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(78));
                ag.setGrade(Double.valueOf(English_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_F_2.getText().isEmpty() && English_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(79));
                ag.setGrade(Double.valueOf(English_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_1.getText().isEmpty() && English_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(80));
                ag.setGrade(Double.valueOf(English_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_2.getText().isEmpty() && English_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(81));
                ag.setGrade(Double.valueOf(English_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //social subject
            if (!Social_F_1.getText().isEmpty() && Social_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(96));
                ag.setGrade(Double.valueOf(Social_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Social_F_2.getText().isEmpty() && Social_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(97));
                ag.setGrade(Double.valueOf(Social_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Social_S_1.getText().isEmpty() && Social_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(98));
                ag.setGrade(Double.valueOf(Social_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Social_S_2.getText().isEmpty() && Social_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(99));
                ag.setGrade(Double.valueOf(Social_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //science subject
            if (!Science_F_1.getText().isEmpty() && Science_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(86));
                ag.setGrade(Double.valueOf(Science_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_F_2.getText().isEmpty() && Science_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(88));
                ag.setGrade(Double.valueOf(Science_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_F_4.getText().isEmpty() && Science_F_4.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_F_4.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(87));
                ag.setGrade(Double.valueOf(Science_F_4.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_S_1.getText().isEmpty() && Science_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(89));
                ag.setGrade(Double.valueOf(Science_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_S_2.getText().isEmpty() && Science_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(91));
                ag.setGrade(Double.valueOf(Science_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_S_4.getText().isEmpty() && Science_S_4.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_S_4.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(90));
                ag.setGrade(Double.valueOf(Science_S_4.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //religion subject
            if (!Religion_F_1.getText().isEmpty() && Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(100));
                ag.setGrade(Double.valueOf(Religion_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_F_2.getText().isEmpty() && Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(101));
                ag.setGrade(Double.valueOf(Religion_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_1.getText().isEmpty() && Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(102));
                ag.setGrade(Double.valueOf(Religion_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_2.getText().isEmpty() && Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(103));
                ag.setGrade(Double.valueOf(Religion_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //french subject
            if (!French_F_1.getText().isEmpty() && French_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(104));
                ag.setGrade(Double.valueOf(French_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_F_2.getText().isEmpty() && French_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(105));
                ag.setGrade(Double.valueOf(French_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_1.getText().isEmpty() && French_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(106));
                ag.setGrade(Double.valueOf(French_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_2.getText().isEmpty() && French_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_2.getText()) <= 30) {
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
            if (!Required_TH_1.getText().isEmpty() && Required_TH_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_TH_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(112));
                ag.setGrade(Double.valueOf(Required_TH_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_TH_2.getText().isEmpty() && Required_TH_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_TH_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(113));
                ag.setGrade(Double.valueOf(Required_TH_2.getText()));
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
        //6th year
        if (current.getClassStudentsList().getCId().getSyId().getSyId() == 6) {
            //arabic subject
            if (!Arabic_F_1.getText().isEmpty() && Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(122));
                ag.setGrade(Double.valueOf(Arabic_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_F_2.getText().isEmpty() && Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(123));
                ag.setGrade(Double.valueOf(Arabic_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_1.getText().isEmpty() && Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(124));
                ag.setGrade(Double.valueOf(Arabic_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Arabic_S_2.getText().isEmpty() && Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Arabic_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(125));
                ag.setGrade(Double.valueOf(Arabic_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //math subject
            if (!Math_F_1.getText().isEmpty() && Math_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_F_1.getText()) <= 70) {
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
                    && Double.valueOf(Math_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(133));
                ag.setGrade(Double.valueOf(Math_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_1.getText().isEmpty() && Math_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(134));
                ag.setGrade(Double.valueOf(Math_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Math_S_2.getText().isEmpty() && Math_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Math_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(135));
                ag.setGrade(Double.valueOf(Math_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //english subject
            if (!English_F_1.getText().isEmpty() && English_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(118));
                ag.setGrade(Double.valueOf(English_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_F_2.getText().isEmpty() && English_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(119));
                ag.setGrade(Double.valueOf(English_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_1.getText().isEmpty() && English_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(120));
                ag.setGrade(Double.valueOf(English_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!English_S_2.getText().isEmpty() && English_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(English_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(121));
                ag.setGrade(Double.valueOf(English_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //social subject
            if (!Social_F_1.getText().isEmpty() && Social_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(136));
                ag.setGrade(Double.valueOf(Social_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Social_F_2.getText().isEmpty() && Social_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(137));
                ag.setGrade(Double.valueOf(Social_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Social_S_1.getText().isEmpty() && Social_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(138));
                ag.setGrade(Double.valueOf(Social_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Social_S_2.getText().isEmpty() && Social_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Social_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(139));
                ag.setGrade(Double.valueOf(Social_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //science subject
            if (!Science_F_1.getText().isEmpty() && Science_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(126));
                ag.setGrade(Double.valueOf(Science_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_F_2.getText().isEmpty() && Science_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(128));
                ag.setGrade(Double.valueOf(Science_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_F_4.getText().isEmpty() && Science_F_4.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_F_4.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(127));
                ag.setGrade(Double.valueOf(Science_F_4.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_S_1.getText().isEmpty() && Science_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(129));
                ag.setGrade(Double.valueOf(Science_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_S_2.getText().isEmpty() && Science_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(131));
                ag.setGrade(Double.valueOf(Science_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Science_S_4.getText().isEmpty() && Science_S_4.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Science_S_4.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(130));
                ag.setGrade(Double.valueOf(Science_S_4.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //religion subject
            if (!Religion_F_1.getText().isEmpty() && Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(140));
                ag.setGrade(Double.valueOf(Religion_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_F_2.getText().isEmpty() && Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(141));
                ag.setGrade(Double.valueOf(Religion_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_1.getText().isEmpty() && Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(142));
                ag.setGrade(Double.valueOf(Religion_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Religion_S_2.getText().isEmpty() && Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Religion_S_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(143));
                ag.setGrade(Double.valueOf(Religion_S_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            //french subject
            if (!French_F_1.getText().isEmpty() && French_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(144));
                ag.setGrade(Double.valueOf(French_F_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_F_2.getText().isEmpty() && French_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_F_2.getText()) <= 30) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(145));
                ag.setGrade(Double.valueOf(French_F_2.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_1.getText().isEmpty() && French_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_1.getText()) <= 70) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(146));
                ag.setGrade(Double.valueOf(French_S_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!French_S_2.getText().isEmpty() && French_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(French_S_2.getText()) <= 30) {
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
            if (!Required_TH_1.getText().isEmpty() && Required_TH_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_TH_1.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(152));
                ag.setGrade(Double.valueOf(Required_TH_1.getText()));
                ag.setSId(current);
                SA.PersistStudControl(ag);
            }
            if (!Required_TH_2.getText().isEmpty() && Required_TH_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && Double.valueOf(Required_TH_2.getText()) <= 10) {
                ActualGrades ag = new ActualGrades();
                ag.setGdId(new GradeDetail(153));
                ag.setGrade(Double.valueOf(Required_TH_2.getText()));
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
