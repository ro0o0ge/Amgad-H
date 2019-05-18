/*    */ package Controller;
/*    */ 
/*    */ import amgad.h.Main;
/*    */ import java.net.URL;
/*    */ import java.util.ResourceBundle;
/*    */ import javafx.fxml.FXML;
/*    */ import javafx.fxml.Initializable;
/*    */ import javafx.geometry.NodeOrientation;
/*    */ import javafx.scene.control.Alert;
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
/*    */ public class MainController
/*    */   implements Initializable
/*    */ {
/*    */   private Main main;
/*    */   
/*    */   public void initialize(URL url, ResourceBundle rb) {}
/*    */   
/* 33 */   public void setMainApp(Main mainapp) { this.main = mainapp; }
/*    */ 
/*    */ 
/*    */   
/*    */   @FXML
/* 38 */   private void handleLogin() { this.main.login(); }
/*    */ 
/*    */ 
/*    */   
/*    */   @FXML
/*    */   private void handleAbout() {
/* 44 */     Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 45 */     alert.setTitle("مدرسة الأمجاد الخاصة");
/* 46 */     alert.setHeaderText("معلومات");
/* 47 */     alert.setContentText("بواسطة : عبدالله رمضان \n للتواصل: abdo.ramadan29@gmail.com");
/*    */ 
/*    */     
/* 50 */     alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 51 */     alert.showAndWait();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @FXML
/* 59 */   private void handleExit() { System.exit(0); }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\MainController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */