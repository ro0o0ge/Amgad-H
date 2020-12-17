 package Controller;
 
 import Entity.Teacher;
 import amgad.h.TeachingStaff;
 import java.net.URL;
 import java.sql.Date;
 import java.time.LocalDate;
 import java.util.ResourceBundle;
 import javafx.beans.value.ObservableValue;
 import javafx.collections.FXCollections;
 import javafx.collections.ObservableList;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.geometry.NodeOrientation;
 import javafx.scene.control.Alert;
 import javafx.scene.control.ComboBox;
 import javafx.scene.control.DatePicker;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 import javafx.scene.control.TextArea;
 import javafx.scene.control.TextField;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class Absent_TeacherController
   implements Initializable
 {
   @FXML
   private TextField SearchQuery;
   @FXML
   private TextField Duration;
   @FXML
   private DatePicker AbsentDate;
   @FXML
   private TextArea Notes;
   @FXML
   private TableView<Teacher> StudentsTable;
   @FXML
   private TableColumn<Teacher, String> NameColumn;
   @FXML
   private ComboBox ComboAbsentType;
   @FXML
   private ComboBox ComboTimeType;
   TeachingStaff MA;
   Teacher st;
   
   public void initialize(URL url, ResourceBundle rb) {
/*  62 */     this.ComboAbsentType.getItems().removeAll(this.ComboAbsentType.getItems());
/*  63 */     this.ComboAbsentType.getItems().addAll(new Object[] { "غياب", "تأخير", "استئذان", "منحة", "سنوية" });
 
 
     
/*  67 */     this.ComboTimeType.getItems().removeAll(this.ComboTimeType.getItems());
/*  68 */     this.ComboTimeType.getItems().addAll(new Object[] { "دقائق", "ايام" });
 
     
/*  71 */     if (!this.StudentsTable.getItems().isEmpty()) {
/*  72 */       this.StudentsTable.getItems().clear();
     }
     
/*  75 */     this.StudentsTable.setItems(TeachingStaff.getPersonsList());
/*  76 */     this.NameColumn.setCellValueFactory(cellData -> ((Teacher)cellData.getValue()).getPId().NameProperty());
     
/*  78 */     this.MA = new TeachingStaff();
   }
   
   @FXML
   public void Search() {
/*  83 */     if (!this.SearchQuery.getText().equals("")) {
/*  84 */       ObservableList<Teacher> TempList = FXCollections.observableArrayList(this.MA.getActiveTeachers());
/*  85 */       this.StudentsTable.getItems().clear();
/*  86 */       for (int i = 0; i < TempList.size(); i++) {
/*  87 */         if (!((Teacher)TempList.get(i)).getPId().getName().contains(this.SearchQuery.getText())) {
/*  88 */           TempList.remove(i);
/*  89 */           i--;
         } 
       } 
/*  92 */       this.StudentsTable.setItems(TempList);
     } else {
/*  94 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/*  95 */       alert.setTitle("يوجد خطأ");
/*  96 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/*  97 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/*  98 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/*  99 */       alert.showAndWait();
     } 
   }
   
   public void afterNew() {
/* 104 */     this.StudentsTable.setItems(TeachingStaff.getPersonsList());
/* 105 */     this.SearchQuery.setText("");
/* 106 */     this.Notes.setText("");
/* 107 */     this.Duration.setText("");
/* 108 */     this.AbsentDate.setValue(null);
   }
   
   @FXML
   public void handleNewAbsent() {
/* 113 */     this.st = (Teacher)this.StudentsTable.getSelectionModel().getSelectedItem();
/* 114 */     if (this.st != null && this.AbsentDate.getValue() != null && this.Duration
/* 115 */       .getText() != null && this.ComboAbsentType.getSelectionModel().getSelectedIndex() != -1 && this.ComboTimeType
/* 116 */       .getSelectionModel().getSelectedIndex() != -1) {
/* 117 */       if (this.MA.PersistNewAbsent(this.Notes.getText(), this.st, 
/* 118 */           Date.valueOf((LocalDate)this.AbsentDate.getValue()), this.ComboAbsentType
/* 119 */           .getSelectionModel().getSelectedItem().toString(), this.ComboTimeType
/* 120 */           .getSelectionModel().getSelectedItem().toString(), this.Duration
/* 121 */           .getText())) {
/* 122 */         afterNew();
/* 123 */         Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 124 */         alert.setTitle("تم");
/* 125 */         alert.setHeaderText("تم الحفظ بنجاح");
/* 126 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 127 */         alert.showAndWait();
       } else {
/* 129 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 130 */         alert.setTitle("يوجد خطأ");
/* 131 */         alert.setHeaderText("لم يتم الحفظ");
/* 132 */         alert.setContentText("برجاء الرجوع الى مالك البرنامج");
/* 133 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 134 */         alert.showAndWait();
       }
     
/* 137 */     } else if (this.st == null) {
/* 138 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 139 */       alert.setTitle("يوجد خطأ");
/* 140 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حفظه");
/* 141 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 142 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 143 */       alert.showAndWait();
     } else {
/* 145 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 146 */       alert.setTitle("يوجد خطأ");
/* 147 */       alert.setHeaderText("برجاء التأكد من ادخال البيانات المطلوبة");
/* 148 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 149 */       alert.showAndWait();
     } 
   }
 
 
 
   
   @FXML
/* 157 */   public void handleClose() { this.MA.getDialogStage().close(); }
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\Absent_TeacherController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */