 package Controller;
 
 import Entity.Student;
 import Entity.StudentExpenses;
 import amgad.h.StudentAffair;
 import java.net.URL;
 import java.sql.Date;
 import java.time.LocalDate;
 import java.util.Calendar;
 import java.util.ResourceBundle;
 import javafx.beans.value.ObservableValue;
 import javafx.collections.FXCollections;
 import javafx.collections.ObservableList;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.geometry.NodeOrientation;
 import javafx.scene.control.Alert;
 import javafx.scene.control.CheckBox;
 import javafx.scene.control.ComboBox;
 import javafx.scene.control.DatePicker;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 import javafx.scene.control.TextArea;
 import javafx.scene.control.TextField;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class StudentExpensesController
   implements Initializable
 {
   @FXML
   private TextField SearchQuery;
   @FXML
   private TextField Amount;
   @FXML
   private TextField RecievedBy;
   @FXML
   private TextArea Notes;
   @FXML
   private DatePicker EDate;
   @FXML
   private CheckBox Recieved;
   @FXML
   private TableView<StudentExpenses> StudentExpensesTable;
   @FXML
   private TableColumn<StudentExpenses, String> RecievedColumn;
   @FXML
   private TableColumn<StudentExpenses, String> AmountColumn;
   @FXML
   private TableColumn<StudentExpenses, String> DateColumn;
   @FXML
   private TableColumn<StudentExpenses, String> TypeColumn;
   @FXML
   private ComboBox ComboType;
   StudentAffair SA;
   StudentExpenses st;
   private static Student current;
   
   public void initialize(URL url, ResourceBundle rb) {
/*  76 */     this.SA = new StudentAffair();
/*  77 */     current = StudentAffair.getEdit();
/*  78 */     this.ComboType.getItems().removeAll(this.ComboType.getItems());
/*  79 */     this.ComboType.getItems().addAll(new Object[] { "رسوم تعليم", "رسوم تعليم قسط أول", "رسوم تعليم قسط ثاني", "رسوم ضافية", "رسوم امتحان", "رسوم نشاط", "كتب وزارية", "كتب اجنبية", "زي", "زي تيشيرت صيفي", "زي تيشيرت شتوي", "زي بنطلون او جيبة", "زي جاكيت", "زي اضافي", "زي اضافي تيشيرت صيفي", "زي اضافي تيشيرت شتوي", "زي اضافي بنطلون او جيبة", "زي اضافي جاكيت", "اعفاء", "باص ترم اول", "باص ترم اول ذهاب", "باص ترم اول عودة ", "باص ترم ثاني", "باص ترم ثاني ذهاب", "باص ترم ثاني عودة " });
 
 
 
 
 
     
/*  86 */     this.StudentExpensesTable.setItems(StudentAffair.getStudentExpensesList());
/*  87 */     this.RecievedColumn.setCellValueFactory(cellData -> ((StudentExpenses)cellData.getValue()).RecievedProperty());
/*  88 */     this.AmountColumn.setCellValueFactory(cellData -> ((StudentExpenses)cellData.getValue()).AmountProperty());
/*  89 */     this.DateColumn.setCellValueFactory(cellData -> ((StudentExpenses)cellData.getValue()).DateProperty());
/*  90 */     this.TypeColumn.setCellValueFactory(cellData -> ((StudentExpenses)cellData.getValue()).TypeProperty());
/*  91 */     this.StudentExpensesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> 
/*  92 */         showDetails(newValue));
   }
 
   
   private void showDetails(StudentExpenses shera2) {
/*  97 */     if (shera2 != null) {
 
       
/* 100 */       this.Amount.setText(String.valueOf(shera2.getAmount()));
/* 101 */       this.RecievedBy.setText(shera2.getSteRecieved());
/* 102 */       this.Notes.setText(shera2.getSteNote());
/* 103 */       Calendar cal = Calendar.getInstance();
/* 104 */       cal.setTime(shera2.getSteDate());
/* 105 */       LocalDate date = LocalDate.of(cal.get(1), cal
/* 106 */           .get(2) + 1, cal.get(5));
/* 107 */       this.EDate.setValue(date);
/* 108 */       this.Recieved.setSelected(shera2.getSteStatus());
/* 109 */       this.ComboType.getSelectionModel().select(shera2.getSteType());
     } else {
/* 111 */       this.Amount.setText("");
/* 112 */       this.RecievedBy.setText("");
/* 113 */       this.Notes.setText("");
/* 114 */       this.EDate.setValue(null);
/* 115 */       this.ComboType.getSelectionModel().clearSelection();
/* 116 */       this.Recieved.setSelected(false);
     } 
   }
   
   @FXML
   public void Search() {
/* 122 */     if (!this.SearchQuery.getText().equals("")) {
/* 123 */       ObservableList<StudentExpenses> TempList = FXCollections.observableArrayList(this.SA.getStudentExpensesList());
/* 124 */       this.StudentExpensesTable.getItems().clear();
       
/* 126 */       for (int i = 0; i < TempList.size(); i++) {
/* 127 */         if (!((StudentExpenses)TempList.get(i)).DateProperty().toString().contains(this.SearchQuery.getText())) {
/* 128 */           TempList.remove(i);
/* 129 */           i--;
         } 
       } 
/* 132 */       this.StudentExpensesTable.setItems(TempList);
     } else {
       
/* 135 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 136 */       alert.setTitle("يوجد خطأ");
/* 137 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/* 138 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/* 139 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 140 */       alert.showAndWait();
     } 
   }
   
   @FXML
   public void handleNew() {
/* 146 */     if (!this.Amount.getText().equals("") && this.ComboType.getSelectionModel().getSelectedIndex() != -1 && this.EDate
/* 147 */       .getValue() != null) {
/* 148 */       this.st = new StudentExpenses();
/* 149 */       this.st.setAmount(Double.valueOf(this.Amount.getText()).doubleValue());
/* 150 */       this.st.setSteNote(this.Notes.getText());
/* 151 */       this.st.setSteRecieved(this.RecievedBy.getText());
/* 152 */       this.st.setSteDate(Date.valueOf((LocalDate)this.EDate.getValue()));
/* 153 */       this.st.setSteType(this.ComboType.getSelectionModel().getSelectedItem().toString());
/* 154 */       this.st.setSteStatus(this.Recieved.isSelected());
/* 155 */       this.st.setSId(current);
/* 156 */       this.SA.PersistStudentExpense(this.st);
/* 157 */       showDetails(null);
/* 158 */       this.StudentExpensesTable.getItems().clear();
/* 159 */       this.StudentExpensesTable.setItems(this.SA.getStudentExpensesList());
     } else {
/* 161 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 162 */       alert.setTitle("يوجد خطأ");
/* 163 */       alert.setHeaderText("خطأ");
/* 164 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 165 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 166 */       alert.showAndWait();
     } 
   }
   
   @FXML
   public void handleEdit() {
/* 172 */     if (!this.Amount.getText().equals("") && this.ComboType.getSelectionModel().getSelectedIndex() != -1 && this.EDate
/* 173 */       .getValue() != null) {
/* 174 */       this.st = (StudentExpenses)this.StudentExpensesTable.getSelectionModel().getSelectedItem();
/* 175 */       this.st.setAmount(Double.valueOf(this.Amount.getText()).doubleValue());
/* 176 */       this.st.setSteNote(this.Notes.getText());
/* 177 */       this.st.setSteRecieved(this.RecievedBy.getText());
/* 178 */       this.st.setSteDate(Date.valueOf((LocalDate)this.EDate.getValue()));
/* 179 */       this.st.setSteType(this.ComboType.getSelectionModel().getSelectedItem().toString());
/* 180 */       this.st.setSteStatus(this.Recieved.isSelected());
/* 181 */       this.SA.UpdateStudentExpense(this.st);
/* 182 */       this.StudentExpensesTable.setItems(StudentAffair.getStudentExpensesList());
     } else {
/* 184 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 185 */       alert.setTitle("يوجد خطأ");
/* 186 */       alert.setHeaderText("خطأ");
/* 187 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 188 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 189 */       alert.showAndWait();
     } 
   }
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\StudentExpensesController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */