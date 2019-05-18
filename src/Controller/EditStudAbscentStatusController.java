/*    */ package Controller;
/*    */ 
/*    */ import Entity.StudentAttendance;
/*    */ import amgad.h.StudentAffair;
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
/*    */ public class EditStudAbscentStatusController
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
/* 38 */     this.name.setText(StudentAffair.getEditStatus().getSId().getPId().getName());
/* 39 */     this.date.setText(StudentAffair.getEditStatus().getAbsentDay().toString());
/* 40 */     this.status.setSelected(StudentAffair.getEditStatus().getStatus());
/*    */   }
/*    */   
/*    */   @FXML
/*    */   public void handleDone() {
/* 45 */     StudentAffair TS = new StudentAffair();
/* 46 */     StudentAttendance ea = StudentAffair.getEditStatus();
/* 47 */     ea.setStatus(this.status.isSelected());
/* 48 */     TS.UpdateAbscenceStatus(ea);
/* 49 */     StudentAffair.getDialogStage2().close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EditStudAbscentStatusController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */