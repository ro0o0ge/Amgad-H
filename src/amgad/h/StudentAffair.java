/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amgad.h;

import Entity.ClassStudents;
import Entity.Classes;
import Entity.Contacts;
import Entity.Persons;
import Entity.StudyYears;
import Entity.UserLog;
import Entity.Student;
import Entity.StudentAttendance;
import Entity.StudentExpenses;
import Entity.StudentNotes;
import Util.HibernateUtil;
import Util.LoginSec;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
public class StudentAffair {

    private root MainApp;
    private static Stage dialogStage;
    private static Stage dialogStage2;
    private static Contacts C;
    UserLog ul;

    StudentAttendance suA;

    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s;

    static Student edit;//STUDENT TO BE EDITED & TO BE VIEWED

    static StudentAttendance editStatus;

    ObservableList<Contacts> ContactsList = FXCollections.observableArrayList();

    public ObservableList<Contacts> getContactsList() {
        return ContactsList;
    }

    static ObservableList<Student> PersonsList = FXCollections.observableArrayList();

    public static ObservableList<Student> getPersonsList() {
        return PersonsList;
    }

    static ObservableList<ClassStudents> StudentsInClassList = FXCollections.observableArrayList();

    public static ObservableList<ClassStudents> getStudentsInClassList() {
        return StudentsInClassList;
    }

    static ObservableList<StudentNotes> StudentNotesList = FXCollections.observableArrayList();

    public static ObservableList<StudentNotes> getStudentNotesList() {
        return StudentNotesList;
    }

    static ObservableList<StudentExpenses> StudentExpensesList = FXCollections.observableArrayList();

    public static ObservableList<StudentExpenses> getStudentExpensesList() {
        return StudentExpensesList;
    }

    public static void setC(Contacts con) {
        C = con;
    }

    public static Contacts getContacts() {
        return C;
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

    public Stage getDialogStage() {
        return dialogStage;
    }

    //bta3 el contacts w el edit w ay 7aga tanya
    public static Stage getDialogStage2() {
        return dialogStage2;
    }

    public void setMainApp(root mainApp) {
        this.MainApp = mainApp;
    }

    public static void setEdit(Student edit) {
        StudentAffair.edit = edit;
    }

    public static Student getEdit() {
        return edit;
    }

    public static StudentAttendance getEditStatus() {
        return editStatus;
    }

    public static void setEditStatus(StudentAttendance editStatus) {
        StudentAffair.editStatus = editStatus;
    }

    public List<StudyYears> getSY() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("StudyYears.findAll");
        List<StudyYears> sy = query.list();
        s.close();
        return sy;
    }

    public List<Classes> getClasses() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.createQuery("from Classes");
        List<Classes> sy = query.list();
        s.close();
        return sy;
    }

    public List<ClassStudents> getClassStudent(Student st) {
        Query query = s.getNamedQuery("ClassStudents.findBysId").setParameter("sId", st);
        List<ClassStudents> sy = query.list();
        return sy;
    }

    public void LoadStudentsInClass(String a) {
        StudentsInClassList = FXCollections.observableArrayList(getStudInClass(a));
    }

    public List<ClassStudents> getStudInClass(String fg) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("ClassStudents.findByCDesc").setParameter("classDesc", fg);
        List<ClassStudents> sub = query.list();
        s.close();
        return sub;
    }

    public void PersistNewStud(Persons p, Student st, ClassStudents cs) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.persist(p);
            log += " -- new Person with id " + p.getPId();
            s.persist(st);
            log += " -- new Student with id " + st.getSId();
            if (cs != null) {
                s.persist(cs);
                log += " -- Register -- Student in a Class with id " + cs.getCsId();
            }
            for (Contacts c : ContactsList) {
                c.setPId(p);
                s.persist(c);
                log += " -- new Contact with id " + c.getCId();
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

    public void UpdateStud(Student st, ClassStudents cs, List<Contacts> cons) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(st);
            log += " --  Person with id " + st.getPId();
            log += " --  Student with id " + st.getSId();
            if (cs != null) {
                List<ClassStudents> tcs = getClassStudent(st);
                if (tcs.size() > 0) {
                    ClassStudents tempCS = tcs.get(0);
                    tempCS.setCId(cs.getCId());
                    s.saveOrUpdate(tempCS);
                } else {
                    s.persist(cs);
                }
                log += " -- Register -- Student in a Class with id " + cs.getCsId();
            }

            for (Contacts c : cons) {
                c.setPId(st.getPId());
                s.saveOrUpdate(c);
                log += " -- Contact with id " + c.getCId();
            }

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            s.update(st.getPId());
            t.commit();
            StudentAffair.dialogStage2.close();
            PersonsList.clear();
            PersonsList.addAll(getStudents());
            s.refresh(st);
            System.out.println("All Done");
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e.getLocalizedMessage());
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }

    public void newStud() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/RegisterStud.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("تسجيل الطلاب");
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
            loader.setLocation(Main.class.getResource("/View/StudContact.fxml"));
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

    public void editStud() {
        try {
            PersonsList.addAll(getStudents());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/EditStud.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("تعدبل الطلاب");
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

    public List<Student> getStudents() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Student.findAll");
        List<Student> sy = query.list();
        s.close();
        return sy;
    }

    public List<StudentExpenses> getStudentExpenses(Student st) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("StudentExpenses.findBySId").setParameter("sId", st);
        List<StudentExpenses> sy = query.list();
        s.close();
        return sy;
    }

    public List<Student> getActiveStudents() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Student.findByStatus").setParameter("status", "3");
        List<Student> sy = query.list();
        s.close();
        return sy;
    }

    public void editStudDetail() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/EditStudDetail.fxml"));
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

    public void editStudExpenses() {
        try {
            StudentExpensesList.addAll(getEdit().getStudentExpensesList());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/StudentExpenses.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("مصاريف المدرسة");
            dialogStage2.initModality(Modality.WINDOW_MODAL);
            dialogStage2.initOwner(this.getDialogStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage2.setScene(scene);
            dialogStage2.showAndWait();
            StudentExpensesList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StudNotes() {
        try {
            StudentNotesList.addAll(getEdit().getStudentNotesList());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/StudNotes.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("ملاحظات");
            dialogStage2.initModality(Modality.WINDOW_MODAL);
            dialogStage2.initOwner(this.getDialogStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage2.setScene(scene);
            dialogStage2.showAndWait();
            StudentNotesList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbsentStud() {
        try {
            PersonsList.addAll(getActiveStudents());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Absent_Stud.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("تسجيل غياب الطلاب");
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

    public boolean PersistNewAbsent(String Notes, Student su, Date dt) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            suA = new StudentAttendance();
            suA.setAbDesc(Notes);
            suA.setAbsentDay(dt);
            suA.setSId(su);
            suA.setStatus(true);
            suA.setEntryDate(java.sql.Date.valueOf(LocalDate.now()));
            s.persist(suA);
            log += " -- new Student Absence with id " + suA.getSAtId();
            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            PersonsList.clear();
            PersonsList.addAll(getActiveStudents());
            return true;
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
            return false;
        }
    }

    public void ClassStudents() {
        try {
            PersonsList.addAll(getStudents());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/ClassStudents.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("تسجيل قوائم الفصول");
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

    public void PersistNewClassStudent(ClassStudents sc) {
        try {
            PersonsList.clear();
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.persist(sc);
            log += " -- new Class Student with id " + sc.getCsId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            PersonsList.addAll(getStudents());
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("يوجد خطأ");
            alert.setHeaderText("الطالب المراد اضافته مسجل في فصل بالفعل");
            alert.setContentText("برجاء التأكد من اختياراتك");
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    public void RemoveClassStudent(ClassStudents sc) {
        try {
            PersonsList.clear();
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Deleted";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            Query query = s.getNamedQuery("ClassStudents.deleteBycsId").setParameter("csId", sc.getCsId());
            log += " -- Class Student with id " + sc.getCsId();
            query.executeUpdate();
            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            PersonsList.addAll(getStudents());
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }

    public void PersistNewStudentNote(StudentNotes sc) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.persist(sc);
            log += " -- new Student Note with id " + sc.getNId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            this.dialogStage2.close();
            PersonsList.clear();
            PersonsList.addAll(getStudents());
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("يوجد خطأ");
//            alert.setHeaderText("الطالب المراد اضافته مسجل في فصل بالفعل");
//            alert.setContentText("برجاء التأكد من اختياراتك");
//            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
//            alert.showAndWait();
        }
    }

    public void RemoveStudentNote(StudentNotes sc) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Deleted";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            Query query = s.getNamedQuery("StudentNotes.deleteByNId").setParameter("nId", sc.getNId());
            log += " -- Class Student with id " + sc.getNId();
            query.executeUpdate();
            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            PersonsList.clear();
            PersonsList.addAll(getStudents());
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
            System.err.println("ERROR IN HIBERNATE : " + e.getCause());
        }
    }

    public void PersistStudentExpense(StudentExpenses bd) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.persist(bd);
            log += " -- new Student Expense with id " + bd.getSteId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            StudentExpensesList.clear();
            StudentExpensesList = FXCollections.observableArrayList(getStudentExpenses(bd.getSId()));
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
        }
    }

    public void UpdateStudentExpense(StudentExpenses bd) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(bd);
            log += " -- Student Expenses with id " + bd.getSteId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            StudentExpensesList.clear();
            StudentExpensesList.addAll(getStudentExpenses(bd.getSId()));
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
        }
    }

    public void ViewStudent() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/ViewStud.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("عرض الطالب");
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

    public void UpdateAbscenceStatus(StudentAttendance ea) {
        try {

            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(ea);
            log += " -- Student Attendece with id " + ea.getSAtId();
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
            loader.setLocation(Main.class.getResource("/View/EditStudAbscentStatus.fxml"));
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
