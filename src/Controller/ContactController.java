/*    */ package Controller;
/*    */ 
/*    */ import amgad.h.StudentAffair;
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
/*    */ 
/*    */ public class ContactController
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
/* 39 */     if (!this.conName.getText().equals("") || 
/* 40 */       !this.conNum.getText().equals("")) {
/* 41 */       StudentAffair.getContacts().setConName(this.conName.getText());
/* 42 */       StudentAffair.getContacts().setConDeatails(this.conNum.getText());
/* 43 */       StudentAffair.getDialogStage2().close();
/*    */     } else {
/* 45 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 46 */       alert.setTitle("يوجد خطأ");
/* 47 */       alert.setHeaderText("خطأ");
/* 48 */       alert.setContentText("برجاء التأكد من ملأ الاسم و لرقم");
/* 49 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 50 */       alert.showAndWait();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\ContactController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */