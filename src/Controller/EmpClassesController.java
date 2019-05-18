/*    */ package Controller;
/*    */ 
/*    */ import Entity.Classes;
/*    */ import amgad.h.Management;
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
/*    */ public class EmpClassesController
/*    */   implements Initializable
/*    */ {
/*    */   @FXML
/*    */   ComboBox STYCombo;
/*    */   Management ts;
/*    */   
/*    */   public void initialize(URL url, ResourceBundle rb) {
/* 38 */     this.STYCombo.getItems().removeAll(this.STYCombo.getItems());
/* 39 */     this.STYCombo.getItems().addAll(getStaudyYears());
/*    */   }
/*    */   
/*    */   private List<String> getStaudyYears() {
/* 43 */     this.ts = new Management();
/* 44 */     List<String> StudY = new ArrayList<String>();
/* 45 */     for (Classes sy : this.ts.getStudyYears()) {
/* 46 */       StudY.add(sy.getClassDesc());
/*    */     }
/* 48 */     return StudY;
/*    */   }
/*    */   
/*    */   @FXML
/*    */   private void handleConfirm() {
/* 53 */     if (!this.STYCombo.getValue().equals("")) {
/* 54 */       this.ts = new Management();
/* 55 */       Management.getDialogStage2().close();
/*    */     } else {
/* 57 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 58 */       alert.setTitle("يوجد خطأ");
/* 59 */       alert.setHeaderText("خطأ");
/* 60 */       alert.setContentText("برجاء التأكد من اختيار الفصل");
/* 61 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 62 */       alert.showAndWait();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EmpClassesController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */