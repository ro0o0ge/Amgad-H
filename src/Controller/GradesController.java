/*     */ package Controller;

/*     */
 /*     */ import Entity.FinalGrades;
/*     */ import Entity.GradeDetail;
/*     */ import Entity.StudyYears;
/*     */ import Entity.Subjects;
/*     */ import amgad.h.TeachingStaff;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.ResourceBundle;
/*     */ import javafx.beans.value.ObservableValue;
/*     */ import javafx.fxml.FXML;
/*     */ import javafx.fxml.Initializable;
/*     */ import javafx.geometry.NodeOrientation;
/*     */ import javafx.scene.control.Alert;
/*     */ import javafx.scene.control.ComboBox;
/*     */ import javafx.scene.control.TableColumn;
/*     */ import javafx.scene.control.TableView;
/*     */ import javafx.scene.control.TextArea;
/*     */ import javafx.scene.control.TextField;

/*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */ public class GradesController
        /*     */ implements Initializable /*     */ {

    /*     */ @FXML
    /*     */ private ComboBox ComboYear;
    /*     */    @FXML
    /*     */ private ComboBox ComboSubject;
    /*     */    @FXML
    /*     */ private TextField FinalGrade;
    /*     */    @FXML
    /*     */ private TextField Grade;
    /*     */    @FXML
    /*     */ private TextArea GradeDesc;
    /*     */    @FXML
    /*     */ private TableView<GradeDetail> GradeDetailTable;
    /*     */    @FXML
    /*     */ private TableColumn<GradeDetail, String> GradeColumn;
    /*     */    @FXML
    /*     */ private TableColumn<GradeDetail, String> GradeDescColumn;
    /*     */    TeachingStaff TS;
    /*     */    private static FinalGrades FG;

    /*     */
 /*  56 */ public static void setFG(FinalGrades FG) {
        GradesController.FG = FG;
    }

    /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */ public void initialize(URL url, ResourceBundle rb) {
        /*  68 */ this.TS = new TeachingStaff();
        /*  69 */ this.ComboSubject.getItems().removeAll(this.ComboSubject.getItems());
        /*  70 */ this.ComboYear.getItems().removeAll(this.ComboYear.getItems());
        /*  71 */ this.ComboYear.getItems().addAll(getStaudyYears());
        /*  72 */ this.ComboYear.valueProperty().addListener((ov, oldValue, newValue) -> {
            /*  73 */ this.ComboSubject.getItems().clear();
            /*  74 */ this.ComboSubject.getItems().addAll(getSubjects(newValue.toString()));
            /*  75 */ this.FinalGrade.setText("");
            /*     */        });
        /*     */
 /*  78 */ ComboSubject.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (newValue != null || !newValue.equals("")) {
                TS.LoadGradeDetails(newValue.toString(),
                        ComboYear.getSelectionModel().getSelectedItem().toString());
                FinalGrade.setText(TS.getFinalGrade(TS.getSubjectsByDescAndYDesc(newValue.toString(),
                        ComboYear.getSelectionModel().getSelectedItem().toString())));

                GradeDetailTable.setItems(TS.getGradeDetailList());
                GradeColumn.setCellValueFactory(cellData -> cellData.getValue().GradeProperty());
                GradeDescColumn.setCellValueFactory(cellData -> cellData.getValue().GradeDescProperty());
                GradeDetailTable.getSelectionModel().selectedItemProperty().addListener(
                        (observabl, oldValu, newValu) -> showDetails(newValu));

            }
        });
        /*     */
 /*     */
 /*  93 */ System.out.println("Call Init");
        /*     */    }

    /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */
 /*     */ private void showDetails(GradeDetail shera2) {
        /* 103 */ if (shera2 != null) {
            /* 104 */ this.Grade.setText(String.valueOf(shera2.getGrade()));
            /* 105 */ this.GradeDesc.setText(shera2.getGradeDetail());
            /*     */        } else {
            /* 107 */ this.Grade.setText("");
            /* 108 */ this.GradeDesc.setText("");
            /*     */        }
        /*     */    }

    /*     */
 /*     */ public List<String> getStaudyYears() {
        /* 113 */ List<String> StudY = new ArrayList<String>();
        /* 114 */ for (StudyYears sy : this.TS.getStudyYears()) {
            /* 115 */ StudY.add(sy.getSyDesc());
            /*     */        }
        /* 117 */ return StudY;
        /*     */    }

    /*     */
 /*     */ public List<String> getSubjects(String syDesc) {
        /* 121 */ List<String> StudY = new ArrayList<String>();
        /* 122 */ for (Subjects sy : this.TS.getSubjectsByStudyYearDesc(syDesc)) {
            /* 123 */ StudY.add(sy.getSuDesc());
            /*     */        }
        /* 125 */ return StudY;
        /*     */    }

    /*     */
 /*     */ @FXML
    /*     */ public void handleNew() {
        /* 130 */ if (!this.Grade.getText().equals("") && !this.GradeDesc.getText().equals("") && this.Grade
                /* 131 */.getText().matches("[0-9]+") && !this.ComboSubject.getSelectionModel().getSelectedItem().equals("")
                && /* 132 */ !this.FinalGrade.getText().equals("") && this.FinalGrade.getText().matches("[0-9]+")) {
            /* 133 */ GradeDetail tempGD = new GradeDetail();
            /* 134 */ System.out.println("final grade of " + FG.getSuId().getSuDesc());
            /* 135 */ tempGD.setGId(FG);
            /* 136 */ tempGD.setGrade(Double.valueOf(this.Grade.getText()).doubleValue());
            /* 137 */ tempGD.setGradeDetail(this.GradeDesc.getText());
            /* 138 */ this.TS.PersistNewGradeDetail(tempGD);
            /* 139 */ this.TS.getGradeDetailList().add(tempGD);
            /* 140 */ this.GradeDetailTable.setItems(this.TS.getGradeDetailList());
            /*     */        } else {
            /* 142 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 143 */ alert.setTitle("يوجد خطأ");
            /* 144 */ alert.setHeaderText("خطأ");
            /* 145 */ alert.setContentText("برجاء التأكد من صحة البيانات");
            /* 146 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 147 */ alert.showAndWait();
            /*     */        }
        /*     */    }

    /*     */
 /*     */ @FXML
    /*     */ public void handleEdit() {
        /* 153 */ GradeDetail gd = (GradeDetail) this.GradeDetailTable.getSelectionModel().getSelectedItem();
        /* 154 */ if (gd != null && !this.Grade.getText().equals("") && !this.GradeDesc.getText().equals("") && this.Grade
                /* 155 */.getText().matches("[0-9]+")) {
            /*     */
 /* 157 */ gd.setGrade(Double.valueOf(this.Grade.getText()).doubleValue());
            /* 158 */ gd.setGradeDetail(this.GradeDesc.getText());
            /*     */
 /* 160 */ this.TS.UpdateGradeDetail(gd);
            /* 161 */ this.GradeDetailTable.setItems(this.TS.getGradeDetailList());
            /*     */        } /*     */ else {
            /*     */
 /* 165 */ Alert alert = new Alert(Alert.AlertType.WARNING);
            /* 166 */ alert.setTitle("يوجد خطأ");
            /* 167 */ alert.setHeaderText("خطأ");
            /* 168 */ alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            /* 169 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 170 */ alert.showAndWait();
            /*     */        }
        /*     */    }

    /*     */
 /*     */ @FXML
    /*     */ public void handleDelete() {
        /* 176 */ int selectedIndex = this.GradeDetailTable.getSelectionModel().getSelectedIndex();
        /* 177 */ if (selectedIndex >= 0) {
            /* 178 */ GradeDetail del = (GradeDetail) this.GradeDetailTable.getItems().get(selectedIndex);
            /* 179 */ this.GradeDetailTable.getItems().remove(selectedIndex);
            /* 180 */ this.TS.RemoveGradeDetail(del);
            /*     */        } else {
            /* 182 */ Alert alert = new Alert(Alert.AlertType.WARNING);
            /* 183 */ alert.setTitle("يوجد خطأ");
            /* 184 */ alert.setHeaderText("خطأ");
            /* 185 */ alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
            /* 186 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 187 */ alert.showAndWait();
            /*     */        }
        /*     */    }

    /*     */
 /*     */
 /*     */ @FXML
    /*     */ public void handleSaveAll() {
    }

    /*     */
 /*     */
 /*     */ @FXML
    /*     */ public void handleNewFinalGrade() {
        /* 198 */ if (!this.ComboSubject.getSelectionModel().getSelectedItem().equals("")
                && /* 199 */ !this.FinalGrade.getText().equals("") && this.FinalGrade.getText().matches("[0-9]+")) {
            /* 200 */ FinalGrades tempFG = new FinalGrades();
            /* 201 */ tempFG.setSuId(this.TS.getSubjectsByDescAndYDesc(this.ComboSubject.getSelectionModel().getSelectedItem().toString(), this.ComboYear
                    /* 202 */.getSelectionModel().getSelectedItem().toString()));
            /* 203 */ tempFG.setGrade(Integer.parseInt(this.FinalGrade.getText()));
            /* 204 */ this.TS.PersistNewFinalGrade(tempFG);
            /*     */        } else {
            /* 206 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 207 */ alert.setTitle("يوجد خطأ");
            /* 208 */ alert.setHeaderText("خطأ");
            /* 209 */ alert.setContentText("برجاء التأكد من اختيار المادة و كتابة الدرجة ");
            /* 210 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 211 */ alert.showAndWait();
            /*     */        }
        /*     */    }

    /*     */
 /*     */ @FXML
    /*     */ public void handleEditFinalGrade() {
        /* 217 */ if (!this.ComboSubject.getSelectionModel().getSelectedItem().equals("")
                && /* 218 */ !this.FinalGrade.getText().equals("") && this.FinalGrade.getText().matches("[0-9]+")) {
            /* 219 */ System.out.println("Selected " + FG.getSuId().getSuDesc());
            /*     */
 /* 221 */ FG.setSuId(this.TS.getSubjectsByDescAndYDesc(this.ComboSubject.getSelectionModel().getSelectedItem().toString(), this.ComboYear
                    /* 222 */.getSelectionModel().getSelectedItem().toString()));
            /* 223 */ FG.setGrade(Integer.parseInt(this.FinalGrade.getText()));
            /* 224 */ this.TS.UpdateFinalGrade(FG);
            /*     */        } else {
            /* 226 */ Alert alert = new Alert(Alert.AlertType.ERROR);
            /* 227 */ alert.setTitle("يوجد خطأ");
            /* 228 */ alert.setHeaderText("خطأ");
            /* 229 */ alert.setContentText("برجاء التأكد من اختيار المادة و كتابة الدرجة ");
            /* 230 */ alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            /* 231 */ alert.showAndWait();
            /*     */        }
        /*     */    }

    /*     */
 /*     */
 /*     */ @FXML
    /* 237 */ public void handleClose() {
        this.TS.getDialogStage().close();
    }
    /*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\GradesController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */
