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
import Util.HibernateUtil;
import Util.LoginSec;
import java.io.IOException;
import java.sql.Timestamp;
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
public class StudentAffair {

    private root MainApp;
    private static Stage dialogStage;
    private static Stage dialogStage2;
    private static Contacts C;
    UserLog ul;
    
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s;

    static Student edit;//STUDENT TO BE EDITED

    ObservableList<Contacts> ContactsList = FXCollections.observableArrayList();

    public ObservableList<Contacts> getContactsList() {
        return ContactsList;
    }

    static ObservableList<Student> PersonsList = FXCollections.observableArrayList();

    public static ObservableList<Student> getPersonsList() {
        return PersonsList;
    }

    public static void setC(Contacts con) {
        C = con;
    }

    public static Contacts getContacts() {
        return C;
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
    
    public ClassStudents getClassStudent(Student st) {
        Query query = s.getNamedQuery("ClassStudents.findBysId").setParameter("sId", st);
        List<ClassStudents> sy = query.list();
        return sy.get(0);
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

    public void UpdateStud(Student st, ClassStudents cs,List<Contacts> cons) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(st);
            log += " --  Person with id " + st.getPId();
            log += " --  Student with id " + st.getSId();
            if (cs != null) {
                ClassStudents tempCS = getClassStudent(st);
                tempCS.setCId(cs.getCId());
                s.saveOrUpdate(tempCS);
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

}
