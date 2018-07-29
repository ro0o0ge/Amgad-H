/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amgad.h;

import Controller.GradesController;
import Entity.Classes;
import Entity.Contacts;
import Entity.EmployeeAttendance;
import Entity.FinalGrades;
import Entity.GradeDetail;
import Entity.LectureDatetime;
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

/**
 *
 * @author Abdo
 */
public class TeachingStaff {

    private root MainApp;
    private static Stage dialogStage;
    private static Stage dialogStage2;
    private static Contacts C;
    private static TeacherSubjects TS;
    UserLog ul;
    private List<TeacherSubjects> tss = new ArrayList<>();
    static Teacher edit;//Teacher TO BE EDITED

    static EmployeeAttendance editStatus;

    EmployeeAttendance EA;

    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s;

    ObservableList<Contacts> ContactsList = FXCollections.observableArrayList();

    public ObservableList<Contacts> getContactsList() {
        return ContactsList;
    }

    ObservableList<Subjects> SubjectsList = FXCollections.observableArrayList();

    public ObservableList<Subjects> getSubjectsList() {
        return SubjectsList;
    }

    public List<StudyYears> getSY() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("StudyYears.findAll");
        List<StudyYears> sy = query.list();
        s.close();
        return sy;
    }

    public List<TeacherSubjects> getTss() {
        return tss;
    }

    public static void setC(Contacts con) {
        C = con;
    }

    public static Contacts getContacts() {
        return C;
    }

    public static TeacherSubjects getS() {
        return TS;
    }

    public static void setS(TeacherSubjects Sub) {
        TS = Sub;
    }

    public void setMainApp(root mainApp) {
        this.MainApp = mainApp;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public static Stage getDialogStage2() {
        return dialogStage2;
    }

    public static Teacher getEdit() {
        return edit;
    }

    public static void setEdit(Teacher edit) {
        TeachingStaff.edit = edit;
    }

    public static EmployeeAttendance getEditStatus() {
        return editStatus;
    }

    public static void setEditStatus(EmployeeAttendance editStatus) {
        TeachingStaff.editStatus = editStatus;
    }

    static ObservableList<Teacher> PersonsList = FXCollections.observableArrayList();

    public static ObservableList<Teacher> getPersonsList() {
        return PersonsList;
    }

    public List<Schedule> getSchedulebyClassDesc(String YDesc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Schedule.findByClassDesc")
                .setParameter("classDesc", YDesc);
        List<Schedule> sy = query.list();
        s.close();
        return sy;
    }

    public List<StudyYears> getStudyYears() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.createQuery("from StudyYears");
        List<StudyYears> sy = query.list();
        s.close();
        return sy;
    }

    public List<Subjects> getSubjectsByStudyYearDesc(String YDesc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Subjects.findBySyDesc")
                .setParameter("syDesc", YDesc);
        List<Subjects> sy = query.list();
        s.close();
        return sy;
    }

    public StudyYears getStudyYearsByDesc(String desc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("StudyYears.findBySyDesc").setParameter("syDesc", desc);
        List<StudyYears> sy = query.list();
        s.close();
        return sy.get(0);
    }

    public List<Subjects> getStudyYearSubjects(StudyYears sty) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Subjects.findBySyId").setParameter("syId", sty);
        List<Subjects> sub = query.list();
        s.close();
        return sub;
    }

    static ObservableList<GradeDetail> GradeDetailList = FXCollections.observableArrayList();

    public static ObservableList<GradeDetail> getGradeDetailList() {
        return GradeDetailList;
    }

    public void LoadGradeDetails(String a, String b) {
        GradeDetailList = FXCollections.observableArrayList(getGradeDetails(getSubjectsByDescAndYDesc(a, b)));
    }

    public List<GradeDetail> getGradeDetails(Subjects fg) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("GradeDetail.findBySubjectId").setParameter("suId", fg);
        List<GradeDetail> sub = query.list();
        s.close();
        return sub;
    }

    public Subjects getSubjectsByDescAndYDesc(String desc, String YDesc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Subjects.findBySuDescAndSyId").
                setParameter("suDesc", desc).setParameter("syDesc", YDesc);
        List<Subjects> sy = query.list();
        s.close();
        return sy.get(0);
    }

    public String getFinalGrade(Subjects desc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("FinalGrades.findBysuId").
                setParameter("suId", desc);
        List<FinalGrades> sy = query.list();
        s.close();
        if (sy.size() < 1) {
            return "";
        }
        GradesController.setFG(sy.get(0));
        return String.valueOf(sy.get(0).getGrade());
    }

    public void PersistNewTeac(Persons p, Teacher te) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.persist(p);
            log += " -- new Person with id " + p.getPId();
            s.persist(te);
            log += " -- new Teacer with id " + te.getTId();

            for (Contacts c : ContactsList) {
                c.setPId(p);
                s.persist(c);
                log += " -- new Contact with id " + c.getCId();
            }

            for (TeacherSubjects su : tss) {
                su.setTId(te);
                s.persist(su);
                log += " -- new Teacher Subject with id " + su.getTSID();
            }

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            this.dialogStage.close();
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }

    public void UpdateTeacher(Teacher st, List<Contacts> cons, List<Subjects> subs) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(st);
            log += " --  Person with id " + st.getPId();
            log += " --  Teacher with id " + st.getTId();

            for (Contacts c : cons) {
                c.setPId(st.getPId());
                s.saveOrUpdate(c);
                log += " -- Contact with id " + c.getCId();
            }

            Query query = s.getNamedQuery("TeacherSubjects.deleteByTID").setParameter("tId", st);
            query.executeUpdate();
            TeacherSubjects trss;
            for (Subjects c : subs) {
                trss = new TeacherSubjects();
                trss.setSuId(c);
                trss.setTId(st);
                s.persist(trss);
                log += " -- Subject with id " + c.getSuId();
            }

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            s.update(st.getPId());
            t.commit();
            TeachingStaff.dialogStage2.close();
            PersonsList.clear();
            PersonsList.addAll(getTeachers());
            System.out.println("All Done");
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e.getLocalizedMessage());
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
            throw e;
        }

    }

    public void newTeacher() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/RegisterTeacher.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("تسجيل المدرسين");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.MainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage.setScene(scene);

            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newCon() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/TeacContact.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("جهات الاتصال");
            dialogStage2.initModality(Modality.WINDOW_MODAL);
            dialogStage2.initOwner(this.getDialogStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage2.setScene(scene);
            dialogStage2.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newSub() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/TeacSubjects.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("المواد");
            dialogStage2.initModality(Modality.WINDOW_MODAL);
            dialogStage2.initOwner(this.getDialogStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage2.setScene(scene);
            dialogStage2.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> getTeachers() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Teacher.findAll");
        List<Teacher> sy = query.list();
        s.close();
        return sy;
    }

    public String getTeacherNameByID(int id) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Teacher.findByTId").setParameter("tId", id);
        List<Teacher> sy = query.list();
        s.close();
        return sy.get(0).getPId().getName();
    }

    public Teacher getTeacherByName(String Name, String Desc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Teacher.findByName").setParameter("name", Name)
                .setParameter("classDesc", Desc);
        List<Teacher> sy = query.list();
        s.close();
        return sy.get(0);
    }

    public List<Teacher> getActiveTeachers() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Teacher.findByStatus").setParameter("status", "1");
        List<Teacher> sy = query.list();
        s.close();
        return sy;
    }

    public List<String> getClassTeachers(String Desc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Teacher.findByClassDesc").setParameter("classDesc", Desc);
        List<Teacher> sy = query.list();
        List<String> StudY = new ArrayList<String>();
        for (Iterator<Teacher> iterator = sy.iterator(); iterator.hasNext();) {
            StudY.add(iterator.next().getPId().getName());
        }
        s.close();
        return StudY;
    }

    public void editTeacher() {
        try {
            PersonsList.addAll(getTeachers());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/EditTeacher.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("تعدبل المدرسين");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.MainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
            PersonsList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editTeacherDetail() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/EditTeacherDetail.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("تعديل بيانات الطالب");
            dialogStage2.initModality(Modality.WINDOW_MODAL);
            dialogStage2.initOwner(this.getDialogStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage2.setScene(scene);
            dialogStage2.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbsentTeacher() {
        try {
            PersonsList.addAll(getActiveTeachers());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Absent_Teacher.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("تسجيل غياب المدرسين");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.MainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
            PersonsList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean PersistNewAbsent(String Notes, Teacher su, Date dt, String Type,
            String DurationType, String Duration) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            EA = new EmployeeAttendance();

            EA.setStatus(true);
            if (Notes.equals("")) {
                EA.setEaDesc(null);
            }
            EA.setEaDate(dt);
            EA.setTId(su);
            EA.setTimeAmount(Integer.parseInt(Duration));
            if (DurationType.equals("دقائق")) {
                EA.setTimeType("1");
            } else {
                EA.setTimeType("2");
            }

            if (Type.equals("تأخير")) {
                EA.setAbscenceType("1");
            } else if (Type.equals("استئذان")) {
                EA.setAbscenceType("2");
            } else if (Type.equals("منحة")) {
                EA.setAbscenceType("3");
            } else if (Type.equals("مرضي")) {
                EA.setAbscenceType("4");
            } else if (Type.equals("سنوية")) {
                EA.setAbscenceType("5");
            } else {
                EA.setAbscenceType("6");
            }
            s.persist(EA);
            log += " -- new Teacher Absence with id " + EA.getEaId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            PersonsList.clear();
            PersonsList.addAll(getActiveTeachers());
            return true;
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
            return false;
        }
    }

    public List<Classes> getClasses() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Classes.findAll");
        List<Classes> sy = query.list();
        s.close();
        return sy;
    }

    public Classes getClassesByDesc(String desc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Classes.findByClassDesc").
                setParameter("classDesc", desc);
        List<Classes> sy = query.list();
        s.close();
        return sy.get(0);
    }

    public List<LectureDatetime> getLectures() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("LectureDatetime.findAll");
        List<LectureDatetime> sy = query.list();
        s.close();
        return sy;
    }

    public void schedule() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Schedule.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("جدول الحصص");
            dialogStage2.initModality(Modality.WINDOW_MODAL);
            dialogStage2.initOwner(this.MainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage2.setScene(scene);
            dialogStage2.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PersistNewSchedule(Schedule sc) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Deleted All Records of ";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            Query query = s.getNamedQuery("Schedule.DeleteByClassId").setParameter("cId", sc.getCId());
            log += " -- Schedule with Class ID " + sc.getCId();
            query.executeUpdate();
            s.persist(sc);
            log += " -- Created -- new Schedule with id " + sc.getScheduleId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            TeachingStaff.dialogStage.close();
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }

    public void FinalGrades() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/FinalGrades.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("الدرجات النهائية");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.MainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PersistNewFinalGrade(FinalGrades sc) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.persist(sc);
            log += " -- new Final Grade with id " + sc.getGId();
            GradesController.setFG(sc);
            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }
    
    public void UpdateFinalGrade(FinalGrades sc) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(sc);
            log += " --  Final Grade with id " + sc.getGId();
            GradesController.setFG(sc);
            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }

    public void PersistNewGradeDetail(GradeDetail sc) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.persist(sc);
            log += " -- new Grade Detail with id " + sc.getGdId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }
    
    public void UpdateGradeDetail(GradeDetail sc) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(sc);
            log += " --  Grade Detail with id " + sc.getGdId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }

    public void RemoveGradeDetail(GradeDetail sc) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Deleted";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            Query query = s.getNamedQuery("GradeDetail.deleteById").setParameter("gdId", sc.getGdId());
            log += " -- Grade Detail with id " + sc.getGdId();
            query.executeUpdate();
            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }
    
    public void ViewTeacher() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/ViewTeacher.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("عرض المدرس");
            dialogStage2.initModality(Modality.WINDOW_MODAL);
            dialogStage2.initOwner(this.getDialogStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage2.setScene(scene);
            dialogStage2.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void UpdateAbscenceStatus(EmployeeAttendance ea) {
        try {
            
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(ea);
            log += " -- Emp Attendece with id " + ea.getEaId();
            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }

    public void ViewEditAbscentStatus() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/EditTeacAbscentStatus.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("تعديل حالة الغياب");
            dialogStage2.initModality(Modality.WINDOW_MODAL);
            dialogStage2.initOwner(this.getDialogStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage2.setScene(scene);
            dialogStage2.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
