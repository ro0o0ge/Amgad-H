/*     */ package Controller;
/*     */ 
/*     */ import Entity.Student;
/*     */ import Entity.StudentNotes;
/*     */ import amgad.h.StudentAffair;
/*     */ import java.net.URL;
/*     */ import java.sql.Date;
/*     */ import java.time.LocalDate;
/*     */ import java.util.ResourceBundle;
/*     */ import javafx.beans.value.ObservableValue;
/*     */ import javafx.fxml.FXML;
/*     */ import javafx.fxml.Initializable;
/*     */ import javafx.geometry.NodeOrientation;
/*     */ import javafx.scene.control.Alert;
/*     */ import javafx.scene.control.ComboBox;
/*     */ import javafx.scene.control.Label;
/*     */ import javafx.scene.control.TableColumn;
/*     */ import javafx.scene.control.TableView;
/*     */ import javafx.scene.control.TextArea;
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
/*     */ public class StudNotesController
/*     */   implements Initializable
/*     */ {
/*     */   @FXML
/*     */   private TableView<StudentNotes> NotesTable;
/*     */   @FXML
/*     */   private TableColumn<StudentNotes, String> TitleColumn;
/*     */   @FXML
/*     */   private TableColumn<StudentNotes, String> DateColumn;
/*     */   @FXML
/*     */   private TableColumn<StudentNotes, String> ContentColumn;
/*     */   @FXML
/*     */   private Label StudName;
/*     */   @FXML
/*     */   private TextArea NoteBody;
/*     */   @FXML
/*     */   ComboBox NoteType;
/*     */   StudentAffair SA;
/*     */   private static Student current;
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/*  60 */     this.SA = new StudentAffair();
/*  61 */     current = StudentAffair.getEdit();
/*  62 */     this.NotesTable.setItems(this.SA.getStudentNotesList());
/*  63 */     this.TitleColumn.setCellValueFactory(cellData -> ((StudentNotes)cellData.getValue()).TitleProperty());
/*  64 */     this.ContentColumn.setCellValueFactory(cellData -> ((StudentNotes)cellData.getValue()).TypeProperty());
/*  65 */     this.DateColumn.setCellValueFactory(cellData -> ((StudentNotes)cellData.getValue()).DateProperty());
/*  66 */     this.StudName.setText(current.getPId().getName());
/*     */     
/*  68 */     this.NoteType.getItems().removeAll(this.NoteType.getItems());
/*  69 */     this.NoteType.getItems().addAll(new Object[] { "السلوك", "الهوايات", "الحالة الصحية", "المستوى التعليمي", "الإلتزام (التأخير)", "الإلتزام (الغياب)", "ملاحظات" });
/*     */ 
/*     */     
/*  72 */     this.NotesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> 
/*  73 */         showDetails(newValue));
/*     */   }
/*     */   
/*     */   private void showDetails(StudentNotes shera2) {
/*  77 */     if (shera2 != null) {
/*  78 */       this.NoteBody.setText(shera2.getNDesc());
/*     */     } else {
/*  80 */       this.NoteBody.setText("");
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleNew() {
/*  86 */     if (!this.NoteBody.getText().equals("")) {
/*  87 */       StudentNotes Temp = new StudentNotes();
/*  88 */       Temp.setNDesc(this.NoteBody.getText());
/*  89 */       Temp.setNDate(Date.valueOf(LocalDate.now()));
/*  90 */       Temp.setSId(current);
/*  91 */       Temp.setNType(this.NoteType.getSelectionModel().getSelectedItem().toString());
/*  92 */       this.SA.PersistNewStudentNote(Temp);
/*     */     } else {
/*  94 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/*  95 */       alert.setTitle("يوجد خطأ");
/*  96 */       alert.setHeaderText("خطأ");
/*  97 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/*  98 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/*  99 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleDelete() {
/* 105 */     int selectedIndex = this.NotesTable.getSelectionModel().getSelectedIndex();
/* 106 */     if (selectedIndex >= 0) {
/*     */       
/* 108 */       this.SA.RemoveStudentNote((StudentNotes)this.NotesTable.getItems().get(selectedIndex));
/* 109 */       this.SA.getStudentNotesList().remove(this.NotesTable.getItems().get(selectedIndex));
/*     */       
/* 111 */       this.NotesTable.setItems(this.SA.getStudentNotesList());
/*     */     }
/*     */     else {
/*     */       
/* 115 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 116 */       alert.setTitle("يوجد خطأ");
/* 117 */       alert.setHeaderText("خطأ");
/* 118 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 119 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 120 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\StudNotesController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */