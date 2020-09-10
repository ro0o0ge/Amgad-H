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

public class StudentGradesOneController
        implements Initializable {

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
    private static Student current;
    StudentAffair SA;

    void fillConstant() {
        Arabic_F_1.setText("75");
        Arabic_F_2.setText("25");
        Arabic_S_1.setText("75");
        Arabic_S_2.setText("25");
        Math_F_1.setText("75");
        Math_F_2.setText("25");
        Math_S_1.setText("75");
        Math_S_2.setText("25");
        English_F_1.setText("75");
        English_F_2.setText("25");
        English_S_1.setText("75");
        English_S_2.setText("25");
        Religion_F_1.setText("75");
        Religion_F_2.setText("25");
        Religion_S_1.setText("75");
        Religion_S_2.setText("25");
        French_F_1.setText("50");
        French_F_2.setText("50");
        French_S_1.setText("50");
        French_S_2.setText("50");
        Required_F_1.setText("10");
        Required_F_2.setText("10");
        Required_S_1.setText("10");
        Required_S_2.setText("10");
        Optional_F_1.setText("10");
        Optional_F_2.setText("10");
        Optional_S_1.setText("10");
        Optional_S_2.setText("10");
    }

    public void initialize(URL url, ResourceBundle rb) {
        /*  184 */ current = StudentAffair.getEdit();
        /*  185 */ this.SA = new StudentAffair();
        /*  186 */ this.name.setText(current.getPId().getName());
        /*  187 */ if (current.getClassStudentsList() != null) {
            /*  188 */ this.className.setText(current.getClassStudentsList().getCId().getClassDesc());
        }

        /*  191 */ this.serialNo.setText(current.getSerialNo());
        /*  192 */ this.seatingNo.setText(current.getSeatingNo());
        /*  193 */ this.obsrNo1.setText(current.getObserve1());
        /*  194 */ this.obsrNo2.setText(current.getObserve2());
        fillConstant();
        /*  196 */ if (current.getActualGradesList() != null) {
            /*  197 */ for (ActualGrades a : current.getActualGradesList()) {
                /*  198 */ System.out.println("grade detail id " + a.getGdId().getGdId());
                /*  199 */ if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 1) {
                    /*  200 */ switch (a.getGdId().getGdId().intValue()) {
                        case 56:
                            /*  202 */ this.Arabic_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 57:
                            /*  205 */ this.Arabic_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 58:
                            /*  208 */ this.Arabic_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 59:
                            /*  211 */ this.Arabic_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 38:
                            /*  215 */ this.Math_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 39:
                            /*  218 */ this.Math_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 40:
                            /*  221 */ this.Math_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 41:
                            /*  224 */ this.Math_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 52:
                            /*  228 */ this.English_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 53:
                            /*  231 */ this.English_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 54:
                            /*  234 */ this.English_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 55:
                            /*  237 */ this.English_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 60:
                            /*  241 */ this.Religion_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 61:
                            /*  244 */ this.Religion_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 62:
                            /*  247 */ this.Religion_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 63:
                            /*  250 */ this.Religion_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 64:
                            /*  254 */ this.French_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 65:
                            /*  257 */ this.French_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 66:
                            /*  260 */ this.French_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 67:
                            /*  263 */ this.French_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 68:
                            /*  267 */ this.Required_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 69:
                            /*  270 */ this.Required_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 70:
                            /*  273 */ this.Required_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 71:
                            /*  276 */ this.Required_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 74:
                            /*  280 */ this.Optional_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 75:
                            /*  283 */ this.Optional_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 76:
                            /*  286 */ this.Optional_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 77:
                            /*  289 */ this.Optional_S_2.setText(String.valueOf(a.getGrade()));
                            break;
                    }
                    continue;
                }
                /*  292 */ if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 2) {
                    /*  293 */ switch (a.getGdId().getGdId().intValue()) {
                        case 82:
                            /*  295 */ this.Arabic_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 83:
                            /*  298 */ this.Arabic_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 84:
                            /*  301 */ this.Arabic_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 85:
                            /*  304 */ this.Arabic_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 92:
                            /*  308 */ this.Math_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 93:
                            /*  311 */ this.Math_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 94:
                            /*  314 */ this.Math_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 95:
                            /*  317 */ this.Math_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 78:
                            /*  321 */ this.English_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 79:
                            /*  324 */ this.English_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 80:
                            /*  327 */ this.English_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 81:
                            /*  330 */ this.English_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 100:
                            /*  334 */ this.Religion_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 101:
                            /*  337 */ this.Religion_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 102:
                            /*  340 */ this.Religion_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 103:
                            /*  343 */ this.Religion_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 104:
                            /*  347 */ this.French_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 105:
                            /*  350 */ this.French_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 106:
                            /*  353 */ this.French_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 107:
                            /*  356 */ this.French_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 108:
                            /*  360 */ this.Required_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 109:
                            /*  363 */ this.Required_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 110:
                            /*  366 */ this.Required_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 111:
                            /*  369 */ this.Required_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 114:
                            /*  373 */ this.Optional_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 115:
                            /*  376 */ this.Optional_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 116:
                            /*  379 */ this.Optional_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 117:
                            /*  382 */ this.Optional_S_2.setText(String.valueOf(a.getGrade()));
                            break;
                    }
                    continue;
                }
                /*  385 */ if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 3) {
                    /*  386 */ switch (a.getGdId().getGdId().intValue()) {
                        case 122:
                            /*  388 */ this.Arabic_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 123:
                            /*  391 */ this.Arabic_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 124:
                            /*  394 */ this.Arabic_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 125:
                            /*  397 */ this.Arabic_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 132:
                            /*  401 */ this.Math_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 133:
                            /*  404 */ this.Math_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 134:
                            /*  407 */ this.Math_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 135:
                            /*  410 */ this.Math_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 118:
                            /*  414 */ this.English_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 119:
                            /*  417 */ this.English_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 120:
                            /*  420 */ this.English_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 121:
                            /*  423 */ this.English_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 140:
                            /*  427 */ this.Religion_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 141:
                            /*  430 */ this.Religion_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 142:
                            /*  433 */ this.Religion_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 143:
                            /*  436 */ this.Religion_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 144:
                            /*  440 */ this.French_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 145:
                            /*  443 */ this.French_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 146:
                            /*  446 */ this.French_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 147:
                            /*  449 */ this.French_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 148:
                            /*  453 */ this.Required_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 149:
                            /*  456 */ this.Required_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 150:
                            /*  459 */ this.Required_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 151:
                            /*  462 */ this.Required_S_2.setText(String.valueOf(a.getGrade()));
                            break;

                        case 154:
                            /*  466 */ this.Optional_F_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 155:
                            /*  469 */ this.Optional_F_2.setText(String.valueOf(a.getGrade()));
                            break;
                        case 156:
                            /*  472 */ this.Optional_S_1.setText(String.valueOf(a.getGrade()));
                            break;
                        case 157:
                            /*  475 */ this.Optional_S_2.setText(String.valueOf(a.getGrade()));
                            break;
                    }

                }
            }
        }
        try {
            /*  483 */ if (!this.Arabic_F_1.getText().isEmpty() && !this.Arabic_F_2.getText().isEmpty()) {
                /*  484 */ double x = Double.valueOf(this.Arabic_F_1.getText()).doubleValue() + Double.valueOf(this.Arabic_F_2.getText()).doubleValue();
                /*  485 */ this.Arabic_F_3.setText(String.valueOf(x));
            }
            /*  487 */ if (!this.Arabic_S_1.getText().isEmpty() && !this.Arabic_S_2.getText().isEmpty()) {
                /*  488 */ double x = Double.valueOf(this.Arabic_S_1.getText()).doubleValue() + Double.valueOf(this.Arabic_S_2.getText()).doubleValue();
                /*  489 */ this.Arabic_S_3.setText(String.valueOf(x));
            }
            /*  491 */ if (!this.Arabic_F_3.getText().isEmpty() && !this.Arabic_S_3.getText().isEmpty()) {
                /*  492 */ double x = Double.valueOf(this.Arabic_F_3.getText()).doubleValue() + Double.valueOf(this.Arabic_S_3.getText()).doubleValue();
                /*  493 */ this.Arabic_T_1.setText(String.valueOf(x));
                /*  494 */ x /= 2.0D;
                /*  495 */ this.Arabic_T_2.setText(String.valueOf(x));
                /*  496 */ x /= 1.0D;
                /*  497 */ this.Arabic_T_3.setText(gpa(x, 1));
            }

            /*  500 */ if (!this.Math_F_1.getText().isEmpty() && !this.Math_F_2.getText().isEmpty()) {
                /*  501 */ double x = Double.valueOf(this.Math_F_1.getText()).doubleValue() + Double.valueOf(this.Math_F_2.getText()).doubleValue();
                /*  502 */ this.Math_F_3.setText(String.valueOf(x));
            }
            /*  504 */ if (!this.Math_S_1.getText().isEmpty() && !this.Math_S_2.getText().isEmpty()) {
                /*  505 */ double x = Double.valueOf(this.Math_S_1.getText()).doubleValue() + Double.valueOf(this.Math_S_2.getText()).doubleValue();
                /*  506 */ this.Math_S_3.setText(String.valueOf(x));
            }
            /*  508 */ if (!this.Math_F_3.getText().isEmpty() && !this.Math_S_3.getText().isEmpty()) {
                /*  509 */ double x = Double.valueOf(this.Math_F_3.getText()).doubleValue() + Double.valueOf(this.Math_S_3.getText()).doubleValue();
                /*  510 */ this.Math_T_1.setText(String.valueOf(x));
                /*  511 */ x /= 2.0D;
                /*  512 */ x *= 0.8D;
                /*  513 */ this.Math_T_2.setText(String.valueOf(x));

                /*  515 */ this.Math_T_3.setText(gpa(x, 2));
            }

            /*  518 */ if (!this.English_F_1.getText().isEmpty() && !this.English_F_2.getText().isEmpty()) {
                /*  519 */ double x = Double.valueOf(this.English_F_1.getText()).doubleValue() + Double.valueOf(this.English_F_2.getText()).doubleValue();
                /*  520 */ this.English_F_3.setText(String.valueOf(x));
            }
            /*  522 */ if (!this.English_S_1.getText().isEmpty() && !this.English_S_2.getText().isEmpty()) {
                /*  523 */ double x = Double.valueOf(this.English_S_1.getText()).doubleValue() + Double.valueOf(this.English_S_2.getText()).doubleValue();
                /*  524 */ this.English_S_3.setText(String.valueOf(x));
            }
            /*  526 */ if (!this.English_F_3.getText().isEmpty() && !this.English_S_3.getText().isEmpty()) {
                /*  527 */ double x = Double.valueOf(this.English_F_3.getText()).doubleValue() + Double.valueOf(this.English_S_3.getText()).doubleValue();
                /*  528 */ this.English_T_1.setText(String.valueOf(x));
                /*  529 */ x /= 2.0D;
                /*  530 */ x *= 0.3D;
                /*  531 */ this.English_T_2.setText(String.valueOf(x));

                /*  533 */ this.English_T_3.setText(gpa(x, 3));
            }

            /*  536 */ if (!this.Required_F_1.getText().isEmpty() && !this.Required_F_2.getText().isEmpty()) {
                /*  537 */ double x = Double.valueOf(this.Required_F_1.getText()).doubleValue() + Double.valueOf(this.Required_F_2.getText()).doubleValue();
                /*  538 */ this.Required_F_3.setText(String.valueOf(x));
            }
            /*  540 */ if (!this.Required_S_1.getText().isEmpty() && !this.Required_S_2.getText().isEmpty()) {
                /*  541 */ double x = Double.valueOf(this.Required_S_1.getText()).doubleValue() + Double.valueOf(this.Required_S_2.getText()).doubleValue();
                /*  542 */ this.Required_S_3.setText(String.valueOf(x));
            }

            /*  545 */ if (!this.Required_F_3.getText().isEmpty() && !this.Required_S_3.getText().isEmpty()) {
                /*  546 */ double x = Double.valueOf(this.Required_F_3.getText()).doubleValue() + Double.valueOf(this.Required_S_3.getText()).doubleValue();

                /*  548 */ this.Required_T_1.setText(String.valueOf(x));

                /*  550 */ this.Required_T_2.setText(gpa(x, 4));
            }

            /*  553 */ if (!this.Optional_F_1.getText().isEmpty() && !this.Optional_F_2.getText().isEmpty()) {
                /*  554 */ double x = Double.valueOf(this.Optional_F_1.getText()).doubleValue() + Double.valueOf(this.Optional_F_2.getText()).doubleValue();
                /*  555 */ this.Optional_F_3.setText(String.valueOf(x));
            }
            /*  557 */ if (!this.Optional_S_1.getText().isEmpty() && !this.Optional_S_2.getText().isEmpty()) {
                /*  558 */ double x = Double.valueOf(this.Optional_S_1.getText()).doubleValue() + Double.valueOf(this.Optional_S_2.getText()).doubleValue();
                /*  559 */ this.Optional_S_3.setText(String.valueOf(x));
            }
            /*  561 */ if (!this.Optional_F_3.getText().isEmpty() && !this.Optional_S_3.getText().isEmpty()) {
                /*  562 */ double x = Double.valueOf(this.Optional_F_3.getText()).doubleValue() + Double.valueOf(this.Optional_S_3.getText()).doubleValue();

                /*  564 */ this.Optional_T_1.setText(String.valueOf(x));

                /*  566 */ this.Optional_T_2.setText(gpa(x, 4));
            }

            /*  569 */ if (!this.Religion_F_1.getText().isEmpty() && !this.Religion_F_2.getText().isEmpty()) {
                /*  570 */ double x = Double.valueOf(this.Religion_F_1.getText()).doubleValue() + Double.valueOf(this.Religion_F_2.getText()).doubleValue();
                /*  571 */ this.Religion_F_3.setText(String.valueOf(x));
            }
            /*  573 */ if (!this.Religion_S_1.getText().isEmpty() && !this.Religion_S_2.getText().isEmpty()) {
                /*  574 */ double x = Double.valueOf(this.Religion_S_1.getText()).doubleValue() + Double.valueOf(this.Religion_S_2.getText()).doubleValue();
                /*  575 */ this.Religion_S_3.setText(String.valueOf(x));
            }
            /*  577 */ if (!this.Religion_F_3.getText().isEmpty() && !this.Religion_S_3.getText().isEmpty()) {
                /*  578 */ double x = Double.valueOf(this.Religion_F_3.getText()).doubleValue() + Double.valueOf(this.Religion_S_3.getText()).doubleValue();
                /*  579 */ this.Religion_T_1.setText(String.valueOf(x));
                /*  580 */ x /= 2.0D;
                /*  581 */ x *= 0.3D;
                /*  582 */ this.Religion_T_2.setText(String.valueOf(x));

                /*  584 */ this.Religion_T_3.setText(gpa(x, 3));
            }

            /*  587 */ if (!this.French_F_1.getText().isEmpty() && !this.French_F_2.getText().isEmpty()) {
                /*  588 */ double x = Double.valueOf(this.French_F_1.getText()).doubleValue() + Double.valueOf(this.French_F_2.getText()).doubleValue();
                /*  589 */ this.French_F_3.setText(String.valueOf(x));
            }
            /*  591 */ if (!this.French_S_1.getText().isEmpty() && !this.French_S_2.getText().isEmpty()) {
                /*  592 */ double x = Double.valueOf(this.French_S_1.getText()).doubleValue() + Double.valueOf(this.French_S_2.getText()).doubleValue();
                /*  593 */ this.French_S_3.setText(String.valueOf(x));
            }
            /*  595 */ if (!this.French_F_3.getText().isEmpty() && !this.French_S_3.getText().isEmpty()) {
                /*  596 */ double x = Double.valueOf(this.French_F_3.getText()).doubleValue() + Double.valueOf(this.French_S_3.getText()).doubleValue();
                /*  597 */ this.French_T_1.setText(String.valueOf(x));
                /*  598 */ x /= 2.0D;
                /*  599 */ x *= 0.3D;
                /*  600 */ this.French_T_2.setText(String.valueOf(x));

                /*  602 */ this.French_T_3.setText(gpa(x, 3));
            }

            /*  605 */ if (!this.French_T_2.getText().isEmpty() && !this.Religion_T_2.getText().isEmpty() && !this.English_T_2.getText().isEmpty()
                    && /*  606 */ !this.Math_T_2.getText().isEmpty() && !this.Arabic_T_2.getText().isEmpty() && !this.Optional_T_1.getText().isEmpty()
                    && /*  607 */ !this.Required_T_1.getText().isEmpty()) {

                /*  611 */ double x = Double.valueOf(this.French_T_2.getText()).doubleValue() + Double.valueOf(this.Religion_T_2.getText()).doubleValue() + Double.valueOf(this.English_T_2.getText()).doubleValue() + Double.valueOf(this.Math_T_2.getText()).doubleValue() + Double.valueOf(this.Arabic_T_2.getText()).doubleValue() + Double.valueOf(this.Optional_T_1.getText()).doubleValue() + Double.valueOf(this.Required_T_1.getText()).doubleValue();
                /*  612 */ this.overall.setText(gpa(x, 5));
            }
            /*  614 */        } catch (Exception e) {
            /*  615 */ e.printStackTrace();
        }
    }

    String gpa(double y, int x) {
        /*  620 */ switch (x) {
            case 1:
                /*  622 */ if (y >= 85.0D) /*  623 */ {
                    return "م";
                }
                /*  624 */ if (y < 85.0D && y >= 75.0D) /*  625 */ {
                    return "ج ج";
                }
                /*  626 */ if (y < 75.0D && y >= 65.0D) /*  627 */ {
                    return "ج";
                }
                /*  628 */ if (y < 65.0D && y >= 50.0D) {
                    /*  629 */ return "مق";
                }
                /*  631 */ return "ض";

            case 2:
                /*  634 */ if (y >= 68.0D) /*  635 */ {
                    return "م";
                }
                /*  636 */ if (y < 68.0D && y >= 60.0D) /*  637 */ {
                    return "ج ج";
                }
                /*  638 */ if (y < 60.0D && y >= 52.0D) /*  639 */ {
                    return "ج";
                }
                /*  640 */ if (y < 52.0D && y >= 40.0D) {
                    /*  641 */ return "مق";
                }
                /*  643 */ return "ض";

            case 3:
                /*  646 */ if (y >= 25.5D) /*  647 */ {
                    return "م";
                }
                /*  648 */ if (y < 25.5D && y >= 22.5D) /*  649 */ {
                    return "ج ج";
                }
                /*  650 */ if (y < 22.5D && y >= 19.5D) /*  651 */ {
                    return "ج";
                }
                /*  652 */ if (y < 19.5D && y >= 15.0D) {
                    /*  653 */ return "مق";
                }
                /*  655 */ return "ض";

            case 4:
                /*  658 */ if (y >= 17.0D) /*  659 */ {
                    return "م";
                }
                /*  660 */ if (y < 17.0D && y >= 15.0D) /*  661 */ {
                    return "ج ج";
                }
                /*  662 */ if (y < 15.0D && y >= 13.0D) /*  663 */ {
                    return "ج";
                }
                /*  664 */ if (y < 13.0D && y >= 10.0D) {
                    /*  665 */ return "مق";
                }
                /*  667 */ return "ض";

            case 5:
                /*  670 */ if (y >= 297.5D) /*  671 */ {
                    return "م";
                }
                /*  672 */ if (y < 297.5D && y >= 262.5D) /*  673 */ {
                    return "ج ج";
                }
                /*  674 */ if (y < 262.5D && y >= 227.5D) /*  675 */ {
                    return "ج";
                }
                /*  676 */ if (y < 227.5D && y >= 175.0D) {
                    /*  677 */ return "مق";
                }
                /*  679 */ return "ض";
        }

        /*  682 */ return "لم";
    }

    @FXML
    public void handleSave() {
        /*  687 */ current.setSerialNo(this.serialNo.getText());
        /*  688 */ current.setSeatingNo(this.seatingNo.getText());
        /*  689 */ current.setObserve1(this.obsrNo1.getText());
        /*  690 */ current.setObserve2(this.obsrNo2.getText());
        /*  691 */ this.SA.UpdateStud(current);

        /*  694 */ if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 1) {

            /*  696 */ if (!this.Arabic_F_1.getText().isEmpty() && this.Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  697 */ Double.valueOf(this.Arabic_F_1.getText()).doubleValue() <= 75.0D) {
                /*  698 */ ActualGrades ag = new ActualGrades();
                /*  699 */ ag.setGdId(new GradeDetail(Integer.valueOf(56)));
                /*  700 */ ag.setGrade(Double.valueOf(this.Arabic_F_1.getText()).doubleValue());
                /*  701 */ ag.setSId(current);
                /*  702 */ this.SA.PersistStudControl(ag);
            }
            /*  704 */ if (!this.Arabic_F_2.getText().isEmpty() && this.Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  705 */ Double.valueOf(this.Arabic_F_2.getText()).doubleValue() <= 25.0D) {
                /*  706 */ ActualGrades ag = new ActualGrades();
                /*  707 */ ag.setGdId(new GradeDetail(Integer.valueOf(57)));
                /*  708 */ ag.setGrade(Double.valueOf(this.Arabic_F_2.getText()).doubleValue());
                /*  709 */ ag.setSId(current);
                /*  710 */ this.SA.PersistStudControl(ag);
            }
            /*  712 */ if (!this.Arabic_S_1.getText().isEmpty() && this.Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  713 */ Double.valueOf(this.Arabic_S_1.getText()).doubleValue() <= 75.0D) {
                /*  714 */ ActualGrades ag = new ActualGrades();
                /*  715 */ ag.setGdId(new GradeDetail(Integer.valueOf(58)));
                /*  716 */ ag.setGrade(Double.valueOf(this.Arabic_S_1.getText()).doubleValue());
                /*  717 */ ag.setSId(current);
                /*  718 */ this.SA.PersistStudControl(ag);
            }
            /*  720 */ if (!this.Arabic_S_2.getText().isEmpty() && this.Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  721 */ Double.valueOf(this.Arabic_S_2.getText()).doubleValue() <= 25.0D) {
                /*  722 */ ActualGrades ag = new ActualGrades();
                /*  723 */ ag.setGdId(new GradeDetail(Integer.valueOf(59)));
                /*  724 */ ag.setGrade(Double.valueOf(this.Arabic_S_2.getText()).doubleValue());
                /*  725 */ ag.setSId(current);
                /*  726 */ this.SA.PersistStudControl(ag);
            }

            /*  729 */ if (!this.Math_F_1.getText().isEmpty() && this.Math_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  730 */ Double.valueOf(this.Math_F_1.getText()).doubleValue() <= 75.0D) {
                /*  731 */ ActualGrades ag = new ActualGrades();
                /*  732 */ ag.setGdId(new GradeDetail(Integer.valueOf(38)));
                /*  733 */ ag.setGrade(Double.valueOf(this.Math_F_1.getText()).doubleValue());
                /*  734 */ ag.setSId(current);
                /*  735 */ this.SA.PersistStudControl(ag);
            }
            /*  737 */ if (!this.Math_F_2.getText().isEmpty() && this.Math_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  738 */ Double.valueOf(this.Math_F_2.getText()).doubleValue() <= 25.0D) {
                /*  739 */ ActualGrades ag = new ActualGrades();
                /*  740 */ ag.setGdId(new GradeDetail(Integer.valueOf(39)));
                /*  741 */ ag.setGrade(Double.valueOf(this.Math_F_2.getText()).doubleValue());
                /*  742 */ ag.setSId(current);
                /*  743 */ this.SA.PersistStudControl(ag);
            }
            /*  745 */ if (!this.Math_S_1.getText().isEmpty() && this.Math_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  746 */ Double.valueOf(this.Math_S_1.getText()).doubleValue() <= 75.0D) {
                /*  747 */ ActualGrades ag = new ActualGrades();
                /*  748 */ ag.setGdId(new GradeDetail(Integer.valueOf(40)));
                /*  749 */ ag.setGrade(Double.valueOf(this.Math_S_1.getText()).doubleValue());
                /*  750 */ ag.setSId(current);
                /*  751 */ this.SA.PersistStudControl(ag);
            }
            /*  753 */ if (!this.Math_S_2.getText().isEmpty() && this.Math_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  754 */ Double.valueOf(this.Math_S_2.getText()).doubleValue() <= 25.0D) {
                /*  755 */ ActualGrades ag = new ActualGrades();
                /*  756 */ ag.setGdId(new GradeDetail(Integer.valueOf(41)));
                /*  757 */ ag.setGrade(Double.valueOf(this.Math_S_2.getText()).doubleValue());
                /*  758 */ ag.setSId(current);
                /*  759 */ this.SA.PersistStudControl(ag);
            }

            /*  762 */ if (!this.English_F_1.getText().isEmpty() && this.English_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  763 */ Double.valueOf(this.English_F_1.getText()).doubleValue() <= 75.0D) {
                /*  764 */ ActualGrades ag = new ActualGrades();
                /*  765 */ ag.setGdId(new GradeDetail(Integer.valueOf(52)));
                /*  766 */ ag.setGrade(Double.valueOf(this.English_F_1.getText()).doubleValue());
                /*  767 */ ag.setSId(current);
                /*  768 */ this.SA.PersistStudControl(ag);
            }
            /*  770 */ if (!this.English_F_2.getText().isEmpty() && this.English_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  771 */ Double.valueOf(this.English_F_2.getText()).doubleValue() <= 25.0D) {
                /*  772 */ ActualGrades ag = new ActualGrades();
                /*  773 */ ag.setGdId(new GradeDetail(Integer.valueOf(53)));
                /*  774 */ ag.setGrade(Double.valueOf(this.English_F_2.getText()).doubleValue());
                /*  775 */ ag.setSId(current);
                /*  776 */ this.SA.PersistStudControl(ag);
            }
            /*  778 */ if (!this.English_S_1.getText().isEmpty() && this.English_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  779 */ Double.valueOf(this.English_S_1.getText()).doubleValue() <= 75.0D) {
                /*  780 */ ActualGrades ag = new ActualGrades();
                /*  781 */ ag.setGdId(new GradeDetail(Integer.valueOf(54)));
                /*  782 */ ag.setGrade(Double.valueOf(this.English_S_1.getText()).doubleValue());
                /*  783 */ ag.setSId(current);
                /*  784 */ this.SA.PersistStudControl(ag);
            }
            /*  786 */ if (!this.English_S_2.getText().isEmpty() && this.English_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  787 */ Double.valueOf(this.English_S_2.getText()).doubleValue() <= 25.0D) {
                /*  788 */ ActualGrades ag = new ActualGrades();
                /*  789 */ ag.setGdId(new GradeDetail(Integer.valueOf(55)));
                /*  790 */ ag.setGrade(Double.valueOf(this.English_S_2.getText()).doubleValue());
                /*  791 */ ag.setSId(current);
                /*  792 */ this.SA.PersistStudControl(ag);
            }

            /*  795 */ if (!this.Religion_F_1.getText().isEmpty() && this.Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  796 */ Double.valueOf(this.Religion_F_1.getText()).doubleValue() <= 75.0D) {
                /*  797 */ ActualGrades ag = new ActualGrades();
                /*  798 */ ag.setGdId(new GradeDetail(Integer.valueOf(60)));
                /*  799 */ ag.setGrade(Double.valueOf(this.Religion_F_1.getText()).doubleValue());
                /*  800 */ ag.setSId(current);
                /*  801 */ this.SA.PersistStudControl(ag);
            }
            /*  803 */ if (!this.Religion_F_2.getText().isEmpty() && this.Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  804 */ Double.valueOf(this.Religion_F_2.getText()).doubleValue() <= 25.0D) {
                /*  805 */ ActualGrades ag = new ActualGrades();
                /*  806 */ ag.setGdId(new GradeDetail(Integer.valueOf(61)));
                /*  807 */ ag.setGrade(Double.valueOf(this.Religion_F_2.getText()).doubleValue());
                /*  808 */ ag.setSId(current);
                /*  809 */ this.SA.PersistStudControl(ag);
            }
            /*  811 */ if (!this.Religion_S_1.getText().isEmpty() && this.Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  812 */ Double.valueOf(this.Religion_S_1.getText()).doubleValue() <= 75.0D) {
                /*  813 */ ActualGrades ag = new ActualGrades();
                /*  814 */ ag.setGdId(new GradeDetail(Integer.valueOf(62)));
                /*  815 */ ag.setGrade(Double.valueOf(this.Religion_S_1.getText()).doubleValue());
                /*  816 */ ag.setSId(current);
                /*  817 */ this.SA.PersistStudControl(ag);
            }
            /*  819 */ if (!this.Religion_S_2.getText().isEmpty() && this.Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  820 */ Double.valueOf(this.Religion_S_2.getText()).doubleValue() <= 25.0D) {
                /*  821 */ ActualGrades ag = new ActualGrades();
                /*  822 */ ag.setGdId(new GradeDetail(Integer.valueOf(63)));
                /*  823 */ ag.setGrade(Double.valueOf(this.Religion_S_2.getText()).doubleValue());
                /*  824 */ ag.setSId(current);
                /*  825 */ this.SA.PersistStudControl(ag);
            }

            /*  828 */ if (!this.French_F_1.getText().isEmpty() && this.French_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  829 */ Double.valueOf(this.French_F_1.getText()).doubleValue() <= 50.0D) {
                /*  830 */ ActualGrades ag = new ActualGrades();
                /*  831 */ ag.setGdId(new GradeDetail(Integer.valueOf(64)));
                /*  832 */ ag.setGrade(Double.valueOf(this.French_F_1.getText()).doubleValue());
                /*  833 */ ag.setSId(current);
                /*  834 */ this.SA.PersistStudControl(ag);
            }
            /*  836 */ if (!this.French_F_2.getText().isEmpty() && this.French_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  837 */ Double.valueOf(this.French_F_2.getText()).doubleValue() <= 50.0D) {
                /*  838 */ ActualGrades ag = new ActualGrades();
                /*  839 */ ag.setGdId(new GradeDetail(Integer.valueOf(65)));
                /*  840 */ ag.setGrade(Double.valueOf(this.French_F_2.getText()).doubleValue());
                /*  841 */ ag.setSId(current);
                /*  842 */ this.SA.PersistStudControl(ag);
            }
            /*  844 */ if (!this.French_S_1.getText().isEmpty() && this.French_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  845 */ Double.valueOf(this.French_S_1.getText()).doubleValue() <= 50.0D) {
                /*  846 */ ActualGrades ag = new ActualGrades();
                /*  847 */ ag.setGdId(new GradeDetail(Integer.valueOf(66)));
                /*  848 */ ag.setGrade(Double.valueOf(this.French_S_1.getText()).doubleValue());
                /*  849 */ ag.setSId(current);
                /*  850 */ this.SA.PersistStudControl(ag);
            }
            /*  852 */ if (!this.French_S_2.getText().isEmpty() && this.French_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  853 */ Double.valueOf(this.French_S_2.getText()).doubleValue() <= 50.0D) {
                /*  854 */ ActualGrades ag = new ActualGrades();
                /*  855 */ ag.setGdId(new GradeDetail(Integer.valueOf(67)));
                /*  856 */ ag.setGrade(Double.valueOf(this.French_S_2.getText()).doubleValue());
                /*  857 */ ag.setSId(current);
                /*  858 */ this.SA.PersistStudControl(ag);
            }

            /*  861 */ if (!this.Required_F_1.getText().isEmpty() && this.Required_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  862 */ Double.valueOf(this.Required_F_1.getText()).doubleValue() <= 10.0D) {
                /*  863 */ ActualGrades ag = new ActualGrades();
                /*  864 */ ag.setGdId(new GradeDetail(Integer.valueOf(68)));
                /*  865 */ ag.setGrade(Double.valueOf(this.Required_F_1.getText()).doubleValue());
                /*  866 */ ag.setSId(current);
                /*  867 */ this.SA.PersistStudControl(ag);
            }
            /*  869 */ if (!this.Required_F_2.getText().isEmpty() && this.Required_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  870 */ Double.valueOf(this.Required_F_2.getText()).doubleValue() <= 10.0D) {
                /*  871 */ ActualGrades ag = new ActualGrades();
                /*  872 */ ag.setGdId(new GradeDetail(Integer.valueOf(69)));
                /*  873 */ ag.setGrade(Double.valueOf(this.Required_F_2.getText()).doubleValue());
                /*  874 */ ag.setSId(current);
                /*  875 */ this.SA.PersistStudControl(ag);
            }
            /*  877 */ if (!this.Required_S_1.getText().isEmpty() && this.Required_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  878 */ Double.valueOf(this.Required_S_1.getText()).doubleValue() <= 10.0D) {
                /*  879 */ ActualGrades ag = new ActualGrades();
                /*  880 */ ag.setGdId(new GradeDetail(Integer.valueOf(70)));
                /*  881 */ ag.setGrade(Double.valueOf(this.Required_S_1.getText()).doubleValue());
                /*  882 */ ag.setSId(current);
                /*  883 */ this.SA.PersistStudControl(ag);
            }
            /*  885 */ if (!this.Required_S_2.getText().isEmpty() && this.Required_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  886 */ Double.valueOf(this.Required_S_2.getText()).doubleValue() <= 10.0D) {
                /*  887 */ ActualGrades ag = new ActualGrades();
                /*  888 */ ag.setGdId(new GradeDetail(Integer.valueOf(71)));
                /*  889 */ ag.setGrade(Double.valueOf(this.Required_S_2.getText()).doubleValue());
                /*  890 */ ag.setSId(current);
                /*  891 */ this.SA.PersistStudControl(ag);
            }

            /*  894 */ if (!this.Optional_F_1.getText().isEmpty() && this.Optional_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  895 */ Double.valueOf(this.Optional_F_1.getText()).doubleValue() <= 10.0D) {
                /*  896 */ ActualGrades ag = new ActualGrades();
                /*  897 */ ag.setGdId(new GradeDetail(Integer.valueOf(74)));
                /*  898 */ ag.setGrade(Double.valueOf(this.Optional_F_1.getText()).doubleValue());
                /*  899 */ ag.setSId(current);
                /*  900 */ this.SA.PersistStudControl(ag);
            }
            /*  902 */ if (!this.Optional_F_2.getText().isEmpty() && this.Optional_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  903 */ Double.valueOf(this.Optional_F_2.getText()).doubleValue() <= 10.0D) {
                /*  904 */ ActualGrades ag = new ActualGrades();
                /*  905 */ ag.setGdId(new GradeDetail(Integer.valueOf(75)));
                /*  906 */ ag.setGrade(Double.valueOf(this.Optional_F_2.getText()).doubleValue());
                /*  907 */ ag.setSId(current);
                /*  908 */ this.SA.PersistStudControl(ag);
            }
            /*  910 */ if (!this.Optional_S_1.getText().isEmpty() && this.Optional_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  911 */ Double.valueOf(this.Optional_S_1.getText()).doubleValue() <= 10.0D) {
                /*  912 */ ActualGrades ag = new ActualGrades();
                /*  913 */ ag.setGdId(new GradeDetail(Integer.valueOf(76)));
                /*  914 */ ag.setGrade(Double.valueOf(this.Optional_S_1.getText()).doubleValue());
                /*  915 */ ag.setSId(current);
                /*  916 */ this.SA.PersistStudControl(ag);
            }
            /*  918 */ if (!this.Optional_S_2.getText().isEmpty() && this.Optional_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  919 */ Double.valueOf(this.Optional_S_2.getText()).doubleValue() <= 10.0D) {
                /*  920 */ ActualGrades ag = new ActualGrades();
                /*  921 */ ag.setGdId(new GradeDetail(Integer.valueOf(77)));
                /*  922 */ ag.setGrade(Double.valueOf(this.Optional_S_2.getText()).doubleValue());
                /*  923 */ ag.setSId(current);
                /*  924 */ this.SA.PersistStudControl(ag);
            }
        }

        /*  928 */ if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 2) {

            /*  930 */ if (!this.Arabic_F_1.getText().isEmpty() && this.Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  931 */ Double.valueOf(this.Arabic_F_1.getText()).doubleValue() <= 75.0D) {
                /*  932 */ ActualGrades ag = new ActualGrades();
                /*  933 */ ag.setGdId(new GradeDetail(Integer.valueOf(82)));
                /*  934 */ ag.setGrade(Double.valueOf(this.Arabic_F_1.getText()).doubleValue());
                /*  935 */ ag.setSId(current);
                /*  936 */ this.SA.PersistStudControl(ag);
            }
            /*  938 */ if (!this.Arabic_F_2.getText().isEmpty() && this.Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  939 */ Double.valueOf(this.Arabic_F_2.getText()).doubleValue() <= 25.0D) {
                /*  940 */ ActualGrades ag = new ActualGrades();
                /*  941 */ ag.setGdId(new GradeDetail(Integer.valueOf(83)));
                /*  942 */ ag.setGrade(Double.valueOf(this.Arabic_F_2.getText()).doubleValue());
                /*  943 */ ag.setSId(current);
                /*  944 */ this.SA.PersistStudControl(ag);
            }
            /*  946 */ if (!this.Arabic_S_1.getText().isEmpty() && this.Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  947 */ Double.valueOf(this.Arabic_S_1.getText()).doubleValue() <= 75.0D) {
                /*  948 */ ActualGrades ag = new ActualGrades();
                /*  949 */ ag.setGdId(new GradeDetail(Integer.valueOf(84)));
                /*  950 */ ag.setGrade(Double.valueOf(this.Arabic_S_1.getText()).doubleValue());
                /*  951 */ ag.setSId(current);
                /*  952 */ this.SA.PersistStudControl(ag);
            }
            /*  954 */ if (!this.Arabic_S_2.getText().isEmpty() && this.Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  955 */ Double.valueOf(this.Arabic_S_2.getText()).doubleValue() <= 25.0D) {
                /*  956 */ ActualGrades ag = new ActualGrades();
                /*  957 */ ag.setGdId(new GradeDetail(Integer.valueOf(85)));
                /*  958 */ ag.setGrade(Double.valueOf(this.Arabic_S_2.getText()).doubleValue());
                /*  959 */ ag.setSId(current);
                /*  960 */ this.SA.PersistStudControl(ag);
            }

            /*  963 */ if (!this.Math_F_1.getText().isEmpty() && this.Math_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  964 */ Double.valueOf(this.Math_F_1.getText()).doubleValue() <= 75.0D) {
                /*  965 */ ActualGrades ag = new ActualGrades();
                /*  966 */ ag.setGdId(new GradeDetail(Integer.valueOf(92)));
                /*  967 */ ag.setGrade(Double.valueOf(this.Math_F_1.getText()).doubleValue());
                /*  968 */ ag.setSId(current);
                /*  969 */ this.SA.PersistStudControl(ag);
            }

            /*  978 */ if (!this.Math_F_2.getText().isEmpty() && this.Math_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  979 */ Double.valueOf(this.Math_F_2.getText()).doubleValue() <= 25.0D) {
                /*  980 */ ActualGrades ag = new ActualGrades();
                /*  981 */ ag.setGdId(new GradeDetail(Integer.valueOf(93)));
                /*  982 */ ag.setGrade(Double.valueOf(this.Math_F_2.getText()).doubleValue());
                /*  983 */ ag.setSId(current);
                /*  984 */ this.SA.PersistStudControl(ag);
            }
            /*  986 */ if (!this.Math_S_1.getText().isEmpty() && this.Math_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  987 */ Double.valueOf(this.Math_S_1.getText()).doubleValue() <= 75.0D) {
                /*  988 */ ActualGrades ag = new ActualGrades();
                /*  989 */ ag.setGdId(new GradeDetail(Integer.valueOf(94)));
                /*  990 */ ag.setGrade(Double.valueOf(this.Math_S_1.getText()).doubleValue());
                /*  991 */ ag.setSId(current);
                /*  992 */ this.SA.PersistStudControl(ag);
            }
            /*  994 */ if (!this.Math_S_2.getText().isEmpty() && this.Math_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /*  995 */ Double.valueOf(this.Math_S_2.getText()).doubleValue() <= 25.0D) {
                /*  996 */ ActualGrades ag = new ActualGrades();
                /*  997 */ ag.setGdId(new GradeDetail(Integer.valueOf(95)));
                /*  998 */ ag.setGrade(Double.valueOf(this.Math_S_2.getText()).doubleValue());
                /*  999 */ ag.setSId(current);
                /* 1000 */ this.SA.PersistStudControl(ag);
            }

            /* 1003 */ if (!this.English_F_1.getText().isEmpty() && this.English_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1004 */ Double.valueOf(this.English_F_1.getText()).doubleValue() <= 75.0D) {
                /* 1005 */ ActualGrades ag = new ActualGrades();
                /* 1006 */ ag.setGdId(new GradeDetail(Integer.valueOf(78)));
                /* 1007 */ ag.setGrade(Double.valueOf(this.English_F_1.getText()).doubleValue());
                /* 1008 */ ag.setSId(current);
                /* 1009 */ this.SA.PersistStudControl(ag);
            }
            /* 1011 */ if (!this.English_F_2.getText().isEmpty() && this.English_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1012 */ Double.valueOf(this.English_F_2.getText()).doubleValue() <= 25.0D) {
                /* 1013 */ ActualGrades ag = new ActualGrades();
                /* 1014 */ ag.setGdId(new GradeDetail(Integer.valueOf(79)));
                /* 1015 */ ag.setGrade(Double.valueOf(this.English_F_2.getText()).doubleValue());
                /* 1016 */ ag.setSId(current);
                /* 1017 */ this.SA.PersistStudControl(ag);
            }
            /* 1019 */ if (!this.English_S_1.getText().isEmpty() && this.English_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1020 */ Double.valueOf(this.English_S_1.getText()).doubleValue() <= 75.0D) {
                /* 1021 */ ActualGrades ag = new ActualGrades();
                /* 1022 */ ag.setGdId(new GradeDetail(Integer.valueOf(80)));
                /* 1023 */ ag.setGrade(Double.valueOf(this.English_S_1.getText()).doubleValue());
                /* 1024 */ ag.setSId(current);
                /* 1025 */ this.SA.PersistStudControl(ag);
            }
            /* 1027 */ if (!this.English_S_2.getText().isEmpty() && this.English_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1028 */ Double.valueOf(this.English_S_2.getText()).doubleValue() <= 25.0D) {
                /* 1029 */ ActualGrades ag = new ActualGrades();
                /* 1030 */ ag.setGdId(new GradeDetail(Integer.valueOf(81)));
                /* 1031 */ ag.setGrade(Double.valueOf(this.English_S_2.getText()).doubleValue());
                /* 1032 */ ag.setSId(current);
                /* 1033 */ this.SA.PersistStudControl(ag);
            }

            /* 1036 */ if (!this.Religion_F_1.getText().isEmpty() && this.Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1037 */ Double.valueOf(this.Religion_F_1.getText()).doubleValue() <= 75.0D) {
                /* 1038 */ ActualGrades ag = new ActualGrades();
                /* 1039 */ ag.setGdId(new GradeDetail(Integer.valueOf(100)));
                /* 1040 */ ag.setGrade(Double.valueOf(this.Religion_F_1.getText()).doubleValue());
                /* 1041 */ ag.setSId(current);
                /* 1042 */ this.SA.PersistStudControl(ag);
            }
            /* 1044 */ if (!this.Religion_F_2.getText().isEmpty() && this.Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1045 */ Double.valueOf(this.Religion_F_2.getText()).doubleValue() <= 25.0D) {
                /* 1046 */ ActualGrades ag = new ActualGrades();
                /* 1047 */ ag.setGdId(new GradeDetail(Integer.valueOf(101)));
                /* 1048 */ ag.setGrade(Double.valueOf(this.Religion_F_2.getText()).doubleValue());
                /* 1049 */ ag.setSId(current);
                /* 1050 */ this.SA.PersistStudControl(ag);
            }
            /* 1052 */ if (!this.Religion_S_1.getText().isEmpty() && this.Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1053 */ Double.valueOf(this.Religion_S_1.getText()).doubleValue() <= 75.0D) {
                /* 1054 */ ActualGrades ag = new ActualGrades();
                /* 1055 */ ag.setGdId(new GradeDetail(Integer.valueOf(102)));
                /* 1056 */ ag.setGrade(Double.valueOf(this.Religion_S_1.getText()).doubleValue());
                /* 1057 */ ag.setSId(current);
                /* 1058 */ this.SA.PersistStudControl(ag);
            }
            /* 1060 */ if (!this.Religion_S_2.getText().isEmpty() && this.Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1061 */ Double.valueOf(this.Religion_S_2.getText()).doubleValue() <= 25.0D) {
                /* 1062 */ ActualGrades ag = new ActualGrades();
                /* 1063 */ ag.setGdId(new GradeDetail(Integer.valueOf(103)));
                /* 1064 */ ag.setGrade(Double.valueOf(this.Religion_S_2.getText()).doubleValue());
                /* 1065 */ ag.setSId(current);
                /* 1066 */ this.SA.PersistStudControl(ag);
            }

            /* 1069 */ if (!this.French_F_1.getText().isEmpty() && this.French_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1070 */ Double.valueOf(this.French_F_1.getText()).doubleValue() <= 50.0D) {
                /* 1071 */ ActualGrades ag = new ActualGrades();
                /* 1072 */ ag.setGdId(new GradeDetail(Integer.valueOf(104)));
                /* 1073 */ ag.setGrade(Double.valueOf(this.French_F_1.getText()).doubleValue());
                /* 1074 */ ag.setSId(current);
                /* 1075 */ this.SA.PersistStudControl(ag);
            }
            /* 1077 */ if (!this.French_F_2.getText().isEmpty() && this.French_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1078 */ Double.valueOf(this.French_F_2.getText()).doubleValue() <= 50.0D) {
                /* 1079 */ ActualGrades ag = new ActualGrades();
                /* 1080 */ ag.setGdId(new GradeDetail(Integer.valueOf(105)));
                /* 1081 */ ag.setGrade(Double.valueOf(this.French_F_2.getText()).doubleValue());
                /* 1082 */ ag.setSId(current);
                /* 1083 */ this.SA.PersistStudControl(ag);
            }
            /* 1085 */ if (!this.French_S_1.getText().isEmpty() && this.French_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1086 */ Double.valueOf(this.French_S_1.getText()).doubleValue() <= 50.0D) {
                /* 1087 */ ActualGrades ag = new ActualGrades();
                /* 1088 */ ag.setGdId(new GradeDetail(Integer.valueOf(106)));
                /* 1089 */ ag.setGrade(Double.valueOf(this.French_S_1.getText()).doubleValue());
                /* 1090 */ ag.setSId(current);
                /* 1091 */ this.SA.PersistStudControl(ag);
            }
            /* 1093 */ if (!this.French_S_2.getText().isEmpty() && this.French_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1094 */ Double.valueOf(this.French_S_2.getText()).doubleValue() <= 50.0D) {
                /* 1095 */ ActualGrades ag = new ActualGrades();
                /* 1096 */ ag.setGdId(new GradeDetail(Integer.valueOf(107)));
                /* 1097 */ ag.setGrade(Double.valueOf(this.French_S_2.getText()).doubleValue());
                /* 1098 */ ag.setSId(current);
                /* 1099 */ this.SA.PersistStudControl(ag);
            }

            /* 1102 */ if (!this.Required_F_1.getText().isEmpty() && this.Required_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1103 */ Double.valueOf(this.Required_F_1.getText()).doubleValue() <= 10.0D) {
                /* 1104 */ ActualGrades ag = new ActualGrades();
                /* 1105 */ ag.setGdId(new GradeDetail(Integer.valueOf(108)));
                /* 1106 */ ag.setGrade(Double.valueOf(this.Required_F_1.getText()).doubleValue());
                /* 1107 */ ag.setSId(current);
                /* 1108 */ this.SA.PersistStudControl(ag);
            }
            /* 1110 */ if (!this.Required_F_2.getText().isEmpty() && this.Required_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1111 */ Double.valueOf(this.Required_F_2.getText()).doubleValue() <= 10.0D) {
                /* 1112 */ ActualGrades ag = new ActualGrades();
                /* 1113 */ ag.setGdId(new GradeDetail(Integer.valueOf(109)));
                /* 1114 */ ag.setGrade(Double.valueOf(this.Required_F_2.getText()).doubleValue());
                /* 1115 */ ag.setSId(current);
                /* 1116 */ this.SA.PersistStudControl(ag);
            }
            /* 1118 */ if (!this.Required_S_1.getText().isEmpty() && this.Required_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1119 */ Double.valueOf(this.Required_S_1.getText()).doubleValue() <= 10.0D) {
                /* 1120 */ ActualGrades ag = new ActualGrades();
                /* 1121 */ ag.setGdId(new GradeDetail(Integer.valueOf(110)));
                /* 1122 */ ag.setGrade(Double.valueOf(this.Required_S_1.getText()).doubleValue());
                /* 1123 */ ag.setSId(current);
                /* 1124 */ this.SA.PersistStudControl(ag);
            }
            /* 1126 */ if (!this.Required_S_2.getText().isEmpty() && this.Required_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1127 */ Double.valueOf(this.Required_S_2.getText()).doubleValue() <= 10.0D) {
                /* 1128 */ ActualGrades ag = new ActualGrades();
                /* 1129 */ ag.setGdId(new GradeDetail(Integer.valueOf(111)));
                /* 1130 */ ag.setGrade(Double.valueOf(this.Required_S_2.getText()).doubleValue());
                /* 1131 */ ag.setSId(current);
                /* 1132 */ this.SA.PersistStudControl(ag);
            }

            /* 1135 */ if (!this.Optional_F_1.getText().isEmpty() && this.Optional_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1136 */ Double.valueOf(this.Optional_F_1.getText()).doubleValue() <= 10.0D) {
                /* 1137 */ ActualGrades ag = new ActualGrades();
                /* 1138 */ ag.setGdId(new GradeDetail(Integer.valueOf(114)));
                /* 1139 */ ag.setGrade(Double.valueOf(this.Optional_F_1.getText()).doubleValue());
                /* 1140 */ ag.setSId(current);
                /* 1141 */ this.SA.PersistStudControl(ag);
            }
            /* 1143 */ if (!this.Optional_F_2.getText().isEmpty() && this.Optional_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1144 */ Double.valueOf(this.Optional_F_2.getText()).doubleValue() <= 10.0D) {
                /* 1145 */ ActualGrades ag = new ActualGrades();
                /* 1146 */ ag.setGdId(new GradeDetail(Integer.valueOf(115)));
                /* 1147 */ ag.setGrade(Double.valueOf(this.Optional_F_2.getText()).doubleValue());
                /* 1148 */ ag.setSId(current);
                /* 1149 */ this.SA.PersistStudControl(ag);
            }
            /* 1151 */ if (!this.Optional_S_1.getText().isEmpty() && this.Optional_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1152 */ Double.valueOf(this.Optional_S_1.getText()).doubleValue() <= 10.0D) {
                /* 1153 */ ActualGrades ag = new ActualGrades();
                /* 1154 */ ag.setGdId(new GradeDetail(Integer.valueOf(116)));
                /* 1155 */ ag.setGrade(Double.valueOf(this.Optional_S_1.getText()).doubleValue());
                /* 1156 */ ag.setSId(current);
                /* 1157 */ this.SA.PersistStudControl(ag);
            }
            /* 1159 */ if (!this.Optional_S_2.getText().isEmpty() && this.Optional_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1160 */ Double.valueOf(this.Optional_S_2.getText()).doubleValue() <= 10.0D) {
                /* 1161 */ ActualGrades ag = new ActualGrades();
                /* 1162 */ ag.setGdId(new GradeDetail(Integer.valueOf(117)));
                /* 1163 */ ag.setGrade(Double.valueOf(this.Optional_S_2.getText()).doubleValue());
                /* 1164 */ ag.setSId(current);
                /* 1165 */ this.SA.PersistStudControl(ag);
            }
        }

        /* 1169 */ if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 3) {

            /* 1171 */ if (!this.Arabic_F_1.getText().isEmpty() && this.Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1172 */ Double.valueOf(this.Arabic_F_1.getText()).doubleValue() <= 75.0D) {
                /* 1173 */ ActualGrades ag = new ActualGrades();
                /* 1174 */ ag.setGdId(new GradeDetail(Integer.valueOf(122)));
                /* 1175 */ ag.setGrade(Double.valueOf(this.Arabic_F_1.getText()).doubleValue());
                /* 1176 */ ag.setSId(current);
                /* 1177 */ this.SA.PersistStudControl(ag);
            }
            /* 1179 */ if (!this.Arabic_F_2.getText().isEmpty() && this.Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1180 */ Double.valueOf(this.Arabic_F_2.getText()).doubleValue() <= 25.0D) {
                /* 1181 */ ActualGrades ag = new ActualGrades();
                /* 1182 */ ag.setGdId(new GradeDetail(Integer.valueOf(123)));
                /* 1183 */ ag.setGrade(Double.valueOf(this.Arabic_F_2.getText()).doubleValue());
                /* 1184 */ ag.setSId(current);
                /* 1185 */ this.SA.PersistStudControl(ag);
            }
            /* 1187 */ if (!this.Arabic_S_1.getText().isEmpty() && this.Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1188 */ Double.valueOf(this.Arabic_S_1.getText()).doubleValue() <= 75.0D) {
                /* 1189 */ ActualGrades ag = new ActualGrades();
                /* 1190 */ ag.setGdId(new GradeDetail(Integer.valueOf(124)));
                /* 1191 */ ag.setGrade(Double.valueOf(this.Arabic_S_1.getText()).doubleValue());
                /* 1192 */ ag.setSId(current);
                /* 1193 */ this.SA.PersistStudControl(ag);
            }
            /* 1195 */ if (!this.Arabic_S_2.getText().isEmpty() && this.Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1196 */ Double.valueOf(this.Arabic_S_2.getText()).doubleValue() <= 25.0D) {
                /* 1197 */ ActualGrades ag = new ActualGrades();
                /* 1198 */ ag.setGdId(new GradeDetail(Integer.valueOf(125)));
                /* 1199 */ ag.setGrade(Double.valueOf(this.Arabic_S_2.getText()).doubleValue());
                /* 1200 */ ag.setSId(current);
                /* 1201 */ this.SA.PersistStudControl(ag);
            }

            /* 1204 */ if (!this.Math_F_1.getText().isEmpty() && this.Math_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1205 */ Double.valueOf(this.Math_F_1.getText()).doubleValue() <= 75.0D) {
                /* 1206 */ ActualGrades ag = new ActualGrades();
                /* 1207 */ ag.setGdId(new GradeDetail(Integer.valueOf(132)));
                /* 1208 */ ag.setGrade(Double.valueOf(this.Math_F_1.getText()).doubleValue());
                /* 1209 */ ag.setSId(current);
                /* 1210 */ this.SA.PersistStudControl(ag);
            }

            /* 1219 */ if (!this.Math_F_2.getText().isEmpty() && this.Math_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1220 */ Double.valueOf(this.Math_F_2.getText()).doubleValue() <= 25.0D) {
                /* 1221 */ ActualGrades ag = new ActualGrades();
                /* 1222 */ ag.setGdId(new GradeDetail(Integer.valueOf(133)));
                /* 1223 */ ag.setGrade(Double.valueOf(this.Math_F_2.getText()).doubleValue());
                /* 1224 */ ag.setSId(current);
                /* 1225 */ this.SA.PersistStudControl(ag);
            }
            /* 1227 */ if (!this.Math_S_1.getText().isEmpty() && this.Math_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1228 */ Double.valueOf(this.Math_S_1.getText()).doubleValue() <= 75.0D) {
                /* 1229 */ ActualGrades ag = new ActualGrades();
                /* 1230 */ ag.setGdId(new GradeDetail(Integer.valueOf(134)));
                /* 1231 */ ag.setGrade(Double.valueOf(this.Math_S_1.getText()).doubleValue());
                /* 1232 */ ag.setSId(current);
                /* 1233 */ this.SA.PersistStudControl(ag);
            }
            /* 1235 */ if (!this.Math_S_2.getText().isEmpty() && this.Math_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1236 */ Double.valueOf(this.Math_S_2.getText()).doubleValue() <= 25.0D) {
                /* 1237 */ ActualGrades ag = new ActualGrades();
                /* 1238 */ ag.setGdId(new GradeDetail(Integer.valueOf(135)));
                /* 1239 */ ag.setGrade(Double.valueOf(this.Math_S_2.getText()).doubleValue());
                /* 1240 */ ag.setSId(current);
                /* 1241 */ this.SA.PersistStudControl(ag);
            }

            /* 1244 */ if (!this.English_F_1.getText().isEmpty() && this.English_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1245 */ Double.valueOf(this.English_F_1.getText()).doubleValue() <= 75.0D) {
                /* 1246 */ ActualGrades ag = new ActualGrades();
                /* 1247 */ ag.setGdId(new GradeDetail(Integer.valueOf(118)));
                /* 1248 */ ag.setGrade(Double.valueOf(this.English_F_1.getText()).doubleValue());
                /* 1249 */ ag.setSId(current);
                /* 1250 */ this.SA.PersistStudControl(ag);
            }
            /* 1252 */ if (!this.English_F_2.getText().isEmpty() && this.English_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1253 */ Double.valueOf(this.English_F_2.getText()).doubleValue() <= 25.0D) {
                /* 1254 */ ActualGrades ag = new ActualGrades();
                /* 1255 */ ag.setGdId(new GradeDetail(Integer.valueOf(119)));
                /* 1256 */ ag.setGrade(Double.valueOf(this.English_F_2.getText()).doubleValue());
                /* 1257 */ ag.setSId(current);
                /* 1258 */ this.SA.PersistStudControl(ag);
            }
            /* 1260 */ if (!this.English_S_1.getText().isEmpty() && this.English_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1261 */ Double.valueOf(this.English_S_1.getText()).doubleValue() <= 75.0D) {
                /* 1262 */ ActualGrades ag = new ActualGrades();
                /* 1263 */ ag.setGdId(new GradeDetail(Integer.valueOf(120)));
                /* 1264 */ ag.setGrade(Double.valueOf(this.English_S_1.getText()).doubleValue());
                /* 1265 */ ag.setSId(current);
                /* 1266 */ this.SA.PersistStudControl(ag);
            }
            /* 1268 */ if (!this.English_S_2.getText().isEmpty() && this.English_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1269 */ Double.valueOf(this.English_S_2.getText()).doubleValue() <= 25.0D) {
                /* 1270 */ ActualGrades ag = new ActualGrades();
                /* 1271 */ ag.setGdId(new GradeDetail(Integer.valueOf(121)));
                /* 1272 */ ag.setGrade(Double.valueOf(this.English_S_2.getText()).doubleValue());
                /* 1273 */ ag.setSId(current);
                /* 1274 */ this.SA.PersistStudControl(ag);
            }

            /* 1277 */ if (!this.Religion_F_1.getText().isEmpty() && this.Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1278 */ Double.valueOf(this.Religion_F_1.getText()).doubleValue() <= 75.0D) {
                /* 1279 */ ActualGrades ag = new ActualGrades();
                /* 1280 */ ag.setGdId(new GradeDetail(Integer.valueOf(140)));
                /* 1281 */ ag.setGrade(Double.valueOf(this.Religion_F_1.getText()).doubleValue());
                /* 1282 */ ag.setSId(current);
                /* 1283 */ this.SA.PersistStudControl(ag);
            }
            /* 1285 */ if (!this.Religion_F_2.getText().isEmpty() && this.Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1286 */ Double.valueOf(this.Religion_F_2.getText()).doubleValue() <= 25.0D) {
                /* 1287 */ ActualGrades ag = new ActualGrades();
                /* 1288 */ ag.setGdId(new GradeDetail(Integer.valueOf(141)));
                /* 1289 */ ag.setGrade(Double.valueOf(this.Religion_F_2.getText()).doubleValue());
                /* 1290 */ ag.setSId(current);
                /* 1291 */ this.SA.PersistStudControl(ag);
            }
            /* 1293 */ if (!this.Religion_S_1.getText().isEmpty() && this.Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1294 */ Double.valueOf(this.Religion_S_1.getText()).doubleValue() <= 75.0D) {
                /* 1295 */ ActualGrades ag = new ActualGrades();
                /* 1296 */ ag.setGdId(new GradeDetail(Integer.valueOf(142)));
                /* 1297 */ ag.setGrade(Double.valueOf(this.Religion_S_1.getText()).doubleValue());
                /* 1298 */ ag.setSId(current);
                /* 1299 */ this.SA.PersistStudControl(ag);
            }
            /* 1301 */ if (!this.Religion_S_2.getText().isEmpty() && this.Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1302 */ Double.valueOf(this.Religion_S_2.getText()).doubleValue() <= 25.0D) {
                /* 1303 */ ActualGrades ag = new ActualGrades();
                /* 1304 */ ag.setGdId(new GradeDetail(Integer.valueOf(143)));
                /* 1305 */ ag.setGrade(Double.valueOf(this.Religion_S_2.getText()).doubleValue());
                /* 1306 */ ag.setSId(current);
                /* 1307 */ this.SA.PersistStudControl(ag);
            }

            /* 1310 */ if (!this.French_F_1.getText().isEmpty() && this.French_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1311 */ Double.valueOf(this.French_F_1.getText()).doubleValue() <= 50.0D) {
                /* 1312 */ ActualGrades ag = new ActualGrades();
                /* 1313 */ ag.setGdId(new GradeDetail(Integer.valueOf(144)));
                /* 1314 */ ag.setGrade(Double.valueOf(this.French_F_1.getText()).doubleValue());
                /* 1315 */ ag.setSId(current);
                /* 1316 */ this.SA.PersistStudControl(ag);
            }
            /* 1318 */ if (!this.French_F_2.getText().isEmpty() && this.French_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1319 */ Double.valueOf(this.French_F_2.getText()).doubleValue() <= 50.0D) {
                /* 1320 */ ActualGrades ag = new ActualGrades();
                /* 1321 */ ag.setGdId(new GradeDetail(Integer.valueOf(145)));
                /* 1322 */ ag.setGrade(Double.valueOf(this.French_F_2.getText()).doubleValue());
                /* 1323 */ ag.setSId(current);
                /* 1324 */ this.SA.PersistStudControl(ag);
            }
            /* 1326 */ if (!this.French_S_1.getText().isEmpty() && this.French_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1327 */ Double.valueOf(this.French_S_1.getText()).doubleValue() <= 50.0D) {
                /* 1328 */ ActualGrades ag = new ActualGrades();
                /* 1329 */ ag.setGdId(new GradeDetail(Integer.valueOf(146)));
                /* 1330 */ ag.setGrade(Double.valueOf(this.French_S_1.getText()).doubleValue());
                /* 1331 */ ag.setSId(current);
                /* 1332 */ this.SA.PersistStudControl(ag);
            }
            /* 1334 */ if (!this.French_S_2.getText().isEmpty() && this.French_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1335 */ Double.valueOf(this.French_S_2.getText()).doubleValue() <= 50.0D) {
                /* 1336 */ ActualGrades ag = new ActualGrades();
                /* 1337 */ ag.setGdId(new GradeDetail(Integer.valueOf(147)));
                /* 1338 */ ag.setGrade(Double.valueOf(this.French_S_2.getText()).doubleValue());
                /* 1339 */ ag.setSId(current);
                /* 1340 */ this.SA.PersistStudControl(ag);
            }

            /* 1343 */ if (!this.Required_F_1.getText().isEmpty() && this.Required_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1344 */ Double.valueOf(this.Required_F_1.getText()).doubleValue() <= 10.0D) {
                /* 1345 */ ActualGrades ag = new ActualGrades();
                /* 1346 */ ag.setGdId(new GradeDetail(Integer.valueOf(148)));
                /* 1347 */ ag.setGrade(Double.valueOf(this.Required_F_1.getText()).doubleValue());
                /* 1348 */ ag.setSId(current);
                /* 1349 */ this.SA.PersistStudControl(ag);
            }
            /* 1351 */ if (!this.Required_F_2.getText().isEmpty() && this.Required_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1352 */ Double.valueOf(this.Required_F_2.getText()).doubleValue() <= 10.0D) {
                /* 1353 */ ActualGrades ag = new ActualGrades();
                /* 1354 */ ag.setGdId(new GradeDetail(Integer.valueOf(149)));
                /* 1355 */ ag.setGrade(Double.valueOf(this.Required_F_2.getText()).doubleValue());
                /* 1356 */ ag.setSId(current);
                /* 1357 */ this.SA.PersistStudControl(ag);
            }
            /* 1359 */ if (!this.Required_S_1.getText().isEmpty() && this.Required_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1360 */ Double.valueOf(this.Required_S_1.getText()).doubleValue() <= 10.0D) {
                /* 1361 */ ActualGrades ag = new ActualGrades();
                /* 1362 */ ag.setGdId(new GradeDetail(Integer.valueOf(150)));
                /* 1363 */ ag.setGrade(Double.valueOf(this.Required_S_1.getText()).doubleValue());
                /* 1364 */ ag.setSId(current);
                /* 1365 */ this.SA.PersistStudControl(ag);
            }
            /* 1367 */ if (!this.Required_S_2.getText().isEmpty() && this.Required_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1368 */ Double.valueOf(this.Required_S_2.getText()).doubleValue() <= 10.0D) {
                /* 1369 */ ActualGrades ag = new ActualGrades();
                /* 1370 */ ag.setGdId(new GradeDetail(Integer.valueOf(151)));
                /* 1371 */ ag.setGrade(Double.valueOf(this.Required_S_2.getText()).doubleValue());
                /* 1372 */ ag.setSId(current);
                /* 1373 */ this.SA.PersistStudControl(ag);
            }

            /* 1376 */ if (!this.Optional_F_1.getText().isEmpty() && this.Optional_F_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1377 */ Double.valueOf(this.Optional_F_1.getText()).doubleValue() <= 10.0D) {
                /* 1378 */ ActualGrades ag = new ActualGrades();
                /* 1379 */ ag.setGdId(new GradeDetail(Integer.valueOf(154)));
                /* 1380 */ ag.setGrade(Double.valueOf(this.Optional_F_1.getText()).doubleValue());
                /* 1381 */ ag.setSId(current);
                /* 1382 */ this.SA.PersistStudControl(ag);
            }
            /* 1384 */ if (!this.Optional_F_2.getText().isEmpty() && this.Optional_F_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1385 */ Double.valueOf(this.Optional_F_2.getText()).doubleValue() <= 10.0D) {
                /* 1386 */ ActualGrades ag = new ActualGrades();
                /* 1387 */ ag.setGdId(new GradeDetail(Integer.valueOf(155)));
                /* 1388 */ ag.setGrade(Double.valueOf(this.Optional_F_2.getText()).doubleValue());
                /* 1389 */ ag.setSId(current);
                /* 1390 */ this.SA.PersistStudControl(ag);
            }
            /* 1392 */ if (!this.Optional_S_1.getText().isEmpty() && this.Optional_S_1.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1393 */ Double.valueOf(this.Optional_S_1.getText()).doubleValue() <= 10.0D) {
                /* 1394 */ ActualGrades ag = new ActualGrades();
                /* 1395 */ ag.setGdId(new GradeDetail(Integer.valueOf(156)));
                /* 1396 */ ag.setGrade(Double.valueOf(this.Optional_S_1.getText()).doubleValue());
                /* 1397 */ ag.setSId(current);
                /* 1398 */ this.SA.PersistStudControl(ag);
            }
            /* 1400 */ if (!this.Optional_S_2.getText().isEmpty() && this.Optional_S_2.getText().matches("[0-9]+(\\.[0-9])*")
                    && /* 1401 */ Double.valueOf(this.Optional_S_2.getText()).doubleValue() <= 10.0D) {
                /* 1402 */ ActualGrades ag = new ActualGrades();
                /* 1403 */ ag.setGdId(new GradeDetail(Integer.valueOf(157)));
                /* 1404 */ ag.setGrade(Double.valueOf(this.Optional_S_2.getText()).doubleValue());
                /* 1405 */ ag.setSId(current);
                /* 1406 */ this.SA.PersistStudControl(ag);
            }
        }
        /* 1409 */ StudentAffair.getDialogStage2().close();
    }
}


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\StudentGradesOneController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */
