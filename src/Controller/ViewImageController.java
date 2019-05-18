/*    */ package Controller;
/*    */ 
/*    */ import amgad.h.root;
/*    */ import java.io.File;
/*    */ import java.net.URL;
/*    */ import java.util.ResourceBundle;
/*    */ import javafx.fxml.FXML;
/*    */ import javafx.fxml.Initializable;
/*    */ import javafx.scene.image.Image;
/*    */ import javafx.scene.image.ImageView;
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
/*    */ public class ViewImageController
/*    */   implements Initializable
/*    */ {
/*    */   @FXML
/*    */   ImageView i;
/*    */   
/*    */   public void initialize(URL url, ResourceBundle rb) {
/*    */     try {
/* 37 */       this.i.setImage(new Image((new File(root.f.getPath())).toURI().toString()));
/* 38 */     } catch (Exception e) {
/* 39 */       System.out.println("Image not Found " + root.f.getPath());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\ViewImageController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */