/*    */ package Controller;
/*    */ 
/*    */ import Entity.Payroll;
/*    */ import amgad.h.Management;
/*    */ import java.net.URL;
/*    */ import java.util.ResourceBundle;
/*    */ import javafx.fxml.FXML;
/*    */ import javafx.fxml.Initializable;
/*    */ import javafx.geometry.NodeOrientation;
/*    */ import javafx.scene.control.Alert;
/*    */ import javafx.scene.control.DatePicker;
/*    */ import javafx.scene.control.Label;
/*    */ import javafx.scene.control.TableColumn;
/*    */ import javafx.scene.control.TableView;
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
/*    */ public class ViewPayrollController
/*    */   implements Initializable
/*    */ {
/*    */   @FXML
/*    */   private Label amount;
/*    */   @FXML
/*    */   private DatePicker fromDate;
/*    */   @FXML
/*    */   private DatePicker toDate;
/*    */   @FXML
/*    */   private TextField IssuedBy;
/*    */   @FXML
/*    */   private TableView<Payroll> PayrollTable;
/*    */   @FXML
/*    */   private TableColumn<Payroll, String> NameColumn;
/*    */   @FXML
/*    */   private TableColumn<Payroll, String> GrossColumn;
/*    */   @FXML
/*    */   private TableColumn<Payroll, String> DeductionColumn;
/*    */   @FXML
/*    */   private TableColumn<Payroll, String> RewardsColumn;
/*    */   @FXML
/*    */   private TableColumn<Payroll, String> NetColumn;
/*    */   Management MA;
/*    */   
/*    */   public void initialize(URL url, ResourceBundle rb) {}
/*    */   
/*    */   @FXML
/*    */   public void Search() {
/* 75 */     if (this.fromDate.getValue() != null && this.toDate.getValue() != null) {
/* 76 */       System.out.println("in search");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     }
/*    */     else {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 92 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 93 */       alert.setTitle("يوجد خطأ");
/* 94 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/* 95 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/* 96 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 97 */       alert.showAndWait();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\ViewPayrollController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */