/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amgad.h;

import Controller.LoginController;
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
public class StudentAffair {

    private root MainApp;
    private static Stage dialogStage;
    private static Stage dialogStage2;
    private static Contacts C;
    UserLog ul;

    ObservableList<Contacts> ContactsList = FXCollections.observableArrayList();

    public ObservableList<Contacts> getContactsList() {
        return ContactsList;
    }

    public static Contacts getContacts() {
        return C;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    //bta3 el contacts fxml
    public static Stage getDialogStage2() {
        return dialogStage2;
    }

    public void setMainApp(root mainApp) {
        this.MainApp = mainApp;
    }
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s;

    public List<StudyYears> getSY() {
        s = sf.openSession();

        s.beginTransaction();
        Query query = s.createQuery("from StudyYears");
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
            for (Iterator<Contacts> iterator = ContactsList.iterator(); iterator.hasNext();) {
                Contacts c = iterator.next();
                s.persist(c);
                log += " -- new Contact with id " + c.getCId();
            }
            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
        } catch (Exception e) {
            System.err.println("ERROR IN HIBERNATE : " + e);
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
        C = new Contacts();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Contact.fxml"));
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

            ContactsList.add(C);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editStud() {
        try {

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    
}
