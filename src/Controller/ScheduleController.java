 package Controller;
 
 import Entity.Classes;
 import Entity.LectureDatetime;
 import Entity.Schedule;
 import Entity.Teacher;
 import amgad.h.TeachingStaff;
 import java.net.URL;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.ResourceBundle;
 import javafx.beans.value.ObservableValue;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.geometry.NodeOrientation;
 import javafx.scene.control.Alert;
 import javafx.scene.control.ComboBox;
 import javafx.scene.control.TextField;
 
 
 
 
 
 
 
 
 
 
 
 
 public class ScheduleController
   implements Initializable
 {
   @FXML
   private TextField Sun1;
   @FXML
   private TextField Sun2;
   @FXML
   private TextField Sun3;
   @FXML
   private TextField Sun4;
   @FXML
   private TextField Sun5;
   @FXML
   private TextField Sun6;
   @FXML
   private TextField Sun7;
   @FXML
   private TextField Mon1;
   @FXML
   private TextField Mon2;
   @FXML
   private TextField Mon3;
   @FXML
   private TextField Mon4;
   @FXML
   private TextField Mon5;
   @FXML
   private TextField Mon6;
   @FXML
   private TextField Mon7;
   @FXML
   private TextField Tue1;
   @FXML
   private TextField Tue2;
   @FXML
   private TextField Tue3;
   @FXML
   private TextField Tue4;
   @FXML
   private TextField Tue5;
   @FXML
   private TextField Tue6;
   @FXML
   private TextField Tue7;
   @FXML
   private TextField Wed1;
   @FXML
   private TextField Wed2;
   @FXML
   private TextField Wed3;
   @FXML
   private TextField Wed4;
   @FXML
   private TextField Wed5;
   @FXML
   private TextField Wed6;
   @FXML
   private TextField Wed7;
   @FXML
   private TextField Thu1;
   @FXML
   private TextField Thu2;
   @FXML
   private TextField Thu3;
   @FXML
   private TextField Thu4;
   @FXML
   private TextField Thu5;
   @FXML
   private TextField Thu6;
   @FXML
   private TextField Thu7;
   @FXML
   private ComboBox comboClass;
   @FXML
   private ComboBox TSun1;
   @FXML
   private ComboBox TSun2;
   @FXML
   private ComboBox TSun3;
   @FXML
   private ComboBox TSun4;
   @FXML
   private ComboBox TSun5;
   @FXML
   private ComboBox TSun6;
   @FXML
   private ComboBox TSun7;
   @FXML
   private ComboBox TMon1;
   @FXML
   private ComboBox TMon2;
   @FXML
   private ComboBox TMon3;
   @FXML
   private ComboBox TMon4;
   @FXML
   private ComboBox TMon5;
   @FXML
   private ComboBox TMon6;
   @FXML
   private ComboBox TMon7;
   @FXML
   private ComboBox TTue1;
   @FXML
   private ComboBox TTue2;
   @FXML
   private ComboBox TTue3;
   @FXML
   private ComboBox TTue4;
   @FXML
   private ComboBox TTue5;
   @FXML
   private ComboBox TTue6;
   @FXML
   private ComboBox TTue7;
   @FXML
   private ComboBox TWed1;
   @FXML
   private ComboBox TWed2;
   @FXML
   private ComboBox TWed3;
   @FXML
   private ComboBox TWed4;
   @FXML
   private ComboBox TWed5;
   @FXML
   private ComboBox TWed6;
   @FXML
   private ComboBox TWed7;
   @FXML
   private ComboBox TThu1;
   @FXML
   private ComboBox TThu2;
   @FXML
   private ComboBox TThu3;
   @FXML
   private ComboBox TThu4;
   @FXML
   private ComboBox TThu5;
   @FXML
   private ComboBox TThu6;
   @FXML
   private ComboBox TThu7;
   TeachingStaff MA;
   Schedule sc;
   Classes c;
   List<LectureDatetime> lecList;
/* 180 */   int tempcheck = 0;
 
 
 
 
 
 
 
 
   
   public void initialize(URL url, ResourceBundle rb) {
     try {
/* 192 */       this.MA = new TeachingStaff();
/* 193 */       this.comboClass.getItems().addAll(getClasses());
       
/* 195 */       this.comboClass.valueProperty().addListener((ov, oldValue, newValue) -> {
/* 196 */             List<Schedule> s = this.MA.getSchedulebyClassDesc(newValue.toString());
/* 197 */             List<String> Ts = this.MA.getClassTeachers(newValue.toString());
/* 198 */             if (Ts.size() > 0 && s.isEmpty()) {
/* 199 */               this.tempcheck = 1;
/* 200 */               this.TSun1.getItems().setAll(Ts);
/* 201 */               this.TSun2.getItems().setAll(Ts);
/* 202 */               this.TSun3.getItems().setAll(Ts);
/* 203 */               this.TSun4.getItems().setAll(Ts);
/* 204 */               this.TSun5.getItems().setAll(Ts);
/* 205 */               this.TMon1.getItems().setAll(Ts);
/* 206 */               this.TMon2.getItems().setAll(Ts);
/* 207 */               this.TMon3.getItems().setAll(Ts);
/* 208 */               this.TMon4.getItems().setAll(Ts);
/* 209 */               this.TMon5.getItems().setAll(Ts);
/* 210 */               this.TTue1.getItems().setAll(Ts);
/* 211 */               this.TTue2.getItems().setAll(Ts);
/* 212 */               this.TTue3.getItems().setAll(Ts);
/* 213 */               this.TTue4.getItems().setAll(Ts);
/* 214 */               this.TTue5.getItems().setAll(Ts);
/* 215 */               this.TWed1.getItems().setAll(Ts);
/* 216 */               this.TWed2.getItems().setAll(Ts);
/* 217 */               this.TWed3.getItems().setAll(Ts);
/* 218 */               this.TWed4.getItems().setAll(Ts);
/* 219 */               this.TWed5.getItems().setAll(Ts);
/* 220 */               this.TThu1.getItems().setAll(Ts);
/* 221 */               this.TThu2.getItems().setAll(Ts);
/* 222 */               this.TThu3.getItems().setAll(Ts);
/* 223 */               this.TThu4.getItems().setAll(Ts);
/* 224 */               this.TThu5.getItems().setAll(Ts);
/* 225 */             } else if (this.tempcheck == 1) {
/* 226 */               this.TSun1.getItems().clear();
/* 227 */               this.TSun2.getItems().clear();
/* 228 */               this.TSun3.getItems().clear();
/* 229 */               this.TSun4.getItems().clear();
/* 230 */               this.TSun5.getItems().clear();
/* 231 */               this.TMon1.getItems().clear();
/* 232 */               this.TMon2.getItems().clear();
/* 233 */               this.TMon3.getItems().clear();
/* 234 */               this.TMon4.getItems().clear();
/* 235 */               this.TMon5.getItems().clear();
/* 236 */               this.TTue1.getItems().clear();
/* 237 */               this.TTue2.getItems().clear();
/* 238 */               this.TTue3.getItems().clear();
/* 239 */               this.TTue4.getItems().clear();
/* 240 */               this.TTue5.getItems().clear();
/* 241 */               this.TWed1.getItems().clear();
/* 242 */               this.TWed2.getItems().clear();
/* 243 */               this.TWed3.getItems().clear();
/* 244 */               this.TWed4.getItems().clear();
/* 245 */               this.TWed5.getItems().clear();
/* 246 */               this.TThu1.getItems().clear();
/* 247 */               this.TThu2.getItems().clear();
/* 248 */               this.TThu3.getItems().clear();
/* 249 */               this.TThu4.getItems().clear();
/* 250 */               this.TThu5.getItems().clear();
             } 
             
/* 253 */             if (s.size() < 1) {
/* 254 */               this.Sun1.setText("");
/* 255 */               this.Sun2.setText("");
/* 256 */               this.Sun3.setText("");
/* 257 */               this.Sun4.setText("");
/* 258 */               this.Sun5.setText("");
/* 259 */               this.Mon1.setText("");
/* 260 */               this.Mon2.setText("");
/* 261 */               this.Mon3.setText("");
/* 262 */               this.Mon4.setText("");
/* 263 */               this.Mon5.setText("");
/* 264 */               this.Tue1.setText("");
/* 265 */               this.Tue2.setText("");
/* 266 */               this.Tue3.setText("");
/* 267 */               this.Tue4.setText("");
/* 268 */               this.Tue5.setText("");
/* 269 */               this.Wed1.setText("");
/* 270 */               this.Wed2.setText("");
/* 271 */               this.Wed3.setText("");
/* 272 */               this.Wed4.setText("");
/* 273 */               this.Wed5.setText("");
/* 274 */               this.Thu1.setText("");
/* 275 */               this.Thu2.setText("");
/* 276 */               this.Thu3.setText("");
/* 277 */               this.Thu4.setText("");
/* 278 */               this.Thu5.setText("");
             } else {
/* 280 */               this.Sun1.setText(((Schedule)s.get(0)).getSuId());
/* 281 */               this.Sun2.setText(((Schedule)s.get(1)).getSuId());
/* 282 */               this.Sun3.setText(((Schedule)s.get(2)).getSuId());
/* 283 */               this.Sun4.setText(((Schedule)s.get(3)).getSuId());
/* 284 */               this.Sun5.setText(((Schedule)s.get(4)).getSuId());
/* 285 */               this.Mon1.setText(((Schedule)s.get(7)).getSuId());
/* 286 */               this.Mon2.setText(((Schedule)s.get(8)).getSuId());
/* 287 */               this.Mon3.setText(((Schedule)s.get(9)).getSuId());
/* 288 */               this.Mon4.setText(((Schedule)s.get(10)).getSuId());
/* 289 */               this.Mon5.setText(((Schedule)s.get(11)).getSuId());
/* 290 */               this.Tue1.setText(((Schedule)s.get(14)).getSuId());
/* 291 */               this.Tue2.setText(((Schedule)s.get(15)).getSuId());
/* 292 */               this.Tue3.setText(((Schedule)s.get(16)).getSuId());
/* 293 */               this.Tue4.setText(((Schedule)s.get(17)).getSuId());
/* 294 */               this.Tue5.setText(((Schedule)s.get(18)).getSuId());
/* 295 */               this.Wed1.setText(((Schedule)s.get(21)).getSuId());
/* 296 */               this.Wed2.setText(((Schedule)s.get(22)).getSuId());
/* 297 */               this.Wed3.setText(((Schedule)s.get(23)).getSuId());
/* 298 */               this.Wed4.setText(((Schedule)s.get(24)).getSuId());
/* 299 */               this.Wed5.setText(((Schedule)s.get(25)).getSuId());
/* 300 */               this.Thu1.setText(((Schedule)s.get(28)).getSuId());
/* 301 */               this.Thu2.setText(((Schedule)s.get(29)).getSuId());
/* 302 */               this.Thu3.setText(((Schedule)s.get(30)).getSuId());
/* 303 */               this.Thu4.setText(((Schedule)s.get(31)).getSuId());
/* 304 */               this.Thu5.setText(((Schedule)s.get(32)).getSuId());
               
/* 306 */               this.TSun1.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(0)).getTId().getTId().intValue()));
/* 307 */               this.TSun2.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(1)).getTId().getTId().intValue()));
/* 308 */               this.TSun3.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(2)).getTId().getTId().intValue()));
/* 309 */               this.TSun4.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(3)).getTId().getTId().intValue()));
/* 310 */               this.TSun5.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(4)).getTId().getTId().intValue()));
/* 311 */               this.TMon1.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(7)).getTId().getTId().intValue()));
/* 312 */               this.TMon2.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(8)).getTId().getTId().intValue()));
/* 313 */               this.TMon3.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(9)).getTId().getTId().intValue()));
/* 314 */               this.TMon4.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(10)).getTId().getTId().intValue()));
/* 315 */               this.TMon5.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(11)).getTId().getTId().intValue()));
/* 316 */               this.TTue1.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(14)).getTId().getTId().intValue()));
/* 317 */               this.TTue2.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(15)).getTId().getTId().intValue()));
/* 318 */               this.TTue3.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(16)).getTId().getTId().intValue()));
/* 319 */               this.TTue4.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(17)).getTId().getTId().intValue()));
/* 320 */               this.TTue5.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(18)).getTId().getTId().intValue()));
/* 321 */               this.TWed1.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(21)).getTId().getTId().intValue()));
/* 322 */               this.TWed2.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(22)).getTId().getTId().intValue()));
/* 323 */               this.TWed3.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(23)).getTId().getTId().intValue()));
/* 324 */               this.TWed4.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(24)).getTId().getTId().intValue()));
/* 325 */               this.TWed5.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(25)).getTId().getTId().intValue()));
/* 326 */               this.TThu1.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(28)).getTId().getTId().intValue()));
/* 327 */               this.TThu2.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(29)).getTId().getTId().intValue()));
/* 328 */               this.TThu3.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(30)).getTId().getTId().intValue()));
/* 329 */               this.TThu4.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(31)).getTId().getTId().intValue()));
/* 330 */               this.TThu5.setValue(this.MA.getTeacherNameByID(((Schedule)s.get(32)).getTId().getTId().intValue()));
             } 
           });
/* 333 */     } catch (Exception e) {
/* 334 */       System.err.println("Table not full : " + e);
/* 335 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
     } 
   }
   
   private List<String> getClasses() {
/* 340 */     List<String> StudY = new ArrayList<String>();
/* 341 */     for (Classes sy : this.MA.getClasses()) {
/* 342 */       StudY.add(sy.getClassDesc());
     }
/* 344 */     return StudY;
   }
   
   public void createNew(String s, LectureDatetime ldt, Teacher tId) {
/* 348 */     this.sc.setCId(this.c);
/* 349 */     this.sc.setLecId(ldt);
/* 350 */     this.sc.setSuId(s);
/* 351 */     this.sc.setTId(tId);
/* 352 */     this.MA.PersistNewSchedule(this.sc);
   }
 
   
   @FXML
   public void Save() {
     try {
/* 359 */       if (!this.comboClass.getValue().equals("")) {
/* 360 */         this.sc = new Schedule();
/* 361 */         this.c = this.MA.getClassesByDesc(this.comboClass.getValue().toString());
/* 362 */         this.lecList = this.MA.getLectures();
         
/* 364 */         createNew(this.Sun1.getText(), (LectureDatetime)this.lecList.get(0), this.MA
/* 365 */             .getTeacherByName(this.TSun1.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 366 */         this.sc = new Schedule();
/* 367 */         createNew(this.Sun2.getText(), (LectureDatetime)this.lecList.get(1), this.MA
/* 368 */             .getTeacherByName(this.TSun2.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 369 */         this.sc = new Schedule();
/* 370 */         createNew(this.Sun3.getText(), (LectureDatetime)this.lecList.get(2), this.MA
/* 371 */             .getTeacherByName(this.TSun3.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 372 */         this.sc = new Schedule();
/* 373 */         createNew(this.Sun4.getText(), (LectureDatetime)this.lecList.get(3), this.MA
/* 374 */             .getTeacherByName(this.TSun4.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 375 */         this.sc = new Schedule();
/* 376 */         createNew(this.Sun5.getText(), (LectureDatetime)this.lecList.get(4), this.MA
/* 377 */             .getTeacherByName(this.TSun5.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
 
 
 
 
 
         
/* 384 */         this.sc = new Schedule();
/* 385 */         createNew(this.Mon1.getText(), (LectureDatetime)this.lecList.get(5), this.MA
/* 386 */             .getTeacherByName(this.TMon1.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 387 */         this.sc = new Schedule();
/* 388 */         createNew(this.Mon2.getText(), (LectureDatetime)this.lecList.get(6), this.MA
/* 389 */             .getTeacherByName(this.TMon2.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 390 */         this.sc = new Schedule();
/* 391 */         createNew(this.Mon3.getText(), (LectureDatetime)this.lecList.get(7), this.MA
/* 392 */             .getTeacherByName(this.TMon3.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 393 */         this.sc = new Schedule();
/* 394 */         createNew(this.Mon4.getText(), (LectureDatetime)this.lecList.get(8), this.MA
/* 395 */             .getTeacherByName(this.TMon4.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 396 */         this.sc = new Schedule();
/* 397 */         createNew(this.Mon5.getText(), (LectureDatetime)this.lecList.get(9), this.MA
/* 398 */             .getTeacherByName(this.TMon5.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
 
 
 
 
 
         
/* 405 */         this.sc = new Schedule();
/* 406 */         createNew(this.Tue1.getText(), (LectureDatetime)this.lecList.get(10), this.MA
/* 407 */             .getTeacherByName(this.TTue1.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 408 */         this.sc = new Schedule();
/* 409 */         createNew(this.Tue2.getText(), (LectureDatetime)this.lecList.get(11), this.MA
/* 410 */             .getTeacherByName(this.TTue2.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 411 */         this.sc = new Schedule();
/* 412 */         createNew(this.Tue3.getText(), (LectureDatetime)this.lecList.get(12), this.MA
/* 413 */             .getTeacherByName(this.TTue3.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 414 */         this.sc = new Schedule();
/* 415 */         createNew(this.Tue4.getText(), (LectureDatetime)this.lecList.get(13), this.MA
/* 416 */             .getTeacherByName(this.TTue4.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 417 */         this.sc = new Schedule();
/* 418 */         createNew(this.Tue5.getText(), (LectureDatetime)this.lecList.get(14), this.MA
/* 419 */             .getTeacherByName(this.TTue5.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
 
 
 
 
 
         
/* 426 */         this.sc = new Schedule();
/* 427 */         createNew(this.Wed1.getText(), (LectureDatetime)this.lecList.get(15), this.MA
/* 428 */             .getTeacherByName(this.TWed1.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 429 */         this.sc = new Schedule();
/* 430 */         createNew(this.Wed2.getText(), (LectureDatetime)this.lecList.get(16), this.MA
/* 431 */             .getTeacherByName(this.TWed2.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 432 */         this.sc = new Schedule();
/* 433 */         createNew(this.Wed3.getText(), (LectureDatetime)this.lecList.get(17), this.MA
/* 434 */             .getTeacherByName(this.TWed3.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 435 */         this.sc = new Schedule();
/* 436 */         createNew(this.Wed4.getText(), (LectureDatetime)this.lecList.get(18), this.MA
/* 437 */             .getTeacherByName(this.TWed4.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 438 */         this.sc = new Schedule();
/* 439 */         createNew(this.Wed5.getText(), (LectureDatetime)this.lecList.get(19), this.MA
/* 440 */             .getTeacherByName(this.TWed5.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
 
 
 
 
 
         
/* 447 */         this.sc = new Schedule();
/* 448 */         createNew(this.Thu1.getText(), (LectureDatetime)this.lecList.get(20), this.MA
/* 449 */             .getTeacherByName(this.TThu1.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 450 */         this.sc = new Schedule();
/* 451 */         createNew(this.Thu2.getText(), (LectureDatetime)this.lecList.get(21), this.MA
/* 452 */             .getTeacherByName(this.TThu2.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 453 */         this.sc = new Schedule();
/* 454 */         createNew(this.Thu3.getText(), (LectureDatetime)this.lecList.get(22), this.MA
/* 455 */             .getTeacherByName(this.TThu3.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 456 */         this.sc = new Schedule();
/* 457 */         createNew(this.Thu4.getText(), (LectureDatetime)this.lecList.get(23), this.MA
/* 458 */             .getTeacherByName(this.TThu4.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
/* 459 */         this.sc = new Schedule();
/* 460 */         createNew(this.Thu5.getText(), (LectureDatetime)this.lecList.get(24), this.MA
/* 461 */             .getTeacherByName(this.TThu5.getSelectionModel().getSelectedItem().toString(), this.c.getClassDesc()));
 
 
       
       }
       else {
 
 
         
/* 470 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 471 */         alert.setTitle("يوجد خطأ");
/* 472 */         alert.setHeaderText("خطأ");
/* 473 */         alert.setContentText("برجاء التأكد من البيانات");
/* 474 */         alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 475 */         alert.showAndWait();
       } 
/* 477 */     } catch (Exception e) {
/* 478 */       System.err.println("Table not full : " + e);
/* 479 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
     } 
   }
 
   
   @FXML
/* 485 */   public void Cancel() { this.MA.getDialogStage2().close(); }
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\ScheduleController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */