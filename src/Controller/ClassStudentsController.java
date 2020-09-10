 package Controller;
 
 import Entity.ClassStudents;
 import Entity.Classes;
 import Entity.Student;
 import amgad.h.StudentAffair;
 import java.net.URL;
 import java.util.ArrayList;
 import java.util.Iterator;
 import java.util.List;
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
 import javafx.scene.control.TextField;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class ClassStudentsController
   implements Initializable
 {
   @FXML
   private ComboBox ComboClass;
   @FXML
   private TextField SearchQuery;
   @FXML
   private TableView<Student> StudentsTable;
   @FXML
   private TableColumn<Student, String> NameColumn;
   @FXML
   private TableColumn<Student, String> StatusColumn;
   @FXML
   private TableColumn<Student, String> ClassColumn;
   @FXML
   private TableColumn<Student, String> AdmissionDateColumn;
   @FXML
   private TableColumn<Student, String> DOBColumn;
   @FXML
   private TableView<ClassStudents> StudentsInClassTable;
   @FXML
   private TableColumn<ClassStudents, String> StudNameColumn;
   @FXML
   private TableColumn<ClassStudents, String> StudSerialColumn;
   StudentAffair SA;
   
   public void initialize(URL url, ResourceBundle rb) {
/*  70 */     this.SA = new StudentAffair();
/*  71 */     this.ComboClass.getItems().clear();
/*  72 */     this.ComboClass.getItems().addAll(getClasses());
/*  73 */     this.ComboClass.valueProperty().addListener((ov, oldValue, newValue) -> {
/*  74 */           this.SA.LoadStudentsInClass(newValue.toString());
/*  75 */           this.StudentsInClassTable.setItems(this.SA.getStudentsInClassList());
         });
     
/*  78 */     if (!this.StudentsTable.getItems().isEmpty()) {
/*  79 */       this.StudentsTable.getItems().clear();
     }
     
/*  82 */     this.StudentsTable.setItems(StudentAffair.getPersonsList());
/*  83 */     this.NameColumn.setCellValueFactory(cellData -> ((Student)cellData.getValue()).getPId().NameProperty());
/*  84 */     this.DOBColumn.setCellValueFactory(cellData -> ((Student)cellData.getValue()).getPId().DOBProperty());
/*  85 */     this.AdmissionDateColumn.setCellValueFactory(cellData -> ((Student)cellData.getValue()).getPId().createdDateProperty());
/*  86 */     this.StatusColumn.setCellValueFactory(cellData -> ((Student)cellData.getValue()).statusProperty());
/*  87 */     this.ClassColumn.setCellValueFactory(cellData -> {
/*  88 */           if (((Student)cellData.getValue()).getClassStudentsList() != null) {
/*  89 */             return ((Student)cellData.getValue()).getClassStudentsList().getCId().ClassDescProperty();
           }
/*  91 */           return null;
         });
 
     
/*  95 */     this.StudNameColumn.setCellValueFactory(cellData -> ((ClassStudents)cellData.getValue()).getSId().getPId().NameProperty());
/*  96 */     this.StudSerialColumn.setCellValueFactory(cellData -> ((ClassStudents)cellData.getValue()).getSId().serialProperty());
   }
   
   private List<String> getClasses() {
/* 100 */     this.SA = new StudentAffair();
/* 101 */     List<String> StudY = new ArrayList<String>();
/* 102 */     for (Iterator<Classes> iterator = this.SA.getClasses().iterator(); iterator.hasNext();) {
/* 103 */       StudY.add(((Classes)iterator.next()).getClassDesc());
     }
/* 105 */     return StudY;
   }
   
   @FXML
   public void Search() {
/* 110 */     if (!this.SearchQuery.getText().equals("")) {
/* 111 */       ObservableList<Student> TempList = FXCollections.observableArrayList(this.SA.getStudents(2));
/* 112 */       this.StudentsTable.getItems().clear();
/* 113 */       for (int i = 0; i < TempList.size(); i++) {
/* 114 */         if (!((Student)TempList.get(i)).getPId().getName().contains(this.SearchQuery.getText())) {
/* 115 */           TempList.remove(i);
/* 116 */           i--;
         } 
       } 
/* 119 */       this.StudentsTable.setItems(TempList);
     } else {
/* 121 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 122 */       alert.setTitle("يوجد خطأ");
/* 123 */       alert.setHeaderText("لاتترك صندوق البحث فارغ");
/* 124 */       alert.setContentText("برجاء التأكد من الكتابة قبل الضغط على ابحث");
/* 125 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 126 */       alert.showAndWait();
     } 
   }
   
   @FXML
   public void handleAdd() {
/* 132 */     int selectedIndex = this.StudentsTable.getSelectionModel().getSelectedIndex();
/* 133 */     if (selectedIndex >= 0) {
/* 134 */       ClassStudents cs = new ClassStudents();
/* 135 */       cs.setCId(this.SA.getClassesByDesc(this.ComboClass.getSelectionModel().getSelectedItem().toString()));
/* 136 */       cs.setSId((Student)this.StudentsTable.getItems().get(selectedIndex));
/* 137 */       this.SA.PersistNewClassStudent(cs);
       
/* 139 */       this.StudentsTable.setItems(StudentAffair.getPersonsList());
/* 140 */       this.SA.LoadStudentsInClass(this.ComboClass.getSelectionModel().getSelectedItem().toString());
/* 141 */       this.StudentsInClassTable.setItems(this.SA.getStudentsInClassList());
     } else {
/* 143 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 144 */       alert.setTitle("يوجد خطأ");
/* 145 */       alert.setHeaderText("لم يتم تحديد العنصر المراد إضافته");
/* 146 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول بالأسفل");
/* 147 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 148 */       alert.showAndWait();
     } 
   }
   
   @FXML
   public void handleDel() {
/* 154 */     int selectedIndex = this.StudentsInClassTable.getSelectionModel().getSelectedIndex();
/* 155 */     if (selectedIndex >= 0) {
       
/* 157 */       this.SA.RemoveClassStudent((ClassStudents)this.StudentsInClassTable.getItems().get(selectedIndex));
/* 158 */       this.SA.getStudentsInClassList().remove(this.StudentsInClassTable.getItems().get(selectedIndex));
       
/* 160 */       this.StudentsTable.setItems(StudentAffair.getPersonsList());
/* 161 */       this.SA.LoadStudentsInClass(this.ComboClass.getSelectionModel().getSelectedItem().toString());
/* 162 */       this.StudentsInClassTable.setItems(this.SA.getStudentsInClassList());
     } else {
/* 164 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 165 */       alert.setTitle("يوجد خطأ");
/* 166 */       alert.setHeaderText("لم يتم تحديد العنصر المراد حذفه");
/* 167 */       alert.setContentText("من فضلك قم بتحديد العنصر من الجدول الجانبي");
/* 168 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 169 */       alert.showAndWait();
     } 
   }
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\ClassStudentsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */