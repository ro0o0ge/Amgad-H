/*     */ package Controller;
/*     */ 
/*     */ import Entity.SchoolExpenses;
/*     */ import Entity.Student;
/*     */ import amgad.h.Management;
/*     */ import java.net.URL;
/*     */ import java.sql.Date;
/*     */ import java.time.LocalDate;
/*     */ import java.util.Calendar;
/*     */ import java.util.ResourceBundle;
/*     */ import javafx.beans.value.ObservableValue;
/*     */ import javafx.collections.FXCollections;
/*     */ import javafx.collections.ObservableList;
/*     */ import javafx.fxml.FXML;
/*     */ import javafx.fxml.Initializable;
/*     */ import javafx.geometry.NodeOrientation;
/*     */ import javafx.scene.control.Alert;
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
/*     */ public class EditSchoolExpensesController
/*     */   implements Initializable
/*     */ {
/*     */   @FXML
/*     */   private TextField SearchQuery;
/*     */   @FXML
/*     */   private TextField Amount;
/*     */   @FXML
/*     */   private TextField ExenseTo;
/*     */   @FXML
/*     */   private DatePicker EDate;
/*     */   @FXML
/*     */   private TextField ExenseBy;
/*     */   @FXML
/*     */   private TextArea Notes;
/*     */   @FXML
/*     */   private TableView<SchoolExpenses> SchoolExpensesTable;
/*     */   @FXML
/*     */   private TableColumn<SchoolExpenses, String> ToColumn;
/*     */   @FXML
/*     */   private TableColumn<SchoolExpenses, String> ByColumn;
/*     */   @FXML
/*     */   private TableColumn<SchoolExpenses, String> DateColumn;
/*     */   @FXML
/*     */   private TableColumn<SchoolExpenses, String> AmountColumn;
/*     */   @FXML
/*     */   private TableColumn<SchoolExpenses, String> NotesColumn;
/*     */   @FXML
/*     */   private ComboBox ComboSearch;
/*     */   @FXML
/*     */   private ComboBox ComboType;
/*     */   Management MA;
/*     */   SchoolExpenses st;
/*     */   private static Student current;
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/*  79 */     this.ComboSearch.getItems().removeAll(this.ComboSearch.getItems());
/*  80 */     this.ComboSearch.getItems().addAll(new Object[] { "جهة الصرف", "التاريخ" });
/*     */     
/*  82 */     this.ComboType.getItems().removeAll(this.ComboType.getItems());
/*  83 */     this.ComboType.getItems().addAll(new Object[] { "فواتير مياه", "فواتير كهرباء", "فواتير تليفون", "سباكة", "نجارة", "كهرباء", "حدادة", "الوميتال", "ادوات نظافة", "مصاريف متنوعة", "تفويل باص 7215", "تفويل باص 7214", "تفويل باص 7234", "تفويل باص 9538", "صيانة باص 7215", "صيانة باص 7214", "صيانة باص 7234", "صيانة باص 9538" });
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
/*  95 */     this.MA = new Management();
/*  96 */     this.ComboSearch.getSelectionModel().select(0);
/*     */     
/*  98 */     this.SchoolExpensesTable.setItems(Management.getSchoolExpensesList());
/*  99 */     this.ToColumn.setCellValueFactory(cellData -> ((SchoolExpenses)cellData.getValue()).IssuedToProperty());
/* 100 */     this.ByColumn.setCellValueFactory(cellData -> ((SchoolExpenses)cellData.getValue()).IssuedByProperty());
/* 101 */     this.DateColumn.setCellValueFactory(cellData -> ((SchoolExpenses)cellData.getValue()).DDateProperty());
/* 102 */     this.AmountColumn.setCellValueFactory(cellData -> ((SchoolExpenses)cellData.getValue()).AmountProperty());
/* 103 */     this.NotesColumn.setCellValueFactory(cellData -> ((SchoolExpenses)cellData.getValue()).NotesProperty());
/*     */     
/* 105 */     this.SchoolExpensesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> 
/* 106 */         showDetails(newValue));
/*     */   }
/*     */   
/*     */   private void showDetails(SchoolExpenses shera2) {
/* 110 */     if (shera2 != null) {
/*     */ 
/*     */       
/* 113 */       this.Amount.setText(String.valueOf(shera2.getAmount()));
/* 114 */       this.ExenseTo.setText(shera2.getIssuedTo());
/* 115 */       Calendar cal = Calendar.getInstance();
/* 116 */       cal.setTime(shera2.getSceDate());
/* 117 */       LocalDate date = LocalDate.of(cal.get(1), cal
/* 118 */           .get(2) + 1, cal.get(5));
/* 119 */       this.EDate.setValue(date);
/* 120 */       this.ExenseBy.setText(shera2.getIssuedBy());
/* 121 */       this.Notes.setText(shera2.getNotes());
/* 122 */       this.ComboType.getSelectionModel().select(shera2.getSceType());
/*     */     } else {
/* 124 */       this.Amount.setText("");
/* 125 */       this.ExenseTo.setText("");
/* 126 */       this.ExenseBy.setText("");
/* 127 */       this.Notes.setText("");
/* 128 */       this.EDate.setValue(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void Search() {
/* 134 */     if (!this.SearchQuery.getText().equals("")) {
/* 135 */       ObservableList<SchoolExpenses> TempList = FXCollections.observableArrayList(this.MA.getSchoolExpenses());
/* 136 */       this.SchoolExpensesTable.getItems().clear();
/*     */       
/* 138 */       if (this.ComboSearch.getSelectionModel().isSelected(0)) {
/* 139 */         for (int i = 0; i < TempList.size(); i++) {
/* 140 */           if (!((SchoolExpenses)TempList.get(i)).IssuedToProperty().toString().contains(this.SearchQuery.getText())) {
/* 141 */             TempList.remove(i);
/* 142 */             i--;
/*     */           } 
/*     */         } 
/* 145 */         this.SchoolExpensesTable.setItems(TempList);
/*     */       } else {
/* 147 */         for (int i = 0; i < TempList.size(); i++) {
/* 148 */           if (!((SchoolExpenses)TempList.get(i)).DDateProperty().toString().contains(this.SearchQuery.getText())) {
/* 149 */             TempList.remove(i);
/* 150 */             i--;
/*     */           } 
/*     */         } 
/* 153 */         this.SchoolExpensesTable.setItems(TempList);
/*     */       } 
/*     */     } else {
/* 156 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 157 */       alert.setTitle("يوجد خطأ");
/* 158 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/* 159 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/* 160 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 161 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   public void handleNew() {
/* 168 */     if (!this.Amount.getText().equals("") && !this.ExenseBy.getText().equals("") && this.EDate
/* 169 */       .getValue() != null && !this.ExenseTo.getText().equals("")) {
/* 170 */       this.st = new SchoolExpenses();
/* 171 */       this.st.setAmount(Double.valueOf(this.Amount.getText()).doubleValue());
/* 172 */       this.st.setIssuedBy(this.ExenseBy.getText());
/* 173 */       this.st.setIssuedTo(this.ExenseTo.getText());
/* 174 */       this.st.setSceDate(Date.valueOf((LocalDate)this.EDate.getValue()));
/* 175 */       this.st.setNotes(this.Notes.getText());
/* 176 */       this.st.setSceType(this.ComboType.getSelectionModel().getSelectedItem().toString());
/* 177 */       this.MA.PersistSchoolExpense(this.st);
/* 178 */       showDetails(null);
/*     */     } else {
/* 180 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 181 */       alert.setTitle("يوجد خطأ");
/* 182 */       alert.setHeaderText("خطأ");
/* 183 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 184 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 185 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   @FXML
/*     */   public void handleEdit() {
/* 191 */     if (!this.Amount.getText().equals("") && !this.ExenseBy.getText().equals("") && this.EDate
/* 192 */       .getValue() != null && !this.ExenseTo.getText().equals("")) {
/* 193 */       this.st = (SchoolExpenses)this.SchoolExpensesTable.getSelectionModel().getSelectedItem();
/* 194 */       this.st.setAmount(Double.valueOf(this.Amount.getText()).doubleValue());
/* 195 */       this.st.setIssuedBy(this.ExenseBy.getText());
/* 196 */       this.st.setIssuedTo(this.ExenseTo.getText());
/* 197 */       this.st.setNotes(this.Notes.getText());
/* 198 */       this.st.setSceDate(Date.valueOf((LocalDate)this.EDate.getValue()));
/* 199 */       this.st.setSceType(this.ComboType.getSelectionModel().getSelectedItem().toString());
/* 200 */       this.MA.UpdateSchoolExpense(this.st);
/* 201 */       showDetails(null);
/*     */     } else {
/* 203 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 204 */       alert.setTitle("يوجد خطأ");
/* 205 */       alert.setHeaderText("خطأ");
/* 206 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 207 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 208 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EditSchoolExpensesController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */