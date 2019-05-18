/*    */ package Controller;
/*    */ 
/*    */ import Entity.EmployeeAttendance;
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
/*    */ public class EditAbscentStatusController
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
/* 38 */     this.name.setText(TeachingStaff.getEditStatus().getTId().getPId().getName());
/* 39 */     this.date.setText(TeachingStaff.getEditStatus().getEaDate().toString());
/* 40 */     this.status.setSelected(TeachingStaff.getEditStatus().getStatus());
/*    */   }
/*    */   
/*    */   @FXML
/*    */   public void handleDone() {
/* 45 */     TeachingStaff TS = new TeachingStaff();
/* 46 */     EmployeeAttendance ea = TeachingStaff.getEditStatus();
/* 47 */     ea.setStatus(this.status.isSelected());
/* 48 */     TS.UpdateAbscenceStatus(ea);
/* 49 */     TeachingStaff.getDialogStage2().close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EditAbscentStatusController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */