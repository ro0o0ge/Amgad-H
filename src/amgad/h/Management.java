/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amgad.h;

import Entity.BoardDecisions;
import Entity.Classes;
import Entity.Contacts;
import Entity.EmployeeAttendance;
import Entity.Evaluation;
import Entity.Payroll;
import Entity.Persons;
import Entity.SchoolExpenses;
import Entity.Staff;
import Entity.StudyYears;
import Entity.Subjects;
import Entity.UserLog;
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
public class Management {

    private root MainApp;
    private static Stage dialogStage;
    private static Stage dialogStage2;
    private static Contacts C;
    UserLog ul;

    static Staff edit;//staff TO BE EDITED

    static EmployeeAttendance editStatus;
    
    static Payroll editPayrollStatus;

    EmployeeAttendance EA;

    Payroll PR;

    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s;

    ObservableList<Contacts> ContactsList = FXCollections.observableArrayList();

    public ObservableList<Contacts> getContactsList() {
        return ContactsList;
    }

    static ObservableList<BoardDecisions> BoardDecisionList = FXCollections.observableArrayList();

    public static ObservableList<BoardDecisions> getBoardDecisionList() {
        return BoardDecisionList;
    }

    static ObservableList<SchoolExpenses> SchoolExpensesList = FXCollections.observableArrayList();

    public static ObservableList<SchoolExpenses> getSchoolExpensesList() {
        return SchoolExpensesList;
    }

    public static void setC(Contacts con) {
        C = con;
    }

    public static Contacts getContacts() {
        return C;
    }

    public static EmployeeAttendance getEditStatus() {
        return editStatus;
    }

    public static void setEditStatus(EmployeeAttendance editStatus) {
        Management.editStatus = editStatus;
    }

    public static Staff getEdit() {
        return edit;
    }

    public static void setEdit(Staff dit) {
        edit = dit;
    }

    public static Payroll getEditPayrollStatus() {
        return editPayrollStatus;
    }

    public static void setEditPayrollStatus(Payroll editPayrollStatus) {
        Management.editPayrollStatus = editPayrollStatus;
    }
    
    static ObservableList<Staff> PersonsList = FXCollections.observableArrayList();

    public static ObservableList<Staff> getPersonsList() {
        return PersonsList;
    }

    static ObservableList<Persons> EmpList = FXCollections.observableArrayList();

    public static ObservableList<Persons> getEmpList() {
        return EmpList;
    }

    static ObservableList<Payroll> PayrollList = FXCollections.observableArrayList();

    public static ObservableList<Payroll> getPayrollList() {
        return PayrollList;
    }

    static ObservableList<Evaluation> EvaluationList = FXCollections.observableArrayList();

    public static ObservableList<Evaluation> getEvaluationList() {
        return EvaluationList;
    }

    public List<StudyYears> getSY() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("StudyYears.findAll");
        List<StudyYears> sy = query.list();
        s.close();
        return sy;
    }
    
    public List<Subjects> getSYSubjects(String SYDesc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Subjects.findBySyDesc").setParameter("syDesc", SYDesc);
        List<Subjects> sy = query.list();
        s.close();
        return sy;
    }
    
    public void setEvaluationList(List<Evaluation> EvaluationList) {
        this.EvaluationList = FXCollections.observableArrayList(EvaluationList);
    }

    public List<Evaluation> getEvaluations() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Evaluation.findByPId").setParameter("pId", edit.getPId());
        List<Evaluation> sy = query.list();
        s.close();
        return sy;
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

    public List<BoardDecisions> getBoardDecision() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("BoardDecisions.findAll");
        List<BoardDecisions> sy = query.list();
        s.close();
        return sy;
    }

    public List<SchoolExpenses> getSchoolExpenses() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("SchoolExpenses.findAll");
        List<SchoolExpenses> sy = query.list();
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

    public void UpdateTeacher(Staff st, List<Contacts> cons) {
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
            } else if (Type.equals("منحة")) {
                EA.setAbscenceType("3");
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

    public void BoardDecision() {
        try {
            BoardDecisionList.addAll(getBoardDecision());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/BoardDecision.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("قرارات الادارة");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.MainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
            BoardDecisionList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PersistDecision(BoardDecisions bd) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.persist(bd);
            log += " -- new Board Decision with id " + bd.getBdId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            BoardDecisionList.clear();
            BoardDecisionList.addAll(getBoardDecision());
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
        }
    }

    public void UpdateDecision(BoardDecisions bd) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(bd);
            log += " -- Board Decision with id " + bd.getBdId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            BoardDecisionList.clear();
            BoardDecisionList.addAll(getBoardDecision());
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
        }
    }

    public void newSchoolExpense() {
        try {
            SchoolExpensesList.addAll(getSchoolExpenses());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/SchoolExpenses.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("نثريات المدرسة");
            dialogStage2.initModality(Modality.WINDOW_MODAL);
            dialogStage2.initOwner(this.getDialogStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage2.setScene(scene);
            dialogStage2.showAndWait();
            SchoolExpensesList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PersistSchoolExpense(SchoolExpenses bd) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.persist(bd);
            log += " -- new School Expense with id " + bd.getSceId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            SchoolExpensesList.clear();
            SchoolExpensesList.addAll(getSchoolExpenses());
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
        }
    }

    public void UpdateSchoolExpense(SchoolExpenses bd) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(bd);
            log += " -- School Expenses with id " + bd.getSceId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            SchoolExpensesList.clear();
            SchoolExpensesList.addAll(getSchoolExpenses());
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
        }
    }

    public void ViewTeacher() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/ViewStaff.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("عرض الموظف");
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
            loader.setLocation(Main.class.getResource("/View/EditStaffAbscentStatus.fxml"));
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

    public List<Persons> getActiveEmp() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Persons.findforBonus");
        List<Persons> sy = query.list();
        query = s.getNamedQuery("Persons.findforBonus2");
        sy.addAll(query.list());
        s.close();
        return sy;
    }

    public List<Payroll> getPayrolls() {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Payroll.findAll");
        List<Payroll> sy = query.list();
        s.close();
        return sy;
    }

    public void bonus() {
        try {
            EmpList.addAll(getActiveEmp());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Bonus.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("المكافأت");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.MainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
            EmpList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean PersistNewBonus(String Notes, Persons su, Date dt, String Type,
            String Amount, boolean Recieved) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            PR = new Payroll();
            PR.setAmount(Double.parseDouble(Amount));
            PR.setPrStatus(true);
            PR.setPRNotes(Notes);
            PR.setPrDate(dt);
            PR.setPId(su);
            PR.setPrTypeBonus(Type);
            PR.setPrType("1"); // 1 for bonus 

            s.persist(PR);
            log += " -- new Bonus Payroll with id " + PR.getPrId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            EmpList.clear();
            EmpList.addAll(getActiveEmp());
            return true;
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
            return false;
        }
    }

    public void penalty() {
        try {
            EmpList.addAll(getActiveEmp());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Penalty.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("الجزاءات");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.MainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
            EmpList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean PersistNewPenalty(String Notes, Persons su, Date dt,
            String Amount, String IssuedBy) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            PR = new Payroll();
            PR.setAmount(Double.parseDouble(Amount));
            PR.setPrStatus(true);
            PR.setPRNotes(IssuedBy + " - " + Notes);
            
            PR.setPrDate(new Timestamp(dt.getTime()));
            PR.setPId(su);
            PR.setPrType("2"); // 2 for Penalty 

            s.persist(PR);
            log += " -- new Penalty Payroll with id " + PR.getPrId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            EmpList.clear();
            EmpList.addAll(getActiveEmp());
            return true;
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
            return false;
        }
    }

    public void ViewPayroll() {
        try {
            PayrollList.addAll(getPayrolls());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/ViewPayroll.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("المرتبات");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.MainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
            PayrollList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insurance() {
        try {
            EmpList.addAll(getActiveEmp());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Insurance.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("التأمينات");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.MainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
            EmpList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean PersistNewInsurance(String Notes, Persons su, Date dt,
            String Amount) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            PR = new Payroll();
            PR.setAmount(Double.parseDouble(Amount));
            PR.setPrStatus(true);
            PR.setPRNotes(Notes);
            PR.setPrDate(dt);
            PR.setPId(su);
            PR.setPrType("3"); // 3 for Insurance

            s.persist(PR);
            log += " -- new Insurance Payroll with id " + PR.getPrId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            EmpList.clear();
            EmpList.addAll(getActiveEmp());
            return true;
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
            return false;
        }
    }

    public Payroll PersistNewNetSalary(String Notes, Persons su,
            Double Amount, String IssuedBy) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            PR = new Payroll();
            PR.setAmount(Amount);
            PR.setPrStatus(true);
            PR.setPRNotes(Notes);
//            PR.setPrDate(dt);
            PR.setPId(su);
            PR.setPrType("9"); // 9 for net salary 

            s.persist(PR);
            log += " -- new net salary Payroll with id " + PR.getPrId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            s.refresh(PR);

            return PR;
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
            throw e;
        }
    }

    public Payroll PersistNewDeductionsSalary(String Notes, Persons su,
            Double Amount) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            PR = new Payroll();
            PR.setAmount(Amount);
            PR.setPrStatus(true);
            PR.setPRNotes(Notes);
//            PR.setPrDate(dt);
            PR.setPId(su);
            PR.setPrType("8"); // 9 for net salary 

            s.persist(PR);

            log += " -- new Deductions Salary Payroll with id " + PR.getPrId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            s.refresh(PR);

            return PR;
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
            throw e;
        }
    }

    public Payroll PersistNewBonusSalary(String Notes, Persons su,
            Double Amount) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            PR = new Payroll();
            PR.setAmount(Amount);
            PR.setPrStatus(true);
            PR.setPRNotes(Notes);
//            PR.setPrDate(dt);
            PR.setPId(su);
            PR.setPrType("7"); // 7  for bonus salary 

            s.persist(PR);
            log += " -- new Bonus Salary Payroll with id " + PR.getPrId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            s.refresh(PR);
            return PR;
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
            throw e;
        }
    }

    public void UpdatePayroll(Payroll r) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(r);
            log += " -- Payroll with id " + r.getPrId();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
        } catch (Exception e) {
            System.err.println("El72 " + e.getMessage());
        }

    }

    public void PersistEval(Evaluation e) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Created";
            s = sf.openSession();
            Transaction t = s.beginTransaction();

            s.persist(e);

            log += " -- new Evaluation with id " + e.getEvaId();
            log += " -- for Person with id  " + e.getPid();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            EvaluationList.clear();
            setEvaluationList(getEvaluations());

        } catch (Exception ex) {
            System.err.println("El72 " + ex.getMessage());
        }
    }

    public void EditEval(Evaluation e) {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();

            s.update(e);

            log += " -- Evaluation with id " + e.getEvaId();
            log += " -- for Person with id  " + e.getPid();

            ul = new UserLog();
            ul.setUId(LoginSec.getLoggedUser());
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC(log);
            s.persist(ul);
            t.commit();
            EvaluationList.clear();
            setEvaluationList(getEvaluations());

        } catch (Exception ex) {
            System.err.println("El72 " + ex.getMessage());
        }
    }
    
    public void ViewEditPenaltyStatus() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/EditEmpPayrollStatus.fxml"));
            AnchorPane page = loader.load();
            dialogStage2 = new Stage();
            dialogStage2.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage2.setTitle("تعديل الحالة");
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
    
    public void UpdatePenaltyStatus() {
        try {
            String log = "User : " + LoginSec.getLoggedUser().getUName() + " -- Updated";
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(editPayrollStatus);
            log += " -- Payroll with id " + editPayrollStatus.getPrId();
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

    public void ReportsMan() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/ManagementReport.fxml"));
            AnchorPane page = loader.load();
            dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("تقارير الادارة");
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
    
    public Integer getExpensebyDesc(String syDesc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.createSQLQuery("select id from school_expense_lkp where expense_desc = '"+syDesc+"'");
        List<Integer> x = query.list();
        s.close();
        return x.get(0);
    }
    
    public Integer getStudyYearbyDesc(String syDesc) {
        s = sf.openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("StudyYears.findBySyDesc1").setParameter("syDesc", syDesc);
        List<Integer> x = query.list();
        s.close();
        return x.get(0);
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
}
