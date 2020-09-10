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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class InsuranceController
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
   private TableView<Persons> PayrollTable;
   @FXML
   private TableColumn<Persons, String> NameColumn;
   Management MA;
   Persons st;
   
   public void initialize(URL url, ResourceBundle rb) {
/*  60 */     this.MA = new Management();
     
/*  62 */     if (!this.PayrollTable.getItems().isEmpty()) {
/*  63 */       this.PayrollTable.getItems().clear();
     }
     
/*  66 */     this.PayrollTable.setItems(Management.getEmpList());
/*  67 */     this.NameColumn.setCellValueFactory(cellData -> ((Persons)cellData.getValue()).NameProperty());
   }
   
   @FXML
   public void Search() {
/*  72 */     if (!this.SearchQuery.getText().equals("")) {
/*  73 */       ObservableList<Persons> TempList = FXCollections.observableArrayList(this.MA.getActiveEmp());
/*  74 */       this.PayrollTable.getItems().clear();
/*  75 */       for (int i = 0; i < TempList.size(); i++) {
/*  76 */         if (!((Persons)TempList.get(i)).getName().contains(this.SearchQuery.getText())) {
/*  77 */           TempList.remove(i);
/*  78 */           i--;
         } 
       } 
/*  81 */       this.PayrollTable.setItems(TempList);
     } else {
/*  83 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/*  84 */       alert.setTitle("يوجد خطأ");
/*  85 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/*  86 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/*  87 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/*  88 */       alert.showAndWait();
     } 
   }
   
   public void afterNew() {
/*  93 */     this.PayrollTable.setItems(Management.getEmpList());
/*  94 */     this.Amount.setText("");
/*  95 */     this.EDate.setValue(null);
/*  96 */     this.Notes.setText("");
   }
   
   @FXML
   public void handleNewAbsent() {
/* 101 */     this.st = (Persons)this.PayrollTable.getSelectionModel().getSelectedItem();
/* 102 */     if (this.st != null && this.EDate.getValue() != null && this.Amount
/* 103 */       .getText() != null) {
/* 104 */       if (this.MA.PersistNewInsurance(this.Notes.getText(), this.st, 
/* 105 */           Date.valueOf((LocalDate)this.EDate.getValue()), this.Amount
/* 106 */           .getText())) {
/* 107 */         afterNew();
/* 108 */         Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 109 */         alert.setTitle("تم");
/* 110 */         alert.setHeaderText("تم الحفظ بنجاح");
/* 111 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 112 */         alert.showAndWait();
       } else {
/* 114 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 115 */         alert.setTitle("يوجد خطأ");
/* 116 */         alert.setHeaderText("لم يتم الحفظ");
/* 117 */         alert.setContentText("برجاء الرجوع الى مالك البرنامج");
/* 118 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 119 */         alert.showAndWait();
       }
     
/* 122 */     } else if (this.st == null) {
/* 123 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 124 */       alert.setTitle("يوجد خطأ");
/* 125 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حفظه");
/* 126 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول");
/* 127 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 128 */       alert.showAndWait();
     } else {
/* 130 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 131 */       alert.setTitle("يوجد خطأ");
/* 132 */       alert.setHeaderText("برجاء التأكد من ادخال البيانات المطلوبة");
/* 133 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 134 */       alert.showAndWait();
     } 
   }
 
 
 
   
   @FXML
/* 142 */   public void handleClose() { Management.getDialogStage().close(); }
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\InsuranceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */