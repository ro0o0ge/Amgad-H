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
import Entity.Student;
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
//    private static Subjects TempS;
    UserLog ul;
    private List<TeacherSubjects> tss = new ArrayList<>();
    static Teacher edit;//Teacher TO BE EDITED
    

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

//    public static Subjects getTempS() {
//        return TempS;
//    }
//
//    public static void setTempS(Subjects TemS) {
//        TempS = TemS;
//    }
    
    

    public void setMainApp(root mainApp) {
        this.MainApp = mainApp;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }
    
    public static Stage getDialogStage2() {
        return dialogStage2;
    }
    
    public List<StudyYears> getStudyYears() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.createQuery("from StudyYears");
        List<StudyYears> sy = query.list();
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
    
    public Subjects getSubjectsByDesc(String desc,String YDesc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Subjects.findBySuDescAndSyId").
                setParameter("suDesc", desc).setParameter("syDesc", YDesc);
        List<Subjects> sy = query.list();
        s.close();
        return sy.get(0);
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
//                TeacherSubjects teSu = new TeacherSubjects();
//                teSu.setSuId(su);
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

}
