/*    */ package Controller;
/*    */ 
/*    */ import amgad.h.Management;
/*    */ import java.net.URL;
/*    */ import java.util.ResourceBundle;
/*    */ import javafx.fxml.FXML;
/*    */ import javafx.fxml.Initializable;
/*    */ import javafx.geometry.NodeOrientation;
/*    */ import javafx.scene.control.Alert;
/*    */ import javafx.scene.control.TextField;
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
/*    */ public class EmpContactsController
/*    */   implements Initializable
/*    */ {
/*    */   @FXML
/*    */   private TextField conName;
/*    */   @FXML
/*    */   private TextField conNum;
/*    */   
/*    */   public void initialize(URL url, ResourceBundle rb) {}
/*    */   
/*    */   @FXML
/*    */   private void handleConfirm() {
/* 38 */     if (!this.conName.getText().equals("") || 
/* 39 */       !this.conNum.getText().equals("")) {
/* 40 */       Management.getContacts().setConName(this.conName.getText());
/* 41 */       Management.getContacts().setConDeatails(this.conNum.getText());
/* 42 */       Management.getDialogStage2().close();
/*    */     } else {
/* 44 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 45 */       alert.setTitle("يوجد خطأ");
/* 46 */       alert.setHeaderText("خطأ");
/* 47 */       alert.setContentText("برجاء التأكد من ملأ الاسم و لرقم");
/* 48 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 49 */       alert.showAndWait();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EmpContactsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */