/*     */ package Controller;
/*     */ 
/*     */ import Entity.Persons;
/*     */ import amgad.h.Management;
/*     */ import java.net.URL;
/*     */ import java.sql.Date;
/*     */ import java.time.LocalDate;
/*     */ import java.util.ResourceBundle;
/*     */ import javafx.beans.value.ObservableValue;
/*     */ import javafx.collections.FXCollections;
/*     */ import javafx.collections.ObservableList;
/*     */ import javafx.fxml.FXML;
/*     */ import javafx.fxml.Initializable;
/*     */ import javafx.geometry.NodeOrientation;
/*     */ import javafx.scene.control.Alert;
/*     */ import javafx.scene.control.CheckBox;
/*     */ import javafx.scene.control.ComboBox;
/*     */ import javafx.scene.control.DatePicker;
/*     */ import javafx.scene.control.TableColumn;
/*     */ import javafx.scene.control.TableView;
/*     */ import javafx.scene.control.TextArea;
/*     */ import javafx.scene.control.TextField;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BonusController
/*     */   implements Initializable
/*     */ {
/*     */   @FXML
/*     */   private TextField SearchQuery;
/*     */   @FXML
/*     */   private TextField Amount;
/*     */   @FXML
/*     */   private TextArea Notes;
/*     */   @FXML
/*     */   private DatePicker EDate;
/*     */   @FXML
/*     */   private CheckBox Recieved;
/*     */   @FXML
/*     */   private TableView<Persons> PayrollTable;
/*     */   @FXML
/*     */   private TableColumn<Persons, String> NameColumn;
/*     */   @FXML
/*     */   private ComboBox ComboType;
/*     */   Management MA;
/*     */   Persons st;
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/*  70 */     this.MA = new Management();
/*     */     
/*  72 */     if (!this.PayrollTable.getItems().isEmpty()) {
/*  73 */       this.PayrollTable.getItems().clear();
/*     */     }
/*     */     
/*  76 */     this.PayrollTable.setItems(Management.getEmpList());
/*  77 */     this.NameColumn.setCellValueFactory(cellData -> ((Persons)cellData.getValue()).NameProperty());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     this.ComboType.getItems().removeAll(this.ComboType.getItems());
/*  83 */     this.ComboType.getItems().addAll(new Object[] { "مكافأة شهرية", "الكادر", "مكافأة استثنائية", "مكافأة امتحانات" });
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   public void Search() {
/*  89 */     if (!this.SearchQuery.getText().equals("")) {
/*  90 */       ObservableList<Persons> TempList = FXCollections.observableArrayList(this.MA.getActiveEmp());
/*  91 */       this.PayrollTable.getItems().clear();
/*  92 */       for (int i = 0; i < TempList.size(); i++) {
/*  93 */         if (!((Persons)TempList.get(i)).getName().contains(this.SearchQuery.getText())) {
/*  94 */           TempList.remove(i);
/*  95 */           i--;
/*     */         } 
/*     */       } 
/*  98 */       this.PayrollTable.setItems(TempList);
/*     */     } else {
/* 100 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 101 */       alert.setTitle("يوجد خطأ");
/* 102 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/* 103 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/* 104 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 105 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void afterNew() {
/* 111 */     this.PayrollTable.setItems(Management.getEmpList());
/* 112 */     this.Amount.setText("");
/* 113 */     this.EDate.setValue(null);
/* 114 */     this.Notes.setText("");
/* 115 */     this.Recieved.setSelected(false);
/* 116 */     this.ComboType.getSelectionModel().select(0);
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleNewAbsent() {
/* 121 */     this.st = (Persons)this.PayrollTable.getSelectionModel().getSelectedItem();
/* 122 */     if (this.st != null && this.EDate.getValue() != null && this.Amount
/* 123 */       .getText() != null && this.ComboType.getSelectionModel().getSelectedIndex() != -1) {
/* 124 */       if (this.MA.PersistNewBonus(this.Notes.getText(), this.st, 
/* 125 */           Date.valueOf((LocalDate)this.EDate.getValue()), this.ComboType
/* 126 */           .getSelectionModel().getSelectedItem().toString(), this.Amount
/* 127 */           .getText(), this.Recieved
/* 128 */           .isSelected())) {
/* 129 */         afterNew();
/* 130 */         Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 131 */         alert.setTitle("تم");
/* 132 */         alert.setHeaderText("تم الحفظ بنجاح");
/* 133 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 134 */         alert.showAndWait();
/*     */       } else {
/* 136 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 137 */         alert.setTitle("يوجد خطأ");
/* 138 */         alert.setHeaderText("لم يتم الحفظ");
/* 139 */         alert.setContentText("برجاء الرجوع الى مالك البرنامج");
/* 140 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 141 */         alert.showAndWait();
/*     */       }
/*     */     
/* 144 */     } else if (this.st == null) {
/* 145 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 146 */       alert.setTitle("يوجد خطأ");
/* 147 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حفظه");
/* 148 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 149 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 150 */       alert.showAndWait();
/*     */     } else {
/* 152 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 153 */       alert.setTitle("يوجد خطأ");
/* 154 */       alert.setHeaderText("برجاء التأكد من ادخال البيانات المطلوبة");
/* 155 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 156 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FXML
/* 164 */   public void handleClose() { Management.getDialogStage().close(); }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\BonusController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */