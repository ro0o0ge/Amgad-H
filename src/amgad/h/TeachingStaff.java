 package amgad.h;
 
 import Controller.GradesController;
 import Entity.Classes;
 import Entity.Contacts;
 import Entity.EmployeeAttendance;
 import Entity.Evaluation;
 import Entity.FinalGrades;
 import Entity.GradeDetail;
 import Entity.LectureDatetime;
 import Entity.Payroll;
 import Entity.Persons;
 import Entity.Schedule;
 import Entity.StudyYears;
 import Entity.Subjects;
 import Entity.Teacher;
 import Entity.TeacherSubjects;
 import Entity.UserLog;
 import Util.HibernateUtil;
 import Util.LoginSec;
 import java.io.IOException;
 import java.sql.Timestamp;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.Iterator;
 import java.util.List;
 import javafx.collections.FXCollections;
 import javafx.collections.ObservableList;
 import javafx.fxml.FXMLLoader;
 import javafx.geometry.NodeOrientation;
 import javafx.scene.Scene;
 import javafx.scene.image.Image;
 import javafx.scene.layout.AnchorPane;
 import javafx.stage.Modality;
 import javafx.stage.Stage;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.SessionFactory;
 import org.hibernate.Transaction;
 
 
 
 
 
 
 
 
 
 
 
 public class TeachingStaff
 {
   private root MainApp;
   private static Stage dialogStage;
   private static Stage dialogStage2;
   private static Contacts C;
   private static TeacherSubjects TS;
   UserLog ul;
/*   59 */   private List<TeacherSubjects> tss = new ArrayList();
   
   static Teacher edit;
   
   static EmployeeAttendance editStatus;
   
   static Payroll editPayrollStatus;
   
   EmployeeAttendance EA;
   
   Payroll PR;
/*   70 */   SessionFactory sf = HibernateUtil.getSessionFactory();
   
   Session s;
/*   73 */   ObservableList<Contacts> ContactsList = FXCollections.observableArrayList();
 
   
/*   76 */   public ObservableList<Contacts> getContactsList() { return this.ContactsList; }
 
   
/*   79 */   ObservableList<Subjects> SubjectsList = FXCollections.observableArrayList();
 
   
/*   82 */   public ObservableList<Subjects> getSubjectsList() { return this.SubjectsList; }
 
   
   public List<StudyYears> getSY() {
/*   86 */     this.s = this.sf.openSession();
/*   87 */     this.s.beginTransaction();
/*   88 */     Query query = this.s.getNamedQuery("StudyYears.findAll");
/*   89 */     List<StudyYears> sy = query.list();
/*   90 */     this.s.close();
/*   91 */     return sy;
   }
 
   
/*   95 */   public List<TeacherSubjects> getTss() { return this.tss; }
 
 
   
/*   99 */   public static void setC(Contacts con) { C = con; }
 
 
   
/*  103 */   public static Contacts getContacts() { return C; }
 
 
   
/*  107 */   public static TeacherSubjects getS() { return TS; }
 
 
   
/*  111 */   public static void setS(TeacherSubjects Sub) { TS = Sub; }
 
 
   
/*  115 */   public void setMainApp(root mainApp) { this.MainApp = mainApp; }
 
 
   
/*  119 */   public Stage getDialogStage() { return dialogStage; }
 
 
   
/*  123 */   public static Stage getDialogStage2() { return dialogStage2; }
 
 
   
/*  127 */   public static Teacher getEdit() { return edit; }
 
 
   
/*  131 */   public static void setEdit(Teacher edit) { TeachingStaff.edit = edit; }
 
 
   
/*  135 */   public static Payroll getEditPayrollStatus() { return editPayrollStatus; }
 
 
   
/*  139 */   public static void setEditPayrollStatus(Payroll editPayrollStatus) { TeachingStaff.editPayrollStatus = editPayrollStatus; }
 
 
   
/*  143 */   public static EmployeeAttendance getEditStatus() { return editStatus; }
 
 
   
/*  147 */   public static void setEditStatus(EmployeeAttendance editStatus) { TeachingStaff.editStatus = editStatus; }
 
   
/*  150 */   static ObservableList<Teacher> PersonsList = FXCollections.observableArrayList();
 
   
/*  153 */   public static ObservableList<Teacher> getPersonsList() { return PersonsList; }
 
   
   public List<Schedule> getSchedulebyClassDesc(String YDesc) {
/*  157 */     this.s = this.sf.openSession();
/*  158 */     this.s.beginTransaction();
     
/*  160 */     Query query = this.s.getNamedQuery("Schedule.findByClassDesc").setParameter("classDesc", YDesc);
/*  161 */     List<Schedule> sy = query.list();
/*  162 */     this.s.close();
/*  163 */     return sy;
   }
   
   public List<StudyYears> getStudyYears() {
/*  167 */     this.s = this.sf.openSession();
/*  168 */     this.s.beginTransaction();
/*  169 */     Query query = this.s.createQuery("from StudyYears");
/*  170 */     List<StudyYears> sy = query.list();
/*  171 */     this.s.close();
/*  172 */     return sy;
   }
   
   public List<Subjects> getSubjectsByStudyYearDesc(String YDesc) {
/*  176 */     this.s = this.sf.openSession();
/*  177 */     this.s.beginTransaction();
     
/*  179 */     Query query = this.s.getNamedQuery("Subjects.findBySyDesc").setParameter("syDesc", YDesc);
/*  180 */     List<Subjects> sy = query.list();
/*  181 */     this.s.close();
/*  182 */     return sy;
   }
   
   public StudyYears getStudyYearsByDesc(String desc) {
/*  186 */     this.s = this.sf.openSession();
/*  187 */     this.s.beginTransaction();
/*  188 */     Query query = this.s.getNamedQuery("StudyYears.findBySyDesc").setParameter("syDesc", desc);
/*  189 */     List<StudyYears> sy = query.list();
/*  190 */     this.s.close();
/*  191 */     return (StudyYears)sy.get(0);
   }
   
   public List<Subjects> getStudyYearSubjects(StudyYears sty) {
/*  195 */     this.s = this.sf.openSession();
/*  196 */     this.s.beginTransaction();
/*  197 */     Query query = this.s.getNamedQuery("Subjects.findBySyId").setParameter("syId", sty);
/*  198 */     List<Subjects> sub = query.list();
/*  199 */     this.s.close();
/*  200 */     return sub;
   }
   
/*  203 */   static ObservableList<GradeDetail> GradeDetailList = FXCollections.observableArrayList();
 
   
/*  206 */   public static ObservableList<GradeDetail> getGradeDetailList() { return GradeDetailList; }
 
   
/*  209 */   static ObservableList<Evaluation> EvaluationList = FXCollections.observableArrayList();
 
   
/*  212 */   public static ObservableList<Evaluation> getEvaluationList() { return EvaluationList; }
 
 
   
/*  216 */   public void setEvaluationList(List<Evaluation> EvaluationList) {  TeachingStaff.EvaluationList = FXCollections.observableArrayList(EvaluationList); }
 
   
   public List<Evaluation> getEvaluations() {
/*  220 */     this.s = this.sf.openSession();
/*  221 */     this.s.beginTransaction();
/*  222 */     Query query = this.s.getNamedQuery("Evaluation.findByPId").setParameter("pId", edit.getPId());
/*  223 */     List<Evaluation> sy = query.list();
/*  224 */     this.s.close();
/*  225 */     return sy;
   }
 
 
   
/*  230 */   public void LoadGradeDetails(String a, String b) { GradeDetailList = FXCollections.observableArrayList(getGradeDetails(getSubjectsByDescAndYDesc(a, b))); }
 
   
   public List<GradeDetail> getGradeDetails(Subjects fg) {
/*  234 */     this.s = this.sf.openSession();
/*  235 */     this.s.beginTransaction();
/*  236 */     Query query = this.s.getNamedQuery("GradeDetail.findBySubjectId").setParameter("suId", fg);
/*  237 */     List<GradeDetail> sub = query.list();
/*  238 */     this.s.close();
/*  239 */     return sub;
   }
   
   public Subjects getSubjectsByDescAndYDesc(String desc, String YDesc) {
/*  243 */     this.s = this.sf.openSession();
/*  244 */     this.s.beginTransaction();
     
/*  246 */     Query query = this.s.getNamedQuery("Subjects.findBySuDescAndSyId").setParameter("suDesc", desc).setParameter("syDesc", YDesc);
/*  247 */     List<Subjects> sy = query.list();
/*  248 */     this.s.close();
/*  249 */     return (Subjects)sy.get(0);
   }
   
   public String getFinalGrade(Subjects desc) {
/*  253 */     this.s = this.sf.openSession();
/*  254 */     this.s.beginTransaction();
     
/*  256 */     Query query = this.s.getNamedQuery("FinalGrades.findBysuId").setParameter("suId", desc);
/*  257 */     List<FinalGrades> sy = query.list();
/*  258 */     this.s.close();
/*  259 */     if (sy.size() < 1) {
/*  260 */       return "";
     }
/*  262 */     GradesController.setFG((FinalGrades)sy.get(0));
/*  263 */     return String.valueOf(((FinalGrades)sy.get(0)).getGrade());
   }
   
   public void PersistNewTeac(Persons p, Teacher te) {
     try {
/*  268 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/*  269 */       this.s = this.sf.openSession();
/*  270 */       Transaction t = this.s.beginTransaction();
/*  271 */       this.s.persist(p);
/*  272 */       log = log + " -- new Person with id " + p.getPId();
/*  273 */       this.s.persist(te);
/*  274 */       log = log + " -- new Teacer with id " + te.getTId();
       
/*  276 */       for (Contacts c : this.ContactsList) {
/*  277 */         c.setPId(p);
/*  278 */         this.s.persist(c);
/*  279 */         log = log + " -- new Contact with id " + c.getCId();
       } 
       
/*  282 */       for (TeacherSubjects su : this.tss) {
/*  283 */         su.setTId(te);
/*  284 */         this.s.persist(su);
/*  285 */         log = log + " -- new Teacher Subject with id " + su.getTSID();
       } 
       
/*  288 */       this.ul = new UserLog();
/*  289 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  290 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  291 */       this.ul.setLogDESC(log);
/*  292 */       this.s.persist(this.ul);
/*  293 */       t.commit();
/*  294 */        dialogStage.close();
/*  295 */     } catch (Exception e) {
/*  296 */       System.err.println("ERROR IN HIBERNATE : " + e);
/*  297 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
     } 
   }
   
   public void UpdateTeacher(Teacher st, List<Contacts> cons, List<Subjects> subs) {
     try {
/*  303 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
/*  304 */       this.s = this.sf.openSession();
/*  305 */       Transaction t = this.s.beginTransaction();
/*  306 */       this.s.update(st);
/*  307 */       log = log + " --  Person with id " + st.getPId();
/*  308 */       log = log + " --  Teacher with id " + st.getTId();
       
/*  310 */       for (Contacts c : cons) {
/*  311 */         c.setPId(st.getPId());
/*  312 */         this.s.saveOrUpdate(c);
/*  313 */         log = log + " -- Contact with id " + c.getCId();
       } 
       
/*  316 */       Query query = this.s.getNamedQuery("TeacherSubjects.deleteByTID").setParameter("tId", st);
/*  317 */       query.executeUpdate();
       
/*  319 */       for (Subjects c : subs) {
/*  320 */         TeacherSubjects trss = new TeacherSubjects();
/*  321 */         trss.setSuId(c);
/*  322 */         trss.setTId(st);
/*  323 */         this.s.persist(trss);
/*  324 */         log = log + " -- Subject with id " + c.getSuId();
       } 
       
/*  327 */       this.ul = new UserLog();
/*  328 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  329 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  330 */       this.ul.setLogDESC(log);
/*  331 */       this.s.persist(this.ul);
/*  332 */       this.s.update(st.getPId());
/*  333 */       t.commit();
/*  334 */       dialogStage2.close();
/*  335 */       PersonsList.clear();
/*  336 */       PersonsList.addAll(getTeachers());
/*  337 */       System.out.println("All Done");
/*  338 */     } catch (Exception e) {
/*  339 */       System.err.println("ERROR IN HIBERNATE : " + e.getLocalizedMessage());
/*  340 */       System.err.println("ERROR IN HIBERNATE : " + e);
/*  341 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
/*  342 */       throw e;
     } 
   }
 
   
   public void newTeacher() {
     try {
/*  349 */       FXMLLoader loader = new FXMLLoader();
/*  350 */       loader.setLocation(Main.class.getResource("/View/RegisterTeacher.fxml"));
/*  351 */       AnchorPane page = (AnchorPane)loader.load();
/*  352 */       dialogStage = new Stage();
/*  353 */       dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*  354 */       dialogStage.setTitle("تسجيل المدرسين");
/*  355 */       dialogStage.initModality(Modality.WINDOW_MODAL);
/*  356 */       dialogStage.initOwner(this.MainApp.getPrimaryStage());
/*  357 */       Scene scene = new Scene(page);
/*  358 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/*  359 */       dialogStage.setScene(scene);
       
/*  361 */       dialogStage.showAndWait();
/*  362 */     } catch (IOException e) {
/*  363 */       e.printStackTrace();
     } 
   }
   
   public void newCon() {
     try {
/*  369 */       FXMLLoader loader = new FXMLLoader();
/*  370 */       loader.setLocation(Main.class.getResource("/View/TeacContact.fxml"));
/*  371 */       AnchorPane page = (AnchorPane)loader.load();
/*  372 */       dialogStage2 = new Stage();
/*  373 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*  374 */       dialogStage2.setTitle("جهات الاتصال");
/*  375 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/*  376 */       dialogStage2.initOwner(getDialogStage());
/*  377 */       Scene scene = new Scene(page);
/*  378 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/*  379 */       dialogStage2.setScene(scene);
/*  380 */       dialogStage2.showAndWait();
/*  381 */     } catch (IOException e) {
/*  382 */       e.printStackTrace();
     } 
   }
   
   public void newSub() {
     try {
/*  388 */       FXMLLoader loader = new FXMLLoader();
/*  389 */       loader.setLocation(Main.class.getResource("/View/TeacSubjects.fxml"));
/*  390 */       AnchorPane page = (AnchorPane)loader.load();
/*  391 */       dialogStage2 = new Stage();
/*  392 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*  393 */       dialogStage2.setTitle("المواد");
/*  394 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/*  395 */       dialogStage2.initOwner(getDialogStage());
/*  396 */       Scene scene = new Scene(page);
/*  397 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/*  398 */       dialogStage2.setScene(scene);
/*  399 */       dialogStage2.showAndWait();
/*  400 */     } catch (IOException e) {
/*  401 */       e.printStackTrace();
     } 
   }
   
   public List<Teacher> getTeachers() {
/*  406 */     this.s = this.sf.openSession();
/*  407 */     this.s.beginTransaction();
/*  408 */     Query query = this.s.getNamedQuery("Teacher.findAll");
/*  409 */     List<Teacher> sy = query.list();
/*  410 */     this.s.close();
/*  411 */     return sy;
   }
   
   public String getTeacherNameByID(int id) {
/*  415 */     this.s = this.sf.openSession();
/*  416 */     this.s.beginTransaction();
/*  417 */     Query query = this.s.getNamedQuery("Teacher.findByTId").setParameter("tId", Integer.valueOf(id));
/*  418 */     List<Teacher> sy = query.list();
/*  419 */     this.s.close();
/*  420 */     return ((Teacher)sy.get(0)).getPId().getName();
   }
   
   public Teacher getTeacherByName(String Name, String Desc) {
/*  424 */     this.s = this.sf.openSession();
/*  425 */     this.s.beginTransaction();
     
/*  427 */     Query query = this.s.getNamedQuery("Teacher.findByName").setParameter("name", Name).setParameter("classDesc", Desc);
/*  428 */     List<Teacher> sy = query.list();
/*  429 */     this.s.close();
/*  430 */     return (Teacher)sy.get(0);
   }
   
   public List<Teacher> getActiveTeachers() {
/*  434 */     this.s = this.sf.openSession();
/*  435 */     this.s.beginTransaction();
/*  436 */     Query query = this.s.getNamedQuery("Teacher.findByStatus").setParameter("status", "1");
/*  437 */     List<Teacher> sy = query.list();
/*  438 */     this.s.close();
/*  439 */     return sy;
   }
   
   public List<String> getClassTeachers(String Desc) {
/*  443 */     this.s = this.sf.openSession();
/*  444 */     this.s.beginTransaction();
/*  445 */     Query query = this.s.getNamedQuery("Teacher.findByClassDesc").setParameter("classDesc", Desc);
/*  446 */     List<Teacher> sy = query.list();
/*  447 */     List<String> StudY = new ArrayList<String>();
/*  448 */     for (Iterator<Teacher> iterator = sy.iterator(); iterator.hasNext();) {
/*  449 */       StudY.add(((Teacher)iterator.next()).getPId().getName());
     }
/*  451 */     this.s.close();
/*  452 */     return StudY;
   }
   
   public void editTeacher() {
     try {
/*  457 */       PersonsList.addAll(getTeachers());
/*  458 */       FXMLLoader loader = new FXMLLoader();
/*  459 */       loader.setLocation(Main.class.getResource("/View/EditTeacher.fxml"));
/*  460 */       AnchorPane page = (AnchorPane)loader.load();
/*  461 */       dialogStage = new Stage();
/*  462 */       dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*  463 */       dialogStage.setTitle("تعدبل المدرسين");
/*  464 */       dialogStage.initModality(Modality.WINDOW_MODAL);
/*  465 */       dialogStage.initOwner(this.MainApp.getPrimaryStage());
/*  466 */       Scene scene = new Scene(page);
/*  467 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/*  468 */       dialogStage.setScene(scene);
/*  469 */       dialogStage.showAndWait();
/*  470 */       PersonsList.clear();
/*  471 */     } catch (IOException e) {
/*  472 */       e.printStackTrace();
     } 
   }
   
   public void editTeacherDetail() {
     try {
/*  478 */       FXMLLoader loader = new FXMLLoader();
/*  479 */       loader.setLocation(Main.class.getResource("/View/EditTeacherDetail.fxml"));
/*  480 */       AnchorPane page = (AnchorPane)loader.load();
/*  481 */       dialogStage2 = new Stage();
/*  482 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*  483 */       dialogStage2.setTitle("تعديل بيانات الطالب");
/*  484 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/*  485 */       dialogStage2.initOwner(getDialogStage());
/*  486 */       Scene scene = new Scene(page);
/*  487 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/*  488 */       dialogStage2.setScene(scene);
/*  489 */       dialogStage2.showAndWait();
     }
/*  491 */     catch (IOException e) {
/*  492 */       e.printStackTrace();
     } 
   }
   
   public void AbsentTeacher() {
     try {
/*  498 */       PersonsList.addAll(getActiveTeachers());
/*  499 */       FXMLLoader loader = new FXMLLoader();
/*  500 */       loader.setLocation(Main.class.getResource("/View/Absent_Teacher.fxml"));
/*  501 */       AnchorPane page = (AnchorPane)loader.load();
/*  502 */       dialogStage = new Stage();
/*  503 */       dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*  504 */       dialogStage.setTitle("تسجيل غياب المدرسين");
/*  505 */       dialogStage.initModality(Modality.WINDOW_MODAL);
/*  506 */       dialogStage.initOwner(this.MainApp.getPrimaryStage());
/*  507 */       Scene scene = new Scene(page);
/*  508 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/*  509 */       dialogStage.setScene(scene);
/*  510 */       dialogStage.showAndWait();
/*  511 */       PersonsList.clear();
/*  512 */     } catch (IOException e) {
/*  513 */       e.printStackTrace();
     } 
   }
 
   
   public boolean PersistNewAbsent(String Notes, Teacher su, Date dt, String Type, String DurationType, String Duration) {
     try {
/*  520 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/*  521 */       this.s = this.sf.openSession();
/*  522 */       Transaction t = this.s.beginTransaction();
/*  523 */       this.EA = new EmployeeAttendance();
       
/*  525 */       this.EA.setStatus(true);
/*  526 */       if (Notes.equals("")) {
/*  527 */         this.EA.setEaDesc(null);
       }
/*  529 */       this.EA.setEaDate(dt);
/*  530 */       this.EA.setTId(su);
/*  531 */       this.EA.setTimeAmount(Integer.parseInt(Duration));
/*  532 */       if (DurationType.equals("دقائق")) {
/*  533 */         this.EA.setTimeType("1");
       } else {
/*  535 */         this.EA.setTimeType("2");
       } 
       
/*  538 */       if (Type.equals("تأخير")) {
/*  539 */         this.EA.setAbscenceType("1");
/*  540 */       } else if (Type.equals("استئذان")) {
/*  541 */         this.EA.setAbscenceType("2");
/*  542 */       } else if (Type.equals("منحة")) {
/*  543 */         this.EA.setAbscenceType("3");
/*  544 */       } else if (Type.equals("سنوية")) {
/*  545 */         this.EA.setAbscenceType("5");
       } else {
/*  547 */         this.EA.setAbscenceType("6");
       } 
/*  549 */       this.s.persist(this.EA);
/*  550 */       log = log + " -- new Teacher Absence with id " + this.EA.getEaId();
       
/*  552 */       this.ul = new UserLog();
/*  553 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  554 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  555 */       this.ul.setLogDESC(log);
/*  556 */       this.s.persist(this.ul);
/*  557 */       t.commit();
/*  558 */       PersonsList.clear();
/*  559 */       PersonsList.addAll(getActiveTeachers());
/*  560 */       return true;
/*  561 */     } catch (Exception e) {
/*  562 */       System.err.println("El72 " + e.getMessage());
/*  563 */       return false;
     } 
   }
   
   public List<Classes> getClasses() {
/*  568 */     this.s = this.sf.openSession();
/*  569 */     this.s.beginTransaction();
/*  570 */     Query query = this.s.getNamedQuery("Classes.findAll");
/*  571 */     List<Classes> sy = query.list();
/*  572 */     this.s.close();
/*  573 */     return sy;
   }
   
   public Classes getClassesByDesc(String desc) {
/*  577 */     this.s = this.sf.openSession();
/*  578 */     this.s.beginTransaction();
     
/*  580 */     Query query = this.s.getNamedQuery("Classes.findByClassDesc").setParameter("classDesc", desc);
/*  581 */     List<Classes> sy = query.list();
/*  582 */     this.s.close();
/*  583 */     return (Classes)sy.get(0);
   }
   
   public List<LectureDatetime> getLectures() {
/*  587 */     this.s = this.sf.openSession();
/*  588 */     this.s.beginTransaction();
/*  589 */     Query query = this.s.getNamedQuery("LectureDatetime.findAll");
/*  590 */     List<LectureDatetime> sy = query.list();
/*  591 */     this.s.close();
/*  592 */     return sy;
   }
   
   public void schedule() {
     try {
/*  597 */       FXMLLoader loader = new FXMLLoader();
/*  598 */       loader.setLocation(Main.class.getResource("/View/Schedule.fxml"));
/*  599 */       AnchorPane page = (AnchorPane)loader.load();
/*  600 */       dialogStage2 = new Stage();
/*  601 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*  602 */       dialogStage2.setTitle("جدول الحصص");
/*  603 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/*  604 */       dialogStage2.initOwner(this.MainApp.getPrimaryStage());
/*  605 */       Scene scene = new Scene(page);
/*  606 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/*  607 */       dialogStage2.setScene(scene);
/*  608 */       dialogStage2.showAndWait();
/*  609 */     } catch (IOException e) {
/*  610 */       e.printStackTrace();
     } 
   }
   
   public void PersistNewSchedule(Schedule sc) {
     try {
/*  616 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Deleted All Records of ";
/*  617 */       this.s = this.sf.openSession();
/*  618 */       Transaction t = this.s.beginTransaction();
/*  619 */       Query query = this.s.getNamedQuery("Schedule.DeleteByClassId").setParameter("cId", sc.getCId());
/*  620 */       log = log + " -- Schedule with Class ID " + sc.getCId();
/*  621 */       query.executeUpdate();
/*  622 */       this.s.persist(sc);
/*  623 */       log = log + " -- Created -- new Schedule with id " + sc.getScheduleId();
       
/*  625 */       this.ul = new UserLog();
/*  626 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  627 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  628 */       this.ul.setLogDESC(log);
/*  629 */       this.s.persist(this.ul);
/*  630 */       t.commit();
     }
/*  632 */     catch (Exception e) {
/*  633 */       System.err.println("ERROR IN HIBERNATE : " + e);
/*  634 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
     } 
   }
   
   public void FinalGrades() {
     try {
/*  640 */       FXMLLoader loader = new FXMLLoader();
/*  641 */       loader.setLocation(Main.class.getResource("/View/FinalGrades.fxml"));
/*  642 */       AnchorPane page = (AnchorPane)loader.load();
/*  643 */       dialogStage = new Stage();
/*  644 */       dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*  645 */       dialogStage.setTitle("الدرجات النهائية");
/*  646 */       dialogStage.initModality(Modality.WINDOW_MODAL);
/*  647 */       dialogStage.initOwner(this.MainApp.getPrimaryStage());
/*  648 */       Scene scene = new Scene(page);
/*  649 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/*  650 */       dialogStage.setScene(scene);
/*  651 */       dialogStage.showAndWait();
/*  652 */     } catch (IOException e) {
/*  653 */       e.printStackTrace();
     } 
   }
   
   public void PersistNewFinalGrade(FinalGrades sc) {
     try {
/*  659 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/*  660 */       this.s = this.sf.openSession();
/*  661 */       Transaction t = this.s.beginTransaction();
/*  662 */       this.s.persist(sc);
/*  663 */       log = log + " -- new Final Grade with id " + sc.getGId();
/*  664 */       GradesController.setFG(sc);
/*  665 */       this.ul = new UserLog();
/*  666 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  667 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  668 */       this.ul.setLogDESC(log);
/*  669 */       this.s.persist(this.ul);
/*  670 */       t.commit();
/*  671 */     } catch (Exception e) {
/*  672 */       System.err.println("ERROR IN HIBERNATE : " + e);
/*  673 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
     } 
   }
   
   public void UpdateFinalGrade(FinalGrades sc) {
     try {
/*  679 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- updated";
/*  680 */       this.s = this.sf.openSession();
/*  681 */       Transaction t = this.s.beginTransaction();
/*  682 */       this.s.update(sc);
/*  683 */       log = log + " --  Final Grade with id " + sc.getGId();
/*  684 */       GradesController.setFG(sc);
/*  685 */       this.ul = new UserLog();
/*  686 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  687 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  688 */       this.ul.setLogDESC(log);
/*  689 */       this.s.persist(this.ul);
/*  690 */       t.commit();
/*  691 */     } catch (Exception e) {
/*  692 */       System.err.println("ERROR IN HIBERNATE : " + e);
/*  693 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
     } 
   }
   
   public void PersistNewGradeDetail(GradeDetail sc) {
     try {
/*  699 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/*  700 */       this.s = this.sf.openSession();
/*  701 */       Transaction t = this.s.beginTransaction();
/*  702 */       this.s.persist(sc);
/*  703 */       log = log + " -- new Grade Detail with id " + sc.getGdId();
       
/*  705 */       this.ul = new UserLog();
/*  706 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  707 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  708 */       this.ul.setLogDESC(log);
/*  709 */       this.s.persist(this.ul);
/*  710 */       t.commit();
/*  711 */     } catch (Exception e) {
/*  712 */       System.err.println("ERROR IN HIBERNATE : " + e);
/*  713 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
     } 
   }
   
   public void UpdateGradeDetail(GradeDetail sc) {
     try {
/*  719 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
/*  720 */       this.s = this.sf.openSession();
/*  721 */       Transaction t = this.s.beginTransaction();
/*  722 */       this.s.update(sc);
/*  723 */       log = log + " --  Grade Detail with id " + sc.getGdId();
       
/*  725 */       this.ul = new UserLog();
/*  726 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  727 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  728 */       this.ul.setLogDESC(log);
/*  729 */       this.s.persist(this.ul);
/*  730 */       t.commit();
/*  731 */     } catch (Exception e) {
/*  732 */       System.err.println("ERROR IN HIBERNATE : " + e);
/*  733 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
     } 
   }
   
   public void RemoveGradeDetail(GradeDetail sc) {
     try {
/*  739 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Deleted";
/*  740 */       this.s = this.sf.openSession();
/*  741 */       Transaction t = this.s.beginTransaction();
/*  742 */       Query query = this.s.getNamedQuery("GradeDetail.deleteById").setParameter("gdId", sc.getGdId());
/*  743 */       log = log + " -- Grade Detail with id " + sc.getGdId();
/*  744 */       query.executeUpdate();
/*  745 */       this.ul = new UserLog();
/*  746 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  747 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  748 */       this.ul.setLogDESC(log);
/*  749 */       this.s.persist(this.ul);
/*  750 */       t.commit();
/*  751 */     } catch (Exception e) {
/*  752 */       System.err.println("ERROR IN HIBERNATE : " + e);
/*  753 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
     } 
   }
   
   public void ViewTeacher() {
     try {
/*  759 */       FXMLLoader loader = new FXMLLoader();
/*  760 */       loader.setLocation(Main.class.getResource("/View/ViewTeacher.fxml"));
/*  761 */       AnchorPane page = (AnchorPane)loader.load();
/*  762 */       dialogStage2 = new Stage();
/*  763 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*  764 */       dialogStage2.setTitle("عرض المدرس");
/*  765 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/*  766 */       dialogStage2.initOwner(getDialogStage());
/*  767 */       Scene scene = new Scene(page);
/*  768 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/*  769 */       dialogStage2.setScene(scene);
/*  770 */       dialogStage2.showAndWait();
     }
/*  772 */     catch (IOException e) {
/*  773 */       e.printStackTrace();
     } 
   }
 
   
   public void UpdateAbscenceStatus(EmployeeAttendance ea) {
     try {
/*  780 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
/*  781 */       this.s = this.sf.openSession();
/*  782 */       Transaction t = this.s.beginTransaction();
/*  783 */       this.s.update(ea);
/*  784 */       log = log + " -- Emp Attendece with id " + ea.getEaId();
/*  785 */       this.ul = new UserLog();
/*  786 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  787 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  788 */       this.ul.setLogDESC(log);
/*  789 */       this.s.persist(this.ul);
/*  790 */       t.commit();
/*  791 */     } catch (Exception e) {
/*  792 */       System.err.println("ERROR IN HIBERNATE : " + e);
/*  793 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
     } 
   }
   
   public void ViewEditAbscentStatus() {
     try {
/*  799 */       FXMLLoader loader = new FXMLLoader();
/*  800 */       loader.setLocation(Main.class.getResource("/View/EditTeacAbscentStatus.fxml"));
/*  801 */       AnchorPane page = (AnchorPane)loader.load();
/*  802 */       dialogStage2 = new Stage();
/*  803 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*  804 */       dialogStage2.setTitle("تعديل حالة الغياب");
/*  805 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/*  806 */       dialogStage2.initOwner(getDialogStage());
/*  807 */       Scene scene = new Scene(page);
/*  808 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/*  809 */       dialogStage2.setScene(scene);
/*  810 */       dialogStage2.showAndWait();
/*  811 */     } catch (IOException e) {
/*  812 */       e.printStackTrace();
     } 
   }
 
   
   public Payroll PersistNewNetSalary(String Notes, Persons su, Double Amount, String IssuedBy) {
     try {
/*  819 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/*  820 */       this.s = this.sf.openSession();
/*  821 */       Transaction t = this.s.beginTransaction();
/*  822 */       this.PR = new Payroll();
/*  823 */       this.PR.setAmount(Amount.doubleValue());
/*  824 */       this.PR.setPrStatus(true);
/*  825 */       this.PR.setPRNotes(Notes);
       
/*  827 */       this.PR.setPId(su);
/*  828 */       this.PR.setPrType("9");
       
/*  830 */       this.s.persist(this.PR);
/*  831 */       log = log + " -- new net salary Payroll with id " + this.PR.getPrId();
       
/*  833 */       this.ul = new UserLog();
/*  834 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  835 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  836 */       this.ul.setLogDESC(log);
/*  837 */       this.s.persist(this.ul);
/*  838 */       t.commit();
/*  839 */       this.s.refresh(this.PR);
       
/*  841 */       return this.PR;
/*  842 */     } catch (Exception e) {
/*  843 */       System.err.println("El72 " + e.getMessage());
                 throw e;
///*  844 */       return null;
     } 
   }
 
   
   public Payroll PersistNewDeductionsSalary(String Notes, Persons su, Double Amount) {
     try {
/*  851 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/*  852 */       this.s = this.sf.openSession();
/*  853 */       Transaction t = this.s.beginTransaction();
/*  854 */       this.PR = new Payroll();
/*  855 */       this.PR.setAmount(Amount.doubleValue());
/*  856 */       this.PR.setPrStatus(true);
/*  857 */       this.PR.setPRNotes(Notes);
       
/*  859 */       this.PR.setPId(su);
/*  860 */       this.PR.setPrType("8");
       
/*  862 */       this.s.persist(this.PR);
       
/*  864 */       log = log + " -- new Deductions Salary Payroll with id " + this.PR.getPrId();
       
/*  866 */       this.ul = new UserLog();
/*  867 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  868 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  869 */       this.ul.setLogDESC(log);
/*  870 */       this.s.persist(this.ul);
/*  871 */       t.commit();
/*  872 */       this.s.refresh(this.PR);
       
/*  874 */       return this.PR;
/*  875 */     } catch (Exception e) {
/*  876 */       System.err.println("El72 " + e.getMessage());
/*  877 */       throw e;
     } 
   }
 
   
   public Payroll PersistNewBonusSalary(String Notes, Persons su, Double Amount) {
     try {
/*  884 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/*  885 */       this.s = this.sf.openSession();
/*  886 */       Transaction t = this.s.beginTransaction();
/*  887 */       this.PR = new Payroll();
/*  888 */       this.PR.setAmount(Amount.doubleValue());
/*  889 */       this.PR.setPrStatus(true);
/*  890 */       this.PR.setPRNotes(Notes);
       
/*  892 */       this.PR.setPId(su);
/*  893 */       this.PR.setPrType("7");
       
/*  895 */       this.s.persist(this.PR);
/*  896 */       log = log + " -- new Bonus Salary Payroll with id " + this.PR.getPrId();
       
/*  898 */       this.ul = new UserLog();
/*  899 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  900 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  901 */       this.ul.setLogDESC(log);
/*  902 */       this.s.persist(this.ul);
/*  903 */       t.commit();
/*  904 */       this.s.refresh(this.PR);
/*  905 */       return this.PR;
/*  906 */     } catch (Exception e) {
/*  907 */       System.err.println("El72 " + e.getMessage());
/*  908 */       throw e;
     } 
   }
   
   public void UpdatePayroll(Payroll r) {
     try {
/*  914 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
/*  915 */       this.s = this.sf.openSession();
/*  916 */       Transaction t = this.s.beginTransaction();
/*  917 */       this.s.update(r);
/*  918 */       log = log + " -- Payroll with id " + r.getPrId();
       
/*  920 */       this.ul = new UserLog();
/*  921 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  922 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  923 */       this.ul.setLogDESC(log);
/*  924 */       this.s.persist(this.ul);
/*  925 */       t.commit();
/*  926 */     } catch (Exception e) {
/*  927 */       System.err.println("El72 " + e.getMessage());
     } 
   }
 
   
   public void PersistEval(Evaluation e) {
     try {
/*  934 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
/*  935 */       this.s = this.sf.openSession();
/*  936 */       Transaction t = this.s.beginTransaction();
       
/*  938 */       this.s.persist(e);
       
/*  940 */       log = log + " -- new Evaluation with id " + e.getEvaId();
/*  941 */       log = log + " -- for Person with id  " + e.getPid();
       
/*  943 */       this.ul = new UserLog();
/*  944 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  945 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  946 */       this.ul.setLogDESC(log);
/*  947 */       this.s.persist(this.ul);
/*  948 */       t.commit();
/*  949 */       EvaluationList.clear();
/*  950 */       setEvaluationList(getEvaluations());
     }
/*  952 */     catch (Exception ex) {
/*  953 */       System.err.println("El72 " + ex.getMessage());
     } 
   }
   
   public void EditEval(Evaluation e) {
     try {
/*  959 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
/*  960 */       this.s = this.sf.openSession();
/*  961 */       Transaction t = this.s.beginTransaction();
       
/*  963 */       this.s.update(e);
       
/*  965 */       log = log + " -- Evaluation with id " + e.getEvaId();
/*  966 */       log = log + " -- for Person with id  " + e.getPid();
       
/*  968 */       this.ul = new UserLog();
/*  969 */       this.ul.setUId(LoginSec.getLoggedUser());
/*  970 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/*  971 */       this.ul.setLogDESC(log);
/*  972 */       this.s.persist(this.ul);
/*  973 */       t.commit();
/*  974 */       EvaluationList.clear();
/*  975 */       setEvaluationList(getEvaluations());
     }
/*  977 */     catch (Exception ex) {
/*  978 */       System.err.println("El72 " + ex.getMessage());
     } 
   }
   
   public void ViewEditPenaltyStatus() {
     try {
/*  984 */       FXMLLoader loader = new FXMLLoader();
/*  985 */       loader.setLocation(Main.class.getResource("/View/EditTeacPayrollStatus.fxml"));
/*  986 */       AnchorPane page = (AnchorPane)loader.load();
/*  987 */       dialogStage2 = new Stage();
/*  988 */       dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
/*  989 */       dialogStage2.setTitle("تعديل الحالة");
/*  990 */       dialogStage2.initModality(Modality.WINDOW_MODAL);
/*  991 */       dialogStage2.initOwner(getDialogStage());
/*  992 */       Scene scene = new Scene(page);
/*  993 */       scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
/*  994 */       dialogStage2.setScene(scene);
/*  995 */       dialogStage2.showAndWait();
/*  996 */     } catch (IOException e) {
/*  997 */       e.printStackTrace();
     } 
   }
   
   public void UpdatePenaltyStatus() {
     try {
/* 1003 */       String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
/* 1004 */       this.s = this.sf.openSession();
/* 1005 */       Transaction t = this.s.beginTransaction();
/* 1006 */       this.s.update(editPayrollStatus);
/* 1007 */       log = log + " -- Payroll with id " + editPayrollStatus.getPrId();
/* 1008 */       this.ul = new UserLog();
/* 1009 */       this.ul.setUId(LoginSec.getLoggedUser());
/* 1010 */       this.ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 1011 */       this.ul.setLogDESC(log);
/* 1012 */       this.s.persist(this.ul);
/* 1013 */       t.commit();
/* 1014 */     } catch (Exception e) {
/* 1015 */       System.err.println("ERROR IN HIBERNATE : " + e);
/* 1016 */       System.err.println("ERROR IN HIBERNATE : " + e.getCause());
     } 
   }
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\amgad\h\TeachingStaff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */