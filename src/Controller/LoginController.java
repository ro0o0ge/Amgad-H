/*    */ package Controller;
/*    */ 
/*    */ import Util.LoginSec;
/*    */ import amgad.h.Main;
/*    */ import java.net.URL;
/*    */ import java.util.ResourceBundle;
/*    */ import javafx.fxml.FXML;
/*    */ import javafx.fxml.Initializable;
/*    */ import javafx.geometry.NodeOrientation;
/*    */ import javafx.scene.control.Alert;
/*    */ import javafx.scene.control.PasswordField;
/*    */ import javafx.scene.control.TextField;
/*    */ import org.hibernate.HibernateException;
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
/*    */ public class LoginController
/*    */   implements Initializable
/*    */ {
/*    */   @FXML
/*    */   private TextField userName;
/*    */   @FXML
/*    */   private PasswordField Pass;
/*    */   private Main main;
/*    */   
/* 38 */   public void setMainApp(Main mainapp) { this.main = mainapp; }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initialize(URL url, ResourceBundle rb) {}
/*    */ 
/*    */ 
/*    */   
/*    */   @FXML
/*    */   public void login() {
/*    */     try {
/* 49 */       LoginSec ls = new LoginSec();
/* 50 */       if (this.userName.getText().equals("") || this.Pass.getText().equals("")) {
/* 51 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 52 */         alert.setTitle("يوجد خطأ");
/* 53 */         alert.setHeaderText("");
/* 54 */         alert.setContentText("برجاء كتابة اسم المستخدم او كلمة المرور");
/* 55 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 56 */         alert.showAndWait();
/* 57 */       } else if (!ls.HandleLogin(this.userName.getText(), this.Pass.getText()).equals("1")) {
/* 58 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 59 */         alert.setTitle("يوجد خطأ");
/* 60 */         alert.setHeaderText("غير مسموح لك بتسجيل الدخول");
/* 61 */         alert.setContentText("برجاء التأكد من اسم المستخدم وكلمة المرور او الرجوع للأدمن");
/* 62 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 63 */         alert.showAndWait();
/*    */       } else {
/* 65 */         this.main.rootView();
/*    */       }
/*    */     
/* 68 */     } catch (HibernateException he) {
/* 69 */       System.out.println("error at db ");
/* 70 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 71 */       alert.setTitle("يوجد خطأ في الاتصال بالداتابيز");
/* 72 */       alert.setHeaderText("برجاء مراجعة مالك البرنامج");
/* 73 */       alert.setContentText(he.getMessage());
/* 74 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 75 */       alert.showAndWait();
/* 76 */     } catch (Exception e) {
/* 77 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 78 */       alert.setTitle("يوجد خطأ");
/* 79 */       alert.setHeaderText("برجاء مراجعة مالك البرنامج");
/* 80 */       alert.setContentText(e.getMessage());
/* 81 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 82 */       alert.showAndWait();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\LoginController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */