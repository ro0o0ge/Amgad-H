/*     */ package Controller;
/*     */ 
/*     */ import Entity.Student;
/*     */ import amgad.h.StudentAffair;
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
/*     */ public class Absent_StudController
/*     */   implements Initializable
/*     */ {
/*     */   @FXML
/*     */   private TextField SearchQuery;
/*     */   @FXML
/*     */   private DatePicker AbsentDate;
/*     */   @FXML
/*     */   private TextArea Notes;
/*     */   @FXML
/*     */   private TableView<Student> StudentsTable;
/*     */   @FXML
/*     */   private TableColumn<Student, String> NameColumn;
/*     */   @FXML
/*     */   private TableColumn<Student, String> ClassColumn;
/*     */   StudentAffair SA;
/*     */   Student su;
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/*  57 */     if (!this.StudentsTable.getItems().isEmpty()) {
/*  58 */       this.StudentsTable.getItems().clear();
/*     */     }
/*     */     
/*  61 */     this.StudentsTable.setItems(StudentAffair.getPersonsList());
/*  62 */     this.NameColumn.setCellValueFactory(cellData -> ((Student)cellData.getValue()).getPId().NameProperty());
/*  63 */     this.ClassColumn.setCellValueFactory(cellData -> {
/*  64 */           if (((Student)cellData.getValue()).getClassStudentsList() != null) {
/*  65 */             return ((Student)cellData.getValue()).getClassStudentsList().getCId().ClassDescProperty();
/*     */           }
/*  67 */           return null;
/*     */         });
/*     */     
/*  70 */     this.SA = new StudentAffair();
/*     */     
/*  72 */     System.out.println("Stud Absent Init");
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void Search() {
/*  77 */     if (!this.SearchQuery.getText().equals("")) {
/*  78 */       ObservableList<Student> TempList = FXCollections.observableArrayList(this.SA.getActiveStudents());
/*  79 */       this.StudentsTable.getItems().clear();
/*  80 */       for (int i = 0; i < TempList.size(); i++) {
/*  81 */         if (!((Student)TempList.get(i)).getPId().getName().contains(this.SearchQuery.getText())) {
/*  82 */           TempList.remove(i);
/*  83 */           i--;
/*     */         } 
/*     */       } 
/*  86 */       this.StudentsTable.setItems(TempList);
/*     */     } else {
/*  88 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/*  89 */       alert.setTitle("يوجد خطأ");
/*  90 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/*  91 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/*  92 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/*  93 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void afterNew() {
/*  98 */     this.StudentsTable.setItems(StudentAffair.getPersonsList());
/*  99 */     this.SearchQuery.setText("");
/* 100 */     this.Notes.setText("");
/* 101 */     this.AbsentDate.setValue(null);
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleNewAbsent() {
/* 106 */     this.su = (Student)this.StudentsTable.getSelectionModel().getSelectedItem();
/* 107 */     if (this.su != null && this.AbsentDate.getValue() != null) {
/* 108 */       if (this.SA.PersistNewAbsent(this.Notes.getText(), this.su, Date.valueOf((LocalDate)this.AbsentDate.getValue()))) {
/*     */         
/* 110 */         afterNew();
/* 111 */         Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 112 */         alert.setTitle("تم");
/* 113 */         alert.setHeaderText("تم الحفظ بنجاح");
/* 114 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 115 */         alert.showAndWait();
/*     */       } else {
/* 117 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 118 */         alert.setTitle("يوجد خطأ");
/* 119 */         alert.setHeaderText("لم يتم الحفظ");
/* 120 */         alert.setContentText("برجاء الرجوع الى صاحب البرنامج");
/* 121 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 122 */         alert.showAndWait();
/*     */       }
/*     */     
/* 125 */     } else if (this.su == null) {
/* 126 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 127 */       alert.setTitle("يوجد خطأ");
/* 128 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حفظه");
/* 129 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 130 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 131 */       alert.showAndWait();
/*     */     } else {
/* 133 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 134 */       alert.setTitle("يوجد خطأ");
/* 135 */       alert.setHeaderText("برجاء ادخال تاريخ الغياب");
/* 136 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 137 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FXML
/* 145 */   public void handleClose() { this.SA.getDialogStage().close(); }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\Absent_StudController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */