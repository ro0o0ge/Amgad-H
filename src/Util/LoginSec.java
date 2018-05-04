/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Entity.UserLog;
import Entity.Users;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Alert;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Abdo
 */
public class LoginSec {

    public LoginSec() {
    }

    private static Users LoggedUser;
    SessionFactory sf;
    Session s;

    public static Users getLoggedUser() {
        return LoggedUser;
    }

    public String HandleLogin(String uName, String Pass) throws HibernateException {
        String status = "";
        sf = HibernateUtil.getSessionFactory();
        s = sf.openSession();
        Transaction t = s.beginTransaction();
        Query query = s.createQuery("from Users where U_NAME= :s and PASS= :p");
        query.setParameter("s", uName).setParameter("p", Pass);
        List<Users> users = query.list();
        UserLog ul = new UserLog();
        for (Iterator<Users> iterator = users.iterator(); iterator.hasNext();) {
            Users next = iterator.next();
            LoggedUser = next;
            status = LoggedUser.getStatus();
            ul.setUId(LoggedUser);
            ul.setLogDate(new Timestamp(new Date().getTime()));
            ul.setLogDESC("User : " + LoggedUser.getUName() + " -- Login");
            s.persist(ul);
            t.commit();
        }
        s.close();

        return status;
    }

    public void HandleLogout() throws Exception {
        UserLog ul = new UserLog();
        sf = HibernateUtil.getSessionFactory();
        s = sf.openSession();
        Transaction t = s.beginTransaction();
        ul.setUId(LoggedUser);
        ul.setLogDate(new Timestamp(new Date().getTime()));
        ul.setLogDESC("User : " + LoggedUser.getUName() + " -- logout");
        s.persist(ul);
        t.commit();
        s.close();
    }
}
