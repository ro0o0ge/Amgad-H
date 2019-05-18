/*     */ package amgad.h;
/*     */ 
/*     */ import Controller.LoginController;
/*     */ import Controller.MainController;
/*     */ import java.io.IOException;
/*     */ import javafx.application.Application;
/*     */ import javafx.application.Platform;
/*     */ import javafx.fxml.FXMLLoader;
/*     */ import javafx.geometry.NodeOrientation;
/*     */ import javafx.scene.Scene;
/*     */ import javafx.scene.control.Alert;
/*     */ import javafx.scene.image.Image;
/*     */ import javafx.scene.layout.AnchorPane;
/*     */ import javafx.stage.Modality;
/*     */ import javafx.stage.Stage;
/*     */ import javafx.stage.WindowEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Main
/*     */   extends Application
/*     */ {
/*     */   private Stage primaryStage;
/*     */   private AnchorPane mainLayout;
/*     */   
/*  38 */   public Stage getPrimaryStage() { return this.primaryStage; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start(Stage primaryStage) {
/*     */     try {
/*  46 */       this.primaryStage = primaryStage;
/*  47 */       this.primaryStage.setTitle("مدرسة الأمجاد الخاصة");
/*  48 */       this.primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*     */       
/*  50 */       FXMLLoader loader = new FXMLLoader();
/*  51 */       loader.setLocation(Main.class.getResource("/View/Main.fxml"));
/*  52 */       this.mainLayout = (AnchorPane)loader.load();
/*  53 */       Scene scene = new Scene(this.mainLayout, 580.0D, 600.0D);
/*  54 */       scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/*  55 */       this.primaryStage.setScene(scene);
/*     */       
/*  57 */       MainController Mcontroller = (MainController)loader.getController();
/*  58 */       Mcontroller.setMainApp(this);
/*     */       
/*  60 */       this.primaryStage.show();
/*     */       
/*  62 */       this.primaryStage.setOnCloseRequest(t -> {
/*  63 */             Platform.exit();
/*  64 */             System.exit(0);
/*     */           });
/*  66 */     } catch (Exception e) {
/*  67 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/*  68 */       alert.setTitle("يوجد خطأ");
/*  69 */       alert.setContentText(e.getLocalizedMessage());
/*  70 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/*  71 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void rootView() {
/*  76 */     root r = new root();
/*  77 */     r.InitRoot();
/*  78 */     this.primaryStage.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public void login() {
/*     */     try {
/*  84 */       FXMLLoader loader = new FXMLLoader();
/*  85 */       loader.setLocation(Main.class.getResource("/View/Login.fxml"));
/*  86 */       AnchorPane page = (AnchorPane)loader.load();
/*     */       
/*  88 */       Stage dialogStage = new Stage();
/*  89 */       dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*     */       
/*  91 */       dialogStage.setTitle("تسجيل الدخول");
/*  92 */       dialogStage.initModality(Modality.WINDOW_MODAL);
/*  93 */       dialogStage.initOwner(getPrimaryStage());
/*  94 */       Scene scene = new Scene(page);
/*  95 */       scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/*  96 */       dialogStage.setScene(scene);
/*     */       
/*  98 */       LoginController Lcontroller = (LoginController)loader.getController();
/*  99 */       Lcontroller.setMainApp(this);
/*     */       
/* 101 */       dialogStage.showAndWait();
/* 102 */     } catch (IOException e) {
/* 103 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 108 */   public static void main(String[] args) { launch(args); }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\amgad\h\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */