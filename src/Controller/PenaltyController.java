 package Controller;
 
 import Entity.Persons;
 import amgad.h.Management;
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
 import javafx.scene.control.DatePicker;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 import javafx.scene.control.TextArea;
 import javafx.scene.control.TextField;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class PenaltyController
   implements Initializable
 {
   @FXML
   private TextField SearchQuery;
   @FXML
   private TextField Amount;
   @FXML
   private TextArea Notes;
   @FXML
   private DatePicker EDate;
   @FXML
   private TextField IssuedBy;
   @FXML
   private TableView<Persons> PayrollTable;
   @FXML
   private TableColumn<Persons, String> NameColumn;
   Management MA;
   Persons st;
   
   public void initialize(URL url, ResourceBundle rb) {
/*  62 */     this.MA = new Management();
     
/*  64 */     if (!this.PayrollTable.getItems().isEmpty()) {
/*  65 */       this.PayrollTable.getItems().clear();
     }
     
/*  68 */     this.PayrollTable.setItems(Management.getEmpList());
/*  69 */     this.NameColumn.setCellValueFactory(cellData -> ((Persons)cellData.getValue()).NameProperty());
   }
   
   @FXML
   public void Search() {
/*  74 */     if (!this.SearchQuery.getText().equals("")) {
/*  75 */       ObservableList<Persons> TempList = FXCollections.observableArrayList(this.MA.getActiveEmp());
/*  76 */       this.PayrollTable.getItems().clear();
/*  77 */       for (int i = 0; i < TempList.size(); i++) {
/*  78 */         if (!((Persons)TempList.get(i)).getName().contains(this.SearchQuery.getText())) {
/*  79 */           TempList.remove(i);
/*  80 */           i--;
         } 
       } 
/*  83 */       this.PayrollTable.setItems(TempList);
     } else {
/*  85 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/*  86 */       alert.setTitle("يوجد خطأ");
/*  87 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/*  88 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/*  89 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/*  90 */       alert.showAndWait();
     } 
   }
   
   public void afterNew() {
/*  95 */     this.PayrollTable.setItems(Management.getEmpList());
/*  96 */     this.Amount.setText("");
/*  97 */     this.EDate.setValue(null);
/*  98 */     this.Notes.setText("");
/*  99 */     this.IssuedBy.setText("");
   }
   
   @FXML
   public void handleNewAbsent() {
/* 104 */     this.st = (Persons)this.PayrollTable.getSelectionModel().getSelectedItem();
/* 105 */     if (this.st != null && this.EDate.getValue() != null && this.Amount
/* 106 */       .getText() != null) {
/* 107 */       if (this.MA.PersistNewPenalty(this.Notes.getText(), this.st, 
/* 108 */           Date.valueOf((LocalDate)this.EDate.getValue()), this.Amount
/* 109 */           .getText(), this.IssuedBy
/* 110 */           .getText())) {
/* 111 */         afterNew();
/* 112 */         Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 113 */         alert.setTitle("تم");
/* 114 */         alert.setHeaderText("تم الحفظ بنجاح");
/* 115 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 116 */         alert.showAndWait();
       } else {
/* 118 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 119 */         alert.setTitle("يوجد خطأ");
/* 120 */         alert.setHeaderText("لم يتم الحفظ");
/* 121 */         alert.setContentText("برجاء الرجوع الى مالك البرنامج");
/* 122 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 123 */         alert.showAndWait();
       }
     
/* 126 */     } else if (this.st == null) {
/* 127 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 128 */       alert.setTitle("يوجد خطأ");
/* 129 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حفظه");
/* 130 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 131 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 132 */       alert.showAndWait();
     } else {
/* 134 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 135 */       alert.setTitle("يوجد خطأ");
/* 136 */       alert.setHeaderText("برجاء التأكد من ادخال البيانات المطلوبة");
/* 137 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 138 */       alert.showAndWait();
     } 
   }
 
 
 
   
   @FXML
/* 146 */   public void handleClose() { Management.getDialogStage().close(); }
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\PenaltyController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */