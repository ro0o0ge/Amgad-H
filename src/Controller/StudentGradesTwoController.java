/*      */ package Controller;
/*      */ 
/*      */ import Entity.ActualGrades;
/*      */ import Entity.GradeDetail;
/*      */ import Entity.Student;
/*      */ import amgad.h.StudentAffair;
/*      */ import java.net.URL;
/*      */ import java.util.ResourceBundle;
/*      */ import javafx.fxml.FXML;
/*      */ import javafx.fxml.Initializable;
/*      */ import javafx.scene.control.Label;
/*      */ import javafx.scene.control.TextField;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StudentGradesTwoController
/*      */   implements Initializable
/*      */ {
/*      */   @FXML
/*      */   private Label name;
/*      */   @FXML
/*      */   private Label className;
/*      */   @FXML
/*      */   private Label overall;
/*      */   @FXML
/*      */   private TextField serialNo;
/*      */   @FXML
/*      */   private TextField seatingNo;
/*      */   @FXML
/*      */   private TextField obsrNo1;
/*      */   @FXML
/*      */   private TextField obsrNo2;
/*      */   @FXML
/*      */   private TextField Arabic_F_1;
/*      */   @FXML
/*      */   private TextField Arabic_F_2;
/*      */   @FXML
/*      */   private TextField Arabic_F_3;
/*      */   @FXML
/*      */   private TextField Arabic_S_1;
/*      */   @FXML
/*      */   private TextField Arabic_S_2;
/*      */   @FXML
/*      */   private TextField Arabic_S_3;
/*      */   @FXML
/*      */   private TextField Arabic_T_1;
/*      */   @FXML
/*      */   private TextField Arabic_T_2;
/*      */   @FXML
/*      */   private TextField Arabic_T_3;
/*      */   @FXML
/*      */   private TextField Math_F_1;
/*      */   @FXML
/*      */   private TextField Math_F_2;
/*      */   @FXML
/*      */   private TextField Math_F_3;
/*      */   @FXML
/*      */   private TextField Math_S_1;
/*      */   @FXML
/*      */   private TextField Math_S_2;
/*      */   @FXML
/*      */   private TextField Math_S_3;
/*      */   @FXML
/*      */   private TextField Math_T_1;
/*      */   @FXML
/*      */   private TextField Math_T_2;
/*      */   @FXML
/*      */   private TextField Math_T_3;
/*      */   @FXML
/*      */   private TextField English_F_1;
/*      */   @FXML
/*      */   private TextField English_F_2;
/*      */   @FXML
/*      */   private TextField English_F_3;
/*      */   @FXML
/*      */   private TextField English_S_1;
/*      */   @FXML
/*      */   private TextField English_S_2;
/*      */   @FXML
/*      */   private TextField English_S_3;
/*      */   @FXML
/*      */   private TextField English_T_1;
/*      */   @FXML
/*      */   private TextField English_T_2;
/*      */   @FXML
/*      */   private TextField English_T_3;
/*      */   @FXML
/*      */   private TextField Social_F_1;
/*      */   @FXML
/*      */   private TextField Social_F_2;
/*      */   @FXML
/*      */   private TextField Social_F_3;
/*      */   @FXML
/*      */   private TextField Social_S_1;
/*      */   @FXML
/*      */   private TextField Social_S_2;
/*      */   @FXML
/*      */   private TextField Social_S_3;
/*      */   @FXML
/*      */   private TextField Social_T_1;
/*      */   @FXML
/*      */   private TextField Social_T_2;
/*      */   @FXML
/*      */   private TextField Social_T_3;
/*      */   @FXML
/*      */   private TextField Science_F_1;
/*      */   @FXML
/*      */   private TextField Science_F_2;
/*      */   @FXML
/*      */   private TextField Science_F_3;
/*      */   @FXML
/*      */   private TextField Science_F_4;
/*      */   @FXML
/*      */   private TextField Science_S_1;
/*      */   @FXML
/*      */   private TextField Science_S_2;
/*      */   @FXML
/*      */   private TextField Science_S_3;
/*      */   @FXML
/*      */   private TextField Science_S_4;
/*      */   @FXML
/*      */   private TextField Science_T_1;
/*      */   @FXML
/*      */   private TextField Science_T_2;
/*      */   @FXML
/*      */   private TextField Science_T_3;
/*      */   @FXML
/*      */   private TextField Religion_F_1;
/*      */   @FXML
/*      */   private TextField Religion_F_2;
/*      */   @FXML
/*      */   private TextField Religion_F_3;
/*      */   @FXML
/*      */   private TextField Religion_S_1;
/*      */   @FXML
/*      */   private TextField Religion_S_2;
/*      */   @FXML
/*      */   private TextField Religion_S_3;
/*      */   @FXML
/*      */   private TextField Religion_T_1;
/*      */   @FXML
/*      */   private TextField Religion_T_2;
/*      */   @FXML
/*      */   private TextField Religion_T_3;
/*      */   @FXML
/*      */   private TextField French_F_1;
/*      */   @FXML
/*      */   private TextField French_F_2;
/*      */   @FXML
/*      */   private TextField French_F_3;
/*      */   @FXML
/*      */   private TextField French_S_1;
/*      */   @FXML
/*      */   private TextField French_S_2;
/*      */   @FXML
/*      */   private TextField French_S_3;
/*      */   @FXML
/*      */   private TextField French_T_1;
/*      */   @FXML
/*      */   private TextField French_T_2;
/*      */   @FXML
/*      */   private TextField French_T_3;
/*      */   @FXML
/*      */   private TextField Required_F_1;
/*      */   @FXML
/*      */   private TextField Required_F_2;
/*      */   @FXML
/*      */   private TextField Required_F_3;
/*      */   @FXML
/*      */   private TextField Required_S_1;
/*      */   @FXML
/*      */   private TextField Required_S_2;
/*      */   @FXML
/*      */   private TextField Required_S_3;
/*      */   @FXML
/*      */   private TextField Required_TH_1;
/*      */   @FXML
/*      */   private TextField Required_TH_2;
/*      */   @FXML
/*      */   private TextField Required_TH_3;
/*      */   @FXML
/*      */   private TextField Required_T_1;
/*      */   @FXML
/*      */   private TextField Required_T_2;
/*      */   @FXML
/*      */   private TextField Optional_F_1;
/*      */   @FXML
/*      */   private TextField Optional_F_2;
/*      */   @FXML
/*      */   private TextField Optional_F_3;
/*      */   @FXML
/*      */   private TextField Optional_S_1;
/*      */   @FXML
/*      */   private TextField Optional_S_2;
/*      */   @FXML
/*      */   private TextField Optional_S_3;
/*      */   @FXML
/*      */   private TextField Optional_T_1;
/*      */   @FXML
/*      */   private TextField Optional_T_2;
/*      */   private static Student current;
/*      */   StudentAffair SA;
/*      */   

            void fillConstant(){
                    Arabic_F_1.setText("70");
                    Arabic_S_1.setText("70");
                    Math_F_1.setText("70");
                    Math_S_1.setText("70");
                    English_F_1.setText("70");
                    English_S_1.setText("70");
                    Religion_F_1.setText("70");
                    Religion_S_1.setText("70");
                    
                    French_F_1.setText("60");
                    French_S_1.setText("60");
                    
                    Social_F_1.setText("70");
                    Social_S_1.setText("70");  
                    
                    Science_F_1.setText("70");
                    Science_S_1.setText("70");
                    Science_F_4.setText("6");
                    Science_S_4.setText("6");
                    
                    Required_F_1.setText("10");
                    Required_F_2.setText("10");
                    Required_S_1.setText("10");
                    Required_TH_1.setText("10");
                    Required_S_2.setText("10");
                    Optional_F_1.setText("10");
                    Optional_F_2.setText("10");
                    Optional_S_1.setText("10");
                    Optional_S_2.setText("10");
            }


/*      */   public void initialize(URL url, ResourceBundle rb) {
/*  232 */     current = StudentAffair.getEdit();
/*  233 */     this.SA = new StudentAffair();
/*  234 */     this.name.setText(current.getPId().getName());
/*  235 */     if (current.getClassStudentsList() != null) {
/*  236 */       this.className.setText(current.getClassStudentsList().getCId().getClassDesc());
/*      */     }
/*      */     
/*  239 */     this.serialNo.setText(current.getSerialNo());
/*  240 */     this.seatingNo.setText(current.getSeatingNo());
/*  241 */     this.obsrNo1.setText(current.getObserve1());
/*  242 */     this.obsrNo2.setText(current.getObserve2());
/*      */     fillConstant();
/*  244 */     if (current.getActualGradesList() != null) {
/*  245 */       for (ActualGrades a : current.getActualGradesList()) {
/*  246 */         System.out.println("grade detail id " + a.getGdId().getGdId());
/*  247 */         if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 4) {
/*  248 */           switch (a.getGdId().getGdId().intValue()) {
/*      */             case 56:
/*  250 */               this.Arabic_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 57:
/*  253 */               this.Arabic_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 58:
/*  256 */               this.Arabic_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 59:
/*  259 */               this.Arabic_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 38:
/*  263 */               this.Math_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 39:
/*  266 */               this.Math_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 40:
/*  269 */               this.Math_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 41:
/*  272 */               this.Math_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 52:
/*  276 */               this.English_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 53:
/*  279 */               this.English_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 54:
/*  282 */               this.English_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 55:
/*  285 */               this.English_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 42:
/*  289 */               this.Social_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 43:
/*  292 */               this.Social_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 44:
/*  295 */               this.Social_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 45:
/*  298 */               this.Social_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 46:
/*  302 */               this.Science_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 48:
/*  305 */               this.Science_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 47:
/*  308 */               this.Science_F_4.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 49:
/*  311 */               this.Science_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 51:
/*  314 */               this.Science_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 50:
/*  317 */               this.Science_S_4.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 60:
/*  321 */               this.Religion_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 61:
/*  324 */               this.Religion_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 62:
/*  327 */               this.Religion_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 63:
/*  330 */               this.Religion_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 64:
/*  334 */               this.French_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 65:
/*  337 */               this.French_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 66:
/*  340 */               this.French_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 67:
/*  343 */               this.French_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 68:
/*  347 */               this.Required_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 69:
/*  350 */               this.Required_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 70:
/*  353 */               this.Required_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 71:
/*  356 */               this.Required_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 72:
/*  359 */               this.Required_TH_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 73:
/*  362 */               this.Required_TH_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 74:
/*  366 */               this.Optional_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 75:
/*  369 */               this.Optional_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 76:
/*  372 */               this.Optional_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 77:
/*  375 */               this.Optional_S_2.setText(String.valueOf(a.getGrade())); break;
/*      */           }  continue;
/*      */         } 
/*  378 */         if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 5) {
/*  379 */           switch (a.getGdId().getGdId().intValue()) {
/*      */             case 82:
/*  381 */               this.Arabic_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 83:
/*  384 */               this.Arabic_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 84:
/*  387 */               this.Arabic_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 85:
/*  390 */               this.Arabic_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 92:
/*  394 */               this.Math_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 93:
/*  397 */               this.Math_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 94:
/*  400 */               this.Math_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 95:
/*  403 */               this.Math_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 78:
/*  407 */               this.English_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 79:
/*  410 */               this.English_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 80:
/*  413 */               this.English_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 81:
/*  416 */               this.English_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 96:
/*  420 */               this.Social_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 97:
/*  423 */               this.Social_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 98:
/*  426 */               this.Social_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 99:
/*  429 */               this.Social_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 86:
/*  433 */               this.Science_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 88:
/*  436 */               this.Science_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 87:
/*  439 */               this.Science_F_4.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 89:
/*  442 */               this.Science_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 91:
/*  445 */               this.Science_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 90:
/*  448 */               this.Science_S_4.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 100:
/*  452 */               this.Religion_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 101:
/*  455 */               this.Religion_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 102:
/*  458 */               this.Religion_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 103:
/*  461 */               this.Religion_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 104:
/*  465 */               this.French_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 105:
/*  468 */               this.French_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 106:
/*  471 */               this.French_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 107:
/*  474 */               this.French_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 108:
/*  478 */               this.Required_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 109:
/*  481 */               this.Required_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 110:
/*  484 */               this.Required_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 111:
/*  487 */               this.Required_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 112:
/*  490 */               this.Required_TH_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 113:
/*  493 */               this.Required_TH_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 114:
/*  497 */               this.Optional_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 115:
/*  500 */               this.Optional_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 116:
/*  503 */               this.Optional_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 117:
/*  506 */               this.Optional_S_2.setText(String.valueOf(a.getGrade())); break;
/*      */           }  continue;
/*      */         } 
/*  509 */         if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 6) {
/*  510 */           switch (a.getGdId().getGdId().intValue()) {
/*      */             case 122:
/*  512 */               this.Arabic_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 123:
/*  515 */               this.Arabic_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 124:
/*  518 */               this.Arabic_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 125:
/*  521 */               this.Arabic_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 132:
/*  525 */               this.Math_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 133:
/*  528 */               this.Math_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 134:
/*  531 */               this.Math_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 135:
/*  534 */               this.Math_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 118:
/*  538 */               this.English_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 119:
/*  541 */               this.English_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 120:
/*  544 */               this.English_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 121:
/*  547 */               this.English_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 136:
/*  551 */               this.Social_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 137:
/*  554 */               this.Social_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 138:
/*  557 */               this.Social_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 139:
/*  560 */               this.Social_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 126:
/*  564 */               this.Science_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 128:
/*  567 */               this.Science_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 127:
/*  570 */               this.Science_F_4.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 129:
/*  573 */               this.Science_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 131:
/*  576 */               this.Science_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 130:
/*  579 */               this.Science_S_4.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 140:
/*  583 */               this.Religion_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 141:
/*  586 */               this.Religion_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 142:
/*  589 */               this.Religion_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 143:
/*  592 */               this.Religion_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 144:
/*  596 */               this.French_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 145:
/*  599 */               this.French_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 146:
/*  602 */               this.French_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 147:
/*  605 */               this.French_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 148:
/*  609 */               this.Required_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 149:
/*  612 */               this.Required_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 150:
/*  615 */               this.Required_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 151:
/*  618 */               this.Required_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 152:
/*  621 */               this.Required_TH_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 153:
/*  624 */               this.Required_TH_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             
/*      */             case 154:
/*  628 */               this.Optional_F_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 155:
/*  631 */               this.Optional_F_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 156:
/*  634 */               this.Optional_S_1.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */             case 157:
/*  637 */               this.Optional_S_2.setText(String.valueOf(a.getGrade()));
/*      */               break;
/*      */           } 
/*      */         
/*      */         }
/*      */       } 
/*      */     }
/*      */     try {
/*  645 */       if (!this.Arabic_F_1.getText().isEmpty() && !this.Arabic_F_2.getText().isEmpty()) {
/*  646 */         double x = Double.valueOf(this.Arabic_F_1.getText()).doubleValue() + Double.valueOf(this.Arabic_F_2.getText()).doubleValue();
/*  647 */         this.Arabic_F_3.setText(String.valueOf(x));
/*      */       } 
/*  649 */       if (!this.Arabic_S_1.getText().isEmpty() && !this.Arabic_S_2.getText().isEmpty()) {
/*  650 */         double x = Double.valueOf(this.Arabic_S_1.getText()).doubleValue() + Double.valueOf(this.Arabic_S_2.getText()).doubleValue();
/*  651 */         this.Arabic_S_3.setText(String.valueOf(x));
/*      */       } 
/*  653 */       if (!this.Arabic_F_3.getText().isEmpty() && !this.Arabic_S_3.getText().isEmpty()) {
/*  654 */         double x = Double.valueOf(this.Arabic_F_3.getText()).doubleValue() + Double.valueOf(this.Arabic_S_3.getText()).doubleValue();
/*  655 */         this.Arabic_T_1.setText(String.valueOf(x));
/*  656 */         x /= 2.0D;
/*  657 */         this.Arabic_T_2.setText(String.valueOf(x));
/*      */         
/*  659 */         this.Arabic_T_3.setText(gpa(x, 1));
/*      */       } 
/*      */       
/*  662 */       if (!this.Math_F_1.getText().isEmpty() && !this.Math_F_2.getText().isEmpty()) {
/*  663 */         double x = Double.valueOf(this.Math_F_1.getText()).doubleValue() + Double.valueOf(this.Math_F_2.getText()).doubleValue();
/*  664 */         this.Math_F_3.setText(String.valueOf(x));
/*      */       } 
/*  666 */       if (!this.Math_S_1.getText().isEmpty() && !this.Math_S_2.getText().isEmpty()) {
/*  667 */         double x = Double.valueOf(this.Math_S_1.getText()).doubleValue() + Double.valueOf(this.Math_S_2.getText()).doubleValue();
/*  668 */         this.Math_S_3.setText(String.valueOf(x));
/*      */       } 
/*  670 */       if (!this.Math_F_3.getText().isEmpty() && !this.Math_S_3.getText().isEmpty()) {
/*  671 */         double x = Double.valueOf(this.Math_F_3.getText()).doubleValue() + Double.valueOf(this.Math_S_3.getText()).doubleValue();
/*  672 */         this.Math_T_1.setText(String.valueOf(x));
/*  673 */         x /= 2.0D;
/*  674 */         x *= 0.8D;
/*  675 */         this.Math_T_2.setText(String.valueOf(x));
/*      */         
/*  677 */         this.Math_T_3.setText(gpa(x, 3));
/*      */       } 
/*      */       
/*  680 */       if (!this.English_F_1.getText().isEmpty() && !this.English_F_2.getText().isEmpty()) {
/*  681 */         double x = Double.valueOf(this.English_F_1.getText()).doubleValue() + Double.valueOf(this.English_F_2.getText()).doubleValue();
/*  682 */         this.English_F_3.setText(String.valueOf(x));
/*      */       } 
/*  684 */       if (!this.English_S_1.getText().isEmpty() && !this.English_S_2.getText().isEmpty()) {
/*  685 */         double x = Double.valueOf(this.English_S_1.getText()).doubleValue() + Double.valueOf(this.English_S_2.getText()).doubleValue();
/*  686 */         this.English_S_3.setText(String.valueOf(x));
/*      */       } 
/*  688 */       if (!this.English_F_3.getText().isEmpty() && !this.English_S_3.getText().isEmpty()) {
/*  689 */         double x = Double.valueOf(this.English_F_3.getText()).doubleValue() + Double.valueOf(this.English_S_3.getText()).doubleValue();
/*  690 */         this.English_T_1.setText(String.valueOf(x));
/*  691 */         x /= 2.0D;
/*  692 */         x *= 0.4D;
/*  693 */         this.English_T_2.setText(String.valueOf(x));
/*      */         
/*  695 */         this.English_T_3.setText(gpa(x, 2));
/*      */       } 
/*      */       
/*  698 */       if (!this.Social_F_1.getText().isEmpty() && !this.Social_F_2.getText().isEmpty()) {
/*  699 */         double x = Double.valueOf(this.Social_F_1.getText()).doubleValue() + Double.valueOf(this.Social_F_2.getText()).doubleValue();
/*  700 */         this.Social_F_3.setText(String.valueOf(x));
/*      */       } 
/*  702 */       if (!this.Social_S_1.getText().isEmpty() && !this.Social_S_2.getText().isEmpty()) {
/*  703 */         double x = Double.valueOf(this.Social_S_1.getText()).doubleValue() + Double.valueOf(this.Social_S_2.getText()).doubleValue();
/*  704 */         this.Social_S_3.setText(String.valueOf(x));
/*      */       } 
/*  706 */       if (!this.Social_F_3.getText().isEmpty() && !this.Social_S_3.getText().isEmpty()) {
/*  707 */         double x = Double.valueOf(this.Social_F_3.getText()).doubleValue() + Double.valueOf(this.Social_S_3.getText()).doubleValue();
/*  708 */         this.Social_T_1.setText(String.valueOf(x));
/*  709 */         x /= 2.0D;
/*  710 */         x *= 0.4D;
/*  711 */         this.Social_T_2.setText(String.valueOf(x));
/*      */         
/*  713 */         this.Social_T_3.setText(gpa(x, 2));
/*      */       } 
/*      */       
/*  716 */       if (!this.Science_F_1.getText().isEmpty() && !this.Science_F_2.getText().isEmpty() && !this.Science_F_4.getText().isEmpty()) {
/*  717 */         double x = Double.valueOf(this.Science_F_1.getText()).doubleValue() + Double.valueOf(this.Science_F_2.getText()).doubleValue() + Double.valueOf(this.Science_F_4.getText()).doubleValue();
/*  718 */         this.Science_F_3.setText(String.valueOf(x));
/*      */       } 
/*  720 */       if (!this.Science_S_1.getText().isEmpty() && !this.Science_S_2.getText().isEmpty() && !this.Science_S_4.getText().isEmpty()) {
/*  721 */         double x = Double.valueOf(this.Science_S_1.getText()).doubleValue() + Double.valueOf(this.Science_S_2.getText()).doubleValue() + Double.valueOf(this.Science_S_4.getText()).doubleValue();
/*  722 */         this.Science_S_3.setText(String.valueOf(x));
/*      */       } 
/*  724 */       if (!this.Science_F_3.getText().isEmpty() && !this.Science_S_3.getText().isEmpty()) {
/*  725 */         double x = Double.valueOf(this.Science_F_3.getText()).doubleValue() + Double.valueOf(this.Science_S_3.getText()).doubleValue();
/*  726 */         this.Science_T_1.setText(String.valueOf(x));
/*  727 */         x /= 2.0D;
/*  728 */         x *= 0.4D;
/*  729 */         this.Science_T_2.setText(String.valueOf(x));
/*      */         
/*  731 */         this.Science_T_3.setText(gpa(x, 2));
/*      */       } 
/*      */       
/*  734 */       if (!this.Required_F_1.getText().isEmpty() && !this.Required_F_2.getText().isEmpty()) {
/*  735 */         double x = Double.valueOf(this.Required_F_1.getText()).doubleValue() + Double.valueOf(this.Required_F_2.getText()).doubleValue();
/*  736 */         this.Required_F_3.setText(String.valueOf(x));
/*      */       } 
/*  738 */       if (!this.Required_S_1.getText().isEmpty() && !this.Required_S_2.getText().isEmpty()) {
/*  739 */         double x = Double.valueOf(this.Required_S_1.getText()).doubleValue() + Double.valueOf(this.Required_S_2.getText()).doubleValue();
/*  740 */         this.Required_S_3.setText(String.valueOf(x));
/*      */       } 
/*  742 */       if (!this.Required_TH_1.getText().isEmpty() && !this.Required_TH_2.getText().isEmpty()) {
/*  743 */         double x = Double.valueOf(this.Required_TH_1.getText()).doubleValue() + Double.valueOf(this.Required_TH_2.getText()).doubleValue();
/*  744 */         this.Required_TH_3.setText(String.valueOf(x));
/*      */       } 
/*  746 */       if (!this.Required_F_3.getText().isEmpty() && !this.Required_S_3.getText().isEmpty() && !this.Required_TH_3.getText().isEmpty()) {
/*  747 */         double x = Double.valueOf(this.Required_F_3.getText()).doubleValue() + Double.valueOf(this.Required_S_3.getText()).doubleValue() + Double.valueOf(this.Required_TH_3.getText()).doubleValue();
/*      */         
/*  749 */         this.Required_T_1.setText(String.valueOf(x));
/*      */         
/*  751 */         this.Required_T_2.setText(gpa(x, 4));
/*      */       } 
/*      */       
/*  754 */       if (!this.Optional_F_1.getText().isEmpty() && !this.Optional_F_2.getText().isEmpty()) {
/*  755 */         double x = Double.valueOf(this.Optional_F_1.getText()).doubleValue() + Double.valueOf(this.Optional_F_2.getText()).doubleValue();
/*  756 */         this.Optional_F_3.setText(String.valueOf(x));
/*      */       } 
/*  758 */       if (!this.Optional_S_1.getText().isEmpty() && !this.Optional_S_2.getText().isEmpty()) {
/*  759 */         double x = Double.valueOf(this.Optional_S_1.getText()).doubleValue() + Double.valueOf(this.Optional_S_2.getText()).doubleValue();
/*  760 */         this.Optional_S_3.setText(String.valueOf(x));
/*      */       } 
/*  762 */       if (!this.Optional_F_3.getText().isEmpty() && !this.Optional_S_3.getText().isEmpty()) {
/*  763 */         double x = Double.valueOf(this.Optional_F_3.getText()).doubleValue() + Double.valueOf(this.Optional_S_3.getText()).doubleValue();
/*      */         
/*  765 */         this.Optional_T_1.setText(String.valueOf(x));
/*      */         
/*  767 */         this.Optional_T_2.setText(gpa(x, 4));
/*      */       } 
/*      */       
/*  770 */       if (!this.Religion_F_1.getText().isEmpty() && !this.Religion_F_2.getText().isEmpty()) {
/*  771 */         double x = Double.valueOf(this.Religion_F_1.getText()).doubleValue() + Double.valueOf(this.Religion_F_2.getText()).doubleValue();
/*  772 */         this.Religion_F_3.setText(String.valueOf(x));
/*      */       } 
/*  774 */       if (!this.Religion_S_1.getText().isEmpty() && !this.Religion_S_2.getText().isEmpty()) {
/*  775 */         double x = Double.valueOf(this.Religion_S_1.getText()).doubleValue() + Double.valueOf(this.Religion_S_2.getText()).doubleValue();
/*  776 */         this.Religion_S_3.setText(String.valueOf(x));
/*      */       } 
/*  778 */       if (!this.Religion_F_3.getText().isEmpty() && !this.Religion_S_3.getText().isEmpty()) {
/*  779 */         double x = Double.valueOf(this.Religion_F_3.getText()).doubleValue() + Double.valueOf(this.Religion_S_3.getText()).doubleValue();
/*  780 */         this.Religion_T_1.setText(String.valueOf(x));
/*  781 */         x /= 2.0D;
/*  782 */         x *= 0.4D;
/*  783 */         this.Religion_T_2.setText(String.valueOf(x));
/*      */         
/*  785 */         this.Religion_T_3.setText(gpa(x, 2));
/*      */       } 
/*      */       
/*  788 */       if (!this.French_F_1.getText().isEmpty() && !this.French_F_2.getText().isEmpty()) {
/*  789 */         double x = Double.valueOf(this.French_F_1.getText()).doubleValue() + Double.valueOf(this.French_F_2.getText()).doubleValue();
/*  790 */         this.French_F_3.setText(String.valueOf(x));
/*      */       } 
/*  792 */       if (!this.French_S_1.getText().isEmpty() && !this.French_S_2.getText().isEmpty()) {
/*  793 */         double x = Double.valueOf(this.French_S_1.getText()).doubleValue() + Double.valueOf(this.French_S_2.getText()).doubleValue();
/*  794 */         this.French_S_3.setText(String.valueOf(x));
/*      */       } 
/*  796 */       if (!this.French_F_3.getText().isEmpty() && !this.French_S_3.getText().isEmpty()) {
/*  797 */         double x = Double.valueOf(this.French_F_3.getText()).doubleValue() + Double.valueOf(this.French_S_3.getText()).doubleValue();
/*  798 */         this.French_T_1.setText(String.valueOf(x));
/*  799 */         x /= 2.0D;
/*  800 */         x *= 0.4D;
/*  801 */         this.French_T_2.setText(String.valueOf(x));
/*      */         
/*  803 */         this.French_T_3.setText(gpa(x, 2));
/*      */       } 
/*  805 */       if (!this.French_T_2.getText().isEmpty() && !this.Religion_T_2.getText().isEmpty() && 
/*  806 */         !this.English_T_2.getText().isEmpty() && !this.Social_T_2.getText().isEmpty() && 
/*  807 */         !this.Math_T_2.getText().isEmpty() && !this.Arabic_T_2.getText().isEmpty() && 
/*  808 */         !this.Optional_T_1.getText().isEmpty() && !this.Required_T_1.getText().isEmpty() && 
/*  809 */         !this.Science_T_2.getText().isEmpty()) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  814 */         double x = Double.valueOf(this.French_T_2.getText()).doubleValue() + Double.valueOf(this.Religion_T_2.getText()).doubleValue() + Double.valueOf(this.English_T_2.getText()).doubleValue() + Double.valueOf(this.Math_T_2.getText()).doubleValue() + Double.valueOf(this.Arabic_T_2.getText()).doubleValue() + Double.valueOf(this.Optional_T_1.getText()).doubleValue() + Double.valueOf(this.Required_T_1.getText()).doubleValue() + Double.valueOf(this.Social_T_2.getText()).doubleValue() + Double.valueOf(this.Science_T_2.getText()).doubleValue() + Double.valueOf(this.Required_T_1.getText()).doubleValue();
/*  815 */         this.overall.setText(gpa(x, 5));
/*      */       } 
/*  817 */     } catch (Exception e) {
/*  818 */       e.printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   String gpa(double y, int x) {
/*  824 */     switch (x) {
/*      */       case 1:
/*  826 */         if (y >= 85.0D)
/*  827 */           return "م"; 
/*  828 */         if (y < 85.0D && y >= 75.0D)
/*  829 */           return "ج ج"; 
/*  830 */         if (y < 75.0D && y >= 65.0D)
/*  831 */           return "ج"; 
/*  832 */         if (y < 65.0D && y >= 50.0D) {
/*  833 */           return "مق";
/*      */         }
/*  835 */         return "ض";
/*      */       
/*      */       case 2:
/*  838 */         if (y >= 34.0D)
/*  839 */           return "م"; 
/*  840 */         if (y < 34.0D && y >= 30.0D)
/*  841 */           return "ج ج"; 
/*  842 */         if (y < 30.0D && y >= 26.0D)
/*  843 */           return "ج"; 
/*  844 */         if (y < 26.0D && y >= 20.0D) {
/*  845 */           return "مق";
/*      */         }
/*  847 */         return "ض";
/*      */       
/*      */       case 3:
/*  850 */         if (y >= 68.0D)
/*  851 */           return "م"; 
/*  852 */         if (y < 68.0D && y >= 60.0D)
/*  853 */           return "ج ج"; 
/*  854 */         if (y < 60.0D && y >= 52.0D)
/*  855 */           return "ج"; 
/*  856 */         if (y < 52.0D && y >= 40.0D) {
/*  857 */           return "مق";
/*      */         }
/*  859 */         return "ض";
/*      */       
/*      */       case 4:
/*  862 */         if (y >= 17.0D)
/*  863 */           return "م"; 
/*  864 */         if (y < 17.0D && y >= 15.0D)
/*  865 */           return "ج ج"; 
/*  866 */         if (y < 15.0D && y >= 13.0D)
/*  867 */           return "ج"; 
/*  868 */         if (y < 13.0D && y >= 10.0D) {
/*  869 */           return "مق";
/*      */         }
/*  871 */         return "ض";
/*      */       
/*      */       case 5:
/*  874 */         if (y >= 408.0D)
/*  875 */           return "م"; 
/*  876 */         if (y < 408.0D && y >= 360.0D)
/*  877 */           return "ج ج"; 
/*  878 */         if (y < 360.0D && y >= 312.0D)
/*  879 */           return "ج"; 
/*  880 */         if (y < 312.0D && y >= 240.0D) {
/*  881 */           return "مق";
/*      */         }
/*  883 */         return "ض";
/*      */     } 
/*      */     
/*  886 */     return "لم";
/*      */   }
/*      */   
/*      */   @FXML
/*      */   public void handleSave() {
/*  891 */     current.setSerialNo(this.serialNo.getText());
/*  892 */     current.setSeatingNo(this.seatingNo.getText());
/*  893 */     current.setObserve1(this.obsrNo1.getText());
/*  894 */     current.setObserve2(this.obsrNo2.getText());
/*  895 */     this.SA.UpdateStud(current);
/*      */ 
/*      */     
/*  898 */     if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 4) {
/*      */       
/*  900 */       if (!this.Arabic_F_1.getText().isEmpty() && this.Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  901 */         Double.valueOf(this.Arabic_F_1.getText()).doubleValue() <= 70.0D) {
/*  902 */         ActualGrades ag = new ActualGrades();
/*  903 */         ag.setGdId(new GradeDetail(Integer.valueOf(56)));
/*  904 */         ag.setGrade(Double.valueOf(this.Arabic_F_1.getText()).doubleValue());
/*  905 */         ag.setSId(current);
/*  906 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*  908 */       if (!this.Arabic_F_2.getText().isEmpty() && this.Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  909 */         Double.valueOf(this.Arabic_F_2.getText()).doubleValue() <= 30.0D) {
/*  910 */         ActualGrades ag = new ActualGrades();
/*  911 */         ag.setGdId(new GradeDetail(Integer.valueOf(57)));
/*  912 */         ag.setGrade(Double.valueOf(this.Arabic_F_2.getText()).doubleValue());
/*  913 */         ag.setSId(current);
/*  914 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*  916 */       if (!this.Arabic_S_1.getText().isEmpty() && this.Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  917 */         Double.valueOf(this.Arabic_S_1.getText()).doubleValue() <= 70.0D) {
/*  918 */         ActualGrades ag = new ActualGrades();
/*  919 */         ag.setGdId(new GradeDetail(Integer.valueOf(58)));
/*  920 */         ag.setGrade(Double.valueOf(this.Arabic_S_1.getText()).doubleValue());
/*  921 */         ag.setSId(current);
/*  922 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*  924 */       if (!this.Arabic_S_2.getText().isEmpty() && this.Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  925 */         Double.valueOf(this.Arabic_S_2.getText()).doubleValue() <= 30.0D) {
/*  926 */         ActualGrades ag = new ActualGrades();
/*  927 */         ag.setGdId(new GradeDetail(Integer.valueOf(59)));
/*  928 */         ag.setGrade(Double.valueOf(this.Arabic_S_2.getText()).doubleValue());
/*  929 */         ag.setSId(current);
/*  930 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/*  933 */       if (!this.Math_F_1.getText().isEmpty() && this.Math_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  934 */         Double.valueOf(this.Math_F_1.getText()).doubleValue() <= 70.0D) {
/*  935 */         ActualGrades ag = new ActualGrades();
/*  936 */         ag.setGdId(new GradeDetail(Integer.valueOf(38)));
/*  937 */         ag.setGrade(Double.valueOf(this.Math_F_1.getText()).doubleValue());
/*  938 */         ag.setSId(current);
/*  939 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*  941 */       if (!this.Math_F_2.getText().isEmpty() && this.Math_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  942 */         Double.valueOf(this.Math_F_2.getText()).doubleValue() <= 30.0D) {
/*  943 */         ActualGrades ag = new ActualGrades();
/*  944 */         ag.setGdId(new GradeDetail(Integer.valueOf(39)));
/*  945 */         ag.setGrade(Double.valueOf(this.Math_F_2.getText()).doubleValue());
/*  946 */         ag.setSId(current);
/*  947 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*  949 */       if (!this.Math_S_1.getText().isEmpty() && this.Math_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  950 */         Double.valueOf(this.Math_S_1.getText()).doubleValue() <= 70.0D) {
/*  951 */         ActualGrades ag = new ActualGrades();
/*  952 */         ag.setGdId(new GradeDetail(Integer.valueOf(40)));
/*  953 */         ag.setGrade(Double.valueOf(this.Math_S_1.getText()).doubleValue());
/*  954 */         ag.setSId(current);
/*  955 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*  957 */       if (!this.Math_S_2.getText().isEmpty() && this.Math_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  958 */         Double.valueOf(this.Math_S_2.getText()).doubleValue() <= 30.0D) {
/*  959 */         ActualGrades ag = new ActualGrades();
/*  960 */         ag.setGdId(new GradeDetail(Integer.valueOf(41)));
/*  961 */         ag.setGrade(Double.valueOf(this.Math_S_2.getText()).doubleValue());
/*  962 */         ag.setSId(current);
/*  963 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/*  966 */       if (!this.English_F_1.getText().isEmpty() && this.English_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  967 */         Double.valueOf(this.English_F_1.getText()).doubleValue() <= 70.0D) {
/*  968 */         ActualGrades ag = new ActualGrades();
/*  969 */         ag.setGdId(new GradeDetail(Integer.valueOf(52)));
/*  970 */         ag.setGrade(Double.valueOf(this.English_F_1.getText()).doubleValue());
/*  971 */         ag.setSId(current);
/*  972 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*  974 */       if (!this.English_F_2.getText().isEmpty() && this.English_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  975 */         Double.valueOf(this.English_F_2.getText()).doubleValue() <= 30.0D) {
/*  976 */         ActualGrades ag = new ActualGrades();
/*  977 */         ag.setGdId(new GradeDetail(Integer.valueOf(53)));
/*  978 */         ag.setGrade(Double.valueOf(this.English_F_2.getText()).doubleValue());
/*  979 */         ag.setSId(current);
/*  980 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*  982 */       if (!this.English_S_1.getText().isEmpty() && this.English_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  983 */         Double.valueOf(this.English_S_1.getText()).doubleValue() <= 70.0D) {
/*  984 */         ActualGrades ag = new ActualGrades();
/*  985 */         ag.setGdId(new GradeDetail(Integer.valueOf(54)));
/*  986 */         ag.setGrade(Double.valueOf(this.English_S_1.getText()).doubleValue());
/*  987 */         ag.setSId(current);
/*  988 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*  990 */       if (!this.English_S_2.getText().isEmpty() && this.English_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/*  991 */         Double.valueOf(this.English_S_2.getText()).doubleValue() <= 30.0D) {
/*  992 */         ActualGrades ag = new ActualGrades();
/*  993 */         ag.setGdId(new GradeDetail(Integer.valueOf(55)));
/*  994 */         ag.setGrade(Double.valueOf(this.English_S_2.getText()).doubleValue());
/*  995 */         ag.setSId(current);
/*  996 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/*  999 */       if (!this.Social_F_1.getText().isEmpty() && this.Social_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1000 */         Double.valueOf(this.Social_F_1.getText()).doubleValue() <= 70.0D) {
/* 1001 */         ActualGrades ag = new ActualGrades();
/* 1002 */         ag.setGdId(new GradeDetail(Integer.valueOf(42)));
/* 1003 */         ag.setGrade(Double.valueOf(this.Social_F_1.getText()).doubleValue());
/* 1004 */         ag.setSId(current);
/* 1005 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1007 */       if (!this.Social_F_2.getText().isEmpty() && this.Social_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1008 */         Double.valueOf(this.Social_F_2.getText()).doubleValue() <= 30.0D) {
/* 1009 */         ActualGrades ag = new ActualGrades();
/* 1010 */         ag.setGdId(new GradeDetail(Integer.valueOf(43)));
/* 1011 */         ag.setGrade(Double.valueOf(this.Social_F_2.getText()).doubleValue());
/* 1012 */         ag.setSId(current);
/* 1013 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1015 */       if (!this.Social_S_1.getText().isEmpty() && this.Social_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1016 */         Double.valueOf(this.Social_S_1.getText()).doubleValue() <= 70.0D) {
/* 1017 */         ActualGrades ag = new ActualGrades();
/* 1018 */         ag.setGdId(new GradeDetail(Integer.valueOf(44)));
/* 1019 */         ag.setGrade(Double.valueOf(this.Social_S_1.getText()).doubleValue());
/* 1020 */         ag.setSId(current);
/* 1021 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1023 */       if (!this.Social_S_2.getText().isEmpty() && this.Social_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1024 */         Double.valueOf(this.Social_S_2.getText()).doubleValue() <= 30.0D) {
/* 1025 */         ActualGrades ag = new ActualGrades();
/* 1026 */         ag.setGdId(new GradeDetail(Integer.valueOf(45)));
/* 1027 */         ag.setGrade(Double.valueOf(this.Social_S_2.getText()).doubleValue());
/* 1028 */         ag.setSId(current);
/* 1029 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1032 */       if (!this.Science_F_1.getText().isEmpty() && this.Science_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1033 */         Double.valueOf(this.Science_F_1.getText()).doubleValue() <= 70.0D) {
/* 1034 */         ActualGrades ag = new ActualGrades();
/* 1035 */         ag.setGdId(new GradeDetail(Integer.valueOf(46)));
/* 1036 */         ag.setGrade(Double.valueOf(this.Science_F_1.getText()).doubleValue());
/* 1037 */         ag.setSId(current);
/* 1038 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1040 */       if (!this.Science_F_2.getText().isEmpty() && this.Science_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1041 */         Double.valueOf(this.Science_F_2.getText()).doubleValue() <= 24.0D) {
/* 1042 */         ActualGrades ag = new ActualGrades();
/* 1043 */         ag.setGdId(new GradeDetail(Integer.valueOf(48)));
/* 1044 */         ag.setGrade(Double.valueOf(this.Science_F_2.getText()).doubleValue());
/* 1045 */         ag.setSId(current);
/* 1046 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1048 */       if (!this.Science_F_4.getText().isEmpty() && this.Science_F_4.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1049 */         Double.valueOf(this.Science_F_4.getText()).doubleValue() <= 6.0D) {
/* 1050 */         ActualGrades ag = new ActualGrades();
/* 1051 */         ag.setGdId(new GradeDetail(Integer.valueOf(47)));
/* 1052 */         ag.setGrade(Double.valueOf(this.Science_F_4.getText()).doubleValue());
/* 1053 */         ag.setSId(current);
/* 1054 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1056 */       if (!this.Science_S_1.getText().isEmpty() && this.Science_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1057 */         Double.valueOf(this.Science_S_1.getText()).doubleValue() <= 70.0D) {
/* 1058 */         ActualGrades ag = new ActualGrades();
/* 1059 */         ag.setGdId(new GradeDetail(Integer.valueOf(49)));
/* 1060 */         ag.setGrade(Double.valueOf(this.Science_S_1.getText()).doubleValue());
/* 1061 */         ag.setSId(current);
/* 1062 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1064 */       if (!this.Science_S_2.getText().isEmpty() && this.Science_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1065 */         Double.valueOf(this.Science_S_2.getText()).doubleValue() <= 24.0D) {
/* 1066 */         ActualGrades ag = new ActualGrades();
/* 1067 */         ag.setGdId(new GradeDetail(Integer.valueOf(51)));
/* 1068 */         ag.setGrade(Double.valueOf(this.Science_S_2.getText()).doubleValue());
/* 1069 */         ag.setSId(current);
/* 1070 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1072 */       if (!this.Science_S_4.getText().isEmpty() && this.Science_S_4.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1073 */         Double.valueOf(this.Science_S_4.getText()).doubleValue() <= 6.0D) {
/* 1074 */         ActualGrades ag = new ActualGrades();
/* 1075 */         ag.setGdId(new GradeDetail(Integer.valueOf(50)));
/* 1076 */         ag.setGrade(Double.valueOf(this.Science_S_4.getText()).doubleValue());
/* 1077 */         ag.setSId(current);
/* 1078 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1081 */       if (!this.Religion_F_1.getText().isEmpty() && this.Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1082 */         Double.valueOf(this.Religion_F_1.getText()).doubleValue() <= 70.0D) {
/* 1083 */         ActualGrades ag = new ActualGrades();
/* 1084 */         ag.setGdId(new GradeDetail(Integer.valueOf(60)));
/* 1085 */         ag.setGrade(Double.valueOf(this.Religion_F_1.getText()).doubleValue());
/* 1086 */         ag.setSId(current);
/* 1087 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1089 */       if (!this.Religion_F_2.getText().isEmpty() && this.Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1090 */         Double.valueOf(this.Religion_F_2.getText()).doubleValue() <= 30.0D) {
/* 1091 */         ActualGrades ag = new ActualGrades();
/* 1092 */         ag.setGdId(new GradeDetail(Integer.valueOf(61)));
/* 1093 */         ag.setGrade(Double.valueOf(this.Religion_F_2.getText()).doubleValue());
/* 1094 */         ag.setSId(current);
/* 1095 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1097 */       if (!this.Religion_S_1.getText().isEmpty() && this.Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1098 */         Double.valueOf(this.Religion_S_1.getText()).doubleValue() <= 70.0D) {
/* 1099 */         ActualGrades ag = new ActualGrades();
/* 1100 */         ag.setGdId(new GradeDetail(Integer.valueOf(62)));
/* 1101 */         ag.setGrade(Double.valueOf(this.Religion_S_1.getText()).doubleValue());
/* 1102 */         ag.setSId(current);
/* 1103 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1105 */       if (!this.Religion_S_2.getText().isEmpty() && this.Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1106 */         Double.valueOf(this.Religion_S_2.getText()).doubleValue() <= 30.0D) {
/* 1107 */         ActualGrades ag = new ActualGrades();
/* 1108 */         ag.setGdId(new GradeDetail(Integer.valueOf(63)));
/* 1109 */         ag.setGrade(Double.valueOf(this.Religion_S_2.getText()).doubleValue());
/* 1110 */         ag.setSId(current);
/* 1111 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1114 */       if (!this.French_F_1.getText().isEmpty() && this.French_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1115 */         Double.valueOf(this.French_F_1.getText()).doubleValue() <= 60.0D) {
/* 1116 */         ActualGrades ag = new ActualGrades();
/* 1117 */         ag.setGdId(new GradeDetail(Integer.valueOf(64)));
/* 1118 */         ag.setGrade(Double.valueOf(this.French_F_1.getText()).doubleValue());
/* 1119 */         ag.setSId(current);
/* 1120 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1122 */       if (!this.French_F_2.getText().isEmpty() && this.French_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1123 */         Double.valueOf(this.French_F_2.getText()).doubleValue() <= 40.0D) {
/* 1124 */         ActualGrades ag = new ActualGrades();
/* 1125 */         ag.setGdId(new GradeDetail(Integer.valueOf(65)));
/* 1126 */         ag.setGrade(Double.valueOf(this.French_F_2.getText()).doubleValue());
/* 1127 */         ag.setSId(current);
/* 1128 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1130 */       if (!this.French_S_1.getText().isEmpty() && this.French_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1131 */         Double.valueOf(this.French_S_1.getText()).doubleValue() <= 60.0D) {
/* 1132 */         ActualGrades ag = new ActualGrades();
/* 1133 */         ag.setGdId(new GradeDetail(Integer.valueOf(66)));
/* 1134 */         ag.setGrade(Double.valueOf(this.French_S_1.getText()).doubleValue());
/* 1135 */         ag.setSId(current);
/* 1136 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1138 */       if (!this.French_S_2.getText().isEmpty() && this.French_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1139 */         Double.valueOf(this.French_S_2.getText()).doubleValue() <= 40.0D) {
/* 1140 */         ActualGrades ag = new ActualGrades();
/* 1141 */         ag.setGdId(new GradeDetail(Integer.valueOf(67)));
/* 1142 */         ag.setGrade(Double.valueOf(this.French_S_2.getText()).doubleValue());
/* 1143 */         ag.setSId(current);
/* 1144 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1147 */       if (!this.Required_F_1.getText().isEmpty() && this.Required_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1148 */         Double.valueOf(this.Required_F_1.getText()).doubleValue() <= 10.0D) {
/* 1149 */         ActualGrades ag = new ActualGrades();
/* 1150 */         ag.setGdId(new GradeDetail(Integer.valueOf(68)));
/* 1151 */         ag.setGrade(Double.valueOf(this.Required_F_1.getText()).doubleValue());
/* 1152 */         ag.setSId(current);
/* 1153 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1155 */       if (!this.Required_F_2.getText().isEmpty() && this.Required_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1156 */         Double.valueOf(this.Required_F_2.getText()).doubleValue() <= 10.0D) {
/* 1157 */         ActualGrades ag = new ActualGrades();
/* 1158 */         ag.setGdId(new GradeDetail(Integer.valueOf(69)));
/* 1159 */         ag.setGrade(Double.valueOf(this.Required_F_2.getText()).doubleValue());
/* 1160 */         ag.setSId(current);
/* 1161 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1163 */       if (!this.Required_S_1.getText().isEmpty() && this.Required_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1164 */         Double.valueOf(this.Required_S_1.getText()).doubleValue() <= 10.0D) {
/* 1165 */         ActualGrades ag = new ActualGrades();
/* 1166 */         ag.setGdId(new GradeDetail(Integer.valueOf(70)));
/* 1167 */         ag.setGrade(Double.valueOf(this.Required_S_1.getText()).doubleValue());
/* 1168 */         ag.setSId(current);
/* 1169 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1171 */       if (!this.Required_S_2.getText().isEmpty() && this.Required_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1172 */         Double.valueOf(this.Required_S_2.getText()).doubleValue() <= 10.0D) {
/* 1173 */         ActualGrades ag = new ActualGrades();
/* 1174 */         ag.setGdId(new GradeDetail(Integer.valueOf(71)));
/* 1175 */         ag.setGrade(Double.valueOf(this.Required_S_2.getText()).doubleValue());
/* 1176 */         ag.setSId(current);
/* 1177 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1179 */       if (!this.Required_TH_1.getText().isEmpty() && this.Required_TH_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1180 */         Double.valueOf(this.Required_TH_1.getText()).doubleValue() <= 10.0D) {
/* 1181 */         ActualGrades ag = new ActualGrades();
/* 1182 */         ag.setGdId(new GradeDetail(Integer.valueOf(72)));
/* 1183 */         ag.setGrade(Double.valueOf(this.Required_TH_1.getText()).doubleValue());
/* 1184 */         ag.setSId(current);
/* 1185 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1187 */       if (!this.Required_TH_2.getText().isEmpty() && this.Required_TH_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1188 */         Double.valueOf(this.Required_TH_2.getText()).doubleValue() <= 10.0D) {
/* 1189 */         ActualGrades ag = new ActualGrades();
/* 1190 */         ag.setGdId(new GradeDetail(Integer.valueOf(73)));
/* 1191 */         ag.setGrade(Double.valueOf(this.Required_TH_2.getText()).doubleValue());
/* 1192 */         ag.setSId(current);
/* 1193 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1196 */       if (!this.Optional_F_1.getText().isEmpty() && this.Optional_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1197 */         Double.valueOf(this.Optional_F_1.getText()).doubleValue() <= 10.0D) {
/* 1198 */         ActualGrades ag = new ActualGrades();
/* 1199 */         ag.setGdId(new GradeDetail(Integer.valueOf(74)));
/* 1200 */         ag.setGrade(Double.valueOf(this.Optional_F_1.getText()).doubleValue());
/* 1201 */         ag.setSId(current);
/* 1202 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1204 */       if (!this.Optional_F_2.getText().isEmpty() && this.Optional_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1205 */         Double.valueOf(this.Optional_F_2.getText()).doubleValue() <= 10.0D) {
/* 1206 */         ActualGrades ag = new ActualGrades();
/* 1207 */         ag.setGdId(new GradeDetail(Integer.valueOf(75)));
/* 1208 */         ag.setGrade(Double.valueOf(this.Optional_F_2.getText()).doubleValue());
/* 1209 */         ag.setSId(current);
/* 1210 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1212 */       if (!this.Optional_S_1.getText().isEmpty() && this.Optional_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1213 */         Double.valueOf(this.Optional_S_1.getText()).doubleValue() <= 10.0D) {
/* 1214 */         ActualGrades ag = new ActualGrades();
/* 1215 */         ag.setGdId(new GradeDetail(Integer.valueOf(76)));
/* 1216 */         ag.setGrade(Double.valueOf(this.Optional_S_1.getText()).doubleValue());
/* 1217 */         ag.setSId(current);
/* 1218 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1220 */       if (!this.Optional_S_2.getText().isEmpty() && this.Optional_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1221 */         Double.valueOf(this.Optional_S_2.getText()).doubleValue() <= 10.0D) {
/* 1222 */         ActualGrades ag = new ActualGrades();
/* 1223 */         ag.setGdId(new GradeDetail(Integer.valueOf(77)));
/* 1224 */         ag.setGrade(Double.valueOf(this.Optional_S_2.getText()).doubleValue());
/* 1225 */         ag.setSId(current);
/* 1226 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */     } 
/*      */     
/* 1230 */     if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 5) {
/*      */       
/* 1232 */       if (!this.Arabic_F_1.getText().isEmpty() && this.Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1233 */         Double.valueOf(this.Arabic_F_1.getText()).doubleValue() <= 70.0D) {
/* 1234 */         ActualGrades ag = new ActualGrades();
/* 1235 */         ag.setGdId(new GradeDetail(Integer.valueOf(82)));
/* 1236 */         ag.setGrade(Double.valueOf(this.Arabic_F_1.getText()).doubleValue());
/* 1237 */         ag.setSId(current);
/* 1238 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1240 */       if (!this.Arabic_F_2.getText().isEmpty() && this.Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1241 */         Double.valueOf(this.Arabic_F_2.getText()).doubleValue() <= 30.0D) {
/* 1242 */         ActualGrades ag = new ActualGrades();
/* 1243 */         ag.setGdId(new GradeDetail(Integer.valueOf(83)));
/* 1244 */         ag.setGrade(Double.valueOf(this.Arabic_F_2.getText()).doubleValue());
/* 1245 */         ag.setSId(current);
/* 1246 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1248 */       if (!this.Arabic_S_1.getText().isEmpty() && this.Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1249 */         Double.valueOf(this.Arabic_S_1.getText()).doubleValue() <= 70.0D) {
/* 1250 */         ActualGrades ag = new ActualGrades();
/* 1251 */         ag.setGdId(new GradeDetail(Integer.valueOf(84)));
/* 1252 */         ag.setGrade(Double.valueOf(this.Arabic_S_1.getText()).doubleValue());
/* 1253 */         ag.setSId(current);
/* 1254 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1256 */       if (!this.Arabic_S_2.getText().isEmpty() && this.Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1257 */         Double.valueOf(this.Arabic_S_2.getText()).doubleValue() <= 30.0D) {
/* 1258 */         ActualGrades ag = new ActualGrades();
/* 1259 */         ag.setGdId(new GradeDetail(Integer.valueOf(85)));
/* 1260 */         ag.setGrade(Double.valueOf(this.Arabic_S_2.getText()).doubleValue());
/* 1261 */         ag.setSId(current);
/* 1262 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1265 */       if (!this.Math_F_1.getText().isEmpty() && this.Math_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1266 */         Double.valueOf(this.Math_F_1.getText()).doubleValue() <= 70.0D) {
/* 1267 */         ActualGrades ag = new ActualGrades();
/* 1268 */         ag.setGdId(new GradeDetail(Integer.valueOf(92)));
/* 1269 */         ag.setGrade(Double.valueOf(this.Math_F_1.getText()).doubleValue());
/* 1270 */         ag.setSId(current);
/* 1271 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1280 */       if (!this.Math_F_2.getText().isEmpty() && this.Math_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1281 */         Double.valueOf(this.Math_F_2.getText()).doubleValue() <= 30.0D) {
/* 1282 */         ActualGrades ag = new ActualGrades();
/* 1283 */         ag.setGdId(new GradeDetail(Integer.valueOf(93)));
/* 1284 */         ag.setGrade(Double.valueOf(this.Math_F_2.getText()).doubleValue());
/* 1285 */         ag.setSId(current);
/* 1286 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1288 */       if (!this.Math_S_1.getText().isEmpty() && this.Math_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1289 */         Double.valueOf(this.Math_S_1.getText()).doubleValue() <= 70.0D) {
/* 1290 */         ActualGrades ag = new ActualGrades();
/* 1291 */         ag.setGdId(new GradeDetail(Integer.valueOf(94)));
/* 1292 */         ag.setGrade(Double.valueOf(this.Math_S_1.getText()).doubleValue());
/* 1293 */         ag.setSId(current);
/* 1294 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1296 */       if (!this.Math_S_2.getText().isEmpty() && this.Math_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1297 */         Double.valueOf(this.Math_S_2.getText()).doubleValue() <= 30.0D) {
/* 1298 */         ActualGrades ag = new ActualGrades();
/* 1299 */         ag.setGdId(new GradeDetail(Integer.valueOf(95)));
/* 1300 */         ag.setGrade(Double.valueOf(this.Math_S_2.getText()).doubleValue());
/* 1301 */         ag.setSId(current);
/* 1302 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1305 */       if (!this.English_F_1.getText().isEmpty() && this.English_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1306 */         Double.valueOf(this.English_F_1.getText()).doubleValue() <= 70.0D) {
/* 1307 */         ActualGrades ag = new ActualGrades();
/* 1308 */         ag.setGdId(new GradeDetail(Integer.valueOf(78)));
/* 1309 */         ag.setGrade(Double.valueOf(this.English_F_1.getText()).doubleValue());
/* 1310 */         ag.setSId(current);
/* 1311 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1313 */       if (!this.English_F_2.getText().isEmpty() && this.English_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1314 */         Double.valueOf(this.English_F_2.getText()).doubleValue() <= 30.0D) {
/* 1315 */         ActualGrades ag = new ActualGrades();
/* 1316 */         ag.setGdId(new GradeDetail(Integer.valueOf(79)));
/* 1317 */         ag.setGrade(Double.valueOf(this.English_F_2.getText()).doubleValue());
/* 1318 */         ag.setSId(current);
/* 1319 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1321 */       if (!this.English_S_1.getText().isEmpty() && this.English_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1322 */         Double.valueOf(this.English_S_1.getText()).doubleValue() <= 70.0D) {
/* 1323 */         ActualGrades ag = new ActualGrades();
/* 1324 */         ag.setGdId(new GradeDetail(Integer.valueOf(80)));
/* 1325 */         ag.setGrade(Double.valueOf(this.English_S_1.getText()).doubleValue());
/* 1326 */         ag.setSId(current);
/* 1327 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1329 */       if (!this.English_S_2.getText().isEmpty() && this.English_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1330 */         Double.valueOf(this.English_S_2.getText()).doubleValue() <= 30.0D) {
/* 1331 */         ActualGrades ag = new ActualGrades();
/* 1332 */         ag.setGdId(new GradeDetail(Integer.valueOf(81)));
/* 1333 */         ag.setGrade(Double.valueOf(this.English_S_2.getText()).doubleValue());
/* 1334 */         ag.setSId(current);
/* 1335 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1338 */       if (!this.Social_F_1.getText().isEmpty() && this.Social_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1339 */         Double.valueOf(this.Social_F_1.getText()).doubleValue() <= 70.0D) {
/* 1340 */         ActualGrades ag = new ActualGrades();
/* 1341 */         ag.setGdId(new GradeDetail(Integer.valueOf(96)));
/* 1342 */         ag.setGrade(Double.valueOf(this.Social_F_1.getText()).doubleValue());
/* 1343 */         ag.setSId(current);
/* 1344 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1346 */       if (!this.Social_F_2.getText().isEmpty() && this.Social_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1347 */         Double.valueOf(this.Social_F_2.getText()).doubleValue() <= 30.0D) {
/* 1348 */         ActualGrades ag = new ActualGrades();
/* 1349 */         ag.setGdId(new GradeDetail(Integer.valueOf(97)));
/* 1350 */         ag.setGrade(Double.valueOf(this.Social_F_2.getText()).doubleValue());
/* 1351 */         ag.setSId(current);
/* 1352 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1354 */       if (!this.Social_S_1.getText().isEmpty() && this.Social_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1355 */         Double.valueOf(this.Social_S_1.getText()).doubleValue() <= 70.0D) {
/* 1356 */         ActualGrades ag = new ActualGrades();
/* 1357 */         ag.setGdId(new GradeDetail(Integer.valueOf(98)));
/* 1358 */         ag.setGrade(Double.valueOf(this.Social_S_1.getText()).doubleValue());
/* 1359 */         ag.setSId(current);
/* 1360 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1362 */       if (!this.Social_S_2.getText().isEmpty() && this.Social_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1363 */         Double.valueOf(this.Social_S_2.getText()).doubleValue() <= 30.0D) {
/* 1364 */         ActualGrades ag = new ActualGrades();
/* 1365 */         ag.setGdId(new GradeDetail(Integer.valueOf(99)));
/* 1366 */         ag.setGrade(Double.valueOf(this.Social_S_2.getText()).doubleValue());
/* 1367 */         ag.setSId(current);
/* 1368 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1371 */       if (!this.Science_F_1.getText().isEmpty() && this.Science_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1372 */         Double.valueOf(this.Science_F_1.getText()).doubleValue() <= 70.0D) {
/* 1373 */         ActualGrades ag = new ActualGrades();
/* 1374 */         ag.setGdId(new GradeDetail(Integer.valueOf(86)));
/* 1375 */         ag.setGrade(Double.valueOf(this.Science_F_1.getText()).doubleValue());
/* 1376 */         ag.setSId(current);
/* 1377 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1379 */       if (!this.Science_F_2.getText().isEmpty() && this.Science_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1380 */         Double.valueOf(this.Science_F_2.getText()).doubleValue() <= 30.0D) {
/* 1381 */         ActualGrades ag = new ActualGrades();
/* 1382 */         ag.setGdId(new GradeDetail(Integer.valueOf(88)));
/* 1383 */         ag.setGrade(Double.valueOf(this.Science_F_2.getText()).doubleValue());
/* 1384 */         ag.setSId(current);
/* 1385 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1387 */       if (!this.Science_F_4.getText().isEmpty() && this.Science_F_4.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1388 */         Double.valueOf(this.Science_F_4.getText()).doubleValue() <= 30.0D) {
/* 1389 */         ActualGrades ag = new ActualGrades();
/* 1390 */         ag.setGdId(new GradeDetail(Integer.valueOf(87)));
/* 1391 */         ag.setGrade(Double.valueOf(this.Science_F_4.getText()).doubleValue());
/* 1392 */         ag.setSId(current);
/* 1393 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1395 */       if (!this.Science_S_1.getText().isEmpty() && this.Science_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1396 */         Double.valueOf(this.Science_S_1.getText()).doubleValue() <= 70.0D) {
/* 1397 */         ActualGrades ag = new ActualGrades();
/* 1398 */         ag.setGdId(new GradeDetail(Integer.valueOf(89)));
/* 1399 */         ag.setGrade(Double.valueOf(this.Science_S_1.getText()).doubleValue());
/* 1400 */         ag.setSId(current);
/* 1401 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1403 */       if (!this.Science_S_2.getText().isEmpty() && this.Science_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1404 */         Double.valueOf(this.Science_S_2.getText()).doubleValue() <= 30.0D) {
/* 1405 */         ActualGrades ag = new ActualGrades();
/* 1406 */         ag.setGdId(new GradeDetail(Integer.valueOf(91)));
/* 1407 */         ag.setGrade(Double.valueOf(this.Science_S_2.getText()).doubleValue());
/* 1408 */         ag.setSId(current);
/* 1409 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1411 */       if (!this.Science_S_4.getText().isEmpty() && this.Science_S_4.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1412 */         Double.valueOf(this.Science_S_4.getText()).doubleValue() <= 30.0D) {
/* 1413 */         ActualGrades ag = new ActualGrades();
/* 1414 */         ag.setGdId(new GradeDetail(Integer.valueOf(90)));
/* 1415 */         ag.setGrade(Double.valueOf(this.Science_S_4.getText()).doubleValue());
/* 1416 */         ag.setSId(current);
/* 1417 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1420 */       if (!this.Religion_F_1.getText().isEmpty() && this.Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1421 */         Double.valueOf(this.Religion_F_1.getText()).doubleValue() <= 70.0D) {
/* 1422 */         ActualGrades ag = new ActualGrades();
/* 1423 */         ag.setGdId(new GradeDetail(Integer.valueOf(100)));
/* 1424 */         ag.setGrade(Double.valueOf(this.Religion_F_1.getText()).doubleValue());
/* 1425 */         ag.setSId(current);
/* 1426 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1428 */       if (!this.Religion_F_2.getText().isEmpty() && this.Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1429 */         Double.valueOf(this.Religion_F_2.getText()).doubleValue() <= 30.0D) {
/* 1430 */         ActualGrades ag = new ActualGrades();
/* 1431 */         ag.setGdId(new GradeDetail(Integer.valueOf(101)));
/* 1432 */         ag.setGrade(Double.valueOf(this.Religion_F_2.getText()).doubleValue());
/* 1433 */         ag.setSId(current);
/* 1434 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1436 */       if (!this.Religion_S_1.getText().isEmpty() && this.Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1437 */         Double.valueOf(this.Religion_S_1.getText()).doubleValue() <= 70.0D) {
/* 1438 */         ActualGrades ag = new ActualGrades();
/* 1439 */         ag.setGdId(new GradeDetail(Integer.valueOf(102)));
/* 1440 */         ag.setGrade(Double.valueOf(this.Religion_S_1.getText()).doubleValue());
/* 1441 */         ag.setSId(current);
/* 1442 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1444 */       if (!this.Religion_S_2.getText().isEmpty() && this.Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1445 */         Double.valueOf(this.Religion_S_2.getText()).doubleValue() <= 30.0D) {
/* 1446 */         ActualGrades ag = new ActualGrades();
/* 1447 */         ag.setGdId(new GradeDetail(Integer.valueOf(103)));
/* 1448 */         ag.setGrade(Double.valueOf(this.Religion_S_2.getText()).doubleValue());
/* 1449 */         ag.setSId(current);
/* 1450 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1453 */       if (!this.French_F_1.getText().isEmpty() && this.French_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1454 */         Double.valueOf(this.French_F_1.getText()).doubleValue() <= 60.0D) {
/* 1455 */         ActualGrades ag = new ActualGrades();
/* 1456 */         ag.setGdId(new GradeDetail(Integer.valueOf(104)));
/* 1457 */         ag.setGrade(Double.valueOf(this.French_F_1.getText()).doubleValue());
/* 1458 */         ag.setSId(current);
/* 1459 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1461 */       if (!this.French_F_2.getText().isEmpty() && this.French_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1462 */         Double.valueOf(this.French_F_2.getText()).doubleValue() <= 40.0D) {
/* 1463 */         ActualGrades ag = new ActualGrades();
/* 1464 */         ag.setGdId(new GradeDetail(Integer.valueOf(105)));
/* 1465 */         ag.setGrade(Double.valueOf(this.French_F_2.getText()).doubleValue());
/* 1466 */         ag.setSId(current);
/* 1467 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1469 */       if (!this.French_S_1.getText().isEmpty() && this.French_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1470 */         Double.valueOf(this.French_S_1.getText()).doubleValue() <= 60.0D) {
/* 1471 */         ActualGrades ag = new ActualGrades();
/* 1472 */         ag.setGdId(new GradeDetail(Integer.valueOf(106)));
/* 1473 */         ag.setGrade(Double.valueOf(this.French_S_1.getText()).doubleValue());
/* 1474 */         ag.setSId(current);
/* 1475 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1477 */       if (!this.French_S_2.getText().isEmpty() && this.French_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1478 */         Double.valueOf(this.French_S_2.getText()).doubleValue() <= 40.0D) {
/* 1479 */         ActualGrades ag = new ActualGrades();
/* 1480 */         ag.setGdId(new GradeDetail(Integer.valueOf(107)));
/* 1481 */         ag.setGrade(Double.valueOf(this.French_S_2.getText()).doubleValue());
/* 1482 */         ag.setSId(current);
/* 1483 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1486 */       if (!this.Required_F_1.getText().isEmpty() && this.Required_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1487 */         Double.valueOf(this.Required_F_1.getText()).doubleValue() <= 10.0D) {
/* 1488 */         ActualGrades ag = new ActualGrades();
/* 1489 */         ag.setGdId(new GradeDetail(Integer.valueOf(108)));
/* 1490 */         ag.setGrade(Double.valueOf(this.Required_F_1.getText()).doubleValue());
/* 1491 */         ag.setSId(current);
/* 1492 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1494 */       if (!this.Required_F_2.getText().isEmpty() && this.Required_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1495 */         Double.valueOf(this.Required_F_2.getText()).doubleValue() <= 10.0D) {
/* 1496 */         ActualGrades ag = new ActualGrades();
/* 1497 */         ag.setGdId(new GradeDetail(Integer.valueOf(109)));
/* 1498 */         ag.setGrade(Double.valueOf(this.Required_F_2.getText()).doubleValue());
/* 1499 */         ag.setSId(current);
/* 1500 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1502 */       if (!this.Required_S_1.getText().isEmpty() && this.Required_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1503 */         Double.valueOf(this.Required_S_1.getText()).doubleValue() <= 10.0D) {
/* 1504 */         ActualGrades ag = new ActualGrades();
/* 1505 */         ag.setGdId(new GradeDetail(Integer.valueOf(110)));
/* 1506 */         ag.setGrade(Double.valueOf(this.Required_S_1.getText()).doubleValue());
/* 1507 */         ag.setSId(current);
/* 1508 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1510 */       if (!this.Required_S_2.getText().isEmpty() && this.Required_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1511 */         Double.valueOf(this.Required_S_2.getText()).doubleValue() <= 10.0D) {
/* 1512 */         ActualGrades ag = new ActualGrades();
/* 1513 */         ag.setGdId(new GradeDetail(Integer.valueOf(111)));
/* 1514 */         ag.setGrade(Double.valueOf(this.Required_S_2.getText()).doubleValue());
/* 1515 */         ag.setSId(current);
/* 1516 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1518 */       if (!this.Required_TH_1.getText().isEmpty() && this.Required_TH_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1519 */         Double.valueOf(this.Required_TH_1.getText()).doubleValue() <= 10.0D) {
/* 1520 */         ActualGrades ag = new ActualGrades();
/* 1521 */         ag.setGdId(new GradeDetail(Integer.valueOf(112)));
/* 1522 */         ag.setGrade(Double.valueOf(this.Required_TH_1.getText()).doubleValue());
/* 1523 */         ag.setSId(current);
/* 1524 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1526 */       if (!this.Required_TH_2.getText().isEmpty() && this.Required_TH_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1527 */         Double.valueOf(this.Required_TH_2.getText()).doubleValue() <= 10.0D) {
/* 1528 */         ActualGrades ag = new ActualGrades();
/* 1529 */         ag.setGdId(new GradeDetail(Integer.valueOf(113)));
/* 1530 */         ag.setGrade(Double.valueOf(this.Required_TH_2.getText()).doubleValue());
/* 1531 */         ag.setSId(current);
/* 1532 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1535 */       if (!this.Optional_F_1.getText().isEmpty() && this.Optional_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1536 */         Double.valueOf(this.Optional_F_1.getText()).doubleValue() <= 10.0D) {
/* 1537 */         ActualGrades ag = new ActualGrades();
/* 1538 */         ag.setGdId(new GradeDetail(Integer.valueOf(114)));
/* 1539 */         ag.setGrade(Double.valueOf(this.Optional_F_1.getText()).doubleValue());
/* 1540 */         ag.setSId(current);
/* 1541 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1543 */       if (!this.Optional_F_2.getText().isEmpty() && this.Optional_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1544 */         Double.valueOf(this.Optional_F_2.getText()).doubleValue() <= 10.0D) {
/* 1545 */         ActualGrades ag = new ActualGrades();
/* 1546 */         ag.setGdId(new GradeDetail(Integer.valueOf(115)));
/* 1547 */         ag.setGrade(Double.valueOf(this.Optional_F_2.getText()).doubleValue());
/* 1548 */         ag.setSId(current);
/* 1549 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1551 */       if (!this.Optional_S_1.getText().isEmpty() && this.Optional_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1552 */         Double.valueOf(this.Optional_S_1.getText()).doubleValue() <= 10.0D) {
/* 1553 */         ActualGrades ag = new ActualGrades();
/* 1554 */         ag.setGdId(new GradeDetail(Integer.valueOf(116)));
/* 1555 */         ag.setGrade(Double.valueOf(this.Optional_S_1.getText()).doubleValue());
/* 1556 */         ag.setSId(current);
/* 1557 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1559 */       if (!this.Optional_S_2.getText().isEmpty() && this.Optional_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1560 */         Double.valueOf(this.Optional_S_2.getText()).doubleValue() <= 10.0D) {
/* 1561 */         ActualGrades ag = new ActualGrades();
/* 1562 */         ag.setGdId(new GradeDetail(Integer.valueOf(117)));
/* 1563 */         ag.setGrade(Double.valueOf(this.Optional_S_2.getText()).doubleValue());
/* 1564 */         ag.setSId(current);
/* 1565 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */     } 
/*      */     
/* 1569 */     if (current.getClassStudentsList().getCId().getSyId().getSyId().intValue() == 6) {
/*      */       
/* 1571 */       if (!this.Arabic_F_1.getText().isEmpty() && this.Arabic_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1572 */         Double.valueOf(this.Arabic_F_1.getText()).doubleValue() <= 70.0D) {
/* 1573 */         ActualGrades ag = new ActualGrades();
/* 1574 */         ag.setGdId(new GradeDetail(Integer.valueOf(122)));
/* 1575 */         ag.setGrade(Double.valueOf(this.Arabic_F_1.getText()).doubleValue());
/* 1576 */         ag.setSId(current);
/* 1577 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1579 */       if (!this.Arabic_F_2.getText().isEmpty() && this.Arabic_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1580 */         Double.valueOf(this.Arabic_F_2.getText()).doubleValue() <= 30.0D) {
/* 1581 */         ActualGrades ag = new ActualGrades();
/* 1582 */         ag.setGdId(new GradeDetail(Integer.valueOf(123)));
/* 1583 */         ag.setGrade(Double.valueOf(this.Arabic_F_2.getText()).doubleValue());
/* 1584 */         ag.setSId(current);
/* 1585 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1587 */       if (!this.Arabic_S_1.getText().isEmpty() && this.Arabic_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1588 */         Double.valueOf(this.Arabic_S_1.getText()).doubleValue() <= 70.0D) {
/* 1589 */         ActualGrades ag = new ActualGrades();
/* 1590 */         ag.setGdId(new GradeDetail(Integer.valueOf(124)));
/* 1591 */         ag.setGrade(Double.valueOf(this.Arabic_S_1.getText()).doubleValue());
/* 1592 */         ag.setSId(current);
/* 1593 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1595 */       if (!this.Arabic_S_2.getText().isEmpty() && this.Arabic_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1596 */         Double.valueOf(this.Arabic_S_2.getText()).doubleValue() <= 30.0D) {
/* 1597 */         ActualGrades ag = new ActualGrades();
/* 1598 */         ag.setGdId(new GradeDetail(Integer.valueOf(125)));
/* 1599 */         ag.setGrade(Double.valueOf(this.Arabic_S_2.getText()).doubleValue());
/* 1600 */         ag.setSId(current);
/* 1601 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1604 */       if (!this.Math_F_1.getText().isEmpty() && this.Math_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1605 */         Double.valueOf(this.Math_F_1.getText()).doubleValue() <= 70.0D) {
/* 1606 */         ActualGrades ag = new ActualGrades();
/* 1607 */         ag.setGdId(new GradeDetail(Integer.valueOf(132)));
/* 1608 */         ag.setGrade(Double.valueOf(this.Math_F_1.getText()).doubleValue());
/* 1609 */         ag.setSId(current);
/* 1610 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1619 */       if (!this.Math_F_2.getText().isEmpty() && this.Math_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1620 */         Double.valueOf(this.Math_F_2.getText()).doubleValue() <= 30.0D) {
/* 1621 */         ActualGrades ag = new ActualGrades();
/* 1622 */         ag.setGdId(new GradeDetail(Integer.valueOf(133)));
/* 1623 */         ag.setGrade(Double.valueOf(this.Math_F_2.getText()).doubleValue());
/* 1624 */         ag.setSId(current);
/* 1625 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1627 */       if (!this.Math_S_1.getText().isEmpty() && this.Math_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1628 */         Double.valueOf(this.Math_S_1.getText()).doubleValue() <= 70.0D) {
/* 1629 */         ActualGrades ag = new ActualGrades();
/* 1630 */         ag.setGdId(new GradeDetail(Integer.valueOf(134)));
/* 1631 */         ag.setGrade(Double.valueOf(this.Math_S_1.getText()).doubleValue());
/* 1632 */         ag.setSId(current);
/* 1633 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1635 */       if (!this.Math_S_2.getText().isEmpty() && this.Math_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1636 */         Double.valueOf(this.Math_S_2.getText()).doubleValue() <= 30.0D) {
/* 1637 */         ActualGrades ag = new ActualGrades();
/* 1638 */         ag.setGdId(new GradeDetail(Integer.valueOf(135)));
/* 1639 */         ag.setGrade(Double.valueOf(this.Math_S_2.getText()).doubleValue());
/* 1640 */         ag.setSId(current);
/* 1641 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1644 */       if (!this.English_F_1.getText().isEmpty() && this.English_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1645 */         Double.valueOf(this.English_F_1.getText()).doubleValue() <= 70.0D) {
/* 1646 */         ActualGrades ag = new ActualGrades();
/* 1647 */         ag.setGdId(new GradeDetail(Integer.valueOf(118)));
/* 1648 */         ag.setGrade(Double.valueOf(this.English_F_1.getText()).doubleValue());
/* 1649 */         ag.setSId(current);
/* 1650 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1652 */       if (!this.English_F_2.getText().isEmpty() && this.English_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1653 */         Double.valueOf(this.English_F_2.getText()).doubleValue() <= 30.0D) {
/* 1654 */         ActualGrades ag = new ActualGrades();
/* 1655 */         ag.setGdId(new GradeDetail(Integer.valueOf(119)));
/* 1656 */         ag.setGrade(Double.valueOf(this.English_F_2.getText()).doubleValue());
/* 1657 */         ag.setSId(current);
/* 1658 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1660 */       if (!this.English_S_1.getText().isEmpty() && this.English_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1661 */         Double.valueOf(this.English_S_1.getText()).doubleValue() <= 70.0D) {
/* 1662 */         ActualGrades ag = new ActualGrades();
/* 1663 */         ag.setGdId(new GradeDetail(Integer.valueOf(120)));
/* 1664 */         ag.setGrade(Double.valueOf(this.English_S_1.getText()).doubleValue());
/* 1665 */         ag.setSId(current);
/* 1666 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1668 */       if (!this.English_S_2.getText().isEmpty() && this.English_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1669 */         Double.valueOf(this.English_S_2.getText()).doubleValue() <= 30.0D) {
/* 1670 */         ActualGrades ag = new ActualGrades();
/* 1671 */         ag.setGdId(new GradeDetail(Integer.valueOf(121)));
/* 1672 */         ag.setGrade(Double.valueOf(this.English_S_2.getText()).doubleValue());
/* 1673 */         ag.setSId(current);
/* 1674 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1677 */       if (!this.Social_F_1.getText().isEmpty() && this.Social_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1678 */         Double.valueOf(this.Social_F_1.getText()).doubleValue() <= 70.0D) {
/* 1679 */         ActualGrades ag = new ActualGrades();
/* 1680 */         ag.setGdId(new GradeDetail(Integer.valueOf(136)));
/* 1681 */         ag.setGrade(Double.valueOf(this.Social_F_1.getText()).doubleValue());
/* 1682 */         ag.setSId(current);
/* 1683 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1685 */       if (!this.Social_F_2.getText().isEmpty() && this.Social_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1686 */         Double.valueOf(this.Social_F_2.getText()).doubleValue() <= 30.0D) {
/* 1687 */         ActualGrades ag = new ActualGrades();
/* 1688 */         ag.setGdId(new GradeDetail(Integer.valueOf(137)));
/* 1689 */         ag.setGrade(Double.valueOf(this.Social_F_2.getText()).doubleValue());
/* 1690 */         ag.setSId(current);
/* 1691 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1693 */       if (!this.Social_S_1.getText().isEmpty() && this.Social_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1694 */         Double.valueOf(this.Social_S_1.getText()).doubleValue() <= 70.0D) {
/* 1695 */         ActualGrades ag = new ActualGrades();
/* 1696 */         ag.setGdId(new GradeDetail(Integer.valueOf(138)));
/* 1697 */         ag.setGrade(Double.valueOf(this.Social_S_1.getText()).doubleValue());
/* 1698 */         ag.setSId(current);
/* 1699 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1701 */       if (!this.Social_S_2.getText().isEmpty() && this.Social_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1702 */         Double.valueOf(this.Social_S_2.getText()).doubleValue() <= 30.0D) {
/* 1703 */         ActualGrades ag = new ActualGrades();
/* 1704 */         ag.setGdId(new GradeDetail(Integer.valueOf(139)));
/* 1705 */         ag.setGrade(Double.valueOf(this.Social_S_2.getText()).doubleValue());
/* 1706 */         ag.setSId(current);
/* 1707 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1710 */       if (!this.Science_F_1.getText().isEmpty() && this.Science_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1711 */         Double.valueOf(this.Science_F_1.getText()).doubleValue() <= 70.0D) {
/* 1712 */         ActualGrades ag = new ActualGrades();
/* 1713 */         ag.setGdId(new GradeDetail(Integer.valueOf(126)));
/* 1714 */         ag.setGrade(Double.valueOf(this.Science_F_1.getText()).doubleValue());
/* 1715 */         ag.setSId(current);
/* 1716 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1718 */       if (!this.Science_F_2.getText().isEmpty() && this.Science_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1719 */         Double.valueOf(this.Science_F_2.getText()).doubleValue() <= 30.0D) {
/* 1720 */         ActualGrades ag = new ActualGrades();
/* 1721 */         ag.setGdId(new GradeDetail(Integer.valueOf(128)));
/* 1722 */         ag.setGrade(Double.valueOf(this.Science_F_2.getText()).doubleValue());
/* 1723 */         ag.setSId(current);
/* 1724 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1726 */       if (!this.Science_F_4.getText().isEmpty() && this.Science_F_4.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1727 */         Double.valueOf(this.Science_F_4.getText()).doubleValue() <= 30.0D) {
/* 1728 */         ActualGrades ag = new ActualGrades();
/* 1729 */         ag.setGdId(new GradeDetail(Integer.valueOf(127)));
/* 1730 */         ag.setGrade(Double.valueOf(this.Science_F_4.getText()).doubleValue());
/* 1731 */         ag.setSId(current);
/* 1732 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1734 */       if (!this.Science_S_1.getText().isEmpty() && this.Science_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1735 */         Double.valueOf(this.Science_S_1.getText()).doubleValue() <= 70.0D) {
/* 1736 */         ActualGrades ag = new ActualGrades();
/* 1737 */         ag.setGdId(new GradeDetail(Integer.valueOf(129)));
/* 1738 */         ag.setGrade(Double.valueOf(this.Science_S_1.getText()).doubleValue());
/* 1739 */         ag.setSId(current);
/* 1740 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1742 */       if (!this.Science_S_2.getText().isEmpty() && this.Science_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1743 */         Double.valueOf(this.Science_S_2.getText()).doubleValue() <= 30.0D) {
/* 1744 */         ActualGrades ag = new ActualGrades();
/* 1745 */         ag.setGdId(new GradeDetail(Integer.valueOf(131)));
/* 1746 */         ag.setGrade(Double.valueOf(this.Science_S_2.getText()).doubleValue());
/* 1747 */         ag.setSId(current);
/* 1748 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1750 */       if (!this.Science_S_4.getText().isEmpty() && this.Science_S_4.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1751 */         Double.valueOf(this.Science_S_4.getText()).doubleValue() <= 30.0D) {
/* 1752 */         ActualGrades ag = new ActualGrades();
/* 1753 */         ag.setGdId(new GradeDetail(Integer.valueOf(130)));
/* 1754 */         ag.setGrade(Double.valueOf(this.Science_S_4.getText()).doubleValue());
/* 1755 */         ag.setSId(current);
/* 1756 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1759 */       if (!this.Religion_F_1.getText().isEmpty() && this.Religion_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1760 */         Double.valueOf(this.Religion_F_1.getText()).doubleValue() <= 70.0D) {
/* 1761 */         ActualGrades ag = new ActualGrades();
/* 1762 */         ag.setGdId(new GradeDetail(Integer.valueOf(140)));
/* 1763 */         ag.setGrade(Double.valueOf(this.Religion_F_1.getText()).doubleValue());
/* 1764 */         ag.setSId(current);
/* 1765 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1767 */       if (!this.Religion_F_2.getText().isEmpty() && this.Religion_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1768 */         Double.valueOf(this.Religion_F_2.getText()).doubleValue() <= 30.0D) {
/* 1769 */         ActualGrades ag = new ActualGrades();
/* 1770 */         ag.setGdId(new GradeDetail(Integer.valueOf(141)));
/* 1771 */         ag.setGrade(Double.valueOf(this.Religion_F_2.getText()).doubleValue());
/* 1772 */         ag.setSId(current);
/* 1773 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1775 */       if (!this.Religion_S_1.getText().isEmpty() && this.Religion_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1776 */         Double.valueOf(this.Religion_S_1.getText()).doubleValue() <= 70.0D) {
/* 1777 */         ActualGrades ag = new ActualGrades();
/* 1778 */         ag.setGdId(new GradeDetail(Integer.valueOf(142)));
/* 1779 */         ag.setGrade(Double.valueOf(this.Religion_S_1.getText()).doubleValue());
/* 1780 */         ag.setSId(current);
/* 1781 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1783 */       if (!this.Religion_S_2.getText().isEmpty() && this.Religion_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1784 */         Double.valueOf(this.Religion_S_2.getText()).doubleValue() <= 30.0D) {
/* 1785 */         ActualGrades ag = new ActualGrades();
/* 1786 */         ag.setGdId(new GradeDetail(Integer.valueOf(143)));
/* 1787 */         ag.setGrade(Double.valueOf(this.Religion_S_2.getText()).doubleValue());
/* 1788 */         ag.setSId(current);
/* 1789 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1792 */       if (!this.French_F_1.getText().isEmpty() && this.French_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1793 */         Double.valueOf(this.French_F_1.getText()).doubleValue() <= 60.0D) {
/* 1794 */         ActualGrades ag = new ActualGrades();
/* 1795 */         ag.setGdId(new GradeDetail(Integer.valueOf(144)));
/* 1796 */         ag.setGrade(Double.valueOf(this.French_F_1.getText()).doubleValue());
/* 1797 */         ag.setSId(current);
/* 1798 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1800 */       if (!this.French_F_2.getText().isEmpty() && this.French_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1801 */         Double.valueOf(this.French_F_2.getText()).doubleValue() <= 40.0D) {
/* 1802 */         ActualGrades ag = new ActualGrades();
/* 1803 */         ag.setGdId(new GradeDetail(Integer.valueOf(145)));
/* 1804 */         ag.setGrade(Double.valueOf(this.French_F_2.getText()).doubleValue());
/* 1805 */         ag.setSId(current);
/* 1806 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1808 */       if (!this.French_S_1.getText().isEmpty() && this.French_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1809 */         Double.valueOf(this.French_S_1.getText()).doubleValue() <= 60.0D) {
/* 1810 */         ActualGrades ag = new ActualGrades();
/* 1811 */         ag.setGdId(new GradeDetail(Integer.valueOf(146)));
/* 1812 */         ag.setGrade(Double.valueOf(this.French_S_1.getText()).doubleValue());
/* 1813 */         ag.setSId(current);
/* 1814 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1816 */       if (!this.French_S_2.getText().isEmpty() && this.French_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1817 */         Double.valueOf(this.French_S_2.getText()).doubleValue() <= 40.0D) {
/* 1818 */         ActualGrades ag = new ActualGrades();
/* 1819 */         ag.setGdId(new GradeDetail(Integer.valueOf(147)));
/* 1820 */         ag.setGrade(Double.valueOf(this.French_S_2.getText()).doubleValue());
/* 1821 */         ag.setSId(current);
/* 1822 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1825 */       if (!this.Required_F_1.getText().isEmpty() && this.Required_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1826 */         Double.valueOf(this.Required_F_1.getText()).doubleValue() <= 10.0D) {
/* 1827 */         ActualGrades ag = new ActualGrades();
/* 1828 */         ag.setGdId(new GradeDetail(Integer.valueOf(148)));
/* 1829 */         ag.setGrade(Double.valueOf(this.Required_F_1.getText()).doubleValue());
/* 1830 */         ag.setSId(current);
/* 1831 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1833 */       if (!this.Required_F_2.getText().isEmpty() && this.Required_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1834 */         Double.valueOf(this.Required_F_2.getText()).doubleValue() <= 10.0D) {
/* 1835 */         ActualGrades ag = new ActualGrades();
/* 1836 */         ag.setGdId(new GradeDetail(Integer.valueOf(149)));
/* 1837 */         ag.setGrade(Double.valueOf(this.Required_F_2.getText()).doubleValue());
/* 1838 */         ag.setSId(current);
/* 1839 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1841 */       if (!this.Required_S_1.getText().isEmpty() && this.Required_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1842 */         Double.valueOf(this.Required_S_1.getText()).doubleValue() <= 10.0D) {
/* 1843 */         ActualGrades ag = new ActualGrades();
/* 1844 */         ag.setGdId(new GradeDetail(Integer.valueOf(150)));
/* 1845 */         ag.setGrade(Double.valueOf(this.Required_S_1.getText()).doubleValue());
/* 1846 */         ag.setSId(current);
/* 1847 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1849 */       if (!this.Required_S_2.getText().isEmpty() && this.Required_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1850 */         Double.valueOf(this.Required_S_2.getText()).doubleValue() <= 10.0D) {
/* 1851 */         ActualGrades ag = new ActualGrades();
/* 1852 */         ag.setGdId(new GradeDetail(Integer.valueOf(151)));
/* 1853 */         ag.setGrade(Double.valueOf(this.Required_S_2.getText()).doubleValue());
/* 1854 */         ag.setSId(current);
/* 1855 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1857 */       if (!this.Required_TH_1.getText().isEmpty() && this.Required_TH_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1858 */         Double.valueOf(this.Required_TH_1.getText()).doubleValue() <= 10.0D) {
/* 1859 */         ActualGrades ag = new ActualGrades();
/* 1860 */         ag.setGdId(new GradeDetail(Integer.valueOf(152)));
/* 1861 */         ag.setGrade(Double.valueOf(this.Required_TH_1.getText()).doubleValue());
/* 1862 */         ag.setSId(current);
/* 1863 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1865 */       if (!this.Required_TH_2.getText().isEmpty() && this.Required_TH_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1866 */         Double.valueOf(this.Required_TH_2.getText()).doubleValue() <= 10.0D) {
/* 1867 */         ActualGrades ag = new ActualGrades();
/* 1868 */         ag.setGdId(new GradeDetail(Integer.valueOf(153)));
/* 1869 */         ag.setGrade(Double.valueOf(this.Required_TH_2.getText()).doubleValue());
/* 1870 */         ag.setSId(current);
/* 1871 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */       
/* 1874 */       if (!this.Optional_F_1.getText().isEmpty() && this.Optional_F_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1875 */         Double.valueOf(this.Optional_F_1.getText()).doubleValue() <= 10.0D) {
/* 1876 */         ActualGrades ag = new ActualGrades();
/* 1877 */         ag.setGdId(new GradeDetail(Integer.valueOf(154)));
/* 1878 */         ag.setGrade(Double.valueOf(this.Optional_F_1.getText()).doubleValue());
/* 1879 */         ag.setSId(current);
/* 1880 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1882 */       if (!this.Optional_F_2.getText().isEmpty() && this.Optional_F_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1883 */         Double.valueOf(this.Optional_F_2.getText()).doubleValue() <= 10.0D) {
/* 1884 */         ActualGrades ag = new ActualGrades();
/* 1885 */         ag.setGdId(new GradeDetail(Integer.valueOf(155)));
/* 1886 */         ag.setGrade(Double.valueOf(this.Optional_F_2.getText()).doubleValue());
/* 1887 */         ag.setSId(current);
/* 1888 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1890 */       if (!this.Optional_S_1.getText().isEmpty() && this.Optional_S_1.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1891 */         Double.valueOf(this.Optional_S_1.getText()).doubleValue() <= 10.0D) {
/* 1892 */         ActualGrades ag = new ActualGrades();
/* 1893 */         ag.setGdId(new GradeDetail(Integer.valueOf(156)));
/* 1894 */         ag.setGrade(Double.valueOf(this.Optional_S_1.getText()).doubleValue());
/* 1895 */         ag.setSId(current);
/* 1896 */         this.SA.PersistStudControl(ag);
/*      */       } 
/* 1898 */       if (!this.Optional_S_2.getText().isEmpty() && this.Optional_S_2.getText().matches("[0-9]+(\\.[0-9])*") && 
/* 1899 */         Double.valueOf(this.Optional_S_2.getText()).doubleValue() <= 10.0D) {
/* 1900 */         ActualGrades ag = new ActualGrades();
/* 1901 */         ag.setGdId(new GradeDetail(Integer.valueOf(157)));
/* 1902 */         ag.setGrade(Double.valueOf(this.Optional_S_2.getText()).doubleValue());
/* 1903 */         ag.setSId(current);
/* 1904 */         this.SA.PersistStudControl(ag);
/*      */       } 
/*      */     } 
/* 1907 */     StudentAffair.getDialogStage2().close();
/*      */   }
/*      */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\StudentGradesTwoController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */