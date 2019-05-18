/*    */ package Controller;
/*    */ 
/*    */ import Entity.EmployeeAttendance;
/*    */ import amgad.h.Management;
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
/*    */ public class EditStaffAbscentStatusController
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
/* 40 */     this.name.setText(Management.getEditStatus().getStId().getPId().getName());
/* 41 */     this.date.setText(Management.getEditStatus().getEaDate().toString());
/* 42 */     this.status.setSelected(Management.getEditStatus().getStatus());
/*    */   }
/*    */   
/*    */   @FXML
/*    */   public void handleDone() {
/* 47 */     Management TS = new Management();
/* 48 */     EmployeeAttendance ea = Management.getEditStatus();
/* 49 */     ea.setStatus(this.status.isSelected());
/* 50 */     TS.UpdateAbscenceStatus(ea);
/* 51 */     Management.getDialogStage2().close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EditStaffAbscentStatusController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */