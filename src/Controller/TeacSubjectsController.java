/*    */ package Controller;
/*    */ 
/*    */ import Entity.StudyYears;
/*    */ import Entity.Subjects;
/*    */ import amgad.h.TeachingStaff;
/*    */ import java.net.URL;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.ResourceBundle;
/*    */ import javafx.fxml.FXML;
/*    */ import javafx.fxml.Initializable;
/*    */ import javafx.geometry.NodeOrientation;
/*    */ import javafx.scene.control.Alert;
/*    */ import javafx.scene.control.ComboBox;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TeacSubjectsController
/*    */   implements Initializable
/*    */ {
/*    */   @FXML
/*    */   ComboBox SUCombo;
/*    */   @FXML
/*    */   ComboBox STYCombo;
/*    */   TeachingStaff ts;
/*    */   
/*    */   public void initialize(URL url, ResourceBundle rb) {
/* 43 */     this.STYCombo.getItems().removeAll(this.STYCombo.getItems());
/* 44 */     this.STYCombo.getItems().addAll(getStaudyYears());
/*    */     
/* 46 */     this.SUCombo.getItems().removeAll(this.STYCombo.getItems());
/*    */   }
/*    */ 
/*    */   
/*    */   private List<String> getStaudyYears() {
/* 51 */     this.ts = new TeachingStaff();
/* 52 */     List<String> StudY = new ArrayList<String>();
/* 53 */     for (StudyYears sy : this.ts.getStudyYears()) {
/* 54 */       StudY.add(sy.getSyDesc());
/*    */     }
/* 56 */     return StudY;
/*    */   }
/*    */   
/*    */   @FXML
/*    */   private void handleSTYSelection() {
/* 61 */     this.SUCombo.getItems().clear();
/* 62 */     this.ts = new TeachingStaff();
/* 63 */     List<String> StudY = new ArrayList<String>();
/* 64 */     for (Subjects sy : this.ts.getStudyYearSubjects(this.ts.getStudyYearsByDesc(this.STYCombo.getValue().toString()))) {
/* 65 */       StudY.add(sy.getSuDesc());
/*    */     }
/* 67 */     this.SUCombo.getItems().addAll(StudY);
/*    */   }
/*    */   
/*    */   @FXML
/*    */   private void handleConfirm() {
/* 72 */     if (!this.SUCombo.getValue().equals("")) {
/* 73 */       this.ts = new TeachingStaff();
/* 74 */       TeachingStaff.getS().setSuId(this.ts
/* 75 */           .getSubjectsByDescAndYDesc(this.SUCombo.getValue().toString(), this.STYCombo.getValue().toString()));
/* 76 */       TeachingStaff.getDialogStage2().close();
/*    */     } else {
/* 78 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 79 */       alert.setTitle("يوجد خطأ");
/* 80 */       alert.setHeaderText("خطأ");
/* 81 */       alert.setContentText("برجاء التأكد من اختيار المادة");
/* 82 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 83 */       alert.showAndWait();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\TeacSubjectsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */