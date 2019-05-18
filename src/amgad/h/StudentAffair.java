/*     */ package amgad.h;
/*     */ 
/*     */ import Entity.ActualGrades;
/*     */ import Entity.ClassStudents;
/*     */ import Entity.Classes;
/*     */ import Entity.Contacts;
/*     */ import Entity.Persons;
/*     */ import Entity.Student;
/*     */ import Entity.StudentAttendance;
/*     */ import Entity.StudentExpenses;
/*     */ import Entity.StudentNotes;
/*     */ import Entity.StudyYears;
/*     */ import Entity.UserLog;
/*     */ import Util.HibernateUtil;
/*     */ import Util.LoginSec;
/*     */ import java.io.IOException;
///*     */ import java.sql.Date;
/*     */ import java.sql.Timestamp;
/*     */ import java.time.LocalDate;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javafx.collections.FXCollections;
/*     */ import javafx.collections.ObservableList;
/*     */ import javafx.fxml.FXMLLoader;
/*     */ import javafx.geometry.NodeOrientation;
/*     */ import javafx.scene.Scene;
/*     */ import javafx.scene.control.Alert;
/*     */ import javafx.scene.image.Image;
/*     */ import javafx.scene.layout.AnchorPane;
/*     */ import javafx.stage.Modality;
/*     */ import javafx.stage.Stage;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.SQLQuery;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.Transaction;
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
/*     */ public class StudentAffair
/*     */ {
/*     */   private root MainApp;
/*     */   private static Stage dialogStage;
/*     */   private static Stage dialogStage2;
/*     */   private static Contacts C;
/*     */   UserLog ul;
/*     */   StudentAttendance suA;
/*  55 */   SessionFactory sf = HibernateUtil.getSessionFactory();
/*     */   
/*     */   Session s;
/*     */   
/*     */   static Student edit;
/*     */   
/*     */   static StudentAttendance editStatus;
/*  62 */   ObservableList<Contacts> ContactsList = FXCollections.observableArrayList();
/*     */ 
/*     */   
/*  65 */   public ObservableList<Contacts> getContactsList() { return this.ContactsList; }
/*     */ 
/*     */   
/*  68 */   static ObservableList<Student> PersonsList = FXCollections.observableArrayList();
/*     */ 
/*     */   
/*  71 */   public static ObservableList<Student> getPersonsList() { return PersonsList; }
/*     */ 
/*     */   
/*  74 */   static ObservableList<ClassStudents> StudentsInClassList = FXCollections.observableArrayList();
/*     */ 
/*     */   
/*  77 */   public static ObservableList<ClassStudents> getStudentsInClassList() { return StudentsInClassList; }
/*     */ 
/*     */   
/*  80 */   static ObservableList<StudentNotes> StudentNotesList = FXCollections.observableArrayList();
/*     */ 
/*     */   
/*  83 */   public static ObservableList<StudentNotes> getStudentNotesList() { return StudentNotesList; }
/*     */ 
/*     */   
/*  86 */   static ObservableList<StudentExpenses> StudentExpensesList = FXCollections.observableArrayList();
/*     */ 
/*     */   
/*  89 */   public static ObservableList<StudentExpenses> getStudentExpensesList() { return StudentExpensesList; }
/*     */ 
/*     */ 
/*     */   
/*  93 */   public static void setC(Contacts con) { C = con; }
/*     */ 
/*     */ 
/*     */   
/*  97 */   public static Contacts getContacts() { return C; }
/*     */ 
/*     */   
/*     */   public Classes getClassesByDesc(String desc) {
/* 101 */     this.s = this.sf.openSession();
/* 102 */     this.s.beginTransaction();
/*     */     
/* 104 */     Query query = this.s.getNamedQuery("Classes.findByClassDesc").setParameter("classDesc", desc);
/* 105 */     List<Classes> sy = query.list();
/* 106 */     this.s.close();
/* 107 */     return (Classes)sy.get(0);
/*     */   }
/*     */ 
/*     */   
/* 111 */   public Stage getDialogStage() { return dialogStage; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   public static Stage getDialogStage2() { return dialogStage2; }
/*     */ 
/*     */ 
/*     */   
/* 120 */   public void setMainApp(root mainApp) { this.MainApp = mainApp; }
/*     */ 
/*     */ 
/*     */   
/* 124 */   public static void setEdit(Student edit) { StudentAffair.edit = edit; }
/*     */ 
/*     */ 
/*     */   
/* 128 */   public static Student getEdit() { return edit; }
/*     */ 
/*     */ 
/*     */   
/* 132 */   public static StudentAttendance getEditStatus() { return editStatus; }
/*     */ 
/*     */ 
/*     */   
/* 136 */   public static void setEditStatus(StudentAttendance editStatus) { StudentAffair.editStatus = editStatus; }
/*     */ 
/*     */   
/*     */   public List<StudyYears> getSY() {
/* 140 */     this.s = this.sf.openSession();
/* 141 */     this.s.beginTransaction();
/* 142 */     Query query = this.s.getNamedQuery("StudyYears.findAll");
/* 143 */     List<StudyYears> sy = query.list();
/* 144 */     this.s.close();
/* 145 */     return sy;
/*     */   }
/*     */   
/*     */   public List<Classes> getClasses() {
/* 149 */     this.s = this.sf.openSession();
/* 150 */     this.s.beginTransaction();
/* 151 */     Query query = this.s.createQuery("from Classes");
/* 152 */     List<Classes> sy = query.list();
/* 153 */     this.s.close();
/* 154 */     return sy;
/*     */   }
/*     */   
/*     */   public List<ClassStudents> getClassStudent(Student st) {
/* 158 */     Query query = this.s.getNamedQuery("ClassStudents.findBysId").setParameter("sId", st);
/* 159 */     return query.list();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 164 */   public void LoadStudentsInClass(String a) { StudentsInClassList = FXCollections.observableArrayList(getStudInClass(a)); }
/*     */ 
/*     */   
/*     */   public List<ClassStudents> getStudInClass(String fg) {
/* 168 */     this.s = this.sf.openSession();
/* 169 */     this.s.beginTransaction();
/* 170 */     Query query = this.s.getNamedQuery("ClassStudents.findByCDesc").setParameter("classDesc", fg);
/* 171 */     List<ClassStudents> sub = query.list();
/* 172 */     this.s.close();
/* 173 */     return sub;
/*     */   }
/*     */   
/*     */   public void PersistNewStud(Persons p, Student st, ClassStudents cs) {
/*     */     try {
/* 178 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/* 179 */       this.s = this.sf.openSession();
/* 180 */       Transaction t = this.s.beginTransaction();
/* 181 */       this.s.persist(p);
/* 182 */       log = log + " -- new Person with id " + p.getPId();
/* 183 */       this.s.persist(st);
/* 184 */       log = log + " -- new Student with id " + st.getSId();
/* 185 */       if (cs != null) {
/* 186 */         this.s.persist(cs);
/* 187 */         log = log + " -- Register -- Student in a Class with id " + cs.getCsId();
/*     */       } 
/* 189 */       for (Contacts c : this.ContactsList) {
/* 190 */         c.setPId(p);
/* 191 */         this.s.persist(c);
/* 192 */         log = log + " -- new Contact with id " + c.getCId();
/*     */       } 
/* 194 */       this.ul = new UserLog();
/* 195 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 196 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 197 */       this.ul.setLogDESC(log);
/* 198 */       this.s.persist(this.ul);
/* 199 */       t.commit();
/* 200 */        dialogStage.close();
/* 201 */     } catch (Exception e) {
/* 202 */       System.err.println("ERROR IN HIBERNATE : " + e);
/* 203 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void UpdateStud(Student st) {
/*     */     try {
/* 209 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
/* 210 */       this.s = this.sf.openSession();
/* 211 */       Transaction t = this.s.beginTransaction();
/* 212 */       this.s.update(st);
/* 213 */       log = log + " --  Person with id " + st.getPId();
/* 214 */       log = log + " --  Student with id " + st.getSId();
/* 215 */       this.ul = new UserLog();
/* 216 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 217 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 218 */       this.ul.setLogDESC(log);
/* 219 */       this.s.persist(this.ul);
/* 220 */       this.s.update(st.getPId());
/*     */       
/* 222 */       t.commit();
/*     */       
/* 224 */       System.out.println("All Done");
/* 225 */     } catch (Exception e) {
/* 226 */       System.err.println("ERROR IN HIBERNATE : " + e.getLocalizedMessage());
/* 227 */       System.err.println("ERROR IN HIBERNATE : " + e);
/* 228 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void UpdateStud(Student st, ClassStudents cs, List<Contacts> cons) {
/*     */     try {
/* 234 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
/* 235 */       this.s = this.sf.openSession();
/* 236 */       Transaction t = this.s.beginTransaction();
/* 237 */       this.s.update(st);
/* 238 */       log = log + " --  Person with id " + st.getPId();
/* 239 */       log = log + " --  Student with id " + st.getSId();
/* 240 */       if (cs != null) {
/* 241 */         List<ClassStudents> tcs = getClassStudent(st);
/* 242 */         if (tcs.size() > 0) {
/* 243 */           ClassStudents tempCS = (ClassStudents)tcs.get(0);
/* 244 */           tempCS.setCId(cs.getCId());
/* 245 */           this.s.saveOrUpdate(tempCS);
/*     */         } else {
/* 247 */           this.s.persist(cs);
/*     */         } 
/* 249 */         log = log + " -- Register -- Student in a Class with id " + cs.getCsId();
/*     */       } 
/*     */       
/* 252 */       for (Contacts c : cons) {
/* 253 */         c.setPId(st.getPId());
/* 254 */         this.s.saveOrUpdate(c);
/* 255 */         log = log + " -- Contact with id " + c.getCId();
/*     */       } 
/*     */       
/* 258 */       this.ul = new UserLog();
/* 259 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 260 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 261 */       this.ul.setLogDESC(log);
/* 262 */       this.s.persist(this.ul);
/* 263 */       this.s.update(st.getPId());
/* 264 */       this.s.refresh(st);
/* 265 */       t.commit();
/* 266 */       dialogStage2.close();
/* 267 */       PersonsList.clear();
/* 268 */       PersonsList.addAll(getStudents(1));
/*     */       
/* 270 */       System.out.println("All Done");
/* 271 */     } catch (Exception e) {
/* 272 */       System.err.println("ERROR IN HIBERNATE : " + e.getLocalizedMessage());
/* 273 */       System.err.println("ERROR IN HIBERNATE : " + e);
/* 274 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void newStud() {
/*     */     try {
/* 280 */       FXMLLoader loader = new FXMLLoader();
/* 281 */       loader.setLocation(Main.class.getResource("/View/RegisterStud.fxml"));
/* 282 */       AnchorPane page = (AnchorPane)loader.load();
/* 283 */       dialogStage = new Stage();
/* 284 */       dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 285 */       dialogStage.setTitle("تسجيل الطلاب");
/* 286 */       dialogStage.initModality(Modality.WINDOW_MODAL);
/* 287 */       dialogStage.initOwner(this.MainApp.getPrimaryStage());
/* 288 */       Scene scene = new Scene(page);
/* 289 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 290 */       dialogStage.setScene(scene);
/*     */       
/* 292 */       dialogStage.showAndWait();
/* 293 */     } catch (IOException e) {
/* 294 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void newCon() {
/*     */     try {
/* 300 */       FXMLLoader loader = new FXMLLoader();
/* 301 */       loader.setLocation(Main.class.getResource("/View/StudContact.fxml"));
/* 302 */       AnchorPane page = (AnchorPane)loader.load();
/* 303 */       dialogStage2 = new Stage();
/* 304 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 305 */       dialogStage2.setTitle("جهات الاتصال");
/* 306 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/* 307 */       dialogStage2.initOwner(getDialogStage());
/* 308 */       Scene scene = new Scene(page);
/* 309 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 310 */       dialogStage2.setScene(scene);
/* 311 */       dialogStage2.showAndWait();
/* 312 */     } catch (IOException e) {
/* 313 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void editStud() {
/*     */     try {
/* 319 */       PersonsList.addAll(getStudents(1));
/* 320 */       FXMLLoader loader = new FXMLLoader();
/* 321 */       loader.setLocation(Main.class.getResource("/View/EditStud.fxml"));
/* 322 */       AnchorPane page = (AnchorPane)loader.load();
/* 323 */       dialogStage = new Stage();
/* 324 */       dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 325 */       dialogStage.setTitle("تعدبل الطلاب");
/* 326 */       dialogStage.initModality(Modality.WINDOW_MODAL);
/* 327 */       dialogStage.initOwner(this.MainApp.getPrimaryStage());
/* 328 */       Scene scene = new Scene(page);
/* 329 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 330 */       dialogStage.setScene(scene);
/*     */       
/* 332 */       dialogStage.showAndWait();
/* 333 */       PersonsList.clear();
/* 334 */     } catch (IOException e) {
/* 335 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Student> getStudents(int i) {
/* 340 */     this.s = this.sf.openSession();
/* 341 */     this.s.beginTransaction();
/* 342 */     Query query = null;
/* 343 */     if (i == 1) {
/* 344 */       query = this.s.getNamedQuery("Student.findAll").setMaxResults(20);
/*     */     } else {
/* 346 */       query = this.s.getNamedQuery("Student.findAll");
/*     */     } 
/* 348 */     List<Student> sy = query.list();
/* 349 */     this.s.close();
/* 350 */     return sy;
/*     */   }
/*     */   
/*     */   public List<StudentExpenses> getStudentExpenses(Student st) {
/* 354 */     this.s = this.sf.openSession();
/* 355 */     this.s.beginTransaction();
/* 356 */     Query query = this.s.getNamedQuery("StudentExpenses.findBySId").setParameter("sId", st);
/* 357 */     List<StudentExpenses> sy = query.list();
/* 358 */     this.s.close();
/* 359 */     return sy;
/*     */   }
/*     */   
/*     */   public List<Student> getActiveStudents() {
/* 363 */     this.s = this.sf.openSession();
/* 364 */     this.s.beginTransaction();
/* 365 */     Query query = this.s.getNamedQuery("Student.findByStatus").setParameter("status", "3");
/* 366 */     List<Student> sy = query.list();
/* 367 */     this.s.close();
/* 368 */     return sy;
/*     */   }
/*     */   
/*     */   public void editStudDetail() {
/*     */     try {
/* 373 */       FXMLLoader loader = new FXMLLoader();
/* 374 */       loader.setLocation(Main.class.getResource("/View/EditStudDetail.fxml"));
/* 375 */       AnchorPane page = (AnchorPane)loader.load();
/* 376 */       dialogStage2 = new Stage();
/* 377 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 378 */       dialogStage2.setTitle("تعديل بيانات الطالب");
/* 379 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/* 380 */       dialogStage2.initOwner(getDialogStage());
/* 381 */       Scene scene = new Scene(page);
/* 382 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 383 */       dialogStage2.setScene(scene);
/* 384 */       dialogStage2.showAndWait();
/*     */     }
/* 386 */     catch (IOException e) {
/* 387 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void editStudExpenses() {
/*     */     try {
/* 393 */       StudentExpensesList.addAll(getEdit().getStudentExpensesList());
/* 394 */       FXMLLoader loader = new FXMLLoader();
/* 395 */       loader.setLocation(Main.class.getResource("/View/StudentExpenses.fxml"));
/* 396 */       AnchorPane page = (AnchorPane)loader.load();
/* 397 */       dialogStage2 = new Stage();
/* 398 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 399 */       dialogStage2.setTitle("مصاريف المدرسة");
/* 400 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/* 401 */       dialogStage2.initOwner(getDialogStage());
/* 402 */       Scene scene = new Scene(page);
/* 403 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 404 */       dialogStage2.setScene(scene);
/* 405 */       dialogStage2.showAndWait();
/* 406 */       StudentExpensesList.clear();
/* 407 */     } catch (IOException e) {
/* 408 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void StudNotes() {
/*     */     try {
/* 414 */       StudentNotesList.addAll(getEdit().getStudentNotesList());
/* 415 */       FXMLLoader loader = new FXMLLoader();
/* 416 */       loader.setLocation(Main.class.getResource("/View/StudNotes.fxml"));
/* 417 */       AnchorPane page = (AnchorPane)loader.load();
/* 418 */       dialogStage2 = new Stage();
/* 419 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 420 */       dialogStage2.setTitle("ملاحظات");
/* 421 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/* 422 */       dialogStage2.initOwner(getDialogStage());
/* 423 */       Scene scene = new Scene(page);
/* 424 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 425 */       dialogStage2.setScene(scene);
/* 426 */       dialogStage2.showAndWait();
/* 427 */       StudentNotesList.clear();
/* 428 */     } catch (IOException e) {
/* 429 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void AbsentStud() {
/*     */     try {
/* 435 */       PersonsList.addAll(getActiveStudents());
/* 436 */       FXMLLoader loader = new FXMLLoader();
/* 437 */       loader.setLocation(Main.class.getResource("/View/Absent_Stud.fxml"));
/* 438 */       AnchorPane page = (AnchorPane)loader.load();
/* 439 */       dialogStage = new Stage();
/* 440 */       dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 441 */       dialogStage.setTitle("تسجيل غياب الطلاب");
/* 442 */       dialogStage.initModality(Modality.WINDOW_MODAL);
/* 443 */       dialogStage.initOwner(this.MainApp.getPrimaryStage());
/* 444 */       Scene scene = new Scene(page);
/* 445 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 446 */       dialogStage.setScene(scene);
/* 447 */       dialogStage.showAndWait();
/* 448 */       PersonsList.clear();
/* 449 */     } catch (IOException e) {
/* 450 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean PersistNewAbsent(String Notes, Student su, Date dt) {
/*     */     try {
/* 456 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/* 457 */       this.s = this.sf.openSession();
/* 458 */       Transaction t = this.s.beginTransaction();
/* 459 */       this.suA = new StudentAttendance();
/* 460 */       this.suA.setAbDesc(Notes);
/* 461 */       this.suA.setAbsentDay(dt);
/* 462 */       this.suA.setSId(su);
/* 463 */       this.suA.setStatus(true);
/* 464 */       this.suA.setEntryDate(java.sql.Date.valueOf(LocalDate.now()));
/* 465 */       this.s.persist(this.suA);
/* 466 */       log = log + " -- new Student Absence with id " + this.suA.getSAtId();
/* 467 */       this.ul = new UserLog();
/* 468 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 469 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 470 */       this.ul.setLogDESC(log);
/* 471 */       this.s.persist(this.ul);
/* 472 */       t.commit();
/* 473 */       PersonsList.clear();
/* 474 */       PersonsList.addAll(getActiveStudents());
/* 475 */       return true;
/* 476 */     } catch (Exception e) {
/* 477 */       System.err.println("El72 " + e.getMessage());
/* 478 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ClassStudents() {
/*     */     try {
/* 484 */       PersonsList.addAll(getStudents(1));
/* 485 */       FXMLLoader loader = new FXMLLoader();
/* 486 */       loader.setLocation(Main.class.getResource("/View/ClassStudents.fxml"));
/* 487 */       AnchorPane page = (AnchorPane)loader.load();
/* 488 */       dialogStage = new Stage();
/* 489 */       dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 490 */       dialogStage.setTitle("تسجيل قوائم الفصول");
/* 491 */       dialogStage.initModality(Modality.WINDOW_MODAL);
/* 492 */       dialogStage.initOwner(this.MainApp.getPrimaryStage());
/* 493 */       Scene scene = new Scene(page);
/* 494 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 495 */       dialogStage.setScene(scene);
/* 496 */       dialogStage.showAndWait();
/* 497 */       PersonsList.clear();
/* 498 */     } catch (IOException e) {
/* 499 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void PersistNewClassStudent(ClassStudents sc) {
/*     */     try {
/* 505 */       PersonsList.clear();
/* 506 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/* 507 */       this.s = this.sf.openSession();
/* 508 */       Transaction t = this.s.beginTransaction();
/* 509 */       this.s.persist(sc);
/* 510 */       log = log + " -- new Class Student with id " + sc.getCsId();
/*     */       
/* 512 */       this.ul = new UserLog();
/* 513 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 514 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 515 */       this.ul.setLogDESC(log);
/* 516 */       this.s.persist(this.ul);
/* 517 */       t.commit();
/* 518 */       PersonsList.addAll(getStudents(1));
/* 519 */     } catch (Exception e) {
/* 520 */       System.err.println("ERROR IN HIBERNATE : " + e);
/* 521 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
/* 522 */       Alert alert = new Alert(Alert.AlertType.WARNING);
/* 523 */       alert.setTitle("يوجد خطأ");
/* 524 */       alert.setHeaderText("الطالب المراد اضافته مسجل في فصل بالفعل");
/* 525 */       alert.setContentText("برجاء التأكد من اختياراتك");
/* 526 */       alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
/* 527 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void RemoveClassStudent(ClassStudents sc) {
/*     */     try {
/* 533 */       PersonsList.clear();
/* 534 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Deleted";
/* 535 */       this.s = this.sf.openSession();
/* 536 */       Transaction t = this.s.beginTransaction();
/* 537 */       Query query = this.s.getNamedQuery("ClassStudents.deleteBycsId").setParameter("csId", sc.getCsId());
/* 538 */       log = log + " -- Class Student with id " + sc.getCsId();
/* 539 */       query.executeUpdate();
/* 540 */       this.ul = new UserLog();
/* 541 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 542 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 543 */       this.ul.setLogDESC(log);
/* 544 */       this.s.persist(this.ul);
/* 545 */       t.commit();
/* 546 */       PersonsList.addAll(getStudents(1));
/* 547 */     } catch (Exception e) {
/* 548 */       System.err.println("ERROR IN HIBERNATE : " + e);
/* 549 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void PersistNewStudentNote(StudentNotes sc) {
/*     */     try {
/* 555 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/* 556 */       this.s = this.sf.openSession();
/* 557 */       Transaction t = this.s.beginTransaction();
/* 558 */       this.s.persist(sc);
/* 559 */       log = log + " -- new Student Note with id " + sc.getNId();
/*     */       
/* 561 */       this.ul = new UserLog();
/* 562 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 563 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 564 */       this.ul.setLogDESC(log);
/* 565 */       this.s.persist(this.ul);
/* 566 */       t.commit();
/* 567 */        dialogStage2.close();
/* 568 */       PersonsList.clear();
/* 569 */       PersonsList.addAll(getStudents(1));
/* 570 */     } catch (Exception e) {
/* 571 */       System.err.println("ERROR IN HIBERNATE : " + e);
/* 572 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void RemoveStudentNote(StudentNotes sc) {
/*     */     try {
/* 584 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Deleted";
/* 585 */       this.s = this.sf.openSession();
/* 586 */       Transaction t = this.s.beginTransaction();
/* 587 */       Query query = this.s.getNamedQuery("StudentNotes.deleteByNId").setParameter("nId", sc.getNId());
/* 588 */       log = log + " -- Class Student with id " + sc.getNId();
/* 589 */       query.executeUpdate();
/* 590 */       this.ul = new UserLog();
/* 591 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 592 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 593 */       this.ul.setLogDESC(log);
/* 594 */       this.s.persist(this.ul);
/* 595 */       t.commit();
/* 596 */       PersonsList.clear();
/* 597 */       PersonsList.addAll(getStudents(1));
/* 598 */     } catch (Exception e) {
/* 599 */       System.err.println("ERROR IN HIBERNATE : " + e);
/* 600 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void PersistStudentExpense(StudentExpenses bd) {
/*     */     try {
/* 606 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/* 607 */       this.s = this.sf.openSession();
/* 608 */       Transaction t = this.s.beginTransaction();
/* 609 */       this.s.persist(bd);
/* 610 */       log = log + " -- new Student Expense with id " + bd.getSteId();
/*     */       
/* 612 */       this.ul = new UserLog();
/* 613 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 614 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 615 */       this.ul.setLogDESC(log);
/* 616 */       this.s.persist(this.ul);
/* 617 */       t.commit();
/* 618 */       StudentExpensesList.clear();
/* 619 */       StudentExpensesList = FXCollections.observableArrayList(getStudentExpenses(bd.getSId()));
/* 620 */     } catch (Exception e) {
/* 621 */       System.err.println("El72 " + e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void UpdateStudentExpense(StudentExpenses bd) {
/*     */     try {
/* 627 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
/* 628 */       this.s = this.sf.openSession();
/* 629 */       Transaction t = this.s.beginTransaction();
/* 630 */       this.s.update(bd);
/* 631 */       log = log + " -- Student Expenses with id " + bd.getSteId();
/*     */       
/* 633 */       this.ul = new UserLog();
/* 634 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 635 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 636 */       this.ul.setLogDESC(log);
/* 637 */       this.s.persist(this.ul);
/* 638 */       t.commit();
/* 639 */       StudentExpensesList.clear();
/* 640 */       StudentExpensesList.addAll(getStudentExpenses(bd.getSId()));
/* 641 */     } catch (Exception e) {
/* 642 */       System.err.println("El72 " + e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ViewStudent() {
/*     */     try {
/* 648 */       FXMLLoader loader = new FXMLLoader();
/* 649 */       loader.setLocation(Main.class.getResource("/View/ViewStud.fxml"));
/* 650 */       AnchorPane page = (AnchorPane)loader.load();
/* 651 */       dialogStage2 = new Stage();
/* 652 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 653 */       dialogStage2.setTitle("عرض الطالب");
/* 654 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/* 655 */       dialogStage2.initOwner(getDialogStage());
/* 656 */       Scene scene = new Scene(page);
/* 657 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 658 */       dialogStage2.setScene(scene);
/* 659 */       dialogStage2.showAndWait();
/*     */     }
/* 661 */     catch (IOException e) {
/* 662 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void UpdateAbscenceStatus(StudentAttendance ea) {
/*     */     try {
/* 669 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
/* 670 */       this.s = this.sf.openSession();
/* 671 */       Transaction t = this.s.beginTransaction();
/* 672 */       this.s.update(ea);
/* 673 */       log = log + " -- Student Attendece with id " + ea.getSAtId();
/* 674 */       this.ul = new UserLog();
/* 675 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 676 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 677 */       this.ul.setLogDESC(log);
/* 678 */       this.s.persist(this.ul);
/* 679 */       t.commit();
/* 680 */     } catch (Exception e) {
/* 681 */       System.err.println("ERROR IN HIBERNATE : " + e);
/* 682 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ViewEditAbscentStatus() {
/*     */     try {
/* 688 */       FXMLLoader loader = new FXMLLoader();
/* 689 */       loader.setLocation(Main.class.getResource("/View/EditStudAbscentStatus.fxml"));
/* 690 */       AnchorPane page = (AnchorPane)loader.load();
/* 691 */       dialogStage2 = new Stage();
/* 692 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 693 */       dialogStage2.setTitle("تعديل حالة الغياب");
/* 694 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/* 695 */       dialogStage2.initOwner(getDialogStage());
/* 696 */       Scene scene = new Scene(page);
/* 697 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 698 */       dialogStage2.setScene(scene);
/* 699 */       dialogStage2.showAndWait();
/* 700 */     } catch (IOException e) {
/* 701 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ViewControl4_6() {
/*     */     try {
/* 707 */       FXMLLoader loader = new FXMLLoader();
/* 708 */       loader.setLocation(Main.class.getResource("/View/StudentGrades4-5-6.fxml"));
/* 709 */       AnchorPane page = (AnchorPane)loader.load();
/* 710 */       dialogStage2 = new Stage();
/* 711 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 712 */       dialogStage2.setTitle("كنترول الطالب");
/* 713 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/* 714 */       dialogStage2.initOwner(getDialogStage());
/* 715 */       Scene scene = new Scene(page);
/* 716 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 717 */       dialogStage2.setScene(scene);
/* 718 */       dialogStage2.showAndWait();
/* 719 */     } catch (IOException e) {
/* 720 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ViewControl1_3() {
/*     */     try {
/* 726 */       FXMLLoader loader = new FXMLLoader();
/* 727 */       loader.setLocation(Main.class.getResource("/View/StudentGrades1-2-3.fxml"));
/* 728 */       AnchorPane page = (AnchorPane)loader.load();
/* 729 */       dialogStage2 = new Stage();
/* 730 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 731 */       dialogStage2.setTitle("كنترول الطالب");
/* 732 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/* 733 */       dialogStage2.initOwner(getDialogStage());
/* 734 */       Scene scene = new Scene(page);
/* 735 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 736 */       dialogStage2.setScene(scene);
/* 737 */       dialogStage2.showAndWait();
/* 738 */     } catch (IOException e) {
/* 739 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void PersistStudControl(ActualGrades ag) {
/*     */     try {
/* 745 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Deleted";
/* 746 */       this.s = this.sf.openSession();
/* 747 */       Transaction t = this.s.beginTransaction();
/*     */       
/* 749 */       Query query = this.s.getNamedQuery("ActualGrades.deleteById").setParameter("gdId", ag.getGdId()).setParameter("sId", ag.getSId());
/* 750 */       log = log + " -- Actual Detail with id " + ag.getAgId();
/* 751 */       query.executeUpdate();
/*     */       
/* 753 */       this.s.persist(ag);
/* 754 */       this.s.refresh(edit);
/* 755 */       log = log + "  -- Created -- Actual Grade with id " + ag.getAgId();
/*     */       
/* 757 */       this.ul = new UserLog();
/* 758 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 759 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 760 */       this.ul.setLogDESC(log);
/* 761 */       this.s.persist(this.ul);
/* 762 */       t.commit();
/*     */     }
/* 764 */     catch (Exception e) {
/* 765 */       System.err.println("El72 " + e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ReportsStud() {
/*     */     try {
/* 771 */       FXMLLoader loader = new FXMLLoader();
/* 772 */       loader.setLocation(Main.class.getResource("/View/studReports.fxml"));
/* 773 */       AnchorPane page = (AnchorPane)loader.load();
/* 774 */       dialogStage = new Stage();
/* 775 */       dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/* 776 */       dialogStage.setTitle("تقارير الطلبة");
/* 777 */       dialogStage.initModality(Modality.WINDOW_MODAL);
/* 778 */       dialogStage.initOwner(this.MainApp.getPrimaryStage());
/* 779 */       Scene scene = new Scene(page);
/* 780 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/* 781 */       dialogStage.setScene(scene);
/* 782 */       dialogStage.showAndWait();
/* 783 */     } catch (IOException e) {
/* 784 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public Integer getStudyYearbyDesc(String syDesc) {
/* 789 */     this.s = this.sf.openSession();
/* 790 */     this.s.beginTransaction();
/* 791 */     Query query = this.s.getNamedQuery("StudyYears.findBySyDesc1").setParameter("syDesc", syDesc);
/* 792 */     List<Integer> x = query.list();
/* 793 */     this.s.close();
/* 794 */     return (Integer)x.get(0);
/*     */   }
/*     */   
/*     */   public Integer getExpensebyDesc(String syDesc) {
/* 798 */     this.s = this.sf.openSession();
/* 799 */     this.s.beginTransaction();
/* 800 */     SQLQuery sQLQuery = this.s.createSQLQuery("select id from student_expenses_lkp where expense_desc = '" + syDesc + "'");
/*     */     
/* 802 */     List<Integer> x = sQLQuery.list();
/* 803 */     this.s.close();
/* 804 */     return (Integer)x.get(0);
/*     */   }
/*     */   
/*     */   public Integer getClassesDesc(String syDesc) {
/* 808 */     this.s = this.sf.openSession();
/* 809 */     this.s.beginTransaction();
/* 810 */     Query query = this.s.getNamedQuery("Classes.findByClassDesc").setParameter("classDesc", syDesc);
/* 811 */     List<Classes> x = query.list();
/* 812 */     this.s.close();
/* 813 */     return ((Classes)x.get(0)).getCId();
/*     */   }
/*     */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\amgad\h\StudentAffair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */