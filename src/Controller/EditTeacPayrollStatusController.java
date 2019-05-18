/*    */ package Controller;
/*    */ 
/*    */ import amgad.h.TeachingStaff;
/*    */ import java.net.URL;
/*    */ import java.util.ResourceBundle;
/*    */ import javafx.fxml.FXML;
/*    */ import javafx.fxml.Initializable;
/*    */ import javafx.scene.control.CheckBox;
/*    */ import javafx.scene.control.Label;
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
/*    */ public class EditTeacPayrollStatusController
/*    */   implements Initializable
/*    */ {
/*    */   @FXML
/*    */   Label name;
/*    */   @FXML
/*    */   Label date;
/*    */   @FXML
/*    */   CheckBox status;
/*    */   
/*    */   public void initialize(URL url, ResourceBundle rb) {
/* 39 */     this.name.setText(TeachingStaff.getEditPayrollStatus().getPId().getName());
/* 40 */     this.date.setText(TeachingStaff.getEditPayrollStatus().getPrDate().toString());
/* 41 */     this.status.setSelected(TeachingStaff.getEditPayrollStatus().getPrStatus());
/*    */   }
/*    */   
/*    */   @FXML
/*    */   public void handleDone() {
/* 46 */     TeachingStaff TS = new TeachingStaff();
/* 47 */     TeachingStaff.getEditPayrollStatus().setPrStatus(this.status.isSelected());
/* 48 */     TS.UpdatePenaltyStatus();
/* 49 */     TeachingStaff.getDialogStage2().close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EditTeacPayrollStatusController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */