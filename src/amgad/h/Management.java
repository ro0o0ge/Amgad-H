/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amgad.h;

import Entity.Classes;
import Entity.Contacts;
import Entity.EmployeeAttendance;
import Entity.Persons;
import Entity.Staff;
import Entity.StaffClasses;
import Entity.UserLog;
import Util.HibernateUtil;
import Util.LoginSec;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
public class Management {

    private root MainApp;
    private static Stage dialogStage;
    private static Stage dialogStage2;
    private static Contacts C;
    UserLog ul;

    private static StaffClasses SC;

    private List<StaffClasses> tss = new ArrayList<>();

    static Staff edit;//staff TO BE EDITED

    EmployeeAttendance EA;

    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s;

    ObservableList<Contacts> ContactsList = FXCollections.observableArrayList();

    public ObservableList<Contacts> getContactsList() {
        return ContactsList;
    }

    ObservableList<Classes> SubjectsList = FXCollections.observableArrayList();

    public ObservableList<Classes> getSubjectsList() {
        return SubjectsList;
    }

    public static StaffClasses getSC() {
        return SC;
    }

    public static void setSC(StaffClasses SC) {
        Management.SC = SC;
    }

    public static void setC(Contacts con) {
        C = con;
    }

    public static Contacts getContacts() {
        return C;
    }

    public static Staff getEdit() {
        return edit;
    }

    public static void setEdit(Staff dit) {
        edit = dit;
    }

    public List<StaffClasses> getTss() {
        return tss;
    }

    static ObservableList<Staff> PersonsList = FXCollections.observableArrayList();

    public static ObservableList<Staff> getPersonsList() {
        return PersonsList;
    }

    public List<Staff> getTeachers() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Staff.findAll");
        List<Staff> sy = query.list();
        s.close();
        return sy;
    }

    public List<Staff> getActiveTeachers() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Staff.findByStatus").setParameter("status", "1");
        List<Staff> sy = query.list();
        s.close();
        return sy;
    }

    public static Stage getDialogStage() {
        return dialogStage;
    }

    public static Stage getDialogStage2() {
        return dialogStage2;
    }

    public List<Classes> getStudyYears() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.createQuery("from Classes");
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

    public void setMainApp(root mainApp) {
        this.MainApp = mainApp;
    }

    public void newEmp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/RegisterEmp.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("تسجيل الموظفين");
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

    public void PersistNewTeac(Persons p, Staff te) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.persist(p);
            log += " -- new Person with id " + p.getPId();
            s.persist(te);
            log += " -- new Staff with id " + te.getStId();

            for (Contacts c : ContactsList) {
                c.setPId(p);
                s.persist(c);
                log += " -- new Contact with id " + c.getCId();
            }

            for (StaffClasses su : tss) {
                su.setStId(te);
                s.persist(su);
                log += " -- new Staff Class with id " + su.getStcID();
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

    public void editEmp() {
        try {
            PersonsList.addAll(getTeachers());
            System.out.println("Prson List Size " + PersonsList.size());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/EditEmp.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("تعدبل الموظفين");
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
            loader.setLocation(Main.class.getResource("/View/EditEmpDetail.fxml"));
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

    public void UpdateTeacher(Staff st, List<Contacts> cons, List<Classes> subs) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(st);
            log += " --  Person with id " + st.getPId();
            log += " --  Staff with id " + st.getStId();

            for (Contacts c : cons) {
                c.setPId(st.getPId());
                s.saveOrUpdate(c);
                log += " -- Contact with id " + c.getCId();
            }

            Query query = s.getNamedQuery("StaffClasses.deleteByStID").setParameter("stId", st);
            query.executeUpdate();
            StaffClasses trss;
            for (Classes c : subs) {
                trss = new StaffClasses();
                trss.setStId(st);
                trss.setCId(c);
                s.persist(trss);
                log += " -- Staff Class with id " + c.getCId();
            }

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            s.update(st.getPId());
            t.commit();
            Management.dialogStage2.close();
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

    public void newCon() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/EmpContacts.fxml"));
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
            loader.setLocation(Main.class.getResource("/View/EmpClasses.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("الفصول");
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

    public void AbsentEmp() {
        try {
            PersonsList.addAll(getActiveTeachers());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Absent_Emp.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("تسجيل غياب الموظفين");
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

    public boolean PersistNewAbsent(String Notes, Staff su, Date dt, String Type,
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
            EA.setStId(su);
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
            } else if (Type.equals("عارضة")) {
                EA.setAbscenceType("3");
            } else if (Type.equals("مرضي")) {
                EA.setAbscenceType("4");
            } else if (Type.equals("سنوية")) {
                EA.setAbscenceType("5");
            } else {
                EA.setAbscenceType("6");
            }
            s.persist(EA);
            log += " -- new Employee Absence with id " + EA.getEaId();

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

}
