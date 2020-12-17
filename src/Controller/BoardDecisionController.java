 package Controller;
 
 import Entity.BoardDecisions;
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
 import javafx.scene.control.ComboBox;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 import javafx.scene.control.TextArea;
 import javafx.scene.control.TextField;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class BoardDecisionController
   implements Initializable
 {
   @FXML
   private TextField SearchQuery;
   @FXML
   private TextField Title;
   @FXML
   private TextArea Notes;
   @FXML
   private TableView<BoardDecisions> DecisionsTable;
   @FXML
   private TableColumn<BoardDecisions, String> TitleColumn;
   @FXML
   private TableColumn<BoardDecisions, String> DateColumn;
   @FXML
   private ComboBox ComboSearch;
   Management MA;
   BoardDecisions st;
   
   public void initialize(URL url, ResourceBundle rb) {
/*  61 */     this.MA = new Management();
/*  62 */     this.ComboSearch.getItems().removeAll(this.ComboSearch.getItems());
/*  63 */     this.ComboSearch.getItems().addAll(new Object[] { "العنوان", "التاريخ" });
/*  64 */     this.ComboSearch.getSelectionModel().select(0);
     
/*  66 */     this.DecisionsTable.setItems(Management.getBoardDecisionList());
/*  67 */     this.TitleColumn.setCellValueFactory(cellData -> ((BoardDecisions)cellData.getValue()).TitleProperty());
/*  68 */     this.DateColumn.setCellValueFactory(cellData -> ((BoardDecisions)cellData.getValue()).DDateProperty());
     
/*  70 */     this.DecisionsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> 
/*  71 */         showDetails(newValue));
   }
   
   private void showDetails(BoardDecisions shera2) {
/*  75 */     if (shera2 != null) {
       
/*  77 */       this.Title.setText(shera2.getTitle());
/*  78 */       this.Notes.setText(shera2.getBody());
     } else {
       
/*  81 */       this.Title.setText("");
/*  82 */       this.Notes.setText("");
     } 
   }
   
   @FXML
   public void Search() {
/*  88 */     if (!this.SearchQuery.getText().equals("")) {
/*  89 */       ObservableList<BoardDecisions> TempList = FXCollections.observableArrayList(this.MA.getBoardDecision());
/*  90 */       this.DecisionsTable.getItems().clear();
       
/*  92 */       if (this.ComboSearch.getSelectionModel().isSelected(0)) {
/*  93 */         for (int i = 0; i < TempList.size(); i++) {
/*  94 */           if (!((BoardDecisions)TempList.get(i)).TitleProperty().toString().contains(this.SearchQuery.getText())) {
/*  95 */             TempList.remove(i);
/*  96 */             i--;
           } 
         } 
/*  99 */         this.DecisionsTable.setItems(TempList);
       } else {
/* 101 */         for (int i = 0; i < TempList.size(); i++) {
/* 102 */           if (!((BoardDecisions)TempList.get(i)).DDateProperty().toString().contains(this.SearchQuery.getText())) {
/* 103 */             TempList.remove(i);
/* 104 */             i--;
           } 
         } 
/* 107 */         this.DecisionsTable.setItems(TempList);
       } 
     } else {
/* 110 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 111 */       alert.setTitle("يوجد خطأ");
/* 112 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/* 113 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/* 114 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 115 */       alert.showAndWait();
     } 
   }
 
   
   @FXML
   public void handleNew() {
/* 122 */     if (!this.Title.getText().equals("") && !this.Notes.getText().equals("")) {
/* 123 */       this.st = new BoardDecisions();
/* 124 */       this.st.setTitle(this.Title.getText());
/* 125 */       this.st.setBody(this.Notes.getText());
/* 126 */       this.st.setDDate(Date.valueOf(LocalDate.now()));
/* 127 */       System.out.println("Time " + this.st.getDDate());
/* 128 */       this.MA.PersistDecision(this.st);
/* 129 */       showDetails(null);
     } else {
       
/* 132 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 133 */       alert.setTitle("يوجد خطأ");
/* 134 */       alert.setHeaderText("خطأ");
/* 135 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 136 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 137 */       alert.showAndWait();
     } 
   }
   
   @FXML
   public void handleEdit() {
/* 143 */     if (!this.Title.getText().equals("") && !this.Notes.getText().equals("")) {
/* 144 */       this.st = (BoardDecisions)this.DecisionsTable.getSelectionModel().getSelectedItem();
/* 145 */       this.st.setTitle(this.Title.getText());
/* 146 */       this.st.setBody(this.Notes.getText());
/* 147 */       this.st.setDDate(Date.valueOf(LocalDate.now()));
/* 148 */       this.MA.UpdateDecision(this.st);
     } else {
/* 150 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 151 */       alert.setTitle("يوجد خطأ");
/* 152 */       alert.setHeaderText("خطأ");
/* 153 */       alert.setContentText("برجاء التأكد من صحة البيانات");
/* 154 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 155 */       alert.showAndWait();
     } 
   }
 
   
   @FXML
/* 161 */   public void handleClose() { Management.getDialogStage().close(); }
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\BoardDecisionController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */