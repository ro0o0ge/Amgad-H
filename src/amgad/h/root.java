/*    */ package amgad.h;
/*    */ 
/*    */ import Controller.RootViewController;
/*    */ import Util.LoginSec;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import javafx.application.Platform;
/*    */ import javafx.fxml.FXMLLoader;
/*    */ import javafx.geometry.NodeOrientation;
/*    */ import javafx.scene.Scene;
/*    */ import javafx.scene.image.Image;
/*    */ import javafx.scene.layout.AnchorPane;
/*    */ import javafx.stage.Stage;
/*    */ import javafx.stage.WindowEvent;
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
/*    */ public class root
/*    */ {
/*    */   private Stage primaryStage;
/*    */   private AnchorPane rootLayout;
/*    */   public static File f;
/*    */   
/* 32 */   public Stage getPrimaryStage() { return this.primaryStage; }
/*    */ 
/*    */   
/*    */   public void InitRoot() {
/*    */     try {
/* 37 */       this.primaryStage = new Stage();
/* 38 */       this.primaryStage.setTitle("مدرسة الأمجاد الخاصة");
/* 39 */       this.primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*    */       
/* 41 */       FXMLLoader loader = new FXMLLoader();
/* 42 */       loader.setLocation(Main.class.getResource("/View/Root.fxml"));
/* 43 */       this.rootLayout = (AnchorPane)loader.load();
/* 44 */       Scene scene = new Scene(this.rootLayout, 580.0D, 600.0D);
/* 45 */       scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 46 */       this.primaryStage.setScene(scene);
/*    */       
/* 48 */       Management m = new Management();
/* 49 */       StudentAffair sa = new StudentAffair();
/* 50 */       TeachingStaff ts = new TeachingStaff();
/* 51 */       m.setMainApp(this);
/* 52 */       sa.setMainApp(this);
/* 53 */       ts.setMainApp(this);
/*    */       
/* 55 */       RootViewController Rcontroller = (RootViewController)loader.getController();
/* 56 */       Rcontroller.setMainApp(m, sa, ts, scene);
/*    */       
/* 58 */       this.primaryStage.show();
/*    */       
/* 60 */       this.primaryStage.setOnCloseRequest(t -> {
/*    */             try {
/* 62 */               LoginSec ls = new LoginSec();
/* 63 */               ls.HandleLogout();
/* 64 */               Platform.exit();
/* 65 */               System.exit(0);
/* 66 */             } catch (Exception e) {
/* 67 */               e.printStackTrace();
/*    */             }
/*    */           
/*    */           });
/* 71 */     } catch (IOException e) {
/* 72 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\amgad\h\root.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */